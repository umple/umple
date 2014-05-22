// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions triggered by UI elements in UmpleOnline
// plus helper functions
// Actions associated with editing the graphical diagram are
// located in the umple_action_diagram.js file.
//
Action = new Object();
Action.waiting_time = 1500;
Action.oldTimeout = null;
Action.minCanvasSize = null;
Action.minEditorSize = null;
Action.elementClicked = false;
Action.canCreateByDrag = true;
Action.manualSync = false;
Action.diagramInSync = true;
Action.freshLoad = false;
Action.gentime = new Date().getTime();
Action.savedCanonical = "";

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
  else if (action == "classDiagram")
  {
    Action.generateCode("classDiagram","classDiagram");
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
  else if (action == "Larger")
  {
    Action.umpleCanvasResized(1);
  }
  else if (action == "Smaller")
  {
    Action.umpleCanvasResized(-1);
  }
  else if (action == "Copy")
  {
    Action.showCodeInSeparateWindow();
  }
  else if (action == "CopyEncodedURL")
  {
    Action.showEncodedURLCodeInSeparateWindow();
  }
  else if (action == "Undo")
  {
    Action.undo();
  }
  else if (action == "Redo")
  {
    Action.redo();
  }
  else if (action == "ShowHideTextEditor")
  {
    Action.showHideTextEditor();
  }
  else if (action == "ShowHideCanvas")
  {
    Action.showHideCanvas();
  }
  else if (action == "ShowEditableClassDiagram")
  {
    Action.changeDiagramType(1);
  }
  else if (action == "ShowGvClassDiagram")
  {
    Action.changeDiagramType(2);
  }
  else if (action == "ShowGvStateDiagram")
  {
    Action.changeDiagramType(3);
  }
  else if (action == "ShowHideLayoutEditor")
  {
    Action.showHideLayoutEditor();
  }
  else if (action == "ManualSync")
  {
    Action.enableManualSync();
  }
  else if (action == "SyncDiagram")
  {
    Action.processTyping("umpleModelEditor", true);
  }
  else if (action == "PhotoReady")
  {
    Action.photoReady();
  }
  else if (action == "ToggleAttributes")
  {
       Action.toggleAttributes();
  }
  else if (action == "ToggleMethods")
  {
       Action.toggleMethods();
  }
  else if (action == "ToggleActions")
  {
       Action.toggleActions();
  }
}

