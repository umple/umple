import unittest

from ImportModules import importModules

importModules(["UntaggedSnippets", "SnippetReceivers"], ["usercode", "behaviour"])
from ImportModules import *

# Untagged Java-shaped snippets (actions, injections, derived attributes, defaults) translated to
# Python with Java's meaning; the values are the ones the generated Java produces.


class SnippetsTest(unittest.TestCase):
    # operator precedence
    def test_arithmeticDefault(self):
        self.assertEqual(14, UntaggedSnippets.UntaggedSnippets().getArithmetic())

    # integer division truncates toward zero, as in Java
    def test_integerDivisionDefault(self):
        x = UntaggedSnippets.UntaggedSnippets()
        self.assertEqual(3, x.getDivision())
        self.assertEqual(-3, x.getNegativeDivision())
        self.assertIsInstance(x.getDivision(), int)

    def test_derivedAttribute(self):
        x = UntaggedSnippets.UntaggedSnippets()
        self.assertEqual(0, x.getTwice())
        x.setN(4)
        self.assertEqual(8, x.getTwice())

    # string concatenation converts the number
    def test_injectionConcatenatesNumber(self):
        x = UntaggedSnippets.UntaggedSnippets()
        x.setN(2)
        x.setN(3)
        self.assertEqual("set 0;set 2;", x.getLog())

    # an untagged action calls the generated setter and
    # the guarded automatic transition that follows sees the new value
    def test_untaggedActionAndGuard(self):
        x = UntaggedSnippets.UntaggedSnippets()
        self.assertIs(True, x.go())
        self.assertEqual(7, x.getN())
        self.assertEqual("C", x.getSmFullName())

    # a static method called through an object that is null is still called,
    # after the object is evaluated once
    def test_staticCallThroughANullObject(self):
        x = SnippetReceivers.SnippetReceivers()
        x.staticCall()
        self.assertEqual(7, x.getAnswered())
        self.assertEqual(1, x.getCalls())
        self.assertEqual(7, x.getAnswerThroughNull())
        self.assertEqual(2, x.getCalls())

    # reading a constant through s.child fails when s is null, as in Java
    def test_staticConstantThroughAFailingChain(self):
        x = SnippetReceivers.SnippetReceivers()
        with self.assertRaises(AttributeError):
            x.staticConstant()
        self.assertEqual(0, x.getAnswered())

    # the arguments of a call on a null object are evaluated before it fails
    def test_argumentsBeforeTheCallOnANullObject(self):
        x = SnippetReceivers.SnippetReceivers()
        with self.assertRaises(AttributeError):
            x.callOnChild()
        self.assertEqual(1, x.getCalls())
        with self.assertRaises(AttributeError):
            x.getTwiceThroughChild()
        self.assertEqual(2, x.getCalls())
        x.setChild(SnippetReceivers.SnippetReceivers())
        x.callOnChild()
        self.assertEqual(6, x.getAnswered())
        self.assertEqual(6, x.getTwiceThroughChild())
