import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["BoatA", "BoatB"], ["attributes", "test"])
from ImportModules import *


class ConstraintTest(unittest.TestCase):
    def test_checkConstraint(self):
        boat = BoatA.BoatA(20)
        self.assertEqual(False, boat.setAge(18))
        self.assertEqual(True, boat.setAge(19))

    def test_checkNegation(self):
        boat = BoatB.BoatB(2)
        self.assertEqual(True, boat.setAge(18))
        self.assertEqual(False, boat.setAge(19))
