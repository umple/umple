Collab = new Object();

// this method is called in umple.php when it is verified that current URL is Bookmarked/Collaborative URL
// connect to UmpleCollabServer which takes URL parameters umpdir, filename and inittext
// umpdir represents the current model
// filename represents the currently active tab
// inittext represents the current contents of the codemirror6 editor
Collab.connectCollabServer = async function() {
  // DEBUG
  console.log("Inside Collab.connectCollabServer ...")
  if(Page.isBookmarkURL()){
    // DEBUG
    console.log("Current Page is Bookmark URL --- connecting to Collab Server!")
    var socket = io("http://localhost:8000", {
      path: "/collabapitest"
    });

    // DEBUG
    console.log("Socket Info: ", socket)

    const umpdir = Page.getModel();
    const filename = TabControl.activeTab.name;
    // const filename = "untitled";
    const inittext = Page.codeMirrorEditor6.state.doc.toString();
    // const inittext = "Test Content";
    var filekey = umpdir+"_"+filename;
    // DEBUG
    // console.log(umpdir, filename, inittext)

    const getDocumentResponse = await Collab.getDocument(socket, filekey, inittext)
    // const {version, doc} = getDocument(socket, filekey, inittext)

    // DEBUG
    console.log("Version: ", getDocumentResponse.version, "Doc: ", getDocumentResponse.doc)
    Page.setCodeMirror6Text(getDocumentResponse.doc)
    // call Action.processTyping() to load diagram based on the editor content
    setTimeout('Action.processTyping("newEditor",' + false + ')', Action.waiting_time);

    // add peerExtension to the cm6 editor to enable collaboration functionalities
    Page.codeMirrorEditor6.dispatch({
      effects: cm6.StateEffect.appendConfig.of(Collab.peerExtension(socket, filekey, getDocumentResponse.version))
    })
  }
  else{
    // DEBUG
    console.log("Current Page URL is NOT Bookmarked!")
    Page.setFeedbackMessage("Current URL is not Collaborative!")
  }
}

// DEBUG
// console.log(Page.getModel())
// console.log(TabControl.activeTab.name)
// console.log(Page.codeMirrorEditor6.state.doc.toString())
// Collab.connectCollabServer(Page.getModel(), TabControl.activeTab.name, Page.codeMirrorEditor6.state.doc.toString());
  

// emits getDocument event and waits for server to return version and document
// once the promise is resolved, returns document version and document content
Collab.getDocument = function(socket, filekey, inittext) {
  // DEBUG
  console.log("Inside Collab.getDocument() ...")
  // socket.emit('getDocument', filekey, inittext);
  // return {version: 0, doc: "FROM getDocument"}
  return new Promise(function(resolve) {
      socket.emit('getDocument', filekey, inittext);

      socket.once('getDocumentResponse', function(version, doc) {
      resolve({
          version,
          doc: cm6.Text.of(doc.split("\n"))
      })
      })
    })
}
  
// creates a Promise for sending updates via a socket connection
// When the updates are sent, it waits for a response with a boolean status, 
// and once that response is received, the Promise is resolved with that status
// this ensures that updates were successfully received or processed by the other side of the socket connection.
Collab.pushUpdates = function(socket, filekey, version, fullUpdates) {
  const updates = fullUpdates.map(u => ({
      clientID: u.clientID,
      changes: u.changes.toJSON(),
      effects: u.effects
  }));

  return new Promise(function(resolve) {
    socket.emit('pushUpdates', filekey, version, JSON.stringify(updates));

    socket.once('pushUpdateResponse', function(status) {
      // DEBUG
      // console.log("status: ", status)
      resolve(status);
    });
  });
}

// pullUpdates obtains changes made by other collaborators
// the arguments are the same three as for pushUpdates above
Collab.pullUpdates = function(socket, filekey, version) {
  return new Promise(function(resolve) {
    socket.emit('pullUpdates', filekey, version);
    // DEBUG
    // console.log("Emitted pullUpdates with filekey: ", filekey)
    socket.once('pullUpdateResponse', function(updates) {
      resolve(JSON.parse(updates));
    });
  }).then((updates) => updates.map((u) => ({
    changes: cm6.ChangeSet.fromJSON(u.changes),
    clientID: u.clientID
  })));
}

Collab.peerExtension = function(socket, filekey, startVersion) {
  // console.log("filekey inside PeerExtension! ", filekey)
  const plugin = cm6.ViewPlugin.fromClass(class {
    constructor(view) {
      this.view = view;
      this.pushing = false;
      this.done = false;
      this.pull(filekey);
    }

    update(update) {
      if (update.docChanged || update.transactions.length) this.push(filekey);
    }

    async push(filekey) {
      const updates = cm6.sendableUpdates(this.view.state);
      if (this.pushing || !updates.length) return;
      this.pushing = true;
      const version = cm6.getSyncedVersion(this.view.state);
      const success = await Collab.pushUpdates(socket, filekey, version, updates);
      console.log(success);
      this.pushing = false;
      // Regardless of whether the push failed or new updates came in
      // while it was running, try again if there are updates remaining
      if (cm6.sendableUpdates(this.view.state).length)
        setTimeout(() => this.push(filekey), 100);
    }

    async pull(filekey) {
      while (!this.done) {
        const version = cm6.getSyncedVersion(this.view.state);
        const updates = await Collab.pullUpdates(socket, filekey, version); // filekey added here
        this.view.dispatch(cm6.receiveUpdates(this.view.state, updates));
      }
    }

    destroy() {
      this.done = true;
    }
  });

  return [cm6.collab({ startVersion }), plugin];
};
