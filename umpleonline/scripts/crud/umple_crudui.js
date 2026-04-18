// In-memory storage for CRUD instances; no persistence or database
Page.crudData = { classes: {} };

// Lookup of class definitions (attributes) by class name for nested types
Page.crudClassDefs = {};

// Association metadata resolved from Json (per navigable end, grouped by class)
Page.crudAssociationsByClass = {};

// Container used for inline CRUD panel rendering
Page.currentCrudContainer = null;

// Informational messages about automatic multiplicity-driven adjustments
// (e.g., when tightening max bounds causes extra links to be trimmed).
Page.crudAdjustmentMessages = [];

// Total number of global CRUD validation violations across all classes
// and association ends. This is computed by validateCrudGlobalModel and
// surfaced in the banner so users can quickly gauge the scope of issues.
Page.crudGlobalErrorCount = 0;

// Per-target-class preference for how association options are labelled
// in CRUD forms. Keys are target class names, values are either an
// attribute name or the special token "__index__" meaning ClassName[index].
Page.crudAssociationLabelPreference = {};

Page.resetCrudData = function() {
  Page.crudData = { classes: {} };
  Page.crudClassDefs = {};
  Page.crudAssociationsByClass = {};
  Page.crudAdjustmentMessages = [];
  Page.crudGlobalErrorCount = 0;
  Page.crudAssociationLabelPreference = {};
};

// Capture the current CRUD form state (excluding global label-selector
// dropdowns) so we can detect unsaved edits when switching classes.
Page.captureCrudFormState = function($panel) {
  if (!$panel || !$panel.length) {
    return "";
  }
  var $form = $panel.find("#crud-instance-form");
  if (!$form.length) {
    return "";
  }

  var state = {
    instanceIndex: $form.find("input[name='instanceIndex']").val() || "",
    fields: [],
    classArrays: []
  };

  $form.find("input, select, textarea").not(".crud-assoc-label-select").each(function() {
    var $el = jQuery(this);
    var tag = (this.tagName || "").toLowerCase();
    var type = ($el.attr("type") || "").toLowerCase();
    var name = $el.attr("name") || "";
    if (!name) { return; }

    var key = tag + "|" + type + "|" + name + "|";
    var value;

    if (type === "checkbox" || type === "radio") {
      key += ($el.val() || "");
      value = $el.is(":checked") ? "1" : "0";
    } else {
      value = $el.val();
      if (value === undefined || value === null) {
        value = "";
      }
    }

    state.fields.push({ key: key, value: String(value) });
  });

  state.fields.sort(function(a, b) {
    if (a.key < b.key) { return -1; }
    if (a.key > b.key) { return 1; }
    if (a.value < b.value) { return -1; }
    if (a.value > b.value) { return 1; }
    return 0;
  });

  $form.find(".crud-class-array").each(function() {
    var $arr = jQuery(this);
    var attrName = $arr.data("attr") || "";
    if (!attrName) { return; }
    var items = $arr.data("items") || [];
    var asText = "";
    try {
      asText = JSON.stringify(items);
    } catch (e) {
      asText = String(items);
    }
    state.classArrays.push({ attr: attrName, items: asText });
  });

  state.classArrays.sort(function(a, b) {
    if (a.attr < b.attr) { return -1; }
    if (a.attr > b.attr) { return 1; }
    if (a.items < b.items) { return -1; }
    if (a.items > b.items) { return 1; }
    return 0;
  });

  try {
    return JSON.stringify(state);
  } catch (e) {
    return "";
  }
};

Page.markCrudFormClean = function($panel) {
  if (!$panel || !$panel.length) { return; }
  $panel.data("crudFormBaseline", Page.captureCrudFormState($panel));
};

Page.isCrudFormDirty = function($panel) {
  if (!$panel || !$panel.length) { return false; }
  var baseline = $panel.data("crudFormBaseline");
  if (typeof baseline !== "string") {
    return false;
  }
  return Page.captureCrudFormState($panel) !== baseline;
};

// Lightweight modern confirmation modal used for unsaved CRUD form edits.
Page.showCrudConfirmModal = function(message, onConfirm, onCancel) {
  // Clear any previous dialog instance.
  var $existing = jQuery("#crud-unsaved-dialog");
  if ($existing.length) {
    try {
      if ($existing.hasClass("ui-dialog-content")) {
        $existing.dialog("destroy");
      }
    } catch (e) {
      // ignore
    }
    $existing.remove();
  }

  var $dialog = jQuery("<div id='crud-unsaved-dialog' style='display:none;'></div>");
  $dialog.html(
    "<div style='padding:4px 2px 2px 2px;font-family:Inter,Segoe UI,Roboto,Arial,sans-serif;'>" +
      "<div style='font-size:14px;line-height:1.55;color:#334155;'>" + String(message || "") + "</div>" +
    "</div>"
  );
  jQuery("body").append($dialog);
  var handled = false;

  var doClose = function() {
    try {
      if ($dialog.hasClass("ui-dialog-content")) {
        $dialog.dialog("destroy");
      }
    } catch (e) {
      // ignore
    }
    $dialog.remove();
  };

  // Prefer jQuery UI dialog for reliability in this app shell.
  // Inject scoped CSS for the close button and button hover once per page.
  if (!jQuery("#crud-unsaved-dialog-style").length) {
    jQuery("head").append(
      "<style id='crud-unsaved-dialog-style'>" +
        ".crud-unsaved-dialog-modern .ui-dialog-titlebar-close { background:none !important; border:none !important; box-shadow:none !important; outline:none !important; width:24px !important; height:24px !important; padding:0 !important; margin:0 !important; position:absolute !important; right:14px !important; top:50% !important; transform:translateY(-50%) !important; overflow:hidden !important; text-indent:-9999px !important; font-size:0 !important; color:transparent !important; }" +
        ".crud-unsaved-dialog-modern .ui-dialog-titlebar-close .ui-icon, .crud-unsaved-dialog-modern .ui-dialog-titlebar-close .ui-button-icon-space, .crud-unsaved-dialog-modern .ui-dialog-titlebar-close .ui-button-text { display:none !important; }" +
        ".crud-unsaved-dialog-modern .ui-dialog-titlebar-close::before { content:'\\00D7' !important; position:absolute !important; left:50% !important; top:50% !important; transform:translate(-50%,-50%) !important; font-size:20px !important; font-weight:bold !important; color:#555555 !important; line-height:1 !important; display:block !important; text-indent:0 !important; }" +
        ".crud-unsaved-dialog-modern .ui-dialog-buttonpane button { border:1px solid #b06c5b !important; background:linear-gradient(to bottom,#e5bcae,#d8a695) !important; color:#ffffff !important; border-radius:4px !important; padding:0 10px !important; height:25px !important; line-height:25px !important; font-weight:bold !important; font-size:14px !important; text-shadow:rgba(0,0,0,.4) 0 1px 0 !important; cursor:pointer; }" +
        ".crud-unsaved-dialog-modern .ui-dialog-buttonpane button:hover { border:1px solid #7a3d2e !important; background:linear-gradient(to bottom,#c8937e,#b5735f) !important; }" +
      "</style>"
    );
  }

  if (typeof $dialog.dialog === "function") {
    $dialog.dialog({
      modal: true,
      width: 520,
      resizable: false,
      draggable: false,
      closeOnEscape: true,
      title: "Unsaved changes",
      dialogClass: "crud-unsaved-dialog-modern",
      open: function() {
        var $widget = $dialog.dialog("widget");
        $widget.css({
          borderRadius: "14px",
          overflow: "hidden",
          boxShadow: "0 18px 48px rgba(2,8,23,0.28)",
          zIndex: 2147483647
        });
        $widget.find(".ui-dialog-titlebar").css({
          background: "#ffffff",
          border: "none",
          borderBottom: "1px solid #e2e8f0",
          padding: "14px 16px"
        });
        $widget.find(".ui-dialog-title").css({
          color: "#0f172a",
          fontWeight: "700"
        });
        $widget.find(".ui-dialog-content").css({
          border: "none",
          padding: "10px 16px 8px 16px",
          background: "#ffffff"
        });
        $widget.find(".ui-dialog-buttonpane").css({
          border: "none",
          borderTop: "1px solid #e2e8f0",
          background: "#f8fafc",
          padding: "10px 12px"
        });
      },
      buttons: [
        {
          text: "Stay on this form",
          click: function() {
            handled = true;
            doClose();
            if (typeof onCancel === "function") {
              onCancel();
            }
          }
        },
        {
          text: "Switch form",
          click: function() {
            handled = true;
            doClose();
            if (typeof onConfirm === "function") {
              onConfirm();
            }
          }
        }
      ],
      close: function() {
        if (handled) {
          return;
        }
        doClose();
        if (typeof onCancel === "function") {
          onCancel();
        }
      }
    });
    return;
  }

  // Fallback if jQuery UI dialog is unavailable.
  var ok = window.confirm(String(message || ""));
  doClose();
  if (ok) {
    if (typeof onConfirm === "function") {
      onConfirm();
    }
  } else if (typeof onCancel === "function") {
    onCancel();
  }
};

// Return the inheritance chain (superclasses) for a given class name
// using the extends map built from the JSON. The array is ordered from
// immediate parent up to the root. Cycles are guarded against.
Page.getCrudSuperclasses = function(className) {
  var result = [];
  if (!className || !Page.crudExtendsByClass) {
    return result;
  }
  var seen = {};
  var current = className;
  while (current) {
    var parent = Page.crudExtendsByClass[current];
    if (!parent || seen[parent]) {
      break;
    }
    seen[parent] = true;
    result.push(parent);
    current = parent;
  }
  return result;
};
// Return true if candidateClass is the same as or a (direct or
// indirect) subclass of rootType according to the extends map
// built from the JSON.
Page.isCrudSubclass = function(candidateClass, rootType) {
  if (!candidateClass || !rootType) {
    return false;
  }
  if (candidateClass === rootType) {
    return true;
  }
  var supers = Page.getCrudSuperclasses(candidateClass);
  return supers.indexOf(rootType) !== -1;
};

// Polymorphic target resolution for associations. Given a root type
// name, return an array of { className, index, instance } for every
// instance whose runtime type is that class or any of its subclasses.
// This preserves the existing per-class storage model; it is a
// read-only aggregation used by the CRUD UI.
Page.getCrudPolymorphicTargets = function(rootType) {
  var results = [];
  if (!rootType || !Page.crudData || !Page.crudData.classes) {
    return results;
  }
  var classesData = Page.crudData.classes;
  Object.keys(classesData).forEach(function(className) {
    if (!Page.isCrudSubclass(className, rootType)) {
      return;
    }
    var info = classesData[className] || {};
    var instances = info.instances || [];
    for (var i = 0; i < instances.length; i++) {
      var inst = instances[i];
      if (!inst) { continue; }
      results.push({ className: className, index: i, instance: inst });
    }
  });
  return results;
};

// Association reference helpers
// -----------------------------
// A canonical association reference is an object of the form
//   { className: string, index: number }
// referring to an instance in Page.crudData.classes[className].instances[index].
// New CRUD writes always use this shape; legacy numeric values are
// still supported on read by treating them as indices into end.toClass.

Page.encodeCrudAssocRef = function(ref) {
  if (!ref || typeof ref.index !== "number" || ref.index < 0 || !ref.className) {
    return "";
  }
  return ref.className + ":" + String(ref.index);
};

Page.decodeCrudAssocRef = function(value, defaultClassName) {
  if (value === null || typeof value === "undefined") {
    return null;
  }
  if (typeof value === "object") {
    var cls = value.className || defaultClassName || null;
    var idx = value.index;
    if (typeof idx !== "number") {
      idx = parseInt(idx, 10);
    }
    if (!cls || isNaN(idx) || idx < 0) {
      return null;
    }
    return { className: cls, index: idx };
  }

  var s = String(value);
  if (s.indexOf(":") !== -1) {
    var parts = s.split(":");
    var clsName = parts[0] || defaultClassName || null;
    var idxStr = parts[1];
    var idxNum = parseInt(idxStr, 10);
    if (!clsName || isNaN(idxNum) || idxNum < 0) {
      return null;
    }
    return { className: clsName, index: idxNum };
  }

  var idxLegacy = parseInt(s, 10);
  if (isNaN(idxLegacy) || idxLegacy < 0) {
    return null;
  }
  return {
    className: defaultClassName || null,
    index: idxLegacy
  };
};

// Normalize any stored association value (number, object, array of
// either) into a canonical array of {className, index} references for
// the given association end. Legacy numeric values are interpreted as
// indices into end.toClass.
Page.normalizeCrudAssociationRefs = function(end, raw) {
  var refs = [];
  if (!end || raw === undefined || raw === null || raw === "") {
    return refs;
  }
  var defClass = end.toClass || null;

  var addRef = function(v) {
    var r = Page.decodeCrudAssocRef(v, defClass);
    if (!r || !r.className || typeof r.index !== "number" || r.index < 0) {
      return;
    }
    refs.push(r);
  };

  if (Array.isArray(raw)) {
    raw.forEach(function(v) { addRef(v); });
  } else {
    addRef(raw);
  }

  return refs;
};

// Validate that key attributes for a single instance (within a class)
// are not left blank. This is used for per-form validation when saving
// an instance so that key fields are always populated.
Page.validateCrudKeysForInstanceLocal = function(className, instance, keyAttributes) {
  var messages = [];

  if (!instance || !Array.isArray(keyAttributes) || !keyAttributes.length) {
    return messages;
  }

  keyAttributes.forEach(function(attrName) {
    if (!attrName) { return; }
    var value = instance[attrName];
    var isEmpty = (typeof value === "undefined" || value === null || value === "");
    if (!isEmpty && Array.isArray(value)) {
      isEmpty = value.length === 0;
    }

    if (isEmpty) {
      messages.push("Please enter a value for key attribute '" + attrName + "' in class '" + className + "'.");
    }
  });

  return messages;
};

