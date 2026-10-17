import unittest

from ImportModules import importModules

importModules(["MentorO", "ProgramO", "StudentO"], ["associations"])
from ImportModules import *


class ManyToMNTest(unittest.TestCase):
    # testbed/test/cruise/associations/ManyToMNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentO.StudentO(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMNTest.java: ConstructorWithTooFew
    def test_ConstructorWithTooFew(self):
        s = StudentO.StudentO(99)
        with self.assertRaises(RuntimeError):
            MentorO.MentorO("blah", s)

    # testbed/test/cruise/associations/ManyToMNTest.java: ConstructorWithTooMany
    def test_ConstructorWithTooMany(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s4 = StudentO.StudentO(96)
        s5 = StudentO.StudentO(95)
        with self.assertRaises(RuntimeError):
            MentorO.MentorO("blah", s, s2, s3, s4, s5)

    # testbed/test/cruise/associations/ManyToMNTest.java: constructorJustBigEnough
    def test_constructorJustBigEnough(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        m = MentorO.MentorO("blah", s, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))

    # testbed/test/cruise/associations/ManyToMNTest.java: constructorJustSmallEnough
    def test_constructorJustSmallEnough(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s4 = StudentO.StudentO(96)
        m = MentorO.MentorO("blah", s, s2, s3, s4)
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))

    # testbed/test/cruise/associations/ManyToMNTest.java: constructorWatchOutForDuplicateEntries
    def test_constructorWatchOutForDuplicateEntries(self):
        s = StudentO.StudentO(99)
        with self.assertRaises(RuntimeError):
            MentorO.MentorO("blah", s, s)

    # testbed/test/cruise/associations/ManyToMNTest.java: constructorExistingMentorsOkay
    def test_constructorExistingMentorsOkay(self):
        s1 = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        m = MentorO.MentorO("blah", s1, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s1.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())
        m2 = MentorO.MentorO("blah2", s1, s2, s3)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s1.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(3, m2.numberOfStudents())
        self.assertIs(m2, s1.getMentor(1))
        self.assertIs(m2, s2.getMentor(1))
        self.assertIs(m2, s3.getMentor(0))

    # testbed/test/cruise/associations/ManyToMNTest.java: setStudents_outsideNM
    def test_setStudents_outsideNM(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s4 = StudentO.StudentO(96)
        s5 = StudentO.StudentO(95)
        m = MentorO.MentorO("blah", s, s2)
        self.assertIs(False, m.setStudents(s2, s3, s4, s5, s))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())
        self.assertIs(False, m.setStudents(s5))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMNTest.java: setStudents_doNotAllowDuplicatesNM
    def test_setStudents_doNotAllowDuplicatesNM(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        m = MentorO.MentorO("blah", s, s2)
        self.assertIs(False, m.setStudents(s2, s2, s3))

    # testbed/test/cruise/associations/ManyToMNTest.java: setStudents_withinNM
    def test_setStudents_withinNM(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s4 = StudentO.StudentO(96)
        m = MentorO.MentorO("blah", s, s2)
        self.assertIs(True, m.setStudents(s2, s3, s4))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))

    # testbed/test/cruise/associations/ManyToMNTest.java: addMentorTooMany
    def test_addMentorTooMany(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s4 = StudentO.StudentO(96)
        s5 = StudentO.StudentO(95)
        m = MentorO.MentorO("blah", s, s2, s3, s4)
        self.assertIs(False, s5.addMentor(m))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(0, s5.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMNTest.java: addMentorTOkay
    def test_addMentorTOkay(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s5 = StudentO.StudentO(95)
        m = MentorO.MentorO("blah", s, s2, s3)
        self.assertIs(True, s5.addMentor(m))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(1, s5.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMNTest.java: addStudent
    def test_addStudent(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s4 = StudentO.StudentO(96)
        s5 = StudentO.StudentO(95)
        m = MentorO.MentorO("blah", s, s2, s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(True, m.addStudent(s4))
        self.assertEqual(4, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))
        self.assertIs(m, s4.getMentor(0))
        self.assertIs(False, m.addStudent(s5))
        self.assertEqual(4, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToMNTest.java: addStudentHasExistingMentor
    def test_addStudentHasExistingMentor(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s4 = StudentO.StudentO(96)
        s5 = StudentO.StudentO(95)
        s6 = StudentO.StudentO(94)
        m = MentorO.MentorO("blah", s, s2, s3)
        m2 = MentorO.MentorO("blah2", s4, s5, s6)
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
        self.assertIs(False, m.addStudent(s5))

    # testbed/test/cruise/associations/ManyToMNTest.java: removeStudent
    def test_removeStudent(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        s4 = StudentO.StudentO(96)
        m = MentorO.MentorO("blah", s, s2, s3)
        self.assertIs(False, m.removeStudent(s4))
        self.assertIs(True, m.removeStudent(s3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())
        self.assertEqual(0, s4.numberOfMentors())
        self.assertIs(False, m.removeStudent(s2))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToMNTest.java: setStudents_empty
    def test_setStudents_empty(self):
        s = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        m = MentorO.MentorO("blah", s, s2, s3)
        self.assertIs(False, m.setStudents())
        self.assertEqual(3, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToMNTest.java: deletStudentDeletesTheMentorIfNotEnoughLeft
    def test_deletStudentDeletesTheMentorIfNotEnoughLeft(self):
        s1 = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        m = MentorO.MentorO("blah", s1, s2)
        studentP = ProgramO.ProgramO()
        mentorP = ProgramO.ProgramO()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNone(m.getProgram())
        self.assertIsNone(mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertEqual(0, s1.numberOfMentors())

    # testbed/test/cruise/associations/ManyToMNTest.java: deleteStudentLeavesMentorAloneIfHasEnough
    def test_deleteStudentLeavesMentorAloneIfHasEnough(self):
        s1 = StudentO.StudentO(99)
        s2 = StudentO.StudentO(98)
        s3 = StudentO.StudentO(97)
        m = MentorO.MentorO("blah", s1, s2, s3)
        studentP = ProgramO.ProgramO()
        mentorP = ProgramO.ProgramO()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(mentorP, m.getProgram())
        self.assertIs(m, mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertEqual(0, s1.numberOfMentors())
