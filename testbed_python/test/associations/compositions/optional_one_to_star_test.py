import unittest

from ImportModules import importModules

importModules(["X0_1__star", "Y0_1__star"], ["associations", "compositions"])
from ImportModules import *


class OptionalOneToStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OptionalOneToStarTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = X0_1__star.X0_1__star(1)
        x2 = X0_1__star.X0_1__star(1)
        y1 = Y0_1__star.Y0_1__star()
        x1.setY0_1__star(y1)
        x2.setY0_1__star(y1)
        self.assertIs(y1, x1.getY0_1__star())
        self.assertIs(y1, x2.getY0_1__star())
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertIsNotNone(x1.getY0_1__star())
        self.assertIsNotNone(x2.getY0_1__star())
        y1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertIsNone(x1.getY0_1__star())
        self.assertIsNone(x2.getY0_1__star())
