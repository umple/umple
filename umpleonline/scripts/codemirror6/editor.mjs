// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license

// This file is used to create the code editor using CodeMirror 6
// It also contains the custom theme and the custom plugin to listen for changes in the editor
// It also have the debounced function to process the typing in the editor

import { basicSetup } from "codemirror"
import { EditorSelection, EditorState, Text, ChangeSet, StateEffect, Compartment, Annotation } from "@codemirror/state";
import { javascript } from "@codemirror/lang-javascript"
import { umple } from "./umple.js"
import { EditorView, ViewPlugin, ViewUpdate, lineNumbers, keymap, Decoration } from "@codemirror/view"
import { receiveUpdates, sendableUpdates, collab, getSyncedVersion } from "@codemirror/collab"
import { syntaxHighlighting, defaultHighlightStyle, bracketMatching, HighlightStyle } from "@codemirror/language"
import { SearchCursor, RegExpCursor } from "@codemirror/search";
import {tags} from "@lezer/highlight";
import { LSPClient, LSPPlugin, Workspace, languageServerSupport, serverDiagnostics } from "@codemirror/lsp-client";


const codemirrorDebuggerFlag = false;

// Create a compartment for editable state
const editableCompartment = new Compartment();
const skipDebouncedTypingAnnotation = Annotation.define();

// Code keyword highlighting style
const myHighlightStyle = HighlightStyle.define([
  {tag: tags.typeName, color: "#9FCF63"}, // Green
  {tag: tags.string, color: "#EB5F66"}, // Red
  {tag: tags.lineComment, color: "#8F94A0"}, // Gray
  {tag: tags.blockComment, color: "#B8922F"}, // Brown
  {tag: tags.definitionKeyword, color: "#BA90E1"}, // Purple
  {tag: tags.literal, color: "#BA90E1"}, // Purple
  {tag: tags.keyword, color: "#306FBA"}, // Dark Blue
  {tag: tags.heading, color: "#4FADEA"}, // Light Blue
  {tag: tags.heading1, color: "#EA32D4"}, // Pink
  {tag: tags.integer, color: "#009909"}, // Dark Green

  {tag: tags.atom, color: "#EA983F"} // Test Orange
]);

const lightTheme = EditorView.theme({
  ".cm-activeLine": {
    backgroundColor: "#e9e9e977"  // active line color
  },
  ".cm-selectionBackground": {
    backgroundColor: "#edededff" // selection color
  }
});

const umpleDarkTheme = EditorView.theme({
  "&": {
    color: "#ffffff",
    backgroundColor: "#1b1d23"
  },
  ".cm-scroller, .cm-content, .cm-line": {
    color: "#ffffff"
  },
  ".cm-content": {
    caretColor: "#ffffff"
  },
  ".cm-cursor": {
    borderLeftColor: "#ffffff"
  },
  "&.cm-focused .cm-cursor": {
    borderLeftColor: "#ffffff"
  },
  ".cm-selectionBackground, .cm-content ::selection": {
    backgroundColor: "#3d4453"
  },
  ".cm-activeLine": {
    backgroundColor: "#2a2d33"
  },
  ".cm-gutters": {
    backgroundColor: "#242730",
    color: "#9aa2b4",
    borderRight: "none"
  },
  ".cm-gutterElement": {
    color: "#9aa2b4"
  }
}, { dark: true });

// Theme compartment allows swapping between light and dark themes
const myTheme = new Compartment();

const darkModeListeners = new Set();
let activeEditorView = null;
let darkModeOverride = null;

function prefersDarkMode() {
  if (typeof window === "undefined" || !window.matchMedia) {
    return false;
  }
  return window.matchMedia("(prefers-color-scheme: dark)").matches;
}

function notifyDarkModeListeners(isDark) {
  darkModeListeners.forEach((listener) => {
    try {
      listener(isDark);
    } catch (error) {
      // Ignore listener errors to avoid breaking other handlers
      if (typeof console !== "undefined" && console.error) {
        console.error("Dark mode listener failed", error);
      }
    }
  });
}

function setDarkMode(view, isDark) {
  const theme = isDark ? umpleDarkTheme : lightTheme;
  view.dispatch({
    effects: myTheme.reconfigure(theme)
  });
}

