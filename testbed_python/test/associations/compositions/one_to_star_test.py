import unittest

from ImportModules import importModules

importModules(["X1_star", "Y1_star"], ["associations", "compositions"])
from ImportModules import *


class OneToStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OneToStarTest.java: setAndDelete
    def test_setAndDelete(self):
        y1 = Y1_star.Y1_star()
        x1 = X1_star.X1_star(1, y1)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(x1.getY1_star())
        self.assertNotEqual(0, y1.numberOfXVar())
        y1.delete()
        self.assertIsNone(x1.getY1_star())
        self.assertEqual(0, y1.numberOfXVar())
