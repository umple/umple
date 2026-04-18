// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Feature model tree view module. Renders a FeatureModelJson as a hierarchical tree with constraint-aware styling inside the "Show and Hide" panel. Feeds user interactions into Page.mixsetsActive via Action.toggleMixsetUseStatement.

var FeatureTree = {};

FeatureTree.model = null;
FeatureTree.nodeById = null;
FeatureTree.nodeByUniqueName = null;
FeatureTree.childrenOf = null;
FeatureTree.parentOf = null;
FeatureTree.rootIds = null;
FeatureTree.multiRefIds = null;
FeatureTree.constraints = null;
FeatureTree.collapsedNodes = new Set();
FeatureTree.container = null;

FeatureTree.reset = function() {
  FeatureTree.model = null;
  FeatureTree.nodeById = null;
  FeatureTree.nodeByUniqueName = null;
  FeatureTree.childrenOf = null;
  FeatureTree.parentOf = null;
  FeatureTree.rootIds = null;
  FeatureTree.multiRefIds = null;
  FeatureTree.constraints = null;
};

FeatureTree.parseModel = function(featureModelJson) {
  FeatureTree.reset();
  if (!featureModelJson) {
    console.error("Null or Empty param received")
    return;
  }

  FeatureTree.model = featureModelJson;
  let nodes = featureModelJson.nodes || [];
  let links = featureModelJson.links || [];

  FeatureTree.nodeById = {};
  FeatureTree.nodeByUniqueName = {};
  for (let i = 0; i < nodes.length; i++) {
    FeatureTree.nodeById[nodes[i].id] = nodes[i];
    FeatureTree.nodeByUniqueName[nodes[i].uniqueName] = nodes[i];
  }

  FeatureTree.childrenOf = {};
  FeatureTree.parentOf = {};
  for (let i = 0; i < nodes.length; i++) {
    FeatureTree.childrenOf[nodes[i].id] = [];
    FeatureTree.parentOf[nodes[i].id] = [];
  }

  for (let i = 0; i < links.length; i++) {
    let link = links[i];
    let src = FeatureTree.nodeById[link.sourceNodeId];
    let tgt = FeatureTree.nodeById[link.targetNodeId];
    if (!src || !tgt) {
      continue;
    }
    FeatureTree.childrenOf[link.sourceNodeId].push({ targetNode: tgt, link: link });
    FeatureTree.parentOf[link.targetNodeId].push({ sourceNode: src, link: link });
  }

  for (let i = 0; i < nodes.length; i++) {
    let node = nodes[i];
    if (node.nodeType === "CompoundFeatureNode" && node.childFeatureIds) {
      for (let j = 0; j < node.childFeatureIds.length; j++) {
        let childId = node.childFeatureIds[j];
        let child = FeatureTree.nodeById[childId];
        if (!child) {
          continue;
        }
        let synth = {
          sourceNodeId: node.id,
          targetNodeId: childId,
          opType: "CompoundChild",
          linkType: "CompoundChild",
          isSub: true
        };
        FeatureTree.childrenOf[node.id].push({ targetNode: child, link: synth });
        FeatureTree.parentOf[childId].push({ sourceNode: node, link: synth });
      }
    }
  }

  FeatureTree.rootIds = FeatureTree._findRoots(nodes);
  FeatureTree.multiRefIds = FeatureTree._getMultiRef(nodes);
  FeatureTree.constraints = FeatureTree._buildConstraints(links);

  FeatureTree._syncMixsetsActive(nodes);
};

FeatureTree._findRoots = function(nodes) {
  // See build/reference/4104RequireStatement.txt, sometimes there might be orphan roots generated in feature model, or even have no umpleFile root node generated
  let umpleFileRoots = [];
  let orphanRoots = [];
  for (let i = 0; i < nodes.length; i++) {
    let n = nodes[i];
    if (n.mixsetOrFileNode && n.mixsetOrFileNode.type === "UmpleFile") {
      umpleFileRoots.push(n.id);
    }
    let incoming = FeatureTree.parentOf[n.id];
    let outgoing = FeatureTree.childrenOf[n.id];
    if (incoming.length === 0 && outgoing.length > 0) {
      orphanRoots.push(n.id);
    }
  }
  for (let i = 0; i < orphanRoots.length; i++) {
    if (!umpleFileRoots.includes(orphanRoots[i])) {
      umpleFileRoots.push(orphanRoots[i]);
    }
  }
  return umpleFileRoots;
};

