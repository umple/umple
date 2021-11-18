// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions triggered by UI elements in UmpleOnline
// plus helper functions
// Actions associated with editing the graphical diagram are
// located in the umple_action_diagram.js file.
//
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
  else if (action == "SimulateCode")
  {
    Action.simulateCode();
  }
  else if (action == "StartOver")
  {
    Action.startOver();
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
    var lines = Page.getRawUmpleCode().split("\n");
    var cursorPos = Page.codeMirrorEditor.getCursor(true);
    var whiteSpace = lines[cursorPos.line].match(/^\s*/)[0].length;
    var lengthToFirstCh = cursorPos.ch - whiteSpace;
    cursorPos.ch = lengthToFirstCh;
    Action.reindent(lines, cursorPos);
  }
  else if (action == "ShowHideTextEditor")
  {
    Layout.showHideTextEditor();
    Page.showText = !Page.showText;
    Page.setShowHideIconState('SHT_button');
  }
  else if (action == "ShowHideCanvas")
  {
    Layout.showHideCanvas();
    Page.showCanvas = !Page.showCanvas;
    Page.setShowHideIconState('SHD_button');
  }
  else if (action == "ShowEditableClassDiagram")
  {
    Action.changeDiagramType({type:"editableClass"});
  }
  else if (action == "ShowJointJSClassDiagram")
  {
    Action.changeDiagramType({type:"JointJSClass"});
  }
  else if (action == "ShowGvClassDiagram")
  {
    Action.changeDiagramType({type:"GvClass"});
  }
  else if (action == "ShowGvFeatureDiagram")
  {
    Action.changeDiagramType({type:"GvFeature"});//buttonShowGvFeatureDiagram
  }
  else if (action == "ShowGvStateDiagram")
  {
    Action.changeDiagramType({type:"GvState"});
  }
  else if (action == "ShowStructureDiagram")
  {
    Action.changeDiagramType({type:"structure"});
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
    Page.codeMirrorEditor.focus();
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
  // Action.saveNewFile();
  // location.
  // location.reload();
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
  var rawOriginal = Page.getRawUmpleCode().replace(Page.modelDelimiter, "");
  var theDiff=Action.findDiff(rawOriginal, rawReplacement);
  var prevLine=Action.getCaretPosition();
  Action.freshLoad = true;
  Page.setUmpleCode(afterHistoryChange);
  if (!Action.manualSync) Action.updateLayoutEditorAndDiagram();

  Action.setjustUpdatetoSaveLater(true);
  
  setTimeout(function () { // Delay so it doesn't get erased
    // Page.setFeedbackMessage("Changed line "+theDiff[3]+" "+theDiff[1]);
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

// Initial load of a file (e.g. example or blank) at initialization
Action.loadFile = function()
{
  var filename = Page.getFilename();
  if (filename != "")
  {
    Action.setjustUpdatetoSaveLater(true);
    if (Page.getModel().substring(0, 8) == "taskroot")
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadFileCallback,format("load=1&isTask=1&filename={0}",filename));
    } 
    else 
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadFileCallback,format("load=1&filename={0}",filename));
    }
  }
  else
  {
    Action.saveNewFile();
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
}

Action.loadTask = function(taskName, isBookmark)
{
  jQuery("#showInstrcutionsArea").css("display","block");
  if (!isBookmark)
  {
    Ajax.sendRequest("bookmark.php", Action.loadTaskBookmark,format("taskname={0}&model={0}",taskName));
    //Ajax.sendRequest("scripts/compiler.php",Action.loadTaskCallback,format("loadTask=1&filename={0}",taskName));
  } else {
    if (Page.getModel().split("-")[0] == "task") // it is in task bookmark page. instruction can not be edited.
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadTaskExceptCodeCallback,format("loadTask=1&loadInstructionAsHTML=1&filename={0}",taskName));
    }
    else
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadTaskExceptCodeCallback,format("loadTask=1&filename={0}",taskName));
    }
  }
}

Action.loadTaskBookmark = function(response)
{
  if (response.responseText.split(" ")[0] == "Task")
  {
    window.alert("Load Task Failed! " + response.responseText);
  }
  else
  {
    window.location.href = "umple.php?model=" + response.responseText;
  }
}

Action.loadTaskCallback = function(response)
{
  Action.freshLoad = true;
  // TODO: this resolves the loading issue but in a very hacky way. See PR#1402.
  if (Object.keys(TabControl.tabs).length > 1) return;

  Action.setjustUpdatetoSaveLater(true);
  TabControl.getCurrentHistory().save(response.responseText,"loadTaskCallback");
  var responseArray = response.responseText.split("task delimiter");
  Page.setUmpleCode(responseArray[0]);
  //jQuery("#textareaShowInstrcutions").val(responseArray[1]);
  //jQuery("#labelShowInstructions").text("Task Instructions: " + responseArray[2]);
  if (TabControl.tabs[TabControl.getActiveTabId()].nameIsEphemeral)
  {
    var extractedName = TabControl.extractNameFromCode(responseArray[0]);
    if (extractedName)
    {
      TabControl.useActiveTabTo(TabControl.renameTab)(extractedName, true);
    }
  }
  if (!Action.manualSync) Action.updateUmpleDiagram();
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  window.location.href = "bookmark.php?taskname=" + responseArray[2] + "&model=" + responseArray[3];
}

Action.loadTaskExceptCodeCallback = function(response)
{
  Action.freshLoad = true;
  // TODO: this resolves the loading issue but in a very hacky way. See PR#1402.
  //if (Object.keys(TabControl.tabs).length > 1) return;

  if (!justUpdatetoSaveLater){
    TabControl.getCurrentHistory().save(response.responseText,"loadTaskExceptCodeCallback");
    Action.setjustUpdatetoSaveLater(true);
  }
  var responseArray = response.responseText.split("task delimiter");
  jQuery("#labelInstructions").text("Instructions for task \"" + responseArray[2] + "\":");
  jQuery("#requestorName").val(responseArray[4]);
  jQuery("#labelInstructions").css("display","block");
  jQuery("#taskArea").css("display","block");
  if (Page.getModel().split("-")[0] == "task") // it is in task bookmark page. instruction can not be edited.
  {
    jQuery("#labelInstructions").text("Instructions for task \"" + responseArray[2] + "\":               Requestor Name:" + responseArray[4]);
    jQuery("#labelCompletionURL").css("display", "none");
    jQuery("#completionURLCell").css("display", "none");
    jQuery("#labelRequestorName").css("display", "none");
    jQuery("#requestorName").css("display", "none");
    jQuery("#instructionsHTML").html(responseArray[1]);
  }
  else 
  {
    jQuery("#instructions").val(responseArray[1]);
    jQuery("#instructions").css("display","block");
    jQuery("#completionURL").val(responseArray[5]);
    jQuery("#isExperimentCell").css("display", "inline");
    jQuery("#isExperiment").prop('checked', responseArray[6] == 'true');
    jQuery('#instructions').each(function () {
      this.setAttribute('style', 'height:' + (this.scrollHeight) + 'px;overflow-y:hidden;');
    }).on('input', function () {
      this.style.height = 'auto';
      this.style.height = (this.scrollHeight) + 'px';
    });

    //jQuery("#completionURL").css("width", responseArray[5].length + "ch");
  }
  // jQuery('#instructions').each(function () {
  //   this.setAttribute('style', 'height:' + (this.scrollHeight) + 'px;overflow-y:hidden;');
  // }).on('input', function () {
  //   this.style.height = 'auto';
  //   this.style.height = (this.scrollHeight) + 'px';
  // });

  if (TabControl.tabs[TabControl.getActiveTabId()].nameIsEphemeral)
  {
    var extractedName = TabControl.extractNameFromCode(responseArray[0]);
    if (extractedName)
    {
      TabControl.useActiveTabTo(TabControl.renameTab)(extractedName, true);
    }
  }
  Layout.zoomResize();
}

Action.submitLoadTask = function()
{
  var taskName = jQuery("#inputLoadTaskName").val();
  let patt = /^(\w|\.)+$/; // taskName Take only [ A-Z or a-z or 0-9 or _ or . ]
  if (!patt.test(taskName))//taskName.indexOf(" ") != -1 || taskName.indexOf("/") != -1 || taskName.indexOf("-") != -1 || taskName.indexOf("\\") != -1) 
  {
    window.alert("Task Name can only contain letters(case insensitive), underscores, dots, and digits!");
    return;
  }
  Action.loadTask(taskName, false);
}

Action.submitTaskWork =function()
{
  Ajax.sendRequest("task.php", Action.submitTaskWorkCallback, format("submitTaskWork=1&model={0}&responseURL={1}", Page.getModel(), window.location.href));
}

Action.submitTaskWorkCallback = function(response)
{
  window.alert("Successfully submitted Task!");
  var responseArray = response.responseText.split("task submit delimiter");
  if (responseArray[0] == "")
  {
    window.location.href = responseArray[2];
  }
  else
  {
    window.location.href = responseArray[0] + "?task=" + responseArray[1] + "&url=" + responseArray[2];
  }
}

Action.launchParticipantURL = function()
{
  var taskname = Page.getModel().split("-")[1];
  window.open("bookmark.php?loadTaskWithURL=1&taskname=" + taskname + "&model=" + taskname);
}

