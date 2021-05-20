TabControl = new Object();

// Constants
TabControl.maxTabs = 10;
TabControl.maxNameLength = 32;
TabControl.defaultTabName = "Untitled";
TabControl.showHideKey = "showUmpleTabs";

TabControl.requestQueue = [];
TabControl.remoteDelim = "%NAME:CONTENT:DELIM%";

// Regular expressions used to validate names as valid filenames
TabControl.illegalNameRegxp = /[\/\?<>\\:\*\|":]/g;
TabControl.controlNameRegxp = /[\x00-\x1f\x80-\x9f]/g;
TabControl.reservedNameRegxp = /^\.+$/;
TabControl.windowsReservedNameRegxp = /^(con|prn|aux|nul|com[0-9]|lpt[0-9])(\..*)?$/i;
TabControl.windowsTrailingRegxp = /[\. ]+$/;
TabControl.nameReplacement = "_";

/**
 * Initializes the tab control.
 */
TabControl.init = function()
{
  jQuery("#tabs").sortable({
    axis: "x",
    helper: 'clone',
    items: "li:not(.unsortable)",
    update: TabControl.saveActiveTabs,
  });

  jQuery.fn.selectText = function(){
    var doc = document;
    var element = this[0];
    if (doc.body.createTextRange) {
        var range = document.body.createTextRange();
        range.moveToElementText(element);
        range.select();
    } else if (window.getSelection) {
        var selection = window.getSelection();
        var range = document.createRange();
        range.selectNodeContents(element);
        selection.removeAllRanges();
        selection.addRange(range);
    }
  };

  TabControl.reset();
  if (!localStorage[TabControl.showHideKey])
  {
    TabControl.hideTabs();
  }
  TabControl.loadAllTabs();
}

/**
 * Shows the tab control div.
 */
TabControl.showTabs = function()
{
  jQuery('#toggleTabsButton').html('Hide Tabs');
  jQuery("#tabControl").show();
  localStorage[TabControl.showHideKey] = true;
 // document.getElementById("toggleTabsButton").innerHTML = "Hide Tabs"; 
}

/**
 * Hides the tab control div.
 */
TabControl.hideTabs = function()
{
  jQuery('#toggleTabsButton').html('Show Tabs');  
  jQuery("#tabControl").hide();
  delete localStorage[TabControl.showHideKey];
 // document.getElementById("toggleTabsButton").innerHTML = "Show Tabs";  
}

/**
 * Save the order of the active tabs.
 */
TabControl.saveActiveTabs = function()
{
  var tabNames = [];
  jQuery(".tabname").each(function()
  {
    tabNames.push(jQuery(this).text())
  });
  TabControl.addToRequestQueue(
    "scripts/tab_control.php",
    function(response){},
    format("index=1&&model={0}&&orderedTabNames={1}", Page.getModel(), encodeURIComponent(JSON.stringify(tabNames))));
}

/**
 * Returns the currently active tab ID.
 */
TabControl.getActiveTabId = function()
{
  return (TabControl.activeTab)? TabControl.activeTab.id : null;
}

/**
 * Return true if the tab control is hidden.
 */
TabControl.isHidden = function()
{
  return jQuery("#tabControl").is(":hidden");
}

/**
 * Resets the state of the tab control.
 */
TabControl.reset = function(){
  TabControl.activeTab = null;
  TabControl.tabs = {}
  TabControl.nextTabId = 1;
  TabControl.requestQueue = [];

  // Don't show tabs when there are tabs that are queued for loading
  TabControl.queuedTabs = 0;

  // Make sure that we don't let people create tabs called model. 
  TabControl.reservedNames = {"model": true};
}

/**
 * Returns a sanitized name suitable for filenames on all OS.
 */
TabControl.sanitizeName = function(name)
{
  var sanitized = name
    .replace(TabControl.illegalNameRegxp, TabControl.nameReplacement)
    .replace(TabControl.controlNameRegxp, TabControl.nameReplacement)
    .replace(TabControl.reservedNameRegxp, TabControl.nameReplacement)
    .replace(TabControl.windowsReservedNameRegxp, TabControl.nameReplacement)
    .replace(TabControl.windowsTrailingNameRegxp, TabControl.nameReplacement);
  return sanitized;
}

/**
 * Returns an auto-incremented name based on name availability.
 */
TabControl.findNextAvailableTabName = function(baseTabName)
{
  // Count upwards until we find a name that is available
  var tabName = baseTabName;
  var counter = 2;
  while (TabControl.reservedNames.hasOwnProperty(tabName)) {
    tabName = baseTabName + counter++;
  }
  return tabName;
}

/**
 * Returns first class name found in code.
 */
TabControl.extractNameFromCode = function(code)
{
  var classNameRegexp = /class[\s]*([a-zA-Z_$][a-zA-Z_$0-9]*)[\s]*{/g;
  var match = classNameRegexp.exec(code);
  if (match) return match[1];
}

/**
 * Creates a new tab.
 * name: name of the tab to create
 * fromRemote: true if code should be taken from remote (requires file with given name to exist)
 * resetCode: true if current editor code should not be used to create the new tab
 */
TabControl.createTab = function(name, code, shouldNotSaveActiveTabs)
{
  if (Page.readOnly && name == 'afterTabControlInit')
  {
    return;
  } else if (name == 'afterTabControlInit')
  {
    name = null;
  }

  // Enforce maximum number of tabs
  if (Object.keys(TabControl.tabs).length == TabControl.maxTabs) return;

  // Tab IDs auto-increment similar to PKs of a database
  var newTabId = TabControl.nextTabId++;
  var baseTabName = !name? TabControl.defaultTabName : name;
  if (code != null)
  {
    // Try to find a name from the code if we don't have a desired name
    // and we're not creating new code from scratch
    if (!name) {
      var extractedName = TabControl.extractNameFromCode(code);
      if (extractedName) baseTabName = extractedName;
    }
  }
  else
  {
    code = Page.modelDelimiter;
  }
  var tabName = TabControl.findNextAvailableTabName(baseTabName);
  
  // Create the tab entity - still need to wait for filename to be populated by server
  TabControl.tabs[newTabId] = {
    name: tabName,
    id: newTabId,
    history: History.getInstance(newTabId),
    nameIsEphemeral: name == null,
  };

  // Bind the code to the tab
  TabControl.reservedNames[tabName] = true;
  TabControl.saveTab(newTabId, code);

  // Create the physical tab element
  var createBtn = jQuery("#createTabBtn");
  var tabTemplate = jQuery('<li id="tab' + newTabId + '" class="">' + 
    '<a class="tabname" title="Double-click to rename tab" id="tabName' + newTabId + '" href="javascript:TabControl.selectTab(\'' + newTabId + '\');">' + tabName + '</a>' + 
      '<button class="tabbtn" onclick="javascript:TabControl.deleteTab(\'' + newTabId + '\');">&times;</button></li>');
  tabTemplate.insertBefore(createBtn);

  // Disable the create button if we've hit the maximum
  if (Object.keys(TabControl.tabs).length == TabControl.maxTabs) createBtn.hide();

  // Add event handlers to handle renaming
  var tabNameDiv = TabControl.getTabNameDiv(newTabId);
  handleNameEdit = function() {
    // Exit edit mode and deselect the text
    tabNameDiv.attr('contentEditable', false);
    if (window.getSelection) window.getSelection().removeAllRanges();
    else if (document.selection) document.selection.empty();

    // Sanitize the input to ensure that we can use it as a filename
    var newName = tabNameDiv.text();
    var oldName = TabControl.tabs[newTabId].name;

    // Do nothing on revert or no op
    if (newName === oldName)
    {
      return;
    }
    // Validation
    var nameIsValid = false;
    if (TabControl.sanitizeName(newName) !== newName)
    {
      alert("The name contains invalid characters. Please try again.");
    }
    else if (newName.length === 0 || newName.length > TabControl.maxNameLength)
    {
      alert("Name must be between 1 and " + TabControl.maxNameLength + " characters long. Please try again.");
    }
    else if (TabControl.reservedNames.hasOwnProperty(newName))
    {
      alert("This name is already in use. Please try again.")
    }
    else
    {
      nameIsValid = true;
    }

    if (nameIsValid)
    {
      // Apply renames
      tabNameDiv.text(newName);
      TabControl.renameTab(newTabId, newName);
    }
    else
    {
      // Revert the name if the name is invalid and reselect it
      tabNameDiv.text(oldName);
      tabNameDiv.selectText();
      tabNameDiv.attr('contentEditable', true);
    }
  }

  // Double-click to begin edit mode
  tabNameDiv.bind('dblclick', function() {
    tabNameDiv.attr('contentEditable', true);
    tabNameDiv.focus();
    tabNameDiv.selectText();
  // Both blur and enter keypress exits edit mode
  }).blur(handleNameEdit).keypress(function(e) {
    var enterKeyCode = 13;
    var deleteKeyCode = 8;
    if(e.which == enterKeyCode) tabNameDiv.blur();
    if(e.which != deleteKeyCode && tabNameDiv.text().length >= TabControl.maxNameLength) e.preventDefault();
  });
  
  // Don't save active tabs as we populate them from remote
  if (!shouldNotSaveActiveTabs)
  {
    TabControl.saveActiveTabs();
  }

  // If we're just creating a new tab, select it after we save it
  TabControl.selectTab(newTabId);
}

/**
 * Saves the code contents of a tab to the remote file.
 * tabId: the ID of the tab to save
 * umpleCode: the code to save to the tab
 * isNewTab: true if the save corresponds to a newly created tab
 */
TabControl.saveTab = function(tabId, umpleCode)
{
  var filename = TabControl.getTabFilename(TabControl.tabs[tabId].name);
  var modelname = Page.getModel();
  localStorage[filename] = umpleCode;
  if (String(Page.getFilename()).indexOf("tasks") !== -1)
  {
    filename = "tasks/" + filename;
    modelname = "tasks/" + modelname;
  }
  var umpleCodeWithoutAmpersand = umpleCode.replace(/&/g, "%26").replace(/\+/g, "%2B");
  TabControl.addToRequestQueue(
    "scripts/compiler.php",
    TabControl.saveTabCallback(tabId),
    format("save=1&&lock=1&&model={2}&&umpleCode={0}&&filename={1}", umpleCodeWithoutAmpersand, filename, modelname));
}

TabControl.saveTabCallback = function(tabId)
{
  return function(response) {
    // Make sure the tab exists before we save the filename for it
    if (TabControl.tabs[tabId])
    {
      TabControl.tabs[tabId].filename = response.responseText;
    }
  }
}

/**
 * Selects a tab.
 * tabId: the ID of the tab to select
 */
TabControl.selectTab = function(tabId)
{ 
  if (TabControl.activeTab) {
    // Do nothing if already selected
    if (tabId == TabControl.activeTab.id) return;

    // Deselect old tab and save the current page contents to it
    var oldActiveTabDiv = TabControl.getTabDiv(TabControl.activeTab.id);
    oldActiveTabDiv.removeClass("selected");
    TabControl.saveTab(TabControl.activeTab.id, Page.getUmpleCode());
  }

  // Select the new tab
  TabControl.activeTab = TabControl.tabs[tabId];
  var activeTabDiv = TabControl.getTabDiv(tabId);
  activeTabDiv.addClass("selected");
  TabControl.getCurrentHistory().setButtons();

  // Load code from cache
  var filename = TabControl.getTabFilename(TabControl.activeTab.name);
  Page.setUmpleCode(localStorage[filename]);

  // Reset caret position
  Action.setCaretPosition(0);
  Action.updateLineNumberDisplay();
}

/**
 * Loads all tabs by checking for files on remote and generating each of them.
 * If no files are found (aside from model.ump), creates a single tab for it. 
 */
TabControl.loadAllTabs = function()
{
  TabControl.addToRequestQueue(
    "scripts/tab_control.php",
    TabControl.loadAllTabsCallback,
    format("list=1&&model={0}", Page.getModel()));
}

TabControl.loadAllTabsCallback = function(response)
{
  // The response is a break-separated list of tab name and content pairings
  var tabs = response.responseText.split("<br />")
  var foundRemoteTabs = false;

  tabs.map(function(nameContent)
  {
      if (!nameContent) return;
      var nameContentSplit = nameContent.split(TabControl.remoteDelim);
      var name = nameContentSplit[0];
      var content = nameContentSplit[1];
      if (!name || name === "model") return;
      if (!foundRemoteTabs)
      {
        // Hide tabs until all of the tabs are populated
        TabControl.hideTabs();
        foundRemoteTabs = true;
      }
      TabControl.createTab(name, content, true);
  });

  // If no tabs are found, we should initialize with a single tab
  if (!foundRemoteTabs)
  {
    TabControl.createTab(null, Page.getUmpleCode());
  }
  else
  {
    TabControl.showTabs();
  }
}

/**
 * Deletes a tab.
 * tabId: the ID of the tab to delete
 */
TabControl.deleteTab = function(tabId)
{
  if (Page.readOnly)
  {
    return;
  } 
  // Don't delete if we only have one tab
  if (Object.keys(TabControl.tabs).length > 1) {
    // Confirm deletion
    var tabName = TabControl.getTabNameDiv(tabId);
    var result = confirm("Are you sure you want to remove " + tabName.text() + "?");
    if (!result) return;

    // If we're deleting the currently active tab, we need to navigate away
    var shouldUpdateSelection = tabId == TabControl.activeTab.id;
    
    // Delete the tab locally
    TabControl.getTabDiv(tabId).remove();

    var tabName = TabControl.tabs[tabId].name;
    var filename = TabControl.tabs[tabId].filename;
    delete TabControl.reservedNames[tabName];
    delete TabControl.tabs[tabId];
    delete localStorage[filename];

    // The create button should now be re-enabled
    var createBtn = jQuery("#createTabBtn");
    createBtn.show();

    // Delete the tab on remote
    TabControl.addToRequestQueue(
      "scripts/tab_control.php",
      function(response){},
      format("delete=1&&model={0}&&name={1}", Page.getModel(), tabName));
    
    // Navigate to the first tab as necessary
    if (shouldUpdateSelection) {
        TabControl.activeTab = null;
        TabControl.selectTab(Object.keys(TabControl.tabs)[0]);
    }

    TabControl.saveActiveTabs();
  }
}

/**
 * Renames a tab.
 * tabId: the ID of the tab to rename
 * newName: the new name of the tab
 */
TabControl.renameTab = function(tabId, newName, updateUI)
{
  if (Page.readOnly)
  {
    return;
  } 
  // If the new name already exists, return
  if (TabControl.reservedNames.hasOwnProperty(newName)) return;

  // If the names are the same, then there's no work to do either
  var oldname = TabControl.tabs[tabId].name;
  if (oldname == newName) return;

  // Update cached contents
  var oldfilename = TabControl.getTabFilename(oldname);
  var newfilename = TabControl.getTabFilename(newName);
  localStorage[newfilename] = localStorage[oldfilename]
  delete localStorage[oldfilename];

  // Only programmatic calls need to update the GUI text again
  if (updateUI)
  {
    TabControl.getTabNameDiv(tabId).text(newName);
  }

  // If a name was renamed, then it is no longer ephemeral
  TabControl.tabs[tabId].nameIsEphemeral = false;

  TabControl.addToRequestQueue(
    "scripts/tab_control.php",
    TabControl.renameTabCallback(tabId, newName),
    format("rename=1&&model={0}&&oldname={1}&&newname={2}", Page.getModel(), oldname, newName));

  TabControl.saveActiveTabs();
}

TabControl.renameTabCallback = function(tabId, newName)
{
  return function(response) {
    delete TabControl.reservedNames[TabControl.tabs[tabId].name];
    TabControl.reservedNames[newName] = true;
    TabControl.tabs[tabId].name = newName;
  }
}

/**
 * Formats the remote filename given a tab name
 */
TabControl.getTabFilename = function(tabName)
{
  return format("{0}/{1}.ump", Page.getModel(), tabName);
}

/**
 * Gets the tab name div element.
 */
TabControl.getTabNameDiv = function(tabId)
{
  return jQuery("#tabName" + tabId);
}

/**
 * Gets the tab div element.
 */
TabControl.getTabDiv = function(tabId)
{
  return jQuery("#tab" + tabId);
}

/**
 * Add an ajax call to the request queue.
 */
TabControl.addToRequestQueue = function(endpoint, callback, parameters)
{
  var requestPayload = {
    endpoint: endpoint,
    callback: TabControl.getQueuedCallback(callback),
    parameters: parameters};

  TabControl.requestQueue.push(requestPayload);
  // If this is the only item in the queue, trigger execution
  if (TabControl.requestQueue.length === 1)
  {
    jQuery(".bookmarkableUrl").addClass("disabled");
    Ajax.sendRequest(
        requestPayload.endpoint,
        TabControl.getQueuedHeadCallback(requestPayload.callback),
        requestPayload.parameters);
  }
}

/**
 * Extra queue manipulation for head requests.
 */
TabControl.getQueuedHeadCallback = function(callback)
{
  return function(response)
  {
    // Discard an extra item when the callback returns
    TabControl.requestQueue.shift();
    callback(response);
  }
}

/**
 * Returns a callback that executes the next item in queue.
 */
TabControl.getQueuedCallback = function(callback)
{
  return function(response)
  {
    // TODO: consider retrying the request on failure
    // The runtime of this is O(n), which is presumably okay since it's
    // running on the client and n is the number of concurrent requests
    var nextRequest = TabControl.requestQueue.shift();
    callback(response);
    if (nextRequest) {
      if (nextRequest.hasOwnProperty("endpoint"))
      {
        Ajax.sendRequest(
            nextRequest.endpoint,
            nextRequest.callback,
            nextRequest.parameters);
      }
      else
      {
          nextRequest.callback();
      }
    }
    else
    {
      if(Page.modelLoadingCount === 0 
        && Page.layoutLoadingCount === 0 
        && Page.canvasLoadingCount === 0)
      {
        jQuery(".bookmarkableUrl").removeClass("disabled");
      }
    }
  }
}

/**
 * Utility method to execute arbitrary code sequentially in the queue.
 */
TabControl.addCallbackToRequestQueue = function(callback)
{
  var callbackWrapper = {callback: TabControl.getQueuedCallback(callback)};
  TabControl.requestQueue.push(callbackWrapper);
  if (TabControl.requestQueue.length === 1)
  {
    jQuery(".bookmarkableUrl").addClass("disabled");
    TabControl.getQueuedHeadCallback(callbackWrapper.callback());
  }
}

/**
 * Gets the current history object.
 */
TabControl.getCurrentHistory = function()
{
  if (!TabControl.activeTab) return History.getInstance();
  return TabControl.tabs[TabControl.activeTab.id].history;
}

/**
 * Calls the callable using the currently active tab.
 */
TabControl.useActiveTabTo = function(tabCallable)
{
  if (!TabControl.activeTab) return function(){};
  return tabCallable.bind(null, TabControl.activeTab.id);
}
