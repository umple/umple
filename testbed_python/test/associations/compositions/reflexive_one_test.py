import unittest

from ImportModules import importModules

importModules(
    ["YR_1_1", "YR_1_star", "YR_M_1", "Z_1_1", "Z_1_star", "Z_M_1"],
    ["associations", "compositions"],
)
from ImportModules import *


class ReflexiveOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/ReflexiveOneTest.java: constructorNotSettingNull
    def test_constructorNotSettingNull(self):
        with self.assertRaises(RuntimeError):
            Z_1_1.Z_1_1.alternateConstructor(12, None)

    # testbed/test/cruise/associations/compositions/ReflexiveOneTest.java: constructionNotSettingXWithNonNullY
    def test_constructionNotSettingXWithNonNullY(self):
        z1 = Z_1_1.Z_1_1(12)
        with self.assertRaises(RuntimeError):
            YR_1_1.YR_1_1.alternateConstructor(z1)

    # testbed/test/cruise/associations/compositions/ReflexiveOneTest.java: oneToOneSetAndDelete
    def test_oneToOneSetAndDelete(self):
        z1 = Z_1_1.Z_1_1(12)
        y1 = z1.getY_1_1()
        self.assertIs(z1, y1.getZVar())
        self.assertIs(y1, z1.getY_1_1())
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y1.getZVar())
        self.assertIsNotNone(z1.getY_1_1())
        y1.delete()
        self.assertIsNone(y1.getZVar())
        self.assertIsNone(z1.getY_1_1())

    # testbed/test/cruise/associations/compositions/ReflexiveOneTest.java: oneToStarSetAndDelete
    def test_oneToStarSetAndDelete(self):
        y1 = YR_1_star.YR_1_star()
        z1 = Z_1_star.Z_1_star(1, y1)
        self.assertIs(y1, z1.getY_1_star())
        self.assertIs(z1, y1.getZVar(0))
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(z1.getY_1_star())
        self.assertNotEqual(0, y1.numberOfZVar())
        y1.delete()
        self.assertIsNone(z1.getY_1_star())
        self.assertEqual(0, y1.numberOfZVar())

    # testbed/test/cruise/associations/compositions/ReflexiveOneTest.java: manyToOneSetAndDelete
    def test_manyToOneSetAndDelete(self):
        z1 = Z_M_1.Z_M_1(1)
        y1 = YR_M_1.YR_M_1(z1)
        self.assertIs(z1, y1.getZVar())
        self.assertIs(y1, z1.getY_m_1(0))
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y1.getZVar())
        self.assertNotEqual(0, z1.numberOfY_m_1())
        y1.delete()
        self.assertIsNone(y1.getZVar())
        self.assertEqual(0, z1.numberOfY_m_1())
