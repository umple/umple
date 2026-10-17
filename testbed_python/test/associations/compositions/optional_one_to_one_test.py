import unittest

from ImportModules import importModules

importModules(["X0_1__1", "Y0_1__1"], ["associations", "compositions"])
from ImportModules import *


class OptionalOneToOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalOneToOneTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_1__1.X0_1__1(1)
        y1 = Y0_1__1.Y0_1__1(x1)
        self.assertIs(y1, x1.getY0_1__1())
        self.assertIs(x1, y1.getXVar())
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(x1.getY0_1__1())
        self.assertIsNotNone(y1.getXVar())
        y1.delete()
        self.assertIsNone(x1.getY0_1__1())
        self.assertIsNone(y1.getXVar())
