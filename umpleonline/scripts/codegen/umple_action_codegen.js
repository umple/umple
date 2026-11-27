// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for generating and executing code, and for showing generated files in tabs

Action.executeCode = function(languageStyle, languageName)
{
  var executeCodeSelector = "#buttonExecuteCode";
  var actualLanguage = languageName;

  jQuery(executeCodeSelector).showLoading();
  Action.ajax(
    function(response) {
      Action.executeCodeCallback(response);
    },
    format("execute=true&language={0}&languageStyle={1}&model={2}", actualLanguage, languageStyle, Page.getModel()),
    "true"
  );
}

Action.generateCode = function(languageStyle, languageName)
{
  var generateCodeSelector = "#buttonGenerateCode";
  var actualLanguage = languageName;
  var additionalCallback;
  if (Page.getAdvancedMode() == 0 && (languageName === "Cpp"))
  {
    actualLanguage = "Experimental-"+languageName;
  }

  if(languageName === "StateTables")
  {
    additionalCallback = StateTree.colourStateTables;
  }

  if(languageName === "EventSequence")
  {
    additionalCallback = StateTree.colourEventSequences;
  }

  //Vahdat
  if(languageName === "stateDiagram")
  {
    actualLanguage = languageName+"."+$("inputGenerateCode").value.split(":")[1];
  }
  else if (languageName === "Mermaid")
  {
    // Keep Mermaid output aligned with the active diagram context in UmpleOnline.
    if (Page.useGvStateDiagram)
    {
      actualLanguage = languageName + ".state";
    }
    else if (Page.useEditableClassDiagram || Page.useJointJSClassDiagram || Page.useGvClassDiagram)
    {
      actualLanguage = languageName + ".class";
    }
  }
  
  jQuery(generateCodeSelector).showLoading();

  Action.ajax(
    function(response) {
      Action.generateCodeCallback(response, languageStyle, additionalCallback);
    },
    format("language={0}&languageStyle={1}", actualLanguage, languageStyle),
    "true"
  );
}

Action.executeCodeCallback = function(response)
{
  var executeCodeSelector = "#buttonExecuteCode";
  jQuery(executeCodeSelector).hideLoading();
  Page.showExecutionArea();
  Page.hideGeneratedCodeOnly();
  Page.showExecutedResponse(response.responseText);
  window.location.href='#codeExecutionArea';
}

Action.generateCodeCallback = function(response, language, optionalCallback)
{
  Page.showGeneratedCode(response.responseText,language);
  Page.hideExecutionArea();
  Action.gentime = new Date().getTime();

  if(optionalCallback !== undefined)
  {
    optionalCallback();
  }

  var generateCodeSelector = "#buttonGenerateCode";
  jQuery(generateCodeSelector).hideLoading();
  Page.showCodeDone();
  window.location.href='#genArea';
}

Action.generateStructureDiagramFile = function()
{
  var filename = Page.getFilename().slice(0, -9) + "structureDiagram.svg";

  var svgContents =  jQuery("#innerGeneratedCodeRow").html().slice(4, -1);

  svgContents = format('<svg xmlns="http://www.w3.org/2000/svg" {0}>', svgContents);

  jQuery("#buttonStructureLink").showLoading();

  Ajax.sendRequest("scripts/compiler.php", Action.generateStructureDiagramFileCallback, 
    format("save=1&filename={0}&svgContent={1}", filename, svgContents));
}

Action.generateStructureDiagramFileCallback = function(response)
{
  jQuery("#buttonStructureLink").hideLoading();
  Page.toggleStructureDiagramLink(true, response.responseText);
}

Action.toggleTabsCheckbox = function(language)
{
  // Workaround for TextUml having java prefix
  if($("inputGenerateCode").value.split(":")[1] == "TextUml"){
    language = "TextUml";
  }

  if(language == "java" || language == "php" || language == "cpp" ||
    language == "python" || language == "ruby" || language == "javascript" || language == "sql") {
    jQuery("#ttTabsCheckbox").show();
    jQuery("#tabRow").show();

    if ($("inputGenerateCode").value.split(":")[1] == "USE" || $("inputGenerateCode").value.split(":")[1] == "UmpleSelf" || $("inputGenerateCode").value.split(":")[1] == "Json") {
      jQuery("#ttTabsCheckbox").hide();
      jQuery("#tabRow").hide();
    }
  }
  else {
    jQuery("#ttTabsCheckbox").hide();
    jQuery("#tabRow").hide();
    if(jQuery('#buttonTabsCheckbox').is(':checked')){
      jQuery('#buttonTabsCheckbox').click();
    }
  }
}

// Function for splitting code into tabs for every new file, activated when checking the Show Tabs checkbox
Action.toggleTabs = function()
{
  // Checking on the checkbox
  if(jQuery('#buttonTabsCheckbox').is(':checked')){

    // Show row with buttons for each filename
    jQuery('#tabRow').show();

    // Hide main code window with glommed files
    jQuery('#innerGeneratedCodeRow').hide();

    // Show first file codeblock
    jQuery('#tabButton1').click();

  }
  // Checking off the checkbox
  else{

    // Hide row with buttons
    jQuery('#tabRow').hide();

    // Show main code window with glommed files
    jQuery('#innerGeneratedCodeRow').show();

    // Hide all file codeblocks
    jQuery('#innerGeneratedCodeRow').nextAll().hide();

  }
}

Action.generateTabsCode = function(theCode)
{
  var arrCodeFiles = [];
  var intFileCounter = 0;
  var strFileContents = "";
  var arrFileNames = [];
  var strNewLine = "";
  var skipSpace = false;

  // Read full code output line by line
  theCode.split('URL_SPLIT')[1].split("\n").forEach(function(theLine){

    // If New File Beginning
    if( (theLine.indexOf("//%%") >= 0) || (theLine.indexOf("# %%") >= 0)){
      intFileCounter++;
      strFileName = theLine.slice(14);
      strFileName = strFileName.substr(0, strFileName.indexOf(' '));
      arrFileNames[intFileCounter] = strFileName;
      jQuery('#generatedCodeRow').append("<div id='innerGeneratedCodeRow" + intFileCounter + "'></div>");
      arrCodeFiles[intFileCounter] = "";
      skipSpace = true;
    }
    else{
      if(!skipSpace){
         arrCodeFiles[intFileCounter] += theLine + "\n";
      }
      else{
        skipSpace = false;
      }
    }
  });

  // Output buttons for number of files found
  for (i=1; i <= intFileCounter; i++){
    jQuery('#tabRow').append("<button type='button' id='tabButton" + i + "'>" + arrFileNames[i] + "</button>");
    jQuery('#tabButton' + i).click({code: arrCodeFiles[i], tabnumber: i}, showTab);
  }
}

function showTab(event)
{
  // Hide all file codeblocks
  jQuery('#innerGeneratedCodeRow').nextAll().hide();

  // Show only relevant file codeblock
  jQuery('#innerGeneratedCodeRow' + event.data.tabnumber).show();

  // Highlight code for specific file only
  Page.showGeneratedCode(event.data.code, $("inputGenerateCode").value.split(":")[0], event.data.tabnumber);

  // Hide main code window with glommed files
  jQuery('#innerGeneratedCodeRow').hide();
}
