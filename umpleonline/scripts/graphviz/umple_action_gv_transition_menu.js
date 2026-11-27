// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Context menu actions for transitions in Graphviz state diagrams

Action.displayTransitionMenu = function(event) {
  if (!Action.diagramInSync || Page.readOnly) {
      return;
  }
  // Remove old menu, if any
  Action.removeContextMenu();
  var targ = event.target;
  //iterate up to top of graph elements
  while (targ.parentElement.id != "graph0" && targ.tagName != "SPAN") {
      targ = targ.parentNode;
  }
  //grabs state name
  var elemText = targ.outerHTML.substr(targ.outerHTML.indexOf("transitionClicked(&quot;") + "transitionClicked(&quot;".length, targ.outerHTML.indexOf("&quot;)\"") - (targ.outerHTML.indexOf("transitionClicked(&quot;") + "transitionClicked(&quot;".length));
  elemText = elemText.replaceAll("&amp;", "&");
  let id = elemText.split("*^*");
  let identifierState = id[3].split(".");
  dest = id[4].split(".");

  var selection = Action.selectStateInClassCM6(id[0], id[1], identifierState[0]);

  for (var i = 1; i < identifierState.length; i++) {
      selection = Action.selectStateInStateCM6(selection.startIndex, selection.endIndex, identifierState[i]);
  }

  let searchTerm = id[2].replaceAll("+", "\\+").replaceAll("-", "\\-").replaceAll("*", "\\*").replaceAll("?", "\\?").replaceAll("|", "\\|"); //preceed any accidental quantifiers with escape character
  searchTerm = searchTerm.replace("after", "after~`~?:Every`~`?"); //subpar solution, could be improved
  if (!id[2].startsWith("after(")) searchTerm = searchTerm.replace(/\(.*\)$/, "~`~?:$&`~`?"); //the code may omit the parameters of the event
  if (id[5] != "") {
      let guardStr = id[5].trim().replaceAll("+", "\\+").replaceAll("-", "\\-").replaceAll("*", "\\*").replaceAll("?", "\\?").replaceAll("|", "\\|"); //preceed any accidental quantifiers with escape character
      searchTerm = searchTerm + "\\s*[\\s*" + guardStr.trim().slice(1, guardStr.trim().length - 1) + "\\s*]";
  }

  searchTerm = searchTerm.replaceAll("]", "\\]").replaceAll("[", "\\[").replaceAll(")", "\\)?").replaceAll("(", "\\(?").replaceAll("~`~", "(").replaceAll("`~`", ")").replaceAll(" ", "\\s*").replaceAll(",", "\\s*,\\s*").replaceAll("!", "\\s*!\\s*").replaceAll("/", "\\s*/\\s*");
  searchTerm = searchTerm.replaceAll("&&", "&{1,2}");
  let pattern = new RegExp(searchTerm + ".*->", "s");

     let startIndex = Page.codeMirrorEditor6.state.doc.toString().substr(selection.startIndex, selection.endIndex - selection.startIndex).search(pattern) + selection.startIndex;
  
     let cText = Page.codeMirrorEditor6.state.doc.toString().substr(startIndex);

  let line = Action.findEOL(cText);
  if (!(line.split("->").length - 1 === 1) ) {
      Page.setFeedbackMessage(" Please edit this complex transition in the textual code.");
      return;
  }
  let endIndex = startIndex + line.length;
   let code = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);
  let pattern2 = new RegExp("^(.*?)(\\s*\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*(\\w+);?$", "s");

  const match = code.trim().match(pattern2);
  // Extracting captured groups based on the updated pattern
  let eventName = match[1].trim();
  let guard = match[3] ? match[3].trim() : (match[7] ? match[7].trim() : null);
  let action = match[5] ? match[5].trim() : (match[9] ? match[9].trim() : null);
  let destinationState = match[10].trim();
  if (guard === null) {
      guard = "";
  }
  //
  if (action === null) {
      action = "";
  }
  //

  //need to sanitize any linebreaks or quotes that could break the generated HTML
  //var jsInput=chosenState.replaceAll("\n","&#10").replaceAll("\"","&#$quot");
  var menu = document.createElement('customContextMenu');
  var rowContent = ["Change or Add Event Name", "Change or Add Guard", "Change or Add Action", "Change Destination State", "Delete Transition"];
  var rowFuncs = [
      "Action.modifyTransitionEventName(\"" + startIndex + "\",\"" + endIndex + "\")",
      "Action.modifyTransitionGuard(\"" + startIndex + "\",\"" + endIndex + "\")",
      "Action.modifyTransitionAction(\"" + startIndex + "\",\"" + endIndex + "\")",
      "Action.changeTransition(\"" + destinationState + "\",\"" + startIndex + "\",\"" + endIndex + "\")",
      "Action.deleteTransition(\"" + startIndex + "\",\"" + endIndex + "\")"

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
      row.setAttribute('onclick', "javascript:" + rowFuncs[i]);
      // Highlight row on hover
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
  var menuRect = menu.getBoundingClientRect();
  if (event.clientX + menuRect.width > window.innerWidth) {
      menu.style.right = (window.innerWidth - event.clientX) + "px";
  } else {
      menu.style.left = event.clientX + "px";
  }
  if (event.clientY + menuRect.height > window.innerHeight) {
      menu.style.bottom = (window.innerHieght - event.clientY) + "px";
  } else {
      menu.style.top = event.clientY + "px";
  }
  // Add a listener to hide the menu when the user clicks outside of it
  document.addEventListener('mousedown', function hideMenu(e) {
      var prompt = document.getElementById("promptBox");
      if (e.target != menu && !menu.contains(e.target)) {
          if (prompt != null && e.target != prompt && !prompt.contains(e.target)) {

              document.removeEventListener('mousedown', hideMenu);
              Action.removeContextMenu();

          } else {
              document.removeEventListener('mousedown', hideMenu);
              Action.removeContextMenu();
          }
      }
  });
  document.addEventListener('keydown', function hideMenu(e) {
    var prompt = document.getElementById("promptBox");
      if (e.target != menu && !menu.contains(e.target)&&e.key === "Escape") {
          if (prompt != null && e.target != prompt && !prompt.contains(e.target)) {

              document.removeEventListener('keydown', hideMenu);
              Action.removeContextMenu();

          } else {
              document.removeEventListener('keydown', hideMenu);
              Action.removeContextMenu();
          }
      }
  });
  document.body.appendChild(menu);
}

