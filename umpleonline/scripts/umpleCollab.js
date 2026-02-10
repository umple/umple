// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license

// Project: UmpleOnline
// This file contains the code for the collaboration feature of UmpleOnline
// It is responsible for connecting to the UmpleCollabServer, sending and receiving updates,
// and handling inactivity

Collab = new Object();  // Object to store the functions for collaboration
let oldSocket= null; // Variable to store the socket connection
let packetLoss = null; // Variable to store the number of packet loss
let baseclientID = null;  // Variable to store the client ID
let attempt = 0;   // Variable to store the number of attempts
let checktemp = false;  // Variable to check if the model is temporary
let isConnected = false; // Variable to store the connection status
let inactivityDisabled = false; // Variable to store the inactivity status

// the main process of Idle timer
const defaultInactivityTime = 600000; // 10 minutes
const defaultInactivitywarningTime = 540000; // 9 minutes
const defaultInactivityTimeTest = 10000; // 10 seconds
const defaultInactivitywarningTimeTest = 6000; // 6 seconds

// defaults for collab server connection
const defaultServerURL = "https://cruise.umple.org"; 
const defaultServerPath = "/collabapi";

let inactivityTime = defaultInactivityTime; // 10 minutes
let inactivitywarningTime = defaultInactivitywarningTime; // 9 minutes
let diff = (inactivityTime - inactivitywarningTime)/1000; // 60 seconds
let inactivityTimer; // Variable to store the timer
let inactivitywarningTimer;
let collabClientDebugFlag = false;
let ackknowledgedTimer = 0; 
let activeUsercount = 0; 
let inactivitychecker = true;


function updateConnectionStatus() {

  if(!navigator.onLine){
    console.warn("You are not connected to the Internet. Please check your connection and try again.");
    Page.setFeedbackMessage("You are not connected to the Internet. Please check your connection and try again.");
    Collab.disconnectFromServer();
  }
  
}

// Listen for changes
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
    if(collabClientDebugFlag){
      console.warn("Model Parameter: ", checkModel, "CheckTemp: ", checktemp);
    }
  }

// Check the initial status
updateConnectionStatus();

  // DEBUG
  if(collabClientDebugFlag){
    console.warn("Inside Collab.connectCollabServer ...");
  }

