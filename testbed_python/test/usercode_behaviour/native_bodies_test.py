import unittest

from ImportModules import importModules

importModules(["NativeBodies"], ["usercode", "behaviour"])
from ImportModules import *

# Native Python bodies are emitted with their relative indentation and literal text unchanged.


class NativeBodiesTest(unittest.TestCase):
    def setUp(self):
        self.x = NativeBodies.NativeBodies()

    # a body written without indentation
    def test_zeroIndentBody(self):
        self.assertEqual(7, self.x.zeroIndent())

    # a body indented by two spaces
    def test_twoSpaceBody(self):
        self.assertEqual(7, self.x.twoIndent())

    # nested suites and blank lines keep their meaning
    def test_nestedBlocks(self):
        self.assertEqual(2, self.x.nestedBlocks())

    # a tab-indented line inside a space-indented body
    def test_tabs(self):
        self.assertEqual(7, self.x.tabs())

    # continuation lines of a string literal are left byte for byte
    def test_multilineStringUnchanged(self):
        self.assertEqual("first\n    second\n      third", self.x.multiline())

    # braces and hashes inside strings
    def test_bracesAndHashesInStrings(self):
        self.assertEqual("value=7 {ok} #{x} # }", self.x.braces())

    # text that looked like an old translator marker
    def test_markerTextInString(self):
        self.assertEqual("<TXL UGM>", self.x.marker())

    # an empty body is a method that does nothing
    def test_emptyBodies(self):
        self.assertIsNone(self.x.empty())
        self.assertIsNone(self.x.emptyShared())

    # int... becomes *xs
    def test_varargs(self):
        self.assertEqual(6, self.x.varargs(1, 2, 3))
        self.assertEqual(0, self.x.varargs())
