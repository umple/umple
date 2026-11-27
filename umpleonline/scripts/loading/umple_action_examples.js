// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for loading example models and the blank model

Action.loadBlankModel = function()
{
  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode="); //left empty
}

Action.setExampleType = function setExampleType()
{
  // Hide them all first
  jQuery("#itemLoadExamples").hide();
  jQuery("#itemLoadExamples2").hide();
  jQuery("#itemLoadExamples3").hide();
  jQuery("#itemLoadExamples4").hide();
  jQuery("#itemLoadExamples5").hide();
  jQuery("#itemLoadExamples6").hide();
  jQuery("#itemLoadExamples7").hide();
  jQuery("#itemLoadExamples8").hide();

     
  if(Page.getExampleType() == "cdModels") {
     jQuery("#itemLoadExamples").show();
     jQuery("#defaultExampleOption").prop("selected",true);
   }
   else if(Page.getExampleType() == "smModels") {
     jQuery("#itemLoadExamples2").show();
     jQuery("#defaultExampleOption2").prop("selected",true);
   }
   else if(Page.getExampleType() == "featureModels") {
     jQuery("#itemLoadExamples4").show();
     jQuery("#defaultExampleOption4").prop("selected",true);
   }
   else if(Page.getExampleType() == "extra1ModelsAD") {
     jQuery("#itemLoadExamples5").show();
     jQuery("#defaultExampleOption5").prop("selected",true);
   }
   else if(Page.getExampleType() == "extra1ModelsEL") {
     jQuery("#itemLoadExamples6").show();
     jQuery("#defaultExampleOption6").prop("selected",true);
   }
   else if(Page.getExampleType() == "extra1ModelsMP") {
     jQuery("#itemLoadExamples7").show();
     jQuery("#defaultExampleOption7").prop("selected",true);
   }
   else if(Page.getExampleType() == "extra1ModelsQZ") {
     jQuery("#itemLoadExamples8").show();
     jQuery("#defaultExampleOption8").prop("selected",true);
   }
   else {
     jQuery("#itemLoadExamples3").show();
     jQuery("#defaultExampleOption3").prop("selected",true);
   }   
}

Action.loadExample = function loadExample()
{
  var requestDiagramType = this.dataset['diagramType'];
  var $option = jQuery(' option:selected', this);
  if ($option.hasClass('openUmprOption')) {
    // user wants to open the umpr repository
    location.href = "http://umple.org/umpr?diagram-type=" + diagramType;
    return;
  }

  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode=" + Page.getSelectedExample());
  var exampleName = Page.getSelectedExample().slice(0,-4);
  var diagramType="";
  if(Page.useGvStateDiagram) {
    diagramType="&diagramtype=state";
    Action.setLiveView("sd");
  }
 else if(Page.useGvFeatureDiagram) {
    diagramType="&diagramtype=GvFeature";
    Action.setLiveView("gfd");
  }
  else if(Page.useGvUseCaseDiagram) {
    diagramType="&diagramtype=GvUseCase";
    Action.setLiveView("gucd");
  }

  else if(Page.useGvEntityRelationshipDiagram) {
    diagramType="&diagramtype=entityRelationshipDiagram";
    Action.setLiveView("erd");
  }

  else if(Page.useInstanceDiagram) {
    diagramType="&diagramtype=instanceDiagram";
    Action.setLiveView("instanceDiagram");
  }


  else if(Page.useStateTables) {
    diagramType="&diagramtype=StateTables";
    Action.setLiveView("stateTables");
  }

  else if(Page.useEventSequence) {
    diagramType="&diagramtype=eventSequence";
    Action.setLiveView("eventSequence");
  }
  else if(Page.useStructureDiagram) {
    diagramType="&diagramtype=structure&generateDefault=cpp";
    Action.setLiveView("std");
  }
  else {
    diagramType="&diagramtype=GvClass";
    if (typeof Action.setLiveView === "function") {
    // This calls the logic we already have at the bottom of umple_action.js
    Action.setLiveView("gcd");
    //jQuery("#genjava").prop("selected",true);
    }
  }
  
  var largerSelector = "#buttonLarger";
  var smallerSelector = "#buttonSmaller";
  var canvasSelector = "#" + Page.umpleCanvasId();
  
  umpleCanvasWidth = jQuery(canvasSelector).width();
  umpleCanvasHeight = jQuery(canvasSelector).height();

  var shortExampleName, newURL;
  if (exampleName.startsWith("https")) {
    shortExampleName=exampleName.split("/").pop();
    newURL="?filename="+exampleName.substr(8)+".ump"+diagramType;
  }
  else
  {
    shortExampleName=exampleName;
    newURL="?example="+shortExampleName+diagramType;
  }
    // COMMENTED OUT SUBJECT TO INVESTIGATION
    // Page.setSelectExample(shortExampleName + ".ump");
    // window.history.pushState({}, "", newURL);

    setTimeout(function () { // Delay so it doesn't get erased
    Page.setExampleMessage("<a href=\""+newURL+"\">URL for "+shortExampleName+" example</a>");
  }, 3000);
  
  // TODO - fix so history works nicely           
  jQuery("#inputExample").blur();
}

Action.loadExampleCallback = function(response)
{
  Action.freshLoad = true;
  Action.setjustUpdatetoSaveLater(true);
  
  //Update the code editor
  Page.setUmpleCode(response.responseText, function(){
    Page.hideLoading();
    Action.updateUmpleDiagram();
  }, true);
 
  Action.setCaretPosition("0");
  Action.updateLineNumberDisplay();
  TabControl.getCurrentHistory().save(response.responseText, "loadExampleCallback");
};

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

Action.moveSelectedClass = function(umpleClass, delta)
{
  if (umpleClass == null) return;
  
  umpleClass.position = umpleClass.position.add(delta);
  UmpleSystem.updateClass(umpleClass);
  Action.classSelected(umpleClass);
  
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }
  Action.oldTimeout = setTimeout(function() {DiagramEdit.classMoved(Page.selectedClass);}, 1000); 
}

Action.keyboardShortcut = function(event)
{
    
  if (!Page.shortcutsEnabled)
  {
    return;
  }
  
  var shortcut = event.which;

  if (shortcut == 27)    // escape
  {
    var shortcutDisabled = Page.unselectAllToggleTools();

    if(!shortcutDisabled)
    {
      jQuery(".visibleFocus").blur();
    }
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery('#umpleCanvasColumn').hasClass('focus'))
  {
    if(Page.selectedClass && jQuery('#' + Page.selectedClass.id).find("input").length == 0)
    {
      DiagramEdit.classDeleted(Page.selectedClass.id);
      event.preventDefault();	  
    }
    else if(Page.selectedAssociation)
    {
      DiagramEdit.associationDeleted(Page.selectedAssociation.id);
      event.preventDefault();	  
    }
    else if(Page.selectedGeneralization)
    {
      DiagramEdit.generalizationDeleted(Page.selectedGeneralization.id);
      event.preventDefault();
    }
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery(".umpleClass").is(":focus")){
  	DiagramEdit.classDeleted(document.activeElement.id);
  	event.preventDefault();
  }
  else if ((shortcut == 8 || shortcut == 46) && (jQuery(".untracedAssociation").is(":focus")||jQuery(".redTracedAssociation").is(":focus"))){
  	DiagramEdit.associationDeleted(document.activeElement.id);
  	event.preventDefault();
  }
  else if ((shortcut == 8 || shortcut == 46) && jQuery(".umpleGeneralization").is(":focus")){
  	DiagramEdit.generalizationDeleted(document.activeElement.id);
  	event.preventDefault();
  }
}


Action.getCaretPosition = function() // TIM Returns the line number
{
  return Page.codeMirrorEditor6.state.doc.lineAt(Page.codeMirrorEditor6.state.selection.main.head).number;
}

// we no longer need this for codemirror 6
// // The following from http://stackoverflow.com/questions/263743/how-to-get-cursor-position-in-textarea/3373056#3373056
Action.getInputSelectionStart = function(el) 
{
  var start = 0, normalizedValue, range, textInputRange, len, endRange;

  if (typeof el.selectionStart == "number" && typeof el.selectionEnd == "number") 
  {
    start = el.selectionStart;
    // The following for debugging
    if (Page.getAdvancedMode() == 2) 
    { // debug
      Page.setFeedbackMessage("Non-IE browser ");
    }
  }
  else 
  { // IE Support
    // The following for debugging
    if (Page.getAdvancedMode() == 2) // debug
    { 
      Page.setFeedbackMessage("IE-type browser ");
    }
    range = document.selection.createRange();
    
    if (range && range.parentElement() == el) {
      len = el.value.length;
      normalizedValue = el.value.replace(/\r\n/g, "\n");
    
      // Create a working TextRange that lives only in the input
      textInputRange = el.createTextRange();
      textInputRange.moveToBookmark(range.getBookmark());
    
      // Check if the start and end of the selection are at the very end
      // of the input, since moveStart/moveEnd doesn't return what we want
      // in those cases
      endRange = el.createTextRange();
      endRange.collapse(false);
    
      if (textInputRange.compareEndPoints("StartToEnd", endRange) > -1) 
      {
        start = len;
      } 
      else 
      {
        start = -textInputRange.moveStart("character", -len);
        start += normalizedValue.slice(0, start).split("\n").length - 1;
      }
    }
  }

  return start;
}


