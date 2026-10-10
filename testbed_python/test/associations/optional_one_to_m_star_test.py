import unittest

from ImportModules import importModules

importModules(["MentorF", "ProgramF", "StudentF"], ["associations"])
from ImportModules import *


class OptionalOneToMStarTest(unittest.TestCase):
    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentF.StudentF()
        self.assertIsNone(s.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: ConstructorWithTooFew
    def test_ConstructorWithTooFew(self):
        s = StudentF.StudentF()
        with self.assertRaises(RuntimeError):
            MentorF.MentorF(s)

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: constructorJustBigEnough
    def test_constructorJustBigEnough(self):
        s = StudentF.StudentF()
        s2 = StudentF.StudentF()
        m = MentorF.MentorF(s, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: constructorWatchOutForDuplicateEntries
    def test_constructorWatchOutForDuplicateEntries(self):
        s = StudentF.StudentF()
        with self.assertRaises(RuntimeError):
            MentorF.MentorF(s, s)

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: constructorCheckForExistingMentorNotEnoughToSurvive
    def test_constructorCheckForExistingMentorNotEnoughToSurvive(self):
        s1 = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        s4 = StudentF.StudentF()
        m = MentorF.MentorF(s1, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s1.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIsNone(s4.getMentor())
        with self.assertRaises(RuntimeError):
            MentorF.MentorF(s1, s2, s4)

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: constructorCheckForExistingMentorFnoughToShare
    def test_constructorCheckForExistingMentorFnoughToShare(self):
        s1 = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        s4 = StudentF.StudentF()
        s5 = StudentF.StudentF()
        m = MentorF.MentorF(s1, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s1.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIsNone(s4.getMentor())
        self.assertIsNone(s5.getMentor())
        m2 = MentorF.MentorF(s2, s4, s5)
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(3, m2.numberOfStudents())
        self.assertIs(m, s1.getMentor())
        self.assertIs(m2, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(m2, s4.getMentor())
        self.assertIs(m2, s5.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: setStudents_lessThanM
    def test_setStudents_lessThanM(self):
        s = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        s4 = StudentF.StudentF()
        s5 = StudentF.StudentF()
        s6 = StudentF.StudentF()
        m = MentorF.MentorF(s, s2)
        self.assertIs(False, m.setStudents(s))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIsNone(s3.getMentor())
        self.assertIsNone(s4.getMentor())
        self.assertIsNone(s5.getMentor())
        self.assertIsNone(s6.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: setStudents_aLot
    def test_setStudents_aLot(self):
        allStudents = [None] * 100
        for i in range(100):
            allStudents[i] = StudentF.StudentF()
        m = MentorF.MentorF(*allStudents)
        self.assertEqual(100, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: setStudents_atLeastM
    def test_setStudents_atLeastM(self):
        s = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        s4 = StudentF.StudentF()
        m = MentorF.MentorF(s, s2)
        self.assertIs(True, m.setStudents(s2, s3, s4))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIsNone(s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(m, s4.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: addStudent
    def test_addStudent(self):
        s = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        s4 = StudentF.StudentF()
        s5 = StudentF.StudentF()
        s6 = StudentF.StudentF()
        m = MentorF.MentorF(s, s2, s3, s4)
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(True, m.addStudent(s5))
        self.assertEqual(5, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(m, s4.getMentor())
        self.assertIs(m, s5.getMentor())
        self.assertIs(True, m.addStudent(s6))
        self.assertEqual(6, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: addStudentHasExistingMentor
    def test_addStudentHasExistingMentor(self):
        s = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        s4 = StudentF.StudentF()
        s5 = StudentF.StudentF()
        s6 = StudentF.StudentF()
        m = MentorF.MentorF(s, s2, s3)
        m2 = MentorF.MentorF(s4, s5, s6)
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

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: removeStudent
    def test_removeStudent(self):
        s = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        s4 = StudentF.StudentF()
        m = MentorF.MentorF(s, s2, s3)
        self.assertIs(False, m.removeStudent(s4))
        self.assertIs(True, m.removeStudent(s3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIsNone(s3.getMentor())
        self.assertIsNone(s4.getMentor())
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: setStudents_empty
    def test_setStudents_empty(self):
        s = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        m = MentorF.MentorF(s, s2, s3)
        self.assertIs(False, m.setStudents())
        self.assertEqual(3, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: deletStudentDeletesTheMentorIfNotEnoughLeft
    def test_deletStudentDeletesTheMentorIfNotEnoughLeft(self):
        s1 = StudentF.StudentF()
        s2 = StudentF.StudentF()
        m = MentorF.MentorF(s1, s2)
        studentP = ProgramF.ProgramF()
        mentorP = ProgramF.ProgramF()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNone(m.getProgram())
        self.assertIsNone(mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertIsNone(s1.getMentor())

    # testbed/test/cruise/associations/OptionalOneToMStarTest.java: deleteStudentLeavesMentorAloneIfHasEnough
    def test_deleteStudentLeavesMentorAloneIfHasEnough(self):
        s1 = StudentF.StudentF()
        s2 = StudentF.StudentF()
        s3 = StudentF.StudentF()
        m = MentorF.MentorF(s1, s2, s3)
        studentP = ProgramF.ProgramF()
        mentorP = ProgramF.ProgramF()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(mentorP, m.getProgram())
        self.assertIs(m, mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertIsNone(s1.getMentor())
