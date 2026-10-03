import unittest

from ImportModules import importModules

importModules(["Xm_n__m_n", "Ym_n__m_n"], ["associations", "compositions"])
from ImportModules import *


class MNToMNTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/MNToMNTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = Xm_n__m_n.Xm_n__m_n(1)
        x2 = Xm_n__m_n.Xm_n__m_n(1)
        x3 = Xm_n__m_n.Xm_n__m_n(1)
        y1 = Ym_n__m_n.Ym_n__m_n()
        y2 = Ym_n__m_n.Ym_n__m_n()
        y3 = Ym_n__m_n.Ym_n__m_n()
        x1.addYm_n__m_n(y1)
        x1.addYm_n__m_n(y2)
        x1.addYm_n__m_n(y3)
        y1.addXVar(x2)
        y1.addXVar(x3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, x1.numberOfYm_n__m_n())
        self.assertNotEqual(0, x2.numberOfYm_n__m_n())
        self.assertNotEqual(0, x3.numberOfYm_n__m_n())
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, y2.numberOfXVar())
        self.assertNotEqual(0, y3.numberOfXVar())
        x1.delete()
        y1.delete()
        self.assertEqual(0, x1.numberOfYm_n__m_n())
        self.assertEqual(0, x2.numberOfYm_n__m_n())
        self.assertEqual(0, x3.numberOfYm_n__m_n())
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, y2.numberOfXVar())
        self.assertEqual(0, y3.numberOfXVar())
