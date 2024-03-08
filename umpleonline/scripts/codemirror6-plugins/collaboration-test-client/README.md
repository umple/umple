# Test-Client for Collab Server

## Involved GitHub Issues: [#1963](https://github.com/umple/umple/issues/1963)

This is a test-client application with a codemirror6 editor to test UmpleCollabServer functionality.

1. [CodeMirror 6 Extensible Code Editor](https://codemirror.net/)
2. [Collaborative Editing](https://codemirror.net/examples/collab/)

## Getting Started
Before you can build and run this project, you need to install the dependencies.
To do this, navigate to collaboration-test-client directory which contains 'package.json' file, in your terminal and run the following command:
```sh
npm install
```
The above command installs all the necessary dependencies listed in the 'package.json' file. They will be in a directory named 'node_modules', and 'node_modules' will be at same directory level as 'package.json'.

## Building the client
To build the test client:
```sh
npm run build
```

Rebuild the client as above after editing any of the code.

Note that you will need to set src/App.tsx to point to the correct server


## Running the client
To run the test client:
```sh
npm run dev
```
This creates a test client on http://localhost:5173 which connects to UmpleCollabServer. This test-client demonstrates collaboration between multiple editors opened in different browsers including on different machines.

Arguments can be expressed such as the following:

http://localhost:5173/?umpdir=testumpdir&filename=test.ump&inittext=startText

Change umpdir or filename to change the collaboration.

To properly test, open multiple browsers with the same umpdir and filenames. 

The inittext argument is only used when establishing a new collaboration (i.e. an umpdir/filename pair not currently defining a collaboration.

The code in this plugin will also be used by UmpleOnline internally when a user requests to collaborate.

