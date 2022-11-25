import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

# Temporarily commented: until Date/Time is implemented
# importModules(["ConstDefault", "ConstDefaultInterfaceObject"], ["associations", "test"])
from ImportModules import *
import datetime


class ConstTest(unittest.TestCase):
    @unittest.skip("Date/Time needs to be implemented")
    def test_constant(self):
        cd = ConstDefault.ConstDefault()
        currentDate = datetime.datetime.now()

        self.assertEqual(0, cd.I1)
        self.assertEqual(0, cd.I2)
        self.assertEqual(0.0, cd.D1, 0.0)
        self.assertEqual(0.0, cd.D2, 0.0)
        self.assertEqual(0.0, cd.F1, 0.0)
        self.assertEqual(0.0, cd.F2, 0.0)
        self.assertEqual(False, cd.B1)
        self.assertEqual(False, cd.B2)
        self.assertEqual("", cd.STR)
        self.assertEqual(datetime.strptime("00:00:00", "%H:%M:%S"), cd.TIME)
        self.assertEqual(str(currentDate), str(cd.DATE))

    @unittest.skip("Date/Time needs to be implemented")
    def test_constantInterface(self):
        cd = ConstDefaultInterfaceObject.ConstDefaultInterfaceObject()

        currentDate = datetime.datetime.now()

        self.assertEqual(0, cd.I1)
        self.assertEqual(0, cd.I2)
        self.assertEqual(0.0, cd.D1, 0.0)
        self.assertEqual(0.0, cd.D2, 0.0)
        self.assertEqual(0.0, cd.F1, 0.0)
        self.assertEqual(0.0, cd.F2, 0.0)
        self.assertEqual(False, cd.B1)
        self.assertEqual(False, cd.B2)
        self.assertEqual("", cd.STR)
        self.assertEqual(datetime.strptime("00:00:00", "%H:%M:%S"), cd.TIME)
        self.assertEqual(str(currentDate), str(cd.DATE))
