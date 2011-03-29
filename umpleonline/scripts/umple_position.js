
UmplePositionFactory = new Object();

UmplePositionFactory.copy = function(position)
{
  return new UmplePosition(position.x,position.y,position.width,position.height);
}

function UmplePosition(aX, aY, aWidth, aHeight)
{
  this.x = aX;
  this.y = aY;
  this.width = aWidth;
  this.height = aHeight;
  
  this.set = function(aX,aY)
  {
    this.x = aX;
    this.y = aY;
  }

  this.subtract = function(other)
  {
    return new UmplePosition(this.x - other.x, this.y - other.y, this.width - other.width, this.height - other.height);
  }
  
  this.add = function(other)
  {
    if (other == null)
    {
      return UmplePositionFactory.copy(this);
    }
    return new UmplePosition(this.x + other.x, this.y + other.y, this.width + other.width, this.height + other.height);
  }
  
  this.slopeAngle = function(pointB)
  {
    return this.slopeAngleAndQuadrant(pointB)[0];
  }
  
  this.quadrant = function(pointB)
  {
    return this.slopeAngleAndQuadrant(pointB)[1];
  }
 
  this.equalsIgnoreSize = function(aPosition)
  {
  	if (this.x != aPosition.x)
  	{
  	  return false;
  	}
  	if (this.y != aPosition.y)
  	{
  	  return false;
  	}
  	return true;
  }
  
  this.slopeAngleAndQuadrant = function(pointB)
  {
    var lengthY = pointB.y - this.y;
    var lengthX = this.x - pointB.x;
    
    var slope = lengthY / lengthX;
    var angle = Math.atan(slope) * 180.0 / 3.14159;
    
    var topRight = lengthY >= 0 && lengthX >= 0;
    var topLeft = lengthY >= 0 && lengthX < 0;
    var bottomRight = lengthY < 0 && lengthX >= 0;
    var bottomLeft = lengthY < 0 && lengthX < 0;
    
    var quadrant = topRight ? "top-right" : topLeft ? "top-left" : bottomRight ? "bottom-right" : "bottom-left";
    return [angle,quadrant];  
  }
  
  this.slopeAngle360 = function(pointB)
  {
    var slopeAngle;
    if (this.y == pointB.y)
    {
      if (this.x > pointB.x) return 180;
      else return 0;
    }
    var lengthY = pointB.y - this.y;
    var lengthX = pointB.x - this.x;
    var slope = lengthX / lengthY;
  
    if (pointB.y < this.y)
    {
      slopeAngle = 90 + Math.atan(slope) * 180/3.14159;    	
    }
    else
    {
      slopeAngle = 270 + Math.atan(slope) * 180/3.14159;
    }
    
    return Math.round(slopeAngle);
  }
  
  this.travelForward = function(distance, slopeAngle)
  {
    var result = new UmplePosition(0,0,0,0);
    var deltaX = 0;
    var deltaY = 0;
    
    if (slopeAngle >= 0 && slopeAngle < 90)
    {
      deltaX = Math.cos(slopeAngle*3.14159/180.0)*distance;
      deltaY = Math.sin(slopeAngle*3.14159/180.0)*distance;
      result.x = this.x + deltaX;
      result.y = this.y - deltaY;
    }
    else if (slopeAngle >= 90 && slopeAngle < 180)
    {
      slopeAngle -= 90;
      deltaX = Math.sin(slopeAngle*3.14159/180.0)*distance;
      deltaY = Math.cos(slopeAngle*3.14159/180.0)*distance;
      result.x = this.x - deltaX;
      result.y = this.y - deltaY;
    }
    else if (slopeAngle >= 180 && slopeAngle < 270)
    {
      slopeAngle -= 180;
      deltaX = Math.cos(slopeAngle*3.14159/180.0)*distance;
      deltaY = Math.sin(slopeAngle*3.14159/180.0)*distance;
      result.x = this.x - deltaX;
      result.y = this.y + deltaY;
    }
    else
    {
      slopeAngle -= 270;
      deltaX = Math.sin(slopeAngle*3.14159/180)*distance;
      deltaY = Math.cos(slopeAngle*3.14159/180)*distance;
      result.x = this.x + deltaX;
      result.y = this.y + deltaY;
    }
    
    result.x = Math.round(result.x);
    result.y = Math.round(result.y);
    return result;
  }
  
  this.wallsAreAdjacent = function(w1, w2)
  {
  	if (w1 == w2) return false;
  	if (w1 == "West" && w2 == "East") return false;
	if (w1 == "East" && w2 == "West") return false;
	if (w1 == "North" && w2 == "South") return false;
	if (w1 == "South" && w2 == "North") return false;
    return true;    
  }
  
  
  this.areAnglesSimilar = function(one,two)
  {
    var delta = 3;
    return Math.abs(one - two) <= delta;
  }
  
  this.toString = function()
  {
  	return "(" + this.x + "," + this.y + "," + this.width + "," + this.height + ")";
  }
  
}