Action.copyParticipantURL = function()
{
  var taskname = Page.getModel().split("-")[1];
  var copiedURL = window.location.hostname + window.location.pathname.substring(0, window.location.pathname.lastIndexOf('/')) + "/bookmark.php?loadTaskWithURL=1&taskname=" + taskname + "&model=" + taskname;
  Action.copyToClp(copiedURL);
  Page.setFeedbackMessage("Participant URL is in copy buffer: " + copiedURL);
}

Action.openStartFreshWork = function() 
{
  var a= confirm("Are you sure to start from fresh?"); 
  if(a) { 
    window.location.href = "/umpleonline/umple.php"
  }
}

Action.copyToClp = function(txt){
    prenode=document.createElement("PRE");
    txt = document.createTextNode(txt);
    prenode.appendChild(txt);
    var m = document;
    var w = window;
    var b = m.body;
    b.appendChild(prenode);

    if (b.createTextRange) {
        var d = b.createTextRange();
        d.moveToElementText(txt);
        d.select();
        m.execCommand('copy');
    } 
    else {
        var d = m.createRange();
        var g = w.getSelection;
        d.selectNodeContents(txt);
        g().removeAllRanges();
        g().addRange(d);
        m.execCommand('copy');
        g().removeAllRanges();
    }
    prenode.remove();
}

