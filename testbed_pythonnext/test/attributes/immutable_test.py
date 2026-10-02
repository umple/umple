import unittest
import datetime

from ImportModules import importModules

importModules(["DoorA", "DoorB", "DoorC"], ["attributes", "test"])
from ImportModules import *

IMMUTABLE_ATTRIBUTES = ["Id", "IntId", "DoubleId", "DateId", "TimeId", "BooleanId", "DoorId"]


class ImmutableTest(unittest.TestCase):
    # testbed/test/cruise/attributes/test/ImmutableTest.java: Immutable
    # Immutable attributes expose getters but no setters; the last assertion checks that.
    def test_Immutable(self):
        door = DoorC.DoorC(
            "1", 2, 3.4, datetime.date(1978, 12, 1), datetime.time(12, 51, 51), False, DoorB.DoorB(5)
        )
        self.assertEqual("1", door.getId())
        self.assertEqual(2, door.getIntId())
        self.assertAlmostEqual(3.4, door.getDoubleId(), delta=0.01)
        self.assertEqual(datetime.date(1978, 12, 1), door.getDateId())
        self.assertEqual(datetime.time(12, 51, 51), door.getTimeId())
        self.assertIs(False, door.getBooleanId())
        self.assertEqual(DoorB.DoorB(5), door.getDoorId())
        self.assertEqual([], [n for n in IMMUTABLE_ATTRIBUTES if hasattr(door, "set" + n)])

    # testbed/test/cruise/attributes/test/ImmutableTest.java: ImmutableInitialized
    # The Date and Time values are the ones in testbed_pythonnext/src/LocalHarness.ump
    def test_ImmutableInitialized(self):
        door = DoorA.DoorA()
        self.assertEqual("1", door.getId())
        self.assertEqual(2, door.getIntId())
        self.assertAlmostEqual(3.4, door.getDoubleId(), delta=0.01)
        self.assertEqual(datetime.date(1978, 12, 5), door.getDateId())
        self.assertEqual(datetime.time(10, 11, 15), door.getTimeId())
        self.assertIs(False, door.getBooleanId())
        self.assertEqual(DoorB.DoorB(5), door.getDoorId())
        self.assertEqual([], [n for n in IMMUTABLE_ATTRIBUTES if hasattr(door, "set" + n)])
