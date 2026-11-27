// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for the caret and line number of the text editor, including the
// hidden commands that can be typed in the line number field

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
