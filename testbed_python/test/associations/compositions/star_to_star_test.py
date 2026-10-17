import unittest

from ImportModules import importModules

importModules(["Xstar_star", "Ystar_star"], ["associations", "compositions"])
from ImportModules import *


class StarToStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/StarToStarTest.java: setAndDelete
    def test_setAndDelete(self):
        y1 = Ystar_star.Ystar_star()
        y2 = Ystar_star.Ystar_star()
        x1 = Xstar_star.Xstar_star(1)
        x1.addYstar_star(y1)
        x1.addYstar_star(y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, x1.numberOfYstar_star())
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, y2.numberOfXVar())
        x1.delete()
        self.assertEqual(0, x1.numberOfYstar_star())
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, y2.numberOfXVar())
