// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions triggered by graphically editing the diagram in UmpleOnline

DiagramEdit = new Object();
DiagramEdit.textChangeQueue = [];
DiagramEdit.pendingChanges = false;
DiagramEdit.newClass = null;
DiagramEdit.newAssociation = null;
DiagramEdit.newGeneralization = null;

//Queues and initiates updates to the text editor after the diagram is edited
DiagramEdit.updateUmpleText = function(update)
{  
  if(DiagramEdit.textChangeQueue.length == 0 && !DiagramEdit.pendingChanges)
  {
    DiagramEdit.pendingChanges = true;
    DiagramEdit.textChangeQueue.push(update);
    DiagramEdit.doTextUpdate();
  }
  else
  {
    DiagramEdit.textChangeQueue.push(update);
  }
}

DiagramEdit.doTextUpdate = function()
{
  update = DiagramEdit.textChangeQueue.shift();

  if(update.codeChange)
    Page.hideGeneratedCode();

  Action.ajax(Action.updateUmpleTextCallback,update.actionCode);
}

///////////////////////////////////////////////////////
// Main functions for changing the diagram graphically
///////////////////////////////////////////////////////

DiagramEdit.addClass = function(position)
{
  DiagramEdit.removeNewClass();
  var umpleClass = UmpleSystem.createClass(position);
  var umpleJson = Json.toString(umpleClass);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({ 
    actionCode: format("action=addClass&actionCode={0}",umpleJson),
    codeChange: true
  });
}

// Create an association based on the temporary association
// line drawn in the diagram using "add association" drawing tool
DiagramEdit.addAssociation = function(line)
{
  // the line shown when selecting participating classes
  // is a dummy - erase it and create association 
  DiagramEdit.removeNewAssociation();
  var umpleAssociation = UmpleSystem.createAssociation( line.classOneId,
                              line.classTwoId,
                              line.classOnePosition.add(UmpleSystem.position()),
                              line.classTwoPosition.add(UmpleSystem.position()));

  // obtain the json representation of the association
  var umpleJson = Json.toString(umpleAssociation);
  
  // unselect all drawing tools in the palette and show loading images
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  
  DiagramEdit.updateUmpleText({
    actionCode: format("action=addAssociation&actionCode={0}",umpleJson),
    codeChange: true
  });
}

DiagramEdit.addGeneralization = function(umpleGeneralization)
{
  DiagramEdit.removeNewGeneralization();
  UmpleSystem.createGeneralization(umpleGeneralization.childId, umpleGeneralization.parentId);
  var umpleJson = Json.toString(umpleGeneralization);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  
  DiagramEdit.updateUmpleText({
    actionCode: format("action=addGeneralization&actionCode={0}",umpleJson),
    codeChange: true
  });
}

/* Creating an association (via diagram) is divided into two parts:
 * The first is selecting the first class, and
 * then anchoring the first end of the association line.  
 * The second is doing the same for the second chosen class, and then launching
 * necessary actions to add the association to the Umple System
 */
DiagramEdit.createAssociationPartOne = function(event)
{
  // get the position of the click and compute the first end's position
  var mousePosition = new UmplePosition(event.pageX,event.pageY,0,0);
  var umpleSystem = UmpleSystem.position();
  var classOneX = mousePosition.x - umpleSystem.x;
  var classOneY = mousePosition.y - umpleSystem.y;
  
  // draw a dummy association line and anchor it to the location of the click
  Action.classSelected(event.currentTarget);
  DiagramEdit.newAssociation = new UmpleAssociation();
  DiagramEdit.newAssociation.classOneId = event.currentTarget.id;
  DiagramEdit.newAssociation.classOnePosition = new UmplePosition(classOneX,classOneY,0,0); 
}

DiagramEdit.createAssociationPartTwo = function(event)
{
  var mousePosition = new UmplePosition(event.pageX,event.pageY,0,0);
  Action.classSelected(event.currentTarget);

  if(DiagramEdit.newAssociation.classOneId <= event.currentTarget.id)
  {
    //The inline association definition belongs in the first class clicked
    DiagramEdit.newAssociation.classTwoId = event.currentTarget.id;
    DiagramEdit.newAssociation.classTwoPosition = mousePosition.subtract(UmpleSystem.position());
  }
  else
  {
    //The inline association definition belongs in the second class clicked
    DiagramEdit.newAssociation.classTwoId = DiagramEdit.newAssociation.classOneId;
    DiagramEdit.newAssociation.classTwoPosition = DiagramEdit.newAssociation.classOnePosition;
    DiagramEdit.newAssociation.classOneId = event.currentTarget.id;
    DiagramEdit.newAssociation.classOnePosition = mousePosition.subtract(UmpleSystem.position());
  }
  
  DiagramEdit.addAssociation(DiagramEdit.newAssociation);
}

