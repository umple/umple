// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models classes in the graphical view of UmpleOnline

UmpleClassFactory = new Object();
UmpleClassFactory.defaultSize = new UmplePosition(0,0,109,41);
UmpleClassFactory.offsetError = new UmplePosition(0,0,0,0);

UmpleClassFactory.create = function(data)
{
  var umpleClass = new UmpleClass();
  umpleClass.id = data.id;
  umpleClass.name = data.name;
  umpleClass.isInterface = data.isInterface;
  umpleClass.displayColor = data.displayColor;
  if(umpleClass.displayColor == "") umpleClass.displayColor="transparent";  
  umpleClass.position.x = data.position.x;
  umpleClass.position.y = data.position.y;
  umpleClass.position.width = data.position.width;
  umpleClass.position.height = data.position.height;
  umpleClass.extendsClass = data.extendsClass;

  for (var i = 0; i < data.attributes.length; i++)
  {
    if(data.attributes[i].modifier == "const") 
    {
      continue;
    }
    umpleClass.attributes.push(UmpleAttributeFactory.create(data.attributes[i]));
  }
  for (var i = 0; i < data.methods.length; i++)
  {
    umpleClass.methods.push(UmpleMethodFactory.create(data.methods[i]));
  }  
  return umpleClass;
}

UmpleClassFactory.perimeterPosition = function(umpleClass, currentPosition, offset)
{
  if (typeof(offset) == "undefined")
  {
    offset = new UmplePosition(0,0,0,0);
  }

  var x = currentPosition.x;
  var y = currentPosition.y;

  var delta = 0;
  var minX = offset.x + umpleClass.position.x + delta;
  var maxX = minX + umpleClass.position.width;

  var minY = offset.y + umpleClass.position.y + delta;
  var maxY = minY + umpleClass.position.height;
  
  var realX = x < minX  ? minX  : x > maxX  ? maxX : x;
  var realY = y < minY ? minY : y > maxY ? maxY : y;

  var minXDelta = x - minX;
  var maxXDelta = maxX - x;
  var minYDelta = y - minY;
  var maxYDelta = maxY - y;

  var deltaX = Math.min(minXDelta,maxXDelta);
  var deltaY = Math.min(minYDelta,maxYDelta);
  

  if (deltaX < deltaY)
  {
    realX = minXDelta < maxXDelta ? minX : maxX;
  }
  else if (deltaY < deltaX)
  {
    realY = minYDelta < maxYDelta ? minY : maxY;
  }
  
  return new UmplePosition(Math.round(realX),Math.round(realY),0,0);
}



