import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["WidgetImmutableA", "WidgetImmutableB", "WidgetMutableB", "WidgetSubclass",
        "ClassOtherclass", "ClassMToN", "ClassMany", "ClassOptionalOne", "ClassOptionalN",
        "ClassOne", "ClassN", "ClassMStar"], ["patterns", "test"])
from ImportModules import *


class ClassLevelImmutabilityTest(unittest.TestCase):
    def test_noDeleteForAssociationsAndAttributesOfImmutableClass(self):
        associated = WidgetImmutableB.WidgetImmutableB("name")

        widget = WidgetImmutableA.WidgetImmutableA("Big Widget", associated)
        self.assertEqual(widget.getName(), "Big Widget")
        self.assertEqual(widget.getWidgetImmutableB(), associated)

        del widget

    def test_noDeleteForAssociationsAndAttributesOfSubclassOfImmutableClass(self):
        associated = WidgetImmutableB.WidgetImmutableB("name")

        widget = WidgetSubclass.WidgetSubclass("Little Widget", "myType", associated)
        self.assertEqual(widget.getName(), "Little Widget")
        self.assertEqual(widget.getType(), "myType")
        self.assertEqual(widget.getWidgetImmutableB(0), associated)

        widget.delete()

    def test_unidirectionalManyAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("otherClass")
        other2 = ClassOtherclass.ClassOtherclass("otherClass")

        many = ClassMany.ClassMany()
        self.assertFalse(many.hasClassOtherclasses())
        many = ClassMany.ClassMany(other1)
        self.assertTrue(many.hasClassOtherclasses())
        many = ClassMany.ClassMany(other1, other2)
        self.assertTrue(many.hasClassOtherclasses())
        self.assertTrue(many.indexOfClassOtherclass(other1) >= 0)
        self.assertTrue(many.indexOfClassOtherclass(other2) >= 0)

    def test_unidirectionalMToNAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("other")
        other2 = ClassOtherclass.ClassOtherclass("other")
        other3 = ClassOtherclass.ClassOtherclass("other")
        other4 = ClassOtherclass.ClassOtherclass("other")

        with self.assertRaises(RuntimeError):
            mToN = ClassMToN.ClassMToN()

        with self.assertRaises(RuntimeError):
            mToN = ClassMToN.ClassMToN(other1)

        mToN = ClassMToN.ClassMToN(other1, other2)
        self.assertTrue(mToN.hasClassOtherclasses())
        self.assertTrue(mToN.indexOfClassOtherclass(other1) >= 0)
        self.assertTrue(mToN.indexOfClassOtherclass(other2) >= 0)

        mToN = ClassMToN.ClassMToN(other1, other2, other3)
        self.assertTrue(mToN.hasClassOtherclasses())

        with self.assertRaises(RuntimeError):
            mToN = ClassMToN.ClassMToN(other1, other2, other3, other4)

    def test_unidirectionalMStarAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("other")
        other2 = ClassOtherclass.ClassOtherclass("other")
        other3 = ClassOtherclass.ClassOtherclass("other")

        with self.assertRaises(RuntimeError):
            mStar = ClassMStar.ClassMStar()

        with self.assertRaises(RuntimeError):
            mStar = ClassMStar.ClassMStar(other1)

        mStar = ClassMStar.ClassMStar(other1, other2)
        self.assertTrue(mStar.hasClassOtherclasses(), "Check if has other classes")
        self.assertTrue(
            mStar.indexOfClassOtherclass(other1) >= 0, "Checking index of other1 >= 0"
        )
        self.assertTrue(
            mStar.indexOfClassOtherclass(other2) >= 0, "Checking index of other2 >= 0"
        )

        mstar = ClassMStar.ClassMStar(other1, other2, other3)
        self.assertTrue(
            mStar.hasClassOtherclasses(), "Checking if class has other classes"
        )

    def test_unidirectionalNAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("other")
        other2 = ClassOtherclass.ClassOtherclass("other")
        other3 = ClassOtherclass.ClassOtherclass("other")

        with self.assertRaises(RuntimeError):
            n = ClassN.ClassN()

        with self.assertRaises(RuntimeError):
            n = ClassN.ClassN(other1)

        n = ClassN.ClassN(other1, other2)
        self.assertTrue(n.hasClassOtherclasses())
        self.assertTrue(n.indexOfClassOtherclass(other1) >= 0)
        self.assertTrue(n.indexOfClassOtherclass(other2) >= 0)

        with self.assertRaises(RuntimeError):
            n = ClassN.ClassN(other1, other2, other3)

    def test_unidirectionalOneAssociation(self):
        other = ClassOtherclass.ClassOtherclass("otherClass")

        one = ClassOne.ClassOne(other)
        self.assertTrue(
            one.getClassOtherclass() == other, "Checking if one has other classes"
        )

        with self.assertRaises(RuntimeError):
            one = ClassOne.ClassOne(None)

    def test_unidirectionalOptionalNAssociation(self):
        other1 = ClassOtherclass.ClassOtherclass("other")
        other2 = ClassOtherclass.ClassOtherclass("other")
        other3 = ClassOtherclass.ClassOtherclass("other")

        optN = ClassOptionalN.ClassOptionalN()
        self.assertFalse(optN.hasClassOtherclasses())

        optN = ClassOptionalN.ClassOptionalN(other1)
        self.assertTrue(optN.hasClassOtherclasses())
        self.assertTrue(optN.indexOfClassOtherclass(other1) >= 0)

        optN = ClassOptionalN.ClassOptionalN(other1, other2)
        self.assertTrue(optN.hasClassOtherclasses())
        self.assertTrue(optN.indexOfClassOtherclass(other1) >= 0)
        self.assertTrue(optN.indexOfClassOtherclass(other2) >= 0)

        with self.assertRaises(RuntimeError):
            optN = ClassOptionalN.ClassOptionalN(other1, other2, other3)

    def test_unidirectionalOptionalOneAssociation(self):
        other = ClassOtherclass.ClassOtherclass("otherClass")

        optOne = ClassOptionalOne.ClassOptionalOne(other)
        self.assertTrue(optOne.getClassOtherclass() == other)

        optOne = ClassOptionalOne.ClassOptionalOne(None)
        self.assertTrue(optOne.getClassOtherclass() == None)
