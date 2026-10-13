UmpleToPython holds the UmpleTL templates of the Python code generator. The build compiles
UmpleTLTemplates/Master.ump into the classes cruise.umple.compiler.python.PythonClassGenerator and
PythonInterfaceGenerator, which cruise.umple/src/generators/Generator_CodePython*.ump drive.

Each template that has a Java counterpart keeps the name of the Java template with the same
behaviour (UmpleToJava/UmpleTLTemplates/<same name>.ump), so the two can be read side by side.

Keeping Python in step with Java: the Python templates are written beside the Java ones, not
generated from them, so they change by hand when Java's output does. By what changed:

  - A new model in a folder the corpus gate checks: classify it in the manifest (see Corpus gate).
  - What a Java template generates, such as a new public method: make the same change in the Python
    template of the same name, with a test. The gate reports "missing Java's public method" for
    each model Python supports until Python has it. If Python cannot have the feature yet, report
    it with error 9210 instead (see unsupportedFeature in
    cruise.umple/src/generators/Generator_CodePython.ump) and classify the models that use it as
    "unsupported 9210: why".
  - How the generated code behaves, with the same methods: the gate does not compare Java's
    behaviour with Python's, so make the same change with a test, or open an issue that records
    the difference.

Tests: the shared template tests run for Python through their subclasses in the py folders beside
them (expected output in *.py.txt); a shared test without one, such as ToJsonTest, runs for Java
only. The Python testbed (testbed_python) mirrors the Java testbed's scenarios.

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
If the generator reports a diagnostic the model deserves, record it with the reason after the colon.

Public API baselines: build/python_corpus_api.json (for some UmpleOnline examples) and
testbed_python/test/compat/testbed_api.json (for the testbed) record the public API that the
previous Python generator produced. A change to the generated API on purpose edits the entry by
hand; in the testbed file a member can instead move to "excluded" with its reason, with a test in
testbed_python/test/compat/ledger_test.py for the new behaviour.