FeatureTree._getMultiRef = function(nodes) {
  let multiRef = new Set();
  for (let i = 0; i < nodes.length; i++) {
    let n = nodes[i];
    let sources = new Set();
    let parents = FeatureTree.parentOf[n.id];
    for (let j = 0; j < parents.length; j++) {
      sources.add(parents[j].sourceNode.id);
    }
    if (sources.size >= 2) {
      multiRef.add(n.id);
    }
  }
  return multiRef;
};

FeatureTree._buildConstraints = function(links) {
  let constraints = [];
  let disjunctiveBySource = {};

  for (let i = 0; i < links.length; i++) {
    let link = links[i];
    let src = FeatureTree.nodeById[link.sourceNodeId];
    let tgt = FeatureTree.nodeById[link.targetNodeId];
    if (!src || !tgt) {
      continue;
    }

    switch (link.opType) {
      case "Mandatory":
      case "Include":
      case "Conjunctive":
        constraints.push({
          type: "mandatory",
          sourceUniqueName: src.uniqueName,
          sourceName: src.name,
          targetUniqueName: tgt.uniqueName,
          targetName: tgt.name,
          targetId: tgt.id
        });
        break;
      case "Multiplicity":
      case "XOR":
        let defaultMin = link.opType === "XOR" ? 1 : 0;
        let defaultMax = tgt.childFeatureIds ? tgt.childFeatureIds.length : 0;
        let min = link.lowerBound != null ? link.lowerBound : defaultMin;
        let max = link.upperBound != null ? link.upperBound : defaultMax;
        let members = [];
        let memberIds = [];
        if (tgt.nodeType === "CompoundFeatureNode" && tgt.childFeatureIds) {
          for (let j = 0; j < tgt.childFeatureIds.length; j++) {
            let ch = FeatureTree.nodeById[tgt.childFeatureIds[j]];
            if (ch) {
              members.push(ch.name);
              memberIds.push(ch.id);
            }
          }
        }
        constraints.push({
          type: "multiplicity",
          sourceUniqueName: src.uniqueName,
          sourceName: src.name,
          targetUniqueName: tgt.uniqueName,
          targetId: tgt.id,
          members: members,
          memberIds: memberIds,
          min: min,
          max: max
        });
        break;
      case "Disjunctive":
        if (!disjunctiveBySource[src.id]) {
          disjunctiveBySource[src.id] = {
            sourceUniqueName: src.uniqueName,
            sourceName: src.name,
            members: [],
            memberIds: []
          };
        }
        disjunctiveBySource[src.id].members.push(tgt.name);
        disjunctiveBySource[src.id].memberIds.push(tgt.id);
        break;
      case "Exclude":
        constraints.push({
          type: "exclude",
          sourceUniqueName: src.uniqueName,
          targetUniqueName: tgt.uniqueName,
          targetName: tgt.name,
          targetId: tgt.id
        });
        break;
      default:
        break;
    }
  }

  for (let key in disjunctiveBySource) {
    if (!Object.prototype.hasOwnProperty.call(disjunctiveBySource, key)) continue;
    let entry = disjunctiveBySource[key];
    constraints.push({
      type: "multiplicity",
      sourceUniqueName: entry.sourceUniqueName,
      sourceName: entry.sourceName,
      targetUniqueName: null,
      targetId: null,
      members: entry.members,
      memberIds: entry.memberIds,
      min: 1,
      max: entry.members.length
    });
  }

  return constraints;
};

FeatureTree._syncMixsetsActive = function(nodes) {
  if (typeof Page === "undefined" || !Page.mixsetsActive) {
    console.error("Page.mixsetsActive not accessible")
    return;
  }
  for (let i = 0; i < nodes.length; i++) {
    let n = nodes[i];
    if (n.mixsetOrFileNode
        && n.mixsetOrFileNode.isMixset
        && n.mixsetOrFileNode.useUmpleFile) {
      if (!Page.mixsetsActive.includes(n.name)) {
        Page.mixsetsActive.push(n.name);
      }
    }
  }
};

