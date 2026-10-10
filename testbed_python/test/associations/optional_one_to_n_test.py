import unittest

from ImportModules import importModules

importModules(["MentorD", "ProgramD", "StudentD"], ["associations"])
from ImportModules import *


class OptionalOneToNTest(unittest.TestCase):
    # testbed/test/cruise/associations/OptionalOneToNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentD.StudentD()
        self.assertIsNone(s.getMentor())

    # testbed/test/cruise/associations/OptionalOneToNTest.java: ConstructorWithoutNStudents
    def test_ConstructorWithoutNStudents(self):
        s = StudentD.StudentD()
        s2 = StudentD.StudentD()
        with self.assertRaises(RuntimeError):
            MentorD.MentorD(s, s2)

    # testbed/test/cruise/associations/OptionalOneToNTest.java: setStudents_makeSureAlwaysN
    def test_setStudents_makeSureAlwaysN(self):
        s = StudentD.StudentD()
        s2 = StudentD.StudentD()
        s3 = StudentD.StudentD()
        m = MentorD.MentorD(s, s2, s3)
        s4 = StudentD.StudentD()
        s5 = StudentD.StudentD()
        s6 = StudentD.StudentD()
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIs(True, m.setStudents(s4, s5, s6))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIsNone(s.getMentor())
        self.assertIsNone(s2.getMentor())
        self.assertIsNone(s3.getMentor())
        self.assertIs(m, s4.getMentor())
        self.assertIs(m, s5.getMentor())
        self.assertIs(m, s6.getMentor())

    # testbed/test/cruise/associations/OptionalOneToNTest.java: setStudents_watchOutForDuplicateEntries
    def test_setStudents_watchOutForDuplicateEntries(self):
        s = StudentD.StudentD()
        s2 = StudentD.StudentD()
        with self.assertRaises(RuntimeError):
            MentorD.MentorD(s, s2, s)

    # testbed/test/cruise/associations/OptionalOneToNTest.java: setStudents_replaceExisitingmakeSureAlwaysN
    def test_setStudents_replaceExisitingmakeSureAlwaysN(self):
        s = StudentD.StudentD()
        s2 = StudentD.StudentD()
        s3 = StudentD.StudentD()
        m = MentorD.MentorD(s, s2, s3)
        s4 = StudentD.StudentD()
        self.assertIs(False, m.setStudents(s, s2))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIsNone(s4.getMentor())
        self.assertIs(False, m.setStudents(s, s2, s3, s4))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIsNone(s4.getMentor())

    # testbed/test/cruise/associations/OptionalOneToNTest.java: setStudents_empty
    def test_setStudents_empty(self):
        s = StudentD.StudentD()
        s2 = StudentD.StudentD()
        s3 = StudentD.StudentD()
        m = MentorD.MentorD(s, s2, s3)
        self.assertIs(True, m.setStudents(s, s2, s3))
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(False, m.setStudents())
        self.assertEqual(3, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToNTest.java: checkForExistingMentor
    def test_checkForExistingMentor(self):
        s1 = StudentD.StudentD()
        s2 = StudentD.StudentD()
        s3 = StudentD.StudentD()
        m = MentorD.MentorD(s1, s2, s3)
        s4 = StudentD.StudentD()
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s1.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())
        self.assertIsNone(s4.getMentor())
        with self.assertRaises(RuntimeError):
            MentorD.MentorD(s1, s2, s4)

    # testbed/test/cruise/associations/OptionalOneToNTest.java: deletStudentDeletesTheMentor
    def test_deletStudentDeletesTheMentor(self):
        s1 = StudentD.StudentD()
        s2 = StudentD.StudentD()
        s3 = StudentD.StudentD()
        m = MentorD.MentorD(s1, s2, s3)
        studentP = ProgramD.ProgramD()
        mentorP = ProgramD.ProgramD()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNone(m.getProgram())
        self.assertIsNone(mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertIsNone(s1.getMentor())
