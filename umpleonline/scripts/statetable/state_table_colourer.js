var StateTable = {}

//////////////////////////////////////////////////////////////
//                      STATENODE CLASS                     //
//////////////////////////////////////////////////////////////
function StateNode(parent, id) 
{
  this.parent = parent;
  this.id = id;
  this.activeColour = null;
  this.passiveColor = null;
};

StateNode.prototype.getParent = function() 
{
  return this.parent;
};

StateNode.prototype.getRoot = function() 
{
  var currentNode = this;
  var prevNode = null;
  while(currentNode !== null) 
  {
    prevNode = currentNode;
    currentNode = currentNode.getParent();
  }

  return prevNode;
};

StateNode.prototype.getId = function() 
{
  return this.id;
};

StateNode.prototype.getDepth = function() 
{
  var currentNode = this;
  var depth = 0;
  while(currentNode !== null) 
  {
    currentNode = currentNode.getParent();
    depth++;
  }

  return depth;
};

//////////////////////////////////////////////////////////////
//                    STATECOLOURER CLASS                   //
//////////////////////////////////////////////////////////////
function StateColourer(numShades, numStateFamilies) 
{
  this.numShades = numShades;
  this.numColours = numStateFamilies;
  this.cachedColours = this.baseColours.slice();
};

StateColourer.prototype.passiveColour = "999999"; //Gray

StateColourer.prototype.baseColours = 
[
  "CC99A2", //Pink 
  "9AAFAF", //Light blue
  "FFFF7F", //Light yellow
  "98FB98", //Light green
  "9DD6D6", //Light turquoise
  "D2AB6F", //Light brown
  "B19CD9" //Light purple
];

StateColourer.prototype.getBasePassiveColour = function()
{
  var returnedColour = this.passiveColour;

  for(var i = 0; i < (5 - this.numShades) && i < 3; i++)
  {
    returnedColour = this.lighten(returnedColour);
  }

  return returnedColour;
}

StateColourer.prototype.getBaseColour = function(colourId)
{
  var returnedColour;

  if(colourId < this.cachedColours.length)
  {
    returnedColour = this.cachedColours[colourId];
  }
  else
  {
    colourId = colourId%this.cachedColours.length;
    returnedColour = this.modifyColour(this.cachedColours[colourId]);
    this.cachedColours[colourId] = returnedColour;
  }

  for(var i = 0; i < (5 - this.numShades) && i < 3; i++)
  {
    returnedColour = this.lighten(returnedColour);
  }

  return returnedColour;
};

StateColourer.prototype.getLightenAmount = function()
{
  return 15;
}

StateColourer.prototype.getModifyAmount = function()
{
  return 20;
}

StateColourer.prototype.modifyColour = function(colour)
{
  var colour = this.createColour(colour);
  var max, min;
  if(colour.red > colour.blue) 
  {
    if(colour.red > colour.green) 
    {
      colour.red -= this.getModifyAmount();
      if(colour.blue > colour.green) colour.green += this.getModifyAmount();
      else colour.blue += this.getModifyAmount();
    }
    else
    {
      colour.green -= this.getModifyAmount();
      colour.blue += this.getModifyAmount();
    }
  }
  else
  {
    if(colour.blue > colour.green)
    {
      colour.blue -= this.getModifyAmount();
      if(colour.red > colour.green) colour.green += this.getModifyAmount();
      else colour.red += this.getModifyAmount();
    }
    else
    {
      colour.blue -= this.getModifyAmount();
      colour.red += this.getModifyAmount();
    }
  }

  return colour.toHex();
};

StateColourer.prototype.lighten = function(colour) 
{
  var colour = this.createColour(colour);
  var amount = this.getLightenAmount();
  colour.modifyRed(amount);
  colour.modifyBlue(amount);
  colour.modifyGreen(amount);
  return colour.toHex();
};

StateColourer.prototype.createColour = function(colour) 
{
  var num = parseInt(colour, 16);
  var r = (num >> 16);
  var b = ((num >> 8) & 0x00FF);
  var g = (num & 0x0000FF);

  return new Colour(r, b, g);
};

//////////////////////////////////////////////////////////////
//                      COLOUR OBJECT                       //
//////////////////////////////////////////////////////////////
function Colour(red, blue, green)
{
  this.red = red;
  this.blue = blue;
  this.green = green;
};

Colour.prototype.modifyRed = function(value)
{
  this.red += value;
  if(this.red > 255) this.red = 255;
  else if(this.red < 0) this.red = 0;
}

