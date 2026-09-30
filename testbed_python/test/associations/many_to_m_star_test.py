import unittest

from ImportModules import importModules

importModules(["MentorR", "ProgramR", "StudentR"], ["associations"])
from ImportModules import *


class ManyToMStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/ManyToMStarTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentR.StudentR(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMStarTest.java: ConstructorWithTooFew
    def test_ConstructorWithTooFew(self):
        s = StudentR.StudentR(99)
        with self.assertRaises(RuntimeError):
            MentorR.MentorR("blah", s)

    # testbed/test/cruise/associations/ManyToMStarTest.java: ConstructorCannotHaveTooMany
    def test_ConstructorCannotHaveTooMany(self):
        # Like the Java test, this passes when nothing raises
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        s5 = StudentR.StudentR(95)
        s6 = StudentR.StudentR(94)
        s7 = StudentR.StudentR(93)
        s8 = StudentR.StudentR(92)
        MentorR.MentorR("blah", s, s2, s3, s4, s5, s6, s7, s8)

    # testbed/test/cruise/associations/ManyToMStarTest.java: constructorJustBigEnough
    def test_constructorJustBigEnough(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        m = MentorR.MentorR("blah", s, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))

    # testbed/test/cruise/associations/ManyToMStarTest.java: constructorMoreThanBigEnough
    def test_constructorMoreThanBigEnough(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        m = MentorR.MentorR("blah", s, s2, s3, s4)
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))

    # testbed/test/cruise/associations/ManyToMStarTest.java: constructorWatchOutForDuplicateEntries
    def test_constructorWatchOutForDuplicateEntries(self):
        s = StudentR.StudentR(99)
        with self.assertRaises(RuntimeError):
            MentorR.MentorR("blah", s, s)

    # testbed/test/cruise/associations/ManyToMStarTest.java: constructorExistingMentorsOkay
    def test_constructorExistingMentorsOkay(self):
        s1 = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        m = MentorR.MentorR("blah", s1, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s1.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(0, s4.numberOfMentors())
        m2 = MentorR.MentorR("blah2", s1, s2, s4)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s1.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(3, m2.numberOfStudents())
        self.assertIs(m2, s1.getMentor(1))
        self.assertIs(m2, s2.getMentor(1))
        self.assertIs(m2, s4.getMentor(0))

    # testbed/test/cruise/associations/ManyToMStarTest.java: setStudents_tooFew
    def test_setStudents_tooFew(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        s5 = StudentR.StudentR(95)
        m = MentorR.MentorR("blah", s, s2, s3)
        self.assertIs(False, m.setStudents(s5, s4))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMStarTest.java: setStudents_doNotAllowDuplicates
    def test_setStudents_doNotAllowDuplicates(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        m = MentorR.MentorR("blah", s, s2, s3)
        self.assertIs(False, m.setStudents(s2, s2, s3))

    # testbed/test/cruise/associations/ManyToMStarTest.java: setStudents_aboveMinimum
    def test_setStudents_aboveMinimum(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        m = MentorR.MentorR("blah", s, s2, s3)
        self.assertIs(True, m.setStudents(s2, s3, s4))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))

    # testbed/test/cruise/associations/ManyToMStarTest.java: addMentorNeverTooMany
    def test_addMentorNeverTooMany(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        s5 = StudentR.StudentR(95)
        m = MentorR.MentorR("blah", s, s2, s3, s4)
        self.assertIs(True, s5.addMentor(m))
        self.assertEqual(5, m.numberOfStudents())
        self.assertEqual(1, s5.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMStarTest.java: addStudent
    def test_addStudent(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        s5 = StudentR.StudentR(95)
        m = MentorR.MentorR("blah", s, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(True, m.addStudent(s4))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))
        self.assertIs(True, m.addStudent(s5))
        self.assertEqual(5, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToMStarTest.java: addStudentHasExistingMentor
    def test_addStudentHasExistingMentor(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        s5 = StudentR.StudentR(95)
        s6 = StudentR.StudentR(94)
        m = MentorR.MentorR("blah", s, s2, s3)
        m2 = MentorR.MentorR("blah2", s4, s5, s6)
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m2, s4.getMentor(0))
        self.assertIs(m2, s5.getMentor(0))
        self.assertIs(m2, s6.getMentor(0))
        self.assertIs(True, m.addStudent(s4))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(3, m2.numberOfStudents())
        self.assertEqual(2, s4.numberOfMentors())
        self.assertIs(m2, s4.getMentor(0))
        self.assertIs(m, s4.getMentor(1))
        self.assertIs(True, m.addStudent(s5))

    # testbed/test/cruise/associations/ManyToMStarTest.java: removeStudent
    def test_removeStudent(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        s5 = StudentR.StudentR(95)
        m = MentorR.MentorR("blah", s, s2, s3, s5)
        self.assertIs(False, m.removeStudent(s4))
        self.assertIs(True, m.removeStudent(s3))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())
        self.assertEqual(0, s4.numberOfMentors())
        self.assertIs(m, s5.getMentor(0))
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(3, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToMStarTest.java: setStudents_empty
    def test_setStudents_empty(self):
        s = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        m = MentorR.MentorR("blah", s, s2, s3)
        self.assertIs(False, m.setStudents())
        self.assertEqual(3, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToMStarTest.java: deletStudentDeletesTheMentorIfNotEnoughLeft
    def test_deletStudentDeletesTheMentorIfNotEnoughLeft(self):
        s1 = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        m = MentorR.MentorR("blah", s1, s2, s3)
        studentP = ProgramR.ProgramR()
        mentorP = ProgramR.ProgramR()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNone(m.getProgram())
        self.assertIsNone(mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertEqual(0, s1.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMStarTest.java: deleteStudentLeavesMentorAloneIfHasEnough
    def test_deleteStudentLeavesMentorAloneIfHasEnough(self):
        s1 = StudentR.StudentR(99)
        s2 = StudentR.StudentR(98)
        s3 = StudentR.StudentR(97)
        s4 = StudentR.StudentR(96)
        m = MentorR.MentorR("blah", s1, s2, s3, s4)
        studentP = ProgramR.ProgramR()
        mentorP = ProgramR.ProgramR()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(mentorP, m.getProgram())
        self.assertIs(m, mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertEqual(0, s1.numberOfMentors())
