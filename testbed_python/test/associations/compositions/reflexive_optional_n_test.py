import unittest

from ImportModules import importModules

importModules(
    ["YR_0_n__0_n", "YR_0_n__1", "YR_0_n__m", "YR_0_n__m_n", "YR_0_n__star", "Z_0_n__0_n", "Z_0_n__1", "Z_0_n__m", "Z_0_n__m_n", "Z_0_n__star"],
    ["associations", "compositions"],
)
from ImportModules import *


class ReflexiveOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/ReflexiveOptionalNTest.java: optionalNToOptionalNSetAndDelete
    def test_optionalNToOptionalNSetAndDelete(self):
        z1 = Z_0_n__0_n.Z_0_n__0_n(1)
        z2 = Z_0_n__0_n.Z_0_n__0_n(1)
        y1 = YR_0_n__0_n.YR_0_n__0_n()
        y1.addZVar(z1)
        y1.addZVar(z2)
        self.assertIn(y1, z1.getY_0_n__0_n())
        self.assertIn(y1, z2.getY_0_n__0_n())
        self.assertIn(z1, y1.getZVar())
        self.assertIn(z2, y1.getZVar())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, z1.numberOfY_0_n__0_n())
        self.assertNotEqual(0, z1.numberOfY_0_n__0_n())
        self.assertNotEqual(0, y1.numberOfZVar())
        y1.delete()
        self.assertEqual(0, z1.numberOfY_0_n__0_n())
        self.assertEqual(0, z1.numberOfY_0_n__0_n())
        self.assertEqual(0, y1.numberOfZVar())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalNTest.java: optionalNToOneSetAndDelete
    def test_optionalNToOneSetAndDelete(self):
        z1 = Z_0_n__1.Z_0_n__1(1)
        y1 = YR_0_n__1.YR_0_n__1(z1)
        self.assertIs(z1, y1.getZVar())
        self.assertIn(y1, z1.getY_0_n__1())
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y1.getZVar())
        self.assertNotEqual(0, z1.numberOfY_0_n__1())
        y1.delete()
        self.assertIsNone(y1.getZVar())
        self.assertEqual(0, z1.numberOfY_0_n__1())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalNTest.java: optionalNToManySetAndDelete
    def test_optionalNToManySetAndDelete(self):
        z1 = Z_0_n__m.Z_0_n__m(1)
        z2 = Z_0_n__m.Z_0_n__m(1)
        z3 = Z_0_n__m.Z_0_n__m(1)
        y1 = YR_0_n__m.YR_0_n__m()
        y1.addZVar(z1)
        y1.addZVar(z2)
        y1.addZVar(z3)
        self.assertIn(z1, y1.getZVar())
        self.assertIn(z2, y1.getZVar())
        self.assertIn(z3, y1.getZVar())
        self.assertIs(y1, z1.getY_0_n__m(0))
        self.assertIs(y1, z2.getY_0_n__m(0))
        self.assertIs(y1, z3.getY_0_n__m(0))
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfZVar())
        self.assertNotEqual(0, z1.numberOfY_0_n__m())
        self.assertNotEqual(0, z2.numberOfY_0_n__m())
        self.assertNotEqual(0, z3.numberOfY_0_n__m())
        y1.delete()
        self.assertEqual(0, y1.numberOfZVar())
        self.assertEqual(0, z1.numberOfY_0_n__m())
        self.assertEqual(0, z2.numberOfY_0_n__m())
        self.assertEqual(0, z3.numberOfY_0_n__m())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalNTest.java: optionalNToMNSetAndDelete
    def test_optionalNToMNSetAndDelete(self):
        y1 = YR_0_n__m_n.YR_0_n__m_n()
        z1 = Z_0_n__m_n.Z_0_n__m_n(1)
        z2 = Z_0_n__m_n.Z_0_n__m_n(1)
        y1.addZVar(z1)
        y1.addZVar(z2)
        self.assertEqual(2, y1.numberOfZVar())
        self.assertIs(y1, z1.getY_0_n__m_n(0))
        self.assertIs(y1, z2.getY_0_n__m_n(0))
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfZVar())
        self.assertNotEqual(0, z1.numberOfY_0_n__m_n())
        self.assertNotEqual(0, z2.numberOfY_0_n__m_n())
        y1.delete()
        self.assertEqual(0, y1.numberOfZVar())
        self.assertEqual(0, z1.numberOfY_0_n__m_n())
        self.assertEqual(0, z2.numberOfY_0_n__m_n())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalNTest.java: optionalNToStarSetAndDelete
    def test_optionalNToStarSetAndDelete(self):
        y1 = YR_0_n__star.YR_0_n__star()
        z1 = Z_0_n__star.Z_0_n__star(1)
        y1.addZVar(z1)
        self.assertIs(z1, y1.getZVar(0))
        self.assertIs(y1, z1.getY_0_n__star(0))
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfZVar())
        self.assertNotEqual(0, z1.numberOfY_0_n__star())
        y1.delete()
        self.assertEqual(0, y1.numberOfZVar())
        self.assertEqual(0, z1.numberOfY_0_n__star())
