import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["DoorB", "DoorD"], ["attributes", "test"])
from ImportModules import *


class DefaultedTest(unittest.TestCase):
    @unittest.skip("Update with different Date/Time")
    def test_defaulted(self):
        door = DoorD.DoorD()
    
        self.assertEqual("1", door.getId())
        self.assertEqual(True, door.setId("2"))
        self.assertEqual("2",door.getId())
        self.assertEqual(True, door.resetId())
        self.assertEqual("1",door.getId())
    
        self.assertEqual(2,door.getIntId())
        self.assertEqual(True, door.setIntId(3))
        self.assertEqual(3,door.getIntId())
        self.assertEqual(True, door.resetIntId())
        self.assertEqual(2,door.getIntId())

        self.assertEqual(3.4,door.getDoubleId(),0.01)
        self.assertEqual(True, door.setDoubleId(33.44))
        self.assertEqual(33.44,door.getDoubleId(),0.01)
        self.assertEqual(True, door.resetDoubleId())
        self.assertEqual(3.4,door.getDoubleId(),0.01)

        self.assertEqual(Date(1234),door.getDateId())
        self.assertEqual(True, door.setDateId(Date(4321)))
        self.assertEqual(Date(4321),door.getDateId())
        self.assertEqual(True, door.resetDateId())
        self.assertEqual(Date(1234),door.getDateId())

        self.assertEqual(Time(1235),door.getTimeId())
        self.assertEqual(True, door.setTimeId(Time(5321)))
        self.assertEqual(Time(5321),door.getTimeId())
        self.assertEqual(True, door.resetTimeId())
        self.assertEqual(Time(1235),door.getTimeId())

        self.assertEqual(False,door.getBooleanId())
        self.assertEqual(True, door.setBooleanId(True))
        self.assertEqual(True,door.getBooleanId())
        self.assertEqual(True, door.resetBooleanId())
        self.assertEqual(False,door.getBooleanId())

        self.assertEqual(DoorB.DoorB(5),door.getDoorId())
        self.assertEqual(True, door.setDoorId(DoorB.DoorB(6)))
        self.assertEqual(DoorB.DoorB(6),door.getDoorId())
        self.assertEqual(True, door.resetDoorId())
        self.assertEqual(DoorB.DoorB(5),door.getDoorId())
  
