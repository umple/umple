// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Restoring earlier versions of a model from the backups that the server makes
// while it is edited (see version_history.php), and noticing when another
// browser tab or window has saved a newer version of the model than the one
// shown in this tab, so that the user does not carry on editing an out-of-date
// copy (issue 1923).

VersionHistory = new Object();

VersionHistory.endpoint = "scripts/version_control.php";
VersionHistory.messageKey = "umpleVersionHistoryMessage";
VersionHistory.checkRetryDelay = 500;
VersionHistory.maxCheckRetries = 40;
VersionHistory.collabSyncTimeout = 5000;

VersionHistory.enabled = false;
// The latest version of the model on the server that this tab is known to show
VersionHistory.knownVersion = 0;
// Counts responses reporting a new version, so that a check for a newer version
// that is overtaken by one of this tab's own saves can be ignored
VersionHistory.changeCount = 0;
VersionHistory.checkInProgress = false;
VersionHistory.checkTimer = null;
VersionHistory.checkRetries = 0;
// Set once the page is about to be reloaded, after which nothing more is saved
VersionHistory.navigatingAway = false;
// The id of the backup of the version that this tab's change replaced, while
// the prompt about it is shown
VersionHistory.replacedBackupId = null;
VersionHistory.backups = [];
VersionHistory.selectedBackup = null;
VersionHistory.selectedFiles = null;
VersionHistory.busy = false;

// Called from Page.init, before the tabs are loaded. The dialogs come later in
// the page than the call, so their buttons use delegated event handlers.
VersionHistory.init = function(readOnly)
{
  var versionField = document.getElementById("modelVersion");
  if (readOnly || versionField == null || !Page.getModel()) return;
  VersionHistory.enabled = true;
  VersionHistory.knownVersion = parseInt(versionField.value, 10) || 0;

  document.addEventListener("visibilitychange", function() {
    if (document.visibilityState === "visible") VersionHistory.checkForNewerVersion();
  });
  window.addEventListener("focus", function() {
    VersionHistory.checkForNewerVersion();
  });

  VersionHistory.bindButton("buttonLoadLatestVersion", VersionHistory.useOtherVersion);
  VersionHistory.bindButton("buttonKeepThisVersion", VersionHistory.keepThisVersion);
  VersionHistory.bindButton("buttonRestoreSelectedVersion", VersionHistory.restoreSelectedVersion);
  VersionHistory.bindButton("buttonCloseVersionHistory", VersionHistory.closeRestoreDialog);
  jQuery(document).on("click", "#versionHistoryModal .dialog-overlay", VersionHistory.closeRestoreDialog);
  jQuery(document).on("click", "#versionHistoryList .version-history-item", function() {
    VersionHistory.selectBackup(jQuery(this).attr("data-id"));
  });
  jQuery(document).on("keydown", "#versionHistoryList .version-history-item", VersionHistory.listKeyDown);
  jQuery(document).on("keydown", function(event) {
    if (event.key === "Escape" && VersionHistory.isOpen("versionHistoryModal")) {
      VersionHistory.closeRestoreDialog();
    }
  });

  VersionHistory.showStoredMessage();
}

VersionHistory.bindButton = function(id, action)
{
  var run = function(button) {
    if (!jQuery(button).hasClass("disabled")) action();
  };
  jQuery(document).on("click", "#" + id, function() { run(this); });
  jQuery(document).on("keydown", "#" + id, function(event) {
    if (event.key === "Enter" || event.key === " ") {
      event.preventDefault();
      run(this);
    }
  });
}

VersionHistory.isOpen = function(modalId)
{
  var modal = document.getElementById(modalId);
  return modal != null && !modal.classList.contains("is-hidden");
}

// Page.readOnly is also set while the diagram is out of date (as when the text
// has an error), so what matters is whether the text can be edited
VersionHistory.isTextEditable = function()
{
  var editor = Page.codeMirrorEditor6;
  if (typeof cm6 === "undefined" || !cm6.EditorView || !editor) return true;
  return editor.state.facet(cm6.EditorView.editable);
}

