// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Initializing and maintaining the features on the screen in UmpleOnline
// Layout initialization and maintenance is located in umple_layout.js.

Page = new Object();

// Refactoring definitive text location
Page.currentUmpleTextBeingEdited = "";

Page.selectedItem = null;
Page.selectedClass = null;
Page.selectedAssociation = null;
Page.selectedTransition = null;
Page.selectedGeneralization = null;
Page.canEditTask = false;
Page.canCreateTask = true;
Page.codeEffect = null;
Page.clickCount = 0;
Page.repeatToolItem = false;
Page.shortcutsEnabled = true;
Page.diagramSyncNeededAppend = false;
Page.modelDelimiter = "//$?[End_of_model]$?";

Page.codeMirrorOn = false;
Page.codeMirrorEditor = null;
Page.codeMirrorEditor6 = null;
Page.hLine = null;

Page.modelLoadingCount = 0;
Page.layoutLoadingCount = 0;
Page.canvasLoadingCount = 0;
Page.onLoadingCompleteCallbacks = [];

// Global options
Page.readOnly = false; // initially allow editing
Page.useEditableClassDiagram = true;
Page.useGvClassDiagram = false;
Page.useGvStateDiagram = false;
Page.useGvFeatureDiagram = false;
Page.showFeatureDependency = false;
Page.useStructureDiagram = false;
Page.useFeatureDiagram = false;
Page.showAttributes = true;
Page.showMethods = false;
Page.filterWordsOutput = "";
Page.mixsetsActive = new Array();
Page.filtersActive = new Array();
Page.copyableMixset="";
Page.specialSuboptionsActive = new Array();
Page.showActions = true;
Page.showText = true;
Page.showCanvas = true;
Page.showTraits = false;
Page.showTransitionLabels = false;
Page.showGuardLabels = false;
Page.showGuards = true;
Page.modifiedDiagrams = false;
Page.allowPinch = false;

Page.initialMouseDownX=0;
Page.initialMouseDownY=0;
Page.selectedGvClass="";

  Page.blahblah = function (theString) {
    console.log("In blah blah "+theString);
  }

// Gvmanual determines behaviour of editing so this function
// provides a shortcut to check for it
// Returns boolean
Page.isGvManual = function () {
  return Page.specialSuboptionsActive.includes("gvmanual");
}


// The following is set called from umple.php
Page.init = function(doShowDiagram, doShowText, doShowMenu, doReadOnly, doShowLayout, diagramType,generateDefault, doLoadTask, doEditTask, doCreateTask, displayoptions)
{ 
  if(performance.navigation.type == 2)
  {
    location.reload(true);
  }
  Page.canEditTask = doEditTask;
  Page.canCreateTask = doCreateTask;
  Layout.isDiagramVisible = doShowDiagram;  
  Layout.isTextVisible = doShowText;  
  Layout.isPaletteVisible = doShowMenu;  
  Layout.isLayoutVisible = doShowLayout;
  Page.readOnly = doReadOnly;

  TabControl.init();
  jQuery(".layoutListItem").hide();

  // Set diagram type - anything else means use the default editable class diagram
  if(diagramType.toLowerCase() == "gvstate" || diagramType.toLowerCase() == "state")   
  { 
    Page.useGvStateDiagram = true;
    Page.useEditableClassDiagram = false; 
    Page.setDiagramTypeIconState('GvState');
    Page.useGvFeatureDiagram = false;
    jQuery(".view_opt_state").show();

  }
  else if(diagramType.toLowerCase() == "gvclass")
  {
    Page.useGvClassDiagram = true;
    Page.useEditableClassDiagram = false;
    Page.setDiagramTypeIconState('GvClass');
    Page.useGvFeatureDiagram = false;
    jQuery(".view_opt_class").show();

  }
  else if(diagramType.toLowerCase() == "gvclasstrait")
  {
    Page.useGvClassDiagram = true;
    Page.useEditableClassDiagram = false;
    Page.setDiagramTypeIconState('GvClass');
    Page.useGvFeatureDiagram = false;
    Page.showTraits=true;
    jQuery(".view_opt_class").show();
  } 
  else if(diagramType.toLowerCase() == "gvfeature")
  {
    Page.useGvFeatureDiagram = true;
    Page.useEditableClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    Page.setDiagramTypeIconState('GvFeature');
    jQuery(".view_opt_feature").show();

  }
  else if(diagramType.toLowerCase() == "structurediagram")
  {
    Page.useStructureDiagram = true;
    Page.useEditableClassDiagram = false;  
    Page.setDiagramTypeIconState('structureDiagram');
    Page.useGvFeatureDiagram = false;
  }
  else
  {
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();
  }

  // Set the default displayoptions if there are any
  if(displayoptions != "") {
    if (displayoptions.includes("gvmanual")) {
      Page.specialSuboptionsActive.push("gvmanual");
      displayoptions=displayoptions.replace("gvmanual","");
    }

    if (displayoptions.includes("gvdot")) {
      Page.specialSuboptionsActive.push("gvdot");
      displayoptions=displayoptions.replace("gvdot","");
    }
    else if (displayoptions.includes("gvsfdp")) {
      Page.specialSuboptionsActive.push("gvsfdp");
      displayoptions=displayoptions.replace("gvsfdp","");
    }
    else if (displayoptions.includes("gvortho")) {
      Page.specialSuboptionsActive.push("gvortho");
      displayoptions=displayoptions.replace("gvortho","");
    }

    jQuery("#filtervalues").val(displayoptions);
    Action.setFilterFull(displayoptions,false);
  }

  jQuery.noConflict();
  jQuery(document).keydown(function(event){Action.keyboardShortcut(event);});
  
  Layout.init();
  Page.initPaletteArea();
  Page.initCanvasArea();
  Page.initUmpleTextArea();
  Page.initSourceCodeArea();
  Page.initCodeExecutionArea();
  jQuery(document).ready(function() {
    DropboxInitializer.initializeDropbox();
    ToolTips.initTooltips();
  });

  if(Page.readOnly) {jQuery("#" + Page.umpleCanvasId()).addClass("photoReady");}

  Action.loadFile();
  if (doLoadTask)
  {
    Action.loadTask(jQuery("#model").val().split("-")[1], true); // load task instruction
  }
  
  jQuery(generateDefault).prop("selected",true);
};