Action.changeTransition = function(dest,startIndex,endIndex) {
   // let classCode = Page.codeMirrorEditor.getValue().substring(startIndex, endIndex);
   let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);

   // Assuming classCode contains the full transition line, including condition and destination
   let trimmedString = classCode.trim().replace(/;$/, "");

   // Split the string into condition (with guard) and destination parts
   let parts = trimmedString.split("->");
   parts[0] = parts[0].trim(); // Condition part
   parts[1] = parts[1].trim(); // Destination part

   // Ensure there are two parts (condition and destination)
   if (parts.length != 2) {
       console.log("Invalid transition format.");
       return;
   }
  var prompt = document.createElement('div');
    prompt.style.zIndex = "1000";
    prompt.style.border = "1px solid #ccc";
    prompt.style.backgroundColor = "#f8f8f8";
    prompt.style.padding = "5px";
    prompt.style.position = "absolute";
    prompt.style.left = '50%';
    prompt.style.top = '50%';
    prompt.style.transform = 'translate(-50%, -50%)';
    prompt.id = "promptBox";

    var input = document.createElement('input');
    input.type = 'text';
    input.value=parts[1];
    input.style.padding = '5px';
    input.style.margin = '5px';
    input.style.width = '200px';

    var submitButton = document.createElement('button');
    submitButton.textContent = 'Change Destination';
    submitButton.style.padding = '5px';
    submitButton.style.marginLeft = '5px';

    // Append elements to the prompt
    prompt.appendChild(input);
    prompt.appendChild(submitButton);

    // Add the prompt to the document body
    document.body.appendChild(prompt);
    input.focus(); // Automatically focus the input
    var hider=function hidePrompt(e) {
      if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
        document.removeEventListener("mousedown", hidePrompt);
        prompt.remove();
      }
    };
    // Add a listener to hide the prompt when the user clicks outside of it
    document.addEventListener("mousedown", hider);
    document.addEventListener("keydown", function(e) {
      if (e.key === "Escape") {
        prompt.remove();
        document.removeEventListener("keydown", arguments.callee);
      }
    });
    // Event listener for the submit action
    submitButton.addEventListener('click', function() {
        // Validate input value is not empty
        if (input.value.trim() === "") {
            console.log("Input for new destination state is empty.");
            return;
        }


        // Create the modified transition string with the new destination
        let modifiedTransition = parts[0] + " -> " + parts[1].replace(dest,input.value.trim()) + ";";
        
        let orig = Page.codeMirrorEditor6.state.doc.toString();
        let before = orig.substring(0, startIndex);
    
        // Get the part of the string after the substring you want to replace
        let after = orig.substring(endIndex);
        let updatedContent = before + modifiedTransition +after;
        //let updatedContent = orig.replace(classCode.trim(), modifiedTransition);

        // Update the editor with the new content
        Page.setCodeMirror6Text(updatedContent);


        Action.removeContextMenu();
        TabControl.getCurrentHistory().save(Page.getUmpleCode(), "changeTransitionDestination");
        document.removeEventListener("mousedown",hider);
        prompt.remove(); // Remove the prompt after processing
        Action.selectMatchingText(modifiedTransition);
    });
    input.addEventListener("keydown", function(e) {
      if (e.key === "Enter") {
        e.preventDefault(); // Prevent the default form submission behavior
        e.stopPropagation();
        submitButton.click();
      }
    });
};