FeatureTree._isAncestorActive = function(uniqueName) {
  let node = FeatureTree.nodeByUniqueName
    ? FeatureTree.nodeByUniqueName[uniqueName] : null;
  if (!node) return false;
  if (node.mixsetOrFileNode && node.mixsetOrFileNode.type === "UmpleFile") return true;
  if (node.nodeType === "FeatureNode" || node.nodeType === "CompoundFeatureNode") return true;
  return Page.mixsetsActive.includes(node.name);
};

FeatureTree.isMultiRefNode = function(nodeId) {
  return FeatureTree.multiRefIds.has(nodeId);
};

// Collect the ancestor paths by uniqueName for every rendered instance of a given node name
FeatureTree.getInstanceAncestorPaths = function(nodeName) {
  let paths = [];
  if (!FeatureTree.container) return paths;
  let instances = FeatureTree.container.querySelectorAll(
    '[data-id="' + FeatureTree._fmtToCss(nodeName) + '"]');
  for (let i = 0; i < instances.length; i++) {
    let inst = instances[i];
    if (inst.getAttribute("data-inst") == null) continue;
    paths.push({
      ancestors: FeatureTree._parseAncestors(inst),
      isCycleInner: inst.getAttribute("data-cycle-inner") === "true",
      isMultiRef: inst.getAttribute("data-multiref") === "true"
    });
  }
  return paths;
};

FeatureTree.TOOLTIP_ID_PREFIX = "ttfeaturemodelselector-";

FeatureTree.applyTooltips = function() {
  if (typeof ToolTips === "undefined" || !ToolTips) {
    console.error("Cannot load tooltip component");
    return;
  }
  if (!FeatureTree.container) return;
  if (!ToolTips.dynamicTooltips) ToolTips.dynamicTooltips = {};

  for (let key in ToolTips.dynamicTooltips) {
    if (!Object.prototype.hasOwnProperty.call(ToolTips.dynamicTooltips, key)) continue;
    if (key.startsWith(FeatureTree.TOOLTIP_ID_PREFIX)) {
      delete ToolTips.dynamicTooltips[key];
    }
  }

  let instances = FeatureTree.container.querySelectorAll("[data-inst]");
  for (let i = 0; i < instances.length; i++) {
    let inst = instances[i];
    let isCycleInner = inst.getAttribute("data-cycle-inner") === "true";
    let isMultiRef = inst.getAttribute("data-multiref") === "true";
    let isExcluded = inst.getAttribute("data-excluded") === "true";
    if (!isCycleInner && !isMultiRef && !isExcluded) continue;

    let tooltipId = FeatureTree._tooltipIdFromInstance(inst);
    let labelEl = FeatureTree._findLabelElement(inst);
    if (!labelEl) continue;
    labelEl.id = tooltipId;

    let content = FeatureTree._buildInstanceTooltipContent(
      inst, isMultiRef, isCycleInner, isExcluded);
    if (!content) continue;
    ToolTips.dynamicTooltips[tooltipId] = ["span", content];

    try {
      ToolTips.setATooltipBasic(ToolTips.dynamicTooltips, tooltipId, "left");
    } catch (err) {
        console.error("FeatureTree: failed to attach tooltip to " + tooltipId, err);

    }

  }
};

FeatureTree._tooltipIdFromInstance = function(inst) {
  let dataInst = inst.getAttribute("data-inst") || "x";
  let safe = dataInst.replace(/[^a-zA-Z0-9_-]/g, "_");
  return FeatureTree.TOOLTIP_ID_PREFIX + safe;
};

FeatureTree._findLabelElement = function(inst) {
  let row = inst.firstChild;
  if (!row) return null;
  return row.querySelector(".feature-tree-name")
    || row.querySelector(".feature-tree-mult-label");
};

