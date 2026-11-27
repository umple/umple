// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Core of the Action object, which handles actions triggered by UI elements
// in UmpleOnline: shared state, the menu click dispatcher, undo/redo,
// drag and drop of files, and the Ajax call to the compiler.
// This file creates the Action object, so it must be loaded before all the
// other umple_action_*.js files.

var Action = new Object();
Action.waiting_time = 1500;
Action.oldTimeout = null;
Action.elementClicked = false;
Action.canCreateByDrag = true;
Action.manualSync = false;
Action.diagramInSync = true;
Action.freshLoad = false;
Action.gentime = new Date().getTime();
Action.savedCanonical = "";
Action.gdprHidden = false;
Action.update = "";
Action.neighbors=[];

const clientDebuggerFlag = false;


// Regulators of whether a save occurs on not
// false: the program proceeds and saves as normal; true: skip the save as the program would have saved earlier already
let justUpdatetoSaveLater = false;

Action.setjustUpdatetoSaveLater = function(state){
  justUpdatetoSaveLater = state;
}

let justUpdatetoSaveLaterForTextCallback = false;

Action.setjustUpdatetoSaveLaterForTextCallback = function(state){
  justUpdatetoSaveLaterForTextCallback = state;
}

Action.clicked = function(event)
{
  Page.clickCount += 1;

  var obj = event.currentTarget;
  var action = obj.id.substring(6);
  if (action == "PhpCode")
  {
    Action.generateCode("php","Php");
  }
  else if (action == "RubyCode")
  {
    Action.generateCode("ruby","Ruby");
  }
  else if (action == "JavaCode")
  {
    Action.generateCode("java","Java");
  }
  else if (action == "RTCppCode")
  {
    Action.generateCode("rtcpp","RTCpp");
  }
  else if (action == "AlloyCode")
  {
    Action.generateCode("alloy","Alloy");
  }
  else if (action == "NuSMVCode")
  {
    Action.generateCode("nusmv","NuSMV");
  }
  else if (action == "CppCode")
  {
    Action.generateCode("cpp","Cpp");
  }
  else if (action == "SQLCode")
  {
    Action.generateCode("sql","Sql");
  }
  else if (action == "JavaAPIDoc")
  {
    Action.generateCode("javadoc","javadoc");
  }
  else if (action == "StateDiagram")
  {
    Action.generateCode("stateDiagram","stateDiagram");
  }
  else if (action == "StructureDiagram")
  {
    Action.generateCode("structureDiagram","structureDiagram");
  }
  else if (action == "FeatureDiagram")
  {
    Action.generateCode("featureDiagram","featureDiagram");
  }
  else if (action == "classDiagram")
  {
    Action.generateCode("classDiagram","classDiagram");
  }
  else if (action == "instanceDiagram")
  {
    Action.generateCode("instanceDiagram","instanceDiagram");
  }
  else if (action == "entityRelationshipDiagram")
  {
    Action.generateCode("entityRelationshipDiagram","entityRelationshipDiagram");
  }
  else if (action == "EcoreCode")
  {
    Action.generateCode("xml","Ecore");
  }
  else if (action == "GenerateCode")
  {
    var languageAndGenerate = $("inputGenerateCode").value.split(":");
    Action.generateCode(languageAndGenerate[0],languageAndGenerate[1]);
  }
  else if (action == "ExecuteCode")
  {
    var languageAndExecute = $("inputGenerateCode").value.split(":");
    Action.executeCode(languageAndExecute[0],languageAndExecute[1]);
  }
  else if (action == "SimulateCode")
  {
    Action.simulateCode();
  }
  else if (action == "StartOver")
  {
    Action.startOver();
  }
  else if (action == "ShowRefreshUmpleOnlineCompletely")
  {
  	Action.showRefreshUmpleOnlineCompletely();
  }
  else if (action == "LoadBlankModel")
  {
  	 Action.loadBlankModel();
  }
  else if (action == "PngImage")
  {
    Action.pngImage();
  }
  else if (action == "YumlImage")
  {
    Action.yumlImage();
  }
  else if (action == "Jsf")
  {
    Action.uigu();
  }
  else if (action == "CopyClip")
  {
    Action.copyClipboardCode();
  }  
  else if (action == "CopyMix")
  {
    Action.copyClipboardMixset();
  }  
  else if (action == "Copy")
  {
    Action.showCodeInSeparateWindow();
  }
  else if (action == "CopyCommandLine")
  {
    Action.copyCommandLineCode();
  }  
  else if (action == "CopyEncodedURL")
  {
    Action.showEncodedURLCodeInSeparateWindow();
  }
  else if (action == "CopyLocalBrowser")
  {
    if (typeof(Storage) !== "undefined") {
      localStorage.setItem("umpleLocalStorage1",Page.getUmpleCode());
      Page.setFeedbackMessage("Model saved. Use Load From Browser later to restore.")
    }
    else{Page.setFeedbackMessage("Unable to copy the model to browser storage. An error occurred.")}
  }
  else if (action == "LoadLocalBrowser")
  {
    if (typeof(Storage) !== "undefined") {
      var textToLoad = localStorage.getItem("umpleLocalStorage1");
      if(textToLoad != null) {
        Page.setUmpleCode(textToLoad);
      }
    }
  }
  else if (action == "RestoreEarlierVersion")
  {
    VersionHistory.openRestoreDialog();
  }
  else if (action == "CreateTask") 
  {
    jQuery("#taskArea").css("display","block");
    //jQuery("#taskNameArea").css("display","block");
    jQuery("#labelTaskName").css("display","block");
    jQuery("#taskNameCell").css("display","block");
    jQuery("#instructions").css("display","block");
    jQuery("#isExperimentCell").css("display","block");
    Layout.zoomResize();
  }
  else if (action == "LoadTask")
  {
    jQuery("#loadTaskNameArea").css("display","block");
  }
  else if (action == "LoadThisTask")
  {
    Action.loadTask(Page.getModel().split("-")[1], false);
  }
  else if (action == "RequestLoadTaskURL")
  {
    var taskname = Page.getModel().split("-")[1];
    Action.copyToClp(window.location.hostname + "/bookmark.php?loadTaskWithURL=1&taskname=" + taskname + "&model=" + taskname);
  }
  else if (action == "RequestAllZip") 
  {
    if (document.getElementById("downloadTaskDirLink") === null)
    {
      var link = document.createElement("a");
      link.setAttribute("href", "scripts/tab_control.php?downloadTaskUserDir=1&taskid=" + Page.getModel());
      link.setAttribute('id', "downloadTaskDirLink");
      var linkText = document.createTextNode("Download ZIP File From Here");
      link.appendChild(linkText);
      
      var node = document.createElement("LI");   
      node.appendChild(link);
      document.getElementById("taskSubmenu").appendChild(node);
    }
    else
    {
      document.getElementById("downloadTaskDirLink").setAttribute("href", "scripts/tab_control.php?downloadTaskUserDir=1&taskid=" + Page.getModel());
    }

    setTimeout(function () {
      document.getElementById("downloadTaskDirLink").remove();
    }, 30000);
  }
  else if (action == "DownloadFiles")
  {
    TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
    
    // issue#1554
    //window.location.href = "scripts/tab_control.php?download=1&&model=" + Page.getModel();
    if (document.getElementById("downloadLink") === null)
    {
      var link = document.createElement("a");
      link.setAttribute("href", "scripts/tab_control.php?download=1&&model=" + Page.getModel());
      link.setAttribute('id', "downloadLink");
      var linkText = document.createTextNode("Download ZIP File From Here");
      link.appendChild(linkText);
      
      var node = document.createElement("LI");   
      node.appendChild(link);
      document.getElementById("saveLoad").appendChild(node);
    }
    else 
    {
      document.getElementById("downloadLink").setAttribute("href", "scripts/tab_control.php?download=1&&model=" + Page.getModel());
    }

    setTimeout(function () {
      document.getElementById("downloadLink").remove();
    }, 30000);
  }
  else if (action == "Undo")
  {
    Action.undo();
  }
  else if (action == "Redo")
  {
    Action.redo();
  }
  else if (action == "Reindent") 
  { 
    var lines = Page.getRawUmpleCodeCM6().split("\n");
    var cursorPos = Page.codeMirrorEditor6.state.selection.main.head;
    var cursorPosLine = Page.codeMirrorEditor6.state.doc.lineAt(cursorPos).number;

    if (clientDebuggerFlag){
      console.log(cursorPosLine);
    }

    var whiteSpace = lines[cursorPosLine].match(/^\s*/)[0].length;
    var lengthToFirstCh = cursorPos.ch - whiteSpace;
    cursorPos.ch = lengthToFirstCh;
    Action.reindent(lines, cursorPos);
  }
  else if (action == "ShowHideTextEditor")
  {
    Layout.showHideTextEditor();
    Page.showText = !Page.showText;
    Page.setShowHideIconState('SHT_button');
    // After toggling Text (T) - doesn't change visibility rule, but keeps things consistent
    if (typeof Action.updateLiveViewVisibility === 'function') { Action.updateLiveViewVisibility(); }
  }
  else if (action == "ShowHideCanvas")
  {
    Layout.showHideCanvas();
    Page.showCanvas = !Page.showCanvas;
    Page.setShowHideIconState('SHD_button');
    // After toggling Diagram (D)
    if (typeof Action.updateLiveViewVisibility === 'function') { Action.updateLiveViewVisibility(); }
  }
  else if (action == "ShowEditableClassDiagram")
  {
    Action.changeDiagramType({type:"editableClass"});
    Action.syncLiveViewSelector("ecd");
  }
  else if (action == "ShowJointJSClassDiagram")
  {
    Action.changeDiagramType({type:"JointJSClass"});
  }
  else if (action == "ShowGvClassDiagram")
  {
    Action.changeDiagramType({type:"GvClass"});
    Action.syncLiveViewSelector("gcd");
  }
  else if (action == "ShowGvFeatureDiagram")
  {
    Action.changeDiagramType({type:"GvFeature"});//buttonShowGvFeatureDiagram
    Action.syncLiveViewSelector("gfd");
  }
  else if (action == "ShowGvUseCaseDiagram")
  {
    Action.changeDiagramType({type:"GvUseCase"});
    Action.syncLiveViewSelector("gucd");
  }
  else if (action == "ShowGvStateDiagram")
  {
    Action.changeDiagramType({type:"GvState"});
    Action.syncLiveViewSelector("sd");
  }
  else if (action == "ShowStructureDiagram")
  {
    Action.changeDiagramType({type:"structure"});
    Action.syncLiveViewSelector("std");
  }
  else if (action === "ShowGvEntityRelationshipDiagram" || action == "ShowEntityRelationshipDiagram")
  {
    Action.changeDiagramType({type:"GvEntityRelationshipDiagram"});
    Action.syncLiveViewSelector("erd");
  }
  else if (action == "ShowInstanceDiagram")
  {
    Action.changeDiagramType({type:"instanceDiagram"});
    Action.syncLiveViewSelector("instanceDiagram");
  }
  else if (action == "ShowCRUDUI")
  {
    Action.changeDiagramType({type:"crudUI"});
    Action.syncLiveViewSelector("crudUI");
  }
  else if (action == "ShowStateTables")
  {
    Action.changeDiagramType({type:"stateTables"});
    Action.syncLiveViewSelector("stateTables");
  }
  else if (action == "ShowEventSequence")
  {
    Action.changeDiagramType({type:"eventSequence"});
    Action.syncLiveViewSelector("eventSequence");
  }
  else if (action == "ShowHideLayoutEditor")
  {
    Layout.showHideLayoutEditor();
  }
  else if (action == "ManualSync")
  {
    Action.enableManualSync();
  }
  else if (action == "SyncDiagram")
  {
    Action.processTyping("codeMirrorEditor", true);
    Page.codeMirrorEditor6.focus();
  }
  else if (action == "PhotoReady")
  {
    Action.photoReady();
  }
  else if (action == "ToggleAttributes")
  {
    Action.toggleAttributes();
    Page.setShowHideIconState('SHA_button');
  }
  else if (action == "ToggleMethods")
  {
    Action.toggleMethods();
    Page.setShowHideIconState('SHM_button');
  }
  else if (action == "ToggleActions")
  {
    Action.toggleActions();
  }
  else if (action == "ToggleTraits")
  {
    Action.toggleTraits();
  }  
  else if (action == "ToggleTransitionLabels")
  {
    Action.toggleTransitionLabels();
  }
  else if (action == "ToggleGuards")
  {
    Action.toggleGuards();
  }
  else if (action == "ToggleGuardLabels")
  {
    Action.toggleGuardLabels();
  }
  else if (action == "ToggleNaturalLanguage")
  {
    Action.toggleNaturalLanguage();
  }
  else if (action == "AllowPinch")
  {
    Action.allowPinch();
  }
  else if (action == "ToggleFeatureDependency")
  {
    Action.toggleFeatureDependency();
  }
  else if(action == "StructureLink")
  {
    Action.generateStructureDiagramFile();
  }
  else if(action == "TabsCheckbox")
  {
    Action.toggleTabs();
  }
  else if(action.substr(0,6) == "mixset")
  {
    Action.toggleMixsetUseStatement(action.substr(6));
  }
  else if(action.substr(0,6) == "filter")
  {
    Action.toggleFilterUseStatement(action.substr(6));
  }
  else if(action.substr(0,2) == "gv")
  {
    Action.toggleSpecialSuboption(action);
  }  
}

