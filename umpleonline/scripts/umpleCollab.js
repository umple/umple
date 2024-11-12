// console.log("umpleCollab.js loaded ...")

Collab = new Object();
let sockett= null;
let dc = null;
let baseclientID = null;  
let attempt = 0;
let checktemp = false;
let isConnected = false;
let inactivityDisabled = false;
// let inActivityIntervalID;

// the main process of Idle timer
// let inactivityTime = 300000; // 5 minutes 
// let inactivityTime = 6000; // 6 seconds
let inactivityTime = 600000; // 10 minutes
let inactivitywarningTime = 540000; // 9 minutes
let diff = (inactivityTime - inactivitywarningTime)/1000;
let inactivityTimer;
let inactivitywarningTimer;
let debugFlag=false;
let achknowledgedTimer = 0;


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

  let urlParams = new URLSearchParams(new URL(window.location.href).search);
  if (urlParams.has('model')) {
    let checkModel = urlParams.get('model');
    checktemp = checkModel.startsWith('tmp');
    if(debugFlag)
    console.warn("Model Parameter: ", checkModel, "CheckTemp: ", checktemp);
  }

// Check the initial status
updateConnectionStatus();

  // DEBUG
  if(debugFlag)
  console.warn("Inside Collab.connectCollabServer ...");

