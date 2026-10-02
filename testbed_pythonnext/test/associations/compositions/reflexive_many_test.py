import unittest

from ImportModules import importModules

importModules(
    ["YR_M_M", "YR_M_star", "YR_m_n__1", "YR_m_n__m", "YR_m_n__m_n", "YR_m_n__star", "Z_M_M", "Z_M_star", "Z_m_n__1", "Z_m_n__m", "Z_m_n__m_n", "Z_m_n__star"],
    ["associations", "compositions"],
)
from ImportModules import *


class ReflexiveManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/ReflexiveManyTest.java: manyToManySetAndDelete
    def test_manyToManySetAndDelete(self):
        z1 = Z_M_M.Z_M_M(1)
        y1 = YR_M_M.YR_M_M()
        y1.addZVar(z1)
        y1.addZVar(Z_M_M.Z_M_M(1))
        y1.addZVar(Z_M_M.Z_M_M(1))
        self.assertEqual(3, y1.numberOfZVar())
        self.assertEqual(1, z1.numberOfY_m_m())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfZVar())
        self.assertNotEqual(0, z1.numberOfY_m_m())
        y1.delete()
        self.assertEqual(0, y1.numberOfZVar())
        self.assertEqual(0, z1.numberOfY_m_m())

    # testbed/test/cruise/associations/compositions/ReflexiveManyTest.java: mnToOneSetAndDelete
    def test_mnToOneSetAndDelete(self):
        z1 = Z_m_n__1.Z_m_n__1(1)
        y1 = YR_m_n__1.YR_m_n__1(z1)
        self.assertIs(z1, y1.getZVar())
        self.assertIs(y1, z1.getY_m_n__1(0))
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y1.getZVar())
        self.assertNotEqual(0, z1.numberOfY_m_n__1())
        y1.delete()
        self.assertIsNone(y1.getZVar())
        self.assertEqual(0, z1.numberOfY_m_n__1())

    # testbed/test/cruise/associations/compositions/ReflexiveManyTest.java: mnToMSetAndDelete
    def test_mnToMSetAndDelete(self):
        y1 = YR_m_n__m.YR_m_n__m()
        z1 = Z_m_n__m.Z_m_n__m(1)
        y1.addZVar(z1)
        self.assertIs(z1, y1.getZVar(0))
        self.assertIs(y1, z1.getY_m_n__m(0))
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfZVar())
        self.assertNotEqual(0, z1.numberOfY_m_n__m())
        y1.delete()
        self.assertEqual(0, y1.numberOfZVar())
        self.assertEqual(0, z1.numberOfY_m_n__m())

    # testbed/test/cruise/associations/compositions/ReflexiveManyTest.java: mnToMnSetAndDelete
    def test_mnToMnSetAndDelete(self):
        z1 = Z_m_n__m_n.Z_m_n__m_n(1)
        y1 = YR_m_n__m_n.YR_m_n__m_n()
        y1.addZVar(z1)
        y1.addZVar(Z_m_n__m_n.Z_m_n__m_n(1))
        self.assertEqual(2, y1.numberOfZVar())
        self.assertEqual(1, z1.numberOfY_m_n__m_n())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfZVar())
        self.assertNotEqual(0, z1.numberOfY_m_n__m_n())
        y1.delete()
        self.assertEqual(0, y1.numberOfZVar())
        self.assertEqual(0, z1.numberOfY_m_n__m_n())

    # testbed/test/cruise/associations/compositions/ReflexiveManyTest.java: mnToStarSetAndDelete
    def test_mnToStarSetAndDelete(self):
        y1 = YR_m_n__star.YR_m_n__star()
        y2 = YR_m_n__star.YR_m_n__star()
        z1 = Z_m_n__star.Z_m_n__star(1, y1, y2)
        self.assertEqual(2, z1.numberOfY_m_n__star())
        self.assertEqual(1, y1.numberOfZVar())
        self.assertEqual(1, y2.numberOfZVar())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, z1.numberOfY_m_n__star())
        self.assertNotEqual(0, y1.numberOfZVar())
        self.assertNotEqual(0, y2.numberOfZVar())
        z1.delete()
        self.assertEqual(0, z1.numberOfY_m_n__star())
        self.assertEqual(0, y1.numberOfZVar())
        self.assertEqual(0, y2.numberOfZVar())

    # testbed/test/cruise/associations/compositions/ReflexiveManyTest.java: manyToStarSetAndDelete
    def test_manyToStarSetAndDelete(self):
        y1 = YR_M_star.YR_M_star()
        y2 = YR_M_star.YR_M_star()
        y3 = YR_M_star.YR_M_star()
        z1 = Z_M_star.Z_M_star(3, y1, y2, y3)
        self.assertEqual(3, z1.numberOfY_m_star())
        self.assertEqual(1, y1.numberOfZVar())
        self.assertEqual(1, y2.numberOfZVar())
        self.assertEqual(1, y3.numberOfZVar())