Action.setCaretPosition = function(line)
{
  if(isNaN(line-0)) 
  {
    // It is not a number so must be a special hidden command
    if(line=="gd") 
    {
      jQuery('#gdprtext').show();
      Action.gdprHidden = false;      
    }
    if(line=="av") 
    {
      // Special backdoor to turn on experimental features
      document.getElementById('advancedMode').value=1;


      Page.setFeedbackMessage("");
      return;
    }
    if(line=="db") 
    { // turn on debugging and do certain debugging options
      document.getElementById('advancedMode').value=2;
      Page.setFeedbackMessage("Debug Mode");
      return;
    }


      if(line.substr(0,4)=="clws") 
        {
          if (line.substr(4,1)=="+") 
          {
            Page.setFeedbackMessage("Collaboration logging Enabled");
            Collab.websocketLogging(0);
          }
          else if (line.substr(4,1)=="-")
          {
            Page.setFeedbackMessage("Collaboration logging disabled");
            Collab.websocketLogging(-1);
          }
          else if (line.substr(4,2)=="tq") 
            {
              Page.setFeedbackMessage("Ten seconds to timeout the client");
              Collab.clientSetTimeout(10);
            }
            else if (line.substr(4,2)=="tn")
            {
              Page.setFeedbackMessage("Turn the timeout back to normal");
              Collab.clientSetTimeout(-1);
            }
            else if (line.substr(4,2)=="tx")
            {
                Page.setFeedbackMessage("Disabled the timeout");
                Collab.clientSetTimeout(0);
            }
          return;    
        } 


    if(line=="sp")
    { // creates Survey Pass; modifies conditions to allow for survey to be displayed:
      // includes setting RandomizedFrequency to 1, MinutesBeforePrompt to 5 secs, EditsBeforePrompt to 1;
      if (existSCookie("surveyCookie")==null && window.localStorage.getItem("surveyShown")==null){
        if (document.getElementById("styleTip")!=null)
          document.getElementById("styleTip").innerHTML="";
        window.randomSurveyRoll = 1;
        window.surveyData.EditsBeforePrompt=1;
        timeSurveyUp = false;
        clearTimeout(timeSurvey);
        timeSurvey = setTimeout(function(){timeSurveyUp = true;}, 10000);
        timeSurvey;
        displayedText=false;
        if (!displayedText){
          beforeInstance = TabControl.getCurrentHistory().currentIndex;
          document.addEventListener("mouseover", function(){
            if (TabControl.getCurrentHistory().currentIndex-beforeInstance >= 1 && !displayedText && timeSurveyUp){
                displaySurvey();
                this.removeEventListener('mouseover', arguments.callee);
            }                        
          });
        }
      }
      
    }
    if (line=="sc")
    { // clears all survey cookies including whether URL has been shown already, whether the user has been skipped, and whether Survey Pass has been activated
      // run twice for it to be effective
      let setToExpire=new Date();
      setToExpire.setTime(setToExpire.getTime()-1000);
      document.cookie="surveyCookie=done; expires="+setToExpire.toUTCString()+"; path=/;";
      window.localStorage.removeItem("surveyShown");
      document.addEventListener("mouseover", function(){});
      setCookieBeforeClose("off");
    }
    if(line=="tc")
    { // resets cookies for tips
      Page.setFeedbackMessage("Clearing tip cookies");
      let currentTime=new Date();
      currentTime.setTime(currentTime.getTime()-1000);
      window.localStorage.removeItem("first_time");
      document.cookie="tipCookie=done; expires="+currentTime.toUTCString()+"; path=/;";
    }
    if(line.substr(0,2)=="cm") 
    {
      if(line.substr(2,1)=="0" && Page.codeMirrorOn) 
      {
        Page.setFeedbackMessage("Turning code mirroring off");
        Page.codeMirrorEditor.toTextArea();
        Page.codeMirrorOn=false;
        jQuery("#linenum").val("0");
      }
      else if(line.substr(2,1)=="1" && !Page.codeMirrorOn) 
      {
        Page.initCodeMirrorEditor();
        jQuery("#linenum").val("0");
      }
      return;
    }

    if(line.substr(0,2)=="bp") {  // Begin prompt - Also invoked by ctrl-b
      Action.promptAndExecuteTest();
      return;
    }
    else
    {
      if(!Action.selectMatchingText(line)) 
      {
        Page.setFeedbackMessage("Line number or word \""+line+"\" not located");
        setTimeout(function() {if(true) {Page.setFeedbackMessage("");}},3000);
      }
      return;
    }
  }
  if(Page.codeMirrorOn) 
  {
   Page.codeMirrorEditor6.focus();
    
    // DEBUG
    /* codemirror 6 line highlight by number*/
    if(line >= 1) {
      line = Math.min(line, Page.codeMirrorEditor6.state.doc.lines);
      const docPosition = Page.codeMirrorEditor6.state.doc.line(line).from;
      Page.codeMirrorEditor6.dispatch({
        selection: { anchor: docPosition },
        scrollIntoView: true
      })
    }
 
    return;
  }
  var ctrl = document.getElementById('umpleModelEditorText');
  var startPos=0;
  var endPos=-1;

  if(line<1)
  {
    endPos=0;
  }
  else
  {
    var theCode=Page.getRawUmpleCodeCM6();

    for(var ch=0; ch<theCode.length; ch++)
    {
      if(theCode.charAt(ch)=='\n')
      {
        line--;
        if(line==1) startPos=ch+1;
        if(line==0) {
          endPos=ch; 
          break;
        }
      }
    }
    if(endPos==-1) { // got to end
      endPos=theCode.length;
      if(line!=1) startPos=endPos;
    }
  }

  if(ctrl.setSelectionRange)
  {
    ctrl.focus();
    ctrl.setSelectionRange(startPos,endPos);
  }
  else if (ctrl.createTextRange) {
    var range = ctrl.createTextRange();
    range.collapse(true);
    range.moveEnd('character', endPos);
    range.moveStart('character', startPos);
    range.select();
  }
}

