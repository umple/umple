// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions that select and highlight code in the text editor, such as for an item clicked in a diagram

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
