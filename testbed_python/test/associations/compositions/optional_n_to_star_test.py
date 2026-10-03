import unittest

from ImportModules import importModules

importModules(["X0_n__star", "Y0_n__star"], ["associations", "compositions"])
from ImportModules import *


class OptionalNToStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalNToStarTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_n__star.X0_n__star(1)
        y1 = Y0_n__star.Y0_n__star()
        y2 = Y0_n__star.Y0_n__star()
        x1.addY0_n__star(y1)
        x1.addY0_n__star(y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, x1.numberOfY0_n__star())
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, y2.numberOfXVar())
        x1.delete()
        self.assertEqual(0, x1.numberOfY0_n__star())
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, y2.numberOfXVar())
