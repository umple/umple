// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions that request the diagram from the compiler and draw the response, for every diagram type

Action.updateUmpleDiagram = function() {
 return Action.updateUmpleDiagramForce(true)
}

// To fetch the feature model json from the backend complier
Action.fetchFeatureModelTreeThen = function(next)
{
  let proceed = function() {
    if (typeof next === "function") next();
  };
  // proceedAsync is only used by the early-return branches below — they need the continuation deferred via setTimeout so fetchFeatureModelTreeThen returns before next() fires. The main Ajax onFinally path calls the sync proceed() directly.
  let proceedAsync = function() {
    setTimeout(proceed, 0);
  };


  let mount = document.getElementById("featureModelTreeContainer");

  // Additional check to ensure this fetch only happens when in the feature diagram mode
  if (!Page.useGvFeatureDiagram) {
    FeatureTree.reset();
    Page.hasFeatureModelTree = false;
    FeatureTreeModal._fetchId++;
    FeatureTreeModal._fetchInFlight = false;
    FeatureTreeModal._lastFetchFailed = false;
    FeatureTreeModal._lastFetchStatus = -1;
    FeatureTreeModal.close();
    if (mount) {
      while (mount.firstChild) mount.removeChild(mount.firstChild);
      mount.style.display = "none";
    }
    proceedAsync();
    return;
  }

  if (!mount) {
    Page.hasFeatureModelTree = false;
    FeatureTreeModal._lastFetchFailed = false;
    FeatureTreeModal._lastFetchStatus = -1;
    proceedAsync();
    return;
  }

  // async lock to prevent ajax mutex
  var thisFetchId = ++FeatureTreeModal._fetchId;
  FeatureTreeModal._fetchInFlight = true;
  FeatureTreeModal._lastFetchFailed = false;
  FeatureTreeModal._lastFetchStatus = -1;
  FeatureTreeModal.refreshBody();

  Ajax.sendRequest(
    "scripts/compiler.php",
    function(response) {
      // Stale callback guard: a newer fetch or a mode switch has made.
      if (thisFetchId !== FeatureTreeModal._fetchId) return;
      var featureModelJson = FeatureTree.getModelFromResponse(response.responseText);
      if (featureModelJson && featureModelJson.featureModel) {
        FeatureTree.parseModel(featureModelJson.featureModel);
        Page.hasFeatureModelTree = true;
      } else {
        FeatureTree.reset();
        Page.hasFeatureModelTree = false;
      }
    },
    "language=FeatureModelJson&theme=light&error=true&umpleCode="
      + encodeURIComponent(Page.getUmpleCode()),
    {
      onError: function(http) {
        // Error-unique: reset feature state and record failure for UI.
        // Stale callbacks do not mutate state; onFinally drives proceed().
        if (thisFetchId !== FeatureTreeModal._fetchId) return;
        FeatureTree.reset();
        Page.hasFeatureModelTree = false;
        FeatureTreeModal._lastFetchFailed = true;
        FeatureTreeModal._lastFetchStatus = http.status;
      },
      onFinally: function(http) {
        if (thisFetchId !== FeatureTreeModal._fetchId) {
          proceed();
          return;
        }
        FeatureTreeModal._fetchInFlight = false;
        FeatureTreeModal.refreshBody();
        proceed();
      }
    }
  );
};

// isLayoutUpdate is true when the diagram is updated with the layout just
// worked out for an edit that has already been saved
Action.updateUmpleDiagramForce = function(forceUpdate, isLayoutUpdate)
{
  // DEBUG
  // console.log("Inside updateUmpleDiagramForce")
  var canonical = Action.trimMultipleNonPrintingAndComments(Page.getUmpleCode());
  if(!forceUpdate) {
    if(canonical == Action.savedCanonical)
    {
      // The umple code is as we last sent to the diagram, except for comment
      // changes, spaces, tabs and newlines, so we return without doing anything
      return;
    }
  }
  Action.savedCanonical=canonical;
  Page.showCanvasLoading();

  Action.fetchFeatureModelTreeThen(function(){
    var update = function() {
      Action.ajax(Action.updateUmpleDiagramCallback, Action.getLanguage());
    };
    if (isLayoutUpdate) VersionHistory.saveAsLayoutUpdate(update);
    else update();
  });

}

