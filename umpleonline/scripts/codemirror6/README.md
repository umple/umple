## This package integrates codemirror6 editor into umpleonline platform

### Includes various codemirror6 modules like @codemirror/view, @codemirror/state, @codemirror/collab

- To install all dependencies, run the following command inside codemirror6 directory:
`npm install`

- Once all depencies are install, the editor.mjs module has to be exported as Javascript bundle file, so it can be further used by existing umpleonline code. Run the following command:
`npm start`

- editor.bundle.js file created in previous step can now be used in umpleonline javascript code.

- Say, you want to access `receiveUpdates` functionality from the bundle.js file, the syntax is as follows:
`cm6.receiveUpdates`