Action.deleteTransition = function(startIndex, endIndex) {
  let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);

  let orig = Page.codeMirrorEditor6.state.doc.toString();

  orig = orig.replace(classCode, "");

  // Update the editor with the new code
  Page.setCodeMirror6Text(orig);

  Action.removeContextMenu();
  TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
};

Action.modifyTransitionGuard = function(startIndex,endIndex) {

  let pattern2 = new RegExp("^(.*?)(\\s*\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*(\\w+);?$", "s");
  let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);
  
  const match =classCode.trim().match(pattern2);

  // Extracting captured groups based on the updated pattern
  let eventName = match[1].trim();
  let guard = match[3] ? match[3].trim() : (match[7] ? match[7].trim() : null);
  let action = match[5] ? match[5].trim() : (match[9] ? match[9].trim() : null);
  let destinationState = match[10].trim();
     if(guard===null){
       guard="";
     }
     //
     if(action===null){
       action="";
     }
  // Create the input prompt for renaming the transition condition
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "absolute";
  prompt.style.left = '50%';
  prompt.style.top = '50%';
  prompt.style.transform = 'translate(-50%, -50%)';
  prompt.id = "promptBox";

  var input = document.createElement('input');
  input.type = 'text';
  input.value = guard;
  input.style.padding = '5px';
  input.style.margin = '5px';
  input.style.width = '200px';

  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change/Add Guard';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  // Append elements to the prompt
  prompt.appendChild(input);
  prompt.appendChild(submitButton);

  // Add the prompt to the document body
  document.body.appendChild(prompt);
  input.focus(); // Automatically focus the input
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });
  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
    // Validate input value is not empty

    let trimmedString = classCode.trim();

    // Split the string into condition (with guard) and destination parts
    let parts = trimmedString.split("->");
    parts[0] = parts[0].trim(); 
    parts[1] = parts[1].trim(); // Destination part

    // Ensure there are two parts (condition and destination)
    if (parts.length != 2) {
        console.log("Invalid transition format.");
        return;
    }
    let modifiedTransition = "";
    if (input.value.trim() === "") {
      if (guard === null || guard === "") {
        return;
     }
     else{
       pattern=new RegExp("\\[\\s*(.*?)\\s*\\]", "g");
       modifiedTransition = classCode.replace(pattern,"");
     }
    }
    else{
      if (guard === null || guard === "") {
        if(action==null || action === ""){
          parts[0]=eventName+" ["+input.value.trim()+"]";

        }
        else{
          if(parts[1].includes(action)){
            parts[0]=eventName+" ["+input.value.trim()+"]";
          }
          else{
            parts[0]=eventName+" ["+input.value.trim()+"]"+" /{" +action+"}"
          }

        }
        modifiedTransition = parts[0]+ " -> " + parts[1];

      }
      else{
        modifiedTransition = classCode.replace(guard,input.value.trim());
      }
    }


    // Assuming classyCode is meant to represent the original content where the transition is to be found
    let orig = Page.codeMirrorEditor6.state.doc.toString();
    let before = orig.substring(0, startIndex);
    
    // Get the part of the string after the substring you want to replace
    let after = orig.substring(endIndex);
    let updatedContent = before + modifiedTransition +after;

    // Update the editor with the new content
    Page.setCodeMirror6Text(updatedContent);

    Action.removeContextMenu();
    TabControl.getCurrentHistory().save(Page.getUmpleCode(), "modifyGuard");
    document.removeEventListener("mousedown",hider);
    prompt.remove(); // Remove the prompt after processing
    Action.selectMatchingText(modifiedTransition);
});
input.addEventListener("keydown", function(e) {
  if (e.key === "Enter") {
    e.preventDefault(); // Prevent the default form submission behavior
    e.stopPropagation();
    submitButton.click();
  }
});
};