Action.focusOn = function(id, gained)
{
  var selector = "#" + id;
  var isPlainEditor = ((id == "umpleModelEditorText" || id == "umpleLayoutEditorText") || id == "CodeMirror");

  if(id == "CodeMirror") selector = ".CodeMirror-scroll"
  
  if (gained) 
  {
    if (!Page.isPhotoReady() || isPlainEditor)
    {
      jQuery(selector).parent().addClass("focus");
      jQuery(selector).addClass("visibleFocus");
      if (isPlainEditor)
      {
        Page.shortcutsEnabled = false;
        if (Page.selectedItem != null) Page.unselectAllToggleTools();
        Action.unselectAll();
      }
    }
  }
  else
  { 
    jQuery(selector).parent().removeClass("focus");
    jQuery(selector).removeClass("visibleFocus");
    if (isPlainEditor || id == "CodeMirror")
    {
      Page.shortcutsEnabled = true;
    }
  }
}

Action.startOver = function()
{
  Page.setUmpleCode("");
  UmpleSystem.merge(null);
  window.location = "umple.php";
}

Action.showRefreshUmpleOnlineCompletely = function()
{
	jQuery("#buttonStartOver").show();
}

Action.undo = function()
{
  if (jQuery("#buttonUndo").hasClass("disabled")) return;
  Action.redoOrUndo(true);
}

