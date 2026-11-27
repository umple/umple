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

//Mac Keyboard Shortcut
if (navigator.appVersion.indexOf("Mac")!=-1)
{
  jQuery(document).ready(function(){
    jQuery('#undosmall').html('[cmd+z]');
    jQuery('#redosmall').html('[cmd+shift+z]');
  });
  Mousetrap.bind(['command+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.undo();
    }
    e.preventDefault();
  });  
  Mousetrap.bind(['command+shift+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.redo();
    }
    e.preventDefault();
  });
}
else //Non Mac
{
  jQuery(document).ready(function(){
    jQuery('#undosmall').html('[ctrl+z]');
    jQuery('#redosmall').html('[ctrl+y]');
  });
  Mousetrap.bind(['ctrl+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.undo();
    }
    e.preventDefault();
  });  
  Mousetrap.bind(['ctrl+y'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.redo();
    }
    e.preventDefault();
  });
}

//Arrow Up
Mousetrap.bind(['up'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,-5,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+up'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,-1,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Down
Mousetrap.bind(['down'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,5,0,0));
    return false; //equivalent to e.preventDefault();
  } 
});
Mousetrap.bind(['shift+down'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,1,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Left
Mousetrap.bind(['left'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(-5,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+left'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(-1,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Right
Mousetrap.bind(['right'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(5,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+right'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(1,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Functions for changing diagram view - change consistently in umple_page.js
Mousetrap.bind(['ctrl+e'], function(e){
  Page.clickShowEditableClassDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+j'], function(e){
  Page.clickShowJointJSClassDiagram();
  return false; //equivalent to e.preventDefault();
});


Mousetrap.bind(['ctrl+g'], function(e){
  Page.clickShowGvClassDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+shift+v'], function(e){
  Page.clickShowGvEntityRelationshipDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+shift+c'], function(e){
  Page.clickShowInstanceDiagram();
  return false; //equivalent to e.preventDefault();
});

// Mousetrap.bind(['ctrl+shift+f'], function(e){
//   Page.clickShowCRUDUI();
//   return false; //equivalent to e.preventDefault();
// });

Mousetrap.bind(['ctrl+shift+t'], function(e){
  Page.clickShowStateTables();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+shift+r'], function(e){
  Page.clickShowEventSequence();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+s'], function(e){
  Page.clickShowGvStateDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+l'], function(e){
  Page.clickShowStructureDiagram();
  return false; //equivalent to e.preventDefault();
});

//Functions for showing and hiding parts of the view
Mousetrap.bind(['ctrl+t', 'ctrl+alt+shift+t'], function(e){
  Page.clickShowHideText();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+d'], function(e){
  Page.clickShowHideCanvas();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+n', 'ctrl+alt+n'], function(e){
  Page.clickShowHideMenu();
  return false; //equivalent to e.preventDefault();
});

// Functions for changing what is shown on the diagram
Mousetrap.bind(['shift+ctrl+a'], function(e){
  Page.clickToggleAttributes();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+m'], function(e){
  Page.clickToggleMethods();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+r'], function(e){
  Page.clickToggleTraits();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+i'], function(e){
  Page.clickToggleTransitionLabels();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+k'], function(e){
  Page.clickToggleGuardLabels();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+b'], function(e){
  Action.promptAndExecuteTest();
  return false;
});

Mousetrap.bind(['ctrl+o'], function(e){
  Action.copyCommandLineCode();
  return false;
});

// Functions for editing the diagram - using shift
Mousetrap.bind(['g'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {      
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {
      jQuery('#buttonAddGeneralization').click();
    }        
  }  
});

Mousetrap.bind(['a'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {
      jQuery(Page.useGvStateDiagram ? '#buttonAddTransition' : '#buttonAddAssociation').click();
    }
  }
});

Mousetrap.bind(['c'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {        
      jQuery(Page.useGvStateDiagram ? '#buttonAddState' : '#buttonAddClass').click();
    }        
  }
});

Action.toggleTabsCheckbox = function(language)
{
  // Workaround for TextUml having java prefix
  if($("inputGenerateCode").value.split(":")[1] == "TextUml"){
    language = "TextUml";
  }

  if(language == "java" || language == "php" || language == "cpp" ||
    language == "python" || language == "ruby" || language == "javascript" || language == "sql") {
    jQuery("#ttTabsCheckbox").show();
    jQuery("#tabRow").show();

    if ($("inputGenerateCode").value.split(":")[1] == "USE" || $("inputGenerateCode").value.split(":")[1] == "UmpleSelf" || $("inputGenerateCode").value.split(":")[1] == "Json") {
      jQuery("#ttTabsCheckbox").hide();
      jQuery("#tabRow").hide();
    }
  }
  else {
    jQuery("#ttTabsCheckbox").hide();
    jQuery("#tabRow").hide();
    if(jQuery('#buttonTabsCheckbox').is(':checked')){
      jQuery('#buttonTabsCheckbox').click();
    }
  }
}

// Function for splitting code into tabs for every new file, activated when checking the Show Tabs checkbox
Action.toggleTabs = function()
{
  // Checking on the checkbox
  if(jQuery('#buttonTabsCheckbox').is(':checked')){

    // Show row with buttons for each filename
    jQuery('#tabRow').show();

    // Hide main code window with glommed files
    jQuery('#innerGeneratedCodeRow').hide();

    // Show first file codeblock
    jQuery('#tabButton1').click();

  }
  // Checking off the checkbox
  else{

    // Hide row with buttons
    jQuery('#tabRow').hide();

    // Show main code window with glommed files
    jQuery('#innerGeneratedCodeRow').show();

    // Hide all file codeblocks
    jQuery('#innerGeneratedCodeRow').nextAll().hide();

  }
}

Action.generateTabsCode = function(theCode)
{
  var arrCodeFiles = [];
  var intFileCounter = 0;
  var strFileContents = "";
  var arrFileNames = [];
  var strNewLine = "";
  var skipSpace = false;

  // Read full code output line by line
  theCode.split('URL_SPLIT')[1].split("\n").forEach(function(theLine){

    // If New File Beginning
    if( (theLine.indexOf("//%%") >= 0) || (theLine.indexOf("# %%") >= 0)){
      intFileCounter++;
      strFileName = theLine.slice(14);
      strFileName = strFileName.substr(0, strFileName.indexOf(' '));
      arrFileNames[intFileCounter] = strFileName;
      jQuery('#generatedCodeRow').append("<div id='innerGeneratedCodeRow" + intFileCounter + "'></div>");
      arrCodeFiles[intFileCounter] = "";
      skipSpace = true;
    }
    else{
      if(!skipSpace){
         arrCodeFiles[intFileCounter] += theLine + "\n";
      }
      else{
        skipSpace = false;
      }
    }
  });

  // Output buttons for number of files found
  for (i=1; i <= intFileCounter; i++){
    jQuery('#tabRow').append("<button type='button' id='tabButton" + i + "'>" + arrFileNames[i] + "</button>");
    jQuery('#tabButton' + i).click({code: arrCodeFiles[i], tabnumber: i}, showTab);
  }
}

Action.getLanguage = function() 
{
  var language = "";
  if(Page.useEditableClassDiagram) {language="language=Json";}
    // JointJS receives the full model (class and state machine) in JSON
  else if(Page.useJointJSClassDiagram) {language="language=JsonMixed";}
  else if(Page.useGvClassDiagram) {
    if(Page.showTraits) {
      language="language=traitDiagram";
    }
    else {
      language="language=classDiagram";
    }
  }
  else if(Page.useGvStateDiagram) {language="language=stateDiagram"}
  else if(Page.useGvEntityRelationshipDiagram) {language="language=entityRelationshipDiagram"}
  else if(Page.useGvUseCaseDiagram) {language="language=useCaseDiagram"}
  else if(Page.useStructureDiagram) {language="language=StructureDiagram"}
  else if(Page.useInstanceDiagram) {language="language=instanceDiagram"}
  else if(Page.useCRUDUI) {language="language=Json&languageStyle=crudJson"}
  else if(Page.useStateTables) {language="language=StateTables"}
  else if(Page.useEventSequence) {language="language=eventSequence"}
 
 

  // append any suboptions needed for GvStateDiagram
  if(Page.useGvStateDiagram) { 
    if(!Page.showActions) language=language+".hideactions";
    if(Page.showTransitionLabels) language=language+".showtransitionlabels";
    if(!Page.showGuards) language=language+".hideguards";    
    if(Page.showGuardLabels) language=language+".showguardlabels";
    if(!Page.showNaturalLanguage) language=language+".hidenaturallanguage";
    language=language+"."+$("inputGenerateCode").value.split(":")[1];
  }
  // append any suboptions needed for GvClassDiagram
  if(Page.useGvClassDiagram) { 
    if(Page.showMethods) language=language+".showmethods";
    if(!Page.showAttributes) language=language+".hideattributes";
  }
  // append any suboptions needed for GvFeatureDiagram
  if(Page.useGvFeatureDiagram) {
    language="language=featureDiagram";
    if(Page.showFeatureDependency) language=language+".showFeatureDependency";
  }
  // append the list of words specified in the filterwords
  // Also gather together copyable code to create a mixset from these
  copyableMixset ="";
  if(Page.filterWordsOutput != "") {
    language=language+".!@FW!@"+Page.filterWordsOutput;

    // Grab the words people have typed in manually for use in mixset
    var copyableIncludeStatements = "";
    Page.filterWordsOutput.split("!@").forEach(function(aFilterWord){
      if(aFilterWord != "") {
        // If it is a number then add a hops clause
        if(!isNaN(aFilterWord)) {
          copyableIncludeStatements+="  hops { association "+aFilterWord+";} ";
        }
        // If it starts with gv it is a filter word and if separator needs cleaning
        else if(aFilterWord.substr(0,2) == "gv") {
          if(aFilterWord.substr(0,11) == "gvseparator") {
            copyableMixset+="  suboption \""+aFilterWord.replace("@@@","")+"\";\n";
          }
          else {
            copyableMixset+="  suboption \""+aFilterWord+"\";\n";
          }
        }
        // If it starts with mixset or filter then process as named
        else if(aFilterWord.substr(0,6) == "filter") {
          copyableMixset+="  filter {includeFilter "+aFilterWord.substr(6)+";}\n";
        }
        else if(aFilterWord.substr(0,6) == "mixset") {
          copyableMixset+="  use "+aFilterWord.substr(6)+";\n";        
        }
        // Otherwise process as a filter pattern
        else {
          copyableIncludeStatements+=" include "+aFilterWord+";";
        }
      }
    });
    if(copyableIncludeStatements != "") {
      copyableMixset += "  filter {"+copyableIncludeStatements+"}\n";
    }
  }   
  // append any of the mixsets of filters
  // words in checkboxes that start with filter, followed by a named filter name
  Page.filtersActive.forEach(function(aNamedFilter){
    language=language+".filter"+aNamedFilter;
    copyableMixset+="  filter {includeFilter "+aNamedFilter+";}\n";
  });
  // words in checkboxes that start with mixset, followed by a mixset name
  Page.mixsetsActive.forEach(function(aMixset){
    language=language+".mixset"+aMixset;
    copyableMixset+="  use "+aMixset+";\n";
  });
  // words in checkboxes starting gv  
  Page.specialSuboptionsActive.forEach(function(aSpecialSuboption){
    language=language+"."+aSpecialSuboption;
    copyableMixset+="  suboption \""+aSpecialSuboption+"\";\n";
  });
  // Generate the actual copyable mixset, calling M followed by 3 digits
  var randomMixsetNumber = Math.floor(Math.random() * 899.0 + 100.0);
  Page.copyableMixset="\/\/ The following was generated from the show and hide options\n"
    +"\/\/ Rename the mixset and paste into the code so you can invoke it at any time\n"
    +"mixset M"+randomMixsetNumber+" {\n"+copyableMixset+"}";
  return language;
}

function showTab(event)
{
  // Hide all file codeblocks
  jQuery('#innerGeneratedCodeRow').nextAll().hide();

  // Show only relevant file codeblock
  jQuery('#innerGeneratedCodeRow' + event.data.tabnumber).show();

  // Highlight code for specific file only
  Page.showGeneratedCode(event.data.code, $("inputGenerateCode").value.split(":")[0], event.data.tabnumber);

  // Hide main code window with glommed files
  jQuery('#innerGeneratedCodeRow').hide();
}

Action.hidegdpr = function() 
{
  jQuery('#gdprtext').hide();
  Action.gdprHidden = true;
}

Action.reindent = function(lines, cursorPos)
{
  var offset = "";
  var codeAfterIndent = "";
  var len = lines.length;
  var inBlockComment = false;
  var statementEnd = true; // i.e. have semicolon at the end of the statement.
  var statementEndIndentSpace = 0;
  var indexOfCursor = -1;
  for (var i = 0; i < len; i++) 
  {
    var trimmedLine = lines[i].trim();

    // remove quotation
    var indexOfFirstQuote  = trimmedLine.indexOf("\"");
    var indexOfLastQuote = trimmedLine.indexOf("\"", indexOfFirstQuote + 1);
    while (indexOfFirstQuote != -1 && indexOfLastQuote != -1)
    {
      trimmedLine = trimmedLine.slice(0, indexOfFirstQuote) + trimmedLine.slice(indexOfLastQuote+1, trimmedLine.length);
      indexOfFirstQuote  = trimmedLine.indexOf("\"");
      indexOfLastQuote = trimmedLine.indexOf("\"", indexOfFirstQuote + 1);
    }

    // remove comment
    if (trimmedLine.indexOf("//") != -1)
    {
      trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("//")).trim();
    }

    if (inBlockComment)
    {
      if (trimmedLine.indexOf("*/") != -1)
      {
        trimmedLine = trimmedLine.substr(trimmedLine.indexOf("*/") + 2).trim();
        inBlockComment = false;
      }
      else {
        if (i != lines.length -1)
        {
          codeAfterIndent += lines[i] + "\n";
        } else {
          codeAfterIndent += lines[i];
        }
        continue;
      }
    }
    else if (trimmedLine.indexOf("/*") != -1)
    {
      if (trimmedLine.indexOf("*/") == -1)
      {
        inBlockComment = true;
        trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("/*")).trim();
      }
      else
      {
        trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("/*")) + trimmedLine.substr(trimmedLine.indexOf("*/") + 2).trim(); // remove block comment for trimmed line
      }
      
    }
    
    var indexOfOpenCurlyBrace = trimmedLine.indexOf("{");
    var indexOfCloseCurlyBrace = trimmedLine.indexOf("}");
    var indexOfSemiColon = trimmedLine.indexOf(";");

    
    if (indexOfSemiColon != -1 && indexOfSemiColon != trimmedLine.length - 1 && trimmedLine.substr(indexOfSemiColon+1).trim().charAt(0) != "}")
    {
      lines.splice(i + 1, 0, trimmedLine.substr(indexOfSemiColon + 1));
      if (i <= cursorPos.line)
      {
        cursorPos.line++;
      }
      lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfSemiColon + 1);
      Action.reindent(lines, cursorPos);
      return;
    }

    var doNotIndent = indexOfOpenCurlyBrace != -1 && indexOfCloseCurlyBrace != -1 && indexOfCloseCurlyBrace - indexOfOpenCurlyBrace < 40 && trimmedLine.substr(0, indexOfCloseCurlyBrace).indexOf("{", indexOfOpenCurlyBrace + 1) == -1;
    if (doNotIndent)
    {
      if (indexOfCloseCurlyBrace != trimmedLine.length - 1)
      {
        lines.splice(i + 1, 0, trimmedLine.substr(indexOfCloseCurlyBrace + 1));
        if (i <= cursorPos.line)
        {
          cursorPos.line++;
        }
        lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfCloseCurlyBrace + 1);
        Action.reindent(lines, cursorPos);
        return;
      }
      
      if (!statementEnd)
      {
        if (trimmedLine.slice(-1) == "{")
        {
          statementEnd = true;
        } 
        else 
        {
          lines[i] = offset + lines[i].match(/^\s*/)[0].substr(statementEndIndentSpace) + lines[i].trim();
          if (trimmedLine.indexOf(";") == trimmedLine.length - 1)
          {
            statementEnd = true;
          }
        }
      }
      else
      {
        lines[i] = offset + lines[i].trim();
      }
    }
    else 
    {
      if (indexOfOpenCurlyBrace != -1 && indexOfOpenCurlyBrace != trimmedLine.length - 1) // put code after an open curly bracket to next line
      {
        lines.splice(i + 1, 0, trimmedLine.substr(indexOfOpenCurlyBrace + 1));
        lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfOpenCurlyBrace + 1);
        if (i <= cursorPos.line)
        {
          cursorPos.line++;
        }
        Action.reindent(lines, cursorPos);
        return;
      }

      if (indexOfCloseCurlyBrace != -1 && trimmedLine.length > 1)
      {
        if (indexOfCloseCurlyBrace == 0)
        {
          lines.splice(i + 1, 0, trimmedLine.substr(1));
          lines[i] = "}";
          if (i <= cursorPos.line)
          {
            cursorPos.line++;
          }
        } else {
          lines.splice(i + 1, 0, "}");
          if (i <= cursorPos.line)
          {
            cursorPos.line++;
          }
          if (indexOfCloseCurlyBrace != trimmedLine.length - 1) // there is code after close curly bracket
          {
            lines.splice(i + 2, 0, trimmedLine.substr(indexOfCloseCurlyBrace + 1));
            if (i <= cursorPos.line)
            {
              cursorPos.line++;
            }
          }
          lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfCloseCurlyBrace);
        }
        Action.reindent(lines, cursorPos);
        return;
      }


      if (statementEnd && trimmedLine.indexOf(";") != trimmedLine.length - 1 && trimmedLine.slice(-1) != "{" && trimmedLine.slice(-1) != "}" && trimmedLine.slice(-2) != "||")
      {
        statementEnd = false;
        statementEndIndentSpace = lines[i].match(/^\s*/)[0].length;
      }

      if (indexOfCloseCurlyBrace != -1)
      {
        offset = offset.substr(2);
      }

      if (!statementEnd)
      {
        if (trimmedLine.slice(-1) == "{" || trimmedLine.slice(-2) == "||" && trimmedLine.slice(-1) == "}")
        {
          statementEnd = true;
          lines[i] = offset + lines[i].trim();
        } 
        else 
        {
          lines[i] = offset + lines[i].match(/^\s*/)[0].substr(statementEndIndentSpace) + lines[i].trim();
          if (trimmedLine.indexOf(";") == trimmedLine.length - 1)
          {
            statementEnd = true;
          }
        }
      }
      else
      {
        lines[i] = offset + lines[i].trim();
      }

      if (indexOfOpenCurlyBrace != -1)
      {
        offset += "  ";
      }
    }

    if (i != lines.length -1)
    {
      codeAfterIndent += lines[i] + "\n";
    } else {
      codeAfterIndent += lines[i];
    }
  }
  
  if(Page.codeMirrorOn) 
  {
    Page.codeMirrorEditor6.dispatch({
      changes: {from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: codeAfterIndent}
    })

  }
  
  // Refactoring definitive text location
  Action.updateCurrentUmpleTextBeingEdited(codeAfterIndent);

  var cursorLine = Page.getRawUmpleCodeCM6().split("\n")[Page.codeMirrorEditor6.state.doc.lineAt(Page.codeMirrorEditor6.state.selection.main.head).number];
  var whiteSpace = cursorLine.match(/^\s*/)[0].length;

  if (cursorPos.ch >= cursorLine.trim().length) 
  {
    Page.codeMirrorEditor6.dispatch({selection: {anchor: (cursorPos.line), head: (cursorLine.trim().length + whiteSpace)}});
  }
  else if (cursorPos.ch >= 0)
  {
    Page.codeMirrorEditor6.dispatch({selection: {anchor: (cursorPos.line), head: (cursorPos.ch+whiteSpace)}});  
  }
  else
  {
   const position = Page.codeMirrorEditor6.state.selection.main.head;
   Page.codeMirrorEditor6.dispatch({selection: {anchor: position, head: position}});
  }

  Page.codeMirrorEditor6.focus();
}

