import unittest

from ImportModules import importModules

importModules(["MentorT", "ProgramT", "StudentT"], ["associations"])
from ImportModules import *


class MNToNTest(unittest.TestCase):
    # testbed/test/cruise/associations/MNToNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentT.StudentT(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorT.MentorT("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/MNToNTest.java: SetStudentsJustRightEnough
    def test_SetStudentsJustRightEnough(self):
        m = MentorT.MentorT("blah")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        s3 = StudentT.StudentT(97)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))

    # testbed/test/cruise/associations/MNToNTest.java: SetStudentsTooMany
    def test_SetStudentsTooMany(self):
        m = MentorT.MentorT("blah")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        s3 = StudentT.StudentT(97)
        s4 = StudentT.StudentT(96)
        self.assertIs(False, m.setStudents(s, s2, s3, s4))

    # testbed/test/cruise/associations/MNToNTest.java: AddStudents
    def test_AddStudents(self):
        m = MentorT.MentorT("blah")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        s3 = StudentT.StudentT(97)
        s4 = StudentT.StudentT(96)
        s5 = StudentT.StudentT(95)
        s6 = StudentT.StudentT(94)
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

    # testbed/test/cruise/associations/MNToNTest.java: CannotRemoveStudents
    def test_CannotRemoveStudents(self):
        m = MentorT.MentorT("blah")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        s3 = StudentT.StudentT(97)
        m.setStudents(s, s2, s3)
        self.assertIs(False, m.removeStudent(s3))

    # testbed/test/cruise/associations/MNToNTest.java: SetStudentsTooManyAndTooFew
    def test_SetStudentsTooManyAndTooFew(self):
        m = MentorT.MentorT("blah")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        s3 = StudentT.StudentT(97)
        s4 = StudentT.StudentT(96)
        s5 = StudentT.StudentT(95)
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

    # testbed/test/cruise/associations/MNToNTest.java: MentorAlreadyHasEnoughStudents
    def test_MentorAlreadyHasEnoughStudents(self):
        m = MentorT.MentorT("blah")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        s3 = StudentT.StudentT(97)
        m.setStudents(s, s2, s3)
        s6 = StudentT.StudentT(94)
        self.assertIs(False, m.addStudent(s6))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(0, s6.numberOfMentors())

    # testbed/test/cruise/associations/MNToNTest.java: setMentors
    def test_setMentors(self):
        m2 = MentorT.MentorT("blah2")
        m3 = MentorT.MentorT("blah2")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        self.assertIs(True, s.setMentors(m2, m3))
        self.assertIs(True, m2.addStudent(s2))
        self.assertEqual(2, m2.numberOfStudents())
        self.assertEqual(1, m3.numberOfStudents())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToNTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorT.MentorT("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentT.StudentT(99))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentT.StudentT(98))
        self.assertIs(False, m.isNumberOfStudentsValid())
        m.addStudent(StudentT.StudentT(97))
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/MNToNTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(3, MentorT.MentorT.minimumNumberOfStudents())
        self.assertEqual(3, MentorT.MentorT.maximumNumberOfStudents())

    # testbed/test/cruise/associations/MNToNTest.java: deleteMentorAndStudentHasEnough
    def test_deleteMentorAndStudentHasEnough(self):
        m = MentorT.MentorT("blah")
        m2 = MentorT.MentorT("blah2")
        m3 = MentorT.MentorT("blah2")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        s3 = StudentT.StudentT(97)
        m.setStudents(s, s2, s3)
        m2.setStudents(s, s2, s3)
        m3.setStudents(s, s2, s3)
        p = ProgramT.ProgramT()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToNTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorT.MentorT("blah")
        m2 = MentorT.MentorT("blah2")
        s = StudentT.StudentT(99)
        s2 = StudentT.StudentT(98)
        s3 = StudentT.StudentT(97)
        m.setStudents(s, s2, s3)
        m2.setStudents(s, s2, s3)
        p = ProgramT.ProgramT()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
