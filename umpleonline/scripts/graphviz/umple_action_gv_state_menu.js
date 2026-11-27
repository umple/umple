// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Context menu and text input actions for states in Graphviz state diagrams

//Called by Action.drawStateMenu(), this multiuse function takes any textual input requires for 
//menu edits on states.
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.drawInputState = function(inputType,stateCode,stateName,eventName){
  // DEBUG
  // console.log("Inside drawInputState: ")
  // console.log("with inputType: ", inputType)
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "fixed";
  prompt.id="promptBox";
  var promptRect=prompt.getBoundingClientRect();
  if(event.clientX+promptRect.width>window.innerWidth){
    prompt.style.right=(window.innerWidth-event.clientX)+"px";
  } else {
    prompt.style.left = event.clientX+"px";
  }
  if(event.clientY+promptRect.height>window.innerHeight){
    prompt.style.bottom=(window.innerHieght-event.clientY)+"px";
  } else {
    prompt.style.top = event.clientY+"px";
  }
  var input = document.createElement('input');
  input.type = 'text';
  input.style.padding = '5px';
  input.style.borderRadius = '3px';
  input.style.border = '1px solid #ccc';
  input.style.width = '200px';
  input.style.marginLeft = '5px';
  var inputErrorMsg = document.createElement('label');
  inputErrorMsg.type='label';
  inputErrorMsg.textContent='Error - Please enter an alphanumeric name beginning with a non-numeric character.';
  inputErrorMsg.style.color="red";
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  var unsanitizedState=stateCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  var label = document.createElement('label');
  label.htmlFor = 'inputLabel';
  label.style.marginRight = '5px';
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  if(inputType=="rename"){

    if (clientDebuggerFlag){
      console.log("Renaming State ...");
    }

    label.appendChild(document.createTextNode("New name for \'"+stateName+"\'?"));
    input.value = stateName;
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        //only accounts for case where states all have unique names
        if(Action.validateAttributeName(input.value)){

          if (clientDebuggerFlag){
            console.log("Getting code from codemirror editor ...");
          }
          // get contents of codemirror 6 editor
          let orig = Page.codeMirrorEditor6.state.doc.toString();

          let regex=new RegExp("(\\W+)("+stateName+")(\\W+)");
          let res;
          while((res=orig.match(regex))!=null){
            orig=orig.substr(0,res.index+res[1].length)+input.value.trim()+orig.substr(res.index+res[1].length+res[2].length,orig.length-(res.index+res[1].length+res[2].length));
          }

          if (clientDebuggerFlag){
            console.log("Setting updated code to codemirror editor ...");
          }

          // update content of codemirror 6 editor with updated code/text
          Page.setCodeMirror6Text(orig);

          setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

          document.removeEventListener("mousedown", hider);

          if (clientDebuggerFlag){
            console.log("Removing mousedown event ...");
          }
          
          prompt.remove();
          Action.removeContextMenu();
          TabControl.getCurrentHistory().save(orig, "menuUpdate");
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });  
  } else if(inputType=="substate") {

    if (clientDebuggerFlag){
      console.log("Substating state ...");
    }

    label.appendChild(document.createTextNode("Name of new substate?"));
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        if(Action.validateAttributeName(input.value)){
          let subtext=unsanitizedState.substr(0,unsanitizedState.length-1)+"  "+input.value+"{}}";

          if (clientDebuggerFlag){
            console.log("Getting original code and adding substate ...");
          }

          subtext=Page.codeMirrorEditor6.state.doc.toString().replace(unsanitizedState,subtext);

          if (clientDebuggerFlag){
            console.log("Setting updated code with substate into codemirror editor ...");
          }

          Page.setCodeMirror6Text(subtext);

          setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

          document.removeEventListener("mousedown", hider);

          if (clientDebuggerFlag){
            console.log("Removing mousedown event ...");
          }

          prompt.remove();
          Action.removeContextMenu();
          TabControl.getCurrentHistory().save(subtext, "menuUpdate");
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
   
  } else if(inputType=="transition"){
    //should have an indicator after user enters label so they know to press another state
    
    if (clientDebuggerFlag){
      console.log("Adding Transition ...");
    }

    label.appendChild(document.createTextNode("Condition for new transition?"));
    // Optional event, e.g. from the column of a state table cell
    if(eventName && Action.validateAttributeName(eventName)) input.value = eventName;
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        if(Action.validateAttributeName(input.value)){
          
          var orig=stateCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
          document.removeEventListener("mousedown", hider);
          prompt.remove();
          Action.removeContextMenu();

          if (clientDebuggerFlag){
            console.log("Waiting to select target state for transition ...");
          }

          var assocState=function (event){
              let targ=event.target;
              while(targ.parentElement.id!="graph0" && targ.tagName!="TD"){
                targ=targ.parentNode;
              }
              let elemText=targ.outerHTML.substr(targ.outerHTML.indexOf("stateClicked(&quot;")+"stateClicked(&quot;".length,targ.outerHTML.indexOf("&quot;)\"")-(targ.outerHTML.indexOf("stateClicked(&quot;")+"stateClicked(&quot;".length));
              elemText=elemText.split("^*^"); //index 0: class, index 1: base state, index 2: remaining states
              let subtext="  "+input.value+" -> "+elemText[2]+";\n}";
              let newState=orig.substr(0,orig.length-1)+subtext;

              if (clientDebuggerFlag){
                console.log("New state created ...");
                console.log("Replacing original state with new state in the code ...");
              }

              Page.setCodeMirror6Text(Page.codeMirrorEditor6.state.doc.toString().replace(orig,newState));

              setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

              //TODO - Saving/edit history doesn't seem to be working here.
              TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString(), "menuUpdate");
              let others=document.getElementsByClassName("node");
              for(let q=0;q<others.length;q++){
                others[q].removeEventListener("mousedown",assocState);
              }
              elems=document.getElementsByClassName("cluster");
              for(let q=0;q<others.length;q++){
                others[q].removeEventListener("mousedown",assocState);
              }  
              others=document.querySelectorAll("#htmlCanvas td.state-header[href]");
              for(let q=0;q<others.length;q++){
                others[q].removeEventListener("mousedown",assocState);
              }
            };
          //add event listener to Graphviz nodes for left click
          var elems=document.getElementsByClassName("node");
          for(let i=0;i<elems.length;i++){
            elems[i].addEventListener("mousedown", assocState);
          }       
          elems=document.getElementsByClassName("cluster");
          for(let i=0;i<elems.length;i++){
            elems[i].addEventListener("mousedown", assocState);
          }       
          elems=document.querySelectorAll("#htmlCanvas td.state-header[href]");
          for(let i=0;i<elems.length;i++){
            elems[i].addEventListener("mousedown", assocState);
          }
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
  } else if(inputType=="colorState") {

    if (clientDebuggerFlag){
      console.log("Changing State Color ...");
    }

    // Change the input to a color picker
    input.type = "color";
    input.style.width = "30px";

    label.appendChild(document.createTextNode("Color - "));

    // Add a clickable arrow like the class color UI
    var arrow = document.createElement("span");
    arrow.innerHTML = "&#8594;";
    arrow.style.cursor = "pointer";
    arrow.style.paddingLeft = "5px";

    var applyColor = function(){
      Action.setColorState(unsanitizedState, stateName, input.value);

      document.removeEventListener("mousedown", hider);
      prompt.remove();
      Action.removeContextMenu();

      // Save history (consistent with other menu actions)
      TabControl.getCurrentHistory().save(Page.codeMirrorEditor6.state.doc.toString(), "menuUpdate");
    };

    input.addEventListener("keydown", function(e) {
      if (e.key === "Enter") {
        applyColor();
      }
    });

    arrow.addEventListener("click", function(){
      applyColor();
    });

    prompt.appendChild(arrow);
  }
  // Add the prompt to the page
  prompt.appendChild(label);
  prompt.appendChild(input);
  document.body.appendChild(prompt);
  input.focus();
}

