// This is the main application file for the test system
// for CodeMirror6 collaboration, as implemented for UmpleOnline.
// See the README.md in the parent directory for details

import EditorElement from './components/EditorElement';
import { io } from "socket.io-client";

// The following three lines are for local testing
// Uncomment these and comment out the subsequent block
// if installing a server on localhost
// This will later be made configurable as there will be
// multiple servers

// const socket = io("http://localhost:8000", {
//   path: "/collabapitest"
// });

// The following socket settings are for connecting to the Umple test server
// the path has to be made configurable as well in the server code

const socket = io("https://cruise.umple.org", {
  path: "/collabapitest"
});

function App() {
  // using URLSearchParams to access parameters from the URL entered
  const queryParameters = new URLSearchParams(window.location.search)
  
  // There are three URL parameters
  // The first two identify the file on which collaboration is occurring
  // When identical pairs are sent to the same server from
  // different browsers or tabs, then collaborative editing from those
  // browsers/tabs is enabled
  const umpdir = queryParameters.get("umpdir")
  const filename = queryParameters.get("filename")
  
  // The third URL parameter inittext is initial text, sent when
  // establishing a new collaboration
  // This would be the umple code when used in UmpleOnline
  // If inittext is sent to an existing collaboration then it is ignored
  const initText = queryParameters.get("inittext")
  
  // The actual collaboration is identified by the following concatenation
  const filekey = umpdir+"_"+filename

  return (
    <>
      <h1>Collaborative Editor to test CodeMirror6 Collaboration for UmpleOnline</h1>

      <div className="card space-x-3">
        <p className='mb-3'>
          The collaboration is determined by the URL arguments.
          <ul>
            <li>umpdir: A simulated Umple session directory e.g. 230831jy56</li>
            <li>filename: A simulated umple file that is one of the tabs in UmpleOnline, such as Untitled.ump</li>
            <li>inittext: Used when establishing a new collaboration to send the initial umple file. Can be any string for testing purposes</li>
          </ul>
        </p>
        
        <p className='mb-3'>
          Edit the document below to test collaboration editing. Also open other editors on the same URL, with the same umpdir and filename parameters to observe collaboration. This requires a server to be running.
        </p>
        
      </div>
      {/* <EditorElement socket={socket}/> */}
      <EditorElement socket={socket} filekey={filekey} inittext={initText!}/>
    </>
  )
}

export default App