VersionHistory.isCollaborating = function()
{
  return typeof Collab !== "undefined" && typeof Collab.isConnected === "function"
    && Collab.isConnected();
}

// Sends a request to version_control.php; onSuccess receives the parsed JSON
VersionHistory.request = function(parameters, isPost, onSuccess, onFailure)
{
  var query = parameters + "&model=" + encodeURIComponent(Page.getModel());
  var url = VersionHistory.endpoint;
  var options = {cache: "no-store", credentials: "same-origin"};
  if (isPost) {
    options.method = "POST";
    options.headers = {"Content-Type": "application/x-www-form-urlencoded"};
    options.body = query;
  } else {
    url += "?" + query;
  }
  fetch(url, options).then(function(response) {
    if (!response.ok) throw new Error("HTTP status " + response.status);
    return response.json();
  }).then(function(result) {
    onSuccess(result);
  }, function(error) {
    if (onFailure) onFailure(error);
  });
}

// --------------------------------------------------------------------------
// Keeping track of the version this tab shows

// Returns the parameter that tells the server which version this tab's
// change is based on, so it can back up a newer version before overwriting it
VersionHistory.baseVersionParameter = function()
{
  return VersionHistory.enabled ? "&&baseVersion=" + VersionHistory.knownVersion : "";
}

// Called with the response to each request that may have changed the model
VersionHistory.noteResponse = function(response)
{
  if (!response || typeof response.getResponseHeader !== "function") return;
  var version = parseInt(response.getResponseHeader("X-Umple-Version"), 10);
  if (isNaN(version)) return;
  var changed = response.getResponseHeader("X-Umple-Version-Changed") === "1";
  if (changed) VersionHistory.changeCount++;
  // Collaborators all see the same text, so their saves never leave a tab behind
  if (changed || VersionHistory.isCollaborating()) VersionHistory.knownVersion = version;

  // The server backed up a newer version before this tab's change replaced it,
  // as when this tab saves before noticing that another tab changed the model
  var replacedId = response.getResponseHeader("X-Umple-Version-Replaced");
  if (changed && replacedId && VersionHistory.enabled && !VersionHistory.navigatingAway
    && !VersionHistory.isCollaborating()) {
    VersionHistory.showReplacedPrompt(replacedId);
  }
}

// Called when this tab becomes visible or gains focus
VersionHistory.checkForNewerVersion = function(isRetry)
{
  if (!isRetry) VersionHistory.checkRetries = 0;
  if (!VersionHistory.enabled || VersionHistory.navigatingAway
    || document.visibilityState === "hidden" || VersionHistory.isCollaborating()
    || VersionHistory.isOpen("versionHistoryModal")) {
    return;
  }
  // This tab's own saves must finish first, or they would look like another tab's
  if (VersionHistory.checkInProgress || TabControl.requestQueue.length > 0) {
    VersionHistory.retryCheck();
    return;
  }
  VersionHistory.checkInProgress = true;
  var changeCountAtStart = VersionHistory.changeCount;
  VersionHistory.request("status=1", false, function(status) {
    VersionHistory.checkInProgress = false;
    if (VersionHistory.changeCount !== changeCountAtStart || TabControl.requestQueue.length > 0) {
      VersionHistory.retryCheck();
    } else if (status.version > VersionHistory.knownVersion) {
      VersionHistory.showNewerVersionPrompt(status);
    }
  }, function() {
    VersionHistory.checkInProgress = false;
  });
}

VersionHistory.retryCheck = function()
{
  if (VersionHistory.checkTimer != null) return;
  if (VersionHistory.checkRetries++ >= VersionHistory.maxCheckRetries) return;
  VersionHistory.checkTimer = setTimeout(function() {
    VersionHistory.checkTimer = null;
    VersionHistory.checkForNewerVersion(true);
  }, VersionHistory.checkRetryDelay);
}

