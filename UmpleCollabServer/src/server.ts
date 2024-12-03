// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license

// This provides collaboration server functionality to allow multiple
// collaborations among Codemirror6 clients. 
//
// Clients define a fileKey that specifies the collaboration
// This is intended to be used in UmpleOnline, where the collaboration is
// defined by the session and the umple file that together form the fileKey.
//
// This server can be established on localhost for testing
// but is intended to run on the UmpleOnline public server machines
//
// Clients that access this server include instances of UmpleOnline
// but also the test code that can be found in this repo under
// umpleonline/scripts/codemirror6-plugins/collaboration-test-client
//
// See the README.md in the parent directory for more information

import { Server, Socket } from 'socket.io';
import * as http from 'http';
import {ChangeSet, Text} from "@codemirror/state"
import {Update} from "@codemirror/collab"
import express from 'express';
import config from 'config';
import cors from 'cors';


const app = express();
app.use(cors());
const server = http.createServer(app);

const port:string = config.get('collab_server.port');
const apiPath:string = config.get('collab_server.path');

const serverDebugFlag = false; // set to true to enable debug messages

if(serverDebugFlag){
  console.log("=====================================");
  console.log("Server", server);
  console.log("=====================================");
  console.log(`Server port: ${port}, apiPath: ${apiPath}`);
  console.log("=====================================");


}

// The updates received so far (updates.length gives the current version)

// CUSTOM TYPE to store updates, document, pending updates
// updates: an array to store document updates corresponding to each filekey
// document: to hold the current state of the document corresponding to each filekey
// pending: an array of function calls related to the document which are pending to applied/called

type collabDoc = {
  updates: Update[],
  doc: Text,
  pending: ((value: any) => void)[]
};

// This Map contains filekey as key and collabDoc custom type as its value.
// filekey is formed by umpdir_filename (both of these parameters are sent by the client)
// collabDoc is a custom type created just above
let collabfilemap = new Map<string, collabDoc>();

// Map for tracking online users per session
let activeUsers = new Map<string, Set<string>>();

// DEBUG
// The following code is currently not active
// app.get('/collabapitest/healthCheck', (req: any, res: any)=>{
//   const data = {
//     uptime: process.uptime(),
//     message: 'Collab_Server is running !!!',
//     date: new Date()
//     }
//   res.status(200).send(data);
// })

let io = new Server(server, {
  path: apiPath,
  cors: {
    origin: "*",
    methods: ["GET", "POST"]
  }
});

io.on('connect_error', (err) => {
  console.log(`could not connect due to ${err.message}`);
});

