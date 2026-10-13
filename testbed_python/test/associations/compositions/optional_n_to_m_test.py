import unittest

from ImportModules import importModules

importModules(["X0_n__m", "Y0_n__m"], ["associations", "compositions"])
from ImportModules import *


class OptionalNToMTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalNToMTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_n__m.X0_n__m(1)
        x2 = X0_n__m.X0_n__m(1)
        x3 = X0_n__m.X0_n__m(1)
        y1 = Y0_n__m.Y0_n__m()
        y1.addXVar(x1)
        y1.addXVar(x2)
        y1.addXVar(x3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, x1.numberOfY0_n__m())
        self.assertNotEqual(0, x2.numberOfY0_n__m())
        self.assertNotEqual(0, x3.numberOfY0_n__m())
        y1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, x1.numberOfY0_n__m())
        self.assertEqual(0, x2.numberOfY0_n__m())
        self.assertEqual(0, x3.numberOfY0_n__m())