// Validate that the new or edited instance does not duplicate the
// value of any key within the same class. When a single key attribute
// is defined, uniqueness is enforced per attribute. When multiple
// attributes are listed as keys, they form a composite key and
// uniqueness is enforced on the combination of their values.
Page.validateCrudKeyUniquenessForClassLocal = function(className, index, isEdit, newInst) {
  var messages = [];

  if (!Page.crudData || !Page.crudData.classes || !className || !newInst) {
    return messages;
  }

  var classInfo = Page.crudData.classes[className];
  if (!classInfo) { return messages; }

  var keyAttrs = Array.isArray(classInfo.keys) ? classInfo.keys : [];
  if (!keyAttrs.length) { return messages; }

  var instances = classInfo.instances || [];

  // Helper to normalize a value for key comparison
  var normalizeVal = function(v) {
    if (v === undefined || v === null || v === "") { return null; }
    if (Array.isArray(v)) {
      return v.length ? v.join(",") : null;
    }
    return String(v);
  };

  // Single-attribute key: preserve existing behaviour
  if (keyAttrs.length === 1) {
    var singleAttr = keyAttrs[0];
    if (!singleAttr) { return messages; }
    var newValSingle = normalizeVal(newInst[singleAttr]);
    if (newValSingle === null) {
      return messages;
    }

    for (var i = 0; i < instances.length; i++) {
      if (isEdit && i === index) { continue; }
      var otherInst = instances[i];
      if (!otherInst) { continue; }
      var otherValSingle = normalizeVal(otherInst[singleAttr]);
      if (otherValSingle === null) { continue; }
      if (otherValSingle === newValSingle) {
        var labelSingle = className + "[" + (i + 1) + "]";
        messages.push(
          "The value for key attribute '" + singleAttr + "' already exists on " + labelSingle + ". " +
          "Please enter a unique value because '" + singleAttr + "' is defined as a key."
        );
        break;
      }
    }
    return messages;
  }

  // Composite key: enforce uniqueness on the combination of all key attributes.
  var keyListText = keyAttrs.join(", ");
  var newParts = [];
  for (var k = 0; k < keyAttrs.length; k++) {
    var aName = keyAttrs[k];
    if (!aName) { return messages; }
    var part = normalizeVal(newInst[aName]);
    if (part === null) {
      // If any part is missing, rely on the "required key" check instead.
      return messages;
    }
    newParts.push(part);
  }
  var newComposite = newParts.join("||");

  for (var j = 0; j < instances.length; j++) {
    if (isEdit && j === index) { continue; }
    var otherInstance = instances[j];
    if (!otherInstance) { continue; }
    var otherParts = [];
    var skipOther = false;
    for (var m = 0; m < keyAttrs.length; m++) {
      var aNameOther = keyAttrs[m];
      var partOther = normalizeVal(otherInstance[aNameOther]);
      if (partOther === null) {
        skipOther = true;
        break;
      }
      otherParts.push(partOther);
    }
    if (skipOther) { continue; }
    var otherComposite = otherParts.join("||");
    if (otherComposite === newComposite) {
      var labelComp = className + "[" + (j + 1) + "]";
      messages.push(
        "The combination of key attributes '" + keyListText + "' already exists on " + labelComp + ". " +
        "Please enter a unique combination because these attributes form a composite key."
      );
      break;
    }
  }

  return messages;
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

// Normalize stored association values for multi-valued ends so that they
// are always represented as an array of numeric indices. This is helpful
// when a model evolution changes an end from single-valued (radio) to
// multi-valued (checkbox), since previously stored links may be a single
// number instead of an array.
Page.normalizeCrudMultiValuedAssociations = function() {
  if (!Page.crudAssociationsByClass || !Page.crudData || !Page.crudData.classes) {
    return;
  }

  var classesData = Page.crudData.classes;

  Object.keys(Page.crudAssociationsByClass).forEach(function(fromClass) {
    var ends = Page.crudAssociationsByClass[fromClass] || [];
    if (!ends.length) { return; }

    var classInfo = classesData[fromClass];
    if (!classInfo) { return; }
    var instances = classInfo.instances || [];
    if (!instances.length) { return; }

    ends.forEach(function(end) {
      if (!end) { return; }
      var fieldName = end.storageKey;
      if (!fieldName) { return; }

      var maxAllowed = (typeof end.toMax === "number") ? end.toMax : null;
      var isMulti = (maxAllowed === null || maxAllowed > 1);
      if (!isMulti) { return; }

      for (var i = 0; i < instances.length; i++) {
        var inst = instances[i];
        if (!inst) { continue; }
        var raw = inst[fieldName];

        if (raw === undefined || raw === null || raw === "") {
          continue;
        }

        // Normalize to canonical polymorphic refs. This preserves
        // existing object-based references while upgrading legacy
        // numeric values into an array form for multi-valued ends.
        var refs = Page.normalizeCrudAssociationRefs
          ? Page.normalizeCrudAssociationRefs(end, raw)
          : [];

        if (refs.length > 0) {
          inst[fieldName] = refs;
        } else {
          inst[fieldName] = [];
        }
      }
    });
  });
};

// When multiplicities are tightened (e.g., from * to 1 or from 5 to 3),
// ensure that stored association values do not exceed the new maximum.
// Extra links are trimmed, and an informational message is recorded so
// users understand what changed.
Page.adjustCrudAssociationsForTightenedMax = function() {
  if (!Page.crudAssociationsByClass || !Page.crudData || !Page.crudData.classes) {
    return;
  }

  var classesData = Page.crudData.classes;

  if (!Array.isArray(Page.crudAdjustmentMessages)) {
    Page.crudAdjustmentMessages = [];
  }

  Object.keys(Page.crudAssociationsByClass).forEach(function(fromClass) {
    var ends = Page.crudAssociationsByClass[fromClass] || [];
    if (!ends.length) { return; }

    var classInfo = classesData[fromClass];
    if (!classInfo) { return; }
    var instances = classInfo.instances || [];
    if (!instances.length) { return; }

    ends.forEach(function(end) {
      if (!end) { return; }
      var fieldName = end.storageKey;
      if (!fieldName) { return; }

      var maxAllowed = (typeof end.toMax === "number") ? end.toMax : null;
      if (maxAllowed === null || maxAllowed <= 0) {
        return; // no upper bound to enforce
      }

      var totalRemoved = 0;

      for (var i = 0; i < instances.length; i++) {
        var inst = instances[i];
        if (!inst) { continue; }
        var raw = inst[fieldName];

        if (raw === undefined || raw === null || raw === "") {
          continue;
        }

        // Work with canonical polymorphic refs so that both legacy
        // numeric indices and new {className,index} objects are
        // handled uniformly.
        var refs = Page.normalizeCrudAssociationRefs
          ? Page.normalizeCrudAssociationRefs(end, raw)
          : [];

        if (!refs.length) {
          // Normalize empty links according to max: scalar null for single,
          // empty array for multi-valued.
          inst[fieldName] = (maxAllowed === 1 ? null : []);
          // With no forward links, there is nothing to keep in sync on the
          // reverse side for this instance.
          continue;
        }

        if (refs.length > maxAllowed) {
          var kept = refs.slice(0, maxAllowed);
          var removed = refs.slice(maxAllowed);

          if (maxAllowed === 1) {
            inst[fieldName] = kept[0];
          } else {
            inst[fieldName] = kept;
          }

          totalRemoved += removed.length;
        } else {
          // Keep representation consistent with the new max bound
          if (maxAllowed === 1) {
            inst[fieldName] = refs[0];
          } else {
            inst[fieldName] = refs;
          }
        }

        // Ensure reverse association ends are also updated to reflect any
        // trimming so that Show Associations never displays links that no
        // longer exist from this side.
        if (typeof Page.syncCrudReverseAssociationsForEnd === "function") {
          Page.syncCrudReverseAssociationsForEnd(fromClass, i, end, inst[fieldName]);
        }
      }

      if (totalRemoved > 0) {
        var maxText = (maxAllowed === 1) ? "one" : String(maxAllowed);
        var msg = "Info: Because the multiplicity for association '" + end.assocName +
                  "' from " + fromClass + " to " + end.toClass +
                  " was tightened to allow " + maxText + " " + end.toClass +
                  " instance(s) per " + fromClass + ", " + "one or more " +
                  " extra " + end.toClass + " link(s) were removed across existing " +
                  fromClass + " instances.";
        Page.crudAdjustmentMessages.push(msg);
      }
    });
  });
};

// Determine whether changing an attribute's type should preserve
// existing data values or treat them as incompatible and clear them.
// This is based purely on the old/new type declarations, not the
// actual runtime values.
Page.isCrudAttributeTypeChangeCompatible = function(oldTypeInfo, newTypeInfo) {
  if (!oldTypeInfo || !newTypeInfo) {
    return false;
  }

  // Arrays and scalars are never considered compatible with each
  // other – a change between scalar and array types clears data.
  if (!!oldTypeInfo.isArray !== !!newTypeInfo.isArray) {
    return false;
  }

  var normalizeBase = function(b) {
    var base = (b || "").toString().toLowerCase();
    if (base === "integer") { return "int"; }
    if (base === "bool") { return "boolean"; }
    if (base === "char") { return "character"; }
    return base;
  };

  var oldBase = normalizeBase(oldTypeInfo.base);
  var newBase = normalizeBase(newTypeInfo.base);

  // No semantic change (including synonyms like Integer -> int).
  if (oldBase === newBase) {
    return true;
  }

  // Any previous type becoming String is always safe: existing values
  // can be displayed as text without loss of information.
  if (newBase === "string") {
    return true;
  }

  // Integers widening to floating point types (e.g., int -> double or
  // int -> float) are treated as compatible.
  var oldIsInt = (oldBase === "int");
  var newIsFloat = (newBase === "double" || newBase === "float");
  if (oldIsInt && newIsFloat) {
    return true;
  }

  // All other type changes (for example, string -> int or
  // double -> int) are treated as incompatible.
  return false;
};

// Attempt to convert an existing stored value into the new type so
// that compatible values can be preserved even when the type change
// as a whole is considered incompatible (for example, String -> int
// where some strings are numeric). Returns an object of the form
// { compatible: <bool>, value: <any> }.
Page.convertCrudValueForNewType = function(value, oldTypeInfo, newTypeInfo) {
  var result = { compatible: false, value: undefined };
  if (!newTypeInfo) {
    return result;
  }

  var normalizeBase = function(b) {
    var base = (b || "").toString().toLowerCase();
    if (base === "integer") { return "int"; }
    if (base === "bool") { return "boolean"; }
    if (base === "char") { return "character"; }
    return base;
  };

  var newBase = normalizeBase(newTypeInfo.base);
  var isArray = !!newTypeInfo.isArray;

  // Helper to convert a single scalar value.
  var convertScalar = function(v) {
    if (typeof v === "undefined" || v === null || v === "") {
      return { compatible: false, value: undefined };
    }

    // Integer target
    if (newBase === "int") {
      if (typeof v === "number" && isFinite(v) && Math.floor(v) === v) {
        return { compatible: true, value: v };
      }
      if (typeof v === "string") {
        var s = v.trim();
        if (s === "") {
          return { compatible: false, value: undefined };
        }
        if (!/^[-+]?\d+$/.test(s)) {
          return { compatible: false, value: undefined };
        }
        var n = parseInt(s, 10);
        if (!isNaN(n)) {
          return { compatible: true, value: n };
        }
      }
      return { compatible: false, value: undefined };
    }

    // Floating-point target (double/float)
    if (newBase === "double" || newBase === "float") {
      if (typeof v === "number" && isFinite(v)) {
        return { compatible: true, value: v };
      }
      if (typeof v === "string") {
        var s2 = v.trim();
        if (s2 === "") {
          return { compatible: false, value: undefined };
        }
        var f = parseFloat(s2);
        if (!isNaN(f)) {
          return { compatible: true, value: f };
        }
      }
      return { compatible: false, value: undefined };
    }

    // Boolean target
    if (newBase === "boolean") {
      if (typeof v === "boolean") {
        return { compatible: true, value: v };
      }
      if (typeof v === "string") {
        var s3 = v.trim().toLowerCase();
        if (s3 === "true") {
          return { compatible: true, value: true };
        }
        if (s3 === "false") {
          return { compatible: true, value: false };
        }
      }
      return { compatible: false, value: undefined };
    }

    // For other targets (date, time, enums, etc.), we do not attempt
    // automatic conversion beyond what the type-compatibility function
    // already allows.
    return { compatible: false, value: undefined };
  };

  // Do not attempt to convert between scalar and array here; those
  // shape changes are handled by the type-compatibility guard.
  if (isArray) {
    if (!Array.isArray(value)) {
      return result;
    }
    var out = [];
    value.forEach(function(elem) {
      var conv = convertScalar(elem);
      if (conv.compatible) {
        out.push(conv.value);
      }
    });
    if (out.length === 0) {
      return result;
    }
    return { compatible: true, value: out };
  }

  return convertScalar(value);
};

// When an attribute has effectively been renamed (old attribute name
// removed, new attribute name added) and their data types are the
// same, preserve existing data by moving values from the old name to
// the new one. If the data type has changed, no values are moved so
// the new attribute appears blank.
Page.adjustCrudAttributesForRenames = function(oldCrudData) {
  if (!oldCrudData || !oldCrudData.classes || !Page.crudData || !Page.crudData.classes) {
    return;
  }

  var classesData = Page.crudData.classes;

  Object.keys(classesData).forEach(function(className) {
    var newInfo = classesData[className];
    if (!newInfo) { return; }
    var instances = newInfo.instances || [];
    if (!instances.length) { return; }

    var oldInfo = oldCrudData.classes[className];
    if (!oldInfo || !Array.isArray(oldInfo.attributes)) { return; }

    var newAttrs = newInfo.attributes || [];
    var oldAttrs = oldInfo.attributes || [];
    if (!newAttrs.length || !oldAttrs.length) { return; }

    var oldByName = {};
    var newByName = {};
    oldAttrs.forEach(function(a) {
      if (!a || !a.name) { return; }
      oldByName[a.name] = a;
    });
    newAttrs.forEach(function(a) {
      if (!a || !a.name) { return; }
      newByName[a.name] = a;
    });

    var oldOnly = [];
    var newOnly = [];

    oldAttrs.forEach(function(a) {
      if (!a || !a.name) { return; }
      if (!newByName[a.name]) {
        oldOnly.push(a);
      }
    });
    newAttrs.forEach(function(a) {
      if (!a || !a.name) { return; }
      if (!oldByName[a.name]) {
        newOnly.push(a);
      }
    });

    if (!oldOnly.length || !newOnly.length) { return; }

    var normalizeBase = function(b) {
      var base = (b || "").toString().toLowerCase();
      if (base === "integer") { return "int"; }
      if (base === "bool") { return "boolean"; }
      if (base === "char") { return "character"; }
      return base;
    };

    var usedOldNames = {};

    newOnly.forEach(function(newAttr) {
      if (!newAttr || !newAttr.name) { return; }
      var newName = newAttr.name;
      var newTypeInfo = Page.getCrudTypeInfo(newAttr.type || "");
      var newBase = normalizeBase(newTypeInfo.base);
      var newIsArray = !!newTypeInfo.isArray;

      // Find a single old-only attribute with the same normalized
      // base type and array-ness. If more than one matches, skip to
      // avoid guessing.
      var candidates = [];
      oldOnly.forEach(function(oldAttr) {
        if (!oldAttr || !oldAttr.name) { return; }
        var oldName = oldAttr.name;
        if (usedOldNames[oldName]) { return; }
        var oldTypeInfo = Page.getCrudTypeInfo(oldAttr.type || "");
        var oldBase = normalizeBase(oldTypeInfo.base);
        var oldIsArray = !!oldTypeInfo.isArray;
        if (oldBase === newBase && oldIsArray === newIsArray) {
          candidates.push(oldAttr);
        }
      });

      if (candidates.length !== 1) {
        return; // ambiguous or no clear rename target
      }

      var chosen = candidates[0];
      var oldNameChosen = chosen.name;
      usedOldNames[oldNameChosen] = true;

      var hadAnyValue = false;
      var movedCount = 0;

      instances.forEach(function(inst) {
        if (!inst || !Object.prototype.hasOwnProperty.call(inst, oldNameChosen)) {
          return;
        }
        var v = inst[oldNameChosen];
        if (typeof v === "undefined" || v === null || v === "") {
          // Remove empty old values so only the new name remains.
          delete inst[oldNameChosen];
          return;
        }

        hadAnyValue = true;

        // Do not overwrite an explicit value on the new attribute if
        // one already exists on this instance.
        if (!Object.prototype.hasOwnProperty.call(inst, newName)) {
          inst[newName] = v;
        }
        delete inst[oldNameChosen];
        movedCount++;
      });

      if (hadAnyValue && movedCount > 0) {
        var msg = "Info: Attribute '" + oldNameChosen + "' in class '" + className + "' was renamed to '" + newName + "'. Existing data was preserved because the attribute type did not change.";
        if (Array.isArray(Page.crudAdjustmentMessages)) {
          Page.crudAdjustmentMessages.push(msg);
        }
      }
    });
  });
};

// When a model evolution changes the declared data type of an
// attribute but keeps the attribute name the same, decide on a
// per-attribute basis whether existing values can be kept or should
// be cleared. Compatible changes (such as int -> double or
// int -> string) keep values; incompatible changes (such as
// string -> int or double -> int) remove them. In both cases, an
// informational message is recorded so users understand what
// happened to their data.
Page.adjustCrudAttributesForTypeChanges = function(oldCrudData) {
  if (!oldCrudData || !oldCrudData.classes || !Page.crudData || !Page.crudData.classes) {
    return;
  }

  var classesData = Page.crudData.classes;

  Object.keys(classesData).forEach(function(className) {
    var newInfo = classesData[className];
    if (!newInfo) { return; }
    var instances = newInfo.instances || [];
    if (!instances.length) { return; }

    var oldInfo = oldCrudData.classes[className];
    if (!oldInfo || !Array.isArray(oldInfo.attributes)) { return; }

    var newAttrs = newInfo.attributes || [];
    if (!newAttrs.length) { return; }

    var oldAttrByName = {};
    oldInfo.attributes.forEach(function(a) {
      if (!a || !a.name) { return; }
      oldAttrByName[a.name] = a;
    });

    newAttrs.forEach(function(attr) {
      if (!attr || !attr.name) { return; }
      var attrName = attr.name;
      var oldAttr = oldAttrByName[attrName];
      if (!oldAttr) { return; }

      var oldTypeRaw = oldAttr.type || "";
      var newTypeRaw = attr.type || "";
      var oldTypeInfo = Page.getCrudTypeInfo(oldTypeRaw);
      var newTypeInfo = Page.getCrudTypeInfo(newTypeRaw);

      // If the normalized base type and array-ness are effectively
      // the same, treat this as no meaningful change.
      var normalizeBase = function(b) {
        var base = (b || "").toString().toLowerCase();
        if (base === "integer") { return "int"; }
        if (base === "bool") { return "boolean"; }
        if (base === "char") { return "character"; }
        return base;
      };
      var oldBase = normalizeBase(oldTypeInfo.base);
      var newBase = normalizeBase(newTypeInfo.base);
      if (oldBase === newBase && !!oldTypeInfo.isArray === !!newTypeInfo.isArray) {
        return;
      }

      var compatible = Page.isCrudAttributeTypeChangeCompatible(oldTypeInfo, newTypeInfo);

      // Track whether any existing instances had a concrete value so
      // we only emit messages when there was something to adjust.
      var hadAnyValue = false;

      if (!compatible) {
        var removedCount = 0;
        var keptCount = 0;
        instances.forEach(function(inst) {
          if (!inst || !Object.prototype.hasOwnProperty.call(inst, attrName)) {
            return;
          }
          var vExisting = inst[attrName];
          if (typeof vExisting === "undefined" || vExisting === null || vExisting === "") {
            return;
          }
          hadAnyValue = true;

          var conv = Page.convertCrudValueForNewType(vExisting, oldTypeInfo, newTypeInfo);
          if (conv && conv.compatible) {
            inst[attrName] = conv.value;
            keptCount++;
          } else {
            delete inst[attrName];
            removedCount++;
          }
        });

        if (hadAnyValue) {
          if (keptCount > 0 && removedCount === 0) {
            var msgAllKept = "Info: Data type of attribute '" + attrName + "' in class '" + className + "' was updated from " + oldTypeRaw + " to " + newTypeRaw + ". Existing data was kept because its values are compatible with the new type.";
            if (Array.isArray(Page.crudAdjustmentMessages)) {
              Page.crudAdjustmentMessages.push(msgAllKept);
            }
          } else if (keptCount > 0 && removedCount > 0) {
            var msgMixed = "Info: Data type of attribute '" + attrName + "' in class '" + className + "' was updated from " + oldTypeRaw + " to " + newTypeRaw + ". Existing data was adjusted: compatible values were kept where possible, and incompatible values were removed from " + removedCount + " instance(s).";
            if (Array.isArray(Page.crudAdjustmentMessages)) {
              Page.crudAdjustmentMessages.push(msgMixed);
            }
          } else if (removedCount > 0) {
            var msgRemoved = "Info: Data type of attribute '" + attrName + "' in class '" + className + "' was updated from " + oldTypeRaw + " to " + newTypeRaw + ". Existing data was removed from " + removedCount + " instance(s) because it is not compatible with the new type.";
            if (Array.isArray(Page.crudAdjustmentMessages)) {
              Page.crudAdjustmentMessages.push(msgRemoved);
            }
          }
        }
      } else {
        instances.forEach(function(inst) {
          if (!inst || !Object.prototype.hasOwnProperty.call(inst, attrName)) {
            return;
          }
          var v = inst[attrName];
          if (typeof v === "undefined" || v === null || v === "") {
            return;
          }
          hadAnyValue = true;
        });

        if (hadAnyValue) {
          var msgKept = "Info: Data type of attribute '" + attrName + "' in class '" + className + "' was updated from " + oldTypeRaw + " to " + newTypeRaw + ". Existing data was kept because it is compatible with the new type.";
          if (Array.isArray(Page.crudAdjustmentMessages)) {
            Page.crudAdjustmentMessages.push(msgKept);
          }
        }
      }
    });
  });
};

// When an attribute's type remains an enum but one or more enum literals
// are removed from the model (for example, "FullTime" is deleted from
// enum Status { FullTime, PartTime }), clear any existing CRUD values that
// still reference those removed literals. This prevents stale, now-invalid
// enum values from lingering in instance data and makes the change visible
// via an informational adjustment message.
Page.adjustCrudEnumValuesForRemovedOptions = function() {
  if (!Page.crudData || !Page.crudData.classes || !Page.resolveCrudEnumOptions) {
    return;
  }

  var classesData = Page.crudData.classes;

  Object.keys(classesData).forEach(function(className) {
    var classInfo = classesData[className];
    if (!classInfo || !Array.isArray(classInfo.instances) || !Array.isArray(classInfo.attributes)) {
      return;
    }

    var instances = classInfo.instances;
    if (!instances.length) { return; }

    classInfo.attributes.forEach(function(attr) {
      if (!attr || !attr.name || !attr.type) { return; }

      var attrName = attr.name;
      var rawType = attr.type;
      var typeInfo = Page.getCrudTypeInfo(rawType);

      // Only consider non-class enum attributes here. Arrays of enums
      // are supported by treating the stored value as an array of
      // strings and dropping any elements that are no longer valid.
      if (typeInfo && typeInfo.base && !typeInfo.isClass) {
        var enumOptions = Page.resolveCrudEnumOptions(rawType);
        if (!enumOptions || !enumOptions.length) {
          return;
        }

        var allowed = {};
        enumOptions.forEach(function(opt) {
          if (opt !== null && typeof opt !== "undefined") {
            allowed[String(opt)] = true;
          }
        });

        var adjustedInstances = 0;

        instances.forEach(function(inst) {
          if (!inst || !Object.prototype.hasOwnProperty.call(inst, attrName)) {
            return;
          }
          var v = inst[attrName];
          if (typeof v === "undefined" || v === null || v === "") {
            return;
          }

          if (Array.isArray(v)) {
            var kept = [];
            v.forEach(function(elem) {
              var key = String(elem);
              if (allowed[key]) {
                kept.push(elem);
              }
            });

            if (kept.length === v.length) {
              return; // no change for this instance
            }

            if (kept.length > 0) {
              inst[attrName] = kept;
            } else {
              delete inst[attrName];
            }
            adjustedInstances++;
          } else {
            var keySingle = String(v);
            if (allowed[keySingle]) {
              return; // still valid
            }
            delete inst[attrName];
            adjustedInstances++;
          }
        });

        if (adjustedInstances > 0 && Array.isArray(Page.crudAdjustmentMessages)) {
          var msg = "Info: Enum attribute '" + attrName + "' in class '" + className + "' contained values for removed enum literal(s). " +
                    "Those values were cleared from " + adjustedInstances + " instance(s).";
          Page.crudAdjustmentMessages.push(msg);
        }
      }
    });
  });
};

// When a class has effectively been renamed (old class name removed,
// new class name added) and its associations to other classes are the
// same, preserve existing association links by moving values from the
// old storage fields (based on the old class name) to the new ones.
//
// classRenameNewToOld: map of { newClassName -> oldClassName }
// oldAssocByClass: snapshot of Page.crudAssociationsByClass from the
//                   previous model load.
Page.adjustCrudAssociationsForClassRenames = function(classRenameNewToOld, oldAssocByClass) {
  if (!classRenameNewToOld || !oldAssocByClass || !Page.crudAssociationsByClass || !Page.crudData || !Page.crudData.classes) {
    return;
  }

  var classesData = Page.crudData.classes;

  // For each renamed class, first adjust association fields on its own
  // instances for navigable ends that originate from this class.
  Object.keys(classRenameNewToOld).forEach(function(newClassName) {
    var oldClassName = classRenameNewToOld[newClassName];
    if (!oldClassName) { return; }

    var classInfo = classesData[newClassName];
    if (!classInfo || !Array.isArray(classInfo.instances)) { return; }
    var instances = classInfo.instances;
    if (!instances.length) { return; }

    var newEndsAll = Page.crudAssociationsByClass[newClassName] || [];
    var oldEndsAll = oldAssocByClass[oldClassName] || [];

    // Build a lookup of old association ends by (assocId,toClass) so
    // we can find the corresponding old storage key for each new end.
    var oldByAssocAndTarget = {};
    oldEndsAll.forEach(function(e) {
      if (!e || !e.assocId) { return; }
      // Only consider navigable ends that originate from the old class
      // name; inherited ends for subclasses are handled through their
      // own class entries.
      if (e.fromClass !== oldClassName) { return; }
      var key = (e.assocId || "") + "::" + (e.toClass || "");
      if (!oldByAssocAndTarget[key]) {
        oldByAssocAndTarget[key] = [];
      }
      oldByAssocAndTarget[key].push(e);
    });

    newEndsAll.forEach(function(end) {
      if (!end || !end.assocId) { return; }
      if (end.fromClass !== newClassName) { return; }

      var lookupKey = (end.assocId || "") + "::" + (end.toClass || "");
      var candidates = oldByAssocAndTarget[lookupKey];
      if (!candidates || !candidates.length) { return; }

      // Use and remove the first candidate so that multiple ends with
      // the same signature are paired in a stable way.
      var oldEnd = candidates.shift();
      if (!oldEnd || !oldEnd.storageKey) { return; }

      var oldKey = oldEnd.storageKey;
      var newKey = end.storageKey;
      if (!newKey || oldKey === newKey) { return; }

      instances.forEach(function(inst) {
        if (!inst || !Object.prototype.hasOwnProperty.call(inst, oldKey)) {
          return;
        }
        if (!Object.prototype.hasOwnProperty.call(inst, newKey)) {
          inst[newKey] = inst[oldKey];
        }
        delete inst[oldKey];
      });
    });
  });

  // Next, for each renamed class, adjust association fields on other
  // classes' instances where the renamed class appears on the target
  // side of a navigable end.
  Object.keys(classRenameNewToOld).forEach(function(newClassName) {
    var oldClassName = classRenameNewToOld[newClassName];
    if (!oldClassName) { return; }

    Object.keys(classesData).forEach(function(sourceClass) {
      var sourceInfo = classesData[sourceClass];
      if (!sourceInfo || !Array.isArray(sourceInfo.instances)) { return; }
      var instances = sourceInfo.instances;
      if (!instances.length) { return; }

      var newEndsAll = Page.crudAssociationsByClass[sourceClass] || [];
      var oldEndsAll = oldAssocByClass[sourceClass] || [];
      if (!newEndsAll.length || !oldEndsAll.length) { return; }

      // Build a lookup of old association ends by assocId where the
      // renamed class was the target side.
      var oldByAssocId = {};
      oldEndsAll.forEach(function(e) {
        if (!e || !e.assocId) { return; }
        if (e.toClass !== oldClassName) { return; }
        var key = e.assocId || "";
        if (!oldByAssocId[key]) {
          oldByAssocId[key] = [];
        }
        oldByAssocId[key].push(e);
      });

      if (!Object.keys(oldByAssocId).length) { return; }

      newEndsAll.forEach(function(end) {
        if (!end || !end.assocId) { return; }
        if (end.toClass !== newClassName) { return; }

        var list = oldByAssocId[end.assocId || ""];
        if (!list || !list.length) { return; }
        var oldEnd = list.shift();
        if (!oldEnd || !oldEnd.storageKey) { return; }

        var oldKey = oldEnd.storageKey;
        var newKey = end.storageKey;
        if (!newKey || oldKey === newKey) { return; }

        instances.forEach(function(inst) {
          if (!inst || !Object.prototype.hasOwnProperty.call(inst, oldKey)) {
            return;
          }
          if (!Object.prototype.hasOwnProperty.call(inst, newKey)) {
            inst[newKey] = inst[oldKey];
          }
          delete inst[oldKey];
        });
      });
    });
  });
};

// When role names (or other end labels that influence storageKey) change for
// an otherwise equivalent association end, preserve existing association data
// by migrating values from old storage fields to new ones. If an old
// association end can no longer be matched to any current end, remove its
// stale stored values and report what was cleared.
Page.adjustCrudAssociationsForRoleNameChanges = function(oldAssocByClass) {
  if (!oldAssocByClass || !Page.crudAssociationsByClass || !Page.crudData || !Page.crudData.classes) {
    return;
  }

  if (!Array.isArray(Page.crudAdjustmentMessages)) {
    Page.crudAdjustmentMessages = [];
  }

  var classesData = Page.crudData.classes;

  var endAppliesToClass = function(className, end) {
    if (!className || !end || !end.fromClass) { return false; }
    if (Page.isCrudSubclass) {
      return Page.isCrudSubclass(className, end.fromClass);
    }
    return end.fromClass === className;
  };

  var toMaxText = function(v) {
    return (typeof v === "number") ? String(v) : "*";
  };

  var sameEndByIdentity = function(a, b) {
    if (!a || !b) { return false; }
    return (a.assocId || "") === (b.assocId || "") &&
      (a.toClass || "") === (b.toClass || "") &&
      (a.direction || "") === (b.direction || "");
  };

  var sameEndByStructure = function(a, b) {
    if (!a || !b) { return false; }
    return (a.fromClass || "") === (b.fromClass || "") &&
      (a.toClass || "") === (b.toClass || "") &&
      (a.direction || "") === (b.direction || "") &&
      (a.fromMultiplicity || "") === (b.fromMultiplicity || "") &&
      (a.toMultiplicity || "") === (b.toMultiplicity || "") &&
      toMaxText(a.fromMax) === toMaxText(b.fromMax) &&
      toMaxText(a.toMax) === toMaxText(b.toMax) &&
      (!!a.isBidirectional) === (!!b.isBidirectional) &&
      (!!a.cascadeDeleteTargets) === (!!b.cascadeDeleteTargets) &&
      (!!a.reflexiveHierarchy) === (!!b.reflexiveHierarchy);
  };

  var countRefs = function(end, raw) {
    if (raw === undefined || raw === null || raw === "") {
      return 0;
    }
    var refs = (Page.normalizeCrudAssociationRefs && typeof Page.normalizeCrudAssociationRefs === "function")
      ? Page.normalizeCrudAssociationRefs(end, raw)
      : [];
    return refs.length;
  };

  Object.keys(classesData).forEach(function(className) {
    var classInfo = classesData[className] || {};
    var instances = classInfo.instances || [];
    if (!instances.length) { return; }

    var oldEndsAll = oldAssocByClass[className] || [];
    var newEndsAll = Page.crudAssociationsByClass[className] || [];
    if (!oldEndsAll.length && !newEndsAll.length) { return; }

    var oldEnds = [];
    oldEndsAll.forEach(function(end) {
      if (!end || !end.storageKey) { return; }
      if (!endAppliesToClass(className, end)) { return; }
      oldEnds.push(end);
    });

    var newEnds = [];
    var newKeys = {};
    newEndsAll.forEach(function(end) {
      if (!end || !end.storageKey) { return; }
      if (!endAppliesToClass(className, end)) { return; }
      newEnds.push(end);
      newKeys[end.storageKey] = true;
    });

    if (!oldEnds.length && !newEnds.length) { return; }

    var usedOldIdx = {};
    var preservedLinks = 0;
    var preservedFields = 0;

    newEnds.forEach(function(newEnd) {
      var newKey = newEnd.storageKey;
      if (!newKey) { return; }

      // Keep already-aligned keys untouched.
      var hasNewKeyData = false;
      for (var i = 0; i < instances.length; i++) {
        if (instances[i] && Object.prototype.hasOwnProperty.call(instances[i], newKey)) {
          hasNewKeyData = true;
          break;
        }
      }
      if (hasNewKeyData) {
        return;
      }

      var matchedOldIdx = -1;
      for (var j = 0; j < oldEnds.length; j++) {
        if (usedOldIdx[j]) { continue; }
        var oldEndId = oldEnds[j];
        if (!oldEndId || !oldEndId.storageKey) { continue; }
        if (oldEndId.storageKey === newKey) { continue; }
        if (sameEndByIdentity(newEnd, oldEndId)) {
          matchedOldIdx = j;
          break;
        }
      }

      if (matchedOldIdx < 0) {
        for (var k = 0; k < oldEnds.length; k++) {
          if (usedOldIdx[k]) { continue; }
          var oldEndStruct = oldEnds[k];
          if (!oldEndStruct || !oldEndStruct.storageKey) { continue; }
          if (oldEndStruct.storageKey === newKey) { continue; }
          if (sameEndByStructure(newEnd, oldEndStruct)) {
            matchedOldIdx = k;
            break;
          }
        }
      }

      if (matchedOldIdx < 0) {
        return;
      }

      var oldEnd = oldEnds[matchedOldIdx];
      var oldKey = oldEnd.storageKey;
      usedOldIdx[matchedOldIdx] = true;

      var movedThisField = false;
      instances.forEach(function(inst) {
        if (!inst || !Object.prototype.hasOwnProperty.call(inst, oldKey)) {
          return;
        }
        var oldRaw = inst[oldKey];
        var refsCount = countRefs(oldEnd, oldRaw);
        if (!Object.prototype.hasOwnProperty.call(inst, newKey)) {
          inst[newKey] = oldRaw;
          movedThisField = true;
          preservedLinks += refsCount;
        }
        delete inst[oldKey];
      });

      if (movedThisField) {
        preservedFields++;
      }
    });

    if (preservedFields > 0) {
      var msgKept = "Info: Association role-name changes were detected in class '" + className + "'. Existing association data was preserved for " + preservedFields + " association field(s)" +
                    (preservedLinks > 0 ? (", covering " + preservedLinks + " link(s).") : ".");
      Page.crudAdjustmentMessages.push(msgKept);
    }

    // Remove stale fields that no longer map to any current association end.
    var removedLinks = 0;
    var removedFields = 0;
    oldEnds.forEach(function(oldEnd, idxOld) {
      if (!oldEnd || !oldEnd.storageKey) { return; }
      var oldKey = oldEnd.storageKey;
      if (newKeys[oldKey]) { return; }
      if (usedOldIdx[idxOld]) { return; }

      var removedAnyForField = false;
      instances.forEach(function(inst) {
        if (!inst || !Object.prototype.hasOwnProperty.call(inst, oldKey)) {
          return;
        }
        removedLinks += countRefs(oldEnd, inst[oldKey]);
        delete inst[oldKey];
        removedAnyForField = true;
      });
      if (removedAnyForField) {
        removedFields++;
      }
    });

    if (removedFields > 0) {
      var msgRemoved = "Info: Some association data in class '" + className + "' was removed because those association definition(s) no longer exist after your model changes. " +
                       "Removed " + removedFields + " stale field(s)" +
                       (removedLinks > 0 ? (" and " + removedLinks + " stale link(s).") : ".");
      Page.crudAdjustmentMessages.push(msgRemoved);
    }
  });
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
    var nextRaw = inst[fieldName];
    var nextRefs = Page.normalizeCrudAssociationRefs
      ? Page.normalizeCrudAssociationRefs(end, nextRaw)
      : [];
    var next = null;
    if (nextRefs.length > 0) {
      var r0 = nextRefs[0];
      if (r0 && r0.className === className && typeof r0.index === "number") {
        next = r0.index;
      }
    }
    current = next;
  }
};

