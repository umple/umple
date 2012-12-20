// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models attributes in the graphical view of UmpleOnline

UmpleAttributeFactory = new Object();

UmpleAttributeFactory.create = function(data)
{
  var umpleAttribute = new UmpleAttribute(data.type,data.name);
  return umpleAttribute;
}

function UmpleAttribute(aType,aName)
{
  this.type = aType;
  this.name = aName;
  
  this.set = function(input)
  {
    var isExisting = this.type != "" && this.name != "";
    if (isExisting)
    {
      this.oldType = this.type;
      this.oldName = this.name;
    }
  
    var typeAndName = input.split(":");
    if (typeAndName.length < 2)
    {
      this.type = "String";
      this.name = input;
    }
    else
    {
      this.name = typeAndName[0].trim();
      this.type = typeAndName[1].trim();
    }
    
    if (!isExisting)
    {
      this.newType = this.type;
      this.newName = this.name;
    }
    
  }
  
  this.copy = function()
  {
    return new UmpleAttribute(this.type,this.name);
  }
}