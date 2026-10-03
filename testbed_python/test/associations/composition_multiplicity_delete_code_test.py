import unittest

from ImportModules import importModules

importModules(
    ["X0_1__0_1", "X0_1__0_n", "X0_1__1", "X0_1__m", "X0_1__m_n", "X0_1__star", "X0_n__0_n", "X0_n__1", "X0_n__m", "X0_n__star", "X1_star", "XM_1", "XM_M", "XM_star", "Xm_n__1", "Xm_n__m", "Xm_n__m_n", "Xm_n__star", "Xstar_star", "Y0_1__0_1", "Y0_1__0_n", "Y0_1__1", "Y0_1__m", "Y0_1__m_n", "Y0_1__star", "Y0_n__0_n", "Y0_n__1", "Y0_n__m", "Y0_n__star", "Y1_1", "Y1_star", "YM_1", "YM_M", "YM_star", "YR_0_1__0_1", "YR_0_1__0_n", "YR_0_1__1", "YR_0_1__m", "YR_0_1__m_n", "YR_0_1__star", "YR_0_n__0_n", "YR_0_n__1", "YR_0_n__m", "YR_0_n__star", "YR_1_1", "YR_1_star", "YR_M_1", "YR_M_M", "YR_M_star", "YR_m_n__1", "YR_m_n__m", "YR_m_n__m_n", "YR_m_n__star", "YR_star_star", "Ym_n__1", "Ym_n__m", "Ym_n__m_n", "Ym_n__star", "Ystar_star", "Z_0_1__0_1", "Z_0_1__0_n", "Z_0_1__1", "Z_0_1__m", "Z_0_1__m_n", "Z_0_1__star", "Z_0_n__0_n", "Z_0_n__1", "Z_0_n__m", "Z_0_n__star", "Z_1_star", "Z_M_1", "Z_M_M", "Z_M_star", "Z_m_n__1", "Z_m_n__m", "Z_m_n__m_n", "Z_m_n__star", "Z_star_star"],
    ["associations", "compositions"],
)
from ImportModules import *


