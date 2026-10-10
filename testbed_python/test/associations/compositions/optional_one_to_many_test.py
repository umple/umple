import unittest

from ImportModules import importModules

importModules(["X0_1__m", "Y0_1__m"], ["associations", "compositions"])
from ImportModules import *


class OptionalOneToManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalOneToManyTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_1__m.X0_1__m(1)
        x2 = X0_1__m.X0_1__m(1)
        x3 = X0_1__m.X0_1__m(1)
        y1 = Y0_1__m.Y0_1__m(x1, x2, x3)
        self.assertIs(y1, x1.getY0_1__m())
        self.assertIs(y1, x2.getY0_1__m())
        self.assertIs(y1, x3.getY0_1__m())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertIsNotNone(x1.getY0_1__m())
        self.assertIsNotNone(x2.getY0_1__m())
        self.assertIsNotNone(x3.getY0_1__m())
        y1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertIsNone(x1.getY0_1__m())
        self.assertIsNone(x2.getY0_1__m())
        self.assertIsNone(x3.getY0_1__m())
