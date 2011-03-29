History = new Object();
History.currentIndex = -1;
History.oldestAvailableIndex = 0;
History.newestAvailableIndex = 0;
History.versionCount = 9999;
History.noChange = "//$?[No_Change]$?";
History.firstSave = true;

History.getNextVersion = function()
{
  Page.enablePaletteItem("buttonUndo", true);
  
  var result;
  
  if (History.newestAvailableIndex != History.currentIndex)
  {
  	History.currentIndex = History.incrementIndex(History.currentIndex);
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

History.getPreviousVersion = function()
{
  var result;
  
  if (History.oldestAvailableIndex != History.currentIndex)
  {
  	History.currentIndex = History.decrementIndex(History.currentIndex);
  	result = History.getVersion(History.currentIndex);
  	
  	if (result == undefined) result = History.noChange;
  	else Page.enablePaletteItem("buttonRedo", true);
  }
  else
  {
  	result = History.noChange;
  }
  
  if (History.oldestAvailableIndex == History.currentIndex)
  {
  	Page.enablePaletteItem("buttonUndo", false);
  }
  
  return result;
}

History.save = function(umpleCode)
{
  if (!History.firstSave) 
  {
  	Page.enablePaletteItem("buttonRedo", false);
  	Page.enablePaletteItem("buttonUndo", true);
  } 
  
  var gap = History.distanceBetween(History.oldestAvailableIndex, History.currentIndex);
  if (gap == History.versionCount - 1)
  {
  	History.oldestAvailableIndex = History.incrementIndex(History.oldestAvailableIndex);
  }

  History.currentIndex = History.incrementIndex(History.currentIndex);
  History.newestAvailableIndex = History.currentIndex;
  History.setVersion(History.currentIndex, umpleCode);
  
  History.firstSave = false;
}

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

History.incrementIndex = function(index)
{
  var result = (index + 1) % History.versionCount;
  return result;
}

History.getVersion = function(versionNumber)
{
  var selector = "#" + "textEditorColumn";
  var requested = "version" + versionNumber;
  
  return jQuery(selector).data(requested);
}

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