VersionHistory.showNewerVersionPrompt = function(status)
{
  VersionHistory.replacedBackupId = null;
  var when = status.savedAt ? " at " + VersionHistory.formatTime(status.savedAt) : "";
  VersionHistory.showConflictPrompt("A newer version of this model exists",
    "This model was changed in another browser tab or window" + when
    + ", so what this tab shows is out of date. Load the latest version to"
    + " carry on from there. If you keep this tab's version instead, the newer"
    + " version will be saved so that you can get it back later using Restore"
    + " Earlier Version in the SAVE & LOAD menu.",
    "Load latest version");
}

VersionHistory.showReplacedPrompt = function(backupId)
{
  VersionHistory.replacedBackupId = backupId;
  VersionHistory.showConflictPrompt("This tab saved over newer changes",
    "While this tab was showing an out-of-date version of this model, the model"
    + " was changed in another browser tab or window, and this tab has just saved"
    + " over those changes. They were saved first, so you can switch to them now,"
    + " or later using Restore Earlier Version in the SAVE & LOAD menu.",
    "Use the other tab's version");
}

// If the prompt is already open, it is updated to describe the latest conflict
VersionHistory.showConflictPrompt = function(title, message, useOtherLabel)
{
  var alreadyOpen = VersionHistory.isOpen("versionConflictModal");
  jQuery("#versionConflictTitle").text(title);
  jQuery("#versionConflictMessage").text(message);
  jQuery("#buttonLoadLatestVersion").text(useOtherLabel);
  if (alreadyOpen) return;
  jQuery("#versionConflictModal").removeClass("is-hidden");
  jQuery("#buttonLoadLatestVersion").focus();
}

VersionHistory.useOtherVersion = function()
{
  jQuery("#versionConflictModal").addClass("is-hidden");
  var replacedId = VersionHistory.replacedBackupId;
  VersionHistory.replacedBackupId = null;
  if (replacedId) {
    VersionHistory.restoreById(replacedId);
  } else {
    VersionHistory.reloadModel();
  }
}

VersionHistory.keepThisVersion = function()
{
  jQuery("#versionConflictModal").addClass("is-hidden");
  if (VersionHistory.replacedBackupId) {
    VersionHistory.replacedBackupId = null;
    Page.setFeedbackMessage("Keeping this tab's version. The other tab's version can be"
      + " restored using Restore Earlier Version.");
    return;
  }
  // If this fails, the server still backs up the newer version before this
  // tab's next change overwrites it, because the change is based on an older one
  VersionHistory.request("backup=1&staleVersion=" + VersionHistory.knownVersion, true,
    function(result) {
      VersionHistory.knownVersion = Math.max(VersionHistory.knownVersion, result.version);
      Page.setFeedbackMessage("Keeping this tab's version. The newer version has been saved"
        + " and can be restored using Restore Earlier Version.");
    });
}

// Loads the model again from the server, using a URL that names it, since the
// current URL may be one that creates a new model, such as an example's URL
VersionHistory.reloadModel = function()
{
  VersionHistory.navigatingAway = true;
  var url = new URL(window.location.href);
  ["example", "text", "filename"].forEach(function(name) {
    url.searchParams.delete(name);
  });
  url.searchParams.set("model", Page.getModel());
  if (url.href === window.location.href) window.location.reload();
  else window.location.href = url.href;
}

// --------------------------------------------------------------------------
// Restore Earlier Version dialog

VersionHistory.openRestoreDialog = function()
{
  if (!VersionHistory.enabled) return;
  if (!VersionHistory.isTextEditable()) {
    Page.setFeedbackMessage("Earlier versions cannot be restored while the model is read-only.");
    return;
  }
  VersionHistory.backups = [];
  VersionHistory.selectedBackup = null;
  VersionHistory.selectedFiles = null;
  VersionHistory.busy = false;
  jQuery("#versionHistoryList").empty();
  jQuery("#versionHistoryPreview").empty();
  VersionHistory.setRestoreEnabled(false);
  VersionHistory.setStatus("Loading saved versions\u2026");
  jQuery("#versionHistoryModal").removeClass("is-hidden");
  jQuery("#buttonCloseVersionHistory").focus();

  VersionHistory.request("list=1", false, function(result) {
    VersionHistory.backups = result.backups || [];
    VersionHistory.renderBackupList();
  }, function() {
    VersionHistory.setStatus("The saved versions could not be loaded. Please try again later.");
  });
}