class CompositionMultiplicity_DeleteCodeTests(unittest.TestCase):
    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: OneToOne_LeftTest
    def test_OneToOne_LeftTest(self):
        y = Y1_1.Y1_1(1)
        x = y.getXVar()
        y.getXVar().delete()
        self.assertIsNone(y.getXVar())
        self.assertIsNone(x.getY1_1())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MToOne_LeftTest
    def test_MToOne_LeftTest(self):
        x = XM_1.XM_1(1)
        y = YM_1.YM_1(x)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y.getXVar())
        self.assertNotEqual(0, len(x.getYm_1()))
        x.delete()
        self.assertIsNone(y.getXVar())
        self.assertEqual(0, len(x.getYm_1()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MToM_LeftTest
    def test_MToM_LeftTest(self):
        y1 = YM_M.YM_M()
        y2 = YM_M.YM_M()
        y3 = YM_M.YM_M()
        x = XM_M.XM_M(1)
        x.setYm_m(y1, y2, y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(y3.getXVar()))
        self.assertNotEqual(0, len(x.getYm_m()))
        x.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(0, len(y3.getXVar()))
        self.assertEqual(0, len(x.getYm_m()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: OneToStar_LeftTest
    def test_OneToStar_LeftTest(self):
        y = Y1_star.Y1_star()
        x = X1_star.X1_star(1, y)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y.getXVar()))
        self.assertIsNotNone(x.getY1_star())
        x.delete()
        self.assertEqual(0, len(y.getXVar()))
        self.assertIsNone(x.getY1_star())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MToStar_LeftTest
    def test_MToStar_LeftTest(self):
        y1 = YM_star.YM_star()
        y2 = YM_star.YM_star()
        y3 = YM_star.YM_star()
        x = XM_star.XM_star(1, y1, y2, y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(y3.getXVar()))
        self.assertNotEqual(0, len(x.getYm_star()))
        x.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(0, len(y3.getXVar()))
        self.assertEqual(0, len(x.getYm_star()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: StarToStar_LeftTest
    def test_StarToStar_LeftTest(self):
        y1 = Ystar_star.Ystar_star()
        y2 = Ystar_star.Ystar_star()
        y3 = Ystar_star.Ystar_star()
        x1 = Xstar_star.Xstar_star(1)
        x1.addYstar_star(y1)
        x1.addYstar_star(y2)
        x1.addYstar_star(y3)
        x2 = Xstar_star.Xstar_star(2)
        x2.addYstar_star(y1)
        x2.addYstar_star(y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(x2.getYstar_star()))
        x2.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(1, len(y3.getXVar()))
        self.assertEqual(1, len(x1.getYstar_star()))
        self.assertEqual(0, len(x2.getYstar_star()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MNToOne_LeftTest
    def test_MNToOne_LeftTest(self):
        x = Xm_n__1.Xm_n__1(1)
        y = Ym_n__1.Ym_n__1(x)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y.getXVar())
        self.assertNotEqual(0, len(x.getYm_n__1()))
        x.delete()
        self.assertIsNone(y.getXVar())
        self.assertEqual(0, len(x.getYm_n__1()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MNToM_LeftTest
    def test_MNToM_LeftTest(self):
        y1 = Ym_n__m.Ym_n__m()
        y2 = Ym_n__m.Ym_n__m()
        y3 = Ym_n__m.Ym_n__m()
        x = Xm_n__m.Xm_n__m(1)
        x.setYm_n__m(y1, y2, y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(y3.getXVar()))
        self.assertNotEqual(0, len(x.getYm_n__m()))
        x.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(0, len(y3.getXVar()))
        self.assertEqual(0, len(x.getYm_n__m()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MNToStar_LeftTest
    def test_MNToStar_LeftTest(self):
        y1 = Ym_n__star.Ym_n__star()
        y2 = Ym_n__star.Ym_n__star()
        y3 = Ym_n__star.Ym_n__star()
        x = Xm_n__star.Xm_n__star(1, y1, y2)
        x.addYm_n__star(y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(y3.getXVar()))
        self.assertNotEqual(0, len(x.getYm_n__star()))
        x.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(0, len(y3.getXVar()))
        self.assertEqual(0, len(x.getYm_n__star()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MNToMN_LeftTest
    def test_MNToMN_LeftTest(self):
        y1 = Ym_n__m_n.Ym_n__m_n()
        y2 = Ym_n__m_n.Ym_n__m_n()
        x = Xm_n__m_n.Xm_n__m_n(1)
        x.setYm_n__m_n(y1, y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(x.getYm_n__m_n()))
        x.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(0, len(x.getYm_n__m_n()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0NToOne_LeftTest
    def test__0NToOne_LeftTest(self):
        x = X0_n__1.X0_n__1(1)
        y = Y0_n__1.Y0_n__1(x)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y.getXVar())
        self.assertNotEqual(0, len(x.getY0_n__1()))
        x.delete()
        self.assertIsNone(y.getXVar())
        self.assertEqual(0, len(x.getY0_n__1()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0NToM_LeftTest
    def test__0NToM_LeftTest(self):
        y1 = Y0_n__m.Y0_n__m()
        y2 = Y0_n__m.Y0_n__m()
        y3 = Y0_n__m.Y0_n__m()
        x = X0_n__m.X0_n__m(1)
        x.addY0_n__m(y1)
        x.addY0_n__m(y2)
        x.addY0_n__m(y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(y3.getXVar()))
        self.assertNotEqual(0, len(x.getY0_n__m()))
        x.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(0, len(y3.getXVar()))
        self.assertEqual(0, len(x.getY0_n__m()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0NToStar_LeftTest
    def test__0NToStar_LeftTest(self):
        y1 = Y0_n__star.Y0_n__star()
        y2 = Y0_n__star.Y0_n__star()
        x = X0_n__star.X0_n__star(1)
        x.addY0_n__star(y1)
        x.addY0_n__star(y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(x.getY0_n__star()))
        x.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(0, len(x.getY0_n__star()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0NTo0N_LeftTest
    def test__0NTo0N_LeftTest(self):
        y1 = Y0_n__0_n.Y0_n__0_n()
        y2 = Y0_n__0_n.Y0_n__0_n()
        x1 = X0_n__0_n.X0_n__0_n(1)
        x1.addY0_n__0_n(y1)
        x1.addY0_n__0_n(y2)
        x2 = X0_n__0_n.X0_n__0_n(2)
        x2.addY0_n__0_n(y1)
        x2.addY0_n__0_n(y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertNotEqual(0, len(y2.getXVar()))
        self.assertNotEqual(0, len(x1.getY0_n__0_n()))
        self.assertNotEqual(0, len(x2.getY0_n__0_n()))
        x1.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertEqual(0, len(y2.getXVar()))
        self.assertEqual(0, len(x1.getY0_n__0_n()))
        self.assertEqual(0, len(x2.getY0_n__0_n()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneToOne_LeftTest
    def test__0OneToOne_LeftTest(self):
        x = X0_1__1.X0_1__1(1)
        y = Y0_1__1.Y0_1__1(x)
        y.getXVar().delete()
        self.assertIsNone(y.getXVar())
        self.assertIsNone(x.getY0_1__1())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneToM_LeftTest
    def test__0OneToM_LeftTest(self):
        x1 = X0_1__m.X0_1__m(1)
        x2 = X0_1__m.X0_1__m(2)
        x3 = X0_1__m.X0_1__m(3)
        y = Y0_1__m.Y0_1__m(x1, x2, x3)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(x1.getY0_1__m())
        self.assertIsNotNone(x2.getY0_1__m())
        self.assertIsNotNone(x3.getY0_1__m())
        self.assertNotEqual(0, len(y.getXVar()))
        x1.delete()
        self.assertIsNone(x1.getY0_1__m())
        self.assertIsNone(x2.getY0_1__m())
        self.assertIsNone(x3.getY0_1__m())
        self.assertEqual(0, len(y.getXVar()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneToStar_LeftTest
    def test__0OneToStar_LeftTest(self):
        y = Y0_1__star.Y0_1__star()
        x = X0_1__star.X0_1__star(1)
        x.setY0_1__star(y)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y.getXVar()))
        self.assertIsNotNone(x.getY0_1__star())
        x.delete()
        self.assertEqual(0, len(y.getXVar()))
        self.assertIsNone(x.getY0_1__star())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneToMN_LeftTest
    def test__0OneToMN_LeftTest(self):
        x1 = X0_1__m_n.X0_1__m_n(1)
        x2 = X0_1__m_n.X0_1__m_n(2)
        x3 = X0_1__m_n.X0_1__m_n(3)
        y = Y0_1__m_n.Y0_1__m_n(x1, x2, x3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y.getXVar()))
        self.assertIsNotNone(x1.getY0_1__m_n())
        self.assertIsNotNone(x2.getY0_1__m_n())
        self.assertIsNotNone(x3.getY0_1__m_n())
        x1.delete()
        self.assertEqual(0, len(y.getXVar()))
        self.assertIsNone(x1.getY0_1__m_n())
        self.assertIsNone(x2.getY0_1__m_n())
        self.assertIsNone(x3.getY0_1__m_n())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _01To0N_LeftTest
    def test__01To0N_LeftTest(self):
        y1 = Y0_1__0_n.Y0_1__0_n()
        x1 = X0_1__0_n.X0_1__0_n(1)
        x1.setY0_1__0_n(y1)
        x2 = X0_1__0_n.X0_1__0_n(2)
        x2.setY0_1__0_n(y1)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getXVar()))
        self.assertIsNotNone(x1.getY0_1__0_n())
        self.assertIsNotNone(x2.getY0_1__0_n())
        x1.delete()
        self.assertEqual(0, len(y1.getXVar()))
        self.assertIsNone(x1.getY0_1__0_n())
        self.assertIsNone(x2.getY0_1__0_n())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneTo0One_LeftTest
    def test__0OneTo0One_LeftTest(self):
        x = X0_1__0_1.X0_1__0_1(1)
        y = Y0_1__0_1.Y0_1__0_1()
        y.setXVar(x)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y.getXVar())
        self.assertIsNotNone(x.getY0_1__0_1())
        x.delete()
        self.assertIsNone(y.getXVar())
        self.assertIsNone(x.getY0_1__0_1())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: OneToOne_RightTest
    def test_OneToOne_RightTest(self):
        y = YR_1_1.YR_1_1(1)
        z = y.getZVar()
        y.getZVar().delete()
        self.assertIsNone(y.getZVar())
        self.assertIsNone(z.getY_1_1())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MToOne_RightTest
    def test_MToOne_RightTest(self):
        z = Z_M_1.Z_M_1(1)
        y = YR_M_1.YR_M_1(z)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y.getZVar())
        self.assertNotEqual(0, len(z.getY_m_1()))
        z.delete()
        self.assertIsNone(y.getZVar())
        self.assertEqual(0, len(z.getY_m_1()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MToM_RightTest
    def test_MToM_RightTest(self):
        y1 = YR_M_M.YR_M_M()
        y2 = YR_M_M.YR_M_M()
        y3 = YR_M_M.YR_M_M()
        z = Z_M_M.Z_M_M(1)
        z.setY_m_m(y1, y2, y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(y3.getZVar()))
        self.assertNotEqual(0, len(z.getY_m_m()))
        z.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(y3.getZVar()))
        self.assertEqual(0, len(z.getY_m_m()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: OneToStar_RightTest
    def test_OneToStar_RightTest(self):
        y = YR_1_star.YR_1_star()
        z = Z_1_star.Z_1_star(1, y)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y.getZVar()))
        self.assertIsNotNone(z.getY_1_star())
        z.delete()
        self.assertEqual(0, len(y.getZVar()))
        self.assertIsNone(z.getY_1_star())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MToStar_RightTest
    def test_MToStar_RightTest(self):
        y1 = YR_M_star.YR_M_star()
        y2 = YR_M_star.YR_M_star()
        y3 = YR_M_star.YR_M_star()
        z = Z_M_star.Z_M_star(1, y1, y2, y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(y3.getZVar()))
        self.assertNotEqual(0, len(z.getY_m_star()))
        z.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(y3.getZVar()))
        self.assertEqual(0, len(z.getY_m_star()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: StarToStar_RightTest
    def test_StarToStar_RightTest(self):
        y1 = YR_star_star.YR_star_star()
        y2 = YR_star_star.YR_star_star()
        y3 = YR_star_star.YR_star_star()
        z1 = Z_star_star.Z_star_star(1)
        z1.addY_star_star(y1)
        z1.addY_star_star(y2)
        z1.addY_star_star(y3)
        z2 = Z_star_star.Z_star_star(2)
        z2.addY_star_star(y1)
        z2.addY_star_star(y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(y3.getZVar()))
        self.assertNotEqual(0, len(z1.getY_star_star()))
        self.assertNotEqual(0, len(z2.getY_star_star()))
        y1.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(y3.getZVar()))
        self.assertEqual(0, len(z1.getY_star_star()))
        self.assertEqual(0, len(z2.getY_star_star()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MNToOne_RightTest
    def test_MNToOne_RightTest(self):
        z = Z_m_n__1.Z_m_n__1(1)
        y = YR_m_n__1.YR_m_n__1(z)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y.getZVar())
        self.assertNotEqual(0, len(z.getY_m_n__1()))
        z.delete()
        self.assertIsNone(y.getZVar())
        self.assertEqual(0, len(z.getY_m_n__1()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MNToM_RightTest
    def test_MNToM_RightTest(self):
        y1 = YR_m_n__m.YR_m_n__m()
        y2 = YR_m_n__m.YR_m_n__m()
        y3 = YR_m_n__m.YR_m_n__m()
        z = Z_m_n__m.Z_m_n__m(1)
        z.setY_m_n__m(y1, y2, y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(y3.getZVar()))
        self.assertNotEqual(0, len(z.getY_m_n__m()))
        z.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(y3.getZVar()))
        self.assertEqual(0, len(z.getY_m_n__m()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MNToStar_RightTest
    def test_MNToStar_RightTest(self):
        y1 = YR_m_n__star.YR_m_n__star()
        y2 = YR_m_n__star.YR_m_n__star()
        y3 = YR_m_n__star.YR_m_n__star()
        z = Z_m_n__star.Z_m_n__star(1, y1, y2)
        z.addY_m_n__star(y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(y3.getZVar()))
        self.assertNotEqual(0, len(z.getY_m_n__star()))
        z.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(y3.getZVar()))
        self.assertEqual(0, len(z.getY_m_n__star()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: MNToMN_RightTest
    def test_MNToMN_RightTest(self):
        y1 = YR_m_n__m_n.YR_m_n__m_n()
        y2 = YR_m_n__m_n.YR_m_n__m_n()
        z = Z_m_n__m_n.Z_m_n__m_n(1)
        z.setY_m_n__m_n(y1, y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(z.getY_m_n__m_n()))
        z.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(z.getY_m_n__m_n()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0NToOne_RightTest
    def test__0NToOne_RightTest(self):
        z = Z_0_n__1.Z_0_n__1(1)
        y = YR_0_n__1.YR_0_n__1(z)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y.getZVar())
        self.assertNotEqual(0, len(z.getY_0_n__1()))
        z.delete()
        self.assertIsNone(y.getZVar())
        self.assertEqual(0, len(z.getY_0_n__1()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0NToM_RightTest
    def test__0NToM_RightTest(self):
        y1 = YR_0_n__m.YR_0_n__m()
        y2 = YR_0_n__m.YR_0_n__m()
        y3 = YR_0_n__m.YR_0_n__m()
        z = Z_0_n__m.Z_0_n__m(1)
        z.addY_0_n__m(y1)
        z.addY_0_n__m(y2)
        z.addY_0_n__m(y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(y3.getZVar()))
        self.assertNotEqual(0, len(z.getY_0_n__m()))
        z.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(y3.getZVar()))
        self.assertEqual(0, len(z.getY_0_n__m()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0NToStar_RightTest
    def test__0NToStar_RightTest(self):
        y1 = YR_0_n__star.YR_0_n__star()
        y2 = YR_0_n__star.YR_0_n__star()
        z = Z_0_n__star.Z_0_n__star(1)
        z.addY_0_n__star(y1)
        z.addY_0_n__star(y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(z.getY_0_n__star()))
        z.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(z.getY_0_n__star()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0NTo0N_RightTest
    def test__0NTo0N_RightTest(self):
        y1 = YR_0_n__0_n.YR_0_n__0_n()
        y2 = YR_0_n__0_n.YR_0_n__0_n()
        z1 = Z_0_n__0_n.Z_0_n__0_n(1)
        z1.addY_0_n__0_n(y1)
        z1.addY_0_n__0_n(y2)
        z2 = Z_0_n__0_n.Z_0_n__0_n(2)
        z2.addY_0_n__0_n(y1)
        z2.addY_0_n__0_n(y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertNotEqual(0, len(y2.getZVar()))
        self.assertNotEqual(0, len(z1.getY_0_n__0_n()))
        self.assertNotEqual(0, len(z2.getY_0_n__0_n()))
        y1.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertEqual(0, len(y2.getZVar()))
        self.assertEqual(0, len(z1.getY_0_n__0_n()))
        self.assertEqual(0, len(z2.getY_0_n__0_n()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneToOne_RightTest
    def test__0OneToOne_RightTest(self):
        z = Z_0_1__1.Z_0_1__1(1)
        y = YR_0_1__1.YR_0_1__1(z)
        y.getZVar().delete()
        self.assertIsNone(y.getZVar())
        self.assertIsNone(z.getY_0_1__1())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneToM_RightTest
    def test__0OneToM_RightTest(self):
        z1 = Z_0_1__m.Z_0_1__m(1)
        z2 = Z_0_1__m.Z_0_1__m(2)
        z3 = Z_0_1__m.Z_0_1__m(3)
        y = YR_0_1__m.YR_0_1__m(z1, z2, z3)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(z1.getY_0_1__m())
        self.assertIsNotNone(z2.getY_0_1__m())
        self.assertIsNotNone(z3.getY_0_1__m())
        self.assertNotEqual(0, len(y.getZVar()))
        z1.delete()
        self.assertIsNone(z1.getY_0_1__m())
        self.assertIsNone(z2.getY_0_1__m())
        self.assertIsNone(z3.getY_0_1__m())
        self.assertEqual(0, len(y.getZVar()))

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneToStar_RightTest
    def test__0OneToStar_RightTest(self):
        y = YR_0_1__star.YR_0_1__star()
        z = Z_0_1__star.Z_0_1__star(1)
        z.setY_0_1__star(y)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y.getZVar()))
        self.assertIsNotNone(z.getY_0_1__star())
        z.delete()
        self.assertEqual(0, len(y.getZVar()))
        self.assertIsNone(z.getY_0_1__star())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneToMN_RightTest
    def test__0OneToMN_RightTest(self):
        z1 = Z_0_1__m_n.Z_0_1__m_n(1)
        z2 = Z_0_1__m_n.Z_0_1__m_n(2)
        z3 = Z_0_1__m_n.Z_0_1__m_n(3)
        y = YR_0_1__m_n.YR_0_1__m_n(z1, z2, z3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y.getZVar()))
        self.assertIsNotNone(z1.getY_0_1__m_n())
        self.assertIsNotNone(z2.getY_0_1__m_n())
        self.assertIsNotNone(z3.getY_0_1__m_n())
        y.delete()
        self.assertEqual(0, len(y.getZVar()))
        self.assertIsNone(z1.getY_0_1__m_n())
        self.assertIsNone(z2.getY_0_1__m_n())
        self.assertIsNone(z3.getY_0_1__m_n())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _01To0N_RightTest
    def test__01To0N_RightTest(self):
        y1 = YR_0_1__0_n.YR_0_1__0_n()
        z1 = Z_0_1__0_n.Z_0_1__0_n(1)
        z1.setY_0_1__0_n(y1)
        z2 = Z_0_1__0_n.Z_0_1__0_n(2)
        z2.setY_0_1__0_n(y1)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, len(y1.getZVar()))
        self.assertIsNotNone(z1.getY_0_1__0_n())
        self.assertIsNotNone(z2.getY_0_1__0_n())
        y1.delete()
        self.assertEqual(0, len(y1.getZVar()))
        self.assertIsNone(z1.getY_0_1__0_n())
        self.assertIsNone(z2.getY_0_1__0_n())

    # testbed/test/cruise/associations/CompositionMultiplicity_DeleteCodeTests.java: _0OneTo0One_RightTest
    def test__0OneTo0One_RightTest(self):
        z = Z_0_1__0_1.Z_0_1__0_1(1)
        y = YR_0_1__0_1.YR_0_1__0_1()
        y.setZVar(z)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y.getZVar())
        self.assertIsNotNone(z.getY_0_1__0_1())
        z.delete()
        self.assertIsNone(y.getZVar())
        self.assertIsNone(z.getY_0_1__0_1())
