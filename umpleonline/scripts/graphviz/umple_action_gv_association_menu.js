// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Context menu actions for associations in Graphviz class diagrams

Action.displayAssociMenu = function(event, associationLink) {
  if (Page.readOnly) return;
  const regex = /Action\.selectAssociation\('([^']+)'\)/;

  // Use the regex to extract the content
  const associationDetails = associationLink.match(regex);


  // associationDetails array contains the extracted information
  let indices = Action.selectAssociation(associationDetails[1]);

  var detailsArray = associationDetails[1].split(',');

  if (detailsArray.length == 4) {
      var destination = detailsArray[1].trim();
      var className = detailsArray[0].trim();
      var endInfo = detailsArray[2].split(' ');
      var startInfo = detailsArray[3].split(' ');

  } else {
      var destination = detailsArray[1].trim();
      var endInfo = detailsArray[2].split(' ');
      var startInfo = detailsArray[2].split(' ');
      var className = detailsArray[0].trim();
  }
  
  var searchCursor = new RegExp("(associationClass|class|interface|trait) " + className + "($|\\\s|[{])");
  var nextCursor = new RegExp("(class|interface|trait) [A-Za-z]");
  if (Page.codeMirrorOn) {
      //get the class code for where the association belong
      var selectionIndiciesCM6 = Action.selectItemCM6(searchCursor);
      var classCode = Page.codeMirrorEditor6.state.sliceDoc(selectionIndiciesCM6.startIndex,selectionIndiciesCM6.endIndex) ;
      //get the class code f
      
      if (clientDebuggerFlag){
        console.warn("classCode: " + classCode);
      }

  }


  var jsInput = classCode.replaceAll("\n", "&#10").replaceAll("\"", "&#$quot");;
  let isEnd = 1; //0 as start 1 as end
  let startIndex = indices.startIndex;
  let endIndex = indices.endIndex;
  var selectedText = Page.codeMirrorEditor6.state.sliceDoc(startIndex,endIndex) ;

  if (clientDebuggerFlag){
    console.warn("selectedText: " + selectedText);  
  }


  if (selectedText.includes(endInfo[0].trim()) == false) {
      isEnd = 3;//association class
  }
  var menu = document.createElement('customContextMenu');
  //special menu for association class
  var rowContent = isEnd === 3 ?
  ["Alter " + className + " multiplicity", "Alter " + className + " role name", "Alter "+destination+" role name"] :
  ["Alter " + className + " multiplicity", "Alter " + className + " role name", "Alter "+destination+" multiplicity" , "Alter "+destination+" role name", "Delete the association"];
  //var rowContent = ["Alter " + className + " multiplicity", "Alter " + className + " role name", "Alter "+destination+" multiplicity" , "Alter "+destination+" role name", "Delete the association."];
  var rowFuncs = isEnd === 3 ?
        [
            "Action.modifyMultiplicity(\"" + jsInput + "\",\"" + selectedText + "\",\"" + startInfo[0] + "\",\"" + 0 + "\")",
            "Action.modifyRoleName(\"" + jsInput + "\",\"" + selectedText + "\",\"" + startInfo[1] + "\",\"" + startInfo[0] + "\",\"" + 0 + "\")",
            "Action.modifyRoleName(\"" + jsInput + "\",\"" + selectedText + "\",\"" + endInfo[1] + "\",\"" + startInfo[0] + "\",\"" + 1 + "\")"
        ] :[

        
      "Action.modifyMultiplicity(\"" + jsInput + "\",\"" + selectedText + "\",\"" + startInfo[0] + "\",\"" + 0 + "\")",
      "Action.modifyRoleName(\"" + jsInput + "\",\"" + selectedText + "\",\"" + startInfo[1] + "\",\"" + startInfo[0] + "\",\"" + 0 + "\")",
      "Action.modifyMultiplicity(\"" + jsInput + "\",\"" + selectedText + "\",\"" + endInfo[0] + "\",\"" + isEnd + "\")",
      "Action.modifyRoleName(\"" + jsInput + "\",\"" + selectedText + "\",\"" + endInfo[1] + "\",\"" + startInfo[0] + "\",\"" + 1 + "\")",
      "Action.deleteAssociation(\"" + jsInput + "\",\"" + selectedText + "\")"

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
  document.body.appendChild(menu);
};




