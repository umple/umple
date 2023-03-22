## How to work with CodeMirror 6
- To add/update anything to codemirror6, `editor.mjs` file under `codemirror6` directory has to be updated.
- Currently `editor.mjs` has following functions:
    - Codemirror6 Editor initialization 
    - Listening to changes

#### To get rollup as a command line function:
```
npm install --global rollup
```

#### To run the rollup script
- go to codemirror6 directory under scripts
```
cd YOUR_UMPLE_DIR/umpleonline/scripts/codemirror6
```
- execute following command, which will update the editor.bundle.js file from editor.mjs
```
npm start
```
- the above step exports all needed functions in `editor.mjs` and they can be accessed using following convention inside any other js files:
```
cm6.createEditorState() , cm6.listenChangesExtension
```

Note that editor.bundle.js is committed to the repo just like the allumple-min.js so that any ordinary user can start using UmpleOnline without having to do these building steps.

The npm start has to be repeated if there are any changes made to editor.mjs