function UmpleClass()
{
  this.id;
  this.name;
  this.isInterface;
  this.displayColor = "transparent";
  this.position = new UmplePosition(0,0,109,41);
  this.attributes = [];
  this.methods = [];
  this.extendsClass;

  this.addAttribute = function(typeAndName)
  {
    var attribute = new UmpleAttribute("","","");
    attribute.set(typeAndName);
    this.attributes.push(attribute);
    return this.attributes.length - 1;
  }
  
  this.removeAttribute = function(index)
  {
    var attribute = this.attributes[index];
    attribute.deleteType = attribute.type;
    attribute.deleteName = attribute.name;
  }
  
  this.resetAttribute = function(index)
  {
    if (this.attributes[index].deleteName != null)
    {
      this.attributes.splice(index,1);
    }
    else
    {
      this.attributes[index] = this.attributes[index].copy();
    }
  }

  this.resetMethod = function(index)
  {
    if(this.methods[index].deleteName != null)
    {
      this.methods.splice(index,1);
    }
    else
    {
      this.methods[index] = this.methods[index].copy();
    }
  }


  this.addMethod = function(data)
  {
    var method = new UmpleMethod("","","","");
    method.set(data);
    this.methods.push(method);
    return this.methods.length - 1;
  }

  this.removeMethod = function(index)
  {
    var method = this.methods[index];
    method.deleteType = method.type;
    method.deleteVisibility = method.visibility;
    method.deleteName = method.name;
    method.deleteParameters = method.parameters;
  }





  this.setExtendsClass = function(umpleClassId)
  {
    this.extendsClass = umpleClassId;
  }
  
  this.removeExtendsClass = function()
  {
    this.extendsClass = null;
  }
  
  // Used by trimOverlap to enable associations to line up properly
  this.borderLines = function()
  {
    var classObj = jQuery("#" + this.id);
    var width = classObj.width();
    var height = classObj.height();

    var topLeft = this.position;
    var topRight = this.position.add(new UmplePosition(width,0,0,0));
    var bottomLeft = this.position.add(new UmplePosition(0,height,0,0));
    var bottomRight = this.position.add(new UmplePosition(width,height,0,0));

    borders = [];
    borders.push(new UmpleLine(topLeft, topRight));
    borders.push(new UmpleLine(topLeft, bottomLeft));
    borders.push(new UmpleLine(bottomLeft, bottomRight));
    borders.push(new UmpleLine(topRight, bottomRight));
    
    return borders;
  }
         
  this.drawable = function()
  {
    var classDiv = this.drawClass();
  var generalizationDiv = this.drawGeneralization();
  var divs = [classDiv,generalizationDiv];
    return divs;
  }
  
  this.drawClass = function()
  {
    var classSel = "#" + this.id;
    var existingClassDiv = jQuery(classSel).get();
    
    if (existingClassDiv == undefined || existingClassDiv == null || existingClassDiv == "")
    {
      classDiv = jQuery("<div></div>");
      classDiv.addClass("umpleClass");
    }
    else
    {
      classDiv = jQuery(existingClassDiv);
      removalSel = format("div#{0} .classTable," +
           "div#{0} .umpleAttribute," +
           "div#{0} .umpleAttributeNew," +
           "div#{0} .anchor, " +
           "div#{0} .hover", this.id);
      jQuery(removalSel).remove();
    }
    
    classDiv.attr("id", this.id);
        
    var offset = -3.5;
    var bottomOffset = -3;
     
    var attributesInnerHtml = '';
    var methodsInnerHtml = '';
    var classInnerHtml = '';

    if (this.attributes.length > 0)
    {
      // For each attribute, output the html
      for (var i=0; i<this.attributes.length; i++)
      { 
        var attr = this.attributes[i];

        var colorStyle = ""
        if(attr.textColor != "black") colorStyle = format("style='color:{0}'", attr.textColor);

        if (Page.isPhotoReady())
        {
          attributesInnerHtml += format('<div class="umpleAttribute" {3}>{0} : {1}</div>',attr.name,attr.type, colorStyle);
        }
        else
        {
          attributesInnerHtml += format('<div class="umpleAttribute" {5}><span id="{2}_attribute_{3}" name="attributeEdit" class="editable editableDoubleClick">{0} : {1}</span> <img src="scripts/delete2.jpg" onclick="DiagramEdit.attributeDelete({4}{2}{4},{4}{3}{4})" /></div>',attr.name,attr.type,this.id,i,"'",colorStyle);
        }
      }
    } // End of loop adding attributes
    
    if(this.methods.length > 0)
    {
      for(var i = 0; i<this.methods.length;i++)
      {
        var method = this.methods[i];

        var visibility="";
        if(method.visibility == "public")
          visibility = "+ ";
        else if(method.visibility == "private")
          visibility = "- ";
        else if(method.visibility == "protected")
          visibility = "# ";
        else
          visibility = "+ ";   //set default visibility to public

        var methodtype = (method.type == "" ?  "void" : method.type)
   
        if(Page.isPhotoReady())
        {
          methodsInnerHtml += format('<div class="umpleMethod">{3}{1}({2}) : {0}</div>',methodtype,method.name,method.parameters,visibility);
        }
        else
          methodsInnerHtml += format('<div class="umpleMethod"><span id="{4}_method_{5}" name="methodEdit" class="editable editableDoubleClick">{3}{1}({2}) : {0}</span> <img src="scripts/delete2.jpg" onclick="Action.methodDelete({6}{4}{6},{6}{5}{6})" /></div>',methodtype,method.name,method.parameters,visibility,this.id,i,"'");

      }
    }
    
    attributesInnerHtml += format('<div class="umpleAttributeNew"><span id="{0}_newAttribute" name="attributeNew" class="editable editableSingleClick">{1}</span></div>',this.id,Page.isPhotoReady() ? '&nbsp;' : '-- Add More --');

    methodsInnerHtml += format('<div class="umpleMethodNew"><span id="{0}_newMethod" name="methodNew" class="editable editableSingleClick">{1}</span></div>',this.id,Page.isPhotoReady() ? '&nbsp;' : '-- Add More --');

    if (!Page.isPhotoReady())
    {
// The following commented out to remove unneeded hovers that are not selectable anyway
// Similar code removed from UmpleClass.drawClass
/*
      classInnerHtml +=
      this.anchorDivHtml("anchor",0) +
      this.anchorDivHtml("anchor",1) +
      this.anchorDivHtml("anchor",2) +
      this.anchorDivHtml("anchor",3) +
      this.anchorDivHtml("anchor",4) +
      this.anchorDivHtml("anchor",5) +
      this.anchorDivHtml("anchor",6) +
      this.anchorDivHtml("anchor",7) +

      this.anchorDivHtml("hover",0) +
      this.anchorDivHtml("hover",1) +
      this.anchorDivHtml("hover",2) +
      this.anchorDivHtml("hover",3) +
      this.anchorDivHtml("hover",4) +
      this.anchorDivHtml("hover",5) +
      this.anchorDivHtml("hover",6) +
      this.anchorDivHtml("hover",7);
*/
    }
    


    rowspan = 3;
    if(Page.showAttributes)
     rowspan+=1;
    if(Page.showMethods)
     rowspan+=1;
      
    classInnerHtml +=
      format(
      '<table bgcolor="'+ this.displayColor+
      '" class="classTable" border="0">', this.id) +
      format(
      '  <tr class="height">' +
      '    <td rowspan="{2}"> <img id="{0}_height" src="scripts/_.gif" style="width:0px;height:{1}px;display:block;"  />' +
      '    </td>' +
      '  </tr>',this.id,this.position.height,rowspan) + 
      '  <tr class="classArea">' +
      '    <td > <img src="scripts/class.png" title="Class" /> ';
    
    

    if (Page.isPhotoReady())
    {
      if (this.isInterface=="true")
      {
        classInnerHtml += format('<span id="{0}_name" name="className">{2}<br>{1}</span>',this.id,this.name," &#171interface&#187");
      }
      else
      {
         classInnerHtml += format('<span id="{0}_name" name="className">{1}</span>',this.id,this.name);
      }
    }
    else
    {
      if (this.isInterface=="true")
      {
        classInnerHtml += format('<span id="{0}_name" name="className" class="editable editableDoubleClick">{2}<br>{1}</span>',this.id, this.name,"&#171interface&#187");
      }
      else
      {
        classInnerHtml += format('<span id="{0}_name" name="className" class="editable editableDoubleClick" >{1}</span>',this.id, this.name);

      }
    }
    
    classInnerHtml += ('</td> ' + '</tr>');


    if(Page.showAttributes == true)
    {  
        classInnerHtml += 
        format(
        '  <tr class="attributeArea">' +
        '    <td class="attributes">{0}' +
        '    </td>' +
        '  </tr>',attributesInnerHtml);

      }
      
      if(Page.showMethods == true)
      {
        classInnerHtml +=
        format(
        '  <tr class="methodArea">' +
        '    <td class="methods">{0}' +
        '    </td>' +
        '  </tr>',methodsInnerHtml);
      }

          classInnerHtml +=
          format(
          '  <tr class="width">' +
          '    <td> <img id="{0}_width" src="scripts/_.gif" style="width:{1}px;height:0px;display:block;"  />' +
          '    </td>' +
          '  </tr>',this.id,this.position.width); 
 
      classInnerHtml += '</table>';
 
    var existing = classDiv.html();
    classDiv.html(classInnerHtml + existing);
  
  return classDiv;
  }
  
  this.drawableClassOutline = function()
  {
    var classSel = "#tempClass";
    var classDiv = jQuery(classSel).get();
    
    if (classDiv == undefined || classDiv == null || classDiv == "")
    {
      classDiv = jQuery("<div></div>");
      classDiv.addClass("umpleClass");
      classDiv.attr("id", this.id);
    }
    else
    {
      classDiv = jQuery(classSel);
    }

    var classInnerHtml =
      '<table class="classTable" "border="0">' +
      format(
      '  <tr class="height">' +
      '    <td rowspan="4"> <img id="{0}_height" src="scripts/_.gif" style="width:0px;height:{1}px;display:block;"  />' +
      '    </td>' +
      '  </tr>',this.id,this.position.height) + 
      '  <tr class="classArea">' +
      '    <td> <img src="scripts/class.png" title="Class" /> ' +
      format(       
      '      <span id="{0}_name" name="className" >{1}</span>',this.id,this.name) +
      '    </td>' +
      '  </tr>' + 
      '  <tr class="attributeArea">' +
      '    <td class="attributes">' +
      '    </td>' +
      '  </tr>' +
      '  <tr class="width">' +
      format(
      '    <td> <img id="{0}_width" src="scripts/_.gif" style="width:{1}px;height:0px;display:block;"  />' +
      '    </td>' +
      '  </tr>',this.id,this.position.width) + 
      '</table>';
    
    classDiv.html(classInnerHtml);
    return classDiv;
  }
  
  this.drawGeneralization = function()
  {
    var parent = UmpleSystem.find(this.extendsClass);
    if (parent == null)
    {
      return null;
    }
    
    var umpleGeneralization = new UmpleGeneralization();
    umpleGeneralization.childId = this.id;
    umpleGeneralization.parentId = parent.id;
    umpleGeneralization.childPosition = this.position;
    umpleGeneralization.parentPosition = parent.position;
    
    generalizationDiv = umpleGeneralization.drawable();
  
    return generalizationDiv;
  }
  
  this.anchorDivHtml = function(type,index)
  {
    return format('<div id="{0}_{1}{2}" class="{3}" name="{4}" style="top: 0px; left: 0px; cursor:{5}; display: none;"><img name="image" src="./scripts/_.gif"/></div>',this.id,type,index,type,type,"move");
  }
  
  

}
