import unittest

from ImportModules import importModules

importModules(["Booking", "Flight", "Passenger"], ["associations"])
from ImportModules import *


class AssociationClassTest(unittest.TestCase):
    # testbed/test/cruise/associations/AssociationClassTest.java: cannotCreateMultipleLinkedInstances
    def test_cannotCreateMultipleLinkedInstances(self):
        f1 = Flight.Flight(100)
        p1 = Passenger.Passenger("Tom")
        p2 = Passenger.Passenger("Jan")
        Booking.Booking(f1, p1)
        Booking.Booking(f1, p2)
        with self.assertRaises(RuntimeError):
            Booking.Booking(f1, p2)
