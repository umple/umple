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
    AiStreamUtils?.abort?.(this.activeStream);
    this.activeStream = null;
  },

  checkApiConfig() {
    return AiConfigValidation.checkApiConfig({ requireVerified: true });
  },

  extractUmpleCode(response) {
    return AiTextUtils.extractUmpleCode(response);
  },

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
    const statusDiv = dialog?.querySelector("#statusMessage");
    const btnGenerate = dialog?.querySelector("#btnGenerate");
    const btnStop = dialog?.querySelector("#btnStop");
    const btnInsert = dialog?.querySelector("#btnInsert");
    const codeContainer = dialog?.querySelector("#generatedCodeContainer");
    const codeArea = dialog?.querySelector("#generatedCodeArea");
    const outputContainer = dialog?.querySelector("#requirementsOutputContainer");

    if (!statusDiv || !btnGenerate || !btnStop || !btnInsert || !codeContainer || !codeArea) {
      return;
    }

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
    RequirementsDialog.clearRequirementsOutput(dialog);
    RequirementsDialog.appendRequirementsOutput(`Generation type: ${genType}`, dialog);

    dialog.generationContext = { selectedReqs, genType, generation: null, umpleCode: "", chatContext: null };
    let tokenLimitTruncated = false;

    try {
      if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.preloadGuidance) {
        const guidanceType = genType === "classdiagram" ? "class diagrams" : "state machines";
        RequirementsDialog.appendRequirementsOutput(`Reading guidance on requirements and ${guidanceType}...`, dialog);
        await RequirementsPromptBuilder.preloadGuidance(genType);
      }

      const generation = RequirementsPromptBuilder.buildGeneration(selectedReqs, genType);
      const chatContext = AiChatContext.create(generation.systemPrompt);

      dialog.generationContext.generation = generation;
      dialog.generationContext.chatContext = chatContext;

      RequirementsDialog.setStatusMessage(statusDiv, "LLM", `Generating ${genType === "classdiagram" ? "class diagram" : "state machine"}...`);
      RequirementsDialog.appendRequirementsOutput(`Generating ${genType === "classdiagram" ? "class diagram" : "state machine"}...`, dialog);
      codeArea.value = "";
      codeContainer.style.display = "block";
      btnInsert.style.display = "none";
      const streamRenderer = AiStreamUtils.createBufferedTextRenderer({
        updateIntervalMs: 40,
        onRender: text => {
          codeArea.value = text;
          codeArea.scrollTop = codeArea.scrollHeight;
        }
      });
      AiChatContext.addUser(chatContext, generation.prompt);
      this.activeStream = AiApi.chatStream(chatContext, {}, {
        onDelta: (deltaText) => {
          streamRenderer.append(deltaText);
        },
        onTruncated: () => {
          tokenLimitTruncated = true;
        }
      });

      const response = await this.activeStream.done;
      this.activeStream = null;
      streamRenderer.flush({ force: true });
      if (response && response.trim()) {
        AiChatContext.addAssistant(chatContext, response);
      }
      RequirementsDialog.appendRequirementsOutput("Generated initial Umple block from AI.", dialog);

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

      dialog.generationContext.umpleCode = this.extractUmpleCode(responseText);
      let umpleCode = dialog.generationContext.umpleCode;

      if (!dialog.stopped) {
        RequirementsDialog.setStatusMessage(statusDiv, "Compiler", "Running self-correction (compiler + validation)...");
        RequirementsDialog.appendRequirementsOutput("Running self-correction (compiler + validation)...", dialog);
        codeArea.value = "";
        codeArea.placeholder = "Self-correction in progress...";
        const originalEditorCode = Page.codeMirrorEditor6?.state.doc.toString() || "";
          try {
            const corrected = await RequirementsSelfCorrection.run({
              originalCode: originalEditorCode,
              generatedResponse: responseText,
              requirements: selectedReqs,
              generationType: genType,
              chatContext,
              expectedRequirementIds: generation.expectedRequirementIds,
              log: line => RequirementsDialog.appendRequirementsOutput(line, dialog),
              setStatus: (label, message, color) => RequirementsDialog.setStatusMessage(statusDiv, label, message, color),
              shouldStop: () => !!dialog.stopped,
              setActiveStream: handle => {
                this.activeStream = handle;
              },
              onRepairTextReset: placeholder => {
                codeArea.value = "";
                codeArea.placeholder = placeholder || "";
              },
              onRepairTextUpdate: text => {
                codeArea.value = text;
                codeArea.scrollTop = codeArea.scrollHeight;
              }
            });
            if (corrected && typeof corrected.block === "string" && corrected.block.trim()) {
              umpleCode = corrected.block.trim();
              dialog.generationContext.umpleCode = umpleCode;
            }
        } catch (e) {
          RequirementsDialog.appendRequirementsOutput(`Self-correction failed: ${e.message}`, dialog);
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
        RequirementsDialog.appendRequirementsOutput("\nGeneration stopped by user.", dialog);
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
    const statusDiv = dialog?.querySelector("#statusMessage");
    const btnGenerate = dialog?.querySelector("#btnGenerate");
    const btnStop = dialog?.querySelector("#btnStop");
    const btnInsert = dialog?.querySelector("#btnInsert");
    const codeContainer = dialog?.querySelector("#generatedCodeContainer");
    const codeArea = dialog?.querySelector("#generatedCodeArea");

    if (!statusDiv || !btnGenerate || !btnStop || !btnInsert || !codeContainer || !codeArea) {
      return;
    }

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
      const streamedText = codeArea?.value || "";

      if (!umpleCode.trim() && streamedText.trim()) {
        const extracted = this.extractUmpleCode(streamedText);
        umpleCode = extracted && extracted.trim() ? extracted : streamedText;
      }

      if (umpleCode.trim()) {
        RequirementsDialog.appendRequirementsOutput("Applying partial generated code...", dialog);
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
    const codeArea = dialog?.querySelector("#generatedCodeArea");
    const code = codeArea?.value;
    if (code) {
      if (!Page.codeMirrorEditor6) {
        alert("Editor not initialized");
        return;
      }

      const genType = dialog?.querySelector('input[name="genType"]:checked')?.value || "statemachine";
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

      // Switch diagram view to match what was generated.
      if (typeof Action !== "undefined" && typeof Action.changeDiagramType === "function") {
        if (genType === "statemachine") {
          Action.changeDiagramType({ type: "GvState" });
        } else if (genType === "classdiagram") {
          Action.changeDiagramType({ type: "GvClass" });
        }
      }

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