FeatureTree._buildInstanceTooltipContent = function(inst, isMultiRef, isCycleInner, isExcluded) {
  let nodeName = inst.getAttribute("data-id");
  let uniqueName = inst.getAttribute("data-unique");
  let ancestors = FeatureTree._parseAncestors(inst);
  let pieces = [];

  if (isMultiRef) {
    let paths = FeatureTree.getInstanceAncestorPaths(nodeName);
    let pathList = [];
    for (let i = 0; i < paths.length; i++) {
      let steps = paths[i].ancestors;
      let rendered = steps.length ? steps.join(" \u203A ") : "(root)";
      if (paths[i].isCycleInner) rendered += " (cycle)";
      pathList.push("<li>" + FeatureTree._fmtToHtml(rendered) + "</li>");
    }
    pieces.push("<b>" + FeatureTree._fmtToHtml(nodeName)
      + "</b> is referenced from multiple paths:<ul>"
      + pathList.join("") + "</ul>Checking any instance toggles them all.");
  }

  if (isCycleInner) {
    let cycleText = FeatureTree._formatCyclePath(ancestors, uniqueName);
    pieces.push("Circular dependency detected: "
      + FeatureTree._fmtToHtml(cycleText)
      + ". This instance is disabled; toggle the outermost <b>"
      + FeatureTree._fmtToHtml(nodeName) + "</b> to change state.");
  }

  if (isExcluded) {
    pieces.push("This feature is excluded by a <code>require [not &hellip;]</code> rule "
      + "in an active ancestor. Selecting it while that ancestor is active "
      + "breaks the configuration.");
  }

  return pieces.join("<br/><br/>");
};

FeatureTree._formatCyclePath = function(ancestors, uniqueName) {
  let start = uniqueName ? ancestors.indexOf(uniqueName) : -1;
  let cycle = start !== -1 ? ancestors.slice(start) : ancestors.slice();
  if (uniqueName) cycle.push(uniqueName);
  return cycle.join(" \u2192 ");
};

// Required so these chars can be rendered properly
FeatureTree._fmtToHtml = function(value) {
  return String(value)
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;");
};

FeatureTree._isExpanded = function(uniqueName) {
  return !FeatureTree.collapsedNodes.has(uniqueName);
};

FeatureTree._toggleExpand = function(uniqueName, toggleElem, childrenElem, childCountElem) {
  if (FeatureTree.collapsedNodes.has(uniqueName)) {
    FeatureTree.collapsedNodes.delete(uniqueName);
    if (childrenElem) childrenElem.style.display = "";
    if (toggleElem) toggleElem.textContent = "\u25BC";
    if (childCountElem) childCountElem.style.display = "none";
  } else {
    FeatureTree.collapsedNodes.add(uniqueName);
    if (childrenElem) childrenElem.style.display = "none";
    if (toggleElem) toggleElem.textContent = "\u25B6";
    if (childCountElem) childCountElem.style.display = "";
  }
};

FeatureTree.render = function(containerElement) {
  FeatureTree.container = containerElement;
  while (containerElement.firstChild) {
    containerElement.removeChild(containerElement.firstChild);
  }
  if (!FeatureTree.model || !FeatureTree.rootIds || FeatureTree.rootIds.length === 0) {
    console.warn("Cannot render the feature tree (no model or empty rootIds)");
    return;
  }

  let rootList = document.createElement("ul");
  rootList.className = "feature-tree";

  let visitedGlobal = new Set();
  for (let i = 0; i < FeatureTree.rootIds.length; i++) {
    let rootId = FeatureTree.rootIds[i];
    let rootElem = FeatureTree._renderNode(rootId, null, [], new Set(), visitedGlobal);
    if (rootElem) rootList.appendChild(rootElem);
  }
  containerElement.appendChild(rootList);
  FeatureTree.evaluateConstraints();
  FeatureTree.applyTooltips();
};

