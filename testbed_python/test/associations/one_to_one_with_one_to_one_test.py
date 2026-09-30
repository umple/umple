import unittest

from ImportModules import importModules

importModules(["MentorAP"], ["associations"])
from ImportModules import *


class OneToOneWithOneToOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToOneWithOneToOneTest.java: CreateMentorWithoutStudents
    def test_CreateMentorWithoutStudents(self):
        m = MentorAP.MentorAP("blah", 999)
        self.assertIsNotNone(m.getStudent())
        self.assertEqual(m.getStudent().getNumber(), 999)
        self.assertIsNotNone(m.getGradStudent())
