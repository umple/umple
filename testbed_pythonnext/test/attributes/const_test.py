import unittest
import datetime

from ImportModules import importModules

importModules(["ConstDefault", "ConstDefaultInterfaceObject"], ["attributes", "test"])
from ImportModules import *


class ConstTest(unittest.TestCase):
    def _assertDefaults(self, cd):
        self.assertEqual(0, cd.I1)
        self.assertEqual(0, cd.I2)
        self.assertEqual(0.0, cd.D1)
        self.assertEqual(0.0, cd.D2)
        self.assertEqual(0.0, cd.F1)
        self.assertEqual(0.0, cd.F2)
        self.assertIs(False, cd.B1)
        self.assertIs(False, cd.B2)
        self.assertEqual("", cd.STR)
        self.assertEqual(datetime.time(0, 0, 0), cd.TIME)
        # Umple fixes a Date constant without a value to the day of generation; the Java test
        # compares it with today's date, which only holds when generation and test share a day
        self.assertIsInstance(cd.DATE, datetime.date)
        self.assertLessEqual(cd.DATE, datetime.date.today())

    # testbed/test/cruise/attributes/test/ConstTest.java: constant
    def test_constant(self):
        self._assertDefaults(ConstDefault.ConstDefault())

    # testbed/test/cruise/attributes/test/ConstTest.java: constantInterface
    def test_constantInterface(self):
        self._assertDefaults(ConstDefaultInterfaceObject.ConstDefaultInterfaceObject())
