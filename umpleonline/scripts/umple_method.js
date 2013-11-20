// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models methods in the graphical view of UmpleOnline

UmpleMethodFactory = new Object();

UmpleMethodFactory.create = function(data)
{
  var umpleMethod = new UmpleMethod(data.visibility, data.type, data.name, data.parameters);
  return umpleMethod;
}

function UmpleMethod(aVisibility, aType, aName, theParameters)
{
  this.visibility = aVisibility;
  this.type = aType;
  this.name = aName;
  this.parameters = (typeof(theParameters) == "string" ? theParameters.split(",") : theParameters);
  //console.log(typeof(theParameters) + ":" + theParameters);
  //console.log(typeof(this.parameters) + ":" + this.parameters);
  //Had to resort to this cheap hack. I have no idea why it was sometimes an array and sometimes a String


  this.set = function(input)
  {
    var isExisting = (this.name != "");

    if (isExisting)
    {
      this.oldVisibility = this.visibility;
      this.oldType = this.type;
      this.oldName = this.name;
      this.oldParameters = this.parameters;
    }

    input = input.trim();
    var sign = input.charAt(0);

    if(sign == "+")
    {
      this.visibility = "public";
      input = input.substr(1);
    }
    else if(sign == "-")
    {
      this.visibility = "private";
      input = input.substr(1);
    }
    else if(sign == "#")
    {
      this.visibility = "protected";
      input = input.substr(1);
    }
    else
      this.visibility = "public";    

    var data = input.split(":");

    if (data.length < 2)
    {
      this.type = "void";
      this.name = input.substring(0,input.indexOf("(")).trim();
      this.parameters = input.match("\\((.*)\\)")[1].replace(/\s+/g, "").split(",");
    }
    else
    {
      var nameandargs = data[0].trim();
      this.type = data[1].trim();
      this.name = nameandargs.substring(0,nameandargs.indexOf("(")).trim();
      this.parameters = nameandargs.match("\\((.*)\\)")[1].replace(/\s+/g, "").split(",");
      
    }
    if (!isExisting)
    {
      this.newVisibility = this.visibility;
      this.newType = this.type;
      this.newName = this.name;
      this.newParameters = this.parameters;
    }

  }

  this.copy = function()
  {
    return new UmpleMethod(this.visibility, this.type, this.name, this.parameters);
  }





}