DiagramEdit.createGeneralizationPartOne = function(event)
{
  var childClass = UmpleSystem.find(event.currentTarget.id);
  if (childClass.extendsClass != null) return false;
      
  Action.classSelected(event.currentTarget);
  DiagramEdit.newGeneralization = new UmpleGeneralization();
  DiagramEdit.newGeneralization.childId = event.currentTarget.id;
  
  umpleSystem = UmpleSystem.position();
  childPositionX = Dom.x(event) - umpleSystem.x;
  childPositionY = Dom.y(event) - umpleSystem.y;
  DiagramEdit.newGeneralization.childPosition = new UmplePosition(childPositionX,childPositionY,0,0);
}

DiagramEdit.createGeneralizationPartTwo = function(event)
{
  Action.classSelected(event.currentTarget);
    
  DiagramEdit.newGeneralization.parentId = event.currentTarget.id;
  DiagramEdit.newGeneralization.parentPosition = new UmplePosition(Dom.x(event),Dom.y(event),0,0);
  DiagramEdit.addGeneralization(DiagramEdit.newGeneralization);
}

DiagramEdit.classMoved = function(targetClass)
{
  var umpleClassMoved = UmpleSystem.find(targetClass.id);
  var classObj = jQuery("#" + umpleClassMoved.id);
 
  // assure the offsets are round numbers
  newPositionX = Math.round(classObj.offset().left);
  newPositionY = Math.round(classObj.offset().top);
  UmpleSystem.updatePosition(umpleClassMoved,newPositionX,newPositionY);
  
  var editClass = Json.toString(umpleClassMoved);
  var umpleCode = Page.getUmpleCode();
  
  // make call to the back end to update the umple code
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=editClass&actionCode={0}",editClass),
    codeChange: false
  });
  Action.classSelected(targetClass);
  
  UmpleSystem.trimOverlappingAssociations(umpleClassMoved);
}

// This function is no longer being called as its caller has been commented out
DiagramEdit.classResized = function(event, ui)
{
  var classDiv = event.target;
  var id = classDiv.id;
  var umpleClass = UmpleSystem.find(id);
  
  UmpleSystem.updateClass(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(umpleClass, addToQueue);
  
  // update the position (in umple code) of any association affected
  for (var i=0; i<UmpleSystem.umpleAssociations.length; i++)
  {
    var umpleAssociation = UmpleSystem.umpleAssociations[i];
    if (umpleAssociation.contains(umpleClass))
    {
      var isClassOne = umpleAssociation.classOneId == umpleClass.id;
      var offset = isClassOne ? umpleAssociation.offsetOnePosition : umpleAssociation.offsetTwoPosition;
    
      var anchorId = isClassOne ? "_anchor0" : "_anchor1";
      var dragDivSelector = "#" + umpleAssociation.id + anchorId;
      var addToQueue = true;
    
      DiagramEdit.associationMoved(dragDivSelector, addToQueue);
    }
  }
  
  var editClass = Json.toString(umpleClass);
  var umpleCode = Page.getUmpleCode();
  
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format('action=editClass&actionCode={0}',editClass),
    codeChange: false
  });
  Action.classSelected(classDiv);
}

DiagramEdit.associationMoved = function(dragDivSelector, addToQueue)
{
  if (DiagramEdit.newAssociation != null) DiagramEdit.removeNewAssociation();
  if (addToQueue == undefined) addToQueue = false;
  
  var dragDivId = jQuery(dragDivSelector).attr("id");
  var associationId = dragDivId.substr(0, dragDivId.length - "_anchorX".length);
  var association = UmpleSystem.findAssociation(associationId);
  
  Action.updateMovedAssociation(dragDivSelector, association);
    
  var editAssociation = Json.toString(association);

  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    codeChange: false,
    actionCode: format("action=editAssociation&actionCode={0}",editAssociation)
  });
}

