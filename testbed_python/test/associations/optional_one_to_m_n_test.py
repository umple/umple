import unittest

from ImportModules import importModules

importModules(["MentorE", "ProgramE", "StudentE"], ["associations"])
from ImportModules import *


class OptionalOneToMNTest(unittest.TestCase):
    # testbed/test/cruise/associations/OptionalOneToMNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentE.StudentE()
        self.assertIsNone(s.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: ConstructorWithTooFew
    def test_ConstructorWithTooFew(self):
        s = StudentE.StudentE()
        with self.assertRaises(RuntimeError):
            MentorE.MentorE(s)

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: ConstructorWithTooMany
    def test_ConstructorWithTooMany(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        s5 = StudentE.StudentE()
        s6 = StudentE.StudentE()
        with self.assertRaises(RuntimeError):
            MentorE.MentorE(s, s2, s3, s4, s5, s6)

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: constructorJustBigEnough
    def test_constructorJustBigEnough(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        m = MentorE.MentorE(s, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: constructorJustSmallEnough
    def test_constructorJustSmallEnough(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        s5 = StudentE.StudentE()
        m = MentorE.MentorE(s, s2, s3, s4, s5)
        self.assertEqual(5, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(m, s4.getMentor())
        self.assertIs(m, s5.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: constructorWatchOutForDuplicateEntries
    def test_constructorWatchOutForDuplicateEntries(self):
        s = StudentE.StudentE()
        with self.assertRaises(RuntimeError):
            MentorE.MentorE(s, s)

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: constructorCheckForExistingMentorNotEnoughToSurvive
    def test_constructorCheckForExistingMentorNotEnoughToSurvive(self):
        s1 = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        m = MentorE.MentorE(s1, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s1.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIsNone(s4.getMentor())
        with self.assertRaises(RuntimeError):
            MentorE.MentorE(s1, s2, s4)

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: constructorCheckForExistingMentorEnoughToShare
    def test_constructorCheckForExistingMentorEnoughToShare(self):
        s1 = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        s5 = StudentE.StudentE()
        m = MentorE.MentorE(s1, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s1.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIsNone(s4.getMentor())
        self.assertIsNone(s5.getMentor())
        m2 = MentorE.MentorE(s2, s4, s5)
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(3, m2.numberOfStudents())
        self.assertIs(m, s1.getMentor())
        self.assertIs(m2, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(m2, s4.getMentor())
        self.assertIs(m2, s5.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: setStudents_outsideNM
    def test_setStudents_outsideNM(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        s5 = StudentE.StudentE()
        s6 = StudentE.StudentE()
        m = MentorE.MentorE(s, s2)
        self.assertIs(False, m.setStudents(s, s2, s3, s4, s5, s6))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIsNone(s3.getMentor())
        self.assertIsNone(s4.getMentor())
        self.assertIsNone(s5.getMentor())
        self.assertIsNone(s6.getMentor())
        self.assertIs(False, m.setStudents(s))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIsNone(s3.getMentor())
        self.assertIsNone(s4.getMentor())
        self.assertIsNone(s5.getMentor())
        self.assertIsNone(s6.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: setStudents_withinNM
    def test_setStudents_withinNM(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        m = MentorE.MentorE(s, s2)
        self.assertIs(True, m.setStudents(s2, s3, s4))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIsNone(s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(m, s4.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: addStudent
    def test_addStudent(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        s5 = StudentE.StudentE()
        s6 = StudentE.StudentE()
        m = MentorE.MentorE(s, s2, s3, s4)
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(True, m.addStudent(s5))
        self.assertEqual(5, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(m, s4.getMentor())
        self.assertIs(m, s5.getMentor())
        self.assertIs(False, m.addStudent(s6))
        self.assertEqual(5, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: addStudentHasExistingMentor
    def test_addStudentHasExistingMentor(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        s5 = StudentE.StudentE()
        s6 = StudentE.StudentE()
        m = MentorE.MentorE(s, s2, s3)
        m2 = MentorE.MentorE(s4, s5, s6)
        self.assertIs(True, m.addStudent(s4))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(m, s4.getMentor())
        self.assertIs(m2, s5.getMentor())
        self.assertIs(m2, s6.getMentor())
        self.assertIs(False, m.addStudent(s5))

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: removeStudent
    def test_removeStudent(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        s4 = StudentE.StudentE()
        m = MentorE.MentorE(s, s2, s3)
        self.assertIs(False, m.removeStudent(s4))
        self.assertIs(True, m.removeStudent(s3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIsNone(s3.getMentor())
        self.assertIsNone(s4.getMentor())
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: setStudents_empty
    def test_setStudents_empty(self):
        s = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        m = MentorE.MentorE(s, s2, s3)
        self.assertIs(False, m.setStudents())
        self.assertEqual(3, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: deletStudentDeletesTheMentorIfNotEnoughLeft
    def test_deletStudentDeletesTheMentorIfNotEnoughLeft(self):
        s1 = StudentE.StudentE()
        s2 = StudentE.StudentE()
        m = MentorE.MentorE(s1, s2)
        studentP = ProgramE.ProgramE()
        mentorP = ProgramE.ProgramE()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNone(m.getProgram())
        self.assertIsNone(mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertIsNone(s1.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMNTest.java: deleteStudentLeavesMentorAloneIfHasEnough
    def test_deleteStudentLeavesMentorAloneIfHasEnough(self):
        s1 = StudentE.StudentE()
        s2 = StudentE.StudentE()
        s3 = StudentE.StudentE()
        m = MentorE.MentorE(s1, s2, s3)
        studentP = ProgramE.ProgramE()
        mentorP = ProgramE.ProgramE()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(mentorP, m.getProgram())
        self.assertIs(m, mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertIsNone(s1.getMentor())
