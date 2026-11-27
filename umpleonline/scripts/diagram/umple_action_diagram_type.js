// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Actions for switching between diagram types, and the Live View selector

Action.changeDiagramType = function(newDiagramType)
{
  // If we’re already in the requested mode, return
  if (newDiagramType.type === "editableClass" && Page.useEditableClassDiagram) return;
  if (newDiagramType.type === "JointJSClass"  && Page.useJointJSClassDiagram) return;
  if (newDiagramType.type === "GvClass"       && Page.useGvClassDiagram) return;
  if (newDiagramType.type === "GvState"       && Page.useGvStateDiagram) return;
  if (newDiagramType.type === "GvFeature"     && Page.useGvFeatureDiagram) return;
  if (newDiagramType.type === "GvUseCase"     && Page.useGvUseCaseDiagram) return;
  if ((newDiagramType.type === "GvEntity" || newDiagramType.type === "GvEntityRelationshipDiagram") && Page.useGvEntityRelationshipDiagram) return;
  if (newDiagramType.type === "structure"     && Page.useStructureDiagram) return;
  if (newDiagramType.type === "stateTables"   && Page.useStateTables) return;

  Page.unselectAllToggleTools();
  var changedType = false;
  jQuery(".layoutListItem").hide();
  // reset show state
  FeatureTreeModal.hidePaletteSection();

  if(newDiagramType.type === "editableClass") {
    if(Page.useEditableClassDiagram) return;
    Page.useEditableClassDiagram = true;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useGvUseCaseDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvEntityRelationshipDiagram = false;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = false;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowEditableClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('editableClass');
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();

  }
  else if(newDiagramType.type === "JointJSClass") {
    if(Page.useJointJSClassDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = true;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useGvUseCaseDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvEntityRelationshipDiagram = false;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = false;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowJointJSClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('JointJSClass');
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();
  }  
  else if(newDiagramType.type === "GvClass") {
    if(Page.useGvClassDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = true;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useGvUseCaseDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvEntityRelationshipDiagram = false;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = false;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowGvClassDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvClass');
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();
  }

  else if(newDiagramType.type === "GvEntity" || newDiagramType.type === "GvEntityRelationshipDiagram") {
    if(Page.useGvEntityRelationshipDiagram) return;
    Page.useGvClassDiagram = false;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useGvUseCaseDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvEntityRelationshipDiagram = true;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = false;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowGvEntityRelationshipDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('none');
    jQuery(".view_opt_class").show();
    jQuery(".view_opt_class_palette").show();
    Page.initExamples();

  }

  else if(newDiagramType.type === "GvState") {
    if(Page.useGvStateDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = true;
    Page.useStructureDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useGvUseCaseDiagram = false;
    Page.useGvEntityRelationshipDiagram = false;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = false;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowGvStateDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvState');
    jQuery(".view_opt_state").show();

  }
  else if(newDiagramType.type === "GvFeature") {
   if(Page.useGvFeatureDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvFeatureDiagram = true;
    Page.useGvUseCaseDiagram = false;
    Page.useGvEntityRelationshipDiagram = false;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = false;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowGvFeatureDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('GvFeature');
    jQuery(".view_opt_feature").show();
    FeatureTreeModal.showPaletteSection();
  }
  else if(newDiagramType.type === "GvUseCase") {
    if(Page.useGvUseCaseDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useGvUseCaseDiagram = true;
    Page.useGvEntityRelationshipDiagram = false;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = false;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowGvUseCaseDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('none');
  }
  else if(newDiagramType.type === "structure") { // Structure Diagram
    if(Page.useGvStructureDiagram) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = true;
    Page.useGvFeatureDiagram = false;
    Page.useGvUseCaseDiagram = false;
    Page.useGvEntityRelationshipDiagram = false;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = false;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowStructureDiagram").prop('checked', 'checked');
    Page.setDiagramTypeIconState('structure');
  }

  else if(newDiagramType.type === "instanceDiagram") {
    if(Page.useInstanceDiagram) return;
     Page.useEditableClassDiagram = false;
     Page.useJointJSClassDiagram = false;
     Page.useGvClassDiagram = false;
     Page.useGvStateDiagram = false;
     Page.useStructureDiagram = false;
     Page.useGvFeatureDiagram = false;
     Page.useGvUseCaseDiagram = false;
     Page.useGvEntityRelationshipDiagram = false;
     Page.useInstanceDiagram = true;
     Page.useCRUDUI = false;
     Page.useStateTables = false;
     Page.useEventSequence = false;
     changedType = true;
     jQuery("#buttonShowInstanceDiagram").prop('checked', 'checked');
     Page.setDiagramTypeIconState('none');
     jQuery(".view_opt_feature").show();
 
 
   }

  else if(newDiagramType.type === "crudUI"){
   if(Page.useCRUDUI) return;
    Page.useEditableClassDiagram = false;
    Page.useJointJSClassDiagram = false;
    Page.useGvClassDiagram = false;
    Page.useGvStateDiagram = false;
    Page.useStructureDiagram = false;
    Page.useGvFeatureDiagram = false;
    Page.useGvUseCaseDiagram = false;
    Page.useGvEntityRelationshipDiagram = false;
    Page.useInstanceDiagram = false;
    Page.useCRUDUI = true;
    Page.useStateTables = false;
    Page.useEventSequence = false;
    changedType = true;
    jQuery("#buttonShowCRUDUI").prop('checked', 'checked');
    Page.setDiagramTypeIconState('none');
    jQuery(".view_opt_feature").show();
}

   else if(newDiagramType.type === "stateTables"){
    if(Page.useStateTables) return;
     Page.useEditableClassDiagram = false;
     Page.useJointJSClassDiagram = false;
     Page.useGvClassDiagram = false;
     Page.useGvStateDiagram = false;
     Page.useStructureDiagram = false;
     Page.useGvFeatureDiagram = false;
     Page.useGvUseCaseDiagram = false;
     Page.useGvEntityRelationshipDiagram = false;
     Page.useInstanceDiagram = false;
     Page.useCRUDUI = false;
     Page.useStateTables = true;
     Page.useEventSequence = false;
     changedType = true;
     jQuery("#buttonShowStateTables").prop('checked', 'checked');
     Page.setDiagramTypeIconState('none');
     jQuery(".view_opt_feature").show();
     // Only adding states applies to state tables; their empty cells add transitions
     jQuery("#buttonAddState").show();
   }

   else if(newDiagramType.type === "eventSequence"){
    if(Page.useEventSequence) return;
     Page.useEditableClassDiagram = false;
     Page.useJointJSClassDiagram = false;
     Page.useGvClassDiagram = false;
     Page.useGvStateDiagram = false;
     Page.useStructureDiagram = false;
     Page.useGvFeatureDiagram = false;
     Page.useGvUseCaseDiagram = false;
     Page.useGvEntityRelationshipDiagram = false;
     Page.useInstanceDiagram = false;
     Page.useCRUDUI = false;
     Page.useStateTables = false;
     Page.useEventSequence = true;
     changedType = true;
     jQuery("#buttonShowEventSequence").prop('checked', 'checked');
     Page.setDiagramTypeIconState('none');
     jQuery(".view_opt_feature").show();
   }
  if (changedType) {
    Action.redrawDiagram();
  }
}

Action.setLiveView = function(viewNameToSet)
{
  Page.catFeedbackMessage("DEBUG:"+viewNameToSet);
  if (viewNameToSet=="ecd") { Page.clickShowEditableClassDiagram(); }
  else if (viewNameToSet=="gcd") { Page.clickShowGvClassDiagram(); }
  else if (viewNameToSet=="sd") { Page.clickShowGvStateDiagram(); }
  else if (viewNameToSet=="std") { Page.clickShowStructureDiagram();}
  else if (viewNameToSet=="erd") { Page.clickShowGvEntityRelationshipDiagram();}
  else if (viewNameToSet=="gfd") { Page.clickShowGvFeatureDiagram();}
  else if (viewNameToSet=="gucd") { Page.clickShowGvUseCaseDiagram();}
  else if (viewNameToSet=="instanceDiagram") {Page.clickShowInstanceDiagram();}
  else if (viewNameToSet == "crudUI") { Page.clickShowCRUDUI();}
  else if (viewNameToSet == "stateTables") { Page.clickShowStateTables();}
  else if (viewNameToSet == "eventSequence") { Page.clickShowEventSequence();}
  else Page.catFeedbackMessage("DEBUG bad selection!!!");
}



Action.syncLiveViewSelector = function(viewCode) {
  var selector = document.getElementById("liveViewSelector");
  if (selector) {
    selector.value = viewCode;
  }
};

// --- Live View visibility helpers ---
// Requirement: if Diagram (D) is off, Live View control disappears;
// it reappears when D is on again.
Action.setLiveViewMenuVisible = function(isVisible) {
  try {
    var $selector = jQuery("#liveViewSelector");
    if ($selector.length === 0) return;

    //Prefer an explicit wrapper if present.
    var $wrapper = jQuery("#liveViewWrapper, #liveViewContainer, .liveViewContainer").filter(function() {
      return jQuery(this).find("#liveViewSelector").length > 0;
    }).first();

    //Otherwise, use the smallest nearby container that looks like the Live View control.
    if ($wrapper.length === 0) {
      $wrapper = $selector.parents("span,div").filter(function() {
        var txt = (jQuery(this).text() || "").toLowerCase();
        return txt.indexOf("live view") !== -1 && jQuery(this).find("#liveViewSelector").length > 0;
      }).first();
    }

    // If we found a safe wrapper, hide/show it (label + select together).
    if ($wrapper.length > 0) {
      $wrapper.toggle(!!isVisible);
      return;
    }

    // Fallback: hide/show the selector + any associated label.
    $selector.toggle(!!isVisible);
    var $label = jQuery("label[for='liveViewSelector'], #liveViewLabel");
    if ($label.length) $label.toggle(!!isVisible);
  } catch (e) {
    // Fail silently; do not break the UI if DOM differs.
  }
};

Action.updateLiveViewVisibility = function() {
  // Diagram visibility is tracked by Page.showCanvas in UmpleOnline.
  // When D is toggled, Page.showCanvas flips true/false.
  var diagramVisible = !!Page.showCanvas;
  Action.setLiveViewMenuVisible(diagramVisible);
};

// Ensure Live View visibility is correct on initial page load.
jQuery(function() {
  if (typeof Action.updateLiveViewVisibility === "function") {
    Action.updateLiveViewVisibility();
  }
});