FeatureTree._renderNode = function(nodeId, incomingLink, ancestorUniqueNames,
                                    visitedOnPath, visitedGlobal) {
  let node = FeatureTree.nodeById[nodeId];
  if (!node) return null;

  let isCycleInner = visitedOnPath.has(nodeId);
  let alreadyVisited = visitedGlobal.has(nodeId);
  let isMultiRef = !isCycleInner
    && FeatureTree.multiRefIds && FeatureTree.multiRefIds.has(nodeId);

  let li = document.createElement("li");
  li.className = "feature-tree-node-wrapper";
  let instId = ancestorUniqueNames.concat([node.uniqueName]).join("/");
  li.setAttribute("data-inst", instId);
  li.setAttribute("data-ancestors", ancestorUniqueNames.join(","));
  li.setAttribute("data-id", node.name);
  li.setAttribute("data-unique", node.uniqueName);
  li.setAttribute("data-node-id", String(node.id));
  if (isCycleInner) li.setAttribute("data-cycle-inner", "true");
  if (isMultiRef) li.setAttribute("data-multiref", "true");
  if (incomingLink && incomingLink.opType === "Exclude") {
    li.setAttribute("data-excluded", "true");
  }

  let row = document.createElement("div");
  row.className = "feature-tree-node";
  li.appendChild(row);

  let childList = [];
  let suppressChildren = isCycleInner || alreadyVisited;
  if (!suppressChildren) {
    childList = FeatureTree.childrenOf[nodeId] || [];
  }
  let hasChildren = childList.length > 0;
  let expanded = FeatureTree._isExpanded(node.uniqueName);

  let toggle = document.createElement("span");
  if (hasChildren) {
    toggle.className = "feature-tree-toggle";
    toggle.textContent = expanded ? "\u25BC" : "\u25B6";
  } else {
    toggle.className = "feature-tree-toggle-placeholder";
    toggle.textContent = "";
  }
  row.appendChild(toggle);

  FeatureTree._renderNodeBody(row, node, incomingLink, isCycleInner);

  let childrenUl = null;
  let childCountSpan = null;
  if (hasChildren) {
    childCountSpan = document.createElement("span");
    childCountSpan.className = "feature-tree-child-count";
    childCountSpan.textContent = "(" + childList.length
      + (childList.length === 1 ? " child)" : " children)");
    childCountSpan.style.display = expanded ? "none" : "";
    row.appendChild(childCountSpan);

    childrenUl = document.createElement("ul");
    childrenUl.className = "feature-tree-children";
    if (!expanded) childrenUl.style.display = "none";

    let newAncestors = ancestorUniqueNames.concat([node.uniqueName]);
    let newPath = new Set(visitedOnPath);
    newPath.add(nodeId);
    visitedGlobal.add(nodeId);

    for (let i = 0; i < childList.length; i++) {
      let childId = childList[i].targetNode.id;
      let childElem = FeatureTree._renderNode(childId, childList[i].link,
        newAncestors, newPath, visitedGlobal);
      if (childElem) childrenUl.appendChild(childElem);
    }
    li.appendChild(childrenUl);

    toggle.addEventListener("click", function(ev) {
      FeatureTree._toggleExpand(node.uniqueName, toggle, childrenUl, childCountSpan);
      ev.stopPropagation();
    });
  } else if (!suppressChildren) {
    visitedGlobal.add(nodeId);
  }

  return li;
};

FeatureTree._renderNodeBody = function(row, node, incomingLink, isCycleInner) {
  let kind = FeatureTree._nodeRenderingKind(node);

  if (kind === "root") {
    let label = document.createElement("span");
    label.className = "feature-tree-name feature-tree-name-root";
    label.textContent = node.name;
    row.appendChild(label);
    return;
  }

  if (kind === "group") {
    let label = document.createElement("span");
    label.className = "feature-tree-name feature-tree-name-group";
    label.textContent = "<" + node.name + ">";
    row.appendChild(label);
    return;
  }

  if (kind === "multiplicity") {
    let min = 0, max = 0;
    if (incomingLink && incomingLink.lowerBound != null) min = incomingLink.lowerBound;
    if (incomingLink && incomingLink.upperBound != null) {
      max = incomingLink.upperBound;
    } else if (node.childFeatureIds) {
      max = node.childFeatureIds.length;
    }
    let label = document.createElement("span");
    label.className = "feature-tree-mult-label";
    label.textContent = "pick " + min + ".." + max + " of:";
    label.setAttribute("data-mult-min", String(min));
    label.setAttribute("data-mult-max", String(max));
    label.setAttribute("data-mult-target", node.uniqueName);
    row.appendChild(label);
    return;
  }

  if (kind === "fragment") {
    let label = document.createElement("span");
    label.className = "feature-tree-name";
    label.textContent = node.name;
    row.appendChild(label);
    return;
  }

  let checkbox = document.createElement("input");
  checkbox.type = "checkbox";
  checkbox.className = "feature-tree-checkbox";
  checkbox.setAttribute("data-id", node.name);
  if (Page.mixsetsActive.includes(node.name)) {
    checkbox.checked = true;
  }
  if (isCycleInner) {
    checkbox.disabled = true;
  } else {
    checkbox.addEventListener("change", FeatureTree._makeChangeHandler(node.name));
  }
  row.appendChild(checkbox);

  let label = document.createElement("span");
  label.className = "feature-tree-name";
  if (incomingLink && incomingLink.opType === "Exclude") {
    label.classList.add("feature-tree-name-excluded");
    label.setAttribute("title", "excluded");
  }
  label.textContent = node.name;
  if (!isCycleInner) {
    label.addEventListener("click", FeatureTree._makeLabelClickHandler(checkbox));
  }
  row.appendChild(label);
};

