// console.log("umpleCollab.js loaded ...")

Collab = new Object();
let sockett= null;
let dc = null;
let baseclientID = null;
let attamept = 0;
// let inActivityIntervalID;

// the main process of Idle timer
// let inactivityTime = 300000; // 5 minutes 
let inactivityTime = 45000; // 45 seconds 
let inactivitywarningTime = 25000; // 20 seconds
let inactivityTimer;
let inactivitywarningTimer;


function updateConnectionStatus() {
  // if (navigator.onLine) {
  //     console.log("You are online");
  // } else {
  //     console.log("You are offline");
  //     this.Collab.disconnectFromServer();
  // }

  if(!navigator.onLine){
    // console.warn("You are not connected to the Internet. Please check your connection and try again.");
    // Page.setFeedbackMessage("You are not connected to the Internet. Please check your connection and try again.");
    Collab.disconnectFromServer("You are not connected to the Internet. Please check your connection and try again.");
  }
  
}

// Listen for changes
// window.addEventListener('online', updateConnectionStatus);
window.addEventListener('offline', updateConnectionStatus);

// this method is called in umple.php when it is verified that current URL is Bookmarked/Collaborative URL
// connect to UmpleCollabServer which takes URL parameters umpdir, filename and inittext
// umpdir represents the current model
// filename represents the currently active tab
// inittext represents the current contents of the codemirror6 editor
Collab.connectCollabServer = async function() {


// Check the initial status
updateConnectionStatus();

  // DEBUG
  console.log("Inside Collab.connectCollabServer ...")
  if(Page.isBookmarkURL()){
    Page.codeMirrorEditor6.dispatch({
      effects: cm6.editableCompartment.reconfigure(cm6.EditorView.editable.of(false))
  });
  Page.readOnly = true;
  document.getElementById('inputExampleType').disabled = true;
  document.getElementById('inputExample').disabled = true;

    // DEBUG
    console.log("Current Page is Bookmark URL --- connecting to Collab Server!")

    // setup default values CollabServerConfig is not set by creating collab-server-config.js
    // The client will try to connect to serverURL: https://cruise.umple.org and serverPath: /collabapi
    const serverURL = typeof CollabServerConfig !== 'undefined' ? CollabServerConfig.serverURL : "https://cruise.umple.org"
    const serverPath = typeof CollabServerConfig !== 'undefined' ? CollabServerConfig.serverPath : "/collabapi" 
    
    // DEBUG
    console.log("serverURL: ", serverURL, "serverPath: ", serverPath);


    var socket = io(serverURL, {
      reconnection: true,          // Enable reconnection
      reconnectionAttempts: 3,     // Set maximum reconnection attempts to 5
      reconnectionDelay: 800,     // Optional: delay between attempts (in ms)

      path: serverPath,
      cors: {
      origin: '*',
      methods: ['GET', 'POST']}

    });

    // DEBUG
    // console.warn("Socket Info: ", socket)

    // LED updates:
    const led = document.getElementById('led');
    
    const connectionTimeout = setTimeout(() => {
      // console.error('Connection to Collaboration server timed out!', window.performance.now()-snapshot);
      console.error('Connection to Collaboration server timed out!');
      console.log("Collaboration server is disconnected/down !")
      Page.setFeedbackMessage("Cannot Collaborate right now, due to connection time out!")
      // led.style.backgroundColor = 'red' ; 
      document.getElementById('led').classList.remove('LEDonError');
      document.getElementById('led').classList.remove('LEDonDisconnect')

      
    }, 10000); // 10 seconds timeout

    // const snapshot= window.performance.now();
    // console.log("timeout registered", snapshot);

    console.log("serverURL: ", serverURL, "serverPath: ", serverPath);


    socket.on('connect', () => {
      // console.log("connected", window.performance.now()-snapshot);
      clearTimeout(connectionTimeout);
      //console.log("Connected to Collab Server....")
      
      // set a feedback message for connected umpleonline window
      setTimeout(Page.setFeedbackMessage("Connected to Collab Server"),2500);
      
        const reconnectButton = document.getElementById('collabReconnect');
        if(reconnectButton){
          reconnectButton.style.display = 'none'; // Show reconnect button
        }
      
        const disconnectButton = document.getElementById('collabDisconnect');
        disconnectButton.style.display = 'inherit'; // Hide disconnect button

        document.getElementById('activeUsers').style.display = 'inherit'; // Hide active users display
        document.getElementById('activeUsersIcon').style.display = 'inherit'; // Hide active users label

        // if(cm6.EditorView.editable.of(false) == true)
        //   console.log("Editor is not editable")
        // Page.codeMirrorEditor6.dispatch({
        //   effects: cm6.StateEffect.removeConfig.of(cm6.EditorView.editable.of(false))
        // });
      socket.emit('joinSession', filekey); // Notify server of joining the session
      
      Page.codeMirrorEditor6.dispatch({
        effects: cm6.editableCompartment.reconfigure(cm6.EditorView.editable.of(true))
    });

    Page.readOnly = false;
    document.getElementById('inputExampleType').disabled=false;
    document.getElementById('inputExample').disabled=false;

    // Action.changeDiagramType({type:"editableClass"});
    startCheckingInactivity();
    // resetInactivityTimer();

    })
    .on('connect_error', (error) => {
      
        console.warn('Connection to Collaboration server failed! Please try again later.');
        Page.setFeedbackMessage("Connection to Collaboration server failed! Please try again later.")

        const reconnectButton = document.getElementById('collabReconnect');
        reconnectButton.style.display = 'inherit'; // Show reconnect button

        const disconnectButton = document.getElementById('collabDisconnect');

        // led.style.backgroundColor = 'red';
        document.getElementById('led').classList.add('LEDonError');
        // Hide disconnect button
        if(disconnectButton.style.display == 'inherit'){
        disconnectButton.style.display = 'none'; // Hide disconnect button


        }

        attamept+=1;  
        if (attamept >= 3){
        // console.log("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later.");
        // Page.setFeedbackMessage("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later.");
        
        attamept=0;
        Collab.disconnectFromServer("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later.");
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDonDisconnect')


        }
      
    });


    // Set up listener for user count updates
    socket.on('userCountUpdate', function (count) {
      // document.getElementById('userCountDisplay').innerText = `Users Online: ${count}`;
      console.warn("Users Online: ", count);
      document.getElementById('activeUsers').innerText = `${count}`;
      if(count == 1){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDMoreThanTwo');
        document.getElementById('led').classList.remove('LEDTwo');
        document.getElementById('led').classList.remove('LEDonDisconnect')

        document.getElementById('led').classList.add('LEDOne');

      }
      else if(count == 2){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDOne');
        document.getElementById('led').classList.remove('LEDMoreThanTwo');
        document.getElementById('led').classList.remove('LEDonDisconnect')

        document.getElementById('led').classList.add('LEDTwo');
      }
      else if(count >=2){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDOne');
        document.getElementById('led').classList.remove('LEDTwo');
        document.getElementById('led').classList.remove('LEDon');
        document.getElementById('led').classList.remove('LEDonDisconnect')
        document.getElementById('led').classList.add('LEDMoreThanTwo');
        
      }
      else {
        document.getElementById('led').classList.remove('LEDOne');
        document.getElementById('led').classList.remove('LEDTwo');
        document.getElementById('led').classList.remove('LEDMoreThanTwo');
        document.getElementById('led').classList.remove('LEDon');
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDonReceive');
        document.getElementById('led').classList.add('LEDonDisconnect');
        document.getElementById('led').backgroundColor = 'gray';
      }
    });

    socket.on('disconnect', function () {
     // console.log('You are disconnected from server.');
     // Page.setFeedbackMessage("Disconnected from Collab Server")
    // Collab.disconnectFromServer();
      
    });


    const umpdir = Page.getModel();
    const filename = TabControl.activeTab != null ? TabControl.activeTab.name : "Untitled";
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
    // when response document coming from collaboration server has some content,
    // then only update the code editor

    if(getDocumentResponse.doc.length != 0){
      Page.setCodeMirror6Text(getDocumentResponse.doc);
    }

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
      // DEBUG
      console.warn("Socket Info: ", socket)
      sockett = socket;

}


Collab.disconnectFromServer = function(text) {
  socket=sockett;
  // Notify the server about disconnection if necessary
  // socket.emit('disconnectRequest');

  // Clean up the socket connection
  if(socket != null)
  socket.disconnect();

  // Update UI for disconnected state
  const led = document.getElementById('led');
  // led.style.backgroundColor = 'gray'; // Indicate disconnected state
  document.getElementById('led').classList.add('LEDonDisconnect');
  document.getElementById('led').classList.remove('LEDon');
  document.getElementById('led').classList.remove('LEDonError');
  document.getElementById('led').classList.remove('LEDonReceive');
  document.getElementById('led').classList.remove('LEDOne');
  document.getElementById('led').classList.remove('LEDTwo');
  document.getElementById('led').classList.remove('LEDMoreThanTwo');


  const reconnectButton = document.getElementById('collabReconnect');
  reconnectButton.style.display = 'inherit'; // Show reconnect button

  const disconnectButton = document.getElementById('collabDisconnect');
  disconnectButton.style.display = 'none'; // Hide disconnect button

  document.getElementById('activeUsers').style.display = 'none'; // Hide active users display
  document.getElementById('activeUsersIcon').style.display = 'none'; // Hide active users label

  if(text !== undefined){
    setTimeout(() => {
    Page.setFeedbackMessage(text);
    console.log(text);
    }, 1000);
  }else{
    setTimeout(() => {
    Page.setFeedbackMessage("Disconnected from Collab Server");
    console.log("Disconnected from Collab Server");
  }, 1000);
  }
      // Page.setFeedbackMessage("Disconnected from Collab Server");
      // // console.log("Disconnected from Collab Server")
      // console.log("Disconnected from Collab Server",socket);

    // Page.codeMirrorEditor6.dispatch({
    //   effects: cm6.StateEffect.appendConfig.of(cm6.EditorView.editable.of(false))
    // });

  Page.codeMirrorEditor6.dispatch({
    effects: cm6.editableCompartment.reconfigure(cm6.EditorView.editable.of(false))
  });

  Page.readOnly = true;
  
  Action.redrawDiagram();

  document.getElementById('inputExampleType').disabled=true;
  document.getElementById('inputExample').disabled=true;

  clearTimeout(inactivityTimer); // Clear the existing timer
  clearTimeout(inactivitywarningTimer); // Clear the existing timer 

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

  baseclientID = fullUpdates[0].clientID;

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

      if (success){
        document.getElementById('led').classList.add('LEDon');
      }else{
        setTimeout(() => {
        document.getElementById('led').classList.add('LEDonError');
        dc+=1;}, 200);
      }

      this.pushing = false;
      // Regardless of whether the push failed or new updates came in
      // while it was running, try again if there are updates remaining
      if (cm6.sendableUpdates(this.view.state).length)
        setTimeout(() => this.push(filekey), 100);

      setTimeout(() => {
        document.getElementById('led').classList.remove('LEDon');
        document.getElementById('led').classList.remove('LEDonError');
      }, 200); 

      if (dc >= 20){
        Collab.disconnectFromServer("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later.");
        alert("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later.");
        dc=0;
      }

      debounce(resetInactivityTimer, 2000)(); // Reset the inactivity timer

    }

    async pull(filekey) {
      while (!this.done) {
        const version = cm6.getSyncedVersion(this.view.state);
        const updates = await Collab.pullUpdates(socket, filekey, version); // filekey added here
        this.view.dispatch(cm6.receiveUpdates(this.view.state, updates));

        // console.log("updates: ", updates);
        // console.log(updates[0].clientID);
        // console.log(baseclientID);

        if(updates[0].clientID != baseclientID){ 
          document.getElementById('led').classList.add('LEDonReceive');
          setTimeout(() => {
            document.getElementById('led').classList.remove('LEDonReceive');
         }, 200);
        }

      }
    }



    destroy() {
      this.done = true;
    }
  });

  return [cm6.collab({ startVersion }), plugin];
};





