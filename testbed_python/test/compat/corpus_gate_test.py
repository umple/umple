import importlib
import os
import sys
import tempfile
import unittest
from pathlib import Path

HERE = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, os.path.join(HERE, os.pardir, os.pardir, os.pardir, "build"))
from python_corpus_gate import batch_results, left_out_method, module_problems, parse_expectation, prepare_output


# The corpus gate excuses a generated class for missing only the methods Umple says it left out.
class CorpusGateTest(unittest.TestCase):
    def test_onlyAMethodLeftOutIsExcusedFromTheExpectedApi(self):
        self.assertEqual("isJava", left_out_method(
            "Method isJava has code only for Java, Php, so it is left out of the generated Python"))
        # An action or injection is left out, but the setter or event it belongs to stays
        self.assertIsNone(left_out_method(
            "After injection of setLevel has code only for Java, so it is left out of the generated Python"))
        self.assertIsNone(left_out_method(
            "The action of the transition on start from state Idle has code only for Java, so it is left out"
            " of the generated Python"))

    def test_anUnsupportedCaseListsEveryErrorItRaises(self):
        self.assertEqual(("unsupported", ["9210", "9211"], False, "queued machine"),
                         parse_expectation("unsupported 9210,9211: queued machine"))
        # the model's own code is Java, so what is generated for its other classes is not compiled
        self.assertEqual(("unsupported", ["9210"], True, "emit"), parse_expectation("unsupported 9210 generation-only: emit"))
        self.assertEqual(("supported", None, False, ""), parse_expectation("supported"))
        with self.assertRaises(ValueError):
            parse_expectation("invalid 22 generation-only: no")

    def test_aBatchRunIsSplitByModel(self):
        output = ("Processing -> a/A.ump\n  Finished generating Python\nSuccess! Processed a/A.ump.\n"
                  "Processing -> b/B.ump\nError 9213 on line 1 of file 'B.ump':\nClass threading conflicts\n"
                  "Processed b/B.ump.\nProcessing -> c/C.ump\nException in thread \"main\"\n")
        results = batch_results(output, {"a/A.ump", "b/B.ump", "c/C.ump"})
        self.assertEqual((0, "Processing -> a/A.ump\n  Finished generating Python\nSuccess! Processed a/A.ump.\n"), results["a/A.ump"])
        self.assertEqual(1, results["b/B.ump"][0])
        self.assertIn("Error 9213", results["b/B.ump"][1])
        # a model the run stopped on has no result, so the gate generates it on its own
        self.assertNotIn("c/C.ump", results)

    # One interpreter checks all of a case's modules, yet each must import without the others
    def test_eachModuleIsImportedOnItsOwn(self):
        with tempfile.TemporaryDirectory() as root:
            (Path(root) / "pkg").mkdir()
            (Path(root) / "pkg" / "B.py").write_text("FLAG = 1\n")
            (Path(root) / "pkg" / "A.py").write_text("import sys\nsys.modules['pkg.B'].FLAG\n")
            (Path(root) / "pkg" / "C.py").write_text("def broken(:\n")
            sys.path.insert(0, root)
            try:
                data = {"root": root, "expected": {}, "api": None}
                problems = module_problems(dict(data, modules=["pkg/B", "pkg/A"]), importlib.import_module)
                self.assertEqual(1, len(problems))
                self.assertTrue(problems[0].startswith("import pkg.A: KeyError"), problems)
                problems = module_problems(dict(data, modules=["pkg/B", "pkg/C"]), importlib.import_module)
                self.assertTrue(problems and problems[0].startswith("does not compile"), problems)
            finally:
                sys.path.remove(root)
                sys.modules.pop("pkg.B", None)
                sys.modules.pop("pkg", None)

    def test_onlyAnOutputDirectoryTheGateMadeIsReplaced(self):
        with tempfile.TemporaryDirectory() as scratch:
            foreign = Path(scratch) / "foreign"
            foreign.mkdir()
            (foreign / "results.json").write_text("{}")
            (foreign / "keep.txt").write_text("data")
            with self.assertRaises(SystemExit):
                prepare_output(foreign)
            self.assertTrue((foreign / "keep.txt").exists() and (foreign / "results.json").exists())
            own = Path(scratch) / "own"
            prepare_output(own)
            (own / "old.txt").write_text("from an earlier run")
            prepare_output(own)
            self.assertEqual([".python-corpus-gate"], sorted(p.name for p in own.iterdir()))


if __name__ == "__main__":
    unittest.main()