// Updates all formats of Umple diagram given the response from the
// backend. This can be svg or else node for Emode.
Action.updateUmpleDiagramCallback = function(response)
{
  // Get the canvas position information, used in several places
  var theCanvas = jQuery("#umpleCanvas");
  var canvasX=Math.round(theCanvas.offset().left);
  var canvasY=Math.round(theCanvas.offset().top);

  // console.log("Debug E6.1: Inside updateUmpleDiagramCallback")
  var diagramCode = "";
  var errorMessage = "";

  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
  Page.hideExecutionArea();

  if(diagramCode == null || diagramCode == "" || diagramCode == "null") 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("<a href=\"\#errorClick\">See message.</a> To fix: edit model or click undo");
  }
  else
  {
    Page.enableDiagram(true);
    // reset error message
    if(!Action.diagramInSync)
    {
      Action.diagramInSync = true;
    }

    Page.setFeedbackMessage("");
    Page.hideGeneratedCode();

    // Enable dynamic checkboxes of mixsets and named filters
    // Find any phrases describing
    // named mixsets of filters not commented out
    var dynamicCheckboxItems = new Array();
    var umpleCodeForScan = Page.getUmpleCode();
    var mixsetMatches = umpleCodeForScan
      .match(/(?<!(\/\/.*))mixset\s+[a-zA-Z1-9-_]+/g);
    var filterMatches = umpleCodeForScan
      .match(/(?<!(\/\/.*))filter\s+[a-zA-Z1-9-_]+/g);
    if (mixsetMatches != null&&!Page.hasFeatureModelTree) dynamicCheckboxItems = dynamicCheckboxItems.concat(mixsetMatches);
    if (filterMatches != null) dynamicCheckboxItems = dynamicCheckboxItems.concat(filterMatches);
    // Add special suboptions
    dynamicCheckboxItems.push("gvmanual","gvdot","gvsfdp","gvcirco","gvortho");
    
    // Clear out previous
    // TODO. May need to keep some so as to preserve selections
    var spanToInjectItem = 
      document.getElementById("ShowMFDynamicArea");
    spanToInjectItem.innerHTML = "";

    if(! (dynamicCheckboxItems == null || dynamicCheckboxItems.length == 0)) {
      var boxesToActivate = new Array();
      // Iterate through all the named filters of mixsets
      dynamicCheckboxItems.forEach(
       function(aDynamicCheckboxItem) {
        // remove spaces from the item so it can also serve
        //  as part of the ID,
        // so idPart would be something like filterF1
        var idPart = aDynamicCheckboxItem.replace(/\s/g, '');

        var htmlToAdd = "<li id=\"tt"+idPart
          +"\" class=\"layoutListItem view_opt_class\">\
                <input id=\"button"+idPart+"\" class=\"checkbox\" type=\"checkbox\"/>\
                <a id=\"label"+idPart+"\" class=\"buttonExtend\">"+aDynamicCheckboxItem+"</a>\
              </li>";
        spanToInjectItem.innerHTML += htmlToAdd;
        // Make sure it is clickable ... have to do this after completion
        // Since activation is cancelled as new items are added
        boxesToActivate.push(idPart);
      });

      /*
       * Reconcile Page.mixsetsActive against the mixsets that still exist in
       * source. boxesToActivate was built from the regex scan above, so any
       * entry absent from it means that mixset was deleted or commented out
       * and should be dropped from the active set.
       *
       * Skip this reconciliation when the feature tree owns mixset state
       * to prevent the selection being cleared by this code
       */
      if (!Page.hasFeatureModelTree) {
        Page.mixsetsActive = Page.mixsetsActive.filter(function(aMixset){
          return boxesToActivate.includes("mixset"+aMixset);
        });
      }
      Page.filtersActive = Page.filtersActive.filter(function(aFilter){
        return boxesToActivate.includes("filter"+aFilter);
      });
      Page.specialSuboptionsActive = Page.specialSuboptionsActive.filter(function(aSuboption){
        return boxesToActivate.includes(aSuboption);
      });

      // Now activate the new ones found
      boxesToActivate.forEach(
       function(aBoxToActivate) {
        Page.initHighlighter("button"+aBoxToActivate);
        // Select it if it was already selected
        var buttonSetting = false;
        if(aBoxToActivate.substr(0,6)=="mixset"
          && Page.mixsetsActive.includes(aBoxToActivate.substr(6))) {
          buttonSetting = true;
        }
        else if(aBoxToActivate.substr(0,6)=="filter"
          && Page.filtersActive.includes(aBoxToActivate.substr(6))) {
          buttonSetting = true;
        }
        else if(aBoxToActivate.substr(0,2)=="gv"
          && Page.specialSuboptionsActive.includes(aBoxToActivate)) {
          buttonSetting = true;
        }        
        jQuery("#button"+aBoxToActivate).prop('checked',buttonSetting);       
        Page.initAction("button"+aBoxToActivate);
        Page.initLabel("label"+aBoxToActivate);
        ToolTips.setATooltipBasic(ToolTips.dynamicTooltips,"tt"+aBoxToActivate,"right");
        jQuery("#tt"+aBoxToActivate).show();
      });
    }

    // Display editable class diagram
    if(Page.useEditableClassDiagram) {
      var newSystem = Json.toObject(diagramCode);
      UmpleSystem.merge(newSystem);
      UmpleSystem.update(); 
      //Apply readonly styles
      if (Page.readOnly) 
      {
        jQuery("span.editable").addClass("uneditable");
      }
    }
    else if(Page.useJointJSClassDiagram) {
      // This code is deprecated as Joint.js functionality is no longer supported

      var model = JSON.parse(diagramCode.replace( new RegExp('} { "name": "', "gi"), '}, { "name": "' ));

      var umpleCanvas = jQuery("#umpleCanvas");

      var paper = JJSdiagram.initJJSDiagram(umpleCanvas, model);

      // zooming with the mouse wheel or finger swipe
      var MouseWheelHandler = function (event){
        var delta = Math.max(-1, Math.min(1, (event.wheelDelta || -event.detail)));
        if (event.altKey === true) {
          var paperHeight = paper.options.height;
          var paperWidth = paper.options.width;
          // scaleFactor is either 1.1 or 0.9
          var scaleFactor = 1 + (Math.abs(delta) / (delta * 10));
          paper.setDimensions(paperWidth * scaleFactor, paperHeight * scaleFactor)

          //correct paper sizing
          if( JJSdiagram.paper ) 
          JJSdiagram.paper.setDimensions(jQuery("#umpleCanvas")[0].clientWidth, jQuery("#umpleCanvas")[0].clientHeight);

        }
      };
      // using the umpleCanvas as the mouse wheel event target, as it is a stable entity
      var paperHolder = document.getElementById("umpleCanvas");

      if (paperHolder.addEventListener) {
        // IE9, Chrome, Safari, Opera
        paperHolder.addEventListener("mousewheel", MouseWheelHandler, false);
        // Firefox
        paperHolder.addEventListener("DOMMouseScroll", MouseWheelHandler, false);
      }
      // IE 6/7/8
      else {paperHolder.attachEvent("onmousewheel", MouseWheelHandler);}

      // Simulate a click on the canvas to draw focus and enable keyboard shortcuts.
      jQuery("#jjsPaper").click(function(){ Action.focusOn(Page.umpleCanvasId(), true);});

    }
    // Display static svg diagram
    else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram || Page.useGvUseCaseDiagram || Page.useGvEntityRelationshipDiagram || Page.useInstanceDiagram)
    {
      theCanvas.html(format('{0}', diagramCode));
      theCanvas.children().first().attr("id", "svgCanvas");
      Page.zoomToCurrentZoom();

      // If gv class mode is gvmanual then we need to update all the umple 
      // positioning information given the diagram locations
      if((Page.useGvClassDiagram || Page.useGvEntityRelationshipDiagram) && Page.isGvManual()) {

        // First, in case we have used a special algorithm to reformulate we first turn them all off
        // This will not have effect if the algorithm is specified in the code.
        var algoWasRemoved = Action.deactivateSpecialLayoutAlgorithmsExcept(null);

// DEBUG
// Page.catFeedbackMessage("updating class diagram layout due to gvmanual "+canvasX+" "+canvasY+" | ");

        // For each of the nodes loop through it
        var positioningCode = jQuery("#umpleLayoutEditorText").val();
        var elems=document.getElementsByClassName("node");
        var posMap = new Array();
        var minUmpleLeft = 9999999;
        var minUmpleTop = 9999999;
        var minRectLeft = 9999999;
        var minRectTop = 9999999;

        for(let i=0;i<elems.length;i++){
          var currentClassForPos = Action.getGvClassNameFromNode(elems[i]);
          var umplePosOfCurrentClass = Action.getGvPosition(positioningCode, currentClassForPos);

          if (umplePosOfCurrentClass == null) {
            // Position not found ... this is actually a bug caused
            // when updating the name of a class in the text ... needs fixing
            continue;
          }
          var theRect=Action.getRectFromSvgNode(elems[i], canvasX, canvasY);
          var rectLeft = theRect.left;
          var rectTop = theRect.top;
          // Get the centre of the rectangle as
          // the gv positions are also centre-focused
          var rectCentreX = theRect.centreX;
          var rectCentreY = theRect.centreY;
          var uLeft = umplePosOfCurrentClass.x;
          var uTop = umplePosOfCurrentClass.y;

// DEBUG
//Page.setFeedbackMessage(".."+currentClassForPos
//  +" "+umplePosOfCurrentClass.x+"/"+rectCentreX
//  +" "+umplePosOfCurrentClass.y+"/"+rectCentreY);

          posMap.push({className: currentClassForPos,
            fullUmplePosOfCurrentClass: umplePosOfCurrentClass.all,
            left: uLeft,
            umpleX: Number(umplePosOfCurrentClass.x)
              + Number(umplePosOfCurrentClass.width) / 2,
            rectCentreX: rectCentreX,
            top: uTop,
            umpleY: Number(umplePosOfCurrentClass.y)
              + Number(umplePosOfCurrentClass.height) / 2,
            rectCentreY: rectCentreY,
            associationPos1: umplePosOfCurrentClass.assoc1,
            associationPos2: umplePosOfCurrentClass.assoc2
          });
          minUmpleLeft=Math.min(minUmpleLeft,uLeft);
          minUmpleTop=Math.min(minUmpleTop,uTop);
          minRectLeft=Math.min(minRectLeft,rectLeft);
          minRectTop=Math.min(minRectTop,rectTop);
        }
    
        let diffX=minUmpleLeft-minRectLeft;
        let diffY=minUmpleTop-minRectTop;
// DEBUG
// Page.catFeedbackMessage("In process of updating nodes from gv diffx="+diffX+" diffy="+diffY+" ");
        // Now loop through the Map updating the Umple code if needed
        var nodesMoved = 0;
        posMap.forEach(function(thePos) {
          const changeThreshold = 10;
          var deltaX= Math.round((thePos.rectCentreX+diffX)-thePos.umpleX);
          var deltaY= Math.round((thePos.rectCentreY+diffY)-thePos.umpleY);
          if(Math.abs(deltaX) > changeThreshold || Math.abs(deltaY) > changeThreshold) {
             // Update Umple text, 
             nodesMoved++;
             Action.updateGVPositionBasic(thePos.className,deltaX,deltaY,
               positioningCode,
               thePos.fullUmplePosOfCurrentClass,
               thePos.left,
               thePos.top,
               thePos.associationPos1,
               thePos.associationPos2,
               false);
// DEBUG
// Page.catFeedbackMessage(" redrawn: "+thePos.className+" //x"+thePos.umpleX+"->"+deltaX+"/"+(thePos.rectCentreX+diffX)
//  +" y"+thePos.umpleY+"->"+deltaY+"/"+(thePos.rectCentreY+diffY));

          }
        });
//DEBUG
//Page.catFeedbackMessage(" Moved "+nodesMoved+" nodes");
        if(algoWasRemoved) {
          // We are coming back from an algo update so we need to push to history
          TabControl.getCurrentHistory().save(Page.getUmpleCode(), "moveClass");
        }
      }

      // generate association/relation mapping - to show neighbor classes from context menu



      const umpleCode=Page.getUmpleCode();
      const lines = umpleCode.split('\n');
      const result = {};
      let currentClass = null;
    
      const classRegex = /^class\s+(\w+)/;
      const assocRegex = /\s*(--\*|--|\*--\*|->|<-)\s*/;
      const isARegex = /^isA\s+([A-Za-z0-9_,\s]+);?/;
    
      for (let i = 0; i < lines.length; i++) {
          const line = lines[i].trim();
    
          // Stop processing at the end marker
          if (line.includes('//$?[End_of_model]$?')) {
            break;
         }
    
          // Detect class definition
          const classMatch = line.match(classRegex);
          if (classMatch) {
            currentClass = classMatch[1];
            if (!result[currentClass]) result[currentClass] = [];
            continue;
          }
    
          // If no class is currently tracked, skip
          if (!currentClass) continue;
    
            // Handle isA line
            const isAMatch = line.match(isARegex);
            if (isAMatch) {
              const isAClasses = isAMatch[1].split(',').map(cls => cls.trim().replace(/[^a-zA-Z0-9_]/g, ''));
              result[currentClass].push(...isAClasses);
              continue;
            }
    
          // Detect association
          const assocSplit = line.split(assocRegex);
          if (assocSplit.length >= 3) {
            const rightPart = assocSplit[2].trim();
            const parts = rightPart.split(/\s+/);
    
            // Usually formatted like: [multiplicity, ClassName, fieldName]
            const classCandidate = parts.length > 1 ? parts[1] : parts[0];
            // Clean up any trailing semicolons or symbols
            const cleanClass = classCandidate.replace(/[^a-zA-Z0-9_]/g, '');
            if (cleanClass) {
              result[currentClass].push(cleanClass);
            }
          }
    
        }

        // Add reverse links (cross-referencing)
        for (const [cls, dependencies] of Object.entries(result)) {
          for (const dep of dependencies) {
            if (!result[dep]){
              result[dep] = [];
            } 
            if(!result[dep].includes(cls)){
              result[dep].push(cls);
            }
          }
        }

        Action.neighbors=result;


      Action.setupPinch();
    }
    // Display generated HTML output in the right-hand canvas area
    else if(Page.useEventSequence || Page.useStateTables)
{
  theCanvas.html("<div id='htmlCanvas' class='generatedDiagram'></div>");
  jQuery("#htmlCanvas").html(diagramCode);

  // Apply the same coloring used by the Generate It path
  if (Page.useStateTables && typeof StateTree !== "undefined" && StateTree.colourStateTables) {
    StateTree.colourStateTables();
  }

  if (Page.useEventSequence && typeof StateTree !== "undefined" && StateTree.colourEventSequences) {
    StateTree.colourEventSequences();
  }
}

    else if(Page.useCRUDUI)
    {
      theCanvas.html("<div id='htmlCanvas' class='generatedDiagram'></div>");
      Page.showCrudFromJson(diagramCode, "", "#htmlCanvas");
    }
    //Display structure diagram
    else if(Page.useStructureDiagram)
    {
      jQuery("#umpleCanvas").html('<svg id="svgCanvas"></svg>');
      eval(diagramCode);
    }   
  }

  //Show the error message
  if(errorMessage != "")
  {
    Page.showGeneratedCode(errorMessage, "diagramUpdate");
  }
  
  Page.hideLoading();

  if (Page.useGvClassDiagram || Page.useGvEntityRelationshipDiagram) {
    GvDiagramEdit.bindClassDiagram(canvasX, canvasY);
  }

  if(Page.useGvStateDiagram){
    GvDiagramEdit.bindStateDiagram();
    //add double click to display menu, issue#2081
    var elems=document.getElementsByClassName("node");
    // Add event listener to Graphviz state nodes for right click
    for(let i=0;i<elems.length;i++){
      elems[i].addEventListener("contextmenu", function(event){
        event.preventDefault();
        Action.drawStateMenu(event);
      });
      // Add event listener for double click, calling the same function as right-click
      elems[i].addEventListener("dblclick", function(event){
        event.preventDefault(); // Prevent the default double-click behavior
        Action.drawStateMenu(event); // Call the same function to display the menu
      });
    }
    elems=document.getElementsByClassName("cluster");
    // Add event listener to Graphviz clusters for right click
    for(let i=0;i<elems.length;i++){
      elems[i].addEventListener("contextmenu", function(event){
        event.preventDefault();
        Action.drawStateMenu(event);
      });
      // Add event listener for double click on clusters, calling the same function as right-click
      elems[i].addEventListener("dblclick", function(event){
        event.preventDefault(); // Prevent the default double-click behavior
        Action.drawStateMenu(event); // Call the same function to display the menu
      });
    }
    var transitionElems = document.getElementsByClassName("edge");

    for (let i = 0; i < transitionElems.length; i++) {
      transitionElems[i].addEventListener("dblclick", function(event) {
        event.preventDefault(); // Prevent the default click behavior
        Action.displayTransitionMenu(event);
    });
    transitionElems[i].addEventListener("contextmenu", function(event) {
        event.preventDefault();
        Action.displayTransitionMenu(event);
    });
    }
  }  

  if(Page.useEventSequence){
    // Give event sequence states and transitions the same code selection as Graphviz state diagram elements
    jQuery("#htmlCanvas .event-sequence-grid").each(function() {
      var heading = jQuery(this).prevAll("h2").first().text().split(" ");
      var rows = jQuery(this).find(".floating-col td");
      var names = [];
      for(var i = 1; i < rows.length; i++) {
        var parentId = parseInt(jQuery(rows[i]).attr("data-parent"));
        names.push((isNaN(parentId) ? "" : names[parentId] + ".") + jQuery(rows[i]).text().replace(/^(- )*/, ""));
        rows[i].setAttribute("onclick", "javascript:Action.stateClicked(\"" + heading[1] + "^*^" + heading[4] + "^*^" + names[i-1] + "\")");
      }
      rows = jQuery(this).next(".event-sequence-list").find("tr");
      for(var i = 1; i < rows.length; i++) {
        var entry = jQuery(rows[i]).find("td")[2];
        entry.setAttribute("onclick", "javascript:Action.stateClicked(\"" + heading[1] + "^*^" + heading[4] + "^*^" + jQuery(entry).text() + "\")");
      }
    });
    jQuery("#htmlCanvas [data-transition]").click(function() {
      Action.transitionClicked(jQuery(this).attr("data-transition"));
    });
  }

  if(Page.useStateTables){
    // Give state table rows the same state identifier and menu as Graphviz state nodes
    jQuery("#htmlCanvas .statetable").each(function() {
      // Composite tables list combinations of concurrent states, not individual states
      if(jQuery(this).parent().prevAll("h3").first().text().indexOf("Composite") == 0) return;
      var heading = jQuery(this).parent().prevAll("h2").first().text().split(" ");
      var rows = jQuery(this).find("tr");
      // In state-state tables the column headings list the same states, in the same order as the rows
      var isStateStateTable = jQuery(this).hasClass("state-statetable");
      var columnHeadings = jQuery(rows[0]).find("td");
      var names = [];
      for(var i = 1; i < rows.length; i++) {
        var entry = jQuery(rows[i]).find("td")[0];
        var parentId = parseInt(jQuery(entry).attr("data-parent"));
        names.push((isNaN(parentId) ? "" : names[parentId] + ".") + jQuery(entry).text().replace(/^(- )*/, ""));
        var stateLink = "javascript:Action.stateClicked(\"" + heading[1] + "^*^" + heading[4] + "^*^" + names[i-1] + "\")";
        var stateEntries = isStateStateTable ? [entry, columnHeadings[i]] : [entry];
        for(var j = 0; j < stateEntries.length; j++) {
          stateEntries[j].setAttribute("href", stateLink);
          stateEntries[j].setAttribute("onclick", stateLink);
          stateEntries[j].addEventListener("contextmenu", function(event){
            event.preventDefault();
            Action.drawStateMenu(event);
          });
          stateEntries[j].addEventListener("dblclick", function(event){
            event.preventDefault();
            Action.drawStateMenu(event);
          });
        }
      }
      // Give transitions the same selection and menu as Graphviz state diagram edges
      jQuery(this).find("[data-transition]").each(function() {
        this.setAttribute("href", "javascript:Action.transitionClicked(\"" + jQuery(this).attr("data-transition") + "\")");
        jQuery(this).click(function() {
          Action.transitionClicked(jQuery(this).attr("data-transition"));
        });
        // Event headings only select because they may represent several transitions.
        if(jQuery(this).hasClass("event-header")) return;
        this.addEventListener("contextmenu", function(event){
          event.preventDefault();
          Action.displayTransitionMenu(event);
        });
        this.addEventListener("dblclick", function(event){
          event.preventDefault();
          Action.displayTransitionMenu(event);
        });
      });
      // Grey (empty) cells add a transition from the state of their row, as in the state diagram
      rows.slice(1).each(function(r) {
        jQuery(this).find("td").slice(1).each(function(c) {
          if(!jQuery(this).text().match(/^\s$/)) return;
          var fromState = heading[1] + "^*^" + heading[4] + "^*^" + names[r];
          var addTransition = function(event){
            event.preventDefault();
            if(!Action.diagramInSync || Page.readOnly) return;
            if(isStateStateTable) {
              // The column is the destination state: same as the Add Transition palette tool
              GvDiagramEdit.commitTransition(fromState, heading[1] + "^*^" + heading[4] + "^*^" + names[c]);
            } else {
              // The column is the event: same as Add Transition in the state menu, with the event filled in
              var range = GvDiagramEdit.findStateRange(GvDiagramEdit.getFullText(), fromState);
              if(!range) return;
              Action.drawInputState("transition", GvDiagramEdit.getFullText().substring(range.start, range.end),
                names[r].split(".").pop(), jQuery(columnHeadings[c+1]).text());
            }
          };
          this.addEventListener("contextmenu", addTransition);
          this.addEventListener("dblclick", addTransition);
        });
      });
    });
  }
}


