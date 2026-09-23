if (typeof window.GvDiagramEdit === "undefined") {
  window.GvDiagramEdit = {};
}

GvDiagramEdit.state = GvDiagramEdit.state || {
  assocSourceClass: null,
  genChildClass: null
};

GvDiagramEdit.dragCreate = GvDiagramEdit.dragCreate || {
  active: false,
  sourceNodeEl: null,
  sourceClassName: null,
  startX: 0,
  startY: 0,
  dragging: false,
  threshold: 6,
  mode: null // "association" | "generalization"
};

GvDiagramEdit.getFullText = function() {
  return Page.codeMirrorEditor6.state.doc.toString();
};

GvDiagramEdit.replaceFullText = function(newText) {
  Page.codeMirrorEditor6.dispatch({
    changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: newText }
  });
};

GvDiagramEdit.clearPendingPaletteState = function() {
  GvDiagramEdit.state.transitionSource = null;
  if (GvDiagramEdit.statePicker) {
    GvDiagramEdit.statePicker.remove();
    GvDiagramEdit.statePicker = null;
  }
  GvDiagramEdit.state.assocSourceClass = null;
  GvDiagramEdit.state.genChildClass = null;

  if (GvDiagramEdit.rubberBand && GvDiagramEdit.rubberBand.isActive()) {
    GvDiagramEdit.rubberBand.cancel();
  }

  if (GvDiagramEdit.dragCreate) {
    GvDiagramEdit.resetDragCreate();
  }
};

GvDiagramEdit.resetDragCreate = function() {
  const s = GvDiagramEdit.dragCreate;
  s.active = false;
  s.sourceNodeEl = null;
  s.sourceClassName = null;
  s.startX = 0;
  s.startY = 0;
  s.dragging = false;
  s.mode = null;
};

GvDiagramEdit.cancelDragCreate = function() {
  if (GvDiagramEdit.rubberBand && GvDiagramEdit.rubberBand.isActive()) {
    GvDiagramEdit.rubberBand.cancel();
  }
  GvDiagramEdit.resetDragCreate();
};

GvDiagramEdit.beginPossibleDragCreate = function(domEvent, nodeEl, mode) {
  if (Page.readOnly || (mode === "transition" ? !Page.useGvStateDiagram : !Page.useGvClassDiagram)) return false;
  if (!Action.diagramInSync) return false;
  if (mode === "transition" && Page.selectedItem !== "AddTransition") return false;
  if (mode === "association" && Page.selectedItem !== "AddAssociation") return false;
  if (mode === "generalization" && Page.selectedItem !== "AddGeneralization") return false;

  const className = mode === "transition" ? GvDiagramEdit.getStateIdentifier(nodeEl) : Action.getGvClassNameFromNode(nodeEl);
  if (!className) return false;

  const s = GvDiagramEdit.dragCreate;
  s.active = true;
  s.sourceNodeEl = nodeEl;
  s.sourceClassName = className;
  s.startX = domEvent.clientX;
  s.startY = domEvent.clientY;
  s.dragging = false;
  s.mode = mode;

  return true;
};

GvDiagramEdit.maybeActivateDragCreate = function(moveEvent) {
  const s = GvDiagramEdit.dragCreate;
  if (!s.active || s.dragging || !s.sourceNodeEl || !s.sourceClassName || !s.mode) return;

  const dx = moveEvent.clientX - s.startX;
  const dy = moveEvent.clientY - s.startY;
  const dist = Math.sqrt(dx * dx + dy * dy);

  if (dist < s.threshold) return;

  s.dragging = true;

  if (s.mode === "transition") {
    GvDiagramEdit.state.transitionSource = s.sourceClassName;
    GvDiagramEdit.selectState(s.sourceClassName);
    GvDiagramEdit.rubberBand.start(s.sourceNodeEl, "transition", moveEvent);
    Page.setFeedbackMessage("Transition: drag to the target state.");
  } else if (s.mode === "association") {
    GvDiagramEdit.state.assocSourceClass = s.sourceClassName;
    Action.selectClass(s.sourceClassName);
    GvDiagramEdit.rubberBand.start(s.sourceNodeEl, "association", moveEvent);
    Page.setFeedbackMessage("Association: drag to target class for " + s.sourceClassName);
  } else if (s.mode === "generalization") {
    GvDiagramEdit.state.genChildClass = s.sourceClassName;
    Action.selectClass(s.sourceClassName);
    GvDiagramEdit.rubberBand.start(s.sourceNodeEl, "generalization", moveEvent);
    Page.setFeedbackMessage("Generalization: drag to parent class for " + s.sourceClassName);
  }
};

