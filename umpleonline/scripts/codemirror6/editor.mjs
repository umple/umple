// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license

// This file is used to create the code editor using CodeMirror 6
// It also contains the custom theme and the custom plugin to listen for changes in the editor
// It also have the debounced function to process the typing in the editor

import { basicSetup } from "codemirror"
import { EditorSelection, EditorState, Text, ChangeSet, StateEffect, Compartment } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { umple } from "./umple.js"
import { EditorView, ViewPlugin, ViewUpdate, lineNumbers, keymap, Decoration } from "@codemirror/view"
import { receiveUpdates, sendableUpdates, collab, getSyncedVersion } from "@codemirror/collab"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching, HighlightStyle } from "@codemirror/language"
import { SearchCursor, RegExpCursor } from "@codemirror/search";
import {tags} from "@lezer/highlight";


const codemirrorDebuggerFlag = false;

// Create a compartment for editable state
const editableCompartment = new Compartment();

// Code keyword highlighting style
const myHighlightStyle = HighlightStyle.define([
  {tag: tags.typeName, color: "#9FCF63"}, // Green
  {tag: tags.string, color: "#EB5F66"}, // Red
  {tag: tags.lineComment, color: "#8F94A0"}, // Gray
  {tag: tags.blockComment, color: "#B8922F"}, // Brown
  {tag: tags.definitionKeyword, color: "#BA90E1"}, // Purple
  {tag: tags.literal, color: "#BA90E1"}, // Purple
  {tag: tags.keyword, color: "#306FBA"}, // Dark Blue
  {tag: tags.heading, color: "#4FADEA"}, // Light Blue
  {tag: tags.heading1, color: "#EA32D4"}, // Pink
  {tag: tags.integer, color: "#009909"}, // Dark Green

  {tag: tags.atom, color: "#EA983F"} // Test Orange
]);

// Define the custom theme for active line and selection highlighting
const myTheme = EditorView.theme({
  
  ".cm-activeLine": {
    backgroundColor: "#e9e9e977"  // active line color
  },
  ".cm-selectionBackground": {
    backgroundColor: "#edededff" // selection color
  }

});

// Function to create the editor state
function createEditorState(initialContents, options={}) {
  
  let extensions = [
    basicSetup,
    umple(),
    myTheme,
    lineNumbers(),
    bracketMatching(),
    syntaxHighlighting(defaultHighlightStyle, { fallback: true }),
    syntaxHighlighting(myHighlightStyle),
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
    
    if (update.docChanged) {
      // Debug: Check if the editor is updated
      if (codemirrorDebuggerFlag)
      console.log('Editor updated..');
        
        const newContent = update.state.doc.toString();
        
        if (newContent !== this.lastContent) {
        const currentPositionofCursor = this.view.state.selection.main.head;

        // Debug: Check if the content has changed
        if (codemirrorDebuggerFlag) {
          console.warn('Content changed');
          console.log('new content lenght:', newContent.length);
          console.log('old content lenght:', this.lastContent.length);
          console.warn('details:', update.changes);
        }  

        this.lastContent = newContent;

        debouncedProcessTyping("newEditor", false ,currentPositionofCursor); // call the debounced function
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