// This pops up a panel that can be used to execute certain specialized test commands
// This should be expanded to allow other commands
Action.promptAndExecuteTest = function() {

  // Get the arguments if any (separated by spaces)
  var testCommand=prompt("Umpleonline test prompt. Enter command e.g. 'ac Classname' to add a class","");

  var edargs=testCommand.substr(2,99).strip().split(" "); 
  if(testCommand.substr(0,1)=="a") {
    // add something
    if(testCommand.substr(1,1)=="c") {
      // add class - one argument
      if(edargs.length >=1) {
        Action.directAddClass(edargs[0]);
        return;
      }
    }
    else if (testCommand.substr(1,1)=="a") {
      // add attribute to class - two arguments
      if(edargs.length >=2) {
        Action.directAddAttribute(edargs[0],edargs[1]);
        return;
      }
    }
    else {
      Page.setFeedbackMessage("Syntax error in test add command");
    }
    Page.setFeedbackMessage("Syntax error in test command");
  }
  else {

  }
  return;
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

// Adds a class with the given name. The class may already be there. Just edits the text.
// This could be modified to 
Action.directAddClass = function(className) {

  var umpleJson = Json.toString({"position" : {"x" : "10","y" : "10","width" : "109","height" : "41"},"name" : className});

  Page.setFeedbackMessage("Adding class "+className);
  Action.setjustUpdatetoSaveLater(false);
  Action.ajax(Action.directUpdateCommandCallback,format("action=addClass&actionCode={0}",umpleJson));

  return;
}

// Adds an attribute to a class
Action.directAddAttribute = function(classname, attribute) {
  // This has to be written.
  // It should look for a matching class, and then look for the attributes in it, then
  // inject the new attribute after it. This assumes no type. That could be added by changing
  // this to have three arguments (if the third one was missing there would be no type, hence
  // string as default.
  // If there is no matching class, this should output a message 
  
  Page.setFeedbackMessage("((when written) Adding to class "+classname+" attribute "+attribute);  
  return;
}


Action.selectMatchingText = function(text) 
{
  // Does nothing if CodeMirror is off
  if (Page.codeMirrorOn) {
    const scursor = new cm6.SearchCursor(Page.codeMirrorEditor6.state.doc, text)
    
    if (!scursor.next()) {
      return false;
    }
      Page.codeMirrorEditor6.dispatch({
        selection: { anchor: scursor.value.from, head: scursor.value.to }
      });
          return true;

  }
  return false;
}


/*
  Called by Action.selectClass() or Action.selectMethod() or Action.selectState()
  Returns an object containing start and end indices of item (class or method or state)
  based on the searchCursor parameter
  Parameters: searchCursor - a regular expression object created in either of Caller methods 
                              with target class name or method name or state name
*/
Action.selectItemCM6 = function(searchCursor){
  // console.log("Debug F4: Inside selectItemCM6")
  if(Page.codeMirrorOn) {
    var text = Page.codeMirrorEditor6.state.doc.toString();
    let splitBuffer=Action.splitStates(text);
    let currClass=null;
    for(let i=0;i<splitBuffer.length;i++){
      if(splitBuffer[i].search(searchCursor)==0){
        currClass=splitBuffer[i];
        break;
      }
    }
    let startIndex = 0;
    let endIndex = 0;
    try{
      startIndex=text.indexOf(currClass);
      endIndex=startIndex+currClass.length;
      
    } catch(err){  
      console.log("Please wait a little more for diagram updates, and try again.") ;

    }

    var outputObj={startIndex: startIndex,endIndex: endIndex};
    return outputObj;
  }
}


// Highlights the text of the method that is currently selected.
Action.selectMethod = function(methodName, type, accessMod)
{
	var scursor = new RegExp(accessMod+" "+type+" "+methodName+"(\\\s|[(])");
	var ncursor = new RegExp("(public|protected|private|class) [A-Za-z]");

  var selectionIndiciesCM6 = Action.selectItemCM6(scursor);
  Action.highlightByIndexCM6(selectionIndiciesCM6.startIndex, selectionIndiciesCM6.endIndex) ;
}


Action.selectAssociation = function(associationDetails) {
  var detailsArray = associationDetails.split(',');
  var className = detailsArray[0];
  var searchCursor = new RegExp("(associationClass|class|interface|trait) " + className + "($|\\\s|[{])");
  var nextCursor = new RegExp("(class|interface|trait) [A-Za-z]");
  if (Page.codeMirrorOn) {

   var selectionIndiciesCM6 = Action.selectItemCM6(searchCursor);
   var selectedText = Page.codeMirrorEditor6.state.sliceDoc(selectionIndiciesCM6.startIndex,selectionIndiciesCM6.endIndex) ;//get the class code for where the association belong
  }
  
  var start, end;
  //for labelAssociation
  if (detailsArray.length > 3) {
      if (detailsArray[2].trim().includes(' ')) {
          // When there's a space, indicating the presence of a role name or additional details
          var array = detailsArray[2].split(' ');
          start = detailsArray[3].trim(); //.replace(/[\*+?.()|[\]\\{}^$]/g, "\\$&"); // Assuming the start multiplicity is always in the 4th segment
          if (array.length == 2) {
              // When there's more than just the multiplicity and class name, indicating a role name is present
              end = array[0].trim() + ' ' + detailsArray[1].trim() + ' ' + array[1].trim();
          } else {
              end = array[0].trim() + ' ' + detailsArray[1].trim();
          }
      } else {
          // When there's no space, meaning no role name is present
          start = detailsArray[3].trim(); //.replace(/[\*+?.()|[\]\\{}^$]/g, "\\$&");
          end = detailsArray[2].trim() + ' ' + detailsArray[1].trim();
      }


      var startEscaped = start.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      var endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      var patternString = startEscaped + "(?:\\s+sorted\\s+{.*?})?" + "(\\s*<-\\s*|\\s*><\\s*|\\s*--\\s*|\\s*->\\s*|\\s*<@>\\-\\s*|\\s*-\\<@>\\s*)" + endEscaped + "(?:\\s+sorted\\s+{.*?})?" + "\\s*;";

      var pattern = new RegExp(patternString, "g");
      var code = Page.codeMirrorEditor6.state.doc.toString();
      //Finding matches using the constructed pattern
      var matches = selectedText.match(pattern);
      if (matches) {
          
          startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
          endIndex = startIndex + matches[0].length;
          
          Action.highlightByIndexCM6(startIndex, endIndex);

          return { startIndex: startIndex, endIndex: endIndex };
      } else {
          if (endEscaped.startsWith("1")) { // this for simple writing association
              end = endEscaped.substring(2).trim();
              endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
              patternString = startEscaped + "\\s+" + endEscaped+ "\\s*;";
              pattern = new RegExp(patternString, "g");
              matches = selectedText.match(pattern);
              if (matches == null) {
                  patternString = startEscaped + "\\s+.*?" + endEscaped+ "\\s*;";
                  pattern = new RegExp(patternString, "g");
                  matches = selectedText.match(pattern);
              }

              try {
              startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
              endIndex = startIndex + matches[0].length;
                
              } catch (error) {
                console.log("Please wait a little more for diagram updates, and try again.") ;     
              }

              Action.highlightByIndexCM6(startIndex, endIndex);
              return { startIndex: startIndex, endIndex: endIndex };
          } else {
              if (startEscaped.trim().includes(' ')) {
                  var newstart = startEscaped.split(' ');
                  startEscaped = newstart[0].trim() + " " + className + " " + newstart[1].trim();
              } else {
                  startEscaped += " " + className;
              }
              
              patternString = startEscaped + "(\\s*<-\\s*|\\s*><\\s*|\\s*--\\s*|\\s*->\\s*|\\s*<@>\\-\\s*|\\s*-\\<@>\\s*)" + endEscaped+ "\\s*;";

              pattern = new RegExp(patternString, "g");
              matches = code.match(pattern);
              if (matches == null) {
                  patternString = startEscaped + "\\s+.*?" + endEscaped+ "\\s*;";
                  pattern = new RegExp(patternString, "g");
                  matches = code.match(pattern);
              }
              
              try {
                
                    startIndex = code.indexOf(matches[0]);
                    endIndex = startIndex + matches[0].length;
                
              } catch (error) {
                console.log("Please wait a little more for diagram updates, and try again.") ;
              }
              Action.highlightByIndexCM6(startIndex, endIndex); 
              return { startIndex: startIndex, endIndex: endIndex };

          }
      }

  } else { //for two label association

      var array = detailsArray[2].split(' ');
      start = array[0].trim();
      end = array[1].trim();

      var startEscaped = start.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      var endEscaped = end.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
      var patternString = startEscaped + ".*?" + endEscaped+ "\\s*;";
      var pattern = new RegExp(patternString, "g");
      var code = Page.codeMirrorEditor6.state.doc.toString();
      //Finding matches using the constructed pattern
      var matches = selectedText.match(pattern);
      if (matches) {
          startIndex = code.indexOf(selectedText) + selectedText.indexOf(matches[0]);
          endIndex = startIndex + matches[0].length;
          Action.highlightByIndexCM6(startIndex, endIndex);
          return { startIndex: startIndex, endIndex: endIndex };
      }

  }
}

// Highlights the text of the class that is currently selected.
Action.selectClass = function(className) 
{
	var scursor = new RegExp("(associationClass|class|interface|trait) "+className+"($|\\\s|[{])");
	var ncursor = new RegExp("(class|interface|trait) [A-Za-z]");

  var selectionIndiciesCM6 = Action.selectItemCM6(scursor);
  Action.highlightByIndexCM6(selectionIndiciesCM6.startIndex, selectionIndiciesCM6.endIndex);
}

// Highlights the text of the attribute that is currently selected.
Action.selectAttribute = function(className, attributeName)
{
  var searchCursor = new RegExp("(associationClass|class|interface|trait) "+className+"($|\\\s|[{])");
  var pattern = new RegExp("(^|[;{}])[^\\S\\n]*([\\w<>\\[\\],.]+[^\\S\\n]+)*"+attributeName+"\\s*[=;]", "m");

  if(Page.codeMirrorOn) {
    var text = Page.codeMirrorEditor6.state.doc.toString();
    let splitBuffer=Action.splitStates(text);
    for(let i=0;i<splitBuffer.length;i++){
      if(splitBuffer[i].search(searchCursor)==0){
        let matches=splitBuffer[i].match(pattern);
        if(matches){
          let startIndex=text.indexOf(splitBuffer[i])+matches.index;
          Action.highlightByIndexCM6(startIndex, startIndex+matches[0].length);
          return;
        }
      }
    }
    Action.selectClass(className);
  }
}

// Highlights the text of the state that is currently selected.
Action.selectState = function(stateName)
{
    var scursor = new RegExp("(class|interface|trait) "+stateName+"($|\\\s|[{])");
    var ncursor = new RegExp("(class|interface|trait) [A-Za-z]");

  var selectionIndiciesCM6 = Action.selectItemCM6(scursor);
  Action.highlightByIndexCM6(selectionIndiciesCM6.startIndex, selectionIndiciesCM6.endIndex);
}

Action.splitStates=function(inputStr){
  let output=[];
  let temp="";
  let depth=0;
  let inComment=false;
  let EOLflag=false;
  for(var inChar in inputStr){
    let curChar=inputStr.charAt(inChar);
    if(EOLflag&&curChar!='\n'&&curChar!=" "){
      EOLflag=false;
      if(curChar!='{'){
        temp="";
      }
    }
    if(curChar=='/'&&inputStr.charAt((parseInt(inChar)+1))=='/'){
      inComment=true;
    }
    if(curChar=='\n'&&inComment){
         inComment=false;
    }

    if(curChar=='{'&&!inComment){ //increase depth
      temp=temp+curChar;
      depth++;
    }else if(curChar=='}'&&!inComment){ //decrease depth
      temp=temp+curChar;
      depth--;
      if(depth==0){
        output.push(temp.trim());
        temp="";
      }
    } else if(curChar=='\n'&&depth==0){ //flush temp at EOL when depth=0
      EOLflag=true;
      temp=temp+"\n";
    } else if(curChar==' '&&depth==0&&temp==""){//ignore empty spaces when depth=0
    }else { //push char to temp variable
        temp=temp+curChar;
    }

  }
  return output;
}
Action.indexToPos = function(index,inputText){
  var ch=0;
  var outputLine=0;
  var temp="";
  for(var i=0;i<index;i++){
    let curChar=inputText.charAt(i);
        if(curChar=="\n"){
      outputLine++;
      temp="";
    } else {
      temp=temp+curChar;
    }
  }
  ch=temp.length;
  output={line:outputLine,ch:ch};
  return  output;
}

/*
  Returns the start and ending position of state inside a state machine in a specific class
  Parameters: stateName - state that has to be searched
              smName - state machine inside which state has to be searched
              className - class inside which state machine containing the state exists
*/
Action.selectStateInClassCM6 = function(className, smName, stateName) 
{
  if(Page.codeMirrorOn) {
    var text = Page.codeMirrorEditor6.state.doc.toString();
    let splitBuffer=Action.splitStates(text);
    let currClass=null;
    let pattern = new RegExp("(?:class|queued)\\s+"+className,"");
    for(let i=0;i<splitBuffer.length;i++){
      if(splitBuffer[i].search(pattern)==0){
        currClass=splitBuffer[i]; //set currClass to class code
        break;
      }
    }
    splitBuffer=Action.splitStates(currClass.substr(currClass.indexOf("{")+1)); //split class into un-nested SMs
    let currSM=null;
    for(let i=0;i<splitBuffer.length;i++){
      let query=new RegExp("(?:queued\\s*)?"+smName);
      if(splitBuffer[i].search(query)==0){
        currSM=splitBuffer[i]; //set currSM to un-nested SM code
        break;
      }
    }
    splitBuffer=Action.splitStates(currSM.substr(currSM.indexOf("{")+1));
    if (splitBuffer!=null) {
      let states = splitBuffer;
      let finState=null;
      for(let i=0;i<states.length;i++){
        if(states[i].search(stateName)==0){
          finState=states[i];
          break;
        }
      }
      let startIndex=text.indexOf(currClass);//index of class start
      let endIndex=startIndex+currClass.length;
      startIndex=text.substr(startIndex,endIndex).indexOf(currSM)+startIndex;//match[1] contains the SM definition+name
      endIndex=startIndex+currSM.length;
      startIndex=text.substr(startIndex,endIndex).indexOf(finState)+startIndex;//finds target state definition within target class and state machine
      endIndex=startIndex+finState.length;
      var outputObj={startIndex:startIndex,endIndex:startIndex+finState.length};
      return outputObj;
      
    } else {
      console.log("No matching state found with regex:"+pattern);
    }
  } else {
    console.log("No matching class and state machine found for class: "+className+" and sm "+smName);
  }
  return null; 
}

/*
  Returns the start and ending position of target state within given indices range
*/
Action.selectStateInStateCM6 = function(startIndex,endIndex,target){
  var temp = Page.codeMirrorEditor6.state.doc.toString().substr(startIndex,endIndex-startIndex);
  let states=Action.splitStates(temp.substr(temp.indexOf("{")+1));
  var stateFin=null;
  for(let i=0;i<states.length;i++){
    if(states[i].startsWith(target)){
      stateFin=states[i];
      break;
    }
  }
  let outputStart=temp.indexOf(stateFin)+startIndex;
  let outputEnd=outputStart+stateFin.length;
  let outputObj={startIndex:outputStart,endIndex:outputEnd};
  return outputObj;
}

Action.highlightByIndex = function(startIndex,endIndex){
  Page.codeMirrorEditor.setSelection(Action.indexToPos(startIndex,Page.codeMirrorEditor.getValue()),
  Action.indexToPos(endIndex,Page.codeMirrorEditor.getValue()))
}

/*
  Highlights specific code in codemirror6 editor with startIndex and endIndex
  Parameters: startIndex, endIndex
              Exact position of start and end characters of code block to be highlighted in code-editor
*/
Action.highlightByIndexCM6 = function(startIndex,endIndex){
  let startSelection = Action.indexToPos(startIndex,Page.codeMirrorEditor6.state.doc.toString());
  let startDocPosition = Page.codeMirrorEditor6.state.doc.line(startSelection.line +1).from;
  let endSelection = Action.indexToPos(endIndex,Page.codeMirrorEditor6.state.doc.toString());
  let endLine = Math.min(endSelection.line +2, Page.codeMirrorEditor6.state.doc.lines);
  let endDocPosition = Page.codeMirrorEditor6.state.doc.line(endLine).from;

  // following is for multiple selection ranges
  Page.codeMirrorEditor6.dispatch({
    selection: cm6.EditorSelection.create([
      // Reversing selection to keep the active line on the top;
      cm6.EditorSelection.range(endDocPosition,startDocPosition),
    ]),
    scrollIntoView: true
  })
}

Action.findEOL = function(inputStr){ //returns ONLY depth==0 lines as an array without letting non-EOL \n's cause line breaks
  let output="";
  let temp="";
  let depth=0;
  let EOLflag=false;
  for(var inChar in inputStr){
    let curChar=inputStr.charAt(inChar);
    if(curChar=='{'){
      depth++;
      temp=temp+curChar;
    } else if(curChar=='}'){
      depth--;
      temp=temp+curChar;
    } else if(curChar==';'&&depth==0){
      output=temp+';';
      break;
    } else {
      temp=temp+curChar;
    }

  }
  return output;
}
Action.delayedFocus = function(ms) 
{
  var ctrl=document.getElementById('umpleModelEditorText');
  setTimeout(function() {ctrl.focus();},ms);
}

Action.updateLineNumberDisplay = function()
{
  jQuery("#linenum").val(Action.getCaretPosition());
}

Action.goToCrossFileError = function(filename, line)
{
  var base = filename.split('/').pop().replace(/\.ump\s*$/i, '');
  var tabId = null;

  Object.keys(TabControl.tabs).forEach(function(id) {
    if (TabControl.tabs[id].name === base) {
      tabId = id;
    }
  });

  if (tabId !== null && String(tabId) !== String(TabControl.activeTab)) {
    TabControl.selectTab(tabId);
  }

  setTimeout(function() {
    Action.setCaretPosition(parseInt(line, 10));
    Action.updateLineNumberDisplay();
  }, 100);

  return false;
};

Action.umpleTyped = function(eventObject)
{
  // DEBUG
  if (clientDebuggerFlag){
    console.log("Inside Action.umpleTyped()...");
  }

  // This function is not called by CodeMirror
  // See umpleCodeMirrorTypingActivity if CodeMirror is on (as it normally is)
  // debug - output key code
  if (Page.getAdvancedMode() == "2") { // debug
     Page.catFeedbackMessage("["+eventObject.keyCode+"] ");
  }
  Action.updateLineNumberDisplay();

  var eventCode = eventObject.keyCode;
  
  // Ignore 33=pgup 34=pgdn 35=end 36=hom 37=lef 38=up 39=rt 40=dn
  if(eventCode>=33 && eventCode <=40) return;

  var target = eventObject.target.id;
  Action.umpleTypingActivity(target);
}

Action.umpleCodeMirrorCursorActivity = function() {
  var docPosition = Page.codeMirrorEditor6.state.selection.main.head;
  var line = Page.codeMirrorEditor6.state.doc.lineAt(docPosition);
  jQuery("#linenum").val(line.number);
}

// Called whenever any text is changed in codemirror 6
Action.umpleCodeMirrorTypingActivity = function(editorThatChanged) {
  
  // DEBUG
  if (clientDebuggerFlag){
    console.log("Inside Action.umpleCodeMirrorTypingActivity...");
  }

  if(Action.freshLoad == false) {
    // Start/restart timer to eventually process this by triggerink disk save and diagram update
    Action.umpleTypingActivity(editorThatChanged);
    if(editorThatChanged == "codeMirrorEditor") {
      Page.codeMirrorEditor.save();
    }
  }
  else {
    Action.freshLoad = false;
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }

}

Action.trimMultipleNonPrintingAndComments = function(text) {
  text = Action.removeComments(text);
  text = text.replace(/[^\x21-\x7E]+/g, ' '); // change non-printing chars to spaces
  text= text.replace(/^\s+|\s+$/g, '');      // remove leading/trailing spaces
  return text;
}

Action.removeComments = function(str) 
{
   // From http://james.padolsey.com/javascript/javascript-comment-removal-revisted/
 
    var uid = '_' + +new Date(),
        primatives = [],
        primIndex = 0;
 
    return (
        str
        /* Remove strings */
        .replace(/(['"])(\\\1|.)+?\1/g, function(match){
            primatives[primIndex] = match;
            return (uid + '') + primIndex++;
        })
 
        /* Remove Regexes */
        .replace(/([^\/])(\/(?!\*|\/)(\\\/|.)+?\/[gim]{0,3})/g, function(match, $1, $2){
            primatives[primIndex] = $2;
            return $1 + (uid + '') + primIndex++;
        })
 
        /*
        - Remove single-line comments that contain would-be multi-line delimiters
            E.g. // Comment /* <--
        - Remove multi-line comments that contain would be single-line delimiters
            E.g. /* // <-- 
       */
        .replace(/\/\/.*?\/?\*.+?(?=\n|\r|$)|\/\*[\s\S]*?\/\/[\s\S]*?\*\//g, ' ')
 
        /*
        Remove single and multi-line comments,
        no consideration of inner-contents
       */
        .replace(/\/\/.+?(?=\n|\r|$)|\/\*[\s\S]+?\*\//g, ' ')
 
        /*
        Remove multi-line comments that have a replaced ending (string/regex)
        Greedy, so no inner strings/regexes will stop it.
       */
        .replace(RegExp('\\/\\*[\\s\\S]+' + uid + '\\d+', 'g'), ' ')
 
        /* Bring back strings & regexes */
        .replace(RegExp(uid + '(\\d+)', 'g'), function(match, n){
            return primatives[n];
        })
    );
}

// Called each time a character is typed
// Sets a timer or resets the time such that the function processTyping
// ends up being called after a 3s gap in calls to this.
Action.umpleTypingActivity = function(target) {

  if (clientDebuggerFlag){
    console.log("Inside Action.umpleTypingActivity()...");
  }

  if (Action.manualSync && Action.diagramInSync)
  {
    if (jQuery("#umpleCanvasColumn").is(":visible")) Page.enablePaletteItem("buttonSyncDiagram", true);
    Action.diagramInSync = false;
    Page.enableDiagram(false);
  }
  if (Action.oldTimeout != null)
  {
    clearTimeout(Action.oldTimeout);
  }

  const delay = (target === "diagramEdit") ? 500 : Action.waiting_time;

  const thisTimer = setTimeout(() => {
    if (Action.oldTimeout !== thisTimer) return;
    Action.oldTimeout = null;
    Action.processTyping(target, false);
  }, delay);

  Action.oldTimeout = thisTimer;
}

// Called after a 3s delay as controlled by umpleTypingActivity when
// text has been edited in any of the editors (indicated by target)
// Target can be diagramEdit (when diagram changed), newEditor for CM6, codeMirrorEditor (will be obsolete)
Action.processTyping = function(target, manuallySynchronized, currentCursorPosition)
{

  if (clientDebuggerFlag){
    console.log("Inside Action.processTyping ...", target);
  }

  if (
    (target == "umpleModelEditorText" || target == "codeMirrorEditor" || target == "newEditor") &&
    typeof GvDiagramEdit !== "undefined" &&
    GvDiagramEdit.clearPendingPaletteState
  ) {
    GvDiagramEdit.clearPendingPaletteState();
  }

  document.getElementById("newEditor").value = Page.codeMirrorEditor6.state.doc.toString();


  // Save in history after a pause in typing
  if (target != "diagramEdit") 
  {
    Action.setjustUpdatetoSaveLaterForTextCallback(true);
  }
  else{
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }
  // Cause changed in text to be made to the diagram
  if (!Action.manualSync || manuallySynchronized)
  {
    Action.diagramInSync = true;
    if (target == "umpleModelEditorText" || target == "codeMirrorEditor" || target == "newEditor") {
      Action.updateLayoutEditorAndDiagram(target); 
      // issue#1554
      var downloadLink = document.getElementById("downloadLink");
      if (downloadLink !== null){
        downloadLink.remove();
      }
      
      Page.enablePaletteItem("buttonSyncDiagram", false);
    }
    else if(target == "diagramEdit")
    {
      Action.ajax(Action.updateFromDiagramCallback, Action.getLanguage());
    }
    //Page.enableDiagram(true);
  }

  if (target != "diagramEdit"){
    if (!justUpdatetoSaveLater){
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "processTyping");
    }
    else if (target == "umpleModelEditorText" || target == "codeMirrorEditor" || target == "newEditor") {
      Action.setjustUpdatetoSaveLater(false);
    }
    Page.setExampleMessage("");
    
  }
}

// Refactoring definitive text location
// This function stores just the core umple code, NOT the layout
Action.updateCurrentUmpleTextBeingEdited = function(codeToSave, skipDebouncedTyping){
  // console.log("Inside Action.updateCurrentUmpleTextBeingEdited() ...")
  // Back up the data in the main editor
  Page.currentUmpleTextBeingEdited = codeToSave;
  
  // Backup save for CM5 CodeMirror 5 to be deleted 
  jQuery("#umpleModelEditorText").val(codeToSave);
  
  // Update the content in CM6 CodeMirror 6
  Page.setCodeMirror6Text(codeToSave, skipDebouncedTyping);
};

Action.updateLayoutEditorAndDiagram = function(target)
{
  Action.ajax(Action.updateUmpleLayoutEditor,"language=Json",target);
}

Action.updateUmpleLayoutEditor = function(response)
{
  // DEBUG
  // console.log("Inside Action.updateUmpleLayoutEditor()...")
  //Extract data from response
  var codeparts = response.responseText.split('URL_SPLIT');
  var errorMessage=codeparts[0];
  var umpleJson=codeparts[1];//Remove the URL_SPLIT in umpleJson

  //If anything failed, set umpleJson to response.responseText
  if(umpleJson == null || umpleJson == undefined)
  {
	  umpleJson = response.responseText;
  }
  
  Page.showLayoutLoading();
  //TODO: for some reason in the live version this call isnt being made
  //but oddly the diagram is updated, and that is done in the callback
      
  VersionHistory.saveAsLayoutUpdate(function() {
    Action.ajax(Action.updateUmpleLayoutEditorCallback,format("action=addPositioning&actionCode={0}",umpleJson));
  });
}

Action.updateUmpleLayoutEditorCallback = function(response)
{
  // DEBUG
  // console.log("Inside updateUmpleLayoutEditorCallback")
  var umpleCode = response.responseText;
  var positioning = Page.splitUmpleCode(umpleCode)[1];
  Page.setUmplePositioningCode(positioning);
  Page.hideLoading();
  Action.updateUmpleDiagramForce(true, true);
}

Action.updateUmpleDiagram = function() {
 return Action.updateUmpleDiagramForce(true)
}

// To fetch the feature model json from the backend complier
Action.fetchFeatureModelTreeThen = function(next)
{
  let proceed = function() {
    if (typeof next === "function") next();
  };
  // proceedAsync is only used by the early-return branches below — they need the continuation deferred via setTimeout so fetchFeatureModelTreeThen returns before next() fires. The main Ajax onFinally path calls the sync proceed() directly.
  let proceedAsync = function() {
    setTimeout(proceed, 0);
  };


  let mount = document.getElementById("featureModelTreeContainer");

  // Additional check to ensure this fetch only happens when in the feature diagram mode
  if (!Page.useGvFeatureDiagram) {
    FeatureTree.reset();
    Page.hasFeatureModelTree = false;
    FeatureTreeModal._fetchId++;
    FeatureTreeModal._fetchInFlight = false;
    FeatureTreeModal._lastFetchFailed = false;
    FeatureTreeModal._lastFetchStatus = -1;
    FeatureTreeModal.close();
    if (mount) {
      while (mount.firstChild) mount.removeChild(mount.firstChild);
      mount.style.display = "none";
    }
    proceedAsync();
    return;
  }

  if (!mount) {
    Page.hasFeatureModelTree = false;
    FeatureTreeModal._lastFetchFailed = false;
    FeatureTreeModal._lastFetchStatus = -1;
    proceedAsync();
    return;
  }

  // async lock to prevent ajax mutex
  var thisFetchId = ++FeatureTreeModal._fetchId;
  FeatureTreeModal._fetchInFlight = true;
  FeatureTreeModal._lastFetchFailed = false;
  FeatureTreeModal._lastFetchStatus = -1;
  FeatureTreeModal.refreshBody();

  Ajax.sendRequest(
    "scripts/compiler.php",
    function(response) {
      // Stale callback guard: a newer fetch or a mode switch has made.
      if (thisFetchId !== FeatureTreeModal._fetchId) return;
      var featureModelJson = FeatureTree.getModelFromResponse(response.responseText);
      if (featureModelJson && featureModelJson.featureModel) {
        FeatureTree.parseModel(featureModelJson.featureModel);
        Page.hasFeatureModelTree = true;
      } else {
        FeatureTree.reset();
        Page.hasFeatureModelTree = false;
      }
    },
    "language=FeatureModelJson&theme=light&error=true&umpleCode="
      + encodeURIComponent(Page.getUmpleCode()),
    {
      onError: function(http) {
        // Error-unique: reset feature state and record failure for UI.
        // Stale callbacks do not mutate state; onFinally drives proceed().
        if (thisFetchId !== FeatureTreeModal._fetchId) return;
        FeatureTree.reset();
        Page.hasFeatureModelTree = false;
        FeatureTreeModal._lastFetchFailed = true;
        FeatureTreeModal._lastFetchStatus = http.status;
      },
      onFinally: function(http) {
        if (thisFetchId !== FeatureTreeModal._fetchId) {
          proceed();
          return;
        }
        FeatureTreeModal._fetchInFlight = false;
        FeatureTreeModal.refreshBody();
        proceed();
      }
    }
  );
};

// isLayoutUpdate is true when the diagram is updated with the layout just
// worked out for an edit that has already been saved
Action.updateUmpleDiagramForce = function(forceUpdate, isLayoutUpdate)
{
  // DEBUG
  // console.log("Inside updateUmpleDiagramForce")
  var canonical = Action.trimMultipleNonPrintingAndComments(Page.getUmpleCode());
  if(!forceUpdate) {
    if(canonical == Action.savedCanonical)
    {
      // The umple code is as we last sent to the diagram, except for comment
      // changes, spaces, tabs and newlines, so we return without doing anything
      return;
    }
  }
  Action.savedCanonical=canonical;
  Page.showCanvasLoading();

  Action.fetchFeatureModelTreeThen(function(){
    var update = function() {
      Action.ajax(Action.updateUmpleDiagramCallback, Action.getLanguage());
    };
    if (isLayoutUpdate) VersionHistory.saveAsLayoutUpdate(update);
    else update();
  });

}

// Updates all formats of Umple diagram given the response from the
// backend. This can be svg or else node for Emode.
Action.updateUmpleDiagramCallback = function(response)
{
  // Get the canvas position information, used in several places
  var theCanvas = jQuery("#umpleCanvas");
  var canvasX=Math.round(theCanvas.offset().left);
  var canvasY=Math.round(theCanvas.offset().top);

  // console.log("Debug E6.1: Inside updateUmpleDiagramCallback")
  var diagramCode = "";
  var errorMessage = "";

  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
  Page.hideExecutionArea();

  if(diagramCode == null || diagramCode == "" || diagramCode == "null") 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("<a href=\"\#errorClick\">See message.</a> To fix: edit model or click undo");
  }
  else
  {
    Page.enableDiagram(true);
    // reset error message
    if(!Action.diagramInSync)
    {
      Action.diagramInSync = true;
    }

    Page.setFeedbackMessage("");
    Page.hideGeneratedCode();

    // Enable dynamic checkboxes of mixsets and named filters
    // Find any phrases describing
    // named mixsets of filters not commented out
    var dynamicCheckboxItems = new Array();
    var umpleCodeForScan = Page.getUmpleCode();
    var mixsetMatches = umpleCodeForScan
      .match(/(?<!(\/\/.*))mixset\s+[a-zA-Z1-9-_]+/g);
    var filterMatches = umpleCodeForScan
      .match(/(?<!(\/\/.*))filter\s+[a-zA-Z1-9-_]+/g);
    if (mixsetMatches != null&&!Page.hasFeatureModelTree) dynamicCheckboxItems = dynamicCheckboxItems.concat(mixsetMatches);
    if (filterMatches != null) dynamicCheckboxItems = dynamicCheckboxItems.concat(filterMatches);
    // Add special suboptions
    dynamicCheckboxItems.push("gvmanual","gvdot","gvsfdp","gvcirco","gvortho");
    
    // Clear out previous
    // TODO. May need to keep some so as to preserve selections
    var spanToInjectItem = 
      document.getElementById("ShowMFDynamicArea");
    spanToInjectItem.innerHTML = "";

    if(! (dynamicCheckboxItems == null || dynamicCheckboxItems.length == 0)) {
      var boxesToActivate = new Array();
      // Iterate through all the named filters of mixsets
      dynamicCheckboxItems.forEach(
       function(aDynamicCheckboxItem) {
        // remove spaces from the item so it can also serve
        //  as part of the ID,
        // so idPart would be something like filterF1
        var idPart = aDynamicCheckboxItem.replace(/\s/g, '');

        var htmlToAdd = "<li id=\"tt"+idPart
          +"\" class=\"layoutListItem view_opt_class\">\
                <input id=\"button"+idPart+"\" class=\"checkbox\" type=\"checkbox\"/>\
                <a id=\"label"+idPart+"\" class=\"buttonExtend\">"+aDynamicCheckboxItem+"</a>\
              </li>";
        spanToInjectItem.innerHTML += htmlToAdd;
        // Make sure it is clickable ... have to do this after completion
        // Since activation is cancelled as new items are added
        boxesToActivate.push(idPart);
      });

      /*
       * Reconcile Page.mixsetsActive against the mixsets that still exist in
       * source. boxesToActivate was built from the regex scan above, so any
       * entry absent from it means that mixset was deleted or commented out
       * and should be dropped from the active set.
       *
       * Skip this reconciliation when the feature tree owns mixset state
       * to prevent the selection being cleared by this code
       */
      if (!Page.hasFeatureModelTree) {
        Page.mixsetsActive = Page.mixsetsActive.filter(function(aMixset){
          return boxesToActivate.includes("mixset"+aMixset);
        });
      }
      Page.filtersActive = Page.filtersActive.filter(function(aFilter){
        return boxesToActivate.includes("filter"+aFilter);
      });
      Page.specialSuboptionsActive = Page.specialSuboptionsActive.filter(function(aSuboption){
        return boxesToActivate.includes(aSuboption);
      });

      // Now activate the new ones found
      boxesToActivate.forEach(
       function(aBoxToActivate) {
        Page.initHighlighter("button"+aBoxToActivate);
        // Select it if it was already selected
        var buttonSetting = false;
        if(aBoxToActivate.substr(0,6)=="mixset"
          && Page.mixsetsActive.includes(aBoxToActivate.substr(6))) {
          buttonSetting = true;
        }
        else if(aBoxToActivate.substr(0,6)=="filter"
          && Page.filtersActive.includes(aBoxToActivate.substr(6))) {
          buttonSetting = true;
        }
        else if(aBoxToActivate.substr(0,2)=="gv"
          && Page.specialSuboptionsActive.includes(aBoxToActivate)) {
          buttonSetting = true;
        }        
        jQuery("#button"+aBoxToActivate).prop('checked',buttonSetting);       
        Page.initAction("button"+aBoxToActivate);
        Page.initLabel("label"+aBoxToActivate);
        ToolTips.setATooltipBasic(ToolTips.dynamicTooltips,"tt"+aBoxToActivate,"right");
        jQuery("#tt"+aBoxToActivate).show();
      });
    }

    // Display editable class diagram
    if(Page.useEditableClassDiagram) {
      var newSystem = Json.toObject(diagramCode);
      UmpleSystem.merge(newSystem);
      UmpleSystem.update(); 
      //Apply readonly styles
      if (Page.readOnly) 
      {
        jQuery("span.editable").addClass("uneditable");
      }
    }
    else if(Page.useJointJSClassDiagram) {
      // This code is deprecated as Joint.js functionality is no longer supported

      var model = JSON.parse(diagramCode.replace( new RegExp('} { "name": "', "gi"), '}, { "name": "' ));

      var umpleCanvas = jQuery("#umpleCanvas");

      var paper = JJSdiagram.initJJSDiagram(umpleCanvas, model);

      // zooming with the mouse wheel or finger swipe
      var MouseWheelHandler = function (event){
        var delta = Math.max(-1, Math.min(1, (event.wheelDelta || -event.detail)));
        if (event.altKey === true) {
          var paperHeight = paper.options.height;
          var paperWidth = paper.options.width;
          // scaleFactor is either 1.1 or 0.9
          var scaleFactor = 1 + (Math.abs(delta) / (delta * 10));
          paper.setDimensions(paperWidth * scaleFactor, paperHeight * scaleFactor)

          //correct paper sizing
          if( JJSdiagram.paper ) 
          JJSdiagram.paper.setDimensions(jQuery("#umpleCanvas")[0].clientWidth, jQuery("#umpleCanvas")[0].clientHeight);

        }
      };
      // using the umpleCanvas as the mouse wheel event target, as it is a stable entity
      var paperHolder = document.getElementById("umpleCanvas");

      if (paperHolder.addEventListener) {
        // IE9, Chrome, Safari, Opera
        paperHolder.addEventListener("mousewheel", MouseWheelHandler, false);
        // Firefox
        paperHolder.addEventListener("DOMMouseScroll", MouseWheelHandler, false);
      }
      // IE 6/7/8
      else {paperHolder.attachEvent("onmousewheel", MouseWheelHandler);}

      // Simulate a click on the canvas to draw focus and enable keyboard shortcuts.
      jQuery("#jjsPaper").click(function(){ Action.focusOn(Page.umpleCanvasId(), true);});

    }
    // Display static svg diagram
    else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram || Page.useGvUseCaseDiagram || Page.useGvEntityRelationshipDiagram || Page.useInstanceDiagram)
    {
      theCanvas.html(format('{0}', diagramCode));
      theCanvas.children().first().attr("id", "svgCanvas");
      Page.zoomToCurrentZoom();

      // If gv class mode is gvmanual then we need to update all the umple 
      // positioning information given the diagram locations
      if((Page.useGvClassDiagram || Page.useGvEntityRelationshipDiagram) && Page.isGvManual()) {

        // First, in case we have used a special algorithm to reformulate we first turn them all off
        // This will not have effect if the algorithm is specified in the code.
        var algoWasRemoved = Action.deactivateSpecialLayoutAlgorithmsExcept(null);

// DEBUG
// Page.catFeedbackMessage("updating class diagram layout due to gvmanual "+canvasX+" "+canvasY+" | ");

        // For each of the nodes loop through it
        var positioningCode = jQuery("#umpleLayoutEditorText").val();
        var elems=document.getElementsByClassName("node");
        var posMap = new Array();
        var minUmpleLeft = 9999999;
        var minUmpleTop = 9999999;
        var minRectLeft = 9999999;
        var minRectTop = 9999999;

        for(let i=0;i<elems.length;i++){
          var currentClassForPos = Action.getGvClassNameFromNode(elems[i]);
          var umplePosOfCurrentClass = Action.getGvPosition(positioningCode, currentClassForPos);

          if (umplePosOfCurrentClass == null) {
            // Position not found ... this is actually a bug caused
            // when updating the name of a class in the text ... needs fixing
            continue;
          }
          var theRect=Action.getRectFromSvgNode(elems[i], canvasX, canvasY);
          var rectLeft = theRect.left;
          var rectTop = theRect.top;
          // Get the centre of the rectangle as
          // the gv positions are also centre-focused
          var rectCentreX = theRect.centreX;
          var rectCentreY = theRect.centreY;
          var uLeft = umplePosOfCurrentClass.x;
          var uTop = umplePosOfCurrentClass.y;

// DEBUG
//Page.setFeedbackMessage(".."+currentClassForPos
//  +" "+umplePosOfCurrentClass.x+"/"+rectCentreX
//  +" "+umplePosOfCurrentClass.y+"/"+rectCentreY);

          posMap.push({className: currentClassForPos,
            fullUmplePosOfCurrentClass: umplePosOfCurrentClass.all,
            left: uLeft,
            umpleX: Number(umplePosOfCurrentClass.x)
              + Number(umplePosOfCurrentClass.width) / 2,
            rectCentreX: rectCentreX,
            top: uTop,
            umpleY: Number(umplePosOfCurrentClass.y)
              + Number(umplePosOfCurrentClass.height) / 2,
            rectCentreY: rectCentreY,
            associationPos1: umplePosOfCurrentClass.assoc1,
            associationPos2: umplePosOfCurrentClass.assoc2
          });
          minUmpleLeft=Math.min(minUmpleLeft,uLeft);
          minUmpleTop=Math.min(minUmpleTop,uTop);
          minRectLeft=Math.min(minRectLeft,rectLeft);
          minRectTop=Math.min(minRectTop,rectTop);
        }
    
        let diffX=minUmpleLeft-minRectLeft;
        let diffY=minUmpleTop-minRectTop;
// DEBUG
// Page.catFeedbackMessage("In process of updating nodes from gv diffx="+diffX+" diffy="+diffY+" ");
        // Now loop through the Map updating the Umple code if needed
        var nodesMoved = 0;
        posMap.forEach(function(thePos) {
          const changeThreshold = 10;
          var deltaX= Math.round((thePos.rectCentreX+diffX)-thePos.umpleX);
          var deltaY= Math.round((thePos.rectCentreY+diffY)-thePos.umpleY);
          if(Math.abs(deltaX) > changeThreshold || Math.abs(deltaY) > changeThreshold) {
             // Update Umple text, 
             nodesMoved++;
             Action.updateGVPositionBasic(thePos.className,deltaX,deltaY,
               positioningCode,
               thePos.fullUmplePosOfCurrentClass,
               thePos.left,
               thePos.top,
               thePos.associationPos1,
               thePos.associationPos2,
               false);
// DEBUG
// Page.catFeedbackMessage(" redrawn: "+thePos.className+" //x"+thePos.umpleX+"->"+deltaX+"/"+(thePos.rectCentreX+diffX)
//  +" y"+thePos.umpleY+"->"+deltaY+"/"+(thePos.rectCentreY+diffY));

          }
        });
//DEBUG
//Page.catFeedbackMessage(" Moved "+nodesMoved+" nodes");
        if(algoWasRemoved) {
          // We are coming back from an algo update so we need to push to history
          TabControl.getCurrentHistory().save(Page.getUmpleCode(), "moveClass");
        }
      }

      // generate association/relation mapping - to show neighbor classes from context menu



      const umpleCode=Page.getUmpleCode();
      const lines = umpleCode.split('\n');
      const result = {};
      let currentClass = null;
    
      const classRegex = /^class\s+(\w+)/;
      const assocRegex = /\s*(--\*|--|\*--\*|->|<-)\s*/;
      const isARegex = /^isA\s+([A-Za-z0-9_,\s]+);?/;
    
      for (let i = 0; i < lines.length; i++) {
          const line = lines[i].trim();
    
          // Stop processing at the end marker
          if (line.includes('//$?[End_of_model]$?')) {
            break;
         }
    
          // Detect class definition
          const classMatch = line.match(classRegex);
          if (classMatch) {
            currentClass = classMatch[1];
            if (!result[currentClass]) result[currentClass] = [];
            continue;
          }
    
          // If no class is currently tracked, skip
          if (!currentClass) continue;
    
            // Handle isA line
            const isAMatch = line.match(isARegex);
            if (isAMatch) {
              const isAClasses = isAMatch[1].split(',').map(cls => cls.trim().replace(/[^a-zA-Z0-9_]/g, ''));
              result[currentClass].push(...isAClasses);
              continue;
            }
    
          // Detect association
          const assocSplit = line.split(assocRegex);
          if (assocSplit.length >= 3) {
            const rightPart = assocSplit[2].trim();
            const parts = rightPart.split(/\s+/);
    
            // Usually formatted like: [multiplicity, ClassName, fieldName]
            const classCandidate = parts.length > 1 ? parts[1] : parts[0];
            // Clean up any trailing semicolons or symbols
            const cleanClass = classCandidate.replace(/[^a-zA-Z0-9_]/g, '');
            if (cleanClass) {
              result[currentClass].push(cleanClass);
            }
          }
    
        }

        // Add reverse links (cross-referencing)
        for (const [cls, dependencies] of Object.entries(result)) {
          for (const dep of dependencies) {
            if (!result[dep]){
              result[dep] = [];
            } 
            if(!result[dep].includes(cls)){
              result[dep].push(cls);
            }
          }
        }

        Action.neighbors=result;


      Action.setupPinch();
    }
    // Display generated HTML output in the right-hand canvas area
    else if(Page.useEventSequence || Page.useStateTables)
{
  theCanvas.html("<div id='htmlCanvas' class='generatedDiagram'></div>");
  jQuery("#htmlCanvas").html(diagramCode);

  // Apply the same coloring used by the Generate It path
  if (Page.useStateTables && typeof StateTree !== "undefined" && StateTree.colourStateTables) {
    StateTree.colourStateTables();
  }

  if (Page.useEventSequence && typeof StateTree !== "undefined" && StateTree.colourEventSequences) {
    StateTree.colourEventSequences();
  }
}

    else if(Page.useCRUDUI)
    {
      theCanvas.html("<div id='htmlCanvas' class='generatedDiagram'></div>");
      Page.showCrudFromJson(diagramCode, "", "#htmlCanvas");
    }
    //Display structure diagram
    else if(Page.useStructureDiagram)
    {
      jQuery("#umpleCanvas").html('<svg id="svgCanvas"></svg>');
      eval(diagramCode);
    }   
  }

  //Show the error message
  if(errorMessage != "")
  {
    Page.showGeneratedCode(errorMessage, "diagramUpdate");
  }
  
  Page.hideLoading();

  if (Page.useGvClassDiagram || Page.useGvEntityRelationshipDiagram) {
    GvDiagramEdit.bindClassDiagram(canvasX, canvasY);
  }

  if(Page.useGvStateDiagram){
    GvDiagramEdit.bindStateDiagram();
    //add double click to display menu, issue#2081
    var elems=document.getElementsByClassName("node");
    // Add event listener to Graphviz state nodes for right click
    for(let i=0;i<elems.length;i++){
      elems[i].addEventListener("contextmenu", function(event){
        event.preventDefault();
        Action.drawStateMenu(event);
      });
      // Add event listener for double click, calling the same function as right-click
      elems[i].addEventListener("dblclick", function(event){
        event.preventDefault(); // Prevent the default double-click behavior
        Action.drawStateMenu(event); // Call the same function to display the menu
      });
    }
    elems=document.getElementsByClassName("cluster");
    // Add event listener to Graphviz clusters for right click
    for(let i=0;i<elems.length;i++){
      elems[i].addEventListener("contextmenu", function(event){
        event.preventDefault();
        Action.drawStateMenu(event);
      });
      // Add event listener for double click on clusters, calling the same function as right-click
      elems[i].addEventListener("dblclick", function(event){
        event.preventDefault(); // Prevent the default double-click behavior
        Action.drawStateMenu(event); // Call the same function to display the menu
      });
    }
    var transitionElems = document.getElementsByClassName("edge");

    for (let i = 0; i < transitionElems.length; i++) {
      transitionElems[i].addEventListener("dblclick", function(event) {
        event.preventDefault(); // Prevent the default click behavior
        Action.displayTransitionMenu(event);
    });
    transitionElems[i].addEventListener("contextmenu", function(event) {
        event.preventDefault();
        Action.displayTransitionMenu(event);
    });
    }
  }  

  if(Page.useEventSequence){
    // Give event sequence states and transitions the same code selection as Graphviz state diagram elements
    jQuery("#htmlCanvas .event-sequence-grid").each(function() {
      var heading = jQuery(this).prevAll("h2").first().text().split(" ");
      var rows = jQuery(this).find(".floating-col td");
      var names = [];
      for(var i = 1; i < rows.length; i++) {
        var parentId = parseInt(jQuery(rows[i]).attr("data-parent"));
        names.push((isNaN(parentId) ? "" : names[parentId] + ".") + jQuery(rows[i]).text().replace(/^(- )*/, ""));
        rows[i].setAttribute("onclick", "javascript:Action.stateClicked(\"" + heading[1] + "^*^" + heading[4] + "^*^" + names[i-1] + "\")");
      }
      rows = jQuery(this).next(".event-sequence-list").find("tr");
      for(var i = 1; i < rows.length; i++) {
        var entry = jQuery(rows[i]).find("td")[2];
        entry.setAttribute("onclick", "javascript:Action.stateClicked(\"" + heading[1] + "^*^" + heading[4] + "^*^" + jQuery(entry).text() + "\")");
      }
    });
    jQuery("#htmlCanvas [data-transition]").click(function() {
      Action.transitionClicked(jQuery(this).attr("data-transition"));
    });
  }

  if(Page.useStateTables){
    // Give state table rows the same state identifier and menu as Graphviz state nodes
    jQuery("#htmlCanvas .statetable").each(function() {
      // Composite tables list combinations of concurrent states, not individual states
      if(jQuery(this).parent().prevAll("h3").first().text().indexOf("Composite") == 0) return;
      var heading = jQuery(this).parent().prevAll("h2").first().text().split(" ");
      var rows = jQuery(this).find("tr");
      // In state-state tables the column headings list the same states, in the same order as the rows
      var isStateStateTable = jQuery(this).hasClass("state-statetable");
      var columnHeadings = jQuery(rows[0]).find("td");
      var names = [];
      for(var i = 1; i < rows.length; i++) {
        var entry = jQuery(rows[i]).find("td")[0];
        var parentId = parseInt(jQuery(entry).attr("data-parent"));
        names.push((isNaN(parentId) ? "" : names[parentId] + ".") + jQuery(entry).text().replace(/^(- )*/, ""));
        var stateLink = "javascript:Action.stateClicked(\"" + heading[1] + "^*^" + heading[4] + "^*^" + names[i-1] + "\")";
        var stateEntries = isStateStateTable ? [entry, columnHeadings[i]] : [entry];
        for(var j = 0; j < stateEntries.length; j++) {
          stateEntries[j].setAttribute("href", stateLink);
          stateEntries[j].setAttribute("onclick", stateLink);
          stateEntries[j].addEventListener("contextmenu", function(event){
            event.preventDefault();
            Action.drawStateMenu(event);
          });
          stateEntries[j].addEventListener("dblclick", function(event){
            event.preventDefault();
            Action.drawStateMenu(event);
          });
        }
      }
      // Give transitions the same selection and menu as Graphviz state diagram edges
      jQuery(this).find("[data-transition]").each(function() {
        this.setAttribute("href", "javascript:Action.transitionClicked(\"" + jQuery(this).attr("data-transition") + "\")");
        jQuery(this).click(function() {
          Action.transitionClicked(jQuery(this).attr("data-transition"));
        });
        // Event headings only select because they may represent several transitions.
        if(jQuery(this).hasClass("event-header")) return;
        this.addEventListener("contextmenu", function(event){
          event.preventDefault();
          Action.displayTransitionMenu(event);
        });
        this.addEventListener("dblclick", function(event){
          event.preventDefault();
          Action.displayTransitionMenu(event);
        });
      });
      // Grey (empty) cells add a transition from the state of their row, as in the state diagram
      rows.slice(1).each(function(r) {
        jQuery(this).find("td").slice(1).each(function(c) {
          if(!jQuery(this).text().match(/^\s$/)) return;
          var fromState = heading[1] + "^*^" + heading[4] + "^*^" + names[r];
          var addTransition = function(event){
            event.preventDefault();
            if(!Action.diagramInSync || Page.readOnly) return;
            if(isStateStateTable) {
              // The column is the destination state: same as the Add Transition palette tool
              GvDiagramEdit.commitTransition(fromState, heading[1] + "^*^" + heading[4] + "^*^" + names[c]);
            } else {
              // The column is the event: same as Add Transition in the state menu, with the event filled in
              var range = GvDiagramEdit.findStateRange(GvDiagramEdit.getFullText(), fromState);
              if(!range) return;
              Action.drawInputState("transition", GvDiagramEdit.getFullText().substring(range.start, range.end),
                names[r].split(".").pop(), jQuery(columnHeadings[c+1]).text());
            }
          };
          this.addEventListener("contextmenu", addTransition);
          this.addEventListener("dblclick", addTransition);
        });
      });
    });
  }
}


// Called when a layout algorithm is clicked, in order to unselect the others
// Can also be used to unselect all of them when gvmanual is active and
// we are in the update callback
Action.deactivateSpecialLayoutAlgorithmsExcept = function(onlyAlgoToKeep) {
  var specialAlgos = new Array();
  var didRemove = false;
  specialAlgos.push("gvdot","gvsfdp","gvcirco");

  // If the one to keep is not a special algo such as gvortho then do nothing
  if(onlyAlgoToKeep != null && (! specialAlgos.includes(onlyAlgoToKeep)) ) {
    return false;
  }
 
  // Search for any of the specialAlgos and turn off except the one to keep
  specialAlgos.forEach(function(anAlgo) {
    if(onlyAlgoToKeep == null || anAlgo != onlyAlgoToKeep) {
      jQuery("#button"+anAlgo).prop('checked',false);
      var index = Page.specialSuboptionsActive.indexOf(anAlgo);
      if(index !== -1) {
        // remove an algo that was selected
        Page.specialSuboptionsActive.splice(index,1);
        didRemove = true;
      }
    }
  });
  return didRemove;
}

Action.getRectFromSvgNode = function(node,canvasX, canvasY) {
  var svgRect = node.getBoundingClientRect();
  return {
    left: Math.round(svgRect.left-canvasX),
    top: Math.round(svgRect.top-canvasY),
    // Get the centre of the rectangle as it actually appears
    // as the gv positions are also centre-focused
    centreX: Math.round(svgRect.left-canvasX + (Math.abs(svgRect.width/2))),
    centreY: Math.round(svgRect.top-canvasY  + (Math.abs(svgRect.height/2)))
  };
}

Action.updateFromDiagramCallback = function(response)
{
  var diagramCode = "";
  var errorMessage = "";
  
  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
  
  if((diagramCode == null || diagramCode == "" || diagramCode == "null") && Action.diagramInSync) 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("<a href=\"\#errorClick\">See message.</a> To fix: edit model or click undo");
  }
  else
  {
    Page.enableDiagram(true);
    Action.diagramInSync = true;
  }
  
  //Show the error message
  if(errorMessage != "")
  {
    Action.lastCompilerErrorHtml = errorMessage;
    Page.showGeneratedCode(errorMessage, "diagramUpdate");
  }  
  else
  {
    Action.lastCompilerErrorHtml = "";
  }
}