GvDiagramEdit.finishDragCreateOnNode = function(domEvent, nodeEl) {
  const s = GvDiagramEdit.dragCreate;
  if (!s.active) return false;

  const wasDragging = s.dragging;
  const mode = s.mode;
  const sourceClass = s.sourceClassName;
  const targetClass = mode === "transition" ? GvDiagramEdit.getStateIdentifier(nodeEl) : Action.getGvClassNameFromNode(nodeEl);

  GvDiagramEdit.resetDragCreate();

  if (!wasDragging) return false;
  if (!sourceClass || !targetClass) {
    GvDiagramEdit.clearPendingPaletteState();
    return true;
  }

  if (mode === "transition") {
    GvDiagramEdit.commitTransition(sourceClass, targetClass);
    return true;
  }

  if (mode === "association") {
    GvDiagramEdit.state.assocSourceClass = null;
    GvDiagramEdit.rubberBand.finish();

    const before = GvDiagramEdit.getFullText();
    const after = GvDiagramEdit.insertAssociationIntoSourceClass(before, sourceClass, targetClass);

    if (after == null) {
      Page.setFeedbackMessage("Couldn't find class block for " + sourceClass + " in editor text.");
      return true;
    }

    GvDiagramEdit.replaceFullText(after);
    GvDiagramEdit.refreshDiagram();

    if (!Page.repeatToolItem) Page.unselectAllToggleTools();
    Page.setFeedbackMessage("Association added: " + sourceClass + " -> " + targetClass);
    return true;
  }

  if (mode === "generalization") {
    GvDiagramEdit.state.genChildClass = null;
    GvDiagramEdit.rubberBand.finish();

    if (sourceClass === targetClass) {
      Page.setFeedbackMessage("Generalization cancelled (same class). Pick a different parent.");
      return true;
    }

    const before = GvDiagramEdit.getFullText();
    const after = GvDiagramEdit.insertGeneralizationIntoChildClass(before, sourceClass, targetClass);

    if (after == null) {
      Page.setFeedbackMessage("Couldn't find class block for " + sourceClass + " in editor text.");
      return true;
    }

    GvDiagramEdit.replaceFullText(after);
    GvDiagramEdit.refreshDiagram();

    if (!Page.repeatToolItem) Page.unselectAllToggleTools();
    Page.setFeedbackMessage("Generalization added: " + sourceClass + " isA " + targetClass);
    return true;
  }

  return false;
};

GvDiagramEdit.handleDocumentMouseUpForCreateDrag = function(domEvent) {
  const s = GvDiagramEdit.dragCreate;
  if (!s.active) return;

  // If mouseup happened on a class node, let that node's own mouseup handler finish the drag-create first.
  const releasedOnNode =
    domEvent.target &&
    typeof domEvent.target.closest === "function" &&
    domEvent.target.closest(s.mode === "transition" ? "#umpleCanvas .node, #umpleCanvas .cluster" : "#umpleCanvas .node");

  if (releasedOnNode && (s.mode !== "transition" || GvDiagramEdit.getStateIdentifier(releasedOnNode))) return;

  // Mouse was released somewhere else (empty canvas / outside canvas), so cancel the in-progress drag-create cleanly.
  if (s.dragging) {
    GvDiagramEdit.clearPendingPaletteState();
    return;
  }

  GvDiagramEdit.resetDragCreate();
};

GvDiagramEdit.installCreateDragListeners = function() {
  if (GvDiagramEdit._createDragListenersInstalled) return;
  GvDiagramEdit._createDragListenersInstalled = true;

  document.addEventListener("mousemove", function(event) {
    GvDiagramEdit.maybeActivateDragCreate(event);
  }, true);

  document.addEventListener("mouseup", function(event) {
    GvDiagramEdit.handleDocumentMouseUpForCreateDrag(event);
  });
};

GvDiagramEdit.refreshDiagram = function() {
  GvDiagramEdit.clearPendingPaletteState();
  setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
};

