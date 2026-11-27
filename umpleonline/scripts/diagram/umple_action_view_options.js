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


Action.redrawDiagram = function()
{
    if (typeof GvDiagramEdit !== "undefined") GvDiagramEdit.clearPendingPaletteState();
    UmpleSystem.merge(null);    // Clear the diagram
    var canvas = jQuery("#umpleCanvas");
    canvas.html("");
    if (!Action.manualSync) 
    {
      Action.updateUmpleDiagram();
      Action.diagramInSync = true;
      //Page.enableDiagram(true);
    }
    if (Action.manualSync && !Action.diagramInSync) Page.enablePaletteItem('buttonSyncDiagram', true);
    if (!Action.manualSync || Action.diagramInSync)
    {
      Page.enableCheckBoxItem("buttonPhotoReady", "ttPhotoReady", true);
      Page.enableCheckBoxItem("buttonManualSync", "ttManualSync", true);

      Page.enablePaletteItem('buttonAddClass', true);
      Page.enablePaletteItem('buttonAddState', true);
      Page.enablePaletteItem('buttonAddAssociation', true);
      Page.enablePaletteItem('buttonAddTransition', true);
      Page.enablePaletteItem('buttonAddGeneralization', true);
      Page.enablePaletteItem('buttonDeleteEntity', true);
    
      Page.initToggleTool('buttonAddClass');
      Page.initToggleTool('buttonAddState');
      Page.initToggleTool('buttonAddAssociation');
      Page.initToggleTool('buttonAddTransition');
      Page.initToggleTool('buttonAddGeneralization');
      Page.initToggleTool('buttonDeleteEntity');
    }
}

InlineEditor.elementChanged = function(obj, oldVal, newVal)
{
  var editType = obj.attr("name");
  var objId = obj.attr("id");

  if (editType == "className")
  {
    var id = objId.substr(0,objId.length - "_name".length);
    DiagramEdit.classNameChanged(id,oldVal,newVal);
  }
  else if (editType == "attributeEdit")
  {
    var index = objId.substr(objId.lastIndexOf("_") + 1);
    var id = objId.substr(0,objId.length - "_attribute_".length - index.length);
    DiagramEdit.attributeNameChanged(id,index,oldVal,newVal);
  }
  else if(editType == "methodEdit")
  {
    var index = objId.substr(objId.lastIndexOf("_") + 1);
    var id = objId.substr(0,objId.length - "_method_".length - index.length);
    DiagramEdit.methodChanged(id,index,oldVal,newVal);
  }
  else if (editType == "attributeNew")
  {
    var id = objId.substr(0,objId.length - "_newAttribute".length);
    DiagramEdit.attributeNew(id,newVal);
  }
  else if(editType == "methodNew")
  {
    var id = objId.substr(0,objId.length - "_newMethod".length);
    DiagramEdit.methodNew(id,newVal);
  }
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

Action.ajax = function(callback,post,target,errors,tabIndependent)
{
  var modelAndPositioning = null;
  modelAndPositioning = Page.getUmpleCode();
  var umpleCode = encodeURIComponent(modelAndPositioning);
  var filename = Page.getFilename();
  var errors = "true";
  TabControl.useActiveTabTo(TabControl.saveTab)(umpleCode);
  post = post + "&theme=" + Action.getThemePreference();

  var tabContextOld = TabControl.getActiveTabId();
  var wrappedCallback = !tabIndependent? function(response){
    var tabContextNew = TabControl.getActiveTabId();
    if (tabContextNew !== tabContextOld){
      Page.hideLoading();
      return;
    }
    callback(response);
  } : callback;
  Ajax.sendRequest("scripts/compiler.php",wrappedCallback,format("{0}&error={3}&umpleCode={1}&filename={2}",post,umpleCode,filename,errors));
}

//Mac Keyboard Shortcut
if (navigator.appVersion.indexOf("Mac")!=-1)
{
  jQuery(document).ready(function(){
    jQuery('#undosmall').html('[cmd+z]');
    jQuery('#redosmall').html('[cmd+shift+z]');
  });
  Mousetrap.bind(['command+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.undo();
    }
    e.preventDefault();
  });  
  Mousetrap.bind(['command+shift+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.redo();
    }
    e.preventDefault();
  });
}
else //Non Mac
{
  jQuery(document).ready(function(){
    jQuery('#undosmall').html('[ctrl+z]');
    jQuery('#redosmall').html('[ctrl+y]');
  });
  Mousetrap.bind(['ctrl+z'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.undo();
    }
    e.preventDefault();
  });  
  Mousetrap.bind(['ctrl+y'], function(e) {
    if(jQuery('#umpleCanvasColumn').hasClass('focus'))
    {      
      Action.redo();
    }
    e.preventDefault();
  });
}