FeatureTree._makeChangeHandler = function(nodeName) {
  return function(ev) {
    let target = ev && ev.target ? ev.target : null;
    let checked = target ? target.checked : false;
    FeatureTree.onCheckboxChange(nodeName, checked);
  };
};

FeatureTree._makeLabelClickHandler = function(checkbox) {
  return function() {
    if (checkbox.disabled) return;
    checkbox.checked = !checkbox.checked;
    let ev = new Event("change", { bubbles: true, cancelable: false });
    checkbox.dispatchEvent(ev);
  };
};

FeatureTree._nodeRenderingKind = function(node) {
  if (node.mixsetOrFileNode && node.mixsetOrFileNode.type === "UmpleFile") {
    return "root";
  }
  if (node.nodeType === "FeatureNode") {
    return "group";
  }
  if (node.nodeType === "CompoundFeatureNode") {
    return "multiplicity";
  }
  if (node.nodeType === "FragmentFeatureLeaf") {
    return "fragment";
  }
  return "leaf";
};

FeatureTree.evaluateConstraints = function() {
  if (!FeatureTree.container) return;
  let instances = FeatureTree.container.querySelectorAll("[data-inst]");
  for (let i = 0; i < instances.length; i++) {
    FeatureTree._evaluateInstance(instances[i]);
  }
};

FeatureTree._parseAncestors = function(li) {
  let raw = li.getAttribute("data-ancestors") || "";
  if (raw === "") return [];
  return raw.split(",");
};

FeatureTree._evaluateInstance = function(li) {
  let ancestors = FeatureTree._parseAncestors(li);
  let nodeName = li.getAttribute("data-id");
  let uniqueName = li.getAttribute("data-unique");
  let isCycleInner = li.getAttribute("data-cycle-inner") === "true";
  let isMultiRef = li.getAttribute("data-multiref") === "true";
  let row = li.firstChild;
  let nameEl = row ? row.querySelector(".feature-tree-name") : null;
  let multLabel = row ? row.querySelector(".feature-tree-mult-label") : null;
  let checkbox = row ? row.querySelector(".feature-tree-checkbox") : null;

  FeatureTree._resetInstanceClasses(nameEl, multLabel);

  if (isCycleInner) {
    if (nameEl) nameEl.classList.add("feature-tree-name-cycle-disabled");
    return;
  }

  let state = FeatureTree._computeInstanceState({
    ancestors: ancestors,
    nodeName: nodeName,
    uniqueName: uniqueName,
    checkbox: checkbox
  });

  if (nameEl) {
    if (state.bold) nameEl.classList.add("feature-tree-name-bold");
    if (isMultiRef) {
      nameEl.classList.add(state.violated
        ? "feature-tree-name-multiref-violated"
        : "feature-tree-name-multiref");
    } else if (state.violated) {
      nameEl.classList.add("feature-tree-name-violated");
    }
  }

  if (multLabel) {
    let multState = FeatureTree._computeMultiplicityLabelState({
      ancestors: ancestors,
      uniqueName: uniqueName
    });
    if (multState.violated) {
      multLabel.classList.add("feature-tree-mult-label-violated");
    }
  }
};

FeatureTree._resetInstanceClasses = function(nameEl, multLabel) {
  nameEl?.classList.remove(
    "feature-tree-name-bold",
    "feature-tree-name-violated",
    "feature-tree-name-multiref",
    "feature-tree-name-multiref-violated",
    "feature-tree-name-cycle-disabled"
  );
  multLabel?.classList.remove("feature-tree-mult-label-violated");
};

FeatureTree._computeInstanceState = function(ctx) {
  return FeatureTree.computeConstraintStateForInstance({
    constraints: FeatureTree.constraints,
    ancestors: ctx.ancestors,
    nodeName: ctx.nodeName,
    uniqueName: ctx.uniqueName,
    hasCheckbox: !!ctx.checkbox,
    isChecked: ctx.checkbox && ctx.checkbox.checked,
    isAncestorActive: FeatureTree._isAncestorActive,
    isMemberActive: function(name) {
      return Page.mixsetsActive.includes(name);
    }
  });
};