Page.initPaletteArea = function()
{
  var palette = "#palette";
  var paletteItems = palette + " *";
  jQuery(palette).accordion({heightStyle: "fill", fillSpace: true, active: 1, collapsible: true});
  jQuery(paletteItems).addClass("unselectable");
  
  Layout.initPaletteSize();
  
  Page.initJQueryButton("buttonGenerateCode");
  Page.initJQueryButton("buttonExecuteCode");
  Page.initJQueryButton("buttonStartOver");
  Page.initJQueryButton("buttonShowRefreshUmpleOnlineCompletely")
  Page.initJQueryButton("buttonLoadBlankModel");
  
  Page.initHighlighter("buttonAddClass");
  Page.initHighlighter("buttonAddAssociation");
  Page.initHighlighter("buttonAddTransition");
  Page.initHighlighter("buttonAddGeneralization");
  Page.initHighlighter("buttonDeleteEntity");
  Page.initHighlighter("buttonPngImage");
  Page.initHighlighter("buttonYumlImage");
  Page.initHighlighter("buttonSimulateCode");
  Page.initHighlighter("buttonUigu");
  Page.initHighlighter("buttonCopyClip");
  Page.initHighlighter("buttonCopyMix");  
  Page.initHighlighter("buttonCollabFork");
  Page.initHighlighter("buttonCopy");
  Page.initHighlighter("buttonCopyEncodedURL");
  Page.initHighlighter("buttonCopyCommandLine");
  Page.initHighlighter("buttonCopyLocalBrowser");
  Page.initHighlighter("buttonLoadLocalBrowser");
  if (Page.canEditTask)
  {
    //Page.initHighlighter("buttonEditTask");
    //Page.initHighlighter("buttonLoadThisTask");
    Page.initHighlighter("buttonRequestAllZip");
    Page.initHighlighter("buttonRequestLoadTaskURL");
  }
  if (Page.canCreateTask)
  {
    Page.initHighlighter("buttonCreateTask");
  }
  Page.initHighlighter("buttonLoadTask")
  
  Page.initHighlighter("buttonDownloadFiles");
  Page.initHighlighter("buttonSmaller");
  Page.initHighlighter("buttonLarger");
  Page.initHighlighter("buttonSyncCode");
  Page.initHighlighter("buttonSyncDiagram");
  Page.initHighlighter("buttonToggleMethods");
  Page.initHighlighter("buttonToggleAttributes");
  Page.initHighlighter("buttonToggleActions");
  Page.initHighlighter("buttonToggleTransitionLabels");
  Page.initHighlighter("buttonToggleGuards");
  Page.initHighlighter("buttonToggleGuardLabels");
  Page.initHighlighter("buttonToggleTraits");
  Page.initHighlighter("buttonToggleFeatureDependency");
  Page.initHighlighter("buttonallowPinch");
  Page.initHighlighter("buttonReindent");
  
  Page.initToggleTool("buttonAddClass");
  Page.initToggleTool("buttonAddAssociation");
  Page.initToggleTool("buttonAddTransition");
  Page.initToggleTool("buttonAddGeneralization");
  Page.initToggleTool("buttonDeleteEntity");
   
  Page.initAction("buttonPngImage");
  Page.initAction("buttonYumlImage");
  Page.initAction("buttonPhpCode");
  Page.initAction("buttonEcoreCode");  
  Page.initAction("buttonJavaCode");
  Page.initAction("buttonJavaAPIDoc");
//  Page.initAction("buttonZip");
  Page.initAction("buttonRubyCode");
  Page.initAction("buttonAlloyCode");
  Page.initAction("buttonNuSMVCode");
  Page.initAction("buttonSqlCode");
  Page.initAction("buttonCppCode");
  Page.initAction("buttonPhotoReady");
  Page.initAction("buttonSimulateCode");
  Page.initAction("buttonShowHideTextEditor");
  Page.initAction("buttonShowHideCanvas");
  Page.initAction("buttonShowEditableClassDiagram");
  Page.initAction("buttonShowJointJSClassDiagram");
    
  Page.initAction("buttonShowGvClassDiagram");
  Page.initAction("buttonShowGvStateDiagram");
  Page.initAction("buttonShowGvFeatureDiagram");//buttonShowGvFeatureDiagram
  Page.initAction("buttonShowStructureDiagram");
  Page.initAction("buttonShowHideLayoutEditor");
  Page.initAction("buttonManualSync");
  Page.initAction("buttonCopyClip");
  Page.initAction("buttonCopyMix");
  Page.initAction("buttonCollabFork");
  Page.initAction("buttonCopy");
  Page.initAction("buttonCopyEncodedURL");
  Page.initAction("buttonCopyCommandLine");
  Page.initAction("buttonCopyLocalBrowser");
  Page.initAction("buttonLoadLocalBrowser");
  if (Page.canEditTask)
  {
    //Page.initAction("buttonEditTask");
    //Page.initAction("buttonLoadThisTask");
    Page.initAction("buttonRequestAllZip");
    Page.initAction("buttonRequestLoadTaskURL");
  }
  if (Page.canCreateTask)
  {
    Page.initAction("buttonCreateTask");
  }
  Page.initAction("buttonLoadTask");

  Page.initAction("buttonDownloadFiles");
  Page.initAction("buttonUndo");
  Page.initAction("buttonRedo");
  Page.initAction("buttonReindent");
  Page.initAction("buttonUigu");
  Page.initAction("buttonStartOver");
  Page.initAction("buttonShowRefreshUmpleOnlineCompletely");
  Page.initAction("buttonLoadBlankModel");
  Page.initAction("buttonGenerateCode");
  Page.initAction("buttonExecuteCode");
  Page.initAction("buttonTabsCheckbox");
  Page.initAction("buttonSmaller");
  Page.initAction("buttonLarger");
  Page.initAction("buttonSyncCode");
  Page.initAction("buttonSyncDiagram");
  Page.initAction("buttonToggleMethods");
  Page.initAction("buttonToggleAttributes");
  Page.initAction("buttonToggleActions");
  Page.initAction("buttonToggleTraits");
  Page.initAction("buttonToggleFeatureDependency");
  Page.initAction("buttonToggleTransitionLabels");
  Page.initAction("buttonToggleGuards");
  Page.initAction("buttonToggleGuardLabels");
  Page.initAction("buttonAllowPinch");
    
  Page.initLabels();

  Page.enablePaletteItem("buttonUndo", false);
  Page.enablePaletteItem("buttonRedo", false);
  Page.enablePaletteItem("buttonSyncDiagram", false);
  Page.enablePaletteItem("buttonAddTransition", false);

  jQuery("#genstatus").hide();
  jQuery("#buttonViewComplete").hide();
  
  Page.initExamples();
  Page.initOptions();
  if(Page.readOnly) {
    jQuery("#mainDrawMenu").hide();
    jQuery(".layoutListItem").hide();
    jQuery("#preferencesTitle").hide();
    jQuery("#ttPhotoReady").hide();
    jQuery("#ttManualSync").hide();
    jQuery("#canvasSizeTitle").hide();
    jQuery("#buttonSmaller").hide();
    jQuery("#buttonLarger").hide();
    jQuery("#menuBookmarkable").hide();
  }
  if(Page.readOnly || !Layout.isPaletteVisible) {  
    jQuery("#topBookmarkable").hide();
  }
  if(!Layout.isPaletteVisible) {jQuery("#paletteColumn").hide();}
  if(!Layout.isTextVisible) {
    if(Page.readOnly) {
      jQuery("#topLine").hide(); 
    }
    else {
      jQuery("#linetext").hide();
    }
  }

  // Only show execute code button for the Java language
  jQuery("#inputGenerateCode").on('change', function() {
    if(this.value.split(":")[1] === 'Java' || this.value.split(":")[1] === 'Python') {
      jQuery("#buttonExecuteCode").show();
    } else {
      jQuery("#buttonExecuteCode").hide();
    }
  })
}