Action.focusOn = function(id, gained)
{
  var selector = "#" + id;
  var textEditor = (id == "umpleLayoutEditor" || id == "umpleModelEditor");
  
  if (gained) 
  {
    if (textEditor || !Page.isPhotoReady())
    {
      jQuery(selector).parent().addClass("focus");
      if (textEditor)
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
    if (textEditor)
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
  
  if (isUndo) afterHistoryChange = History.getPreviousVersion();
  else afterHistoryChange = History.getNextVersion();
  
  if (afterHistoryChange == History.noChange)
  {
    afterHistoryChange = "";
  }
  Action.freshLoad = true;
  Page.setUmpleCode(afterHistoryChange);
  if (!Action.manualSync) Action.updateUmpleDiagram();
}

// Initial load of a file (e.g. example or blank) at initialization
Action.loadFile = function()
{
  var filename = Page.getFilename();
  if (filename != "")
  {
    Ajax.sendRequest("scripts/compiler.php",Action.loadFileCallback,format("load=1&filename={0}",filename));
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
  History.save(response.responseText,"loadFileCallback");
  Page.setUmpleCode(response.responseText);
  if (!Action.manualSync) Action.updateUmpleDiagram();
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

Action.showHideLayoutEditor = function(doShow)
{
  var layoutEditor = jQuery("#umpleLayoutEditor");
  var modelEditor = jQuery("#umpleModelEditor");
  var newHeight = jQuery("#umpleCanvas").height();
   
  if (doShow == undefined) doShow = layoutEditor.is(":visible");
  
  if (doShow)  // warning: This works backwards to intuition
  {
    layoutEditor.hide();
    Action.adjustTextEditorHeight(newHeight);
  }
  else
  {
    layoutEditor.show();
    Action.adjustTextEditorHeight(newHeight);
  }
}

Action.showHideTextEditor = function(doShow)
{ 
  var textEditor = jQuery("#textEditorColumn");
  var layoutBox = jQuery("#buttonShowHideLayoutEditor");
  var layoutListItem = jQuery("#layoutListItem");
  var canvas = jQuery("#" + Page.umpleCanvasId());
  var canvasColumn = jQuery("#umpleCanvasColumn");
  var canvasVisible = canvasColumn.is(":visible");
  
  if (doShow == undefined) doShow = !textEditor.is(":visible"); 
    
  if (doShow)
  {
    textEditor.show();
    
    // canvas must be visible in order to change width
    // if hidden, show temporarily
    if (!canvasVisible) canvasColumn.show();
    canvas.width(Action.minCanvasSize.width);
    if (!canvasVisible) canvasColumn.hide();
    
    // disable the show/hide layout editor option
    layoutBox.attr('disabled', false);
    layoutBox.css('cursor', 'pointer');
    layoutListItem.css('color', 'Black');
    if(Page.readOnly) {
      jQuery("#topLine").show(); 
    }
    else {
      jQuery("#linetext").show();
    }
    Page.setUmpleCode(Page.getUmpleCode()); // force reset
  }
  else
  {
    canvas.width(canvas.width() + textEditor.width());
    textEditor.hide();
  layoutBox.attr('disabled', true);
  layoutBox.css('cursor', 'not-allowed');
  layoutListItem.css('color', 'DimGray');
  if(Page.readOnly) {
      jQuery("#topLine").hide(); 
    }
    else {
      jQuery("#linetext").hide();
    }
  }
}

Action.changeDiagramType = function(newDiagramType)
{
  var changedType = false;
  if(newDiagramType == 1) { // Editable
    if(Page.useEditableClassDiagram) return;
    Page.useEditableClassDiagram = true;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    changedType = true;
  }
  else   if(newDiagramType == 2) { // GV class
    if(Page.useGvClassDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useGvClassDiagram = true;
    Page.useGvStateDiagram = false;
    changedType = true;
  }
  else   if(newDiagramType == 3) { // GV state
    if(Page.useGvStateDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = true;
    changedType = true;
  }
  if (changedType) {
    // Page.setFeedbackMessage("DEBUG New Diagram type "+newDiagramType);
    UmpleSystem.merge(null);    // Clear the diagram
    var canvas = jQuery("#umpleCanvas");
    canvas.html("");
    Action.showHideCanvas(true);
  }
}

Action.showHideMenu = function(doShow)
{
  var menu = jQuery("#paletteColumn");

  if (doShow == undefined) doShow = !menu.is(":visible"); 
  if (doShow)
  {
    menu.show();
  }
  else
  {
    menu.hide();
  }
}

Action.showHideCanvas = function(doShow)
{ 
  var canvas = jQuery("#umpleCanvasColumn");
  
  if (doShow == undefined) doShow = !canvas.is(":visible"); 
  if (doShow)
  {
    canvas.show();
    Action.manualSync = jQuery("#buttonManualSync").attr('checked');
    jQuery("#buttonShowHideCanvas").attr('checked',true);
    
    if (!Action.manualSync) 
    {
      Action.updateUmpleDiagram();
      Action.diagramInSync = true;
      Page.enableDiagram(true);
    }
    if (Action.manualSync && !Action.diagramInSync) Page.enablePaletteItem('buttonSyncDiagram', true);
    if (!Action.manualSync || Action.diagramInSync)
    {
      Page.enableCheckBoxItem("buttonPhotoReady", "photoReadyListItem", true);
      Page.enableCheckBoxItem("buttonManualSync", "manualSyncListItem", true);

     Page.enablePaletteItem('buttonAddClass', true);
      Page.enablePaletteItem('buttonAddAssociation', true);
      Page.enablePaletteItem('buttonAddGeneralization', true);
      Page.enablePaletteItem('buttonDeleteEntity', true);
    
      Page.initToggleTool('buttonAddClass');
      Page.initToggleTool('buttonAddAssociation');
      Page.initToggleTool('buttonAddGeneralization');
      Page.initToggleTool('buttonDeleteEntity');
    }
  }
  else
  {
    canvas.hide();
    Action.manualSync = true;
    jQuery("#buttonShowHideCanvas").attr('checked',false);

  Page.enableCheckBoxItem("buttonPhotoReady", "photoReadyListItem", false);
    Page.enableCheckBoxItem("buttonManualSync", "manualSyncListItem", false);

    
  Page.enablePaletteItem('buttonAddClass', false);
    Page.enablePaletteItem('buttonAddAssociation', false);
    Page.enablePaletteItem('buttonAddGeneralization', false);
    Page.enablePaletteItem('buttonDeleteEntity', false);
  Page.enablePaletteItem('buttonSyncDiagram', false);

    Page.removeToggleTool('buttonAddClass');
    Page.removeToggleTool('buttonAddAssociation');
    Page.removeToggleTool('buttonAddGeneralization');
    Page.removeToggleTool('buttonDeleteEntity');
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

Action.showCodeInSeparateWindow = function()
{
  codeWindow = window.open("","UmpleCode","height=700, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
  codeWindow.document.write('<code><pre id="umpleCode">' + Page.getUmpleCode() + '</pre></code>');
  codeWindow.document.close();
}

Action.showEncodedURLCodeInSeparateWindow = function()
{
  codeWindow = window.open("","UmpleCode","height=500, width=400, left=100, top=100, location=no, status=no, scrollbars=yes");
  codeWindow.document.write('<code><pre id="umpleCode">' + Page.getEncodedURL() + '</pre></code>');
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

Action.mainApplicationHeightResizing = function(event, ui)
{
  var currentHeight = ui.size.height;
  
  Page.setUmpleCanvasSize(jQuery("#umpleCanvas").width(), currentHeight);
}

Action.umpleTextEditorResizing = function(event, ui)
{
  var currentWidth = ui.size.width;
  
  Page.setTextEditorWidth(currentWidth);
}

Action.umpleCanvasResizing = function(event, ui)
{
  var currentHeight = ui.size.height;
  var currentWidth = ui.size.width;
  
  Page.setUmpleCanvasSize(currentWidth, currentHeight);
}

Action.umpleCanvasResized = function(factor)
{ 
  canvasSelector = "#" + Page.umpleCanvasId();
  var currentHeight = jQuery(canvasSelector).height();
  var currentWidth = jQuery(canvasSelector).width();
  
  var inc = 100;
  var newHeight=currentHeight + 0.25*inc*factor;
  var newWidth=currentWidth + inc*factor;
  
  Page.setUmpleCanvasSize(newWidth,newHeight);
}

Action.adjustTextEditorHeight = function(height) 
{  
  if (jQuery("#buttonShowHideLayoutEditor").attr('checked'))
  {
    jQuery("#umpleModelEditor").height(height*0.7 + 3);
    if(Page.codeMirrorOn) {
       Page.resizeCodeMirrorEditor(height*0.7 + 3);
    }
    jQuery("#umpleLayoutEditor").height(height*0.3);
  }
  else
  {
    jQuery("#umpleModelEditor").height(height + 6);
    if(Page.codeMirrorOn) {
       Page.resizeCodeMirrorEditor(height + 6);
    }
  }
  jQuery("#umpleTextEditor").height(height + 6);
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
}

Action.classClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.focusOn("umpleCanvas", true);
  Action.focusOn("umpleModelEditor", false);

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

Action.associationClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.elementClicked = true;
  Action.unselectAll();
  
  var obj = event.currentTarget;
  Action.associationSelected(obj);
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

Action.generateCode = function(languageStyle,languageName)
{
  var generateCodeSelector = "#buttonGenerateCode";
  var actualLanguage = languageName;
  if (Page.getAdvancedMode() == 0 && (languageName == "Cpp" || languageName == "Sql"))
  {
    actualLanguage = "Experimental-"+languageName;
  }
  jQuery(generateCodeSelector).showLoading();
  Action.ajax(function(response) {Action.generateCodeCallback(response,languageStyle);},format("language={0}&languageStyle={1}",actualLanguage, languageStyle),"true");
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

Action.generateCodeCallback = function(response,language)
{
  Page.showGeneratedCode(response.responseText,language);
  Action.gentime = new Date().getTime();
  var generateCodeSelector = "#buttonGenerateCode";
  jQuery(generateCodeSelector).hideLoading();
  Page.showCodeDone();
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
  if (DiagramEdit.newGeneralization != null && Page.selectedItem == "AddGeneralization")
  {
    Action.drawGeneralizationLine(event, DiagramEdit.newGeneralization);
  }
}

Action.drawClassOutline = function(event, newClass)
{
  var canvasSelector = "#" + Page.umpleCanvasId();
  var screenPosition = new UmplePosition(event.pageX, event.pageY,0,0);
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
  var mousePosition = new UmplePosition(event.pageX - 5, event.pageY + 5,0,0);
  newAssociation.classTwoPosition = mousePosition.subtract(UmpleSystem.position());
  jQuery(canvasSelector).append(newAssociation.drawable());
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
    var position = new UmplePosition(Math.round(event.pageX),Math.round(event.pageY),0,0);
    DiagramEdit.addClass(position);
  }
  else if (Page.selectedItem == "AddAssociation" && DiagramEdit.newAssociation != null)
  {
    if (Page.clickCount > 1)
    {
    	DiagramEdit.removeNewAssociation();
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

// Called whenever any change is made on the graphic pane
// such as adding/deleting/moving/renaming class/assoc/generalization
Action.updateUmpleTextCallback = function(response)
{
  History.save(response.responseText, "TextCallback");
  Action.freshLoad = true;

  Page.setUmpleCode(response.responseText);
  // DEBUG
  // Page.setFeedbackMessage("update text callback -");
  // Page.catFeedbackMessage(response.responseText);
  // Page.catFeedbackMessage("-");
  
  if (DiagramEdit.textChangeQueue.length == 0) 
  {
    DiagramEdit.pendingChanges = false;
    Page.hideLoading();
  }
  else
  {
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
     
  if(Page.getExampleType() == "cdModels") {
     jQuery("#itemLoadExamples").show();
     jQuery("#defaultExampleOption").attr("selected",true);
   }
   else {
     jQuery("#itemLoadExamples2").show();
     jQuery("#defaultExampleOption2").attr("selected",true);
   }
}

Action.loadExample = function loadExample()
{
  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode=" + Page.getSelectedExample());
  var exampleName = Page.getSelectedExample().slice(0,-4);
  var diagramType="";
  
  var largerSelector = "#buttonLarger";
  var smallerSelector = "#buttonSmaller";
  var canvasSelector = "#" + Page.umpleCanvasId();
 
  umpleCanvasWidth = jQuery(canvasSelector).width();
  umpleCanvasHeight = jQuery(canvasSelector).height();
  
  Page.resetCanvasSize();
  var sel = Page.getSelectedExample();
  
  if (sel=="2DShapes.ump"){Page.setUmpleCanvasSize(620,550);}
  else if (sel=="AccessControl.ump"){Page.setUmpleCanvasSize(620,550);}
  else if (sel=="Accidents.ump"){Page.setUmpleCanvasSize(620,550);}
  else if (sel=="Accommodations.ump"){Page.setUmpleCanvasSize(780,550);}
  else if (sel=="AfghanRainDesign.ump"){Page.setUmpleCanvasSize(920,600);}
  else if (sel=="AirlineExample.ump"){Page.setUmpleCanvasSize(700,550);}
  else if (sel=="BankingSystemA.ump"){Page.setUmpleCanvasSize(840,550);}
  else if (sel=="BankingSystemB.ump"){Page.setUmpleCanvasSize(820,550);}
  else if (sel=="CanalSystem.ump"){Page.setUmpleCanvasSize(850,600);}
  else if (sel=="OhHellWhist.ump"){Page.setUmpleCanvasSize(700,550);}
  else if (sel=="Claim.ump"){Page.setUmpleCanvasSize(550,550);}
  else if (sel=="CommunityAssociation.ump"){Page.setUmpleCanvasSize(720,590);}
  else if (sel=="CoOpSystem.ump"){Page.setUmpleCanvasSize(700,550);}
  else if (sel=="DMMOverview.ump"){Page.setUmpleCanvasSize(650,550);}
  else if (sel=="DMMModelElementHierarchy.ump"){Page.setUmpleCanvasSize(935,600);}
  else if (sel=="DMMSourceObjectHierarchy.ump"){Page.setUmpleCanvasSize(1000,550);}
  else if (sel=="DMMRelationshipHierarchy.ump"){Page.setUmpleCanvasSize(1200,570);}
  else if (sel=="DMMExtensionCTF.ump"){Page.setUmpleCanvasSize(1100,620);}
  else if (sel=="Decisions.ump"){Page.setUmpleCanvasSize(780,720);}
  else if (sel=="ElectionSystem.ump"){Page.setUmpleCanvasSize(680,550);}
  else if (sel=="ElevatorSystemA.ump"){Page.setUmpleCanvasSize(550,550);}
  else if (sel=="ElevatorSystemB.ump"){Page.setUmpleCanvasSize(820,550);}
  else if (sel=="GenealogyA.ump"){Page.setUmpleCanvasSize(550,550);}
  else if (sel=="GenealogyB.ump"){Page.setUmpleCanvasSize(550,550);}
  else if (sel=="GenealogyC.ump"){Page.setUmpleCanvasSize(550,550);}  
  else if (sel=="GeographicalInformationSystem.ump"){Page.setUmpleCanvasSize(765,550);}
  else if (sel=="Hospital.ump"){Page.setUmpleCanvasSize(650,550);}
  else if (sel=="Hotel.ump"){Page.setUmpleCanvasSize(820,550);}
  else if (sel=="Insurance.ump"){Page.setUmpleCanvasSize(650,575);}
  else if (sel=="InventoryManagement.ump"){Page.setUmpleCanvasSize(625,570);}
  else if (sel=="Library.ump"){Page.setUmpleCanvasSize(780,550);}
  else if (sel=="MailOrderSystemClientOrder.ump"){Page.setUmpleCanvasSize(780,550);}
// old mis-spelling for historical record
  else if (sel=="ManufactoringPlantController.ump"){Page.setUmpleCanvasSize(750,550);}
  else if (sel=="ManufacturingPlantController.ump"){Page.setUmpleCanvasSize(750,550);}
  else if (sel=="Pizza.ump"){Page.setUmpleCanvasSize(700,570);}
  else if (sel=="PoliceSystem.ump"){Page.setUmpleCanvasSize(800,700);} 
  else if (sel=="PoliticalEntities.ump"){Page.setUmpleCanvasSize(550,550);}
  else if (sel=="realestate.ump"){Page.setUmpleCanvasSize(730,700);}
  else if (sel=="RoutesAndLocations.ump"){Page.setUmpleCanvasSize(750,680);}
  else if (sel=="School.ump"){Page.setUmpleCanvasSize(700,550);}
  else if (sel=="TelephoneSystem.ump"){Page.setUmpleCanvasSize(700,550);}
  else if (sel=="UniversitySystem.ump"){Page.setUmpleCanvasSize(600,550);}  
  else if (sel=="VendingMachineClassDiagram.ump"){Page.setUmpleCanvasSize(650,650);}
  else if (sel=="WarehouseSystem.ump"){Page.setUmpleCanvasSize(750,700);}

// State diagrams
  else {
    diagramType="&diagramtype=state"
    if (sel=="Booking.ump"){Page.setUmpleCanvasSize(400,550);}
    else if (sel=="CanalLockStateMachine.ump"){Page.setUmpleCanvasSize(800,800);}
    else if (sel=="CarTransmission.ump"){Page.setUmpleCanvasSize(1000,600);}  
    else if (sel=="ComplexStateMachine.ump"){Page.setUmpleCanvasSize(600,600);}  
    else if (sel=="DigitalWatchNested.ump"){Page.setUmpleCanvasSize(1350,750);}  
    else if (sel=="DigitalWatchFlat.ump"){Page.setUmpleCanvasSize(1000,800);}  
    else if (sel=="Elevator_State_Machine.ump"){Page.setUmpleCanvasSize(1200,900);}  
    else if (sel=="GarageDoor.ump"){Page.setUmpleCanvasSize(550,550);}    
    else if (sel=="Phone.ump"){Page.setUmpleCanvasSize(1000,600);}
    else if (sel=="SpecificFlight.ump"){Page.setUmpleCanvasSize(900,800);}  
    else if (sel=="SpecificFlightFlat.ump"){Page.setUmpleCanvasSize(900,800);}  
    else if (sel=="TrafficLightsA.ump"){Page.setUmpleCanvasSize(1100,700);}
    else {Page.setUmpleCanvasSize(1100,900);}
  }
  
  var newURL="?example="+exampleName+diagramType;
  Page.setExampleMessage("<a href=\""+newURL+"\">URL for "+exampleName+" example</a>");
 // TODO - fix so history works nicely
 //   if(history.pushState) {history.pushState("", document.title, newURL);}
           
  jQuery("#inputExample").blur();
}

Action.loadExampleCallback = function(response)
{
  Action.freshLoad = true;
  Page.setUmpleCode(response.responseText);
  Page.hideLoading();
  History.save(response.responseText, "loadExampleCallback");
  Action.updateUmpleDiagram();
  Action.setCaretPosition("0");
  Action.updateLineNumberDisplay();

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
  Action.oldTimeout = setTimeout(function() {Action.classMoved(Page.selectedClass);}, 1000); 
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
    Page.unselectAllToggleTools();
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

}

Action.getCaretPosition = function() // TIM Returns the line number
{
  var ctrl = document.getElementById('umpleModelEditor');
  
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
Action.getInputSelectionStart = function(el) {
    var start = 0, normalizedValue, range, textInputRange, len, endRange;

    if (typeof el.selectionStart == "number" && typeof el.selectionEnd == "number") {
      start = el.selectionStart;
      // The following for debugging
    if (Page.getAdvancedMode() == 2) { // debug
      Page.setFeedbackMessage("Non-IE browser ");
      }
    }
    else { // IE Support
      // The following for debugging
    if (Page.getAdvancedMode() == 2) { // debug
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

            if (textInputRange.compareEndPoints("StartToEnd", endRange) > -1) {
                start = len;
            } else {
                start = -textInputRange.moveStart("character", -len);
                start += normalizedValue.slice(0, start).split("\n").length - 1;
            }
        }
    }

    return start;
}

Action.setCaretPosition = function(line){
  if(isNaN(line-0)) {
    // It is not a number so must be a special hidden command
    if(line=="av") {
      // Special backdoor to turn on experimental features
      document.getElementById('advancedMode').value=1;
      Page.setFeedbackMessage("");
      return;
    }
    if(line=="db") { // turn on debugging and do certain debugging options
      document.getElementById('advancedMode').value=2;
      Page.setFeedbackMessage("Debug Mode");
      return;
    }
    if(line.substr(0,2)=="cm") {
      if(line.substr(2,1)=="0" && Page.codeMirrorOn) {
        Page.setFeedbackMessage("Turning code mirroring off");
        Page.codeMirrorEditor.toTextArea();
        Page.codeMirrorOn=false;
        jQuery("#linenum").val("0");
      }
      else if(line.substr(2,1)=="1" && !Page.codeMirrorOn) {
        Page.initCodeMirrorEditor();
        jQuery("#linenum").val("0");
      }
      return;
    }
    else
    {
      if(!Action.selectMatchingText(line)) {
        Page.setFeedbackMessage("Line number or word \""+line+"\" not located");
        setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},3000);      }
      return;
    }
  }
  if(Page.codeMirrorOn) {
    Page.codeMirrorEditor.setSelection({line: line-1,ch: 0},{line: line-1,ch: 999999});
    Page.codeMirrorEditor.focus();
    return;
  }
  var ctrl = document.getElementById('umpleModelEditor');
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

// Searches for the matching text in the code mirror editor
// Does not span lines
Action.selectMatchingText = function(text) {
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

// Will select a class. Needs improving so does not match certain comments
Action.selectClass = function(className) {
  if(Page.codeMirrorOn) {
    var scursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("class "+
       className+"($|\\\s|[{])"));

    if(!scursor.findNext()) {
      return; // false
    }

    // Have found declaration of class. Now have to search for the next class or end
    var start = scursor.from();

    var theEnd=new Object();

    theEnd.line = Page.codeMirrorEditor.lineCount();
    theEnd.ch = 9999;
    
    scursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("class [A-Z]"),scursor.to());
    if(scursor.findNext()) {
      // Found a subsequent class - back up one line from it
      // TODO: This is weak since it can select a comment before the next class
      var endObject = scursor.from();
      theEnd.line = endObject.line -1;
      theEnd.ch = 999;
    }

    Page.codeMirrorEditor.setSelection(start,theEnd);
    return;    //true 
  }
  return;  // false - important do not return a value or it won't work in Firefox/Opera
}

Action.selectStateInClass = function(stateName, classname) {
  // TODO
  if(Page.codeMirrorOn) {
  }
}

Action.delayedFocus = function(ms) {
  var ctrl=document.getElementById('umpleModelEditor');
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
    Page.codeMirrorEditor.save();
    Action.umpleTypingActivity("codeMirrorEditor");
  }
  else {
    Action.freshLoad = false;
  }
}

Action.trimMultipleNonPrintingAndComments = function(text) {
  text = Action.removeComments(text);
  text = text.replace(/[^\x21-\x7E]+/g, ' '); // change non-printing chars to spaces
  text= text.replace(/^\s+|\s+$/g, '');      // remove leading/trailing spaces
  return text;
}

Action.removeComments = function(str) {
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
  
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  Action.oldTimeout = setTimeout('Action.processTyping("' + target + '",' + false + ')', Action.waiting_time);
}

Action.processTyping = function(target, manuallySynchronized)
{
  // Save in history after a pause in typing
  History.save(Page.getUmpleCode(), "processTyping");
  Page.setExampleMessage("");
  if (!Action.manualSync || manuallySynchronized)
  {
    if (target == "umpleModelEditor" || target == "codeMirrorEditor") {
      Action.updateLayoutEditorAndDiagram();
    }
    else Action.updateUmpleDiagramForce(false);
    Action.diagramInSync = true;
    Page.enablePaletteItem("buttonSyncDiagram", false);
    Page.enableDiagram(true);
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
  Action.updateUmpleDiagramForce(false);
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
  if(Page.useEditableClassDiagram) {language="language=Json"}
  else if(Page.useGvClassDiagram) {language="language=classDiagram"}
  else {language="language=stateDiagram"}
  
  // append any suboptions needed for GvStateDiagram
  if(Page.useGvStateDiagram) { 
    if(!Page.showActions) language=language+".hideactions";
  }
  // append any suboptions needed for GvClassDiagram
  if(Page.useGvClassDiagram) { 
    if(Page.showMethods) language=language+".showmethods";
    if(!Page.showAttributes) language=language+".hideattributes";
  }
  Action.ajax(Action.updateUmpleDiagramCallback,language);
}

Action.updateUmpleDiagramCallback = function(response)
{
  var toDisplay = response.responseText;
  var umpleJson = "";
  var errorMessage = "";
  var isError = false;
  
  if(Page.useEditableClassDiagram) {	  
    var codeparts = toDisplay.split('URL_SPLIT');
    errorMessage=codeparts[0];
    umpleJson=codeparts[1];
  }
  else {  // GraphViz diagram to display
    var codeparts = toDisplay.split('<svg xmlns=');
    var miscStuffAndErrorMessages = codeparts[0];
    var prelimparts = miscStuffAndErrorMessages.split('errorRow');
    if(prelimparts.length > 1) {
      errorMessage= "<div id='errorRow"+(prelimparts[1].split('<script'))[0];
      isError = true;    
    }
    
    if(codeparts.length>1 && codeparts[1].length>100) {
      umpleJson="<svg xmlns="+codeparts[1];
    }
  }
  
  if(umpleJson == "null" || umpleJson == "" || isError) {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("The Umple model/code cannot be compiled; <a href=\"\#errorClick\">see explanation at the bottom.</a> To fix: edit the text or click undo");
    Page.showGeneratedCode(errorMessage,"diagramUpdate");
  }
  else {  // reset feedback message when error is corrected
    if(!Action.diagramInSync)
    {
      Page.enableDiagram(true);
      Action.diagramInSync=true;
    }
    Page.setFeedbackMessage("");
    if (new Date().getTime()-Action.gentime > 5000)
    {
      // Erase generated code if it was generated a long time ago
      Page.hideGeneratedCode();
    }
    if(Page.useEditableClassDiagram) {
      var newSystem = Json.toObject(umpleJson);
      UmpleSystem.merge(newSystem);
      if(Page.showMethods || !Page.showAttributes)
       UmpleSystem.update(); 
    }

    if (Page.readOnly) {
      jQuery("span.editable").addClass("uneditable");
      // jQuery("div.umpleClass").addClass("unselectable");
    }
  }
  
  if(!Page.useEditableClassDiagram) {
    // GV diagram - always output
    // JSON must actually be svg code
    var canvas = jQuery("#umpleCanvas");
    canvas.html(format('{0}',umpleJson));
  }
  Page.hideLoading();
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
  var id = jQuery(dragDivSel).attr("id");
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
  var dragDivId = jQuery(dragDivSel).attr("id");
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
  Action.redrawDiagram()
  // UmpleSystem.update();
}
  
Action.toggleMethods = function()
{
  Page.showMethods = !Page.showMethods;
  Action.redrawDiagram()
  // UmpleSystem.update();
}

Action.toggleActions = function()
{
  Page.showActions = !Page.showActions;
  Action.redrawDiagram()
}

Action.redrawDiagram = function()
{
    UmpleSystem.merge(null);    // Clear the diagram
    var canvas = jQuery("#umpleCanvas");
    canvas.html("");
    Action.showHideCanvas(true);
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
    Action.processTyping("umpleModelEditor",true);
    Page.enablePaletteItem("buttonSyncDiagram", false);
  }
}

Action.ajax = function(callback,post,errors)
{
  var modelAndPositioning = Page.getUmpleCode();
  var umpleCode = encodeURIComponent(modelAndPositioning);
  var filename = Page.getFilename();
  // var errors = typeof(errors) != 'undefined' ? errors : "false";
  var errors = "true";
    Ajax.sendRequest("scripts/compiler.php",callback,format("{0}&error={3}&umpleCode={1}&filename={2}",post,umpleCode,filename,errors));
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
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,-5,0,0));
});
Mousetrap.bind(['shift+up'], function(e){
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,-1,0,0));
});

//Arrow Down
Mousetrap.bind(['down'], function(e){
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,5,0,0));
});
Mousetrap.bind(['shift+down'], function(e){
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,1,0,0));
});

//Arrow Left
Mousetrap.bind(['left'], function(e){
  Action.moveSelectedClass(Page.selectedClass, new UmplePosition(-5,0,0,0));
});
Mousetrap.bind(['shift+left'], function(e){
  Action.moveSelectedClass(Page.selectedClass, new UmplePosition(-1,0,0,0));
});

//Arrow Right
Mousetrap.bind(['right'], function(e){
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(5,0,0,0));
});
Mousetrap.bind(['shift+right'], function(e){
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(1,0,0,0));
});

//Functions for changing diagram view - change consistently in umple_page.js
Mousetrap.bind(['ctrl+e'], function(e){
  Page.clickShowEditableClassDiagram();
});

Mousetrap.bind(['ctrl+g'], function(e){
  Page.clickShowGvClassDiagram();
});

Mousetrap.bind(['ctrl+s'], function(e){
  Page.clickShowGvStateDiagram();
});

//Functions for showing and hiding parts of the view
Mousetrap.bind(['ctrl+t'], function(e){
  Page.clickShowHideText();
});

Mousetrap.bind(['ctrl+d'], function(e){
  Page.clickShowHideCanvas();
});

Mousetrap.bind(['ctrl+n'], function(e){
  Page.clickShowHideMenu();
});


//Functions for shrinking and growing the diagram
Mousetrap.bind(['ctrl+shift+='], function(e){
  Page.clickButtonlarger();
});

Mousetrap.bind(['ctrl+shift+-'], function(e){
  Page.clickButtonSmaller();
});

// Functions for changing what is shown on the diagram
Mousetrap.bind(['ctrl+a'], function(e){
  Page.clickToggleAttributes();
});

Mousetrap.bind(['ctrl+m'], function(e){
  Page.clickToggleMethods();
});

// Functions for editing the diagram - using shift
Mousetrap.bind(['g'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {      
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {
      document.getElementById('buttonAddGeneralization').click();
    }        
  }  
});

Mousetrap.bind(['a'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {
      document.getElementById('buttonAddAssociation').click();
    }
  }
});

Mousetrap.bind(['c'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {        
      document.getElementById('buttonAddClass').click();
    }        
  }
});

