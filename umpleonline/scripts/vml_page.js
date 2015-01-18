// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Describes the various elements of the page in the VML online tool
// TODO needs maintenance

Page = new Object();

Page.init = function()
{
  Page.initAction("buttonGenericCode");
  Page.initAction("buttonPhpCode");
  Page.initAction("buttonJavaCode");
  Page.initAction("buttonRubyCode");
  Page.initAction("buttonEcoreCode");
  Page.initAction("buttonTextUmlCode");
  Page.initAction("buttonScxmlCode");
  Page.initAction("buttonPapyrusCode");
  Page.initAction("buttonYumlCode");
  Page.initAction("buttonJsonCode");

  Page.initExamples();

  Page.initSourceCodeArea();
  Page.showCodeMessage("none");
  Action.saveNewFile();
}

Page.initAction = function(id,action)
{
  var obj = document.getElementById(id);
  Dom.attachEvent(obj,"click",Action.clicked);
}

Page.initSourceCodeArea = function()
{
  SyntaxHighlighter.config.clipboardSwf = 'scripts/clipboard.swf';
  var generatedCodeRow = document.getElementById("generatedCodeRow");
  generatedCodeRow.style.display = "none";
}

Page.initExamples = function()
{
  var obj = document.getElementById("buttonExample");
  Dom.attachEvent(obj,"click",Action.loadExample);
}

Page.getVmlCode = function()
{
  return document.getElementById("vmltext").value;
}

Page.setVmlCode = function(code)
{
  var vmltext = document.getElementById("vmltext");
  vmltext.value = code;
}

Page.getSelectedExample = function()
{
  var inputExample = document.getElementById("inputExample");
  return inputExample.options[inputExample.selectedIndex].value;
}

Page.showWaitingCode = function()
{
  if (Page.codeEffect != null)
  {
    Page.codeEffect.cancel();
  }
  Page.showCodeMessage("wait");
  Page.codeEffect = Effect.Fade('buttonCodeComplete',{ duration: 0, from: 0, to: 1 });
}

Page.showCodeDone = function()
{
  if (Page.codeEffect != null)
  {
    Page.codeEffect.cancel();
  }
  Page.showCodeMessage("done");
  Page.codeEffect = Effect.Fade('buttonCodeComplete',{ duration: 3.0 });
}

Page.showCodeMessage = function(messageType)
{
  var completeStyle = messageType == "done" ? "" : "none";
  var waitingStyle = messageType == "wait" ? "" : "none";

  var buttonCodeComplete = document.getElementById("buttonCodeComplete");
  buttonCodeComplete.style.display = completeStyle;

  var buttonCodeWaiting = document.getElementById("buttonCodeWaiting");
  buttonCodeWaiting.style.display = waitingStyle;

}

Page.showGeneratedCode = function(code,language)
{
  var generatedCodeRow = document.getElementById("generatedCodeRow");
  generatedCodeRow.style.display = "";
  generatedCodeRow.innerHTML = format('<pre class="brush: {1};">{0}</pre>',code,language);
  SyntaxHighlighter.highlight("code");
}

Page.setFilename = function(filename)
{
  var inputFilename = document.getElementById("filename");
  inputFilename.value = filename;
}

Page.getFilename = function()
{
  var inputFilename = document.getElementById("filename");
  return inputFilename.value;
}