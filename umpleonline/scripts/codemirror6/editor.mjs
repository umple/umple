import { EditorView, basicSetup, minimalSetup } from "codemirror"
import { EditorSelection, EditorState, StateEffect, StateField } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { lineNumbers, keymap, Decoration } from "@codemirror/view"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching } from "@codemirror/language"
import { SearchCursor, RegExpCursor } from "@codemirror/search";
import { Text } from "@codemirror/text"

var CM6Data = new Object();
CM6Data.codeMirror6UmpleText="";

function getCodeMirror6UmpleText() {
  return CM6Data.codeMirror6UmpleText;
}

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

function createKeyMap(key, operation){
  return keymap.of([{
    key,
    run() {
      return operation();
    }
  }])
}

function getRegExpCursorCM6(code, queryString){
  console.log("Inside getRegExpCursorCM6: ")
  let codeParts = code.toJSON();
  // console.log("code to search in: ", codeParts)
  // console.log("code type: ", typeof codeParts)
  // console.log("queryString: ", queryString)
  // console.log("queryString type: ", typeof queryString)
  let cursor = new RegExpCursor(Text.of(codeParts), queryString);
  return cursor.next();
}

export { createEditorState, createEditorView, createKeyMap, getCodeMirror6UmpleText, CM6Data, 
  getRegExpCursorCM6, EditorSelection, SearchCursor, RegExpCursor, Text } 
