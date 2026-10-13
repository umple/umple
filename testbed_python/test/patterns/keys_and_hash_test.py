import unittest
import datetime

from ImportModules import importModules

importModules(["WidgetA", "WidgetB", "WidgetC"], ["patterns", "test"])
from ImportModules import *


class KeysAndHashTest(unittest.TestCase):
    # testbed/test/cruise/patterns/test/KeysAndHashTest.java: equals_NotNull
    def test_equals_NotNull(self):
        self.assertIs(False, WidgetC.WidgetC("x").equals(None))

    # testbed/test/cruise/patterns/test/KeysAndHashTest.java: equals_WrongType
    def test_equals_WrongType(self):
        self.assertIs(False, WidgetC.WidgetC("x").equals(WidgetB.WidgetB()))

    # testbed/test/cruise/patterns/test/KeysAndHashTest.java: equals_SameData
    def test_equals_SameData(self):
        original = WidgetB.WidgetB()
        widget = WidgetA.WidgetA("blah", 1, 2.3, True, datetime.date(1978, 12, 1), original, "ignore")
        compareTo = WidgetA.WidgetA("blah", 1, 2.3, True, datetime.date(1978, 12, 1), original, "alsoIgnore")
        self.assertIs(True, widget.equals(compareTo))
        self.assertIs(True, compareTo.equals(widget))
        self.assertEqual(hash(widget), hash(compareTo))

    # testbed/test/cruise/patterns/test/KeysAndHashTest.java: equals_CompareToNull
    def test_equals_CompareToNull(self):
        original = WidgetB.WidgetB()
        widget = WidgetA.WidgetA("blah", 1, 2.3, True, datetime.date(1978, 12, 1), original, "ignore")
        compareToA = WidgetA.WidgetA(None, 1, 2.3, True, datetime.date(1978, 12, 1), original, "alsoIgnore")
        compareToB = WidgetA.WidgetA("blah", 1, 2.3, True, None, original, "alsoIgnore")
        compareToC = WidgetA.WidgetA("blah", 1, 2.3, True, datetime.date(1978, 12, 1), None, "alsoIgnore")
        self.assertIs(False, widget.equals(compareToA))
        self.assertIs(False, widget.equals(compareToB))
        self.assertIs(False, widget.equals(compareToC))
        self.assertIs(False, compareToA.equals(widget))
        self.assertIs(False, compareToB.equals(widget))
        self.assertIs(False, compareToC.equals(widget))

    # testbed/test/cruise/patterns/test/KeysAndHashTest.java: equals_SameNulls
    def test_equals_SameNulls(self):
        widget = WidgetA.WidgetA(None, 1, 2.3, True, None, None, "ignore")
        compareTo = WidgetA.WidgetA(None, 1, 2.3, True, None, None, "alsoIgnore")
        self.assertIs(True, widget.equals(compareTo))
        self.assertIs(True, compareTo.equals(widget))

    # testbed/test/cruise/patterns/test/KeysAndHashTest.java: equals_WrongData
    def test_equals_WrongData(self):
        original = WidgetB.WidgetB()
        copy = WidgetB.WidgetB()
        widget = WidgetA.WidgetA("blah", 1, 2.3, True, datetime.date(1978, 12, 1), original, "ignore")
        compareToA = WidgetA.WidgetA("blah2", 1, 2.3, True, datetime.date(1978, 12, 1), original, "alsoIgnore")
        compareToB = WidgetA.WidgetA("blah", 12, 2.3, True, datetime.date(1978, 12, 1), original, "alsoIgnore")
        compareToC = WidgetA.WidgetA("blah", 1, 3.3, True, datetime.date(1978, 12, 1), original, "alsoIgnore")
        compareToD = WidgetA.WidgetA("blah", 1, 2.3, False, datetime.date(1978, 12, 1), original, "alsoIgnore")
        compareToE = WidgetA.WidgetA("blah", 1, 2.3, True, datetime.date(1979, 12, 1), original, "alsoIgnore")
        compareToF = WidgetA.WidgetA("blah", 1, 2.3, True, datetime.date(1978, 12, 1), copy, "alsoIgnore")
        self.assertIs(False, widget.equals(compareToA))
        self.assertIs(False, widget.equals(compareToB))
        self.assertIs(False, widget.equals(compareToC))
        self.assertIs(False, widget.equals(compareToD))
        self.assertIs(False, widget.equals(compareToE))
        self.assertIs(False, widget.equals(compareToF))
        self.assertIs(False, compareToA.equals(widget))
        self.assertIs(False, compareToB.equals(widget))
        self.assertIs(False, compareToC.equals(widget))
        self.assertIs(False, compareToD.equals(widget))
        self.assertIs(False, compareToE.equals(widget))
        self.assertIs(False, compareToF.equals(widget))

    # testbed/test/cruise/patterns/test/KeysAndHashTest.java: cannotChangeHashCodeAfterCalling
    def test_cannotChangeHashCodeAfterCalling(self):
        original = WidgetB.WidgetB()
        copy = WidgetB.WidgetB()
        widget = WidgetA.WidgetA("blah", 1, 2.3, True, datetime.date(1978, 12, 1), original, "stuff")
        self.assertEqual("blah", widget.getId())
        self.assertIs(True, widget.setId("blah2"))
        self.assertEqual("blah2", widget.getId())
        hashCode = hash(widget)
        self.assertIs(False, widget.setId("blah3"))
        self.assertIs(False, widget.setIntId(2))
        self.assertIs(False, widget.setDoubleId(3.4))
        self.assertIs(False, widget.setBoolId(False))
        self.assertIs(False, widget.setDateId(datetime.date(1978, 9, 21)))
        self.assertIs(False, widget.setWidgetId(copy))
        self.assertIs(True, widget.setIgnore("more stuff"))
        self.assertEqual("blah2", widget.getId())
        self.assertEqual(1, widget.getIntId())
        self.assertAlmostEqual(2.3, widget.getDoubleId(), delta=0.01)
        self.assertIs(True, widget.getBoolId())
        self.assertIs(original, widget.getWidgetId())
        self.assertEqual("more stuff", widget.getIgnore())
        self.assertEqual(hashCode, hash(widget))