// Called when a layout algorithm is clicked, in order to unselect the others
// Can also be used to unselect all of them when gvmanual is active and
// we are in the update callback
Action.deactivateSpecialLayoutAlgorithmsExcept = function(onlyAlgoToKeep) {
  var specialAlgos = new Array();
  var didRemove = false;
  specialAlgos.push("gvdot","gvsfdp","gvcirco");

  // If the one to keep is not a special algo such as gvortho then do nothing
  if(onlyAlgoToKeep != null && (! specialAlgos.includes(onlyAlgoToKeep)) ) {
    return false;
  }
 
  // Search for any of the specialAlgos and turn off except the one to keep
  specialAlgos.forEach(function(anAlgo) {
    if(onlyAlgoToKeep == null || anAlgo != onlyAlgoToKeep) {
      jQuery("#button"+anAlgo).prop('checked',false);
      var index = Page.specialSuboptionsActive.indexOf(anAlgo);
      if(index !== -1) {
        // remove an algo that was selected
        Page.specialSuboptionsActive.splice(index,1);
        didRemove = true;
      }
    }
  });
  return didRemove;
}

Action.getRectFromSvgNode = function(node,canvasX, canvasY) {
  var svgRect = node.getBoundingClientRect();
  return {
    left: Math.round(svgRect.left-canvasX),
    top: Math.round(svgRect.top-canvasY),
    // Get the centre of the rectangle as it actually appears
    // as the gv positions are also centre-focused
    centreX: Math.round(svgRect.left-canvasX + (Math.abs(svgRect.width/2))),
    centreY: Math.round(svgRect.top-canvasY  + (Math.abs(svgRect.height/2)))
  };
}

