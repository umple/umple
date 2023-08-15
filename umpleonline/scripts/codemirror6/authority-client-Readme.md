## Implementing Authority-Client communication using Sockets

### Authority
- A central server where all clients connect
- Updates are stored
- Currently implemented as HTTP server
- run `node authority.js` inside codemirror6 directory to start authority server on port 8000

### Client
- A client connects to authority using sockets
- For now client is hitting a GET request to authority server on port 8000
- The client should use one of following ways to connect to authority
    - umpleonline/umple.php
    - umpleonline/umple.php?model=
    - `node client.js`

### Communication
- Communication is established using sockets
- Client and authority should be able to share information using pullUpdates, pushUpdates, getDocument (these are codemirror6 events)