Action.setLiveView = function(viewNameToSet)
{
  Page.catFeedbackMessage("DEBUG:"+viewNameToSet);
  if (viewNameToSet=="ecd") { Page.clickShowEditableClassDiagram(); }
  else if (viewNameToSet=="gcd") { Page.clickShowGvClassDiagram(); }
  else if (viewNameToSet=="sd") { Page.clickShowGvStateDiagram(); }
  else if (viewNameToSet=="std") { Page.clickShowStructureDiagram();}
  else if (viewNameToSet=="erd") { Page.clickShowGvEntityRelationshipDiagram();}
  else if (viewNameToSet=="gfd") { Page.clickShowGvFeatureDiagram();}
  else if (viewNameToSet=="gucd") { Page.clickShowGvUseCaseDiagram();}
  else if (viewNameToSet=="instanceDiagram") {Page.clickShowInstanceDiagram();}
  else if (viewNameToSet == "crudUI") { Page.clickShowCRUDUI();}
  else if (viewNameToSet == "stateTables") { Page.clickShowStateTables();}
  else if (viewNameToSet == "eventSequence") { Page.clickShowEventSequence();}
  else Page.catFeedbackMessage("DEBUG bad selection!!!");
}



Action.syncLiveViewSelector = function(viewCode) {
  var selector = document.getElementById("liveViewSelector");
  if (selector) {
    selector.value = viewCode;
  }
};

