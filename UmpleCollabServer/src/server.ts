import { Server, Socket } from 'socket.io';
import * as http from 'http';
import {ChangeSet, Text} from "@codemirror/state"
import {Update} from "@codemirror/collab"
import express from 'express';
import config from 'config';

const app = express();
const server = http.createServer(app);

const port:string = config.get('collab_server.port');
const apiPath:string = config.get('collab_server.path')


// The updates received so far (updates.length gives the current
// version)
// let updates: Update[] = []

// creating Map for collaapifile keys
let collabfilemap = new Map<string, Update[]>();

// The current document
let doc = Text.of(["Start document"])
let pending: ((value: any) => void)[] = []

// app.get('/collabapitest/healthCheck', (req: any, res: any)=>{
// 	const data = {
// 		uptime: process.uptime(),
// 		message: 'Collab_Server is running !!!',
// 		date: new Date()
// 	  }
// 	res.status(200).send(data);
// })

let io = new Server(server, {
	path: apiPath,
	cors: {
		origin: "*",
		methods: ["GET", "POST"]
	}
});

// global variable to store filekey coming from client

io.on('connect_error', (err) => {
	console.log(`could not connect due to ${err.message}`);
});

// listening for connections from clients
io.on('connection', (socket: Socket) =>{

	console.log("Client connected! ")
	// fileKey parameter should come from the client - umpdir_filename
	socket.on('pullUpdates', (fileKey: string, version: number) => {
		// console.log("inside pullUpdates with filekey: ", fileKey)
		let updates: Update[] = getUpdatesOrCreate(fileKey)
		if (version < updates.length) {
			socket.emit("pullUpdateResponse", JSON.stringify(updates.slice(version)))
		} else {
			pending.push((updates) => { socket.emit('pullUpdateResponse', JSON.stringify(updates.slice(version))) });
		}
	})

	// fileKey parameter should come from the client - umpdir_filename
	socket.on('pushUpdates', (fileKey: string, version, docUpdates) => {
		let updates: Update[] = getUpdatesOrCreate(fileKey)
		docUpdates = JSON.parse(docUpdates);

		try {
			// maybe issue is here, version != updates.length
			// version and updates.length have to be equal to apply updates to editor document
			if (version != updates.length) {
				console.log(`${version} != ${updates.length}`)
				socket.emit('pushUpdateResponse', false);
			} else {
				for (let update of docUpdates) {
					// Convert the JSON representation to an actual ChangeSet
					// instance
					let changes = ChangeSet.fromJSON(update.changes)
					updates.push({changes, clientID: update.clientID})
					doc = changes.apply(doc)
				}
				socket.emit('pushUpdateResponse', true);

				while (pending.length) pending.pop()!(updates)
			}
		} catch (error) {
			console.error(error)
		}
	})

	socket.on('getDocument', (fileKey) => {
		// if(collabfilemap.has(fileKey)){
			let updates: Update[] = getUpdatesOrCreate(fileKey)!
			socket.emit('getDocumentResponse', updates.length, doc.toString());
			// socket.emit('getDocumentResponse', 1, "Test Document");
		// }
	})
})

function getUpdatesOrCreate(fileKey: string): Update[] {
	// console.log("collabfilemap.size : ", collabfilemap.size)
	// console.log('collabfilemap: ', collabfilemap)
	if(!collabfilemap.has(fileKey)){
		collabfilemap.set(fileKey, []);
	}
	// ! - non-null assertion operator
	// tells type script that even though something seems to be null, 
	// it can trust that it's not
	return collabfilemap.get(fileKey)!
}

// start listening to calls to collaborate
server.listen(port, () => {
	console.log(`Collab server listening on port: ${port}`)
	// console.log(`Connect your client to path: ${apiPath}`)
	// console.log(server.address())
});
