// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Reading and updating the positions of classes moved in Graphviz class diagrams

// Get the positioning information for a given class as stored in the
// Umple model. 
Action.getGvPosition =function(positioningCode, className) {
  // Returns an structure with 
  //  all  matchedClassPos ... the overall match
  //  assoc1 any initial code describing assoc positions
  //  x  the X position (left)
  //  y  the y position (right)
  //  width the width (we will not edit)
  //  height the height (we will not edit)
  //  assoc2   any more code describing association locations
  
  // Find the positioning code for the class
  var regexForPositions = new RegExp(
    "class[\\s]*" +className +"[\\s]{"
    +"([\\sa-zA-Z\\:\\.\\,\\;\\-\\_0-9]*)"
    +"\\s*position ([\\d.]*) ([\\d.]*) ([\\d.]*) ([\\d.]*);"
    +"([\\sa-zA-Z\\:\\.\\,\\;\\-\\_0-9]*)}","s");
  var theMatch=positioningCode.match(regexForPositions);
  if(theMatch == null) {
    // This should be an error
    return null;
  }

  var positionStruct = {
    all: theMatch[0],
    assoc1: theMatch[1],
    x: theMatch[2],
    y: theMatch[3],
    width: theMatch[4],
    height: theMatch[5],
    assoc2: theMatch[6]
  };
  
  return positionStruct;
}

// Called when a class is being moved by direct manipulation
// To ways this could have been done:
// 1. Front end in CodeMirror6: Edit the text as above in setColor as per G mode
//   .. won't work as the diagram code is not necessarily in the visible text
// 2. Backend function as used by E mode as in DiagramEdit.classMoved and
//    DiagramEdit.updateUmpleText with editClass
//   .. won't work as we would have to have full details of the class parsed as Json
// Solution: Edit code in the layout editor, then trigger CodeMirror6 to send change
Action.updateGvPosition=function(className,deltaX,deltaY) {
  // Get the positioning code that we will update
  var positioningCode = jQuery("#umpleLayoutEditorText").val();

  // get astructure containing the umple positioning info in the current model
  var theMatch = Action.getGvPosition(positioningCode, className);

  if(theMatch == null) {
    // Could not find position for this class
//DEBUG
//Page.catFeedbackMessage("NOPOS:"+className+" ");

    return null;
  }

  // Update the position for this class
  var matchedClassPos=theMatch.all; // full positioning text
  var xPos=theMatch.x; // left
  
  var yPos=theMatch.y; // top
  var associationPos1=theMatch.assoc1; // only used by E mode
  var associationPos2=theMatch.assoc2; // only used by E mode

  return Action.updateGVPositionBasic(className,deltaX,deltaY,positioningCode,
    matchedClassPos,xPos,yPos,associationPos1,associationPos2,true);
}

// Completion for the above, called both by the above on direct manip
// and also in updateUmpleDiagramCallback when gv is updated and
// gvmanual is set
Action.updateGVPositionBasic=function(className,deltaX,deltaY,positioningCode,
    matchedClassPos,xPos,yPos,associationPos1,associationPos2, doRedraw) {

  // Prevent positions from being set to values off or too close to diagram edge
  var newXpos = Math.round(Math.max(Number(xPos)+deltaX,5)); // just before left border
  var newYpos = Math.round(Math.max(Number(yPos)+deltaY,5)); // just below top border
//DEBUG
//if(isNaN(xPos)) Page.catFeedbackMessage("OXNAN");
//if(isNaN(yPos)) Page.catFeedbackMessage("OYNAN");
//if(isNaN(deltaX)) Page.catFeedbackMessage("DXNAN");
//if(isNaN(deltaY)) Page.catFeedbackMessage("DYNAN");
//if(isNaN(newXpos)) Page.catFeedbackMessage("NXNAN");
//if(isNaN(newYpos)) Page.catFeedbackMessage("NYNAN");

  var newClassPos=matchedClassPos.replace(
    "position "+xPos+" "+yPos,
    "position "+newXpos+" "+newYpos);

  // Remove any association positioning that has been left
  if(associationPos1 != null) {
    newClassPos=newClassPos.replace(""+associationPos1+"","\n");
  }
  if(associationPos2 != null) {
    newClassPos=newClassPos.replace(""+associationPos2+"","\n");
  }
//DEBUG next 6 lines
//if (matchedClassPos == newClassPos) {
//  Page.catFeedbackMessage(" @@@"+deltaX+"&"+xPos+"&"+newXpos+" ");
//}
//else {
//  Page.catFeedbackMessage("###"+deltaX);
//}
  
  //Update the text
  Page.setUmplePositioningCode(
    positioningCode.replace(matchedClassPos,newClassPos));

  if(doRedraw) {
    // Update the backend, triggering redraw
    setTimeout(function(){
      TabControl.getCurrentHistory().save(Page.getUmpleCode(), "moveClass");
    }, 100);
      Action.redrawDiagram();
  }
}


Action.isWithinRadarZone=function(positioningCode,target, other, Threshold=100){

  
  var targetClassPos = Action.getGvPosition(positioningCode, target);
  

  var otherClassName = Action.getGvClassNameFromNode(other);
  var otherClassPos = Action.getGvPosition(positioningCode, otherClassName);

  const withinX = Math.abs(otherClassPos.x - targetClassPos.x) <= Threshold;
  const withinY = Math.abs(otherClassPos.y - targetClassPos.y) <= Threshold;
  // console.log("target", targetClassPos.x, targetClassPos.y);
  // console.log("other:",otherClassName, otherClassPos.x, otherClassPos.y);
  // console.log("result",Math.abs(otherClassPos.x - targetClassPos.x),Math.abs(otherClassPos.y - targetClassPos.y) )
  return withinX && withinY;
  
}
