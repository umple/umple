import { parser } from "./parser.js"
import { syntaxTree, LRLanguage, indentNodeProp, continuedIndent, flatIndent, delimitedIndent, foldNodeProp, foldInside, defineLanguageFacet, sublanguageProp, LanguageSupport, HighlightStyle } from "@codemirror/language"
import { snippetCompletion, ifNotIn, completeFromList } from "@codemirror/autocomplete"
import { Tag, styleTags, tags as t } from "@lezer/highlight"
import { NodeWeakMap, IterMode } from '@lezer/common';

let parserWithMetadata = parser.configure({
  props: [
    styleTags({
      // "glossary distributable strictness disable generate use top namespace req implementsReq": t.modifier,
      // "public protected private static synchronized queued abstract": t.modifier,
      // Modifier: t.modifier,
      // Integer: t.bool,
      identifier: t.name,
      InlineComment: t.lineComment,
      MultilineComment: t.blockComment,
      // MarkerAnnotation: t.docComment,
      name: t.docComment,
      Integer: t.integer,
      // Asterisk: t.lineComment,
      MultiplicityInteger: t.literal,
      Asterisk: t.literal,
      Arrow: t.literal,
      DoubleDots: t.literal,
      Name: t.keyword,
      InterfaceDefinitionName: t.keyword,
      MethodName: t.color,
      NestedType: t.bool,
      InlineStateMachineName: t.keyword,
      // Action: t.heading,
      FromState: t.typeName,
      ToState: t.heading1,
      StateNameDestination: t.heading1,
      EventName: t.heading,
      // FromState: t.heading,
      // ToState: t.heading1,
      StateName: t.keyword,
      StringLiteral: t.string,
      NameOfTypedName: t.keyword,
      ClassName: t.typeName,
      BaseType: t.typeName,
      ExtendsName: t.typeName,
      MethodName: t.keyword,
      AssociationEndName: t.keyword,
      // Normal: t.atom,
      // NormalWithout: t.heading,

      "class queued pooled immutable equals unspecified afterEvery after public static void unique lazy ivar association singleton isA do opt not and or xor XOR implementsReq req mixset namespace --redefine use abstract depend interface internal constant const trait associationClass statemachine entry exit return": t.definitionKeyword,
      "generate Java Nothing Php RTCpp SimpleCpp Ruby Python Cpp Json StructureDiagram Yuml Violet Umlet Simulate TextUml Scxml GvStateDiagram GvClassDiagram GvFeatureDiagram GvClassTraitDiagram GvEntityRelationshipDiagram Alloy NuSMV NuSMVOptimizer Papyrus Ecore Xmi Xtext Sql Umple UmpleSelf USE Test SimpleMetrics PlainRequirementsDoc Uigu2 -s --suboption": t.definitionKeyword,
      "module package import": t.moduleKeyword,

      SimpleAttributeName: t.bool,

      ["requires exports opens uses provides public private protected static transitive abstract final " +
        "strictfp synchronized native transient volatile throws"]: t.modifier,
      IntegerLiteral: t.integer,
      FloatingPointLiteral: t.float,
      // "StringLiteral TextBlock": t.string,
    }),
    indentNodeProp.add({
      // ClassDefinition: continuedIndent(),
      // AssociationDefinition: continuedIndent(),
      // InlineStateMachine: continuedIndent(),
      MethodBody: continuedIndent(),
      // Application: context => context.column(context.node.from) + context.unit
    }),
    foldNodeProp.add({
      "ClassBody": foldInside,
      "InterfaceDefinitionBody": foldInside,
      "InlineStateMachineBody": foldInside,
      "MethodBody": foldInside,
    })
  ]
})

export const umpleLanguage = LRLanguage.define({
  parser: parserWithMetadata,
  languageData: {
    closeBrackets: { brackets: ["(", "[", "{", "'", '"', "`"] },
    commentTokens: { line: "//", block: { open: "/*", close: "*/" } },
    indentOnInput: /^\s*(?:case |default:|\{|\})$/,
    // wordChars: "$"
  }
})

// const tagOptions = [
//   "constructor", "deprecated", "link", "param", "returns", "type"
// ].map(tag => ({ label: "@" + tag, type: "keyword" }))