// --- Live View visibility helpers ---
// Requirement: if Diagram (D) is off, Live View control disappears;
// it reappears when D is on again.
Action.setLiveViewMenuVisible = function(isVisible) {
  try {
    var $selector = jQuery("#liveViewSelector");
    if ($selector.length === 0) return;

    //Prefer an explicit wrapper if present.
    var $wrapper = jQuery("#liveViewWrapper, #liveViewContainer, .liveViewContainer").filter(function() {
      return jQuery(this).find("#liveViewSelector").length > 0;
    }).first();

    //Otherwise, use the smallest nearby container that looks like the Live View control.
    if ($wrapper.length === 0) {
      $wrapper = $selector.parents("span,div").filter(function() {
        var txt = (jQuery(this).text() || "").toLowerCase();
        return txt.indexOf("live view") !== -1 && jQuery(this).find("#liveViewSelector").length > 0;
      }).first();
    }

    // If we found a safe wrapper, hide/show it (label + select together).
    if ($wrapper.length > 0) {
      $wrapper.toggle(!!isVisible);
      return;
    }

    // Fallback: hide/show the selector + any associated label.
    $selector.toggle(!!isVisible);
    var $label = jQuery("label[for='liveViewSelector'], #liveViewLabel");
    if ($label.length) $label.toggle(!!isVisible);
  } catch (e) {
    // Fail silently; do not break the UI if DOM differs.
  }
};

Action.updateLiveViewVisibility = function() {
  // Diagram visibility is tracked by Page.showCanvas in UmpleOnline.
  // When D is toggled, Page.showCanvas flips true/false.
  var diagramVisible = !!Page.showCanvas;
  Action.setLiveViewMenuVisible(diagramVisible);
};

// Ensure Live View visibility is correct on initial page load.
jQuery(function() {
  if (typeof Action.updateLiveViewVisibility === "function") {
    Action.updateLiveViewVisibility();
  }
});
