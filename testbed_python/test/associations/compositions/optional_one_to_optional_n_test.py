import unittest

from ImportModules import importModules

importModules(["X0_1__0_n", "Y0_1__0_n"], ["associations", "compositions"])
from ImportModules import *


class OptionalOneToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalOneToOptionalNTest.java: setAndDelete
    def test_setAndDelete(self):
        y1 = Y0_1__0_n.Y0_1__0_n()
        x1 = X0_1__0_n.X0_1__0_n(1)
        y1.addXVar(x1)
        y1.addXVar(X0_1__0_n.X0_1__0_n(1))
        self.assertEqual(2, y1.numberOfXVar())
        self.assertIs(y1, x1.getY0_1__0_n())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertIsNotNone(x1.getY0_1__0_n())
        y1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertIsNone(x1.getY0_1__0_n())
