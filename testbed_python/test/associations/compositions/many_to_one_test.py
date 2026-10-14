import unittest

from ImportModules import importModules

importModules(["XM_1", "YM_1"], ["associations", "compositions"])
from ImportModules import *


class ManytoOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/ManytoOneTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = XM_1.XM_1(1)
        y1 = YM_1.YM_1(x1)
        y2 = YM_1.YM_1(x1)
        y3 = YM_1.YM_1(x1)
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y1.getXVar())
        self.assertIsNotNone(y2.getXVar())
        self.assertIsNotNone(y3.getXVar())
        self.assertNotEqual(0, x1.numberOfYm_1())
        x1.delete()
        self.assertIsNone(y1.getXVar())
        self.assertIsNone(y2.getXVar())
        self.assertIsNone(y3.getXVar())
        self.assertEqual(0, x1.numberOfYm_1())