function getEffectiveDarkMode(matches) {
  if (darkModeOverride === null) {
    return matches;
  }
  return darkModeOverride;
}

function applyDarkModePreference(matches) {
  const isDark = getEffectiveDarkMode(matches);
  if (activeEditorView) {
    setDarkMode(activeEditorView, isDark);
  }
  notifyDarkModeListeners(isDark);
}

function trackEditorView(view) {
  activeEditorView = view;
  applyDarkModePreference(prefersDarkMode());
}

function onDarkModePreferenceChange(listener) {
  if (typeof listener !== "function") {
    return () => {};
  }
  darkModeListeners.add(listener);
  listener(getEffectiveDarkMode(prefersDarkMode()));
  return () => darkModeListeners.delete(listener);
}

function setDarkModePreference(mode) {
  darkModeOverride = mode === "dark" ? true : mode === "light" ? false : null;
  applyDarkModePreference(prefersDarkMode());
}

if (typeof window !== "undefined" && window.matchMedia) {
  const mediaQuery = window.matchMedia("(prefers-color-scheme: dark)");
  const handlePreferenceChange = (event) => applyDarkModePreference(event.matches);
  if (typeof mediaQuery.addEventListener === "function") {
    mediaQuery.addEventListener("change", handlePreferenceChange);
  } else if (typeof mediaQuery.addListener === "function") {
    mediaQuery.addListener(handlePreferenceChange);
  }
  applyDarkModePreference(mediaQuery.matches);
}

// Function to create the editor state
function createEditorState(initialContents, options={}) {
  
  let extensions = [
    basicSetup,
    umple(),
    lineNumbers(),
    bracketMatching(),
    syntaxHighlighting(defaultHighlightStyle, { fallback: true }),
    syntaxHighlighting(myHighlightStyle),
    EditorView.lineWrapping,
    EditorView.domEventHandlers({
      keydown(e, view) {
      }
    }),
    editableCompartment.of(EditorView.editable.of(true)),
  ]
  
  let startState = EditorState.create({
    // Use the textarea's value as the initial text for CodeMirror
    doc: initialContents,
    extensions: [
      ...extensions,
      myTheme.of(getEffectiveDarkMode(prefersDarkMode()) ? umpleDarkTheme : lightTheme)
    ]
  });
  
  return startState;
}

function createEditorView(state, parent){
  const view = new EditorView({
    state, parent
  });
  trackEditorView(view);
  return view;
}


// Debounce function - to avoid multiple calls when typing
function debounce(func, wait) {
  let timeout;
  return function executedFunction(...args) {
    clearTimeout(timeout);
    timeout = setTimeout(() => func(...args), wait);
  };
}


// Debounced action function
const debouncedProcessTyping = debounce((editorName, flag, currentPositionofCursor) => {
  if (codemirrorDebuggerFlag) {
    console.log("Debounced processTyping called for editor: ", editorName);
  }
  Action.processTyping(editorName, flag, currentPositionofCursor); // call the action function
}, Action.waiting_time);


// a custom plugin to listen for any changes in the code editor
// and update the digram accordingly without triggering any events
const changeListenerPlugin = ViewPlugin.fromClass(class {
  constructor(view) {
  this.view = view;

  // We cannot use trim() here since we use Enter to go to the next line;
  this.lastContent = view.state.doc.toString();


  // Dispatch a change to the view

  }

  update(update) {
    
    if (update.docChanged) {
      // Debug: Check if the editor is updated
      if (codemirrorDebuggerFlag)
      console.log('Editor updated..');

      const newContent = update.state.doc.toString();
      const shouldSkipDebouncedTyping = update.transactions.some(transaction =>
        transaction.annotation(skipDebouncedTypingAnnotation));

      if (newContent !== this.lastContent) {
        const currentPositionofCursor = this.view.state.selection.main.head;

        // Debug: Check if the content has changed
        if (codemirrorDebuggerFlag) {
          console.warn('Content changed');
          console.log('new content lenght:', newContent.length);
          console.log('old content lenght:', this.lastContent.length);
          console.warn('details:', update.changes);
          console.log('shouldSkipDebouncedTyping:', shouldSkipDebouncedTyping);
        }

        this.lastContent = newContent;

        if (!shouldSkipDebouncedTyping) {
          debouncedProcessTyping("newEditor", false ,currentPositionofCursor); // call the debounced function
        }
      }
    }
    Action.updateLineNumberDisplay();
  }

  
});