// Validate association multiplicities globally across all classes and
// instances, taking into account a pending update for a single instance
// (the instance currently being saved). This allows us to surface
// conflicts that arise when the model's associations have changed in a
// way that existing instances no longer satisfy (e.g., adding a new
// mandatory association to a class that already has instances).
//
// pendingUpdate: optional object of the form
//   {
//      className: <string>,
//      index: <number>,     // index within instances[] when editing
//      isEdit: <boolean>,   // true if editing existing, false if adding
//      newInst: <object>    // instance snapshot about to be saved
//   }
//
// Returns an array of human-readable error messages. No side effects are
// performed on Page.crudData.
Page.validateCrudGlobalModel = function(pendingUpdate) {
  var errors = [];

  // Reset global count before each validation run.
  Page.crudGlobalErrorCount = 0;

  if (!Page.crudAssociationsByClass || !Page.crudData || !Page.crudData.classes) {
    return errors;
  }

  var classesData = Page.crudData.classes;
  var totalViolations = 0;

  // Association multiplicity validation
  for (var fromClass in Page.crudAssociationsByClass) {
    if (!Page.crudAssociationsByClass.hasOwnProperty(fromClass)) { continue; }

    var ends = Page.crudAssociationsByClass[fromClass] || [];
    if (!ends.length) { continue; }

    var classInfo = classesData[fromClass];
    if (!classInfo) { continue; }

    var baseInstances = classInfo.instances || [];
    var baseCount = baseInstances.length;

    var isPendingForClass = !!(pendingUpdate && pendingUpdate.className === fromClass && pendingUpdate.newInst);
    var virtualExtra = (isPendingForClass && !pendingUpdate.isEdit) ? 1 : 0;
    var virtualCount = baseCount + virtualExtra;

    ends.forEach(function(end) {
      if (!end) { return; }

      var fieldName = end.storageKey;
      if (!fieldName) { return; }

      var minRequired = (typeof end.toMin === "number") ? end.toMin : 0;
      var maxAllowed = (typeof end.toMax === "number") ? end.toMax : null;

      // If there are no multiplicity constraints, skip this end.
      if (minRequired <= 0 && (maxAllowed === null || maxAllowed === undefined)) {
        return;
      }

      var missingCount = 0;
      var overMaxCount = 0;
      var missingInstanceIndices = [];
      var overMaxInstanceIndices = [];

      for (var i = 0; i < virtualCount; i++) {
        var inst;
        if (isPendingForClass) {
          if (!pendingUpdate.isEdit && i === baseCount) {
            inst = pendingUpdate.newInst;
          } else if (pendingUpdate.isEdit && i === pendingUpdate.index) {
            inst = pendingUpdate.newInst;
          } else {
            inst = baseInstances[i];
          }
        } else {
          inst = baseInstances[i];
        }

        if (!inst) { continue; }

        var rawVal = inst[fieldName];
        var refsForCount = Page.normalizeCrudAssociationRefs
          ? Page.normalizeCrudAssociationRefs(end, rawVal)
          : [];
        var linkCount = refsForCount.length;

        if (linkCount < minRequired) {
          missingCount++;
          missingInstanceIndices.push(i);
        }
        if (maxAllowed !== null && maxAllowed !== undefined && linkCount > maxAllowed) {
          overMaxCount++;
          overMaxInstanceIndices.push(i);
        }
      }

      if (missingCount > 0) {
        totalViolations += missingCount;
        var targetInfo = classesData[end.toClass];
        var targetCount = (targetInfo && Array.isArray(targetInfo.instances)) ? targetInfo.instances.length : 0;

        // If the class we are saving is the target side of this
        // association, include its pending new instance in the target
        // count so that messages evolve naturally from "create" to
        // "associate" when the first instance is added.
        if (pendingUpdate && pendingUpdate.newInst && pendingUpdate.className === end.toClass) {
          if (!pendingUpdate.isEdit) {
            targetCount += 1;
          }
        }

        if (minRequired >= 1) {
          if (targetCount === 0) {
            errors.push(
              "Conflict: " + fromClass + " cannot exist without " + end.toClass + " according to the updated association. " +
              "Please create at least one " + end.toClass + " instance and associate it with the existing " + fromClass + " instances."
            );
          } else {
            var countWord = (minRequired === 1) ? "instance" : "instances";
            var minText;

            if (maxAllowed !== null && maxAllowed === minRequired) {
              // Exact cardinality, e.g., 3 or 3..3
              minText = "exactly " + minRequired + " " + end.toClass + " " + countWord;
            } else if (maxAllowed === null) {
              // Lower bound only, e.g., 3..*
              minText = "at least " + minRequired + " " + end.toClass + " " + countWord;
            } else if (maxAllowed !== null && maxAllowed > minRequired) {
              // Bounded range, e.g., 1..3 or 2..5
              var maxCountWord = (maxAllowed === 1) ? "instance" : "instances";
              if (minRequired === maxAllowed) {
                minText = "exactly " + minRequired + " " + end.toClass + " " + countWord;
              } else {
                minText = "between " + minRequired + " and " + maxAllowed + " " + end.toClass + " " + maxCountWord;
              }
            } else {
              // Fallback: at least minRequired
              minText = "at least " + minRequired + " " + end.toClass + " " + countWord;
            }
            if (missingInstanceIndices.length > 0) {
              var firstIdx = missingInstanceIndices[0];
              var label = fromClass + "[" + (firstIdx + 1) + "]";
              errors.push(
                "Please associate " + label + " with " + minText + " to satisfy association '" + end.assocName + "'."
              );
            } else {
              errors.push(
                "Please associate " + fromClass + " with " + minText + " to satisfy association '" + end.assocName + "'."
              );
            }
          }
        } else {
          errors.push(
            "Some " + fromClass + " instances do not satisfy the multiplicity constraints for association '" + end.assocName + "' to " + end.toClass + "."
          );
        }
      }

      if (overMaxCount > 0) {
        totalViolations += overMaxCount;
        if (overMaxInstanceIndices.length > 0) {
          var overIdx = overMaxInstanceIndices[0];
          var overLabel = fromClass + "[" + (overIdx + 1) + "]";
          var maxText = (maxAllowed === 1) ? "one" : ("" + maxAllowed);
          errors.push(
            "Please reduce the number of associated " + end.toClass + " instances for " + overLabel + " to at most " + maxText + " to satisfy association '" + end.assocName + "'."
          );
        } else {
          errors.push(
            "Some " + fromClass + " instances exceed the maximum allowed number of " + end.toClass + " links for association '" + end.assocName + "'."
          );
        }
      }
    });
  }

  // Key uniqueness validation: ensure that, for each class, keys are unique.
  // When a single key attribute is defined, uniqueness is enforced per
  // attribute. When multiple attributes are listed as keys, they form a
  // composite key and uniqueness is enforced on the combination of their
  // values.
  for (var className in classesData) {
    if (!classesData.hasOwnProperty(className)) { continue; }

    var classInfoKeys = classesData[className];
    if (!classInfoKeys) { continue; }

    var keyAttrs = Array.isArray(classInfoKeys.keys) ? classInfoKeys.keys : [];
    if (!keyAttrs.length) { continue; }

    var baseInstancesK = classInfoKeys.instances || [];
    var baseCountK = baseInstancesK.length;

    var isPendingForClassK = !!(pendingUpdate && pendingUpdate.className === className && pendingUpdate.newInst);
    var virtualExtraK = (isPendingForClassK && !pendingUpdate.isEdit) ? 1 : 0;
    var virtualCountK = baseCountK + virtualExtraK;

    // Helper to normalize a value for key comparison
    var normalizeValK = function(v) {
      if (v === undefined || v === null || v === "") { return null; }
      if (Array.isArray(v) && v.length === 0) { return null; }
      if (Array.isArray(v)) { return v.join(","); }
      return String(v);
    };

    var singleKeyMode = (keyAttrs.length === 1);
    var seenByAttr = {};
    var duplicateReportedByAttr = {};
    var seenComposite = {};
    var compositeDuplicateReported = false;

    if (singleKeyMode) {
      var onlyAttr = keyAttrs[0];
      if (onlyAttr) {
        seenByAttr[onlyAttr] = {};
        duplicateReportedByAttr[onlyAttr] = false;
      }
    } else {
      // Composite key mode: use seenComposite map instead of seenByAttr
      keyAttrs.forEach(function(attrName) {
        if (!attrName) { return; }
        // still initialise maps so later code can rely on them if needed
        seenByAttr[attrName] = {};
        duplicateReportedByAttr[attrName] = false;
      });
    }

    for (var iK = 0; iK < virtualCountK; iK++) {
      var instK;
      if (isPendingForClassK) {
        if (!pendingUpdate.isEdit && iK === baseCountK) {
          instK = pendingUpdate.newInst;
        } else if (pendingUpdate.isEdit && iK === pendingUpdate.index) {
          instK = pendingUpdate.newInst;
        } else {
          instK = baseInstancesK[iK];
        }
      } else {
        instK = baseInstancesK[iK];
      }

      if (!instK) { continue; }

      if (singleKeyMode) {
        var attrNameSingle = keyAttrs[0];
        if (attrNameSingle) {
          var vSingle = normalizeValK(instK[attrNameSingle]);
          if (vSingle !== null) {
            var seenMapSingle = seenByAttr[attrNameSingle];
            if (seenMapSingle && seenMapSingle[vSingle]) {
              totalViolations += 1;
              if (!duplicateReportedByAttr[attrNameSingle]) {
                duplicateReportedByAttr[attrNameSingle] = true;
                var labelSingleK = className + "[" + (iK + 1) + "]";
                errors.push(
                  "The value for key attribute '" + attrNameSingle + "' in " + labelSingleK + " already exists. " +
                  "Please enter a unique value because '" + attrNameSingle + "' is defined as a key."
                );
              }
            } else if (seenMapSingle) {
              seenMapSingle[vSingle] = true;
            }
          }
        }
      } else {
        // Composite key: build tuple across all key attributes for this instance
        var partsK = [];
        var missingPart = false;
        for (var a = 0; a < keyAttrs.length; a++) {
          var aNameK = keyAttrs[a];
          if (!aNameK) { continue; }
          var vPart = normalizeValK(instK[aNameK]);
          if (vPart === null) {
            missingPart = true;
            break;
          }
          partsK.push(vPart);
        }
        if (!missingPart && partsK.length === keyAttrs.length) {
          var tupleKey = partsK.join("||");
          if (seenComposite[tupleKey]) {
            totalViolations += 1;
            if (!compositeDuplicateReported) {
              compositeDuplicateReported = true;
              var labelCompK = className + "[" + (iK + 1) + "]";
              errors.push(
                "The combination of key attributes '" + keyAttrs.join(", ") + "' in " + labelCompK + " already exists. " +
                "Please enter a unique combination because these attributes form a composite key."
              );
            }
          } else {
            seenComposite[tupleKey] = true;
          }
        }
      }
    }
  }

  // De-duplicate messages so the same textual error is only shown once.
  var seen = {};
  var unique = [];
  errors.forEach(function(msg) {
    if (!msg || seen[msg]) { return; }
    seen[msg] = true;
    unique.push(msg);
  });

  // Expose the total number of individual multiplicity violations so the
  // global banner can show a quick summary (e.g., "Total 37 validation
  // errors") even when messages are aggregated.
  Page.crudGlobalErrorCount = totalViolations;

  return unique;
};

