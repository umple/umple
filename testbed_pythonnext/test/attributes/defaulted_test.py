import unittest
import datetime

from ImportModules import importModules

importModules(["DoorB", "DoorD"], ["attributes", "test"])
from ImportModules import *


class DefaultedTest(unittest.TestCase):
    # testbed/test/cruise/attributes/test/DefaultedTest.java: defaulted
    # The Date and Time defaults are the ones in testbed_pythonnext/src/LocalHarness.ump
    def test_defaulted(self):
        door = DoorD.DoorD()

        self.assertEqual("1", door.getId())
        self.assertIs(True, door.setId("2"))
        self.assertEqual("2", door.getId())
        self.assertIs(True, door.resetId())
        self.assertEqual("1", door.getId())

        self.assertEqual(2, door.getIntId())
        self.assertIs(True, door.setIntId(3))
        self.assertEqual(3, door.getIntId())
        self.assertIs(True, door.resetIntId())
        self.assertEqual(2, door.getIntId())

        self.assertAlmostEqual(3.4, door.getDoubleId(), delta=0.01)
        self.assertIs(True, door.setDoubleId(33.44))
        self.assertAlmostEqual(33.44, door.getDoubleId(), delta=0.01)
        self.assertIs(True, door.resetDoubleId())
        self.assertAlmostEqual(3.4, door.getDoubleId(), delta=0.01)

        self.assertEqual(datetime.date(1978, 12, 5), door.getDateId())
        self.assertIs(True, door.setDateId(datetime.date(1979, 1, 2)))
        self.assertEqual(datetime.date(1979, 1, 2), door.getDateId())
        self.assertIs(True, door.resetDateId())
        self.assertEqual(datetime.date(1978, 12, 5), door.getDateId())

        self.assertEqual(datetime.time(10, 11, 15), door.getTimeId())
        self.assertIs(True, door.setTimeId(datetime.time(20, 21, 22)))
        self.assertEqual(datetime.time(20, 21, 22), door.getTimeId())
        self.assertIs(True, door.resetTimeId())
        self.assertEqual(datetime.time(10, 11, 15), door.getTimeId())

        self.assertIs(False, door.getBooleanId())
        self.assertIs(True, door.setBooleanId(True))
        self.assertIs(True, door.getBooleanId())
        self.assertIs(True, door.resetBooleanId())
        self.assertIs(False, door.getBooleanId())

        # DoorB is keyed on id, so equal keys are equal objects (Java equals, Python ==)
        self.assertEqual(DoorB.DoorB(5), door.getDoorId())
        self.assertIs(True, door.setDoorId(DoorB.DoorB(6)))
        self.assertEqual(DoorB.DoorB(6), door.getDoorId())
        self.assertIs(True, door.resetDoorId())
        self.assertEqual(DoorB.DoorB(5), door.getDoorId())