// ---------------------------------------------------------------------------
// LSP Integration (Item 5: Transport + Item 6: Workspace)
// ---------------------------------------------------------------------------

// LSP compartment for dynamically adding/removing LSP extensions
const lspCompartment = new Compartment();

let lspClient = null;
let lspEnabled = false;

// Reconnection config
const LSP_RECONNECT_DELAYS = [1000, 2000, 4000, 8000];
const LSP_MAX_RECONNECT = LSP_RECONNECT_DELAYS.length;
let lspReconnectAttempt = 0;
let lspReconnectTimer = null;

// ---------------------------------------------------------------------------
// WebSocket Transport — implements @codemirror/lsp-client Transport
// ---------------------------------------------------------------------------

function createWebSocketTransport(wsUrl) {
  const handlers = new Set();
  let socket = null;

  function connect() {
    socket = new WebSocket(wsUrl);

    socket.onmessage = (event) => {
      const msg = typeof event.data === "string" ? event.data : event.data.toString();
      for (const handler of handlers) {
        try {
          handler(msg);
        } catch (e) {
          console.error("[lsp] handler error:", e);
        }
      }
    };

    socket.onerror = (err) => {
      console.warn("[lsp] WebSocket error:", err);
    };

    socket.onclose = (event) => {
      console.warn("[lsp] WebSocket closed:", event.code, event.reason);
      socket = null;
      // Immediately detach LSP client to stop requests on dead transport
      if (lspClient) {
        lspClient.disconnect();
      }
      // Remove LSP extensions from editor to prevent completion/sync noise
      if (lspAppendedToEditor && lspEditorView) {
        try {
          lspEditorView.dispatch({
            effects: lspCompartment.reconfigure([])
          });
        } catch (e) {
          // Editor may be gone
        }
      }
      lspEnabled = false;

      // Only reconnect on transient/retryable close codes
      const PERMANENT_CLOSE_CODES = new Set([
        4001, // Invalid session ID
        4002, // Model directory not found
        4003, // Invalid auth token
        4004, // Concurrent connection rejected
        4007, // Read-only token rejected
      ]);
      if (!PERMANENT_CLOSE_CODES.has(event.code)) {
        scheduleLspReconnect();
      } else {
        console.warn("[lsp] Permanent close code " + event.code + " — not reconnecting");
      }
    };

    return new Promise((resolve, reject) => {
      socket.onopen = () => resolve();
      socket.onerror = () => reject(new Error("WebSocket connection failed"));
    });
  }

  const transport = {
    send(message) {
      if (!socket || socket.readyState !== WebSocket.OPEN) {
        // Silently drop — client will be disconnected/reconnected
        return;
      }
      socket.send(message);
    },
    subscribe(handler) {
      handlers.add(handler);
    },
    unsubscribe(handler) {
      handlers.delete(handler);
    },
    close() {
      if (socket) {
        socket.onclose = null; // Prevent reconnect on intentional close
        socket.close();
        socket = null;
      }
    }
  };

  return { transport, connect };
}

// ---------------------------------------------------------------------------
// UmpleWorkspace — adapter beside existing TabControl
// ---------------------------------------------------------------------------

// Strip the post-delimiter layout tail from combined saved files.
// Saved .ump files contain: model_text + //$?[End_of_model]$? + layout_text
// The editor only shows model_text. LSP workspace must be model-only.
const UMPLE_MODEL_DELIMITER = "//$?[End_of_model]$?";

function stripLayoutTail(text) {
  if (!text) return text;
  const idx = text.indexOf(UMPLE_MODEL_DELIMITER);
  return idx === -1 ? text : text.substring(0, idx);
}

class UmpleWorkspace extends Workspace {
  constructor(client, umpBasePath, modelId) {
    super(client);
    this._files = [];
    this._umpBasePath = umpBasePath;
    this._modelId = modelId;
  }

  get files() {
    return this._files;
  }

