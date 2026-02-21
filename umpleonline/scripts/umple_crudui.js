// In-memory storage for CRUD instances; no persistence or database
Page.crudData = { classes: {} };

// Lookup of class definitions (attributes) by class name for nested types
Page.crudClassDefs = {};

// Association metadata resolved from Json (per navigable end, grouped by class)
Page.crudAssociationsByClass = {};

// Container used for inline CRUD panel rendering
Page.currentCrudContainer = null;

Page.resetCrudData = function() {
  Page.crudData = { classes: {} };
  Page.crudClassDefs = {};
  Page.crudAssociationsByClass = {};
};

// Updates instance count for each class
Page.updateCrudClassCount = function(className) {
  if (!Page.crudData || !Page.crudData.classes || !Page.crudData.classes[className]) {
    return;
  }
  var instances = Page.crudData.classes[className].instances || [];
  var count = instances.length;
  jQuery(".crud-class-item[data-class='" + className + "'] .crud-class-count").text("[" + count + "]");
};

// Normalize type information from an attribute's type string
Page.getCrudTypeInfo = function(rawType) {
  var t = (rawType || "").toString();
  var lower = t.toLowerCase();
  var isArray = lower.indexOf("[]") !== -1;
  var baseLower = isArray ? lower.replace(/\[\]/g, "") : lower; // removes [] from array
  return {
    raw: t,
    lower: lower,
    isArray: isArray,
    base: baseLower
  };
};

