import unittest

from ImportModules import importModules

importModules(["MentorX", "ProgramX", "StudentX"], ["associations"])
from ImportModules import *


class MStarToMStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/MStarToMStarTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentX.StudentX(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/MStarToMStarTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorX.MentorX("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/MStarToMStarTest.java: SetStudentsJustEnough
    def test_SetStudentsJustEnough(self):
        m = MentorX.MentorX("blah")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(97)
        self.assertIs(True, m.setStudents(s, s2, s3, s4))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))

    # testbed/test/cruise/associations/MStarToMStarTest.java: SetStudentsNeverAtMax
    def test_SetStudentsNeverAtMax(self):
        m = MentorX.MentorX("blah")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(96)
        s5 = StudentX.StudentX(95)
        s6 = StudentX.StudentX(95)
        s7 = StudentX.StudentX(95)
        s8 = StudentX.StudentX(95)
        s9 = StudentX.StudentX(95)
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

    # testbed/test/cruise/associations/MStarToMStarTest.java: AddStudents
    def test_AddStudents(self):
        m = MentorX.MentorX("blah")
        s = StudentX.StudentX(99)
        self.assertIs(True, m.addStudent(s))
        for i in range(2, 10):
            s2 = StudentX.StudentX(i)
            self.assertIs(True, m.addStudent(s2))
            self.assertEqual(i, m.numberOfStudents())
            self.assertIs(m, s2.getMentor(0))

    # testbed/test/cruise/associations/MStarToMStarTest.java: RemoveMiddleStudentWhenNotValidMaintainsTheOrder
    def test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder(self):
        m = MentorX.MentorX("blah")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(97)
        self.assertIs(True, m.setStudents(s, s2, s3, s4))
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(s2, m.getStudent(1))

    # testbed/test/cruise/associations/MStarToMStarTest.java: RemoveStudents
    def test_RemoveStudents(self):
        m = MentorX.MentorX("blah")
        m2 = MentorX.MentorX("blah2")
        m3 = MentorX.MentorX("blah3")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(96)
        s5 = StudentX.StudentX(95)
        s6 = StudentX.StudentX(94)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3, s4, s5)
        m3.setStudents(s, s2, s3, s4, s5)
        self.assertIs(False, m.removeStudent(s6))
        self.assertIs(True, m.removeStudent(s5))
        self.assertEqual(2, s5.numberOfMentors())
        self.assertEqual(4, m.numberOfStudents())

    # testbed/test/cruise/associations/MStarToMStarTest.java: SetStudentsTooFew
    def test_SetStudentsTooFew(self):
        m = MentorX.MentorX("blah")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(96)
        s5 = StudentX.StudentX(95)
        s6 = StudentX.StudentX(94)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertIs(False, m.setStudents(s4, s5))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/MStarToMStarTest.java: MentorNeverHasEnoughStudents
    def test_MentorNeverHasEnoughStudents(self):
        m = MentorX.MentorX("blah")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(96)
        s5 = StudentX.StudentX(95)
        m.setStudents(s, s2, s3, s4, s5)
        s6 = StudentX.StudentX(94)
        self.assertIs(True, m.addStudent(s6))
        self.assertEqual(6, m.numberOfStudents())
        self.assertEqual(1, s6.numberOfMentors())

    # testbed/test/cruise/associations/MStarToMStarTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorX.MentorX("blah")
        m2 = MentorX.MentorX("blah2")
        m3 = MentorX.MentorX("blah2")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(96)
        s5 = StudentX.StudentX(95)
        m.setStudents(s, s2, s3, s4, s5)
        self.assertIs(True, s.setMentors(m2, m3))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(1, m3.numberOfStudents())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/MStarToMStarTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorX.MentorX("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentX.StudentX(99))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentX.StudentX(98))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentX.StudentX(97))
        self.assertIs(True, m.isNumberOfStudentsValid())
        m.addStudent(StudentX.StudentX(96))
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/MStarToMStarTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(3, MentorX.MentorX.minimumNumberOfStudents())

    # testbed/test/cruise/associations/MStarToMStarTest.java: deleteMentorAndStudentHasEnough
    def test_deleteMentorAndStudentHasEnough(self):
        m = MentorX.MentorX("blah")
        m2 = MentorX.MentorX("blah2")
        m3 = MentorX.MentorX("blah2")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(96)
        s5 = StudentX.StudentX(95)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3, s4, s5)
        m3.setStudents(s, s2, s3, s4, s5)
        p = ProgramX.ProgramX()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/MStarToMStarTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorX.MentorX("blah")
        m2 = MentorX.MentorX("blah2")
        s = StudentX.StudentX(99)
        s2 = StudentX.StudentX(98)
        s3 = StudentX.StudentX(97)
        s4 = StudentX.StudentX(96)
        s5 = StudentX.StudentX(95)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3)
        p = ProgramX.ProgramX()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
