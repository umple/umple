// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Context menu and text input actions for classes in Graphviz class diagrams

//Searches the document for any element matching the "customContextMenu" tag, and removes it. 
//Removes context menu on state and class diagrams
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.removeContextMenu = function(){
  var o = document.getElementsByTagName('customContextMenu');
  if (o.length != 0) {
    o.item(0).remove();
  }
}


//Called from Action.drawInput(), searches for existing displayColor definitions in the class code, replaces it if it exists,
//prepends a new displayColor statement to the start of the class if one doesn't exist.
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.setColor=function(classCode,className,color){
  let classyCode=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  if(!classyCode.includes("displayColor")){ //if color is not already set, we can prepend it to the start of the class
    let subtext="{  displayColor "+color+";\n"; 
    subtext=classyCode.substr(0,classyCode.indexOf("{"))+subtext+classyCode.substr(classyCode.indexOf("{")+1,classyCode.length-classyCode.indexOf("{")-1);
    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: Page.codeMirrorEditor6.state.doc.toString().replace(classyCode,subtext) } });

  } else { //otherwise, use regex to replace existing displayColor statement
    let subtext="displayColor "+color+";"; 
    let regex=new RegExp("displayColor\\s+.*;");
    subtext=classyCode.replace(regex,subtext);

    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: Page.codeMirrorEditor6.state.doc.toString().replace(classyCode,subtext) } });

    setTimeout(function(){
        TabControl.getCurrentHistory().save(Page.getUmpleCode(), "setColor");
    }, 100);

  }
}

// Focuses the diagram on a specific class and its immediate neighbors (1 hop).
Action.filterOnOneClass = function(className) {
  var focusValue = className + " 1";
  
  // Set the filter, clearing previous class filters as per Issue #2277
  Action.setFilterFull(focusValue, true); 
  
  // Update the UI filter text field
  jQuery("#filtervalues").val(focusValue);
  
  Action.removeContextMenu();
}

Action.clearFilterOnOneClass=function(className){

  Page.filterWordsOutput=Page.filterWordsOutput.replace(`${className}!@`, "");
  Action.setFilterFull(Page.filterWordsOutput.trim(), true);
  let textInputValues = jQuery('#filtervalues').val();
  if(textInputValues.length-className.length<2){
    jQuery("#filtervalues").val('*');
  }else{
    let removedClassTextInputValues=textInputValues.replace(className, "");
    jQuery("#filtervalues").val(removedClassTextInputValues);
  }
  Action.removeContextMenu();

}

Action.hideClass=function(className){

  if(Page.filterWordsOutput.includes("*")){
    Action.setFilterFull(`~${className}`, true); 
  }else{
    Action.setFilterFull(Page.filterWordsOutput+"~"+className, true); 
  }

  var textInputValues = jQuery('#filtervalues').val();
  if(textInputValues.includes('*')){
    let inputReplace="~"+className;
    jQuery("#filtervalues").val(inputReplace);
  }else{
    jQuery("#filtervalues").val(textInputValues+" ~"+className);
  }
  Action.removeContextMenu();

}

Action.unHideClasses=function(){
  let unhideWordOutputs=Action.removeHiddenClasses(Page.filterWordsOutput);
  let textInputValues = Action.removeHiddenClasses(jQuery('#filtervalues').val());
  Action.setFilterFull(unhideWordOutputs, true); 
  jQuery("#filtervalues").val(textInputValues);
  Action.removeContextMenu();
}

Action.removeHiddenClasses=function(textInput){
  const unHideRegex = /~\w+!?@?/g;
  return textInput.replace(unHideRegex, "").replace(/\s+/g, "").trim();
}