Action.redo = function()
{
  if (jQuery("#buttonRedo").hasClass("disabled")) return;
  Action.redoOrUndo(false);
}

// The following from https://developer.mozilla.org/en-US/docs/Web/API/HTML_Drag_and_Drop_API/File_drag_and_drop
Action.dropHandler = function(ev) {
  Page.setFeedbackMessage("File will be dropped")

  // Prevent default behavior (Prevent file from being opened)
  ev.preventDefault();

  if (ev.dataTransfer.items) {
    // Use DataTransferItemList interface to access the file(s)
    for (var i = 0; i < ev.dataTransfer.items.length; i++) {
      // If dropped items aren't files, reject them
      if (ev.dataTransfer.items[i].kind === 'file') {
        var file = ev.dataTransfer.items[i].getAsFile();
        file.text().then(function(text) {
          Page.setUmpleCode(text);
        });
      }
    }
  } else {
    // Use DataTransfer interface to access the file(s)
    for (var i = 0; i < ev.dataTransfer.files.length; i++) {
       ev.dataTransfer.files[i].text().then(function(text) {
        Page.setUmpleCode(text);
      });
    }
  }
}

Action.dragOverHandler = function(ev) {
  // Prevent default behavior (Prevent file from being opened)
  ev.preventDefault();
}

