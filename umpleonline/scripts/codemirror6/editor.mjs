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


export { createEditorState, createEditorView, 
  EditorSelection, SearchCursor, RegExpCursor, changeListenerPlugin,
  EditorView, ViewPlugin, ViewUpdate, Text, ChangeSet, StateEffect,
  receiveUpdates, sendableUpdates, collab, getSyncedVersion, Compartment,editableCompartment,
  prefersDarkMode, onDarkModePreferenceChange, setDarkMode, setDarkModePreference,
  skipDebouncedTypingAnnotation
}
