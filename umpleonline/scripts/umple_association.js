// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models associations in the graphical view of UmpleOnline

UmpleAssociationFactory = new Object();

UmpleAssociationFactory.create = function(data)
{
  var umpleAssociation = new UmpleAssociation();
  umpleAssociation.id = data.id;
  umpleAssociation.classOneId = data.classOneId;
  umpleAssociation.classTwoId = data.classTwoId;
  umpleAssociation.offsetOnePosition = UmplePositionFactory.copy(data.offsetOnePosition);
  umpleAssociation.offsetTwoPosition = UmplePositionFactory.copy(data.offsetTwoPosition);
  umpleAssociation.multiplicityOne = data.multiplicityOne;
  umpleAssociation.multiplicityTwo = data.multiplicityTwo;
  umpleAssociation.name = data.name;
  umpleAssociation.roleOne = data.roleOne;
  umpleAssociation.roleTwo = data.roleTwo;
  umpleAssociation.isSymmetricReflexive = (data.isSymmetricReflexive == "true" || data.isSymmetricReflexive == true) ? true : false;
  umpleAssociation.isLeftNavigable = (data.isLeftNavigable == "true" || data.isLeftNavigable == true) ? true : false;
  umpleAssociation.isRightNavigable = (data.isRightNavigable == "true" || data.isRightNavigable == true) ? true : false;
  umpleAssociation.color = data.isTraced;
  return umpleAssociation;
}

