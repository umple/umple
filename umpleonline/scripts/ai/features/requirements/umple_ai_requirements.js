// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Generator for UmpleOnline
// Generates Umple code (state machines, class diagrams) from requirements using LLMs

const AiRequirements = {
  activeStream: null,

  parseRequirements(umpleCode) {
    const requirements = [];
    const reqPattern = /req\s+(\w+(?:[-_]\w+)*)\s*\{([^}]*)\}/gs;
    let match;

    while ((match = reqPattern.exec(umpleCode)) !== null) {
      const id = match[1].trim();
      const text = match[2].trim();
      if (id && text) {
        requirements.push({ id, text });
      }
    }

    return requirements;
  },

  abortActiveStream() {
    try {
      this.activeStream?.abort?.();
    } catch (e) {
    } finally {
      this.activeStream = null;
    }
  },

  checkApiConfig() {
    return AiConfigValidation.checkApiConfig({ requireVerified: false });
  },

  buildPrompt(requirements, generationType) {
    if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.buildGeneration) {
      return RequirementsPromptBuilder.buildGeneration(requirements, generationType).prompt;
    }

    const requirementTexts = requirements.map(req => `Requirement ${req.id}:\n${req.text}`).join("\n\n");

    if (typeof AiPromptUtils !== "undefined" && AiPromptUtils.block && AiPromptUtils.joinBlocks) {
      return AiPromptUtils.joinBlocks([
        AiPromptUtils.block("task", "Generate ONLY Umple code based on the following requirement(s)."),
        AiPromptUtils.block("requirements", requirementTexts, { allowEmpty: true }),
        AiPromptUtils.block("output_contract", [
          "- Output ONLY Umple code.",
          "- Output EXACTLY ONE fenced code block with language \"umple\":",
          "  ```umple",
          "  ...",
          "  ```",
          "- No prose before or after the code block."
        ].join("\n"))
      ]);
    }

    return `Generate ONLY Umple code based on the following requirement(s).\n\nRequirements:\n${requirementTexts}\n\nUmple code:`;
  },

  extractUmpleCode(response) {
    return AiTextUtils.extractUmpleCode(response);
  },

  SYSTEM_PROMPT: (() => {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple modeling language.";

    const directive = "Your job is to generate ONLY valid Umple code.";
    if (typeof AiPromptUtils !== "undefined" && AiPromptUtils.block && AiPromptUtils.joinBlocks) {
      return AiPromptUtils.joinBlocks([
        AiPromptUtils.block("system", base, { allowEmpty: true }),
        AiPromptUtils.block("directive", directive)
      ]);
    }

    return `${base}\n\n${directive}`;
  })(),

  showDialog() {
    const umpleCode = Page.codeMirrorEditor6?.state.doc.toString() || "";
    const requirements = this.parseRequirements(umpleCode);

    if (requirements.length === 0) {
      alert("No requirements found in your Umple code.\n\nSee https://cruise.umple.org/umple/Requirements.html for more information.");
      return;
    }

    const apiConfig = this.checkApiConfig();
    if (!apiConfig.configured) {
      if (typeof AiSettings !== "undefined" && AiSettings.showSettingsModal) {
        AiSettings.showSettingsModal();
      }
      alert(apiConfig.message);
      return;
    }

    const dialog = RequirementsDialog.createDialog(requirements);
    RequirementsDialog.setupDialogEvents(dialog, requirements, {
      onGenerate: () => this.handleGenerate(dialog, requirements),
      onStop: () => this.handleStop(dialog),
      onInsert: () => this.handleInsert(dialog),
      onCancel: () => {
        this.abortActiveStream();
        dialog.remove();
      }
    });
  },

  async handleGenerate(dialog, requirements) {
    const statusDiv = document.getElementById("statusMessage");
    const btnGenerate = document.getElementById("btnGenerate");
    const btnStop = document.getElementById("btnStop");
    const btnInsert = document.getElementById("btnInsert");
    const codeContainer = document.getElementById("generatedCodeContainer");
    const codeArea = document.getElementById("generatedCodeArea");
    const outputContainer = document.getElementById("requirementsOutputContainer");

    const selectedReqs = RequirementsDialog.getSelectedRequirements(dialog, requirements);

    if (selectedReqs.length === 0) {
      RequirementsDialog.setStatusMessage(statusDiv, "Error", "Please select at least one requirement", "#DD0033");
      return;
    }

    const genType = dialog.querySelector('input[name="genType"]:checked')?.value || "statemachine";
    const apiConfig = this.checkApiConfig();

    if (!apiConfig.configured) {
      RequirementsDialog.setStatusMessage(statusDiv, "Error", apiConfig.message, "#DD0033");
      return;
    }

    btnGenerate.classList.add("disabled");
    btnGenerate.textContent = "Generating...";
    btnStop.style.display = "inline-block";
    RequirementsDialog.setStatusMessage(statusDiv, "LLM", "Generating Umple code from requirements...");

    if (outputContainer) outputContainer.style.display = "block";
    RequirementsDialog.clearRequirementsOutput();
    RequirementsDialog.appendRequirementsOutput(`Generation type: ${genType}`);

    dialog.generationContext = { selectedReqs, genType, generation: null, umpleCode: "" };
    let tokenLimitTruncated = false;

    try {
      if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.preloadGuidance) {
        const guidanceType = genType === "classdiagram" ? "class diagrams" : "state machines";
        RequirementsDialog.appendRequirementsOutput(`Reading guidance on requirements and ${guidanceType}...`);
        await RequirementsPromptBuilder.preloadGuidance(genType);
      }

      const generation = (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.buildGeneration)
        ? RequirementsPromptBuilder.buildGeneration(selectedReqs, genType)
        : { prompt: this.buildPrompt(selectedReqs, genType), systemPrompt: this.SYSTEM_PROMPT, expectedRequirementIds: selectedReqs.map(r => r.id) };

      dialog.generationContext.generation = generation;

      RequirementsDialog.setStatusMessage(statusDiv, "LLM", `Generating ${genType === "classdiagram" ? "class diagram" : "state machine"}...`);
      RequirementsDialog.appendRequirementsOutput(`Generating ${genType === "classdiagram" ? "class diagram" : "state machine"}...`);
      let streamedText = "";
      codeArea.value = "";
      codeContainer.style.display = "block";
      btnInsert.style.display = "none";
      this.activeStream = AiApi.chatStream(generation.prompt, generation.systemPrompt, {}, {
        onDelta: (deltaText) => {
          streamedText += deltaText;
          codeArea.value = streamedText;
          codeArea.scrollTop = codeArea.scrollHeight;
        },
        onTruncated: () => {
          tokenLimitTruncated = true;
        }
      });

      const response = await this.activeStream.done;
      this.activeStream = null;
      RequirementsDialog.appendRequirementsOutput("Generated initial Umple block from AI.");

      if (tokenLimitTruncated) {
        dialog.stopped = true;
        RequirementsDialog.setStatusMessage(
          statusDiv,
          "LLM",
          "Generation stopped: AI output was truncated due to token limit. Try selecting fewer requirements, shortening requirement text, or using a larger model.",
          "#DD0033"
        );
        codeArea.value = response || "";
        codeContainer.style.display = "block";
        btnInsert.style.display = response && response.trim() ? "inline-block" : "none";
        return;
      }

      let responseText = response || "";
      if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.validateResponseFormat) {
        const formatErrors = RequirementsPromptBuilder.validateResponseFormat(responseText);
        if (formatErrors.length > 0 && !dialog.stopped) {
          RequirementsDialog.appendRequirementsOutput(`Output contract violations: ${formatErrors.join("; ")}`);
          RequirementsDialog.setStatusMessage(statusDiv, "LLM", "Repairing output format...");
          RequirementsDialog.appendRequirementsOutput("Attempting format-only repair...");
          codeArea.value = "";
          codeArea.placeholder = "Repairing output format...";
          codeContainer.style.display = "block";

          const originalEditorCode = Page.codeMirrorEditor6?.state.doc.toString() || "";
          const invalidBlock = this.extractUmpleCode(responseText);
          const compilerIssuesText = formatErrors.map(err => `- Validation Error: ${err}`).join("\n");

          const repairResult = (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.repair_buildGeneration)
            ? RequirementsPromptBuilder.repair_buildGeneration({
              generationType: genType,
              requirements: selectedReqs,
              originalCode: originalEditorCode,
              invalidBlock,
              compilerIssuesText
            })
            : {
              prompt: `Fix the output format: ${compilerIssuesText}\n\nOutput ONLY a single \`\`\`umple\`\`\` code block with valid Umple code.`,
              systemPrompt: generation.systemPrompt
            };

          let repairedText = "";
          this.activeStream = AiApi.chatStream(repairResult.prompt, repairResult.systemPrompt, {}, {
            onDelta: (deltaText) => {
              repairedText += deltaText;
              codeArea.value = repairedText;
              codeArea.scrollTop = codeArea.scrollHeight;
            }
          });

          responseText = await this.activeStream.done;
          this.activeStream = null;
          RequirementsDialog.appendRequirementsOutput("Output format repair completed.");

          const remainingErrors = RequirementsPromptBuilder.validateResponseFormat(responseText);
          if (remainingErrors.length > 0) {
            RequirementsDialog.appendRequirementsOutput(`Output contract still violated: ${remainingErrors.join("; ")}`);
          }
        }
      }

      dialog.generationContext.umpleCode = this.extractUmpleCode(responseText);
      let umpleCode = dialog.generationContext.umpleCode;

      if (!dialog.stopped) {
        RequirementsDialog.setStatusMessage(statusDiv, "Compiler", "Running self-correction (compiler + validation)...");
        RequirementsDialog.appendRequirementsOutput("Running self-correction (compiler + validation)...");
        codeArea.value = "";
        codeArea.placeholder = "Self-correction in progress...";
        const originalEditorCode = Page.codeMirrorEditor6?.state.doc.toString() || "";
        try {
          const corrected = await RequirementsSelfCorrection.run({
            originalCode: originalEditorCode,
            generatedBlock: umpleCode,
            requirements: selectedReqs,
            generationType: genType,
            systemPrompt: generation.systemPrompt,
            dialog,
            statusDiv,
            expectedRequirementIds: generation.expectedRequirementIds
          });
          if (corrected && typeof corrected.block === "string" && corrected.block.trim()) {
            umpleCode = corrected.block.trim();
            dialog.generationContext.umpleCode = umpleCode;
          }
        } catch (e) {
          RequirementsDialog.appendRequirementsOutput(`Self-correction failed: ${e.message}`);
        }
      }

      codeArea.placeholder = "";
      codeArea.value = umpleCode;
      codeContainer.style.display = "block";
      btnInsert.style.display = "inline-block";

      if (statusDiv.style.color !== "#DD0033") {
        const successMsg = dialog.stopped
          ? "Generation stopped. Partial code generated! Review and click 'Insert to Editor' to add it to your model."
          : "Code generated successfully! Review and click 'Insert to Editor' to add it to your model.";
        RequirementsDialog.setStatusMessage(statusDiv, "LLM", successMsg);
      }
    } catch (error) {
      if (error?.name === "AbortError") {
        RequirementsDialog.appendRequirementsOutput("\nGeneration stopped by user.");
        return;
      }
      console.error("Error generating code:", error);
      RequirementsDialog.setStatusMessage(statusDiv, "Error", `Error: ${error.message}`, "#DD0033");
    } finally {
      btnGenerate.classList.remove("disabled");
      btnGenerate.textContent = "Generate";
      btnStop.style.display = "none";
      dialog.stopped = false;
      dialog.generationContext = null;
    }
  },

  async handleStop(dialog) {
    const statusDiv = document.getElementById("statusMessage");
    const btnGenerate = document.getElementById("btnGenerate");
    const btnStop = document.getElementById("btnStop");
    const btnInsert = document.getElementById("btnInsert");
    const codeContainer = document.getElementById("generatedCodeContainer");
    const codeArea = document.getElementById("generatedCodeArea");

    dialog.stopped = true;
    this.abortActiveStream();

    RequirementsDialog.setStatusMessage(statusDiv, "LLM", "Stopping generation...");

    try {
      const context = dialog.generationContext;
      if (!context) {
        RequirementsDialog.setStatusMessage(statusDiv, "LLM", "No generation in progress.", "#DD0033");
        return;
      }

      let umpleCode = context.umpleCode || "";

      if (umpleCode.trim()) {
        RequirementsDialog.appendRequirementsOutput("Applying partial generated code...");
        codeArea.value = umpleCode;
        codeContainer.style.display = "block";
        btnInsert.style.display = "inline-block";
        RequirementsDialog.setStatusMessage(
          statusDiv,
          "LLM",
          "Generation stopped. Partial code generated! Review and click 'Insert to Editor' to add it to your model."
        );
      } else {
        RequirementsDialog.setStatusMessage(statusDiv, "LLM", "Generation stopped before any code was generated.", "#DD0033");
      }
    } catch (error) {
      console.error("Error stopping generation:", error);
      RequirementsDialog.setStatusMessage(statusDiv, "Error", `Error stopping: ${error.message}`, "#DD0033");
    } finally {
      btnGenerate.classList.remove("disabled");
      btnGenerate.textContent = "Generate";
      btnStop.style.display = "none";
      dialog.generationContext = null;
    }
  },

  handleInsert(dialog) {
    const codeArea = document.getElementById("generatedCodeArea");
    const code = codeArea.value;
    if (code) {
      if (!Page.codeMirrorEditor6) {
        alert("Editor not initialized");
        return;
      }
      const currentDoc = Page.codeMirrorEditor6.state.doc.toString();
      const insertion = RequirementsSelfCorrection.buildMergedCode(currentDoc, code);
      const highlightDurationMs = 3000;

      Page.codeMirrorEditor6.dispatch({
        changes: { from: insertion.insertPos, to: insertion.insertPos, insert: insertion.insertText },
        selection: insertion.highlightTo > insertion.highlightFrom
          ? { anchor: insertion.highlightFrom, head: insertion.highlightTo }
          : { anchor: insertion.insertPos + insertion.insertText.length },
        scrollIntoView: true
      });

      Page.codeMirrorEditor6.focus();
      const newCode = Page.codeMirrorEditor6.state.doc.toString();
      TabControl.getCurrentHistory().save(newCode, "aiGeneration");

      setTimeout(() => {
        const view = Page.codeMirrorEditor6;
        if (!view) return;
        const selection = view.state.selection.main;
        if (selection.from === insertion.highlightFrom && selection.to === insertion.highlightTo) {
          view.dispatch({ selection: { anchor: insertion.highlightFrom } });
        }
      }, highlightDurationMs);
      dialog.remove();
    }
  }
};

if (typeof Page !== "undefined") {
}