// Check if 'model' parameter exists and starts with 'tmp'
  if(Page.isBookmarkURL() && checktemp!=true){
    Page.codeMirrorEditor6.dispatch({
      effects: cm6.editableCompartment.reconfigure(cm6.EditorView.editable.of(false))
  });
  Page.readOnly = true;
  document.getElementById('inputExampleType').disabled = true;
  document.getElementById('inputExample').disabled = true;

    // DEBUG
    if(debugFlag)
    console.log("Current Page is Bookmark URL --- connecting to Collab Server!");

    // setup default values CollabServerConfig is not set by creating collab-server-config.js
    // The client will try to connect to serverURL: https://cruise.umple.org and serverPath: /collabapi
    const serverURL = typeof CollabServerConfig !== 'undefined' ? CollabServerConfig.serverURL : "https://cruise.umple.org"
    const serverPath = typeof CollabServerConfig !== 'undefined' ? CollabServerConfig.serverPath : "/collabapi" 
    
    // DEBUG
    if(debugFlag){
    console.log("serverURL: ", serverURL);
    console.log("serverPath: ", serverPath);
    }

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
    if(debugFlag)
    console.warn("Socket Info: ", socket);

    // LED updates:
    const led = document.getElementById('led');
    
    const connectionTimeout = setTimeout(() => {
      // console.error('Connection to Collaboration server timed out!', window.performance.now()-snapshot);
      if(debugFlag){
        console.error('Connection to Collaboration server timed out!');
        console.log("Collaboration server is disconnected/down !");
      }
      Page.setFeedbackMessage("Cannot Collaborate right now, due to connection time out!");
      // led.style.backgroundColor = 'red' ; 
      document.getElementById('led').classList.remove('LEDonError');
      document.getElementById('led').classList.remove('LEDonDisconnect');

      
    }, 10000); // 10 seconds timeout

    // const snapshot= window.performance.now();
    // console.log("timeout registered", snapshot);
    if(debugFlag)
    console.log("serverURL: ", serverURL, "serverPath: ", serverPath);
  



    socket.on('connect', () => {
      isConnected = true;
      // console.log("connected", window.performance.now()-snapshot);
      clearTimeout(connectionTimeout);
      
      if(debugFlag)
      console.log("Connected to Collab Server....");
      
      // set a feedback message for connected umpleonline window
      setTimeout(Page.setFeedbackMessage("Connected to Collab Server"),2500);

      
        const reconnectButton = document.getElementById('collabReconnect');

        if(reconnectButton){
          reconnectButton.style.display = 'none'; // Show reconnect button
        }

        const forkButton = document.getElementById('buttonCollabFork');
        forkButton.style.display = 'inherit'; // show fork button
      

        const disconnectButton = document.getElementById('collabDisconnect');
        if(disconnectButton)
        disconnectButton.style.display = 'inherit'; // Hide disconnect button

        if (document.getElementById('activeUsers')){
        document.getElementById('activeUsers').style.display = 'inherit'; // Hide active users display
        document.getElementById('activeUsersIcon').style.display = 'inherit'; // Hide active users label
        }
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
      isConnected = false;
      
      if(debugFlag)
        console.warn('Connection to Collaboration server failed! Please try again later.');

        Page.setFeedbackMessage("Connection to Collaboration server failed! Please try again later.");

        const reconnectButton = document.getElementById('collabReconnect');

        if(reconnectButton)
        reconnectButton.style.display = 'inherit'; // Show reconnect button

        const disconnectButton = document.getElementById('collabDisconnect');
        const collabFork = document.getElementById('buttonCollabFork');

        // led.style.backgroundColor = 'red';
        document.getElementById('led').classList.add('LEDonError');
        // Hide disconnect button
        if(disconnectButton.style.display == 'inherit'){
        disconnectButton.style.display = 'none'; // Hide disconnect button
        collabFork.style.display = 'none'; // Hide fork button
        }

        attempt+=1;  
        if (attempt >= 3){
        // console.log("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later.");
        // Page.setFeedbackMessage("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later.");
        
        attempt=0;
        Collab.disconnectFromServer("You have been disconnected from the server due to multiple failed attempts to update the document. Please try to reconnect to your collaboration session later.");
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDonDisconnect');


        }
      
    });


    // Set up listener for user count updates
    socket.on('userCountUpdate', function (count) {
      // document.getElementById('userCountDisplay').innerText = `Users Online: ${count}`;
      if(debugFlag)
      console.warn("Users Online: ", count);

      if(document.getElementById('activeUsers')){
      document.getElementById('activeUsers').innerText = `${count}`;

      if(count == 1){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDMoreThanTwo');
        document.getElementById('led').classList.remove('LEDTwo');
        document.getElementById('led').classList.remove('LEDonDisconnect');

        document.getElementById('led').classList.add('LEDOne');

      }
      else if(count == 2){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDOne');
        document.getElementById('led').classList.remove('LEDMoreThanTwo');
        document.getElementById('led').classList.remove('LEDonDisconnect');

        document.getElementById('led').classList.add('LEDTwo');
      }
      else if(count >=2){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDOne');
        document.getElementById('led').classList.remove('LEDTwo');
        document.getElementById('led').classList.remove('LEDon');
        document.getElementById('led').classList.remove('LEDonDisconnect');
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
    }
    });

    socket.on('disconnect', function () {
     // console.log('You are disconnected from server.');
     // Page.setFeedbackMessage("Disconnected from Collab Server")
    // Collab.disconnectFromServer();
    isConnected = false;
      
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
    if(debugFlag)
    console.log("Version: ", getDocumentResponse.version, "Doc: ", getDocumentResponse.doc);
    // when response document coming from collaboration server has some content,
    // then only update the code editor

    if(getDocumentResponse.doc.length != 0){
      Page.setCodeMirror6Text(getDocumentResponse.doc);
      if(debugFlag){
        console.warn("Document content received from Collab Server: ");
        console.log("response of get document ", getDocumentResponse.doc);
        console.log("Document Version received from Collab Server: ", getDocumentResponse.version);
      }
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
    if(debugFlag)
    console.log("Current Page URL is NOT Bookmarked!");

    Page.setFeedbackMessage("Current URL is not Collaborative!");
  }
      // DEBUG
      if(socket != null){
        if(debugFlag)
        console.warn("Socket Info: ", socket);
      }

      sockett = socket;

}


Collab.disconnectFromServer = function(text) {
  socket=sockett;
  isConnected = false;
  // Notify the server about disconnection if necessary
  // socket.emit('disconnectRequest');

  // Clean up the socket connection
  if(socket != null)
  socket.disconnect();

  document.getElementById('changableButton').innerHTML= "<a class='button2' id='topBookmarkable' href='javascript:reconnect()'> Reconnect <span id='led' class='led'> </span><span id='activeUsersIcon' style='display:none'>&#128100;</span>&nbsp;<span id='activeUsers' style='display:none' ></span></a>"


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


  // const reconnectButton = document.getElementById('collabReconnect');
  // reconnectButton.style.display = 'inherit'; // Show reconnect button

  const disconnectButton = document.getElementById('collabDisconnect');
  disconnectButton.style.display = 'none'; // Hide disconnect button

  const collabFork = document.getElementById('buttonCollabFork');
  collabFork.style.display = 'none'; // Hide fork button

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
    
    if(debugFlag)
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
  if(debugFlag)
  console.warn("Inside Collab.getDocument() ...");
  // socket.emit('getDocument', filekey, inittext);
  // return {version: 0, doc: "FROM getDocument"}
  return new Promise(function(resolve) {
      socket.emit('getDocument', filekey, inittext);
      
      if(debugFlag)
      console.log("Emitted getDocument with filekey: ", filekey);

      socket.once('getDocumentResponse', function(version, doc) {
      resolve({
          version,
          doc: cm6.Text.of(doc.split("\n"))
      })
      if(debugFlag)
        console.log("Version: ", version, "Doc: ", doc);
      })
    })
}
  
// creates a Promise for sending updates via a socket connection
// When the updates are sent, it waits for a response with a boolean status, 
// and once that response is received, the Promise is resolved with that status
// this ensures that updates were successfully received or processed by the other side of the socket connection.
Collab.pushUpdates = async function(socket, filekey, version, fullUpdates) {
  const updates = fullUpdates.map(u => ({
      clientID: u.clientID,
      changes: u.changes.toJSON(),
      effects: u.effects
  }));


 if(debugFlag){
  console.warn("Inside Collab.pushUpdates() ...");
  console.warn("clientID: ", fullUpdates[0].clientID);
  console.log("Updates: ", updates);
  console.log("Filekey: ", filekey);
  console.log("Version: ", version);
  console.log("FullUpdates: ", fullUpdates);
  achknowledgedTimer = Date.now();
 }


  baseclientID = fullUpdates[0].clientID;

  return new Promise(function(resolve) {
    socket.emit('pushUpdates', filekey, version, JSON.stringify(updates));
    socket.once('pushUpdateResponse', function(status) {
      // DEBUG
      // console.log("status: ", status)
      // ===================
      if (status.error) {
        return reject(new Error(status.error));
      }
      // ===================
      resolve(status);
    });

    if(debugFlag)
    console.log("Emitted pushUpdates with filekey: ", filekey, "Version: ", version, "Updates: ", updates , "FullUpdates: ", fullUpdates);
  });
}

// pullUpdates obtains changes made by other collaborators
// the arguments are the same three as for pushUpdates above
Collab.pullUpdates = function(socket, filekey, version) {
   if (debugFlag){
    console.log("Inside Collab.pullUpdates() ...");
    console.log("Filekey: ", filekey);
    console.log("Version: ", version);
   }

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
  if(debugFlag){
    console.warn("Inside Collab.peerExtension() ...");
    console.log("Socket: ", socket);
    console.log("Filekey: ", filekey);
    console.log("StartVersion: ", startVersion);
  }
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
      let success = false;
      const updates = cm6.sendableUpdates(this.view.state);
      if (this.pushing || !updates.length) return;
      this.pushing = true;
      const version = cm6.getSyncedVersion(this.view.state);
      try {
       success = await Collab.pushUpdates(socket, filekey, version, updates);
       
       if(debugFlag){
         console.log(success);
         if (success){
          console.warn("Updates have been successfully pushed to the server in : "+ (Date.now() - achknowledgedTimer) + " milliseconds");
          }
          }
      } catch (e) {
      success = false;
      console.error(e);
      console.warn("Failed to push updates to the server");

      }
     
      if(debugFlag){
        console.warn("Inside Collab.peerExtension.push(),update ...");
        console.log("Updates: ", updates);
        console.log("Version: ", version);
        console.log("Success: ", success);
      }

      if (success && document.getElementById('led')){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.add('LEDon');
      }else if (!success && document.getElementById('led')){
        setTimeout(() => {
          document.getElementById('led').classList.remove('LEDon');
        document.getElementById('led').classList.add('LEDonError');
        dc+=1;
      }, 200);

      if (dc >= 500){
        // Collab.disconnectFromServer("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later.");
        // setTimeout(Page.setFeedbackMessage("You have been disconnected from server due to multiple failed attempts. Please try to reconnect to your collaboration session later."),3000);
        
        console.log("It looks like you're experiencing packet loss, which can cause lag or slow performance.");
        setTimeout(Page.setFeedbackMessage("It looks like you're experiencing packet loss, which can cause lag or slow performance."),3000);
        dc=0;
      }

      }

      this.pushing = false;
      // Regardless of whether the push failed or new updates came in
      // while it was running, try again if there are updates remaining
      if (cm6.sendableUpdates(this.view.state).length)
        setTimeout(() => this.push(filekey), 200);

      if(document.getElementById('led')){
      setTimeout(() => {
        document.getElementById('led').classList.remove('LEDon');
        document.getElementById('led').classList.remove('LEDonError');
      }, 200); 
    }

      debounce(resetInactivityTimer, 2000)(); // Reset the inactivity timer
    }

    async pull(filekey) {
      while (!this.done) {
        const version = cm6.getSyncedVersion(this.view.state);
        const updates = await Collab.pullUpdates(socket, filekey, version); // filekey added here
        this.view.dispatch(cm6.receiveUpdates(this.view.state, updates));

        if(debugFlag){
          console.warn("Inside Collab.peerExtension.pull(),update ...");
          console.log("Updates: ", updates);
          console.log("Version: ", version);
          console.warn("client ID",updates[0].clientID);
        }

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

}


function sendInactivitywarning() {
  if(debugFlag)
  console.warn("Only " + diff + " seconds left to disconnect due to inactivity");

  Page.setFeedbackMessage("Only " + diff + " seconds left to disconnect due to inactivity");  
  // Page.setFeedbackMessage("You will be disconnected from collaboration due to inactivity in 20 seconds. Please type something on the editor to continue collaborating."); 
}


// Function to trigger when the user is considered inactive
function userIsInactive() {
  if(debugFlag)
  console.log("User is inactive, disconnect sequence started...");
  
  // stopActivityInterval();

  Collab.disconnectFromServer(); // Function to handle disconnection

  if(inactivityTime == 600000){
    setTimeout(()=>{
      // alert("You have disconnected from collaboration due to inactivity. Please click reconnect if you want to connect to your collaboration session again.");
      console.warn("Collaboration disconnected and model is read only after 10 minutes of inactivity. Click reconnect to continue."); 
      Page.setFeedbackMessage("Collaboration disconnected and model is read only after 10 minutes of inactivity. Click reconnect to continue.");
    } ,3000);

  }
  else
  {
    setTimeout(()=>{
      // alert("You have disconnected from collaboration due to inactivity. Please click reconnect if you want to connect to your collaboration session again.");
      console.warn("Collaboration disconnected and model is read only after " + inactivityTime/1000 + " seconds of inactivity. Click reconnect to continue.");
      Page.setFeedbackMessage("Collaboration disconnected and model is read only after " + inactivityTime/1000 + " seconds of inactivity. Click reconnect to continue.");
    } ,3000);

  }
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
  if (!inactivityDisabled){
  if(debugFlag)
  console.warn('timer reset called ...');

  clearTimeout(inactivityTimer); // Clear the existing timer
  clearTimeout(inactivitywarningTimer); // Clear the existing timer

  inactivityTimer = setTimeout(userIsInactive, inactivityTime); // Set a new timer
  inactivitywarningTimer = setTimeout(sendInactivitywarning, inactivitywarningTime); // Set a new timer
  }
}



Collab.websocketLogging = function(command){
  if(command == 0){
    console.log("Unlimited collaboration logging");
    debugFlag = true;

  }else if(command == -1){
    console.log("Disable collaboration logging");
    debugFlag = false;
 
  }
 }

 Collab.clientSetTimeout = function(command){
  if(command == 10){
    if (isConnected){
    inactivityDisabled = false;
    console.log("Timeout the client after 10 seconds");
    inactivityTime = 10000; // 10 seconds
    inactivitywarningTime = 6000; // 6 seconds
    diff = 4000/1000;
    resetInactivityTimer();
    }
    else{
      console.log("you are not connected to the collaboration server");
      Page.setFeedbackMessage("You are not connected to the collaboration server");
    }
  
  }else if(command == -1){
    if (isConnected){
    inactivityDisabled = false;
    console.log("Reset to normal inactivity time");
    inactivityTime = 600000; // 10 minutes
    inactivitywarningTime = 540000; // 9 minutes
    diff = (600000- 540000)/1000;
    resetInactivityTimer();
    }
    else{
      console.log("you are not connected to the collaboration server");
      Page.setFeedbackMessage("You are not connected to the collaboration server");
    }
   
  }
  else if(command == 0){
    if (isConnected){
    console.log("client timeout disabled");
    clearTimeout(inactivityTimer); // Clear the existing timer
    clearTimeout(inactivitywarningTimer); // Clear the existing timer
    inactivityDisabled = true;
    }
    else{
      console.log("you are not connected to the collaboration server");
      Page.setFeedbackMessage("You are not connected to the collaboration server");
    }
  }
 }


//  if(command == 10){
//   console.log("Ten seconds of collaboration logging started");
//   debugFlag = true;
//   setTimeout(() => {
//     debugFlag = false;
//     Page.setFeedbackMessage("Ten seconds of collaboration logging ended");
//   }, 10000);
// }

