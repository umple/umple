import unittest

from ImportModules import importModules

importModules(["MentorS", "ProgramS", "StudentS"], ["associations"])
from ImportModules import *


class MNToMNTest(unittest.TestCase):
    # testbed/test/cruise/associations/MNToMNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentS.StudentS(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToMNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorS.MentorS("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/MNToMNTest.java: SetStudentsJustEnough
    def test_SetStudentsJustEnough(self):
        m = MentorS.MentorS("blah")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))

    # testbed/test/cruise/associations/MNToMNTest.java: SetStudentsAtMax
    def test_SetStudentsAtMax(self):
        m = MentorS.MentorS("blah")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        s4 = StudentS.StudentS(96)
        s5 = StudentS.StudentS(95)
        self.assertIs(True, m.setStudents(s, s2, s3, s4, s5))
        self.assertEqual(5, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))
        self.assertIs(m, s5.getMentor(0))

    # testbed/test/cruise/associations/MNToMNTest.java: AddStudents_DuplicateNotOkay
    def test_AddStudents_DuplicateNotOkay(self):
        m = MentorS.MentorS("blah")
        s = StudentS.StudentS(99)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(False, m.addStudent(s))
        self.assertEqual(1, m.numberOfStudents())

    # testbed/test/cruise/associations/MNToMNTest.java: AddStudents
    def test_AddStudents(self):
        m = MentorS.MentorS("blah")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        s4 = StudentS.StudentS(96)
        s5 = StudentS.StudentS(95)
        s6 = StudentS.StudentS(94)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.addStudent(s2))
        self.assertIs(True, m.addStudent(s3))
        self.assertIs(True, m.addStudent(s4))
        self.assertIs(True, m.addStudent(s5))
        self.assertIs(False, m.addStudent(s6))
        self.assertEqual(5, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))
        self.assertIs(m, s5.getMentor(0))
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/MNToMNTest.java: RemoveMiddleStudentWhenNotValidMaintainsTheOrder
    def test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder(self):
        m = MentorS.MentorS("blah")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(s2, m.getStudent(1))

    # testbed/test/cruise/associations/MNToMNTest.java: RemoveStudents
    def test_RemoveStudents(self):
        m = MentorS.MentorS("blah")
        m2 = MentorS.MentorS("blah2")
        m3 = MentorS.MentorS("blah3")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        s4 = StudentS.StudentS(96)
        s5 = StudentS.StudentS(95)
        s6 = StudentS.StudentS(94)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3, s4, s5)
        m3.setStudents(s, s2, s3, s4, s5)
        self.assertIs(False, m.removeStudent(s6))
        self.assertIs(True, m.removeStudent(s5))
        self.assertEqual(2, s5.numberOfMentors())
        self.assertEqual(4, m.numberOfStudents())

    # testbed/test/cruise/associations/MNToMNTest.java: SetStudentsTooManyAndTooFew
    def test_SetStudentsTooManyAndTooFew(self):
        m = MentorS.MentorS("blah")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        s4 = StudentS.StudentS(96)
        s5 = StudentS.StudentS(95)
        s6 = StudentS.StudentS(94)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertIs(False, m.setStudents(s4, s5))
        self.assertIs(False, m.setStudents(s4, s5, s, s2, s3, s6))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/MNToMNTest.java: MentorAlreadyHasEnoughStudents
    def test_MentorAlreadyHasEnoughStudents(self):
        m = MentorS.MentorS("blah")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        s4 = StudentS.StudentS(96)
        s5 = StudentS.StudentS(95)
        s7 = StudentS.StudentS(94)
        self.assertIs(True, m.setStudents(s, s2, s3, s4, s5))
        s6 = StudentS.StudentS(94)
        self.assertIs(False, m.addStudent(s6))
        self.assertIs(False, s7.addMentor(m))
        self.assertEqual(5, m.numberOfStudents())
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/MNToMNTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorS.MentorS("blah")
        m2 = MentorS.MentorS("blah2")
        m3 = MentorS.MentorS("blah2")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        s4 = StudentS.StudentS(96)
        s5 = StudentS.StudentS(95)
        m.setStudents(s, s2, s3, s4, s5)
        self.assertIs(True, s.setMentors(m2, m3))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(1, m3.numberOfStudents())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToMNTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorS.MentorS("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentS.StudentS(99))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentS.StudentS(99))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentS.StudentS(99))
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/MNToMNTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(3, MentorS.MentorS.minimumNumberOfStudents())
        self.assertEqual(5, MentorS.MentorS.maximumNumberOfStudents())

    # testbed/test/cruise/associations/MNToMNTest.java: deleteMentorAndStudentHasEnough
    def test_deleteMentorAndStudentHasEnough(self):
        m = MentorS.MentorS("blah")
        m2 = MentorS.MentorS("blah2")
        m3 = MentorS.MentorS("blah2")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        s4 = StudentS.StudentS(96)
        s5 = StudentS.StudentS(95)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3, s4, s5)
        m3.setStudents(s, s2, s3, s4, s5)
        p = ProgramS.ProgramS()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToMNTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorS.MentorS("blah")
        m2 = MentorS.MentorS("blah2")
        s = StudentS.StudentS(99)
        s2 = StudentS.StudentS(98)
        s3 = StudentS.StudentS(97)
        s4 = StudentS.StudentS(96)
        s5 = StudentS.StudentS(95)
        m.setStudents(s, s2, s3, s4, s5)
        m2.setStudents(s, s2, s3)
        p = ProgramS.ProgramS()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
