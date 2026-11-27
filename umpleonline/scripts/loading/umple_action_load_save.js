// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for loading the initial model file and saving a new one

// Initial load of a file (e.g. example or blank) at initialization
Action.loadFile = function()
{
  var filename = Page.getFilename();
  if (filename != "")
  {
    Action.setjustUpdatetoSaveLater(true);
    if (Page.getModel().substring(0, 8) == "taskroot")
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadFileCallback,format("load=1&isTask=1&filename={0}",filename),{onFinally: Action.initialLoadFinished});
    } 
    else 
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadFileCallback,format("load=1&filename={0}",filename),{onFinally: Action.initialLoadFinished});
    }
  }
  else
  {
    Action.saveNewFile();
  }
}

// Collaboration needs the loaded text, which is complete once the model file and the tab list are both in
Action.initialLoadsPending = 2;
Action.initialLoadFinished = function()
{
  Action.initialLoadsPending -= 1;
  if (Action.initialLoadsPending == 0)
  {
    Collab.connectCollabServer();
  }
}

// Triggered by the above Action.loadFile. Initial load of a file at startup
Action.loadFileCallback = function(response)
{
  Action.freshLoad = true;
  // TODO: this resolves the loading issue but in a very hacky way. See PR#1402.
  if (Object.keys(TabControl.tabs).length > 1) return;
  Page.setUmpleCode(response.responseText, true);
  TabControl.getCurrentHistory().save(response.responseText,"loadFileCallback");
  Action.setjustUpdatetoSaveLater(true);
  if (TabControl.tabs[TabControl.getActiveTabId()].nameIsEphemeral)
  {
    var extractedName = TabControl.extractNameFromCode(response.responseText);
    if (extractedName)
    {
      TabControl.useActiveTabTo(TabControl.renameTab)(extractedName, true);
    }
  }
  if (!Action.manualSync) {
    Action.updateUmpleDiagram();
    Action.freshLoad = false;
  }

  // LSP: bootstrap after real content is loaded into editor
  if (typeof Page !== "undefined" && Page.initLspAsync) {
    Page.initLspAsync();
  }
}

Action.saveNewFile = function()
{
  var umpleCode = Page.getUmpleCode();
  var filename = Page.getFilename();

  if (filename == "")
  {
    Ajax.sendRequest("scripts/compiler.php",Action.saveNewFileCallback,format("save=1&&umpleCode={0}",umpleCode),{onFinally: Action.initialLoadFinished});
  }

  // LSP: bootstrap for new blank sessions (loadFileCallback doesn't fire)
  if (typeof Page !== "undefined" && Page.initLspAsync) {
    Page.initLspAsync();
  }
}

Action.saveNewFileCallback = function(response)
{
  Page.setFilename(response.responseText);
}