Page.initOptions = function()
{
  jQuery("#buttonShowHideLayoutEditor").prop('checked', Layout.isLayoutVisible);
  jQuery("#buttonShowHideTextEditor").prop('checked', Layout.isTextVisible);
  jQuery("#buttonShowHideCanvas").prop('checked', Layout.isDiagramVisible);
	jQuery("#buttonTabsCheckbox").prop('checked', false);
	jQuery("#tabRow").hide();
	jQuery("#ttTabsCheckbox").hide();
  jQuery("#buttonToggleAttributes").prop('checked',true);
  jQuery("#buttonToggleActions").prop('checked',true);
  jQuery("#buttonToggleTransitionLabels").prop('checked',false);
  jQuery("#buttonToggleGuards").prop('checked',true);  
  jQuery("#buttonToggleGuardLabels").prop('checked',false);
  jQuery("#buttonToggleTraits").prop('checked',Page.showTraits);
  jQuery("#buttonToggleFeatureDependency").prop('checked',false);
  jQuery("#buttonAllowPinch").prop('checked',false);
  
  if(Page.useEditableClassDiagram)
   jQuery("#buttonShowEditableClassDiagram").prop('checked', true);
  if(Page.useJointJSClassDiagram)
   jQuery("#buttonShowJointJSClassDiagram").prop('checked', true);
  if(Page.useGvClassDiagram)
    jQuery("#buttonShowGvClassDiagram").prop('checked', true);
  if(Page.useGvFeatureDiagram)
    jQuery("#buttonShowGvFeatureDiagram").prop('checked', true);

  if(Page.useGvStateDiagram)
    jQuery("#buttonShowGvStateDiagram").prop('checked', true);
  if(Page.useStructureDiagram)
    jQuery("#buttonShowStructureDiagram").prop('checked', true);

  jQuery("#buttonPhotoReady").prop('checked', false);
  jQuery("#buttonManualSync").prop('checked', false);
  
  jQuery("#buttonShowHideTextEditor").prop('disabled', false);
  jQuery("#buttonShowHideCanvas").prop('disabled', false);
  jQuery("#buttonPhotoReady").prop('disabled', false);
  jQuery("#buttonManualSync").prop('disabled', false);
}

Page.initHighlighter = function(id)
{
  var selector = "#" + id;
  jQuery(selector).mouseover(function() {Page.highlightItem(id);});
  jQuery(selector).mouseout(function() {Page.unhighlightItem(id);});
}

Page.removeHighlighter = function(id)
{
  var selector = "#" + id;
  
  jQuery(selector).unbind('mouseover');
  jQuery(selector).unbind('mouseout');
}

Page.enableCheckBoxItem = function(boxId, listItemId, doEnable)
{
  var listItem = jQuery("#" + listItemId);
  var checkbox = jQuery("#" + boxId);
  
  if (doEnable)
  {
    checkbox.prop('disabled', false);
    checkbox.css('cursor', 'pointer');
    listItem.css('color', 'Black');
    
  }
  else
  {
    checkbox.prop('disabled', true);
    checkbox.css('cursor', 'not-allowed');
    listItem.css('color', 'Silver');
  }
}

Page.enablePaletteItem = function(id, doEnable)
{
  var item = jQuery("#" + id);
  var enabled = !item.hasClass("disabled");
  
  if (enabled == doEnable) return;
  
  if (doEnable)
  {
    item.removeClass();
    item.prop('disabled', true);
    Page.initHighlighter(id);
  }
  else
  {
    item.removeClass();
    item.addClass("disabled");
    item.prop('disabled', false);
    Page.removeHighlighter(id);
  }
}

Page.initToggleTool = function(id)
{
  var item = jQuery("#" + id);
  item.unbind().click(function() {Page.toggleToolItem(id, false);});
  item.dblclick(function() {Page.toggleToolItem(id, true);});
}

Page.removeToggleTool = function(id)
{
  var item = jQuery("#" + id);
  item.unbind('click');
  item.unbind('dblclick');
}

Page.initJQueryButton = function(id)
{
  var selector = "#" + id;
  var value = jQuery(selector).attr("value");
  jQuery(selector).button({
    label: value,
    className: "jQuery-palette-button"
  });
}

Page.initAction = function(id)
{
  var selector = "#" + id;
  jQuery(selector).click(Action.clicked);
}

// Binds the label text on buttons to the button action
// Allows the user to click the label or the actual button
Page.initLabels = function()
{
  var labels = jQuery(".buttonExtend");
  
  for(var i = 0, len = labels.length; i < len; i++)
  {
    Page.initLabel(jQuery(labels[i]).prop("id") );
  }
}

Page.initLabel = function(id)
{
  var labelId = "#" + id;
  jQuery(labelId).click(function(x) {
    return function() {
      jQuery("#" + jQuery(x).prop("id").replace("label", "button")).trigger('click');
    }
  }(labelId));  
}

// BOOKMARK: adding basic event handlers to model and layout editors:: calls to Action...
Page.initUmpleTextArea = function()
{
  var modelEditor = jQuery("#newEditor");
  var layoutEditor = jQuery("#umpleLayoutEditorText");
  
  modelEditor.keyup(function(eventObject){
    Action.freshLoad = false;
    Action.umpleTyped(eventObject);
  });
  modelEditor.mousedown(function(){setTimeout("jQuery(\"#linenum\").val(Action.getCaretPosition())",25)});
  layoutEditor.keyup(function(eventObject){
    Action.freshLoad = false;
    Action.setjustUpdateNowtoSaveLater(false);
    Action.umpleCodeMirrorTypingActivity("layoutEditor");
  }); // Fixes Issue#1571 Editing on the layout editor will not update the Umple diagram
  modelEditor.focusin(function(){Action.focusOn("umpleModelEditorText", true);});
  layoutEditor.focus(function(){Action.focusOn("umpleLayoutEditorText", true);});
  modelEditor.focusout(function(){Action.focusOn("umpleModelEditorText", false);});
  layoutEditor.blur(function(){Action.focusOn("umpleLayoutEditorText", false);});
  
  Page.initCodeMirrorEditor();
  Layout.initUmpleTextAreaSize();
  if (!Layout.isTextVisible) {Layout.showHideTextEditor(false);}
  if (!Layout.isLayoutVisible) {Layout.showHideLayoutEditor(false);}
}

/* codemirror 6 */
Page.initCodeMirrorEditor = function() {
  const extraKeys = [
    { key: "Ctrl-E", run: function() { Page.clickShowEditableClassDiagram() } },
    { key: "Ctrl-J", run: function() { Page.clickShowJointJSClassDiagram() } },
    { key: "Ctrl-G", run: function() { Page.clickShowGvClassDiagram() } },
    { key: "Ctrl-S", run: function() { Page.clickShowGvStateDiagram() } },
    { key: "Ctrl-L", run: function() { Page.clickShowStructureDiagram() } },
    { key: "Ctrl-T", run: function() { Page.clickShowHideText() } },
    { key: "Shift-Ctrl-Alt-T", run: function() { Page.clickShowHideText() } },
    { key: "Ctrl-D", run: function() { Page.clickShowHideCanvas() } },
    { key: "Ctrl-N", run: function() { Page.clickShowHideMenu() } },
    { key: "trl-Alt-N", run: function() { Page.clickShowHideMenu() } },
    { key: "Ctrl-Shift-=", run: function() { Page.clickButtonlarger() } },
    { key: "Ctrl-Shift--", run: function() { Page.clickButtonSmaller() } },
    { key: "Shift-Ctrl-A", run: function() { Page.clickToggleAttributes() } },
    { key: "Ctrl-M", run: function() { Page.clickToggleMethods() } },
    { key: "Ctrl-R", run: function() { Page.clickToggleTraits() } },
    { key: "Ctrl-I", run: function() { Page.clickToggleTransitionLabels() } },
    { key: "Ctrl-K", run: function() { Page.clickToggleGuardLabels() } },
    { key: "Ctrl-O", run: function() { Page.copyCommandLineCode() } },
    { key: "Ctrl-B", run: function() { Page.promptAndExecuteTest() } },
    { key: "Esc", run: function(cm6) { cm6.getInputField().blur() } },
  ]
    
  // codemirror 6 
  // comment the following when trying to mount react app
  const initialState = cm6.createEditorState(
    document.getElementById("newEditor").value, 
     {
       extensions: []
     });

  Page.codeMirrorEditor6 = cm6.createEditorView(
    initialState, document.getElementById("newEditor"));

  // adds changeListenerPlugin to the code editor
  // to listen to code changes happening in it
  // either due to collaborative editing or normal editing
  // without triggering any keyboard/mouse events
  Page.codeMirrorEditor6.dispatch({
    effects: cm6.StateEffect.appendConfig.of(cm6.changeListenerPlugin)
  });

  if (Page.readOnly) {
            Page.codeMirrorEditor6.dispatch({
          effects: cm6.editableCompartment.reconfigure(cm6.EditorView.editable.of(false))
      });
  }
      
  // Sets the codemirror 6 text without any change trigger (hopefully)
  Page.setCodeMirror6Text = function (textToSet) {
    Page.codeMirrorEditor6.dispatch({ 
      changes: { 
        from: 0, 
        to: Page.codeMirrorEditor6.state.doc.length, 
        insert: textToSet
        }
    } )
  }

   Page.codeMirrorEditor6.dom.addEventListener('mousedown', function () {
    Action.umpleCodeMirrorCursorActivity();
   });

  Page.codeMirrorOn = true;  
}

