UmpleToJavaScript holds the UmpleTL templates of the JavaScript code generator. The build compiles
UmpleTLTemplates/Master.ump into the class cruise.umple.compiler.javascript.JavaScriptClassGenerator,
which cruise.umple/src/generators/Generator_CodeJavaScript.ump drives.

Each template that has a Java counterpart keeps the name of the Java template with the same
behaviour (UmpleToJava/UmpleTLTemplates/<same name>.ump), so the two can be read side by side.

What the generator writes: one CommonJS module per class, ClassName.js, in the folder given by the
class's namespace. The module declares the class, exports it with module.exports, and requires the
superclass before the declaration and the other classes that methods written in the model use after
the export, so that two classes using each other both load.

What the generator refuses: Generator_CodeJavaScript.ump decides, in problems(UmpleClass, CodeTranslator), what
stops a class being generated. A class that is refused gets a diagnostic and no file at all, never a
stub, and the compilation then fails, so the command line exits with a non-zero status; the other
classes of the model are still generated. The diagnostics are E9220 (a feature JavaScript generation
does not cover yet, including a superclass that is not generated and two methods that would share a
name), E9221 (a name JavaScript reserves or that a CommonJS module uses) and W9222 (a method written
only for other languages, which is left out of the class while the class is still generated).
duplicateMethod collects the names the templates declare, as Umple's own duplicate check does for
attributes (error 48), so a name clash is reported before anything is written and a subclass of the
class is reported as well. Their
manual pages are build/reference/9939E9220JavaScriptUnsupported.txt, 9940E9221JavaScriptReservedName.txt
and 9941W9222JavaScriptNoJavaScriptCode.txt; build/reference/14060JavaScript.txt lists what is
supported and what is not.

Methods written in the model: a body tagged JavaScript is used as written, and so is an untagged
body, which every language falls back to. Add JavaScript to the codeLang alternatives of
cruise.umple/src/class/umple_classes.grammar if that list ever changes.

Tests:
  - cruise.umple/test/cruise/umple/implementation/js/JavaScriptClassTemplateTest.java compares the
    generated text with the saved *.js.txt files and checks what the generator refuses. Every model
    it generates is also parsed with "node --check" when Node is available (see
    assertGeneratedJavaScriptParses in cruise.umple/test/cruise/umple/implementation/TemplateTest.java).
  - cruise.umple/test/cruise/umple/implementation/js/JavaScriptDiagnosticsTest.java generates small
    models of its own, checks each diagnostic, and runs the generated modules in Node.
  - testbed_js holds the executable testbed: testbed_js/src is generated into
    testbed_js/src-gen-umple by the Ant target compileJavaScript, and testbed_js/test/AllTests.js
    runs the tests beside it with Node's assert (Ant target testJavaScript, both in
    build/build.testbed.xml). Update the INVENTORY count in AllTests.js when adding tests.