  // Build properly encoded file:// URI from tab name
  _tabUri(tabName) {
    const fileName = tabName.endsWith(".ump") ? tabName : tabName + ".ump";
    return "file://" + this._umpBasePath + "/" + this._modelId + "/" + encodeURIComponent(fileName);
  }

  // Find file by normalized tab name — handles URI encoding and path differences
  getFile(uri) {
    const exact = this._files.find(f => f.uri === uri);
    if (exact) return exact;
    // Normalize both sides through _uriToTabName for encoding-safe comparison
    const targetName = this._uriToTabName(uri);
    if (targetName) {
      return this._files.find(f => this._uriToTabName(f.uri) === targetName) || null;
    }
    return null;
  }

  // Sync active editor changes to LSP — must match DefaultWorkspace contract
  // Uses plugin.unsyncedChanges (incremental) and calls plugin.clear() to reset
  syncFiles() {
    const updates = [];
    for (const file of this._files) {
      const view = file.getView();
      if (!view) continue;

      const plugin = LSPPlugin.get(view);
      if (!plugin) continue;

      const changes = plugin.unsyncedChanges;
      if (!changes.empty) {
        updates.push({ changes, file, prevDoc: file.doc });
        file.doc = view.state.doc;
        file.version++;
        plugin.clear();
      }
    }
    return updates;
  }

  // Called when editor binds to a file (active tab)
  openFile(uri, languageId, view) {
    let file = this.getFile(uri);
    if (file) {
      // Passive file becoming active — bind view and send didOpen if not already open
      const wasPassive = !file._view;
      file._view = view;
      file.doc = view.state.doc;
      if (wasPassive && !file._lspOpen) {
        this.client.didOpen(file);
        file._lspOpen = true;
      }
      return;
    }
    file = {
      uri,
      languageId,
      version: 0,
      doc: view.state.doc,
      _view: view,
      getView(main) { return this._view; }
    };
    this._files.push(file);
    this.client.didOpen(file);
    file._lspOpen = true;
  }

  // Called when editor unbinds from a file (tab switch away)
  // Keep file open with the server so it stays indexed for use-completion
  // and cross-file features. Only unbind the view.
  closeFile(uri, view) {
    const file = this.getFile(uri);
    if (!file) return;
    file._view = null;
    // Don't send didClose — file stays open with server as passive
  }

  // Called on connect — re-open active file and any _lspOpen passive files
  connected() {
    for (const file of this._files) {
      if (file._view || file._lspOpen) {
        this.client.didOpen(file);
        file._lspOpen = true;
      }
    }
  }

  disconnected() {
    // Files stay tracked for reconnection
  }

  // Hydrate and return an inactive file for references panel
  // Fix #2: Use localStorage directly via TabControl.getTabFilename
  requestFile(uri) {
    const existing = this.getFile(uri);
    if (existing) return Promise.resolve(existing);

    const tabName = this._uriToTabName(uri);
    if (tabName && typeof TabControl !== "undefined" && typeof Page !== "undefined") {
      const filename = TabControl.getTabFilename(tabName);
      const cachedText = stripLayoutTail(localStorage[filename]);
      if (cachedText !== null && cachedText !== undefined) {
        const file = {
          uri,
          languageId: "umple",
          version: 0,
          doc: Text.of(cachedText.split("\n")),
          _view: null,
          getView() { return null; }
        };
        this._files.push(file);
        return Promise.resolve(file);
      }
    }

    return Promise.resolve(null);
  }

  // Switch to a tab for cross-file jump
  // Fix #1: Use tab ID, not tab name, for TabControl.selectTab()
  displayFile(uri) {
    const tabName = this._uriToTabName(uri);
    if (!tabName) return Promise.resolve(null);

    if (typeof TabControl !== "undefined" && TabControl.selectTab) {
      // Find the tab ID by matching tab name
      const tabId = this._findTabIdByName(tabName);
      if (tabId === null) return Promise.resolve(null);

      TabControl.selectTab(tabId);
      // After tab switch, the editor view should be available
      return new Promise((resolve) => {
        setTimeout(() => {
          const file = this.getFile(uri);
          resolve(file ? file.getView() : null);
        }, 100);
      });
    }
    return Promise.resolve(null);
  }

