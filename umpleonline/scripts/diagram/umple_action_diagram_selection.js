// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for clicking, hovering over and selecting elements of a diagram

Action.classSelected = function(obj)
{
  var previouslySelected = Page.selectedClass;
  var newClassSelected = obj;
  
  if (previouslySelected != null)
  {
    Page.selectedClass = null;
    
    // Change background color to white
    jQuery("#"+previouslySelected.id).css('background-color','white');
    
    // Hide anchors on previous class
    var selector = "#" + previouslySelected.id + "_anchor";
    for (var i=0; i<8; i++) jQuery(selector + i).hide();
  }
 
  if (newClassSelected != null)
  {
    jQuery("#umpleCanvas").addClass("unscrollable");
    Page.selectedClass = UmpleSystem.find(newClassSelected.id);
    
    // Change background color to blue
    jQuery("#"+newClassSelected.id).css('background-color', '#F3F6FB');
    
    // Show anchors on new class and remove the hovers
    var selector = "#" + newClassSelected.id + "_anchor";
    var hover = "#" + newClassSelected.id + "_hover";
    for (var i=0; i<8; i++)
    {
      jQuery(selector + i).show();
      jQuery(hover + i).hide();
    }
  }
  else
  {
    jQuery("#umpleCanvas").removeClass("unscrollable");
  }
}

Action.classHover = function(event,isHovering)
{
  var updateClass = event.currentTarget;
  if (!Action.diagramInSync) return;
  if (Page.selectedClass != null && Page.selectedClass.id == updateClass.id) return;
  
  var displayType = isHovering ? "block" : "none";
  var umpleClass = jQuery("#" + updateClass.id);
  
  // change the background color
  if (isHovering) umpleClass.css("background-color", "#F3F6FB");
  else umpleClass.css("background-color", "white");
  
  // show or hide the hovers (if they are enabled)
  if (Page.canShowHovers())
  {
    var numHovers = 8;
    var hoverSelector = "#" + updateClass.id + "_hover";
    for (var i=0; i<numHovers; i++)
    {
      if (isHovering) jQuery(hoverSelector + i).show();
      else jQuery(hoverSelector + i).hide();  
    }
  }
}

Action.unselectAll = function()
{
  Action.classSelected(null);
  Action.associationSelected(null);
  Action.generalizationSelected(null);
  Action.transitionSelected(null);
}

Action.classClicked = function(event)
{

  // DEBUG F
  if (!Action.diagramInSync) return;
  Action.focusOn("umpleCanvas", true);
  Action.focusOn("umpleModelEditorText", false);

  Action.unselectAll();
  Action.elementClicked = true;
  var obj = event.currentTarget;

  Action.selectClass(obj.id);
  
  if (Page.selectedItem == "DeleteEntity")
  {
    DiagramEdit.classDeleted(obj.id);
  }
  else if (Page.selectedItem == "AddAssociation")
  {
    if (DiagramEdit.newAssociation == null)
    {
      Action.canCreateByDrag = false;
      DiagramEdit.createAssociationPartOne(event);
    }
    else
    {
      DiagramEdit.createAssociationPartTwo(event);
      setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
    }
  }
  else if (Page.selectedItem == "AddGeneralization")
  {
    if (DiagramEdit.newGeneralization == null)
    {
      var successful = DiagramEdit.createGeneralizationPartOne(event);
      if (successful) Action.canCreateByDrag = false;
    }
    else
    {
      DiagramEdit.createGeneralizationPartTwo(event);
      setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
    }
  }
  
  else
  {
    Action.classSelected(obj);
  }
}

