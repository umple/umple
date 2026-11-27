// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for diagram display options: show/hide toggles, filters, mixsets and suboptions

Action.toggleSpecialSuboption = function(suboption) {
  // If suboption  is not in active ones then add it
  var index = Page.specialSuboptionsActive.indexOf(suboption);  
  if(index !== -1) {
    // Turn off suboption if not already on by deleting it
    // This sets some options to the default
    // Suboptions specified in the code always override this though
    Page.specialSuboptionsActive.splice(index,1);
  }
  else {
    // Turn on suboption if off by adding it
    // May have no effect if the code requires a conflicting one
    Page.specialSuboptionsActive.push(suboption);

    // If gvmanual is active, then the options affecting layout
    // will be applied to the manual layout too
    // this is done in Action.updateUmpleDiagramCallback

    // Only one of the layout algorithms can be active at a time
    // so turn off others that are mutually exclusive. These are
    // gvdot, gvsfdp, gvcirco
    Action.deactivateSpecialLayoutAlgorithmsExcept(suboption);
  }
  Action.redrawDiagram();
}


Action.toggleMixsetUseStatement = function(mixset) {
  // If use statement is not in active ones then add it
  var index = Page.mixsetsActive.indexOf(mixset);
  if(index !== -1) {
    Page.mixsetsActive.splice(index,1);
  }
  else {
    Page.mixsetsActive.push(mixset);
  }

  Action.redrawDiagram();
}

Action.toggleFilterUseStatement = function(filter) {
  // If use statement is not in active ones then add it
  var index = Page.filtersActive.indexOf(filter);
  if(index !== -1) {
    Page.filtersActive.splice(index,1);
  }
  else {
    Page.filtersActive.push(filter);
  }

  Action.redrawDiagram();
}

Action.photoReady = function()
{
  var canvasSel = "#" + Page.umpleCanvasId();
  if (Page.isPhotoReady())
  {
    jQuery(canvasSel).addClass("photoReady");
  }
  else
  {
    jQuery(canvasSel).removeClass("photoReady");
  }
  
  UmpleSystem.redrawCanvas();
}

Action.customSizeTyped = function()
{
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  
  var width = jQuery("#widthField").val();
  var height = jQuery("#heightField").val();
  
  Action.oldTimeout = setTimeout(function(){ Page.setUmpleCanvasSize(width, height); }, Action.waiting_time);
}

// Processes the filter
// If an integer treated as hops
// Then could be suboptions
// Second could be mixsets to turn on
// Otherwise treated as class filter patterns
Action.setFilterFull = function(newFilter, doRedraw)
{
  // Reset first
  Page.filterWordsOutput = "";
  
  var filterWordsInput=newFilter.split(" ").filter(word => word.trim() !== '');

  filterWordsInput.forEach(function(foundFilterWord) {
    var actualFilterWord = foundFilterWord;
    if(foundFilterWord.startsWith("gvseparator=")) {
      // transform any dot decimal so it does not get split in transfer
      actualFilterWord=foundFilterWord.replace(".","@@@");
    }
    
    Page.filterWordsOutput+=(actualFilterWord+"!@");

  });
  if(doRedraw) {
    Action.redrawDiagram();
  }
}

// version of the above that redraws by default
Action.setFilter = function(newFilter)
{
  return Action.setFilterFull(newFilter, true);
}

Action.toggleAttributes = function()
{
  Page.showAttributes = !Page.showAttributes;
  Action.redrawDiagram();
}
  
Action.toggleMethods = function()
{
  Page.showMethods = !Page.showMethods;
  Action.redrawDiagram();
}

Action.toggleActions = function()
{
  Page.showActions = !Page.showActions;
  Action.redrawDiagram();
}

Action.toggleTransitionLabels = function()
{
  Page.showTransitionLabels = !Page.showTransitionLabels;
  Action.redrawDiagram();
}

Action.toggleGuards = function()
{
  Page.showGuards = !Page.showGuards;
  Action.redrawDiagram();
}
Action.toggleGuardLabels = function()
{
  Page.showGuardLabels = !Page.showGuardLabels;
  Action.redrawDiagram();
}
Action.toggleNaturalLanguage = function()
{
  Page.showNaturalLanguage = !Page.showNaturalLanguage;
  Action.redrawDiagram();
}
Action.allowPinch = function()
{
  Page.allowPinch = !Page.allowPinch;
  if (Page.allowPinch == false) {
     // has been turned off
     Action.removePinch();
  }
  Action.redrawDiagram();
}
Action.toggleFeatureDependency = function()
{
  Page.showFeatureDependency = !Page.showFeatureDependency;
  Action.redrawDiagram();
}
Action.toggleTraits = function()
{
  Page.showTraits = !Page.showTraits;
  Action.redrawDiagram();
}

Action.enableManualSync = function(enable)
{
  var checkbox = jQuery("#buttonManualSync");
  var syncDiagram = jQuery("#buttonSyncDiagram");
  if (enable == undefined) enable = checkbox.is(":checked");
  
  if (enable)
  {
  Action.manualSync = true;
  }
  else
  {
    Action.manualSync = false;
    Action.processTyping("umpleModelEditorText",true);
    Page.enablePaletteItem("buttonSyncDiagram", false);
  }
}
