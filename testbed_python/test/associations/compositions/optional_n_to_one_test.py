import unittest

from ImportModules import importModules

importModules(["X0_n__1", "Y0_n__1"], ["associations", "compositions"])
from ImportModules import *


class OptionalNtoOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalNtoOneTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_n__1.X0_n__1(1)
        x2 = X0_n__1.X0_n__1(1)
        y1 = Y0_n__1.Y0_n__1(x1)
        x1.addY0_n__1(Y0_n__1.Y0_n__1(x2))
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y1.getXVar())
        self.assertNotEqual(0, x1.numberOfY0_n__1())
        x1.delete()
        self.assertIsNone(y1.getXVar())
        self.assertEqual(0, x1.numberOfY0_n__1())