Action.getThemePreference = function()
{
  try {
    var sel = document.getElementById("themeModeSelect");
    var stored = localStorage.getItem("umple-theme");
    var theme = (sel && /^(light|dark|system)$/.test(sel.value)) ? sel.value :
                (/(light|dark|system)$/.test(stored)) ? stored : "system";

    // Resolve "system" to actual theme
    if (theme === "system") {
      return window.matchMedia && window.matchMedia("(prefers-color-scheme: dark)").matches ? "dark" : "light";
    }
    return theme;
  } catch (e) {
    return "light";
  }
}

Action.redoOrUndo = function(isUndo)
{
  var afterHistoryChange = "";
  if (Action.manualSync && Action.diagramInSync)
  {
    Action.diagramInSync = false;
    Page.enablePaletteItem("buttonSyncDiagram", true);
    Page.enableDiagram(false);
  }
  
  if (isUndo) afterHistoryChange = TabControl.getCurrentHistory().getPreviousVersion();
  else afterHistoryChange = TabControl.getCurrentHistory().getNextVersion();
  if (afterHistoryChange == History.noChange)
  {
    afterHistoryChange = "";
  }
  
  var delimiterLoc = afterHistoryChange.indexOf(Page.modelDelimiter);
  var rawReplacement = "";
  if(delimiterLoc == -1) {
    rawReplacement = afterHistoryChange;
  }
  else {
    rawReplacement = afterHistoryChange.substring(0,delimiterLoc);
  }

  var rawOriginal = Page.getRawUmpleCodeCM6().replace(Page.modelDelimiter, "");
  
  var theDiff=Action.findDiff(rawOriginal, rawReplacement);
  var prevLine=Action.getCaretPosition();
  Action.freshLoad = true;
  Page.setUmpleCode(afterHistoryChange);
  if (!Action.manualSync) Action.updateLayoutEditorAndDiagram();

  Action.setjustUpdatetoSaveLater(true);
  
  setTimeout(function () { // Delay so it doesn't get erased
    if(theDiff[1] == theDiff[2])
    {
      // change was in diagram so leave caret where it is
      Action.setCaretPosition(prevLine);
    }
    else
    {
      // set line number to where change occurred
      Action.setCaretPosition(theDiff[3]);
    }   
  }, 300);
}

