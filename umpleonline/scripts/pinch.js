// Code to adjust GraphViz class and state diagrams
// To fill the entire space
// And allow gestural scrolling and pinching
// Code adapted from https://stackblitz.com/edit/multi-touch-trackpad-gesture?file=index.js

// Action.svgPosX = 0;
// Action.svgPosY = 0;
// Action.svgScale = 1;

Action.svgChangeCount=0;

Action.removePinch = function() {
  // Functionality needs to be added to remove
  // the event listeners when allowPinch is switched off.
}

Action.setupPinch = function()
{
  if(!Page.allowPinch) {
    return;
  }

  var node; 
  var rotation = 0;  // Not currently used
  var gestureStartRotation = 0;
  var gestureStartScale = 0;
  var startX;
  var startY;
  
  var minPosX = -9999999;
  var maxPosX = 9999999;
  var minPosY = -9999999;
  var maxPosY = 9999999;
  
  var svgPosX=0;
  var posY=0;
  var scale=1;

  // The area currently dedicated to the canvas
  var fullArea = document.querySelector("#umpleCanvasColumn");
  var fullHeight= fullArea.scrollHeight.round();
  var fullWidth= fullArea.scrollWidth.round();


  // the whole area where we will accept scrolling and gestures
  var parentNode = document.querySelector("#umpleCanvas");

  // the svg area (initially may be small; we will increase)
  var svgNode = document.querySelector("#svgCanvas");
  if(svgNode == null) return; // no current canvas to set up

  // The graph within the svg that we will move around can be tiny or huge
  var node = document.querySelector("#graph0"); 
  if(svgNode == null) return; // no current graph to set up
  var nodeHeight= node.getBoundingClientRect().height.round();
  var nodeWidth= node.getBoundingClientRect().width.round();

  // Set the scale so the initial font size is constant
  var scaleX=nodeWidth / fullWidth;
  var scaleY=nodeHeight / fullHeight;
  scale = Math.max(scaleX, scaleY);

  // set initial position so it is visible 
  if(scale <1) {
    posY = nodeHeight*scale+10;
  }
  else {
    posY = nodeHeight+10;
    if(nodeWidth > nodeHeight) {
      posY = posY * (nodeWidth/nodeHeight/2);
    }
  }
  svgPosX = 10;

  // Ensure entire area can be scrolled over
  svgNode.style.width=fullWidth;
  svgNode.style.height=fullHeight;

  // Set initial position and scale
  var val = `translate3D(${svgPosX}px, ${posY}px, 0px) scale(${scale})`;
  node.style.transform = val;
  
  Action.svgChangeCount++;

  var debugPrint = () => {
    Page.setFeedbackMessage(
      "N: <font color='red'>"+nodeWidth+"</font>,"+nodeHeight+
      " F: <font color='red'>"+fullWidth+"</font>,"+fullHeight+
      " Scroll: [<font color='red'>"+svgPosX.toFixed()+"</font>,"+posY.toFixed()+",  <font color='green'>"+scale.toFixed(3)+"</font>]"+
      " bounds:<font color='red'>"+minPosX.toFixed()+"-"+maxPosX.toFixed()+"</font>,"+minPosY.toFixed()+ "-"+maxPosY.toFixed() +
      "Chg:"+Action.svgChangeCount);
  }
//  debugPrint();

  // This function is called to redraw the canvas repeatedly
  var render = () => {
    
    if(node == null) node = document.querySelector("#graph0");
    window.requestAnimationFrame(() => {
      // constrain max and min values, which change depending on scale
      // set extreme boundaries that we want to be able to scroll to
      
      if(scale < 1) {
        // X dimension Case 1: image smaller than space.
        minPosX = -(nodeWidth*0.2); 
        maxPosX = (nodeWidth - nodeWidth*scale)*1.25;
      }
      else {
        // reveal what is on the right
        minPosX = (nodeWidth - nodeWidth*scale)*1.25;
        // reveal what is on the left
        maxPosX = nodeWidth*0.2;
      }

      if(scale < 1) {
        // Y dimension Case 1: image smaller than space.
        minPosY = (nodeHeight*scale)*.9; 
        maxPosY = (nodeHeight*1.111);
      }
      else {
        // reveal what is on the right
        minPosY = (nodeHeight*.9);
        // reveal what is on the left
        maxPosY = (nodeHeight*scale*1.111);
      }
    
      svgPosX = Math.min(Math.max(svgPosX,minPosX),maxPosX);
      posY = Math.min(Math.max(posY,minPosY),maxPosY);

      // var val = `translate3D(${svgPosX}px, ${posY}px, 0px) rotate(${rotation}deg) scale(${scale})`;
      var val = `translate3D(${svgPosX}px, ${posY}px, 0px) scale(${scale})`;
    //  debugPrint();
      node.style.transform = val;
      Action.svgChangeCount++;
    })
  
  }

  parentNode.addEventListener('wheel', (e) => {
    e.preventDefault();

    if (e.ctrlKey) {
      scale -= e.deltaY * 0.01;
    } else {
      svgPosX -= e.deltaX * 2;
      posY -= e.deltaY * 2;
    }

    render();
  });

  parentNode.addEventListener("gesturestart", function (e) {
    e.preventDefault();
    startX = e.pageX - svgPosX;
    startY = e.pageY - posY;
    gestureStartRotation = rotation;
    gestureStartScale = scale;
  });

  parentNode.addEventListener("gesturechange", function (e) {
    e.preventDefault();
  
    rotation = gestureStartRotation + e.rotation;
    scale = gestureStartScale * e.scale;

    svgPosX = e.pageX - startX;
    posY = e.pageY - startY; 

    render();

  })

  parentNode.addEventListener("gestureend", function (e) {
    e.preventDefault();
  });

}