FeatureTree.computeConstraintStateForInstance = function(opts) {
  let constraints = (opts && opts.constraints) || [];
  let ancestors = (opts && opts.ancestors) || [];
  let nodeName = opts && opts.nodeName;
  let uniqueName = opts && opts.uniqueName;
  let hasCheckbox = !(opts && opts.hasCheckbox === false);
  let isChecked = !!(opts && opts.isChecked);
  let isAncestorActive = (opts && opts.isAncestorActive)
    || function() { return false; };
  let isMemberActive = (opts && opts.isMemberActive)
    || function() { return false; };

  let bold = false;
  let violated = false;
  for (let i = 0; i < constraints.length; i++) {
    let c = constraints[i];
    if (!ancestors.includes(c.sourceUniqueName)) continue;
    if (!isAncestorActive(c.sourceUniqueName)) continue;

    if (c.type === "mandatory") {
      let targetMatches = c.targetUniqueName
        ? c.targetUniqueName === uniqueName
        : c.targetName === nodeName;
      if (targetMatches) {
        bold = true;
        if (hasCheckbox && !isChecked) violated = true;
      }
    } else if (c.type === "multiplicity") {
      if (c.members?.includes(nodeName)) {
        let count = 0;
        for (let j = 0; j < c.members.length; j++) {
          if (isMemberActive(c.members[j])) count++;
        }
        if (c.min >= 1) bold = true;
        if (count < c.min || count > c.max) violated = true;
      }
    } else if (c.type === "exclude") {
      let excludeTargetMatches = c.targetUniqueName
        ? c.targetUniqueName === uniqueName
        : c.targetName === nodeName;
      if (excludeTargetMatches) {
        if (hasCheckbox && isChecked) {
          violated = true;
        }
      }
    }
  }
  return { bold: bold, violated: violated };
};

FeatureTree._computeMultiplicityLabelState = function(ctx) {
  if (!FeatureTree.constraints) return { violated: false };
  for (let i = 0; i < FeatureTree.constraints.length; i++) {
    let c = FeatureTree.constraints[i];
    if (c.type !== "multiplicity") continue;
    if (c.targetUniqueName !== ctx.uniqueName) continue;
    if (!ctx.ancestors.includes(c.sourceUniqueName)) continue;
    if (!FeatureTree._isAncestorActive(c.sourceUniqueName)) continue;
    let count = FeatureTree._countCheckedMembers(c.members);
    if (count < c.min || count > c.max) return { violated: true };
  }
  return { violated: false };
};

FeatureTree._countCheckedMembers = function(members) {
  if (!members) return 0;
  let n = 0;
  for (let i = 0; i < members.length; i++) {
    if (Page.mixsetsActive.includes(members[i])) n++;
  }
  return n;
};

FeatureTree.onCheckboxChange = function(nodeName, checked) {
  FeatureTree._syncCheckboxInstances(nodeName, checked);
  Action.toggleMixsetUseStatement(nodeName);
  FeatureTree.evaluateConstraints();
};

FeatureTree._syncCheckboxInstances = function(nodeName, checked) {
  if (!FeatureTree.container) return;
  let boxes = FeatureTree.container.querySelectorAll(
    'input.feature-tree-checkbox[data-id="' + FeatureTree._fmtToCss(nodeName) + '"]');
  for (let i = 0; i < boxes.length; i++) {
    if (boxes[i].checked !== checked) {
      boxes[i].checked = checked;
    }
  }
};

