// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Requirements Dialog - Dialog UI for requirements generation

const RequirementsDialog = {
  getRequirementsOutputArea(dialog = null) {
    if (dialog && typeof dialog.querySelector === "function") {
      return dialog.querySelector("#requirementsOutputArea");
    }
    return document.getElementById("requirementsOutputArea");
  },

  clearRequirementsOutput(dialog = null) {
    const area = this.getRequirementsOutputArea(dialog);
    if (area) area.value = "";
  },

  appendRequirementsOutput(line, dialog = null) {
    const area = this.getRequirementsOutputArea(dialog);
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
    this.renderTextWithLinks(textDiv, requirement.text);
    display.appendChild(textDiv);

    container.appendChild(display);
    if (requirement.implemented) {
      const note = document.createElement("div");
      note.className = "requirement-implemented-note";
      note.textContent = "This requirement already has an implementsReq in the model.";
      container.appendChild(note);
    }

    const modeDiv = document.createElement("div");
    modeDiv.className = "requirement-mode";
    modeDiv.appendChild(this.createModeRadio("all", " Implement This Requirement", true));
    container.appendChild(modeDiv);
    this.appendNewAndModifyModes(container, modeDiv, [requirement]);
    return container;
  },

  // No requirement yet: only a new one can be written (issue #2485)
  createNewOnlyUI(requirements) {
    const container = document.createElement("div");
    container.className = "requirement-selection";

    const heading = document.createElement("h4");
    heading.textContent = "New Requirement:";
    container.appendChild(heading);

    const modeDiv = document.createElement("div");
    modeDiv.className = "requirement-mode";
    modeDiv.style.display = "none";
    modeDiv.appendChild(this.createModeRadio("new", " New Requirement", true));
    container.appendChild(modeDiv);

    const form = this.createNewRequirementForm(requirements);
    form.style.display = "block";
    container.appendChild(form);
    return container;
  },

  createModeRadio(value, labelText, checked = false) {
    const label = document.createElement("label");
    const radio = document.createElement("input");
    radio.type = "radio";
    radio.name = "reqMode";
    radio.value = value;
    radio.checked = checked;
    label.appendChild(radio);
    label.appendChild(document.createTextNode(labelText));
    return label;
  },

  // "New" adds a requirement at the top of the model and implements it; "Modify" changes the
  // wording of an existing one and updates or creates its implementation (issue #2485)
  appendNewAndModifyModes(container, modeDiv, requirements) {
    modeDiv.appendChild(this.createModeRadio("new", " New Requirement (type it, it is added to the model and implemented)"));
    modeDiv.appendChild(this.createModeRadio("modify", " Modify a Requirement (change its wording, the AI updates the model)"));
    container.appendChild(this.createNewRequirementForm(requirements));
    container.appendChild(this.createModifyRequirementForm(requirements));
  },

  // The next free ID following the existing ones: R01, R02 -> R03; none -> R1
  nextRequirementId(requirements) {
    let prefix = null;
    let width = 1;
    let max = 0;
    requirements.forEach(r => {
      const match = /^(.*?)(\d+)$/.exec(r.id);
      if (!match || (prefix !== null && match[1] !== prefix)) return;
      prefix = match[1];
      width = Math.max(width, match[2].length);
      max = Math.max(max, parseInt(match[2], 10));
    });
    const ids = new Set(requirements.map(r => r.id));
    let n = max + 1;
    let id;
    do {
      id = (prefix === null ? "R" : prefix) + String(n).padStart(width, "0");
      n++;
    } while (ids.has(id));
    return id;
  },

  createNewRequirementForm(requirements) {
    const form = document.createElement("div");
    form.id = "newReqForm";
    form.className = "requirement-edit-form";
    form.style.display = "none";

    const idLabel = document.createElement("label");
    idLabel.textContent = "ID: ";
    const idInput = document.createElement("input");
    idInput.type = "text";
    idInput.id = "newReqId";
    idInput.value = this.nextRequirementId(requirements);
    idLabel.appendChild(idInput);
    form.appendChild(idLabel);

    const text = document.createElement("textarea");
    text.id = "newReqText";
    text.placeholder = "Describe the new requirement...";
    form.appendChild(text);

    const note = document.createElement("div");
    note.className = "requirement-implemented-note";
    note.textContent = "The requirement is added at the top of your model, then the AI implements it.";
    form.appendChild(note);
    return form;
  },

  createModifyRequirementForm(requirements) {
    const form = document.createElement("div");
    form.id = "modifyReqForm";
    form.className = "requirement-edit-form";
    form.style.display = "none";

    const select = document.createElement("select");
    select.id = "modifyReqId";
    requirements.forEach(req => {
      const option = document.createElement("option");
      option.value = req.id;
      option.textContent = req.implemented ? `${req.id} (implemented)` : req.id;
      select.appendChild(option);
    });
    form.appendChild(select);

    const text = document.createElement("textarea");
    text.id = "modifyReqText";
    text.value = requirements[0]?.text || "";
    form.appendChild(text);

    const note = document.createElement("div");
    note.id = "modifyReqNote";
    note.className = "requirement-implemented-note";
    note.textContent = this.describeModify(requirements[0]);
    form.appendChild(note);
    return form;
  },

  describeModify(requirement) {
    if (!requirement) return "";
    return requirement.implemented
      ? "Already implemented: the AI updates the model to match the new wording."
      : "Not implemented yet: the AI implements the new wording.";
  },

  // What the user asked for: {mode, requirements} for the selection modes, {mode, requirement,
  // previous} for "new" and "modify"
  getRequestedAction(dialog, requirements) {
    const mode = dialog.querySelector('input[name="reqMode"]:checked')?.value || "all";
    if (mode === "new") {
      const id = (dialog.querySelector("#newReqId")?.value || "").trim();
      const text = (dialog.querySelector("#newReqText")?.value || "").trim();
      return { mode, requirement: { id, text, implemented: false } };
    }
    if (mode === "modify") {
      const id = dialog.querySelector("#modifyReqId")?.value || "";
      const text = (dialog.querySelector("#modifyReqText")?.value || "").trim();
      const previous = requirements.find(r => r.id === id) || null;
      return { mode, requirement: { id, text, implemented: !!previous?.implemented }, previous };
    }
    return { mode, requirements: this.getSelectedRequirements(dialog, requirements) };
  },

  // An error message, or null when the requested action can run
  validateRequestedAction(action, requirements) {
    if (action.mode !== "new" && action.mode !== "modify") {
      return action.requirements.length === 0 ? "Please select at least one requirement" : null;
    }
    const { id, text } = action.requirement;
    if (!text) return "Please type the requirement";
    if (/[{}]/.test(text)) return "The requirement text cannot contain { or }";
    if (action.mode === "new") {
      if (!/^\w+(?:[-_]\w+)*$/.test(id)) return "Please give an ID made of letters, digits, - or _ (for example R4)";
      if (requirements.some(r => r.id === id)) return `A requirement with ID ${id} already exists`;
    } else if (action.previous && action.previous.text.trim() === text) {
      return "The wording has not changed";
    }
    return null;
  },

  // Requirements that no active implementsReq names yet (issue #2485)
  getUnimplementedRequirements(requirements) {
    return requirements.filter(r => !r.implemented);
  },

  describeMode(mode, requirements) {
    if (mode === "unimplemented") {
      return `Not yet implemented (${this.getUnimplementedRequirements(requirements).length} of ${requirements.length})`;
    }
    return `All requirements (${requirements.length})`;
  },

  createMultipleRequirementUI(requirements) {
    const container = document.createElement("div");
    container.className = "requirement-selection";

    const heading = document.createElement("h4");
    heading.textContent = "Select Requirements:";
    container.appendChild(heading);

    const modeDiv = document.createElement("div");
    modeDiv.className = "requirement-mode";

    const unimplementedCount = this.getUnimplementedRequirements(requirements).length;
    const someImplemented = unimplementedCount > 0 && unimplementedCount < requirements.length;

    const labelAll = document.createElement("label");
    const radioAll = document.createElement("input");
    radioAll.type = "radio";
    radioAll.name = "reqMode";
    radioAll.value = "all";
    radioAll.checked = !someImplemented;
    labelAll.appendChild(radioAll);
    labelAll.appendChild(document.createTextNode(" All Requirements (recommended for comprehensive generation)"));
    modeDiv.appendChild(labelAll);

    if (someImplemented) {
      const labelUnimplemented = document.createElement("label");
      const radioUnimplemented = document.createElement("input");
      radioUnimplemented.type = "radio";
      radioUnimplemented.name = "reqMode";
      radioUnimplemented.value = "unimplemented";
      radioUnimplemented.checked = true;
      labelUnimplemented.appendChild(radioUnimplemented);
      labelUnimplemented.appendChild(document.createTextNode(
        ` Only Requirements Not Yet Implemented (${unimplementedCount}, no implementsReq in the model)`));
      modeDiv.appendChild(labelUnimplemented);
    }

    const labelMultiple = document.createElement("label");
    const radioMultiple = document.createElement("input");
    radioMultiple.type = "radio";
    radioMultiple.name = "reqMode";
    radioMultiple.value = "multiple";
    labelMultiple.appendChild(radioMultiple);
    labelMultiple.appendChild(document.createTextNode(" Select Specific Requirements"));
    modeDiv.appendChild(labelMultiple);

    container.appendChild(modeDiv);
    this.appendNewAndModifyModes(container, modeDiv, requirements);

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
      const linkifiedNode = document.createElement("span");
      span.appendChild(linkifiedNode);
      if(req.text.length <= 100) {
        this.renderTextWithLinks(linkifiedNode,`: ${summaryText}`);
      }
      else {
        linkifiedNode.appendChild(document.createTextNode(`: ${summaryText}`));
      }
      if (req.implemented) {
        const tag = document.createElement("em");
        tag.className = "requirement-implemented-tag";
        tag.textContent = " (implemented)";
        span.appendChild(tag);
      }
      label.appendChild(span);

      multipleDiv.appendChild(label);
    });

    container.appendChild(multipleDiv);

    const displayDiv = document.createElement("div");
    displayDiv.id = "selectedReqDisplay";
    displayDiv.className = "selected-req-display";

    const strong = document.createElement("strong");
    strong.textContent = "Selected Requirements:";
    displayDiv.appendChild(strong);

    const selectedText = document.createElement("div");
    selectedText.id = "selectedReqText";
    selectedText.textContent = this.describeMode(someImplemented ? "unimplemented" : "all", requirements);
    displayDiv.appendChild(selectedText);

    container.appendChild(displayDiv);
    return container;
  },

  renderTextWithLinks(container, text) {
    // Clear safely
    container.textContent = "";

    if (!text) return;

    // Basic http/https URL matcher
    const urlRegex = /(https?:\/\/[^\s<>"')\]]+)/g;

    let lastIndex = 0;
    let match;

    while ((match = urlRegex.exec(text)) !== null) {
      const url = match[0];
      const start = match.index;

      // Text before the URL
      if (start > lastIndex) {
        container.appendChild(document.createTextNode(text.slice(lastIndex, start)));
      }

      // The URL as a link
      const a = document.createElement("a");
      a.href = url;
      a.textContent = url;
      a.target = "_blank";
      a.rel = "noopener noreferrer";
      container.appendChild(a);

      lastIndex = start + url.length;
    }

    // Remaining text
    if (lastIndex < text.length) {
      container.appendChild(document.createTextNode(text.slice(lastIndex)));
    }
  },

  updateSelectedDisplay(dialog, requirements) {
    const displayDiv = dialog.querySelector("#selectedReqText");
    if (!displayDiv) return;
    const checkboxes = dialog.querySelectorAll(".req-checkbox:checked");
    const selectedIds = Array.from(checkboxes).map(cb => cb.value);

    if (selectedIds.length === 0) {
      this.renderTextWithLinks(displayDiv, "No requirements selected");
    } else {
      const selectedReqs = requirements.filter(r => selectedIds.includes(r.id));
      const content = selectedReqs.map(r => `${r.id}: ${r.text}`).join("\n\n");
      this.renderTextWithLinks(displayDiv, content);
    }
  },

  getSelectedRequirements(dialog, requirements) {
    const mode = dialog.querySelector('input[name="reqMode"]:checked')?.value || "all";

    if (mode === "all") {
      return requirements;
    } else if (mode === "unimplemented") {
      return this.getUnimplementedRequirements(requirements);
    } else if (mode === "new" || mode === "modify") {
      const action = this.getRequestedAction(dialog, requirements);
      return action.requirement.text ? [action.requirement] : [];
    } else {
      const checkboxes = dialog.querySelectorAll(".req-checkbox:checked");
      const selectedIds = Array.from(checkboxes).map(cb => cb.value);
      return requirements.filter(r => selectedIds.includes(r.id));
    }
  },

  createDialog(requirements) {
    const existingDialog = document.getElementById("aiRequirementsDialog");
    if (existingDialog) {
      existingDialog.remove();
    }

    const dialog = document.createElement("div");
    dialog.id = "aiRequirementsDialog";
    dialog.className = "ai-requirements-dialog";

    const overlay = document.createElement("div");
    overlay.className = "dialog-overlay";
    dialog.appendChild(overlay);

    const content = document.createElement("div");
    content.className = "dialog-content";

    const title = document.createElement("h3");
    title.textContent = "Generate from Requirements";
    content.appendChild(title);

    const requirementSelection = requirements.length === 0
      ? this.createNewOnlyUI(requirements)
      : requirements.length === 1
        ? this.createSingleRequirementUI(requirements[0])
        : this.createMultipleRequirementUI(requirements);
    content.appendChild(requirementSelection);

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

    // Further Umple features the AI may generate (issue #2485)
    const optionsHeading = document.createElement("h4");
    optionsHeading.textContent = "Also Generate:";
    genTypeDiv.appendChild(optionsHeading);
    [["optMethods", " Methods implied by the requirements"], ["optMain", " A main method that demonstrates the model"]].forEach(([id, text]) => {
      const label = document.createElement("label");
      const checkbox = document.createElement("input");
      checkbox.type = "checkbox";
      checkbox.id = id;
      label.appendChild(checkbox);
      label.appendChild(document.createTextNode(text));
      genTypeDiv.appendChild(label);
    });

    content.appendChild(genTypeDiv);

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
    btnCancel.id = "btnCancelRequirements";
    btnCancel.className = "jQuery-palette-button unselectable ui-button ui-corner-all ui-widget";
    btnCancel.tabIndex = 0;
    btnCancel.setAttribute("role", "button");
    btnCancel.textContent = "Cancel";
    buttonsDiv.appendChild(btnCancel);

    const statusDiv = document.createElement("div");
    statusDiv.id = "statusMessage";
    statusDiv.className = "status-message";
    statusDiv.style.display = "none";
    content.appendChild(statusDiv);

    content.appendChild(buttonsDiv);

    dialog.appendChild(content);
    document.body.appendChild(dialog);

    return dialog;
  },

  getGenerationOptions(dialog) {
    return {
      includeMethods: !!dialog.querySelector("#optMethods")?.checked,
      includeMain: !!dialog.querySelector("#optMain")?.checked
    };
  },

  setupDialogEvents(dialog, requirements, callbacks) {
    const modeRadios = dialog.querySelectorAll('input[name="reqMode"]');
    modeRadios.forEach(radio => {
      radio.addEventListener("change", e => {
        const mode = e.target.value;
        const multipleDiv = dialog.querySelector("#multipleReqSelection");
        const displayDiv = dialog.querySelector("#selectedReqText");
        const newForm = dialog.querySelector("#newReqForm");
        const modifyForm = dialog.querySelector("#modifyReqForm");
        const selectedDisplay = dialog.querySelector("#selectedReqDisplay");

        if (newForm) newForm.style.display = mode === "new" ? "block" : "none";
        if (modifyForm) modifyForm.style.display = mode === "modify" ? "block" : "none";
        if (selectedDisplay) selectedDisplay.style.display = mode === "new" || mode === "modify" ? "none" : "block";
        if (mode === "new" || mode === "modify") {
          if (multipleDiv) multipleDiv.style.display = "none";
          return;
        }

        if (!multipleDiv || !displayDiv) return;

        if (mode === "all" || mode === "unimplemented") {
          multipleDiv.style.display = "none";
          this.renderTextWithLinks(displayDiv, this.describeMode(mode, requirements));
        } else if (mode === "multiple") {
          multipleDiv.style.display = "block";
          this.updateSelectedDisplay(dialog, requirements);
        }
      });
    });

    const modifySelect = dialog.querySelector("#modifyReqId");
    if (modifySelect) {
      modifySelect.addEventListener("change", () => {
        const req = requirements.find(r => r.id === modifySelect.value);
        const text = dialog.querySelector("#modifyReqText");
        const note = dialog.querySelector("#modifyReqNote");
        if (text) text.value = req?.text || "";
        if (note) note.textContent = this.describeModify(req);
      });
    }

    const checkboxes = dialog.querySelectorAll(".req-checkbox");
    checkboxes.forEach(checkbox => {
      checkbox.addEventListener("change", () => {
        this.updateSelectedDisplay(dialog, requirements);
      });
    });

    const btnGenerate = dialog.querySelector("#btnGenerate");
    const generateHandler = event => {
      event.preventDefault();
      if (callbacks.onGenerate) callbacks.onGenerate();
    };
    btnGenerate.addEventListener("click", generateHandler);
    btnGenerate.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") generateHandler(event);
    });

    const btnStop = dialog.querySelector("#btnStop");
    const stopHandler = event => {
      event.preventDefault();
      if (callbacks.onStop) callbacks.onStop();
    };
    btnStop.addEventListener("click", stopHandler);
    btnStop.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") stopHandler(event);
    });

    const btnInsert = dialog.querySelector("#btnInsert");
    const insertHandler = event => {
      event.preventDefault();
      if (callbacks.onInsert) callbacks.onInsert();
    };
    btnInsert.addEventListener("click", insertHandler);
    btnInsert.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") insertHandler(event);
    });

    const btnCancel = dialog.querySelector("#btnCancelRequirements");
    const cancelHandler = event => {
      event.preventDefault();
      if (callbacks.onCancel) callbacks.onCancel();
    };
    btnCancel.addEventListener("click", cancelHandler);
    btnCancel.addEventListener("keypress", event => {
      if (event.key === "Enter" || event.key === " ") cancelHandler(event);
    });

    const overlay = dialog.querySelector(".dialog-overlay");
    overlay.addEventListener("click", () => {
      if (callbacks.onCancel) callbacks.onCancel();
    });
  }
};
