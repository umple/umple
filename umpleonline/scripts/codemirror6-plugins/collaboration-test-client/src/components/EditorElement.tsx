import { Component } from "react";

import CodeMirror from '@uiw/react-codemirror';
import { langs } from '@uiw/codemirror-extensions-langs';
import { basicSetup } from '@uiw/codemirror-extensions-basic-setup';
import { indentUnit } from '@codemirror/language'

import { type Socket } from "socket.io-client";
import { getDocument, peerExtension } from "../utils/collab";

type Mode = 'light' | 'dark';

type state = {
	filekey: string | null,
	connected: boolean;
	version: number | null;
	doc: string | null;
	mode:  Mode;
}

type props = {
	socket: Socket;
	className?: String;
	filekey: string;
	inittext: string;
}

class EditorElement extends Component<props, state> {

	state = {
		filekey: this.props.filekey,
		connected: false,
		version: null,
		doc: null,
		mode: window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light' as Mode
	}

	// componentDidMount() is called only once, when the page loads
	// i.e. when client loads/reloads the URL
	async componentDidMount() {
		// DEBUG
		// console.log("filekey in EditorElement: ", this.props.filekey)
		const { version, doc } = await getDocument(this.props.socket, this.props.filekey, this.props.inittext);
		// DEBUG
		// console.log(`Version: ${version} Doc: ${doc} after getDocument()`)
		this.setState({
			version,
			doc: doc.toString(),
			filekey: this.props.filekey
		})
		// DEBUG
		// console.log("this.state: ", this.state.doc, this.state.doc, this.state.filekey)

		this.props.socket.on('connect', () => {
			this.setState({
				connected: true
			});
		});

		this.props.socket.on('disconnect', () => {
			this.setState({ 
				connected: false
			});
		});

		// Change to dark mode or light mode depending on settings.
		window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', event => {
			const mode = event.matches ? "dark" : "light";
			this.setState({
				mode
			})
		});
	}

	componentWillUnmount(): void {
		this.props.socket.off('connect');
		this.props.socket.off('disconnect');
		this.props.socket.off('pullUpdateResponse');
		this.props.socket.off('pushUpdateResponse');
		this.props.socket.off('getDocumentResponse');
	}

	render() {
		// DEBUG
		// console.log("this.state: ", this.state)
		if (this.state.version !== null && this.state.doc !== null) {
			return (
				<>
					<CodeMirror
						className={`flex-1 overflow-scroll text-left ${this.props.className}`}
						height="100%"
						basicSetup={false}
						id="codeEditor"
						theme={ this.state.mode }
						extensions={[
							indentUnit.of("\t"), 
							basicSetup(), 
							langs.c(),
							// peerExtension handles all the collaboration functions of pushing, pulling updates
							peerExtension(this.props.socket, this.props.filekey, this.state.version)
						]}
						value={this.state.doc}
					/>
				</>
			);
		} else {
			return (
				<span>loading...</span>
			)
		}
	}
}

export default EditorElement;