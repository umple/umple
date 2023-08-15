import { EditorView, basicSetup } from "codemirror"
import { ChangeSet, EditorSelection, EditorState, Text } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { lineNumbers } from "@codemirror/view"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching } from "@codemirror/language"
// import { Text } from "@codemirror/text"
// import {  } from "@codemirror/collab";

function createEditorState(intialContents, options={}) {

  let extensions = [
    basicSetup, 
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

export { createEditorState, createEditorView, EditorSelection, Text,
          ChangeSet } 
