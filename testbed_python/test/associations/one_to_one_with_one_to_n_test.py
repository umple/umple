import unittest

from ImportModules import importModules

importModules(["MentorAO"], ["associations"])
from ImportModules import *


class OneToOneWithOneToNTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToOneWithOneToNTest.java: CreateMentorWithoutStudents
    def test_CreateMentorWithoutStudents(self):
        m = MentorAO.MentorAO("blah")
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNotNone(m.getGradStudent())