// Function to make the E G S icons in UmpleOnline context senstive (#1400)
Page.setDiagramTypeIconState = function(diagramType){
  buttonList = ['ECD_button','GCD_button','SD_button'];
  for (i = 0, l = buttonList.length; i<l;++i){
    document.getElementById(buttonList[i]).className = "button2";
  }
  switch(diagramType){
    case 'editableClass':
    document.getElementById('ECD_button').className = "button2 active";
    break;
    case 'GvClass':
    document.getElementById('GCD_button').className = "button2 active";
    break;
    case 'GvState':
    document.getElementById('SD_button').className = "button2 active";
    break;
  }
}

// Function to make the T D A M icons in UmpleOnline context senstive (#1400)
Page.setShowHideIconState = function(selectedButton){
  switch(selectedButton){
    case 'SHT_button':
      if(Page.showText){
        document.getElementById(selectedButton).className = "button2 active";
      } else {
        document.getElementById(selectedButton).className = "button2";
      }
      break;
    case 'SHD_button':
      if(Page.showCanvas){
        document.getElementById(selectedButton).className = "button2 active";
      } else {
        document.getElementById(selectedButton).className = "button2";
      }
      break;
    case 'SHA_button':
      if(Page.showAttributes){
        document.getElementById(selectedButton).className = "button2 active";
      } else {
        document.getElementById(selectedButton).className = "button2";
      }
      break;
    case 'SHM_button':
      if(Page.showMethods){
        document.getElementById(selectedButton).className = "button2 active";
      } else {
        document.getElementById(selectedButton).className = "button2";
      }
      break;
  }
}

// Functions to click various menu items - invoked by code mirror and MouseTrap
Page.clickShowEditableClassDiagram = function() {
  jQuery('#buttonShowEditableClassDiagram').trigger('click');
}
Page.clickShowJointJSClassDiagram = function() {
  jQuery('#buttonShowJointJSClassDiagram').trigger('click');
}
Page.clickShowGvClassDiagram = function() {
  jQuery('#buttonShowGvClassDiagram').trigger('click');
}
Page.clickShowGvStateDiagram = function() {
  jQuery('#buttonShowGvStateDiagram').trigger('click');
}
Page.clickShowGvFeatureDiagram = function() {
  jQuery('#buttonShowGvFeatureDiagram').trigger('click');
}
Page.clickShowStructureDiagram = function() {
  jQuery('#buttonShowStructureDiagram').trigger('click');
}
Page.clickShowHideText = function() {
  jQuery('#buttonShowHideTextEditor').trigger('click');
}
Page.clickShowHideCanvas = function() {
  jQuery('#buttonShowHideCanvas').trigger('click');
}
Page.clickShowHideMenu = function() {
  Layout.showHideMenu(); // No clickable button
}

Page.clickButtonlarger = function() {
  jQuery('#buttonLarger').trigger('click');
}
Page.clickButtonSmaller = function() {
  jQuery('#buttonSmaller').trigger('click');
}
Page.clickToggleAttributes = function() {
  jQuery('#buttonToggleAttributes').trigger('click');
}
Page.clickToggleMethods = function() {
  jQuery('#buttonToggleMethods').trigger('click');
}
Page.clickToggleTraits = function() {
  jQuery('#buttonToggleTraits').trigger('click');
}
Page.clickToggleFeatureDependency= function() {
  jQuery('#buttonToggleFeatureDependency').trigger('click');
}
Page.clickToggleTransitionLabels = function() {
  jQuery('#buttonToggleTransitionLabels').trigger('click');
}
Page.clickToggleGuardLabels = function() {
  jQuery('#buttonToggleGuards').trigger('click');
}
Page.clickToggleGuardLabels = function() {
  jQuery('#buttonToggleGuardLabels').trigger('click');
}

Page.clickAllowPinch = function() {
  jQuery('#buttonAllowPinch').trigger('click');
}


Page.isPhotoReady = function()
{
  if(Page.readOnly) {
    return(true)
  }
  else {
    var selector = "#buttonPhotoReady";
    return jQuery(selector).prop('checked');
  }
}

Page.initSourceCodeArea = function()
{
  SyntaxHighlighter.config.clipboardSwf = 'scripts/clipboard.swf';
  var generatedCodeRowSelector = "#generatedCodeRow";
  jQuery(generatedCodeRowSelector).hide();
}

Page.initCodeExecutionArea = function()
{
  var executionAreaSelector = "#codeExecutionArea";
  jQuery(executionAreaSelector).hide();
}

Page.showExecutionArea = function()
{
  var executionAreaSelector = "#codeExecutionArea";
  jQuery(executionAreaSelector).show();
}

Page.hideExecutionArea = function()
{
  var executionAreaSelector = "#codeExecutionArea";
  jQuery(executionAreaSelector).hide();
}

Page.hideGeneratedCode = function()
{
  jQuery("#generatedCodeRow").hide();
  jQuery("#innerGeneratedCodeRow").hide();
  if(!Page.useStructureDiagram) jQuery("#svgCanvas").hide();
}

Page.hideGeneratedCodeOnly = function() {
  jQuery("#generatedCodeRow").hide();
  jQuery("#innerGeneratedCodeRow").hide();
}

