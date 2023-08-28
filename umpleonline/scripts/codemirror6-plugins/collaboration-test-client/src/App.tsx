import EditorElement from './components/EditorElement';

import { io } from "socket.io-client";

// The following socket settings are for connecting to collab_server when the collab_server is run on local machine on port 8000
// const socket = io("http://localhost:8000", {
//   path: "/collabapitest"
// });

// The following socket settings are for connecting to collab_server
// the path has to be made configurable as well in server code
const socket = io("https://cruise.umple.org", {
  path: "/collabapitest"
});

function App() {
  return (
    <>
      <h1>Collaborative Editor</h1>
      <div className="card space-x-3">
        <p className='mb-3'>
          Edit the document below to test collab editing
        </p>
      </div>
      <EditorElement socket={socket}  />
    </>
  )
}

export default App