function startCheckingInactivity() {
// Inactive timer:
// if(document.getElementById('disconnectButton')){
  resetInactivityTimer();

  // inActivityIntervalID = setInterval(()=>{


  //   // if(inactivityTimer >= inactivityTime){
  //   //   userIsInactive();
  //   // }
      
  //     }, 3000);

   //    console.warn("Interval started", inActivityIntervalID);
}


function sendInactivitywarning() {
  console.warn("Only 20 seconds left to disconnect due to inactivity");
  Page.setFeedbackMessage("Only 20 seconds left to disconnect due to inactivity");  
  // Page.setFeedbackMessage("You will be disconnected from collaboration due to inactivity in 20 seconds. Please type something on the editor to continue collaborating."); 
}


// Function to trigger when the user is considered inactive
function userIsInactive() {
  console.log("User is inactive, disconnect sequence started...");
  
  // stopActivityInterval();

  Collab.disconnectFromServer(); // Function to handle disconnection

  setTimeout(()=>{
    alert("You have disconnected from collaboration due to inactivity. Please click reconnect if you want to connect to your collaboration session again.");
  } ,3000);    

  // resetInactivityTimer(); // Reset the inactivity timer 

}


function debounce(callback, delay) {
  let timeoutId;  // Variable to store the timeout ID

  return function(...args) {
      // Clear any existing timer before starting a new one
      if (timeoutId) {
          clearTimeout(timeoutId);
      }

      // Set a new timer
      timeoutId = setTimeout(() => {
          // Call the callback function after the delay
          callback.apply(this, args);
      }, delay);
  };
}


// Function to reset the inactivity timer
function resetInactivityTimer() {
  console.warn('timer reset called ...');
  clearTimeout(inactivityTimer); // Clear the existing timer
  clearTimeout(inactivitywarningTimer); // Clear the existing timer

  inactivityTimer = setTimeout(userIsInactive, inactivityTime); // Set a new timer
  inactivitywarningTimer = setTimeout(sendInactivitywarning, inactivitywarningTime); // Set a new timer

}

// function stopActivityInterval() {
//   console.warn("Stopping the interval triggered", inActivityIntervalID);
//   clearInterval(inActivityIntervalID);
// }


