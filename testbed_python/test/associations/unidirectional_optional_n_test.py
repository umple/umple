import unittest

from ImportModules import importModules

importModules(["MentorI", "ProgramI", "StudentI"], ["associations"])
from ImportModules import *


class UnidirectionalOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/UnidirectionalOptionalNTest.java: constructorTooFew
    def test_constructorTooFew(self):
        s = StudentI.StudentI(99)
        with self.assertRaises(RuntimeError):
            MentorI.MentorI("blah", s)

    # testbed/test/cruise/associations/UnidirectionalOptionalNTest.java: constructorTooMany
    def test_constructorTooMany(self):
        s = StudentI.StudentI(99)
        s2 = StudentI.StudentI(98)
        s3 = StudentI.StudentI(97)
        s4 = StudentI.StudentI(96)
        s5 = StudentI.StudentI(96)
        with self.assertRaises(RuntimeError):
            MentorI.MentorI("blah", s, s2, s3, s4, s5)

    # testbed/test/cruise/associations/UnidirectionalOptionalNTest.java: constructorRequiresMinimumToMaximum
    def test_constructorRequiresMinimumToMaximum(self):
        s = StudentI.StudentI(99)
        s2 = StudentI.StudentI(98)
        s3 = StudentI.StudentI(97)
        s4 = StudentI.StudentI(96)
        m = MentorI.MentorI("blah", s, s2)
        self.assertEqual(2, m.numberOfStudents())
        m2 = MentorI.MentorI("blah2", s, s2, s3, s4)
        self.assertEqual(4, m2.numberOfStudents())

    # testbed/test/cruise/associations/UnidirectionalOptionalNTest.java: addRemoveWithinLimits
    def test_addRemoveWithinLimits(self):
        s = StudentI.StudentI(99)
        s2 = StudentI.StudentI(98)
        s3 = StudentI.StudentI(97)
        s4 = StudentI.StudentI(96)
        s5 = StudentI.StudentI(95)
        m = MentorI.MentorI("blah", s, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(True, m.addStudent(s3))
        self.assertIs(True, m.addStudent(s4))
        self.assertIs(False, m.addStudent(s4))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(False, m.removeStudent(s5))
        self.assertIs(True, m.removeStudent(s3))
        self.assertIs(True, m.removeStudent(s4))
        self.assertIs(False, m.removeStudent(s))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/UnidirectionalOptionalNTest.java: deleteDoesNotChangeStudent
    def test_deleteDoesNotChangeStudent(self):
        s = StudentI.StudentI(99)
        s2 = StudentI.StudentI(98)
        p = ProgramI.ProgramI()
        s.setProgram(p)
        m = MentorI.MentorI("blah", s, s2)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())
