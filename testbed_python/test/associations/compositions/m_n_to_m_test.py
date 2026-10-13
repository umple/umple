import unittest

from ImportModules import importModules

importModules(["Xm_n__m", "Ym_n__m"], ["associations", "compositions"])
from ImportModules import *


class MNToMTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/MNToMTest.java: setAndDelete
    def test_setAndDelete(self):
        x1 = Xm_n__m.Xm_n__m(1)
        y1 = Ym_n__m.Ym_n__m()
        y1.addXVar(x1)
        # The links exist before the deletion (added to the Java test)
        self.assertNotEqual(0, y1.numberOfXVar())
        self.assertNotEqual(0, x1.numberOfYm_n__m())
        x1.delete()
        self.assertEqual(0, y1.numberOfXVar())
        self.assertEqual(0, x1.numberOfYm_n__m())
