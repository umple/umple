// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Generator for UmpleOnline
// Generates Umple code (state machines, class diagrams) from requirements using LLMs

const AiRequirements = {
  // Active stream handle (for abort)
  activeStream: null,

  /**
   * Parse all requirements from Umple code
   * Requirements are defined with: req RequirementID { requirement text }
   * @param {string} umpleCode - The Umple code to parse
   * @returns {Array} Array of {id, text} requirement objects
   */
  parseRequirements(umpleCode) {
    const requirements = [];
    // Match req ID { text } allowing for multiline text
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

  /**
   * Abort the active stream (if any)
   */
  abortActiveStream() {
    try {
      this.activeStream?.abort?.();
    } catch (e) {
      // ignore
    } finally {
      this.activeStream = null;
    }
  },

  /**
   * Check if API key and model are configured
   * @returns {Object} {configured: boolean, message: string}
   */
  checkApiConfig() {
    return AiConfigValidation.checkApiConfig({ requireVerified: false });
  },

  /**
   * Build prompt for AI based on requirements and generation type
   * @param {Array} requirements - Array of requirement objects {id, text}
   * @param {string} generationType - 'statemachine' or 'classdiagram'
   * @returns {string} The prompt to send to AI
   */
  buildPrompt(requirements, generationType) {
    if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.buildGeneration) {
      return RequirementsPromptBuilder.buildGeneration(requirements, generationType).prompt;
    }

    // Fallback (should be unreachable in normal UmpleOnline load order)
    const requirementTexts = requirements.map(req => `Requirement ${req.id}:\n${req.text}`).join("\n\n");

    if (typeof AiPromptTags !== "undefined" && AiPromptTags.block && AiPromptTags.joinBlocks) {
      return AiPromptTags.joinBlocks([
        AiPromptTags.block("task", "Generate ONLY Umple code based on the following requirement(s)."),
        AiPromptTags.block("requirements", requirementTexts, { allowEmpty: true }),
        AiPromptTags.block("output_contract", [
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

  /**
   * Extract Umple code from AI response
   * @param {string} response - Raw AI response
   * @returns {string} Extracted Umple code
   */
  extractUmpleCode(response) {
    return AiResponseUtils.extractUmpleCode(response);
  },

  // --------------------------------------------------------------------------
  // Self-correction helpers (compiler-based)
  // --------------------------------------------------------------------------

  getCompilerLanguage() {
    return AiCompilerService.getCompilerLanguage();
  },

  getSelfCorrectionMaxPasses() {
    return AiCompilerService.getSelfCorrectionMaxPasses();
  },

  getRequirementsOutputArea() {
    return document.getElementById("requirementsOutputArea");
  },

  clearRequirementsOutput() {
    const area = this.getRequirementsOutputArea();
    if (area) area.value = "";
  },

  appendRequirementsOutput(line) {
    const area = this.getRequirementsOutputArea();
    if (!area) return;
    const text = String(line || "");
    area.value = area.value ? `${area.value}\n${text}` : text;
    area.scrollTop = area.scrollHeight;
  },

  setStatusMessage(statusDiv, label, message, color = "#3383bb") {
    if (!statusDiv) return;
    statusDiv.style.display = "block";
    statusDiv.style.color = color;
    statusDiv.textContent = "";
    if (label) {
      const labelSpan = document.createElement("span");
      labelSpan.className = "ai-status-label";
      labelSpan.textContent = label;
      statusDiv.appendChild(labelSpan);
      statusDiv.appendChild(document.createTextNode(` ${message}`));
    } else {
      statusDiv.textContent = message;
    }
  },

  stripHtmlToText(html) {
    return AiTextUtils.stripHtmlToText(html);
  },

  parseCompilerIssuesFromErrorHtml(errorHtml) {
    return AiCompilerService.parseCompilerIssuesFromErrorHtml(errorHtml);
  },

  getIssueKey(issue) {
    return AiCompilerService.getIssueKey(issue);
  },

  formatIssuesForLog(issues) {
    return AiCompilerService.formatIssuesForLog(issues);
  },

  formatIssuesForPrompt(issues) {
    return AiCompilerService.formatIssuesForPrompt(issues);
  },

  computeLineNumberAtIndex(text, index) {
    return AiTextUtils.computeLineNumberAtIndex(text, index);
  },

  async compileUmpleWithServer(umpleCode) {
    return AiCompilerService.compileUmpleWithServer(umpleCode);
  },

  getInsertionPos(docText) {
    const modelDelimiter = (typeof Page !== "undefined" && Page.modelDelimiter) ? Page.modelDelimiter : null;
    const modelEndIndex = modelDelimiter ? docText.indexOf(modelDelimiter) : -1;
    const insertBeforeIndex = modelEndIndex >= 0 ? modelEndIndex : docText.length;

    const modelText = docText.slice(0, insertBeforeIndex);
    const reqPattern = /req\s+(\w+(?:[-_]\w+)*)\s*\{[^}]*\}/gs;
    let lastReqEnd = -1;
    let match;

    while ((match = reqPattern.exec(modelText)) !== null) {
      lastReqEnd = match.index + match[0].length;
    }

    return lastReqEnd >= 0 ? lastReqEnd : insertBeforeIndex;
  },

  normalizeNewlines(text) {
    return AiTextUtils.normalizeNewlines(text);
  },

  computePrefix(docText, pos) {
    return AiTextUtils.computePrefix(docText, pos);
  },

  computeSuffix(docText, pos) {
    return AiTextUtils.computeSuffix(docText, pos);
  },

  buildMergedCode(docText, blockCode) {
    const insertPos = this.getInsertionPos(docText);
    const codeText = String(blockCode || "").trim();
    const prefix = this.computePrefix(docText, insertPos);
    const suffix = this.computeSuffix(docText, insertPos);
    const insertText = prefix + codeText + suffix;
    const mergedText = docText.slice(0, insertPos) + insertText + docText.slice(insertPos);

    const highlightFrom = insertPos + prefix.length;
    const highlightTo = highlightFrom + codeText.length;

    return { insertPos, insertText, mergedText, highlightFrom, highlightTo, codeText };
  },

  async selfCorrectWithCompiler({ originalCode, generatedBlock, requirements, generationType, systemPrompt, dialog, statusDiv } = {}) {
    const maxPasses = this.getSelfCorrectionMaxPasses();
    let currentBlock = String(generatedBlock || "").trim();
    if (!currentBlock) return { block: currentBlock };

    let baseline = null;
    try {
      baseline = await this.compileUmpleWithServer(originalCode);
      if (baseline.issues.length > 0) {
        this.appendRequirementsOutput("Baseline compile: the original model already has issues:");
        this.appendRequirementsOutput(this.formatIssuesForLog(baseline.issues));
      } else {
        this.appendRequirementsOutput("Baseline compile: no issues in original model.");
      }
    } catch (e) {
      this.appendRequirementsOutput(`Baseline compile failed: ${e.message}`);
    }

    const seenBlocks = new Set();
    const initialBlock = String(currentBlock || "").trim();
    if (initialBlock) {
      seenBlocks.add(initialBlock);
    }
    let lastIssueSignature = null;
    let stagnantIssueCount = 0;

    // Preload guidance for repair prompts to ensure cached content is available
    if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.preloadGuidance) {
      try {
        await RequirementsPromptBuilder.preloadGuidance(generationType);
      } catch (e) {
        this.appendRequirementsOutput(`Guidance preload failed (continuing anyway): ${e.message}`);
      }
    }

    for (let pass = 1; pass <= maxPasses; pass++) {
      if (dialog?.stopped) {
        this.appendRequirementsOutput(`\nSelf-correction stopped by user at pass ${pass}.`);
        break;
      }
      this.setStatusMessage(statusDiv, "Compiler", `Self-correction pass ${pass}/${maxPasses}: compiling...`);
      this.appendRequirementsOutput(`\nSelf-correction pass ${pass}: compiling merged model...`);
      const merged = this.buildMergedCode(originalCode, currentBlock);
      const insertedStartLine = this.computeLineNumberAtIndex(merged.mergedText, merged.highlightFrom);
      const insertedEndLine = this.computeLineNumberAtIndex(merged.mergedText, merged.highlightTo);

      const mergedText = merged.mergedText;

      let compiled;
      try {
        compiled = await this.compileUmpleWithServer(mergedText);
      } catch (e) {
        this.appendRequirementsOutput(`Compile failed: ${e.message}`);
        break;
      }

      const issues = compiled.issues || [];
      const errorIssues = issues.filter(issue => issue.severity === "Error");
      if (errorIssues.length === 0) {
        const warningCount = issues.filter(issue => issue.severity === "Warning").length;
        this.appendRequirementsOutput(
          warningCount > 0
            ? `Compiler reports no errors (${warningCount} warning(s) ignored for self-correction).`
            : "Compiler reports no errors."
        );
        return { block: currentBlock };
      }

      const baselineIssues = baseline?.issues || [];
      const baselineIssueKeys = baselineIssues.length > 0
        ? new Set(baselineIssues.map(issue => this.getIssueKey(issue)))
        : new Set();

      const nonBaselineErrors = baselineIssueKeys.size > 0
        ? errorIssues.filter(issue => !baselineIssueKeys.has(this.getIssueKey(issue)))
        : errorIssues;

      if (baselineIssueKeys.size > 0) {
        this.appendRequirementsOutput(`Baseline issues: ${baselineIssues.length}`);
      }

      if (baselineIssueKeys.size > 0 && nonBaselineErrors.length === 0) {
        this.appendRequirementsOutput("Only baseline errors remain; stopping self-correction.");
        return { block: currentBlock };
      }

      const focusErrorIssues = nonBaselineErrors.length > 0 ? nonBaselineErrors : errorIssues;
      const inInsertedRange = focusErrorIssues.filter(i => Number.isFinite(i.line) && i.line >= insertedStartLine && i.line <= insertedEndLine);
      const focusIssues = inInsertedRange.length > 0 ? inInsertedRange : focusErrorIssues;

      const issueSignature = focusIssues.map(issue => this.getIssueKey(issue)).join("||");
      if (issueSignature && issueSignature === lastIssueSignature) {
        stagnantIssueCount += 1;
      } else {
        stagnantIssueCount = 0;
        lastIssueSignature = issueSignature;
      }

      if (stagnantIssueCount >= 1) {
        this.appendRequirementsOutput("Compiler issues did not change after a repair attempt; stopping self-correction.");
        break;
      }

      this.appendRequirementsOutput(`Compiler reported ${errorIssues.length} error(s) in merged model.`);
      if (inInsertedRange.length > 0) {
        this.appendRequirementsOutput(`Focusing on ${inInsertedRange.length} issue(s) within the inserted block (lines ${insertedStartLine}-${insertedEndLine}).`);
      } else {
        this.appendRequirementsOutput("No issues were located within the inserted block line range; attempting to fix by adjusting the generated block anyway.");
      }
      this.appendRequirementsOutput(this.formatIssuesForLog(focusIssues));

      const compilerIssuesText = focusIssues.map(issue => {
        const codeSuffix = issue.errorCode ? ` (${issue.errorCode})` : "";
        const lineText = Number.isFinite(issue.line) ? issue.line : "?";
        const blockLine = Number.isFinite(issue.line) && issue.line >= insertedStartLine && issue.line <= insertedEndLine
          ? issue.line - insertedStartLine + 1
          : null;
        const blockText = Number.isFinite(blockLine) ? ` (block line ${blockLine})` : "";
        let issueText = `- ${issue.severity}${codeSuffix} on merged line ${lineText}${blockText}: ${issue.message}`;

        if (Number.isFinite(issue.line) && mergedText) {
          const snippet = AiTextUtils.getLinesAround(mergedText, issue.line - 1, 2);
          if (snippet) {
            issueText += `\n  snippet:\n${snippet.split("\n").map(l => "  " + l).join("\n")}`;
          }
        }

        return issueText;
      }).join("\n");
      const repairPrompt = (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.repair_buildGeneration)
        ? RequirementsPromptBuilder.repair_buildGeneration({
          generationType,
          requirements,
          originalCode,
          invalidBlock: currentBlock,
          compilerIssuesText
        })
        : `Fix the following Umple block so that it compiles with the original model without errors.\n\nOriginal model:\n\n\`\`\`umple\n${originalCode}\n\`\`\`\n\nBlock to fix:\n\n\`\`\`umple\n${currentBlock}\n\`\`\`\n\nCompiler issues:\n${compilerIssuesText}\n\nOutput ONLY the corrected block as a single \`\`\`umple\`\`\` code block.`;

      this.setStatusMessage(statusDiv, "LLM", `Repairing generated block (pass ${pass}/${maxPasses})...`);
      this.appendRequirementsOutput("Asking AI to repair the generated block...");

      let repairedResponse;
      try {
        repairedResponse = await AiApi.chat(repairPrompt, systemPrompt);
      } catch (e) {
        this.appendRequirementsOutput(`AI repair failed: ${e.message}`);
        break;
      }

      const repairedBlock = String(this.extractUmpleCode(repairedResponse) || "").trim();
      if (!repairedBlock) {
        this.appendRequirementsOutput("AI repair produced empty output; stopping.");
        break;
      }

      if (repairedBlock.trim() === String(currentBlock || "").trim()) {
        this.appendRequirementsOutput("AI repair repeated the current output; stopping.");
        break;
      }

      if (seenBlocks.has(repairedBlock)) {
        this.appendRequirementsOutput("AI repair repeated an earlier output; stopping.");
        break;
      }

      currentBlock = repairedBlock;
      seenBlocks.add(repairedBlock);

      this.appendRequirementsOutput("Retrying compile with repaired block...");
    }

    this.appendRequirementsOutput("Self-correction stopped before reaching a clean compile.");
    return { block: currentBlock };
  },

  // System prompt for Umple code generation
  SYSTEM_PROMPT: (() => {
    const base = (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
      ? AiPrompting.getBaseSystemPrompt()
      : "You are an expert in Umple modeling language.";

    const directive = "Your job is to generate ONLY valid Umple code.";
    if (typeof AiPromptTags !== "undefined" && AiPromptTags.block && AiPromptTags.joinBlocks) {
      return AiPromptTags.joinBlocks([
        AiPromptTags.block("system", base, { allowEmpty: true }),
        AiPromptTags.block("directive", directive)
      ]);
    }

    return `${base}\n\n${directive}`;
  })(),

  /**
   * Show the requirements selection dialog
   */
  showDialog() {
    // Get current Umple code
    const umpleCode = Page.codeMirrorEditor6?.state.doc.toString() || "";

    // Parse requirements
    const requirements = this.parseRequirements(umpleCode);

    if (requirements.length === 0) {
      // Show non-dismissible info dialog
      const dialog = document.createElement("div");
      dialog.className = "ai-requirements-dialog";

      const overlay = document.createElement("div");
      overlay.className = "dialog-overlay";
      overlay.style.pointerEvents = "none";
      dialog.appendChild(overlay);

      const content = document.createElement("div");
      content.className = "dialog-content";

      const title = document.createElement("h3");
      title.textContent = "No Requirements Found";
      content.appendChild(title);

      const messageDiv = document.createElement("div");
      messageDiv.style.marginBottom = "15px";
      messageDiv.style.whiteSpace = "pre-line";
      const messageText = document.createTextNode("No requirements found in your Umple code.\n\nSee ");
      messageDiv.appendChild(messageText);
      const link = document.createElement("a");
      link.href = "https://cruise.umple.org/umple/Requirements.html";
      link.target = "_blank";
      link.textContent = "https://cruise.umple.org/umple/Requirements.html";
      messageDiv.appendChild(link);
      messageDiv.appendChild(document.createTextNode(" for more information."));
      content.appendChild(messageDiv);

      const buttonsDiv = document.createElement("div");
      buttonsDiv.className = "dialog-buttons";
      buttonsDiv.style.justifyContent = "center";

      const btnOK = document.createElement("div");
      btnOK.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
      btnOK.tabIndex = 0;
      btnOK.setAttribute("role", "button");
      btnOK.textContent = "OK";
      btnOK.addEventListener("click", () => {
        dialog.remove();
      });
      btnOK.addEventListener("keypress", (event) => {
        if (event.key === "Enter" || event.key === " ") {
          dialog.remove();
        }
      });
      buttonsDiv.appendChild(btnOK);

      content.appendChild(buttonsDiv);
      dialog.appendChild(content);
      document.body.appendChild(dialog);
      return;
    }

    // Check API configuration
    const apiConfig = this.checkApiConfig();
    if (!apiConfig.configured) {
      // Show the settings modal instead of just an alert
      if (typeof AiController !== "undefined" && AiController.showSettingsModal) {
        AiController.showSettingsModal();
      }
      alert(apiConfig.message);
      return;
    }

    // Create and show dialog
    this.createDialog(requirements);
  },

  /**
   * Create requirement selection UI for single requirement
   * @param {Object} requirement - Requirement object {id, text}
   * @returns {HTMLElement} Requirement selection container
   */
  createSingleRequirementUI(requirement) {
    const container = document.createElement("div");
    container.className = "requirement-selection";

    const heading = document.createElement("h4");
    heading.textContent = "Requirement:";
    container.appendChild(heading);

    const display = document.createElement("div");
    display.className = "requirement-display";

    const strong = document.createElement("strong");
    strong.textContent = requirement.id;
    display.appendChild(strong);

    const textDiv = document.createElement("div");
    textDiv.className = "requirement-text";
    textDiv.textContent = requirement.text;
    display.appendChild(textDiv);

    container.appendChild(display);
    return container;
  },

  /**
   * Create requirement selection UI for multiple requirements
   * @param {Array} requirements - Array of requirement objects
   * @returns {HTMLElement} Requirement selection container
   */
  createMultipleRequirementUI(requirements) {
    const container = document.createElement("div");
    container.className = "requirement-selection";

    const heading = document.createElement("h4");
    heading.textContent = "Select Requirements:";
    container.appendChild(heading);

    // Radio buttons for mode selection
    const modeDiv = document.createElement("div");
    modeDiv.className = "requirement-mode";

    const labelAll = document.createElement("label");
    const radioAll = document.createElement("input");
    radioAll.type = "radio";
    radioAll.name = "reqMode";
    radioAll.value = "all";
    radioAll.checked = true;
    labelAll.appendChild(radioAll);
    labelAll.appendChild(document.createTextNode(" All Requirements (recommended for comprehensive generation)"));
    modeDiv.appendChild(labelAll);

    const labelMultiple = document.createElement("label");
    const radioMultiple = document.createElement("input");
    radioMultiple.type = "radio";
    radioMultiple.name = "reqMode";
    radioMultiple.value = "multiple";
    labelMultiple.appendChild(radioMultiple);
    labelMultiple.appendChild(document.createTextNode(" Select Specific Requirements"));
    modeDiv.appendChild(labelMultiple);

    container.appendChild(modeDiv);

    // Checkboxes container
    const multipleDiv = document.createElement("div");
    multipleDiv.id = "multipleReqSelection";
    multipleDiv.className = "multiple-req-selection";
    multipleDiv.style.display = "none";

    requirements.forEach(req => {
      const label = document.createElement("label");
      label.className = "requirement-checkbox";

      const checkbox = document.createElement("input");
      checkbox.type = "checkbox";
      checkbox.value = req.id;
      checkbox.className = "req-checkbox";
      label.appendChild(checkbox);

      const span = document.createElement("span");
      span.className = "requirement-summary";
      const strong = document.createElement("strong");
      strong.textContent = req.id;
      span.appendChild(strong);
      const summaryText = req.text.substring(0, 100) + (req.text.length > 100 ? "..." : "");
      span.appendChild(document.createTextNode(`: ${summaryText}`));
      label.appendChild(span);

      multipleDiv.appendChild(label);
    });

    container.appendChild(multipleDiv);

    // Selected requirements display
    const displayDiv = document.createElement("div");
    displayDiv.id = "selectedReqDisplay";
    displayDiv.className = "selected-req-display";

    const strong = document.createElement("strong");
    strong.textContent = "Selected Requirements:";
    displayDiv.appendChild(strong);

    const selectedText = document.createElement("div");
    selectedText.id = "selectedReqText";
    selectedText.textContent = `All requirements (${requirements.length})`;
    displayDiv.appendChild(selectedText);

    container.appendChild(displayDiv);
    return container;
  },

  /**
   * Create the requirements selection dialog UI
   * @param {Array} requirements - Array of requirement objects
   */
  createDialog(requirements) {
    // Remove existing dialog if any
    const existingDialog = document.getElementById("aiRequirementsDialog");
    if (existingDialog) {
      existingDialog.remove();
    }

    // Create dialog container
    const dialog = document.createElement("div");
    dialog.id = "aiRequirementsDialog";
    dialog.className = "ai-requirements-dialog";

    // Create overlay
    const overlay = document.createElement("div");
    overlay.className = "dialog-overlay";
    dialog.appendChild(overlay);

    // Create dialog content
    const content = document.createElement("div");
    content.className = "dialog-content";

    // Title
    const title = document.createElement("h3");
    title.textContent = "Generate from Requirements";
    content.appendChild(title);

    // Requirement selection UI
    const requirementSelection = requirements.length === 1
      ? this.createSingleRequirementUI(requirements[0])
      : this.createMultipleRequirementUI(requirements);
    content.appendChild(requirementSelection);

    // Generation type selection
    const genTypeDiv = document.createElement("div");
    genTypeDiv.className = "generation-type";

    const genTypeHeading = document.createElement("h4");
    genTypeHeading.textContent = "Select Generation Type:";
    genTypeDiv.appendChild(genTypeHeading);

    const labelStateMachine = document.createElement("label");
    const radioStateMachine = document.createElement("input");
    radioStateMachine.type = "radio";
    radioStateMachine.name = "genType";
    radioStateMachine.value = "statemachine";
    radioStateMachine.checked = true;
    labelStateMachine.appendChild(radioStateMachine);
    labelStateMachine.appendChild(document.createTextNode(" State Machine"));
    genTypeDiv.appendChild(labelStateMachine);

    const labelClassDiagram = document.createElement("label");
    const radioClassDiagram = document.createElement("input");
    radioClassDiagram.type = "radio";
    radioClassDiagram.name = "genType";
    radioClassDiagram.value = "classdiagram";
    labelClassDiagram.appendChild(radioClassDiagram);
    labelClassDiagram.appendChild(document.createTextNode(" Class Diagram"));
    genTypeDiv.appendChild(labelClassDiagram);

    content.appendChild(genTypeDiv);

    // Generated code container
    const codeContainer = document.createElement("div");
    codeContainer.id = "generatedCodeContainer";
    codeContainer.style.display = "none";

    const codeHeading = document.createElement("h4");
    codeHeading.textContent = "Generated Umple Code:";
    codeContainer.appendChild(codeHeading);

    const codeArea = document.createElement("textarea");
    codeArea.id = "generatedCodeArea";
    codeArea.readOnly = true;
    codeContainer.appendChild(codeArea);

    content.appendChild(codeContainer);

    // Self-correction / compilation output
    const outputContainer = document.createElement("div");
    outputContainer.id = "requirementsOutputContainer";
    outputContainer.style.display = "none";

    const outputHeading = document.createElement("h4");
    outputHeading.textContent = "Log:";
    outputContainer.appendChild(outputHeading);

    const outputArea = document.createElement("textarea");
    outputArea.id = "requirementsOutputArea";
    outputArea.readOnly = true;
    outputContainer.appendChild(outputArea);
    content.appendChild(outputContainer);

    // Dialog buttons
    const buttonsDiv = document.createElement("div");
    buttonsDiv.className = "dialog-buttons";

    const btnGenerate = document.createElement("div");
    btnGenerate.id = "btnGenerate";
    btnGenerate.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnGenerate.tabIndex = 0;
    btnGenerate.setAttribute("role", "button");
    btnGenerate.textContent = "Generate";
    buttonsDiv.appendChild(btnGenerate);

    const btnStop = document.createElement("div");
    btnStop.id = "btnStop";
    btnStop.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnStop.tabIndex = 0;
    btnStop.setAttribute("role", "button");
    btnStop.style.display = "none";
    btnStop.textContent = "Stop";
    buttonsDiv.appendChild(btnStop);

    const btnInsert = document.createElement("div");
    btnInsert.id = "btnInsert";
    btnInsert.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnInsert.tabIndex = 0;
    btnInsert.setAttribute("role", "button");
    btnInsert.style.display = "none";
    btnInsert.textContent = "Insert to Editor";
    buttonsDiv.appendChild(btnInsert);

    const btnCancel = document.createElement("div");
    btnCancel.id = "btnCancel";
    btnCancel.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnCancel.tabIndex = 0;
    btnCancel.setAttribute("role", "button");
    btnCancel.textContent = "Cancel";
    buttonsDiv.appendChild(btnCancel);

    // Status message (compiler-like output)
    const statusDiv = document.createElement("div");
    statusDiv.id = "statusMessage";
    statusDiv.className = "status-message";
    statusDiv.style.display = "none";
    content.appendChild(statusDiv);

    content.appendChild(buttonsDiv);

    dialog.appendChild(content);
    document.body.appendChild(dialog);

    // Set up event listeners
    this.setupDialogEvents(dialog, requirements);
  },

  /**
   * Set up event listeners for the dialog
   * @param {HTMLElement} dialog - The dialog element
   * @param {Array} requirements - Array of requirements
   */
  setupDialogEvents(dialog, requirements) {
    // Mode selection change
    const modeRadios = dialog.querySelectorAll('input[name="reqMode"]');
    modeRadios.forEach(radio => {
      radio.addEventListener("change", e => {
        const mode = e.target.value;
        const multipleDiv = document.getElementById("multipleReqSelection");
        const displayDiv = document.getElementById("selectedReqText");

        if (mode === "all") {
          multipleDiv.style.display = "none";
          displayDiv.textContent = `All requirements (${requirements.length})`;
        } else if (mode === "multiple") {
          multipleDiv.style.display = "block";
          this.updateSelectedDisplay(dialog, requirements);
        }
      });
    });

    // Checkbox change for multiple selection
    const checkboxes = dialog.querySelectorAll(".req-checkbox");
    checkboxes.forEach(checkbox => {
      checkbox.addEventListener("change", () => {
        this.updateSelectedDisplay(dialog, requirements);
      });
    });

    // Generate button
    const btnGenerate = document.getElementById("btnGenerate");
    const generateHandler = event => {
      event.preventDefault();
      this.handleGenerate(dialog, requirements);
    };
    btnGenerate.addEventListener("click", generateHandler);
    btnGenerate.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") generateHandler(event);
    });

    // Stop button
    const btnStop = document.getElementById("btnStop");
    const stopHandler = event => {
      event.preventDefault();
      this.handleStop(dialog);
    };
    btnStop.addEventListener("click", stopHandler);
    btnStop.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") stopHandler(event);
    });

    // Insert button
    const btnInsert = document.getElementById("btnInsert");
    const insertHandler = event => {
      event.preventDefault();
      const codeArea = document.getElementById("generatedCodeArea");
      const code = codeArea.value;
      if (code) {
        if (!Page.codeMirrorEditor6) {
          alert("Editor not initialized");
          return;
        }
        const currentDoc = Page.codeMirrorEditor6.state.doc.toString();
        const insertion = this.buildMergedCode(currentDoc, code);
        const highlightDurationMs = 3000;

        Page.codeMirrorEditor6.dispatch({
          changes: { from: insertion.insertPos, to: insertion.insertPos, insert: insertion.insertText },
          selection: insertion.highlightTo > insertion.highlightFrom
            ? { anchor: insertion.highlightFrom, head: insertion.highlightTo }
            : { anchor: insertion.insertPos + insertion.insertText.length }
          ,
          scrollIntoView: true
        });

        Page.codeMirrorEditor6.focus();

        const newCode = Page.codeMirrorEditor6.state.doc.toString();
        TabControl.getCurrentHistory().save(newCode, "aiGeneration");

        // Temporary highlight to help users spot the inserted block.
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
    };
    btnInsert.addEventListener("click", insertHandler);
    btnInsert.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") insertHandler(event);
    });

    // Cancel button
    const btnCancel = document.getElementById("btnCancel");
    const cancelHandler = event => {
      event.preventDefault();
      this.abortActiveStream();
      dialog.remove();
    };
    btnCancel.addEventListener("click", cancelHandler);
    btnCancel.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") cancelHandler(event);
    });

    // Close on overlay click
    const overlay = dialog.querySelector(".dialog-overlay");
    overlay.addEventListener("click", () => {
      this.abortActiveStream();
      dialog.remove();
    });
  },

  /**
   * Update the selected requirements display
   * @param {HTMLElement} dialog - The dialog element
   * @param {Array} requirements - Array of all requirements
   */
  updateSelectedDisplay(dialog, requirements) {
    const displayDiv = document.getElementById("selectedReqText");
    const checkboxes = dialog.querySelectorAll(".req-checkbox:checked");
    const selectedIds = Array.from(checkboxes).map(cb => cb.value);

    if (selectedIds.length === 0) {
      displayDiv.textContent = "No requirements selected";
    } else {
      const selectedReqs = requirements.filter(r => selectedIds.includes(r.id));
      displayDiv.textContent = selectedReqs.map(r => `${r.id}: ${r.text}`).join("\n\n");
    }
  },

  /**
   * Get selected requirements based on current mode
   * @param {HTMLElement} dialog - The dialog element
   * @param {Array} requirements - Array of all requirements
   * @returns {Array} Selected requirements
   */
  getSelectedRequirements(dialog, requirements) {
    const mode = dialog.querySelector('input[name="reqMode"]:checked')?.value || "all";

    if (mode === "all") {
      return requirements;
    } else {
      // multiple
      const checkboxes = dialog.querySelectorAll(".req-checkbox:checked");
      const selectedIds = Array.from(checkboxes).map(cb => cb.value);
      return requirements.filter(r => selectedIds.includes(r.id));
    }
  },

  /**
   * Handle generate button click
   * @param {HTMLElement} dialog - The dialog element
   * @param {Array} requirements - Array of all requirements
   */
  async handleGenerate(dialog, requirements) {
    const statusDiv = document.getElementById("statusMessage");
    const btnGenerate = document.getElementById("btnGenerate");
    const btnStop = document.getElementById("btnStop");
    const btnInsert = document.getElementById("btnInsert");
    const codeContainer = document.getElementById("generatedCodeContainer");
    const codeArea = document.getElementById("generatedCodeArea");
    const outputContainer = document.getElementById("requirementsOutputContainer");

    // Get selected requirements
    const selectedReqs = this.getSelectedRequirements(dialog, requirements);

    if (selectedReqs.length === 0) {
      this.setStatusMessage(statusDiv, "Error", "Please select at least one requirement", "#DD0033");
      return;
    }

    // Get generation type
    const genType = dialog.querySelector('input[name="genType"]:checked')?.value || "statemachine";

    // Get API config
    const apiConfig = this.checkApiConfig();
    if (!apiConfig.configured) {
      this.setStatusMessage(statusDiv, "Error", apiConfig.message, "#DD0033");
      return;
    }

    // Disable generate button, show stop button, and show loading
    btnGenerate.classList.add("disabled");
    btnGenerate.textContent = "Generating...";
    btnStop.style.display = "inline-block";
    this.setStatusMessage(statusDiv, "LLM", "Generating Umple code from requirements...");

    if (outputContainer) outputContainer.style.display = "block";
    this.clearRequirementsOutput();
    this.appendRequirementsOutput(`Generation type: ${genType}`);

    // Store generation context for stop handler
    dialog.generationContext = { selectedReqs, genType, generation: null, umpleCode: "" };
    let tokenLimitTruncated = false;

    try {
      if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.preloadGuidance) {
        const guidanceType = genType === "classdiagram" ? "class diagrams" : "state machines";
        this.appendRequirementsOutput(`Reading guidance on requirements and ${guidanceType}...`);
        await RequirementsPromptBuilder.preloadGuidance(genType);
      }

      const generation = (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.buildGeneration)
        ? RequirementsPromptBuilder.buildGeneration(selectedReqs, genType)
        : { prompt: this.buildPrompt(selectedReqs, genType), systemPrompt: this.SYSTEM_PROMPT, expectedRequirementIds: selectedReqs.map(r => r.id) };

      dialog.generationContext.generation = generation;

    // Call AI API using streaming
      this.setStatusMessage(statusDiv, "LLM", `Generating ${genType === "classdiagram" ? "class diagram" : "state machine"}...`);
      this.appendRequirementsOutput(`Generating ${genType === "classdiagram" ? "class diagram" : "state machine"}...`);
      let streamedText = "";
      codeArea.value = "";
      codeContainer.style.display = "block";
      btnInsert.style.display = "none";
      this.activeStream = AiApi.chatStream(generation.prompt, generation.systemPrompt, {}, {
        onDelta: (deltaText) => {
          streamedText += deltaText;
          codeArea.value = streamedText;
        },
        onTruncated: () => {
          tokenLimitTruncated = true;
        }
      });

      const response = await this.activeStream.done;
      this.activeStream = null;
      this.appendRequirementsOutput("Generated initial Umple block from AI.");

      if (tokenLimitTruncated) {
        // Stop further processing (validation/repair/self-correction)
        dialog.stopped = true;
        this.setStatusMessage(
          statusDiv,
          "LLM",
          "Generation stopped: AI output was truncated due to token limit. Try selecting fewer requirements, shortening requirement text, or using a larger model.",
          "#DD0033"
        );

        // Still show whatever we got so the user can decide what to do.
        codeArea.value = response || "";
        codeContainer.style.display = "block";
        btnInsert.style.display = response && response.trim() ? "inline-block" : "none";
        return;
      }

      // Extract Umple code
      dialog.generationContext.umpleCode = this.extractUmpleCode(response);
      let umpleCode = dialog.generationContext.umpleCode;

      // Validate + single repair pass (only if not stopped)
      if (!dialog.stopped && typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.validateGeneratedUmple && RequirementsPromptBuilder.repair_buildGeneration) {
        const validation = RequirementsPromptBuilder.validateGeneratedUmple({
          code: umpleCode,
          expectedRequirementIds: generation.expectedRequirementIds || [],
          generationType: genType
        });

        if (!validation.valid) {
          this.setStatusMessage(statusDiv, "LLM", "Repairing validation issues...");
          this.appendRequirementsOutput(`Validation issues found: ${validation.errors.join(", ")}. Repairing...`);
          const validationIssuesText = validation.errors.map(err => `- ${err}`).join("\n");
          const repairPrompt = RequirementsPromptBuilder.repair_buildGeneration({
            generationType: genType,
            requirements: selectedReqs,
            invalidBlock: umpleCode,
            compilerIssuesText: validationIssuesText
          });

          if (dialog.stopped) {
            this.appendRequirementsOutput("\nRepair stopped by user.");
          } else {
            const repairedResponse = await AiApi.chat(repairPrompt, generation.systemPrompt);
            umpleCode = this.extractUmpleCode(repairedResponse);
            dialog.generationContext.umpleCode = umpleCode;

            const repairedValidation = RequirementsPromptBuilder.validateGeneratedUmple({
              code: umpleCode,
              expectedRequirementIds: generation.expectedRequirementIds || [],
              generationType: genType
            });

            if (!repairedValidation.valid) {
              this.setStatusMessage(
                statusDiv,
                "LLM",
                `Generated code may be invalid:\n${repairedValidation.errors.join("\n")}`,
                "#DD0033"
              );
            } else {
              this.appendRequirementsOutput("Code repaired successfully.");
            }
          }
        }
      }

      // Compiler-based self-correction loop (compile merged model: original + inserted block)
      if (!dialog.stopped) {
        this.setStatusMessage(statusDiv, "Compiler", "Running compiler-based self-correction...");
        this.appendRequirementsOutput("Running compiler-based self-correction...");
        codeArea.value = "";
        codeArea.placeholder = "Self-correction in progress...";
        const originalEditorCode = Page.codeMirrorEditor6?.state.doc.toString() || "";
        try {
          const corrected = await this.selfCorrectWithCompiler({
            originalCode: originalEditorCode,
            generatedBlock: umpleCode,
            requirements: selectedReqs,
            generationType: genType,
            systemPrompt: generation.systemPrompt,
            dialog,
            statusDiv
          });
          if (corrected && typeof corrected.block === "string" && corrected.block.trim()) {
            umpleCode = corrected.block.trim();
            dialog.generationContext.umpleCode = umpleCode;
          }
        } catch (e) {
          this.appendRequirementsOutput(`Self-correction failed: ${e.message}`);
        }
      }

      // Display generated code
      codeArea.placeholder = "";
      codeArea.value = umpleCode;
      codeContainer.style.display = "block";
      btnInsert.style.display = "inline-block";

      if (statusDiv.style.color !== "#DD0033") {
        const successMsg = dialog.stopped
          ? "Generation stopped. Partial code generated! Review and click 'Insert to Editor' to add it to your model."
          : "Code generated successfully! Review and click 'Insert to Editor' to add it to your model.";
        this.setStatusMessage(statusDiv, "LLM", successMsg);
      }
    } catch (error) {
      if (error?.name === "AbortError") {
        this.appendRequirementsOutput("\nGeneration stopped by user.");
        return;
      }
      console.error("Error generating code:", error);
      this.setStatusMessage(statusDiv, "Error", `Error: ${error.message}`, "#DD0033");
    } finally {
      btnGenerate.classList.remove("disabled");
      btnGenerate.textContent = "Generate";
      btnStop.style.display = "none";
      dialog.stopped = false;
      dialog.generationContext = null;
    }
  },

  /**
   * Handle stop button click
   * @param {HTMLElement} dialog - The dialog element
   */
  async handleStop(dialog) {
    const statusDiv = document.getElementById("statusMessage");
    const btnGenerate = document.getElementById("btnGenerate");
    const btnStop = document.getElementById("btnStop");
    const btnInsert = document.getElementById("btnInsert");
    const codeContainer = document.getElementById("generatedCodeContainer");
    const codeArea = document.getElementById("generatedCodeArea");

    // Mark as stopped
    dialog.stopped = true;

    // Abort the active stream
    this.abortActiveStream();

    this.setStatusMessage(statusDiv, "LLM", "Stopping generation...");

    try {
      const context = dialog.generationContext;
      if (!context) {
        this.setStatusMessage(statusDiv, "LLM", "No generation in progress.", "#DD0033");
        return;
      }

      let umpleCode = context.umpleCode;

      // If we have no code yet (stopped too early), extract from any accumulated response
      if (!umpleCode) {
        umpleCode = "";
      }

      if (umpleCode.trim()) {
        this.appendRequirementsOutput("Applying partial generated code...");

        // Display generated code
        codeArea.value = umpleCode;
        codeContainer.style.display = "block";
        btnInsert.style.display = "inline-block";

        this.setStatusMessage(
          statusDiv,
          "LLM",
          "Generation stopped. Partial code generated! Review and click 'Insert to Editor' to add it to your model."
        );
      } else {
        this.setStatusMessage(statusDiv, "LLM", "Generation stopped before any code was generated.", "#DD0033");
      }
    } catch (error) {
      console.error("Error stopping generation:", error);
      this.setStatusMessage(statusDiv, "Error", `Error stopping: ${error.message}`, "#DD0033");
    } finally {
      btnGenerate.classList.remove("disabled");
      btnGenerate.textContent = "Generate";
      btnStop.style.display = "none";
      dialog.generationContext = null;
    }
  }
};

// Initialize when DOM is ready
if (typeof Page !== "undefined") {
  // Page object exists, we can add the button programmatically
  // This will be called from umple.php or after DOM loads
}
