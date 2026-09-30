UmpleToPython holds the UmpleTL templates of the Python code generator. The build compiles
UmpleTLTemplates/Master.ump into the classes cruise.umple.compiler.python.PythonClassGenerator and
PythonInterfaceGenerator, which cruise.umple/src/generators/Generator_CodePython*.ump drive.

Each template that has a Java counterpart keeps the name of the Java template with the same
behaviour (UmpleToJava/UmpleTLTemplates/<same name>.ump), so the two can be read side by side.

Drift rule: Umple's semantics are implemented by both the Java and the Python templates. A change
to the behaviour of a Java template needs the same change in the Python template of the same name,
with a test, or an issue that records the difference. The template tests run every shared test
model for Python too, and the Python testbed (testbed_python) mirrors the Java testbed's scenarios.

Corpus gate: build/python_corpus_gate.py generates Python for every example, manual example,
testbed model and shared test model matched by the "corpus" patterns of
build/python_corpus_manifest.json, and checks each against the outcome the manifest gives it. It
runs in the Ant target newUserManualAndExampleTestsPython and in the Gradle build. A new model file
in one of those folders needs an entry, or the gate fails with "not classified in the manifest".
The outcomes, detailed at the top of the gate script, are:

  supported             Python is generated, compiles, imports and has every public Java method
  generation-only       the model's own code is not Python, so only generation is checked
  unsupported CODES: why generation fails with exactly the error CODES, comma-separated
                        (for example 9210 or 9210,9211); the other classes' modules compile, unless
                        written "unsupported CODES generation-only: why" (the model's code is Java)
  invalid CODES: why    the model is not valid Umple: exactly the errors CODES
  fragment              a file other models include; not generated on its own

Start a new entry as "supported" and check it alone with
  python3 build/python_corpus_gate.py --only <path of the model>
If Python reports a diagnostic the model deserves, record it with the reason after the colon.

Public API baselines: build/python_corpus_api.json (for some UmpleOnline examples) and
testbed_python/test/compat/testbed_api.json (for the testbed) record the public API that the
previous Python generator produced. A change to the generated API on purpose edits the entry by
hand; in the testbed file a member can instead move to "excluded" with its reason, with a test in
testbed_python/test/compat/ledger_test.py for the new behaviour.