Action.findDiff = function(oldString, newString)
{

  var lineNumber = 0; // line number in newString
  
  var lOld = oldString.length, lNew = newString.length;
  var l=lOld; // Assume old is shorter
  if (lNew < l) l=lNew; // Actually new is shorter
  var i=0;

  while(i < l && oldString.charAt(i) === newString.charAt(i)) {
    i++;
    if(oldString.charAt(i) === '\n' && newString.charAt(i) === '\n') lineNumber++;
  }
  
  // i is now the character index where the difference begins
  var startChange=newString.substring(i,1);
  
  // Tuple is length of old, length of new, position of change, line number chg
  return [lOld, lNew, i, lineNumber+1];
}

Action.ajax = function(callback,post,target,errors,tabIndependent)
{
  var modelAndPositioning = null;
  modelAndPositioning = Page.getUmpleCode();
  var umpleCode = encodeURIComponent(modelAndPositioning);
  var filename = Page.getFilename();
  var errors = "true";
  TabControl.useActiveTabTo(TabControl.saveTab)(umpleCode);
  post = post + "&theme=" + Action.getThemePreference();

  var tabContextOld = TabControl.getActiveTabId();
  var wrappedCallback = !tabIndependent? function(response){
    var tabContextNew = TabControl.getActiveTabId();
    if (tabContextNew !== tabContextOld){
      Page.hideLoading();
      return;
    }
    callback(response);
  } : callback;
  Ajax.sendRequest("scripts/compiler.php",wrappedCallback,format("{0}&error={3}&umpleCode={1}&filename={2}",post,umpleCode,filename,errors));
}

Action.hidegdpr = function() 
{
  jQuery('#gdprtext').hide();
  Action.gdprHidden = true;
}
