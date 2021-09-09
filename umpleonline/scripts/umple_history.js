// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models history (undo stack) in UmpleOnline

History = new Object();

// capacity of the circular structure; we will reuse after cycling through
History.versionCount = 9999;
History.noChange = "//$?[No_Change]$?";

History.getInstance = function(id)
{
  var instance = new Object();

  instance.id = id;

  // History item currently on display; -1 means nothing saved.
  instance.currentIndex = -1;
  
  // Initially there is nothing saved.
  instance.oldestAvailableIndex = 0;
  instance.newestAvailableIndex = 0;

  // Initially nothing is saved.
  instance.firstSave = true;
  instance.undoButton = false;
  instance.redoButton = false;

  instance.getNextVersion = function() {return History.getNextVersion(instance)};
  instance.getPreviousVersion = function() {return History.getPreviousVersion(instance)};
  instance.save = function(umpleCode, reason) {return History.save(instance, umpleCode, reason)};
  instance.distanceBetween = function(index1, index2) {return History.distanceBetween(instance, index1, index2)};
  instance.setButtons = function() {return History.setButtons(instance)};
  instance.getVersion = function(versionNumber) {return History.getVersion(instance, versionNumber)};
  instance.setVersion = function(versionNumber, umpleCode) {return History.setVersion(instance, versionNumber, umpleCode)};
  
  return instance;
}

History.setButtons = function(instance)
{
  History.enableButtonUndo(instance, instance.undoButton);
  History.enableButtonRedo(instance, instance.redoButton);
}

History.enableButtonUndo = function(instance, value)
{
  instance.undoButton = value;
  Page.enablePaletteItem("buttonUndo", value);
}

History.enableButtonRedo = function(instance, value)
{
  instance.redoButton = value;
  Page.enablePaletteItem("buttonRedo", value);
}

// Returns the version that had been saved; called when moving forward
// using a 'redo' operation; called from Action.redo
History.getNextVersion = function(instance)
{
  History.enableButtonUndo(instance, true);
  
  var result;
  
  if (!instance.FirstSave && instance.newestAvailableIndex != instance.currentIndex)
  {
  	instance.currentIndex = History.incrementIndex(instance.currentIndex);
  	// Page.catFeedbackMessage("Set history for next to " + History.currentIndex); // DEBUG

  	result = instance.getVersion(instance.currentIndex);
  	if (result == undefined) result = History.noChange;
  } 
  else
  {
  	result = History.noChange;
  }
  
  if (instance.newestAvailableIndex == instance.currentIndex)
  {
  	History.enableButtonRedo(instance, false);
  }
  return result;
}

// Returns the previously saved version in the undo stack
// Moves the pointer back in the undo stack
// Called from Action.undo and also from save in the case of an apparent undo
History.getPreviousVersion = function(instance)
{
  var result;
  
  if (!instance.FirstSave && instance.oldestAvailableIndex != instance.currentIndex)
  {
  	instance.currentIndex = History.decrementIndex(instance.currentIndex);
  	// Page.catFeedbackMessage("Set history back to " + History.currentIndex); // DEBUG

  	result = instance.getVersion(instance.currentIndex);

  	if (result == undefined) result = History.noChange;
  	else History.enableButtonRedo(instance, true);
  }
  else
  {
    // No previously saved versions
  	result = History.noChange;
  }
  
  if (instance.oldestAvailableIndex == instance.currentIndex)
  {
    History.enableButtonUndo(instance, false);
  }
  return result;
}

// Save a new version of the code
History.save = function(instance, umpleCode, reason)
{
  if (instance.getVersion(instance.currentIndex) == umpleCode) return;

  console.log("========== saved");
  if (!instance.firstSave) 
  {
    // Whenever we save we set the highest saved index
    // So we can't redo
    History.enableButtonRedo(instance, false);
    History.enableButtonUndo(instance, true);
  } 
  
  var gap = instance.distanceBetween(instance.oldestAvailableIndex, instance.currentIndex);
  if (gap == instance.versionCount - 1)
  {
  	instance.oldestAvailableIndex = History.incrementIndex(instance.oldestAvailableIndex);
  }

  instance.currentIndex = History.incrementIndex(instance.currentIndex);
  // Page.catFeedbackMessage("Set history for new to " + History.currentIndex + " " + reason);// DEBUG

  instance.newestAvailableIndex = instance.currentIndex;
  instance.setVersion(instance.currentIndex, umpleCode);
  
  if(instance.firstSave) {
    instance.firstSave = false;
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
History.getVersion = function(instance, versionNumber)
{
  var selector = "#" + "textEditorColumn";
  var requested = instance.id + "version" + versionNumber;
  
  return jQuery(selector).data(requested);
}

// Store a new version with index versionNumber
History.setVersion = function(instance, versionNumber, umpleCode)
{
  var selector = "#" + "textEditorColumn";
  var requested = instance.id + "version" + versionNumber;

  return jQuery(selector).data(requested, umpleCode);
}


History.distanceBetween = function(instance, index1, index2)
{
  if (instance.currentIndex == -1) return 0;
  
  var distance = 0;
  var i = index1;
  
  while (i != index2) 
  {
  	i = History.incrementIndex(i);
  	distance += 1;
  } 
  return distance;
}
