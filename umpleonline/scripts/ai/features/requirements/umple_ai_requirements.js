// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Generator for UmpleOnline
// Generates Umple code (state machines, class diagrams) from requirements using LLMs

const AiRequirements = {
  activeStream: null,

  // Only active reqs are returned; commented-out ones are ignored (issue #2541).
  // implemented: an active implementsReq already names the requirement (issue #2485).
  parseRequirements(umpleCode) {
    const { blocks, implementedIds } = AiTextUtils.scanRequirements(umpleCode);
    return blocks
      .filter(block => block.id && block.text)
      .map(({ id, text }) => ({ id, text, implemented: implementedIds.has(id) }));
  },

  // The model part of the editor text, before UmpleOnline's layout section
  getModelEnd(docText) {
    const delimiter = (typeof Page !== "undefined" && Page.modelDelimiter) ? Page.modelDelimiter : null;
    const index = delimiter ? docText.indexOf(delimiter) : -1;
    return index >= 0 ? index : docText.length;
  },

  replaceEditorText(from, to, text) {
    const editor = Page.codeMirrorEditor6;
    editor.dispatch({ changes: { from, to, insert: text } });
    TabControl.getCurrentHistory().save(editor.state.doc.toString(), "aiGeneration");
  },

  formatRequirementBlock(requirement) {
    return `req ${requirement.id} {\n  ${requirement.text}\n}`;
  },

  // Replaces only the part of the editor text that differs, so the rest of the editor is kept
  setEditorText(text) {
    const docText = Page.codeMirrorEditor6.state.doc.toString();
    if (docText === text) return;
    let from = 0;
    while (from < docText.length && from < text.length && docText[from] === text[from]) from++;
    let end = 0;
    while (end < docText.length - from && end < text.length - from
      && docText[docText.length - 1 - end] === text[text.length - 1 - end]) {
      end++;
    }
    this.replaceEditorText(from, docText.length - end, text.slice(from, text.length - end));
  },

  // The text with the requirement of "New" or "Modify": the req block with its ID gets the new wording,
  // or "New" adds it at the top of the model; null if "Modify" can no longer find it (issue #2485)
  withRequirementEdit(docText, action) {
    const block = AiTextUtils.findRequirementBlocks(docText.slice(0, this.getModelEnd(docText)))
      .find(b => b.id === action.requirement.id);
    const reqBlock = this.formatRequirementBlock(action.requirement);
    if (block) return docText.slice(0, block.start) + reqBlock + docText.slice(block.end);
    return action.mode === "new" ? `${reqBlock}\n\n${docText}` : null;
  },

  // New and Modify change the editor before generating. Each Generate starts again from the text the
  // editor had before, so a requirement is never added twice, and Cancel can put that text back
  applyRequirementEdit(dialog, action) {
    const docText = Page.codeMirrorEditor6.state.doc.toString();
    const before = dialog.editorBefore !== undefined && docText === dialog.editorAfter ? dialog.editorBefore : docText;
    const edited = this.withRequirementEdit(before, action);
    if (edited === null) return false;
    this.setEditorText(edited);
    dialog.editorBefore = before;
    dialog.editorAfter = edited;
    return true;
  },

  // Puts back the editor text from before New or Modify, unless the editor was changed since
  undoRequirementEdit(dialog) {
    if (dialog.editorBefore !== undefined && Page.codeMirrorEditor6?.state.doc.toString() === dialog.editorAfter) {
      this.setEditorText(dialog.editorBefore);
    }
    dialog.editorBefore = undefined;
    dialog.editorAfter = undefined;
  },

  // An unfinished updated model must never replace the user's model (issue #2485)
  showReplaceStopped(dialog, reason) {
    const btnInsert = dialog.querySelector("#btnInsert");
    if (btnInsert) btnInsert.style.display = "none";
    RequirementsDialog.hideModelChanges(dialog);
    RequirementsDialog.setStatusMessage(dialog.querySelector("#statusMessage"), "LLM",
      `${reason} Your model was not changed; click Generate to try again.`, "#DD0033");
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
        // Nothing was inserted: the editor gets back its text from before New or Modify (issue #2485)
        this.undoRequirementEdit(dialog);
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

    const action = RequirementsDialog.getRequestedAction(dialog, requirements);
    const actionError = RequirementsDialog.validateRequestedAction(action, requirements);

    if (actionError) {
      RequirementsDialog.setStatusMessage(statusDiv, "Error", actionError, "#DD0033");
      return;
    }

    const genType = dialog.querySelector('input[name="genType"]:checked')?.value || "statemachine";
    const apiConfig = this.checkApiConfig();

    if (!apiConfig.configured) {
      RequirementsDialog.setStatusMessage(statusDiv, "Error", apiConfig.message, "#DD0033");
      return;
    }

    // New and Modify change the req blocks in the editor first; other requests undo that change (issue #2485)
    let selectedReqs = action.requirements;
    let mode = "insert";
    if (action.mode === "new" || action.mode === "modify") {
      if (!this.applyRequirementEdit(dialog, action)) {
        RequirementsDialog.setStatusMessage(statusDiv, "Error", `Requirement ${action.requirement.id} is no longer in the editor`, "#DD0033");
        return;
      }
      selectedReqs = [action.requirement];
      if (action.mode === "modify") mode = action.previous?.implemented ? "replace" : "insert";
    } else {
      this.undoRequirementEdit(dialog);
    }

    const editorText = Page.codeMirrorEditor6?.state.doc.toString() || "";
    const modelText = editorText.slice(0, this.getModelEnd(editorText));
    const options = { ...RequirementsDialog.getGenerationOptions(dialog), modelText };
    dialog.insertMode = mode;
    RequirementsDialog.hideModelChanges(dialog);

    btnGenerate.classList.add("disabled");
    btnGenerate.textContent = "Generating...";
    btnStop.style.display = "inline-block";
    RequirementsDialog.setStatusMessage(statusDiv, "LLM", "Generating Umple code from requirements...");

    if (outputContainer) outputContainer.style.display = "block";
    RequirementsDialog.clearRequirementsOutput(dialog);
    RequirementsDialog.appendRequirementsOutput(`Generation type: ${genType}`, dialog);

    dialog.generationContext = { selectedReqs, genType, mode, generation: null, umpleCode: "", chatContext: null };
    let tokenLimitTruncated = false;

    try {
      if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.preloadGuidance) {
        const guidanceType = genType === "classdiagram" ? "class diagrams" : "state machines";
        RequirementsDialog.appendRequirementsOutput(`Reading guidance on requirements and ${guidanceType}...`, dialog);
        await RequirementsPromptBuilder.preloadGuidance(genType);
      }

      const generation = mode === "replace"
        ? RequirementsPromptBuilder.buildUpdate({
          requirement: action.requirement,
          previousText: action.previous?.text,
          generationType: genType,
          modelText,
          options
        })
        : RequirementsPromptBuilder.buildGeneration(selectedReqs, genType, options);
      if (mode === "replace") {
        RequirementsDialog.appendRequirementsOutput(`${action.requirement.id} is already implemented: asking the AI for the updated model.`, dialog);
      }
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
      // Stop was clicked: handleStop has already shown what was generated
      if (dialog.stopped) return;
      streamRenderer.flush({ force: true });
      if (response && response.trim()) {
        AiChatContext.addAssistant(chatContext, response);
      }
      RequirementsDialog.appendRequirementsOutput("Generated initial Umple block from AI.", dialog);

      if (tokenLimitTruncated) {
        dialog.stopped = true;
        if (mode === "replace") {
          codeArea.value = response || "";
          this.showReplaceStopped(dialog, "Generation stopped: AI output was truncated due to token limit.");
          return;
        }
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
        const originalEditorCode = mode === "replace" ? modelText : (Page.codeMirrorEditor6?.state.doc.toString() || "");
          try {
            const corrected = await RequirementsSelfCorrection.run({
              originalCode: originalEditorCode,
              generatedResponse: responseText,
              requirements: selectedReqs,
              generationType: genType,
              chatContext,
              expectedRequirementIds: generation.expectedRequirementIds,
              mode,
              options,
              keptRequirementIds: mode === "replace" ? AiTextUtils.findRequirementBlocks(modelText).map(b => b.id) : [],
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
              // Stop clears the context
              if (dialog.generationContext) dialog.generationContext.umpleCode = umpleCode;
            }
        } catch (e) {
          RequirementsDialog.appendRequirementsOutput(`Self-correction failed: ${e.message}`, dialog);
        }
      }

      if (dialog.stopped && mode === "replace") {
        this.showReplaceStopped(dialog, "Generation stopped.");
        return;
      }

      codeArea.placeholder = "";
      codeArea.value = umpleCode;
      codeContainer.style.display = "block";
      btnInsert.style.display = "inline-block";
      if (mode === "replace") {
        const docText = Page.codeMirrorEditor6?.state.doc.toString() || "";
        RequirementsDialog.showModelChanges(dialog, docText.slice(0, this.getModelEnd(docText)), umpleCode);
      }

      if (statusDiv.style.color !== "#DD0033") {
        const successMsg = dialog.insertMode === "replace"
          ? "Updated model generated! Check the changes listed, then click 'Insert to Editor' to replace your model with it (Undo restores the previous one)."
          : dialog.stopped
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

      if (dialog.insertMode === "replace") {
        this.showReplaceStopped(dialog, "Generation stopped.");
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
      // "replace": the AI returned the whole updated model; the layout section is kept (issue #2485)
      const insertion = dialog.insertMode === "replace"
        ? (() => {
          const modelEnd = this.getModelEnd(currentDoc);
          const insertText = code.trim() + (modelEnd < currentDoc.length ? "\n" : "");
          return { insertPos: 0, replaceTo: modelEnd, insertText, highlightFrom: 0, highlightTo: code.trim().length };
        })()
        : RequirementsSelfCorrection.buildMergedCode(currentDoc, code);
      const highlightDurationMs = 3000;

      Page.codeMirrorEditor6.dispatch({
        changes: { from: insertion.insertPos, to: insertion.replaceTo ?? insertion.insertPos, insert: insertion.insertText },
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


