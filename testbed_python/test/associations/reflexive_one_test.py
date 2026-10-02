import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorAF"], ["associations"])
from ImportModules import *

class ReflexiveOneTest(unittest.TestCase):
    def test_getFriend(self):
        m = MentorAF.MentorAF("m1","m2")
        m2 = m.getFriend()
    
        self.assertEqual(m2, m.getFriend())
        self.assertEqual(m, m2.getFriend())