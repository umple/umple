---
paths:
  - "umpleonline/scripts/codemirror6/**"
  - "umpleonline/scripts/codemirror6-plugins/**"
---

## Core editor (`scripts/codemirror6/`)

- `editor.mjs` is the source — editor init, change listeners, exported functions
- `editor.bundle.js` is the committed rollup bundle
- After editing `editor.mjs`: `cd scripts/codemirror6 && npm start`
- Other JS files access editor functions via `cm6.createEditorState()`, `cm6.listenChangesExtension`, etc.

## Syntax highlighting plugin (`scripts/codemirror6-plugins/`)

- Run `npm install` first if `node_modules/` is missing
- See `scripts/codemirror6-plugins/README.md` for build commands (parser generation, rollup bundling)

Both `editor.bundle.js` files are committed so users can run UmpleOnline without building.