DiagramEdit.regularAssociationMoving = function(dragSelector)
{
  if (DiagramEdit.newAssociation == null)
  {
    var dragId = jQuery(dragSelector).attr("id");
    var id = dragId.substr(0,dragId.length - "_anchorX".length);

    // get the association being moved and create a temporary one
    // to display movement
    var association = UmpleSystem.findAssociation(id);
    var dragAssociation = new UmpleAssociation();
    
    // identify which end is being moved and update its attributes
    if (dragId.endsWith("_anchor0"))
    {
      dragAssociation.classOneId = association.classTwoId;
      dragAssociation.classOnePosition = association.classTwoPosition;
      dragAssociation.offsetOnePosition = association.offsetTwoPosition;
    }
    else
    {
      dragAssociation.classOneId = association.classOneId;
      dragAssociation.classOnePosition = association.classOnePosition;
      dragAssociation.offsetOnePosition = association.offsetOnePosition;
    } 
    DiagramEdit.newAssociation = dragAssociation;
  }
  
  var dragOffset = jQuery(dragSelector).offset();
  var xys = Action.associationSnap(Math.round(dragOffset.left),Math.round(dragOffset.top),dragSelector);
  var screenPosition = new UmplePosition(xys[0],xys[1]);
  DiagramEdit.newAssociation.classTwoPosition = screenPosition.subtract(UmpleSystem.position());
  DiagramEdit.newAssociation.offsetTwoPosition = new UmplePosition(0,0,0,0);

  var canvasSelector = "#" + Page.umpleCanvasId();
  jQuery(canvasSelector).append(DiagramEdit.newAssociation.drawable());
}

DiagramEdit.reflexiveAssociationMoving = function(dragSelector)
{
  var dragId = jQuery(dragSelector).attr("id");
  var id = dragId.substr(0,dragId.length - "_anchorX".length);
  var association = UmpleSystem.findAssociation(id);

  if (DiagramEdit.newAssociation == null)
  {
    DiagramEdit.newAssociation = new UmpleAssociation();
    DiagramEdit.newAssociation.classOneId = association.classOneId;
    DiagramEdit.newAssociation.classTwoId = association.classTwoId;
    DiagramEdit.newAssociation.classOnePosition = association.classOnePosition;
    DiagramEdit.newAssociation.classTwoPosition = association.classTwoPosition;
    DiagramEdit.newAssociation.offsetOnePosition = association.offsetOnePosition;
    DiagramEdit.newAssociation.offsetTwoPosition = association.offsetTwoPosition;
    DiagramEdit.newAssociation.id = DiagramEdit.newAssociation.getElementId();
  }
  
  var dragOffset = jQuery(dragSelector).offset();
  var xys = Action.associationSnap(Math.round(dragOffset.left),Math.round(dragOffset.top),dragSelector);
  var screenPosition = (new UmplePosition(xys[0],xys[1],0,0));
  var offset = screenPosition.subtract(UmpleSystem.position());
  offset.x = offset.x - DiagramEdit.newAssociation.classOnePosition.x;
  offset.y = offset.y - DiagramEdit.newAssociation.classOnePosition.y;
  
  if (dragId.endsWith("_anchor0")) DiagramEdit.newAssociation.offsetOnePosition = offset;
  else DiagramEdit.newAssociation.offsetTwoPosition = offset;
  
  var canvasSelector = "#" + Page.umpleCanvasId();
  jQuery(canvasSelector).append(DiagramEdit.newAssociation.drawableReflexive());
}