// Build tooltip HTML to help user know what the data type is for a class attribute
// and whether it is inherited. We return an HTML string that will be used with a
// per-element jQuery UI tooltip (via data-crud-tooltip-html) so that we can
// render line breaks using <br/>.
Page.buildCrudTooltip = function(attrName, rawType, inheritedFrom) {
  var typeText = rawType || "";
  var lines = [];

  lines.push(attrName + " : " + typeText);

  if (inheritedFrom) {
    lines.push("This is an inherited attribute from " + inheritedFrom + ".");
  }

  var html = lines.join("<br/>");

  // Escape double quotes so the HTML can be safely embedded in an attribute
  return html.replace(/"/g, "&quot;");
};

// Parse a multiplicity string like "1", "0..1", "1..*", "3..*", "0..2" into
// a numeric range { min, max } where max === null means unbounded.
Page.parseCrudMultiplicity = function(multiplicity) {
  var s = (multiplicity || "").toString().trim();
  var result = { min: 0, max: null };

  if (s === "") {
    return result;
  }

  // Simple forms: "*" or a single integer
  if (s.indexOf("..") === -1) {
    if (s === "*") {
      return { min: 0, max: null };
    }
    var n = parseInt(s, 10);
    if (!isNaN(n)) {
      return { min: n, max: n };
    }
    return result;
  }

  // Range form: "a..b", where b may be "*"
  var parts = s.split("..");
  var lowerRaw = (parts[0] || "").trim();
  var upperRaw = (parts[1] || "").trim();

  var min = 0;
  if (lowerRaw !== "") {
    var lower = parseInt(lowerRaw, 10);
    if (!isNaN(lower) && lower >= 0) {
      min = lower;
    }
  }

  var max = null;
  if (upperRaw !== "" && upperRaw !== "*") {
    var upper = parseInt(upperRaw, 10);
    if (!isNaN(upper) && upper >= min) {
      max = upper;
    }
  }

  return { min: min, max: max };
};

// For hierarchical self-reflexive associations where each instance can have at
// most one parent (e.g., FunctionalArea parent/child), verify that assigning
// parentIndex as the parent of childIndex does not create a cycle.
Page.checkCrudReflexiveHierarchyCycle = function(className, instances, end, childIndex, parentIndex, errors) {
  if (end.fromClass !== end.toClass) {
    return;
  }

  // We only treat patterns like * to 0..1 as hierarchical parent/child.
  var fromHasStar = (end.fromMultiplicity || "").indexOf("*") !== -1;
  var toRange = { min: typeof end.toMin === "number" ? end.toMin : 0, max: end.toMax };
  if (!fromHasStar || (toRange.max !== null && toRange.max !== 1)) {
    return;
  }

  if (typeof parentIndex !== "number" || parentIndex < 0 || parentIndex >= instances.length) {
    return;
  }

  var fieldName = end.storageKey;
  var visited = {};
  var current = parentIndex;

  while (typeof current === "number" && current >= 0 && current < instances.length) {
    if (current === childIndex) {
      errors.push("Cycle detected in association " + end.assocName + ": a " + className + " cannot be its own ancestor.");
      return;
    }
    if (visited[current]) {
      return; // already walked this path
    }
    visited[current] = true;

    var inst = instances[current] || {};
    var next = inst[fieldName];
    if (Array.isArray(next)) {
      next = next.length ? next[0] : null;
    }
    if (typeof next !== "number") {
      var n = parseInt(next, 10);
      next = isNaN(n) ? null : n;
    }
    current = next;
  }
};

// Keep reverse association ends in sync for bidirectional associations. When
// editing an instance of className at position index and updating a navigable
// end, this ensures the corresponding reverse end on the target class's
// instances reflects the new links.
Page.syncCrudReverseAssociationsForEnd = function(className, index, end, newValue) {
  if (!Page.crudAssociationsByClass || !Page.crudData || !Page.crudData.classes) {
    return;
  }

  var fromClass = end.fromClass;
  var toClass = end.toClass;
  if (fromClass !== className) {
    return;
  }

  // For hierarchical self-reflexive associations (e.g., FunctionalArea
  // parent/child where one side is many and the other is single), we do
  // not maintain explicit reverse links. Children store a parent reference,
  // and parents derive their children by scanning those references. If we
  // tried to sync reverse links here, we would end up writing back into the
  // same field on other instances (since fromClass === toClass) and make it
  // appear as though parents have parents they do not actually own.
  if (fromClass === toClass && end.reflexiveHierarchy) {
    return;
  }

  var targetInfo = Page.crudData.classes[toClass];
  if (!targetInfo) {
    return;
  }
  var targetInstances = targetInfo.instances || [];

  // Find reverse end: same association id, from the target class back to
  // this class.
  var reverseEnd = null;
  var candidates = Page.crudAssociationsByClass[toClass] || [];
  for (var i = 0; i < candidates.length; i++) {
    var cand = candidates[i];
    if (cand.assocId === end.assocId && cand.toClass === fromClass) {
      reverseEnd = cand;
      break;
    }
  }
  if (!reverseEnd) {
    return;
  }

  var revKey = reverseEnd.storageKey;
  var revMultiple = reverseEnd.toMultiplicity && reverseEnd.toMultiplicity.indexOf("*") !== -1;

  // Helper to know whether the edited instance should be linked to a given
  // target index according to newValue.
  var isLinked;
  if (Array.isArray(newValue)) {
    var set = {};
    for (var s = 0; s < newValue.length; s++) {
      var v = newValue[s];
      if (typeof v === "number" && v >= 0) {
        set[v] = true;
      }
    }
    isLinked = function(tIdx) { return !!set[tIdx]; };
  } else if (typeof newValue === "number" && newValue >= 0) {
    isLinked = function(tIdx) { return newValue === tIdx; };
  } else {
    isLinked = function() { return false; };
  }

  for (var tIdx = 0; tIdx < targetInstances.length; tIdx++) {
    var tInst = targetInstances[tIdx] || {};
    var linked = isLinked(tIdx);

    if (revMultiple) {
      var arr = Array.isArray(tInst[revKey]) ? tInst[revKey].slice() : [];
      var pos = arr.indexOf(index);
      if (linked && pos === -1) {
        arr.push(index);
      }
      if (!linked && pos !== -1) {
        arr.splice(pos, 1);
      }
      tInst[revKey] = arr;
    } else {
      if (linked) {
        tInst[revKey] = index;
      } else if (tInst[revKey] === index) {
        tInst[revKey] = null;
      }
    }
  }
};

// Remove an instance and reindex association links that point to this class.
Page.removeCrudInstance = function(className, index) {
  if (!Page.crudData || !Page.crudData.classes || !Page.crudData.classes[className]) {
    return;
  }
  var classInfo = Page.crudData.classes[className];
  var instances = classInfo.instances || [];
  if (index < 0 || index >= instances.length) {
    return;
  }

  var assocByClass = Page.crudAssociationsByClass || {};
  var inst = instances[index];

  // First, handle composition: if this class is the composition owner for
  // any association ends, delete the composed (part) instances referenced
  // from this instance, regardless of multiplicity.
  var endsFromThis = assocByClass[className] || [];
  endsFromThis.forEach(function(end) {
    if (!end || !end.cascadeDeleteTargets) { return; }
    var key = end.storageKey;
    var val = inst[key];
    if (val === undefined || val === null) { return; }

    var targetIndices = [];
    if (Array.isArray(val)) {
      val.forEach(function(v) {
        if (typeof v !== "number") { v = parseInt(v, 10); }
        if (!isNaN(v) && v >= 0) {
          targetIndices.push(v);
        }
      });
    } else {
      var v2 = val;
      if (typeof v2 !== "number") { v2 = parseInt(v2, 10); }
      if (!isNaN(v2) && v2 >= 0) {
        targetIndices.push(v2);
      }
    }

    if (!targetIndices.length) { return; }

    // Delete targets in descending order so that earlier indices remain
    // valid as we remove later ones.
    targetIndices.sort(function(a, b) { return b - a; });
    targetIndices.forEach(function(tIdx) {
      Page.removeCrudInstance(end.toClass, tIdx);
    });
  });

  // Remove the instance itself
  instances.splice(index, 1);

  // Reindex any association links that point to this class
  for (var sourceClass in assocByClass) {
    if (!assocByClass.hasOwnProperty(sourceClass)) { continue; }
    var ends = assocByClass[sourceClass] || [];
    if (!ends.length) { continue; }
    var sourceInfo = Page.crudData.classes[sourceClass];
    if (!sourceInfo) { continue; }
    var sourceInstances = sourceInfo.instances || [];

    ends.forEach(function(end) {
      if (!end || end.toClass !== className) { return; }
      var key = end.storageKey;

      sourceInstances.forEach(function(inst) {
        var val = inst[key];
        if (Array.isArray(val)) {
          var arr = val.slice();
          var changed = false;
          var newArr = [];
          arr.forEach(function(v) {
            if (typeof v !== "number") { return; }
            if (v === index) { changed = true; return; }
            if (v > index) {
              newArr.push(v - 1);
              changed = true;
            } else {
              newArr.push(v);
            }
          });
          if (changed) {
            inst[key] = newArr;
          }
        } else {
          var v2 = val;
          if (typeof v2 !== "number") {
            v2 = parseInt(v2, 10);
            if (isNaN(v2)) { return; }
          }
          if (v2 === index) {
            inst[key] = null;
          } else if (v2 > index) {
            inst[key] = v2 - 1;
          }
        }
      });
    });
  }

  // Update the visible instance count for this class so that any
  // header buttons (ClassName [count]) stay in sync after deletes,
  // including those triggered via composition cascades.
  if (Page.updateCrudClassCount) {
    Page.updateCrudClassCount(className);
  }
};

// Builds the HTML input(s) for a single field given its type
Page.buildCrudInputHtml = function(attrName, typeInfo) {
  var baseType = typeInfo.base;
  var isArray = typeInfo.isArray;
  var rawType = typeInfo.raw;

  // Boolean: radio buttons
  if (baseType === "boolean" || baseType === "bool") {
    return "<div class='crud-boolean' style='display:inline-block;'>" +
           "<label><input type='radio' name='" + attrName + "' value='true'> True</label>" +
           "<label><input type='radio' name='" + attrName + "' value='false'> False</label>" +
           "</div>";
  }

  // Arrays: comma-separated values in a text box (supports any base type)
  if (isArray) {
    var classDefForArray = Page.getAttributeType && Page.getAttributeType(rawType);

    // Special handling for arrays of class types: render a small editor with an
    // Add another button and a list of added entries
    if (classDefForArray) {
      return Page.buildCrudClassArrayHtml(attrName, classDefForArray);
    }

    var placeholder = "Enter comma-separated values";
    return "<input type='text' name='" + attrName + "' placeholder='" + placeholder + "' " +
           "style='padding:2px 4px;margin-right:8px;' />";
  }

  // Integer / int: numeric input, whole numbers only
  if (baseType === "integer" || baseType === "int") {
    return "<input type='number' name='" + attrName + "' step='1' style='padding:2px 4px;margin-right:8px;' />";
  }

  // Double / Float: numeric input, decimals allowed
  if (baseType === "double" || baseType === "float") {
    return "<input type='number' name='" + attrName + "' step='any' style='padding:2px 4px;margin-right:8px;' />";
  }

  // Date
  if (baseType === "date") {
    return "<input type='date' name='" + attrName + "' style='padding:2px 4px;margin-right:8px;' />";
  }

  // Time
  if (baseType === "time") {
    return "<input type='time' name='" + attrName + "' style='padding:2px 4px;margin-right:8px;' />";
  }

  // Character: single character only
  if (baseType === "character" || baseType === "char") {
    return "<input type='text' name='" + attrName + "' maxlength='1' style='padding:2px 4px;margin-right:8px;' />";
  }

  // String: plain text
  if (baseType === "string") {
    return "<input type='text' name='" + attrName + "' style='padding:2px 4px;margin-right:8px;' />";
  }

  // Enum types: rendered as dropdowns. Enums may be defined locally on a
  // class (umpleClasses[].enums) or globally (globalEnums).
  var enumOptions = Page.resolveCrudEnumOptions && Page.resolveCrudEnumOptions(rawType);
  if (enumOptions && enumOptions.length) {
    var html = "<select name='" + attrName + "' style='padding:2px 4px;margin-right:8px;'>";
    html += "<option value=''>-- select --</option>";
    enumOptions.forEach(function(opt) {
      if (opt === null || typeof opt === "undefined") { return; }
      var val = opt.toString();
      html += "<option value='" + val.replace(/\"/g, "&quot;") + "'>" + val + "</option>";
    });
    html += "</select>";
    return html;
  }

  return Page.buildCrudForClassType(attrName, typeInfo);
};

// Function to build inputs for class data type
Page.buildCrudForClassType = function(attrName, typeInfo) {
  var baseType = typeInfo.base;
  var rawType = typeInfo.raw;
  var isArray = typeInfo.isArray;

  // Nested user-defined class type: render its attributes inline
  var classDef = Page.getAttributeType && Page.getAttributeType(rawType);
  if (!isArray && classDef) {
    var nestedHtml = "<div class='crud-nested'>";
    classDef.forEach(function(subAttr) {
      var subName = subAttr.name;
      if (!subName) { return; }
      var subTypeInfo = Page.getCrudTypeInfo(subAttr.type);
      var tooltipHtml = Page.buildCrudTooltip(subName, subAttr.type, subAttr.inheritedFrom);
      nestedHtml += "<div class='crud-nested-field'>";
      nestedHtml += "<label class='crud-nested-label'><span class='crud-tooltip-target' data-crud-tooltip-html=\"" + tooltipHtml + "\">" + subName + "</span></label>";
      nestedHtml += Page.buildCrudInputHtml(attrName + "." + subName, subTypeInfo);
      nestedHtml += "</div>";
    });
    nestedHtml += "</div>";
    return nestedHtml;
  }

  // Any other non-class, non-primitive type (e.g., enums)
  return "<span class='crud-unsupported-type'>" + rawType + " Yet to be handled</span>";
};

// Builds the UI for an attribute that is an array of a class data type
Page.buildCrudClassArrayHtml = function(attrName, classDef) {
  var html = "<div class='crud-class-array' data-attr='" + attrName + "'>";

  // Existing items list (filled when editing an instance)
  html += "<div class='crud-class-array-items'></div>";

  // Editor for a single element in the array
  html += "<div class='crud-class-array-editor'>";
  html += "<div class='crud-nested'>";

  classDef.forEach(function(subAttr) {
    var subName = subAttr.name;
    if (!subName) { return; }
    var subTypeInfo = Page.getCrudTypeInfo(subAttr.type);
    var tooltipHtml = Page.buildCrudTooltip(subName, subAttr.type, subAttr.inheritedFrom);
    var fieldName = attrName + "." + subName;
    html += "<div class='crud-nested-field'>";
    html += "<label class='crud-nested-label'><span class='crud-tooltip-target' data-crud-tooltip-html=\"" + tooltipHtml + "\">" + subName + "</span></label>";
    html += Page.buildCrudInputHtml(fieldName, subTypeInfo);
    html += "</div>";
  });

  html += "</div>"; // .crud-nested

  // Hidden field to track whether we are editing an existing element
  html += "<input type='hidden' class='crud-class-array-index' value='' />";

  // Buttons for managing elements
  html += "<div class='crud-class-array-buttons'>";
  html += "<button type='button' class='crud-class-array-add' data-attr='" + attrName + "'>Add / Update</button>";
  html += "<button type='button' class='crud-class-array-clear' data-attr='" + attrName + "' style='margin-left:6px;'>Clear all</button>";
  html += "</div>";

  html += "</div>"; // .crud-class-array-editor
  html += "</div>";   // .crud-class-array

  return html;
};

// Resolve a class definition (its attributes) for a given class name
Page.getAttributeType = function(rawType) {
  if (!Page.crudClassDefs) {
    return null;
  }
  var t = (rawType || "").toString();
  // Strips array suffix if present, e.g., "GPSCoord[]" -> "GPSCoord"
  var key = t.replace(/\[\]/g, "");
  return Page.crudClassDefs[key] || null;
};

// Resolve enum options for a given type name, preferring class-local enums
// for the current crudClassSelected if available, otherwise falling back to
// globalEnums.
Page.resolveCrudEnumOptions = function(rawType) {
  var t = (rawType || "").toString();
  if (!t) { return null; }
  // Strip any array suffix;
  var name = t.replace(/\[\]/g, "");

  // Prefer local enums on the currently edited class, if present
  var currentClass = Page.crudClassSelected;
  if (currentClass && Page.crudEnumsByClass && Page.crudEnumsByClass[currentClass]) {
    var localMap = Page.crudEnumsByClass[currentClass];
    if (localMap[name] && Array.isArray(localMap[name])) {
      return localMap[name];
    }
  }

  // Fall back to global enums
  if (Page.crudGlobalEnums && Page.crudGlobalEnums[name] && Array.isArray(Page.crudGlobalEnums[name])) {
    return Page.crudGlobalEnums[name];
  }

  return null;
};

// Formats time value (e.g., "19:50") as 12-hour with AM/PM (e.g., "7:50 PM")
Page.formatCrudTime = function(value) {
  if (typeof value === "undefined" || value === null) {
    return "";
  }
  var s = value.toString();
  var lower = s.toLowerCase();
  // If the user already typed am/pm, keep it as-is
  if (lower.indexOf("am") !== -1 || lower.indexOf("pm") !== -1) {
    return s;
  }
  // Expect HH:MM or H:MM[:SS]; if it doesn't match, return original
  var m = /^(\d{1,2}):(\d{2})(?::(\d{2}))?$/.exec(s);
  if (!m) {
    return s;
  }
  var h = parseInt(m[1], 10);
  var minute = m[2];
  if (isNaN(h)) {
    return s;
  }
  var suffix = h >= 12 ? "PM" : "AM";
  var hour12 = h % 12;
  if (hour12 === 0) {
    hour12 = 12;
  }
  return hour12 + ":" + minute + " " + suffix;
};

// Format a stored value back into a string suitable for display in summaries
Page.formatCrudDisplayValue = function(value, typeInfo) {
  var baseType = typeInfo && typeInfo.base;

  if (Array.isArray(value)) {
    // Arrays are shown as comma-separated values; if the elements are
    // objects (e.g., class-typed arrays), shows key=value pairs for each.
    if (value.length > 0 && typeof value[0] === "object") {
      var parts = [];
      value.forEach(function(item) {
        if (!item || typeof item !== "object") { return; }
        var inner = [];
        for (var k in item) {
          if (!item.hasOwnProperty(k)) { continue; }
          var v = item[k];
          if (typeof v === "undefined" || v === null || v === "") { continue; }
          inner.push(k + "=" + v);
        }
        if (inner.length > 0) {
          parts.push("{" + inner.join(", ") + "}");
        }
      });
      return parts.join("; ");
    }
    return value.join(", ");
  }
  if (typeof value === "undefined" || value === null) {
    return "";
  }
  // Nested object (class-typed attribute): show key=value pairs
  if (typeof value === "object") {
    var partsObj = [];
    for (var key in value) {
      if (!value.hasOwnProperty(key)) { continue; }
      var v2 = value[key];
      if (typeof v2 === "undefined" || v2 === null || v2 === "") { continue; }
      partsObj.push(key + "=" + v2);
    }
    if (partsObj.length > 0) {
      return partsObj.join(", ");
    }
    return "";
  }
  if (baseType === "time") {
    return Page.formatCrudTime(value);
  }
  return value.toString();
};

// Format a stored value back into a string suitable for filling form inputs
Page.formatCrudInputValue = function(value, typeInfo) {
  var baseType = typeInfo && typeInfo.base;

  if (Array.isArray(value)) {
    // For inputs, arrays are always edited as comma-separated raw values
    return value.join(", ");
  }
  if (typeof value === "undefined" || value === null) {
    return "";
  }
  // For time inputs 
  if (baseType === "time") {
    return value.toString();
  }
  return value.toString();
};

// Parse the value for a single field from the form, performing type-specific validation
// Returns the parsed value; on error, pushes messages into errors[] and may return undefined
Page.parseCrudFieldValue = function($form, attrName, typeInfo, errors) {
  var baseType = typeInfo.base;
  var isArray = typeInfo.isArray;

  // Boolean / Boolean
  if (baseType === "boolean" || baseType === "bool") {
    var checked = $form.find("input[name='" + attrName + "']:checked").val();
    if (checked === "true") {
      return true;
    }
    if (checked === "false") {
      return false;
    }
    return "";
  }

  // Prefer a <select> element when present (used for enums). If there is no
  // select, fall back to a plain input field.
  var $select = $form.find("select[name='" + attrName + "']");
  var raw;
  if ($select.length > 0) {
    raw = $select.val();
  } else {
    var $input = $form.find("input[name='" + attrName + "']");
    raw = $input.val();
  }
  var trimmed = jQuery.trim(raw == null ? "" : raw);

  // Empty value: treat as empty string or empty array, no error
  if (trimmed === "") {
    return isArray ? [] : "";
  }

  // Arrays: comma-separated values, validate element-wise based on base type
  if (isArray) {
    var parts = trimmed.split(",");
    var out = [];
    var hadError = false;
    parts.forEach(function(p) {
      var v = jQuery.trim(p);
      if (v === "") { return; }
      // Integer / int elements
      if (baseType === "integer" || baseType === "int") {
        var n = parseInt(v, 10);
        if (isNaN(n)) {
          hadError = true;
        } else {
          out.push(n);
        }
      }
      // Double / Float elements
      else if (baseType === "double" || baseType === "float") {
        var f = parseFloat(v);
        if (isNaN(f)) {
          hadError = true;
        } else {
          out.push(f);
        }
      }
      // Boolean elements
      else if (baseType === "boolean" || baseType === "bool") {
        var lower = v.toLowerCase();
        if (lower === "true") {
          out.push(true);
        } else if (lower === "false") {
          out.push(false);
        } else {
          hadError = true;
        }
      }
      // Character elements
      else if (baseType === "character" || baseType === "char") {
        if (v.length !== 1) {
          hadError = true;
        } else {
          out.push(v);
        }
      }
      // For String, Date, Time, and unknown: keep trimmed strings
      else {
        out.push(v);
      }
    });
    if (hadError) {
      errors.push("Invalid value(s) for " + attrName + ". Expected comma-separated " + baseType + "s.");
    }
    return out;
  }

  // Primitive numeric types and character
  if (baseType === "integer" || baseType === "int") {
    var n2 = parseInt(trimmed, 10);
    if (isNaN(n2)) {
      errors.push("Invalid value for " + attrName + " (expected integer).");
      return undefined;
    }
    return n2;
  }

  if (baseType === "double" || baseType === "float") {
    var f2 = parseFloat(trimmed);
    if (isNaN(f2)) {
      errors.push("Invalid value for " + attrName + " (expected number).");
      return undefined;
    }
    return f2;
  }

  if (baseType === "character" || baseType === "char") {
    if (trimmed.length !== 1) {
      errors.push("Invalid value for " + attrName + " (expected single character).");
      return undefined;
    }
    return trimmed;
  }

  // String, Date, Time or any other type: accept trimmed string
  return trimmed;
};

// Shows simple info panel for abstract classes when their header is clicked
Page.showCrudAbstractMessage = function(className) {
  var container = Page.currentCrudContainer || jQuery("#innerGeneratedCodeRow");
  var $panel = container.find(".crud-instance-panel");
  if ($panel.length === 0) {
    $panel = jQuery("<div class='crud-instance-panel' style='margin-top:10px;'></div>");
    container.append($panel);
  }

  var html = "<div class='crud-dialog-content'>";
  html += "<h3>" + className + "</h3>";
  html += "<p>This is an abstract class. It cannot be instantiated.</p>";
  html += "</div>";

  $panel.html(html);
};

// Sets up clickable class headers and hides underlying forms
Page.initCrudUi = function(tabnumber) {
  var container = jQuery("#innerGeneratedCodeRow" + tabnumber);

  // Remember current container for inline CRUD panel rendering
  Page.currentCrudContainer = container;

  container.find(".crud-form").each(function() {
    var $form = jQuery(this);
    var className = $form.data("class");
    if (!className) { return; }

    var isAbstract = $form.data("abstract") === true || $form.data("abstract") === "true";

    // Ensure storage exists for this class
    if (!Page.crudData.classes[className]) {
      Page.crudData.classes[className] = {
        attributes: [],
        instances: [],
        isAbstract: isAbstract
      };
    }

    // Adds a single clickable header per class, styled as a button
    if (container.find(".crud-class-item[data-class='" + className + "']").length === 0) {
      var headerHtml = "<a class='button2 crud-class-item' data-class='" + className + "' data-abstract='" + (isAbstract ? "true" : "false") + "'>" +
                       "<span class='crud-class-name'>" + className + "</span>";
      if (!isAbstract) {
        headerHtml += " <span class='crud-class-count'>[0]</span>";
      }
      headerHtml += "</a>";
      $form.before(headerHtml);
    }

    // Hide the raw form; interaction happens via popup dialog
    $form.hide();
  });

  // Click handler: open popup dialog for chosen class
  container.find(".crud-class-item").off("click").on("click", function() {
    var $item = jQuery(this);
    var className = $item.data("class");
    var isAbstract = $item.data("abstract") === true || $item.data("abstract") === "true";

    // Visually indicate the selected class header
    container.find(".crud-class-item").removeClass("crud-class-item-active active");
    $item.addClass("crud-class-item-active active");

    if (isAbstract) {
      Page.showCrudAbstractMessage(className);
    } else {
      Page.openCrudDialogForClass(className);
    }
  });
};

Page.openCrudDialogForClass = function(className) {
  if (!Page.crudData || !Page.crudData.classes || !Page.crudData.classes[className]) {
    return;
  }

  // Remember which class is currently being edited so enum resolution can
  // first look for enums defined locally on this class.
  Page.crudClassSelected = className;

  var classInfo = Page.crudData.classes[className];
  var attrs = classInfo.attributes || [];
  var instances = classInfo.instances || [];

  // Simple HTML escaper for safely rendering attribute values in the
  // instance summary table.
  function escapeHtml(str) {
    if (str === null || str === undefined) { return ""; }
    return String(str)
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;")
      .replace(/'/g, "&#39;");
  }

  // Gather association ends for this class, including any inherited from
  // its superclasses, using the extends map built from the JSON.
  var assocEnds = [];
  if (Page.crudAssociationsByClass) {
    var seenAssocKeysForClass = {};
    var currentClassName = className;
    while (currentClassName) {
      var ends = Page.crudAssociationsByClass[currentClassName] || [];
      ends.forEach(function(end) {
        if (!end) { return; }
        var key = (end.assocId || "") + "::" + (end.toClass || "") + "::" + (end.direction || "");
        if (seenAssocKeysForClass[key]) { return; }
        seenAssocKeysForClass[key] = true;
        assocEnds.push(end);
      });
      var extendsMap = Page.crudExtendsByClass || {};
      currentClassName = extendsMap[currentClassName] || null;
    }
  }
  var container = Page.currentCrudContainer || jQuery("#innerGeneratedCodeRow");
  var $panel = container.find(".crud-instance-panel");
  if ($panel.length === 0) {
    $panel = jQuery("<div class='crud-instance-panel' style='margin-top:10px;'></div>");
    container.append($panel);
  }

  // If this class has mandatory (multiplicity 1) navigable associations to other
  // classes (min bound > 0), and there are currently too few instances of those
  // target classes to ever satisfy the multiplicity, prevent creating instances
  // and instruct the user to create required ones first.
  if (assocEnds.length > 0) {
    var missingRequiredTargets = [];
    assocEnds.forEach(function(end) {
      var minRequired = (typeof end.toMin === "number") ? end.toMin : 0;
      if (minRequired <= 0) { return; }
      var targetInfo = Page.crudData.classes[end.toClass];
      var targetInstances = (targetInfo && targetInfo.instances) || [];
      if (targetInstances.length < minRequired) {
        if (missingRequiredTargets.indexOf(end.toClass) === -1) {
          missingRequiredTargets.push(end.toClass);
        }
      }
    });
    if (missingRequiredTargets.length > 0 && instances.length === 0) {
      var msgHtml = "<div class='crud-dialog-content'>";
      msgHtml += "<h3>" + className + "</h3>";
      msgHtml += "<p>To create " + className + " instances, first create the following: " + missingRequiredTargets.join(", ") + ".</p>";
      msgHtml += "</div>";
      $panel.html(msgHtml);
      return;
    }
  }

  var html = "<div class='crud-dialog-content'>";
  html += "<h3 style='margin-bottom:8px;'>" + className + " instances (" + instances.length + ")</h3>";

  // Existing instances list
  html += "<div class='crud-instance-list' style='margin-bottom:10px;'>";
  if (instances.length === 0) {
    html += "<p>No instances yet.</p>";
  } else {
    // Render instances as a dedicated CRUD table with its own CSS
    html += "<div class='crud-instance-table-wrap'>";
    html += "<table class='crud-instance-table'>";
    html += "<thead><tr>";
    html += "<th>Instance</th>";
    attrs.forEach(function(attr) {
      var name = attr.name;
      if (!name) { return; }
      html += "<th>" + escapeHtml(name) + "</th>";
    });
    html += "<th>Actions</th>";
    html += "</tr></thead><tbody>";

    instances.forEach(function(inst, idx) {
      html += "<tr class='crud-instance-row' data-index='" + idx + "'>";
      html += "<td class='crud-instance-label'>" + className + "[" + (idx + 1) + "]</td>";

      attrs.forEach(function(attr) {
        var name = attr.name;
        if (!name) { return; }
        var val = inst[name];
        var typeInfo = Page.getCrudTypeInfo(attr.type);
        var classDef = Page.getAttributeType && Page.getAttributeType(attr.type);
        var displayVal = Page.formatCrudDisplayValue(val, typeInfo);
        if (displayVal !== "" && classDef && !typeInfo.isArray) {
          // Class-typed primitive attributes: wrap their key=value pairs in braces
          displayVal = "{" + displayVal + "}";
        }
        var cellText = displayVal === "" ? "" : escapeHtml(displayVal);
        // Use a non-breaking space for empty cells so borders render correctly
        html += "<td>" + (cellText || "&nbsp;") + "</td>";
      });

      html += "<td>";
      // Action dropdown for each instance
      html += "<select class='crud-instance-action' data-index='" + idx + "'>";
      html += "<option value=''>Select action...</option>";
      html += "<option value='edit'>Edit</option>";
      html += "<option value='delete'>Delete</option>";
      if (assocEnds.length > 0) {
        html += "<option value='associations'>See Associations</option>";
      }
      html += "</select>";

      // Hidden buttons so we can reuse existing click handlers for
      // edit/delete/see-associations without duplicating logic.
      html += "<button type='button' class='crud-edit-instance' data-index='" + idx + "' style='display:none;'></button>";
      html += "<button type='button' class='crud-delete-instance' data-index='" + idx + "' style='display:none;'></button>";
      if (assocEnds.length > 0) {
        html += "<button type='button' class='crud-see-associations' data-index='" + idx + "' style='display:none;'></button>";
      }

      html += "</td>";

      html += "</tr>";
    });

    html += "</tbody></table></div>";
  }
  html += "</div>";

  // Add/Edit form
  html += "<h4>Add / Edit Instance</h4>";
  html += "<div class='crud-error' style='color:red;margin-bottom:6px;display:none;'></div>";
  html += "<form id='crud-instance-form' data-class='" + className + "'>";
  html += "<input type='hidden' name='instanceIndex' value='' />";

  attrs.forEach(function(attr) {
    var attrName = attr.name;
    var typeInfo = Page.getCrudTypeInfo(attr.type);
    if (!attrName) { return; }
    html += "<div class='crud-field'>";
    var tooltipHtml = Page.buildCrudTooltip(attrName, attr.type, attr.inheritedFrom);
    html += "<label class='crud-field-label'><span class='crud-tooltip-target' data-crud-tooltip-html=\"" + tooltipHtml + "\">" + attrName + "</span></label>";
    html += Page.buildCrudInputHtml(attrName, typeInfo);

    html += "</div>";
  });

  // Association selectors for navigable ends from this class
  // We generally render selectors for all navigable ends, but we hide the
  // "reverse" side of one-to-many associations (e.g., Employee -> Accident)
  // to avoid large multi-selects when a clearer owner side exists. For true
  // many-to-many (* to *) associations, we still show selectors so links can
  // be edited from each navigable side.
  var assocSelectorEnds = [];
  var seenReflexiveAssoc = {};
  assocEnds.forEach(function(end) {
    var multTo = end.toMultiplicity || "";
    var multFrom = end.fromMultiplicity || "";
    var toHasStar = multTo.indexOf("*") !== -1;
    var fromHasStar = multFrom.indexOf("*") !== -1;

    // Hide the reverse of a one-to-many: if the target side allows many (*),
    // but the source side does not, it is clearer to edit links from the
    // opposite end. Example: Employee -> Accident when Accident -> Employee
    // is 1..*.
    // Only apply this when the association is truly bidirectional; for
    // unidirectional associations, this is the only navigable end and must
    // remain visible (including when inherited by subclasses).
    if (end.isBidirectional && toHasStar && !fromHasStar) {
      return;
    }

    // For self-reflexive associations (fromClass === toClass), we can end up
    // with two navigable ends that look identical from the UI perspective.
    // Only keep one per association id so we don't render duplicate groups
    // (e.g., Territory[*] borders Territory[*]).
    if (end.fromClass === end.toClass) {
      var key = (end.assocId || end.assocName || "") + "::" + end.toClass;
      if (seenReflexiveAssoc[key]) {
        return;
      }
      seenReflexiveAssoc[key] = true;
    }

    // Otherwise (including many-to-many where both sides use *), show it.
    assocSelectorEnds.push(end);
  });

  if (assocSelectorEnds.length > 0) {
    html += "<h4>Associations</h4>";
    assocSelectorEnds.forEach(function(end) {
      var targetClass = end.toClass;
      var targetInfo = Page.crudData.classes[targetClass];
      var targetInstances = (targetInfo && targetInfo.instances) || [];
      var fieldName = end.storageKey;

      html += "<div class='crud-field'>";
      var labelText = targetClass;
      if (end.fromClass === end.toClass && end.roleName) {
        labelText += " (" + end.roleName + ")";
      }
      var minRequired = (typeof end.toMin === "number") ? end.toMin : 0;
      if (minRequired > 0) {
        labelText += " (required)";
      }
      var assocTooltip = "";
      if (end.inheritedFrom) {
        assocTooltip = "This is an inherited association from " + end.inheritedFrom + ".";
      }
      if (end.cascadeDeleteTargets) {
        var compText = className + " composes " + targetClass + " (deleting " + className + " will also delete its " + targetClass + " instances).";
        assocTooltip = assocTooltip ? (assocTooltip + " " + compText) : compText;
      }
      if (assocTooltip) {
        html += "<label class='crud-field-label'><span class='crud-tooltip-target' title='" + assocTooltip.replace(/\"/g, "&quot;") + "'>" + labelText + "</span></label>";
      } else {
        html += "<label class='crud-field-label'>" + labelText + "</label>";
      }

      // Use checkbox list whenever the target multiplicity allows more than
      // one associated instance (e.g., 2..4, 0..*, 1..*). Radio buttons are
      // reserved for strictly single-valued ends where max === 1.
      var multiple = true;
      if (typeof end.toMax === "number" && end.toMax <= 1) {
        multiple = false;
      }

      // Build a richer tooltip for each association option including
      // class name, role (for reflexive associations), attribute list,
      // and the record's attribute values.
      var buildAssocOptionTooltip = function(endMeta, targetClassName, optionLabel, instObj, targetAttrs) {
        var lines = [];
        lines.push("<b>Class:</b> " + targetClassName);
        if (endMeta.fromClass === endMeta.toClass && endMeta.roleName) {
          lines.push("<b>Role from this " + endMeta.fromClass + ":</b> " + endMeta.roleName);
        }

        var attrDescs = [];
        targetAttrs.forEach(function(attr) {
          if (attr && attr.name) {
            var desc = attr.name;
            if (attr.type) {
              desc += ":" + attr.type;
            }
            attrDescs.push(desc);
          }
        });
        if (attrDescs.length) {
          lines.push("<b>Attributes:</b> " + attrDescs.join(", "));
        }

        var parts = [];
        targetAttrs.forEach(function(attr) {
          var aName = attr.name;
          if (!aName) { return; }
          var v = instObj[aName];
          if (typeof v === "undefined" || v === null || v === "") { return; }
          parts.push(aName + "=" + v);
        });
        if (parts.length) {
          lines.push("<b>Record:</b> " + parts.join(", "));
        } else {
          lines.push("<b>Record:</b> (no attribute values set)");
        }

        var tooltipHtml = lines.join("<br/>");
        return tooltipHtml.replace(/\"/g, "&quot;");
      };

      if (multiple) {
        // Multi-valued end: render a checkbox list so users can easily
        // add/remove multiple associated instances (e.g., many-to-many).
        html += "<div class='crud-assoc-multi' data-field='" + fieldName + "'>";
        targetInstances.forEach(function(inst, idx) {
          var optionLabel = targetClass + "[" + (idx + 1) + "]";
          var targetAttrs = (Page.crudData.classes[targetClass] && Page.crudData.classes[targetClass].attributes) || [];
          var tooltipEsc = buildAssocOptionTooltip(end, targetClass, optionLabel, inst, targetAttrs);
          html += "<label style='margin-right:8px;'>" +
            "<input type='checkbox' name='" + fieldName + "' value='" + idx + "'> " +
            "<span class='crud-tooltip-target' data-crud-tooltip-html=\"" + tooltipEsc + "\">" + optionLabel + "</span>" +
            "</label>";
        });
        html += "</div>";
      } else {
        // Single-valued end: render radio buttons (with an explicit None
        // option when the multiplicity allows 0) instead of a dropdown.
        html += "<div class='crud-assoc-single' data-field='" + fieldName + "'>";
        if (minRequired === 0) {
          html += "<label style='margin-right:8px;'><input type='radio' name='" + fieldName + "' value=''> None</label>";
        }

        targetInstances.forEach(function(inst, idx) {
          var optionLabel = targetClass + "[" + (idx + 1) + "]";
          var targetAttrs = (Page.crudData.classes[targetClass] && Page.crudData.classes[targetClass].attributes) || [];
          var tooltipEsc = buildAssocOptionTooltip(end, targetClass, optionLabel, inst, targetAttrs);
          html += "<label style='margin-right:8px;'>" +
            "<input type='radio' name='" + fieldName + "' value='" + idx + "'> " +
            "<span class='crud-tooltip-target' data-crud-tooltip-html=\"" + tooltipEsc + "\">" + optionLabel + "</span>" +
            "</label>";
        });
        html += "</div>";
      }

      // If there are no target instances and multiplicity requires one, hint to create them first
      if (targetInstances.length < minRequired && minRequired > 0) {
        html += "<div class='crud-association-hint' style='margin-top:4px;color:#a00;'>" +
                "Not enough " + targetClass + " instances exist. Create more before adding " + className + "." +
                "</div>";
      }

      html += "</div>";
    });
  }

  html += "<div class='crud-form-actions' style='margin-top:8px;'>";
  html += "<button type='button' id='crud-save-instance' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button primary' style='margin-right:8px;'>Save</button>";
  html += "<button type='button' id='crud-clear-instances' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button'>Clear all " + className + "</button>";
  html += "</div>";
  html += "</form>";
  html += "<div class='crud-related-instances' style='margin-top:8px;'></div>";
  html += "</div>";

  $panel.html(html);

  // Initialize HTML-based tooltips for CRUD association options that
  // provided rich HTML content via data-crud-tooltip-html. We attach
  // per-element jQuery UI tooltips here so we can use <br> and other
  // markup in the tooltip body 
  $panel.find(".crud-tooltip-target[data-crud-tooltip-html]").each(function() {
    var htmlContent = jQuery(this).attr("data-crud-tooltip-html");
    if (!htmlContent) { return; }
    jQuery(this).tooltip({
      items: this.tagName.toLowerCase(),
      content: htmlContent,
      show: { delay: 1000 },
      // Prevent the global dwell-time animation from auto-hiding CRUD
      // tooltips; we want them to disappear only on mouseleave.
      open: function(event, ui) {
        if (ui && ui.tooltip) {
          ui.tooltip.css({
            animation: "none",
            "-webkit-animation": "none",
            "-moz-animation": "none",
            "-o-animation": "none"
          });
        }
      }
    });
  });

  // Remove previous handlers to avoid duplicates
  $panel.off();

  // Handle action dropdown selection for each instance row
  $panel.on("change", ".crud-instance-action", function() {
    var action = jQuery(this).val();
    var index = jQuery(this).data("index");
    if (!action) {
      return;
    }

    if (action === "edit") {
      $panel.find(".crud-edit-instance[data-index='" + index + "']").trigger("click");
    } else if (action === "delete") {
      $panel.find(".crud-delete-instance[data-index='" + index + "']").trigger("click");
    } else if (action === "associations") {
      $panel.find(".crud-see-associations[data-index='" + index + "']").trigger("click");
    }

    // For Edit, keep the dropdown showing Edit to reflect current mode.
    // For other actions, reset back to the placeholder.
    if (action === "edit") {
      jQuery(this).val("edit");
    } else {
      jQuery(this).val("");
    }
  });

  $panel.on("click", ".crud-edit-instance", function() {
    var index = parseInt(jQuery(this).data("index"), 10);
    if (isNaN(index) || index < 0 || index >= instances.length) {
      return;
    }
    var inst = instances[index] || {};
    var $form = $panel.find("#crud-instance-form");
    $form.find("input[name='instanceIndex']").val(index);

    attrs.forEach(function(attr) {
      var attrName = attr.name;
      var typeInfo = Page.getCrudTypeInfo(attr.type);
      var baseType = typeInfo.base;
      if (!attrName) { return; }
      var value = inst[attrName];
      var classDef = Page.getAttributeType && Page.getAttributeType(attr.type);

      // Class-typed array attribute: populate its items list
      if (typeInfo.isArray && classDef) {
        var $containerArr = $form.find(".crud-class-array[data-attr='" + attrName + "']");
        if ($containerArr.length > 0) {
          var items = Array.isArray(value) ? value.slice() : [];
          $containerArr.data("items", items);
          Page.renderCrudClassArrayItems($containerArr, attrName, items);
          // Clear editor fields and index
          $containerArr.find(".crud-class-array-index").val("");
          classDef.forEach(function(subAttr) {
            var subName = subAttr.name;
            if (!subName) { return; }
            var fieldName = attrName + "." + subName;
            $form.find("input[name='" + fieldName + "']").val("");
          });
        }
      }
      // Nested class-typed attribute: populate each sub-field
      else if (!typeInfo.isArray && classDef) {
        var nestedObj = value || {};
        classDef.forEach(function(subAttr) {
          var subName = subAttr.name;
          if (!subName) { return; }
          var nestedTypeInfo = Page.getCrudTypeInfo(subAttr.type);
          var nestedBase = nestedTypeInfo.base;
          var nestedValue = nestedObj[subName];
          var fieldName = attrName + "." + subName;
          if (nestedBase === "boolean" || nestedBase === "bool") {
            var trueInputNested = $form.find("input[name='" + fieldName + "'][value='true']");
            var falseInputNested = $form.find("input[name='" + fieldName + "][value='false']");
            trueInputNested.prop("checked", nestedValue === true || nestedValue === "true");
            falseInputNested.prop("checked", nestedValue === false || nestedValue === "false");
          } else {
            var nestedInputValue = Page.formatCrudInputValue(nestedValue, nestedTypeInfo);
            $form.find("input[name='" + fieldName + "']").val(nestedInputValue);
          }
        });
      }
      // Primitive / array attributes
      else if (baseType === "boolean" || baseType === "bool") {
        var trueInput = $form.find("input[name='" + attrName + "'][value='true']");
        var falseInput = $form.find("input[name='" + attrName + "'][value='false']");
        trueInput.prop("checked", value === true || value === "true");
        falseInput.prop("checked", value === false || value === "false");
      } else {
        var inputValue = Page.formatCrudInputValue(value, typeInfo);
        var $selectField = $form.find("select[name='" + attrName + "']");
        if ($selectField.length > 0) {
          $selectField.val(inputValue);
        } else {
          $form.find("input[name='" + attrName + "']").val(inputValue);
        }
      }
    });

    // Pre-populate association selectors based on stored links on the instance
    assocEnds.forEach(function(end) {
      var fieldName = end.storageKey;
      var stored = inst[fieldName];
      // Keep multiplicity interpretation consistent with rendering/saving:
      // multi-valued when max bound allows more than one.
      var multiple = true;
      if (typeof end.toMax === "number" && end.toMax <= 1) {
        multiple = false;
      }
      var minRequired = (typeof end.toMin === "number") ? end.toMin : 0;

      if (multiple) {
        var $checks = $form.find("input[type='checkbox'][name='" + fieldName + "']");
        $checks.prop("checked", false);
        if (Array.isArray(stored)) {
          $checks.each(function() {
            var v = jQuery(this).val();
            var idx = parseInt(v, 10);
            if (!isNaN(idx) && stored.indexOf(idx) !== -1) {
              jQuery(this).prop("checked", true);
            }
          });
        }
      } else {
        var $radios = $form.find("input[type='radio'][name='" + fieldName + "']");
        $radios.prop("checked", false);
        if (stored === undefined || stored === null || stored === "") {
          // If there is an explicit None option (minRequired === 0), select it
          // so the user can clearly see that "no association" is a choice.
          if (minRequired === 0) {
            $radios.each(function() {
              if (jQuery(this).val() === "") {
                jQuery(this).prop("checked", true);
              }
            });
          }
        } else {
          var targetVal = Array.isArray(stored) ? (stored[0] || "") : stored;
          $radios.each(function() {
            var v = jQuery(this).val();
            if (v === "") { return; }
            var idx = parseInt(v, 10);
            if (!isNaN(idx) && idx === targetVal) {
              jQuery(this).prop("checked", true);
            }
          });
        }
      }
    });

    // Show related instances from other classes that are linked to this one
    var $related = $panel.find(".crud-related-instances");
    if ($related.length > 0) {
      var relatedHtml = "";
      var assocByClass = Page.crudAssociationsByClass || {};
      for (var sourceClass in assocByClass) {
        if (!assocByClass.hasOwnProperty(sourceClass)) { continue; }
        var endsFromSource = assocByClass[sourceClass] || [];
        var seenAssocIds = {};
        endsFromSource.forEach(function(end) {
          // Only show reverse-linked instances for bidirectional associations
          if (!end.isBidirectional) { return; }
          if (end.toClass !== className) { return; }
          // Avoid duplicate groups for self-reflexive associations where two
          // navigable ends correspond to the same logical relationship.
          if (end.fromClass === end.toClass) {
            var key = end.assocId || end.assocName || "";
            if (seenAssocIds[key]) { return; }
            seenAssocIds[key] = true;
          }
          var sourceInfo = Page.crudData.classes[sourceClass];
          var sourceInstances = (sourceInfo && sourceInfo.instances) || [];
          if (sourceInstances.length === 0) { return; }
          var matches = [];
          sourceInstances.forEach(function(sInst, sIdx) {
            var val = sInst[end.storageKey];
            if (val === undefined || val === null) { return; }
            if (Array.isArray(val)) {
              if (val.indexOf(index) !== -1) {
                matches.push({ inst: sInst, idx: sIdx });
              }
            } else if (val === index) {
              matches.push({ inst: sInst, idx: sIdx });
            }
          });
          if (matches.length > 0) {
            relatedHtml += "<div class='crud-related-group' style='margin-top:4px;'>";
            relatedHtml += "<div><strong>" + sourceClass + " linked to this " + className + ":</strong></div>";
            var srcAttrs = (Page.crudData.classes[sourceClass] && Page.crudData.classes[sourceClass].attributes) || [];
            matches.forEach(function(match) {
              var label = sourceClass + "[" + (match.idx + 1) + "]";
              var parts = [];
              srcAttrs.forEach(function(attr) {
                var aName = attr.name;
                if (!aName) { return; }
                var v = match.inst[aName];
                if (typeof v === "undefined" || v === null || v === "") { return; }
                parts.push(aName + "=" + v);
              });
              var summary = parts.length ? " - " + parts.join(", ") : "";
              relatedHtml += "<div style='margin-left:10px;'>" + label + summary + "</div>";
            });
            relatedHtml += "</div>";
          }
        });
      }
      $related.html(relatedHtml);
    }
  });

  // Delete existing instance
  $panel.on("click", ".crud-delete-instance", function() {
    var index = parseInt(jQuery(this).data("index"), 10);
    if (isNaN(index) || index < 0 || index >= instances.length) {
      return;
    }
    Page.removeCrudInstance(className, index);
    Page.updateCrudClassCount(className);
    Page.openCrudDialogForClass(className);
  });

  // Show associations for a specific instance in the list
  $panel.on("click", ".crud-see-associations", function(event) {
    // Prevent this click from bubbling back up to the row handler,
    // which would otherwise retrigger this handler and recurse.
    if (event && typeof event.stopPropagation === "function") {
      event.stopPropagation();
    }
    var index = parseInt(jQuery(this).data("index"), 10);
    if (isNaN(index) || index < 0 || index >= instances.length) {
      return;
    }
    var inst = instances[index] || {};
    var $row = jQuery(this).closest(".crud-instance-row");
    // For the table layout, render associations in a dedicated row
    // immediately following the instance row, spanning all columns.
    var $table = $row.closest("table");
    var colCount = $table.find("thead th").length || ($row.children("td").length || 1);
    var $assocRow = $row.next(".crud-instance-associations-row");
    var $assoc;

    // Toggle visibility if an associations row already exists
    if ($assocRow.length) {
      $assoc = $assocRow.find(".crud-instance-associations");
      if ($assocRow.is(":visible")) {
        $assocRow.hide();
        return;
      }
    } else {
      $assocRow = jQuery("<tr class='crud-instance-associations-row'><td colspan='" + colCount + "'><div class='crud-instance-associations' style='margin-top:4px;'></div></td></tr>");
      $row.after($assocRow);
      $assoc = $assocRow.find(".crud-instance-associations");
    }

    var assocHtml = "";
    var hasContent = false;

    // Forward associations: navigable ends from this class
    var seenAssocIdsForward = {};
    assocEnds.forEach(function(end) {
      var fieldName = end.storageKey;
      var val = inst[fieldName];
      var targetClass = end.toClass;
      var targetInfo = Page.crudData.classes[targetClass];
      var targetInstances = (targetInfo && targetInfo.instances) || [];
      var targetAttrs = (targetInfo && targetInfo.attributes) || [];

      if (val === undefined || val === null) {
        return;
      }

      // Avoid duplicate groups for self-reflexive associations where two
      // navigable ends correspond to the same logical relationship.
      if (end.fromClass === end.toClass) {
        var keyF = end.assocId || end.assocName || "";
        if (seenAssocIdsForward[keyF]) { return; }
        seenAssocIdsForward[keyF] = true;
      }

      var items = [];
      // Align multiplicity interpretation with form rendering/saving: treat
      // an end as multi-valued when its max bound allows more than one.
      var multiple = true;
      if (typeof end.toMax === "number" && end.toMax <= 1) {
        multiple = false;
      }
      if (multiple) {
        if (!Array.isArray(val) || val.length === 0) { return; }
        val.forEach(function(idx) {
          if (typeof idx !== "number" || idx < 0 || idx >= targetInstances.length) { return; }
          items.push({ inst: targetInstances[idx], idx: idx });
        });
      } else {
        var idxSingle = val;
        if (typeof idxSingle !== "number") {
          idxSingle = parseInt(idxSingle, 10);
        }
        if (isNaN(idxSingle) || idxSingle < 0 || idxSingle >= targetInstances.length) { return; }
        items.push({ inst: targetInstances[idxSingle], idx: idxSingle });
      }

      if (items.length === 0) {
        return;
      }

      hasContent = true;
      var headerLabel = targetClass;
      if (end.fromClass === end.toClass && end.roleName) {
        headerLabel += " (" + end.roleName + ")";
      }

      assocHtml += "<div class='crud-related-group' style='margin-top:4px;'>";
      assocHtml += "<div>" + headerLabel + " associated with this " + className + ":</div>";
      assocHtml += "<div class='crud-assoc-table-wrap'>";
      assocHtml += "<table class='crud-assoc-table'>";
      assocHtml += "<thead><tr><th>Instance</th>";
      targetAttrs.forEach(function(attr) {
        var aName = attr.name;
        if (!aName) { return; }
        assocHtml += "<th>" + aName + "</th>";
      });
      assocHtml += "</tr></thead><tbody>";

      items.forEach(function(item) {
        var label = targetClass + "[" + (item.idx + 1) + "]";
        assocHtml += "<tr><td>" + label + "</td>";
        targetAttrs.forEach(function(attr) {
          var aName = attr.name;
          if (!aName) { return; }
          var v = item.inst[aName];
          var text = (typeof v === "undefined" || v === null || v === "") ? "" : v;
          assocHtml += "<td>" + (text === "" ? "&nbsp;" : String(text)) + "</td>";
        });
        assocHtml += "</tr>";
      });

      assocHtml += "</tbody></table></div></div>";
    });

    // For hierarchical self-reflexive associations where only one side
    // stores the link (e.g., child -> parent), also show the reverse
    // perspective in this panel: from a parent record, list its children
    // without modifying any stored associations.
    assocEnds.forEach(function(end) {
      if (!end.reflexiveHierarchy) { return; }
      if (end.fromClass !== end.toClass) { return; }

      var fieldName = end.storageKey;
      var classInfo = Page.crudData.classes[className];
      var allInstances = (classInfo && classInfo.instances) || [];
      if (!allInstances.length) { return; }

      var children = [];
      allInstances.forEach(function(otherInst, otherIdx) {
        if (otherIdx === index) { return; }
        var linkVal = otherInst[fieldName];
        if (linkVal === undefined || linkVal === null) { return; }
        var parentIdx = linkVal;
        if (Array.isArray(parentIdx)) {
          // Hierarchical patterns should store a single parent index, but
          // handle arrays defensively by checking membership.
          if (parentIdx.indexOf(index) === -1) { return; }
        } else {
          if (typeof parentIdx !== "number") {
            parentIdx = parseInt(parentIdx, 10);
          }
          if (isNaN(parentIdx) || parentIdx !== index) { return; }
        }
        children.push({ inst: otherInst, idx: otherIdx });
      });

      if (!children.length) { return; }

      hasContent = true;
      var revHeader = className;
      if (end.oppositeRoleName) {
        revHeader += " (" + end.oppositeRoleName + ")";
      }

      assocHtml += "<div class='crud-related-group' style='margin-top:4px;'>";
      assocHtml += "<div>" + revHeader + " associated with this " + className + ":</div>";
      assocHtml += "<div class='crud-assoc-table-wrap'>";
      assocHtml += "<table class='crud-assoc-table'>";
      assocHtml += "<thead><tr><th>Instance</th>";
      var attrsForClass = (classInfo && classInfo.attributes) || [];
      attrsForClass.forEach(function(attr) {
        var aName = attr.name;
        if (!aName) { return; }
        assocHtml += "<th>" + aName + "</th>";
      });
      assocHtml += "</tr></thead><tbody>";

      children.forEach(function(child) {
        var label = className + "[" + (child.idx + 1) + "]";
        assocHtml += "<tr><td>" + label + "</td>";
        attrsForClass.forEach(function(attr) {
          var aName = attr.name;
          if (!aName) { return; }
          var v = child.inst[aName];
          var text = (typeof v === "undefined" || v === null || v === "") ? "" : v;
          assocHtml += "<td>" + (text === "" ? "&nbsp;" : String(text)) + "</td>";
        });
        assocHtml += "</tr>";
      });

      assocHtml += "</tbody></table></div></div>";
    });

    if (!hasContent) {
      assocHtml = "<em>No associations linked for this instance.</em>";
    }

    $assoc.html(assocHtml).show();
  });

  // Save instance (new or edited)
  $panel.on("click", "#crud-save-instance", function() {
    var $form = $panel.find("#crud-instance-form");
    var $error = $panel.find(".crud-error");
    $error.hide().text("");
    var errors = [];
    var indexVal = $form.find("input[name='instanceIndex']").val();
    var isEdit = indexVal !== "";
    var index = isEdit ? parseInt(indexVal, 10) : instances.length;
    if (isEdit && (isNaN(index) || index < 0 || index >= instances.length)) {
      index = instances.length;
      isEdit = false;
    }

    var newInst = {};
    attrs.forEach(function(attr) {
      var attrName = attr.name;
      var typeInfo = Page.getCrudTypeInfo(attr.type);
      if (!attrName) { return; }
      var classDef = Page.getAttributeType && Page.getAttributeType(attr.type);

      // Class-typed array attribute: take items from the per-field array editor
      if (typeInfo.isArray && classDef) {
        var $containerArr = $form.find(".crud-class-array[data-attr='" + attrName + "']");
        var items = $containerArr.length ? ($containerArr.data("items") || []) : [];
        newInst[attrName] = items;
      }
      // Nested class-typed Primitive attribute: build an object from its sub-fields
      else if (!typeInfo.isArray && classDef) {
        var nestedObj = {};
        classDef.forEach(function(subAttr) {
          var subName = subAttr.name;
          if (!subName) { return; }
          var nestedTypeInfo = Page.getCrudTypeInfo(subAttr.type);
          var fieldName = attrName + "." + subName;
          var parsedNested = Page.parseCrudFieldValue($form, fieldName, nestedTypeInfo, errors);
          if (typeof parsedNested !== "undefined") {
            nestedObj[subName] = parsedNested;
          }
        });
        newInst[attrName] = nestedObj;
      }
      // Primitive / non-class array attributes
      else {
        var parsed = Page.parseCrudFieldValue($form, attrName, typeInfo, errors);
        if (typeof parsed !== "undefined") {
          newInst[attrName] = parsed;
        }
      }
    });

    // Associations: enforce multiplicity rules and capture selected links
    assocEnds.forEach(function(end) {
      var fieldName = end.storageKey;
      // Treat an end as multi-valued whenever its max bound allows
      // more than one linked instance. This covers ranges like 2..4,
      // 0..* and 1..* in addition to explicit "*".
      var multiple = true;
      if (typeof end.toMax === "number" && end.toMax <= 1) {
        multiple = false;
      }
      var minRequired = (typeof end.toMin === "number") ? end.toMin : 0;
      var maxAllowed = (typeof end.toMax === "number") ? end.toMax : null;

      if (multiple) {
        // Checkbox-based UI for multi-valued ends
        var selectedArray = [];
        var $checks = $form.find("input[type='checkbox'][name='" + fieldName + "']:checked");
        $checks.each(function() {
          selectedArray.push(jQuery(this).val());
        });
        var indices = [];
        selectedArray.forEach(function(v) {
          if (v === "") { return; }
          var idx = parseInt(v, 10);
          if (!isNaN(idx)) {
            indices.push(idx);
          }
        });

        // Reflexive constraint: prevent self-reference in many-valued
        // self-associations (e.g., Territory borders itself).
        if (end.fromClass === end.toClass) {
          var selfPos = indices.indexOf(index);
          if (selfPos !== -1) {
            indices.splice(selfPos, 1);
            errors.push("An instance of " + className + " cannot be associated with itself for association " + end.assocName + ".");
          }
        }

        newInst[fieldName] = indices;

        var count = indices.length;
        var relationLabel = end.cascadeDeleteTargets ? "composition" : "association";
        if (minRequired > 0 && count < minRequired) {
          var remaining = minRequired - count;
          if (remaining > 0) {
            var instanceLabel = remaining === 1 ? " instance" : " instances";
            errors.push("Please select " + remaining + " more " + end.toClass + instanceLabel + " for " + relationLabel + " " + end.assocName + ".");
          }
        }
        if (maxAllowed !== null && count > maxAllowed) {
          errors.push("Please select at most " + maxAllowed + " " + end.toClass + " instance(s) for " + relationLabel + " " + end.assocName + ".");
        }
      } else {
        // Radio-based UI for single-valued ends
        var $radio = $form.find("input[type='radio'][name='" + fieldName + "']:checked");
        var val = $radio.length ? $radio.val() : "";
        if (!val || val === "") {
          // If min bound is >= 1, this link is mandatory
          if (minRequired >= 1) {
            var relationLabelSingle = end.cascadeDeleteTargets ? "composition" : "association";
            errors.push("Please select a " + end.toClass + " for " + relationLabelSingle + " " + end.assocName + ".");
          }
          newInst[fieldName] = null;
        } else {
          var idxSingle = parseInt(val, 10);
          if (isNaN(idxSingle)) {
            if (minRequired >= 1) {
              var relationLabelInvalid = end.cascadeDeleteTargets ? "composition" : "association";
              errors.push("Invalid selection for " + relationLabelInvalid + " " + end.assocName + ".");
            }
            newInst[fieldName] = null;
          } else {
            // Reflexive constraint: prevent self-reference.
            if (end.fromClass === end.toClass && idxSingle === index) {
              var relationLabelSelf = end.cascadeDeleteTargets ? "composition" : "association";
              errors.push("An instance of " + className + " cannot be associated with itself for " + relationLabelSelf + " " + end.assocName + ".");
              newInst[fieldName] = null;
            } else {
            newInst[fieldName] = idxSingle;
              // With a single-select, we can only ever have 0 or 1; enforce
              // any max bound < 1 as an error, and otherwise accept.
              if (maxAllowed !== null && maxAllowed < 1) {
                var relationLabelMult = end.cascadeDeleteTargets ? "composition" : "association";
                errors.push("Multiplicity for " + relationLabelMult + " " + end.assocName + " does not allow any linked " + end.toClass + " instances.");
              }
            }
          }
        }
      }
    });

    // For hierarchical self-reflexive associations (like FunctionalArea
    // parent/child), ensure that choosing a parent does not introduce a
    // parent-child cycle.
    assocEnds.forEach(function(end) {
      if (end.fromClass !== end.toClass) { return; }
      var multiple = true;
      if (typeof end.toMax === "number" && end.toMax <= 1) {
        multiple = false;
      }
      if (multiple) { return; }
      var value = newInst[end.storageKey];
      if (typeof value !== "number") { return; }
      Page.checkCrudReflexiveHierarchyCycle(className, instances, end, index, value, errors);
    });

    if (errors.length > 0) {
      $error.text(errors.join(" ")).show();
      return;
    }

    // Keep reverse association ends consistent for bidirectional associations
    // using the newly computed link values on this instance.
    assocEnds.forEach(function(end) {
      var fieldName = end.storageKey;
      var newVal = newInst[fieldName];
      Page.syncCrudReverseAssociationsForEnd(className, index, end, newVal);
    });

    if (isEdit) {
      instances[index] = newInst;
    } else {
      instances.push(newInst);
    }

    Page.updateCrudClassCount(className);
    // Re-render inline panel so the new/updated instance appears immediately
    Page.openCrudDialogForClass(className);
  });

  // Clear all instances for this class
  $panel.on("click", "#crud-clear-instances", function() {
    Page.crudData.classes[className].instances = [];
    Page.updateCrudClassCount(className);
    Page.openCrudDialogForClass(className);
  });

  // ----- Class array (ClassType[]) element management -----

  // Add or update an element in a class-array 
  $panel.on("click", ".crud-class-array-add", function() {
    var attrName = jQuery(this).data("attr");
    var $form = $panel.find("#crud-instance-form");
    var $error = $panel.find(".crud-error");
    var $container = $form.find(".crud-class-array[data-attr='" + attrName + "']");
    if ($container.length === 0) { return; }

    var attrMeta = null;
    attrs.forEach(function(a) {
      if (a.name === attrName) { attrMeta = a; }
    });
    if (!attrMeta) { return; }

    var classDef = Page.getAttributeType && Page.getAttributeType(attrMeta.type);
    if (!classDef) { return; }

    var errorsLocal = [];
    var elementObj = {};
    classDef.forEach(function(subAttr) {
      var subName = subAttr.name;
      if (!subName) { return; }
      var nestedTypeInfo = Page.getCrudTypeInfo(subAttr.type);
      var fieldName = attrName + "." + subName;
      var parsed = Page.parseCrudFieldValue($form, fieldName, nestedTypeInfo, errorsLocal);
      if (typeof parsed !== "undefined") {
        elementObj[subName] = parsed;
      }
    });

    if (errorsLocal.length > 0) {
      $error.text(errorsLocal.join(" ")).show();
      return;
    }

    var items = $container.data("items") || [];
    var idxField = $container.find(".crud-class-array-index");
    var idxVal = idxField.val();
    if (idxVal !== "") {
      var idx = parseInt(idxVal, 10);
      if (!isNaN(idx) && idx >= 0 && idx < items.length) {
        items[idx] = elementObj;
      } else {
        items.push(elementObj);
      }
    } else {
      items.push(elementObj);
    }

    $container.data("items", items);
    Page.renderCrudClassArrayItems($container, attrName, items);

    // Clear editor fields and index
    idxField.val("");
    classDef.forEach(function(subAttr) {
      var subName = subAttr.name;
      if (!subName) { return; }
      var fieldName = attrName + "." + subName;
      $form.find("input[name='" + fieldName + "']").val("");
    });
  });

  // Clear all elements from a class-array attribute
  $panel.on("click", ".crud-class-array-clear", function() {
    var attrName = jQuery(this).data("attr");
    var $form = $panel.find("#crud-instance-form");
    var $container = $form.find(".crud-class-array[data-attr='" + attrName + "']");
    if ($container.length === 0) { return; }

    var items = [];
    $container.data("items", items);
    Page.renderCrudClassArrayItems($container, attrName, items);
    $container.find(".crud-class-array-index").val("");

    // Clear editor fields
    var attrMeta = null;
    attrs.forEach(function(a) { if (a.name === attrName) { attrMeta = a; } });
    var classDef = attrMeta && Page.getAttributeType && Page.getAttributeType(attrMeta.type);
    if (classDef) {
      classDef.forEach(function(subAttr) {
        var subName = subAttr.name;
        if (!subName) { return; }
        var fieldName = attrName + "." + subName;
        $form.find("input[name='" + fieldName + "']").val("");
      });
    }
  });

  // Edit a specific element from the class-array list
  $panel.on("click", ".crud-class-array-edit-item", function() {
    var attrName = jQuery(this).data("attr");
    var idx = parseInt(jQuery(this).data("index"), 10);
    var $form = $panel.find("#crud-instance-form");
    var $container = $form.find(".crud-class-array[data-attr='" + attrName + "']");
    if ($container.length === 0 || isNaN(idx)) { return; }

    var items = $container.data("items") || [];
    if (idx < 0 || idx >= items.length) { return; }
    var elementObj = items[idx] || {};

    var attrMeta = null;
    attrs.forEach(function(a) { if (a.name === attrName) { attrMeta = a; } });
    var classDef = attrMeta && Page.getAttributeType && Page.getAttributeType(attrMeta.type);
    if (!classDef) { return; }

    classDef.forEach(function(subAttr) {
      var subName = subAttr.name;
      if (!subName) { return; }
      var nestedTypeInfo = Page.getCrudTypeInfo(subAttr.type);
      var fieldName = attrName + "." + subName;
      var v = elementObj[subName];
      var inputVal = Page.formatCrudInputValue(v, nestedTypeInfo);
      $form.find("input[name='" + fieldName + "']").val(inputVal);
    });

    $container.find(".crud-class-array-index").val(idx);
  });

  // Remove an element from the class-array list
  $panel.on("click", ".crud-class-array-remove-item", function() {
    var attrName = jQuery(this).data("attr");
    var idx = parseInt(jQuery(this).data("index"), 10);
    var $form = $panel.find("#crud-instance-form");
    var $container = $form.find(".crud-class-array[data-attr='" + attrName + "']");
    if ($container.length === 0 || isNaN(idx)) { return; }

    var items = $container.data("items") || [];
    if (idx < 0 || idx >= items.length) { return; }
    items.splice(idx, 1);
    $container.data("items", items);
    Page.renderCrudClassArrayItems($container, attrName, items);
    $container.find(".crud-class-array-index").val("");
  });
};

// Render the summary list of elements for a class-array attribute
Page.renderCrudClassArrayItems = function($container, attrName, items) {
  var $list = $container.find(".crud-class-array-items");
  if ($list.length === 0) { return; }

  if (!Array.isArray(items) || items.length === 0) {
    $list.html("<em>No values added yet.</em>");
    return;
  }

  var html = "";
  items.forEach(function(item, idx) {
    var summary = [];
    if (item && typeof item === "object") {
      for (var k in item) {
        if (!item.hasOwnProperty(k)) { continue; }
        var v = item[k];
        if (typeof v === "undefined" || v === null || v === "") { continue; }
        summary.push(k + "=" + v);
      }
    }
    var label = attrName + "[" + (idx + 1) + "]";
    html += "<div class='crud-class-array-item' data-index='" + idx + "'>";
    html += "<span class='crud-class-array-item-summary'>" + label + " " + (summary.length ? "{" + summary.join(", ") + "}" : "") + "</span>";
    html += "<button type='button' class='crud-class-array-edit-item' data-attr='" + attrName + "' data-index='" + idx + "'>Edit</button>";
    html += "<button type='button' class='crud-class-array-remove-item' data-attr='" + attrName + "' data-index='" + idx + "'>Remove</button>";
    html += "</div>";
  });

  $list.html(html);
};

// Entry point used by Page.showGeneratedCode when language === "crudJson"
Page.showCrudFromJson = function(jsonText, tabnumber) {
  var formHtml = "<div class='crud-ui-forms'>";
  try {
    var data = JSON.parse(jsonText);
    var classes = data.umpleClasses || [];
    var associations = data.umpleAssociations || [];
    var globalEnums = data.globalEnums || [];

    // Resets in-memory CRUD data each time we (re)render CRUD UI
    Page.resetCrudData();
    // Builds a quick lookup for inheritance resolution and association navigation
    var crudMetaByClass = {};
    Page.crudExtendsByClass = {};
    classes.forEach(function(cls) {
      var className = cls.name || cls.id;
      if (!className) { return; }
      crudMetaByClass[className] = {
        name: className,
        rawAttributes: cls.attributes || [],
        extendsClass: cls.extendsClass || null,
        isAbstract: cls.isAbstract === true || cls.isAbstract === "true"
      };
      Page.crudExtendsByClass[className] = cls.extendsClass || null;

      // Capture local enums defined inside this class, if any
      var localEnums = (cls.enums && Array.isArray(cls.enums)) ? cls.enums : [];
      if (localEnums.length > 0) {
        if (!Page.crudEnumsByClass) {
          Page.crudEnumsByClass = {};
        }
        if (!Page.crudEnumsByClass[className]) {
          Page.crudEnumsByClass[className] = {};
        }
        localEnums.forEach(function(enumObj) {
          if (!enumObj) { return; }
          for (var enumName in enumObj) {
            if (!enumObj.hasOwnProperty(enumName)) { continue; }
            var values = enumObj[enumName];
            if (!Array.isArray(values)) { continue; }
            Page.crudEnumsByClass[className][enumName] = values.slice();
          }
        });
      }
    });

    // Capture global enums from the JSON payload, if any
    Page.crudGlobalEnums = {};
    if (Array.isArray(globalEnums)) {
      globalEnums.forEach(function(enumObj) {
        if (!enumObj) { return; }
        for (var enumName in enumObj) {
          if (!enumObj.hasOwnProperty(enumName)) { continue; }
          var values = enumObj[enumName];
          if (!Array.isArray(values)) { continue; }
          Page.crudGlobalEnums[enumName] = values.slice();
        }
      });
    }

    // Resolve attributes for a class, including inherited ones, and mark
    // where inherited attributes come from.
    var resolvedAttr = {};
    var resolveCrudAttributes = function(className, visited) {
      if (!className || !crudMetaByClass[className]) {
        return [];
      }
      if (resolvedAttr[className]) {
        return resolvedAttr[className];
      }

      visited = visited || {};
      if (visited[className]) {
        // Cycle guard: fall back to this class's own attributes only
        var ownOnly = crudMetaByClass[className].rawAttributes || [];
        resolvedAttr[className] = ownOnly;
        return ownOnly;
      }
      visited[className] = true;

      var meta = crudMetaByClass[className];
      var result = [];
      var seenNames = {};

      // First, pull in parent's attributes (if any) and mark them as inherited
      var parentName = meta.extendsClass;
      if (parentName && crudMetaByClass[parentName]) {
        var parentAttrs = resolveCrudAttributes(parentName, visited);
        parentAttrs.forEach(function(a) {
          if (!a || !a.name) { return; }
          if (seenNames[a.name]) { return; }
          var inheritedCopy = {};
          for (var k in a) {
            if (a.hasOwnProperty(k)) {
              inheritedCopy[k] = a[k];
            }
          }
          // Preserve original declaring class if present, otherwise the
          // immediate parent becomes the source of inheritance.
          if (!inheritedCopy.inheritedFrom) {
            if (inheritedCopy.declaringClass) {
              inheritedCopy.inheritedFrom = inheritedCopy.declaringClass;
            } else {
              inheritedCopy.inheritedFrom = parentName;
            }
          }
          seenNames[a.name] = true;
          result.push(inheritedCopy);
        });
      }

      // Then add this class's own attributes; mark declaringClass so that
      // deeper descendants can still know the original class.
      var ownAttrs = meta.rawAttributes || [];
      ownAttrs.forEach(function(a) {
        if (!a || !a.name) { return; }
        var ownCopy = {};
        for (var k in a) {
          if (a.hasOwnProperty(k)) {
            ownCopy[k] = a[k];
          }
        }
        ownCopy.declaringClass = className;
        // If an attribute with the same name was inherited, override it
        if (seenNames[a.name]) {
          for (var i = 0; i < result.length; i++) {
            if (result[i].name === a.name) {
              result[i] = ownCopy;
              break;
            }
          }
        } else {
          seenNames[a.name] = true;
          result.push(ownCopy);
        }
      });

      resolvedAttr[className] = result;
      return result;
    };

    // Build association navigation metadata per class (based on navigability and multiplicity).
    // Associations are also inherited along the extends hierarchy, similar to attributes.
    Page.crudAssociationsByClass = {};
    associations.forEach(function(assoc) {
      var classOneId = assoc.classOneId;
      var classTwoId = assoc.classTwoId;
      if (!classOneId || !classTwoId) { return; }

      var classOneName = (crudMetaByClass[classOneId] && crudMetaByClass[classOneId].name) || classOneId;
      var classTwoName = (crudMetaByClass[classTwoId] && crudMetaByClass[classTwoId].name) || classTwoId;

      var multOne = assoc.multiplicityOne || ""; // multiplicity at classOne end
      var multTwo = assoc.multiplicityTwo || ""; // multiplicity at classTwo end

      var leftNav = assoc.isLeftNavigable === true || assoc.isLeftNavigable === "true";
      var rightNav = assoc.isRightNavigable === true || assoc.isRightNavigable === "true";

      // Composition flags from the JSON definition
      var leftComp = assoc.isLeftComposition === true || assoc.isLeftComposition === "true";
      var rightComp = assoc.isRightComposition === true || assoc.isRightComposition === "true";

      // A bidirectional association means both ends are navigable
      var isBidirectional = leftNav && rightNav;

      var assocName = assoc.name || (classOneName + "__" + classTwoName);

      // For self-reflexive associations, detect hierarchical patterns
      // where one end is many and the other is single (e.g.,
      // FunctionalArea child * <-> 0..1 parent). These should not have
      // symmetric reverse links in the CRUD UI; children store a parent,
      // while parents derive their children.
      var isReflexive = (classOneName === classTwoName);
      var multOneHasStar = multOne && multOne.indexOf("*") !== -1;
      var multTwoHasStar = multTwo && multTwo.indexOf("*") !== -1;
      var isReflexiveHierarchy = isReflexive && (multOneHasStar !== multTwoHasStar);

      var registerEnd = function(fromClass, toClass, fromMult, toMult, direction) {
        if (!fromClass || !toClass) { return; }
        if (!Page.crudAssociationsByClass[fromClass]) {
          Page.crudAssociationsByClass[fromClass] = [];
        }
        var toRange = Page.parseCrudMultiplicity ? Page.parseCrudMultiplicity(toMult) : { min: 0, max: null };
        var fromRange = Page.parseCrudMultiplicity ? Page.parseCrudMultiplicity(fromMult) : { min: 0, max: null };

        // Determine whether deleting an instance of fromClass should also
        // delete its associated toClass instances for this end (composition).
        var cascadeDeleteTargets = false;
        if (leftComp && fromClass === classOneName && toClass === classTwoName) {
          cascadeDeleteTargets = true;
        }
        if (rightComp && fromClass === classTwoName && toClass === classOneName) {
          cascadeDeleteTargets = true;
        }

        // Storage key used on instances and form fields for this navigable end
        var storageKey = "__assoc__" + assocName + "__" + toClass;
        // Determine the role name for this navigable end. For non-reflexive
        // associations, roleOne applies to the classOne end and roleTwo to
        // classTwo. For reflexive associations, we still distinguish by
        // direction so that UIs can show role names like parent/child. We
        // also capture the opposite role name so that reverse views (e.g.,
        // a parent showing its children) can display the correct role.
        var roleName = "";
        var oppositeRoleName = "";
        if (!isReflexive) {
          if (fromClass === classOneName) {
            roleName = assoc.roleOne || "";
            oppositeRoleName = assoc.roleTwo || "";
          } else if (fromClass === classTwoName) {
            roleName = assoc.roleTwo || "";
            oppositeRoleName = assoc.roleOne || "";
          }
        } else {
          if (direction === "one-to-two") {
            // From classOne to classTwo
            roleName = assoc.roleTwo || assoc.roleOne || "";
            oppositeRoleName = assoc.roleOne || assoc.roleTwo || "";
          } else if (direction === "two-to-one") {
            // From classTwo to classOne
            roleName = assoc.roleOne || assoc.roleTwo || "";
            oppositeRoleName = assoc.roleTwo || assoc.roleOne || "";
          }
        }

        Page.crudAssociationsByClass[fromClass].push({
          assocName: assocName,
          assocId: assoc.id || assocName,
          fromClass: fromClass,
          toClass: toClass,
          fromMultiplicity: fromMult,
          toMultiplicity: toMult,
          direction: direction,
          isBidirectional: isBidirectional,
          toMin: toRange.min,
          toMax: toRange.max,
          fromMin: fromRange.min,
          fromMax: fromRange.max,
          storageKey: storageKey,
          roleName: roleName,
          oppositeRoleName: oppositeRoleName,
          // Track where this association end was declared so we can
          // propagate it to subclasses as an inherited association.
          declaringClass: fromClass,
          // Mark hierarchical self-reflexive associations so that reverse
          // sync can treat them specially (no symmetric links).
          reflexiveHierarchy: isReflexiveHierarchy,
          // For composition ends where this class is the owner (whole),
          // indicate that deleting fromClass should cascade to toClass.
          cascadeDeleteTargets: cascadeDeleteTargets
        });
      };

      // isRightNavigable true means classOne can navigate to classTwo
      if (rightNav) {
        registerEnd(classOneName, classTwoName, multOne, multTwo, "one-to-two");
      }
      // isLeftNavigable true means classTwo can navigate to classOne
      if (leftNav) {
        registerEnd(classTwoName, classOneName, multTwo, multOne, "two-to-one");
      }
    });

    // Resolve associations for a class, including inherited ones, and mark
    // where inherited associations come from (by declaringClass or parent).
    var resolvedAssoc = {};
    var resolveCrudAssociations = function(className, visited) {
      if (!className || !crudMetaByClass[className]) {
        return Page.crudAssociationsByClass[className] || [];
      }
      if (resolvedAssoc[className]) {
        return resolvedAssoc[className];
      }

      visited = visited || {};
      if (visited[className]) {
        // Cycle guard: fall back to this class's own associations only
        var ownOnly = Page.crudAssociationsByClass[className] || [];
        resolvedAssoc[className] = ownOnly;
        return ownOnly;
      }
      visited[className] = true;

      var metaA = crudMetaByClass[className];
      var resultA = [];
      var seenKeys = {};

      var makeKey = function(end) {
        if (!end) { return ""; }
        if (end.storageKey) { return end.storageKey; }
        return (end.assocId || "") + "::" + (end.toClass || "") + "::" + (end.direction || "");
      };

      // First, pull in parent's associations (if any) and mark them as inherited
      var parentNameA = metaA.extendsClass;
      if (parentNameA && crudMetaByClass[parentNameA]) {
        var parentEnds = resolveCrudAssociations(parentNameA, visited);
        parentEnds.forEach(function(e) {
          if (!e) { return; }
          var key = makeKey(e);
          if (seenKeys[key]) { return; }
          var inheritedCopy = {};
          for (var k in e) {
            if (e.hasOwnProperty(k)) {
              inheritedCopy[k] = e[k];
            }
          }
          if (!inheritedCopy.inheritedFrom) {
            if (inheritedCopy.declaringClass) {
              inheritedCopy.inheritedFrom = inheritedCopy.declaringClass;
            } else {
              inheritedCopy.inheritedFrom = parentNameA;
            }
          }
          seenKeys[key] = true;
          resultA.push(inheritedCopy);
        });
      }

      // Then add this class's own association ends; mark declaringClass so
      // deeper descendants can still know the original class.
      var ownEndsA = Page.crudAssociationsByClass[className] || [];
      ownEndsA.forEach(function(e) {
        if (!e) { return; }
        var key = makeKey(e);
        var ownCopy = {};
        for (var k in e) {
          if (e.hasOwnProperty(k)) {
            ownCopy[k] = e[k];
          }
        }
        ownCopy.declaringClass = className;
        if (seenKeys[key]) {
          // Override inherited end with same logical key
          for (var i = 0; i < resultA.length; i++) {
            var existing = resultA[i];
            if (makeKey(existing) === key) {
              resultA[i] = ownCopy;
              break;
            }
          }
        } else {
          seenKeys[key] = true;
          resultA.push(ownCopy);
        }
      });

      resolvedAssoc[className] = resultA;
      return resultA;
    };

    // Apply resolved (inherited) associations back onto the shared map so
    // the rest of the CRUD UI can consume them directly.
    Object.keys(crudMetaByClass).forEach(function(cn) {
      var resolvedForClass = resolveCrudAssociations(cn, {});
      if (resolvedForClass && resolvedForClass.length) {
        Page.crudAssociationsByClass[cn] = resolvedForClass;
      }
    });

    // Creates forms for each class using resolved attrs
    classes.forEach(function(cls) {
      var className = cls.name || cls.id;
      if (!className) { return; }
      var meta = crudMetaByClass[className] || {};
      var isAbstract = meta.isAbstract;
      var attrs = resolveCrudAttributes(className, {});

      // Track class definitions (including inherited attributes) so
      // class-typed attributes can be rendered nested everywhere.
      Page.crudClassDefs[className] = attrs;

      // Provides a form shell for all classes so they appear as buttons.
      // Abstract classes will be treated specially when clicked.
      formHtml += "<form class='crud-form' data-class='" + className + "' data-abstract='" + (isAbstract ? "true" : "false") + "'>";
      formHtml += "<h3>" + className + "</h3>";

      Page.crudData.classes[className] = {
        attributes: attrs,
        instances: [],
        isAbstract: isAbstract
      };

      formHtml += "</form>";
    });
    formHtml += "</div>";
  }
  catch (e) {
    formHtml = "<pre>Failed to parse JSON for CRUD UI:\n" + e + "</pre>";
  }

  jQuery("#innerGeneratedCodeRow" + tabnumber).html(formHtml);

  // Enhance forms with clickable class headers and popup dialog per class
  Page.initCrudUi(tabnumber);
};