// Render high-level global CRUD validation messages at the top of the
// CRUD UI container (just under the JSON / Instance Diagram controls).
// This surfaces association conflicts even when individual class
// dialogs are not expanded.
Page.renderCrudGlobalErrors = function(containerSelector) {
  var container = containerSelector ? jQuery(containerSelector) : (Page.currentCrudContainer || jQuery("#innerGeneratedCodeRow"));
  if (!container || !container.length) {
    return;
  }

  // Remove any existing banner before re-rendering.
  container.find(".crud-global-errors-banner").remove();

  var infoMessages = Page.crudAdjustmentMessages || [];
  var validationMessages = Page.validateCrudGlobalModel(null) || [];
  var messages = infoMessages.concat(validationMessages);
  if (!messages.length) {
    return;
  }

  // Use blue for purely informational messages and red when there are
  // any actual validation errors.
  var allInfo = messages.every(function(msg) {
    return msg && msg.indexOf("Info:") === 0;
  });
  var color = allInfo ? "#0074D9" : "red";

  var displayMessages = messages.map(function(msg) {
    return msg ? msg.replace(/^Info:\s*/, "") : msg;
  });
  var prefix = "";
  var errorCount = Page.crudGlobalErrorCount || 0;
  if (!allInfo && errorCount > 0) {
    prefix = "Total " + errorCount + " validation error" + (errorCount === 1 ? "" : "s") + ". ";
  }

  var html = "<div class='crud-global-errors-banner' style='color:" + color + ";margin:6px 0 10px 0;'>" +
             prefix + "<br/>" + displayMessages.join(" ") +
             "</div>";

  var jsonRow = container.find(".crud-json-actions");
  if (jsonRow.length) {
    jsonRow.after(html);
  } else {
    container.prepend(html);
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
  // Only handle updates when the edited instance's runtime class is
  // the same as or a subclass of the association's fromClass. This
  // allows subclass-specific forms (e.g., Student isA Person) to keep
  // reverse links in sync for associations declared on the base type.
  if (!Page.isCrudSubclass || !Page.isCrudSubclass(className, fromClass)) {
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

  // Find reverse end definition: same association id, from the target
  // root class back to this class's root type.
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

  // Normalize the forward value into canonical refs for this end.
  var forwardRefs = Page.normalizeCrudAssociationRefs(end, newValue);
  var sourceRef = { className: className, index: index };

  // For each concrete target class that can play the role of toClass
  // (i.e., toClass and its subclasses), update the reverse end to
  // reflect the new forwardRefs.
  var classesData = Page.crudData.classes;
  // Track replacements for single-valued reverse ends so that we can
  // remove stale forward links from any previous source instance.
  var replacedSingleLinks = [];

  Object.keys(classesData).forEach(function(targetRuntimeClass) {
    if (!Page.isCrudSubclass(targetRuntimeClass, toClass)) {
      return;
    }
    var targetInfo = classesData[targetRuntimeClass] || {};
    var targetInstances = targetInfo.instances || [];
    for (var tIdx = 0; tIdx < targetInstances.length; tIdx++) {
      var tInst = targetInstances[tIdx] || {};

      var shouldLink = false;
      for (var r = 0; r < forwardRefs.length; r++) {
        var fr = forwardRefs[r];
        if (fr.className === targetRuntimeClass && fr.index === tIdx) {
          shouldLink = true;
          break;
        }
      }

      var currentRaw = tInst[revKey];
      var currentRefs = Page.normalizeCrudAssociationRefs(reverseEnd, currentRaw);

      if (revMultiple) {
        var hasRef = false;
        var filtered = [];
        for (var k = 0; k < currentRefs.length; k++) {
          var cr = currentRefs[k];
          if (cr.className === sourceRef.className && cr.index === sourceRef.index) {
            hasRef = true;
            if (!shouldLink) { continue; }
          }
          filtered.push(cr);
        }
        if (shouldLink && !hasRef) {
          filtered.push(sourceRef);
        }
        tInst[revKey] = filtered;
      } else {
        if (shouldLink) {
          if (currentRefs.length > 0) {
            var oldRef = currentRefs[0];
            if (!(oldRef.className === sourceRef.className && oldRef.index === sourceRef.index)) {
              // Remember that this target instance is now owned by a
              // different source so we can strip the target from the
              // old source's forward association field.
              replacedSingleLinks.push({
                oldSource: { className: oldRef.className, index: oldRef.index },
                targetClassName: targetRuntimeClass,
                targetIndex: tIdx
              });
            }
          }
          tInst[revKey] = sourceRef;
        } else {
          if (currentRefs.length > 0) {
            var cr0 = currentRefs[0];
            if (cr0.className === sourceRef.className && cr0.index === sourceRef.index) {
              tInst[revKey] = null;
            }
          }
        }
      }
    }
  });

  // For associations where the reverse end is single-valued, a target
  // instance can only be linked to one source at a time. When a target
  // is re-assigned to a new source, also remove that target from the
  // old source's forward association field so that stale references do
  // not accumulate.
  if (!revMultiple && replacedSingleLinks.length > 0) {
    var forwardKey = end.storageKey;
    replacedSingleLinks.forEach(function(entry) {
      var old = entry.oldSource;
      var targetClassName = entry.targetClassName;
      var targetIndex = entry.targetIndex;
      var srcData = classesData[old.className] || {};
      var srcInstances = srcData.instances || [];
      if (old.index < 0 || old.index >= srcInstances.length) {
        return;
      }
      var srcInst = srcInstances[old.index] || {};
      var rawForward = srcInst[forwardKey];
      var fwdRefs = Page.normalizeCrudAssociationRefs(end, rawForward);
      if (!fwdRefs.length) {
        return;
      }

      var updated;
      if (Array.isArray(rawForward)) {
        // Multi-valued forward end: filter out the stolen target.
        updated = [];
        for (var i = 0; i < fwdRefs.length; i++) {
          var fr2 = fwdRefs[i];
          if (fr2.className === targetClassName && fr2.index === targetIndex) {
            continue;
          }
          updated.push(fr2);
        }
        srcInst[forwardKey] = updated;
      } else {
        // Single-valued forward end: clear it if it points at this target.
        var fr0 = fwdRefs[0];
        if (fr0.className === targetClassName && fr0.index === targetIndex) {
          srcInst[forwardKey] = null;
        }
      }
    });
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
    var rawVal = inst[key];
    if (rawVal === undefined || rawVal === null) { return; }

    var refs = Page.normalizeCrudAssociationRefs(end, rawVal);
    if (!refs.length) { return; }

    // Delete targets in descending index order per concrete runtime
    // class so that earlier indices remain valid as we remove later
    // ones.
    var byClass = {};
    refs.forEach(function(ref) {
      if (!ref || typeof ref.index !== "number" || ref.index < 0 || !ref.className) {
        return;
      }
      if (!byClass[ref.className]) {
        byClass[ref.className] = [];
      }
      byClass[ref.className].push(ref.index);
    });

    Object.keys(byClass).forEach(function(targetClass) {
      var idxs = byClass[targetClass];
      if (!idxs || !idxs.length) { return; }
      idxs.sort(function(a, b) { return b - a; });
      idxs.forEach(function(tIdx) {
        Page.removeCrudInstance(targetClass, tIdx);
      });
    });
  });

  // Remove the instance itself
  instances.splice(index, 1);

  // Reindex any association links that may point to this concrete class
  // through ends whose target type can include this class.
  for (var sourceClass in assocByClass) {
    if (!assocByClass.hasOwnProperty(sourceClass)) { continue; }
    var ends = assocByClass[sourceClass] || [];
    if (!ends.length) { continue; }
    var sourceInfo = Page.crudData.classes[sourceClass];
    if (!sourceInfo) { continue; }
    var sourceInstances = sourceInfo.instances || [];

    ends.forEach(function(end) {
      if (!end) { return; }
      if (!Page.isCrudSubclass(className, end.toClass)) { return; }
      var key = end.storageKey;

      sourceInstances.forEach(function(inst) {
        var raw = inst[key];
        var refs = Page.normalizeCrudAssociationRefs(end, raw);
        if (!refs.length && (raw === null || typeof raw === "undefined")) {
          return;
        }

        var multiple = end.toMultiplicity && end.toMultiplicity.indexOf("*") !== -1;
        var changed = false;

        if (multiple) {
          var newRefs = [];
          for (var r = 0; r < refs.length; r++) {
            var ref = refs[r];
            if (ref.className === className) {
              if (ref.index === index) {
                // Drop refs to the removed instance.
                changed = true;
                continue;
              }
              if (ref.index > index) {
                ref = { className: ref.className, index: ref.index - 1 };
                changed = true;
              }
            }
            newRefs.push(ref);
          }
          if (changed) {
            inst[key] = newRefs;
          }
        } else {
          if (!refs.length) {
            return;
          }
          var refSingle = refs[0];
          if (refSingle.className === className) {
            if (refSingle.index === index) {
              inst[key] = null;
              changed = true;
            } else if (refSingle.index > index) {
              inst[key] = { className: refSingle.className, index: refSingle.index - 1 };
              changed = true;
            }
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

// Determine candidate attributes for labelling instances of a given
// target class in association selectors. Returns an object of the form:
//   {
//      attrNames: ["id", "name", ...],       // all attribute names
//      nonNullAttrs: ["id", ...],             // attributes that have any data
//      defaultAttrName: "id" | "name" | ...   // best default, or null
//   }
Page.getCrudAssociationLabelCandidatesForClass = function(className) {
  if (!Page.crudData || !Page.crudData.classes || !Page.crudData.classes[className]) {
    return { attrNames: [], nonNullAttrs: [], defaultAttrName: null };
  }

  var classInfo = Page.crudData.classes[className];
  var attrs = classInfo.attributes || [];
  var instances = classInfo.instances || [];

  var attrNames = [];
  attrs.forEach(function(attr) {
    if (attr && attr.name) {
      attrNames.push(attr.name);
    }
  });

  var nonNullAttrs = [];
  attrNames.forEach(function(name) {
    var hasData = false;
    for (var i = 0; i < instances.length; i++) {
      var v = instances[i] && instances[i][name];
      if (v !== undefined && v !== null && v !== "") {
        hasData = true;
        break;
      }
    }
    if (hasData) {
      nonNullAttrs.push(name);
    }
  });

  var defaultAttrName = null;
  var pickFrom = nonNullAttrs;

  function findFirstExact(nameLower) {
    for (var i = 0; i < pickFrom.length; i++) {
      if (pickFrom[i].toLowerCase() === nameLower) {
        return pickFrom[i];
      }
    }
    return null;
  }

  function findFirstMatching(predicate) {
    for (var i = 0; i < pickFrom.length; i++) {
      if (predicate(pickFrom[i].toLowerCase())) {
        return pickFrom[i];
      }
    }
    return null;
  }

  // 1) Prefer a plain "id" column
  defaultAttrName = findFirstExact("id");

  // 2) Then id-like names: id_*, *_id, *_id_*
  if (!defaultAttrName) {
    defaultAttrName = findFirstMatching(function(lower) {
      return lower.indexOf("id_") === 0 ||
             lower.lastIndexOf("_id") === lower.length - 3 ||
             lower.indexOf("_id_") !== -1;
    });
  }

  // 3) Then a plain "name" column
  if (!defaultAttrName) {
    defaultAttrName = findFirstExact("name");
  }

  // 4) Then name-like names: name_*, *_name, *_name_*
  if (!defaultAttrName) {
    defaultAttrName = findFirstMatching(function(lower) {
      return lower.indexOf("name_") === 0 ||
             lower.lastIndexOf("_name") === lower.length - 5 ||
             lower.indexOf("_name_") !== -1;
    });
  }

  // 5) Finally, fall back to the first attribute with any data
  if (!defaultAttrName && pickFrom.length > 0) {
    defaultAttrName = pickFrom[0];
  }

  return {
    attrNames: attrNames,
    nonNullAttrs: nonNullAttrs,
    defaultAttrName: defaultAttrName
  };
};

// Build a human-friendly label for a target instance in an association
// selector. When preferredKey is an attribute name, we try that first;
// when it is "__index__" we always use ClassName[index] based on the
// runtime class and its own index when available, falling back to the
// declared targetClass and positional index.
Page.buildCrudAssociationLabelForInstance = function(targetClass, inst, index, labelMeta, preferredKey, runtimeClass, runtimeIndex) {
  var classForIndex = runtimeClass || targetClass;
  var ordinalIndex = (typeof runtimeIndex === "number" && runtimeIndex >= 0) ? runtimeIndex : index;
  var baseLabel = classForIndex + "[" + (ordinalIndex + 1) + "]";
  if (!inst || !labelMeta) {
    return baseLabel;
  }

  var attrNames = labelMeta.attrNames || [];

   // Explicit request to use the positional label only.
   if (preferredKey === "__index__") {
     return baseLabel;
   }

  // If an explicit attribute has been chosen for this class, try it
  // first, but fall back gracefully when the value is empty.
  if (preferredKey) {
    var directVal = inst[preferredKey];
    if (directVal !== undefined && directVal !== null && directVal !== "") {
      return String(directVal);
    }
  }

  function firstAttrValueMatching(predicate) {
    for (var i = 0; i < attrNames.length; i++) {
      var name = attrNames[i];
      var lower = name.toLowerCase();
      if (predicate && !predicate(lower)) {
        continue;
      }
      var v = inst[name];
      if (v !== undefined && v !== null && v !== "") {
        return String(v);
      }
    }
    return null;
  }

  // Heuristic per record: id → name → id-like → name-like → first non-empty
  var val = firstAttrValueMatching(function(lower) { return lower === "id"; });
  if (val !== null) { return val; }

  val = firstAttrValueMatching(function(lower) { return lower === "name"; });
  if (val !== null) { return val; }

  val = firstAttrValueMatching(function(lower) {
    return lower.indexOf("id_") === 0 ||
           lower.lastIndexOf("_id") === lower.length - 3 ||
           lower.indexOf("_id_") !== -1;
  });
  if (val !== null) { return val; }

  val = firstAttrValueMatching(function(lower) {
    return lower.indexOf("name_") === 0 ||
           lower.lastIndexOf("_name") === lower.length - 5 ||
           lower.indexOf("_name_") !== -1;
  });
  if (val !== null) { return val; }

  val = firstAttrValueMatching(function() { return true; });
  if (val !== null) { return val; }

  return baseLabel;
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
  $panel.data("crudActiveClass", className);
};

// Sets up clickable class headers and hides underlying forms
// If containerSelector is provided, CRUD UI will be initialized inside
// that container (used for Live View); otherwise it defaults to the
// bottom generated-code area for the given tabnumber.
Page.initCrudUi = function(tabnumber, containerSelector) {
  var container = containerSelector ? jQuery(containerSelector) : jQuery("#innerGeneratedCodeRow" + tabnumber);

  // Remember current container for inline CRUD panel rendering
  Page.currentCrudContainer = container;

  // Add JSON persistence controls once per container
    if (container.find(".crud-json-actions").length === 0) {
      var jsonHtml = "<div class='crud-json-actions' style='margin:6px 0 10px 0;'>" +
        "<div class='crud-json-row'>" +
        "<button type='button' id='crud-generate-json' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button' style='margin-right:6px;'>Download JSON</button>" +
        "<button type='button' id='crud-generate-random-data' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button' style='margin-right:6px;'>Generate Random Data</button>" +
      "<button type='button' id='crud-load-json' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button' style='margin-right:6px;'>Load JSON</button>" +
      "<button type='button' id='crud-clear-all' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button' style='margin-right:6px;'>Clear All</button>" +
      "<button type='button' id='crud-clear-errors-validate' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button' style='margin-right:6px;'>Validate data</button>" +
        "</div>" +
        "<div class='crud-json-row' style='margin-top:6px;'>" +
      "<button type='button' id='crud-load-instance-diagram' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button'>Load as Instance Diagram</button>" +
        "</div>" +
      "<input type='file' id='crud-load-json-file' accept='application/json,.json' style='display:none;' />" +
      "</div>";
    container.prepend(jsonHtml);

    // Helper to show or hide an informational message related to
    // instance-diagram or random-data issues within this CRUD panel.
    function showInstanceDiagramMessage(message) {
      var $existingErr = container.find(".crud-instance-diagram-error");
      if ($existingErr.length === 0) {
        var jsonRow = container.find(".crud-json-actions");
        var htmlErr = "<div class='crud-instance-diagram-error' style='color:red;margin:6px 0 10px 0;'></div>";
        if (jsonRow.length) {
          jsonRow.after(htmlErr);
          $existingErr = container.find(".crud-instance-diagram-error");
        } else {
          $existingErr = jQuery(htmlErr).prependTo(container);
        }
      }

      if (message) {
        $existingErr.text(message).show();
      } else {
        $existingErr.hide().text("");
      }
    }

    // Wire up JSON buttons
    container.find("#crud-generate-json").off("click").on("click", function() {
      if (typeof Page.crudJsonDownload === "function") {
        Page.crudJsonDownload();
      }
    });

    // Internal helper to call the backend Instance Diagram generator
    // for random data, with limited automatic retries when the
    // generator reports an empty diagram.
    function requestRandomCrudData(code, attempt) {
      var currentAttempt = attempt || 1;
      var maxAutoRetries = 2; // one automatic retry after the first failure

      jQuery.ajax({
        url: "scripts/crud_random_data.php",
        method: "POST",
        data: {
          code: code
          // Additional tuning parameters for random generation could be
          // threaded through via a 'suboptions' field in future.
        },
        dataType: "text",
        success: function(resp) {
          var parsed;
          var isEmptyDiagram = false;
          try {
            parsed = JSON.parse(resp);
            if (parsed && parsed.diagramIsEmpty) {
              isEmptyDiagram = true;
            }
          } catch (e) {
            // Non-JSON response; fall through to normal import path.
          }

          if (isEmptyDiagram) {
            // The Instance Diagram generator did not produce any
            // instances for this model. Perform a limited automatic
            // retry without immediately flashing an error message to
            // avoid flicker when a subsequent attempt succeeds. Only
            // show the informational message after the final retry
            // has also failed.
            if (currentAttempt < maxAutoRetries) {
              requestRandomCrudData(code, currentAttempt + 1);
            } else {
              showInstanceDiagramMessage("There is an issue generating random data. Please try again.");
            }
            return;
          }

          // Successful random data generation: clear any previous
          // informational message and import using the normal path.
          showInstanceDiagramMessage("");

          if (typeof Page.crudJsonImportFromText === "function") {
            Page.crudJsonImportFromText(resp);
            // After import, (re)open a CRUD dialog. Prefer the class
            // that was previously expanded, but only if it still
            // exists in the current model and is not abstract;
            // otherwise open the first non-abstract class.
            var targetClass = Page.crudClassSelected || null;
            if (Page.crudData && Page.crudData.classes) {
              if (!targetClass || !Page.crudData.classes[targetClass] || Page.crudData.classes[targetClass].isAbstract) {
                targetClass = null;
                Object.keys(Page.crudData.classes).some(function(cn) {
                  var info = Page.crudData.classes[cn] || {};
                  if (info.isAbstract) { return false; }
                  targetClass = cn;
                  return true;
                });
              }
            }
            if (targetClass && typeof Page.openCrudDialogForClass === "function") {
              Page.crudClassSelected = targetClass;
              Page.openCrudDialogForClass(targetClass);
            }
          }
        },
        error: function(xhr, status, err) {
          console.error("Failed to generate random instance data:", status, err, xhr && xhr.responseText);
        }
      });
    }

    // Ask the backend Instance Diagram generator for random data and
    // import the returned JSON using the same path as "Load JSON".
    container.find("#crud-generate-random-data").off("click").on("click", function() {
      if (typeof Page.getUmpleCode !== "function") {
        console.warn("No Umple code available for random data generation.");
        return;
      }
      var code = Page.getUmpleCode() || "";
      if (!code) {
        console.warn("Umple code is empty; cannot generate random data.");
        return;
      }

      requestRandomCrudData(code, 1);
    });

    container.find("#crud-load-json").off("click").on("click", function() {
      container.find("#crud-load-json-file").trigger("click");
    });

    // Clear all visible CRUD error banners/messages in this container
    // and re-run global CRUD validation to show the current state.
    container.find("#crud-clear-errors-validate").off("click").on("click", function() {
      var target = container;

      // Clear any existing per-instance and inline errors for this
      // CRUD view (bottom panel or live-view) so the user starts from
      // a clean slate.
      target.find(".crud-error").hide().text("");
      target.find(".crud-instance-diagram-error").hide().text("");
      target.find(".crud-global-errors-banner").remove();

      // Optionally reset informational adjustment messages so the
      // banner only reflects the latest validation pass.
      Page.crudAdjustmentMessages = [];

      if (typeof Page.renderCrudGlobalErrors === "function") {
        Page.renderCrudGlobalErrors(target);
      }
    });

    // Clear all CRUD instance data for all classes in the current
    // model. This leaves the schema intact but removes every
    // instance and refreshes counts and global messages.
    container.find("#crud-clear-all").off("click").on("click", function() {
      if (!Page.crudData || !Page.crudData.classes) {
        return;
      }
      Object.keys(Page.crudData.classes).forEach(function(className) {
        var info = Page.crudData.classes[className] || {};
        info.instances = [];
        Page.crudData.classes[className] = info;
        if (typeof Page.updateCrudClassCount === "function") {
          Page.updateCrudClassCount(className);
        }
      });

      // Reset any JSON export ID bookkeeping so future exports start
      // from a clean slate after clearing all instances.
      Page._crudJsonIds = {};
      Page._crudJsonIdCounter = 1;

      // Clear any multiplicity/adjustment messages and re-render the
      // global banner so the user sees a clean state.
      Page.crudAdjustmentMessages = [];
      if (typeof Page.renderCrudGlobalErrors === "function") {
        Page.renderCrudGlobalErrors(container);
      }

      // If a class dialog is currently open, refresh it so the empty
      // instance list is visible immediately.
      if (Page.crudClassSelected && typeof Page.openCrudDialogForClass === "function") {
        Page.openCrudDialogForClass(Page.crudClassSelected);
      }
    });

    container.find("#crud-load-json-file").off("change").on("change", function(evt) {
      var file = evt.target.files && evt.target.files[0];
      if (!file) { return; }
      // Ensure the selected file has a .json extension; if not, show
      // a clear message and abort without attempting to read it.
      var fname = file.name || "";
      var lowerName = fname.toLowerCase();
      if (lowerName && lowerName.indexOf(".json", Math.max(0, lowerName.length - 5)) === -1) {
        var msg = "The selected file ('" + fname + "') is not a .json file and cannot be loaded into CRUD.";
        if (typeof Page.setFeedbackMessage === "function") {
          Page.setFeedbackMessage(msg);
        } else {
          alert(msg);
        }
        // Reset the input so the user can pick another file.
        jQuery(this).val("");
        return;
      }
      var reader = new FileReader();
      reader.onload = function(e) {
        if (typeof Page.crudJsonImportFromText === "function") {
          Page.crudJsonImportFromText(e.target.result);
          // After import, (re)open a CRUD dialog. Prefer the class
          // that was previously expanded; if none, open the first
          // non-abstract class.
          var targetClass = Page.crudClassSelected || null;
          if (!targetClass && Page.crudData && Page.crudData.classes) {
            Object.keys(Page.crudData.classes).some(function(cn) {
              var info = Page.crudData.classes[cn] || {};
              if (info.isAbstract) { return false; }
              targetClass = cn;
              return true;
            });
          }
          if (Page.crudData && Page.crudData.classes) {
            if (!targetClass || !Page.crudData.classes[targetClass] || Page.crudData.classes[targetClass].isAbstract) {
              targetClass = null;
              Object.keys(Page.crudData.classes).some(function(cn) {
                var info = Page.crudData.classes[cn] || {};
                if (info.isAbstract) { return false; }
                targetClass = cn;
                return true;
              });
            }
          }
          if (targetClass && typeof Page.openCrudDialogForClass === "function") {
            Page.crudClassSelected = targetClass;
            Page.openCrudDialogForClass(targetClass);
          }
        }
      };
      reader.readAsText(file);
      // Reset the input so the same file can be chosen again later
      jQuery(this).val("");
    });

    // Use the current CRUD instances as input to the Instance Diagram
    // generator. This works by embedding a small JSON blob of per-class
    // instance counts into the Umple source as a special comment, then
    // invoking the InstanceDiagram generator with a custom suboption.
    container.find("#crud-load-instance-diagram").off("click").on("click", function() {
      Page.currentCrudContainer = container;

      // If the user is currently editing an *existing* instance in this
      // CRUD view, commit those changes first so the instance diagram
      // reflects the latest visible values. When the form is in "add new
      // instance" mode (no instanceIndex set), we intentionally do NOT
      // auto-save to avoid creating a new instance implicitly.
      var $form = container.find(".crud-instance-panel #crud-instance-form").first();
      var $saveButton = container.find(".crud-instance-panel #crud-save-instance").first();
      if ($saveButton.length && $form.length) {
        var idxVal = $form.find("input[name='instanceIndex']").val();
        if (idxVal !== "") {
          $saveButton.trigger("click");
        }
      }

      if (typeof Page.getUmpleCode !== "function" || typeof Page.setUmpleCode !== "function") {
        console.warn("Umple code accessors are unavailable; cannot load instance diagram from CRUD.");
        return;
      }

      if (!Page.crudData || !Page.crudData.classes) {
        Page.setFeedbackMessage && Page.setFeedbackMessage("No CRUD data available to build an instance diagram.");
        return;
      }

      var counts = {};
      var hasAny = false;
      // Also build a lightweight snapshot of attribute values and
      // association links per instance so the backend instance diagram
      // can render exactly what the user sees in the CRUD UI instead
      // of regenerating random attributes or links.
      var instanceSnapshot = { instances: [], associations: [] };

      var assocByClass = Page.crudAssociationsByClass || {};

      Object.keys(Page.crudData.classes).forEach(function(className) {
        var info = Page.crudData.classes[className] || {};
        var instances = info.instances || [];
        var count = instances.length || 0;
        if (count > 0) {
          counts[className] = count;
          hasAny = true;
        }

        if (count > 0) {
          var attrsMeta = info.attributes || [];
          // Precompute attribute names for this class so we only
          // capture real attributes, not internal association fields.
          var attrNames = [];
          attrsMeta.forEach(function(a) {
            if (a && a.name) {
              attrNames.push(a.name);
            }
          });

          var assocEndsAll = assocByClass[className] || [];
          // Match CRUD form behaviour: include association ends declared on
          // this class or inherited from superclasses, and for self-reflexive
          // associations sharing one storage field pick a single canonical end
          // (prefer single-valued) to avoid duplicate links.
          var assocEnds = [];
          var reflexiveByField = {};
          assocEndsAll.forEach(function(end) {
            if (!end || !end.storageKey) { return; }
            if (Page.isCrudSubclass && !Page.isCrudSubclass(className, end.fromClass)) {
              return;
            }

            if (end.fromClass === end.toClass) {
              var fieldName = end.storageKey;
              var existing = reflexiveByField[fieldName];
              if (!existing) {
                reflexiveByField[fieldName] = end;
              } else {
                var existingMax = (typeof existing.toMax === "number") ? existing.toMax : null;
                var newMax = (typeof end.toMax === "number") ? end.toMax : null;
                var existingMultiple = (existingMax === null || existingMax > 1);
                var newMultiple = (newMax === null || newMax > 1);
                if (existingMultiple && !newMultiple) {
                  reflexiveByField[fieldName] = end;
                }
              }
            } else {
              assocEnds.push(end);
            }
          });
          Object.keys(reflexiveByField).forEach(function(fieldName) {
            assocEnds.push(reflexiveByField[fieldName]);
          });

          instances.forEach(function(inst, idx) {
            if (!inst) { return; }
            var attrs = {};
            // Flatten attribute values to simple strings so the backend
            // JSON parser for @crudInstanceData always sees a predictable
            // shape and never falls back to randomized values. Include
            // every declared attribute name (using an empty string when
            // the CRUD instance has no stored value) so that the backend
            // does not synthesize random defaults for "missing" fields
            // on subsequent round-trips.
            attrNames.forEach(function(an) {
              var v = Object.prototype.hasOwnProperty.call(inst, an) ? inst[an] : "";
              if (typeof v === "undefined" || v === null) {
                v = "";
              }

              if (typeof v === "object") {
                // For nested objects or arrays, render a concise
                // summary like "k1=v1, k2=v2" or "v1, v2" so the
                // instance diagram can still display something
                // human-readable without introducing complex JSON
                // structures that the backend parser does not expect.
                if (Array.isArray(v)) {
                  var partsArr = [];
                  v.forEach(function(elem) {
                    if (typeof elem === "undefined" || elem === null || elem === "") { return; }
                    partsArr.push(String(elem));
                  });
                  attrs[an] = partsArr.length > 0 ? partsArr.join(", ") : "";
                } else {
                  var partsObj = [];
                  for (var k in v) {
                    if (!Object.prototype.hasOwnProperty.call(v, k)) { continue; }
                    var vv = v[k];
                    if (typeof vv === "undefined" || vv === null || vv === "") { continue; }
                    partsObj.push(k + "=" + vv);
                  }
                  attrs[an] = partsObj.length > 0 ? partsObj.join(", ") : "";
                }
              } else {
                attrs[an] = String(v);
              }
            });
            instanceSnapshot.instances.push({
              "class": className,
              index: idx + 1, // 1-based to match instance diagram numbering
              attrs: attrs
            });

            // Capture association links for this instance using the
            // same index space (1-based) so the backend can build
            // precise link matrices instead of random ones.
            assocEnds.forEach(function(end) {
              if (!end) { return; }
              var fieldName = end.storageKey;
              if (!fieldName) { return; }
              var rawVal = inst[fieldName];
              if (rawVal === undefined || rawVal === null || rawVal === "") {
                return;
              }

              var refs = (Page.normalizeCrudAssociationRefs && typeof Page.normalizeCrudAssociationRefs === "function")
                ? Page.normalizeCrudAssociationRefs(end, rawVal)
                : [];
              if (!refs.length) { return; }

              refs.forEach(function(ref) {
                if (!ref || typeof ref.index !== "number" || ref.index < 0) { return; }
                var runtimeToClass = ref.className || end.toClass;
                if (!runtimeToClass) { return; }
                var runtimeInfo = Page.crudData.classes[runtimeToClass] || {};
                var runtimeInstances = runtimeInfo.instances || [];
                if (ref.index >= runtimeInstances.length) { return; }
                instanceSnapshot.associations.push({
                  fromClass: className,
                  fromIndex: idx + 1,
                  toClass: runtimeToClass,
                  toIndex: ref.index + 1
                });
              });
            });
          });
        }
      });

      if (!hasAny) {
        var msgNoInstances = "No instances exist in CRUD to build an instance diagram.";
        // Show this message inline within the CRUD UI container rather than
        // in the global feedback area at the top of the page.
        var $existingErr = container.find(".crud-instance-diagram-error");
        if ($existingErr.length === 0) {
          var jsonRow = container.find(".crud-json-actions");
          var htmlErr = "<div class='crud-instance-diagram-error' style='color:red;margin:6px 0 10px 0;'></div>";
          if (jsonRow.length) {
            jsonRow.after(htmlErr);
            $existingErr = container.find(".crud-instance-diagram-error");
          } else {
            $existingErr = jQuery(htmlErr).prependTo(container);
          }
        }
        $existingErr.text(msgNoInstances).show();
        return;
      }

      var originalCode = Page.getUmpleCode() || "";
      // Remove any previous CRUD markers to avoid stale data.
      var cleanedCode = originalCode
        .replace(/^\/\/ @crudInstanceCounts .*$/gm, "")
        .replace(/^\/\/ @crudInstanceData .*$/gm, "");

      var jsonCountsText;
      var jsonDataText;
      try {
        jsonCountsText = JSON.stringify(counts);
        jsonDataText = JSON.stringify(instanceSnapshot);
      } catch (e) {
        console.error("Failed to serialize CRUD instance data:", e);
        Page.setFeedbackMessage && Page.setFeedbackMessage("Unable to serialize CRUD data for instance diagram.");
        return;
      }

      // Append markers as single-line comments. The backend will scan
      // for these and interpret the JSON payloads.
      var markerLineCounts = "// @crudInstanceCounts " + jsonCountsText;
      var markerLineData = "// @crudInstanceData " + jsonDataText;
      var sep = cleanedCode.length && !/\n$/.test(cleanedCode) ? "\n" : "";
      var newCode = cleanedCode + sep + markerLineCounts + "\n" + markerLineData + "\n";

      // Update the Umple source with CRUD markers but skip the
      // debounced typing pipeline so we don't immediately trigger a
      // second auto-refresh that would overwrite the generated
      // instance diagram with whatever diagram type was previously
      // selected in the live view.
      Page.setUmpleCode(newCode, undefined, true);

      if (typeof Action !== "undefined" && typeof Action.generateCode === "function") {
        // Ask the backend to generate an instance diagram using the
        // CRUD-supplied counts. The compiler will translate
        // "instanceDiagram.crudUseJson" into an InstanceDiagram
        // generation with the -s crudUseJson suboption.
        Action.generateCode("instanceDiagram", "instanceDiagram.crudUseJson");
      } else {
        console.warn("Action.generateCode is unavailable; cannot trigger instance diagram generation.");
      }
    });
  }

  // After ensuring the JSON controls exist, show any global validation
  // issues (e.g., strengthened associations that existing instances do
  // not yet satisfy) so they are visible even when no class is expanded.
  Page.renderCrudGlobalErrors(container);

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

    // Ensure the visible instance count for this class matches the
    // current number of instances we are carrying forward.
    if (!isAbstract) {
      var info = Page.crudData.classes[className] || {};
      var count = (info.instances && Array.isArray(info.instances)) ? info.instances.length : 0;
      var $countSpan = container.find(".crud-class-item[data-class='" + className + "'] .crud-class-count");
      if ($countSpan.length) {
        $countSpan.text("[" + count + "]");
      }
    }

    // Hide the raw form; interaction happens via popup dialog
    $form.hide();
  });

  // Click handler: open popup dialog for chosen class
  container.find(".crud-class-item").off("click").on("click", function() {
    var $item = jQuery(this);
    var className = $item.data("class");
    var isAbstract = $item.data("abstract") === true || $item.data("abstract") === "true";
    var $panel = container.find(".crud-instance-panel").first();
    var currentOpenClass = $panel.length ? ($panel.data("crudActiveClass") || null) : null;
    if (!currentOpenClass && Page.crudClassSelected) {
      currentOpenClass = Page.crudClassSelected;
    }

    var doSwitch = function() {
      // Ensure that subsequent dialog rendering targets the container
      // that this header belongs to (bottom panel vs live-view canvas).
      Page.currentCrudContainer = container;

      // Visually indicate the selected class header
      container.find(".crud-class-item").removeClass("crud-class-item-active active");
      $item.addClass("crud-class-item-active active");

      if (isAbstract) {
        Page.showCrudAbstractMessage(className);
      } else {
        Page.openCrudDialogForClass(className);
      }
    };

    // If the user is switching away from a different class form with
    // unsaved edits, confirm before discarding those in-progress changes.
    if ($panel.length && currentOpenClass && currentOpenClass !== className && Page.isCrudFormDirty && Page.isCrudFormDirty($panel)) {
      Page.showCrudConfirmModal(
        "Switching forms will discard your unsaved changes. Do you want to continue?",
        function() { doSwitch(); },
        function() { /* stay on current form */ }
      );
      return;
    }

    doSwitch();
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
  // Map from storageKey to the association end that is actually rendered
  // in the form for this class. This keeps the save logic aligned with
  // the UI (e.g., picking the single-valued end for a reflexive
  // association like mentor instead of the many-valued opposite).
  var assocEndByField = {};
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
        // Starts as 'Show Associations'; when the associations panel is
        // visible this option text is toggled to 'Hide Associations'.
        html += "<option value='associations'>Show Associations</option>";
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

  // Add/Edit form. The heading starts in "Add" mode and is updated to
  // "Edit Class[index] Instance" when an existing instance is selected.
  html += "<h4 class='crud-instance-form-heading'>Add Instance</h4>";
  html += "<div class='crud-error' style='color:red;margin-bottom:6px;display:none;'></div>";
  html += "<form id='crud-instance-form' data-class='" + className + "'>";
  html += "<input type='hidden' name='instanceIndex' value='' />";
  var keyAttrsForClass = (Page.crudData && Page.crudData.classes && Page.crudData.classes[className] && Array.isArray(Page.crudData.classes[className].keys))
    ? Page.crudData.classes[className].keys
    : [];

  attrs.forEach(function(attr) {
    var attrName = attr.name;
    var typeInfo = Page.getCrudTypeInfo(attr.type);
    if (!attrName) { return; }
    var isKeyAttr = keyAttrsForClass.indexOf(attrName) !== -1;
    html += "<div class='crud-field'>";
    var tooltipHtml = Page.buildCrudTooltip(attrName, attr.type, attr.inheritedFrom);
    html += "<label class='crud-field-label'><span class='crud-tooltip-target' data-crud-tooltip-html=\"" + tooltipHtml + "\">" + attrName + "</span>";
    if (isKeyAttr) {
      html += "<span class='crud-key-required-asterisk' style='color:red;' title='Key attribute (required and must be unique)'>*</span>";
    }
    html += "</label>";
    html += Page.buildCrudInputHtml(attrName, typeInfo);

    html += "</div>";
  });

  // Association selectors for navigable ends from this class.
  // Render selectors for every navigable end so that for a
  // bidirectional association (A -- C), links are editable from
  // both classes A and C. For self-reflexive associations we may
  // have two navigable ends with the same storageKey; in that case
  // choose a single canonical end (preferring single-valued over
  // many-valued) so the UI does not show duplicate groups and so
  // save logic can align with the rendered controls.
  var assocSelectorEnds = [];
  var reflexiveByField = {};

  assocEnds.forEach(function(end) {
    if (!end || !end.storageKey) { return; }
    var fieldName = end.storageKey;

    if (end.fromClass === end.toClass) {
      var existing = reflexiveByField[fieldName];
      if (!existing) {
        reflexiveByField[fieldName] = end;
      } else {
        // Prefer the end whose target multiplicity is strictly
        // single-valued (max <= 1). If both are multi-valued or
        // both single-valued, keep the first.
        var existingMax = (typeof existing.toMax === "number") ? existing.toMax : null;
        var newMax = (typeof end.toMax === "number") ? end.toMax : null;
        var existingMultiple = (existingMax === null || existingMax > 1);
        var newMultiple = (newMax === null || newMax > 1);
        if (existingMultiple && !newMultiple) {
          reflexiveByField[fieldName] = end;
        }
      }
    } else {
      assocSelectorEnds.push(end);
      assocEndByField[fieldName] = end;
    }
  });

  // Add the chosen reflexive ends (if any) after non-reflexive ones.
  Object.keys(reflexiveByField).forEach(function(fieldName) {
    var chosen = reflexiveByField[fieldName];
    assocSelectorEnds.push(chosen);
    assocEndByField[fieldName] = chosen;
  });

  if (assocSelectorEnds.length > 0) {
    // Use a plain text label rather than a heading so this section
    // does not visually compete with the main "Add/Edit Instance"
    // heading or look like it refers to an existing row.
    html += "<div class='crud-assoc-section-label' style='margin:8px 0 4px 0;font-weight:normal;'>Associations from this instance</div>";
    assocSelectorEnds.forEach(function(end) {
      var targetClass = end.toClass;
      var targetInfo = Page.crudData.classes[targetClass];
      // Build polymorphic target list: targetClass and all its subclasses.
      var polyTargets = Page.getCrudPolymorphicTargets
        ? Page.getCrudPolymorphicTargets(targetClass)
        : [];
      var fieldName = end.storageKey;

      html += "<div class='crud-field crud-assoc-field'>";
      var labelText = targetClass;
      if (end.fromClass === end.toClass && end.roleName) {
        labelText += " (" + end.roleName + ")";
      }
      var minRequired = (typeof end.toMin === "number") ? end.toMin : 0;
      var isRequired = minRequired > 0;
      var assocTooltip = "";
      if (end.inheritedFrom) {
        assocTooltip = "This is an inherited association from " + end.inheritedFrom + ".";
      }
      if (end.cascadeDeleteTargets) {
        var compText = className + " composes " + targetClass + " (deleting " + className + " will also delete its " + targetClass + " instances).";
        assocTooltip = assocTooltip ? (assocTooltip + " " + compText) : compText;
      }
      html += "<div class='crud-assoc-header'>";
      if (assocTooltip) {
        html += "<label class='crud-field-label'>" +
                 "<span class='crud-tooltip-target' title='" + assocTooltip.replace(/\"/g, "&quot;") + "'>" + labelText + "</span>" +
                 (isRequired ? "<span class='crud-assoc-required-asterisk' title='Required'>*</span>" : "") +
                 "</label>";
      } else {
        html += "<label class='crud-field-label'>" + labelText +
                 (isRequired ? "<span class='crud-assoc-required-asterisk' title='Required'>*</span>" : "") +
                 "</label>";
      }

      // Determine how to label options for this target class based on
      // existing attribute data and any user-chosen preference.
      var labelMeta = Page.getCrudAssociationLabelCandidatesForClass(targetClass);
      var nonNullAttrs = (labelMeta && labelMeta.nonNullAttrs) || [];
      var defaultAttrName = labelMeta && labelMeta.defaultAttrName;

      var prefMap = Page.crudAssociationLabelPreference || (Page.crudAssociationLabelPreference = {});
      var currentPref = prefMap[targetClass] || null;

      // If the stored preference refers to an attribute that no longer has
      // any data (e.g., column cleared), drop it so we can pick a better
      // default going forward.
      if (currentPref && currentPref !== "__index__" && nonNullAttrs.indexOf(currentPref) === -1) {
        currentPref = null;
        delete prefMap[targetClass];
      }

      var effectivePref = currentPref;
      if (!effectivePref) {
        if (defaultAttrName) {
          effectivePref = defaultAttrName;
        } else {
          effectivePref = "__index__";
        }
      }
      prefMap[targetClass] = effectivePref;

      // Small dropdown to let the user choose the labelling basis.
      html += "<div class='crud-assoc-label-selector'>";
      html += "<span class='crud-assoc-label-selector-text'>Label" + " options: </span>";
      html += "<select class='crud-assoc-label-select' data-target-class='" + targetClass + "'>";

      var indexSelected = (effectivePref === "__index__");
      html += "<option value='__index__'" + (indexSelected ? " selected='selected'" : "") + ">" + targetClass + "[instanceNumber]</option>";

      nonNullAttrs.forEach(function(attrName) {
        var selected = (effectivePref === attrName) ? " selected='selected'" : "";
        html += "<option value='" + attrName + "'" + selected + ">" + escapeHtml(attrName) + "</option>";
      });

      html += "</select></div>";

      html += "</div>"; // .crud-assoc-header

      // Use checkbox list whenever the target multiplicity allows more than
      // one associated instance (e.g., 2..4, 0..*, 1..*). Radio buttons are
      // reserved for strictly single-valued ends where max === 1.
      var multiple = true;
      if (typeof end.toMax === "number" && end.toMax <= 1) {
        multiple = false;
      }

      // Brief hint so users know when they can pick multiple options
      // for this association. For single-valued associations, we omit
      // the hint to avoid extra visual noise.
      var selectionHint = multiple ? "Multiple selection allowed." : "";
      if (selectionHint) {
        html += "<div class='crud-assoc-selection-hint'>" + selectionHint + "</div>";
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
        html += "<div class='crud-assoc-options crud-assoc-multi' data-field='" + fieldName + "'>";
        polyTargets.forEach(function(entry, idx) {
          var instObj = entry.instance;
          var runtimeClass = entry.className;
          var runtimeIndex = entry.index;
          var optionLabel = Page.buildCrudAssociationLabelForInstance(targetClass, instObj, idx, labelMeta, effectivePref, runtimeClass, runtimeIndex);
          var attrsForRuntime = (Page.crudData.classes[runtimeClass] && Page.crudData.classes[runtimeClass].attributes) || [];
          var tooltipEsc = buildAssocOptionTooltip(end, runtimeClass, optionLabel, instObj, attrsForRuntime);
          var refVal = Page.encodeCrudAssocRef({ className: runtimeClass, index: entry.index });
          html += "<label class='crud-assoc-option'>" +
            "<input type='checkbox' name='" + fieldName + "' value='" + refVal + "'>" +
            "<span class='crud-tooltip-target crud-assoc-option-label' data-target-class='" + targetClass + "' data-runtime-class='" + runtimeClass + "' data-runtime-index='" + entry.index + "' data-field='" + fieldName + "' data-crud-tooltip-html=\"" + tooltipEsc + "\">" + escapeHtml(optionLabel) + "</span>" +
            "</label>";
        });
        html += "</div>";
      } else {
        // Single-valued end: render radio buttons (with an explicit None
        // option when the multiplicity allows 0) instead of a dropdown.
        html += "<div class='crud-assoc-options crud-assoc-single' data-field='" + fieldName + "'>";
        if (minRequired === 0) {
          html += "<label class='crud-assoc-option crud-assoc-none-option'>" +
                   "<input type='radio' name='" + fieldName + "' value=''>" +
                   "<span class='crud-assoc-option-label'>None</span>" +
                   "</label>";
        }

        polyTargets.forEach(function(entry, idx) {
          var instObj = entry.instance;
          var runtimeClass = entry.className;
          var runtimeIndex = entry.index;
          var optionLabel = Page.buildCrudAssociationLabelForInstance(targetClass, instObj, idx, labelMeta, effectivePref, runtimeClass, runtimeIndex);
          var attrsForRuntime = (Page.crudData.classes[runtimeClass] && Page.crudData.classes[runtimeClass].attributes) || [];
          var tooltipEsc = buildAssocOptionTooltip(end, runtimeClass, optionLabel, instObj, attrsForRuntime);
          var refVal = Page.encodeCrudAssocRef({ className: runtimeClass, index: entry.index });
          html += "<label class='crud-assoc-option'>" +
            "<input type='radio' name='" + fieldName + "' value='" + refVal + "'>" +
            "<span class='crud-tooltip-target crud-assoc-option-label' data-target-class='" + targetClass + "' data-runtime-class='" + runtimeClass + "' data-runtime-index='" + entry.index + "' data-field='" + fieldName + "' data-crud-tooltip-html=\"" + tooltipEsc + "\">" + escapeHtml(optionLabel) + "</span>" +
            "</label>";
        });
        html += "</div>";
      }

      // If there are no target instances and multiplicity requires one, hint to create them first
      if (polyTargets.length < minRequired && minRequired > 0) {
        html += "<div class='crud-association-hint' style='margin-top:4px;color:#a00;'>" +
                "Not enough " + targetClass + " instances exist. Create more before adding " + className + ". " + "If this is a cyclic association, please proceed to click Save, the error messages will guide you."+
                "</div>";
      }

      html += "</div>";
    });
  }

  html += "<div class='crud-form-actions' style='margin-top:8px;'>";
  html += "<button type='button' id='crud-save-instance' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button primary' style='margin-right:8px;'>Save</button>";
  // Cancel button is initially hidden and is only shown when editing an
  // existing instance (instanceIndex is non-empty).
  html += "<button type='button' id='crud-cancel-edit-instance' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button' style='margin-right:8px;display:none;'>Cancel Edit</button>";
  html += "<button type='button' id='crud-clear-instances' class='jQuery-palette-button ui-button ui-corner-all ui-widget crud-form-button'>Clear all " + className + "</button>";
  html += "</div>";
  html += "</form>";
  html += "<div class='crud-related-instances' style='margin-top:8px;'></div>";
  html += "</div>";

  $panel.html(html);
  $panel.data("crudActiveClass", className);

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

  // Allow users to change how association options are labelled (by id,
  // name, other attributes or the default ClassName[index]) without
  // re-rendering the entire dialog.
  $panel.on("change", ".crud-assoc-label-select", function() {
    var $select = jQuery(this);
    var targetClass = $select.data("target-class");
    if (!targetClass) { return; }

    var newPref = $select.val() || "__index__";
    if (!Page.crudAssociationLabelPreference) {
      Page.crudAssociationLabelPreference = {};
    }
    Page.crudAssociationLabelPreference[targetClass] = newPref;

    var labelMeta = Page.getCrudAssociationLabelCandidatesForClass(targetClass);
    var nonNullAttrs = (labelMeta && labelMeta.nonNullAttrs) || [];
    var defaultAttrName = labelMeta && labelMeta.defaultAttrName;

    var effectivePref = newPref;
    if (effectivePref && effectivePref !== "__index__" && nonNullAttrs.indexOf(effectivePref) === -1) {
      // Chosen attribute no longer has any data; fall back to the class
      // default or to the index-based label.
      if (defaultAttrName && nonNullAttrs.indexOf(defaultAttrName) !== -1) {
        effectivePref = defaultAttrName;
      } else {
        effectivePref = "__index__";
      }
      Page.crudAssociationLabelPreference[targetClass] = effectivePref;
      $select.val(effectivePref);
    }

    var instancesForClass = Page.getCrudPolymorphicTargets
      ? Page.getCrudPolymorphicTargets(targetClass)
      : [];

    $panel.find(".crud-assoc-option-label[data-target-class='" + targetClass + "']").each(function(idx) {
      var $span = jQuery(this);
      if (idx < 0 || idx >= instancesForClass.length) {
        return;
      }
      var entry = instancesForClass[idx];
      var inst = entry.instance;
      var runtimeClass = entry.className;
      var runtimeIndex = entry.index;
      var newLabel = Page.buildCrudAssociationLabelForInstance(targetClass, inst, idx, labelMeta, effectivePref, runtimeClass, runtimeIndex);
      $span.text(newLabel);
    });
  });

  // Handle action dropdown selection for each instance row
  $panel.on("change", ".crud-instance-action", function() {
    var $select = jQuery(this);
    var action = $select.val();
    var index = $select.data("index");
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
      // Ensure only the currently edited row shows "Edit" in its
      // dropdown; reset all others back to the placeholder.
      $panel.find(".crud-instance-action").not($select).val("");
      $select.val("edit");
    } else {
      $select.val("");
    }
  });

  $panel.on("click", ".crud-edit-instance", function() {
    Page.currentCrudContainer = $panel.parent();

    var currentClassInfo = (Page.crudData && Page.crudData.classes && Page.crudData.classes[className]) ? Page.crudData.classes[className] : {};
    var attrsCurrent = currentClassInfo.attributes || attrs;
    var instancesCurrent = currentClassInfo.instances || [];

    var index = parseInt(jQuery(this).data("index"), 10);
    if (isNaN(index) || index < 0 || index >= instancesCurrent.length) {
      return;
    }
    var inst = instancesCurrent[index] || {};
    var $form = $panel.find("#crud-instance-form");
    $form.find("input[name='instanceIndex']").val(index);

    // Update the heading to reflect that we are editing a specific
    // instance, e.g., "Edit Person[1] Instance".
    var $heading = $panel.find(".crud-instance-form-heading");
    if ($heading.length) {
      $heading.text("Edit " + className + "[" + (index + 1) + "] Instance");
    }

    // When editing an existing instance, show the Cancel Edit button so
    // the user has an explicit way to abandon in-progress changes.
    var $cancelBtn = $panel.find("#crud-cancel-edit-instance");
    if ($cancelBtn.length) {
      $cancelBtn.show();
    }

    attrsCurrent.forEach(function(attr) {
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
        var refs = Page.normalizeCrudAssociationRefs(end, stored);
        if (refs.length > 0) {
          $checks.each(function() {
            var v = jQuery(this).val();
            var ref = Page.decodeCrudAssocRef(v, end.toClass);
            if (!ref) { return; }
            for (var i = 0; i < refs.length; i++) {
              var r = refs[i];
              if (r.className === ref.className && r.index === ref.index) {
                jQuery(this).prop("checked", true);
                break;
              }
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
          var refSingle = null;
          var refsSingle = Page.normalizeCrudAssociationRefs(end, stored);
          if (refsSingle.length > 0) {
            refSingle = refsSingle[0];
          }
          if (refSingle) {
            $radios.each(function() {
              var v = jQuery(this).val();
              if (v === "") { return; }
              var refOpt = Page.decodeCrudAssocRef(v, end.toClass);
              if (!refOpt) { return; }
              if (refOpt.className === refSingle.className && refOpt.index === refSingle.index) {
                jQuery(this).prop("checked", true);
              }
            });
          }
        }
      }
    });

    // Editing form is now fully populated programmatically; treat this
    // populated state as clean until the user changes something.
    if (typeof Page.markCrudFormClean === "function") {
      Page.markCrudFormClean($panel);
    }
  });

  // Delete existing instance
  $panel.on("click", ".crud-delete-instance", function() {
    Page.currentCrudContainer = $panel.parent();

    var currentClassInfo = (Page.crudData && Page.crudData.classes && Page.crudData.classes[className]) ? Page.crudData.classes[className] : {};
    var instancesCurrent = currentClassInfo.instances || [];

    var index = parseInt(jQuery(this).data("index"), 10);
    if (isNaN(index) || index < 0 || index >= instancesCurrent.length) {
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
    var wasVisible = $assocRow.length && $assocRow.is(":visible");
    var $assoc;

    if (wasVisible) {
      // Currently visible: hide the row, and we'll update the dropdown
      // label below to say 'Show Associations'.
      $assocRow.hide();
    } else {
      if (!$assocRow.length) {
        $assocRow = jQuery("<tr class='crud-instance-associations-row'><td colspan='" + colCount + "'><div class='crud-instance-associations' style='margin-top:4px;'></div></td></tr>");
        $row.after($assocRow);
      }
      $assoc = $assocRow.find(".crud-instance-associations");

      var assocHtml = "";
      var hasContent = false;

    // Forward associations: navigable ends from this class
    var seenAssocIdsForward = {};
    assocEnds.forEach(function(end) {
      var fieldName = end.storageKey;
      var val = inst[fieldName];
      var targetClass = end.toClass;
      var targetInfo = Page.crudData.classes[targetClass];
      var targetAttrs = (targetInfo && targetInfo.attributes) || [];

      if (val === undefined || val === null) {
        return;
      }

      // Avoid duplicate groups for self-reflexive associations where two
      // navigable ends correspond to the same logical relationship. When a
      // canonical end has been chosen for this storage field (e.g., the
      // single-valued mentor side of a mentor/mentee association), prefer
      // that end so that role names in the header match the form.
      if (end.fromClass === end.toClass) {
        var keyF = end.assocId || end.assocName || "";
        if (keyF) {
          if (seenAssocIdsForward[keyF]) { return; }

          if (assocEndByField && assocEndByField[fieldName] && assocEndByField[fieldName] !== end) {
            return;
          }

          seenAssocIdsForward[keyF] = true;
        }
      }

      // Use canonical polymorphic refs so that associations targeting
      // subclasses of the declared target type are also displayed.
      var refs = Page.normalizeCrudAssociationRefs
        ? Page.normalizeCrudAssociationRefs(end, val)
        : [];

      if (!refs.length) { return; }

      var items = [];
      refs.forEach(function(ref) {
        if (!ref || typeof ref.index !== "number" || ref.index < 0) { return; }
        var runtimeClass = ref.className || targetClass;
        var runtimeInfo = Page.crudData.classes[runtimeClass];
        if (!runtimeInfo || !Array.isArray(runtimeInfo.instances)) { return; }
        var runtimeInstances = runtimeInfo.instances;
        if (ref.index >= runtimeInstances.length) { return; }
        items.push({ inst: runtimeInstances[ref.index], idx: ref.index, className: runtimeClass });
      });

      if (!items.length) { return; }

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
        var label = (item.className || targetClass) + "[" + (item.idx + 1) + "]";
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
    var seenAssocIdsHierarchy = {};
    assocEnds.forEach(function(end) {
      if (!end.reflexiveHierarchy) { return; }
      if (end.fromClass !== end.toClass) { return; }

      var fieldName = end.storageKey;
      var classInfo = Page.crudData.classes[className];
      if (!classInfo) { return; }

      // When a reflexive association has two navigable ends that share the
      // same underlying storage (e.g., a mentor/mentee association on
      // Person), we only want to render a single hierarchical reverse
      // group. Use the association id as the key and, when available,
      // prefer the canonical end that is actually rendered in the form
      // (so labels and tooltips stay consistent with the UI).
      var assocKey = end.assocId || (end.assocName || "");
      if (assocKey) {
        if (seenAssocIdsHierarchy[assocKey]) {
          return;
        }
        // If this storage field is mapped to a specific end in the form,
        // and that end differs from the one we are currently visiting,
        // skip this visit so that the canonical end will own the
        // hierarchical view.
        if (assocEndByField && assocEndByField[fieldName] && assocEndByField[fieldName] !== end) {
          return;
        }
        seenAssocIdsHierarchy[assocKey] = true;
      }

      // For hierarchical self-reflexive associations that are declared on
      // a base class (e.g., Person mentor -- Person) but whose actual
      // instances may be subclasses (e.g., Student isA Person), search
      // across all subclasses of this class for links pointing back to
      // the current instance.
      var candidateChildren = Page.getCrudPolymorphicTargets
        ? Page.getCrudPolymorphicTargets(className)
        : [];

      if (!candidateChildren.length) { return; }

      var children = [];
      candidateChildren.forEach(function(entry) {
        if (!entry || !entry.instance) { return; }
        var otherInst = entry.instance;
        var otherIdx = entry.index;
        var otherClassName = entry.className;

        // Skip the current instance itself (same class and index).
        if (otherClassName === className && otherIdx === index) { return; }

        var linkVal = otherInst[fieldName];
        if (linkVal === undefined || linkVal === null) { return; }
        var refs = Page.normalizeCrudAssociationRefs
          ? Page.normalizeCrudAssociationRefs(end, linkVal)
          : [];
        if (!refs.length) { return; }
        for (var r = 0; r < refs.length; r++) {
          var ref = refs[r];
          if (!ref || ref.className !== className) { continue; }
          if (typeof ref.index === "number" && ref.index === index) {
            children.push({ inst: otherInst, idx: otherIdx, className: otherClassName });
            break;
          }
        }
      });

      if (!children.length) { return; }

      hasContent = true;
      var revHeader = className;
      // Only show a role name when it meaningfully differs from the
      // forward role. This avoids confusing labels like "mentor" being
      // reused for both mentor and mentee when only one role is named.
      if (end.oppositeRoleName && end.oppositeRoleName !== end.roleName) {
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
        var labelClass = child.className || className;
        var label = labelClass + "[" + (child.idx + 1) + "]";
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
      $assocRow.show();
    }

    // Update the dropdown option label to reflect the new state: when the
    // panel is visible, show 'Hide Associations'; otherwise 'Show Associations'.
    var nowVisible = $assocRow.length && $assocRow.is(":visible");
    var $select = $row.find(".crud-instance-action");
    if ($select.length) {
      var $opt = $select.find("option[value='associations']");
      if ($opt.length) {
        $opt.text(nowVisible ? "Hide Associations" : "Show Associations");
      }
    }
  });

  // When focus is inside a single-line field (text, number, etc.),
  // prevent the Enter key from submitting the form or navigating to
  // a new URL. Saving remains an explicit button click.
  $panel.on("keydown", "#crud-instance-form input[type='text'], #crud-instance-form input[type='number'], #crud-instance-form input[type='date'], #crud-instance-form input[type='time'], #crud-instance-form input[type='datetime-local'], #crud-instance-form input[type='email'], #crud-instance-form input[type='url'], #crud-instance-form input[type='search'], #crud-instance-form input[type='tel']", function(evt) {
    if (!evt) { return; }
    var key = evt.which || evt.keyCode;
    if (key === 13) { // Enter
      if (typeof evt.preventDefault === "function") {
        evt.preventDefault();
      }
      if (typeof evt.stopPropagation === "function") {
        evt.stopPropagation();
      }
      return false;
    }
  });

  // Save instance (new or edited)
  $panel.on("click", "#crud-save-instance", function() {
    Page.currentCrudContainer = $panel.parent();

    var currentClassInfo = (Page.crudData && Page.crudData.classes && Page.crudData.classes[className]) ? Page.crudData.classes[className] : {};
    var attrsCurrent = currentClassInfo.attributes || attrs;
    var instancesCurrent = currentClassInfo.instances || [];

    var $form = $panel.find("#crud-instance-form");
    var $error = $panel.find(".crud-error");
    $error.hide().text("");
    var errors = [];
    var indexVal = $form.find("input[name='instanceIndex']").val();
    var isEdit = indexVal !== "";
    var index = isEdit ? parseInt(indexVal, 10) : instancesCurrent.length;
    if (isEdit && (isNaN(index) || index < 0 || index >= instancesCurrent.length)) {
      index = instancesCurrent.length;
      isEdit = false;
    }

    var newInst = {};
    attrsCurrent.forEach(function(attr) {
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

    // Enforce that key attributes are always populated for this
    // instance before processing associations.
    var keyAttrsForClass = Array.isArray(currentClassInfo.keys) ? currentClassInfo.keys : [];
    var keyRequiredErrors = Page.validateCrudKeysForInstanceLocal(className, newInst, keyAttrsForClass);
    if (keyRequiredErrors.length > 0) {
      errors = errors.concat(keyRequiredErrors);
    }

    // Enforce that key attributes remain unique within this class
    // before processing associations or global validation.
    var keyDuplicateErrors = Page.validateCrudKeyUniquenessForClassLocal(className, index, isEdit, newInst);
    if (keyDuplicateErrors.length > 0) {
      errors = errors.concat(keyDuplicateErrors);
    }

    // Associations: enforce multiplicity rules and capture selected links
    var processedAssocFields = {};
    assocEnds.forEach(function(end) {
      var fieldName = end.storageKey;
      if (!fieldName) {
        return;
      }

      // For reflexive associations there may be two navigable ends
      // that share the same storageKey. Only process each storage
      // field once per save, and when a specific end was rendered in
      // the UI for this field (via assocEndByField), use that end so
      // multiplicity and labels match the controls.
      if (processedAssocFields[fieldName]) {
        return;
      }
      processedAssocFields[fieldName] = true;

      if (assocEndByField && assocEndByField[fieldName]) {
        end = assocEndByField[fieldName];
      }

      // If this association end does not have any visible controls in the
      // current form (for example, when we intentionally hide the reverse
      // side of a one-to-many), then preserve the existing stored value
      // when editing and skip any further processing. This avoids
      // accidentally clearing links for associations the user did not edit
      var $assocField = $form.find(".crud-assoc-multi[data-field='" + fieldName + "'], .crud-assoc-single[data-field='" + fieldName + "']");
      if ($assocField.length === 0) {
        if (isEdit && instancesCurrent[index] && Object.prototype.hasOwnProperty.call(instancesCurrent[index], fieldName)) {
          newInst[fieldName] = instancesCurrent[index][fieldName];
        }
        return;
      }

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
        var refs = [];
        selectedArray.forEach(function(v) {
          if (v === "") { return; }
          var ref = Page.decodeCrudAssocRef(v, end.toClass);
          if (!ref) { return; }
          refs.push(ref);
        });

        // Reflexive constraint: prevent self-reference in many-valued
        // self-associations (e.g., Territory borders itself).
        if (end.fromClass === end.toClass) {
          var filtered = [];
          refs.forEach(function(r) {
            if (r.className === className && r.index === index) {
              errors.push("An instance of " + className + " cannot be associated with itself for association " + end.assocName + ".");
            } else {
              filtered.push(r);
            }
          });
          refs = filtered;
        }

        newInst[fieldName] = refs;

        var count = refs.length;
        var relationLabel = end.cascadeDeleteTargets ? "composition" : "association";
        // Do not block save when mandatory associations are underfilled;
        // rely on global validation to surface multiplicity issues.
        if (maxAllowed !== null && count > maxAllowed) {
          errors.push("Please select at most " + maxAllowed + " " + end.toClass + " instance(s) for " + relationLabel + " " + end.assocName + ".");
        }
      } else {
        // Radio-based UI for single-valued ends
        var $radio = $form.find("input[type='radio'][name='" + fieldName + "']:checked");
        var val = $radio.length ? $radio.val() : "";
        if (!val || val === "") {
          // Leave mandatory-single associations empty locally; global
          // validation will report missing links.
          newInst[fieldName] = null;
        } else {
          var refSingle = Page.decodeCrudAssocRef(val, end.toClass);
          if (!refSingle || typeof refSingle.index !== "number" || refSingle.index < 0) {
            if (minRequired >= 1) {
              var relationLabelInvalid = end.cascadeDeleteTargets ? "composition" : "association";
              errors.push("Invalid selection for " + relationLabelInvalid + " " + end.assocName + ".");
            }
            newInst[fieldName] = null;
          } else {
            // Reflexive constraint: prevent self-reference.
            if (end.fromClass === end.toClass && refSingle.className === className && refSingle.index === index) {
              var relationLabelSelf = end.cascadeDeleteTargets ? "composition" : "association";
              errors.push("An instance of " + className + " cannot be associated with itself for " + relationLabelSelf + " " + end.assocName + ".");
              newInst[fieldName] = null;
            } else {
            newInst[fieldName] = refSingle;
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
    // parent-child cycle. Use a snapshot that includes the pending
    // change for this instance so newly introduced cycles are caught
    // locally before saving.
    var instancesForCycleCheck = instancesCurrent.slice();
    if (isEdit && index >= 0 && index < instancesForCycleCheck.length) {
      instancesForCycleCheck[index] = newInst;
    } else if (!isEdit && index === instancesForCycleCheck.length) {
      instancesForCycleCheck.push(newInst);
    }

    assocEnds.forEach(function(end) {
      if (end.fromClass !== end.toClass) { return; }
      var multiple = true;
      if (typeof end.toMax === "number" && end.toMax <= 1) {
        multiple = false;
      }
      if (multiple) { return; }
      var rawVal = newInst[end.storageKey];
      var refsForParent = Page.normalizeCrudAssociationRefs
        ? Page.normalizeCrudAssociationRefs(end, rawVal)
        : [];
      if (!refsForParent.length) { return; }
      var parentRef = refsForParent[0];
      if (!parentRef || parentRef.className !== className || typeof parentRef.index !== "number") {
        return;
      }
      Page.checkCrudReflexiveHierarchyCycle(className, instancesForCycleCheck, end, index, parentRef.index, errors);
    });

    // First, show any local validation errors for the currently edited
    // instance (attributes, key constraints, association choices,
    // reflexive cycles). Local errors block saving.
    if (errors.length > 0) {
      $error.text(errors.join(" ")).show();
      return;
    }

    // Next, validate the entire CRUD model (all classes and instances)
    // using a snapshot that includes this pending change. This allows
    // us to surface conflicts introduced by association updates or
    // global key constraints. Global errors are reported but do not
    // prevent saving; they are primarily summarized in the banner.
    var globalErrors = Page.validateCrudGlobalModel({
      className: className,
      index: index,
      isEdit: isEdit,
      newInst: newInst
    });
    if (globalErrors && globalErrors.length > 0) {
      $error.text(globalErrors.join(" ")).show();
    }

    // Keep reverse association ends consistent for bidirectional associations
    // using the newly computed link values on this instance.
    assocEnds.forEach(function(end) {
      var fieldName = end.storageKey;
      var newVal = newInst[fieldName];
      Page.syncCrudReverseAssociationsForEnd(className, index, end, newVal);
    });

    if (isEdit) {
      instancesCurrent[index] = newInst;
    } else {
      instancesCurrent.push(newInst);
    }

    if (Page.crudData && Page.crudData.classes && Page.crudData.classes[className]) {
      Page.crudData.classes[className].instances = instancesCurrent;
    }

    Page.updateCrudClassCount(className);
    // Re-render inline panel so the new/updated instance appears immediately
    Page.openCrudDialogForClass(className);

    // Refresh the global banner under the JSON / Instance Diagram
    // controls so that conflict messages reflect the latest instance
    // counts and links (e.g., after creating the first Witness).
    if (typeof Page.renderCrudGlobalErrors === "function") {
      Page.renderCrudGlobalErrors(null);
    }
  });

  // Clear all instances for this class
  $panel.on("click", "#crud-clear-instances", function() {
    Page.currentCrudContainer = $panel.parent();
    Page.crudData.classes[className].instances = [];
    Page.updateCrudClassCount(className);
    Page.openCrudDialogForClass(className);
  });

  // Cancel editing the current instance: clear the form fields, reset
  // edit state back to "add new" (no instanceIndex), hide the Cancel
  // button, and reset the per-instance action dropdown.
  $panel.on("click", "#crud-cancel-edit-instance", function() {
    var $form = $panel.find("#crud-instance-form");
    if (!$form.length) { return; }

    // Reset hidden index so Save will create a new instance instead of
    // overwriting an existing one.
    $form.find("input[name='instanceIndex']").val("");

    // Clear all attribute inputs within this form.
    $form.find("input[type='text'], input[type='number'], input[type='date'], input[type='time'], input[type='datetime-local'], input[type='email'], input[type='url'], input[type='search'], input[type='tel'], textarea").val("");
    $form.find("input[type='checkbox'], input[type='radio']").prop("checked", false);
    // Reset select elements that store instance attribute/association
    // values, but do NOT touch the small "Label for {Class} options"
    // dropdowns that control how association options are labelled
    // globally (those have class 'crud-assoc-label-select').
    $form.find("select").not(".crud-assoc-label-select").each(function() {
      var $sel = jQuery(this);
      // Prefer an explicit empty option if present; otherwise fall back
      // to the first option.
      if ($sel.find("option[value='']").length) {
        $sel.val("");
      } else {
        var firstVal = $sel.find("option").first().val();
        $sel.val(firstVal);
      }
    });

    // Clear any inline error messages for this form.
    $panel.find(".crud-error").hide().text("");

    // Hide the Cancel button now that we are no longer editing.
    jQuery(this).hide();

    // Reset any per-row action dropdowns back to the placeholder. Be
    // explicit about the selected option to avoid any stale UI state
    // in the browser.
    $panel.find(".crud-instance-action").each(function() {
      var $sel = jQuery(this);
      // Clear current selection and then force-select the placeholder
      // option (value="").
      $sel.find("option").prop("selected", false);
      $sel.val("");
      $sel.find("option[value='']").prop("selected", true);
      // Trigger change so any listeners that depend on the value being
      // cleared can react, but the handler will exit early since the
      // value is now empty.
      $sel.trigger("change");
    });

    // Cancel returns the form to a clean add-mode state.
    if (typeof Page.markCrudFormClean === "function") {
      Page.markCrudFormClean($panel);
    }
  });

  // Initial baseline for unsaved-change detection in the currently
  // rendered form.
  if (typeof Page.markCrudFormClean === "function") {
    Page.markCrudFormClean($panel);
  }

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

// Entry point used by Page.showGeneratedCode when language === "crudJson".
// Optional containerSelector allows rendering into an arbitrary container
// (e.g., Live View's htmlCanvas) instead of the default bottom panel.
Page.showCrudFromJson = function(jsonText, tabnumber, containerSelector) {
  var formHtml = "<div class='crud-ui-forms'>";
  try {
    var data = JSON.parse(jsonText);
    var classes = data.umpleClasses || [];
    var associations = data.umpleAssociations || [];
    var globalEnums = data.globalEnums || [];

    // Preserve any existing CRUD instance data so schema-only changes
    // (e.g., adding classes/attributes) do not wipe user-entered values.
    // We snapshot the current structure before resetting metadata and then
    // reuse instances for classes that still exist in the new model.
    var oldCrudData = (Page.crudData && Page.crudData.classes) ? Page.crudData : null;
    // Also snapshot the previous association metadata so that we can
    // detect simple class renames where attributes and associations are
    // unchanged between versions.
    var oldCrudAssociationsByClass = Page.crudAssociationsByClass || null;

    // Reset metadata containers (class defs, associations, enums, etc.).
    // Instance arrays for existing classes will be reattached below.
    Page.resetCrudData();
    // Builds a quick lookup for inheritance resolution and association navigation
    var crudMetaByClass = {};
    Page.crudExtendsByClass = {};
    classes.forEach(function(cls) {
      var className = cls.name || cls.id;
      if (!className) { return; }

      var methods = cls.methods || [];
      var hasMain = false;
      methods.forEach(function(m) {
        if (!m) { return; }
        // Treat any concrete method named "main" as an indicator that
        // this class is a main/root class for JSON export purposes.
        if (m.name === "main" && (m.isAbstract === false || m.isAbstract === "false" || typeof m.isAbstract === "undefined")) {
          hasMain = true;
        }
      });

      crudMetaByClass[className] = {
        name: className,
        rawAttributes: cls.attributes || [],
        extendsClass: cls.extendsClass || null,
        isAbstract: cls.isAbstract === true || cls.isAbstract === "true",
        hasMain: hasMain
      };
      Page.crudExtendsByClass[className] = cls.extendsClass || null;

      // Capture key attributes for this class, if present. The JSON
      // generator exposes keys as an array of attribute names.
      var keysRaw = Array.isArray(cls.keys) ? cls.keys : [];
      crudMetaByClass[className].keys = keysRaw.slice();

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

    // Resolve key attributes for each class, including those inherited
    // from ancestor classes in the extends hierarchy. This allows,
    // for example, a key defined on superclass A to be treated as a
    // key on subclass B that extends A in the CRUD UI.
    var resolvedKeys = {};
    var resolveCrudKeys = function(className, visited) {
      if (!className || !crudMetaByClass[className]) {
        return [];
      }
      if (resolvedKeys[className]) {
        return resolvedKeys[className];
      }

      visited = visited || {};
      if (visited[className]) {
        // Cycle guard: fall back to this class's own keys only.
        var ownOnly = Array.isArray(crudMetaByClass[className].keys)
          ? crudMetaByClass[className].keys.slice()
          : [];
        resolvedKeys[className] = ownOnly;
        return ownOnly;
      }
      visited[className] = true;

      var meta = crudMetaByClass[className];
      var result = [];
      var seen = {};

      // First, inherit keys from the parent class (if any).
      var parentName = meta.extendsClass;
      if (parentName && crudMetaByClass[parentName]) {
        var parentKeys = resolveCrudKeys(parentName, visited);
        parentKeys.forEach(function(k) {
          if (!k || seen[k]) { return; }
          seen[k] = true;
          result.push(k);
        });
      }

      // Then add this class's own key attributes, avoiding duplicates.
      var ownKeys = Array.isArray(meta.keys) ? meta.keys : [];
      ownKeys.forEach(function(k) {
        if (!k || seen[k]) { return; }
        seen[k] = true;
        result.push(k);
      });

      resolvedKeys[className] = result;
      return result;
    };

    Object.keys(crudMetaByClass).forEach(function(cn) {
      var meta = crudMetaByClass[cn];
      if (!meta) { return; }
      meta.keys = resolveCrudKeys(cn, {});
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

      // For self-reflexive associations, detect hierarchical or
      // directional patterns where one end is many and the other is
      // single (e.g., FunctionalArea child * <-> 0..1 parent, or
      // Person 0..1 mentor -- 0..* Person). These should not have
      // symmetric reverse links in the CRUD UI; the "many" side stores
      // a single link to the "one" side, while the "one" side derives
      // its linked instances by scanning those references.
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
            // From classOne to classTwo: the targets are seen using
            // the role defined on the classTwo end. Do not fall back
            // to the opposite role when one side is unnamed; this keeps
            // missing roles as empty strings instead of duplicating
            // names like "mentee" on both sides.
            roleName = assoc.roleTwo || "";
            oppositeRoleName = assoc.roleOne || "";
          } else if (direction === "two-to-one") {
            // From classTwo to classOne
            roleName = assoc.roleOne || "";
            oppositeRoleName = assoc.roleTwo || "";
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

      // Build a logical key for an association end that is stable across
      // inheritance and does not collapse distinct directions of the same
      // association (important for reflexive associations where both
      // parent->child and child->parent ends exist). We intentionally
      // avoid using storageKey here because it omits direction and would
      // cause one end to overwrite the other when both originate from the
      // same declaring class.
      var makeKey = function(end) {
        if (!end) { return ""; }
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

    // Detect simple class renames where an old class name disappears
    // and a new class appears with the same attributes and the same
    // associations to other classes. In such cases, we treat this as a
    // rename and carry existing instances over to the new class name.
    var classRenameNewToOld = {};
    if (oldCrudData && oldCrudData.classes) {
      var oldClassNames = Object.keys(oldCrudData.classes);
      var newClassNames = Object.keys(crudMetaByClass);
      var oldOnly = [];
      var newOnly = [];

      oldClassNames.forEach(function(name) {
        if (!crudMetaByClass[name]) {
          oldOnly.push(name);
        }
      });
      newClassNames.forEach(function(name) {
        if (!oldCrudData.classes[name]) {
          newOnly.push(name);
        }
      });

      if (oldOnly.length && newOnly.length) {
        var buildAttrSig = function(attrsList) {
          if (!Array.isArray(attrsList) || !attrsList.length) {
            return "";
          }
          var items = [];
          attrsList.forEach(function(a) {
            if (!a || !a.name) { return; }
            var t = a.type || "";
            items.push(a.name + ":" + t);
          });
          items.sort();
          return items.join(";");
        };

        var buildAssocSigForClass = function(className, assocByClass) {
          var ends = (assocByClass && assocByClass[className]) ? assocByClass[className] : [];
          if (!Array.isArray(ends) || !ends.length) {
            return "";
          }
          var simplified = [];
          ends.forEach(function(e) {
            if (!e) { return; }
            // Only consider navigable ends originating from this class.
            if (e.fromClass && e.fromClass !== className) { return; }
            var toClass = e.toClass || "";
            var min = (typeof e.toMin === "number") ? e.toMin : 0;
            var max = (typeof e.toMax === "number") ? e.toMax : null;
            var maxStr = (max === null || typeof max === "undefined") ? "*" : String(max);
            var bidir = e.isBidirectional ? "1" : "0";
            var comp = e.cascadeDeleteTargets ? "1" : "0";
            simplified.push(toClass + "|" + min + "|" + maxStr + "|" + bidir + "|" + comp);
          });
          if (!simplified.length) {
            return "";
          }
          simplified.sort();
          return simplified.join(";");
        };

        var usedOldNames = {};

        newOnly.forEach(function(newName) {
          var newInfoMeta = crudMetaByClass[newName];
          if (!newInfoMeta) { return; }
          var newAttrsResolved = resolveCrudAttributes(newName, {});
          var newAttrSig = buildAttrSig(newAttrsResolved);
          var newAssocSig = buildAssocSigForClass(newName, Page.crudAssociationsByClass);

          var candidates = [];
          oldOnly.forEach(function(oldName) {
            if (usedOldNames[oldName]) { return; }
            var oldInfo = oldCrudData.classes[oldName];
            if (!oldInfo) { return; }
            var oldAttrSig = buildAttrSig(oldInfo.attributes || []);
            if (oldAttrSig !== newAttrSig) { return; }

            var oldAssocSig = buildAssocSigForClass(oldName, oldCrudAssociationsByClass);
            if (oldAssocSig !== newAssocSig) { return; }

            candidates.push(oldName);
          });

          if (candidates.length === 1) {
            var chosenOld = candidates[0];
            usedOldNames[chosenOld] = true;
            classRenameNewToOld[newName] = chosenOld;

            var msgClass = "Info: Class '" + chosenOld + "' was renamed to '" + newName + "'. Existing instances were preserved because its attributes and associations did not change.";
            if (Array.isArray(Page.crudAdjustmentMessages)) {
              Page.crudAdjustmentMessages.push(msgClass);
            }
          }
        });
      }
    }

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

      // Reuse existing instances for this class if they exist; if this
      // is a newly added class, start with an empty instance list. When
      // a simple class rename has been detected (old name removed, new
      // name added, same attributes and associations), pull instances
      // from the old class name instead.
      var existingInfo = null;
      if (oldCrudData && oldCrudData.classes) {
        var sourceClassName = className;
        if (classRenameNewToOld && classRenameNewToOld[className]) {
          sourceClassName = classRenameNewToOld[className];
        }
        existingInfo = oldCrudData.classes[sourceClassName];
      }
      var existingInstances = (existingInfo && Array.isArray(existingInfo.instances)) ? existingInfo.instances : [];

      Page.crudData.classes[className] = {
        attributes: attrs,
        instances: existingInstances,
        isAbstract: isAbstract,
        // Mark whether this class declares a main() method so that the
        // CRUD JSON exporter can treat it as a root/main class.
        isMain: !!meta.hasMain,
        keys: Array.isArray(meta.keys) ? meta.keys.slice() : []
      };

      formHtml += "</form>";
    });
    // After reattaching any preserved instances, adjust association
    // storage fields for simple class renames so that existing links
    // continue to satisfy the updated association metadata.
    if (oldCrudAssociationsByClass && classRenameNewToOld && Object.keys(classRenameNewToOld).length) {
      if (typeof Page.adjustCrudAssociationsForClassRenames === "function") {
        Page.adjustCrudAssociationsForClassRenames(classRenameNewToOld, oldCrudAssociationsByClass);
      }
    }
    // Reconcile association-field keys when association role names change.
    // If an old end and a new end are structurally the same, preserve data
    // by moving values to the new storage key; otherwise remove stale values
    // and report what was cleared.
    if (oldCrudAssociationsByClass && typeof Page.adjustCrudAssociationsForRoleNameChanges === "function") {
      Page.adjustCrudAssociationsForRoleNameChanges(oldCrudAssociationsByClass);
    }
    // After reattaching any preserved instances, first handle simple
    // attribute renames (old attribute removed, new attribute added,
    // same data type) so that values are carried forward to the new
    // name. Then reconcile in-place type changes for attributes that
    // kept the same name.
    if (oldCrudData && oldCrudData.classes) {
      if (typeof Page.adjustCrudAttributesForRenames === "function") {
        Page.adjustCrudAttributesForRenames(oldCrudData);
      }
      if (typeof Page.adjustCrudAttributesForTypeChanges === "function") {
        Page.adjustCrudAttributesForTypeChanges(oldCrudData);
      }
    }
    // After reconciling attribute renames and type changes, remove any
    // enum values that reference literals no longer present in the
    // current model so that stale values do not linger in CRUD data.
    if (typeof Page.adjustCrudEnumValuesForRemovedOptions === "function") {
      Page.adjustCrudEnumValuesForRemovedOptions();
    }
    // After reattaching any preserved instances, first normalize
    // association fields for multi-valued ends so that they are always
    // arrays of numeric indices, and then trim any links that exceed new
    // maximum bounds when multiplicities have been tightened (e.g., from
    // * to 1). This keeps legacy links consistent with the updated model
    // while informing users about any automatic adjustments.
    if (typeof Page.normalizeCrudMultiValuedAssociations === "function") {
      Page.normalizeCrudMultiValuedAssociations();
    }
    if (typeof Page.adjustCrudAssociationsForTightenedMax === "function") {
      Page.adjustCrudAssociationsForTightenedMax();
    }
    formHtml += "</div>";
  }
  catch (e) {
    formHtml = "<pre>Failed to parse JSON for CRUD UI:\n" + e + "</pre>";
  }

  var targetSelector = containerSelector || ("#innerGeneratedCodeRow" + tabnumber);
  jQuery(targetSelector).html(formHtml);

  // Enhance forms with clickable class headers and popup dialog per class
  Page.initCrudUi(tabnumber, containerSelector);

  // After (re)rendering the CRUD UI for this model, keep the
  // previously expanded class dialog open when possible. If that
  // class no longer exists or is abstract, or if no class has been
  // selected yet, default to opening the first non-abstract class so
  // the user immediately sees a form instead of a collapsed panel.
  if (typeof Page.openCrudDialogForClass === "function" && Page.crudData && Page.crudData.classes) {
    var targetClassAuto = Page.crudClassSelected || null;
    if (!targetClassAuto || !Page.crudData.classes[targetClassAuto] || Page.crudData.classes[targetClassAuto].isAbstract) {
      targetClassAuto = null;
      Object.keys(Page.crudData.classes).some(function(cn) {
        var info = Page.crudData.classes[cn] || {};
        if (info.isAbstract) { return false; }
        targetClassAuto = cn;
        return true;
      });
    }
    if (targetClassAuto) {
      Page.crudClassSelected = targetClassAuto;
      Page.openCrudDialogForClass(targetClassAuto);
    }
  }

  // If instance-data JSON has been prepared via the backend, import it
  // now that the CRUD metadata and forms have been initialized.
  if (Page._pendingCrudInstanceJson && typeof Page.crudJsonImportFromText === "function") {
    try {
      Page.crudJsonImportFromText(Page._pendingCrudInstanceJson);

      // After import, automatically open a dialog for a class that
      // actually has instances, preferring the current selection if
      // it still exists and is concrete; otherwise fall back to the
      // first non-abstract class with instances.
      var targetClass = Page.crudClassSelected || null;
      if (Page.crudData && Page.crudData.classes) {
        if (!targetClass || !Page.crudData.classes[targetClass] || Page.crudData.classes[targetClass].isAbstract) {
          targetClass = null;
        }
        if (!targetClass) {
          Object.keys(Page.crudData.classes).some(function(cn) {
            var info = Page.crudData.classes[cn] || {};
            if (info.isAbstract) { return false; }
            var inst = info.instances || [];
            if (inst.length > 0) {
              targetClass = cn;
              return true;
            }
            return false;
          });
        }
      }
      if (targetClass && typeof Page.openCrudDialogForClass === "function") {
        Page.crudClassSelected = targetClass;
        Page.openCrudDialogForClass(targetClass);
      }
    } catch (e) {
      console.error("Failed to import CRUD instances from pending instance-diagram JSON:", e);
    } finally {
      Page._pendingCrudInstanceJson = null;
    }
  }
};