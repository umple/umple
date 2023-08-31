import EditorElement from './components/EditorElement';
import { io } from "socket.io-client";

// var socket: any;

// for local testing
// const socket = io("http://localhost:8000", {
//   path: "/collabapitest"
// });

// The following socket settings are for connecting to umple test server
// the path has to be made configurable as well in server code
const socket = io("https://cruise.umple.org", {
  path: "/collabapitest"
});

function App() {
  // using URLSearchParams to access parameters from the URL entered
  const queryParameters = new URLSearchParams(window.location.search)
  const umpdir = queryParameters.get("umpdir")
  const filename = queryParameters.get("filename")
  const initText = queryParameters.get("inittext")
  const filekey = umpdir+"_"+filename

  return (
    <>
      <h1>Collaborative Editor</h1>

      <div className="card space-x-3">
        <p className='mb-3'>
          Edit the document below to test collab editing
        </p>
      </div>
      {/* <EditorElement socket={socket}/> */}
      <EditorElement socket={socket} filekey={filekey} inittext={initText!}/>
    </>
  )
}

export default App