Action.modifyTransitionAction = function(startIndex,endIndex) {
  let pattern2 = new RegExp("^(.*?)(\\s*\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\[(.*?)\\])?(\\s*\\/\\s*\\{(.*?)\\})?\\s*(\\w+);?$", "s");
  let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);

  const match =classCode.trim().match(pattern2);
  // Extracting captured groups based on the updated pattern

  let guard = match[3] ? match[3].trim() : (match[7] ? match[7].trim() : null);
  let currentAction = match[5] ? match[5].trim() : (match[9] ? match[9].trim() : null);

     if(guard===null){
       guard="";
     }
     //
  if(currentAction===null){
    currentAction="";
  }
  // Create the input prompt for  the transition condition
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
    prompt.style.border = "1px solid #ccc";
    prompt.style.backgroundColor = "#f8f8f8";
    prompt.style.padding = "5px";
    prompt.style.position = "absolute";
    prompt.style.left = '50%';
    prompt.style.top = '50%';
    prompt.style.transform = 'translate(-50%, -50%)';
    prompt.id = "promptBox";

  var textarea = document.createElement('textarea');
  textarea.style.width = '300px';
    textarea.style.height = '100px';
    textarea.value = currentAction || ""; // Pre-fill the textarea with the current action if any
    // Styling for the textarea omitted for brevity...

  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change/Add Action';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  // Append elements to the prompt
  prompt.appendChild(textarea);
  prompt.appendChild(submitButton);

  // Add the prompt to the document body
  document.body.appendChild(prompt);
  textarea.focus(); // Automatically focus the input
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });
  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
      // Validate input value is not empty

      let trimmedString = classCode.trim();

      // Split the string into condition (with guard) and destination parts
      let parts = trimmedString.split("->");
      parts[0] = parts[0].trim(); 
      parts[1] = parts[1].trim(); // Destination part

      // Ensure there are two parts (condition and destination)
      if (parts.length != 2) {
          console.log("Invalid transition format.");
          return;
      }
      let modifiedTransition = "";
      if (textarea.value.trim() === "") {
        if (currentAction === null || currentAction === "") {
          return;
       }
       else{
         pattern=new RegExp("/\\s*\\{.*?\\}\\s*->", "g");
         modifiedTransition = classCode.replace(pattern," ->");
       }
      }
      else{
        if (currentAction === null || currentAction === "") {
          modifiedTransition = parts[0]+"/{"+textarea.value.trim()+"}"+ " -> " + parts[1];


        }
        else{
          modifiedTransition = classCode.replace(currentAction,textarea.value.trim());
        }
      }


      // Assuming classyCode is meant to represent the original content where the transition is to be found
      let orig = Page.codeMirrorEditor6.state.doc.toString();
      let before = orig.substring(0, startIndex);
    
      // Get the part of the string after the substring you want to replace
      let after = orig.substring(endIndex);
      let updatedContent = before + modifiedTransition +after;

      // Update the editor with the new content
         Page.setCodeMirror6Text(updatedContent);

      Action.removeContextMenu();
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "modifyAction");
      document.removeEventListener("mousedown",hider);
      prompt.remove(); // Remove the prompt after processing
      Action.selectMatchingText(modifiedTransition);
  });
  input.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
      e.preventDefault(); // Prevent the default form submission behavior
      e.stopPropagation();
      submitButton.click();
    }
  });
};