  // Apply server-initiated edits (rename)
  updateFile(uri, update) {
    const file = this.getFile(uri);
    if (!file) return;

    const view = file.getView();
    if (view) {
      // Active tab — dispatch to editor
      view.dispatch(update);
    } else {
      // Inactive tab — apply to cached doc and notify LSP server
      // update.changes is a ChangeSpec array from the rename handler, not a ChangeSet
      if (update.changes) {
        // Extract old name before applying changes (for layout declaration update)
        let oldName = null, newName = null;
        const first = update.changes[0];
        if (first && first.from !== undefined && first.to !== undefined) {
          oldName = file.doc.sliceString(first.from, first.to);
          newName = first.insert;
        }

        const changeSet = ChangeSet.of(update.changes, file.doc.length);
        file.doc = changeSet.apply(file.doc);
        file.version++;

        // Notify LSP server about the passive file change
        if (this.client) {
          if (!file._lspOpen) {
            this.client.didOpen(file);
            file._lspOpen = true;
          } else {
            this.client.notification("textDocument/didChange", {
              textDocument: { uri: file.uri, version: file.version },
              contentChanges: [{ text: file.doc.toString() }]
            });
          }
        }

        // Build full content: model + updated layout suffix
        const tabName = this._uriToTabName(uri);
        if (tabName && typeof TabControl !== "undefined" && typeof Page !== "undefined") {
          const filename = TabControl.getTabFilename(tabName);
          const existing = localStorage[filename] || "";
          const delimIdx = existing.indexOf(UMPLE_MODEL_DELIMITER);

          let fullContent;
          if (delimIdx !== -1) {
            let layoutSuffix = existing.substring(delimIdx);
            // Bounded declaration replacement: only "class OldName" in layout
            if (oldName && newName && oldName !== newName) {
              const escaped = oldName.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
              layoutSuffix = layoutSuffix.replace(
                new RegExp('(\\bclass\\s+)' + escaped + '\\b', 'g'),
                '$1' + newName
              );
            }
            fullContent = file.doc.toString() + layoutSuffix;
          } else {
            fullContent = file.doc.toString();
          }

          // Save to both localStorage and disk via existing save contract
          const tabId = this._findTabIdByName(tabName);
          if (tabId !== null) {
            TabControl.saveTab(tabId, fullContent);
          } else {
            // Fallback: at least update localStorage if tab ID not found
            localStorage[filename] = fullContent;
          }
        }
      }
    }
  }

  // Add a passive file (no view, no didOpen) for workspace tracking
  addPassiveFile(tabName, content) {
    const uri = this._tabUri(tabName);
    if (this.getFile(uri)) return;
    this._files.push({
      uri,
      languageId: "umple",
      version: 0,
      doc: Text.of(stripLayoutTail(content || "").split("\n")),
      _view: null,
      _lspOpen: false,
      getView() { return null; }
    });
  }

  // Remove a tracked file entirely (tab deleted)
  removeFile(tabName) {
    const uri = this._tabUri(tabName);
    const file = this.getFile(uri);
    if (!file) return;
    // Close with server if open (active or passively opened)
    if (file._view || file._lspOpen) {
      this.client.didClose(file.uri);
    }
    const idx = this._files.indexOf(file);
    if (idx !== -1) {
      this._files.splice(idx, 1);
    }
  }

  // Find tab ID by tab name (for TabControl.selectTab which takes ID)
  _findTabIdByName(tabName) {
    if (typeof TabControl === "undefined") return null;
    for (const id in TabControl.tabs) {
      if (TabControl.tabs[id].name === tabName) {
        return id;
      }
    }
    return null;
  }

  // Extract tab name from URI — with basename fallback because server may
  // return filesystem URIs that differ from our constructed prefix
  // Extract decoded tab name from any file:// URI
  // Handles both our constructed URIs and server filesystem URIs
  // Decodes URL-encoded characters (e.g., %20 → space)
  _uriToTabName(uri) {
    // Try exact prefix match first
    const prefix = "file://" + this._umpBasePath + "/" + this._modelId + "/";
    let encoded;
    if (uri.startsWith(prefix)) {
      encoded = uri.slice(prefix.length);
    } else {
      // Basename fallback for server filesystem URIs
      encoded = uri.split("/").pop();
    }
    if (!encoded) return null;
    // Decode and strip .ump extension
    try {
      const decoded = decodeURIComponent(encoded);
      if (decoded.endsWith(".ump")) {
        return decoded.replace(/\.ump$/, "");
      }
    } catch {
      // Malformed URI encoding — try raw
      if (encoded.endsWith(".ump")) {
        return encoded.replace(/\.ump$/, "");
      }
    }
    return null;
  }
}

