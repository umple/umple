## How to work with CodeMirror 6
- To add/update anything to codemirror6, `editor.mjs` file under `codemirror6` directory has to be updated.
- Currently `editor.mjs` has following functions:
    - Codemirror6 Editor initialization 
    - Listening to changes

#### To run the rollup script
- go to codemirror6 directory under scripts
```
cd umple/umpleonline/scripts/codemirror6
```
- execute following command which will create editor.bundle.js file from editor.mjs
```
npm start
```
- the previous step exports all functionalities in `editor.mjs` and they can be accessed using following convention inside any other js files:
```
cm6.createEditorState() , cm6.listenChangesExtension
```

