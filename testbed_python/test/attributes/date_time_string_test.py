import unittest
import datetime

from ImportModules import importModules

importModules(["DoorE", "DoorF"], ["attributes", "test"])
from ImportModules import *


class DateTimeStringTest(unittest.TestCase):
    # testbed/test/cruise/attributes/test/DateTimeStringTest.java: Date
    def test_Date(self):
        door = DoorE.DoorE()
        self.assertEqual(datetime.date(1978, 12, 1), door.getD1())
        self.assertEqual(datetime.date(1978, 12, 2), door.getD2())
        self.assertEqual(datetime.date(1978, 12, 3), door.getD3())
        self.assertEqual(datetime.date(1978, 12, 4), door.getD4())
        door.resetD3()
        self.assertEqual(datetime.date(1978, 12, 3), door.getD3())

    # testbed/test/cruise/attributes/test/DateTimeStringTest.java: Time
    def test_Time(self):
        door = DoorF.DoorF()
        self.assertEqual(datetime.time(12, 51, 51), door.getD1())
        self.assertEqual(datetime.time(12, 52, 52), door.getD2())
        self.assertEqual(datetime.time(12, 53, 53), door.getD3())
        self.assertEqual(datetime.time(12, 54, 54), door.getD4())
        door.resetD3()
        self.assertEqual(datetime.time(12, 53, 53), door.getD3())