VersionHistory.closeRestoreDialog = function()
{
  if (!VersionHistory.isOpen("versionHistoryModal")) return;
  jQuery("#versionHistoryModal").addClass("is-hidden");
  jQuery("#buttonRestoreEarlierVersion").focus();
}

VersionHistory.setStatus = function(message)
{
  jQuery("#versionHistoryStatus").text(message);
}

VersionHistory.setRestoreEnabled = function(enabled)
{
  jQuery("#buttonRestoreSelectedVersion").toggleClass("disabled", !enabled)
    .attr("aria-disabled", enabled ? "false" : "true");
}

VersionHistory.renderBackupList = function()
{
  var list = jQuery("#versionHistoryList").empty();
  if (VersionHistory.backups.length == 0) {
    VersionHistory.setStatus("No earlier versions have been saved yet. A version is saved"
      + " automatically once you have made at least 5 changes over at least 2 minutes.");
    return;
  }
  VersionHistory.setStatus("Select a version to see what it contained.");
  VersionHistory.backups.forEach(function(backup) {
    var item = jQuery('<li class="version-history-item" role="option" tabindex="0" aria-selected="false"></li>');
    item.attr("data-id", backup.id);
    item.append(jQuery('<span class="version-history-time"></span>').text(VersionHistory.formatTime(backup.savedAt)));
    item.append(jQuery('<span class="version-history-age"></span>').text(VersionHistory.formatAge(backup.savedAt)));
    item.append(jQuery('<span class="version-history-detail"></span>').text(VersionHistory.describeBackup(backup)));
    var reason = VersionHistory.describeReason(backup);
    if (reason) item.append(jQuery('<span class="version-history-reason"></span>').text(reason));
    list.append(item);
  });
}

VersionHistory.listKeyDown = function(event)
{
  var item = jQuery(this);
  if (event.key === "Enter" || event.key === " ") {
    event.preventDefault();
    VersionHistory.selectBackup(item.attr("data-id"));
  } else if (event.key === "ArrowDown" || event.key === "ArrowUp") {
    event.preventDefault();
    var next = event.key === "ArrowDown" ? item.next() : item.prev();
    if (next.length) {
      next.focus();
      VersionHistory.selectBackup(next.attr("data-id"));
    }
  }
}

VersionHistory.findBackup = function(id)
{
  for (var i = 0; i < VersionHistory.backups.length; i++) {
    if (VersionHistory.backups[i].id === id) return VersionHistory.backups[i];
  }
  return null;
}

VersionHistory.selectBackup = function(id)
{
  var backup = VersionHistory.findBackup(id);
  if (backup == null || VersionHistory.busy) return;
  VersionHistory.selectedBackup = backup;
  VersionHistory.selectedFiles = null;
  jQuery("#versionHistoryList .version-history-item").each(function() {
    var selected = jQuery(this).attr("data-id") === id;
    jQuery(this).toggleClass("selected", selected).attr("aria-selected", selected ? "true" : "false");
  });
  VersionHistory.setRestoreEnabled(false);
  jQuery("#versionHistoryPreview").empty().append(
    jQuery('<div class="version-history-info"></div>').text("Loading\u2026"));

  VersionHistory.request("files=1&id=" + encodeURIComponent(id), false, function(result) {
    if (VersionHistory.selectedBackup !== backup) return;
    VersionHistory.selectedFiles = result.files;
    VersionHistory.renderPreview(result.files);
    VersionHistory.setRestoreEnabled(true);
    VersionHistory.setStatus(VersionHistory.restoresInEditor(result.files)
      ? "Restoring replaces the text in the editor. You can use Undo to go back."
      : "Restoring replaces all of the model's files and reloads the page. Your current"
        + " work is saved as a version first, so you can return to it.");
  }, function() {
    if (VersionHistory.selectedBackup !== backup) return;
    jQuery("#versionHistoryPreview").empty().append(
      jQuery('<div class="version-history-info"></div>').text("This version could not be loaded."));
  });
}

