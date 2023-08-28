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
This command installs all the necessary dependencies listed in the 'package.json' file. They will be in a directory named 'node_modules', and 'node_modules' will be at same directory level as 'package.json'.

## Building the client
To build the test client:
```sh
npm run build
```

## Running the client
To run the test client:
```sh
npm run dev
```
This creates a test client on http://localhost:5173 which connects to UmpleCollabServer. This test-client demonstrates collaboration between multiple editors opened in different browsers or even on different machines.

