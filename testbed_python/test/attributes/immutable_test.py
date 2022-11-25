import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["DoorA", "DoorB", "DoorC"], ["attributes", "test"])
from ImportModules import *
import datetime


class ImmutableTest(unittest.TestCase):
    @unittest.skip("Update with different Date/Time")
    def test_Immutable(self):
        door = DoorC.DoorC(
            "1",
            2,
            3.4,
            datetime.datetime.strptime("1234", "%Y").date(),
            datetime.datetime.strptime("1235", "%H%M"),
            False,
            DoorB.DoorB(5),
        )

        self.assertEqual("1", door.getId())

        self.assertEqual(2, door.getIntId())

        self.assertEqual(3.4, door.getDoubleId(), 0.01)

        self.assertEqual(
            datetime.datetime.strptime("1234", "%Y").date(),
            door.getDateId(),
            "DateTime object did not match",
        )

        self.assertEqual(
            datetime.datetime.strptime("1235", "%H%M"),
            door.getTimeId(),
            "DateTime object did not match",
        )

        self.assertEqual(False, door.getBooleanId())

        self.assertEqual(DoorB.DoorB(5), door.getDoorId())

    @unittest.skip("Update with different Date/Time")
    def test_ImmutableInitialized(self):
        door = DoorA.DoorA()
        self.assertEqual("1", door.getId())

        self.assertEqual(2, door.getIntId())

        self.assertEqual(3.4, door.getDoubleId(), 0.01)

        self.assertEqual(Date(1234), door.getDateId())

        self.assertEqual(Time(1235), door.getTimeId())

        self.assertEqual(False, door.getBooleanId())

        self.assertEqual(DoorB(5), door.getDoorId())
