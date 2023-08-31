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

// The updates received so far (updates.length gives the current version)

// ORIGINAL Variables related to single document collaboration
// let updates: Update[] = []
// The current document
// let doc = Text.of(["Start document"])
// let pending: ((value: any) => void)[] = []


// CUSTOM TYPE to store updates, document, pending updates
// updates: an array to store document updates corresponding to each filekey
// document: to hold the current state of the document corresponding to each filekey
// pending: an array of function calls related to the document which are pending to applied/called
type collabDoc = {
	updates: Update[],
	doc: Text,
	pending: ((value: any) => void)[]
};

// This Map contains filekey as key and collabDoc custom type as its value.
// filekey is formed by umpdir_filename (both of these parameters are sent by the client)
// collabDoc is a custom type created just above
let collabfilemap = new Map<string, collabDoc>();


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

io.on('connect_error', (err) => {
	console.log(`could not connect due to ${err.message}`);
});

// listening for connections from clients
io.on('connection', (socket: Socket) =>{

	console.log("Client connected! ")	
	// fileKey parameter should come from the client - umpdir_filename
	socket.on('pullUpdates', (fileKey: string, version: number) => {
		// DEBUG
		// console.log("inside pullUpdates with filekey: ", fileKey)
		console.log(`pullUpdates fileKey: ${fileKey}`)
		let currentCollabDoc: collabDoc = getOrCreate(fileKey)
		let updates: Update[] = currentCollabDoc.updates
		let pending: ((value: any) => void)[] = currentCollabDoc.pending
		if (version < updates.length) {
			socket.emit("pullUpdateResponse", JSON.stringify(updates.slice(version)))
		} else {
			pending.push((updates) => { 
				socket.emit('pullUpdateResponse', JSON.stringify(updates.slice(version))) });
		}
		// write back the updated local variables to currentCollabDoc
		// and update the collabDoc in map against using the filekey
		currentCollabDoc.updates = updates
		currentCollabDoc.pending = pending
		collabfilemap.set(fileKey, currentCollabDoc)
	})

	// fileKey parameter should come from the client - umpdir_filename
	socket.on('pushUpdates', (fileKey: string, version, docUpdates) => {
		// DEBUG
		console.log(`pushUpdates fileKey: ${fileKey}`)
		let currentCollabDoc : collabDoc = getOrCreate(fileKey)
		let updates: Update[] = currentCollabDoc.updates
		docUpdates = JSON.parse(docUpdates);

		try {
			// DEBUG
			// console.log(`fileKey: ${fileKey} , version: ${version} != updates.length: ${updates.length}`)
			if (version != updates.length) {
				socket.emit('pushUpdateResponse', false);
			} else {
				let doc: Text = currentCollabDoc.doc;
				for (let update of docUpdates) {
					// Convert the JSON representation to an actual ChangeSet
					// instance
					let changes = ChangeSet.fromJSON(update.changes)
					updates.push({changes, clientID: update.clientID})
					doc = changes.apply(doc)
				}
				socket.emit('pushUpdateResponse', true);

				let pending: ((value: any) => void)[] = currentCollabDoc.pending;
				while (pending.length){
					pending.pop()!(updates)
				}
				// write back the updated local variable doc to currentCollabDoc
				currentCollabDoc.doc = doc
				currentCollabDoc.pending = pending
			}
		} catch (error) {
			console.error(error)
		}
		// write back the updated local variables to currentCollabDoc
		// and update the collabDoc in map against using the filekey
		currentCollabDoc.updates = updates
		collabfilemap.set(fileKey, currentCollabDoc)
	})

	socket.on('getDocument', (fileKey) => {
		// if(collabfilemap.has(fileKey)){
			let currentCollabDoc: collabDoc = getOrCreate(fileKey)
			let updates: Update[] = currentCollabDoc.updates
			let doc: Text = currentCollabDoc.doc
			socket.emit('getDocumentResponse', updates.length, doc.toString());
			// DEBUG
			// socket.emit('getDocumentResponse', 1, "Test Document");
		// }
	})
})

// checks if the Map contains any records related to the fileKey coming from the client
// fileKey is created as follows: umpdir_filename (both of these parameters are passed in the URL by cleint)
// if a corresponding record for fileKey sent by client is not found, an empty record of custom type collabDoc is created
// custom type: collabDoc is defined at start of the file
function getOrCreate(fileKey: string): collabDoc {
	// DEBUG
	// console.log("collabfilemap.size : ", collabfilemap.size)
	// console.log('collabfilemap: ', collabfilemap)
	if(!collabfilemap.has(fileKey)){
		collabfilemap.set(fileKey, 
			{
				updates: [],
				doc: Text.of(["Intialized"]),
				pending: []
			});
	}
	// non-null assertion operator
	return collabfilemap.get(fileKey)!
}

// start listening to calls to collaborate
server.listen(port, () => {
	console.log(`Collab server listening on port: ${port}`)
	// DEBUG
	// console.log(`Connect your client to path: ${apiPath}`)
	// console.log(server.address())
});
