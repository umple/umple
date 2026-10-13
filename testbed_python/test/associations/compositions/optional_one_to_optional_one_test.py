import unittest

from ImportModules import importModules

importModules(["X0_1__0_1", "Y0_1__0_1"], ["associations", "compositions"])
from ImportModules import *


class OptionalOneToOptionalOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalOneToOptionalOneTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_1__0_1.X0_1__0_1(1)
        y1 = Y0_1__0_1.Y0_1__0_1()
        self.assertIs(True, x1.setY0_1__0_1(y1))
        self.assertIs(x1, y1.getXVar())
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y1.getXVar())
        self.assertIsNotNone(x1.getY0_1__0_1())
        x1.delete()
        self.assertIsNone(y1.getXVar())
        self.assertIsNone(x1.getY0_1__0_1())
