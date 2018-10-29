TabControl = new Object();

// Constants
TabControl.maxTabs = 10;
TabControl.maxNameLength = 32;
TabControl.defaultTabName = "Untitled";
TabControl.showHideKey = "showUmpleTabs";

TabControl.requestQueue = [];

/**
 * Initializes the tab control.
 */
TabControl.init = function()
{
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
  jQuery("#tabControl").show();
  localStorage[TabControl.showHideKey] = true;
}

/**
 * Hides the tab control div.
 */
TabControl.hideTabs = function()
{
  jQuery("#tabControl").hide();
  delete localStorage[TabControl.showHideKey];
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
 * Creates a new tab.
 * name: name of the tab to create
 * fromRemote: true if code should be taken from remote (requires file with given name to exist)
 * resetCode: true if current editor code should not be used to create the new tab
 */
TabControl.createTab = function(name, fromRemote, resetCode)
{
  // If the page is still loading, call this when it's done
  if (Page.modelLoadingCount > 0 || Page.layoutLoadingCount > 0 || Page.canvasLoadingCount > 0) {
    Page.onLoadingCompleteCallbacks.push(function(){TabControl.createTab(name, fromRemote, resetCode)});
    return;
  };
  // Enforce maximum number of tabs
  if (Object.keys(TabControl.tabs).length == TabControl.maxTabs) return;
  // Tab IDs auto-increment similar to PKs of a database
  var newTabId = TabControl.nextTabId++;
  var baseTabName = !name? TabControl.defaultTabName : name;
  var baseCode;
  if (!fromRemote)
  {
    if (!resetCode)
    {
      baseCode = Page.getUmpleCode();
      // Try to find a name from the code if we don't have a desired name
      // and we're not creating new code from scratch
      if (!name) {
        var classNameRegexp = /class[\s]*([a-zA-Z_$][a-zA-Z_$0-9]*)[\s]*{/g;
        var match = classNameRegexp.exec(baseCode);
        if (match) baseTabName = match[1];
      }
    }
    else
    {
      baseCode = Page.modelDelimiter;
    }
  }
  // Count upwards until we find a name that is available
  var tabName = baseTabName;
  var counter = 2;
  while (TabControl.reservedNames.hasOwnProperty(tabName)) {
    tabName = baseTabName + counter++;
  }
  // Create the tab entity - still need to wait for filename to be populated by server
  TabControl.tabs[newTabId] = {
    name: tabName,
    id: newTabId,
    history: History.getInstance(newTabId),
  };
  // If we're creating the file using remote contents, we need to fetch it
  if (fromRemote) {
    var filename = TabControl.getTabFilename(tabName);
    TabControl.addToRequestQueue(
      "scripts/compiler.php",
      TabControl.createTabFromExistingCallback(newTabId),
      format("load=1&&filename={0}", filename));
  }
  // Otherwise create a new tab using the baseCode
  else {
    TabControl.saveTab(newTabId, baseCode, true);
  }
  TabControl.reservedNames[tabName] = true;
}

TabControl.createTabFromExistingCallback = function(tabId)
{
  return function(response)
  {
    TabControl.saveTab(tabId, response.responseText, true);
  }
}

/**
 * Saves the code contents of a tab to the remote file.
 * tabId: the ID of the tab to save
 * umpleCode: the code to save to the tab
 * isNewTab: true if the save corresponds to a newly created tab
 */
TabControl.saveTab = function(tabId, umpleCode, isNewTab)
{
  var filename = TabControl.getTabFilename(TabControl.tabs[tabId].name);
  localStorage[filename] = umpleCode;
  TabControl.addToRequestQueue(
    "scripts/compiler.php",
    TabControl.saveTabCallback(tabId, isNewTab),
    format("save=1&&umpleCode={0}&&filename={1}", umpleCode, filename));
}

TabControl.saveTabCallback = function(tabId, isNewTab)
{
  return function(response) {
    if (isNewTab)
    {
      // Create the physical tab element
      var tabName = TabControl.tabs[tabId].name;
      var createBtn = jQuery("#createTabBtn");
      var tabTemplate = jQuery('<li id="tab' + tabId + '" class="">' + 
        '<a class="tabname" id="tabName' + tabId + '" href="javascript:TabControl.selectTab(\'' + tabId + '\');">' + tabName + '</a>' + 
          '<button class="tabbtn" onclick="javascript:TabControl.deleteTab(\'' + tabId + '\');">&times;</button></li>');
      tabTemplate.insertBefore(createBtn);

      // Disable the create button if we've hit the maximum
      if (Object.keys(TabControl.tabs).length == TabControl.maxTabs)
      {
        createBtn.hide();
      }

      var createdTabName = TabControl.getTabNameDiv(tabId);
      handleNameEdit = function() {
        // Exit edit mode
        createdTabName.attr('contentEditable', false);

        // Remove all whitespace
        var newName = createdTabName.text().replace(/\s/g,'');

        // Revert the name if the name is invalid
        if (newName.length === 0 || newName.length > TabControl.maxNameLength || TabControl.reservedNames.hasOwnProperty(newName)) {
          createdTabName.text(TabControl.tabs[tabId].name);
        }
        // Otherwise perform the rename operation
        else
        {
          createdTabName.text(newName);
          TabControl.renameTab(tabId, newName);
        }
      }

      // Double-click to begin edit mode
      createdTabName.bind('dblclick', function() {
        createdTabName.attr('contentEditable', true);
        createdTabName.focus();
      // Both blur and enter keypress exits edit mode
      }).blur(handleNameEdit).keypress(function(e) {
        var enterKeyCode = 13;
        var deleteKeyCode = 8;
        if(e.which == enterKeyCode) createdTabName.blur();
        if(e.which != deleteKeyCode && createdTabName.text().length >= TabControl.maxNameLength) e.preventDefault();
      });
      
      // If we're just creating a new tab, select it after we save it
      TabControl.selectTab(tabId);
    }
    TabControl.tabs[tabId].filename = response.responseText;
  }
}

/**
 * Selects a tab.
 * tabId: the ID of the tab to select
 */
TabControl.selectTab = function(tabId)
{ 
   // If the page is still loading, call this when it's done
  if (Page.modelLoadingCount > 0 || Page.layoutLoadingCount > 0 || Page.canvasLoadingCount > 0) {
      Page.onLoadingCompleteCallbacks.push(function(){TabControl.selectTab(tabId)});
      return;
  };

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
  // The response is a break-separated list of X.ump files
  var tabs = response.responseText.split("<br />")
  .filter(
    function(name) {
      // Remove empty lines and model.ump
      return (name && name != "model");
  })

  tabs.map(
    function(name) {
      TabControl.createTab(name, true);
    }
  );

  // If no tabs are found, we should still create a single tab
  if (tabs.length === 0) TabControl.createTab();
}

/**
 * Deletes a tab.
 * tabId: the ID of the tab to delete
 */
TabControl.deleteTab = function(tabId)
{
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
      TabControl.deleteTabCallback,
      format("delete=1&&model={0}&&name={1}", Page.getModel(), tabName));
    
    // Navigate to the first tab as necessary
    if (shouldUpdateSelection) {
        TabControl.activeTab = null;
        TabControl.selectTab(Object.keys(TabControl.tabs)[0]);
    }
  }
}

