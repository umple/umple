import {basicSetup} from "codemirror"
import {EditorView, keymap} from "@codemirror/view"
import {syntaxHighlighting} from "@codemirror/language"
import {indentWithTab} from "@codemirror/commands"
import {javascript} from "@codemirror/lang-javascript"
import {java} from "@codemirror/lang-java"
import {python} from "@codemirror/lang-python"
import {umple} from "./umple.js"
import {tags} from "@lezer/highlight"
import {HighlightStyle} from "@codemirror/language"

// Template: {tag: tags., color: "#"},
// Template: {tag: tags., color: "#", fontStyle: "italic"},
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

  {tag: tags.atom, color: "#EA983F"}, // Test Orange
])

let editor = new EditorView({
  extensions: [
    basicSetup, 
    keymap.of([indentWithTab]),
    syntaxHighlighting(myHighlightStyle),
    umple()
    ],
  // extensions: [basicSetup, javascript()],
  // extensions: [basicSetup, java()],
  parent: document.body
})