// ---------------------------------------------------------------------------
// LSP Initialization
// ---------------------------------------------------------------------------

let currentWorkspace = null;
let currentTransportObj = null;
let lspAppendedToEditor = false; // Track first-init vs reconnect
let lspEditorView = null; // Reference to the editor view for cleanup on disconnect
let lspInitPromise = null; // In-flight init guard

function buildLspWsUrl(baseUrl, modelId, token) {
  const sep = baseUrl.includes("?") ? "&" : "?";
  return baseUrl + sep + "session=" + encodeURIComponent(modelId) + "&token=" + encodeURIComponent(token);
}

function initLsp(view, config) {
  const { wsUrl, token, modelId, umpBasePath, activeTabName } = config;

  if (!wsUrl || !modelId) {
    return Promise.resolve(false);
  }

  // Guard 1: already active
  if (lspEnabled && lspClient) {
    return Promise.resolve(true);
  }

  // Guard 2: already in flight
  if (lspInitPromise) {
    return lspInitPromise;
  }

  lspInitPromise = _doInitLsp(view, config);
  lspInitPromise.finally(() => { lspInitPromise = null; });
  return lspInitPromise;
}

async function _doInitLsp(view, config) {
  const { wsUrl, token, modelId, umpBasePath, activeTabName } = config;

  lspEditorView = view; // Store for cleanup on disconnect

  // Build WebSocket URL
  let fullWsUrl;
  if (wsUrl.startsWith("/")) {
    // Same-origin relative path — convert to ws:// or wss://
    const proto = window.location.protocol === "https:" ? "wss:" : "ws:";
    fullWsUrl = proto + "//" + window.location.host + wsUrl;
  } else {
    fullWsUrl = wsUrl;
  }
  fullWsUrl = buildLspWsUrl(fullWsUrl, modelId, token);

  // Create transport
  const { transport, connect } = createWebSocketTransport(fullWsUrl);
  currentTransportObj = { transport, connect, close: transport.close };

  // Create client with custom workspace
  const rootUri = "file://" + umpBasePath + "/" + modelId;
  lspClient = new LSPClient({
    rootUri,
    workspace: (client) => {
      currentWorkspace = new UmpleWorkspace(client, umpBasePath, modelId);
      return currentWorkspace;
    },
    extensions: [serverDiagnostics()],
  });

  // Connect
  try {
    await connect();
    lspClient.connect(transport);
    await lspClient.initializing;
    lspEnabled = true;
    lspReconnectAttempt = 0;

    // Build the URI for the active tab
    const activeUri = currentWorkspace._tabUri(activeTabName || "model");
    const lspExt = languageServerSupport(lspClient, activeUri, "umple");

    // First init: append compartment. Reconnect: reconfigure existing compartment.
    if (!lspAppendedToEditor) {
      view.dispatch({
        effects: StateEffect.appendConfig.of(lspCompartment.of(lspExt))
      });
      lspAppendedToEditor = true;
    } else {
      view.dispatch({
        effects: lspCompartment.reconfigure(lspExt)
      });
    }

    return true;
  } catch (err) {
    console.warn("[lsp] Connection failed:", err.message);
    lspEnabled = false;
    return false;
  }
}

function scheduleLspReconnect() {
  if (lspReconnectAttempt >= LSP_MAX_RECONNECT) {
    console.warn("[lsp] Max reconnect attempts reached. LSP disabled.");
    lspEnabled = false;
    return;
  }

  const delay = LSP_RECONNECT_DELAYS[lspReconnectAttempt] || 8000;
  lspReconnectAttempt++;
  console.log(`[lsp] Reconnecting in ${delay}ms (attempt ${lspReconnectAttempt}/${LSP_MAX_RECONNECT})`);

  if (lspReconnectTimer) clearTimeout(lspReconnectTimer);
  lspReconnectTimer = setTimeout(() => {
    // Reconnection needs to be driven from umple_page.js
    // since it needs access to the editor view and config
    if (typeof window !== "undefined" && window.umpleLspReconnect) {
      window.umpleLspReconnect();
    }
  }, delay);
}

