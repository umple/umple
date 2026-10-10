import unittest

from ImportModules import importModules

importModules(["X0_n__m_n", "Y0_n__m_n"], ["associations", "compositions"])
from ImportModules import *


class OptionalNtoMNTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalNtoMNTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_n__m_n.X0_n__m_n(1)
        x2 = X0_n__m_n.X0_n__m_n(1)
        y1 = Y0_n__m_n.Y0_n__m_n()
        y1.addXVar(x1)
        y1.addXVar(x2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, x1.numberOfY0_n__m_n())
        self.assertNotEqual(0, x2.numberOfY0_n__m_n())
        y1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, x1.numberOfY0_n__m_n())
        self.assertEqual(0, x2.numberOfY0_n__m_n())
