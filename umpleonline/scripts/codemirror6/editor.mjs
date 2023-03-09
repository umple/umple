import { EditorView, basicSetup, minimalSetup } from "codemirror"
import { EditorState, StateField } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { lineNumbers, keymap } from "@codemirror/view"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching } from "@codemirror/language"

// Define StateField
const listenChangesExtension = StateField.define({
  // we won't use the actual StateField value, null or undefined is fine
  create: () => null,
  update: (value, transaction) => {
    if (transaction.docChanged) {
      // access new content via the Transaction
      // console.log(transaction.newDoc.toJSON());
      console.log("Contents changed in codemirror 6 editor")
    }
    return null;
  },
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

// let updateListenerExtension = EditorView.updateListener.of((update) => {
//   if (update.docChanged) {
//     // Handle the event here
//     Page.codeMirrorEditor6.dispatch({ changes: { from: 0, 
//       to: Page.codeMirrorEditor6.state.doc.length, 
//       insert:  document.getElementById("umpleModelEditorText").value } })
//   }
// });

// extensions = [updateListenerExtension]/* Add your other extensions */
// const nextState = cm6.createEditorState(
// document.getElementById("umpleModelEditorText").value, {extraKeys, extensions});


export { createEditorState, createEditorView, createKeyMap, listenChangesExtension } 
