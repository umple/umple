// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Context menu actions for attributes in Graphviz class diagrams

Action.displayAttributeMenu = function(event, attributeName, attributeType, className) {
  if(!Action.diagramInSync || Page.readOnly){
    return;
  }
  // Remove old menu, if any
  Action.removeContextMenu();
  attributeName = attributeName.trim();
  // ERD supplies the owner explicitly; class diagrams use the enclosing SVG node.
  var elemText = className || Action.getGvClassName(event);
  var chosenClass = Action.getGvClassCode(elemText);
  if(typeof chosenClass != 'string'){
    return;
  }
  
  // Create context menu for attribute
  var menu = document.createElement('customContextMenu');
  var menuHeader = document.createElement('div');
  menuHeader.textContent = "Attribute: " + attributeName + " Type: " + attributeType;
  menuHeader.style.padding = "5px";
  menuHeader.style.borderBottom = "1px solid #ccc";
  menuHeader.style.fontWeight = "bold";
  menu.appendChild(menuHeader);
  var rowContent = ["Rename Attribute", "Change Type", "Delete Attribute"];
  var jsInput=chosenClass.replaceAll("\n","&#10").replaceAll("\"","&#$quot");;
  var rowFuncs = [
    "Action.renameAttribute(\""+jsInput+"\",\""+elemText+"\",\""+attributeName+"\",\""+attributeType+"\")",
    "Action.changeAttributeType(\""+jsInput+"\",\""+elemText+"\",\""+attributeName+"\",\""+attributeType+"\")",
    "Action.deleteAttribute(\""+jsInput+"\",\""+elemText+"\",\""+attributeName+"\",\""+attributeType+"\")"
  ];


  // Set common styles for the menu
  menu.style.zIndex = "1000";
  menu.style.border = "1px solid #ccc";
  menu.style.backgroundColor = "#f8f8f8";
  menu.style.padding = "5px";
  menu.style.position = "fixed";
  
  // Add rows for each action in the context menu
  for (var i = 0; i < rowContent.length; i++) {
    var row = document.createElement("div");
    row.style.padding = "5px";
    row.style.borderRadius = "3px";
    row.style.cursor = "pointer";
    row.style.transition = "background-color 0.3s";
    row.textContent = rowContent[i];
    row.setAttribute('onclick', "javascript:" + rowFuncs[i]);
    
    // Event listeners for visual feedback on hover
    row.addEventListener("mouseover", function() {
      this.style.backgroundColor = "#ddd";
    });
    row.addEventListener("mouseout", function() {
      this.style.backgroundColor = "transparent";
    });
    
    menu.appendChild(row); // Add row to context menu
  }

  // Position the menu at the mouse location while ensuring it is on screen
  var menuRect = menu.getBoundingClientRect();
  if (event.clientX + menuRect.width > window.innerWidth) {
    menu.style.right = (window.innerWidth - event.clientX) + "px";
  } else {
    menu.style.left = event.clientX + "px";
  }
  if (event.clientY + menuRect.height > window.innerHeight) {
    menu.style.bottom = (window.innerHeight - event.clientY) + "px";
  } else {
    menu.style.top = event.clientY + "px";
  }
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
  // Add an event listener to hide the menu when the user clicks outside of it
  document.addEventListener('mousedown', function hideMenu(e) {
    if (e.target != menu && !menu.contains(e.target)) {
      document.removeEventListener('mousedown', hideMenu);
      Action.removeContextMenu();
    }
  });

  document.body.appendChild(menu); // Add the menu to the page
};

