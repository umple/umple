import { basicSetup } from "codemirror"
import { EditorSelection, EditorState, Text, ChangeSet, StateEffect, Compartment } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { umple } from "./umple.js"
import { EditorView, ViewPlugin, ViewUpdate, lineNumbers, keymap, Decoration } from "@codemirror/view"
import { receiveUpdates, sendableUpdates, collab, getSyncedVersion } from "@codemirror/collab"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching } from "@codemirror/language"
import { SearchCursor, RegExpCursor } from "@codemirror/search";


const debuggerFlag = false;

// Create a compartment for editable state
const editableCompartment = new Compartment();

// Define the custom theme for active line and selection highlighting

const myTheme = EditorView.theme({
  
  ".cm-activeLine": {
    backgroundColor: "#d9d9d977"  // active line color
  },
  ".cm-selectionBackground": {
    backgroundColor: "#edededff" // selection color
  }

});



function createEditorState(initialContents, options={}) {
  
  let extensions = [
    basicSetup,
    umple(),
    myTheme,
    lineNumbers(),
    bracketMatching(),
    syntaxHighlighting(defaultHighlightStyle, { fallback: true }),
    EditorView.lineWrapping,
    EditorView.domEventHandlers({
      keydown(e, view) {
      }
    }),
    editableCompartment.of(EditorView.editable.of(true)),
  ]
  
  let startState = EditorState.create({
    // Use the textarea's value as the initial text for CodeMirror
    doc: initialContents,
    extensions
  });
  
  return startState;
}

function createEditorView(state, parent){
  return new EditorView({
    state, parent
  });
}


// Debounce function - to avoid multiple calls when typing
function debounce(func, wait) {
  let timeout;
  return function executedFunction(...args) {
    clearTimeout(timeout);
    timeout = setTimeout(() => func(...args), wait);
  };
}


// Debounced action function
const debouncedProcessTyping = debounce((editorName, flag, currentPositionofCursor) => {
  Action.processTyping(editorName, flag, currentPositionofCursor); // call the action function
}, Action.waiting_time);


// a custom plugin to listen for any changes in the code editor
// and update the digram accordingly without triggering any events
const changeListenerPlugin = ViewPlugin.fromClass(class {
  constructor(view) {
  this.view = view;

  // We cannot use trim() here since we use Enter to go to the next line;
  this.lastContent = view.state.doc.toString();


  // Dispatch a change to the view

  }

  update(update) {
    // console.log('update:', update);
    
    if (update.docChanged) {
      if (debuggerFlag)
      console.log('Editor updated..');
        
        const newContent = update.state.doc.toString();
        
        if (newContent !== this.lastContent) {
        const currentPositionofCursor = this.view.state.selection.main.head;
       // if (newContent.localeCompare(this.lastContent) !== 0) {

        if (debuggerFlag)   
       console.warn('Content changed');

        //console.warn('new content:', newContent); 
        if (debuggerFlag)
        console.log('new content lenght:', newContent.length);

        // console.warn('old content:', this.lastContent);
        if (debuggerFlag)
        console.log('old content lenght:', this.lastContent.length);

        // console.warn('update:', update);

        // console.log('update lenght:', update.length);
        if (debuggerFlag)
        console.warn('details:', update.changes);
      
      // DEBUG
        // console.log('Editor content changed...', 'Update the Diagram!');
        this.lastContent = newContent;

        debouncedProcessTyping("newEditor", false ,currentPositionofCursor); // call the debounced function

        // // Use setTimeout to avoid the update-in-progress error
        // setTimeout(() => {
        //   this.view.dispatch({
        //     selection: EditorSelection.single(currentPositionofCursor)
        //   });

        // }, 0); // This will schedule the execution in the next event loop cycle


      // setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
      }
    }
    Action.updateLineNumberDisplay();
  }

  
});


export { createEditorState, createEditorView, 
  EditorSelection, SearchCursor, RegExpCursor, changeListenerPlugin,
  EditorView, ViewPlugin, ViewUpdate, Text, ChangeSet, StateEffect,
  receiveUpdates, sendableUpdates, collab, getSyncedVersion, Compartment,editableCompartment
}
