// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions that respond to edits of the text or the diagram, and keep the
// text, the layout and the diagram in sync

// Called when a change is made by a command that modifies the text, to refresh it
// and then refresh the diagram.
Action.directUpdateCommandCallback = function(response)
{
  Action.updateUmpleTextCallback(response);
  Action.redrawDiagram();
}

// Called whenever any change is made on the graphic pane
// such as adding/deleting/moving/renaming class/assoc/generalization
Action.updateUmpleTextCallback = function(response)
{
  // DEBUG
  // console.log("Inside updateUmpleTextCallback: ")
  if (!justUpdatetoSaveLater && !justUpdatetoSaveLaterForTextCallback){
    TabControl.getCurrentHistory().save(response.responseText, "TextCallback");
    Page.setExampleMessage("");
  }
  Action.freshLoad = true;
  
  Page.setUmpleCode(response.responseText, Action.update.codeChange);
  
  Page.hideLoading();

  if (DiagramEdit.textChangeQueue.length == 0) 
  {
    Action.freshLoad = false;
    DiagramEdit.pendingChanges = false;
    Action.setjustUpdatetoSaveLater(false);
    Action.setjustUpdatetoSaveLaterForTextCallback(false);
  }
  else{
    Action.setjustUpdatetoSaveLater(true);
    Action.setjustUpdatetoSaveLaterForTextCallback(true);
    DiagramEdit.doTextUpdate();
  }
  
  //Uncomment for testing purposes only - to update the image after updating the text
}

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