Colour.prototype.modifyBlue = function(value)
{
  this.blue += value;
  if(this.blue > 255) this.blue = 255;
  else if(this.blue < 0) this.blue = 0;
}

Colour.prototype.modifyGreen = function(value)
{
  this.green += value;
  if(this.green > 255) this.green = 255;
  else if(this.green < 0) this.green = 0;
}

Colour.prototype.modifyByName = function(colourName, value)
{
  if(colourName !== "red" && colourName !== "blue" && colourName !== "green")
    throw "Not a valid colour name";
}

Colour.prototype.toHex = function()
{
  var newColour = this.green | (this.blue << 8) | (this.red << 16); 
  return newColour.toString(16);
};

//////////////////////////////////////////////////////////////
//                   STATETABLE FUNCTIONS                   //
//////////////////////////////////////////////////////////////
StateTable.init = function(table) 
{
  StateTable.stateNodes = [];

  StateTable.table = table;

  if(StateTable.table.hasClass("event-statetable")) 
  {
    StateTable.type = "event";
  } 
  else if(StateTable.table.hasClass("state-statetable")) 
  {
    StateTable.type = "state";
  } 
  else 
  {
    console.log("Unknown state table type");
    StateTable.type = "unknown";
  }
};

StateTable.createState = function(stateRow, id) 
{
  var parentId = parseInt(stateRow.attr("data-parent"));
  var parent = StateTable.stateNodes[parentId];

  if(isNaN(parentId)) 
  {
    parent = null;
  } 

  return new StateNode(parent, id);
};

StateTable.readTable = function() 
{
  var rows = StateTable.table.find("tr");

  //process first entry in each row (except the first) to get the state tree
  var id = 0;

  for(var i = 1; i < rows.length; i++) 
  {
    var entry = jQuery(rows[i]).find("td")[0];
    StateTable.stateNodes.push(StateTable.createState(jQuery(entry), id));
    id++;
  }
};

StateTable.maxDepth = function() 
{
  var max = 0;
  var stateDepth;
  for(var i = 0; i < StateTable.stateNodes.length; i++) 
  {
    stateDepth = StateTable.stateNodes[i].getDepth();

    if(stateDepth > max) max = stateDepth;
  }

  return max;
};

StateTable.numStateFamilies = function() 
{
  numStateFamilies = 0;
  for(var i = 0; i < StateTable.stateNodes.length; i++) 
  {
    if(StateTable.stateNodes[i].getParent() === null)
      numStateFamilies++;
  }

  return numStateFamilies;
};

StateTable.colour = function() 
{
  var colourer = new StateColourer(StateTable.maxDepth(), 
    StateTable.numStateFamilies);

  //Assign each state their passive and active colours
  var colourId = 0;
  var stateNode;

  for(var i = 0; i < StateTable.stateNodes.length; i++) 
  {
    stateNode = StateTable.stateNodes[i];
    //Non-child state
    if(stateNode.getParent() === null)
    {
      stateNode.passiveColour = colourer.getBasePassiveColour();
      stateNode.activeColour = colourer.getBaseColour(colourId++);
    } 
    else //Child state 
    {
      stateNode.passiveColour = colourer.lighten(
        stateNode.getParent().passiveColour);
      stateNode.activeColour = colourer.lighten(
        stateNode.getParent().activeColour);
    }
  }

  //Colour the states
  var rows = StateTable.table.find("tr");
  var rowEntries, rowState, cell;

  //Colour the header
  if(StateTable.type === "state") 
  {
    rowEntries = jQuery(rows[0]).find("td");
    for(var i = 1; i < rowEntries.length; i++) 
    {
      jQuery(rowEntries[i]).css("background-color", "#" +
        StateTable.stateNodes[i - 1].activeColour);
    }
  }

  //Colour the rest of the table
  for(var i = 1; i < rows.length; i++) 
  {
    rowState = StateTable.stateNodes[i - 1];
    rowEntries = jQuery(rows[i]).find("td");

    cell = jQuery(rowEntries[0]);
    cell.css("background-color", "#" + rowState.activeColour);

    for(var j = 1; j < rowEntries.length; j++) 
    {
      cell = jQuery(rowEntries[j]);
      if(cell.text().match(/^\s$/)) {
        cell.css("background-color", "#" + rowState.passiveColour);
      }
      else
        cell.css("background-color", "#" + rowState.activeColour);
    }
  }
};