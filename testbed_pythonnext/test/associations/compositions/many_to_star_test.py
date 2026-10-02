import unittest

from ImportModules import importModules

importModules(["XM_star", "YM_star"], ["associations", "compositions"])
from ImportModules import *


class ManyToStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/ManyToStarTest.java: setAndDelete
    def test_setAndDelete(self):
        y1 = YM_star.YM_star()
        y2 = YM_star.YM_star()
        y3 = YM_star.YM_star()
        x1 = XM_star.XM_star(3, y1, y2, y3)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, y2.numberOfXVar())
        self.assertNotEqual(0, y3.numberOfXVar())
        self.assertNotEqual(0, x1.numberOfYm_star())
        x1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, y2.numberOfXVar())
        self.assertEqual(0, y3.numberOfXVar())
        self.assertEqual(0, x1.numberOfYm_star())
