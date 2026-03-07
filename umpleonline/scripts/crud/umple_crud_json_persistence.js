// JSON persistence helper for CRUD UI instances and associations

(function(global, jQuery) {
  "use strict";

  var Page = global.Page = global.Page || {};

  // Internal storage for generated IDs so associations can refer to objects
  Page._crudJsonIds = Page._crudJsonIds || {};
  Page._crudJsonIdCounter = Page._crudJsonIdCounter || 1;

  function getNamespaceFromModel() {
    if (typeof Page.getUmpleCode !== "function") {
      return "";
    }
    try {
      var code = Page.getUmpleCode() || "";
      var match = code.match(/\bnamespace\s+([A-Za-z_][A-Za-z0-9_]*)\s*;/);
      return match ? match[1] : "";
    } catch (e) {
      return "";
    }
  }

  function getQualifiedClassName(className, ns) {
    if (!className) { return className; }
    ns = (typeof ns === "string") ? ns : getNamespaceFromModel();
    return ns ? (ns + "." + className) : className;
  }

  function ensureUmpleId(className, index) {
    var key = className + "#" + index;
    if (!Page._crudJsonIds[key]) {
      Page._crudJsonIds[key] = String(Page._crudJsonIdCounter++);
    }
    return Page._crudJsonIds[key];
  }

  function getAssocPropertyName(end) {
    if (end && end.roleName) {
      return end.roleName;
    }
    var base = (end && end.toClass) ? String(end.toClass) : "";
    if (!base) { return ""; }
    var prop = base.charAt(0).toLowerCase() + base.slice(1);
    var multiple = true;
    if (typeof end.toMax === "number" && end.toMax <= 1) {
      multiple = false;
    }
    if (multiple) {
      // Very simple pluralization: append "s" if not already ending in s
      if (prop.charAt(prop.length - 1) !== "s") {
        prop += "s";
      }
    }
    return prop;
  }

  function makeAssociationRef(namespace, targetClass, targetIndex) {
    if (targetIndex === null || typeof targetIndex === "undefined") {
      return null;
    }
    var fqn = getQualifiedClassName(targetClass, namespace);
    var id = ensureUmpleId(targetClass, targetIndex);
    var inner = { umpleObjectID: id };
    var wrapper = {};
    wrapper[fqn] = inner;
    return wrapper;
  }

  // Recursively build a nested object (including composed children) for a
  // single instance. 
  function buildNestedInstance(ns, className, index, visited) {
    if (!Page.crudData || !Page.crudData.classes || !Page.crudData.classes[className]) {
      return null;
    }

    var info = Page.crudData.classes[className] || {};
    var attrs = info.attributes || [];
    var instances = info.instances || [];
    if (index < 0 || index >= instances.length) {
      return null;
    }

    visited = visited || {};
    var visitKey = className + "#" + index;
    if (visited[visitKey]) {
      // Cycle guard: fall back to an ID-only reference.
      return makeAssociationRef(ns, className, index);
    }

    // If this instance was already fully expanded earlier in this export
    // run (for another root tree), emit only an ID-based reference to avoid
    // repeating the same nested object multiple times in the final JSON.
    if (Page._crudJsonExported && Page._crudJsonExported[visitKey]) {
      return makeAssociationRef(ns, className, index);
    }

    visited[visitKey] = true;

    var inst = instances[index] || {};
    var data = {};
    data.umpleObjectID = ensureUmpleId(className, index);

    // Copy attribute values
    attrs.forEach(function(attr) {
      var name = attr && attr.name;
      if (!name) { return; }
      if (Object.prototype.hasOwnProperty.call(inst, name)) {
        data[name] = inst[name];
      }
    });

    var assocEnds = (Page.crudAssociationsByClass && Page.crudAssociationsByClass[className]) || [];

    assocEnds.forEach(function(end) {
      if (!end || end.fromClass !== className) { return; }
      var fieldName = end.storageKey;
      if (!fieldName) { return; }

      var propName = getAssocPropertyName(end);
      if (!propName) { return; }

      var val = inst[fieldName];
      var multiple = true;
      if (typeof end.toMax === "number" && end.toMax <= 1) {
        multiple = false;
      }

      if (multiple) {
        var arr = [];
        if (Array.isArray(val)) {
          val.forEach(function(targetIdx) {
            if (typeof targetIdx !== "number") {
              targetIdx = parseInt(targetIdx, 10);
            }
            if (isNaN(targetIdx) || targetIdx < 0) { return; }
            // Always expand forward links; the cycle guard above will turn
            // back-references into ID-only stubs.
            var child = buildNestedInstance(ns, end.toClass, targetIdx, visited);
            if (child) {
              arr.push(child);
            }
          });
        }
        data[propName] = arr;
      } else {
        if (val === undefined || val === null || val === "") {
          // Single-valued ends are omitted when there is no link.
          return;
        }
        var idxSingle = val;
        if (typeof idxSingle !== "number") {
          idxSingle = parseInt(idxSingle, 10);
        }
        if (isNaN(idxSingle) || idxSingle < 0) { return; }
        var linked = buildNestedInstance(ns, end.toClass, idxSingle, visited);
        if (linked) {
          data[propName] = linked;
        }
      }
    });

    var fqn = getQualifiedClassName(className, ns);
    var wrapper = {};
    wrapper[fqn] = data;

    // Mark this instance as fully exported so subsequent references from
    // other roots can collapse to ID-only stubs.
    if (!Page._crudJsonExported) {
      Page._crudJsonExported = {};
    }
    Page._crudJsonExported[visitKey] = true;

    return wrapper;
  }

  Page.crudJsonBuildExport = function() {
    if (!Page.crudData || !Page.crudData.classes) {
      return {};
    }

    var ns = getNamespaceFromModel();

    // Reset per-export tracking of which instances have been fully
    // materialized in the JSON so we can collapse repeats to ID-only stubs.
    Page._crudJsonExported = {};

    var objects = [];

    var composedClasses = {};
    if (Page.crudAssociationsByClass) {
      Object.keys(Page.crudAssociationsByClass).forEach(function(srcClass) {
        var ends = Page.crudAssociationsByClass[srcClass] || [];
        ends.forEach(function(end) {
          if (end && end.cascadeDeleteTargets && end.toClass) {
            composedClasses[end.toClass] = true;
          }
        });
      });
    }

    // Collect candidate root classes: non-composed classes that actually
    // have instances. These are the only reasonable roots.
    var rootCandidates = [];
    Object.keys(Page.crudData.classes).forEach(function(className) {
      if (composedClasses[className]) {
        return;
      }
      var info = Page.crudData.classes[className] || {};
      var instances = info.instances || [];
      if (!instances.length) { return; }
      rootCandidates.push(className);
    });

    // Prefer classes that are marked as main (have a main() method in the
    // Umple model) as roots. If none exist, fall back to all candidates.
    var mainRoots = [];
    rootCandidates.forEach(function(className) {
      var info = Page.crudData.classes[className] || {};
      if (info.isMain) {
        mainRoots.push(className);
      }
    });
    var rootClasses = mainRoots.length ? mainRoots : rootCandidates;

    rootClasses.forEach(function(className) {
      var info = Page.crudData.classes[className] || {};
      var instances = info.instances || [];
      instances.forEach(function(_, idx) {
        // Ensure IDs are stable
        ensureUmpleId(className, idx);
        var nested = buildNestedInstance(ns, className, idx, {});
        if (nested) {
          objects.push(nested);
        }
      });
    });

    if (objects.length === 1) {
      return objects[0];
    }

    // Otherwise, fall back to an array of roots.
    return objects;
  };

  // Trigger a JSON download of the current CRUD state
  Page.crudJsonDownload = function() {
    var payload = Page.crudJsonBuildExport();
    var jsonText = JSON.stringify(payload, null, 2);

    try {
      var blob = new Blob([jsonText], { type: "application/json" });
      var url = URL.createObjectURL(blob);
      var a = document.createElement("a");
      a.href = url;
      a.download = "umple-crud-data.json";
      document.body.appendChild(a);
      a.click();
      document.body.removeChild(a);
      URL.revokeObjectURL(url);
    } catch (e) {
      // Fallback: open in a new window/tab
      var w = window.open("", "_blank");
      if (w) {
        w.document.write("<pre>" + jsonText.replace(/</g, "&lt;") + "</pre>");
      }
    }
  };

  // Import a previously exported JSON payload and rebuild CRUD instances
  Page.crudJsonImport = function(payload) {
    if (!payload) { return; }
    var objects = [];

    if (Array.isArray(payload)) {
      objects = payload;
    } else if (Array.isArray(payload.objects)) {
      objects = payload.objects;
    } else {
      // Single object case: wrap it
      objects = [payload];
    }

    if (!Page.crudData || !Page.crudData.classes) {
      return;
    }

    var idMap = {}; // key: fqn#id -> { className, index, data }
    var instancesByClass = {};

    // Helper to recursively walk a wrapper (and its nested association
    // wrappers) so that composed children and other linked objects are also
    // allocated, not just the top-level roots.
    function collectEntitiesFromWrapper(wrapper) {
      if (!wrapper || typeof wrapper !== "object") { return; }
      var keys = Object.keys(wrapper);
      if (!keys.length) { return; }
      var fqn = keys[0];
      var data = wrapper[fqn] || {};
      if (!data || typeof data !== "object") { return; }
      var id = data.umpleObjectID;
      if (!id) { return; }

      var parts = fqn.split(".");
      var className = parts[parts.length - 1];
      if (!className || !Page.crudData.classes[className]) {
        return; // Unknown class in this model
      }

      var mapKey = fqn + "#" + id;
      var entry = idMap[mapKey];
      if (!entry) {
        if (!instancesByClass[className]) {
          instancesByClass[className] = [];
        }
        var index = instancesByClass[className].length;
        instancesByClass[className].push({});
        entry = {
          className: className,
          index: index,
          data: data
        };
        idMap[mapKey] = entry;
      } else {
        // Prefer the richest copy of the data we see (a fully expanded
        // object rather than an ID-only stub), based on number of keys.
        var existingData = entry.data || {};
        if (Object.keys(data).length > Object.keys(existingData).length) {
          entry.data = data;
        }
      }

      // Recurse into association-valued properties so that children and
      // other linked objects are discovered.
      var assocEnds = (Page.crudAssociationsByClass && Page.crudAssociationsByClass[className]) || [];
      assocEnds.forEach(function(end) {
        if (!end || end.fromClass !== className) { return; }
        var propName = getAssocPropertyName(end);
        if (!propName) { return; }
        var rawVal = data[propName];
        if (rawVal === undefined || rawVal === null || rawVal === "") {
          return;
        }

        var multiple = true;
        if (typeof end.toMax === "number" && end.toMax <= 1) {
          multiple = false;
        }

        if (multiple) {
          if (!Array.isArray(rawVal)) { return; }
          rawVal.forEach(function(childWrapper) {
            collectEntitiesFromWrapper(childWrapper);
          });
        } else {
          collectEntitiesFromWrapper(rawVal);
        }
      });
    }

    // First pass: walk all root objects and any nested association wrappers
    // so that we allocate slots for Airline, RegularFlight, SpecificFlight,
    // etc., not only the roots.
    objects.forEach(function(wrapper) {
      collectEntitiesFromWrapper(wrapper);
    });

    // Second pass: populate attributes and forward association indices
    Object.keys(instancesByClass).forEach(function(className) {
      var info = Page.crudData.classes[className] || {};
      var attrs = info.attributes || [];
      var assocEnds = (Page.crudAssociationsByClass && Page.crudAssociationsByClass[className]) || [];
      var arr = instancesByClass[className];

      arr.forEach(function(inst, localIndex) {
        // Locate corresponding payload
        var ns = payload && payload.namespace ? payload.namespace : getNamespaceFromModel();
        var fqn = getQualifiedClassName(className, ns);
        var keyPrefix = fqn + "#";
        var matchedEntry = null;
        Object.keys(idMap).some(function(k) {
          var entry = idMap[k];
          if (entry.className === className && entry.index === localIndex) {
            matchedEntry = entry;
            return true;
          }
          return false;
        });
        if (!matchedEntry) { return; }
        var data = matchedEntry.data || {};

        // Attributes
        attrs.forEach(function(attr) {
          var name = attr && attr.name;
          if (!name) { return; }
          if (Object.prototype.hasOwnProperty.call(data, name)) {
            inst[name] = data[name];
          }
        });

        // Associations (forward ends only; reverse ends will be synced later)
        assocEnds.forEach(function(end) {
          if (!end || end.fromClass !== className) { return; }
          var fieldName = end.storageKey;
          if (!fieldName) { return; }

          var propName = getAssocPropertyName(end);
          if (!propName) { return; }
          var rawVal = data[propName];
          if (rawVal === undefined || rawVal === null || rawVal === "") {
            return;
          }

          var multiple = true;
          if (typeof end.toMax === "number" && end.toMax <= 1) {
            multiple = false;
          }

          if (multiple) {
            if (!Array.isArray(rawVal)) { return; }
            var indices = [];
            rawVal.forEach(function(refWrapper) {
              if (!refWrapper || typeof refWrapper !== "object") { return; }
              var keys = Object.keys(refWrapper);
              if (!keys.length) { return; }
              var rfqn = keys[0];
              var inner = refWrapper[rfqn] || {};
              var rid = inner.umpleObjectID;
              if (!rid) { return; }
              var entry = idMap[rfqn + "#" + rid];
              if (!entry) { return; }
              indices.push(entry.index);
            });
            inst[fieldName] = indices;
          } else {
            if (!rawVal || typeof rawVal !== "object") { return; }
            var keysSingle = Object.keys(rawVal);
            if (!keysSingle.length) { return; }
            var sfqn = keysSingle[0];
            var sinner = rawVal[sfqn] || {};
            var sid = sinner.umpleObjectID;
            if (!sid) { return; }
            var sentry = idMap[sfqn + "#" + sid];
            if (!sentry) { return; }
            inst[fieldName] = sentry.index;
          }
        });
      });
    });

    // Apply rebuilt instances to Page.crudData
    Object.keys(Page.crudData.classes).forEach(function(className) {
      var arr = instancesByClass[className] || [];
      Page.crudData.classes[className].instances = arr;
      if (typeof Page.updateCrudClassCount === "function") {
        Page.updateCrudClassCount(className);
      }
    });

    // Sync reverse association ends to keep bidirectional links consistent
    if (Page.crudAssociationsByClass && typeof Page.syncCrudReverseAssociationsForEnd === "function") {
      Object.keys(Page.crudAssociationsByClass).forEach(function(className) {
        var assocEnds = Page.crudAssociationsByClass[className] || [];
        var info = Page.crudData.classes[className] || {};
        var instArr = info.instances || [];
        assocEnds.forEach(function(end) {
          if (!end || end.fromClass !== className) { return; }
          var fieldName = end.storageKey;
          instArr.forEach(function(inst, idx) {
            var newVal = inst[fieldName];
            Page.syncCrudReverseAssociationsForEnd(className, idx, end, newVal);
          });
        });
      });
    }
  };

  // Helper to import from a JSON string (used by UI layer)
  Page.crudJsonImportFromText = function(text) {
    if (!text) { return; }
    try {
      var payload = JSON.parse(text);
      Page.crudJsonImport(payload);
    } catch (e) {
      alert("Failed to parse JSON for CRUD import: " + e);
    }
  };

})(window, jQuery);
