if (typeof window.GvDiagramEdit === "undefined") {
  window.GvDiagramEdit = {};
}

GvDiagramEdit.state = GvDiagramEdit.state || {
  assocSourceClass: null,
  genChildClass: null
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
  GvDiagramEdit.state.assocSourceClass = null;
  GvDiagramEdit.state.genChildClass = null;

  if (GvDiagramEdit.rubberBand && GvDiagramEdit.rubberBand.isActive()) {
    GvDiagramEdit.rubberBand.cancel();
  }
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
  TabControl.getCurrentHistory().save(after, "menuUpdate");

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
  TabControl.getCurrentHistory().save(after, "menuUpdate");

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
        if (GvDiagramEdit.handlePaletteAssociation(e, theNode)) return;
    };
    theNode.addEventListener("mousedown", theNode.__gvAssocDown, true);

    // ---- Generalization tool in GV mode ----
    if (theNode.__gvGenDown) {
      theNode.removeEventListener("mousedown", theNode.__gvGenDown, true);
    }
    theNode.__gvGenDown = function(e) {
        if (GvDiagramEdit.handlePaletteGeneralization(e, theNode)) return;
    };
    theNode.addEventListener("mousedown", theNode.__gvGenDown, true);

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
        RB.cancel();

        if (GvDiagramEdit && GvDiagramEdit.state) {
          GvDiagramEdit.state.assocSourceClass = null;
          GvDiagramEdit.state.genChildClass = null;
        }
      }
    };
    document.addEventListener("keydown", RB._onKeyDown, true);
  };

  RB.finish = function() {
    cancelInternal();
  };

  return RB;
})();