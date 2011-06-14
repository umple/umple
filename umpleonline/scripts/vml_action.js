
Action = new Object();
Action.waiting_time = 1200;
Action.oldTimeout = null;
Action.newAssociation = null;

Action.clicked = function(event)
{
  Page.clickCount += 1;
  event = Dom.getEvent(event);
  var obj = Dom.getObject(event);
  var action = obj.id.substring(6);

  if (action == "PhpCode")
  {
    Action.generateCode("php","Php");
  }
  else if (action == "JavaCode")
  {
    Action.generateCode("java","Java");
  }
  else if (action == "RubyCode")
  {
    Action.generateCode("ruby","Ruby");
  }
  else if (action == "EcoreCode")
  {
    Action.generateCode("xml","Ecore");
  }
  else if (action == "TextUmlCode")
  {
    Action.generateCode("java","TextUml");
  }
  else if (action == "PapyrusCode")
  {
    Action.generateCode("xml","Papyrus");
  }
  else if (action == "YumlCode")
  {
    Action.generateCode("java","Yuml");
  }
  else if (action == "JsonCode")
  {
    Action.generateCode("java","Json");
  }
  else if (action == "GenericCode")
  {
    Action.generateCode("java","Generic");
  }
}

Action.saveNewFile = function()
{
  var vmlCode = Page.getVmlCode();
  var filename = Page.getFilename();
  
  if (filename == "")
  {
    Ajax.sendRequest("scripts/compiler_vml.php",Action.saveNewFileCallback,format("save=1&&vmlCode={0}",vmlCode));
  }
}

Action.saveNewFileCallback = function(response)
{
  Page.setFilename(response.responseText);
}

Action.generateCode = function(languageStyle,languageName)
{
  Action.ajax(function(response) {Action.generateCodeCallback(response,languageStyle);},format("language={0}",languageName));
}

Action.generateCodeCallback = function(response,language)
{
  Page.showGeneratedCode(response.responseText,language);
}

Action.loadExample = function loadExample()
{
  Ajax.sendRequest("scripts/compiler_vml.php",Action.loadExampleCallback,"exampleCode=" + Page.getSelectedExample());
}

Action.loadExampleCallback = function(response)
{
  Page.setVmlCode(response.responseText);
}

Action.ajax = function(callback,post)
{
  var vmlCode = escape(Page.getVmlCode());
  var filename = Page.getFilename();
  Ajax.sendRequest("scripts/compiler_vml.php",callback,format("{0}&vmlCode={1}&filename={2}",post,vmlCode,filename));
}