// const tagOptions = [
//   "association", "class"
// ].map(tag => (snippetCompletion(tag + " ${name} {\n\t${}\n}", {
//         label: tag,
//         detail: "Entity",
//         type: "keyword"
//       })))

const classTag = snippetCompletion("class ${className} {\n\t${}\n}", {
  label: "class",
  info: "Add a new top level class",
  type: "keyword",
  section: "Top Level",
  boost: 81
});

const traitTag = snippetCompletion("trait ${traitName} {\n\t${}\n}", {
  label: "trait",
  info: "Add a trait with code to blend into classes",
  type: "keyword",
  section: "Top Level",
  boost: 75
});

const interfaceTag = snippetCompletion("interface ${interfaceName} {\n\t${}\n}", {
  label: "interface",
  info: "Add an interface describing valid method signatures",
  type: "keyword",
  section: "Top Level",
  boost: 69
});

const useTag = snippetCompletion("use ${useName}${}", {
  label: "useStatement",
  info: "Include Umple code from another file, a mixset, a library or a URL",
  type: "keyword",
  section: "Top Level",
  boost: 63
});

const associationTag = snippetCompletion("association {\n\t${}\n}", {
  label: "association",
  info: "Specify an association between two classes; can also be done within a class",
  type: "keyword",
  section: "Top Level",
  boost: 57
});

const associationClassTag = snippetCompletion("associationClass {\n\t${}\n}", {
  label: "associationClass",
  info: "Specify a class relating two other classes",
  type: "keyword",
  section: "Top Level",
  boost: 51
});

const mixsetTag = snippetCompletion("mixset ${mixsetName} {\n\t${}\n}", {
  label: "mixset",
  info: "Specify optional code that could be mixed in",
  type: "keyword",
  section: "Top Level",
  boost: 45
});

const namespaceTag = snippetCompletion("namespace ${namespaceName};${}", {
  label: "namespace",
  info: "Designate the package for generated code",
  type: "keyword",
  section: "Top Level",
  boost: 39,
});

const generateTag = snippetCompletion("generate ${language};${}", {
  label: "generate",
  info: "Specify output to generate - default is Java or as specified by the UI",
  type: "keyword",
  section: "Top Level",
  boost: 33
});

const attributeTag = snippetCompletion("${const} ${type} ${attributeName} = ${\"value\"};${}", {
  label: "attribute",
  info: "Specify data to be contained in all instances of this class",
  type: "keyword",
  section: "Class Content",
  boost: 81
});

const inlineAssociationTag = snippetCompletion("${0..1} ${roleName1} ${<@>-} ${*} ${type} ${roleName2};${}", {
  label: "inlineAssociation",
  info: "Specify an association to another class",
  type: "keyword",
  section: "Class Content",
  boost: 75
});

const stateMachineTag = snippetCompletion("${stateMachineName} {\n\t${}\n}", {
  label: "stateMachine",
  info: "Define behaviour for this class",
  type: "keyword",
  section: "Class Content",
  boost: 69,
});

const concreteMethodTag = snippetCompletion("${type} ${methodDeclarator}(${}) {\n\t${}\n}", {
  label: "concreteMethod",
  info: "Specify a method whose behavior will be specfic in this state",
  type: "function",
  section: "Class Content",
  boost: 63
});

const subClassTag = snippetCompletion("class ${className} {\n\t${}\n}", {
  label: "subClass",
  info: "Specify a subclass",
  type: "keyword",
  section: "Class Content",
  boost: 57
});

const stateTag = snippetCompletion("${stateName} {\n\t${}\n}", {
  label: "state",
  info: "One of the states this object can be in",
  type: "keyword",
  boost: 30
});

const standAloneTransitionTag = snippetCompletion("${eventName()} ${fromState} -> ${destination};${}", {
  label: "standAloneTransition",
  info: "Indicate an event (method call) that will trigger a transition to another state",
  type: "function",
  boost: 24
});

const transitionTag = snippetCompletion("${eventName()} -> ${stateName};${}", {
  label: "transition",
  info: "Indicate an event (method call) that will trigger a transition to another state",
  type: "function",
  boost: 69
});