Action.validateMultiplicity = function(multiplicity) {
  // Check if not empty
  if (!multiplicity) return false;

  // Validate '*' or a single positive integer including '0'
  if (multiplicity === "*" || multiplicity.match(/^\d+$/)) return true;

  // Validate range formats including "n..m", "0..*", "1..*", "n..*", "0..m", "1..m"
  if (multiplicity.match(/^(\d+|\*)\.\.(\d+|\*)$/)) {
    const parts = multiplicity.split('..');
    const lowerBound = parts[0];
    const upperBound = parts[1];

    // Handle '*' in either part of the range
    if (lowerBound === '*' || upperBound === '*') {
      // Validate "0..*" or "n..*" where n > 0
      if (lowerBound === '0' || lowerBound.match(/^\d+$/) && lowerBound !== '0') return true;
    } else {
      // Validate "n..m" where n <= m
      const n = parseInt(lowerBound, 10);
      const m = parseInt(upperBound, 10);

      if (n <= m) return true;
    }
  }

  // If none of the above conditions met, return false
  return false;
};

Action.modifyMultiplicity = function(classCode,selectedText, mult, isStart){
  let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  if(isStart==1){
    var isEnd=true;
    
  }
  else if(isStart==3){
    //alert("unable to change end multiplicity for associationClass");
    Page.setFeedbackMessage(" unable to change end multiplicity for associationClass ");
    return;
  }
  else{
    var isEnd=false;
    ;
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
  input.value = mult; // Pre-fill with the current attribute name
  input.style.padding = '5px';
  input.style.margin = '5px';
  input.style.width = '200px';
 
  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  var inputErrorMsg = document.createElement('label');
  inputErrorMsg.type='label';
  inputErrorMsg.style.color = "red";
  inputErrorMsg.textContent = "Please enter a valid multiplicity format (e.g., '*', '1', '0..1', '1..*', '2..5').";
 
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

   // Add ESC key listener to close the prompt
   document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      prompt.remove();
      document.removeEventListener("keydown", arguments.callee);
    }
  });

  // Event listener for the submit action
  submitButton.addEventListener('click', function() {
    if(Action.validateMultiplicity(input.value.trim())){
    var escapedOldMult = mult.trim().replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
    
    let updatedAssociationString;
    
    if (isEnd) {
        // If it's the end multiplicity and there are two occurrences, replace the second one
        const parts = selectedText.split(new RegExp(escapedOldMult));
        if (parts.length === 3) { // Assuming exactly two occurrences
            updatedAssociationString = parts[0] + mult.trim() + parts[1] + input.value.trim() + parts[2];
        } else if (parts.length === 2) { // Assuming only one occurrence (end multiplicity)
            updatedAssociationString = parts[0] + input.value.trim() + parts[1];
        }
    } else {
        // If it's the start multiplicity, simply replace the first occurrence
        updatedAssociationString = selectedText.replace(new RegExp(escapedOldMult), input.value.trim());
    }

    let orig=Page.codeMirrorEditor6.state.doc.toString();;
    if((classyCode.includes(selectedText))==false){
      orig=orig.replace(selectedText,updatedAssociationString);
    }
    else{
    let modifiedClassCode = classyCode;
    modifiedClassCode = modifiedClassCode.replace(selectedText,updatedAssociationString);
     orig=orig.replace(classyCode,modifiedClassCode);
    }
    
    Page.setCodeMirror6Text(orig);

    // Apply updatedAssociationString to the Umple code as needed
    
     Action.removeContextMenu();
     TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
     
     prompt.remove(); // Remove the prompt after processing
     Action.selectMatchingText(updatedAssociationString);
  }
  else {
    // If the format is invalid, display a message
    input.focus(); // Re-focus on the input to allow the user to correct it
    prompt.appendChild(inputErrorMsg);
      }
  });

  // Add Enter key listener to trigger the change
  input.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
      e.preventDefault(); // Prevent the default form submission behavior
      e.stopPropagation();
      submitButton.click();
    }
  });
 };