//Arrow Up
Mousetrap.bind(['up'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,-5,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+up'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,-1,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Down
Mousetrap.bind(['down'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,5,0,0));
    return false; //equivalent to e.preventDefault();
  } 
});
Mousetrap.bind(['shift+down'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(0,1,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Left
Mousetrap.bind(['left'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(-5,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+left'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(-1,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Arrow Right
Mousetrap.bind(['right'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(5,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});
Mousetrap.bind(['shift+right'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    Action.moveSelectedClass(Page.selectedClass, new UmplePosition(1,0,0,0));
    return false; //equivalent to e.preventDefault();
  }
});

//Functions for changing diagram view - change consistently in umple_page.js
Mousetrap.bind(['ctrl+e'], function(e){
  Page.clickShowEditableClassDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+j'], function(e){
  Page.clickShowJointJSClassDiagram();
  return false; //equivalent to e.preventDefault();
});


Mousetrap.bind(['ctrl+g'], function(e){
  Page.clickShowGvClassDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+shift+v'], function(e){
  Page.clickShowGvEntityRelationshipDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+shift+c'], function(e){
  Page.clickShowInstanceDiagram();
  return false; //equivalent to e.preventDefault();
});

// Mousetrap.bind(['ctrl+shift+f'], function(e){
//   Page.clickShowCRUDUI();
//   return false; //equivalent to e.preventDefault();
// });

Mousetrap.bind(['ctrl+shift+t'], function(e){
  Page.clickShowStateTables();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+shift+r'], function(e){
  Page.clickShowEventSequence();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+s'], function(e){
  Page.clickShowGvStateDiagram();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+l'], function(e){
  Page.clickShowStructureDiagram();
  return false; //equivalent to e.preventDefault();
});

//Functions for showing and hiding parts of the view
Mousetrap.bind(['ctrl+t', 'ctrl+alt+shift+t'], function(e){
  Page.clickShowHideText();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+d'], function(e){
  Page.clickShowHideCanvas();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+n', 'ctrl+alt+n'], function(e){
  Page.clickShowHideMenu();
  return false; //equivalent to e.preventDefault();
});

// Functions for changing what is shown on the diagram
Mousetrap.bind(['shift+ctrl+a'], function(e){
  Page.clickToggleAttributes();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+m'], function(e){
  Page.clickToggleMethods();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+r'], function(e){
  Page.clickToggleTraits();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+i'], function(e){
  Page.clickToggleTransitionLabels();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+k'], function(e){
  Page.clickToggleGuardLabels();
  return false; //equivalent to e.preventDefault();
});

Mousetrap.bind(['ctrl+b'], function(e){
  Action.promptAndExecuteTest();
  return false;
});

Mousetrap.bind(['ctrl+o'], function(e){
  Action.copyCommandLineCode();
  return false;
});

// Functions for editing the diagram - using shift
Mousetrap.bind(['g'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {      
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {
      jQuery('#buttonAddGeneralization').click();
    }        
  }  
});

Mousetrap.bind(['a'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {
      jQuery(Page.useGvStateDiagram ? '#buttonAddTransition' : '#buttonAddAssociation').click();
    }
  }
});

Mousetrap.bind(['c'], function(e){
  if(jQuery('#umpleCanvasColumn').hasClass('focus') 
    && Page.selectedAssociation == null && Page.selectedGeneralization == null)
  {
    if(Page.selectedClass == null || (Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0))
    {        
      jQuery(Page.useGvStateDiagram ? '#buttonAddState' : '#buttonAddClass').click();
    }        
  }
});

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

Action.getLanguage = function() 
{
  var language = "";
  if(Page.useEditableClassDiagram) {language="language=Json";}
    // JointJS receives the full model (class and state machine) in JSON
  else if(Page.useJointJSClassDiagram) {language="language=JsonMixed";}
  else if(Page.useGvClassDiagram) {
    if(Page.showTraits) {
      language="language=traitDiagram";
    }
    else {
      language="language=classDiagram";
    }
  }
  else if(Page.useGvStateDiagram) {language="language=stateDiagram"}
  else if(Page.useGvEntityRelationshipDiagram) {language="language=entityRelationshipDiagram"}
  else if(Page.useGvUseCaseDiagram) {language="language=useCaseDiagram"}
  else if(Page.useStructureDiagram) {language="language=StructureDiagram"}
  else if(Page.useInstanceDiagram) {language="language=instanceDiagram"}
  else if(Page.useCRUDUI) {language="language=Json&languageStyle=crudJson"}
  else if(Page.useStateTables) {language="language=StateTables"}
  else if(Page.useEventSequence) {language="language=eventSequence"}
 
 

  // append any suboptions needed for GvStateDiagram
  if(Page.useGvStateDiagram) { 
    if(!Page.showActions) language=language+".hideactions";
    if(Page.showTransitionLabels) language=language+".showtransitionlabels";
    if(!Page.showGuards) language=language+".hideguards";    
    if(Page.showGuardLabels) language=language+".showguardlabels";
    if(!Page.showNaturalLanguage) language=language+".hidenaturallanguage";
    language=language+"."+$("inputGenerateCode").value.split(":")[1];
  }
  // append any suboptions needed for GvClassDiagram
  if(Page.useGvClassDiagram) { 
    if(Page.showMethods) language=language+".showmethods";
    if(!Page.showAttributes) language=language+".hideattributes";
  }
  // append any suboptions needed for GvFeatureDiagram
  if(Page.useGvFeatureDiagram) {
    language="language=featureDiagram";
    if(Page.showFeatureDependency) language=language+".showFeatureDependency";
  }
  // append the list of words specified in the filterwords
  // Also gather together copyable code to create a mixset from these
  copyableMixset ="";
  if(Page.filterWordsOutput != "") {
    language=language+".!@FW!@"+Page.filterWordsOutput;

    // Grab the words people have typed in manually for use in mixset
    var copyableIncludeStatements = "";
    Page.filterWordsOutput.split("!@").forEach(function(aFilterWord){
      if(aFilterWord != "") {
        // If it is a number then add a hops clause
        if(!isNaN(aFilterWord)) {
          copyableIncludeStatements+="  hops { association "+aFilterWord+";} ";
        }
        // If it starts with gv it is a filter word and if separator needs cleaning
        else if(aFilterWord.substr(0,2) == "gv") {
          if(aFilterWord.substr(0,11) == "gvseparator") {
            copyableMixset+="  suboption \""+aFilterWord.replace("@@@","")+"\";\n";
          }
          else {
            copyableMixset+="  suboption \""+aFilterWord+"\";\n";
          }
        }
        // If it starts with mixset or filter then process as named
        else if(aFilterWord.substr(0,6) == "filter") {
          copyableMixset+="  filter {includeFilter "+aFilterWord.substr(6)+";}\n";
        }
        else if(aFilterWord.substr(0,6) == "mixset") {
          copyableMixset+="  use "+aFilterWord.substr(6)+";\n";        
        }
        // Otherwise process as a filter pattern
        else {
          copyableIncludeStatements+=" include "+aFilterWord+";";
        }
      }
    });
    if(copyableIncludeStatements != "") {
      copyableMixset += "  filter {"+copyableIncludeStatements+"}\n";
    }
  }   
  // append any of the mixsets of filters
  // words in checkboxes that start with filter, followed by a named filter name
  Page.filtersActive.forEach(function(aNamedFilter){
    language=language+".filter"+aNamedFilter;
    copyableMixset+="  filter {includeFilter "+aNamedFilter+";}\n";
  });
  // words in checkboxes that start with mixset, followed by a mixset name
  Page.mixsetsActive.forEach(function(aMixset){
    language=language+".mixset"+aMixset;
    copyableMixset+="  use "+aMixset+";\n";
  });
  // words in checkboxes starting gv  
  Page.specialSuboptionsActive.forEach(function(aSpecialSuboption){
    language=language+"."+aSpecialSuboption;
    copyableMixset+="  suboption \""+aSpecialSuboption+"\";\n";
  });
  // Generate the actual copyable mixset, calling M followed by 3 digits
  var randomMixsetNumber = Math.floor(Math.random() * 899.0 + 100.0);
  Page.copyableMixset="\/\/ The following was generated from the show and hide options\n"
    +"\/\/ Rename the mixset and paste into the code so you can invoke it at any time\n"
    +"mixset M"+randomMixsetNumber+" {\n"+copyableMixset+"}";
  return language;
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

Action.hidegdpr = function() 
{
  jQuery('#gdprtext').hide();
  Action.gdprHidden = true;
}

Action.reindent = function(lines, cursorPos)
{
  var offset = "";
  var codeAfterIndent = "";
  var len = lines.length;
  var inBlockComment = false;
  var statementEnd = true; // i.e. have semicolon at the end of the statement.
  var statementEndIndentSpace = 0;
  var indexOfCursor = -1;
  for (var i = 0; i < len; i++) 
  {
    var trimmedLine = lines[i].trim();

    // remove quotation
    var indexOfFirstQuote  = trimmedLine.indexOf("\"");
    var indexOfLastQuote = trimmedLine.indexOf("\"", indexOfFirstQuote + 1);
    while (indexOfFirstQuote != -1 && indexOfLastQuote != -1)
    {
      trimmedLine = trimmedLine.slice(0, indexOfFirstQuote) + trimmedLine.slice(indexOfLastQuote+1, trimmedLine.length);
      indexOfFirstQuote  = trimmedLine.indexOf("\"");
      indexOfLastQuote = trimmedLine.indexOf("\"", indexOfFirstQuote + 1);
    }

    // remove comment
    if (trimmedLine.indexOf("//") != -1)
    {
      trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("//")).trim();
    }

    if (inBlockComment)
    {
      if (trimmedLine.indexOf("*/") != -1)
      {
        trimmedLine = trimmedLine.substr(trimmedLine.indexOf("*/") + 2).trim();
        inBlockComment = false;
      }
      else {
        if (i != lines.length -1)
        {
          codeAfterIndent += lines[i] + "\n";
        } else {
          codeAfterIndent += lines[i];
        }
        continue;
      }
    }
    else if (trimmedLine.indexOf("/*") != -1)
    {
      if (trimmedLine.indexOf("*/") == -1)
      {
        inBlockComment = true;
        trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("/*")).trim();
      }
      else
      {
        trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("/*")) + trimmedLine.substr(trimmedLine.indexOf("*/") + 2).trim(); // remove block comment for trimmed line
      }
      
    }
    
    var indexOfOpenCurlyBrace = trimmedLine.indexOf("{");
    var indexOfCloseCurlyBrace = trimmedLine.indexOf("}");
    var indexOfSemiColon = trimmedLine.indexOf(";");

    
    if (indexOfSemiColon != -1 && indexOfSemiColon != trimmedLine.length - 1 && trimmedLine.substr(indexOfSemiColon+1).trim().charAt(0) != "}")
    {
      lines.splice(i + 1, 0, trimmedLine.substr(indexOfSemiColon + 1));
      if (i <= cursorPos.line)
      {
        cursorPos.line++;
      }
      lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfSemiColon + 1);
      Action.reindent(lines, cursorPos);
      return;
    }

    var doNotIndent = indexOfOpenCurlyBrace != -1 && indexOfCloseCurlyBrace != -1 && indexOfCloseCurlyBrace - indexOfOpenCurlyBrace < 40 && trimmedLine.substr(0, indexOfCloseCurlyBrace).indexOf("{", indexOfOpenCurlyBrace + 1) == -1;
    if (doNotIndent)
    {
      if (indexOfCloseCurlyBrace != trimmedLine.length - 1)
      {
        lines.splice(i + 1, 0, trimmedLine.substr(indexOfCloseCurlyBrace + 1));
        if (i <= cursorPos.line)
        {
          cursorPos.line++;
        }
        lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfCloseCurlyBrace + 1);
        Action.reindent(lines, cursorPos);
        return;
      }
      
      if (!statementEnd)
      {
        if (trimmedLine.slice(-1) == "{")
        {
          statementEnd = true;
        } 
        else 
        {
          lines[i] = offset + lines[i].match(/^\s*/)[0].substr(statementEndIndentSpace) + lines[i].trim();
          if (trimmedLine.indexOf(";") == trimmedLine.length - 1)
          {
            statementEnd = true;
          }
        }
      }
      else
      {
        lines[i] = offset + lines[i].trim();
      }
    }
    else 
    {
      if (indexOfOpenCurlyBrace != -1 && indexOfOpenCurlyBrace != trimmedLine.length - 1) // put code after an open curly bracket to next line
      {
        lines.splice(i + 1, 0, trimmedLine.substr(indexOfOpenCurlyBrace + 1));
        lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfOpenCurlyBrace + 1);
        if (i <= cursorPos.line)
        {
          cursorPos.line++;
        }
        Action.reindent(lines, cursorPos);
        return;
      }

      if (indexOfCloseCurlyBrace != -1 && trimmedLine.length > 1)
      {
        if (indexOfCloseCurlyBrace == 0)
        {
          lines.splice(i + 1, 0, trimmedLine.substr(1));
          lines[i] = "}";
          if (i <= cursorPos.line)
          {
            cursorPos.line++;
          }
        } else {
          lines.splice(i + 1, 0, "}");
          if (i <= cursorPos.line)
          {
            cursorPos.line++;
          }
          if (indexOfCloseCurlyBrace != trimmedLine.length - 1) // there is code after close curly bracket
          {
            lines.splice(i + 2, 0, trimmedLine.substr(indexOfCloseCurlyBrace + 1));
            if (i <= cursorPos.line)
            {
              cursorPos.line++;
            }
          }
          lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfCloseCurlyBrace);
        }
        Action.reindent(lines, cursorPos);
        return;
      }


      if (statementEnd && trimmedLine.indexOf(";") != trimmedLine.length - 1 && trimmedLine.slice(-1) != "{" && trimmedLine.slice(-1) != "}" && trimmedLine.slice(-2) != "||")
      {
        statementEnd = false;
        statementEndIndentSpace = lines[i].match(/^\s*/)[0].length;
      }

      if (indexOfCloseCurlyBrace != -1)
      {
        offset = offset.substr(2);
      }

      if (!statementEnd)
      {
        if (trimmedLine.slice(-1) == "{" || trimmedLine.slice(-2) == "||" && trimmedLine.slice(-1) == "}")
        {
          statementEnd = true;
          lines[i] = offset + lines[i].trim();
        } 
        else 
        {
          lines[i] = offset + lines[i].match(/^\s*/)[0].substr(statementEndIndentSpace) + lines[i].trim();
          if (trimmedLine.indexOf(";") == trimmedLine.length - 1)
          {
            statementEnd = true;
          }
        }
      }
      else
      {
        lines[i] = offset + lines[i].trim();
      }

      if (indexOfOpenCurlyBrace != -1)
      {
        offset += "  ";
      }
    }

    if (i != lines.length -1)
    {
      codeAfterIndent += lines[i] + "\n";
    } else {
      codeAfterIndent += lines[i];
    }
  }
  
  if(Page.codeMirrorOn) 
  {
    Page.codeMirrorEditor6.dispatch({
      changes: {from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: codeAfterIndent}
    })

  }
  
  // Refactoring definitive text location
  Action.updateCurrentUmpleTextBeingEdited(codeAfterIndent);

  var cursorLine = Page.getRawUmpleCodeCM6().split("\n")[Page.codeMirrorEditor6.state.doc.lineAt(Page.codeMirrorEditor6.state.selection.main.head).number];
  var whiteSpace = cursorLine.match(/^\s*/)[0].length;

  if (cursorPos.ch >= cursorLine.trim().length) 
  {
    Page.codeMirrorEditor6.dispatch({selection: {anchor: (cursorPos.line), head: (cursorLine.trim().length + whiteSpace)}});
  }
  else if (cursorPos.ch >= 0)
  {
    Page.codeMirrorEditor6.dispatch({selection: {anchor: (cursorPos.line), head: (cursorPos.ch+whiteSpace)}});  
  }
  else
  {
   const position = Page.codeMirrorEditor6.state.selection.main.head;
   Page.codeMirrorEditor6.dispatch({selection: {anchor: position, head: position}});
  }

  Page.codeMirrorEditor6.focus();
}

