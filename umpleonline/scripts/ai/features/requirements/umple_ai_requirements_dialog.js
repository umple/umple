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
    textDiv.textContent = requirement.text;
    display.appendChild(textDiv);

    container.appendChild(display);
    return container;
  },

  createMultipleRequirementUI(requirements) {
    const container = document.createElement("div");
    container.className = "requirement-selection";

    const heading = document.createElement("h4");
    heading.textContent = "Select Requirements:";
    container.appendChild(heading);

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

  updateSelectedDisplay(dialog, requirements) {
    const displayDiv = dialog.querySelector("#selectedReqText");
    if (!displayDiv) return;
    const checkboxes = dialog.querySelectorAll(".req-checkbox:checked");
    const selectedIds = Array.from(checkboxes).map(cb => cb.value);

    if (selectedIds.length === 0) {
      displayDiv.textContent = "No requirements selected";
    } else {
      const selectedReqs = requirements.filter(r => selectedIds.includes(r.id));
      displayDiv.textContent = selectedReqs.map(r => `${r.id}: ${r.text}`).join("\n\n");
    }
  },

  getSelectedRequirements(dialog, requirements) {
    const mode = dialog.querySelector('input[name="reqMode"]:checked')?.value || "all";

    if (mode === "all") {
      return requirements;
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

    const requirementSelection = requirements.length === 1
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

  setupDialogEvents(dialog, requirements, callbacks) {
    const modeRadios = dialog.querySelectorAll('input[name="reqMode"]');
    modeRadios.forEach(radio => {
      radio.addEventListener("change", e => {
        const mode = e.target.value;
        const multipleDiv = dialog.querySelector("#multipleReqSelection");
        const displayDiv = dialog.querySelector("#selectedReqText");

        if (!multipleDiv || !displayDiv) return;

        if (mode === "all") {
          multipleDiv.style.display = "none";
          displayDiv.textContent = `All requirements (${requirements.length})`;
        } else if (mode === "multiple") {
          multipleDiv.style.display = "block";
          this.updateSelectedDisplay(dialog, requirements);
        }
      });
    });

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