// listening for connections from clients
io.on('connection', (socket: Socket) =>{
  // DEBUG
  if (serverDebugFlag){
    console.warn("=====================================");
    console.warn("Client connected!", "Socket ID: ", socket.id);
    console.warn("=====================================");
    console.warn('New connection from ' + socket.handshake.address + ' with socket id: ' + socket.id);
  }


  // Listen for a new session
  socket.on('joinSession', (fileKey: string) => {

  if(serverDebugFlag){
    console.log("=====================================");
    console.warn("user joined Session with this keyfile: ", fileKey);
  }

    if (!activeUsers.has(fileKey)) {
      activeUsers.set(fileKey, new Set());

      if(serverDebugFlag){
        console.log("=====================================");
        console.log(`New session created, file ID: ${fileKey}`);
      }

    }
    
    const users = activeUsers.get(fileKey)!;
    users.add(socket.id);

    if(serverDebugFlag){
      console.log("=====================================");
      console.warn(`User count for session: ${fileKey}, count: ${users.size}`);
      console.warn(`Active users: ${users}`);
    }
    
    // Join the socket to the room
    socket.join(fileKey);

    io.in(fileKey).emit('userCountUpdate', users.size);

    if(serverDebugFlag){
      console.log("=====================================");
      console.log(`User joined session: ${fileKey}, current count: ${users.size}`);
    }

  });
  
  
  // core socket event that sends updates to a requesting client
  // when the client requests for them to be pulled
  // fileKey parameter should come from the client - umpdir_filename
  socket.on('pullUpdates', (fileKey: string, version: number) => {

    if(serverDebugFlag){
      console.warn(`User:${socket.id} pullUpdates calls - fileKey: ${fileKey} update number: ${version}`);
    }
    let currentCollabDoc: collabDoc = getOrCreate(fileKey);
    let updates: Update[] = currentCollabDoc.updates;
    let pending: ((value: any) => void)[] = currentCollabDoc.pending;

    if(serverDebugFlag){
      console.log("=====================================");
      console.warn(`currentCollabDoc.updates.length: ${updates.length}`);
    }

    if (version < updates.length) {
      socket.emit("pullUpdateResponse", JSON.stringify(updates.slice(version)));

      if(serverDebugFlag){
        console.log("=====================================");
        console.warn(`pullUpdateResponse sent with updates: ${updates.slice(version)}`);
      }

    } else {
      pending.push((updates) => { 
        socket.emit('pullUpdateResponse', JSON.stringify(updates.slice(version))) });

      if(serverDebugFlag){
        console.log("=====================================");
        console.warn(`pending.push called with updates (pullUpdateResponse)`);
      }
    }
    // write back the updated local variables to currentCollabDoc
    // and update the collabDoc in map against using the filekey
    currentCollabDoc.updates = updates;
    currentCollabDoc.pending = pending;
    collabfilemap.set(fileKey, currentCollabDoc);

if(serverDebugFlag){
     console.log("currentCollabDoc: ", currentCollabDoc);
  }

  })

  // core socket event that receives updates when a client has made changes
  // and needs to have them distributed to other clients
  // fileKey parameter should come from the client - umpdir_filename
  socket.on('pushUpdates', (fileKey: string, version, docUpdates) => {

    if(serverDebugFlag){
      console.warn(`User:${socket.id} pushUpdates called - fileKey: ${fileKey} update number: ${version} docUpdates: ${docUpdates}`);
    }
    let currentCollabDoc : collabDoc = getOrCreate(fileKey);
    let updates: Update[] = currentCollabDoc.updates;
    docUpdates = JSON.parse(docUpdates);

    if(serverDebugFlag){
      console.log("=====================================");
      console.warn(`currentCollabDoc.updates.length: ${updates.length}`);
      console.log(`docUpdates: ${docUpdates}`);
      console.log(`docUpdates.length: ${docUpdates.length}`);
      console.log("=====================================");
      
      // DEBUG
      console.log(`document (10 chars): ${currentCollabDoc.doc.slice(0, 10)}`);
      console.log("document updates: ", docUpdates.toString());
      
    }

    try {
      // DEBUG
      if(serverDebugFlag){
      console.log(`fileKey: ${fileKey} , version: ${version} , updates.length: ${updates.length}`);
      }

      if (version != updates.length) {
        socket.emit('pushUpdateResponse', false);

        if(serverDebugFlag){
          console.log(`pushUpdateResponse sent with false`);
          console.log(`filekey: ${fileKey} version: ${version} != updates.length: ${updates.length}`);
        }
        
      } else {


        let doc: Text = currentCollabDoc.doc;
        for (let update of docUpdates) {
          // Convert the JSON representation to an actual ChangeSet
          // instance

          try {
            let changes = ChangeSet.fromJSON(update.changes)
            updates.push({changes, clientID: update.clientID})
            doc = changes.apply(doc)
  
          } catch (error) {
            console.error(error); 
            socket.emit('pushUpdateResponse', false);
          }

          if(serverDebugFlag)
            {
              console.log("=====================================");
              console.warn(`update.changes: ${update.changes}`);
              console.log(`doc: ${doc}`);
              console.log(`doc.length: ${doc.length}`);
            }
        }
        socket.emit('pushUpdateResponse', true);

        if(serverDebugFlag){
          console.log(`Emitted, pushUpdateResponse sent with true`);
        }


        let pending: ((value: any) => void)[] = currentCollabDoc.pending;
        while (pending.length){
          pending.pop()!(updates)
        }
        // write back the updated local variable doc to currentCollabDoc
        currentCollabDoc.doc = doc
        currentCollabDoc.pending = pending
      }
    } catch (error) {
      console.error(error)
    }
    // write back the updated local variables to currentCollabDoc
    // and update the collabDoc in map against using the filekey
    currentCollabDoc.updates = updates
    collabfilemap.set(fileKey, currentCollabDoc)
  })

  socket.on('getDocument', (fileKey, initText) => {

if(serverDebugFlag){
    console.log("=====================================");
    console.warn(`getDocument event called with this key: ${fileKey}`);
}

    // DEBUG
    // console.log(`getDocument event: ${fileKey}`) // ${initText}

      let currentCollabDoc: collabDoc = getOrCreate(fileKey)
      let updates: Update[] = currentCollabDoc.updates
      let doc: Text = currentCollabDoc.doc
      if(doc.length == 0){
        doc = Text.of([initText])
        currentCollabDoc.doc = doc

      if(serverDebugFlag){
        console.log("=====================================");
        console.warn(`Document text not present on server, setting to: ${initText}`);
      }

      }
      else{
        console.log(`${fileKey} - Document text present on server`);
      }
      socket.emit('getDocumentResponse', updates.length, doc.toString());
  })

  socket.on('disconnect', () => {
    // Remove the user from all active sessions
    for (const [fileKey, users] of activeUsers.entries()) {
      if (users.delete(socket.id)) {
        // Emit the updated user count to all clients in the session
        io.in(fileKey).emit('userCountUpdate', users.size);
        if(serverDebugFlag){
        console.log("=====================================");
        console.log(`User disconnected from session: ${fileKey}, current count: ${users.size}`);
        }
        break; // Exit after handling the first found session
      }
    }
  });
  
})



// checks if the Map contains any records related to the fileKey coming from the client
// fileKey is created as follows: umpdir_filename (both of these parameters are passed in the URL by cleint)
// if a corresponding record for fileKey sent by client is not found, an empty record of custom type collabDoc is created
// custom type: collabDoc is defined at start of the file
function getOrCreate(fileKey: string): collabDoc {

  if(serverDebugFlag){
    console.log("=====================================");
    console.warn(`getOrCreate called with fileKey: ${fileKey}`);
  }
  
  if(!collabfilemap.has(fileKey)){
    collabfilemap.set(fileKey, 
      {
        updates: [],
        doc: Text.of([""]),
        pending: []
      });
  }
  // non-null assertion operator
  return collabfilemap.get(fileKey)!
}

// start listening to calls to collaborate
server.listen(port, () => {
  console.log(`Collab server listening on port: ${port}`);
});