//Multiuse function called whenever a user wants to use a menu edit function that requires user input
//allows users to input their text/color selection, listens for "enter", then performs the relevant edit
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.drawInput = function(inputType,classCode,className,neighbor){
  // creating input div
  var prompt = document.createElement('div');
  prompt.style.zIndex = "1000";
  prompt.style.border = "1px solid #ccc";
  prompt.style.backgroundColor = "#f8f8f8";
  prompt.style.padding = "5px";
  prompt.style.position = "fixed";
  prompt.id="promptBox";
  //draw at mouse location
  var promptRect=prompt.getBoundingClientRect();
  if(event.clientX+promptRect.width>window.innerWidth){
    prompt.style.right=(window.innerWidth-event.clientX)+"px";
  } else {
    prompt.style.left = event.clientX+"px";
  }
  if(event.clientY+promptRect.height>window.innerHeight){
    prompt.style.bottom=(window.innerHeight-event.clientY)+"px";
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
  inputErrorMsg.textContent='Error - Please enter an alphanumeric name.';
  inputErrorMsg.style.color="red";
  var hider=function hidePrompt(e) {
    if (document.contains(prompt) && e.target != prompt && !prompt.contains(e.target)) {
      document.removeEventListener("mousedown", hidePrompt);
      prompt.remove();
    }
  };
  // Add a listener to hide the prompt when the user clicks outside of it
  document.addEventListener("mousedown", hider);

  if(inputType=="attri"){
    //create the attribute dropdown list
    var select = document.createElement("select");
    var option1 = document.createElement("option");
    option1.value = "String";
    option1.text = "String";
    var option2 = document.createElement("option");
    option2.value = "Integer";
    option2.text = "Integer";
    var option3 = document.createElement("option");
    option3.value = "Double";
    option3.text = "Double";
    var option4 = document.createElement("option");
    option4.value = "Float";
    option4.text = "Float";
    var option5 = document.createElement("option");
    option5.value = "Boolean";
    option5.text = "Boolean";
    var option6 = document.createElement("option");
    option6.value = "Date";
    option6.text = "Date";
    var option7 = document.createElement("option");
    option7.value = "Time";
    option7.text = "Time";
    select.add(option1);
    select.add(option2);
    select.add(option3);
    select.add(option4);
    select.add(option5);
    select.add(option6);
    select.add(option7);
    prompt.appendChild(select);
    //create the text input for attribute name
    var input = document.createElement("input");
    input.type = "text";
    input.style.padding = "5px";
    input.style.borderRadius = "3px";
    input.style.border = "1px solid #ccc";
    input.style.width = "200px";
    input.style.marginLeft = "5px";
    input.addEventListener("keydown", function(e) {
      if (e.key === "Enter") {
        if(Action.validateAttributeName(input.value)){
          let orig=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
          let newClass;
          if(input.value.includes(":")){ //In the case users wish to type in the format - "newAttrName:Type" - instead of using dropdown
            let attriInput=input.value.split(":");
            newClass=orig.substr(0,orig.length-1)+"  "+attriInput[1].trim()+" "+attriInput[0].trim()+";\n}";
          } else { //if users use dropdown and type attribute name in text box
            newClass=orig.substr(0,orig.length-1)+"  "+select.value+" "+input.value+";\n}";
          }
          const textlength = Page.codeMirrorEditor6.state.doc.length
          const insertval = Page.codeMirrorEditor6.state.doc.toString().replace(orig,newClass)

          Page.codeMirrorEditor6.dispatch({ 
            changes: { 
              from: 0, 
              to: textlength,
              insert:  insertval
            } 
          });
          document.removeEventListener("mousedown", hider);
        
          prompt.remove();
          Action.removeContextMenu();
          TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
    prompt.appendChild(input);
  } else if(inputType=="rename"){
    var replaceAllLabel = document.createElement('label');
    replaceAllLabel.htmlFor = 'replace-all-checkbox';
    replaceAllLabel.style.marginRight = '5px';
    replaceAllLabel.appendChild(document.createTextNode("New name for \'"+className+"\'?"));
    input.value = className;
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        if(Action.validateAttributeName(input.value)){
        
          // Update core text
          let orig = Page.codeMirrorEditor6.state.doc.toString();
          orig = Action.renameClassAssistant(orig, className, input.value.trim());
          Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });
          
          // Update diagram text
          var positioningCode = jQuery("#umpleLayoutEditorText").val();
          positioningCode =  Action.renameClassAssistant(positioningCode, className, input.value.trim());
          Page.setUmplePositioningCode(positioningCode);
          
          document.removeEventListener("mousedown", hider);
          prompt.remove();
          Action.removeContextMenu();
          TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
    prompt.appendChild(replaceAllLabel);
    prompt.appendChild(input);    
  } else if(inputType=="subclass") {
    input.addEventListener('keydown', function(e) {
      if (e.key === 'Enter') {
        if(Action.validateAttributeName(input.value)){
          let subtext="\nclass "+input.value+"\n{\n  isA "+className+";\n}\n";
          Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: Page.codeMirrorEditor6.state.doc.toString() + subtext}});
          document.removeEventListener("mousedown", hider);
          TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
          prompt.remove();
          Action.removeContextMenu();
        } else if(!document.contains(inputErrorMsg)) {
          prompt.appendChild(inputErrorMsg);
        }
      }
    });
    prompt.appendChild(input);
  } else if(inputType=="color"){
    var label=document.createElement("label");
    label.textContent="Color - ";
    var arrow=document.createElement("span");
    arrow.innerHTML="&#8594;";
    arrow.style.cursor="pointer";
    arrow.fontSize="20px";
    arrow.style.paddingLeft="5px";
    input.style.width="30px";
    input.style.height="30px";
    input.type="color";
    var inputFunc=function setter(e) {
      if (e.key === 'Enter') {
        document.removeEventListener('keydown',setter);
        Action.setColor(classCode,className,input.value);
        prompt.remove();
        Action.removeContextMenu();
      }
    };
    document.addEventListener('keydown', inputFunc);
    arrow.addEventListener("click", function(){
      Action.setColor(classCode,className,input.value);
      document.removeEventListener('keydown',inputFunc);
      prompt.remove();
      Action.removeContextMenu();
    });
    // Add event listeners for hover
    arrow.addEventListener("mouseover", function() {
      arrow.style.color = "blue";
    });
    arrow.addEventListener("mouseout", function() {
      arrow.style.color = "black";
    });
    prompt.appendChild(label);
    prompt.appendChild(input);
    prompt.appendChild(arrow);
  }else if(inputType=="assoc"){
    neighbor.forEach(element => {
      var item=document.createElement("p");
      item.textContent=element;
      item.style.width="100px";
      item.style.padding="5px";
      item.style.borderRadius="3px";
      item.style.margin="0px";
      item.style.cursor = "pointer";
      item.onclick = () => {
        Action.filterOnOneClass(element);
        prompt.remove();
      };
      // Highlight item on hover
      item.addEventListener("mouseover", function() {
        this.style.backgroundColor = "#ddd";
      });
      item.addEventListener("mouseout", function() {
        this.style.backgroundColor = "transparent";
      });
      prompt.appendChild(item);
    });
  }
  // Add the prompt to the page
  document.body.appendChild(prompt);
  input.focus();

}

//Replaces a word anywhere in the text repeatedly
//Used to rename classes ... both their definition() 
//including diagram layout
//and use as a type.
Action.renameClassAssistant = function(text, oldClassName, newClassName) {
  let newText= text;
  let regex=new RegExp("(\\W+)("+oldClassName+")(\\W+)");
  let res;
  while((res=newText.match(regex))!=null){
    newText=
      newText.substr(0,res.index+res[1].length)
      +newClassName
      +newText.substr(
        res.index+res[1].length+res[2].length,
        newText.length-(res.index+res[1].length+res[2].length)
      );
  }
  return newText;
}

//Searches for existing associations, children, and associationClasses related to the target class
//Associations are: deleted
//Children are: pointed to parent (if exists)
//associationClasses are: deleted
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.deleteClass = function(classCode, className){
  let orig=Page.codeMirrorEditor6.state.doc.toString();

  orig=orig.replace(classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\""),"");
  //deletes all associations leading to target class
  //\b keeps className from matching the end of a longer name, such as PlayingCard or topCard for Card
  let regex=new RegExp(".*\\s*(-|<)(>|-)\\s*.*\\s*\\b"+className+"(\\s+\\w+)*\\s*;");
  let res;
  while((res=orig.match(regex))!=null){ 
    orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
  }
  regex=new RegExp(".*\\b"+className+"\\s*(<|-)(>|-)\\s*.*\\s+\\w+;");
  while((res=orig.match(regex))!=null){ 
    orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
  }
  //finds all children of target class and connects them to parent of target, if it exists
  //The match must include the ';' so that deleting Card does not also match the start of isA CardSet;
  regex=new RegExp("isA\\s+"+className+"\\s*;");
  if(orig.match(regex)!=null){
    let subregex=new RegExp("isA\\s+(\\w+);");
    let test;
    if((test=classCode.match(subregex))!=null){ //if parent class exists, link children to it
      let parentClass="isA "+test[1]+";";
      while((res=orig.match(regex))!=null){
        orig=orig.substr(0,res.index)+parentClass+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
      }
    } else { //if parent class does not exist, delete relevant isA statements
      while((res=orig.match(regex))!=null){
        orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
      }
    }
  }
  //remove any associationClass definitions containing this class
  regex=new RegExp("associationClass\\s+\\w+\\s*\\n*{(\\n*\\W*\\w*;)*(\\s*CRUD_Value\\s*{(\\s*\\w*\\s*,*)*}\\s*\\n*)*(\\n*\\W*\\w*;)*([\\s|\\t]*[*]\\s+"+className+";)(\\n*\\W*\\w*;)*(\\s*CRUD_Value\\s*{(\\s*\\w*\\s*,*)*}\\s*\\n*)*(\\n*\\W*\\w*)*?}");
  res=null;
  while((res=orig.match(regex))!=null){ 
    orig=orig.substr(0,res.index)+orig.substr(res.index+res[0].length,orig.length-(res.index+res[0].length));
  }
  //set editor code, save new state, and remove the context menu
    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: orig } });


  Action.removeContextMenu();
  TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
}



