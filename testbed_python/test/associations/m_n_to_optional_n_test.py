import unittest

from ImportModules import importModules

importModules(["MentorAB", "ProgramAB", "StudentAB"], ["associations"])
from ImportModules import *


class MNToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/MNToOptionalNTest.java: CreateStudentWihtoutMentor
    def test_CreateStudentWihtoutMentor(self):
        s = StudentAB.StudentAB(99)
        self.assertIs(False, s.isNumberOfMentorsValid())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorAB.MentorAB("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: AddStudentsAndMentorsOkay
    def test_AddStudentsAndMentorsOkay(self):
        m = MentorAB.MentorAB("blah")
        m2 = MentorAB.MentorAB("blah2")
        m3 = MentorAB.MentorAB("blah3")
        m4 = MentorAB.MentorAB("blah4")
        m5 = MentorAB.MentorAB("blah5")
        m6 = MentorAB.MentorAB("blah6")
        s = StudentAB.StudentAB(99)
        s2 = StudentAB.StudentAB(98)
        s3 = StudentAB.StudentAB(97)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.addStudent(s2))
        self.assertIs(False, m.addStudent(s3))
        self.assertIs(True, s.addMentor(m2))
        self.assertIs(True, s.addMentor(m3))
        self.assertIs(True, s.addMentor(m4))
        self.assertIs(True, s.addMentor(m5))
        self.assertIs(False, s.addMentor(m6))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m4, s.getMentor(3))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(5, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: RemoveMiddleMentorWhenNotValidMaintainsTheOrder
    def test_RemoveMiddleMentorWhenNotValidMaintainsTheOrder(self):
        s = StudentAB.StudentAB(99)
        m = MentorAB.MentorAB("blah")
        m2 = MentorAB.MentorAB("blah2")
        m3 = MentorAB.MentorAB("blah3")
        s.addMentor(m)
        s.addMentor(m2)
        s.addMentor(m3)
        self.assertIs(False, s.removeMentor(m2))
        self.assertEqual(3, s.numberOfMentors())
        self.assertIs(m2, s.getMentor(1))

    # testbed/test/cruise/associations/MNToOptionalNTest.java: RemoveStudents
    def test_RemoveStudents(self):
        m = MentorAB.MentorAB("blah")
        m2 = MentorAB.MentorAB("blah2")
        m3 = MentorAB.MentorAB("blah3")
        m4 = MentorAB.MentorAB("blah3")
        s = StudentAB.StudentAB(99)
        s2 = StudentAB.StudentAB(98)
        s3 = StudentAB.StudentAB(97)
        m.addStudent(s)
        m.addStudent(s2)
        m2.addStudent(s)
        m2.addStudent(s2)
        m3.addStudent(s)
        m3.addStudent(s2)
        m4.addStudent(s)
        m4.addStudent(s2)
        self.assertIs(False, m.removeStudent(s3))
        self.assertIs(True, m.removeStudent(s2))
        self.assertEqual(3, s2.numberOfMentors())
        self.assertEqual(1, m.numberOfStudents())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: SetStudentsTooMany
    def test_SetStudentsTooMany(self):
        m = MentorAB.MentorAB("blah")
        s = StudentAB.StudentAB(99)
        s2 = StudentAB.StudentAB(98)
        s3 = StudentAB.StudentAB(97)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.addStudent(s2))
        self.assertIs(False, m.addStudent(s3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: MentorAlreadyHasEnoughStudents
    def test_MentorAlreadyHasEnoughStudents(self):
        m = MentorAB.MentorAB("blah")
        s = StudentAB.StudentAB(99)
        s2 = StudentAB.StudentAB(98)
        s3 = StudentAB.StudentAB(97)
        m.addStudent(s)
        m.addStudent(s2)
        self.assertIs(False, m.addStudent(s3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(0, s3.numberOfMentors())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(2, MentorAB.MentorAB.maximumNumberOfStudents())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: getBoundsForMentor
    def test_getBoundsForMentor(self):
        self.assertEqual(3, StudentAB.StudentAB.minimumNumberOfMentors())
        self.assertEqual(5, StudentAB.StudentAB.maximumNumberOfMentors())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: deleteMentorAndStudentHasEnough
    def test_deleteMentorAndStudentHasEnough(self):
        m = MentorAB.MentorAB("blah")
        m2 = MentorAB.MentorAB("blah2")
        m3 = MentorAB.MentorAB("blah2")
        m4 = MentorAB.MentorAB("blah2")
        s = StudentAB.StudentAB(99)
        s2 = StudentAB.StudentAB(98)
        m.addStudent(s)
        m.addStudent(s2)
        m2.addStudent(s)
        m2.addStudent(s2)
        m3.addStudent(s)
        m3.addStudent(s2)
        m4.addStudent(s)
        m4.addStudent(s2)
        p = ProgramAB.ProgramAB()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())
        self.assertEqual(3, s.numberOfMentors())

    # testbed/test/cruise/associations/MNToOptionalNTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorAB.MentorAB("blah")
        m2 = MentorAB.MentorAB("blah2")
        m3 = MentorAB.MentorAB("blah3")
        s = StudentAB.StudentAB(99)
        s2 = StudentAB.StudentAB(98)
        m.addStudent(s)
        m.addStudent(s2)
        m2.addStudent(s)
        m2.addStudent(s2)
        m3.addStudent(s)
        m3.addStudent(s2)
        p = ProgramAB.ProgramAB()
        s.setProgram(p)
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertEqual(3, s.numberOfMentors())
        self.assertEqual(3, s2.numberOfMentors())
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, m3.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
        self.assertEqual(0, s2.numberOfMentors())
