import unittest

from ImportModules import importModules

importModules(["WidgetD", "WidgetE", "WidgetF", "LanguageSpecificCodeBlock"], ["patterns", "test"])
from ImportModules import *


class CodeInjectionTest(unittest.TestCase):
    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: BeforeAfterSet_Attribute
    def test_BeforeAfterSet_Attribute(self):
        widgetD = WidgetD.WidgetD("blah")
        self.assertEqual(0, widgetD.numberOfLogs())
        widgetD.setId("moreBlah")
        self.assertEqual(2, widgetD.numberOfLogs())
        self.assertEqual("before setId:blah", widgetD.getLog(0))
        self.assertEqual("after setId:moreBlah", widgetD.getLog(1))

    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: BeforeAfterGet_Attribute
    def test_BeforeAfterGet_Attribute(self):
        widget = WidgetD.WidgetD("blah")
        self.assertEqual(0, widget.numberOfLogs())
        widget.getId()
        self.assertEqual(2, widget.numberOfLogs())
        self.assertEqual("before getId", widget.getLog(0))
        self.assertEqual("after getId", widget.getLog(1))

    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: BeforeAfterAdd_Attribute
    def test_BeforeAfterAdd_Attribute(self):
        widget = WidgetE.WidgetE()
        self.assertEqual(0, widget.numberOfLogs())
        widget.addId("anId")
        self.assertEqual(2, widget.numberOfLogs())
        self.assertEqual("before addId:0", widget.getLog(0))
        self.assertEqual("after addId:1", widget.getLog(1))

    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: BeforeAfterRemove_Attribute
    def test_BeforeAfterRemove_Attribute(self):
        widget = WidgetE.WidgetE()
        self.assertEqual(0, widget.numberOfLogs())
        widget.addId("anId")
        widget.removeId("anId")
        self.assertEqual(4, widget.numberOfLogs())
        self.assertEqual("before removeId:1", widget.getLog(2))
        self.assertEqual("after removeId:0", widget.getLog(3))

    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: BeforeAfterIndexOf_Attribute
    def test_BeforeAfterIndexOf_Attribute(self):
        widget = WidgetE.WidgetE()
        self.assertEqual(0, widget.numberOfLogs())
        widget.indexOfId("abc")
        self.assertEqual(2, widget.numberOfLogs())
        self.assertEqual("before indexOfId", widget.getLog(0))
        self.assertEqual("after indexOfId", widget.getLog(1))

    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: BeforeAfterGetAtIndex_Attribute
    def test_BeforeAfterGetAtIndex_Attribute(self):
        widget = WidgetE.WidgetE()
        self.assertEqual(0, widget.numberOfLogs())
        widget.addId("abc")
        widget.getId(0)
        self.assertEqual(4, widget.numberOfLogs())
        self.assertEqual("before getId", widget.getLog(2))
        self.assertEqual("after getId", widget.getLog(3))

    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: BeforeAfterGetIds_Attribute
    def test_BeforeAfterGetIds_Attribute(self):
        widget = WidgetE.WidgetE()
        self.assertEqual(0, widget.numberOfLogs())
        widget.getIds()
        self.assertEqual(2, widget.numberOfLogs())
        self.assertEqual("before getIds", widget.getLog(0))
        self.assertEqual("after getIds", widget.getLog(1))

    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: BeforeAfterNumberOfIds_Attribute
    def test_BeforeAfterNumberOfIds_Attribute(self):
        widget = WidgetF.WidgetF()
        self.assertEqual(0, widget.numberOfLogs())
        widget.numberOfIds()
        self.assertEqual(2, widget.numberOfLogs())
        self.assertEqual("before numberOfIds", widget.getLog(0))
        self.assertEqual("after numberOfIds", widget.getLog(1))

    # testbed/test/cruise/patterns/test/CodeInjectionTest.java: MultiLanguagedCodeBlocks
    def test_MultiLanguagedCodeBlocks(self):
        cb = LanguageSpecificCodeBlock.LanguageSpecificCodeBlock("Hello")
        cb.setName("World")
        self.assertEqual("My lang is python", cb.getName())
        self.assertFalse(cb.isJava())
        cb.applySpecificAction()
        self.assertEqual("action=python", cb.getName())
        self.assertEqual("Python", cb.getLanguageImplementedIn())