Action.setLiveView = function(viewNameToSet)
{
  Page.catFeedbackMessage("DEBUG:"+viewNameToSet);
  if (viewNameToSet=="ecd") { Page.clickShowEditableClassDiagram(); }
  else if (viewNameToSet=="gcd") { Page.clickShowGvClassDiagram(); }
  else if (viewNameToSet=="sd") { Page.clickShowGvStateDiagram(); }
  else if (viewNameToSet=="std") { Page.clickShowStructureDiagram();}
  else if (viewNameToSet=="erd") { Page.clickShowGvEntityRelationshipDiagram();}
  else if (viewNameToSet=="gfd") { Page.clickShowGvFeatureDiagram();}
  else if (viewNameToSet=="gucd") { Page.clickShowGvUseCaseDiagram();}
  else if (viewNameToSet=="instanceDiagram") {Page.clickShowInstanceDiagram();}
  else if (viewNameToSet == "crudUI") { Page.clickShowCRUDUI();}
  else if (viewNameToSet == "stateTables") { Page.clickShowStateTables();}
  else if (viewNameToSet == "eventSequence") { Page.clickShowEventSequence();}
  else Page.catFeedbackMessage("DEBUG bad selection!!!");
}



Action.syncLiveViewSelector = function(viewCode) {
  var selector = document.getElementById("liveViewSelector");
  if (selector) {
    selector.value = viewCode;
  }
};