/*
  Called whenever a state or nested state is clicked in a state diagram
  Internally calls Action.selectStateInClassCM6() if single-level state is clicked in diagram
  or
  calls Action.selectStateInStateCM6() if nested-state is clicked in  diagram
  Highlights the corresponding code for diagram part clicked, in the code editor

  Parameters: identifier - complete name of target that was clicked in state machine diagram (See example below)
              Single State -> CourseSection^*^status^*^Open
                              CourseSection - Class name
                              status - state-machine name
                              open - state name
              Nested State -> CourseSection^*^status^*^Open.NotEnoughStudents
                              CourseSection - class name
                              status - state-machine name
                              Open.NotEnoughStudents - nested state
*/
Action.stateClicked = function(identifier)
{
    if (!Action.diagramInSync) return;
    GvDiagramEdit.selectedState = identifier;
    Action.focusOn("umpleCanvas", true);
    Action.focusOn("umpleModelEditorText", false);
    var idSplit=identifier.split("^*^");
    var identifierClass=idSplit[0]
    var identifierSM=idSplit[1]
    var identifierState=idSplit[2].replace("Entry:","").replace("Exit:","");
    identifierState=identifierState.replace("Exit:","");
    Action.unselectAll();
    Action.elementClicked = true;
    var selectionIndicies=null;
    var selectionIndiciesCM6=null;
    if(identifierState.includes('.')){ //nested case

      if (clientDebuggerFlag){
        console.log("stateClicked - nested state case");
      }
      
      identifierState=identifierState.split('.');
      selectionIndiciesCM6=Action.selectStateInClassCM6(identifierClass,identifierSM,identifierState[0]);
      for(let i=1;i<identifierState.length;i++){

        if (clientDebuggerFlag){
          console.log("Iterating states within Identified state ...");
        }

        selectionIndiciesCM6=Action.selectStateInStateCM6(selectionIndiciesCM6.startIndex,selectionIndiciesCM6.endIndex,identifierState[i]);
      }
    } else { //base case

      if (clientDebuggerFlag){
        console.log("stateClicked - else - base case");
      }

      selectionIndiciesCM6 = Action.selectStateInClassCM6(identifierClass,identifierSM,identifierState);

      if (clientDebuggerFlag){
        console.log("selectionIndiciesCM6: ", selectionIndiciesCM6);
      }

    }

    Action.highlightByIndexCM6(selectionIndiciesCM6.startIndex, selectionIndiciesCM6.endIndex);



   if (Page.selectedItem == "AddTransition" && !Page.useGvStateDiagram)
    {
        if (DiagramEdit.newTransition == null)
        {
            Action.canCreateByDrag = false;
            DiagramEdit.createTransitionPartOne(event);
        }
        else
        {
            DiagramEdit.createTransitionPartTwo(event);
            setTimeout(function(){ Action.canCreateByDrag = true; }, 500);
        }
    }
    else
    {
        //Action.stateSelected(identifier);
    }
}

Action.associationClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.elementClicked = true;
  Action.unselectAll();
  
  var obj = event.currentTarget;
  Action.associationSelected(obj);
}

/*
  Called when a transition is clicked in the state digram
  Internally calls Action.selectStateInClassCM6() and Action.selectStateInStateCM6() 
  to locate selected class, start and end states in the code present in code editor
  and highlights the target transition between the start and end states

  Parameters: identifier - complete name of target that was clicked in state machine diagram (See example below)
              CourseSection*^*status*^*openRegistration*^*Planned*^*Open.NotEnoughStudents*^*
              CourseSection - class name
              status - state-machine name
              openRegistration - transition name
              Planned - start state
              Open.NotEnoughStudents - end state
*/
Action.transitionClicked = function(identifier)
{
  if(!Action.diagramInSync) return;
  if(typeof identifier === "string" && identifier === null) return;
  Action.elementClicked = true;
  Action.unselectAll();
  let id = identifier.split("*^*");
  let identifierState=id[3].split(".");
  
  dest=id[4];
  var selection = Action.selectStateInClassCM6(id[0],id[1],identifierState[0]);
  dest=id[4].split(".");

  for (var i=1;i<identifierState.length;i++){
    selection=Action.selectStateInStateCM6(selection.startIndex,selection.endIndex,identifierState[i]);
  }
  let searchTerm=id[2].replaceAll("+","\\+").replaceAll("-","\\-").replaceAll("*","\\*").replaceAll("?","\\?").replaceAll("|","\\|"); //preceed any accidental quantifiers with escape character
  searchTerm=searchTerm.replace("after","after~`~?:Every`~`?"); //subpar solution, could be improved
  if(!id[2].startsWith("after(")) searchTerm=searchTerm.replace(/\(.*\)$/, "~`~?:$&`~`?"); //the code may omit the parameters of the event
  if(id[5]!=""){

    let guardStr=id[5].trim().replaceAll("+","\\+").replaceAll("-","\\-").replaceAll("*","\\*").replaceAll("?","\\?").replaceAll("|","\\|"); //preceed any accidental quantifiers with escape character
    searchTerm=searchTerm+"\\s*[\\s*"+guardStr.trim().slice(1,guardStr.trim().length-1)+"\\s*]";

  }
  searchTerm=searchTerm.replaceAll("]","\\]").replaceAll("[","\\[").replaceAll(")","\\)?").replaceAll("(","\\(?").replaceAll("~`~","(").replaceAll("`~`",")").replaceAll(" ","\\s*").replaceAll(",","\\s*,\\s*").replaceAll("!","\\s*!\\s*").replaceAll("/","\\s*/\\s*"); 
  searchTerm=searchTerm.replaceAll("&&","&{1,2}");
  let pattern= new RegExp(searchTerm+".*->","s");

  let startIndex=Page.codeMirrorEditor6.state.doc.toString().substr(selection.startIndex,selection.endIndex-selection.startIndex).search(pattern)+selection.startIndex;
  let cText = Page.codeMirrorEditor6.state.doc.toString().substr(startIndex);
  let line = Action.findEOL(cText);
  let endIndex=startIndex+line.length;
  Action.highlightByIndexCM6(startIndex,endIndex);

// DEBUG THE FOLLOWING MAY NEED CHANGING FOR CM6  
  if(!(line.split("->").length - 1 === 1) ){
    Page.setFeedbackMessage("Please edit this complex transition in the textual code.");
  }
  
  Action.highlightByIndexCM6(startIndex,endIndex);
}
Action.generalizationClicked = function(event)
{
  if (!Action.diagramInSync) return;
  Action.elementClicked = true;
  Action.unselectAll();
    
  var obj = event.currentTarget;
  Action.generalizationSelected(obj);
}

