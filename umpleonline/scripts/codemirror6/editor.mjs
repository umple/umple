import { minimalSetup } from "codemirror"
import { EditorSelection, EditorState, Text, ChangeSet, StateEffect } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { EditorView, ViewPlugin, ViewUpdate, lineNumbers, keymap, Decoration } from "@codemirror/view"
import { receiveUpdates, sendableUpdates, collab, getSyncedVersion } from "@codemirror/collab"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching } from "@codemirror/language"
import { SearchCursor, RegExpCursor } from "@codemirror/search";

function createEditorState(intialContents, options={}) {

  let extensions = [
    minimalSetup, 
    javascript(),
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
    doc: intialContents,
    extensions
  });

  return startState;
}

function createEditorView(state, parent){
  return new EditorView({
    state, parent
  });
}

// a custom plugin to listen for any changes in the code editor
// and update the digram accordingly without triggering any events
const changeListenerPlugin = ViewPlugin.fromClass(class {
  constructor(view) {
    this.view = view;
    this.lastContent = view.state.doc.toString();
  }
  update(update) {
    if (update.docChanged) {
      const newContent = update.state.doc.toString();
      if (newContent !== this.lastContent) {
        // DEBUG
        console.log('Editor content changed...', 'Update the Diagram!');
        this.lastContent = newContent;
        setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);
      }
    }
  }
});


export { createEditorState, createEditorView, 
  EditorSelection, SearchCursor, RegExpCursor, changeListenerPlugin,
  EditorView, ViewPlugin, ViewUpdate, Text, ChangeSet, StateEffect,
  receiveUpdates, sendableUpdates, collab, getSyncedVersion
}
