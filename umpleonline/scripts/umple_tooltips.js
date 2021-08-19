// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Initializes all the tooltips on umpleonline

// This is a dictionary of all the tooltips that are not initialized using the title attribute.
// The are in the following format: 'id: ["tag type", "tooltip HTML"]'
// These tooltips can use full HTML and can be styled using css
var ToolTips = {}

// All custom shortcut types
var undo, redo, toggleTextEditor;

// Some special shortcuts
if (navigator.appVersion.indexOf("Mac")!=-1)
{
  undo = 'cmd-z';
  redo = 'cmd-shift-z';
  toggleTextEditor = 'ctrl-t';
}
else
{
  undo = 'ctrl-z';
  redo = 'ctrl-y';
  toggleTextEditor = 'ctrl-alt-shift-t';
}



ToolTips.tooltipEntries = {
  // save model tooltips
  ttSaveBookmark: ["li", "Click to bookmark this model"],
  ttSaveModel: ["li", "Click to save this model for future editing. After clicking this, you will need to use your browser to bookmark the URL. "],
  buttonCopy: ["li", "Click to open a window containing the plain source for this model"],
  buttonCopyCommandLine: ["li", "Click to copy a sequence of Mac/Linux shell commands that will you can paste into a terminal to create a new directory under ~/tmp, create the umple file there as test.ump and to compile the Umple and resulting Java (with the option to run the java if there is a main program present). You need to install the Java development environment and an 'umple' script for this to work. The Umple script should run 'java -jar umple.jar' with a .ump file as an argument  </br><b>Shortcut: [ctrl-o]</b>"],
  buttonCopyEncodedURL: ["li", "Click to view a url encoded with this model. This works for very small models only. You can send people that URL so they can recreate your model in their browser."],  
  buttonCopyLocalBrowser: ["li", "Click to save the model in in your browser local storage for later reloading using Load from Browser below"],  
  buttonLoadLocalBrowser: ["li", "Click to load the model from what you had previously saved in this browser (above)"],
  buttonDownloadFiles: ["li", "Click to download the currently open .ump files."],
  buttonCreateTask: ["li", "Create a modeling task for participants to try.</br>You will be able to give them some instructions. The model currently appearing here will be their starting point. The instructions could be requirements to model, or changes to make. This can be for an experiment or a course assignment."],
  buttonLoadTask: ["li", "Load a model and a set of instructions that have been created by someone running an experiment or a teacher of a course. You need to enter the task name that the person gave you."],
  buttonRequestAllZip: ["li", "Create a zip file to download, containing all submissions for this task."],
  ttDropboxSaver: ["li", "Click to save your model to dropbox"],

  // start over tooltips
  ttStartOver: ["li", "Click to clear the text editor and the diagram"],

  // load example tooltips
  ttDropboxChooser: ["li", "Click to load an example from dropbox"],

  // diagram editing tools tooltips
  buttonAddClass: ["li", "Click the diagram to add a class </br><b>Shortcut: [c]</b>"],
  buttonAddAssociation: ["li", "Click on two classes to create an association </br><b>Shortcut: [a]</b>"],
  buttonAddGeneralization: ["li", "Click on two classes to create a generalization </br><b>Shortcut: [g]</b>"],
  buttonDeleteEntity: ["li", "Click on a class, association, or generalization to delete that entity </br><b>Shortcut: [DEL]</b>"],
  buttonUndo: ["li", "Click to undo the most recent action </br><b>Shortcut: [" + undo + "]</b>"],
  buttonRedo: ["li", "Click to redo the most recent undone action </br><b>Shortcut: [" + redo + "]</b>"],
  buttonReindent: ["li", "Click this to adjust the text so that blocks marked by { and } have their contents indented by 2 spaces"],
  buttonSyncDiagram: ["li", "Click to sync the diagram and the text"],

  // code generation tooltip
  ttGeneratedCodeType: ["li", "Choose the language or diagram to generate"],
  ttGenerateCode: ["li", "Click this button to generate the above code or diagram"],

  // show/hide elements tooltips
  ttShowHideCanvas: ['li', "Show/Hide the diagram </br><b>Shortcut: [ctrl+d]</b>"],
  ttShowHideTextEditor: ['li', "Show/Hide the text editor </br><b>Shortcut: [" + toggleTextEditor + "]"],
  ttShowHideLayoutEditor: ['li', "Show/Hide the layout editor"],
  ttToggleAttributes: ['li', "Show/Hide attributes in class diagrams </br><b>Shortcut: [shift+ctrl+a]</b>"],
  ttToggleMethods: ['li', "Show/Hide methods in class diagrams </br><b>Shortcut: [ctrl+m]</b>"],
  ttToggleTraits: ['li', "Show/Hide traits; when selected any traits and their relationships are explicitly shown; when unselected, traits are merged into their client classes </br><b>Shortcut: [ctrl+r]</b>"],
  ttToggleActions: ['li', "Show/Hide actions in state diagrams (hide to simplify)"],
  ttToggleGuards: ['li', "Show/Hide guards in state diagrams (hide to simplify)"],
  ttToggleTransitionLabels: ['li', "Show/Hide transition labels in state diagrams (t1, t2 etc.) to allow reference"],
  ttToggleGuardLabels: ['li', "Show/Hide guard labels on the state diagrams (g1, g2 etc.) to allow reference"],
  SHT_button: ['a', "Show/Hide the text editor - <b>" + toggleTextEditor +"</b>" ],
  SHD_button: ['a', "Show/hide diagram pane on right - <b> ctrl-D</b>"],
  SHA_button: ['a', "Show/hide attributes in class diagrams - <b>shift-ctrl-A</b>"],
  SHM_button: ['a', "Show/hide methods in class diagrams - <b>ctrl-M</b>"],
  

  // diagram type tooltips
  ttShowEditableClassDiagram: ["li", "Display a graphically editable class diagram </br><b>Shortcut: [ctrl+e]</b>"],
  ttShowJointJSClassDiagram: ["li", "Display a prettier graphically editable class diagram </br><b>Shortcut: [ctrl+j]</b>"],
  ttShowGvClassDiagram: ["li", "Display a class diagram rendered using GraphViz </br><b>Shortcut: [ctrl+g]</b>"],
  ttShowGvStateDiagram: ["li", "Display a state diagram rendered using GraphViz</br><b>Shortcut: [ctrl+s]</b>"],
  ttShowStructureDiagram: ["li", "Display a graphically editable composite structure diagram </br><b>Shortcut: [ctrl+l]</b>"],
  ECD_button: ['a', "Editable class diagram - <b>ctrl-E</b>"],
  GCD_button: ['a', "Graphviz class diagram - <b>ctrl-G</b>"],
  SD_button: ['a', "State diagram - <b>ctrl-S</b>"],

  // preferences tooltips
  ttPhotoReady: ["li", "Remove editing handles from diagram"],
  ttManualSync: ["li", "Stop the diagram from syncing automatically"],
  ttAllowPinch: ["li", "When active on GraphViz diagrams, this allows two-fingered gestures to zoom the diagram in or out to make it have any desired resolution and size (but prevents the entire browser from being zoomed in this manner)"],

  // other views tooltips
  ttYumlImage: ["li", "Generate a class diagram using Yuml in another window"]
};


