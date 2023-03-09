import {basicSetup} from 'codemirror';
import {EditorState, StateField, StateEffect} from '@codemirror/state';
import { javascript } from "@codemirror/lang-javascript"
import {EditorView, Decoration} from '@codemirror/view';
import { lineNumbers, keymap } from "@codemirror/view"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching } from "@codemirror/language"

const addLineHighlight = StateEffect.define();

const lineHighlightField = StateField.define({
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

const lineHighlightMark = Decoration.line({
  attributes: {style: 'background-color: yellow'},
});

export default class HighlightableEditor {
  constructor(parent, code, onHighlight) {
    this.editorView = new EditorView({
      state: EditorState.create({
        doc: code,
        extensions: [basicSetup, lineHighlightField, javascript(),
            lineNumbers(), bracketMatching(),
            syntaxHighlighting(defaultHighlightStyle, { fallback: true }),
        ],
      }),
      parent: parent,
    });

    this.editorView.dom.addEventListener('mousemove', (event) => {
      const lastMove = {
        x: event.clientX,
        y: event.clientY,
        target: event.target,
        time: Date.now(),
      };
      const pos = this.editorView.posAtCoords(lastMove);
      let lineNo = this.editorView.state.doc.lineAt(pos).number;
      const docPosition = this.editorView.state.doc.line(lineNo).from;
      this.editorView.dispatch({effects: addLineHighlight.of(docPosition)});
      onHighlight(lineNo);
    });
  }

  getCode() {
    return this.editorView.state.doc.toString();
  }

  highlightLine(lineNo) {
    if (lineNo <= 0) return;
    const docPosition = this.editorView.state.doc.line(lineNo).from;
    this.editorView.dispatch({effects: addLineHighlight.of(docPosition)});
  }
}