Action.modifyRoleName = function(classCode,selectedText, roleName,mult,isStart){
  let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  if(isStart==1){
    var isEnd=true;
    
  }
  else{
    var isEnd=false;
    ;
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
  input.value = roleName; // Pre-fill with the current attribute name
  input.style.padding = '5px';
  input.style.margin = '5px';
  input.style.width = '200px';
 
  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change';
  submitButton.style.padding = '5px';
  submitButton.style.marginLeft = '5px';

  var inputErrorMsg = document.createElement('label');
  inputErrorMsg.type='label';
  inputErrorMsg.style.color = "red";
  inputErrorMsg.textContent = "To add a role name at this end there must be a role name at the other end first";
 
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
    var newRoleName = input.value.trim();
    if(roleName==""){
      var connectionPattern = /(\s*<-\s*|\s*><\s*|\s*--\s*|\s*->\s*|\s*<@>-\s*|\s*-\s*<@>\s*)/;
    var parts = selectedText.split(connectionPattern);
    var startPart = parts[0].trim(); // "1 parent"
    var updatedStartPart, updatedEndPart;
    var updatedAssociationString;
    if(parts.length>2){
      var endPart = parts[2].trim(); // "* FunctionalArea child;"
      if (isEnd) {
        if((endPart.includes("sorted"))){
          var endParts2 = endPart.split("sorted");
          var endParts = endPart.split(";");
          updatedEndPart = endParts2[0].trim()+" "+newRoleName+""+"sorted"+endParts2[1];
        }
        else{
        var endParts = endPart.split(";");
          updatedEndPart = endParts[0].trim()+" "+newRoleName+";";
        }
      } else {
        if((classyCode.includes(selectedText))==false){
          updatedStartPart = startPart.trim()+" "+newRoleName;
        }
        else{
          updatedStartPart = mult.trim()+" "+newRoleName;
        }
        if((startPart.includes("sorted"))){
          var startParts = startPart.split("sorted");

          updatedStartPart = mult.trim()+" "+newRoleName+""+"sorted"+startParts[1];
        }
      }
      updatedAssociationString = isEnd ? (startPart + parts[1] + updatedEndPart) : (updatedStartPart + parts[1] + endPart);
    }
    else{
      let parts2 = selectedText.split(";");
      parts=parts2[0].split(" ");
      if (isEnd==false) {
        updatedStartPart = mult.trim()+" "+newRoleName;
        if(parts.length>2){
          updatedAssociationString = updatedStartPart+" "+parts[1].trim()+" "+parts[2].trim()+";";
        }
        else{
          input.focus();
          prompt.appendChild(inputErrorMsg);
          return;
        }
      } else {
        endParts = selectedText.split(";");
        updatedAssociationString = endParts[0].trim()+" "+newRoleName+";";
      }
    }
    }
    else{
      updatedAssociationString = selectedText.replace(roleName, newRoleName);
    }
    
    let orig=Page.codeMirrorEditor6.state.doc.toString();

    if((classyCode.includes(selectedText))==false){
      orig=orig.replace(selectedText,updatedAssociationString);
    }
    else{
    let modifiedClassCode = classyCode;
    modifiedClassCode = modifiedClassCode.replace(selectedText,updatedAssociationString);
     orig=orig.replace(classyCode,modifiedClassCode);
    }
    
    Page.setCodeMirror6Text(orig);

    // Apply updatedAssociationString to the Umple code as needed
    Action.removeContextMenu();
    TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
    prompt.remove(); // Remove the prompt after processing
    Action.selectMatchingText(updatedAssociationString);
  });
  input.addEventListener("keydown", function(e) {
    if (e.key === "Enter") {
      e.preventDefault(); // Prevent the default form submission behavior
      e.stopPropagation();
      submitButton.click();
    }
  });
 };

   
 Action.deleteAssociation = function(classCode, selectedText) {
  let orig = Page.codeMirrorEditor6.state.doc.toString();

  let classyCode = classCode.replaceAll("&#10", "\n").replaceAll("&#$quot", "\"");
  if ((classyCode.includes(selectedText)) == false) {
      orig = orig.replace(selectedText, "");
  } else {
      let modifiedClassCode = classyCode;
      modifiedClassCode = modifiedClassCode.replace(selectedText, "");

      orig = orig.replace(classyCode, modifiedClassCode);
  }

  Page.setCodeMirror6Text(orig);
  Action.removeContextMenu();
  TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
}
