import unittest

from ImportModules import importModules

importModules(["MentorAL", "ProgramAL", "StudentAL"], ["associations"])
from ImportModules import *


class UnidirectionalMStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/UnidirectionalMStarTest.java: constructorTooFew
    def test_constructorTooFew(self):
        s = StudentAL.StudentAL(99)
        s2 = StudentAL.StudentAL(98)
        with self.assertRaises(RuntimeError):
            MentorAL.MentorAL("blah", s, s2)

    # testbed/test/cruise/associations/UnidirectionalMStarTest.java: constructorRequiresMinimum
    def test_constructorRequiresMinimum(self):
        s = StudentAL.StudentAL(99)
        s2 = StudentAL.StudentAL(98)
        s3 = StudentAL.StudentAL(97)
        m = MentorAL.MentorAL("blah", s, s2, s3)
        self.assertEqual(3, m.numberOfStudents())

    # testbed/test/cruise/associations/UnidirectionalMStarTest.java: addRemoveWithinLimits
    def test_addRemoveWithinLimits(self):
        s = StudentAL.StudentAL(99)
        s2 = StudentAL.StudentAL(98)
        s3 = StudentAL.StudentAL(97)
        s4 = StudentAL.StudentAL(96)
        s5 = StudentAL.StudentAL(95)
        s6 = StudentAL.StudentAL(94)
        m = MentorAL.MentorAL("blah", s, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(True, m.addStudent(s4))
        self.assertIs(True, m.addStudent(s5))
        self.assertEqual(5, m.numberOfStudents())
        self.assertIs(False, m.removeStudent(s6))
        self.assertIs(True, m.removeStudent(s3))
        self.assertIs(True, m.removeStudent(s4))
        self.assertIs(False, m.removeStudent(s))
        self.assertEqual(3, m.numberOfStudents())

    # testbed/test/cruise/associations/UnidirectionalMStarTest.java: deleteDoesNotChangeStudent
    def test_deleteDoesNotChangeStudent(self):
        s = StudentAL.StudentAL(99)
        s2 = StudentAL.StudentAL(98)
        s3 = StudentAL.StudentAL(98)
        p = ProgramAL.ProgramAL()
        s.setProgram(p)
        m = MentorAL.MentorAL("blah", s, s2, s3)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())