Page.initCanvasArea = function()
{
  var canvas = jQuery("#umpleCanvas");
  Layout.initUmpleCanvasSize();
  
  canvas.click(function(event){Action.umpleCanvasClicked(event);});
  canvas.mousemove(Action.mouseMove);
  canvas.focus(function(){Action.focusOn(Page.umpleCanvasId(), true);});
  canvas.blur(function(){Action.focusOn(Page.umpleCanvasId(), false);});
  canvas.delegate("[class$='editableDoubleClick']", 'dblclick', InlineEditor.handleOnClick);
  canvas.delegate("[class$='editableSingleClick']", 'click', InlineEditor.handleOnClick);

  if (!Layout.isDiagramVisible) {Layout.showHideCanvas(false);}
}
//The purpose of this function is make sure the URL example argument selects the appropriate dropdown example
Page.setExamples = function(ex)
{
  var exValue = ex+".ump"
  jQuery("#inputExample").change(Action.loadExample);
  jQuery("#inputExample option").each(function(){
    if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample option[value = \""+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )
 
  jQuery("#inputExampleType").change(Action.setExampleType);

  jQuery("#inputExample2").change(Action.loadExample);
  jQuery("#inputExample2 option").each(function(){
     if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample2 option[value = \""+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )
  
  jQuery("#inputExample3").change(Action.loadExample);
  jQuery("#inputExample3 option").each(function(){
    if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample3 option[value = \""+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )
 
  jQuery("#inputExample4").change(Action.loadExample);
  jQuery("#inputExample4 option").each(function(){
    if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample4 option[value = \""+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )

  // TODO the following does not yet properly work to open the files from the command line
  // DEBUG
  jQuery("#inputExample5").change(Action.loadExample);
  jQuery("#inputExample5 option").each(function(){
    if (this.value==exValue || 
      (this.value.startsWith("http") && this.value.endsWith(exValue))){
      jQuery("#inputExample5 option[value = \"extraExamples1/"+exValue  +"\"]").attr("selected", true);
      return ;
    }
   }
  )
}
Page.initExamples = function()
{
 
  jQuery("#inputExample").change(Action.loadExample);
  jQuery("#defaultExampleOption").attr("selected",true);
 
  jQuery("#inputExampleType").change(Action.setExampleType);

  jQuery("#inputExample2").change(Action.loadExample);
  jQuery("#defaultExampleOption2").attr("selected",true);

  jQuery("#inputExample3").change(Action.loadExample);
  jQuery("#defaultExampleOption3").attr("selected",true);

  jQuery("#inputExample4").change(Action.loadExample);
  jQuery("#defaultExampleOption4").attr("selected",true);

  jQuery("#inputExample5").change(Action.loadExample);
  jQuery("#defaultExampleOption5").attr("selected",true);

  jQuery("#inputExample6").change(Action.loadExample);
  jQuery("#defaultExampleOption6").attr("selected",true);

  jQuery("#inputExample7").change(Action.loadExample);
  jQuery("#defaultExampleOption7").attr("selected",true);

  jQuery("#inputExample8").change(Action.loadExample);
  jQuery("#defaultExampleOption8").attr("selected",true);


  if (Page.useStructureDiagram) {
    jQuery("#structureModels").prop("selected",true);
    jQuery("#itemLoadExamples").hide();
    jQuery("#itemLoadExamples2").hide();
    jQuery("#itemLoadExamples4").hide();      
    jQuery("#itemLoadExamples5").hide();   
    jQuery("#itemLoadExamples6").hide();   
    jQuery("#itemLoadExamples7").hide();   
    jQuery("#itemLoadExamples8").hide();   

  }
  else if (Page.useGvStateDiagram) {
    jQuery("#smModels").prop("selected",true);
    jQuery("#itemLoadExamples").hide();
    jQuery("#itemLoadExamples3").hide();
    jQuery("#itemLoadExamples4").hide();
    jQuery("#itemLoadExamples5").hide();
    jQuery("#itemLoadExamples6").hide();   
    jQuery("#itemLoadExamples7").hide();   
    jQuery("#itemLoadExamples8").hide();   

  }
 else if (Page.useGvFeatureDiagram) {
    jQuery("#featureModels").prop("selected",true);
    jQuery("#itemLoadExamples").hide();
    jQuery("#itemLoadExamples2").hide();
    jQuery("#itemLoadExamples3").hide();
    jQuery("#itemLoadExamples5").hide();
    jQuery("#itemLoadExamples6").hide();   
    jQuery("#itemLoadExamples7").hide();   
    jQuery("#itemLoadExamples8").hide();   

  }
  else {
    // TODO any examples loaded on initialization without a 
    // URL argument will choose class diagrams
    // Therefore for new example sets 5-8, we will need to change this logic
    // to determine which set to hide
    jQuery("#cdModels").prop("selected",true); 
    jQuery("#itemLoadExamples2").hide();
    jQuery("#itemLoadExamples3").hide(); 
    jQuery("#itemLoadExamples4").hide();
    jQuery("#itemLoadExamples5").hide();
    jQuery("#itemLoadExamples6").hide();   
    jQuery("#itemLoadExamples7").hide();   
    jQuery("#itemLoadExamples8").hide();   

  }  
}


Page.highlightItem = function(id)
{
  var selector = "#" + id;
  jQuery(selector).addClass("highlight");
}

Page.unhighlightItem = function(id)
{
  var selector = "#" + id;
  jQuery(selector).removeClass("highlight");
}

Page.enableDiagram = function(doEnable)
{
  Page.enableEditDragAndResize(doEnable);
  Page.enablePaletteItem("buttonAddClass", doEnable);
  Page.enablePaletteItem("buttonAddAssociation", doEnable);
  Page.enablePaletteItem("buttonAddGeneralization", doEnable);
  Page.enablePaletteItem("buttonDeleteEntity", doEnable);
  Page.showDiagramSyncNeeded(!doEnable);
}
Page.enableTransition = function(doEnable)
{
    Page.enablePaletteItem("buttonAddTransition", doEnable);
    Page.enablePaletteItem("buttonAddAssociation", !doEnable);
}

Page.enableEditDragAndResize = function(doEnable)
{
  if (doEnable)
  {
    jQuery("span.editable").removeClass("uneditable");
    jQuery("div.umpleClass").removeClass("unselectable");
    jQuery("div.umpleClass.ui-draggable").draggable({disabled: false});
  } 
  else
  {
    jQuery("span.editable").addClass("uneditable");
    jQuery("div.umpleClass").addClass("unselectable");
    jQuery("div.umpleClass.ui-draggable").draggable({disabled: true});
    jQuery(':text').blur()

  }
}

Page.toggleToolItem = function(id, doubleClicked)
{
  if (doubleClicked == undefined) doubleClicked = false;
  Page.repeatToolItem = doubleClicked;
  
  var toolSelected = id.substring(6);
  var isNewTool = (toolSelected != Page.selectedItem);
  
  if (isNewTool)
  {
    Page.selectToggleTool(toolSelected);
  }
  else
  {
    Page.unselectAllToggleTools();
  }
}

Page.unselectAllToggleTools = function()
{
  var unselected = false;
  var temp = false;

  temp = DiagramEdit.removeNewClass();
  if(temp) unselected = true;
  temp = DiagramEdit.removeNewAssociation();
  if(temp) unselected = true;
  temp = DiagramEdit.removeNewTransition();
  if(temp) unselected = true;
  temp = DiagramEdit.removeNewGeneralization();
  if(temp) unselected = true;
  
  var allSelectedItems = "ul.toggle li.selected"; 
  jQuery(allSelectedItems).removeClass("selected highlight");
  
  setTimeout("Page.enableEditDragAndResize(true);", 500);
  Page.selectedItem = null;
  Page.repeatToolItem = false;

  return unselected;
}

Page.selectToggleTool = function(toolSelected)
{
  if (Page.selectedItem != null)
  {
    DiagramEdit.removeNewClass();
    DiagramEdit.removeNewAssociation();
    DiagramEdit.removeNewTransition();
    DiagramEdit.removeNewGeneralization();
  }
  
  Page.enableEditDragAndResize(false);
  Page.selectedItem = toolSelected;
  Action.unselectAll();
  
  var allSelectedItems = format("ul.toggle li.selected");
  var newSelectedItem = "#button" + toolSelected;
  jQuery(allSelectedItems).removeClass("selected highlight");
  jQuery(newSelectedItem).addClass("selected");
}

Page.canShowHovers = function()
{
  return Page.selectedItem == null || Page.selectedItem == "DeleteEntity";
}

Page.getRawUmpleCode = function()
{
  return document.getElementById('umpleModelEditorText').value;
}

// CM6 function corresponding to CM5 Page.getRawUmpleCode()
Page.getRawUmpleCodeCM6 = function()
{
  return Page.codeMirrorEditor6.state.doc.toString();
}

Page.getUmpleCode = function()
{
  // DEBUG
  // console.log("Inside Page.getUmpleCode ...")
  var modelCleaned = Page.getRawUmpleCodeCM6().replace(Page.modelDelimiter, "");
  var positioning = jQuery("#umpleLayoutEditorText").val().replace(Page.modelDelimiter, "");
  if(positioning !== "" && !positioning.includes("namespace -;")){
   // prepend namespace cancellation to prevent namespace redefinition errors
    positioning = "\n\nnamespace -;\n"+positioning;
  }
  var umpleCode = modelCleaned + Page.modelDelimiter + positioning;
  return umpleCode;
}

Page.getEncodedURL = function()
{
  var server=window.location.href.split("?")[0];
  if(server.substr(0,37)=="https://cruise.umple.org/umpleonline/") {
    server = "http://try.umple.org/";
  }
  return server+"?text=" + encodeURIComponent(Page.getUmpleCode());
}

Page.splitUmpleCode = function(umpleCode)
{
  // DEBUG
  // console.log("Inside Page.splitUmpleCode ...")

  var splitIndex = umpleCode.indexOf(Page.modelDelimiter);
  if (splitIndex == -1)
  {
    model = umpleCode;
    positioning = "";
  }
  else
  {
    umpleCode = umpleCode.replace(Page.modelDelimiter, "");
  
    var model = umpleCode.substr(0, splitIndex);
    var positioning = umpleCode.substr(splitIndex, umpleCode.length);
  }
  var modelAndPositioning = [model, positioning];
  return modelAndPositioning;
}  

// Takes as an argument the full file with core code and layout info
// Called by fuunctions such as loadExampeCallback and loadFileCallback
// Also called by updateUmpleTextCallback which is triggered by diagram edit by directUpdateCommandCallback  
// Updates all text editors, and then can call a function called reason
Page.setUmpleCode = function(umpleCode, reason)
{
  // DEBUG
  // console.log("Inside Page.setUmpleCode() ...")
  var modelAndPositioning = Page.splitUmpleCode(umpleCode);

  // Update the layout editor with the second part of the combined file
  // console.log("Setting positioningCode into umpleLayoutEditorText html element ...")
  jQuery("#umpleLayoutEditorText").val(modelAndPositioning[1]);

  if(Page.codeMirrorOn) {
    // issue#1409  Do not Set the umple code if codeChange is false(i.e. reason is false)
    if (!((typeof reason === 'boolean') && reason == false))
    {
      Page.setCodeMirror6Text(modelAndPositioning[0]);
    }
  }
  // Refactoring definitive text location
  // Update Codemirror 6 and the backup variable
  // console.log("Setting modelCode to codeMirror 6 ...")
  Action.updateCurrentUmpleTextBeingEdited(modelAndPositioning[0]);

  if (typeof reason === 'function'){
    reason();
  }
}

Page.setUmplePositioningCode = function(positioning)
{
  jQuery("#umpleLayoutEditorText").val(positioning);
}

Page.umpleCanvasId = function()
{
  return "umpleCanvas";
}

// Page.createBookmark() is called when Save & Collaborate button is clicked in umpleonline ui
// this method internally calls Page.connectCollabServer() which connects the current client to the UmpleCollabServer
// and enables the current users to collaborate by sharing the collaborative URL
Page.createBookmark = function()
{
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  window.location.href = "bookmark.php?model=" + Page.getModel();
}

// same as Page.createBookmark()
// but creates a new temporary copy of the bookmarked model
// useful when collaborating and the user wants to work
// independently on their own version
Page.createBookmarkFork = function()
{
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  window.location.href = "bookmark.php?model=" + Page.getModel() + "&forkSoMakeTmpOnly";
}

Page.createTask = function()
{
  var taskName = jQuery("#taskName").val();
  let patt = /^(\w|\.)+$/; // taskName Take only [ A-Z or a-z or 0-9 or _ or . ]
  if (!patt.test(taskName))//taskName.indexOf(" ") != -1 || taskName.indexOf("/") != -1 || taskName.indexOf("-") != -1 || taskName.indexOf("\\") != -1) 
  {
    window.alert("Task Name can only contain letters(case insensitive), underscores, dots, and digits!");
    return;
  }
  var requestorName = jQuery("#requestorName").val();
  var instructions = jQuery("#instructions");
  var completionURL = jQuery("#completionURL").val();
  var isExperiment = jQuery("#isExperiment").is(':checked');
  // jQuery("#labelInstructions").hide();
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  Ajax.sendRequest("task.php",Page.createTaskCallback,format("taskName={0}&instructions={1}&model={2}&requestorName={3}&completionURL={4}&isExperiment={5}", 
    taskName, instructions.val(), Page.getModel(), requestorName, completionURL, isExperiment));
}


Page.createTaskCallback = function(response)
{
  if (response.responseText.split(" ")[0] == "Task")
  {
    window.alert("Not able to create a task with that name. " + response.responseText);
  }
  else 
  {
    window.location.href = "umple.php?task=1&model=" + response.responseText;
  }
}

Page.editTask = function()
{
  var instructions = jQuery("#instructions");
  var taskName = jQuery("#model").val().split("-")[1];
  var requestorName = jQuery("#requestorName").val();
  var completionURL = jQuery("#completionURL").val();
  var isExperiment = jQuery("#isExperiment").is(':checked');
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  Ajax.sendRequest("task.php", Page.editTaskCallback, "edit=1&taskName=" + taskName + "&instructions=" + instructions.val() + "&model=" 
    + Page.getModel() + "&requestorName=" + requestorName + "&completionURL=" + completionURL + "&isExperiment=" + isExperiment);
  //window.location.href = "task.php?edit=1&taskName=" + taskName + "&instructions=" + instructions.val() + "&model=" + Page.getModel() + "&requestorName=" + requestorName;
  //window.alert("Successfully edit Task " + taskName + "!");
}

Page.editTaskCallback = function(response)
{
  Page.setFeedbackMessage('Changes saved');
}

Page.cancelTaskResponse = function()
{
  var answer = confirm("Are you sure to cancel this task response?");
  if (answer)
  {
    window.location.href = "task.php?cancelTaskResponse=1&model=" + Page.getModel();
  }
}
Page.hideTask = function(){
    jQuery("#taskArea").css("display","none");
    jQuery("#labelTaskName").css("display","none");
    jQuery("#taskNameCell").css("display","none");
    jQuery("#instructions").css("display","none");
    jQuery("#isExperimentCell").css("display","none");
    jQuery("#isExperiment").attr("checked", false);
    Layout.zoomResize();
}
Page.cancelTask = function(){
   
   if (jQuery("#completionURL").val()!='' || jQuery("#taskName").val()!='' || jQuery("#requestorName").val()!='' || jQuery("#instructions").val()!=''){

    var answer = confirm ("Are you sure you want to end the task creation process?");
	
    if (answer){
    jQuery("#taskName").val('');
    jQuery("#requestorName").val('');
    jQuery("#completionURL").val('');
    jQuery("#instructions").val('');
    Page.hideTask();
    }
    }
    else{ Page.hideTask();}
}

Page.endTaskEdit = function() {
  
    var answer = confirm ("Are you sure you want to end the task editing process?");
    if (answer){
    	Page.hideTask();
    }
  
}

Page.toggleTabs = function()
{
  TabControl.isHidden()? TabControl.showTabs() : TabControl.hideTabs();
  Layout.layoutHandler.adjustAfterWindowResize();
}

Page.showDiagramSyncNeeded = function(doShow)
{
  var canvas = jQuery("#umpleCanvas");
  var messageDiv =  '<div id="syncNeededMessage" class="syncNeededMessage unselectable">' +
              'Diagram is out of synchronization with the text due to selecting Manual Sync or an error in the text that has caused the compiler to produce no output. ' +
            '</div>';
  if (doShow && !Page.diagramSyncNeededAppend)
  {
    canvas.append(messageDiv);
    Page.diagramSyncNeededAppend = true;
    Page.readOnly = true;
    UmpleSystem.redrawCanvas();
  }
  else if(!doShow && Page.diagramSyncNeededAppend)
  {
    jQuery("#syncNeededMessage").remove();
    Page.diagramSyncNeededAppend = false;
    Page.readOnly = false;
    UmpleSystem.redrawCanvas();
  }
  
}

Page.hideLoading = function()
{
  // change to code mirror 6
  // var modelEditor = "#topTextEditor";
  var modelEditor = "#newEditor";
  var layoutEditor = "#bottomTextEditor";
  var canvas = "#" + Page.umpleCanvasId();  

  if(Page.modelLoadingCount > 0) Page.modelLoadingCount--;
  if(Page.layoutLoadingCount > 0) Page.layoutLoadingCount--;
  if(Page.canvasLoadingCount > 0) Page.canvasLoadingCount--;

  if(Page.modelLoadingCount === 0) jQuery(modelEditor).hideLoading();
  if(Page.layoutLoadingCount === 0) jQuery(layoutEditor).hideLoading();
  if(Page.canvasLoadingCount === 0) jQuery(canvas).hideLoading();
  
  if(Page.modelLoadingCount === 0 
    && Page.layoutLoadingCount === 0 
    && Page.canvasLoadingCount === 0)
  {
    jQuery(".bookmarkableUrl").removeClass("disabled");
  }
}

Page.showModelLoading = function()
{
  // change to code mirror 6
  var modelEditor = jQuery("#newEditor");

  if(Page.modelLoadingCount == 0)
  {
    if (jQuery("#textEditorColumn").is(":visible"))
    {
      modelEditor.showLoading();
    }
    jQuery(".bookmarkableUrl").addClass("disabled");
  }

  Page.modelLoadingCount++;
}

Page.showLayoutLoading = function()
{
  var layoutEditor = jQuery("#bottomTextEditor");
  
  if(Page.layoutLoadingCount == 0)
  {
    jQuery(".bookmarkableUrl").addClass("disabled");
    if (layoutEditor.is(":visible")) 
    {
      layoutEditor.showLoading();
    }
  }

  Page.layoutLoadingCount++;
}

Page.showCanvasLoading = function()
{
  // console.log("Inside Page.showCanvasLoading() ...")

  var canvas = jQuery("#umpleCanvas");
  if(Page.canvasLoadingCount == 0)
  {
    jQuery(".bookmarkableUrl").addClass("disabled");
    if (canvas.is(":visible"))
    {
      canvas.showLoading();
    }
  }
  
  Page.canvasLoadingCount++;
}

Page.resetCanvasSize = function()
{
  Page.setUmpleCanvasSize(Layout.minCanvasSize.width, Layout.minCanvasSize.height);
}


Page.getSelectedExample = function()
{
  var inputExample = "";
  var theExampleType = Page.getExampleType();

  // store the menu id of the example set as there will be more than one for class diagrams
  var exampleSet = theExampleType;

  // The default model type comes from the first 4 menu items created in umple.php
  // But as we add additional special sets of examples, we need to define the exampleType
  if(theExampleType.substring(0,5) == "extra") {
    theExampleType = "cdModels";
  }

  if(theExampleType == "cdModels") {
    // Jan 2025 change to ensure class diagrams by default use GvClass.
    var requiresGvClass = true; // Some class diagrams  are too complex to edit

    var exampleSetIDToLoad = "inputExample";
    if (exampleSet == "extra1ModelsAD") {
      exampleSetIDToLoad = "inputExample5";
      requiresGvClass = true; // All these examples are too complex for E mode
    }
    else if (exampleSet == "extra1ModelsEL") {
      exampleSetIDToLoad = "inputExample6";
      requiresGvClass = true; // All these examples are too complex for E mode
    }
    else if (exampleSet == "extra1ModelsMP") {
      exampleSetIDToLoad = "inputExample7";
      requiresGvClass = true; // All these examples are too complex for E mode
    }
    else if (exampleSet == "extra1ModelsQZ") {
      exampleSetIDToLoad = "inputExample8";
      requiresGvClass = true; // All these examples are too complex for E mode
    }

    inputExample = jQuery("#"+exampleSetIDToLoad+" option:selected").val();

    // Override special case to use G mode where E mode is too complex
    // Commented out when making G mode default
    // TODO: Consider tagging the examples by mode in umple.php rather than here
    // if (inputExample == "GeometricSystem.ump") {
    //  requiresGvClass = true;
    // }

    if(requiresGvClass) {
      // if diagram type not a editable class diagram, set it 
      if(!Page.useGvClassDiagram) {
        jQuery("#buttonShowGvClassDiagram").attr('checked', true); 
        Action.changeDiagramType({type: "GvClass"});
      }
    }
    else {
      // if diagram type not a class diagram, set it to a class diagram
      if(!(Page.useEditableClassDiagram || Page.useGvClassDiagram)) {
        jQuery("#buttonShowEditableClassDiagram").attr('checked', true); 
        Action.changeDiagramType({type: "editableClass"});
      }
    }
  }
  else if (theExampleType == "featureModels")
    {
       inputExample = jQuery("#inputExample4 option:selected").val(); 
     //  if (inputExample == "BerkeleyDB_SP_featureDepend.ump")
     //  this.showFeatureDependency = true;
       if( !Page.useGvFeatureDiagram) {
         jQuery("#buttonShowGvFeatureDiagram").attr('checked', true); 
         Action.changeDiagramType({type: "GvFeature"});
      }
    
    }
  else {

    if(theExampleType == "smModels") {
      inputExample = jQuery("#inputExample2 option:selected").val();
      // if diagram type is not a state machine, set to state machine
      if( !Page.useGvStateDiagram && !Page.useJointJSClassDiagram) {
         jQuery("#buttonShowGvStateDiagram").attr('checked', true); 
         Action.changeDiagramType({type: "GvState"});
      }
    }
    else {
      inputExample = jQuery("#inputExample3 option:selected").val();
      // if diagram type is not a structure diagram, set to structure diagram
      if( !Page.useStructureDiagram) {
         jQuery("#buttonShowStructureDiagram").attr('checked', true); 
         Action.changeDiagramType({type: "structure"});
      }    
    }
  }
  return inputExample;
}

Page.getExampleType = function()
{
  var exampleType = jQuery("#exampleType option:selected").val();
  return exampleType;
}

Page.showCodeDone = function()
{
  var gcselector = "#genstatus";
  jQuery(gcselector).show();
  setTimeout(function() {jQuery(gcselector).hide();}, 2000);
}

Page.showViewDone = function()
{
  var selector = "#buttonViewComplete";
  jQuery(selector).dialog({closeOnEscape:true, hide:'puff', height:100, width:250});
  setTimeout(function() {jQuery(selector).dialog("close");}, 2000);
}

Page.showExecutedResponse = function(responseText) {
  jQuery("#executionMessage").html(responseText);
}

// In-memory storage for CRUD instances; no persistence or database
Page.crudData = { classes: {} };

// Lookup of class definitions (attributes) by class name for nested types
Page.crudClassDefs = {};

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
  var baseLower = isArray ? lower.replace(/\[\]/g, "") : lower; //removes [] from array
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
    var parts = [];
    for (var key in value) {
      if (!value.hasOwnProperty(key)) { continue; }
      var v = value[key];
      if (typeof v === "undefined" || v === null || v === "") { continue; }
      parts.push(key + "=" + v);
    }
    if (parts.length > 0) {
      return parts.join(", ");
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

// Sets up clickable class headers and hide underlying forms
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

    // Hides the raw form;
    $form.hide();
  });

  // Click handler: opens form dialog for chosen class
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

  // ----- Class array (class[]) element management -----

  // Add or update a element in a class-array 
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

Page.showGeneratedCode = function(code,language,tabnumber)
{
	// Default "tabnumber" parameter to null, ie. only output to the main codeblock
	if (typeof(tabnumber)==='undefined') tabnumber = "";

	Action.toggleTabsCheckbox(language);

  Page.applyGeneratedCodeAreaStyles(language);
  
  var errorMarkup = Page.getErrorMarkup(code, language);
  var generatedMarkup = Page.getGeneratedMarkup(code, language);

  //Set download link, any error or warning messages 
	if (tabnumber == "")
  {
    jQuery("#downloadArea").html(errorMarkup);
  } else {
    jQuery("#messageArea").html(errorMarkup);
  }

  //Set the generated content
  if(language == "java" || language == "php" || language == "cpp" 
    || language == "ruby" || language == "python" || language == "xml" || language == "sql" || language == "alloy" || language == "nusmv")
  {
		jQuery("#innerGeneratedCodeRow" + tabnumber).html(
			formatOnce('<pre class="brush: {1};">{0}</pre>',generatedMarkup,language)
		)
    SyntaxHighlighter.highlight("code");

		if(tabnumber == ""){
			// Remove all previous file codeblocks
			jQuery('#innerGeneratedCodeRow').nextAll().remove();
			// Clear tab row contents
			jQuery('#tabRow').html('');
			// Generate tabs
			Action.generateTabsCode(code);
			Action.toggleTabs();
		}
  }
  else if(language == "structureDiagram")
  {
    //render the structure diagram
    eval(generatedMarkup);

    //Add a download link to the top of the structure diagram
    //This onclick ensures the href is not followed
    var downloadLink = '<div id="diagramLinkContainer"></div>';
    errorMarkup = downloadLink + errorMarkup;

		if(errorMarkup != ""){
    	jQuery("#messageArea").html(errorMarkup);
		}
    Page.toggleStructureDiagramLink(false);
  }
  // Special handling for CRUD UI rendered from Json
  else if (language === "crudJson")
  {
    // generatedMarkup here is the raw JSON produced by JsonGenerator
    var jsonText = generatedMarkup;
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
  }
  else
  {
    jQuery("#innerGeneratedCodeRow" + tabnumber).html(generatedMarkup);
  }
}

Page.applyGeneratedCodeAreaStyles = function(language)
{
  var generatedArea = jQuery("#generatedCodeRow");
  generatedArea.show();
  jQuery("#innerGeneratedCodeRow").show();

  //Modify styles and show or hide containers depending on the content
  //Error message
  if(language == "diagramUpdate") 
  {
    generatedArea.removeClass('generatedCode');
    generatedArea.removeClass('generatedDiagram');
  }
  //One of the svg diagram types
  else if(language == "stateDiagram" || language == "classDiagram" || language == "structureDiagram")
  {
    generatedArea.removeClass('generatedCode');
    generatedArea.addClass('generatedDiagram');
    
    if(language == "structureDiagram")
    {
      //Add an svg container to hold the structure diagram
      jQuery("#innerGeneratedCodeRow").html('<svg id="generatedSVGCanvas"></svg>')
    }
  }
  //Generated code
  else
  {
    generatedArea.removeClass('generatedDiagram');
    generatedArea.addClass('generatedCode');
  }
}

// Pulls any error and warning markup from the response from code generation
Page.getErrorMarkup = function(code, language)
{
  var output = "";
  
  if(language == "classDiagram" || language == "stateDiagram")
  { // Covers Graphviz class and state diagrams
    output = code.split("<svg xmlns=")[0];
    output = output.replace(/&nbsp;\s*$/, "");
  }
  else if(language == "javadoc" || language == "yumlDiagram")
  { // Covers javadoc and YUML diagrams
    output = code.split("<iframe ")[0];
  }
  else if(language == "diagramUpdate")
  { // Covers simple right-hand side canvas updates
    output = code.replace(/<p>[\s\S]*/, "");
  }
  else
  {
    // Covers the rest of the generated languages
    // Don't assign error markup unless there was a split - see #1362
    var split = code.split("<p>URL_SPLIT");
    if (split.length > 1){
      output = split[0];
    }
  }

  return output;
}

// Removes any extraneous code from the generated code to display
Page.getGeneratedMarkup = function(code, language)
{
  var output = "";
  
  if(language == "classDiagram" || language == "stateDiagram")
  { // Covers Graphviz class and state diagrams
    output = code.split("<svg width=")[1];
    output = "<svg width=" + output;
    output = output.replace(/<\/svg>$/, "");
  }
  else if(language == "javadoc" || language == "yumlDiagram")
  { // Covers javadoc and YUML diagrams
    output = code.split("<iframe ")[1];
    output = "<iframe " + output;
  }
  else if(language == "diagramUpdate")
  { // Covers simple right-hand side canvas updates
    // No generated code to extract
  }
  else if(language == "structureDiagram") 
  {
    // Covers the structure diagram code
    output = code.split("<p>URL_SPLIT")[1];
    output = output.replace(/##CANVAS_ID##/g, "generatedSVGCanvas");
    // Converts html encoded special characters to plaintext
    output = jQuery("<div/>").html(output).text();
  }
  else
  {
    // Covers the rest of the generated languages
    // Assign to entire code block if non-splitting - see #1362
    var split = code.split("<p>URL_SPLIT");
    output = (split.length > 1) ? split[1] : code;
  }
  return output;
}

Page.toggleStructureDiagramLink = function(isGenerated, filename)
{
  linkContainer = jQuery("#diagramLinkContainer");

  if(isGenerated)
  {
    linkContainer.html(format("<a href='{0}' target='_blank' id='structureLink'>Download the SVG for the following</a>", filename))
    jQuery("#structureLink").on('click', function(event) 
    {
      Page.toggleStructureDiagramLink(false);
    });
  }
  else
  {
    linkContainer.html('<div id="buttonStructureLink" value="Generate SVG"></div>');
    Page.initJQueryButton("buttonStructureLink");
    Page.initAction("buttonStructureLink");
  }
}

Page.setFilename = function(filename)
{
  jQuery("#filename").val(filename);
}

Page.setFeedbackMessage = function(feedbackMessage)
{
  document.getElementById('feedbackMessage').innerHTML=feedbackMessage;
}

Page.setExampleMessage = function(exampleMessage)
{
  document.getElementById('exampleMessage').innerHTML=exampleMessage;
}

Page.getFeedbackMessage = function()
{
  return document.getElementById('feedbackMessage').innerHTML;
}

Page.catFeedbackMessage = function(feedbackMessage)
{
  var origMsg = document.getElementById('feedbackMessage').innerHTML;
  document.getElementById('feedbackMessage').innerHTML=origMsg+feedbackMessage;
}

Page.getFilename = function()
{
  return jQuery("#filename").val();
}

Page.getAdvancedMode = function()
{
  return document.getElementById("advancedMode").value;
}

Page.getModel = function()
{
  return jQuery("#model").val();
}

jQuery.fn.selectRange = function(start, end) {
  return this.each(function() 
  {
    if(this.setSelectionRange) 
    {
      this.focus();
      this.setSelectionRange(start, end);
    } 
    else if(this.createTextRange) 
    {
       var range = this.createTextRange();
       range.collapse(true);
       range.moveEnd('character', end);
       range.moveStart('character', start);
       range.select();
    }
  });
}

// checks if the uel of current page is bookmark or not
Page.isBookmarkURL = function() {
  const currentURL = window.location.href;
  const modelName = currentURL.substring(currentURL.indexOf("?model=") + 1) 
  if(currentURL.includes("model") && modelName.length!=0){
    return true;
  }
  return false;
}