ToolTips.initTooltips = function()
{  
  // Initialize the tooltips in the above tooltip dictionary
  for(var id in this.tooltipEntries)
  {
  //Special cases
    if (id=="SD_button"||id=="GCD_button"||id=="ECD_button"||id=="SHT_button"||id=="SHD_button"||id=="SHA_button"||id=="SHM_button") {
      jQuery("#" + id).tooltip({
        items: this.tooltipEntries[id][0],
        content: this.tooltipEntries[id][1],
        show: {delay: 1000},
        position: {my:"left top+25%", of:"#"+id}
        });
    }
    else{
      jQuery("#" + id).tooltip({
        items: this.tooltipEntries[id][0],
        content: this.tooltipEntries[id][1],
        show: {delay: 1000},
        position: {my:"right", at:"left", of:"#"+id}
      });
      }
  }

  //Special cases

  //Sets the example dropdown menus tooltip so it does not collide with the
  //contents of the dropdown list
  dropDownTooltips = {
    exampleType: ["li", "Choose an example type to load"],
    itemLoadExamples: ["li", "Choose a class diagram example to load"],
    itemLoadExamples2: ["li", "Choose a state diagram example to load"],
    itemLoadExamples3: ["li", "Choose a composite structure diagram example to load"]
  }

  for(id in dropDownTooltips)
  {
    jQuery("#" + id).tooltip({
      items: dropDownTooltips[id][0],
      content: dropDownTooltips[id][1],
      show: {delay: 1000},
      position: {my:"center+15% bottom", at:"top", of:"#"+id}
    });
  }

  // Sets the rest of the tooltips using the styling provided by the jQuery style.
  // These tooltips use the title attribute as the content
  jQuery(document).tooltip({show: {delay: 1000}});
}