Action.openInstructionInNewTab = function()
{
  jQuery("#buttonReshowInstructions").css("display", "inline");
  // var winPrint = window.open('', '', 'left=0,top=0,width=800,height=600,toolbar=0,scrollbars=0,status=0');
  // winPrint.document.write("<!DOCTYPE html><html><head><title>Instructions</title></head><body>" + jQuery("#instructionsHTML").html() + "</body></html>");
  // winPrint.document.close();
  // winPrint.focus();
  var tab = window.open('about:blank', '_blank');
  tab.document.write(jQuery("#instructionsHTML").html()); // where 'html' is a variable containing your HTML
  tab.document.close();
  jQuery("#instructionsHTML").css("display", "none");
  jQuery("#labelInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "none");
  Layout.zoomResize();
}

Action.reshowInstructions = function()
{
  jQuery("#instructionsHTML").css("display", "block");
  jQuery("#labelInstructions").css("display", "inline");
  jQuery("#buttonReshowInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "inline");
  Layout.zoomResize();
}

Action.hideInstructions = function()
{
  jQuery("#instructionsHTML").css("display", "none");
  jQuery("#labelInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "none");
  jQuery("#buttonReshowInstructions").css("display", "inline");
  Layout.zoomResize();
}

Action.saveNewFile = function()
{
  var umpleCode = Page.getUmpleCode();
  var filename = Page.getFilename();
  
  if (filename == "")
  {
    Ajax.sendRequest("scripts/compiler.php",Action.saveNewFileCallback,format("save=1&&umpleCode={0}",umpleCode));
  }
}

Action.saveNewFileCallback = function(response)
{
  Page.setFilename(response.responseText);
}

Action.changeDiagramType = function(newDiagramType)
{
  var changedType = false;
  jQuery(".layoutListItem").hide();

  if(newDiagramType.type == "editableClass") { 
    if(Page.useEditableClassDiagram) return;
    Page.useEditableClassDiagram = true;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowEditableClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('editableClass');
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();

  }
  else if(newDiagramType.type == "JointJSClass") { 
    if(Page.useJointJSClassDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = true;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowJointJSClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('JointJSClass');
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();
  }  
  else if(newDiagramType.type == "GvClass") { 
    if(Page.useGvClassDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = true;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowGvClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvClass');
    jQuery(".view_opt_class").show();

  }
  else if(newDiagramType.type == "GvState") {
    if(Page.useGvStateDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = true;
    Page.useStructureDiagram = false;
    Page.useGvFeatureDiagram = false;
    changedType = true;
    jQuery("#buttonShowGvStateDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvState');
    jQuery(".view_opt_state").show();

  }
  else if(newDiagramType.type == "GvFeature") {
   if(Page.useGvFeatureDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvFeatureDiagram = true;
    changedType = true;
    jQuery("#buttonShowGvFeatureDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvFeature');
    jQuery(".view_opt_feature").show();


  }
  else if(newDiagramType.type == "structure") { // Structure Diagram
    if(Page.useGvStructureDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = true;
    Page.useGvFeatureDiagram = false;
    changedType = true;
    jQuery("#buttonShowStructureDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('structure');
  }
  if (changedType) {
    Action.redrawDiagram();
  }
}

Action.pngImage = function()
{
  var jsonText = Json.toString(UmpleSystem);
  var jsonEncodedText = encodeURIComponent(jsonText);
  window.open("scripts/compiler.php?asImage=" + jsonEncodedText, "UMLClassDiagram");
}

Action.yumlImage = function()
{
  var yumlImageSelector = "#buttonYumlImage";
  jQuery(yumlImageSelector).showLoading();
  Action.ajax(Action.yumlImageCallback,"save=1");
}

Action.yumlImageCallback = function(response)
{
  var filename = response.responseText;
  var yumlImageSelector = "#buttonYumlImage";
  jQuery(yumlImageSelector).hideLoading();
  window.open("scripts/compiler.php?asYuml=" + filename, "yumlClassDiagram");
  Page.showViewDone();
}

Action.uigu = function()
{
  var uiguSelector = "#buttonUigu";
  jQuery(uiguSelector).showLoading();
  Action.ajax(Action.uiguCallback,"save=1");
}

Action.uiguCallback = function(response)
{
  var filename = response.responseText;
  var uiguSelector = "#buttonUigu";
  jQuery(uiguSelector).hideLoading();
  window.open("scripts/compiler.php?asUI=" + filename, "showUserInterface");
  Page.showViewDone();
}

Action.copyCommandLineCode = function()
{
  var pretext="sh\n";
  pretext+="echo Will compile umple file. Requires umple command to be installed\n";
  pretext+="cd ~/tmp\n";
  pretext+="mkdir testump-$$\n";
  pretext+="cd testump-$$\n";
  pretext+="cat >> test.ump <<ENDUMP\n";
  var posttext="\nENDUMP\n";
  posttext+="umple test.ump -c -\n";
  posttext+="echo Use ctrl-D to exit back to the original shell\n\n";
  Action.copyToClp(pretext+Page.getUmpleCode()+posttext);
  Page.setFeedbackMessage("Shell code to compile on command line was copied to clipboard");  
}

Action.showCodeInSeparateWindow = function()
{
  codeWindow = window.open("","UmpleCode"+Math.random()*10000,"height=700, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
  codeWindow.document.write('<code><pre id="umpleCode">' + Page.getUmpleCode() + '</pre></code>');
  codeWindow.document.title="Umple raw code";
  codeWindow.document.close();
}

Action.showEncodedURLCodeInSeparateWindow = function()
{
  codeWindow = window.open("","UmpleEncodedURL"+Math.random()*10000,"height=500, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
  codeWindow.document.write('<code><pre id="umpleCode">' + Page.getEncodedURL() + '</pre></code>');
  codeWindow.document.title="Umple encoded URL";
  codeWindow.document.close();
}

Action.simulateCode = function()
{
  simulateButtonSelector = "#buttonSimulateCode";
  jQuery(simulateButtonSelector).showLoading();
  Action.ajax(Action.simulateCodeCallback,"language=Simulate");
}

Action.simulateCodeCallback = function(response)
{
  simulateButtonSelector = "#buttonSimulateCode";
  jQuery(simulateButtonSelector).hideLoading();
  var modelId = response.responseText;
  window.open("../umpleonline/simulate.php?model=" + modelId, "umpleSimulator");
  Page.showViewDone(); 
}

Action.classSelected = function(obj)
{
  var previouslySelected = Page.selectedClass;
  var newClassSelected = obj;
  
  if (previouslySelected != null)
  {
    Page.selectedClass = null;
    
    // Change background color to white
    jQuery("#"+previouslySelected.id).css('background-color','white');
    
    // Hide anchors on previous class
    var selector = "#" + previouslySelected.id + "_anchor";
    for (var i=0; i<8; i++) jQuery(selector + i).hide();
  }
 
  if (newClassSelected != null)
  {
    jQuery("#umpleCanvas").addClass("unscrollable");
    Page.selectedClass = UmpleSystem.find(newClassSelected.id);
    
    // Change background color to blue
    jQuery("#"+newClassSelected.id).css('background-color', '#F3F6FB');
    
    // Show anchors on new class and remove the hovers
    var selector = "#" + newClassSelected.id + "_anchor";
    var hover = "#" + newClassSelected.id + "_hover";
    for (var i=0; i<8; i++)
    {
      jQuery(selector + i).show();
      jQuery(hover + i).hide();
    }
  }
  else
  {
    jQuery("#umpleCanvas").removeClass("unscrollable");
  }
}

Action.classHover = function(event,isHovering)
{
  var updateClass = event.currentTarget;
  if (!Action.diagramInSync) return;
  if (Page.selectedClass != null && Page.selectedClass.id == updateClass.id) return;
  
  var displayType = isHovering ? "block" : "none";
  var umpleClass = jQuery("#" + updateClass.id);
  
  // change the background color
  if (isHovering) umpleClass.css("background-color", "#F3F6FB");
  else umpleClass.css("background-color", "white");
  
  // show or hide the hovers (if they are enabled)
  if (Page.canShowHovers())
  {
    var numHovers = 8;
    var hoverSelector = "#" + updateClass.id + "_hover";
    for (var i=0; i<numHovers; i++)
    {
      if (isHovering) jQuery(hoverSelector + i).show();
      else jQuery(hoverSelector + i).hide();  
    }
  }
}

Action.unselectAll = function()
{
  Action.classSelected(null);
  Action.associationSelected(null);
  Action.generalizationSelected(null);
  Action.transitionSelected(null);
}

Action.classClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.focusOn("umpleCanvas", true);
  Action.focusOn("umpleModelEditorText", false);

  Action.unselectAll();
  Action.elementClicked = true;
  var obj = event.currentTarget;

  Action.selectClass(obj.id);
  
  if (Page.selectedItem == "DeleteEntity")
  {
    DiagramEdit.classDeleted(obj.id);
  }
  else if (Page.selectedItem == "AddAssociation")
  {
    if (DiagramEdit.newAssociation == null)
    {
      Action.canCreateByDrag = false;
      DiagramEdit.createAssociationPartOne(event);
    }
    else
    {
      DiagramEdit.createAssociationPartTwo(event);
      setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
    }
  }
  else if (Page.selectedItem == "AddGeneralization")
  {
    if (DiagramEdit.newGeneralization == null)
    {
      var successful = DiagramEdit.createGeneralizationPartOne(event);
      if (successful) Action.canCreateByDrag = false;
    }
    else
    {
      DiagramEdit.createGeneralizationPartTwo(event);
      setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
    }
  }
  
  else
  {
    Action.classSelected(obj);
  }
}

Action.stateClicked = function(event)
{
    Page.setFeedbackMessage("state clicked");
    if (!Action.diagramInSync) return;
    Action.focusOn("umpleCanvas", true);
    Action.focusOn("umpleModelEditorText", false);

    Action.unselectAll();
    Action.elementClicked = true;
    var obj = event.currentTarget;

    Action.selectState(obj.id);


   if (Page.selectedItem == "AddTransition")
    {
        if (DiagramEdit.newTransition == null)
        {
            Action.canCreateByDrag = false;
            DiagramEdit.createTransitionPartOne(event);
        }
        else
        {
            DiagramEdit.createTransitionPartTwo(event);
            setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
        }
    }
    else
    {
        Action.stateSelected(obj);
    }
}

Action.associationClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.elementClicked = true;
  Action.unselectAll();
  
  var obj = event.currentTarget;
  Action.associationSelected(obj);
}

Action.transitionClicked = function(event)
{
    Page.setFeedbackMessage("transition clicked");
  if(!Action.diagramInSync) return;
  Action.elementClicked = true;
  Action.unselectAll();

  var obj = event.currentTarget;
  Action.transitionSelected(obj);
}
Action.generalizationClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.elementClicked = true;
  Action.unselectAll();
    
  var obj = event.currentTarget;
  Action.generalizationSelected(obj);
}

Action.associationHover = function(event,isHovering)
{
  if (!Action.diagramInSync) return;
  var updateAssociation = event.currentTarget;
  var umpleAssociation = UmpleSystem.findAssociation(updateAssociation.id);
  
  if (updateAssociation != null && Page.canShowHovers())
  {
    var hoverCount = 2;
    var selector = "#" + updateAssociation.id + "_hover";
    
    for (var i=0; i<hoverCount; i++)
    {
      if (isHovering) jQuery(selector+i).show();
      else jQuery(selector+i).hide();
    }
  }
}

Action.transitionHover = function(event,isHovering)
{
    if (!Action.diagramInSync) return;
    var updateTransition = event.currentTarget;
    var umpleTransition = UmpleSystem.findTransition(updateTransition.id);

    if (updateAssociation != null && Page.canShowHovers())
    {
        var hoverCount = 2;
        var selector = "#" + updateAssociation.id + "_hover";

        for (var i=0; i<hoverCount; i++)
        {
            if (isHovering) jQuery(selector+i).show();
            else jQuery(selector+i).hide();
        }
    }
}


Action.generalizationHover = function(event,isHovering)
{
  if (!Action.diagramInSync) return;
  var updateGeneralization = event.currentTarget;
  
  if (updateGeneralization != null && Page.canShowHovers())
  {
    var selector = "#" + updateGeneralization.id + "_hover";
    for (var i=0; i<3; i++)
    {
      if (isHovering) jQuery(selector+i).show();
      else jQuery(selector+i).hide();
    }
  }
}

Action.associationSelected = function(obj)
{
  var isSelected = (obj == null) ? false : true;
  var updateObj = null;
  
  if (Page.selectedItem == "DeleteEntity" && obj != null)
  {
    var addToQueue = false;
    DiagramEdit.associationDeleted(obj.id, addToQueue);
    return;
  }  
  
  if (obj != null)
  {
    Page.selectedAssociation = obj;
    updateObj = obj;
  }
  else if (Page.selectedAssociation != null)
  {
    updateObj = Page.selectedAssociation;
    Page.selectedAssociation = null;
  }
  else
  {
    return;  
  }
  
  var anchorCount = 2;
  var anchorSelector = "#" + updateObj.id + "_anchor";
  for (var i=0; i<anchorCount; i++)
  {
    if (isSelected) jQuery(anchorSelector + i).show();
    else jQuery(anchorSelector + i).hide();
  }
}

Action.transitionSelected = function(obj)
{
    // Page.setFeedbackMessage("transition selected");
    var isSelected = (obj == null) ? false : true;
    var updateObj = null;

    if (Page.selectedItem == "DeleteEntity" && obj != null)
    {
        var addToQueue = false;
        DiagramEdit.transitionDeleted(obj.id, addToQueue);
        return;
    }

    if (obj != null)
    {
        Page.selectedTransition = obj;
        updateObj = obj;
    }
    else if (Page.selectedTransition != null)
    {
        updateObj = Page.selectedTransition;
        Page.selectedTransition = null;
    }
    else
    {
        return;
    }

    var anchorCount = 2;
    var anchorSelector = "#" + updateObj.id + "_anchor";
    for (var i=0; i<anchorCount; i++)
    {
        if (isSelected) jQuery(anchorSelector + i).show();
        else jQuery(anchorSelector + i).hide();
    }
}

Action.generalizationSelected = function(obj)
{
  var isSelected = (obj == null) ? false : true;
  var updateObj = null;
  
  if (Page.selectedItem == "DeleteEntity" && obj != null)
  {
    var addToQueue = false;
    DiagramEdit.generalizationDeleted(obj.id, addToQueue);
    return;
  }  
  
  if (obj != null)
  {
    Page.selectedGeneralization = obj;
    updateObj = obj;
  }
  else if (Page.selectedGeneralization != null)
  {
    updateObj = Page.selectedGeneralization;
    Page.selectedGeneralization = null;
  }
  else
  {
    return;  
  }

  var anchorCount = 3;
  var anchorSelector = "#" + updateObj.id + "_anchor";
  for (var i=0; i<anchorCount; i++)
  {
    if (isSelected) jQuery(anchorSelector + i).show();
    else jQuery(anchorSelector + i).hide();
  }
}

Action.generateCode = function(languageStyle, languageName)
{
  var generateCodeSelector = "#buttonGenerateCode";
  var actualLanguage = languageName;
  var additionalCallback;
  if (Page.getAdvancedMode() == 0 && (languageName === "Cpp"))
  {
    actualLanguage = "Experimental-"+languageName;
  }

  if(languageName === "StateTables")
  {
    additionalCallback = StateTree.colourStateTables;
  }

  if(languageName === "EventSequence")
  {
    additionalCallback = StateTree.colourEventSequences;
  }

  //Vahdat
  if(languageName === "stateDiagram")
  {
    actualLanguage = languageName+"."+$("inputGenerateCode").value.split(":")[1];
  }
  
  jQuery(generateCodeSelector).showLoading();
  Action.ajax(
    function(response) { 
      Action.generateCodeCallback(response, languageStyle, additionalCallback); 
    },
    format("language={0}&languageStyle={1}", actualLanguage, languageStyle),
    "true"
  );
}

Action.photoReady = function()
{
  var canvasSel = "#" + Page.umpleCanvasId();
  if (Page.isPhotoReady())
  {
    jQuery(canvasSel).addClass("photoReady");
  }
  else
  {
    jQuery(canvasSel).removeClass("photoReady");
  }
  
  UmpleSystem.redrawCanvas();
}

Action.generateCodeCallback = function(response, language, optionalCallback)
{
  Page.showGeneratedCode(response.responseText,language);
  Action.gentime = new Date().getTime();

  if(optionalCallback !== undefined)
  {
    optionalCallback();
  }

  var generateCodeSelector = "#buttonGenerateCode";
  jQuery(generateCodeSelector).hideLoading();
  Page.showCodeDone();
  window.location.href='#genArea';
}

Action.classMouseDown = function(event)
{
  if (!Action.canCreateByDrag) return;
  
  if (Page.selectedItem == "AddAssociation" && DiagramEdit.newAssociation == null)
  {
    DiagramEdit.createAssociationPartOne(event);
  }
  else if (Page.selectedItem == "AddGeneralization" && DiagramEdit.newGeneralization == null)
  {
    DiagramEdit.createGeneralizationPartOne(event);
  }
  else if (Page.selectedItem == "AddTransition" && DiagramEdit.newTransition == null)
  {
      DiagramEdit.createTransitionPartOne(event);
  }
}

Action.classMouseUp = function(event)
{
  if (!Action.canCreateByDrag) return;
  
  if (Page.selectedItem == "AddAssociation" && DiagramEdit.newAssociation != null)
  {
    DiagramEdit.createAssociationPartTwo(event);
  }
  else if (Page.selectedItem == "AddGeneralization" && DiagramEdit.newGeneralization != null)
  {
    DiagramEdit.createGeneralizationPartTwo(event);
  }
  else if (Page.selectedItem == "AddTransition" && DiagramEdit.newTransition != null){
    DiagramEdit.createTransitionPartTwo(event);
  }
}

Action.mouseMove = function(event)
{
  Page.clickCount = 0;
  
  if (Page.selectedItem == "AddClass")
  {
    if (DiagramEdit.newClass == null)
    {
      DiagramEdit.newClass = new UmpleClass();
      DiagramEdit.newClass.name = "";
      DiagramEdit.newClass.id = "tempClass";
    }
    Action.drawClassOutline(event, DiagramEdit.newClass);
  }
  
  if (DiagramEdit.newAssociation != null && Page.selectedItem == "AddAssociation")
  {
    Action.drawAssociationLine(event, DiagramEdit.newAssociation);
  }
  if (DiagramEdit.newTransition != null && Page.selectedItem == "AddTransition")
  {
    Action.drawTransitionLine(event, Diagramedit.newTransition);
  }
  if (DiagramEdit.newGeneralization != null && Page.selectedItem == "AddGeneralization")
  {
    Action.drawGeneralizationLine(event, DiagramEdit.newGeneralization);
  }
}

Action.drawClassOutline = function(event, newClass)
{
  var canvasSelector = "#" + Page.umpleCanvasId();
  var screenPosition = new UmplePosition(event.pageX, event.pageY + 1,0,0);
  var mousePosition = screenPosition.subtract(UmpleSystem.position());
  
  newClass.position = new UmplePosition(mousePosition.x, mousePosition.y, UmpleClassFactory.defaultSize.width, UmpleClassFactory.defaultSize.height);
  var classOutline = newClass.drawableClassOutline();
  jQuery(canvasSelector).append(classOutline);
  
  var classSel = "#" + newClass.id;
  var widthSel = classSel + "_width";
  var heightSel = classSel + "_height";
  
  var offset = new Object();
  offset.left = screenPosition.x;
  offset.top = screenPosition.y;
  
  jQuery(classSel).offset(offset);
  jQuery(widthSel).width(newClass.position.width);
  jQuery(heightSel).height(newClass.position.height);
}

Action.drawAssociationLine = function(event, newAssociation)
{
  var canvasSelector = "#" + Page.umpleCanvasId();
  var mousePosition = new UmplePosition(event.pageX, event.pageY,0,0);
  newAssociation.classTwoPosition = mousePosition.subtract(UmpleSystem.position());
  jQuery(canvasSelector).append(newAssociation.drawable());
}

Action.drawTransitionLine = function(event, newTransition)
{
    var canvasSelector = "#" + Page.umpleCanvasId();
    var mousePosition = new UmplePosition(event.pageX, event.pageY,0,0);
    newTransition.toStatePosition = mousePosition.subtract(UmpleSystem.position());
    jQuery(canvasSelector).append(newTransition.drawable());
}


Action.drawGeneralizationLine = function(event, newGeneralization)
{
  var canvasSelector = "#" + Page.umpleCanvasId();
  var generalizationSelector = "#" + newGeneralization.getElementId();
  
  var umpleSystem = UmpleSystem.position();
  var parentX = event.pageX - 5 - umpleSystem.x;
  var parentY = event.pageY + 5 - umpleSystem.y; 
  newGeneralization.parentPosition = new UmplePosition(parentX,parentY,0,0);
  
  jQuery(generalizationSelector).remove();
  jQuery(canvasSelector).append(newGeneralization.drawable(false));
}

Action.umpleCanvasClicked = function(event)
{
  if (Action.elementClicked)
  {
    Action.elementClicked = false;
    return;
  }
  
  if (Page.selectedItem == "AddClass")
  {
    var position = new UmplePosition(Math.floor(event.pageX),Math.floor(event.pageY),0,0);
    DiagramEdit.addClass(position);
  }
  else if (Page.selectedItem == "AddAssociation" && DiagramEdit.newAssociation != null)
  {
    if (Page.clickCount > 1)
    {
      DiagramEdit.removeNewAssociation();
    }
  }
  else if (Page.selectedItem == "AddTransition" && DiagramEdit.newTransition != null)
  {
    if (Page.clickCount >1)
    {
      DiagramEdit.removeNewTransition();
    }
  }

  else if (Page.selectedItem == "AddGeneralization" && DiagramEdit.newGeneralization != null)
  {
    if (Page.clickCount > 1)
    {
    	DiagramEdit.removeNewGeneralization();
    }
  }
  else
  {
    Action.unselectAll();
  }
}

// Called when a change is made by a command that modifies the text, to refresh it
// and then refresh the diagram.
Action.directUpdateCommandCallback = function(response)
{
  Action.updateUmpleTextCallback(response);
  Action.redrawDiagram();
}

// Called whenever any change is made on the graphic pane
// such as adding/deleting/moving/renaming class/assoc/generalization
Action.updateUmpleTextCallback = function(response)
{
  if (!justUpdatetoSaveLater && !justUpdatetoSaveLaterForTextCallback){
    TabControl.getCurrentHistory().save(response.responseText, "TextCallback");
    Page.setExampleMessage("");
  }
  Action.freshLoad = true;
  
  Page.setUmpleCode(response.responseText, Action.update.codeChange);
  // DEBUG
  // Page.setFeedbackMessage("update text callback -");
  // Page.catFeedbackMessage(response.responseText);
  // Page.catFeedbackMessage("-");
  
  Page.hideLoading();

  if (DiagramEdit.textChangeQueue.length == 0) 
  {
    Action.freshLoad = false;
    DiagramEdit.pendingChanges = false;
    Action.setjustUpdatetoSaveLater(false);
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }
  else{
    Action.setjustUpdatetoSaveLater(true);
    Action.setjustUpdatetoSaveLaterForTextCallback(true);
    DiagramEdit.doTextUpdate();
  }
  
  //Uncomment for testing purposes only - to update the image after updating the text
  //Action.updateUmpleDiagram();
}

Action.setExampleType = function setExampleType()
{
  // Hide them all first
  jQuery("#itemLoadExamples").hide();
  jQuery("#itemLoadExamples2").hide();
  jQuery("#itemLoadExamples3").hide();
  jQuery("#itemLoadExamples4").hide();
     
  if(Page.getExampleType() == "cdModels") {
     jQuery("#itemLoadExamples").show();
     jQuery("#defaultExampleOption").prop("selected",true);
   }
   else if(Page.getExampleType() == "smModels") {
     jQuery("#itemLoadExamples2").show();
     jQuery("#defaultExampleOption2").prop("selected",true);
   }
   else if(Page.getExampleType() == "featureModels") {
     jQuery("#itemLoadExamples4").show();
     jQuery("#defaultExampleOption4").prop("selected",true);
   }
   else {
     jQuery("#itemLoadExamples3").show();
     jQuery("#defaultExampleOption3").prop("selected",true);
   }   
}

Action.loadExample = function loadExample()
{
  var diagramType = this.dataset['diagramType'];
  var $option = jQuery(' option:selected', this);
  if ($option.hasClass('openUmprOption')) {
    // user wants to open the umpr repository
    location.href = "http://umpr.umple.org?diagram-type=" + diagramType;
    return;
  }

  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode=" + Page.getSelectedExample());
  var exampleName = Page.getSelectedExample().slice(0,-4);
  var diagramType="";
  if(Page.useGvStateDiagram) {
    diagramType="&diagramtype=state";
    //jQuery("#genjava").prop("selected",true);
  }
 else if(Page.useGvFeatureDiagram) {
    diagramType="&diagramtype=GvFeature";
    //jQuery("#genjava").prop("selected",true);
  }
  else if(Page.useStructureDiagram) {
    diagramType="&diagramtype=structure&generateDefault=cpp";
    //jQuery("#gencpp").prop("selected",true);
  }
  else {
    //jQuery("#genjava").prop("selected",true);
  }
  
  var largerSelector = "#buttonLarger";
  var smallerSelector = "#buttonSmaller";
  var canvasSelector = "#" + Page.umpleCanvasId();
  
  umpleCanvasWidth = jQuery(canvasSelector).width();
  umpleCanvasHeight = jQuery(canvasSelector).height();
  
  var sel = Page.getSelectedExample();
  
  var newURL="?example="+exampleName+diagramType;
  Page.setExampleMessage("<a href=\""+newURL+"\">URL for "+exampleName+" example</a>");

 // TODO - fix so history works nicely
 //   if(history.pushState) {history.pushState("", document.title, newURL);}
           
  jQuery("#inputExample").blur();
}

Action.loadExampleCallback = function(response)
{
  Action.freshLoad = true;
  Action.setjustUpdatetoSaveLater(true);
  Page.setUmpleCode(response.responseText, function(){
    Page.hideLoading();
    Action.updateUmpleDiagram()}
  );
  Action.setCaretPosition("0");
  Action.updateLineNumberDisplay();
  TabControl.getCurrentHistory().save(response.responseText, "loadExampleCallback");
}

Action.customSizeTyped = function()
{
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  
  var width = jQuery("#widthField").val();
  var height = jQuery("#heightField").val();
  
  Action.oldTimeout = setTimeout(function(){ Page.setUmpleCanvasSize(width, height); }, Action.waiting_time);
}

Action.moveSelectedClass = function(umpleClass, delta)
{
  if (umpleClass == null) return;
  
  umpleClass.position = umpleClass.position.add(delta);
  UmpleSystem.updateClass(umpleClass);
  Action.classSelected(umpleClass);
  
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  Action.oldTimeout = setTimeout(function() {DiagramEdit.classMoved(Page.selectedClass);}, 1000); 
}

Action.keyboardShortcut = function(event)
{
    
  if (!Page.shortcutsEnabled)
  {
    return;
  }
  
  var shortcut = event.which;

  if (shortcut == 27)    // escape
  {
    var shortcutDisabled = Page.unselectAllToggleTools();

    if(!shortcutDisabled)
    {
      jQuery(".visibleFocus").blur();
    }
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    if(Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0)
    {
      DiagramEdit.classDeleted(Page.selectedClass.id);
      event.preventDefault();	  
    }
    else if(Page.selectedAssociation)
    {
      DiagramEdit.associationDeleted(Page.selectedAssociation.id);
      event.preventDefault();	  
    }
    else if(Page.selectedGeneralization)
    {
      DiagramEdit.generalizationDeleted(Page.selectedGeneralization.id);
      event.preventDefault();
    }
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery(".umpleClass").is(":focus")){
  	DiagramEdit.classDeleted(document.activeElement.id);
  	event.preventDefault();
  }
  else if ((shortcut == 8 || shortcut == 46) && (jQuery(".untracedAssociation").is(":focus")||jQuery(".redTracedAssociation").is(":focus"))){
  	DiagramEdit.associationDeleted(document.activeElement.id);
  	event.preventDefault();
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery(".umpleGeneralization").is(":focus")){
  	DiagramEdit.generalizationDeleted(document.activeElement.id);
  	event.preventDefault();
  }
}

Action.getCaretPosition = function() // TIM Returns the line number
{
  var ctrl = document.getElementById('umpleModelEditorText');
  
  var CaretPos = Action.getInputSelectionStart(ctrl);
  
  var nlcount=1;
  var theCode=Page.getRawUmpleCode();

  for(var ch=0; ch<(CaretPos); ch++)
  {
     if(theCode.charAt(ch)=="\n") nlcount++;
     
     // The following for debugging
     if (Page.getAdvancedMode() == 2 && ch < 15) { // debug
       Page.catFeedbackMessage("<"+ch+" "+theCode.charAt(ch)+"="+theCode.charCodeAt(ch)+"> ");
     }
  }
  return nlcount;
}

// The following from http://stackoverflow.com/questions/263743/how-to-get-cursor-position-in-textarea/3373056#3373056
Action.getInputSelectionStart = function(el) 
{
  var start = 0, normalizedValue, range, textInputRange, len, endRange;

  if (typeof el.selectionStart == "number" && typeof el.selectionEnd == "number") 
  {
    start = el.selectionStart;
    // The following for debugging
    if (Page.getAdvancedMode() == 2) 
    { // debug
      Page.setFeedbackMessage("Non-IE browser ");
    }
  }
  else 
  { // IE Support
    // The following for debugging
    if (Page.getAdvancedMode() == 2) // debug
    { 
      Page.setFeedbackMessage("IE-type browser ");
    }
    range = document.selection.createRange();
    
    if (range && range.parentElement() == el) {
      len = el.value.length;
      normalizedValue = el.value.replace(/\r\n/g, "\n");
    
      // Create a working TextRange that lives only in the input
      textInputRange = el.createTextRange();
      textInputRange.moveToBookmark(range.getBookmark());
    
      // Check if the start and end of the selection are at the very end
      // of the input, since moveStart/moveEnd doesn't return what we want
      // in those cases
      endRange = el.createTextRange();
      endRange.collapse(false);
    
      if (textInputRange.compareEndPoints("StartToEnd", endRange) > -1) 
      {
        start = len;
      } 
      else 
      {
        start = -textInputRange.moveStart("character", -len);
        start += normalizedValue.slice(0, start).split("\n").length - 1;
      }
    }
  }

  return start;
}

Action.setCaretPosition = function(line)
{
  if(isNaN(line-0)) 
  {
    // It is not a number so must be a special hidden command
    if(line=="gd") 
    {
      jQuery('#gdprtext').show();
      Action.gdprHidden = false;      
    }
    if(line=="av") 
    {
      // Special backdoor to turn on experimental features
      document.getElementById('advancedMode').value=1;
      Page.setFeedbackMessage("");
      return;
    }
    if(line=="db") 
    { // turn on debugging and do certain debugging options
      document.getElementById('advancedMode').value=2;
      Page.setFeedbackMessage("Debug Mode");
      return;
    }
    if(line=="sp")
    { // creates Survey Pass; modifies conditions to allow for survey to be displayed:
      // includes setting RandomizedFrequency to 1, MinutesBeforePrompt to 5 secs, EditsBeforePrompt to 1;
      if (existSCookie("surveyCookie")==null && window.localStorage.getItem("surveyShown")==null){
        if (document.getElementById("styleTip")!=null)
          document.getElementById("styleTip").innerHTML="";
        window.randomSurveyRoll = 1;
        window.surveyData.EditsBeforePrompt=1;
        timeSurveyUp = false;
        clearTimeout(timeSurvey);
        timeSurvey = setTimeout(function(){timeSurveyUp = true;}, 10000);
        timeSurvey;
        displayedText=false;
        if (!displayedText){
          beforeInstance = TabControl.getCurrentHistory().currentIndex;
          document.addEventListener("mouseover", function(){
            if (TabControl.getCurrentHistory().currentIndex-beforeInstance >= 1 && !displayedText && timeSurveyUp){
                displaySurvey();
                this.removeEventListener('mouseover', arguments.callee);
            }                        
          });
        }
      }
      
    }
    if (line=="sc")
    { // clears all survey cookies including whether URL has been shown already, whether the user has been skipped, and whether Survey Pass has been activated
      // run twice for it to be effective
      let setToExpire=new Date();
      setToExpire.setTime(setToExpire.getTime()-1000);
      document.cookie="surveyCookie=done; expires="+setToExpire.toUTCString()+"; path=/;";
      window.localStorage.removeItem("surveyShown");
      document.addEventListener("mouseover", function(){});
      setCookieBeforeClose("off");
    }
    if(line=="tc")
    { // resets cookies for tips
      Page.setFeedbackMessage("Clearing tip cookies");
      let currentTime=new Date();
      currentTime.setTime(currentTime.getTime()-1000);
      window.localStorage.removeItem("first_time");
      document.cookie="tipCookie=done; expires="+currentTime.toUTCString()+"; path=/;";
    }
    if(line.substr(0,2)=="cm") 
    {
      if(line.substr(2,1)=="0" && Page.codeMirrorOn) 
      {
        Page.setFeedbackMessage("Turning code mirroring off");
        Page.codeMirrorEditor.toTextArea();
        Page.codeMirrorOn=false;
        jQuery("#linenum").val("0");
      }
      else if(line.substr(2,1)=="1" && !Page.codeMirrorOn) 
      {
        Page.initCodeMirrorEditor();
        jQuery("#linenum").val("0");
      }
      return;
    }
    if(line.substr(0,2)=="bp") {  // Begin prompt - Also invoked by ctrl-b
      Action.promptAndExecuteTest();
      return;
    }
    else
    {
      if(!Action.selectMatchingText(line)) 
      {
        Page.setFeedbackMessage("Line number or word \""+line+"\" not located");
        setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},3000);
      }
      return;
    }
  }
  if(Page.codeMirrorOn) 
  {
    Page.codeMirrorEditor.setSelection({line: line-1,ch: 0},{line: line-1,ch: 999999});
    Page.codeMirrorEditor.focus();
    return;
  }
  var ctrl = document.getElementById('umpleModelEditorText');
  var startPos=0;
  var endPos=-1;

  if(line<1)
  {
    endPos=0;
  }
  else
  {
    var theCode=Page.getRawUmpleCode();
    for(var ch=0; ch<theCode.length; ch++)
    {
      if(theCode.charAt(ch)=='\n')
      {
        line--;
        if(line==1) startPos=ch+1;
        if(line==0) {
          endPos=ch; 
          break;
        }
      }
    }
    if(endPos==-1) { // got to end
      endPos=theCode.length;
      if(line!=1) startPos=endPos;
    }
  }

  if(ctrl.setSelectionRange)
  {
    ctrl.focus();
    ctrl.setSelectionRange(startPos,endPos);
  }
  else if (ctrl.createTextRange) {
    var range = ctrl.createTextRange();
    range.collapse(true);
    range.moveEnd('character', endPos);
    range.moveStart('character', startPos);
    range.select();
  }
}

// This pops up a panel that can be used to execute certain specialized test commands
// This should be expanded to allow other commands
Action.promptAndExecuteTest = function() {

  // Get the arguments if any (separated by spaces)
  var testCommand=prompt("Umpleonline test prompt. Enter command e.g. 'ac Classname' to add a class","");

  var edargs=testCommand.substr(2,99).strip().split(" "); 
  if(testCommand.substr(0,1)=="a") {
    // add something
    if(testCommand.substr(1,1)=="c") {
      // add class - one argument
      if(edargs.length >=1) {
        Action.directAddClass(edargs[0]);
        return;
      }
    }
    else if (testCommand.substr(1,1)=="a") {
      // add attribute to class - two arguments
      if(edargs.length >=2) {
        Action.directAddAttribute(edargs[0],edargs[1]);
        return;
      }
    }
    else {
      Page.setFeedbackMessage("Syntax error in test add command");
    }
    Page.setFeedbackMessage("Syntax error in test command");
  }
  else {

  }
  return;
}

// Adds a class with the given name. The class may already be there. Just edits the text.
// This could be modified to 
Action.directAddClass = function(className) {

  var umpleJson = Json.toString({"position" : {"x" : "10","y" : "10","width" : "109","height" : "41"},"name" : className});

  Page.setFeedbackMessage("Adding class "+className);
  Action.setjustUpdatetoSaveLater(false);
  Action.ajax(Action.directUpdateCommandCallback,format("action=addClass&actionCode={0}",umpleJson));

  // After a pause to let the ajax return, then redraw the diagram.
  // This could be put in a new callback
  // setTimeout(function() {Action.redrawDiagram();},1000);
  return;
}

// Adds an attribute to a class
Action.directAddAttribute = function(classname, attribute) {
  // This has to be written.
  // It should look for a matching class, and then look for the attributes in it, then
  // inject the new attribute after it. This assumes no type. That could be added by changing
  // this to have three arguments (if the third one was missing there would be no type, hence
  // string as default.
  // If there is no matching class, this should output a message 
  
  Page.setFeedbackMessage("((when written) Adding to class "+classname+" attribute "+attribute);  
  return;
}


// Searches for the matching text in the code mirror editor
// Does not span lines
Action.selectMatchingText = function(text) 
{
  // Does nothing if CodeMirror is off
  if(Page.codeMirrorOn) {
    var scursor = Page.codeMirrorEditor.getSearchCursor(text);
    if(!scursor.findNext()) {
      return false;
    }
    Page.codeMirrorEditor.setSelection(scursor.from(),scursor.to());
    Page.codeMirrorEditor.focus();
    return true;
  }
  return false;
}

// Code behind highlighting of text
Action.selectItem = function(searchCursor, nextCursor)
{
	if(Page.codeMirrorOn) {
    var scursor = Page.codeMirrorEditor.getSearchCursor(searchCursor);

    if(!scursor.findNext()) {
      return; // false
    }

    // Have found declaration of class. Now have to search for the next class or end
    var start = scursor.from();

    var theEnd=new Object();

    theEnd.line = Page.codeMirrorEditor.lineCount();
    theEnd.ch = 9999;
    
    scursor = Page.codeMirrorEditor.getSearchCursor(nextCursor,scursor.to());
    
    while(scursor.findNext()) 
    {
      var endObject = scursor.from();
      
      //This is checking if the class declaration found was in a single line comment.
      innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("//"), endObject);
      var commentFound = innerCursor.findPrevious();
      if(commentFound && innerCursor.from().line == endObject.line) 
      {
        //The class declaration found was actually in a single line comment, keep searching
        continue;
      }

      //Check if the found class declaration is in a multiline comment
      innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("/\\*|\\*/"), endObject);
      //Search backwards for a /* or */
      var commentFound = innerCursor.findPrevious();
      if (commentFound) 
      {
        if(commentFound[0] === "/*") 
        {
          //Note, if an exit multiline comment is found first, then the class declaration cannot be in a comment
          
          //Look for the exit marker
          innerCursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("\\*/"), endObject);
          var commentFound = innerCursor.findNext();
          
          if(commentFound) 
          {
            var commentEnd = innerCursor.from();
            if (commentEnd.line > endObject.line || (commentEnd.line == endObject.line && commentEnd.ch >= endObject.ch))
            {
              //The class declaration found is in a multiline comment, keep looking
              continue;
            }
          }
        }
      }
      
      theEnd.line = endObject.line -1;
      theEnd.ch = 999;
      break;
    }

    Page.codeMirrorEditor.setSelection(start,theEnd);
    return;    //true 
  }
  return;  // false - important do not return a value or it won't work in Firefox/Opera
}

// Highlights the text of the method that is currently selected.
Action.selectMethod = function(methodName, type, accessMod)
{
	var scursor = new RegExp(accessMod+" "+type+" "+methodName+"(\\\s|[(])");
	var ncursor = new RegExp("(public|protected|private|class) [A-Za-z]");

	Action.selectItem(scursor, ncursor);
}

// Highlights the text of the class that is currently selected.
Action.selectClass = function(className) 
{
	var scursor = new RegExp("(class|interface|trait) "+className+"($|\\\s|[{])");
	var ncursor = new RegExp("(class|interface|trait) [A-Za-z]");

	Action.selectItem(scursor, ncursor);
}

// Highlights the text of the class that is currently selected.
Action.selectState = function(stateName)
{
    var scursor = new RegExp("(class|interface|trait) "+stateName+"($|\\\s|[{])");
    var ncursor = new RegExp("(class|interface|trait) [A-Za-z]");

    Action.selectItem(scursor, ncursor);
}

Action.selectStateInClass = function(stateName, classname) 
{
  if(Page.codeMirrorOn) {}
}

Action.delayedFocus = function(ms) 
{
  var ctrl=document.getElementById('umpleModelEditorText');
  setTimeout(function() {ctrl.focus();},ms);
}

Action.updateLineNumberDisplay = function()
{
  jQuery("#linenum").val(Action.getCaretPosition());
}

Action.umpleTyped = function(eventObject)
{
  // This function is not called by CodeMirror
  // See umpleCodeMirrorTypingActivity if CodeMirror is on (as it normally is)
  // debug - output key code
  if (Page.getAdvancedMode() == "2") { // debug
     Page.catFeedbackMessage("["+eventObject.keyCode+"] ");
  }
  Action.updateLineNumberDisplay();

  var eventCode = eventObject.keyCode;
  
  // Ignore 33=pgup 34=pgdn 35=end 36=hom 37=lef 38=up 39=rt 40=dn
  if(eventCode>=33 && eventCode <=40) return;

  var target = eventObject.target.id;
  Action.umpleTypingActivity(target);
}

Action.umpleCodeMirrorCursorActivity = function() {
  var line = Page.codeMirrorEditor.getCursor(true).line+1;
  jQuery("#linenum").val(line);
}

Action.umpleCodeMirrorTypingActivity = function() {
  if(Action.freshLoad == false) {
    Action.umpleTypingActivity("codeMirrorEditor");
    Page.codeMirrorEditor.save();
  }
  else {
    Action.freshLoad = false;
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }

}

Action.trimMultipleNonPrintingAndComments = function(text) {
  text = Action.removeComments(text);
  text = text.replace(/[^\x21-\x7E]+/g, ' '); // change non-printing chars to spaces
  text= text.replace(/^\s+|\s+$/g, '');      // remove leading/trailing spaces
  return text;
}

Action.removeComments = function(str) 
{
   // From http://james.padolsey.com/javascript/javascript-comment-removal-revisted/
 
    var uid = '_' + +new Date(),
        primatives = [],
        primIndex = 0;
 
    return (
        str
        /* Remove strings */
        .replace(/(['"])(\\\1|.)+?\1/g, function(match){
            primatives[primIndex] = match;
            return (uid + '') + primIndex++;
        })
 
        /* Remove Regexes */
        .replace(/([^\/])(\/(?!\*|\/)(\\\/|.)+?\/[gim]{0,3})/g, function(match, $1, $2){
            primatives[primIndex] = $2;
            return $1 + (uid + '') + primIndex++;
        })
 
        /*
        - Remove single-line comments that contain would-be multi-line delimiters
            E.g. // Comment /* <--
        - Remove multi-line comments that contain would be single-line delimiters
            E.g. /* // <-- 
       */
        .replace(/\/\/.*?\/?\*.+?(?=\n|\r|$)|\/\*[\s\S]*?\/\/[\s\S]*?\*\//g, ' ')
 
        /*
        Remove single and multi-line comments,
        no consideration of inner-contents
       */
        .replace(/\/\/.+?(?=\n|\r|$)|\/\*[\s\S]+?\*\//g, ' ')
 
        /*
        Remove multi-line comments that have a replaced ending (string/regex)
        Greedy, so no inner strings/regexes will stop it.
       */
        .replace(RegExp('\\/\\*[\\s\\S]+' + uid + '\\d+', 'g'), ' ')
 
        /* Bring back strings & regexes */
        .replace(RegExp(uid + '(\\d+)', 'g'), function(match, n){
            return primatives[n];
        })
    );
}

Action.umpleTypingActivity = function(target) {
  if (Action.manualSync && Action.diagramInSync)
  {
    if (jQuery("#umpleCanvasColumn").is(":visible")) Page.enablePaletteItem("buttonSyncDiagram", true);
    Action.diagramInSync = false;
    Page.enableDiagram(false);
  }
  //Action.processTyping("codeMirrorEditor", true);
  //return;
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  if(target == "diagramEdit") Action.oldTimeout = setTimeout('Action.processTyping("' + target + '",' + false + ')', 500);
  else Action.oldTimeout = setTimeout('Action.processTyping("' + target + '",' + false + ')', Action.waiting_time);
}

Action.processTyping = function(target, manuallySynchronized)
{
  // Save in history after a pause in typing
  if (target != "diagramEdit") 
  {
    Action.setjustUpdatetoSaveLaterForTextCallback(true);
  }
  else{
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }
  
  if (!Action.manualSync || manuallySynchronized)
  {
    Action.diagramInSync = true;
    
    if (target == "umpleModelEditorText" || target == "codeMirrorEditor") {
      Action.updateLayoutEditorAndDiagram(); 

      // issue#1554
      var downloadLink = document.getElementById("downloadLink");
      if (downloadLink !== null){
        downloadLink.remove();
      }
      
      Page.enablePaletteItem("buttonSyncDiagram", false);
    }
    else if(target == "diagramEdit")
    {
      Action.ajax(Action.updateFromDiagramCallback,Action.getLanguage());
    }
    //Page.enableDiagram(true);
  }

  if (target != "diagramEdit"){
    if (!justUpdatetoSaveLater){
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "processTyping");
    }
    else if (target == "umpleModelEditorText" || target == "codeMirrorEditor"){
      Action.setjustUpdatetoSaveLater(false);
    }
    Page.setExampleMessage("");
    
  }

}

Action.updateLayoutEditorAndDiagram = function()
{
  Action.ajax(Action.updateUmpleLayoutEditor,"language=Json");
}

Action.updateUmpleLayoutEditor = function(response)
{
  //Extract data from response	
  var codeparts = response.responseText.split('URL_SPLIT');
  var errorMessage=codeparts[0];
  var umpleJson=codeparts[1];//Remove the URL_SPLIT in umpleJson

  //If anything failed, set umpleJson to response.responseText
  if(umpleJson == null || umpleJson == undefined)
  {
	  umpleJson = response.responseText;
  }
  
  Page.showLayoutLoading();
  //TODO: for some reason in the live version this call isnt being made
  //but oddly the diagram is updated, and that is done in the callback
      
  Action.ajax(Action.updateUmpleLayoutEditorCallback,format("action=addPositioning&actionCode={0}",umpleJson));  
}

Action.updateUmpleLayoutEditorCallback = function(response)
{
  var umpleCode = response.responseText;
  var positioning = Page.splitUmpleCode(umpleCode)[1];
  
  Page.setUmplePositioningCode(positioning);
  Page.hideLoading();
  Action.updateUmpleDiagramForce(true);
}

Action.updateUmpleDiagram = function() {
 return Action.updateUmpleDiagramForce(true)
}

Action.updateUmpleDiagramForce = function(forceUpdate)
{
  var canonical = Action.trimMultipleNonPrintingAndComments(Page.getUmpleCode());
  if(!forceUpdate) {
    if(canonical == Action.savedCanonical)   
    {
      // The umple code is as we last sent to the diagram, except for comment
      // changes, spaces, tabs and newlines, so we return without doing anything
      return;
    }
  }
  Action.savedCanonical=canonical;
  Page.showCanvasLoading();
  
  Action.ajax(Action.updateUmpleDiagramCallback, Action.getLanguage());

}

Action.updateUmpleDiagramCallback = function(response)
{
  var diagramCode = "";
  var errorMessage = "";

  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
    
  if(diagramCode == null || diagramCode == "" || diagramCode == "null") 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("<a href=\"\#errorClick\">See message.</a> To fix: edit model or click undo");
  }
  else
  {
    Page.enableDiagram(true);
    // reset error message
    if(!Action.diagramInSync)
    {
      Action.diagramInSync = true;
    }

    Page.setFeedbackMessage("");
    Page.hideGeneratedCode();
    
    // Display editable class diagram
    if(Page.useEditableClassDiagram) {
      var newSystem = Json.toObject(diagramCode);
      UmpleSystem.merge(newSystem);
      UmpleSystem.update(); 
      
      //Apply readonly styles
      if (Page.readOnly) 
      {
        jQuery("span.editable").addClass("uneditable");
      }
    }
    else if(Page.useJointJSClassDiagram) {

      var model = JSON.parse(diagramCode.replace( new RegExp('} { "name": "', "gi"), '}, { "name": "' ));

      var umpleCanvas = jQuery("#umpleCanvas");

      var paper = JJSdiagram.initJJSDiagram(umpleCanvas, model);

      // zooming with the mouse wheel or finger swipe
      var MouseWheelHandler = function (event){
        var delta = Math.max(-1, Math.min(1, (event.wheelDelta || -event.detail)));
        if (event.altKey === true) {
          var paperHeight = paper.options.height;
          var paperWidth = paper.options.width;
          // scaleFactor is either 1.1 or 0.9
          var scaleFactor = 1 + (Math.abs(delta) / (delta * 10));
          paper.setDimensions(paperWidth * scaleFactor, paperHeight * scaleFactor)

          //correct paper sizing
          if( JJSdiagram.paper ) 
          JJSdiagram.paper.setDimensions(jQuery("#umpleCanvas")[0].clientWidth, jQuery("#umpleCanvas")[0].clientHeight);

          //scale the content
          //commented it out because the customized object does not scale
          //paper.scaleContentToFit({padding: 15});
        }
      };
      // using the umpleCanvas as the mouse wheel event target, as it is a stable entity
      var paperHolder = document.getElementById("umpleCanvas");

      if (paperHolder.addEventListener) {
        // IE9, Chrome, Safari, Opera
        paperHolder.addEventListener("mousewheel", MouseWheelHandler, false);
        // Firefox
        paperHolder.addEventListener("DOMMouseScroll", MouseWheelHandler, false);
      }
      // IE 6/7/8
      else {paperHolder.attachEvent("onmousewheel", MouseWheelHandler);}

      // Simulate a click on the canvas to draw focus and enable keyboard shortcuts.
      jQuery("#jjsPaper").click(function(){ Action.focusOn(Page.umpleCanvasId(), true);});

    }
    // Display static svg diagram
    else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram )
    {
      jQuery("#umpleCanvas").html(format('{0}', diagramCode));
      jQuery("#umpleCanvas").children().first().attr("id", "svgCanvas");
      Action.setupPinch();
    }
    //Display structure diagram
    else if(Page.useStructureDiagram)
    {
      jQuery("#umpleCanvas").html('<svg id="svgCanvas"></svg>');
      eval(diagramCode);
    }   
  }

  //Show the error message
  if(errorMessage != "")
  {
    Page.showGeneratedCode(errorMessage, "diagramUpdate");
  }
  
  Page.hideLoading();
}

Action.updateFromDiagramCallback = function(response)
{
  var diagramCode = "";
  var errorMessage = "";
  
  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
  
  if((diagramCode == null || diagramCode == "" || diagramCode == "null") && Action.diagramInSync) 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("<a href=\"\#errorClick\">See message.</a> To fix: edit model or click undo");
  }
  else
  {
    Page.enableDiagram(true);
    Action.diagramInSync = true;
  }
  
  //Show the error message
  if(errorMessage != "")
  {
    Page.showGeneratedCode(errorMessage, "diagramUpdate");
  }  
}

// Gets the code to display from the AJAX response
Action.getDiagramCode = function(responseText)
{
  var output = "";
  
  // Also want to use the same response for JointJS
  if(Page.useEditableClassDiagram || Page.useJointJSClassDiagram)
  {
    output = responseText.split('URL_SPLIT')[1];
    
    if(output == "null") output = "";
    
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram)
  {
    // The graphviz diagrams are taken from the inner svg tag only. 
    // This allows the website to have a dynamic canvas size around the diagram
    var codeparts = responseText.split('<svg width=');
    
    //Put the start of the svg back together. 
    if(codeparts.length>1 && codeparts[1].length>100) {
      output = "<svg width="+codeparts[1];
      //remove the redundant svg closing tag
      output = output.replace(/<\/svg>$/, "");
    }
  }
  else if(Page.useStructureDiagram)
  {
    output = responseText.split("<p>URL_SPLIT")[1];
    output = output.replace(/##CANVAS_ID##/g, "svgCanvas");
    // Converts html encoded special characters to plaintext
    output = jQuery("<div/>").html(output).text();
  }
  
  return output;
}

// Gets any error code from the AJAX response
Action.getErrorCode = function(responseText)
{
  var output = "";
  if(Page.useEditableClassDiagram || Page.useStructureDiagram)
  {
    output = responseText.split('URL_SPLIT')[0];
    
    if(output == "<p>") output = "";
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram)
  {
    var miscStuffAndErrorMessages = responseText.split('<svg width=')[0];
    var prelimparts = miscStuffAndErrorMessages.split('errorRow');
    if(prelimparts.length > 1) {
      output = miscStuffAndErrorMessages.split("</script>&nbsp;")[0];
    }
  }

  return output;
}

// This function is no longer being called as its caller has been commented out
Action.classResizing = function(event, ui)
{
  var classId = event.target.id;
  var umpleClass = UmpleSystem.find(classId);
  var classSel = "#" + classId;
  
  var newWidth = Math.round(jQuery(classSel).width());
  var newHeight = Math.round(jQuery(classSel).height());
  
  UmpleSystem.updatingSize(umpleClass,newWidth,newHeight);
}

Action.associationSnap = function(x, y, dragDivSel) 
{
  var id = jQuery(dragDivSel).prop("id");
  var elementId = id.substr(0,id.lastIndexOf("_"));
  var index = id.substr(id.lastIndexOf("_") + "anchor".length + 1);
  var association = UmpleSystem.findAssociation(elementId);
  var umpleClass = association.getClass(index);
  var perimeter = UmpleClassFactory.perimeterPosition(umpleClass,new UmplePosition(x,y,0,0),UmpleSystem.position());
  return [perimeter.x, perimeter.y];
}

Action.associationSnapClassReady = function(x,y,umpleClass)
{
  var perimeter = UmpleClassFactory.perimeterPosition(umpleClass,new UmplePosition(x,y,0,0),UmpleSystem.position());
  return [perimeter.x, perimeter.y];
}

Action.updateMovedAssociation = function(dragDivSel, association)
{
  jQuery(dragDivSel).show();
  var dragOffset = jQuery(dragDivSel).offset();
  var dragDivId = jQuery(dragDivSel).prop("id");
  jQuery(dragDivSel).hide();
  
  var left = Math.round(dragOffset.left);
  var top = Math.round(dragOffset.top);
  
  var xys = Action.associationSnap(left,top,dragDivSel);
  var screenPosition = (new UmplePosition(xys[0],xys[1],0,0));  
  
  if (dragDivId.endsWith("_anchor0"))
  {
    association.setOffsetOnePosition(screenPosition);
  }
  else
  {
    association.setOffsetTwoPosition(screenPosition);
  }
  
  UmpleSystem.redrawAssociation(association);
  Action.associationSelected(null);
}

Action.validateAttributeName = function(newAttribute)
{
  return newAttribute.length!=0  && (
     newAttribute.match(/^[_a-zA-Z0-9]+$/) ||
     newAttribute.match(/^[_a-zA-Z0-9]+[\u0020]*:[\u0020]*[_a-zA-Z0-9]+(\[\])?$/)
     );
}

Action.validateMethodName = function(newMethod)
{
  return newMethod.length!=0 &&
     newMethod.match(/^[-+#]?\s*[_a-zA-Z0-9]+\s*\(([_a-zA-Z0-9]+(\[\])?(,\s*[_a-zA-Z0-9]+(\[\])?)*)?\)(\s*:\s*[_a-zA-Z0-9]+(\[\])?)?$/);
}

Action.toggleAttributes = function()
{
  Page.showAttributes = !Page.showAttributes;
  Action.redrawDiagram();
}
  
Action.toggleMethods = function()
{
  Page.showMethods = !Page.showMethods;
  Action.redrawDiagram();
}

Action.toggleActions = function()
{
  Page.showActions = !Page.showActions;
  Action.redrawDiagram();
}

Action.toggleTransitionLabels = function()
{
  Page.showTransitionLabels = !Page.showTransitionLabels;
  Action.redrawDiagram();
}

Action.toggleGuards = function()
{
  Page.showGuards = !Page.showGuards;
  Action.redrawDiagram();
}
Action.toggleGuardLabels = function()
{
  Page.showGuardLabels = !Page.showGuardLabels;
  Action.redrawDiagram();
}
Action.allowPinch = function()
{
  Page.allowPinch = !Page.allowPinch;
  Action.redrawDiagram();
}
Action.toggleFeatureDependency = function()
{
  Page.showFeatureDependency = !Page.showFeatureDependency;
  Action.redrawDiagram();
}
Action.toggleTraits = function()
{
  Page.showTraits = !Page.showTraits;
  Action.redrawDiagram();
}


Action.redrawDiagram = function()
{
    UmpleSystem.merge(null);    // Clear the diagram
    var canvas = jQuery("#umpleCanvas");
    canvas.html("");
    if (!Action.manualSync) 
    {
      Action.updateUmpleDiagram();
      Action.diagramInSync = true;
      //Page.enableDiagram(true);
    }
    if (Action.manualSync && !Action.diagramInSync) Page.enablePaletteItem('buttonSyncDiagram', true);
    if (!Action.manualSync || Action.diagramInSync)
    {
      Page.enableCheckBoxItem("buttonPhotoReady", "ttPhotoReady", true);
      Page.enableCheckBoxItem("buttonManualSync", "ttManualSync", true);

      Page.enablePaletteItem('buttonAddClass', true);
      Page.enablePaletteItem('buttonAddAssociation', true);
      Page.enablePaletteItem('buttonAddTransition', true);
      Page.enablePaletteItem('buttonAddGeneralization', true);
      Page.enablePaletteItem('buttonDeleteEntity', true);
    
      Page.initToggleTool('buttonAddClass');
      Page.initToggleTool('buttonAddAssociation');
      Page.initToggleTool('buttonAddTransition');
      Page.initToggleTool('buttonAddGeneralization');
      Page.initToggleTool('buttonDeleteEntity');
    }
}

InlineEditor.elementChanged = function(obj, oldVal, newVal)
{
  var editType = obj.attr("name");
  var objId = obj.attr("id");

  if (editType == "className")
  {
    var id = objId.substr(0,objId.length - "_name".length);
    DiagramEdit.classNameChanged(id,oldVal,newVal);
  }
  else if (editType == "attributeEdit")
  {
    var index = objId.substr(objId.lastIndexOf("_") + 1);
    var id = objId.substr(0,objId.length - "_attribute_".length - index.length);
    DiagramEdit.attributeNameChanged(id,index,oldVal,newVal);
  }
  else if(editType == "methodEdit")
  {
    var index = objId.substr(objId.lastIndexOf("_") + 1);
    var id = objId.substr(0,objId.length - "_method_".length - index.length);
    DiagramEdit.methodChanged(id,index,oldVal,newVal);
  }
  else if (editType == "attributeNew")
  {
    var id = objId.substr(0,objId.length - "_newAttribute".length);
    DiagramEdit.attributeNew(id,newVal);
  }
  else if(editType == "methodNew")
  {
    var id = objId.substr(0,objId.length - "_newMethod".length);
    DiagramEdit.methodNew(id,newVal);
  }
}

Action.enableManualSync = function(enable)
{
  var checkbox = jQuery("#buttonManualSync");
  var syncDiagram = jQuery("#buttonSyncDiagram");
  if (enable == undefined) enable = checkbox.is(":checked");
  
  if (enable)
  {
  Action.manualSync = true;
  }
  else
  {
    Action.manualSync = false;
    Action.processTyping("umpleModelEditorText",true);
    Page.enablePaletteItem("buttonSyncDiagram", false);
  }
}

Action.generateStructureDiagramFile = function()
{
  var filename = Page.getFilename().slice(0, -9) + "structureDiagram.svg";

  var svgContents =  jQuery("#innerGeneratedCodeRow").html().slice(4, -1);

  svgContents = format('<svg xmlns="http://www.w3.org/2000/svg" {0}>', svgContents);

  jQuery("#buttonStructureLink").showLoading();

  Ajax.sendRequest("scripts/compiler.php", Action.generateStructureDiagramFileCallback, 
    format("save=1&filename={0}&svgContent={1}", filename, svgContents));
}

Action.generateStructureDiagramFileCallback = function(response)
{
  jQuery("#buttonStructureLink").hideLoading();
  Page.toggleStructureDiagramLink(true, response.responseText);
}

Action.ajax = function(callback,post,errors,tabIndependent)
{
  var modelAndPositioning = Page.getUmpleCode();

  var umpleCode = encodeURIComponent(modelAndPositioning);
  var filename = Page.getFilename();
  // var errors = typeof(errors) != 'undefined' ? errors : "false";
  var errors = "true";
  TabControl.useActiveTabTo(TabControl.saveTab)(umpleCode);

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
      jQuery('#buttonAddAssociation').click();
    }
  }
});

Mousetrap.bind(['c'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {        
      jQuery('#buttonAddClass').click();
    }        
  }
});

Action.toggleTabsCheckbox = function(language)
{
  // Workaround for TextUml having java prefix
  if($("inputGenerateCode").value.split(":")[1] == "TextUml"){
    language = "TextUml";
  }

  if(language == "java" || language == "php" || language == "cpp" 
    || language == "ruby" || language == "sql") {
    jQuery("#ttTabsCheckbox").show();
    jQuery("#tabRow").show();

    if ($("inputGenerateCode").value.split(":")[1] == "UmpleSelf" || $("inputGenerateCode").value.split(":")[1] == "Json") {
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
    if(theLine.indexOf("//%%") >= 0){
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
  else if(Page.useStructureDiagram) {language="language=StructureDiagram"}
 

  // append any suboptions needed for GvStateDiagram
  if(Page.useGvStateDiagram) { 
    if(!Page.showActions) language=language+".hideactions";
    if(Page.showTransitionLabels) language=language+".showtransitionlabels";
    if(!Page.showGuards) language=language+".hideguards";    
    if(Page.showGuardLabels) language=language+".showguardlabels";
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
    Page.codeMirrorEditor.setValue(codeAfterIndent);
  }
  jQuery("#umpleModelEditorText").val(codeAfterIndent);

  var cursorLine = Page.getRawUmpleCode().split("\n")[cursorPos.line];
  var whiteSpace = cursorLine.match(/^\s*/)[0].length;
  if (cursorPos.ch >= cursorLine.trim().length) 
  {
    Page.codeMirrorEditor.setCursor(cursorPos.line, cursorLine.trim().length + whiteSpace);
  }
  else if (cursorPos.ch >= 0)
  {
    Page.codeMirrorEditor.setCursor(cursorPos.line, cursorPos.ch+whiteSpace);
  }
  else
  {
    Page.codeMirrorEditor.setCursor(cursorPos.line, 0);
  }
  Page.codeMirrorEditor.focus();
}