DiagramEdit.classNameChanged = function(diagramId,oldName,newName)
{
  if(newName.length=0 || !newName.match(/^[_a-zA-Z0-9]+$/))
  {

    Action.updateUmpleDiagram();
    var message="Class names must be alphanumeric. &lt;"
      +(newName.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))
      +"&gt is not valid.";
    setTimeout(function() {Page.setFeedbackMessage(message);},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else
  {
    var umpleClass = UmpleSystem.renameClass(diagramId,oldName,newName);
    // Reset height and width to minimum - TRYING
    umpleClass.position.width = UmpleClassFactory.defaultSize.width;

    var editClass = Json.toString(umpleClass);
    delete umpleClass.oldname;
  
    Page.showModelLoading();
    Page.showLayoutLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
  }
}

DiagramEdit.attributeNameChanged = function(diagramId,index,oldName,newAttribute)
{
  if(!Action.validateAttributeName(newAttribute))
  {
    Action.updateUmpleDiagram();
    setTimeout(function() {Page.setFeedbackMessage("UML Attributes must be alphanumeric with an optional type after a colon. &lt;"+(newAttribute.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;")
)+"&gt is not valid.");},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else
  {
    var umpleClass = UmpleSystem.find(diagramId);
    umpleClass.attributes[index].set(newAttribute);
    UmpleSystem.redraw(umpleClass);
  
    var editClass = Json.toString(umpleClass);
    Page.showModelLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
    umpleClass.resetAttribute(index);
  }
}

DiagramEdit.attributeNew = function(diagramId,attributeInput)
{
  if(!Action.validateAttributeName(attributeInput))
  {
    Action.updateUmpleDiagram();
    setTimeout(function() {Page.setFeedbackMessage("UML Attributes must be alphanumeric with "
      + "an optional type after a colon. &lt;"
      + (attributeInput.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))
      + "&gt is not valid.");},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else // new attribute is valid
  {
    var umpleClass = UmpleSystem.find(diagramId);
    var attributeIndex = umpleClass.addAttribute(attributeInput);

    var editClass = Json.toString(umpleClass);
    Page.showModelLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });

    umpleClass.resetAttribute(attributeIndex);
    UmpleSystem.updateClass(umpleClass);
    UmpleSystem.redrawGeneralizationsTo(umpleClass);
    UmpleSystem.trimOverlappingAssociations(umpleClass);
  }
}

DiagramEdit.classDeleted = function(diagramId)
{
  var addToQueue = true;
  var umpleClass = UmpleSystem.find(diagramId);
  var associationsAffected = [];
  var generalizationsAffected = [];
  
  for (var i=0; i<UmpleSystem.umpleAssociations.length; i++)
  {
    var umpleAssociation = UmpleSystem.umpleAssociations[i];
    if (umpleAssociation.contains(umpleClass))
    {
      associationsAffected.push(umpleAssociation.id);  
    }
  }
  for (var i=0; i<UmpleSystem.umpleClasses.length; i++)
  {
    var currentClass = UmpleSystem.umpleClasses[i];
    if (currentClass.extendsClass == umpleClass.id)
    {
      generalizationsAffected.push(currentClass.id + "_generalization");
    }
  }
  
  for (var i=0; i<associationsAffected.length; i++)
  {
    DiagramEdit.associationDeleted(associationsAffected[i], addToQueue);
  }
  for (var i=0; i<generalizationsAffected.length; i++)
  {
    DiagramEdit.generalizationDeleted(generalizationsAffected[i], addToQueue);
  }
    
  var result = UmpleSystem.removeClass(diagramId);
  var removeClass = Json.toString(result);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=removeClass&actionCode={0}",removeClass),
    codeChange: true
  });
}

