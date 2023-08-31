// This file contains the core client-side functions
// needed for collaborative editing using CodeMirror6 in UmpleOnline

import { EditorView, ViewPlugin, ViewUpdate } from "@codemirror/view"
import { Text, ChangeSet } from "@codemirror/state"
import { Update, receiveUpdates, sendableUpdates, collab, getSyncedVersion } from "@codemirror/collab"
import { Socket } from "socket.io-client"


// pushUpdates connects to the socket on the running server to send
// changes made by the user typing (or copying and pasting) in the
// CodeMirror6 web page.
//
//   socket is the connection to the server
//   filekey identifies the collaboration
//   version identifies the sequence number of edits
//   fullUpdates is the changes made

function pushUpdates(socket: Socket, filekey: string, version: number,fullUpdates: readonly Update[]
): Promise<boolean> {
  // Strip off transaction data
  const updates = fullUpdates.map(u => ({
    clientID: u.clientID,
    changes: u.changes.toJSON(),
    effects: u.effects
  }))

  // creates a Promise for sending updates via a socket connection
  // When the updates are sent, it waits for a response with a boolean status, 
  // and once that response is received, the Promise is resolved with that status
  // this ensures that updates were successfully received or processed by the other side of the socket connection.
  return new Promise(function(resolve) {
    socket.emit('pushUpdates', filekey, version, JSON.stringify(updates)); // fileKey argument to be added here

    socket.once('pushUpdateResponse', function(status: boolean) {
      // console.log("status: ", status)
      resolve(status);
    });
  });
}

// pullUpdates obtains changes made by other collaborators
// the arguments are the same three as for pushUpdates above

function pullUpdates(socket: Socket, filekey:string, version: number): Promise<readonly Update[]> {
  return new Promise(function(resolve) {
    socket.emit('pullUpdates', filekey, version); // fileKey argument to be added here
    // console.log("Emitted pullUpdates with filekey: ", filekey)
    socket.once('pullUpdateResponse', function(updates: any) {
      resolve(JSON.parse(updates));
    });
  }).then((updates: any) => updates.map((u: any) => ({
    changes: ChangeSet.fromJSON(u.changes),
    clientID: u.clientID
  })));
}

// emits getDocument event and waits for server to return version and document
// once the promise is resolved, values are returned back to calling line
export function getDocument(socket: Socket, filekey:string, inittext: string): Promise<{version: number, doc: Text}> {
  return new Promise(function(resolve) {
    socket.emit('getDocument', filekey, inittext); // filekey,inittext added to send to server for initialization of editor

    socket.once('getDocumentResponse', function(version: number, doc: string) {
      resolve({
        version,
        doc: Text.of(doc.split("\n"))
      });
    });
  });
}

export const peerExtension = (socket: Socket, filekey:string, startVersion: number) => {
  // console.log("filekey inside PeerExtension! ", filekey)
  const plugin = ViewPlugin.fromClass(class {
    private pushing = false
    private done = false

    constructor(private view: EditorView) { this.pull(filekey) }

    update(update: ViewUpdate) {
      if (update.docChanged || update.transactions.length) this.push(filekey)
    }

    async push(filekey: string) {
      const updates = sendableUpdates(this.view.state)
      if (this.pushing || !updates.length) return
      this.pushing = true
      const version = getSyncedVersion(this.view.state)
      const success = await pushUpdates(socket, filekey, version, updates)  // filekey added here
      console.log(success)
      this.pushing = false
      // Regardless of whether the push failed or new updates came in
      // while it was running, try again if there's updates remaining
      if (sendableUpdates(this.view.state).length)
        setTimeout(() => this.push(filekey), 100)
    }

    async pull(filekey: string) {
      while (!this.done) {
        const version = getSyncedVersion(this.view.state)
        const updates = await pullUpdates(socket, filekey, version)    // filekeyadded here
        this.view.dispatch(receiveUpdates(this.view.state, updates))
      }
    }

    destroy() { this.done = true }
  })

  
  return [ collab({ startVersion }), plugin ]
}
