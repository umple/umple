// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Drawing lines in the graphical view of UmpleOnline

function UmpleLine(pointA, pointB)
{
  this.pointOne = pointA;
  this.pointTwo = pointB;

  this.drawable = function(offset)
  {
    var line = jQuery("<div class='umpleLine'></div>");

    var start = UmplePositionFactory.copy(this.pointOne);
    var end = UmplePositionFactory.copy(this.pointTwo);
    
    if (typeof(offset) != "undefined")
    {
      start.x = start.x + offset.x;
      start.y = start.y + offset.y;
      end.x = end.x + offset.x;
      end.y = end.y + offset.y;
    }
  
    var i=0;
    if (start.y == end.y)
    {
      var point = start.x < end.x ? start : end;
      var width = Math.abs(end.x - start.x);

      line.append(this.createConnector(point.x,point.y,width,1));
      line.append(this.createSelector(point.x,point.y,width,6));
    
      return line;
    }
    else if (start.x == end.x)
    {
      var point = start.y < end.y ? start : end;
      var height = Math.abs(end.y - start.y);
    
      line.append(this.createConnector(point.x,point.y,1,height));
      line.append(this.createSelector(point.x,point.y,6,height));
    
    return line;
    }
  
    var slope = this.slope();
    var xDelta = end.x > start.x ? 1 : -1;
    var yDelta = xDelta * slope;
    if (Math.abs(slope) > 1)
    {
      yDelta = end.y > start.y ? 1 : -1;
      xDelta = yDelta * (1 / slope);
    }
  
    var counter = 0;
    var y = start.y;
    for (var x = start.x; (x <= end.x && xDelta > 0) || (x >= end.x && xDelta < 0); x+=xDelta)
    {
      if (counter++ > 1000) break;
    
      line.append(this.createConnector(x,y,1,1));
      line.append(this.createSelector(x,y,6,6));
      y += yDelta;
      i++;
    }
  
    return line;
  }

  this.slope = function()
  {
    slope = (this.pointTwo.y - this.pointOne.y) / (this.pointTwo.x - this.pointOne.x); 
    return slope;
  }

  this.length = function()
  {
    var a = this.pointTwo.x - this.pointOne.x;
    var b = this.pointTwo.y - this.pointOne.y;
    var c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
    return Math.round(c);
  }

  this.createConnector = function(x,y,width,height)
  {
    var connector = jQuery("<div></div>");
    connector.addClass("umpleAssociation");
    connector.attr("name", this.startId);
    connector.css({"position":"absolute", "left":x, "top":y, "width":width, "height":height});
  
    return connector;
  }

  this.createSelector = function(x,y,width,height)
  {
    var selector = jQuery("<div></div>");
    selector.addClass("umpleAssociationSelector");
    selector.attr("name", this.startId);
    selector.css({"position":"absolute", "left":x, "top":y, "width":width, "height":height});
   
    return selector;
  }

  this.intersection = function(otherLine)
  {
    var x1 = this.pointOne.x;
    var y1 = this.pointOne.y;
    var x2 = this.pointTwo.x;
    var y2 = this.pointTwo.y;
  
    var x3 = otherLine.pointOne.x;
    var y3 = otherLine.pointOne.y;
    var x4 = otherLine.pointTwo.x;
    var y4 = otherLine.pointTwo.y;
  
    var slope1 = this.slope();
    var slope2 = otherLine.slope();
    
    var intersectX = null;
    var intersectY = null;
    var yIntercept1 = null;
    var yIntercept2 = null;
    var found = false;
    
    if (slope1 == slope2) 
    {
      return null;
    }
    
    if (slope1 == Infinity || slope1 == -Infinity)
    {
      yIntercept2 = y3 - slope2*x3;
      intersectX = x1;
      intersectY = slope2*intersectX + yIntercept2;
      found = true;
    }
    else if (slope2 == Infinity || slope2 == -Infinity)
    {
      yIntercept1 = y1 - slope1*x1;
      intersectX = x3;
      intersectY = slope1*intersectX + yIntercept1;
      found = true;
    }
    
    if (!found)
    {
      yIntercept1 = y1 - slope1*x1;
      yIntercept2 = y3 - slope2*x3;
    
      intersectX = (yIntercept2 - yIntercept1) / (slope1 - slope2);
      intersectY = slope1*intersectX + yIntercept1;
    }
    
    var largerX1 = (x2 > x1)? x2 : x1;
    var largerX2 = (x4 > x3)? x4 : x3;
    var largerY1 = (y2 > y1)? y2 : y1;
    var largerY2 = (y4 > y3)? y4 : y3;
    var smallerX1 = (largerX1 == x2) ? x1 : x2;
    var smallerX2 = (largerX2 == x4) ? x3 : x4;
    var smallerY1 = (largerY1 == y2) ? y1 : y2;
    var smallerY2 = (largerY2 == y4) ? y3 : y4;
    
    if (intersectX < smallerX1 || intersectX < smallerX2  ||
        intersectX > largerX1  || intersectX > largerX2   ||
        intersectY < smallerY1 || intersectY < smallerY2  ||
        intersectY > largerY1  || intersectY > largerY2) 
    {
  	  return null;
    }
  
    intersectX = Math.round(intersectX);
    intersectY = Math.round(intersectY);
    
    return new UmplePosition(intersectX,intersectY,0,0);
  }
}