import unittest

from ImportModules import importModules

importModules(["YR_star_star", "Z_star_star"], ["associations", "compositions"])
from ImportModules import *


class ReflexiveStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/ReflexiveStarTest.java: check42
    def test_check42(self):
        z1 = Z_star_star.Z_star_star(1)
        y1 = YR_star_star.YR_star_star()
        y1.addZVar(z1)
        self.assertIs(z1, y1.getZVar(0))
        self.assertIs(y1, z1.getY_star_star(0))
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfZVar())
        self.assertNotEqual(0, z1.numberOfY_star_star())
        y1.delete()
        self.assertEqual(0, y1.numberOfZVar())
        self.assertEqual(0, z1.numberOfY_star_star())