// --- Live View visibility helpers ---
// Requirement: if Diagram (D) is off, Live View control disappears;
// it reappears when D is on again.
Action.setLiveViewMenuVisible = function(isVisible) {
  try {
    var $selector = jQuery("#liveViewSelector");
    if ($selector.length === 0) return;

    //Prefer an explicit wrapper if present.
    var $wrapper = jQuery("#liveViewWrapper, #liveViewContainer, .liveViewContainer").filter(function() {
      return jQuery(this).find("#liveViewSelector").length > 0;
    }).first();

    //Otherwise, use the smallest nearby container that looks like the Live View control.
    if ($wrapper.length === 0) {
      $wrapper = $selector.parents("span,div").filter(function() {
        var txt = (jQuery(this).text() || "").toLowerCase();
        return txt.indexOf("live view") !== -1 && jQuery(this).find("#liveViewSelector").length > 0;
      }).first();
    }

    // If we found a safe wrapper, hide/show it (label + select together).
    if ($wrapper.length > 0) {
      $wrapper.toggle(!!isVisible);
      return;
    }

    // Fallback: hide/show the selector + any associated label.
    $selector.toggle(!!isVisible);
    var $label = jQuery("label[for='liveViewSelector'], #liveViewLabel");
    if ($label.length) $label.toggle(!!isVisible);
  } catch (e) {
    // Fail silently; do not break the UI if DOM differs.
  }
};

Action.updateLiveViewVisibility = function() {
  // Diagram visibility is tracked by Page.showCanvas in UmpleOnline.
  // When D is toggled, Page.showCanvas flips true/false.
  var diagramVisible = !!Page.showCanvas;
  Action.setLiveViewMenuVisible(diagramVisible);
};

// Ensure Live View visibility is correct on initial page load.
jQuery(function() {
  if (typeof Action.updateLiveViewVisibility === "function") {
    Action.updateLiveViewVisibility();
  }
});