//Adds an association to a class, this function is called by Action.displayMenu() when the user selects "Add Association"
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.addAssociationGv = function(classCode, className){
  var elems=document.getElementsByClassName("node");
  var orig=classCode.replaceAll("&#10","\n").replaceAll("&#$quot","\"");
  Action.removeContextMenu();
  // Share one listener so completing the operation removes it from every node.
  function assocClass(event){
    const elemText = Action.getGvClassName(event);
    if (!elemText || !Action.getGvClassCode(elemText)) return;
    let subtext="  * -> 1 "+elemText+";\n}\n";
    let newClass=orig.substr(0,orig.length-1)+subtext;

    Page.codeMirrorEditor6.dispatch({ changes: { from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: Page.codeMirrorEditor6.state.doc.toString().replace(orig,newClass) } });

    TabControl.getCurrentHistory().save(Page.getUmpleCode(), "menuUpdate");
    for(let i=0;i<elems.length;i++){
      elems[i].removeEventListener("mousedown",assocClass);
    }
  }
  for(let i=0;i<elems.length;i++){
    elems[i].addEventListener("mousedown", assocClass);
  }
}

// Get the class name from a SVGGelement
Action.getGvClassName = function(event) {
  return Action.getGvClassNameFromNode(event.target);
}

// Resolve the model class from the generated link, including association-class
// junctions and edges whose SVG titles are not class names.
Action.getGvClassNameFromLink = function(link) {
  const match = (link || "").match(/Action\.selectClass\((["'])([^"']+)\1\)/);
  return match ? match[2] : null;
}

Action.getGvClassNameFromNode = function(element) {
  const group = element.closest(".node, .edge");
  if (!group) return "";
  const anchors = group.getElementsByTagName("a");
  for (let i = 0; i < anchors.length; i++) {
    const className = Action.getGvClassNameFromLink(
      anchors[i].getAttribute("xlink:href") || anchors[i].getAttribute("href"));
    if (className) return className;
  }
  const title = group.querySelector("title");
  return title ? title.textContent : "";
}

Action.getGvClassCode = function(className) {
  return Action.splitStates(Page.codeMirrorEditor6.state.doc.toString()).find(function(block) {
    const declaration = block.match(/^(?:class|associationClass)\s+([^\s{]+)/);
    return declaration && declaration[1] === className;
  });
}

//Action.displayMenu() is triggered by contextmenu event on Graphviz Class "node" elements
//Draws a div containing the editing options for class GV diagrams, as well as calling the related function when clicked
//Part of Issue #1898, see wiki for more details: https://github.com/umple/umple/wiki/MenusInGraphviz
Action.displayMenu = function(event) {
  if(!Action.diagramInSync){
    return;
  }
  // Remove old menu, if any
  Action.removeContextMenu();
  var elemText=Action.getGvClassName(event);

  var chosenClass = Action.getGvClassCode(elemText);
  if(typeof chosenClass != 'string'){
    return;
  }
  var menu = document.createElement('customContextMenu');
  var rowContent = ["Add Attribute","Rename Class","Delete Class","Add Subclass","Add Association","Change Color", "Focus on this class", "Do not show this class"];
  var jsInput=chosenClass.replaceAll("\n","&#10").replaceAll("\"","&#$quot");
  var rowFuncs = ["Action.drawInput(\"attri\",\""+jsInput+"\",\""+elemText+"\")","Action.drawInput(\"rename\",\""+jsInput+"\",\""+elemText+"\")","Action.deleteClass(\""+jsInput+"\",\""+elemText+"\")","Action.drawInput(\"subclass\",\""+jsInput+"\",\""+elemText+"\")","Action.addAssociationGv(\""+jsInput+"\",\""+elemText+"\")","Action.drawInput(\"color\",\""+jsInput+"\",\""+elemText+"\")", "Action.filterOnOneClass(\""+elemText+"\")", "Action.hideClass(\""+elemText+"\")"];
  // A read-only model keeps only the items that change what is shown, not the model
  if(Page.readOnly){
    var editingItems = ["Add Attribute","Rename Class","Delete Class","Add Subclass","Add Association","Change Color"];
    rowFuncs = rowFuncs.filter((funcItem, i) => !editingItems.includes(rowContent[i]));
    rowContent = rowContent.filter(menuItem => !editingItems.includes(menuItem));
  }


  var positioningCode = jQuery("#umpleLayoutEditorText").val();

  var currentClasses=[];
  var showNeighbors=[];
  var elems=document.getElementsByClassName("node");
  for(let i=0;i<elems.length;i++){
    var currentClassForPos = Action.getGvClassNameFromNode(elems[i]);
    currentClasses.push(currentClassForPos);
  }
  // console.log('chosen', Action.neighbors[elemText]);
  // console.log('all', Action.neighbors)
  // console.log('current', currentClasses);
  var selectedClassNeighbors= Action.neighbors[elemText] || [];
  showNeighbors=selectedClassNeighbors.filter(cls=>!currentClasses.includes(cls));
  // console.log(showNeighbors);
  if(showNeighbors.length>0){
    rowContent.push("Show Associations to:");
    rowFuncs.push("Action.drawInput(\"assoc\",null,null,"+JSON.stringify(showNeighbors)+")");
  }

 
  // If filter is applied then need to remove Filter option from menu to prevent repeatetive calls - gazi.
  if(Page.filterWordsOutput.length>0){
    Page.filterWordsOutput.split("!@").forEach(function(aFilterWord){
      if(aFilterWord.toLowerCase()==elemText.toLowerCase()){
        //remove the filter option from the menu
        //using array.includes("subString") instead of splice() - because menu index can alter in future.
        rowContent=rowContent.filter(menuItem=>!menuItem.includes("Focus on this class"));
        
        //add the Remove Filter option in the menu
        rowContent.push("Remove Focus");
        //remove the function of the Filter option
        rowFuncs=rowFuncs.filter(funcItem=>!funcItem.includes("Action.filterOnOneClass"));

        //add function for Remove Filter.
        rowFuncs.push("Action.clearFilterOnOneClass(\""+elemText+"\")");


      rowContent=rowContent.filter(menuItem=>!menuItem.includes("Do not show this class"));
      rowFuncs=rowFuncs.filter(funcItem=>!funcItem.includes("Action.hideClass"));
      }

      // console.log();

      if(aFilterWord.includes('~')){
        // Add context menu to show the hidden classes
        if(!rowContent.includes("Unhide Class(es)")){
          rowContent.push("Unhide Class(es)");
          rowFuncs.push("Action.unHideClasses()");
        }
      }
    })

  }




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
  // Add a listener to hide the menu when the user clicks outside of it
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
