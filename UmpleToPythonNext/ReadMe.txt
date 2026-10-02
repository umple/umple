UmpleToPythonNext holds the UmpleTL templates of PythonNext, the Python generator that works from
the model directly. The build compiles UmpleTLTemplates/Master.ump into
cruise.umple.compiler.pythonnext.PythonNextClassGenerator and PythonNextInterfaceGenerator, which
cruise.umple/src/generators/Generator_CodePythonNext*.ump drive. The original Python generator
(UmpleToPython, TXL) is unchanged and still selected by "generate Python".

A template with a Java counterpart has the name of the Java template with the same behaviour
(UmpleToJava/UmpleTLTemplates/<same name>.ump), so the two can be read side by side. A change to the
behaviour of a Java template needs the same change here, with a test, or an issue that records the
difference.

Tests: the template tests in cruise.umple/test/.../implementation/pynext and
statemachine/implementation/pynext, the compiler tests named PythonNext*Test, and the runtime
testbed in testbed_pythonnext.

Corpus gate: build/pythonnext_corpus_gate.py generates PythonNext output for every model matched by
the "corpus" patterns of build/pythonnext_corpus_manifest.json and checks each against the outcome
the manifest gives it (the outcomes are described at the top of the script). A new model file in
one of those folders needs an entry. Check one case with
  python3 build/pythonnext_corpus_gate.py --only <path of the model>

Public API baselines: build/pythonnext_corpus_api.json and testbed_pythonnext/test/compat/
testbed_api.json record the API the original Python generator produced. A deliberate change to the
generated API edits the entry by hand, or moves the member to "excluded" with its reason and a test
in testbed_pythonnext/test/compat/ledger_test.py.