// Check if 'model' parameter exists and starts with 'tmp'
  if(Page.isBookmarkURL() && checktemp!=true){
    Page.codeMirrorEditor6.dispatch({
      effects: cm6.editableCompartment.reconfigure(cm6.EditorView.editable.of(false))
  });
  Page.readOnly = true;
  document.getElementById('inputExampleType').disabled = true;
  document.getElementById('inputExample').disabled = true;

  const collabServerConfigExists = typeof CollabServerConfig !== 'undefined';

    // DEBUG
    if(collabClientDebugFlag){
      console.log("Current Page is Bookmark URL --- connecting to Collab Server!");
      console.log("CollabServerConfig: ", collabServerConfigExists ? CollabServerConfig : "CollabServerConfig is not defined");
    }

    // To change from the default serverURL and serverPath, create a collab-server-config.js 
    // file based on the collab-server-config.js.template file and update the serverURL and 
    // serverPath to connect to your desired collab server instance
    const serverURL = collabServerConfigExists ? CollabServerConfig.serverURL : defaultServerURL;
    const serverPath = collabServerConfigExists ? CollabServerConfig.serverPath : defaultServerPath;
    
    // DEBUG
    if(collabClientDebugFlag){
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
    if(collabClientDebugFlag){
      console.warn("Socket Info: ", socket);
    }

    // LED updates:
    const led = document.getElementById('led');
    
    const connectionTimeout = setTimeout(() => {
      if(collabClientDebugFlag){
        console.error('Connection to Collaboration server timed out!');
        console.log("Collaboration server is disconnected/down !");
      }
      Page.setFeedbackMessage("Cannot Collaborate right now, due to too many failed tries!");
      document.getElementById('led').classList.remove('LEDonError');
      document.getElementById('led').classList.remove('LEDonDisconnect');
    }, 10000); // 10 seconds timeout

    if(collabClientDebugFlag){
      console.log("serverURL: ", serverURL, "serverPath: ", serverPath);
    }
  



    socket.on('connect', () => {
      isConnected = true;
      clearTimeout(connectionTimeout);
      
      if(collabClientDebugFlag){
        console.log("Connected to Collab Server....");
      }
      
      // set a feedback message for connected umpleonline window
      setTimeout(Page.setFeedbackMessage("Connected to Collab Server"),2500);

      
        const reconnectButton = document.getElementById('collabReconnect');

        if(reconnectButton){
          reconnectButton.style.display = 'none'; // Show reconnect button
        }

        const forkButton = document.getElementById('buttonCollabFork');
        forkButton.style.display = 'inherit'; // show fork button
      

        const disconnectButton = document.getElementById('collabDisconnect');
        if(disconnectButton && activeUsercount>1)
        disconnectButton.style.display = 'inherit'; // Hide disconnect button

        if (document.getElementById('activeUsers')){
        document.getElementById('activeUsers').style.display = 'inherit'; // Hide active users display
        document.getElementById('activeUsersIcon').style.display = 'inherit'; // Hide active users label
        }
   
      socket.emit('joinSession', filekey); // Notify server of joining the session
      
      Page.codeMirrorEditor6.dispatch({
        effects: cm6.editableCompartment.reconfigure(cm6.EditorView.editable.of(true))
    });

    Page.readOnly = false;
    UmpleSystem.redrawCanvas();
    document.getElementById('inputExampleType').disabled=false;
    document.getElementById('inputExample').disabled=false;

    if(activeUsercount > 1 && inactivitychecker)
    startCheckingInactivity();

    })
    .on('connect_error', (error) => {
      isConnected = false;
      
      if(collabClientDebugFlag){
        console.warn('Connection to Collaboration server failed! Please try again later.');
      }

        Page.setFeedbackMessage("Connection to Collaboration server failed! Please try again later.");

        const reconnectButton = document.getElementById('collabReconnect');

        if(reconnectButton)
        reconnectButton.style.display = 'inherit'; // Show reconnect button

        const disconnectButton = document.getElementById('collabDisconnect');
        const collabFork = document.getElementById('buttonCollabFork');

        document.getElementById('led').classList.add('LEDonError');

        // Hide disconnect button
        if(disconnectButton.style.display == 'inherit'){
        disconnectButton.style.display = 'none'; // Hide disconnect button
        collabFork.style.display = 'none'; // Hide fork button
        }

        attempt+=1;  
        if (attempt >= 3){
        attempt=0;
        Collab.disconnectFromServer("You have been disconnected from the server due to multiple failed attempts to update the document. Please try to reconnect to your collaboration session later.");
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDonDisconnect');
        }
      
    });


    // Set up listener for active users count updates
    socket.on('userCountUpdate', function (count) {
      activeUsercount = count;
      if(collabClientDebugFlag){
        console.warn("Users Online: ", activeUsercount);
      }

      if(document.getElementById('activeUsers')){
      document.getElementById('activeUsers').innerText = `${activeUsercount}`;

      if(activeUsercount == 1){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDMoreThanTwo');
        document.getElementById('led').classList.remove('LEDTwo');
        document.getElementById('led').classList.remove('LEDonDisconnect');

        document.getElementById('led').classList.add('LEDOne');
        clearTimeout(inactivityTimer); // Clear the existing timer
        clearTimeout(inactivitywarningTimer); // Clear the existing timer

        if(isConnected)
          document.getElementById('collabDisconnect').style.display = 'none';

      }
      else if(activeUsercount == 2){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDOne');
        document.getElementById('led').classList.remove('LEDMoreThanTwo');
        document.getElementById('led').classList.remove('LEDonDisconnect');

        document.getElementById('led').classList.add('LEDTwo');
        
        if(inactivitychecker){
          startCheckingInactivity();
        }

        if(isConnected)
          document.getElementById('collabDisconnect').style.display = 'inherit';

      }
      else if(activeUsercount >2){
        document.getElementById('led').classList.remove('LEDonError');
        document.getElementById('led').classList.remove('LEDOne');
        document.getElementById('led').classList.remove('LEDTwo');
        document.getElementById('led').classList.remove('LEDon');
        document.getElementById('led').classList.remove('LEDonDisconnect');
        document.getElementById('led').classList.add('LEDMoreThanTwo');

        if(inactivitychecker){
          startCheckingInactivity();
        }

        if(isConnected){
          document.getElementById('collabDisconnect').style.display = 'inherit';
        }
        
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
    isConnected = false;
      
    });


    const umpdir = Page.getModel();
    const filename = TabControl.activeTab != null ? TabControl.activeTab.name : "Untitled";

    const inittext = Page.codeMirrorEditor6.state.doc.toString();

    var filekey = umpdir+"_"+filename;
    // DEBUG

    const getDocumentResponse = await Collab.getDocument(socket, filekey, inittext)

    // DEBUG
    if(collabClientDebugFlag){
      console.log("Version: ", getDocumentResponse.version, "Doc: ", getDocumentResponse.doc);
    }
    // when response document coming from collaboration server has some content,
    // then only update the code editor

    if(getDocumentResponse.doc.length != 0){
      Page.setCodeMirror6Text(getDocumentResponse.doc);
      if(collabClientDebugFlag){
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
    if(collabClientDebugFlag){
      console.log("Current Page URL is NOT Bookmarked!");
    }

    Page.setFeedbackMessage("Current URL is not Collaborative!");
  }
      // DEBUG
      if(socket != null){
        if(collabClientDebugFlag){
          console.warn("Socket Info: ", socket);
        }
      }

      oldSocket = socket;

}


Collab.disconnectFromServer = function(text) {
  socket=oldSocket;
  isConnected = false;
  inactivitychecker = true;
  // You can notify the server about disconnection if necessary
  // socket.emit('disconnectRequest');

  // Clean up the socket connection
  if(socket != null)
  socket.disconnect();

  document.getElementById('changableButton').innerHTML= "<a class='button2' id='topBookmarkable' href='javascript:reconnect()'> Reconnect <span id='led' class='led'> </span><span id='activeUsersIcon' style='display:none'>&#128100;</span>&nbsp;<span id='activeUsers' style='display:none' ></span></a>"


  // Update UI for disconnected state
  const led = document.getElementById('led');
  document.getElementById('led').classList.add('LEDonDisconnect');
  document.getElementById('led').classList.remove('LEDon');
  document.getElementById('led').classList.remove('LEDonError');
  document.getElementById('led').classList.remove('LEDonReceive');
  document.getElementById('led').classList.remove('LEDOne');
  document.getElementById('led').classList.remove('LEDTwo');
  document.getElementById('led').classList.remove('LEDMoreThanTwo');



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
    
    if(collabClientDebugFlag){
      console.log("Disconnected from Collab Server");
    }

  }, 1000);
  }

  Page.codeMirrorEditor6.dispatch({
    effects: cm6.editableCompartment.reconfigure(cm6.EditorView.editable.of(false))
  });

  Page.readOnly = true;
  
  UmpleSystem.redrawCanvas();

  

  document.getElementById('inputExampleType').disabled=true;
  document.getElementById('inputExample').disabled=true;

  
  clearTimeout(inactivityTimer); // Clear the existing timer
  clearTimeout(inactivitywarningTimer); // Clear the existing timer 
}


// emits getDocument event and waits for server to return version and document
// once the promise is resolved, returns document version and document content
Collab.getDocument = function(socket, filekey, inittext) {
  // DEBUG
  if(collabClientDebugFlag){
    console.warn("Inside Collab.getDocument() ...");
  }

  return new Promise(function(resolve) {
      socket.emit('getDocument', filekey, inittext);
      
      if(collabClientDebugFlag){
        console.log("Emitted getDocument with filekey: ", filekey);
      }

      socket.once('getDocumentResponse', function(version, doc) {
      resolve({
          version,
          doc: cm6.Text.of(doc.split("\n"))
      })

      if(collabClientDebugFlag){
        console.log("Version: ", version, "Doc: ", doc);
      }

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


 if(collabClientDebugFlag){
  console.warn("Inside Collab.pushUpdates() ...");
  console.warn("clientID: ", fullUpdates[0].clientID);
  console.log("Updates: ", updates);
  console.log("Filekey: ", filekey);
  console.log("Version: ", version);
  console.log("FullUpdates: ", fullUpdates);
  ackknowledgedTimer = Date.now();
 }


  baseclientID = fullUpdates[0].clientID;

  return new Promise(function(resolve) {
    socket.emit('pushUpdates', filekey, version, JSON.stringify(updates));
    socket.once('pushUpdateResponse', function(status) {

      if (status.error) {
        return reject(new Error(status.error));
      }
      resolve(status);
    });

    if(collabClientDebugFlag){
      console.log("Emitted pushUpdates with filekey: ", filekey, "Version: ", version, "Updates: ", updates , "FullUpdates: ", fullUpdates);
    }

  });
}

// pullUpdates obtains changes made by other collaborators
// the arguments are the same three as for pushUpdates above
Collab.pullUpdates = function(socket, filekey, version) {
   if (collabClientDebugFlag){
    console.log("Inside Collab.pullUpdates() ...");
    console.log("Filekey: ", filekey);
    console.log("Version: ", version);
   }

  return new Promise(function(resolve) {
    socket.emit('pullUpdates', filekey, version);

    socket.once('pullUpdateResponse', function(updates) {
      resolve(JSON.parse(updates));
    });
  }).then((updates) => updates.map((u) => ({
    changes: cm6.ChangeSet.fromJSON(u.changes),
    clientID: u.clientID
  })));
}

// peerExtension is a function that returns an array of two elements
// the first element is a cm6.collab object that is used to manage the collaboration
// the second element is a cm6.ViewPlugin that is used to manage the view
// the function takes a socket, a filekey, and a startVersion as arguments
// the socket is the connection to the server
// the filekey is the unique identifier for the file being edited
// the startVersion is the version of the document that the client has
// the function returns an array of two elements, the first is a cm6.collab object,
// and the second is a cm6.ViewPlugin
Collab.peerExtension = function(socket, filekey, startVersion) {
  if(collabClientDebugFlag){
    console.warn("Inside Collab.peerExtension() ...");
    console.log("Socket: ", socket);
    console.log("Filekey: ", filekey);
    console.log("StartVersion: ", startVersion);
  }
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
       
       if(collabClientDebugFlag){
         console.log(success);
         if (success){
          console.warn("Updates have been successfully pushed to the server in : "+ (Date.now() - ackknowledgedTimer) + " milliseconds");
          }
          }
      } catch (e) {
      success = false;
      console.error(e);
      console.warn("Failed to push updates to the server");

      }
     
      if(collabClientDebugFlag){
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
        packetLoss+=1;
      }, 200);

      if (packetLoss >= 500){
        console.log("It looks like you're experiencing packet loss, which can cause lag or slow performance.");
        setTimeout(Page.setFeedbackMessage("It looks like you're experiencing packet loss, which can cause lag or slow performance."),3000);
        packetLoss=0;
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

      if(activeUsercount > 1)
      debounce(resetInactivityTimer, 2000)(); // Reset the inactivity timer
    }

    async pull(filekey) {
      while (!this.done) {
        const version = cm6.getSyncedVersion(this.view.state);
        const updates = await Collab.pullUpdates(socket, filekey, version); // filekey added here
        this.view.dispatch(cm6.receiveUpdates(this.view.state, updates));

        if(collabClientDebugFlag){
          console.warn("Inside Collab.peerExtension.pull(),update ...");
          console.log("Updates: ", updates);
          console.log("Version: ", version);
          console.warn("client ID",updates[0].clientID);
        }

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
  resetInactivityTimer();
  inactivitychecker = false;

}


function sendInactivitywarning() {
  if(collabClientDebugFlag){
    console.warn("Only " + diff + " seconds left to disconnect due to inactivity");
  }

  Page.setFeedbackMessage("Only " + diff + " seconds left to disconnect due to inactivity");  
}


// Function to trigger when the user is considered inactive
function userIsInactive() {
  if(collabClientDebugFlag){
    console.log("User is inactive, disconnect sequence started...");
  }
  

  Collab.disconnectFromServer(); // Function to handle disconnection

  if(inactivityTime == defaultInactivityTime){
    setTimeout(()=>{
      console.warn("Collaboration disconnected and model is read only after 10 minutes of inactivity. Click reconnect to continue."); 
      Page.setFeedbackMessage("Collaboration disconnected and model is read only after 10 minutes of inactivity. Click reconnect to continue.");
    } ,3000);

  }
  else
  {
    setTimeout(()=>{
      console.warn("Collaboration disconnected and model is read only after " + inactivityTime/1000 + " seconds of inactivity. Click reconnect to continue.");
      Page.setFeedbackMessage("Collaboration disconnected and model is read only after " + inactivityTime/1000 + " seconds of inactivity. Click reconnect to continue.");
    } ,3000);

  }

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
  if(collabClientDebugFlag){
    console.warn('timer reset called ...');
  }

  clearTimeout(inactivityTimer); // Clear the existing timer
  clearTimeout(inactivitywarningTimer); // Clear the existing timer

  inactivityTimer = setTimeout(userIsInactive, inactivityTime); // Set a new timer
  inactivitywarningTimer = setTimeout(sendInactivitywarning, inactivitywarningTime); // Set a new timer
  }
}



Collab.websocketLogging = function(command){
  if(command == 0){
    console.log("Unlimited collaboration logging");
    collabClientDebugFlag = true;

  }else if(command == -1){
    console.log("Disable collaboration logging");
    collabClientDebugFlag = false;
 
  }
 }

 // Function to set the inactivity time
 // command = 10 for 10 seconds, -1 for 10 minutes, 0 to disable
 // This function is called from the Line Number
 Collab.clientSetTimeout = function(command){
  if(command == 10){
    if (isConnected){
    inactivityDisabled = false;
    console.log("Timeout the client after 10 seconds");
    inactivityTime = defaultInactivityTimeTest; // 10 seconds
    inactivitywarningTime = defaultInactivitywarningTimeTest; // 6 seconds
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
    inactivityTime = defaultInactivityTime; // 10 minutes
    inactivitywarningTime = defaultInactivitywarningTime; // 9 minutes
    diff = (defaultInactivityTime - defaultInactivitywarningTime)/1000; 
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