VersionHistory.renderPreview = function(files)
{
  var preview = jQuery("#versionHistoryPreview").empty();
  files.forEach(function(file) {
    var modelText = Page.splitUmpleCode(file.content)[0];
    var block = jQuery('<div class="version-history-file"></div>');
    if (files.length > 1 || file.name !== "model.ump") {
      block.append(jQuery('<div class="version-history-filename"></div>').text(file.name));
    }
    block.append(jQuery('<pre class="version-history-code"></pre>')
      .text(modelText.trim() === "" ? "(empty)" : modelText));
    preview.append(block);
  });
}

VersionHistory.describeBackup = function(backup)
{
  var files = backup.files || [];
  var description = "Version " + backup.version;
  if (files.length > 3) description += " \u00b7 " + files.length + " files";
  else if (files.length > 1 || (files.length == 1 && files[0] !== "model.ump")) {
    description += " \u00b7 " + files.join(", ");
  }
  return description;
}

VersionHistory.describeReason = function(backup)
{
  switch (backup.reason) {
    case "initial":
      return "The earliest saved version";
    case "beforeRestore":
      return backup.restoredVersion != null
        ? "Your work just before version " + backup.restoredVersion + " was restored"
        : "Your work just before an earlier version was restored";
    case "conflict":
      return "Saved before a browser tab showing an older version replaced it";
    case "beforeDelete":
      return backup.deletedFile
        ? "Just before " + backup.deletedFile + " was deleted"
        : "Just before a file was deleted";
    default:
      return "";
  }
}

VersionHistory.formatTime = function(seconds)
{
  var date = new Date(seconds * 1000);
  try {
    return date.toLocaleString(undefined, {dateStyle: "medium", timeStyle: "short"});
  } catch (e) {
    return date.toLocaleString();
  }
}

VersionHistory.formatAge = function(seconds)
{
  var age = Math.max(0, Math.round(Date.now() / 1000 - seconds));
  var units = [[86400, "day"], [3600, "hour"], [60, "minute"]];
  for (var i = 0; i < units.length; i++) {
    if (age >= units[i][0]) {
      var count = Math.floor(age / units[i][0]);
      return count + " " + units[i][1] + (count == 1 ? "" : "s") + " ago";
    }
  }
  return "just now";
}

// --------------------------------------------------------------------------
// Restoring

VersionHistory.restoreSelectedVersion = function()
{
  if (VersionHistory.selectedBackup == null || VersionHistory.selectedFiles == null) return;
  VersionHistory.restore(VersionHistory.selectedBackup, VersionHistory.selectedFiles);
}

// Restores a backup given only its id, as when undoing a restore
VersionHistory.restoreById = function(id)
{
  VersionHistory.request("files=1&id=" + encodeURIComponent(id), false, function(result) {
    VersionHistory.restore(result.backup, result.files);
  }, function() {
    Page.setFeedbackMessage("That version could not be loaded.");
  });
}

// A model with a single tab is restored through the editor, so that Undo goes
// back to what was there before and collaborators see the change
VersionHistory.restoresInEditor = function(files)
{
  return files.length == 1 && TabControl.activeTab != null
    && Object.keys(TabControl.tabs).length == 1;
}

VersionHistory.restore = function(backup, files)
{
  if (VersionHistory.busy) return;
  if (!VersionHistory.isTextEditable()) {
    Page.setFeedbackMessage("Earlier versions cannot be restored while the model is read-only.");
    return;
  }
  VersionHistory.busy = true;
  VersionHistory.setRestoreEnabled(false);
  VersionHistory.setStatus("Restoring version " + backup.version + "\u2026");
  var onFailure = function() {
    VersionHistory.busy = false;
    VersionHistory.setRestoreEnabled(VersionHistory.selectedFiles != null);
    VersionHistory.setStatus("The version could not be restored. Please try again later.");
    Page.setFeedbackMessage("Version " + backup.version + " could not be restored.");
  };
  if (VersionHistory.restoresInEditor(files)) {
    VersionHistory.restoreInEditor(backup, files[0].content, onFailure);
  } else {
    VersionHistory.restoreOnServer(backup, onFailure);
  }
}

