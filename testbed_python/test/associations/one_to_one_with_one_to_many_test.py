import unittest

from ImportModules import importModules

importModules(["MentorAN"], ["associations"])
from ImportModules import *


class OneToOneWithOneToManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToOneWithOneToManyTest.java: CreateMentorWithoutStudents
    def test_CreateMentorWithoutStudents(self):
        m = MentorAN.MentorAN("blah")
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNotNone(m.getGradStudent())
