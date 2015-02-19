// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models an Umple model containing classes and associations
// in the graphical view of UmpleOnline

UmpleSystem = new Object();
UmpleSystem.umpleClasses = [];
UmpleSystem.umpleAssociations = [];
  
UmpleSystem.position = function()
{
  var canvas = jQuery("#umpleCanvas");
  var x = Math.ceil(canvas.offset().left - canvas.scrollLeft()); 
  var y = Math.ceil(canvas.offset().top - canvas.scrollTop());
  var p = new UmplePosition(x,y,0,0);
  return p;
}

UmpleSystem.findIn = function(allUmpleElements,diagramId)
{
  if (allUmpleElements == null) return null;
  
  for (var i=0; i<allUmpleElements.length; i++)
  {
    var umpleElement = allUmpleElements[i];
    if (umpleElement.id == diagramId)
    {
      return umpleElement;
    }
  }
  return null;
}

UmpleSystem.find = function(diagramId)
{
  return UmpleSystem.findIn(this.umpleClasses,diagramId);
}

UmpleSystem.findAssociation = function(diagramId)
{
  var association = UmpleSystem.findIn(this.umpleAssociations,diagramId); 
  return association;
}

/* New association is being added via the diagram - this
 * method creates the association object and adds it 
 * to the Umple System */
UmpleSystem.createAssociation = function(classOneId, classTwoId, screenOnePosition, screenTwoPosition)
{
  // create association object
  var umpleAssociation = new UmpleAssociation();
  
  // set its attributes according to parameters
  umpleAssociation.id = this.nextAssociationId();
  umpleAssociation.setClasses(classOneId, classTwoId);
  umpleAssociation.setOffsetOnePosition(screenOnePosition);
  umpleAssociation.setOffsetTwoPosition(screenTwoPosition);
  umpleAssociation.setDefaultMultiplicities();
  umpleAssociation.setDefaultRoles();
  umpleAssociation.setName(umpleAssociation.getName());
  // adjust the association start and end points to snap the association to the class edges
  if(classOneId == classTwoId)
  {
    umpleAssociation.adjustReflexiveEndpoints();
  }
  else
  {
    umpleAssociation.trimOverlap();
  }

  // add it to the Umple System
  return this.addAssociation(umpleAssociation);
}

UmpleSystem.createGeneralization = function(childId, parentId)
{
  var child = UmpleSystem.find(childId);
  child.extendsClass = parentId;
  UmpleSystem.updateClass(child);
}

/* Add association to the umple system */
UmpleSystem.addAssociation = function(umpleAssociation)
{
  this.umpleAssociations.push(umpleAssociation);
  var associationDiv = this.redrawAssociation(umpleAssociation);
  
  return umpleAssociation;
}

/* Create a new class to be added to the Umple System
 * 
 */