const abstractMethodTag = snippetCompletion("${type} ${methodDeclarator}(${});", {
  label: "abstractMethod",
  info: "Specify a method signature",
  type: "function",
  section: "Interface",
  boost: 60
});

const topLeveltagOptions = [
  classTag, traitTag, interfaceTag, useTag, associationTag, associationClassTag, mixsetTag, namespaceTag, generateTag
];

// Comment | ClassDefinition | SoftwarePattern | Attribute | StateMachine | InlineAssociation | ConcreteMethodDeclaration | ";"

const classContentTagOptions = [
  attributeTag, inlineAssociationTag, stateMachineTag, subClassTag
]

const inlineStateMachineTagOptions = [
  stateTag, standAloneTransitionTag
]

const stateInternalTagOptions = [
  transitionTag, concreteMethodTag
]

const interfaceBodyTagOptions = [
  abstractMethodTag
]

function completeUmple(context) {
  let nodeBefore = syntaxTree(context.state).resolveInner(context.pos, -1)
  
  if (nodeBefore.name == "Program"
  // && RegExp(/^ *$/).test(context.state.sliceDoc(nodeBefore.from, context.pos))
  // ||  context.state.sliceDoc(nodeBefore.from, nodeBefore.from + 3) != "/**"
  ) { 
    let textBefore = context.state.sliceDoc(nodeBefore.from, context.pos)
    let tagBefore = /\w*$/.exec(textBefore)
    if (!tagBefore && !context.explicit) return null
    return {
      from: tagBefore ? nodeBefore.from + tagBefore.index : context.pos,
      options: topLeveltagOptions,
      validFor: /^(\w*)?$/
    }
   }
  else if (nodeBefore.name == "ClassBody"
  ) {
    let textBefore = context.state.sliceDoc(nodeBefore.from, context.pos)
    let tagBefore = /\w*$/.exec(textBefore)
    if (!tagBefore && !context.explicit) return null
    return {
      from: tagBefore ? nodeBefore.from + tagBefore.index : context.pos,
      options: classContentTagOptions,
      validFor: /^(\w*)?$/
    }
  }
  else if (nodeBefore.name == "InlineStateMachineBody") {
    let textBefore = context.state.sliceDoc(nodeBefore.from, context.pos)
    let tagBefore = /\w*$/.exec(textBefore)
    if (!tagBefore && !context.explicit) return null
    return {
      from: tagBefore ? nodeBefore.from + tagBefore.index : context.pos,
      options: inlineStateMachineTagOptions,
      validFor: /^(\w*)?$/
    }
  }
  else if (nodeBefore.name == "StateBody") {
    let textBefore = context.state.sliceDoc(nodeBefore.from, context.pos)
    let tagBefore = /\w*$/.exec(textBefore)
    if (!tagBefore && !context.explicit) return null
    return {
      from: tagBefore ? nodeBefore.from + tagBefore.index : context.pos,
      options: stateInternalTagOptions,
      validFor: /^(\w*)?$/
    }
  }
  else if (nodeBefore.name == "InterfaceDefinitionBody"
  ) {
    let textBefore = context.state.sliceDoc(nodeBefore.from, context.pos)
    let tagBefore = /\w*$/.exec(textBefore)
    if (!tagBefore && !context.explicit) return null
    return {
      from: tagBefore ? nodeBefore.from + tagBefore.index : context.pos,
      options: interfaceBodyTagOptions,
      validFor: /^(\w*)?$/
    }
  }
}

export const umpleCompletion = umpleLanguage.data.of({
  autocomplete: 
    // localCompletionSource,
    // scopeCompletionSource,
    completeUmple,

    // completeFromList([
    //   {label: "public", type: "keyword"},
    //   {label: "private", type: "keyword"},
    //   {label: "stateMachine", type: "function"},
    //   snippetCompletion("class ${name} {\n\t${}\n}", {
    //     label: "class",
    //     detail: "definition",
    //     type: "function"
    //   }),
    //   snippetCompletion("${name} {\n\t${}\n}", {
    //     label: "sm",
    //     detail: "definition",
    //     type: "function"
    //   }),
    // ]), 
})

export function umple() {
  return new LanguageSupport(umpleLanguage, [umpleCompletion])
}