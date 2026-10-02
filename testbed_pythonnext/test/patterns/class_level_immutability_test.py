import re
import unittest

from ImportModules import importModules

importModules(
    ["ClassMStar", "ClassMToN", "ClassMany", "ClassN", "ClassOne", "ClassOptionalN", "ClassOptionalOne", "ClassOtherclass", "WidgetImmutableA", "WidgetImmutableB", "WidgetMutableB", "WidgetSubclass"],
    ["patterns", "test"],
)
from ImportModules import *


def objectClassHasSettersAddersOrRemovers(obj):
    return any(re.fullmatch("(set|add|remove)[A-Z]+[a-zA-Z]*", name) for name in dir(type(obj)))


class ClassLevelImmutabilityTest(unittest.TestCase):
    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: noDeleteForAssociationsAndAttributesOfImmutableClass
    def test_noDeleteForAssociationsAndAttributesOfImmutableClass(self):
        associated = WidgetImmutableB.WidgetImmutableB("name")
        widget = WidgetImmutableA.WidgetImmutableA("Big Widget", associated)
        self.assertEqual(widget.getName(), "Big Widget")
        self.assertIs(widget.getWidgetImmutableB(), associated)
        widget.delete()
        self.assertEqual(widget.getName(), "Big Widget")
        self.assertIs(widget.getWidgetImmutableB(), associated)

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: noDeleteForAssociationsAndAttributesOfSubclassOfImmutableClass
    def test_noDeleteForAssociationsAndAttributesOfSubclassOfImmutableClass(self):
        associated = WidgetImmutableB.WidgetImmutableB("name")
        widget = WidgetSubclass.WidgetSubclass("Little Widget", "myType", associated)
        self.assertEqual(widget.getName(), "Little Widget")
        self.assertEqual(widget.getType(), "myType")
        self.assertIs(widget.getWidgetImmutableB(0), associated)
        widget.delete()
        self.assertEqual(widget.getName(), "Little Widget")
        self.assertEqual(widget.getType(), "myType")
        self.assertIs(widget.getWidgetImmutableB(0), associated)

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: mutableClassHasSettersRemoversAndAddMethods
    def test_mutableClassHasSettersRemoversAndAddMethods(self):
        widget = WidgetMutableB.WidgetMutableB()
        self.assertIs(True, objectClassHasSettersAddersOrRemovers(widget))

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: unidirectionalManyAssociation
    def test_unidirectionalManyAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("otherClass")
        other2 = ClassOtherclass.ClassOtherclass("otherClass")
        many = ClassMany.ClassMany()
        self.assertIs(False, many.hasClassOtherclasses())
        many = ClassMany.ClassMany(other1)
        self.assertIs(True, many.hasClassOtherclasses())
        many = ClassMany.ClassMany(other1, other2)
        self.assertIs(True, many.hasClassOtherclasses())
        self.assertGreaterEqual(many.indexOfClassOtherclass(other1), 0)
        self.assertGreaterEqual(many.indexOfClassOtherclass(other2), 0)
        self.assertIs(False, objectClassHasSettersAddersOrRemovers(many))

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: unidirectionalMToNAssociation
    def test_unidirectionalMToNAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("other")
        other2 = ClassOtherclass.ClassOtherclass("other")
        other3 = ClassOtherclass.ClassOtherclass("other")
        other4 = ClassOtherclass.ClassOtherclass("other")
        with self.assertRaises(RuntimeError):
            ClassMToN.ClassMToN()
        with self.assertRaises(RuntimeError):
            ClassMToN.ClassMToN(other1)
        mToN = ClassMToN.ClassMToN(other1, other2)
        self.assertIs(True, mToN.hasClassOtherclasses())
        self.assertGreaterEqual(mToN.indexOfClassOtherclass(other1), 0)
        self.assertGreaterEqual(mToN.indexOfClassOtherclass(other2), 0)
        mToN = ClassMToN.ClassMToN(other1, other2, other3)
        self.assertIs(True, mToN.hasClassOtherclasses())
        with self.assertRaises(RuntimeError):
            ClassMToN.ClassMToN(other1, other2, other3, other4)
        self.assertIs(False, objectClassHasSettersAddersOrRemovers(mToN))

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: unidirectionalMStarAssociation
    def test_unidirectionalMStarAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("other")
        other2 = ClassOtherclass.ClassOtherclass("other")
        other3 = ClassOtherclass.ClassOtherclass("other")
        with self.assertRaises(RuntimeError):
            ClassMStar.ClassMStar()
        with self.assertRaises(RuntimeError):
            ClassMStar.ClassMStar(other1)
        mStar = ClassMStar.ClassMStar(other1, other2)
        self.assertIs(True, mStar.hasClassOtherclasses())
        self.assertGreaterEqual(mStar.indexOfClassOtherclass(other1), 0)
        self.assertGreaterEqual(mStar.indexOfClassOtherclass(other2), 0)
        mStar = ClassMStar.ClassMStar(other1, other2, other3)
        self.assertIs(True, mStar.hasClassOtherclasses())
        self.assertIs(False, objectClassHasSettersAddersOrRemovers(mStar))

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: unidirectionalNAssociation
    def test_unidirectionalNAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("other")
        other2 = ClassOtherclass.ClassOtherclass("other")
        other3 = ClassOtherclass.ClassOtherclass("other")
        with self.assertRaises(RuntimeError):
            ClassN.ClassN()
        with self.assertRaises(RuntimeError):
            ClassN.ClassN(other1)
        n = ClassN.ClassN(other1, other2)
        self.assertIs(True, n.hasClassOtherclasses())
        self.assertGreaterEqual(n.indexOfClassOtherclass(other1), 0)
        self.assertGreaterEqual(n.indexOfClassOtherclass(other2), 0)
        with self.assertRaises(RuntimeError):
            ClassN.ClassN(other1, other2, other3)
        self.assertIs(False, objectClassHasSettersAddersOrRemovers(n))

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: unidirectionalOneAssociation
    def test_unidirectionalOneAssociation(self):
        other = ClassOtherclass.ClassOtherclass("otherClass")
        one = ClassOne.ClassOne(other)
        self.assertIs(one.getClassOtherclass(), other)
        with self.assertRaises(RuntimeError):
            ClassOne.ClassOne(None)
        self.assertIs(False, objectClassHasSettersAddersOrRemovers(one))

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: unidirectionalOptionalNAssociation
    def test_unidirectionalOptionalNAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("other")
        other2 = ClassOtherclass.ClassOtherclass("other")
        other3 = ClassOtherclass.ClassOtherclass("other")
        optN = ClassOptionalN.ClassOptionalN()
        self.assertIs(False, optN.hasClassOtherclasses())
        optN = ClassOptionalN.ClassOptionalN(other1)
        self.assertIs(True, optN.hasClassOtherclasses())
        self.assertGreaterEqual(optN.indexOfClassOtherclass(other1), 0)
        optN = ClassOptionalN.ClassOptionalN(other1, other2)
        self.assertIs(True, optN.hasClassOtherclasses())
        self.assertGreaterEqual(optN.indexOfClassOtherclass(other1), 0)
        self.assertGreaterEqual(optN.indexOfClassOtherclass(other2), 0)
        with self.assertRaises(RuntimeError):
            ClassOptionalN.ClassOptionalN(other1, other2, other3)
        self.assertIs(False, objectClassHasSettersAddersOrRemovers(optN))

    # testbed/test/cruise/patterns/test/ClassLevelImmutabilityTest.java: unidirectionalOptionalOneAssociation
    def test_unidirectionalOptionalOneAssociation(self):
        other = ClassOtherclass.ClassOtherclass("otherClass")
        optOne = ClassOptionalOne.ClassOptionalOne(other)
        self.assertIs(optOne.getClassOtherclass(), other)
        optOne = ClassOptionalOne.ClassOptionalOne(None)
        self.assertIsNone(optOne.getClassOtherclass())
        self.assertIs(False, objectClassHasSettersAddersOrRemovers(optOne))
