// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models history (undo stack) in UmpleOnline

History = new Object();
// History item currently on display; -1 means nothing saved.
History.currentIndex = -1;
// Initially there is nothing saved.
History.oldestAvailableIndex = 0;
History.newestAvailableIndex = 0;
// capacity of the circular structure; we will reuse after cycling through
History.versionCount = 9999;
History.noChange = "//$?[No_Change]$?";
// Initially nothing is saved.
History.firstSave = true;

// Returns the version that had been saved; called when moving forward
// using a 'redo' operation; called from Action.redo
History.getNextVersion = function()
{
  Page.enablePaletteItem("buttonUndo", true);
  
  var result;
  
  if (!History.FirstSave && History.newestAvailableIndex != History.currentIndex)
  {
  	History.currentIndex = History.incrementIndex(History.currentIndex);
  	// Page.catFeedbackMessage("Set history for next to " + History.currentIndex); // DEBUG

  	result = History.getVersion(History.currentIndex);
  	if (result == undefined) result = History.noChange;
  } 
  else
  {
  	result = History.noChange;
  }
  
  if (History.newestAvailableIndex == History.currentIndex)
  {
  	Page.enablePaletteItem("buttonRedo", false);
  }
  
  return result;
}

// Returns the previously saved version in the undo stack
// Moves the pointer back in the undo stack
// Called from Action.undo and also from save in the case of an apparent undo
History.getPreviousVersion = function()
{
  var result;
  
  if (!History.FirstSave && History.oldestAvailableIndex != History.currentIndex)
  {
  	History.currentIndex = History.decrementIndex(History.currentIndex);
  	// Page.catFeedbackMessage("Set history back to " + History.currentIndex); // DEBUG

  	result = History.getVersion(History.currentIndex);
  	
  	if (result == undefined) result = History.noChange;
  	else Page.enablePaletteItem("buttonRedo", true);
  }
  else
  {
    // No previously saved versions
  	result = History.noChange;
  }
  
  if (History.oldestAvailableIndex == History.currentIndex)
  {
  	Page.enablePaletteItem("buttonUndo", false);
  }
  
  return result;
}

// Save a new version of the code
History.save = function(umpleCode, reason)
{
  if (!History.firstSave) 
  {
    // Whenever we save we set the highest saved index
    // So we can't redo
  	Page.enablePaletteItem("buttonRedo", false);
  	  Page.enablePaletteItem("buttonUndo", true);
  } 
  
  var gap = History.distanceBetween(History.oldestAvailableIndex, History.currentIndex);
  if (gap == History.versionCount - 1)
  {
  	History.oldestAvailableIndex = History.incrementIndex(History.oldestAvailableIndex);
  }

  History.currentIndex = History.incrementIndex(History.currentIndex);
  // Page.catFeedbackMessage("Set history for new to " + History.currentIndex + " " + reason);// DEBUG

  History.newestAvailableIndex = History.currentIndex;
  History.setVersion(History.currentIndex, umpleCode);
  
  if(History.firstSave) {
    History.firstSave = false;
  }
}

// Find the previous index of a saved item, this
// is simply by decrementing, except if we hit zero, in which case we 
// cycle back around from versionCount.
// The result may be 'invalid' in that nothing may have bet been stored there
History.decrementIndex = function(index)
{
  var result;
  if (index == 0)
  {
  	result = History.versionCount - 1;
  }
  else 
  {
  	result = index - 1;
  }
  return result;
}

// Find the next index above the argument; loop around to zero
// if we exceed versionCount since we are using a circular structure
// The result may be 'invalid' in that nothing may have bet been stored there
History.incrementIndex = function(index)
{
  var result = (index + 1) % History.versionCount;
  return result;
}

// Retrieve the index with version versionNumber
History.getVersion = function(versionNumber)
{
  var selector = "#" + "textEditorColumn";
  var requested = "version" + versionNumber;
  
  return jQuery(selector).data(requested);
}

// Store a new version with index versionNumber
History.setVersion = function(versionNumber, umpleCode)
{
  var selector = "#" + "textEditorColumn";
  var requested = "version" + versionNumber;
  
  return jQuery(selector).data(requested, umpleCode);
}


History.distanceBetween = function(index1, index2)
{
  if (History.currentIndex == -1) return 0;
  
  var distance = 0;
  var i = index1;
  
  while (i != index2) 
  {
  	i = History.incrementIndex(i);
  	distance += 1;
  } 
  return distance;
}