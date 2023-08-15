// Object.defineProperty(exports, "__esModule", { value: true });
const socket_io_1 = require("socket.io");
const http = require("http");
const state = require("@codemirror/state");
const server = http.createServer();

let updates = []

let doc = state.Text.of(["Start Document"])
let pending = [];

let io = new socket_io_1.Server(server, {
    path: "/collab",
    cors: {
        origin: "*",
        methods: ["GET", "POST"]
    }
});

server.on('connection', (socket) => {
    var clientAddress = `${socket.remoteAddress}:${socket.remotePort}`;
    console.log(`new client connected: ${clientAddress}`); 

    socket.on('close', () => {
        console.log(`client disconnected: ${clientAddress}`); 
    });

    socket.on('data', (data)=>{
        console.log(`Received: ${data}`)
    });
    socket.on('pullUpdates', (version) => {
        if (version < updates.length) {
            socket.emit("pullUpdateResponse", JSON.stringify(updates.slice(version)));
        }
        else {
            pending.push((updates) => { socket.emit('pullUpdateResponse', JSON.stringify(updates.slice(version))); });
        }
    });
    socket.on('pushUpdates', (version, docUpdates) => {
        docUpdates = JSON.parse(docUpdates);
        try {
            if (version != updates.length) {
                socket.emit('pushUpdateResponse', false);
            }
            else {
                for (let update of docUpdates) {
                    // Convert the JSON representation to an actual ChangeSet
                    // instance
                    let changes = state_1.ChangeSet.fromJSON(update.changes);
                    updates.push({ changes, clientID: update.clientID });
                    doc = changes.apply(doc);
                }
                socket.emit('pushUpdateResponse', true);
                while (pending.length)
                    pending.pop()(updates);
            }
        }
        catch (error) {
            console.error(error);
        }
    });
    socket.on('getDocument', () => {
        socket.emit('getDocumentResponse', updates.length, doc.toString());
    });
});

server.on('error', (error) => {
    console.log(`Error at Authority Server: Closing ...`);
    console.log(error);
    server.destroy();
});

const port = process.env.PORT || 8000;
server.listen(port, () => console.log(`Authority Server started on port: ${port}`));
