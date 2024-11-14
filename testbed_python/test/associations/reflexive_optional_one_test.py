import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorH"], ["associations"])
from ImportModules import *


class ReflexiveOptionalOneTest(unittest.TestCase):
    def test_SetSuperMentor(self):
        m = MentorH.MentorH("m1")
        m2 = MentorH.MentorH("m2")

        m.setSuperMentor(m2)
        self.assertEqual(m, m2.getSuperMentor())
        self.assertEqual(m2, m.getSuperMentor())