Action.updateFromDiagramCallback = function(response)
{
  var diagramCode = "";
  var errorMessage = "";
  
  diagramCode = Action.getDiagramCode(response.responseText);
  errorMessage = Action.getErrorCode(response.responseText);
  
  if((diagramCode == null || diagramCode == "" || diagramCode == "null") && Action.diagramInSync) 
  {
    Page.enableDiagram(false);
    Action.diagramInSync = false;
    Page.setFeedbackMessage("<a href=\"\#errorClick\">See message.</a> To fix: edit model or click undo");
  }
  else
  {
    Page.enableDiagram(true);
    Action.diagramInSync = true;
  }
  
  //Show the error message
  if(errorMessage != "")
  {
    Action.lastCompilerErrorHtml = errorMessage;
    Page.showGeneratedCode(errorMessage, "diagramUpdate");
  }  
  else
  {
    Action.lastCompilerErrorHtml = "";
  }
}

// Gets the code to display from the AJAX response
Action.getDiagramCode = function(responseText)
{
  var output = "";
  
  // Also want to use the same response for JointJS
  if(Page.useEditableClassDiagram || Page.useJointJSClassDiagram)
  {
    output = responseText.split('URL_SPLIT')[1];
    
    if(output == "null") output = "";
    
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram || Page.useGvUseCaseDiagram || Page.useGvEntityRelationshipDiagram || Page.useInstanceDiagram)
  {
    // The graphviz diagrams are taken from the inner svg tag only. 
    // This allows the website to have a dynamic canvas size around the diagram
    var codeparts = responseText.split('<svg width=');
    
    //Put the start of the svg back together. 
    if(codeparts.length>1 && codeparts[1].length>100) {
      output = "<svg width="+codeparts[1];
      //remove the redundant svg closing tag
      output = output.replace(/<\/svg>$/, "");
    }
  }
  else if(Page.useCRUDUI || Page.useEventSequence || Page.useStateTables)
  {
    var language = Page.useCRUDUI ? "crudJson" :
                   Page.useEventSequence ? "eventSequence" :
                   "stateTables";

    output = Page.getGeneratedMarkup(responseText, language);
  }
  else if(Page.useStructureDiagram)
  {
    output = responseText.split("<p>URL_SPLIT")[1];
    output = output.replace(/##CANVAS_ID##/g, "svgCanvas");
    // Converts html encoded special characters to plaintext
    output = jQuery("<div/>").html(output).text();
  }
  
  return output;
}

// Gets any error code from the AJAX response
Action.getErrorCode = function(responseText)
{
  var output = "";
  if(Page.useEditableClassDiagram || Page.useStructureDiagram)
  {
    output = responseText.split('URL_SPLIT')[0];
    
    if(output == "<p>") output = "";
  }
  else if(Page.useGvClassDiagram || Page.useGvStateDiagram || Page.useGvFeatureDiagram || Page.useGvUseCaseDiagram || Page.useGvEntityRelationshipDiagram || Page.useInstanceDiagram)
  {
    var miscStuffAndErrorMessages = responseText.split('<svg width=')[0];
    var prelimparts = miscStuffAndErrorMessages.split('errorRow');
    if(prelimparts.length > 1) {
      output = miscStuffAndErrorMessages.split("</script>&nbsp;")[0];
    }
  }
  else if(Page.useCRUDUI || Page.useEventSequence || Page.useStateTables)
  {
    var language = Page.useCRUDUI ? "crudJson" :
                   Page.useEventSequence ? "eventSequence" :
                   "stateTables";
    output = Page.getErrorMarkup(responseText, language);
  }
  return output;
}


Action.redrawDiagram = function()
{
    if (typeof GvDiagramEdit !== "undefined") GvDiagramEdit.clearPendingPaletteState();
    UmpleSystem.merge(null);    // Clear the diagram
    var canvas = jQuery("#umpleCanvas");
    canvas.html("");
    if (!Action.manualSync) 
    {
      Action.updateUmpleDiagram();
      Action.diagramInSync = true;
      //Page.enableDiagram(true);
    }
    if (Action.manualSync && !Action.diagramInSync) Page.enablePaletteItem('buttonSyncDiagram', true);
    if (!Action.manualSync || Action.diagramInSync)
    {
      Page.enableCheckBoxItem("buttonPhotoReady", "ttPhotoReady", true);
      Page.enableCheckBoxItem("buttonManualSync", "ttManualSync", true);

      Page.enablePaletteItem('buttonAddClass', true);
      Page.enablePaletteItem('buttonAddState', true);
      Page.enablePaletteItem('buttonAddAssociation', true);
      Page.enablePaletteItem('buttonAddTransition', true);
      Page.enablePaletteItem('buttonAddGeneralization', true);
      Page.enablePaletteItem('buttonDeleteEntity', true);
    
      Page.initToggleTool('buttonAddClass');
      Page.initToggleTool('buttonAddState');
      Page.initToggleTool('buttonAddAssociation');
      Page.initToggleTool('buttonAddTransition');
      Page.initToggleTool('buttonAddGeneralization');
      Page.initToggleTool('buttonDeleteEntity');
    }
}

Action.getLanguage = function() 
{
  var language = "";
  if(Page.useEditableClassDiagram) {language="language=Json";}
    // JointJS receives the full model (class and state machine) in JSON
  else if(Page.useJointJSClassDiagram) {language="language=JsonMixed";}
  else if(Page.useGvClassDiagram) {
    if(Page.showTraits) {
      language="language=traitDiagram";
    }
    else {
      language="language=classDiagram";
    }
  }
  else if(Page.useGvStateDiagram) {language="language=stateDiagram"}
  else if(Page.useGvEntityRelationshipDiagram) {language="language=entityRelationshipDiagram"}
  else if(Page.useGvUseCaseDiagram) {language="language=useCaseDiagram"}
  else if(Page.useStructureDiagram) {language="language=StructureDiagram"}
  else if(Page.useInstanceDiagram) {language="language=instanceDiagram"}
  else if(Page.useCRUDUI) {language="language=Json&languageStyle=crudJson"}
  else if(Page.useStateTables) {language="language=StateTables"}
  else if(Page.useEventSequence) {language="language=eventSequence"}
 
 

  // append any suboptions needed for GvStateDiagram
  if(Page.useGvStateDiagram) { 
    if(!Page.showActions) language=language+".hideactions";
    if(Page.showTransitionLabels) language=language+".showtransitionlabels";
    if(!Page.showGuards) language=language+".hideguards";    
    if(Page.showGuardLabels) language=language+".showguardlabels";
    if(!Page.showNaturalLanguage) language=language+".hidenaturallanguage";
    language=language+"."+$("inputGenerateCode").value.split(":")[1];
  }
  // append any suboptions needed for GvClassDiagram
  if(Page.useGvClassDiagram) { 
    if(Page.showMethods) language=language+".showmethods";
    if(!Page.showAttributes) language=language+".hideattributes";
  }
  // append any suboptions needed for GvFeatureDiagram
  if(Page.useGvFeatureDiagram) {
    language="language=featureDiagram";
    if(Page.showFeatureDependency) language=language+".showFeatureDependency";
  }
  // append the list of words specified in the filterwords
  // Also gather together copyable code to create a mixset from these
  copyableMixset ="";
  if(Page.filterWordsOutput != "") {
    language=language+".!@FW!@"+Page.filterWordsOutput;

    // Grab the words people have typed in manually for use in mixset
    var copyableIncludeStatements = "";
    Page.filterWordsOutput.split("!@").forEach(function(aFilterWord){
      if(aFilterWord != "") {
        // If it is a number then add a hops clause
        if(!isNaN(aFilterWord)) {
          copyableIncludeStatements+="  hops { association "+aFilterWord+";} ";
        }
        // If it starts with gv it is a filter word and if separator needs cleaning
        else if(aFilterWord.substr(0,2) == "gv") {
          if(aFilterWord.substr(0,11) == "gvseparator") {
            copyableMixset+="  suboption \""+aFilterWord.replace("@@@","")+"\";\n";
          }
          else {
            copyableMixset+="  suboption \""+aFilterWord+"\";\n";
          }
        }
        // If it starts with mixset or filter then process as named
        else if(aFilterWord.substr(0,6) == "filter") {
          copyableMixset+="  filter {includeFilter "+aFilterWord.substr(6)+";}\n";
        }
        else if(aFilterWord.substr(0,6) == "mixset") {
          copyableMixset+="  use "+aFilterWord.substr(6)+";\n";        
        }
        // Otherwise process as a filter pattern
        else {
          copyableIncludeStatements+=" include "+aFilterWord+";";
        }
      }
    });
    if(copyableIncludeStatements != "") {
      copyableMixset += "  filter {"+copyableIncludeStatements+"}\n";
    }
  }   
  // append any of the mixsets of filters
  // words in checkboxes that start with filter, followed by a named filter name
  Page.filtersActive.forEach(function(aNamedFilter){
    language=language+".filter"+aNamedFilter;
    copyableMixset+="  filter {includeFilter "+aNamedFilter+";}\n";
  });
  // words in checkboxes that start with mixset, followed by a mixset name
  Page.mixsetsActive.forEach(function(aMixset){
    language=language+".mixset"+aMixset;
    copyableMixset+="  use "+aMixset+";\n";
  });
  // words in checkboxes starting gv  
  Page.specialSuboptionsActive.forEach(function(aSpecialSuboption){
    language=language+"."+aSpecialSuboption;
    copyableMixset+="  suboption \""+aSpecialSuboption+"\";\n";
  });
  // Generate the actual copyable mixset, calling M followed by 3 digits
  var randomMixsetNumber = Math.floor(Math.random() * 899.0 + 100.0);
  Page.copyableMixset="\/\/ The following was generated from the show and hide options\n"
    +"\/\/ Rename the mixset and paste into the code so you can invoke it at any time\n"
    +"mixset M"+randomMixsetNumber+" {\n"+copyableMixset+"}";
  return language;
}