VersionHistory.restoreInEditor = function(backup, content, onFailure)
{
  var codeBefore = Page.getUmpleCode();
  // Make sure the server has what is being replaced before it is backed up
  TabControl.useActiveTabTo(TabControl.saveTab)(codeBefore);
  TabControl.addCallbackToRequestQueue(function() {
    VersionHistory.request("backup=1&restoring=" + encodeURIComponent(backup.id), true, function(result) {
      VersionHistory.busy = false;
      var history = TabControl.getCurrentHistory();
      history.save(codeBefore, "beforeRestoreVersion");
      Page.setUmpleCode(content);
      var codeAfter = Page.getUmpleCode();
      history.save(codeAfter, "restoreVersion");
      history.setButtons();
      // Saved directly since typing does not save when the diagram is synchronized manually
      TabControl.useActiveTabTo(TabControl.saveTab)(codeAfter);
      VersionHistory.closeRestoreDialog();
      VersionHistory.showRestoredMessage({
        restoredVersion: backup.version,
        savedId: result.backup ? result.backup.id : null,
        savedVersion: result.backup ? result.backup.version : null
      });
    }, onFailure);
  });
}

VersionHistory.restoreOnServer = function(backup, onFailure)
{
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.addCallbackToRequestQueue(function() {
    VersionHistory.request("restore=1&id=" + encodeURIComponent(backup.id), true, function(result) {
      VersionHistory.navigatingAway = true;
      VersionHistory.storeMessage({
        restoredVersion: result.restoredVersion,
        savedId: result.savedId,
        savedVersion: result.savedVersion
      });
      VersionHistory.shareWithCollaborators(result.shownContent, VersionHistory.reloadModel);
    }, onFailure);
  });
}

// Collaborators share the editor's text through the collaboration server, which
// would otherwise put the old text back when the reloaded page reconnects
VersionHistory.shareWithCollaborators = function(shownContent, then)
{
  if (!VersionHistory.isCollaborating() || typeof cm6 === "undefined" || !cm6.sendableUpdates) {
    then();
    return;
  }
  Page.setCodeMirror6Text(Page.splitUmpleCode(shownContent)[0], true);
  var waited = 0;
  var waitForSync = function() {
    if (cm6.sendableUpdates(Page.codeMirrorEditor6.state).length > 0
      && waited < VersionHistory.collabSyncTimeout) {
      waited += 100;
      setTimeout(waitForSync, 100);
    } else {
      then();
    }
  };
  setTimeout(waitForSync, 100);
}

// The message about a restore survives the reload that follows restoring a
// model with several tabs
VersionHistory.storeMessage = function(details)
{
  details.model = Page.getModel();
  try {
    sessionStorage.setItem(VersionHistory.messageKey, JSON.stringify(details));
  } catch (e) {
    // Storage unavailable; the restore still happened
  }
}

VersionHistory.showStoredMessage = function()
{
  var details = null;
  try {
    details = JSON.parse(sessionStorage.getItem(VersionHistory.messageKey));
    sessionStorage.removeItem(VersionHistory.messageKey);
  } catch (e) {
    return;
  }
  if (details && details.model === Page.getModel()) VersionHistory.showRestoredMessage(details);
}

VersionHistory.showRestoredMessage = function(details)
{
  var message = jQuery("#versionHistoryMessage").empty();
  message.append(document.createTextNode("Restored version " + details.restoredVersion + ". "));
  if (details.savedId) {
    message.append(jQuery('<a href="#" class="version-history-undo"></a>')
      .text("Undo restore")
      .attr("title", "Go back to version " + details.savedVersion + ", saved just before the restore")
      .on("click", function(event) {
        event.preventDefault();
        message.addClass("is-hidden");
        VersionHistory.restoreById(details.savedId);
      }));
  }
  message.append(jQuery('<a href="#" class="version-history-message-close" aria-label="Dismiss">\u00d7</a>')
    .on("click", function(event) {
      event.preventDefault();
      message.addClass("is-hidden");
    }));
  message.removeClass("is-hidden");
}