FeatureTree._fmtToCss = function(value) {
  return String(value).replace(/["\\]/g, "\\$&");
};

FeatureTree.getModelFromResponse = function(responseText) {
  if (!responseText || typeof responseText !== "string") {
    console.error("responseText is not a String");
    return null;
  }
  let splitMarker = "<p>URL_SPLIT";
  let idx = responseText.indexOf(splitMarker);
  if (idx === -1) {
    return null;
  }
  let jsonText = responseText.substring(idx + splitMarker.length).trim();
  if (jsonText.length === 0) {
    return null;
  }
  try {
    let parsed = JSON.parse(jsonText);
    return parsed && parsed.featureModel !== undefined ? parsed : null;
  } catch (e) {
    console.warn("FeatureTree: failed to parse FeatureModelJson from response", e);
    return null;
  }
};

// Floating-modal controller for the feature tree.
var FeatureTreeModal = {
  _domBound: false,
  _escapeBound: false,
  _lastTriggerButton: null,
  _fetchInFlight: false,
  _fetchId: 0,
  _savedScroll: 0,

  init: function() {
    if (FeatureTreeModal._domBound) return;
    FeatureTreeModal._domBound = true;

    let btn = document.getElementById("buttonSelectReq");
    if (btn) {
      btn.addEventListener("click", function(e) {
        e.preventDefault();
        FeatureTreeModal._lastTriggerButton = btn;
        FeatureTreeModal.open();
      });
      btn.addEventListener("keydown", function(e) {
        if (e.key === "Enter" || e.key === " ") {
          e.preventDefault();
          FeatureTreeModal._lastTriggerButton = btn;
          FeatureTreeModal.open();
        }
      });
    }
    let closeBtn = document.getElementById("btnCloseFeatureTree");
    if (closeBtn) {
      closeBtn.addEventListener("click", function() { FeatureTreeModal.close(); });
      closeBtn.addEventListener("keydown", function(e) {
        if (e.key === "Enter" || e.key === " ") {
          e.preventDefault();
          FeatureTreeModal.close();
        }
      });
    }
    let retry = document.getElementById("featureTreeRetryLink");
    if (retry) {
      retry.addEventListener("click", function(e) {
        e.preventDefault();
        FeatureTreeModal.requestFetch();
      });
    }
    let modal = document.getElementById("featureTreeModal");
    if (modal) {
      let overlay = modal.querySelector(".dialog-overlay");
      if (overlay) {
        overlay.addEventListener("click", function() { FeatureTreeModal.close(); });
      }
    }
    if (!FeatureTreeModal._escapeBound) {
      FeatureTreeModal._escapeBound = true;
      document.addEventListener("keydown", function(e) {
        if (e.key === "Escape" && FeatureTreeModal.isOpen()) {
          FeatureTreeModal.close();
        }
      });
    }
  },

  isOpen: function() {
    let m = document.getElementById("featureTreeModal");
    return !!(m && !m.classList.contains("is-hidden"));
  },

  open: function() {
    let modal = document.getElementById("featureTreeModal");
    if (!modal) return;
    FeatureTreeModal.refreshBody();
    modal.classList.remove("is-hidden");
  },

  close: function() {
    let modal = document.getElementById("featureTreeModal");
    if (!modal) return;
    let wasOpen = !modal.classList.contains("is-hidden");
    modal.classList.add("is-hidden");
    if (!wasOpen) return;
    let body = document.getElementById("featureTreeModalBody");
    if (body) FeatureTreeModal._savedScroll = body.scrollTop;
    FeatureTreeModal._lastTriggerButton?.focus();
  },

  // Render current FeatureTree.model into the mount. states: loading (spinner + hide tree), empty (info + retry), data (render tree).
  refreshBody: function() {
    let mount = document.getElementById("featureModelTreeContainer");
    let empty = document.getElementById("featureTreeModalEmpty");
    let spin  = document.getElementById("featureTreeModalLoading");
    let body  = document.getElementById("featureTreeModalBody");
    if (!mount) return;
    let prevScroll = body ? body.scrollTop : FeatureTreeModal._savedScroll;

    if (FeatureTreeModal._fetchInFlight) {
      mount.style.display = "none";
      if (empty) empty.classList.add("is-hidden");
      if (spin) spin.classList.remove("is-hidden");
      return;
    }
    let hasData = FeatureTree.model
      && FeatureTree.rootIds
      && FeatureTree.rootIds.length > 0;
    if (hasData) {
      FeatureTree.render(mount);
      mount.style.display = "";
      if (empty) empty.classList.add("is-hidden");
      if (spin) spin.classList.add("is-hidden");
      if (body) body.scrollTop = prevScroll;
    } else {
      while (mount.firstChild) mount.removeChild(mount.firstChild);
      mount.style.display = "none";
      if (empty) empty.classList.remove("is-hidden");
      if (spin) spin.classList.add("is-hidden");
    }
  },

  // Manually trigger a FeatureModelJson fetch
  requestFetch: function() {
    Action.fetchFeatureModelTreeThen(function() {});
  },

  showPaletteSection: function() {
    jQuery("#paletteFeatureSelectReqSection").show();
  },

  hidePaletteSection: function() {
    FeatureTreeModal.close();
    jQuery("#paletteFeatureSelectReqSection").hide();
  }
};
