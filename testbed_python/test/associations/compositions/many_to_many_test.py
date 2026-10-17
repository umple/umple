import unittest

from ImportModules import importModules

importModules(["XM_M", "YM_M"], ["associations", "compositions"])
from ImportModules import *


class ManyToManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/ManyToManyTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = XM_M.XM_M(2)
        x2 = XM_M.XM_M(2)
        y1 = YM_M.YM_M()
        y2 = YM_M.YM_M()
        x1.addYm_m(y1)
        x1.addYm_m(y2)
        y1.addXVar(x2)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, x1.numberOfYm_m())
        self.assertNotEqual(0, x2.numberOfYm_m())
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, y2.numberOfXVar())
        x1.delete()
        self.assertEqual(0, x1.numberOfYm_m())
        self.assertEqual(0, x2.numberOfYm_m())
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, y2.numberOfXVar())
