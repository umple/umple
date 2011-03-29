function simulateCommand(command)
{
  var inputAction = jQuery('#inputAction');
  var buttonAction = jQuery('#buttonAction');
  inputAction.val(command);
  buttonAction.click();
  
  //var inputAction = document.getElementById('inputAction');
  //var buttonAction = document.getElementById('buttonAction');
  //inputAction.value = command;
  //buttonAction.click();
}

Simulate = new Object();

Simulate.init = function()
{
  jQuery("select.methods").change(function(){Simulate.copyToTextArea(jQuery(this));});
  jQuery("select.methods").attr("selectedIndex", 0);
}

Simulate.copyToTextArea = function(select)
{
  var selectedMethod = jQuery("#" + select.attr("id") + " option:selected").val();
  var textArea = jQuery('#inputAction');
  var initialContent = textArea.val();
  var newLine = initialContent == "" ? "" : "\n";
  textArea.val(textArea.val() + newLine + selectedMethod);
  select.attr("selectedIndex", 0);
}
