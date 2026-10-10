import unittest

from ImportModules import importModules

importModules(["Xm_n__1", "Ym_n__1"], ["associations", "compositions"])
from ImportModules import *


class MNToOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/MNToOneTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = Xm_n__1.Xm_n__1(1)
        y1 = Ym_n__1.Ym_n__1(x1)
        y2 = Ym_n__1.Ym_n__1(x1)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, x1.numberOfYm_n__1())
        self.assertIsNotNone(y1.getXVar())
        self.assertIsNotNone(y2.getXVar())
        x1.delete()
        self.assertEqual(0, x1.numberOfYm_n__1())
        self.assertIsNone(y1.getXVar())
        self.assertIsNone(y2.getXVar())
