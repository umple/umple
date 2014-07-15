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
  else if (action == "StructureDiagram")
  {
    Action.generateCode("structureDiagram","structureDiagram");
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
    Layout.umpleCanvasResized(1);
  }
  else if (action == "Smaller")
  {
    Layout.umpleCanvasResized(-1);
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
    Layout.showHideTextEditor();
  }
  else if (action == "ShowHideCanvas")
  {
    Layout.showHideCanvas();
  }
  else if (action == "ShowEditableClassDiagram")
  {
    Action.changeDiagramType({type:"editableClass"});
  }
  else if (action == "ShowGvClassDiagram")
  {
    Action.changeDiagramType({type:"GVClass"});
  }
  else if (action == "ShowGvStateDiagram")
  {
    Action.changeDiagramType({type:"GVState"});
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
    Action.processTyping("umpleModelEditorText", true);
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

Action.changeDiagramType = function(newDiagramType)
{
  var changedType = false;
  if(newDiagramType.type == "editableClass") { 
    if(Page.useEditableClassDiagram) return;
    Page.useEditableClassDiagram = true;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowEditableClassDiagram").prop('checked', 'checked');
  }
  else if(newDiagramType.type == "GVClass") { 
    if(Page.useGvClassDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useGvClassDiagram = true;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowGvClassDiagram").prop('checked', 'checked');
  }
  else if(newDiagramType.type == "GVState") {
    if(Page.useGvStateDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = true;
    Page.useStructureDiagram = false;
    changedType = true;
    jQuery("#buttonShowGvStateDiagram").prop('checked', 'checked');
  }
  else if(newDiagramType.type == "structure") { // Structure Diagram
    if(Page.useGvStructureDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = true;
    changedType = true;
    jQuery("#buttonShowStructureDiagram").prop('checked', 'checked');
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
  if (Page.getAdvancedMode() == 0 && (languageName == "Cpp"))
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
    var position = new UmplePosition(Math.round(event.pageX),Math.round(event.pageY) + 1,0,0);
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
  
  Page.hideLoading();

  if (DiagramEdit.textChangeQueue.length == 0) 
  {
    DiagramEdit.pendingChanges = false;
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
  jQuery("#itemLoadExamples3").hide();
     
  if(Page.getExampleType() == "cdModels") {
     jQuery("#itemLoadExamples").show();
     jQuery("#defaultExampleOption").prop("selected",true);
   }
   else if(Page.getExampleType() == "smModels") {
     jQuery("#itemLoadExamples2").show();
     jQuery("#defaultExampleOption2").prop("selected",true);
   }
   else {
     jQuery("#itemLoadExamples3").show();
     jQuery("#defaultExampleOption3").prop("selected",true);
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
  if(Page.useGvStateDiagram) diagramType="&diagramtype=state";
  else if(Page.useStructureDiagram) diagramType="&diagramtype=structure";
  
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

// Highlights the text of the class that is currently selected.
Action.selectClass = function(className) 
{
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
    
    scursor = Page.codeMirrorEditor.getSearchCursor(new RegExp("class [A-Za-z]"),scursor.to());
    
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
    if (target == "umpleModelEditorText" || target == "codeMirrorEditor") {
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
  else if(Page.useGvStateDiagram) {language="language=stateDiagram"}
  else if(Page.useStructureDiagram) {language="language=StructureDiagram"}
  
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
  var diagramCode = "";
  var errorMessage = "";
  
  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
  
  if(diagramCode == null || diagramCode == "") 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("The Umple model/code cannot be compiled; <a href=\"\#errorClick\">see explanation at the bottom.</a> To fix: edit the text or click undo");
  }
  else 
  {
    // reset error message
    if(!Action.diagramInSync)
    {
      Page.enableDiagram(true);
      Action.diagramInSync=true;
    }

    Page.setFeedbackMessage("");
    Page.hideGeneratedCode(); //TODO always hide generated code? as the code is updated?
    
    // Display editable class diagram
    if(Page.useEditableClassDiagram) {
      jQuery("#umpleCanvas").show();
      jQuery("#svgDummy").hide();
      var newSystem = Json.toObject(diagramCode);
      UmpleSystem.merge(newSystem);
      if(Page.showMethods || !Page.showAttributes)
      UmpleSystem.update(); 
      
      //Apply readonly styles
      if (Page.readOnly) {
        jQuery("span.editable").addClass("uneditable");
        // jQuery("div.umpleClass").addClass("unselectable");
      }
    }
    // Display static svg diagram
    else if(Page.useGvClassDiagram || Page.useGvStateDiagram)
    {
      jQuery("#umpleCanvas").show();
      jQuery("#svgDummy").hide();
      jQuery("#umpleCanvas").html(format('{0}', diagramCode));
    }
    //Display structure diagram
    else if(Page.useStructureDiagram)
    {
      Action.renderStructureDiagram(diagramCode);
    }
  }
  
  //Show the error message
  if(errorMessage != "")
  {
    Page.showGeneratedCode(errorMessage,"diagramUpdate");
  }
  
  Page.hideLoading();
}

// Gets the code to display from the AJAX response
Action.getDiagramCode = function(responseText)
{
  var output = "";
  
  if(Page.useEditableClassDiagram)
  {
    output = responseText.split('URL_SPLIT')[1];
    
    if(output == "null") output = "";
    
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram)
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
  if(Page.useEditableClassDiagram)
  {
    output = responseText.split('URL_SPLIT')[0];
    
    if(output == "<p>") output = "";
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram)
  {
    var miscStuffAndErrorMessages = responseText.split('<svg width=')[0];
    var prelimparts = miscStuffAndErrorMessages.split('errorRow');
    if(prelimparts.length > 1) {
      output = miscStuffAndErrorMessages.split("</script>&nbsp;")[0];
    }
  }
  return output;
}

Action.renderStructureDiagram = function(diagramCode)
{
  // Remove any existing svgCanvas
  jQuery("#svgCanvas").remove();
  
  // Hide the standard canvas
  jQuery("#umpleCanvas").hide();
  
  // Place a new svgCanvas in the canvas area
  jQuery("#svgDummy").show();
  jQuery("#svgDummy").html("<svg id=\"svgCanvas\"></svg>");
  
  // eval the javascript that was returned
  eval(diagramCode);
  jQuery("#svgDummy").addClass("structureInCanvas");
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
    if (!Action.manualSync) 
    {
      Action.updateUmpleDiagram();
      Action.diagramInSync = true;
      Page.enableDiagram(true);
    }
    if (Action.manualSync && !Action.diagramInSync) Page.enablePaletteItem('buttonSyncDiagram', true);
    if (!Action.manualSync || Action.diagramInSync)
    {
      Page.enableCheckBoxItem("buttonPhotoReady", "ttPhotoReady", true);
      Page.enableCheckBoxItem("buttonManualSync", "ttManualSync", true);

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

Mousetrap.bind(['ctrl+l'], function(e){
  Page.clickShowStructureDiagram();
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