// Gets the code to display from the AJAX response
Action.getDiagramCode = function(responseText)
{
  var output = "";
  
  // Also want to use the same response for JointJS
  if(Page.useEditableClassDiagram || Page.useJointJSClassDiagram)
  {
    output = responseText.split('URL_SPLIT')[1];
    
    if(output == "null") output = "";
    
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram || Page.useGvUseCaseDiagram || Page.useGvEntityRelationshipDiagram || Page.useInstanceDiagram)
  {
    // The graphviz diagrams are taken from the inner svg tag only. 
    // This allows the website to have a dynamic canvas size around the diagram
    var codeparts = responseText.split('<svg width=');
    
    //Put the start of the svg back together. 
    if(codeparts.length>1 && codeparts[1].length>100) {
      output = "<svg width="+codeparts[1];
      //remove the redundant svg closing tag
      output = output.replace(/<\/svg>$/, "");
    }
  }
  else if(Page.useCRUDUI || Page.useEventSequence || Page.useStateTables)
  {
    var language = Page.useCRUDUI ? "crudJson" :
                   Page.useEventSequence ? "eventSequence" :
                   "stateTables";

    output = Page.getGeneratedMarkup(responseText, language);
  }
  else if(Page.useStructureDiagram)
  {
    output = responseText.split("<p>URL_SPLIT")[1];
    output = output.replace(/##CANVAS_ID##/g, "svgCanvas");
    // Converts html encoded special characters to plaintext
    output = jQuery("<div/>").html(output).text();
  }
  
  return output;
}

// Gets any error code from the AJAX response
Action.getErrorCode = function(responseText)
{
  var output = "";
  if(Page.useEditableClassDiagram || Page.useStructureDiagram)
  {
    output = responseText.split('URL_SPLIT')[0];
    
    if(output == "<p>") output = "";
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram || Page.useGvUseCaseDiagram || Page.useGvEntityRelationshipDiagram || Page.useInstanceDiagram)
  {
    var miscStuffAndErrorMessages = responseText.split('<svg width=')[0];
    var prelimparts = miscStuffAndErrorMessages.split('errorRow');
    if(prelimparts.length > 1) {
      output = miscStuffAndErrorMessages.split("</script>&nbsp;")[0];
    }
  }
  else if(Page.useCRUDUI || Page.useEventSequence || Page.useStateTables)
  {
    var language = Page.useCRUDUI ? "crudJson" :
                   Page.useEventSequence ? "eventSequence" :
                   "stateTables";
    output = Page.getErrorMarkup(responseText, language);
  }
  return output;
}

// This function is no longer being called as its caller has been commented out
Action.classResizing = function(event, ui)
{
  var classId = event.target.id;
  var umpleClass = UmpleSystem.find(classId);
  var classSel = "#" + classId;
  
  var newWidth = Math.round(jQuery(classSel).width());
  var newHeight = Math.round(jQuery(classSel).height());
  
  UmpleSystem.updatingSize(umpleClass,newWidth,newHeight);
}

Action.associationSnap = function(x, y, dragDivSel) 
{
  var id = jQuery(dragDivSel).prop("id");
  var elementId = id.substr(0,id.lastIndexOf("_"));
  var index = id.substr(id.lastIndexOf("_") + "anchor".length + 1);
  var association = UmpleSystem.findAssociation(elementId);
  var umpleClass = association.getClass(index);
  var perimeter = UmpleClassFactory.perimeterPosition(umpleClass,new UmplePosition(x,y,0,0),UmpleSystem.position());
  return [perimeter.x, perimeter.y];
}

Action.associationSnapClassReady = function(x,y,umpleClass)
{
  var perimeter = UmpleClassFactory.perimeterPosition(umpleClass,new UmplePosition(x,y,0,0),UmpleSystem.position());
  return [perimeter.x, perimeter.y];
}

Action.updateMovedAssociation = function(dragDivSel, association)
{
  jQuery(dragDivSel).show();
  var dragOffset = jQuery(dragDivSel).offset();
  var dragDivId = jQuery(dragDivSel).prop("id");
  jQuery(dragDivSel).hide();
  
  var left = Math.round(dragOffset.left);
  var top = Math.round(dragOffset.top);
  
  var xys = Action.associationSnap(left,top,dragDivSel);
  var screenPosition = (new UmplePosition(xys[0],xys[1],0,0));  
  
  if (dragDivId.endsWith("_anchor0"))
  {
    association.setOffsetOnePosition(screenPosition);
  }
  else
  {
    association.setOffsetTwoPosition(screenPosition);
  }
  
  UmpleSystem.redrawAssociation(association);
  Action.associationSelected(null);
}

Action.validateAttributeName = function(newAttribute)
{
  return newAttribute.length!=0  && (
     newAttribute.match(/^[_a-zA-Z0-9]+$/) ||
     newAttribute.match(/^[_a-zA-Z0-9]+[\u0020]*:[\u0020]*[_a-zA-Z0-9]+(\[\])?$/)
     );
}

Action.validateMethodName = function(newMethod)
{
  return newMethod.length!=0 &&
     newMethod.match(/^[-+#]?\s*[_a-zA-Z0-9]+\s*\(([_a-zA-Z0-9]+(\[\])?(,\s*[_a-zA-Z0-9]+(\[\])?)*)?\)(\s*:\s*[_a-zA-Z0-9]+(\[\])?)?$/);
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
