import unittest

from ImportModules import importModules

importModules(["MentorAF"], ["associations"])
from ImportModules import *


class ReflexiveOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/ReflexiveOneTest.java: getFriend
    def test_getFriend(self):
        m = MentorAF.MentorAF("m1", "m2")
        m2 = m.getFriend()
        self.assertIs(m2, m.getFriend())
        self.assertIs(m, m2.getFriend())