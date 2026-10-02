import os
import sys
import tempfile
import unittest
from pathlib import Path

HERE = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, os.path.join(HERE, os.pardir, os.pardir, os.pardir, "build"))
from pythonnext_corpus_gate import left_out_method, parse_expectation, prepare_output


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
