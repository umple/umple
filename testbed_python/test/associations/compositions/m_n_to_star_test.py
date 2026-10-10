import unittest

from ImportModules import importModules

importModules(["Xm_n__star", "Ym_n__star"], ["associations", "compositions"])
from ImportModules import *


class MNToStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/MNToStarTest.java: setAndDelete
    def test_setAndDelete(self):
        y1 = Ym_n__star.Ym_n__star()
        y2 = Ym_n__star.Ym_n__star()
        x1 = Xm_n__star.Xm_n__star(2, y1, y2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, y2.numberOfXVar())
        self.assertNotEqual(0, x1.numberOfYm_n__star())
        x1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, y2.numberOfXVar())
        self.assertEqual(0, x1.numberOfYm_n__star())
