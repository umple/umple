// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for UmpleOnline tasks: loading and submitting tasks, and showing their instructions

Action.loadTask = function(taskName, isBookmark)
{
  jQuery("#showInstrcutionsArea").css("display","block");
  if (!isBookmark)
  {
    Ajax.sendRequest("bookmark.php", Action.loadTaskBookmark,format("taskname={0}&model={0}",taskName));
  } else {
    if (Page.getModel().split("-")[0] == "task") // it is in task bookmark page. instruction can not be edited.
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadTaskExceptCodeCallback,format("loadTask=1&loadInstructionAsHTML=1&filename={0}",taskName));
    }
    else
    {
      Ajax.sendRequest("scripts/compiler.php",Action.loadTaskExceptCodeCallback,format("loadTask=1&filename={0}",taskName));
    }
  }
}

Action.loadTaskBookmark = function(response)
{
  if (response.responseText.split(" ")[0] == "Task")
  {
    window.alert("Load Task Failed! " + response.responseText);
  }
  else
  {
    window.location.href = "umple.php?model=" + response.responseText;
  }
}

Action.loadTaskCallback = function(response)
{
  Action.freshLoad = true;
  // TODO: this resolves the loading issue but in a very hacky way. See PR#1402.
  if (Object.keys(TabControl.tabs).length > 1) return;

  Action.setjustUpdatetoSaveLater(true);
  TabControl.getCurrentHistory().save(response.responseText,"loadTaskCallback");
  var responseArray = response.responseText.split("task delimiter");
  Page.setUmpleCode(responseArray[0]);
  if (TabControl.tabs[TabControl.getActiveTabId()].nameIsEphemeral)
  {
    var extractedName = TabControl.extractNameFromCode(responseArray[0]);
    if (extractedName)
    {
      TabControl.useActiveTabTo(TabControl.renameTab)(extractedName, true);
    }
  }
  if (!Action.manualSync) Action.updateUmpleDiagram();
  TabControl.useActiveTabTo(TabControl.saveTab)(Page.getUmpleCode());
  TabControl.saveActiveTabs();
  window.location.href = "bookmark.php?taskname=" + responseArray[2] + "&model=" + responseArray[3];
}

Action.loadTaskExceptCodeCallback = function(response)
{
  Action.freshLoad = true;
  // TODO: this resolves the loading issue but in a very hacky way. See PR#1402.

  if (!justUpdatetoSaveLater){
    TabControl.getCurrentHistory().save(response.responseText,"loadTaskExceptCodeCallback");
    Action.setjustUpdatetoSaveLater(true);
  }
  var responseArray = response.responseText.split("task delimiter");
  jQuery("#labelInstructions").text("Instructions for task \"" + responseArray[2] + "\":");
  jQuery("#requestorName").val(responseArray[4]);
  jQuery("#labelInstructions").css("display","block");
  jQuery("#taskArea").css("display","block");
  if (Page.getModel().split("-")[0] == "task") // it is in task bookmark page. instruction can not be edited.
  {
    jQuery("#labelInstructions").text("Instructions for task \"" + responseArray[2] + "\":               Requestor Name:" + responseArray[4]);
    jQuery("#labelCompletionURL").css("display", "none");
    jQuery("#completionURLCell").css("display", "none");
    jQuery("#labelRequestorName").css("display", "none");
    jQuery("#requestorName").css("display", "none");
    jQuery("#instructionsHTML").html(responseArray[1]);
  }
  else 
  {
    jQuery("#instructions").val(responseArray[1]);
    jQuery("#instructions").css("display","block");
    jQuery("#completionURL").val(responseArray[5]);
    jQuery("#isExperimentCell").css("display", "inline");
    jQuery("#isExperiment").prop('checked', responseArray[6] == 'true');
    jQuery('#instructions').each(function () {
      this.setAttribute('style', 'height:' + (this.scrollHeight) + 'px;overflow-y:hidden;');
    }).on('input', function () {
      this.style.height = 'auto';
      this.style.height = (this.scrollHeight) + 'px';
    });
  }

  if (TabControl.tabs[TabControl.getActiveTabId()].nameIsEphemeral)
  {
    var extractedName = TabControl.extractNameFromCode(responseArray[0]);
    if (extractedName)
    {
      TabControl.useActiveTabTo(TabControl.renameTab)(extractedName, true);
    }
  }
  Layout.zoomResize();
}

Action.submitLoadTask = function()
{
  var taskName = jQuery("#inputLoadTaskName").val();
  let patt = /^(\w|\.)+$/; // taskName Take only [ A-Z or a-z or 0-9 or _ or . ]
  if (!patt.test(taskName))//taskName.indexOf(" ") != -1 || taskName.indexOf("/") != -1 || taskName.indexOf("-") != -1 || taskName.indexOf("\\") != -1) 
  {
    window.alert("Task Name can only contain letters(case insensitive), underscores, dots, and digits!");
    return;
  }
  Action.loadTask(taskName, false);
}

Action.submitTaskWork =function()
{
  Ajax.sendRequest("task.php", Action.submitTaskWorkCallback, format("submitTaskWork=1&model={0}&responseURL={1}", Page.getModel(), window.location.href));
}

Action.submitTaskWorkCallback = function(response)
{
  window.alert("Successfully submitted Task!");
  var responseArray = response.responseText.split("task submit delimiter");
  if (responseArray[0] == "")
  {
    window.location.href = responseArray[2];
  }
  else
  {
    window.location.href = responseArray[0] + "?task=" + responseArray[1] + "&url=" + responseArray[2];
  }
}

Action.launchParticipantURL = function()
{
  var taskname = Page.getModel().split("-")[1];
  window.open("bookmark.php?loadTaskWithURL=1&taskname=" + taskname + "&model=" + taskname);
}

Action.copyParticipantURL = function()
{
  var taskname = Page.getModel().split("-")[1];
  var copiedURL = window.location.hostname + window.location.pathname.substring(0, window.location.pathname.lastIndexOf('/')) + "/bookmark.php?loadTaskWithURL=1&taskname=" + taskname + "&model=" + taskname;
  Action.copyToClp(copiedURL);
  Page.setFeedbackMessage("Participant URL is in copy buffer: " + copiedURL);
}

Action.openStartFreshWork = function() 
{
  var a= confirm("Are you sure to start from fresh?"); 
  if(a) { 
    window.location.href = "/umpleonline/umple.php"
  }
}

Action.openInstructionInNewTab = function()
{
  jQuery("#buttonReshowInstructions").css("display", "inline");
  var tab = window.open('about:blank', '_blank');
  tab.document.write(jQuery("#instructionsHTML").html()); // where 'html' is a variable containing your HTML
  tab.document.close();
  jQuery("#instructionsHTML").css("display", "none");
  jQuery("#labelInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "none");
  Layout.zoomResize();
}

Action.reshowInstructions = function()
{
  jQuery("#instructionsHTML").css("display", "block");
  jQuery("#labelInstructions").css("display", "inline");
  jQuery("#buttonReshowInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "inline");
  Layout.zoomResize();
}

Action.hideInstructions = function()
{
  jQuery("#instructionsHTML").css("display", "none");
  jQuery("#labelInstructions").css("display", "none");
  jQuery("#buttonHideInstructions").css("display", "none");
  jQuery("#buttonReshowInstructions").css("display", "inline");
  Layout.zoomResize();
}
