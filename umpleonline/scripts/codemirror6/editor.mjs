import { EditorView, basicSetup, minimalSetup } from "codemirror"
import { EditorState, StateEffect, StateField } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { lineNumbers, keymap, Decoration } from "@codemirror/view"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching } from "@codemirror/language"
import { RegExpCursor } from "@codemirror/search";

var CM6Data = new Object();
CM6Data.codeMirror6UmpleText="";

function getCodeMirror6UmpleText() {
  return CM6Data.codeMirror6UmpleText;
}

// Define StateField
const listenChangesExtension = StateField.define({
  // we won't use the actual StateField value, null or undefined is fine
  create: () => null,
  update: (value, transaction) => {
    if (transaction.docChanged) {
      // access new content via the Transaction
      CM6Data.codeMirror6UmpleText = transaction.newDoc.toString();
      // console.log("Contents changed in codemirror 6 editor: "
      //  +CM6Data.codeMirror6UmpleText);
    }
    return null;
  },
});

// highlight lines logic
const addLineHighlight = StateEffect.define();
const lineHighlightMark = Decoration.line({
  attributes: {style: 'background-color: yellow'},
});
const lineHighlightExtension = StateField.define({
  create() {
    return Decoration.none;
  },
  update(lines, tr) {
    lines = lines.map(tr.changes);
    for (let e of tr.effects) {
      if (e.is(addLineHighlight)) {
        lines = Decoration.none;
        lines = lines.update({add: [lineHighlightMark.range(e.value)]});
      }
    }
    return lines;
  },
  provide: (f) => EditorView.decorations.from(f),
});

function createEditorState(intialContents, options={}) {

  let extensions = [
    basicSetup, 
    javascript(),
    lineNumbers(),
    bracketMatching(),
    syntaxHighlighting(defaultHighlightStyle, { fallback: true }),
    EditorView.domEventHandlers({
      keydown(e, view) {
        // console.log("change: ", e)
      }
    }),
    listenChangesExtension,
    lineHighlightExtension,
    // keymap.of(options.extraKeys)
    ...options.extensions
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
  // console.log("Code as Text: ", Text.of(code))
  return new RegExpCursor(code, queryString);
}

export { createEditorState, createEditorView, createKeyMap, listenChangesExtension, getCodeMirror6UmpleText, CM6Data, 
  lineHighlightExtension, addLineHighlight, lineHighlightMark, getRegExpCursorCM6 } 