function UmpleAssociation()
{
  this.id;
  this.classOneId;
  this.classTwoId;
  this.classOnePosition = null;
  this.classTwoPosition = null;
  this.offsetOnePosition = null;
  this.offsetTwoPosition = null;
  this.multiplicityOne = "";
  this.multiplicityTwo = "";
  this.name = "";
  this.roleOne = "";
  this.roleTwo = "";
  this.isSymmetricReflexive = false;
  this.isLeftNavigable = true;
  this.isRightNavigable = true;
  this.color = "black";
  
  this.setClasses = function(aClassOneId,aClassTwoId)
  {
    this.classOneId = aClassOneId;
    this.classTwoId = aClassTwoId;
  }
  
  this.setDefaultMultiplicities = function()
  {
    this.multiplicityOne = "*";
    this.multiplicityTwo = "*";
  }

  this.setDefaultRoles = function()
  {
    if(this.classOneId == this.classTwoId)
    {
      this.roleTwo = "roleName";
    }
  }
  
  this.setRoles = function(aRole1, aRole2)
  {
    this.roleOne = aRole1;
    this.roleTwo = aRole2;
  }
  
  this.setName = function(aName)
  {
    this.name = aName;
  }
  
  this.getName = function()
  {
    if (this.name == null || this.name == "") return this.deriveName();
    else return this.name;
  }
  
  this.deriveName = function()
  {
    var derivedName = "";
    var classOnePart = this.classOneId;
    var classTwoPart = this.classTwoId;
    
    if(!(this.roleOne == null || this.roleOne === ""))
    {
      classOnePart = this.classOneId + ":" + this.roleOne;
    }

    if(!(this.roleTwo == null || this.roleTwo === ""))
    {
      classTwoPart = this.classTwoId + ":" + this.roleTwo;
    }
    
    if (this.classOneId <= this.classTwoId)
    {
      derivedName = classOnePart + "__" + classTwoPart;
    }
    else
    {
      derivedName = classTwoPart + "__" + classOnePart;
    }
    return derivedName;
  }
  
  this.getElementId = function()
  {
    return this.id == null ? "newassociation" : this.id;
  }
  
  this.getClass = function(index)
  {
    return index == 0 ? UmpleSystem.find(this.classOneId) : UmpleSystem.find(this.classTwoId);
  }
  
  this.setOffsetOnePosition = function(offsetOnePosition)
  {
    var classOne = UmpleSystem.find(this.classOneId);
    this.classOnePosition = classOne.position;
    this.offsetOnePosition = offsetOnePosition.subtract(classOne.position).subtract(UmpleSystem.position());
    this.offsetOnePosition.width = 0;
    this.offsetOnePosition.height = 0;
  }
  
  this.setOffsetTwoPosition = function(offsetTwoPosition)
  {
    var classTwo = UmpleSystem.find(this.classTwoId);
    this.classTwoPosition = classTwo.position;
    this.offsetTwoPosition = offsetTwoPosition.subtract(classTwo.position).subtract(UmpleSystem.position());
    this.offsetTwoPosition.width = 0;
    this.offsetTwoPosition.height = 0;
  }
  
  // Used to trim non-reflexive associations to the edge of classes
  this.trimOverlap = function()
  {
    // set up needed variables
    var associationLine = new UmpleLine(this.offsetOnePosition.add(this.classOnePosition), this.offsetTwoPosition.add(this.classTwoPosition));
    var classOneBorders = UmpleSystem.find(this.classOneId).borderLines();
    var classTwoBorders = UmpleSystem.find(this.classTwoId).borderLines();
    var currentOne = this.offsetOnePosition.add(this.classOnePosition);
    var currentTwo = this.offsetTwoPosition.add(this.classTwoPosition);
    var intersections1 = [];
    var intersections2 = [];

    // find all intersections between the association line and class one borders
    for (var i=0; i<classOneBorders.length; i++)
    {
      intersection = associationLine.intersection(classOneBorders[i])
      if (intersection != null) intersections1.push(intersection);
    }
    
    // find all intersections between the association line and class two borders
    for (var i=0; i<classTwoBorders.length; i++)
    {
      intersection = associationLine.intersection(classTwoBorders[i]);
      if (intersection != null) intersections2.push(intersection);
    }
    
    // min is the shortest possible association line, and is set to the current
    // line by default
    var min = new UmpleLine(currentOne, currentTwo);

    // identify the cutoff point (intersection) on end one that results 
    // in the shortest association line
    var current = new UmpleLine(min.pointOne, min.pointTwo);
    for (var i=0; i<intersections1.length; i++)
    {
      current.pointOne = intersections1[i];
      if (current.length() < min.length()) {min = new UmpleLine(current.pointOne, current.pointTwo);}
    }
    
    // identify the cutoff point (intersection) on end two that results 
    // in the shortest association line
    var current = new UmpleLine(min.pointOne, min.pointTwo);
    for (var i=0; i<intersections2.length; i++)
    {
      current.pointTwo = intersections2[i];
      if (current.length() < min.length()) {min = new UmpleLine(current.pointOne, current.pointTwo);}
    }

    this.setOffsetOnePosition(min.pointOne.add(UmpleSystem.position()));
    this.setOffsetTwoPosition(min.pointTwo.add(UmpleSystem.position()));
  }

  // Used to move the endpoints of a reflexive associations to the closest edges of the class they were placed
  this.adjustReflexiveEndpoints = function()
  {
    var endOne = this.offsetOnePosition;
    var endTwo = this.offsetTwoPosition;

    var borders = UmpleSystem.find(this.classOneId).borderLines();

    // move the first point to the closest edge
    this.snapToClosestEdge(endOne, borders);

    // move the second point to the closest edge
    this.snapToClosestEdge(endTwo, borders);
  }

  this.snapToClosestEdge = function(point, borders)
  {
    var isNearTop = true;
    var isNearLeft = true;

    var adjustedX = point.x + this.classOnePosition.x;
    var adjustedY = point.y + this.classOnePosition.y;

    var topBottomDist = adjustedY - borders[0].pointOne.y;
    var leftRightDist = adjustedX - borders[1].pointOne.x;

    if(topBottomDist > borders[2].pointOne.y - adjustedY)
    {
      isNearTop = false;
      topBottomDist = borders[2].pointOne.y - adjustedY;
    }

    if(leftRightDist > borders[3].pointOne.x - adjustedX)
    {
      isNearLeft = false;
      leftRightDist = borders[3].pointOne.x - adjustedX;
    }

    if(topBottomDist <= leftRightDist)
    { 
      if(isNearTop) //Snap to top edge
        point.y = 0; 
      else //Snap to bottom edge
        point.y = this.classOnePosition.height;
    }
    else
    { 
      if(isNearLeft) //Snap to left edge
        point.x = 0;
      else //Snap to right edge
        point.x = this.classOnePosition.width;
    }
  }
  
  this.drawable = function()
  {
    if (this.id == null)
    {
      associationDiv = this.drawableTemp();  
    }
    else if (this.isReflexive())
    {
      associationDiv = this.drawableReflexive();
    }
    else if (this.isBidirectional())
    {
      associationDiv = this.drawableBidirectional();
    }
    else
    {
      associationDiv = this.drawableUnidirectional();
    }
    return associationDiv;
  }
  
  ///////////////////////////////////////////////
  //Main rendering functions for the associations
  ///////////////////////////////////////////////
  this.drawableTemp = function()
  {
    var associationSel = "#" + this.getElementId();
    jQuery(associationSel).remove();
    
    var associationDiv = this.createBaseJQueryObject();
    associationDiv.addClass("umpleAssociationTemp");
    associationDiv.attr("id", "newassociation");
    
    var line = new UmpleLine(this.classOnePosition.add(this.offsetOnePosition), this.classTwoPosition.add(this.offsetTwoPosition));
    associationDiv.append(line.drawable());
            
    return associationDiv;
  }
  
  this.drawableBidirectional = function()
  {
    var associationSel = "#" + this.id;
    jQuery(associationSel).remove();
    
    var associationDiv = this.createBaseJQueryObject();
    if(this.color == "red") associationDiv.addClass("redTracedAssociation");
    else associationDiv.addClass("untracedAssociation");
    associationDiv.attr("id", this.id);
    
    var classOne = UmpleSystem.find(this.classOneId);
    var classTwo = UmpleSystem.find(this.classTwoId);
  
  //If the classes are undefined quite operation
  if(classOne == null || classOne == undefined || classTwo == null || classTwo == undefined)
    return associationDiv;
  
    this.classOnePosition = classOne.position;
    this.classTwoPosition = classTwo.position;
    var perimeterOne = this.classOnePosition.add(this.offsetOnePosition);
    var perimeterTwo = this.classTwoPosition.add(this.offsetTwoPosition);
    
    var line = new UmpleLine(perimeterOne.add(UmpleClassFactory.offsetError),perimeterTwo.add(UmpleClassFactory.offsetError));
    associationDiv.append(line.drawable());
    
    // initiate the hovers and anchors
    var hoverHtml = "";
    var offset = -3;
    hoverHtml += this.anchorDivHtml("hover",0,perimeterOne.x + offset, perimeterOne.y + offset);
    hoverHtml += this.anchorDivHtml("anchor",0,perimeterOne.x + offset, perimeterOne.y + offset);
    hoverHtml += this.anchorDivHtml("hover",1,perimeterTwo.x + offset, perimeterTwo.y + offset);
    hoverHtml += this.anchorDivHtml("anchor",1,perimeterTwo.x + offset, perimeterTwo.y + offset);
    var angle = perimeterOne.slopeAngle(perimeterTwo);
    
    // draw the multiplicities
    var multiplicityOnePosition = this.multiplicityPosition(true);
    var multiplicityTwoPosition = this.multiplicityPosition(false);
    var multiOneHtml = this.multiplicityDivHtml("one",this.multiplicityOne,multiplicityOnePosition.x,multiplicityOnePosition.y); 
    var multiTwoHtml = this.multiplicityDivHtml("two",this.multiplicityTwo,multiplicityTwoPosition.x,multiplicityTwoPosition.y);
    
    // draw the role names 
    if (this.roleOne != "")
    {
      roleOnePosition = this.rolePosition(true);
      var roleOneHtml = this.roleDivHtml("one",this.roleOne,roleOnePosition.x,roleOnePosition.y);
    }
    else roleOneHtml = "";
    
    if (this.roleTwo != "") 
    {
      roleTwoPosition = this.rolePosition(false);
      var roleTwoHtml = this.roleDivHtml("two",this.roleTwo,roleTwoPosition.x,roleTwoPosition.y);
    }
    else roleTwoHtml = "";
  
    currentHtml = associationDiv.html();
    associationDiv.html(multiOneHtml + multiTwoHtml + roleOneHtml + roleTwoHtml + hoverHtml + currentHtml);
    
    return associationDiv;
  }
  
  this.drawableUnidirectional = function()
  {
    var associationDiv = this.drawableBidirectional();
    var peak = null;
    
    if (this.isLeftNavigable)
    {
      peak = this.classOnePosition.add(this.offsetOnePosition);
      otherEnd = this.classTwoPosition.add(this.offsetTwoPosition);
    }
    else
    {
      peak = this.classTwoPosition.add(this.offsetTwoPosition);
      otherEnd = this.classOnePosition.add(this.offsetOnePosition);
    }
    
    var associationLineSlopeAngle = peak.slopeAngle360(otherEnd);
    var edge1SlopeAngle = associationLineSlopeAngle + 30;
    var edge2SlopeAngle = associationLineSlopeAngle - 30;
    var distance = 10;
    
    var vertice1 = peak.travelForward(distance, edge1SlopeAngle);
    var vertice2 = peak.travelForward(distance, edge2SlopeAngle);
    
    var edge1 = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice1.add(UmpleClassFactory.offsetError));
    var edge2 = new UmpleLine(peak.add(UmpleClassFactory.offsetError), vertice2.add(UmpleClassFactory.offsetError));
    associationDiv.append(edge1.drawable());
    associationDiv.append(edge2.drawable());
    
    return associationDiv;
  }
  
  this.drawableReflexive = function() 
  {
    // replace the old association div with a fresh one
    var associationSel = "#" + this.id;
    jQuery(associationSel).remove();
    var associationDiv = this.createBaseJQueryObject();
    if(this.color == "red") associationDiv.addClass("redTracedAssociation");
    else associationDiv.addClass("untracedAssociation");
    associationDiv.attr("id", this.id);
    
    // set the class positions
    var umpleClass = UmpleSystem.find(this.classOneId);
    this.classOnePosition = umpleClass.position;
    this.classTwoPosition = umpleClass.position;
    var classHeight = umpleClass.position.height;
    var classWidth = umpleClass.position.width;
    
    // initialize variables to be used
    var segmentLength = 15;
    
    // identify which class wall (N,S,E or W) end one sits on
    var endOneWall = this.whichWall(true);
    factorX = endOneWall == "West"? -1 : endOneWall == "South"? 0 : endOneWall == "East"? 1 :  0;
    factorY = endOneWall == "West"?  0 : endOneWall == "South"? 1 : endOneWall == "East"? 0 : -1;
    
    // set the start and end points of segment one (small line starting at offset one and perpendicular to class wall)
    var segmentOneStart = this.offsetOnePosition.add(this.classOnePosition);
    var segmentOneEnd = this.offsetOnePosition.add(this.classOnePosition).add(new UmplePosition(segmentLength*factorX, segmentLength*factorY,0,0));
    if(endOneWall == "South") segmentOneStart.y = segmentOneStart.y - 1;
    var segmentOne = new UmpleLine(segmentOneStart, segmentOneEnd);
    
    // identify which class wall (N,S,E or W) end two sits on
    var endTwoWall = this.whichWall(false);
    factorX = endTwoWall == "West"? -1 : endTwoWall == "South"? 0 : endTwoWall == "East"? 1 :  0;
    factorY = endTwoWall == "West"?  0 : endTwoWall == "South"? 1 : endTwoWall == "East"? 0 : -1;
  
    // set the start and end points of segment two (small line starting at offset two and perpendicular to class wall)
    var segmentTwoStart = this.offsetTwoPosition.add(this.classTwoPosition);
    var segmentTwoEnd = this.offsetTwoPosition.add(this.classTwoPosition).add(new UmplePosition(segmentLength*factorX, segmentLength*factorY,0,0));
    var segmentTwo = new UmpleLine(segmentTwoStart, segmentTwoEnd);
    
    // add both segments to the div
    associationDiv.append(segmentOne.drawable());
    associationDiv.append(segmentTwo.drawable());
    
    // The point(s) to add the label to
    var labelPositionOne = new UmplePosition(0, 0, 0, 0);
    
    // if both ends are on same wall connect them with one line
    // also set the position for the label
    if(endOneWall == endTwoWall)
    {
      var connector = new UmpleLine(segmentOneEnd, segmentTwoEnd);
      
      if(endOneWall == "North" || endOneWall == "South") 
      {
        if(this.isSymmetricReflexive) 
        {
          // Set the label position to the midpoint of the connector
          labelPositionOne.x = (segmentOneEnd.x + segmentTwoEnd.x)/2;
          labelPositionOne.y = segmentOneEnd.y;
        }
      }
      else 
      {
        if(this.isSymmetricReflexive) 
        {
          // Set the the label position to the midpoint of the connector
          labelPositionOne.x = segmentOneEnd.x;
          labelPositionOne.y = (segmentOneEnd.y + segmentTwoEnd.y)/2;
        }
      }
      
      associationDiv.append(connector.drawable());
    }
    
    // if ends are on adjacent walls, connect them with two lines
    else if (this.offsetOnePosition.wallsAreAdjacent(endOneWall, endTwoWall))
    {
      var meetingPoint = new UmplePosition(0,0,0,0);
      var anEndIsOnLeft = (endOneWall == "West" || endTwoWall == "West");
      var anEndIsOnTop = (endOneWall == "North" || endTwoWall == "North");
    
      if (anEndIsOnLeft) meetingPoint.x = this.classOnePosition.x - segmentLength;
      else meetingPoint.x = this.classOnePosition.x + classWidth + segmentLength;
      if (anEndIsOnTop) meetingPoint.y = this.classOnePosition.y - segmentLength;
      else meetingPoint.y = this.classOnePosition.y + classHeight + segmentLength;
      
      var connectorOne = new UmpleLine(segmentOneEnd, meetingPoint);
      var connectorTwo = new UmpleLine(segmentTwoEnd, meetingPoint);
      associationDiv.append(connectorOne.drawable());
      associationDiv.append(connectorTwo.drawable());
      
      if(this.isSymmetricReflexive) 
      {
        // Set the label position to the connection point of the two added line segments
        labelPositionOne.set(meetingPoint.x, meetingPoint.y);
      }
    }
    
    // otherwise, ends are on opposite walls - connect them using three lines
    else
    {
      var meetingPoint1 = new UmplePosition(0,0,0,0);
      var meetingPoint2 = new UmplePosition(0,0,0,0);
      var connector1;
      var connector2;
      var connector3;
      var start;
      var end;
        
      // if top and bottom, go around the left of the class
      if (endOneWall == "South" || endTwoWall == "South")
      {
        // connecting points at top left and bottom left
        meetingPoint1.x = this.classOnePosition.x - segmentLength;
        meetingPoint1.y = this.classOnePosition.y - segmentLength;
        meetingPoint2.x = meetingPoint1.x;
        meetingPoint2.y = this.classOnePosition.y + classHeight + segmentLength;
        
        if (endTwoWall == "South")
        {
          start = segmentOneEnd;
          end = segmentTwoEnd;
        }
        else
        {
          start = segmentTwoEnd;
          end = segmentOneEnd;
        }
        
        if(this.isSymmetricReflexive) 
        {
          labelPositionOne.x = meetingPoint1.x;
          labelPositionOne.y = (meetingPoint1.y + meetingPoint2.y)/2;
        }
      }
      // if left and right, go around the bottom of the class
      else
      {
        // connecting points at bottom left and bottom right
        meetingPoint1.x = this.classOnePosition.x - segmentLength;
        meetingPoint1.y = this.classOnePosition.y + classHeight + segmentLength;
        meetingPoint2.x = this.classOnePosition.x + classWidth + segmentLength;
        meetingPoint2.y = meetingPoint1.y;
        
        if (endTwoWall == "East")
        {
          start = segmentOneEnd;
          end = segmentTwoEnd;
        }
        else
        {
          start = segmentTwoEnd;
          end = segmentOneEnd;
        }
        
        if(this.isSymmetricReflexive) 
        {
          labelPositionOne.x = (meetingPoint1.x + meetingPoint2.x)/2;
          labelPositionOne.y = meetingPoint1.y;
        }
      }
      connector1 = new UmpleLine(start, meetingPoint1);
      connector2 = new UmpleLine(meetingPoint1, meetingPoint2);
      connector3 = new UmpleLine(meetingPoint2, end);
      
      associationDiv.append(connector1.drawable());
      associationDiv.append(connector2.drawable());
      associationDiv.append(connector3.drawable()); 
    }
    
    // Set the label positions for non-symmetric reflexive associations.
    // If it is not symmetric, then the labels are always at the midpoints of the line
    // segments that are attached to the class
    if(!this.isSymmetricReflexive) 
    {
      var labelPositionTwo = new UmplePosition(0, 0, 0, 0);
      
      if(endOneWall == "North" || endOneWall == "South")
      {
        labelPositionOne.x = segmentOneEnd.x;
        labelPositionOne.y = (segmentOneStart.y + segmentOneEnd.y)/2;
      }
      else 
      {
        labelPositionOne.x = (segmentOneStart.x + segmentOneEnd.x)/2;
        labelPositionOne.y = segmentOneEnd.y;
      }
      
      if(endTwoWall == "North" || endTwoWall == "South")
      {
        labelPositionTwo.x = segmentTwoEnd.x;
        labelPositionTwo.y = (segmentTwoStart.y + segmentTwoEnd.y)/2;
      }
      else 
      {
        labelPositionTwo.x = (segmentTwoStart.x + segmentTwoEnd.x)/2;
        labelPositionTwo.y = segmentTwoEnd.y;
      }
    }
    
    // Create the markup for the anchors to move the associations
    var hoverHtml = "";
    var hover0 = segmentOneStart;
    var hover1 = segmentTwoStart;
    var centerHover = 3;
    hoverHtml += this.anchorDivHtml("hover",0,hover0.x - centerHover, hover0.y - centerHover);
    hoverHtml += this.anchorDivHtml("anchor",0,hover0.x - centerHover, hover0.y - centerHover);
    hoverHtml += this.anchorDivHtml("hover",1,hover1.x - centerHover, hover1.y - centerHover);
    hoverHtml += this.anchorDivHtml("anchor",1,hover1.x - centerHover, hover1.y - centerHover);
    
    // Create the markup for the association labels and multiplicities
    if(this.isSymmetricReflexive)
    {
      var multiplicityPosition = UmplePositionFactory.copy(this.centerMultiplicityPosition(labelPositionOne));
      
      // draw the role names
      var rolePosition = this.adjustRolePosition(labelPositionOne, true);
      var roleHtml = this.roleDivHtml("center", this.roleOne, rolePosition.x, rolePosition.y)

      //draw the multiplicities
      var multiHtml = this.multiplicityDivHtml("center", this.multiplicityOne, 
          multiplicityPosition.x, multiplicityPosition.y); 
    }
    else
    { 
      var multiplicityPositionOne = UmplePositionFactory.copy(
          this.reflexiveMultiplicityPosition(labelPositionOne, labelPositionTwo, true));
      var multiplicityPositionTwo = UmplePositionFactory.copy(
          this.reflexiveMultiplicityPosition(labelPositionTwo, labelPositionOne, false));
      
      // draw the role names
      var rolePositionOne = this.adjustRolePosition(labelPositionOne, true);
      var rolePositionTwo = this.adjustRolePosition(labelPositionTwo, false);
      var roleHtml = (this.roleDivHtml("one", this.roleOne, rolePositionOne.x, rolePositionOne.y)
          + this.roleDivHtml("two", this.roleTwo, rolePositionTwo.x, rolePositionTwo.y));
      
      //draw the multiplicities
      var multiHtml = 
        (this.multiplicityDivHtml("one", this.multiplicityOne, multiplicityPositionOne.x, multiplicityPositionOne.y)
        + this.multiplicityDivHtml("two", this.multiplicityTwo, multiplicityPositionTwo.x, multiplicityPositionTwo.y)); 
    }
    
    if (this.id == null)
    {
      associationDiv.attr("id", "newassociation");
      return associationDiv;
    } 
    
    var currentHtml = associationDiv.html();
    associationDiv.html(multiHtml + roleHtml + hoverHtml + currentHtml);
    
    return associationDiv;
  }
  
  /////////////////////////////////////////////////
  //Helper functions for rendering the associations
  /////////////////////////////////////////////////
  this.isReflexive = function()
  {
    return this.classOneId == this.classTwoId || this.isSymmetricReflexive;
  }
  
  this.isBidirectional = function()
  {
    if (this.isRightNavigable == undefined || this.isLeftNavigable == undefined)
    {
      return true;
    }
    return this.isRightNavigable && this.isLeftNavigable;
  }
  
  this.endHasArrow = function(isEndOne)
  {
    if (isEndOne) return this.isLeftNavigable;
    else return this.isRightNavigable;
  }

  this.contains = function(umpleClass)
  {
    return umpleClass.id == this.classOneId || umpleClass.id == this.classTwoId;
  }
  
  this.anchorDivHtml = function(type,index,x,y)
  {
    return format('<div id="{0}_{1}{2}" class="{1}" name="{1}" style="left: {3}px; top: {4}px; cursor: pointer; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.id,type,index,x,y);
  }
  
  this.multiplicityDivHtml = function(leftOrRight,multiplicity,x,y,role)
  {
    if (role == undefined || role == "undefined") role = "";
    return format('<div id="{0}_{1}" class="multiplicity" name="{1}" style="left: {2}px; top: {3}px; cursor: pointer;">{4}&nbsp;&nbsp;{5}</div>',this.id,leftOrRight,x,y,multiplicity,role);
  }
  
  this.roleDivHtml = function(position,role,x,y)
  {
    if (position == "one") idExtension = "roleOne";
    else if (position == "two") idExtension = "roleTwo";
    else if (position == "center") idExtension = "role";
    else idExtension = "";
    return format('<div id="{0}_{1}" class="role" name="{1}" style="left: {2}px; top: {3}px; cursor: pointer;">{4}</div>',this.id,idExtension,x,y,role);
  }
  
  this.whichWall = function(isEndOne)
  {
    // set proper values according to which end we are dealing with
    if (isEndOne)
    {
      var classPosition = this.classOnePosition;
      var offset = this.offsetOnePosition;
    }
    else
    {
      var classPosition = this.classTwoPosition;
      var offset = this.offsetTwoPosition;
    }
    
    // determine which class wall the association end resides on
    var max = 1;
    if (offset.x == 0)
    {
      return "West";
    }
    else if (offset.y == 0)
    {
      return "North";
    }
    else if (Math.abs(offset.x-classPosition.width) <= max)
    {
      return "East";
    }
    else
    {
      return "South";
    }
  }
  
  this.multiplicityPosition = function(isEndOne)
  {
    // perimeters are the offset positions relative to the umple canvas
    // (as opposed to their end class)
    if (isEndOne)
    {
      var perimeterOne = this.classOnePosition.add(this.offsetOnePosition);
      var perimeterTwo = this.classTwoPosition.add(this.offsetTwoPosition);
      var multiplicity = this.multiplicityOne;
    }
    else
    {
      var perimeterOne = this.classTwoPosition.add(this.offsetTwoPosition);
      var perimeterTwo = this.classOnePosition.add(this.offsetOnePosition);
      var multiplicity = this.multiplicityTwo;
    }
    
    // identify which wall the association end lies on
    var wall = this.whichWall(isEndOne);
    
    var multHeight = multiplicity == "*"? new UmplePosition(0,10,0,0):new UmplePosition(0,16,0,0);
    var multWidth = new UmplePosition(5*multiplicity.length+1,0,0,0);
    
    // allow extra space for arrow in undirectional associations
    // reduce space if multiplicity is *
    var space = 3;
    if (!this.isBidirectional() && this.endHasArrow(isEndOne)) space += 5;
    
    // slope angle of the association
    var angle = perimeterOne.slopeAngle360(perimeterTwo);
    
    // multiplicity is positioned at middle angle between
    // association and class wall
    if (wall == "North")
    {
      if (angle < 90)
      {
        var halfWaySlope = (180-angle)/2 + angle;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multWidth);
        multPosition = multPosition.subtract(multHeight);
      }
      else
      {
        var halfWaySlope = angle/2;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multHeight);
      }
    }
    else if (wall == "East")
    {
      if (angle >= 0 && angle <= 90)
      {
        var halfWaySlope = (angle+90)/2 + 270;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
      }
      else
      {
        var halfWaySlope = ((360-angle+90)/2 + angle)%360;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multHeight);
      }
    }
    else if (wall == "South")
    {
      if (angle <= 270)
      {
        var halfWaySlope = (360-angle)/2 + angle;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        var temp = multPosition;
      }
      else
      {
        var halfWaySlope = (angle-180)/2 + 180;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        var temp = multPosition;
        multPosition = multPosition.subtract(multWidth);
      }
    }
    else
    {
      if (angle <= 180)
      {
        var halfWaySlope = (270-angle)/2 + angle;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multWidth);
      }
      else
      {
        var halfWaySlope = (angle-90)/2 + 90;
        var multPosition = perimeterOne.travelForward(space,halfWaySlope);
        multPosition = multPosition.subtract(multHeight);
        multPosition = multPosition.subtract(multWidth);
      }
    }
    return multPosition;
  }
  
  //Sets the location of a multiplicity label for symmetric reflexive associations.
  // An UmplePosition is returned that includes the width of the role name.
  this.centerMultiplicityPosition = function(labelPosition) 
  {
    var wallOne = this.whichWall(true);
    var wallTwo = this.whichWall(false);
    
    var offset = 1;
    var space = 5;
    
    labelPosition.width = 5*this.multiplicityOne.length + space + 6*this.roleOne.length;
    labelPosition.height = 16; 
    
    if((wallOne == "West" && wallTwo == "West") 
      || (wallOne == "North" && wallTwo == "South")
      || (wallOne == "South" && wallTwo == "North")) 
    {
      //label is offset to left
      labelPosition.x -= (labelPosition.width + offset);
      labelPosition.y -= labelPosition.height/2;
    } 
    else if(wallOne == "East" && wallTwo == "East") 
    {
      //label is offset to right
      labelPosition.x += offset;
      labelPosition.y -= labelPosition.height/2;
    } 
    else if(wallOne == "North" || wallTwo == "North") 
    {
      //label is offset upwards
      labelPosition.y -= (offset + labelPosition.height);
      labelPosition.x -= labelPosition.width/2;
    } 
    else 
    {
      //label is offset downwards
      labelPosition.y += offset;
      labelPosition.x -= labelPosition.width/2;
    } 
    
    return labelPosition;
  }
  
  // Sets the location of a multiplicity label for non-symmetric reflexive associations.
  // An UmplePosition is returned that includes the width of the role name.
  this.reflexiveMultiplicityPosition = function(position, otherPosition, isAssociationOne) 
  {
    var space = 5;
    var offset = 1;
    
    if(isAssociationOne) 
    {
      var wall = this.whichWall(true);
      var otherWall = this.whichWall(false);
      var multiplicityLength = this.multiplicityOne.length;
      var roleLength = this.roleOne.length;
    }
    else 
    {
      var wall = this.whichWall(false);
      var otherWall = this.whichWall(true);
      var multiplicityLength = this.multiplicityTwo.length;
      var roleLength = this.roleTwo.length;
    }
    
    position.width = 5*multiplicityLength + space + 6*roleLength;
    position.height = 16; 
    
    if(wall == "North") 
    {
      position.y -= position.height/2;
      if((otherWall == "North" && position.x < otherPosition.x) 
          || otherWall == "East")
      {
        // label is offset to the left
        position.x -= (position.width + offset);
      }
      else
      {
        // label is offset to the right
        position.x += offset;
      }
    }
    else if (wall == "East")
    {
      if((otherWall == "East" && position.y < otherPosition.y)
          || otherWall == "South" || otherWall == "West")
      {
        //label is offset upwards
        position.y -= (position.height);
      }
      else 
      {
        //label is offset downwards
        position.y += offset;
      }
    }
    else if(wall == "South")
    {
      position.y -= position.height/2;
      if((otherWall == "South" && position.x < otherPosition.x)
          || otherWall == "East")
      {
        // label is offset to the left
        position.x -= (position.width + offset);
      }
      else 
      {
        // label is offset to the right
        position.x += offset;
      }
    }
    else if (wall == "West")
    {
      position.x -= position.width;
      if((otherWall == "West" && position.y < otherPosition.y)
          || otherWall == "East" || otherWall == "South")
      {
        //label is offset upwards 
        position.y -= (position.height);
      }
      else
      {
        //label is offset downwards 
        position.y += offset;
      }
    }
    return position;
  }
  
  this.rolePosition = function(isEndOne)
  {
    var multiplicity = isEndOne? this.multiplicityOne : this.multiplicityTwo;
    var role = isEndOne? this.roleOne : this.roleTwo;
    var perimeterOne = isEndOne? this.classOnePosition.add(this.offsetOnePosition):
                   this.classTwoPosition.add(this.offsetTwoPosition);
    var perimeterTwo = isEndOne? this.classTwoPosition.add(this.offsetTwoPosition):
                   this.classOnePosition.add(this.offsetOnePosition);
    
    // length of multiplicity plus a space character
    var multLength = new UmplePosition(5*(multiplicity.length),0,0,0);
    var roleLength = new UmplePosition(6*(role.length),0,0,0,0);
    var multHeight = new UmplePosition(0,16,0,0);
    var roleHeight = multHeight;
    var space = new UmplePosition(5,0,0,0);
    var multPosition = this.multiplicityPosition(isEndOne);
    
    // new algorithm: reuse angles from multiplicity to know which side it goes on
    // 8 cases in total
    var wall = this.whichWall(isEndOne); 
    
    // slope angle of the association
    var angle = perimeterOne.slopeAngle360(perimeterTwo);
    if (wall == "North")
    {
      if (angle < 90)
      {
        // role goes on left of multiplicity
        rolePosition = multPosition.subtract(roleLength).subtract(multLength);
      }
      else
      {
        // role goes on right of multiplicity
        rolePosition = multPosition.add(multLength).add(space);
      }
      // re adjust position if multiplicity is "*"
      if (multiplicity == "*") rolePosition = rolePosition.subtract(new UmplePosition(0,6,0,0));
    }
    else if (wall == "East")
    {
      // role goes on right 
      rolePosition = multPosition.add(multLength).add(space);
    }
    else if (wall == "South")
    {
      if (angle <= 270)
      {
        // role goes on right 
        rolePosition = multPosition.add(multLength).add(space);
      }
      else
      {
        // role goes on left
        rolePosition = multPosition.subtract(roleLength).subtract(multLength);
      }
    }
    else
    {
      // role goes on left
      rolePosition = multPosition.subtract(roleLength).subtract(multLength);
    }
    return rolePosition;  
  }
  
  this.adjustRolePosition = function(labelPosition, isAssociationEndOne)
  {
    var multiplicityLength = isAssociationEndOne ? this.multiplicityOne.length : this.multiplicityTwo.length;
    //Move the label over by the length of the multiplicity label and a space
    labelPosition.x += 5*multiplicityLength + 6;
    return labelPosition;
  }

  this.createBaseJQueryObject = function()
  {
    return jQuery(format("<div class='{0}'></div>", this.getName()))
  }
}