GvDiagramEdit.getClassCode = function(className) {
  const orig = GvDiagramEdit.getFullText();
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

GvDiagramEdit.findClassBlockRange = function(text, className) {
  const headerRe = new RegExp("\\bclass\\s+" + className + "\\b");
  const m = headerRe.exec(text);
  if (!m) return null;

  const open = text.indexOf("{", m.index);
  if (open === -1) return null;

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

GvDiagramEdit.insertAssociationIntoSourceClass = function(fullText, sourceClass, targetClass) {
  const range = GvDiagramEdit.findClassBlockRange(fullText, sourceClass);
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

  if (block.includes(assocLine.trim())) return fullText;

  const newBlock = block.substring(0, lastBrace) + assocLine + block.substring(lastBrace);
  return fullText.substring(0, range.start) + newBlock + fullText.substring(range.end);
};

GvDiagramEdit.insertGeneralizationIntoChildClass = function(fullText, childClass, parentClass) {
  const range = GvDiagramEdit.findClassBlockRange(fullText, childClass);
  if (!range) return null;

  const block = range.block;
  const lastBrace = block.lastIndexOf("}");
  if (lastBrace === -1) return null;

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

GvDiagramEdit.deleteIfToolActive = function(domEvent, nodeEl) {
  if (!Page.useGvClassDiagram) return false;
  if (!Action.diagramInSync) return false;
  if (Page.selectedItem !== "DeleteEntity") return false;

  domEvent.preventDefault();
  domEvent.stopPropagation();
  if (domEvent.stopImmediatePropagation) domEvent.stopImmediatePropagation();

  const className = Action.getGvClassNameFromNode(nodeEl);
  if (!className) return true;

  const classCode = GvDiagramEdit.getClassCode(className);
  if (!classCode) {
    Page.setFeedbackMessage("Couldn't find class block for " + className + " in editor text.");
    return true;
  }

  const jsInput = classCode.replaceAll("\n","&#10").replaceAll("\"","&#$quot");
  Action.deleteClass(jsInput, className);

  GvDiagramEdit.refreshDiagram();

  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.setFeedbackMessage("Deleted class: " + className);
  return true;
};

GvDiagramEdit.handlePaletteAssociation = function(domEvent, nodeEl) {
  if (!Page.useGvClassDiagram) return false;
  if (!Action.diagramInSync) return false;
  if (Page.selectedItem !== "AddAssociation") return false;

  domEvent.preventDefault();
  domEvent.stopPropagation();
  if (domEvent.stopImmediatePropagation) domEvent.stopImmediatePropagation();

  const clickedClass = Action.getGvClassNameFromNode(nodeEl);
  if (!clickedClass) return true;

  // First click
  if (GvDiagramEdit.state.assocSourceClass == null) {
    GvDiagramEdit.state.assocSourceClass = clickedClass;
    Action.selectClass(clickedClass);

    // start rubber band from the clicked node
    GvDiagramEdit.rubberBand.start(nodeEl, "association", domEvent);

    Page.setFeedbackMessage("Association: select target class for " + clickedClass);
    return true;
  }

  // Second click (commit)
  const source = GvDiagramEdit.state.assocSourceClass;
  const target = clickedClass;
  GvDiagramEdit.state.assocSourceClass = null;

  // stop rubber band now that we’re committing
  GvDiagramEdit.rubberBand.finish();

  const before = GvDiagramEdit.getFullText();
  const after = GvDiagramEdit.insertAssociationIntoSourceClass(before, source, target);

  if (after == null) {
    Page.setFeedbackMessage("Couldn't find class block for " + source + " in editor text.");
    return true;
  }

  GvDiagramEdit.replaceFullText(after);
  GvDiagramEdit.refreshDiagram();

  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.setFeedbackMessage("Association added: " + source + " -> " + target);
  return true;
};

GvDiagramEdit.handlePaletteGeneralization = function(domEvent, nodeEl) {
  if (!Page.useGvClassDiagram) return false;
  if (!Action.diagramInSync) return false;
  if (Page.selectedItem !== "AddGeneralization") return false;

  domEvent.preventDefault();
  domEvent.stopPropagation();
  if (domEvent.stopImmediatePropagation) domEvent.stopImmediatePropagation();

  const clickedClass = Action.getGvClassNameFromNode(nodeEl);
  if (!clickedClass) return true;

  // First click
  if (GvDiagramEdit.state.genChildClass == null) {
    GvDiagramEdit.state.genChildClass = clickedClass;
    Action.selectClass(clickedClass);

    GvDiagramEdit.rubberBand.start(nodeEl, "generalization", domEvent);

    Page.setFeedbackMessage("Generalization: select parent class for " + clickedClass);
    return true;
  }

  // Second click (commit)
  const child = GvDiagramEdit.state.genChildClass;
  const parent = clickedClass;
  GvDiagramEdit.state.genChildClass = null;

  GvDiagramEdit.rubberBand.finish();

  if (child === parent) {
    Page.setFeedbackMessage("Generalization cancelled (same class). Pick a different parent.");
    return true;
  }

  const before = GvDiagramEdit.getFullText();
  const after = GvDiagramEdit.insertGeneralizationIntoChildClass(before, child, parent);

  if (after == null) {
    Page.setFeedbackMessage("Couldn't find class block for " + child + " in editor text.");
    return true;
  }

  GvDiagramEdit.replaceFullText(after);
  GvDiagramEdit.refreshDiagram();

  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.setFeedbackMessage("Generalization added: " + child + " isA " + parent);
  return true;
};

/**
 * Bind all Graphviz class-diagram interactions (nodes + edges).
 */
GvDiagramEdit.bindClassDiagram = function(canvasX, canvasY) {
  // If gv class mode is gvmanual then we need to allow node movement, otherwise do not
  let allowNodeMovement = true;
  if (!Page.isGvManual()) {
    allowNodeMovement = false;
  }

  GvDiagramEdit.installCreateDragListeners();

  const elems = document.getElementsByClassName("node");

  for (let i = 0; i < elems.length; i++) {
    const theNode = elems[i];

    // ---- context menu + double click menu (keep as-is) ----
    theNode.addEventListener("contextmenu", function(event) {
      event.preventDefault();
      Action.displayMenu(event);
    });

    theNode.addEventListener("dblclick", function(event) {
      event.preventDefault();
      Action.displayMenu(event);
    });

    // ---- Delete tool in GV mode ----
    if (theNode.__gvDeleteDown) {
      theNode.removeEventListener("mousedown", theNode.__gvDeleteDown, true);
    }
    theNode.__gvDeleteDown = function(e) {
      if (GvDiagramEdit.deleteIfToolActive(e, theNode)) return;
    };
    theNode.addEventListener("mousedown", theNode.__gvDeleteDown, true);

    // ---- Association tool in GV mode ----
    if (theNode.__gvAssocDown) {
      theNode.removeEventListener("mousedown", theNode.__gvAssocDown, true);
    }
    theNode.__gvAssocDown = function(e) {
      if (!Page.useGvClassDiagram) return;
      if (!Action.diagramInSync) return;
      if (Page.selectedItem !== "AddAssociation") return;

      e.preventDefault();
      e.stopPropagation();
      if (e.stopImmediatePropagation) e.stopImmediatePropagation();

      GvDiagramEdit.beginPossibleDragCreate(e, theNode, "association");
    };
    theNode.addEventListener("mousedown", theNode.__gvAssocDown, true);

    // ---- Generalization tool in GV mode ----
    if (theNode.__gvGenDown) {
      theNode.removeEventListener("mousedown", theNode.__gvGenDown, true);
    }
    theNode.__gvGenDown = function(e) {
      if (!Page.useGvClassDiagram) return;
      if (!Action.diagramInSync) return;
      if (Page.selectedItem !== "AddGeneralization") return;

      e.preventDefault();
      e.stopPropagation();
      if (e.stopImmediatePropagation) e.stopImmediatePropagation();

      GvDiagramEdit.beginPossibleDragCreate(e, theNode, "generalization");
    };
    theNode.addEventListener("mousedown", theNode.__gvGenDown, true);

    // ---- Association tool mouseup in GV mode ----
    if (theNode.__gvAssocUp) {
      theNode.removeEventListener("mouseup", theNode.__gvAssocUp, true);
    }
    theNode.__gvAssocUp = function(e) {
      if (!Page.useGvClassDiagram) return;
      if (!Action.diagramInSync) return;
      if (Page.selectedItem !== "AddAssociation") return;

      e.preventDefault();
      e.stopPropagation();
      if (e.stopImmediatePropagation) e.stopImmediatePropagation();

      // If this was a drag-release, commit now and stop.
      if (GvDiagramEdit.finishDragCreateOnNode(e, theNode)) return;

      // Otherwise this was a click-release, so preserve the two-click flow.
      GvDiagramEdit.handlePaletteAssociation(e, theNode);
    };
    theNode.addEventListener("mouseup", theNode.__gvAssocUp, true);

    // ---- Generalization tool mouseup in GV mode ----
    if (theNode.__gvGenUp) {
      theNode.removeEventListener("mouseup", theNode.__gvGenUp, true);
    }
    theNode.__gvGenUp = function(e) {
      if (!Page.useGvClassDiagram) return;
      if (!Action.diagramInSync) return;
      if (Page.selectedItem !== "AddGeneralization") return;

      e.preventDefault();
      e.stopPropagation();
      if (e.stopImmediatePropagation) e.stopImmediatePropagation();

      // If this was a drag-release, commit now and stop.
      if (GvDiagramEdit.finishDragCreateOnNode(e, theNode)) return;

      // Otherwise this was a click-release, so preserve the two-click flow.
      GvDiagramEdit.handlePaletteGeneralization(e, theNode);
    };
    theNode.addEventListener("mouseup", theNode.__gvGenUp, true);

    // ---- Drag/move classes in GV manual mode ----
    theNode.addEventListener("mousedown", function(event) {
      if (Page.selectedItem === "AddAssociation" || Page.selectedItem === "AddGeneralization") return;
      event.preventDefault();

      let deltaXSum = 0;
      let deltaYSum = 0;
      let didAMove = false;

      Page.selectedGvClass = Action.getGvClassName(event);
      Page.initialMouseDownX = event.clientX;
      Page.initialMouseDownY = event.clientY;

      let prevX = Page.initialMouseDownX;
      let prevY = Page.initialMouseDownY;

      function moveClass(moveEvent) {
        moveEvent.preventDefault();

        const currentX = moveEvent.clientX;
        const currentY = moveEvent.clientY;

        const deltaX = currentX - prevX;
        const deltaY = currentY - prevY;

        deltaXSum += deltaX;
        deltaYSum += deltaY;

        if (allowNodeMovement && (didAMove || Math.abs(deltaXSum + deltaYSum) > 10)) {
          theNode.setAttribute("transform", " translate(" + deltaXSum + "," + deltaYSum + ")");
          didAMove = true;
        }

        prevX = currentX;
        prevY = currentY;

        if (!allowNodeMovement) {
          Page.setFeedbackMessage("To enable moving of classes in G mode, set gvmanual in the Show and Hide menu");
        }
      }

      function stopMovingClass(stopEvent) {
        if (allowNodeMovement && didAMove && (deltaXSum !== 0 || deltaYSum !== 0)) {
          Action.updateGvPosition(Page.selectedGvClass, deltaXSum, deltaYSum);
        }

        document.removeEventListener("mousemove", moveClass);
        document.removeEventListener("mouseup", stopMovingClass);
      }

      document.addEventListener("mousemove", moveClass);
      document.addEventListener("mouseup", stopMovingClass);
    });

    // ---- Attribute anchors: dblclick/contextmenu ----
    const attributeAnchors = theNode.getElementsByTagName("a");
    for (let j = 1; j < attributeAnchors.length; j++) {
      const titleText = attributeAnchors[j].getAttribute("xlink:title");
      if (!titleText) continue;

      const parts = titleText.split(" ");
      const attributeType = parts[0];
      const attributeName = parts[1];

      attributeAnchors[j].addEventListener("dblclick", function(event) {
        event.preventDefault();
        Action.displayAttributeMenu(event, attributeName, attributeType);
      });

      attributeAnchors[j].addEventListener("contextmenu", function(event) {
        event.preventDefault();
        event.stopPropagation();
        Action.displayAttributeMenu(event, attributeName, attributeType);
      });
    }
  }

  // ---- Association edges menu ----
  const associationElems = document.getElementsByClassName("edge");
  for (let i = 0; i < associationElems.length; i++) {
    const associationAnchors = associationElems[i].getElementsByTagName("a");
    for (let j = 0; j < associationAnchors.length; j++) {
      const associationLink = associationAnchors[j].getAttribute("xlink:href");

      associationAnchors[j].addEventListener("dblclick", function(event) {
        event.preventDefault();
        Action.displayAssociMenu(event, associationLink);
      });

      associationAnchors[j].addEventListener("contextmenu", function(event) {
        event.preventDefault();
        Action.displayAssociMenu(event, associationLink);
      });
    }
  }
};

// Rubber band line overlay for GV mode (tool-agnostic)
GvDiagramEdit.rubberBand = GvDiagramEdit.rubberBand || (function() {
  const RB = {
    active: false,
    svg: null,
    layer: null,
    path: null,
    startPt: null,      // {x,y} in svg coords
    startNode: null,    // DOM node element
    mode: null,         // e.g. "association" | "generalization" | "transition" | ...
    _onMove: null,
    _onKeyDown: null,
    _onDown: null
  };

  // How far (in SVG user units) to overshoot past the cursor Y before coming back up.
  // Tweak if you want the “dip” bigger/smaller.
  const GEN_Y_OVERSHOOT = 12;

  function getSvgRootFromAny(el) {
    if (!el) return null;
    if (el.tagName && el.tagName.toLowerCase() === "svg") return el;
    return el.ownerSVGElement || el.closest?.("svg") || null;
  }

  function ensureLayer(svg) {
    if (!svg) return null;
    if (RB.layer && RB.layer.ownerSVGElement === svg) return RB.layer;

    const ns = "http://www.w3.org/2000/svg";

    const layer = document.createElementNS(ns, "g");
    layer.setAttribute("class", "gv-rubberband-layer");
    layer.style.pointerEvents = "none";

    // defs + arrow marker (always points UP, hollow triangle)
    const defs = document.createElementNS(ns, "defs");
    const marker = document.createElementNS(ns, "marker");
    marker.setAttribute("id", "gvRubberBandArrowUp");
    marker.setAttribute("markerWidth", "10");
    marker.setAttribute("markerHeight", "10");
    marker.setAttribute("refX", "5");
    marker.setAttribute("refY", "1");   // tip at top edge of marker box
    marker.setAttribute("orient", "0");
    marker.setAttribute("markerUnits", "strokeWidth");

    const arrowPath = document.createElementNS(ns, "path");
    // Up-pointing hollow triangle; tip at (5,0)
    arrowPath.setAttribute("class", "gv-rubberband-arrow");
    arrowPath.setAttribute("d", "M 5 0 L 10 10 L 0 10 Z");

    marker.appendChild(arrowPath);
    defs.appendChild(marker);
    layer.appendChild(defs);

    const path = document.createElementNS(ns, "path");
    path.setAttribute("class", "gv-rubberband");
    path.removeAttribute("stroke-dasharray");

    layer.appendChild(path);
    svg.appendChild(layer);

    RB.svg = svg;
    RB.layer = layer;
    RB.path = path;
    return layer;
  }

  // Convert mouse event (clientX/Y) into SVG user coords
  function clientToSvgPoint(svg, clientX, clientY) {
    const pt = svg.createSVGPoint();
    pt.x = clientX;
    pt.y = clientY;
    const ctm = svg.getScreenCTM();
    if (!ctm) return { x: 0, y: 0 };
    const p = pt.matrixTransform(ctm.inverse());
    return { x: p.x, y: p.y };
  }

  function setPath(start, end) {
    if (!RB.path) return;
    RB.path.setAttribute("d", `M ${start.x} ${start.y} L ${end.x} ${end.y}`);
  }

  // E-mode generalization rubber band: vertical down from start, horizontal to end.x, then vertical to end.y, with a dip in the middle
  function setPathGeneralizationEStyle(start, end) {
    if (!RB.path) return;

    const yOvershoot = end.y + GEN_Y_OVERSHOOT;

    RB.path.setAttribute(
      "d",
      `M ${start.x} ${start.y}
       L ${start.x} ${yOvershoot}
       L ${end.x} ${yOvershoot}
       L ${end.x} ${end.y}`
    );
  }

  function show() {
    if (RB.layer) RB.layer.style.display = "";
  }

  function hide() {
    if (RB.layer) RB.layer.style.display = "none";
  }

  function cancelInternal() {
    RB.active = false;
    RB.mode = null;
    RB.startPt = null;
    RB.startNode = null;

    // Always clear marker so we don't carry over between modes
    if (RB.path) RB.path.removeAttribute("marker-end");

    hide();

    if (RB._onMove) document.removeEventListener("mousemove", RB._onMove, true);
    if (RB._onKeyDown) document.removeEventListener("keydown", RB._onKeyDown, true);
    if (RB._onDown) document.removeEventListener("mousedown", RB._onDown, true);

    RB._onMove = null;
    RB._onKeyDown = null;
    RB._onDown = null;
  }

  RB.isActive = function() {
    return !!RB.active;
  };

  RB.cancel = function() {
    cancelInternal();
  };

  RB.start = function(nodeEl, mode, event) {
    const svg = getSvgRootFromAny(nodeEl);
    if (!svg) return;

    ensureLayer(svg);

    RB.active = true;
    RB.mode = mode || "generic";

    if (RB.mode === "generalization") {
      RB.path.setAttribute("marker-end", "url(#gvRubberBandArrowUp)");
    } else {
      RB.path.removeAttribute("marker-end");
    }

    RB.startNode = nodeEl;

    if (event && typeof event.clientX === "number" && typeof event.clientY === "number") {
      RB.startPt = clientToSvgPoint(svg, event.clientX, event.clientY);
    } else {
      RB.startPt = nodeAnchorPoint(nodeEl);
    }

    if (RB.mode === "generalization") {
      setPathGeneralizationEStyle(RB.startPt, RB.startPt);
    } else {
      setPath(RB.startPt, RB.startPt);
    }
    show();

    RB._onMove = function(e) {
      if (!RB.active || !RB.svg || !RB.startPt) return;

      // Freeze the temporary line when the cursor leaves the diagram frame.
      const canvasEl = document.getElementById("umpleCanvas");
      const boundsEl = canvasEl || RB.svg;
      const rect = boundsEl.getBoundingClientRect();

      const isInsideCanvas =
        e.clientX >= rect.left &&
        e.clientX <= rect.right &&
        e.clientY >= rect.top &&
        e.clientY <= rect.bottom;

      if (!isInsideCanvas) {
        return;
      }

      const end = clientToSvgPoint(RB.svg, e.clientX, e.clientY);

      if (RB.mode === "generalization") {
        setPathGeneralizationEStyle(RB.startPt, end);
      } else {
        setPath(RB.startPt, end);
      }
    };
    document.addEventListener("mousemove", RB._onMove, true);

    RB._onKeyDown = function(e) {
      if (!RB.active) return;
      if (e.key === "Escape") {
        e.preventDefault();
        e.stopPropagation();
        GvDiagramEdit.clearPendingPaletteState();
      }
    };
    document.addEventListener("keydown", RB._onKeyDown, true);
  };

  RB.finish = function() {
    cancelInternal();
  };

  return RB;
})();

// S-mode tools use the same editor updates, drag threshold and preview as G mode.
GvDiagramEdit.getStateIdentifier = function(nodeEl) {
  const anchors = nodeEl.querySelectorAll("a");
  for (const anchor of anchors) {
    const href = anchor.getAttribute("href") || anchor.getAttribute("xlink:href") || "";
    const match = href.match(/^javascript:Action\.stateClicked\(["']([^"']+)["']\)/);
    if (match) return match[1].replace(/Entry:|Exit:/g, "");
  }
  return null; // Start markers and transition edges are not states.
};

// Keep offsets intact while ignoring braces and names in comments or strings.
GvDiagramEdit.maskStateSource = function(text) {
  return text.replace(/\/\/[^\n]*|\/\*[\s\S]*?\*\/|"(?:\\.|[^"\\])*"|'(?:\\.|[^'\\])*'/g,
    part => part.replace(/[^\n\r]/g, " "));
};

GvDiagramEdit.findNamedStateBlock = function(masked, name, from, to) {
  let depth = 0;
  for (let i = from; i < to; i++) {
    if (masked[i] === "{") depth++;
    else if (masked[i] === "}") depth--;
    else if (depth === 0 && /[A-Za-z_]/.test(masked[i])) {
      const start = i;
      while (i < to && /[A-Za-z0-9_]/.test(masked[i])) i++;
      const word = masked.slice(start, i);
      while (i < to && /\s/.test(masked[i])) i++;
      if (word === name && masked[i] === "{") {
        const open = i;
        let braces = 1;
        while (++i < to) {
          if (masked[i] === "{") braces++;
          if (masked[i] === "}" && --braces === 0) return { start, open, end: i + 1 };
        }
        return null;
      }
      i--;
    }
  }
  return null;
};

GvDiagramEdit.findStateRange = function(text, identifier, machineOnly) {
  const parts = identifier.split("^*^");
  if (parts.length !== 3) return null;
  const masked = GvDiagramEdit.maskStateSource(text);
  let range = GvDiagramEdit.findNamedStateBlock(masked, parts[0], 0, masked.length);
  if (!range) return null;
  range = GvDiagramEdit.findNamedStateBlock(masked, parts[1], range.open + 1, range.end - 1);
  if (machineOnly) return range;
  for (const name of parts[2].split(".")) {
    if (!range) return null;
    range = GvDiagramEdit.findNamedStateBlock(masked, name, range.open + 1, range.end - 1);
  }
  return range;
};

GvDiagramEdit.appendToStateBlock = function(text, range, line) {
  const close = range.end - 1;
  const lineStart = text.lastIndexOf("\n", range.start - 1) + 1;
  const indent = (text.slice(lineStart, range.start).match(/^\s*/) || [""])[0];
  const closingLine = text.lastIndexOf("\n", close - 1) + 1;
  const insertAt = /^\s*$/.test(text.slice(closingLine, close)) ? closingLine : close;
  const prefix = insertAt > 0 && text[insertAt - 1] !== "\n" ? "\n" : "";
  return text.slice(0, insertAt) + prefix + indent + "  " + line + "\n" +
    (insertAt === close ? indent : "") + text.slice(insertAt);
};

GvDiagramEdit.uniqueStateName = function(text, prefix) {
  const names = new Set(GvDiagramEdit.maskStateSource(text).match(/[A-Za-z_][A-Za-z0-9_]*/g) || []);
  let index = 1;
  while (names.has(prefix + index)) index++;
  return prefix + index;
};

GvDiagramEdit.insertTransitionIntoSourceState = function(text, source, target) {
  const from = source.split("^*^");
  const to = target.split("^*^");
  if (from[0] !== to[0] || from[1] !== to[1]) return null;
  const range = GvDiagramEdit.findStateRange(text, source);
  const machine = GvDiagramEdit.findStateRange(text, source, true);
  if (!range || !machine || !GvDiagramEdit.findStateRange(text, target)) return null;
  const eventName = GvDiagramEdit.uniqueStateName(text.slice(machine.start, machine.end), "event");
  return GvDiagramEdit.appendToStateBlock(text, range, eventName + " -> " + to[2] + ";");
};

GvDiagramEdit.selectState = function(identifier) {
  GvDiagramEdit.selectedState = identifier;
  const range = GvDiagramEdit.findStateRange(GvDiagramEdit.getFullText(), identifier);
  if (range) Action.highlightByIndexCM6(range.start, range.end);
};

GvDiagramEdit.commitTransition = function(source, target) {
  GvDiagramEdit.clearPendingPaletteState();
  const after = GvDiagramEdit.insertTransitionIntoSourceState(GvDiagramEdit.getFullText(), source, target);
  if (after == null) {
    Page.setFeedbackMessage("Choose states in the same state machine, defined in the current editor.");
    return;
  }
  GvDiagramEdit.replaceFullText(after);
  GvDiagramEdit.refreshDiagram();
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.setFeedbackMessage("Transition added: " + source.split("^*^")[2] + " -> " + target.split("^*^")[2]);
};

GvDiagramEdit.handlePaletteTransition = function(event, nodeEl) {
  const identifier = GvDiagramEdit.getStateIdentifier(nodeEl);
  if (!identifier) return;
  if (GvDiagramEdit.state.transitionSource == null) {
    GvDiagramEdit.state.transitionSource = identifier;
    GvDiagramEdit.selectState(identifier);
    GvDiagramEdit.rubberBand.start(nodeEl, "transition", event);
    Page.setFeedbackMessage("Transition: select the target state.");
  } else {
    GvDiagramEdit.commitTransition(GvDiagramEdit.state.transitionSource, identifier);
  }
};

GvDiagramEdit.bindStateDiagram = function() {
  GvDiagramEdit.installCreateDragListeners();
  const nodes = document.querySelectorAll("#umpleCanvas .node, #umpleCanvas .cluster");
  for (const node of nodes) {
    if (!GvDiagramEdit.getStateIdentifier(node)) continue;
    let suppressClick = false;
    const active = () => Page.useGvStateDiagram && !Page.readOnly && Action.diagramInSync && Page.selectedItem === "AddTransition";
    const stop = event => { event.preventDefault(); event.stopImmediatePropagation(); };
    node.addEventListener("mousedown", function(event) {
      suppressClick = false;
      if (!active() || event.button !== 0) return;
      stop(event);
      GvDiagramEdit.beginPossibleDragCreate(event, node, "transition");
    }, true);
    node.addEventListener("mouseup", function(event) {
      if (!active() || event.button !== 0) return;
      stop(event);
      suppressClick = true;
      Action.elementClicked = false;
      if (!GvDiagramEdit.finishDragCreateOnNode(event, node)) {
        GvDiagramEdit.handlePaletteTransition(event, node);
      }
    }, true);
    node.addEventListener("click", function(event) {
      if (suppressClick || active()) {
        suppressClick = false;
        stop(event); // Do not follow the state link or call the legacy transition tool.
      }
    }, true);
  }
};

GvDiagramEdit.insertFirstState = function(text, className) {
  const masked = GvDiagramEdit.maskStateSource(text);
  const range = className && GvDiagramEdit.findNamedStateBlock(masked, className, 0, masked.length);
  if (className && !range) return null;
  const machineName = GvDiagramEdit.uniqueStateName(text, "stateMachine");
  const newMachine = machineName + " {\n    State1 {}\n  }";
  const updated = range ? GvDiagramEdit.appendToStateBlock(text, range, newMachine) :
    text + "\nclass " + GvDiagramEdit.uniqueStateName(text, "NewClass") + " {\n  " + newMachine + "\n}\n";
  return { text: updated, name: "State1" };
};

GvDiagramEdit.insertStateIntoMachine = function(text, identifier, nested) {
  const range = GvDiagramEdit.findStateRange(text, identifier, !nested);
  if (!range) return null;
  const machine = GvDiagramEdit.findStateRange(text, identifier, true);
  const name = GvDiagramEdit.uniqueStateName(text.slice(machine.start, machine.end), "State");
  return { text: GvDiagramEdit.appendToStateBlock(text, range, name + " {}"), name };
};

GvDiagramEdit.addState = function(event) {
  if (!Page.useGvStateDiagram || Page.readOnly || !Action.diagramInSync) return;
  const text = GvDiagramEdit.getFullText();
  const cluster = event.target.closest(".cluster");
  const nestedIdentifier = cluster && GvDiagramEdit.getStateIdentifier(cluster);
  const machines = new Map();
  for (const node of document.querySelectorAll("#umpleCanvas .node, #umpleCanvas .cluster")) {
    const id = GvDiagramEdit.getStateIdentifier(node);
    if (id && GvDiagramEdit.findStateRange(text, id, true)) {
      const parts = id.split("^*^");
      machines.set(parts[0] + " / " + parts[1], id);
    }
  }
  const masked = GvDiagramEdit.maskStateSource(text);
  const classes = [...masked.matchAll(/\bclass\s+([A-Za-z_][A-Za-z0-9_]*)\s*\{/g)];
  for (const match of classes) {
    const classRange = GvDiagramEdit.findNamedStateBlock(masked, match[1], 0, masked.length);
    if (!classRange) continue;
    const body = masked.slice(classRange.open + 1, classRange.end - 1);
    for (const block of body.matchAll(/\b([A-Za-z_][A-Za-z0-9_]*)\s*\{/g)) {
      const range = GvDiagramEdit.findNamedStateBlock(masked, block[1], classRange.open + 1, classRange.end - 1);
      if (range && range.start === classRange.open + 1 + block.index &&
          masked.slice(range.open + 1, range.end - 1).trim() === "" &&
          !["invariant", "before", "after"].includes(block[1])) {
        machines.set(match[1] + " / " + block[1], match[1] + "^*^" + block[1] + "^*^");
      }
    }
  }
  function create(identifier, nested) {
    if (text !== GvDiagramEdit.getFullText()) {
      Page.setFeedbackMessage("The model changed. Select State again to add a state.");
      GvDiagramEdit.clearPendingPaletteState();
      return;
    }
    const result = identifier.split("^*^")[1] ? GvDiagramEdit.insertStateIntoMachine(text, identifier, nested) :
      GvDiagramEdit.insertFirstState(text, identifier.split("^*^")[0]);
    if (!result) {
      Page.setFeedbackMessage("Select a state machine defined in the current editor.");
      return;
    }
    GvDiagramEdit.replaceFullText(result.text);
    GvDiagramEdit.refreshDiagram();
    if (!Page.repeatToolItem) Page.unselectAllToggleTools();
    Page.setFeedbackMessage("State added: " + result.name);
  }
  if (nestedIdentifier) return create(nestedIdentifier, true);
  const selected = GvDiagramEdit.selectedState;
  if (selected && [...machines.values()].some(id => id.split("^*^").slice(0, 2).join("^*^") === selected.split("^*^").slice(0, 2).join("^*^"))) {
    return create(selected, false);
  }
  if (machines.size === 0) {
    if (classes.length === 0) return create("^*^^*^", false);
    for (const match of classes) machines.set(match[1] + " / new state machine", match[1] + "^*^^*^");
  }
  if (machines.size === 1) return create(machines.values().next().value, false);
  // A blank canvas click has no owner when several state machines are visible.
  GvDiagramEdit.clearPendingPaletteState();
  const picker = document.createElement("div");
  picker.className = "gv-state-picker";
  const label = document.createElement("label");
  label.textContent = "Add state to: ";
  const select = document.createElement("select");
  for (const [name, id] of machines) {
    const option = document.createElement("option");
    option.textContent = name;
    option.value = id;
    select.appendChild(option);
  }
  label.appendChild(select);
  picker.appendChild(label);
  const add = document.createElement("button");
  add.textContent = "Add state";
  add.onclick = () => create(select.value, false);
  picker.appendChild(add);
  const cancel = document.createElement("button");
  cancel.textContent = "Cancel";
  cancel.onclick = () => GvDiagramEdit.clearPendingPaletteState();
  picker.appendChild(cancel);
  picker.addEventListener("keydown", e => {
    if (e.key === "Escape") GvDiagramEdit.clearPendingPaletteState();
  });
  picker.style.position = "fixed";
  picker.style.left = Math.max(0, Math.min(event.clientX, window.innerWidth - 360)) + "px";
  picker.style.top = Math.max(0, Math.min(event.clientY, window.innerHeight - 80)) + "px";
  document.body.appendChild(picker);
  GvDiagramEdit.statePicker = picker;
  select.focus();
};