Action.setColorState = function(stateCode, stateName, colorValue) {
  var orig = Page.codeMirrorEditor6.state.doc.toString();
  var startIndex = orig.indexOf(stateCode);

  if (startIndex === -1) {
    console.log("State not found in editor.");
    return;
  }

  var endIndex = startIndex + stateCode.length;
  var updatedState = stateCode;

  // Replace existing displayColor if present
  if (updatedState.includes("displayColor")) {
    updatedState = updatedState.replace(
      /displayColor\s+#[0-9a-fA-F]{6}\s*;/,
      "displayColor " + colorValue + ";"
    );
  } 
  // Otherwise insert a new displayColor line inside the state block
  else {
    var braceIndex = updatedState.indexOf("{");
    if (braceIndex >= 0) {
      updatedState =
        updatedState.slice(0, braceIndex + 1) +
        "\n  displayColor " + colorValue + ";\n" +
        updatedState.slice(braceIndex + 1);
    }
  }

  Page.codeMirrorEditor6.dispatch({
    changes: { from: startIndex, to: endIndex, insert: updatedState }
  });

  setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
};

//Deletes a target state within the specific SM and Class, as well any transitions to/from target state
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.deleteState = function(stateCode,className,smName,stateName){
  // Debug
  // console.log("Inside Action.deleteState ...")
  let subStates=stateName.split(",");

  if (clientDebuggerFlag){
    console.log("Getting code from codemirror editor ...");
  }

  let orig=Page.codeMirrorEditor6.state.doc.toString();

  if (clientDebuggerFlag){
    console.log("Deleting State: ", stateName);
  }

  let unsanitizedState = stateCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  orig=orig.replace(unsanitizedState,"");
  //delete any transitions leading to target state - this handles the case where there are NOT multiple states with the same name
 let regex=new RegExp("[^{};]*->\\s*([^\\S\\s]*|\\s*)(\\/\\s*{[^}]*})*([^\\S\\s]*|\\s*)("+subStates[subStates.length-1]+")(\\s+\\w+)*\\s*;");
  let res;
  while((res=orig.match(regex))!=null){ 
    orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
  }

  if (clientDebuggerFlag){
    console.log("Setting updated code to codemirror editor ...");
  }

  Page.setCodeMirror6Text(orig);

  setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

  TabControl.getCurrentHistory().save(orig, "menuUpdate");
  Action.removeContextMenu();
}
//Action.drawStateMenu() is triggered by contextmenu event on Graphviz State Diagram "node" elements
//Draws a div containing the editing options for state GV diagrams, as well as calling the related function when clicked
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.drawStateMenu = function(event){
  // Debug
  // console.log("Inside drawStateMenu: ")
  if(!Action.diagramInSync || Page.readOnly){
    return;
  }
  // Remove old menu, if any
  Action.removeContextMenu();
  var targ=event.target;
  //iterate up to top of graph elements
  while (targ && targ.parentElement && targ.parentElement.id != "graph0" && targ.tagName != "TD") {
    targ = targ.parentNode;
  }
  //grabs state name
  var match = targ.outerHTML.match(/stateClicked\((?:&quot;|"|')([^"']+)(?:&quot;|"|')\)/);
  
  if (!match) {
    return;
  }
  
  var elemText = match[1].split("^*^");
  if (!elemText[2]) {
    return;
  }
  elemText[2]=elemText[2].split(".");
  var orig = Page.codeMirrorEditor6.state.doc.toString();
  var chosenStateIndices=Action.selectStateInClassCM6(elemText[0],elemText[1],elemText[2][0]);
  for(let i=1;i<elemText[2].length;i++){
    chosenStateIndices=Action.selectStateInStateCM6(chosenStateIndices.startIndex,chosenStateIndices.endIndex,elemText[2][i]);
  }
  var chosenState=orig.substr(chosenStateIndices.startIndex,chosenStateIndices.endIndex-chosenStateIndices.startIndex);
  if(typeof chosenState != 'string'){
    return;
  }
  //this section generates the context menu, grabbing option names and associated functions from the vars below 
  var menu = document.createElement('customContextMenu');
  var rowContent = ["Rename State","Delete State","Add Substate","Add Transition","Change Color"];
  //need to sanitize any linebreaks or quotes that could break the generated HTML
  var jsInput=chosenState.replaceAll("\n","&#10").replaceAll("\"","&#$quot");
  var rowFuncs = [
    "Action.drawInputState(\"rename\",\""+jsInput+"\",\""+elemText[2][elemText[2].length-1]+"\")",
    "Action.deleteState(\""+jsInput+"\",\""+elemText[0]+"\",\""+elemText[1]+"\",\""+elemText[2]+"\")",
    "Action.drawInputState(\"substate\",\""+jsInput+"\",\""+elemText[2][elemText[2].length-1]+"\")",
    "Action.drawInputState(\"transition\",\""+jsInput+"\",\""+elemText[2][elemText[2].length-1]+"\")",
    "Action.drawInputState(\"colorState\",\""+jsInput+"\",\""+elemText[2][elemText[2].length-1]+"\")"
  ]; 
  menu.style.zIndex = "1000";
  menu.style.border = "1px solid #ccc";
  menu.style.backgroundColor = "#f8f8f8";
  menu.style.padding = "5px";
  menu.style.position = "fixed";
  //add rows
  for (var i = 0; i < rowContent.length; i++) {
    var row = document.createElement("div");
    row.style.padding = "5px";
    row.style.borderRadius = "3px";
    row.style.cursor = "pointer";
    row.style.transition = "background-color 0.3s";
    row.textContent = rowContent[i];
    row.setAttribute('onclick',"javascript:"+rowFuncs[i]);
    //Highlight row on hover
    row.addEventListener("mouseover", function() {
      this.style.backgroundColor = "#ddd";
    });
    row.addEventListener("mouseout", function() {
      this.style.backgroundColor = "transparent";
    });
    //add row to context menu
    menu.appendChild(row);
  }
  //set menu location at mouse, while ensuring it is on screen
  var menuRect=menu.getBoundingClientRect();
  if(event.clientX+menuRect.width>window.innerWidth){
    menu.style.right=(window.innerWidth-event.clientX)+"px";
  } else {
    menu.style.left = event.clientX+"px";
  }
  if(event.clientY+menuRect.height>window.innerHeight){
    menu.style.bottom=(window.innerHieght-event.clientY)+"px";
  } else {
    menu.style.top = event.clientY+"px";
  }

  //Add an event listener to hide the menu when the user clicks outside of it
  document.addEventListener('mousedown', function hideMenu(e) {
    var prompt=document.getElementById("promptBox");
    if (e.target != menu && !menu.contains(e.target)) {
      if(prompt!=null&&e.target != prompt && !prompt.contains(e.target)){
        document.removeEventListener('mousedown', hideMenu);
        Action.removeContextMenu();
      } else {
        document.removeEventListener('mousedown', hideMenu);
        Action.removeContextMenu();
      }
    }
  });
  document.body.appendChild(menu);
}
