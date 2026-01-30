// In-memory storage for CRUD instances; no persistence or database
Page.crudData = { classes: {} };

// Lookup of class definitions (attributes) by class name for nested types
Page.crudClassDefs = {};

// Container used for inline CRUD panel rendering
Page.currentCrudContainer = null;

Page.resetCrudData = function() {
  Page.crudData = { classes: {} };
  Page.crudClassDefs = {};
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

// Build tooltip text to help user know what the data type is for a class attribute
Page.buildCrudTooltip = function(attrName, rawType, inheritedFrom) {
  var tooltip = attrName + ": " + (rawType || "");
  if (inheritedFrom) {
    tooltip += "\n. This is an inherited attribute from " + inheritedFrom + ".";
  }
  return tooltip;
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
      var tooltip = Page.buildCrudTooltip(subName, subAttr.type, subAttr.inheritedFrom);
      nestedHtml += "<div class='crud-nested-field'>";
      nestedHtml += "<label class='crud-nested-label'><span class='crud-tooltip-target' title='" + tooltip + "'>" + subName + "</span></label>";
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
    var tooltip = Page.buildCrudTooltip(subName, subAttr.type, subAttr.inheritedFrom);
    var fieldName = attrName + "." + subName;
    html += "<div class='crud-nested-field'>";
    html += "<label class='crud-nested-label'><span class='crud-tooltip-target' title='" + tooltip + "'>" + subName + "</span></label>";
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

  var $input = $form.find("input[name='" + attrName + "']");
  var raw = $input.val();
  var trimmed = jQuery.trim(raw);

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

  var classInfo = Page.crudData.classes[className];
  var attrs = classInfo.attributes || [];
  var instances = classInfo.instances || [];
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
    instances.forEach(function(inst, idx) {
      html += "<div class='crud-instance-row' data-index='" + idx + "' style='margin:4px 0;'>";
      html += "<span class='crud-instance-label'>" + className + "[" + (idx + 1) + "]</span>";

      var summary = [];
      attrs.forEach(function(attr) {
        var name = attr.name;
        if (!name) { return; }
        var val = inst[name];
        var typeInfo = Page.getCrudTypeInfo(attr.type);
        var classDef = Page.getAttributeType && Page.getAttributeType(attr.type);
        var displayVal = Page.formatCrudDisplayValue(val, typeInfo);
        if (displayVal !== "") {
          // Class-typed primitive attributes: wrap their key=value pairs in braces
          if (classDef && !typeInfo.isArray) {
            summary.push(name + "={" + displayVal + "}");
          } else {
            summary.push(name + "=" + displayVal);
          }
        }
      });
      if (summary.length > 0) {
        html += "<span class='crud-instance-summary' style='margin-left:8px;'> " + summary.join(", ") + "</span>";
      }

      html += "<button type='button' class='crud-edit-instance' data-index='" + idx + "' style='margin-left:8px;'>Edit</button>";
      html += "</div>";
    });
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
    var tooltip = Page.buildCrudTooltip(attrName, attr.type, attr.inheritedFrom);
    html += "<label class='crud-field-label'><span class='crud-tooltip-target' title='" + tooltip + "'>" + attrName + "</span></label>";
    html += Page.buildCrudInputHtml(attrName, typeInfo);

    html += "</div>";
  });

  html += "<div class='crud-form-actions' style='margin-top:8px;'>";
  html += "<button type='button' id='crud-save-instance' style='margin-right:8px;'>Save</button>";
  html += "<button type='button' id='crud-clear-instances'>Clear all " + className + "</button>";
  html += "</div>";
  html += "</form>";
  html += "</div>";

  $panel.html(html);

  // Remove previous handlers to avoid duplicates
  $panel.off();

  // Edit existing instance
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
        $form.find("input[name='" + attrName + "']").val(inputValue);
      }
    });
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

    if (errors.length > 0) {
      $error.text(errors.join(" ")).show();
      return;
    }

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

    // Resets in-memory CRUD data each time we (re)render CRUD UI
    Page.resetCrudData();
    // Builds a quick lookup for inheritance resolution
    var crudMetaByClass = {};
    classes.forEach(function(cls) {
      var className = cls.name || cls.id;
      if (!className) { return; }
      crudMetaByClass[className] = {
        name: className,
        rawAttributes: cls.attributes || [],
        extendsClass: cls.extendsClass || null,
        isAbstract: cls.isAbstract === true || cls.isAbstract === "true"
      };
    });

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
