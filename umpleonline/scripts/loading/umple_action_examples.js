// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for loading example models and the blank model

Action.loadBlankModel = function()
{
  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode="); //left empty
}

Action.setExampleType = function setExampleType()
{
  // Hide them all first
  jQuery("#itemLoadExamples").hide();
  jQuery("#itemLoadExamples2").hide();
  jQuery("#itemLoadExamples3").hide();
  jQuery("#itemLoadExamples4").hide();
  jQuery("#itemLoadExamples5").hide();
  jQuery("#itemLoadExamples6").hide();
  jQuery("#itemLoadExamples7").hide();
  jQuery("#itemLoadExamples8").hide();

     
  if(Page.getExampleType() == "cdModels") {
     jQuery("#itemLoadExamples").show();
     jQuery("#defaultExampleOption").prop("selected",true);
   }
   else if(Page.getExampleType() == "smModels") {
     jQuery("#itemLoadExamples2").show();
     jQuery("#defaultExampleOption2").prop("selected",true);
   }
   else if(Page.getExampleType() == "featureModels") {
     jQuery("#itemLoadExamples4").show();
     jQuery("#defaultExampleOption4").prop("selected",true);
   }
   else if(Page.getExampleType() == "extra1ModelsAD") {
     jQuery("#itemLoadExamples5").show();
     jQuery("#defaultExampleOption5").prop("selected",true);
   }
   else if(Page.getExampleType() == "extra1ModelsEL") {
     jQuery("#itemLoadExamples6").show();
     jQuery("#defaultExampleOption6").prop("selected",true);
   }
   else if(Page.getExampleType() == "extra1ModelsMP") {
     jQuery("#itemLoadExamples7").show();
     jQuery("#defaultExampleOption7").prop("selected",true);
   }
   else if(Page.getExampleType() == "extra1ModelsQZ") {
     jQuery("#itemLoadExamples8").show();
     jQuery("#defaultExampleOption8").prop("selected",true);
   }
   else {
     jQuery("#itemLoadExamples3").show();
     jQuery("#defaultExampleOption3").prop("selected",true);
   }   
}

Action.loadExample = function loadExample()
{
  var requestDiagramType = this.dataset['diagramType'];
  var $option = jQuery(' option:selected', this);
  if ($option.hasClass('openUmprOption')) {
    // user wants to open the umpr repository
    location.href = "http://umple.org/umpr?diagram-type=" + diagramType;
    return;
  }

  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  Ajax.sendRequest("scripts/compiler.php",Action.loadExampleCallback,"exampleCode=" + Page.getSelectedExample());
  var exampleName = Page.getSelectedExample().slice(0,-4);
  var diagramType="";
  if(Page.useGvStateDiagram) {
    diagramType="&diagramtype=state";
    Action.setLiveView("sd");
  }
 else if(Page.useGvFeatureDiagram) {
    diagramType="&diagramtype=GvFeature";
    Action.setLiveView("gfd");
  }
  else if(Page.useGvUseCaseDiagram) {
    diagramType="&diagramtype=GvUseCase";
    Action.setLiveView("gucd");
  }

  else if(Page.useGvEntityRelationshipDiagram) {
    diagramType="&diagramtype=entityRelationshipDiagram";
    Action.setLiveView("erd");
  }

  else if(Page.useInstanceDiagram) {
    diagramType="&diagramtype=instanceDiagram";
    Action.setLiveView("instanceDiagram");
  }


  else if(Page.useStateTables) {
    diagramType="&diagramtype=StateTables";
    Action.setLiveView("stateTables");
  }

  else if(Page.useEventSequence) {
    diagramType="&diagramtype=eventSequence";
    Action.setLiveView("eventSequence");
  }
  else if(Page.useStructureDiagram) {
    diagramType="&diagramtype=structure&generateDefault=cpp";
    Action.setLiveView("std");
  }
  else {
    diagramType="&diagramtype=GvClass";
    if (typeof Action.setLiveView === "function") {
    // This calls the logic we already have in diagram/umple_action_diagram_type.js
    Action.setLiveView("gcd");
    //jQuery("#genjava").prop("selected",true);
    }
  }
  
  var largerSelector = "#buttonLarger";
  var smallerSelector = "#buttonSmaller";
  var canvasSelector = "#" + Page.umpleCanvasId();
  
  umpleCanvasWidth = jQuery(canvasSelector).width();
  umpleCanvasHeight = jQuery(canvasSelector).height();

  var shortExampleName, newURL;
  if (exampleName.startsWith("https")) {
    shortExampleName=exampleName.split("/").pop();
    newURL="?filename="+exampleName.substr(8)+".ump"+diagramType;
  }
  else
  {
    shortExampleName=exampleName;
    newURL="?example="+shortExampleName+diagramType;
  }
    // COMMENTED OUT SUBJECT TO INVESTIGATION
    // Page.setSelectExample(shortExampleName + ".ump");
    // window.history.pushState({}, "", newURL);

    setTimeout(function () { // Delay so it doesn't get erased
    Page.setExampleMessage("<a href=\""+newURL+"\">URL for "+shortExampleName+" example</a>");
  }, 3000);
  
  // TODO - fix so history works nicely           
  jQuery("#inputExample").blur();
}

Action.loadExampleCallback = function(response)
{
  Action.freshLoad = true;
  Action.setjustUpdatetoSaveLater(true);
  
  //Update the code editor
  Page.setUmpleCode(response.responseText, function(){
    Page.hideLoading();
    Action.updateUmpleDiagram();
  }, true);
 
  Action.setCaretPosition("0");
  Action.updateLineNumberDisplay();
  TabControl.getCurrentHistory().save(response.responseText, "loadExampleCallback");
};