function disconnectLsp() {
  lspEnabled = false;
  if (lspReconnectTimer) {
    clearTimeout(lspReconnectTimer);
    lspReconnectTimer = null;
  }
  if (lspClient) {
    lspClient.disconnect();
    lspClient = null;
  }
  if (currentTransportObj) {
    currentTransportObj.close();
    currentTransportObj = null;
  }
  currentWorkspace = null;
}

// Switch LSP to a different tab file
// Reconfigures the LSP plugin compartment — the plugin lifecycle handles
// workspace closeFile (on destroy) and openFile (on create) automatically.
function switchLspFile(view, tabName) {
  if (!currentWorkspace || !lspClient || !lspEnabled) return;

  const newUri = currentWorkspace._tabUri(tabName);

  // Reconfigure the LSP plugin to the new URI.
  // Old LSPPlugin.destroy() calls workspace.closeFile(oldUri, view)
  // New LSPPlugin constructor calls workspace.openFile(newUri, languageId, view)
  view.dispatch({
    effects: lspCompartment.reconfigure(
      languageServerSupport(lspClient, newUri, "umple")
    )
  });
}

// ---------------------------------------------------------------------------
// Public workspace mutation wrappers (currentWorkspace is module-private)
// All are no-ops when LSP is not initialized.
// ---------------------------------------------------------------------------

function lspAddPassiveFile(tabName, content) {
  if (!currentWorkspace) return;
  currentWorkspace.addPassiveFile(tabName, content);
}

function lspRemoveFile(tabName) {
  if (!currentWorkspace) return;
  currentWorkspace.removeFile(tabName);
}

function lspRenameFile(oldName, newName) {
  if (!currentWorkspace) return;
  const oldUri = currentWorkspace._tabUri(oldName);
  const newUri = currentWorkspace._tabUri(newName);
  const file = currentWorkspace.getFile(oldUri);
  if (!file) return;

  if (file._view && lspClient && lspEnabled) {
    // Active file rename: preserve didClose(oldUri) → didOpen(newUri) lifecycle.
    // 1. DO NOT mutate file.uri yet — plugin destroy needs oldUri for closeFile
    // 2. Reconfigure compartment — destroys old plugin (closeFile(oldUri)),
    //    but new plugin will call openFile(newUri) and not find it yet.
    // So: let destroy happen with old URI, then mutate, then let create open new URI.

    const view = file._view;

    // Step 1: Temporarily remove file from workspace so destroy's closeFile
    // finds it with the OLD uri and demotes it properly
    // (closeFile sets _view = null, sends didClose(oldUri))

    // Step 2: Now mutate the URI
    file.uri = newUri;

    // Step 3: Reconfigure — old plugin destroy calls closeFile(oldUri),
    // but file.uri is already newUri so closeFile won't find oldUri.
    // We need to send didClose manually for the old URI.
    lspClient.didClose(oldUri);
    file._view = null;

    // Step 4: Reconfigure with new URI — new plugin calls openFile(newUri)
    // openFile finds the file (now with newUri), sees _view is null (passive),
    // binds view, sends didOpen(newUri)
    view.dispatch({
      effects: lspCompartment.reconfigure(
        languageServerSupport(lspClient, newUri, "umple")
      )
    });
  } else {
    // Passive file rename: just mutate URI, no lifecycle needed
    file.uri = newUri;
  }
}

function isLspActive() {
  return lspEnabled && lspClient !== null;
}

export { createEditorState, createEditorView,
  EditorSelection, SearchCursor, RegExpCursor, changeListenerPlugin,
  EditorView, ViewPlugin, ViewUpdate, Text, ChangeSet, StateEffect,
  receiveUpdates, sendableUpdates, collab, getSyncedVersion, Compartment, editableCompartment,
  prefersDarkMode, onDarkModePreferenceChange, setDarkMode, setDarkModePreference,
  skipDebouncedTypingAnnotation,
  lspCompartment, initLsp, disconnectLsp, switchLspFile,
  lspAddPassiveFile, lspRemoveFile, lspRenameFile, isLspActive
}
