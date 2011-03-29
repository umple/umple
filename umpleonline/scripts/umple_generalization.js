
function UmpleGeneralization()
{
  this.parentId = null;
  this.childId = null;
  this.parentPosition = null;
  this.childPosition = null;
  this.id = null;
  
  this.setClasses = function(aChildId,aParentId)
  {
    this.childId = aChildId;
    this.parentId = aParentId;
  }
  
  this.setChildId = function(aChildId)
  {
  	this.childId = aChildId;
  }
  
  this.setParentId = function(aParentId)
  {
  	this.parentId = aParentId;
  }
  
  this.getElementId = function()
  {
    return this.id == null ? "newgeneralization" : this.id;
  }
  
  this.getChildId = function()
  {
    return this.childId;
  }
  
  this.getParentId = function()
  {
    return this.parentId;
  }
  
  this.drawable = function(isPermanent)
  {
  	if (isPermanent == undefined) isPermanent = true;
  	
  	if (this.childId == null || this.childId == undefined) 
  	{
  	  return null;
  	}
  	
  	var generalizationSel = "#" + this.childId + "_generalization"; 
  	jQuery(generalizationSel).remove();
  	var generalizationDiv = jQuery("<div></div>");
  	
  	var idValue = isPermanent ? this.childId + "_generalization" : "newgeneralization";
    var classValue = "umpleGeneralization";
    generalizationDiv.attr("id", idValue);
    generalizationDiv.addClass(classValue);
    
  	var triangleHeight = new UmplePosition(0,10,0,0); 
    var triangleBase = new UmplePosition(15,0,0,0);
    var tipLength = new UmplePosition(0,22,0,0);
    
    var lineStart = this.childPosition;
    var offsetInChild = new UmplePosition(this.childPosition.width/2,0,0,0);
    var lineEnd = this.parentPosition;
    var offsetInParent = new UmplePosition(this.parentPosition.width/2,this.parentPosition.height,0,0);
    offsetInParent = offsetInParent.add(triangleHeight).add(tipLength);
    
    lineEnd = lineEnd.add(offsetInParent);
    lineStart = lineStart.add(offsetInChild);
    
    var leftBound = this.childPosition.x;
    var rightBound = this.childPosition.x + this.childPosition.width;
    var bottomBound = this.childPosition.y + this.childPosition.height;
    var topBound = this.childPosition.y;
    var drawVertical = true;
    
    if (lineEnd.y > topBound)
    {
      if (lineEnd.y < bottomBound)
      {
      	if (Math.abs(lineEnd.x - rightBound) < Math.abs(lineEnd.x - leftBound)) 
      	{
      	  lineStart = lineStart.add(new UmplePosition(this.childPosition.width/2,0,0,0));
      	  lineStart.y = lineEnd.y;
      	  drawVertical = false;
      	}
        else 
        {
          lineStart = lineStart.subtract(new UmplePosition(this.childPosition.width/2,0,0,0));
          lineStart.y = lineEnd.y;
          drawVertical = false;
        } 	
      }
	  else {lineStart = lineStart.add(new UmplePosition(0,this.childPosition.height,0,0));}
    }
    
    var lineBreak = new UmplePosition(lineStart.x, lineEnd.y);
    if (drawVertical)
    {
      var verticalLine = new UmpleLine(lineBreak.add(UmpleClassFactory.verticalError), lineEnd.add(UmpleClassFactory.verticalError));
      var horizontalLine = new UmpleLine(lineStart.add(UmpleClassFactory.verticalError), lineBreak.add(UmpleClassFactory.verticalError));
      generalizationDiv.append(verticalLine.drawable());
    }
    else
    { 
      var horizontalLine = new UmpleLine(lineStart.add(UmpleClassFactory.verticalError), lineEnd.add(UmpleClassFactory.verticalError));
    } 
    generalizationDiv.append(horizontalLine.drawable());
    
    var tipStart = lineEnd;
    var tipEnd = lineEnd.subtract(tipLength);
    var tipLine = new UmpleLine(tipStart.add(UmpleClassFactory.verticalError),tipEnd.add(UmpleClassFactory.verticalError));
    generalizationDiv.append(tipLine.drawable());
      	
    var verticeA = tipEnd.subtract(new UmplePosition(triangleBase.x/2,0,0,0));
    var verticeB = verticeA.add(triangleBase);
    var verticeC = tipEnd.subtract(triangleHeight);
    var triangleBase = new UmpleLine(verticeA.add(UmpleClassFactory.verticalError), verticeB.add(UmpleClassFactory.verticalError));
    var triangleLeft = new UmpleLine(verticeA.add(UmpleClassFactory.verticalError), verticeC.add(UmpleClassFactory.verticalError));
    var triangleRight = new UmpleLine(verticeB.add(UmpleClassFactory.verticalError), verticeC.add(UmpleClassFactory.verticalError));
    
    generalizationDiv.append(triangleBase.drawable());
    generalizationDiv.append(triangleRight.drawable());
    generalizationDiv.append(triangleLeft.drawable());
    
    var hoverOffset = new UmplePosition(3,3,0,0);
    var hoverPoint1 = lineStart.subtract(hoverOffset);
    var hoverPoint2 = tipEnd.subtract(hoverOffset);
    var hoverPoint3 = tipStart.subtract(hoverOffset);
    var hoverHtml = "";
    hoverHtml += this.anchorDivHtml("hover",0,hoverPoint1.x,hoverPoint1.y);
    hoverHtml += this.anchorDivHtml("anchor",0,hoverPoint1.x,hoverPoint1.y); 
    hoverHtml += this.anchorDivHtml("hover",1,hoverPoint2.x,hoverPoint2.y);
    hoverHtml += this.anchorDivHtml("anchor",1,hoverPoint2.x,hoverPoint2.y);
    hoverHtml += this.anchorDivHtml("hover",2,hoverPoint3.x,hoverPoint3.y);
    hoverHtml += this.anchorDivHtml("anchor",2,hoverPoint3.x,hoverPoint3.y);
    
    var currentHtml = generalizationDiv.html();
    generalizationDiv.html(hoverHtml + currentHtml);
    
    return generalizationDiv;
  }
  
  this.anchorDivHtml = function(type,index,x,y)
  {
    return format('<div id="{0}_{1}{2}" class="{1}" name="{1}" style="left: {3}px; top: {4}px; cursor: pointer; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.childId + "_generalization",type,index,x,y);
  }
}
