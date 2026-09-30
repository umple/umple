import unittest

from ImportModules import importModules

importModules(["MentorAC", "ProgramAC", "StudentAC"], ["associations"])
from ImportModules import *


class NToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/NToOptionalNTest.java: CreateStudentWithoutMentors
    def test_CreateStudentWithoutMentors(self):
        # Like the Java test, this passes when nothing raises
        StudentAC.StudentAC(99)

    # testbed/test/cruise/associations/NToOptionalNTest.java: CreateStudentJustEnoughMentors
    def test_CreateStudentJustEnoughMentors(self):
        m = MentorAC.MentorAC("blah")
        m2 = MentorAC.MentorAC("blah2")
        m3 = MentorAC.MentorAC("blah2")
        s = StudentAC.StudentAC(99)
        self.assertIs(True, s.addMentor(m))
        self.assertIs(True, s.addMentor(m2))
        self.assertIs(False, s.addMentor(m3))
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/NToOptionalNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorAC.MentorAC("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/NToOptionalNTest.java: SetMentorsOutsideRange
    def test_SetMentorsOutsideRange(self):
        s = StudentAC.StudentAC(99)
        m = MentorAC.MentorAC("blah")
        m2 = MentorAC.MentorAC("blah2")
        m3 = MentorAC.MentorAC("blah3")
        self.assertIs(True, s.addMentor(m))
        self.assertIs(True, s.addMentor(m2))
        self.assertIs(False, s.addMentor(m3))
        self.assertEqual(2, s.numberOfMentors())
        self.assertIs(s, m.getStudent(0))
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(0, m3.numberOfStudents())

    # testbed/test/cruise/associations/NToOptionalNTest.java: AddStudents
    def test_AddStudents(self):
        m = MentorAC.MentorAC("blah")
        s = StudentAC.StudentAC(99)
        s2 = StudentAC.StudentAC(98)
        s3 = StudentAC.StudentAC(97)
        s4 = StudentAC.StudentAC(96)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.addStudent(s2))
        self.assertIs(True, m.addStudent(s3))
        self.assertIs(False, m.addStudent(s4))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(1, s3.numberOfMentors())

    # testbed/test/cruise/associations/NToOptionalNTest.java: RemoveMiddleMentorWhenNotValidMaintainsTheOrder
    def test_RemoveMiddleMentorWhenNotValidMaintainsTheOrder(self):
        s = StudentAC.StudentAC(99)
        m = MentorAC.MentorAC("blah")
        m2 = MentorAC.MentorAC("blah2")
        s.addMentor(m)
        s.addMentor(m2)
        self.assertIs(False, s.removeMentor(m2))
        self.assertEqual(2, s.numberOfMentors())
        self.assertIs(m2, s.getMentor(1))

    # testbed/test/cruise/associations/NToOptionalNTest.java: CannotRemoveStudents
    def test_CannotRemoveStudents(self):
        m = MentorAC.MentorAC("blah")
        m2 = MentorAC.MentorAC("blah2")
        m3 = MentorAC.MentorAC("blah3")
        s = StudentAC.StudentAC(99)
        s2 = StudentAC.StudentAC(98)
        s3 = StudentAC.StudentAC(97)
        m.addStudent(s)
        m.addStudent(s2)
        m2.addStudent(s)
        m2.addStudent(s2)
        self.assertIs(False, m3.addStudent(s))
        self.assertIs(False, m3.addStudent(s2))
        self.assertIs(False, m.removeStudent(s3))
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(2, s2.numberOfMentors())
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/NToOptionalNTest.java: SetStudentsTooMany
    def test_SetStudentsTooMany(self):
        m = MentorAC.MentorAC("blah")
        s = StudentAC.StudentAC(99)
        s2 = StudentAC.StudentAC(98)
        s3 = StudentAC.StudentAC(97)
        s4 = StudentAC.StudentAC(96)
        m.addStudent(s)
        m.addStudent(s2)
        self.assertIs(True, m.addStudent(s3))
        self.assertIs(False, m.addStudent(s4))

    # testbed/test/cruise/associations/NToOptionalNTest.java: MentorAlreadyHasEnoughStudents
    def test_MentorAlreadyHasEnoughStudents(self):
        m = MentorAC.MentorAC("blah")
        s = StudentAC.StudentAC(99)
        s2 = StudentAC.StudentAC(98)
        s3 = StudentAC.StudentAC(97)
        s4 = StudentAC.StudentAC(96)
        m.addStudent(s)
        m.addStudent(s2)
        m.addStudent(s3)
        self.assertIs(False, m.addStudent(s4))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(1, s3.numberOfMentors())

    # testbed/test/cruise/associations/NToOptionalNTest.java: addMentor
    def test_addMentor(self):
        m = MentorAC.MentorAC("blah")
        m2 = MentorAC.MentorAC("blah2")
        m3 = MentorAC.MentorAC("blah2")
        s = StudentAC.StudentAC(99)
        s2 = StudentAC.StudentAC(98)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.addStudent(s2))
        self.assertIs(True, s.addMentor(m2))
        self.assertIs(False, s.addMentor(m3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(0, m3.numberOfStudents())
        self.assertEqual(2, s.numberOfMentors())

    # testbed/test/cruise/associations/NToOptionalNTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(3, MentorAC.MentorAC.maximumNumberOfStudents())

    # testbed/test/cruise/associations/NToOptionalNTest.java: getBoundsForMentor
    def test_getBoundsForMentor(self):
        self.assertEqual(2, StudentAC.StudentAC.minimumNumberOfMentors())
        self.assertEqual(2, StudentAC.StudentAC.maximumNumberOfMentors())

    # testbed/test/cruise/associations/NToOptionalNTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorAC.MentorAC("blah")
        m2 = MentorAC.MentorAC("blah2")
        m3 = MentorAC.MentorAC("blah2")
        s = StudentAC.StudentAC(99)
        s2 = StudentAC.StudentAC(98)
        s.addMentor(m)
        s.addMentor(m2)
        s.addMentor(m3)
        s2.addMentor(m)
        s2.addMentor(m2)
        s2.addMentor(m3)
        m3.addStudent(s)
        m3.addStudent(s2)
        p = ProgramAC.ProgramAC()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
