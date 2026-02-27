
Action.gvGetClassCode = function(className) {
  const orig = Page.codeMirrorEditor6.state.doc.toString();
  const parts = Action.splitStates(orig);
  for (let i = 0; i < parts.length; i++) {
    const p = parts[i];
    if (
      p.startsWith("class " + className + "{") ||
      p.startsWith("class " + className + " ") ||
      p.startsWith("class " + className + "\n")
    ) {
      return p;
    }
  }
  return null;
};


Action.gvDeleteIfToolActive = function(domEvent, nodeEl) {
  if (!Page.useGvClassDiagram) return false;
  if (!Action.diagramInSync) return false;
  if (Page.selectedItem !== "DeleteEntity") return false;

  domEvent.preventDefault();
  domEvent.stopPropagation();
  if (domEvent.stopImmediatePropagation) domEvent.stopImmediatePropagation();

  const className = Action.getGvClassNameFromNode(nodeEl);
  if (!className) return true;

  // Get the class block
  const classCode = Action.gvGetClassCode(className);
  if (!classCode) {
    Page.setFeedbackMessage("Couldn't find class block for " + className + " in editor text.");
    return true;
  }

  const jsInput = classCode.replaceAll("\n","&#10").replaceAll("\"","&#$quot");
  Action.deleteClass(jsInput, className);

  // Refresh diagram
  setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.setFeedbackMessage("Deleted class: " + className);
  return true;
};

// Find the full text range of a class block "class X { ... }"
// Returns { start, end, block } where end is index AFTER the closing brace.
Action.findClassBlockRange = function(text, className) {
  const headerRe = new RegExp("\\bclass\\s+" + className + "\\b");
  const m = headerRe.exec(text);
  if (!m) return null;

  // Find the first '{' after the class header
  const open = text.indexOf("{", m.index);
  if (open === -1) return null;

  // Brace match
  let depth = 0;
  for (let i = open; i < text.length; i++) {
    const ch = text[i];
    if (ch === "{") depth++;
    else if (ch === "}") {
      depth--;
      if (depth === 0) {
        return {
          start: m.index,
          end: i + 1,
          block: text.substring(m.index, i + 1)
        };
      }
    }
  }
  return null;
};

// Insert association line before the last '}' of the source class block.
Action.insertAssociationIntoSourceClass = function(fullText, sourceClass, targetClass) {
  const range = Action.findClassBlockRange(fullText, sourceClass);
  if (!range) return null;

  const block = range.block;
  const lastBrace = block.lastIndexOf("}");
  if (lastBrace === -1) return null;

  let assocLine;
  if (sourceClass === targetClass) {
    assocLine = "  * -- * " + targetClass + " roleName;\n";
  } else {
    assocLine = "  * -- * " + targetClass + ";\n";
  }

  // Avoid duplicate exact line
  if (block.includes(assocLine.trim())) {
    return fullText;
  }

  const newBlock =
    block.substring(0, lastBrace) +
    assocLine +
    block.substring(lastBrace);

  return fullText.substring(0, range.start) + newBlock + fullText.substring(range.end);
};

Action.gvAssocSourceClass = null;

Action.gvHandlePaletteAssociation = function(domEvent, nodeEl) {
  if (!Page.useGvClassDiagram) return false;
  if (!Action.diagramInSync) return false;
  if (Page.selectedItem !== "AddAssociation") return false;

  domEvent.preventDefault();
  domEvent.stopPropagation();
  if (domEvent.stopImmediatePropagation) domEvent.stopImmediatePropagation();

  const clickedClass = Action.getGvClassNameFromNode(nodeEl);
  if (!clickedClass) return true;

  // First click: set source
  if (Action.gvAssocSourceClass == null) {
    Action.gvAssocSourceClass = clickedClass;
    Action.selectClass(clickedClass);
    Page.setFeedbackMessage("Association: select target class for " + clickedClass);
    return true;
  }

  // Second click: commit association
  const source = Action.gvAssocSourceClass;
  const target = clickedClass;
  Action.gvAssocSourceClass = null;

  const before = Page.codeMirrorEditor6.state.doc.toString();
  const after = Action.insertAssociationIntoSourceClass(before, source, target);

  if (after == null) {
    Page.setFeedbackMessage("Couldn't find class block for " + source + " in editor text.");
    return true;
  }

  // Update editor
  Page.codeMirrorEditor6.dispatch({
    changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: after }
  });

  // Refresh diagram + history
  setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
  TabControl.getCurrentHistory().save(after, "menuUpdate");

  if (!Page.repeatToolItem) Page.unselectAllToggleTools();

  Page.setFeedbackMessage("Association added: " + source + " -> " + target);
  return true;
};

// Insert "isA Parent;" before the last '}' of the child class block.
Action.insertGeneralizationIntoChildClass = function(fullText, childClass, parentClass) {
  const range = Action.findClassBlockRange(fullText, childClass);
  if (!range) return null;

  const block = range.block;
  const lastBrace = block.lastIndexOf("}");
  if (lastBrace === -1) return null;

  // If isA already exists, append parent if not present; else create new isA line.
  const isALineRe = /^\s*isA\s+([^;]+);/m;
  const m = block.match(isALineRe);

  if (m) {
    const existing = m[1]
      .split(",")
      .map(s => s.trim())
      .filter(Boolean);

    if (existing.includes(parentClass)) return fullText;

    const updatedParents = existing.concat([parentClass]).join(", ");
    const newBlock = block.replace(isALineRe, "  isA " + updatedParents + ";");
    return fullText.substring(0, range.start) + newBlock + fullText.substring(range.end);
  } else {
    const genLine = "  isA " + parentClass + ";\n";
    const newBlock = block.substring(0, lastBrace) + genLine + block.substring(lastBrace);
    return fullText.substring(0, range.start) + newBlock + fullText.substring(range.end);
  }
};

Action.gvGenChildClass = null;

Action.gvHandlePaletteGeneralization = function(domEvent, nodeEl) {
  if (!Page.useGvClassDiagram) return false;
  if (!Action.diagramInSync) return false;
  if (Page.selectedItem !== "AddGeneralization") return false;

  domEvent.preventDefault();
  domEvent.stopPropagation();
  if (domEvent.stopImmediatePropagation) domEvent.stopImmediatePropagation();

  const clickedClass = Action.getGvClassNameFromNode(nodeEl);
  if (!clickedClass) return true;

  // First click: choose CHILD
  if (Action.gvGenChildClass == null) {
    Action.gvGenChildClass = clickedClass;
    Action.selectClass(clickedClass);
    Page.setFeedbackMessage("Generalization: select parent class for " + clickedClass);
    return true;
  }

  // Second click: choose PARENT
  const child = Action.gvGenChildClass;
  const parent = clickedClass;
  Action.gvGenChildClass = null;

  // Prevent generalization to self
  if (child === parent) {
    Page.setFeedbackMessage("Generalization cancelled (same class). Pick a different parent.");
    return true;
  }

  const before = Page.codeMirrorEditor6.state.doc.toString();
  const after = Action.insertGeneralizationIntoChildClass(before, child, parent);

  if (after == null) {
    Page.setFeedbackMessage("Couldn't find class block for " + child + " in editor text.");
    return true;
  }

  Page.codeMirrorEditor6.dispatch({
    changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: after }
  });

  setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
  TabControl.getCurrentHistory().save(after, "menuUpdate");

  if (!Page.repeatToolItem) Page.unselectAllToggleTools();

  Page.setFeedbackMessage("Generalization added: " + child + " isA " + parent);
  return true;
};