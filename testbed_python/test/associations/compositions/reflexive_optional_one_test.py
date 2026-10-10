import unittest

from ImportModules import importModules

importModules(
    ["YR_0_1__0_1", "YR_0_1__0_n", "YR_0_1__1", "YR_0_1__m", "YR_0_1__m_n", "YR_0_1__star", "Z_0_1__0_1", "Z_0_1__0_n", "Z_0_1__1", "Z_0_1__m", "Z_0_1__m_n", "Z_0_1__star"],
    ["associations", "compositions"],
)
from ImportModules import *


class ReflexiveOptionalOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/ReflexiveOptionalOneTest.java: optionalOneToOptionalOneSetAndDelete
    def test_optionalOneToOptionalOneSetAndDelete(self):
        z1 = Z_0_1__0_1.Z_0_1__0_1(1)
        y1 = YR_0_1__0_1.YR_0_1__0_1()
        z1.setY_0_1__0_1(y1)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(z1.getY_0_1__0_1())
        self.assertIsNotNone(y1.getZVar())
        z1.delete()
        self.assertIsNone(z1.getY_0_1__0_1())
        self.assertIsNone(y1.getZVar())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalOneTest.java: optionalOneToOptionalNSetAndDelete
    def test_optionalOneToOptionalNSetAndDelete(self):
        y1 = YR_0_1__0_n.YR_0_1__0_n()
        z1 = Z_0_1__0_n.Z_0_1__0_n(1)
        z1.setY_0_1__0_n(y1)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(z1.getY_0_1__0_n())
        self.assertNotEqual(0, y1.numberOfZVar())
        y1.delete()
        self.assertIsNone(z1.getY_0_1__0_n())
        self.assertEqual(0, y1.numberOfZVar())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalOneTest.java: optionalOneToOneSetAndDelete
    def test_optionalOneToOneSetAndDelete(self):
        z1 = Z_0_1__1.Z_0_1__1(1)
        y1 = YR_0_1__1.YR_0_1__1(z1)
        self.assertIs(y1, z1.getY_0_1__1())
        self.assertIs(z1, y1.getZVar())
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(z1.getY_0_1__1())
        self.assertIsNotNone(y1.getZVar())
        y1.delete()
        self.assertIsNone(z1.getY_0_1__1())
        self.assertIsNone(y1.getZVar())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalOneTest.java: optionalOneToManySetAndDelete
    def test_optionalOneToManySetAndDelete(self):
        z1 = Z_0_1__m.Z_0_1__m(1)
        z2 = Z_0_1__m.Z_0_1__m(1)
        z3 = Z_0_1__m.Z_0_1__m(1)
        y1 = YR_0_1__m.YR_0_1__m(z1, z2, z3)
        self.assertIs(y1, z1.getY_0_1__m())
        self.assertIs(y1, z2.getY_0_1__m())
        self.assertIs(y1, z3.getY_0_1__m())
        self.assertIn(z1, y1.getZVar())
        self.assertIn(z2, y1.getZVar())
        self.assertIn(z3, y1.getZVar())
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(z1.getY_0_1__m())
        self.assertIsNotNone(z2.getY_0_1__m())
        self.assertIsNotNone(z3.getY_0_1__m())
        self.assertNotEqual(0, y1.numberOfZVar())
        y1.delete()
        self.assertIsNone(z1.getY_0_1__m())
        self.assertIsNone(z2.getY_0_1__m())
        self.assertIsNone(z3.getY_0_1__m())
        self.assertEqual(0, y1.numberOfZVar())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalOneTest.java: optionalOneToMNSetAndDelete
    def test_optionalOneToMNSetAndDelete(self):
        z1 = Z_0_1__m_n.Z_0_1__m_n(1)
        z2 = Z_0_1__m_n.Z_0_1__m_n(1)
        y1 = YR_0_1__m_n.YR_0_1__m_n(z1, z2)
        self.assertIs(y1, z1.getY_0_1__m_n())
        self.assertIs(y1, z2.getY_0_1__m_n())
        self.assertIn(z1, y1.getZVar())
        self.assertIn(z2, y1.getZVar())
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(z1.getY_0_1__m_n())
        self.assertIsNotNone(z2.getY_0_1__m_n())
        self.assertNotEqual(0, y1.numberOfZVar())
        y1.delete()
        self.assertIsNone(z1.getY_0_1__m_n())
        self.assertIsNone(z2.getY_0_1__m_n())
        self.assertEqual(0, y1.numberOfZVar())

    # testbed/test/cruise/associations/compositions/ReflexiveOptionalOneTest.java: optionalOneToStarSetAndDelete
    def test_optionalOneToStarSetAndDelete(self):
        z1 = Z_0_1__star.Z_0_1__star(1)
        y1 = YR_0_1__star.YR_0_1__star()
        z1.setY_0_1__star(y1)
        self.assertIs(y1, z1.getY_0_1__star())
        self.assertIs(z1, y1.getZVar(0))
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(z1.getY_0_1__star())
        self.assertNotEqual(0, y1.numberOfZVar())
        z1.delete()
        self.assertIsNone(z1.getY_0_1__star())
        self.assertEqual(0, y1.numberOfZVar())