Action.associationHover = function(event,isHovering)
{
  if (!Action.diagramInSync) return;
  var updateAssociation = event.currentTarget;
  var umpleAssociation = UmpleSystem.findAssociation(updateAssociation.id);
  
  if (updateAssociation != null && Page.canShowHovers())
  {
    var hoverCount = 2;
    var selector = "#" + updateAssociation.id + "_hover";
    
    for (var i=0; i<hoverCount; i++)
    {
      if (isHovering) jQuery(selector+i).show();
      else jQuery(selector+i).hide();
    }
  }
}

Action.transitionHover = function(event,isHovering)
{
    if (!Action.diagramInSync) return;
    var updateTransition = event.currentTarget;
    var umpleTransition = UmpleSystem.findTransition(updateTransition.id);

    if (updateAssociation != null && Page.canShowHovers())
    {
        var hoverCount = 2;
        var selector = "#" + updateAssociation.id + "_hover";

        for (var i=0; i<hoverCount; i++)
        {
            if (isHovering) jQuery(selector+i).show();
            else jQuery(selector+i).hide();
        }
    }
}


Action.generalizationHover = function(event,isHovering)
{
  if (!Action.diagramInSync) return;
  var updateGeneralization = event.currentTarget;
  
  if (updateGeneralization != null && Page.canShowHovers())
  {
    var selector = "#" + updateGeneralization.id + "_hover";
    for (var i=0; i<3; i++)
    {
      if (isHovering) jQuery(selector+i).show();
      else jQuery(selector+i).hide();
    }
  }
}

Action.associationSelected = function(obj)
{
  var isSelected = (obj == null) ? false : true;
  var updateObj = null;
  
  if (Page.selectedItem == "DeleteEntity" && obj != null)
  {
    var addToQueue = false;
    DiagramEdit.associationDeleted(obj.id, addToQueue);
    return;
  }  
  
  if (obj != null)
  {
    Page.selectedAssociation = obj;
    updateObj = obj;
  }
  else if (Page.selectedAssociation != null)
  {
    updateObj = Page.selectedAssociation;
    Page.selectedAssociation = null;
  }
  else
  {
    return;  
  }
  
  var anchorCount = 2;
  var anchorSelector = "#" + updateObj.id + "_anchor";
  for (var i=0; i<anchorCount; i++)
  {
    if (isSelected) jQuery(anchorSelector + i).show();
    else jQuery(anchorSelector + i).hide();
  }
}

Action.transitionSelected = function(obj)
{
    var isSelected = (obj == null) ? false : true;
    var updateObj = null;

    if (Page.selectedItem == "DeleteEntity" && obj != null)
    {
        var addToQueue = false;
        DiagramEdit.transitionDeleted(obj.id, addToQueue);
        return;
    }

    if (obj != null)
    {
        Page.selectedTransition = obj;
        updateObj = obj;
    }
    else if (Page.selectedTransition != null)
    {
        updateObj = Page.selectedTransition;
        Page.selectedTransition = null;
    }
    else
    {
        return;
    }

    var anchorCount = 2;
    var anchorSelector = "#" + updateObj.id + "_anchor";
    for (var i=0; i<anchorCount; i++)
    {
        if (isSelected) jQuery(anchorSelector + i).show();
        else jQuery(anchorSelector + i).hide();
    }
}

Action.generalizationSelected = function(obj)
{
  var isSelected = (obj == null) ? false : true;
  var updateObj = null;
  
  if (Page.selectedItem == "DeleteEntity" && obj != null)
  {
    var addToQueue = false;
    DiagramEdit.generalizationDeleted(obj.id, addToQueue);
    return;
  }  
  
  if (obj != null)
  {
    Page.selectedGeneralization = obj;
    updateObj = obj;
  }
  else if (Page.selectedGeneralization != null)
  {
    updateObj = Page.selectedGeneralization;
    Page.selectedGeneralization = null;
  }
  else
  {
    return;  
  }

  var anchorCount = 3;
  var anchorSelector = "#" + updateObj.id + "_anchor";
  for (var i=0; i<anchorCount; i++)
  {
    if (isSelected) jQuery(anchorSelector + i).show();
    else jQuery(anchorSelector + i).hide();
  }
}