DiagramEdit.methodNew = function(diagramId, methodInput)
{
  if(!Action.validateMethodName(methodInput))
  {
    Action.updateUmpleDiagram();
    setTimeout(function() {Page.setFeedbackMessage("Invalid UML Method. &lt;"+(methodInput.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.");},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else
  {
    var umpleClass = UmpleSystem.find(diagramId);
    var methodIndex = umpleClass.addMethod(methodInput);
    var editClass = Json.toString(umpleClass);
    Page.showModelLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
    umpleClass.resetMethod(methodIndex);
    UmpleSystem.updateClass(umpleClass);
    UmpleSystem.redrawGeneralizationsTo(umpleClass);
    UmpleSystem.trimOverlappingAssociations(umpleClass); 
  }
}

DiagramEdit.methodChanged = function(diagramId,index,oldName,newMethod)
{
  if(!Action.validateMethodName(newMethod))
  {
    Action.updateUmpleDiagram();
    setTimeout(function() {Page.setFeedbackMessage("Invalid UML Method. &lt;"+(newMethod.split("&").join("&amp;").split( "<").join("&lt;").split(">").join("&gt;"))+"&gt is not valid.");},2000);
    setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},10000);
  }
  else
  {
    var umpleClass = UmpleSystem.find(diagramId);
    umpleClass.methods[index].set(newMethod);
    UmpleSystem.redraw(umpleClass);
    var editClass = Json.toString(umpleClass);
    Page.showModelLoading();
    DiagramEdit.updateUmpleText({
      actionCode: format("action=editClass&actionCode={0}",editClass),
      codeChange: true
    });
    umpleClass.resetMethod(index);
  }
}

DiagramEdit.methodDelete = function(diagramId,index)
{
  var umpleClass = UmpleSystem.find(diagramId);
  umpleClass.removeMethod(index);
  // Reset height and width to sensible values
  var classObj = jQuery("#" + umpleClass.id);
  //  umpleClass.position.height = Math.round(classObj.height());
  //  umpleClass.position.width = Math.round(classObj.width());

  umpleClass.position.height = 28+17*(umpleClass.attributes.size()+umpleClass.methods.size());
// This needs fixing so it picks up the correct width
// Look trimOverlap, which seems to know the correct width
  umpleClass.position.width = UmpleClassFactory.defaultSize.width;

//  umpleClass.position.height = UmpleClassFactory.defaultSize.height;
//  umpleClass.position.width = UmpleClassFactory.defaultSize.width;

  var editClass = Json.toString(umpleClass);
  Page.showModelLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=editClass&actionCode={0}",editClass),
    codeChange: true
  });

  umpleClass.resetMethod(index);
  UmpleSystem.updateClass(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(umpleClass);
  UmpleSystem.trimOverlappingAssociations(umpleClass);
}

DiagramEdit.attributeDelete = function(diagramId,index)
{
  var umpleClass = UmpleSystem.find(diagramId);
  umpleClass.removeAttribute(index);
  // Reset height and width to sensible values
  var classObj = jQuery("#" + umpleClass.id);
//  umpleClass.position.height = Math.round(classObj.height());
//  umpleClass.position.width = Math.round(classObj.width());

  umpleClass.position.height = 28+17*(umpleClass.attributes.size()+umpleClass.methods.size());
// This needs fixing so it picks up the correct width
// Look trimOverlap, which seems to know the correct width
  umpleClass.position.width = UmpleClassFactory.defaultSize.width;

//  umpleClass.position.height = UmpleClassFactory.defaultSize.height;
//  umpleClass.position.width = UmpleClassFactory.defaultSize.width;

  var editClass = Json.toString(umpleClass);
  Page.showModelLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=editClass&actionCode={0}",editClass),
    codeChange: true
  });

  umpleClass.resetAttribute(index);
  UmpleSystem.updateClass(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(umpleClass);    
  UmpleSystem.trimOverlappingAssociations(umpleClass);
}

DiagramEdit.associationDeleted = function(diagramId, addToQueue)
{
  if (addToQueue == undefined) addToQueue = false;
  var removed = UmpleSystem.removeAssociation(diagramId);
  var json = Json.toString(removed);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=removeAssociation&actionCode={0}",json),
    codeChange: true
  });
}

DiagramEdit.generalizationDeleted = function(diagramId, addToQueue)
{
  if (addToQueue == undefined) addToQueue = false;
  var removed = UmpleSystem.removeGeneralization(diagramId)
  var json = Json.toString(removed);
  
  if (!Page.repeatToolItem) Page.unselectAllToggleTools();
  
  Page.showModelLoading();
  Page.showLayoutLoading();
  DiagramEdit.updateUmpleText({
    actionCode: format("action=removeGeneralization&actionCode={0}",json),
    codeChange: true
  });
}

/////////////////////////////////////
//Helper and auxilliary functions
/////////////////////////////////////

DiagramEdit.removeNewClass = function()
{
  if (DiagramEdit.newClass != null)
  {
    var classSelector = "#" + DiagramEdit.newClass.id;
    DiagramEdit.newClass = null;
    jQuery(classSelector).remove();
  }
}

DiagramEdit.removeNewAssociation = function()
{
  if (DiagramEdit.newAssociation != null)
  {
    var lineSelector = "#"+DiagramEdit.newAssociation.getElementId();
    jQuery(lineSelector).remove();
    DiagramEdit.newAssociation = null;
  }
}

DiagramEdit.removeNewGeneralization = function()
{
  if (DiagramEdit.newGeneralization != null)
  {
    var lineSelector = "#" + DiagramEdit.newGeneralization.getElementId();
    jQuery(lineSelector).remove();
    DiagramEdit.newGeneralization = null;
  }
}