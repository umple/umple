import unittest

from ImportModules import importModules

importModules(["X0_n__0_n", "Y0_n__0_n"], ["associations", "compositions"])
from ImportModules import *


class OptionalNToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalNToOptionalNTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_n__0_n.X0_n__0_n(1)
        y1 = Y0_n__0_n.Y0_n__0_n()
        y1.addXVar(x1)
        y1.addXVar(X0_n__0_n.X0_n__0_n(1))
        x1.addY0_n__0_n(Y0_n__0_n.Y0_n__0_n())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, x1.numberOfY0_n__0_n())
        self.assertNotEqual(0, y1.numberOfXVar())
        x1.delete()
        self.assertEqual(0, x1.numberOfY0_n__0_n())
        self.assertEqual(0, y1.numberOfXVar())