Action.modifyTransitionEventName = function(startIndex, endIndex) {
  let classCode = Page.codeMirrorEditor6.state.doc.toString().substring(startIndex, endIndex);
  let pattern2 = new RegExp("^(.*?)\\s*(\\[(.*?)\\])?\\s*(\\/\\s*\\{(.*?)\\})?\\s*->\\s*(\\w+);?$", "s");

  const match = classCode.match(pattern2);


  let eventName = match[1].trim();
  let guard = match[3] ? match[3].trim() : null;
  let action = match[5] ? match[5].trim() : null;
  let destinationState = match[6].trim();
  // Create the input prompt for renaming the transition condition
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "absolute";
  prompt.style.left = '50%';
  prompt.style.top = '50%';
  prompt.style.transform = 'translate(-50%, -50%)';
  prompt.id = "promptBox";

  var input = document.createElement('input');
  input.type = 'text';
  input.value = eventName;
  input.style.padding = '5px';
  input.style.margin = '5px';
  input.style.width = '200px';

  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change/Add Event Name';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  // Append elements to the prompt
  prompt.appendChild(input);
  prompt.appendChild(submitButton);

  // Add the prompt to the document body
  document.body.appendChild(prompt);
  input.focus(); // Automatically focus the input
  var hider = function hidePrompt(e) {
      if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
          document.removeEventListener("mousedown", hidePrompt);
          prompt.remove();
      }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);
  document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });
  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
      // Validate input value is not empty
      if (input.value.trim() === "") {
          console.log("Input for new transition condition is empty.");
          return;
      }

      // Create the modified transition string
      let modifiedTransition = classCode.replace(eventName, input.value.trim());

      // Assuming classyCode is meant to represent the original content where the transition is to be found
      let orig = Page.codeMirrorEditor6.state.doc.toString();
      let before = orig.substring(0, startIndex);
    
      // Get the part of the string after the substring you want to replace
      let after = orig.substring(endIndex);
      let updatedContent = before + modifiedTransition +after;

      // Update the editor with the new content
      Page.setCodeMirror6Text(updatedContent);

      Action.removeContextMenu();
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "renameTransition");
      document.removeEventListener("mousedown", hider);
      prompt.remove(); // Remove the prompt after processing
      Action.selectMatchingText(modifiedTransition);
  });
  input.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
      e.preventDefault(); // Prevent the default form submission behavior
      e.stopPropagation();
      submitButton.click();
    }
  });
};
