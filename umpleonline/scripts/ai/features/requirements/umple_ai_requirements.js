// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Generator for UmpleOnline
// Generates Umple code (state machines, class diagrams) from requirements using LLMs

const AiRequirements = {
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
   * Check if API key and model are configured
   * @returns {Object} {configured: boolean, message: string}
   */
  checkApiConfig() {
    const provider = AiApi.getProvider();
    if (!provider) {
      return {
        configured: false,
        message: "Please select an AI provider in the AI section first."
      };
    }

    const apiKey = AiApi.getApiKey(provider);
    if (!apiKey) {
      return {
        configured: false,
        message: "Please configure your AI API key in the AI section first."
      };
    }

    // Check both localStorage and UI element for model
    const model = AiApi.getModel();
    if (!model) {
      return {
        configured: false,
        message: "Please verify your API key and select a model in the AI section."
      };
    }

    return { configured: true };
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
    return `You are an expert in Umple modeling language. Based on the following requirement(s), generate ONLY Umple code.\n\nRequirements:\n${requirementTexts}\n\nUmple code:`;
  },

  /**
   * Extract Umple code from AI response
   * @param {string} response - Raw AI response
   * @returns {string} Extracted Umple code
   */
  extractUmpleCode(response) {
    // Try to extract code from markdown code blocks first
    const codeBlockMatch = response.match(/```(?:umple)?\s*([\s\S]*?)```/);
    if (codeBlockMatch) {
      return codeBlockMatch[1].trim();
    }

    // If no code block, try to find class definitions or req statements
    const classMatch = response.match(/(?:class|interface|trait|association)\s+\w+/);
    if (classMatch) {
      // Return everything from the first class/interface/trait/association keyword
      const startIndex = response.indexOf(classMatch[0]);
      return response.substring(startIndex).trim();
    }

    // Return the whole response, trimmed
    return response.trim();
  },

  // System prompt for Umple code generation
  SYSTEM_PROMPT: (typeof AiPrompting !== "undefined" && AiPrompting.getBaseSystemPrompt)
    ? `${AiPrompting.getBaseSystemPrompt()}\n\nYour job is to generate ONLY valid Umple code.`
    : "You are an expert in Umple modeling language. Generate only valid Umple code without explanations.",

  /**
   * Insert generated code at cursor position in CodeMirror 6
   * @param {string} code - Code to insert
   */
  insertCodeAtCursor(code) {
    if (!Page.codeMirrorEditor6) {
      alert("Editor not initialized");
      return;
    }

    // Get current cursor position
    const cursorPos = Page.codeMirrorEditor6.state.selection.main.head;

    // Add newlines before and after for proper formatting
    const formattedCode = "\n" + code + "\n";

    // Insert the code at cursor position
    Page.codeMirrorEditor6.dispatch({
      changes: { from: cursorPos, to: cursorPos, insert: formattedCode },
      selection: { anchor: cursorPos + formattedCode.length }
    });

    // Focus the editor
    Page.codeMirrorEditor6.focus();

    // Save to history
    const newCode = Page.codeMirrorEditor6.state.doc.toString();
    TabControl.getCurrentHistory().save(newCode, "aiGeneration");
  },

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

    content.appendChild(buttonsDiv);

    // Status message
    const statusDiv = document.createElement("div");
    statusDiv.id = "statusMessage";
    statusDiv.className = "status-message";
    statusDiv.style.display = "none";
    content.appendChild(statusDiv);

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

    // Insert button
    const btnInsert = document.getElementById("btnInsert");
    const insertHandler = event => {
      event.preventDefault();
      const codeArea = document.getElementById("generatedCodeArea");
      const code = codeArea.value;
      if (code) {
        this.insertCodeAtCursor(code);
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
      dialog.remove();
    };
    btnCancel.addEventListener("click", cancelHandler);
    btnCancel.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") cancelHandler(event);
    });

    // Close on overlay click
    const overlay = dialog.querySelector(".dialog-overlay");
    overlay.addEventListener("click", () => {
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
    const btnInsert = document.getElementById("btnInsert");
    const codeContainer = document.getElementById("generatedCodeContainer");
    const codeArea = document.getElementById("generatedCodeArea");

    // Get selected requirements
    const selectedReqs = this.getSelectedRequirements(dialog, requirements);

    if (selectedReqs.length === 0) {
      statusDiv.style.display = "block";
      statusDiv.textContent = "Please select at least one requirement";
      statusDiv.style.color = "#DD0033";
      return;
    }

    // Get generation type
    const genType = dialog.querySelector('input[name="genType"]:checked')?.value || "statemachine";

    // Get API config
    const apiConfig = this.checkApiConfig();
    if (!apiConfig.configured) {
      statusDiv.style.display = "block";
      statusDiv.textContent = apiConfig.message;
      statusDiv.style.color = "#DD0033";
      return;
    }

    // Disable generate button and show loading
    btnGenerate.classList.add("disabled");
    btnGenerate.textContent = "Generating...";
    statusDiv.style.display = "block";
    statusDiv.textContent = "Generating Umple code from requirements...";
    statusDiv.style.color = "#3383bb";

    try {
      const generation = (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.buildGeneration)
        ? RequirementsPromptBuilder.buildGeneration(selectedReqs, genType)
        : { prompt: this.buildPrompt(selectedReqs, genType), systemPrompt: this.SYSTEM_PROMPT, expectedRequirementIds: selectedReqs.map(r => r.id) };

      // Call AI API using centralized AiApi.chat()
      const response = await AiApi.chat(generation.prompt, generation.systemPrompt);

      // Extract Umple code
      let umpleCode = this.extractUmpleCode(response);

      // Validate + single repair pass
      if (typeof RequirementsPromptBuilder !== "undefined" && RequirementsPromptBuilder.validateGeneratedUmple && RequirementsPromptBuilder.buildRepairPrompt) {
        const validation = RequirementsPromptBuilder.validateGeneratedUmple({
          code: umpleCode,
          expectedRequirementIds: generation.expectedRequirementIds || [],
          generationType: genType
        });

        if (!validation.valid) {
          const repairPrompt = RequirementsPromptBuilder.buildRepairPrompt({
            generationType: genType,
            requirements: selectedReqs,
            invalidCode: umpleCode,
            errors: validation.errors
          });

          const repairedResponse = await AiApi.chat(repairPrompt, generation.systemPrompt);
          umpleCode = this.extractUmpleCode(repairedResponse);

          const repairedValidation = RequirementsPromptBuilder.validateGeneratedUmple({
            code: umpleCode,
            expectedRequirementIds: generation.expectedRequirementIds || [],
            generationType: genType
          });

          if (!repairedValidation.valid) {
            statusDiv.style.display = "block";
            statusDiv.textContent = `Generated code may be invalid:\n${repairedValidation.errors.join("\n")}`;
            statusDiv.style.color = "#DD0033";
          }
        }
      }

      // Display generated code
      codeArea.value = umpleCode;
      codeContainer.style.display = "block";
      btnInsert.style.display = "inline-block";

      if (statusDiv.style.color !== "#DD0033") {
        statusDiv.style.display = "block";
        statusDiv.textContent = "Code generated successfully! Review and click 'Insert to Editor' to add it to your model.";
        statusDiv.style.color = "#3383bb";
      }
    } catch (error) {
      console.error("Error generating code:", error);
      statusDiv.style.display = "block";
      statusDiv.textContent = `Error: ${error.message}`;
      statusDiv.style.color = "#DD0033";
    } finally {
      btnGenerate.classList.remove("disabled");
      btnGenerate.textContent = "Generate";
    }
  }
};

// Initialize when DOM is ready
if (typeof Page !== "undefined") {
  // Page object exists, we can add the button programmatically
  // This will be called from umple.php or after DOM loads
}
