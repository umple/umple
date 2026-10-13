import unittest

from ImportModules import importModules

importModules(["BoatA", "BoatB"], ["attributes", "test"])
from ImportModules import *


class ConstraintTest(unittest.TestCase):
    # testbed/test/cruise/attributes/test/ConstraintTest.java: checkConstraint
    def test_checkConstraint(self):
        boat = BoatA.BoatA(20)
        self.assertIs(False, boat.setAge(18))
        self.assertIs(True, boat.setAge(19))

    # testbed/test/cruise/attributes/test/ConstraintTest.java: checkNegation
    def test_checkNegation(self):
        boat = BoatB.BoatB(2)
        self.assertIs(True, boat.setAge(18))
        self.assertIs(False, boat.setAge(19))
