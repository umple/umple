import unittest

from ImportModules import importModules

importModules(["MentorAD", "ProgramAD", "StudentAD"], ["associations"])
from ImportModules import *


class MStarToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/MStarToOptionalNTest.java: CreateStudentWihtoutMentor
    def test_CreateStudentWihtoutMentor(self):
        s = StudentAD.StudentAD(99)
        self.assertIs(False, s.isNumberOfMentorsValid())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorAD.MentorAD("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: AddStudentsAndMentorsOkay
    def test_AddStudentsAndMentorsOkay(self):
        m = MentorAD.MentorAD("blah")
        m2 = MentorAD.MentorAD("blah2")
        m3 = MentorAD.MentorAD("blah3")
        m4 = MentorAD.MentorAD("blah4")
        m5 = MentorAD.MentorAD("blah5")
        m6 = MentorAD.MentorAD("blah6")
        s = StudentAD.StudentAD(99)
        s2 = StudentAD.StudentAD(98)
        s3 = StudentAD.StudentAD(97)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.addStudent(s2))
        self.assertIs(False, m.addStudent(s3))
        self.assertIs(True, s.addMentor(m2))
        self.assertIs(True, s.addMentor(m3))
        self.assertIs(True, s.addMentor(m4))
        self.assertIs(True, s.addMentor(m5))
        self.assertIs(True, s.addMentor(m6))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m4, s.getMentor(3))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(6, s.numberOfMentors())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: isNumberOfValid
    def test_isNumberOfValid(self):
        s = StudentAD.StudentAD(99)
        self.assertIs(False, s.isNumberOfMentorsValid())
        s.addMentor(MentorAD.MentorAD("blah"))
        self.assertIs(False, s.isNumberOfMentorsValid())
        s.addMentor(MentorAD.MentorAD("blah2"))
        self.assertIs(False, s.isNumberOfMentorsValid())
        s.addMentor(MentorAD.MentorAD("blah3"))
        self.assertIs(True, s.isNumberOfMentorsValid())
        s.addMentor(MentorAD.MentorAD("blah4"))
        self.assertIs(True, s.isNumberOfMentorsValid())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: RemoveMiddleMentorWhenNotValidMaintainsTheOrder
    def test_RemoveMiddleMentorWhenNotValidMaintainsTheOrder(self):
        s = StudentAD.StudentAD(99)
        m = MentorAD.MentorAD("blah")
        m2 = MentorAD.MentorAD("blah2")
        m3 = MentorAD.MentorAD("blah3")
        s.addMentor(m)
        s.addMentor(m2)
        s.addMentor(m3)
        self.assertIs(False, s.removeMentor(m2))
        self.assertEqual(3, s.numberOfMentors())
        self.assertIs(m2, s.getMentor(1))

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: RemoveStudents
    def test_RemoveStudents(self):
        m = MentorAD.MentorAD("blah")
        m2 = MentorAD.MentorAD("blah2")
        m3 = MentorAD.MentorAD("blah3")
        m4 = MentorAD.MentorAD("blah3")
        s = StudentAD.StudentAD(99)
        s2 = StudentAD.StudentAD(98)
        s3 = StudentAD.StudentAD(97)
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

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: SetStudentsTooMany
    def test_SetStudentsTooMany(self):
        m = MentorAD.MentorAD("blah")
        s = StudentAD.StudentAD(99)
        s2 = StudentAD.StudentAD(98)
        s3 = StudentAD.StudentAD(97)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.addStudent(s2))
        self.assertIs(False, m.addStudent(s3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: MentorAlreadyHasEnoughStudents
    def test_MentorAlreadyHasEnoughStudents(self):
        m = MentorAD.MentorAD("blah")
        s = StudentAD.StudentAD(99)
        s2 = StudentAD.StudentAD(98)
        s3 = StudentAD.StudentAD(97)
        m.addStudent(s)
        m.addStudent(s2)
        self.assertIs(False, m.addStudent(s3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(0, s3.numberOfMentors())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(2, MentorAD.MentorAD.maximumNumberOfStudents())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: getBoundsForMentor
    def test_getBoundsForMentor(self):
        self.assertEqual(3, StudentAD.StudentAD.minimumNumberOfMentors())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: deleteMentorAndStudentHasEnough
    def test_deleteMentorAndStudentHasEnough(self):
        m = MentorAD.MentorAD("blah")
        m2 = MentorAD.MentorAD("blah2")
        m3 = MentorAD.MentorAD("blah2")
        m4 = MentorAD.MentorAD("blah2")
        s = StudentAD.StudentAD(99)
        s2 = StudentAD.StudentAD(98)
        m.addStudent(s)
        m.addStudent(s2)
        m2.addStudent(s)
        m2.addStudent(s2)
        m3.addStudent(s)
        m3.addStudent(s2)
        m4.addStudent(s)
        m4.addStudent(s2)
        p = ProgramAD.ProgramAD()
        s.setProgram(p)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())
        self.assertEqual(3, s.numberOfMentors())

    # testbed/test/cruise/associations/MStarToOptionalNTest.java: deleteMentorAndStudentNowHasTooFewMentors
    def test_deleteMentorAndStudentNowHasTooFewMentors(self):
        m = MentorAD.MentorAD("blah")
        m2 = MentorAD.MentorAD("blah2")
        m3 = MentorAD.MentorAD("blah2")
        s = StudentAD.StudentAD(99)
        s2 = StudentAD.StudentAD(98)
        m.addStudent(s)
        m.addStudent(s2)
        m2.addStudent(s)
        m2.addStudent(s2)
        m3.addStudent(s)
        m3.addStudent(s2)
        p = ProgramAD.ProgramAD()
        s.setProgram(p)
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertEqual(3, s.numberOfMentors())
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
