import { basicSetup } from "codemirror"
import { EditorSelection, EditorState, Text, ChangeSet, StateEffect } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { umple } from "./umple.js"
import { EditorView, ViewPlugin, ViewUpdate, lineNumbers, keymap, Decoration } from "@codemirror/view"
import { receiveUpdates, sendableUpdates, collab, getSyncedVersion } from "@codemirror/collab"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching } from "@codemirror/language"
import { SearchCursor, RegExpCursor } from "@codemirror/search";


// Define the custom theme for active line and selection highlighting

const myTheme = EditorView.theme({
  
  ".cm-activeLine": {
    backgroundColor: "#d9d9d977"  // active line color
  },
  ".cm-selectionBackground": {
    backgroundColor: "#edededff" // selection color
  }

});


// Debounce function - to avoid multiple calls when typing
function debounce(func, wait) {
  let timeout;
  return function executedFunction(...args) {
    clearTimeout(timeout);
    timeout = setTimeout(() => func(...args), wait);
  };
}


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

// Debounced action function
const debouncedProcessTyping = debounce((editorName, flag) => {
  Action.processTyping(editorName, flag); // call the action function
}, Action.waiting_time);


// a custom plugin to listen for any changes in the code editor
// and update the digram accordingly without triggering any events
const changeListenerPlugin = ViewPlugin.fromClass(class {
  constructor(view) {
  this.view = view;
  this.lastContent = view.state.doc.toString().trim();
  // this.lastContent = view.state.doc.toString();
  // this.lastContent = view.state.doc.toString().toLowerCase().trim();
  }

  update(update) {
    // console.log('update:', update);

    if (update.docChanged) {
      console.log('Editor updated..');

      // const newContent = update.state.doc.toString();
        // const newContent = update.state.doc.toString().toLowerCase().trim();
      const newContent = update.state.doc.toString().trim();

      if (newContent !== this.lastContent) {
       // if (newContent.localeCompare(this.lastContent) !== 0) {
          console.warn('Content changed');

          //console.warn('new content:', newContent); 
          console.log('new content lenght:', newContent.length);

         // console.warn('old content:', this.lastContent);
          console.log('old content lenght:', this.lastContent.length);

         // console.warn('update:', update);

          // console.log('update lenght:', update.length);
          console.warn('details:', update.changes);
      
      // DEBUG
        // console.log('Editor content changed...', 'Update the Diagram!');
        this.lastContent = newContent;
        //  setTimeout('Action.processTyping("newEditor",' + false + ')', 2500);

        debouncedProcessTyping("newEditor", false); // call the debounced function
      // setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
      }
    }
  }
});


export { createEditorState, createEditorView, 
  EditorSelection, SearchCursor, RegExpCursor, changeListenerPlugin,
  EditorView, ViewPlugin, ViewUpdate, Text, ChangeSet, StateEffect,
  receiveUpdates, sendableUpdates, collab, getSyncedVersion
}