UmpleSystem.createClass = function(screenPosition)
{
  // create the class object
  var umpleClass = new UmpleClass();
  
  // set the default ID and other attributes
  umpleClass.id = this.nextId("NewClass");
  umpleClass.name = umpleClass.id;
  umpleClass.position.set(screenPosition.x - UmpleSystem.position().x, screenPosition.y - UmpleSystem.position().y, UmpleClassFactory.defaultSize.width, UmpleClassFactory.defaultSize.height);
  
  // add the class to the Umple System and draw
  // any generalizations lines that lead to it
  var addedClass = this.addClass(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(addedClass);
  return addedClass;
}

UmpleSystem.addClass = function(umpleClass)
{
  this.umpleClasses.push(umpleClass);
  this.updateClass(umpleClass);
  
  var classObj = jQuery("#" + umpleClass.id);
  
  if (!Page.isPhotoReady())
  {
    classObj.click(Action.classClicked);
    classObj.mouseover(function(event) { Action.classHover(event,true);} );
    classObj.mouseout(function(event) { Action.classHover(event,false);} );
    classObj.mousedown(function(event) { setTimeout(function(){Action.classMouseDown(event);}, 400);} );
   // classObj.touchstart(function(event) { setTimeout(function(){Action.classMouseDown(event);}, 400);} );
    classObj.mouseup(function(event){ Action.classMouseUp(event); });
   // classObj.touchend(function(event){ Action.classMouseUp(event); });
     if (!Page.readOnly) 
     {
      classObj.draggable
      ({
       containment:'parent', 
       stop:function(event,ui){DiagramEdit.classMoved(event.target
      )}
     });
 /*     classObj.resizable
      ({
          minHeight:UmpleClassFactory.defaultSize.height, 
          minWidth:UmpleClassFactory.defaultSize.width, 
          autoHide:true,
          containment:'parent',
          resize:function(event,ui){DiagramEditclassResizing(event,ui);},
          stop:function(event,ui){DiagramEditclassResized(event,ui);}
      }); */
    }
    
    // remove the jquery resizable handle
    jQuery(".ui-icon-gripsmall-diagonal-se").removeClass("ui-icon-gripsmall-diagonal-se");
    jQuery(".ui-icon").removeClass("ui-icon");
  }
  //UmpleSystem.redrawGeneralizationsTo(umpleClass);
  return umpleClass;   
}

UmpleSystem.replaceClass = function(newClass)
{
  for (var i=0; i< this.umpleClasses.length; i++)
  {
    var existingClass = this.umpleClasses[i];
    if (existingClass.id == newClass.id)
    {
      var classSel = "#" + existingClass.id;
      var generalizationSel = classSel + "_generalization";
      var existingClassDiv = jQuery(classSel).get();
      var existingGeneralizationDiv = jQuery(generalizationSel).get();
      
      jQuery(existingClassDiv).attr("id", newClass.id);
      
      if (existingGeneralizationDiv != undefined)
      {
      	jQuery(existingGeneralizationDiv).attr("id", newClass.id + "_generalization");
      	jQuery(existingGeneralizationDiv).remove();
      }
      
      this.umpleClasses[i] = newClass;
      this.updateClass(this.umpleClasses[i]);
      
      return;
    }
  }
}

UmpleSystem.renameClass = function(diagramId, oldName, newName)
{
  var umpleClass = UmpleSystem.find(diagramId);
  var classSel = "#" + diagramId;
  var generalizationSel = classSel + "_generalization";
  
  newName = this.nextId(newName);
  umpleClass.id = newName;
  umpleClass.name = newName;
  umpleClass.oldname = oldName;
  
  jQuery(classSel).attr("id", umpleClass.id);
  if (jQuery(generalizationSel).get() != undefined)
  {
  	jQuery(generalizationSel).attr("id", umpleClass.id + "_generalization");
  }
  
  for (var i=0; i< this.umpleAssociations.length; i++)
  {
    var existingAssociation = this.umpleAssociations[i];
    if (existingAssociation.classOneId == oldName)
    {
      existingAssociation.classOneId = umpleClass.id;
    }
    if (existingAssociation.classTwoId == oldName)
    {
      existingAssociation.classTwoId = umpleClass.id;
    }
  }
  
  for (var i=0; i< this.umpleClasses.length; i++)
  {
  	var child = this.umpleClasses[i];
  	if (child.extendsClass == oldName)
  	{
  	  child.extendsClass = newName;
  	  this.updateClass(child);
  	}
  }
  
  UmpleSystem.updateClass(umpleClass);
  
  return umpleClass;
}

UmpleSystem.replaceAssociation = function(newAssociation)
{
  for (var i=0; i< this.umpleAssociations.length; i++)
  {
    var existingAssociation = this.umpleAssociations[i];
    if (existingAssociation.id == newAssociation.id)
    {
      this.umpleAssociations[i] = newAssociation;
      index = i;
    }
  }
   
  this.redrawAssociation(newAssociation);
  return;
}

UmpleSystem.updatePosition = function(umpleClass,screenX,screenY)
{
  umpleClass.position.x = screenX - UmpleSystem.position().x;
  umpleClass.position.y = screenY - UmpleSystem.position().y;
  UmpleSystem.redrawAssociationsFor(umpleClass);
  UmpleSystem.redrawGeneralizationsTo(umpleClass);
  UmpleSystem.updateClass(umpleClass);
}

UmpleSystem.updateClass = function(umpleClass)
{
  var divs = umpleClass.drawable();
  var classDiv = divs[0];
  var generalizationDiv = divs[1];
  
  var canvas = jQuery("#" + Page.umpleCanvasId());
  var classObj = jQuery("#" + umpleClass.id);
  canvas.append(classDiv);
  //canvas.append(generalizationDiv);
  if(generalizationDiv != null)
  {
    for(var i=0; i<generalizationDiv.length; i++)
    {
      canvas.append(generalizationDiv[i]);
    }
    
  }
  
  UmpleSystem.redraw(umpleClass);

  
  var buffer = 2;
  var isDirty = false;
  
  if (classObj.width() > umpleClass.position.width + buffer)
  {
    umpleClass.position.width = classObj.width();
    isDirty = true;
  }
  
  if (classObj.height() > umpleClass.position.height + buffer)
  {
    umpleClass.position.height = classObj.height();
    isDirty = true;
  }
  if (isDirty)
  {
    UmpleSystem.redraw(umpleClass);    
  }  
  
/*  classObj.resizable("destroy");
  classObj.resizable
  ({
    minHeight:UmpleClassFactory.defaultSize.height, 
    minWidth:UmpleClassFactory.defaultSize.width, 
    autoHide:true,
    containment:'parent',
    resize:function(event,ui){DiagramEditclassResizing(event,ui);},
    stop:function(event,ui){DiagramEditclassResized(event,ui);}
  }); */
  
  //remove the jquery resizable handle
  jQuery(".ui-icon-gripsmall-diagonal-se").removeClass("ui-icon-gripsmall-diagonal-se");
  jQuery(".ui-icon").removeClass("ui-icon");
}

UmpleSystem.redrawAssociationsFor = function(umpleClass)
{
  for (var i=0; i<this.umpleAssociations.length; i++)
  {
    var umpleAssociation = this.umpleAssociations[i];
    if (umpleAssociation.contains(umpleClass))
    {
      UmpleSystem.redrawAssociation(umpleAssociation);
    }
  }
}

UmpleSystem.redrawAssociation = function(umpleAssociation)
{
  var associationSel = "#" + umpleAssociation.id;
  var canvasSel = "#" + Page.umpleCanvasId();
  var associationDiv = null;
  
  associationDiv = umpleAssociation.drawable();
  jQuery(canvasSel).append(associationDiv);
  
  if (!Page.isPhotoReady())
  {
    jQuery(associationSel).click(Action.associationClicked);
    jQuery(associationSel).mouseover(function(event) { Action.associationHover(event,true); });
    jQuery(associationSel).mouseout(function(event) { Action.associationHover(event,false); });
    UmpleSystem.setDragableAssociationAnchor(umpleAssociation,0);
    UmpleSystem.setDragableAssociationAnchor(umpleAssociation,1);
  }
  
  return associationDiv;
}

UmpleSystem.redrawGeneralizationsTo = function(parent)
{
  for (var i=0; i<this.umpleClasses.length; i++)
  {
  	var umpleClass = this.umpleClasses[i];
  	if (umpleClass.extendsClass == parent.id) 
  	{
  	  this.updateClass(umpleClass);
  	}
    else if(umpleClass.interfaces.length > 0)
    {
      for (var j = 0; j < umpleClass.interfaces.length; j++)
      {
        if ( umpleClass.interfaces[j] == parent.id)
        {
          this.updateClass(umpleClass);
        }
       
      }
    }
  }
}

UmpleSystem.update = function()
{
  for(var i = 0; i<this.umpleClasses.length;++i)
  {
    var umpleClass = this.umpleClasses[i];
    umpleClass.position.height = 28;
    if(UmpleSystem.showAttributes)
      umpleClass.position.height += 17*(umpleClass.attributes.size());
    if(UmpleSystem.showMethods)
      umpleClass.position.height += 17*(umpleClass.methods.size());
    UmpleSystem.updateClass(umpleClass);

  }

  for(var i = 0; i<this.umpleAssociations.length;++i)
  {
    var umpleClass1 = UmpleSystem.find(this.umpleAssociations[i].classOneId);
    var x = this.umpleAssociations[i].offsetOnePosition.x+umpleClass1.position.x+UmpleSystem.position().x;
    var y = this.umpleAssociations[i].offsetOnePosition.y+umpleClass1.position.y+UmpleSystem.position().y;
    var xys1 =  Action.associationSnapClassReady(x,y,umpleClass1);

    var umpleClass2 = UmpleSystem.find(this.umpleAssociations[i].classTwoId);
    x = this.umpleAssociations[i].offsetTwoPosition.x+umpleClass2.position.x+UmpleSystem.position().x;
    y = this.umpleAssociations[i].offsetTwoPosition.y+umpleClass2.position.y+UmpleSystem.position().y;
    var xys2 =  Action.associationSnapClassReady(x,y,umpleClass2);

    var screenPosition1 = new UmplePosition(xys1[0],xys1[1],0,0);
    var screenPosition2 = new UmplePosition(xys2[0],xys2[1],0,0);

    this.umpleAssociations[i].setOffsetOnePosition(screenPosition1);
    this.umpleAssociations[i].setOffsetTwoPosition(screenPosition2);
    UmpleSystem.redrawAssociation(this.umpleAssociations[i]);
  }
  for(var i = 0; i<this.umpleClasses.length;++i)
  {
    UmpleSystem.trimOverlappingAssociations(this.umpleClasses[i]);
  }

}

UmpleSystem.redraw = function(umpleClass)
{
  var screenX = umpleClass.position.x + UmpleSystem.position().x;
  var screenY = umpleClass.position.y + UmpleSystem.position().y;
  
  var classSel = "#" + umpleClass.id;
  var generalizationSel = classSel + "_generalization";
  var widthSel = classSel + "_width";
  var heightSel = classSel + "_height";
  
  var offset = new Object();
  offset.top = screenY;
  offset.left = screenX;
  jQuery(classSel).offset(offset);
  jQuery(widthSel).width(umpleClass.position.width);
  jQuery(heightSel).height(umpleClass.position.height);
  
  if (!Page.isPhotoReady())
  {
    // The following can be deleted
/*    UmpleSystem.updateAnchor(umpleClass,0);
    UmpleSystem.updateAnchor(umpleClass,1);
    UmpleSystem.updateAnchor(umpleClass,2);
    UmpleSystem.updateAnchor(umpleClass,3);
    UmpleSystem.updateAnchor(umpleClass,4);
    UmpleSystem.updateAnchor(umpleClass,5);
    UmpleSystem.updateAnchor(umpleClass,6);
    UmpleSystem.updateAnchor(umpleClass,7);
*/    
    var generalizationDiv = jQuery(generalizationSel).get();
    if(generalizationDiv != undefined)
    {
      jQuery(generalizationSel).click(Action.generalizationClicked);
      jQuery(generalizationSel).mouseover(function(event) { Action.generalizationHover(event,true); });
      jQuery(generalizationSel).mouseout(function(event) { Action.generalizationHover(event,false); });
    }
  }
  
  this.redrawAssociationsFor(umpleClass);
}

UmpleSystem.trimOverlappingAssociations = function(umpleClass)
{
  // trim any association that may now overlap a class

  Page.showLayoutLoading();

  for (var i=0; i<UmpleSystem.umpleAssociations.length; i++)
  {
    var umpleAssociation = UmpleSystem.umpleAssociations[i];
    
    if (umpleAssociation.contains(umpleClass))
    {
      var oldOffsetOne = UmplePositionFactory.copy(umpleAssociation.offsetOnePosition); 
      var oldOffsetTwo = UmplePositionFactory.copy(umpleAssociation.offsetTwoPosition);

      if(umpleAssociation.isReflexive()) 
        umpleAssociation.adjustReflexiveEndpoints();
      else 
        umpleAssociation.trimOverlap();

      // if an offset position has changed, update the association
      if (!oldOffsetOne.equalsIgnoreSize(umpleAssociation.offsetOnePosition) ||
          !oldOffsetTwo.equalsIgnoreSize(umpleAssociation.offsetTwoPosition))
      {
        Page.showLayoutLoading();
        // redraw the association
        UmpleSystem.redrawAssociation(umpleAssociation);
        
        // prepare an update call to the back and add it to the queue
        var editAssociation = Json.toString(umpleAssociation);
        DiagramEdit.updateUmpleText({
          actionCode: format("action=editAssociation&actionCode={0}",editAssociation),
          codeChange: false
        });
      }
    }
  }

  Page.hideLoading()
}

// The following can be deleted
UmpleSystem.updateAnchor = function(umpleClass,index)
{
  var classSel = "#" + umpleClass.id;
  var anchorSel = classSel + "_anchor" + index;
  var hoverSel = classSel + "_hover" + index;
  
  var position = "";
  
  switch (index)
  {
    case 0: position = "left top"; 		break;
    case 1: position = "left center"; 	break;
    case 2: position = "left bottom"; 	break;
    case 3: position = "center bottom"; break;
    case 4: position = "right bottom";	break;
    case 5: position = "right center"; 	break;
    case 6: position = "right top"; 	break;
    case 7: position = "center top";	break;
  }
  
  jQuery(anchorSel).show(); //jQuery does not support .position() on hidden elements
  jQuery(hoverSel).show();
  jQuery(anchorSel).position({my:"center", at:position, of:classSel});
  jQuery(hoverSel).position({my:"center", at:position, of:classSel});
  jQuery(anchorSel).hide();
  jQuery(hoverSel).hide();
}

UmpleSystem.setDragableAssociationAnchor = function(umpleAssociation,anchorNbr)
{
  if (Page.readOnly) {return}
  
  if (umpleAssociation.isReflexive())
  {
    var anchorSel = "#" + umpleAssociation.id + "_anchor" + anchorNbr;
    var umpleClassId = anchorNbr == 0 ? umpleAssociation.classOneId : umpleAssociation.classTwoId;
    
    jQuery(anchorSel).draggable
    ({
    	drag: function(event, ui) {DiagramEdit.reflexiveAssociationMoving("#" + event.target.id);},
    	stop: function(event, ui) {DiagramEdit.associationMoved("#" + event.target.id);},
    	cursor: 'pointer',
    	snap: '#' + umpleClassId,
    	snapTolerance: 5,
    	containment: '#' + umpleClassId, 
    	zIndex: 1
    });
  }
  else
  { 
    var anchorSel = "#" + umpleAssociation.id + "_anchor" + anchorNbr;
    var umpleClassId = anchorNbr == 0 ? umpleAssociation.classOneId : umpleAssociation.classTwoId;
    
    jQuery(anchorSel).draggable
    ({
    	drag: function(event, ui) {DiagramEdit.regularAssociationMoving("#" + event.target.id);},
    	stop: function(event, ui) {DiagramEdit.associationMoved("#" + event.target.id);},
    	cursor: 'pointer',
    	snap: '#' + umpleClassId,
    	snapTolerance: 5,
    	containment: '#' + umpleClassId,
    	zIndex: 1
    });
  }  
}

UmpleSystem.updatingSize = function(umpleClass,newWidth,newHeight)
{
  umpleClass.position.width = newWidth;
  umpleClass.position.height = newHeight;
  UmpleSystem.redraw(umpleClass);
}

UmpleSystem.removeClass = function(diagramId)
{
  for (var i=0; i<this.umpleClasses.length; i++)
  {
    var umpleClass = this.umpleClasses[i];
    if (umpleClass.id == diagramId)
    {
      this.umpleClasses.splice(i,1);
      var classSel = "#" + diagramId;
      var generalizationSel = classSel + "_generalization";
      
      jQuery(classSel).remove();
      jQuery(generalizationSel).remove();
      
      return umpleClass;
    }
  }
  return null;
}

UmpleSystem.removeAssociation = function(diagramId)
{
  for (var i=0; i<this.umpleAssociations.length; i++)
  {
    var umpleAssociation = this.umpleAssociations[i];
    if (umpleAssociation.id == diagramId)
    {
      this.umpleAssociations.splice(i,1);
      
      var associationSel = "#" + diagramId;
      jQuery(associationSel).remove();
      
      return umpleAssociation;
    }
  }
  return null;
}

UmpleSystem.removeGeneralization = function(diagramId)
{
  var generalizationSel = "#" + diagramId;
  jQuery(generalizationSel).remove();
  
  var umpleClassId = diagramId.replace("_generalization", "");
  var umpleClass = UmpleSystem.find(umpleClassId);
  umpleClass.extendsClass = null;
  
  var umpleGeneralization = new UmpleGeneralization();
  umpleGeneralization.childId = umpleClass.id;
  umpleGeneralization.parentId = umpleClass.extendsClass;
  
  return umpleGeneralization;
}

UmpleSystem.redrawCanvas = function()
{
  UmpleSystem.merge(UmpleSystem);
}

UmpleSystem.merge = function(newSystem)
{
  UmpleSystem.mergeClasses(newSystem);
  UmpleSystem.mergeAssociations(newSystem);
}

UmpleSystem.mergeClasses = function(newSystem)
{
  if (newSystem == null)
  {
    while (this.umpleClasses.length > 0)
    {
      this.removeClass(this.umpleClasses[0].id);
    }
    return;
  }
  
  for (var i=0; i<this.umpleClasses.length; i++)
  {
    var umpleClass = this.umpleClasses[i];
    var newClass = this.findIn(newSystem.umpleClasses,umpleClass.id);
    
    if (newClass == null)
    {
      i -= 1;
      this.removeClass(umpleClass.id);
    }
    else
    {
      this.replaceClass(UmpleClassFactory.create(newClass));
    }
  }
  
  for (var i=0; i<newSystem.umpleClasses.length; i++)
  {
  	var newClass = newSystem.umpleClasses[i];
  	var existingClass = this.find(newClass.id);
    
    if (existingClass == null)
    {
      this.addClass(UmpleClassFactory.create(newClass));
    }
  }
  
  for (var i=0; i<this.umpleClasses.length; i++)
  {
  	var umpleClass = this.umpleClasses[i]; 
  	if (umpleClass.extendsClass != null || umpleClass.interfaces.length >0)
  	{
      this.updateClass(umpleClass);
  	}
  }
}

UmpleSystem.mergeAssociations = function(newSystem)
{
  if (newSystem == null)
  {
    while (this.umpleAssociations.length > 0)
    {
      this.removeAssociation(this.umpleAssociations[0].id);
    }
    return;
  }
  
  for (var i=0; i<this.umpleAssociations.length; i++)
  {
    var umpleAssociation = this.umpleAssociations[i];
    var newAssociation = this.findIn(newSystem.umpleAssociations,umpleAssociation.id);
    
    if (newAssociation == null)
    {
      i -= 1;
      this.removeAssociation(umpleAssociation.id);
    }
    else
    {
      this.replaceAssociation(UmpleAssociationFactory.create(newAssociation));
    }
  }
  
  for (var i=0; i<newSystem.umpleAssociations.length; i++)
  {
    var existingAssociation = this.findAssociation(newSystem.umpleAssociations[i].id);
    
    if (existingAssociation == null)
    {
      var newAssociation = UmpleAssociationFactory.create(newSystem.umpleAssociations[i]);
      this.addAssociation(newAssociation);
    }
  }
}

UmpleSystem.nextId = function(desiredName)
{
  var template = "umpleElement_";
  var nextElementId = template + "0";
  if (typeof(desiredName) != "undefined")
  {
    template = desiredName;
    nextElementId = desiredName;
  }

  var found = false;
  var nextIndex = 0;
  while (nextIndex < 100 && !found)
  {
    if (nextIndex > 0)
    {
    nextElementId = template + nextIndex;
    }
    found = true;
    for (var i=0; i<this.umpleClasses.length; i++)
    {
      if (this.umpleClasses[i].id == nextElementId)
      {
        found = false;
        nextIndex += 1;
        break;
      }
    }
    if (found)
    {
      return nextElementId;
    }
  }
  return "";
}

UmpleSystem.nextAssociationId = function(desiredName)
{
  var template = "umpleAssociation_";
  var nextElementId = template + "0";
  if (typeof(desiredName) != "undefined")
  {
    template = desiredName;
    nextElementId = desiredName;
  }

  var found = false;
  var nextIndex = 0;
  while (nextIndex < 100 && !found)
  {
    if (nextIndex > 0)
    {
    nextElementId = template + nextIndex;
    }
    found = true;
    for (var i=0; i<this.umpleAssociations.length; i++)
    {
      if (this.umpleAssociations[i].id == nextElementId)
      {
        found = false;
        nextIndex += 1;
        break;
      }
    }
    if (found)
    {
      return nextElementId;
    }
  }
  return "";
}
