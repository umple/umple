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
let updates: Update[] = []
// The current document
let doc = Text.of(["Start document"])
let pending: ((value: any) => void)[] = []

app.get('/healthCheck', (req: any, res: any)=>{
	const data = {
		uptime: process.uptime(),
		message: 'Collab_Server is running !!!',
		date: new Date()
	  }
	res.status(200).send(data);
})

let io = new Server(server, {
	path: apiPath,
	cors: {
		origin: "*",
		methods: ["GET", "POST"]
	}
});

// listening for connections from clients
io.on('connection', (socket: Socket) =>{

	socket.on('pullUpdates', (version: number) => {
		if (version < updates.length) {
			socket.emit("pullUpdateResponse", JSON.stringify(updates.slice(version)))
		} else {
			pending.push((updates) => { socket.emit('pullUpdateResponse', JSON.stringify(updates.slice(version))) });
		}
	})

	socket.on('pushUpdates', (version, docUpdates) => {
		docUpdates = JSON.parse(docUpdates);

		try {
			if (version != updates.length) {
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

	socket.on('getDocument', () => {
		socket.emit('getDocumentResponse', updates.length, doc.toString());
	})
})

// start listening to calls to collaborate
server.listen(port, () => {
	console.log(`Collab server listening on port: ${port}`)
	// console.log(`Connect your client to path: ${apiPath}`)
	// console.log(server.address())
});