Action.renameAttribute = function(classCode, className, attributeName, attributeType) {
 // Create the input prompt for renaming an attribute
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
 input.value = attributeName; // Pre-fill with the current attribute name
 input.style.padding = '5px';
 input.style.margin = '5px';
 input.style.width = '200px';

 var submitButton = document.createElement('button');
 submitButton.textContent = 'Rename';
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
document.addEventListener("mousedown", hider);
 input.addEventListener('keydown', function(e) {
   if (e.key === 'Enter') {
     e.preventDefault();
     e.stopPropagation();
     submitButton.click();
   }
 });
 // Event listener for the submit action
 submitButton.addEventListener('click', function() {
  if(Action.validateAttributeName(input.value.trim())){
    let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
    let hasType = classyCode.includes(attributeName + " :");
    let attrRegexWithType = new RegExp("\\b" + attributeName + "\\s*:\\s*\\w+\\s*;\\n?", "g");
    let attrRegexWithoutType = new RegExp("\\b" + attributeName + "\\s*;\\n?", "g");
    let newAttributeDeclaration = hasType ?
      attributeType + " " + input.value.trim()+";\n" :
      input.value.trim()+";\n";
    let modifiedClassCode = classyCode;
    modifiedClassCode = modifiedClassCode.replace(attrRegexWithType, newAttributeDeclaration);
    modifiedClassCode = modifiedClassCode.replace(attrRegexWithoutType, newAttributeDeclaration);
    let globalAttrRegex = new RegExp("\\b" + attributeName + "\\b", "g");
    modifiedClassCode = modifiedClassCode.replace(globalAttrRegex, input.value.trim());

    let orig = Page.codeMirrorEditor6.state.doc.toString();

    orig=orig.replace(classyCode,modifiedClassCode);
    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });

    Action.removeContextMenu();
    TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
    document.removeEventListener("mousedown", hider);
    prompt.remove(); // Remove the prompt after processing
    }
 });
};

Action.changeAttributeType = function(classCode, className, attributeName, currentType) {
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

  var select = document.createElement("select");
  // Add options to the select
  ["String", "Integer", "Double", "Float", "Boolean", "Date", "Time"].forEach(function(type) {
    var option = document.createElement("option");
    option.value = type;
    option.text = type;
    if (type === currentType) { // Mark the current type as selected
      option.selected = true;
    }
    select.appendChild(option);
  });

  var submitButton = document.createElement('button');
  submitButton.textContent = 'Change Type';
  submitButton.style.padding = '5px';
  submitButton.style.margin = '5px';
  prompt.appendChild(select);
  prompt.appendChild(submitButton);

  document.body.appendChild(prompt);
  select.focus(); // Automatically focus the select dropdown
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  document.addEventListener("mousedown", hider);
  select.addEventListener('keydown', function(e) {
    if (e.key === 'Enter') {
      e.preventDefault();
      e.stopPropagation();
      submitButton.click();
    }
  });
  // Event listener for the submit button action
    submitButton.addEventListener('click', function() {
      var selectedType = select.options[select.selectedIndex].value;

      if (selectedType !== currentType) { // Proceed only if the type has been changed
        let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
        let modifiedClassCode = classyCode;
        if(currentType !="String"){
          let attrRegexWithType = new RegExp("\\b" + currentType + "\\s" + attributeName,"g");
          modifiedClassCode = modifiedClassCode.replace(attrRegexWithType,  selectedType+" "+attributeName);
        }
        else{
          
          let attrRegexWithType = new RegExp("\\b" + currentType + "\\s" + attributeName, "g");
          let attrRegexWithoutType = new RegExp("\\b" + attributeName  , "g");
          modifiedClassCode = modifiedClassCode.replace(attrRegexWithType,  selectedType+" "+attributeName);
          modifiedClassCode = modifiedClassCode.replace(attrRegexWithoutType,  selectedType+" "+attributeName);
        }
        
        let orig=Page.codeMirrorEditor6.state.doc.toString();
        orig=orig.replace(classyCode,modifiedClassCode);
        // Update the editor with the new code

        Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });

        Action.removeContextMenu();
        TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
        document.removeEventListener("mousedown", hider);
        prompt.remove(); // Remove the prompt after processing

      }
      else{
        document.removeEventListener("mousedown", hider);
        prompt.remove();
      }
      })
    };


Action.deleteAttribute = function(classCode, className, attributeName, attributeType) {
  // Decode HTML entities in the classCode to work with actual line breaks and quotes
  let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  let attrRegexWithType = new RegExp("\\b" + attributeType + "\\s" + attributeName + "\\s*;", "g");
  let attrRegexWithoutType = new RegExp("\\b" + attributeName + "\\s*;\\n?", "g");
  // Use the regex to replace the attribute line with an empty string
  let modifiedClassCode = classyCode;
  modifiedClassCode = modifiedClassCode.replace(attrRegexWithType, "");
  modifiedClassCode = modifiedClassCode.replace(attrRegexWithoutType, "");
  
  let orig = Page.codeMirrorEditor6.state.doc.toString();
  
  orig = orig.replace(classyCode,modifiedClassCode);
  
  // Update the editor with the new code
  Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });

  Action.removeContextMenu();
  TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
};
