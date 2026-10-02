import unittest

from ImportModules import importModules

importModules(["MentorW", "ProgramW", "StudentW"], ["associations"])
from ImportModules import *


class NToMStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/NToMStarTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentW.StudentW(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/NToMStarTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorW.MentorW("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/NToMStarTest.java: SetStudentsJustEnough
    def test_SetStudentsJustEnough(self):
        m = MentorW.MentorW("blah")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(97)
        self.assertIs(True, m.setStudents(s, s2, s3, s4))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))

    # testbed/test/cruise/associations/NToMStarTest.java: SetStudentsNeverAtMax
    def test_SetStudentsNeverAtMax(self):
        m = MentorW.MentorW("blah")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(96)
        s5 = StudentW.StudentW(95)
        s6 = StudentW.StudentW(95)
        s7 = StudentW.StudentW(95)
        s8 = StudentW.StudentW(95)
        s9 = StudentW.StudentW(95)
        self.assertIs(True, m.setStudents(s, s2, s3, s4, s5, s6, s7, s8, s9))
        self.assertEqual(9, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))
        self.assertIs(m, s5.getMentor(0))
        self.assertIs(m, s6.getMentor(0))
        self.assertIs(m, s7.getMentor(0))
        self.assertIs(m, s8.getMentor(0))
        self.assertIs(m, s9.getMentor(0))

    # testbed/test/cruise/associations/NToMStarTest.java: AddStudents
    def test_AddStudents(self):
        m = MentorW.MentorW("blah")
        s = StudentW.StudentW(99)
        self.assertIs(True, m.addStudent(s))
        for i in range(2, 10):
            s2 = StudentW.StudentW(i)
            self.assertIs(True, m.addStudent(s2))
            self.assertEqual(i, m.numberOfStudents())
            self.assertIs(m, s2.getMentor(0))

    # testbed/test/cruise/associations/NToMStarTest.java: RemoveMiddleStudentWhenNotValidMaintainsTheOrder
    def test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder(self):
        m = MentorW.MentorW("blah")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(97)
        self.assertIs(True, m.setStudents(s, s2, s3, s4))
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(s2, m.getStudent(1))

    # testbed/test/cruise/associations/NToMStarTest.java: CannotRemoveStudentsBecauseNeedsFixedNumberOfMentors
    def test_CannotRemoveStudentsBecauseNeedsFixedNumberOfMentors(self):
        m = MentorW.MentorW("blah")
        m2 = MentorW.MentorW("blah2")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(96)
        s5 = StudentW.StudentW(95)
        s6 = StudentW.StudentW(94)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3, s4, s5)
        self.assertIs(False, m.removeStudent(s6))
        self.assertIs(False, m.removeStudent(s5))
        self.assertEqual(2, s5.numberOfMentors())
        self.assertEqual(5, m.numberOfStudents())

    # testbed/test/cruise/associations/NToMStarTest.java: SetStudentsTooFew
    def test_SetStudentsTooFew(self):
        m = MentorW.MentorW("blah")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(96)
        s5 = StudentW.StudentW(95)
        s6 = StudentW.StudentW(94)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertIs(False, m.setStudents(s4, s5))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/NToMStarTest.java: MentorNeverHasEnoughStudents
    def test_MentorNeverHasEnoughStudents(self):
        m = MentorW.MentorW("blah")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(96)
        s5 = StudentW.StudentW(95)
        m.setStudents(s, s2, s3, s4, s5)
        s6 = StudentW.StudentW(94)
        self.assertIs(True, m.addStudent(s6))
        self.assertEqual(6, m.numberOfStudents())
        self.assertEqual(1, s6.numberOfMentors())

    # testbed/test/cruise/associations/NToMStarTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorW.MentorW("blah")
        m2 = MentorW.MentorW("blah2")
        m3 = MentorW.MentorW("blah2")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(96)
        s5 = StudentW.StudentW(95)
        m.setStudents(s, s2, s3, s4, s5)
        self.assertIs(True, s.setMentors(m2, m3))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(1, m3.numberOfStudents())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/NToMStarTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorW.MentorW("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentW.StudentW(99))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentW.StudentW(98))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentW.StudentW(97))
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/NToMStarTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(3, MentorW.MentorW.minimumNumberOfStudents())

    # testbed/test/cruise/associations/NToMStarTest.java: deleteMentorDeletesStudents
    def test_deleteMentorDeletesStudents(self):
        m = MentorW.MentorW("blah")
        m2 = MentorW.MentorW("blah2")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(96)
        s5 = StudentW.StudentW(95)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3, s4, s5)
        p = ProgramW.ProgramW()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNone(s.getProgram())
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/NToMStarTest.java: deleteMentorDeletesStudentThatThenDeletesMentor
    def test_deleteMentorDeletesStudentThatThenDeletesMentor(self):
        m = MentorW.MentorW("blah")
        m2 = MentorW.MentorW("blah2")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(96)
        m.setStudents(s, s2, s3, s4)
        m2.setStudents(s, s2, s3)
        p = ProgramW.ProgramW()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertIsNone(s.getProgram())
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/NToMStarTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorW.MentorW("blah")
        m2 = MentorW.MentorW("blah2")
        s = StudentW.StudentW(99)
        s2 = StudentW.StudentW(98)
        s3 = StudentW.StudentW(97)
        s4 = StudentW.StudentW(96)
        s5 = StudentW.StudentW(95)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3)
        p = ProgramW.ProgramW()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
