import unittest

from ImportModules import importModules

importModules(["X0_1__m_n", "Y0_1__m_n"], ["associations", "compositions"])
from ImportModules import *


class OptionalOneToMNTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalOneToMNTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_1__m_n.X0_1__m_n(1)
        x2 = X0_1__m_n.X0_1__m_n(1)
        y1 = Y0_1__m_n.Y0_1__m_n(x1, x2)
        self.assertIs(y1, x1.getY0_1__m_n())
        self.assertIs(y1, x2.getY0_1__m_n())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertIsNotNone(x1.getY0_1__m_n())
        self.assertIsNotNone(x2.getY0_1__m_n())
        y1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertIsNone(x1.getY0_1__m_n())
        self.assertIsNone(x2.getY0_1__m_n())
