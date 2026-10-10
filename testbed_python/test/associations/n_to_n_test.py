import unittest

from ImportModules import importModules

importModules(["MentorV", "ProgramV", "StudentV"], ["associations"])
from ImportModules import *


class NToNTest(unittest.TestCase):
    # testbed/test/cruise/associations/NToNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentV.StudentV(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/NToNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorV.MentorV("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/NToNTest.java: SetStudentsJustRightEnough
    def test_SetStudentsJustRightEnough(self):
        m = MentorV.MentorV("blah")
        s = StudentV.StudentV(99)
        s2 = StudentV.StudentV(98)
        s3 = StudentV.StudentV(97)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))

    # testbed/test/cruise/associations/NToNTest.java: SetStudentsTooMany
    def test_SetStudentsTooMany(self):
        m = MentorV.MentorV("blah")
        s = StudentV.StudentV(99)
        s2 = StudentV.StudentV(98)
        s3 = StudentV.StudentV(97)
        s4 = StudentV.StudentV(96)
        self.assertIs(False, m.setStudents(s, s2, s3, s4))

    # testbed/test/cruise/associations/NToNTest.java: AddStudents
    def test_AddStudents(self):
        m = MentorV.MentorV("blah")
        s = StudentV.StudentV(99)
        s2 = StudentV.StudentV(98)
        s3 = StudentV.StudentV(97)
        s4 = StudentV.StudentV(96)
        s5 = StudentV.StudentV(95)
        s6 = StudentV.StudentV(94)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.addStudent(s2))
        self.assertIs(True, m.addStudent(s3))
        self.assertIs(False, m.addStudent(s4))
        self.assertIs(False, m.addStudent(s5))
        self.assertIs(False, m.addStudent(s6))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/NToNTest.java: CannotRemoveStudents
    def test_CannotRemoveStudents(self):
        m = MentorV.MentorV("blah")
        s = StudentV.StudentV(99)
        s2 = StudentV.StudentV(98)
        s3 = StudentV.StudentV(97)
        m.setStudents(s, s2, s3)
        self.assertIs(False, m.removeStudent(s3))

    # testbed/test/cruise/associations/NToNTest.java: SetStudentsTooManyAndTooFew
    def test_SetStudentsTooManyAndTooFew(self):
        m = MentorV.MentorV("blah")
        s = StudentV.StudentV(99)
        s2 = StudentV.StudentV(98)
        s3 = StudentV.StudentV(97)
        s4 = StudentV.StudentV(96)
        s5 = StudentV.StudentV(95)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertIs(False, m.setStudents(s4, s5))
        self.assertIs(False, m.setStudents(s4, s5, s, s2))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())

    # testbed/test/cruise/associations/NToNTest.java: MentorAlreadyHasEnoughStudents
    def test_MentorAlreadyHasEnoughStudents(self):
        m = MentorV.MentorV("blah")
        s = StudentV.StudentV(99)
        s2 = StudentV.StudentV(98)
        s3 = StudentV.StudentV(97)
        m.setStudents(s, s2, s3)
        s6 = StudentV.StudentV(94)
        self.assertIs(False, m.addStudent(s6))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/NToNTest.java: setMentors
    def test_setMentors(self):
        m = MentorV.MentorV("blah2")
        m2 = MentorV.MentorV("blah2")
        m3 = MentorV.MentorV("blah2")
        m4 = MentorV.MentorV("blah2")
        s = StudentV.StudentV(99)
        s2 = StudentV.StudentV(98)
        self.assertIs(True, s.setMentors(m2, m3, m, m4))
        self.assertIs(True, m2.addStudent(s2))
        self.assertEqual(2, m2.numberOfStudents())
        self.assertEqual(1, m3.numberOfStudents())
        self.assertEqual(4, s.numberOfMentors())

    # testbed/test/cruise/associations/NToNTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorV.MentorV("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentV.StudentV(99))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentV.StudentV(98))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentV.StudentV(97))
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/NToNTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(3, MentorV.MentorV.minimumNumberOfStudents())
        self.assertEqual(3, MentorV.MentorV.maximumNumberOfStudents())

    # testbed/test/cruise/associations/NToNTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorV.MentorV("blah")
        m2 = MentorV.MentorV("blah2")
        s = StudentV.StudentV(99)
        s2 = StudentV.StudentV(98)
        s3 = StudentV.StudentV(97)
        m.setStudents(s, s2, s3)
        m2.setStudents(s, s2, s3)
        p = ProgramV.ProgramV()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
