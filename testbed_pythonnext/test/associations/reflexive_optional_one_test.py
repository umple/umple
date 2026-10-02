import unittest

from ImportModules import importModules

importModules(["MentorH"], ["associations"])
from ImportModules import *


class ReflexiveOptionalOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/ReflexiveOptionalOneTest.java: SetSuperMentor
    def test_SetSuperMentor(self):
        m = MentorH.MentorH("m1")
        m2 = MentorH.MentorH("m2")
        m.setSuperMentor(m2)
        self.assertIs(m, m2.getSuperMentor())
        self.assertIs(m2, m.getSuperMentor())
