import unittest

from ImportModules import importModules

importModules(["MentorU", "ProgramU", "StudentU"], ["associations"])
from ImportModules import *


class MNToMStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/MNToMStarTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentU.StudentU(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToMStarTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorU.MentorU("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/MNToMStarTest.java: SetStudentsJustEnough
    def test_SetStudentsJustEnough(self):
        m = MentorU.MentorU("blah")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(97)
        self.assertIs(True, m.setStudents(s, s2, s3, s4))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))

    # testbed/test/cruise/associations/MNToMStarTest.java: SetStudentsNeverAtMax
    def test_SetStudentsNeverAtMax(self):
        m = MentorU.MentorU("blah")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(96)
        s5 = StudentU.StudentU(95)
        s6 = StudentU.StudentU(95)
        s7 = StudentU.StudentU(95)
        s8 = StudentU.StudentU(95)
        s9 = StudentU.StudentU(95)
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

    # testbed/test/cruise/associations/MNToMStarTest.java: AddStudents
    def test_AddStudents(self):
        m = MentorU.MentorU("blah")
        s = StudentU.StudentU(99)
        self.assertIs(True, m.addStudent(s))
        for i in range(2, 10):
            s2 = StudentU.StudentU(i)
            self.assertIs(True, m.addStudent(s2))
            self.assertEqual(i, m.numberOfStudents())
            self.assertIs(m, s2.getMentor(0))

    # testbed/test/cruise/associations/MNToMStarTest.java: RemoveMiddleStudentWhenNotValidMaintainsTheOrder
    def test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder(self):
        m = MentorU.MentorU("blah")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(97)
        self.assertIs(True, m.setStudents(s, s2, s3, s4))
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(s2, m.getStudent(1))

    # testbed/test/cruise/associations/MNToMStarTest.java: RemoveStudents
    def test_RemoveStudents(self):
        m = MentorU.MentorU("blah")
        m2 = MentorU.MentorU("blah2")
        m3 = MentorU.MentorU("blah3")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(96)
        s5 = StudentU.StudentU(95)
        s6 = StudentU.StudentU(94)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3, s4, s5)
        m3.setStudents(s, s2, s3, s4, s5)
        self.assertIs(False, m.removeStudent(s6))
        self.assertIs(True, m.removeStudent(s5))
        self.assertEqual(2, s5.numberOfMentors())
        self.assertEqual(4, m.numberOfStudents())

    # testbed/test/cruise/associations/MNToMStarTest.java: SetStudentsTooManyAndTooFew
    def test_SetStudentsTooManyAndTooFew(self):
        m = MentorU.MentorU("blah")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(96)
        s5 = StudentU.StudentU(95)
        s6 = StudentU.StudentU(94)
        self.assertIs(True, m.setStudents(s, s2, s3, s4))
        self.assertIs(False, m.setStudents(s4, s5, s3))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))
        self.assertEqual(0, s5.numberOfMentors())
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/MNToMStarTest.java: MentorNeverHasEnoughStudents
    def test_MentorNeverHasEnoughStudents(self):
        m = MentorU.MentorU("blah")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(96)
        s5 = StudentU.StudentU(95)
        m.setStudents(s, s2, s3, s4, s5)
        s6 = StudentU.StudentU(94)
        self.assertIs(True, m.addStudent(s6))
        self.assertEqual(6, m.numberOfStudents())
        self.assertEqual(1, s6.numberOfMentors())

    # testbed/test/cruise/associations/MNToMStarTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorU.MentorU("blah")
        m2 = MentorU.MentorU("blah2")
        m3 = MentorU.MentorU("blah2")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(96)
        s5 = StudentU.StudentU(95)
        m.setStudents(s, s2, s3, s4, s5)
        self.assertIs(True, s.setMentors(m2, m3))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(1, m3.numberOfStudents())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToMStarTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorU.MentorU("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentU.StudentU(99))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentU.StudentU(98))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentU.StudentU(97))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentU.StudentU(96))
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/MNToMStarTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(4, MentorU.MentorU.minimumNumberOfStudents())

    # testbed/test/cruise/associations/MNToMStarTest.java: deleteMentorAndStudentHasEnough
    def test_deleteMentorAndStudentHasEnough(self):
        m = MentorU.MentorU("blah")
        m2 = MentorU.MentorU("blah2")
        m3 = MentorU.MentorU("blah2")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(96)
        s5 = StudentU.StudentU(95)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3, s4, s5)
        m3.setStudents(s, s2, s3, s4, s5)
        p = ProgramU.ProgramU()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToMStarTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorU.MentorU("blah")
        m2 = MentorU.MentorU("blah2")
        s = StudentU.StudentU(99)
        s2 = StudentU.StudentU(98)
        s3 = StudentU.StudentU(97)
        s4 = StudentU.StudentU(96)
        s5 = StudentU.StudentU(95)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3)
        p = ProgramU.ProgramU()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
