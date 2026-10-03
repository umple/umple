import unittest

from ImportModules import importModules

importModules(["DoorG"], ["attributes", "test"])
from ImportModules import *


class FloatTest(unittest.TestCase):
    # testbed/test/cruise/attributes/test/FloatTest.java: floatWithoutF
    def test_floatWithoutF(self):
        door = DoorG.DoorG()
        self.assertAlmostEqual(1.1, door.getFloatNoF(), delta=0.01)
        self.assertAlmostEqual(1.2, door.getFloatWithF(), delta=0.01)
        self.assertAlmostEqual(1.3, door.getDoubleNoF(), delta=0.01)
        self.assertAlmostEqual(1.4, door.getDoubleWithF(), delta=0.01)