TabControl.deleteTabCallback = function(response){}

/**
 * Renames a tab.
 * tabId: the ID of the tab to rename
 * newName: the new name of the tab
 */
TabControl.renameTab = function(tabId, newName)
{
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

  TabControl.addToRequestQueue(
    "scripts/tab_control.php",
    TabControl.renameTabCallback(tabId, newName),
    format("rename=1&&model={0}&&oldname={1}&&newname={2}", Page.getModel(), oldname, newName));
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

  // If this is the only item in the queue, trigger execution
  if (TabControl.requestQueue.length === 0)
  {
    Ajax.sendRequest(
        requestPayload.endpoint,
        requestPayload.callback,
        requestPayload.parameters);
  }
  else
  {
    TabControl.requestQueue.push(requestPayload);
  }
}

/**
 * Returns a callback that executes the next item in queue.
 */
TabControl.getQueuedCallback = function(callback)
{
  return function(response)
  {
    callback(response);
    // TODO: consider retrying the request on failure
    // The runtime of this is O(n), which is presumably okay since it's
    // running on the client and n is the number of concurrent requests
    var nextRequest = TabControl.requestQueue.shift();
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
  }
}

/**
 * Utility method to execute arbitrary code sequentially in the queue.
 */
TabControl.addCallbackToRequestQueue = function(callback)
{
  var callbackWrapper = {callback: TabControl.getQueuedCallback(callback)};
  if (TabControl.requestQueue.length === 0)
  {
    callbackWrapper.callback();
  }
  else
  {
    TabControl.requestQueue.push(callbackWrapper);
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
