import unittest

from ImportModules import importModules

importModules(["MentorQ", "ProgramQ", "StudentQ"], ["associations"])
from ImportModules import *


class ManyToNTest(unittest.TestCase):
    # testbed/test/cruise/associations/ManyToNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentQ.StudentQ(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/ManyToNTest.java: ConstructorWithTooFew
    def test_ConstructorWithTooFew(self):
        s = StudentQ.StudentQ(99)
        with self.assertRaises(RuntimeError):
            MentorQ.MentorQ("blah", s)

    # testbed/test/cruise/associations/ManyToNTest.java: ConstructorWithTooMany
    def test_ConstructorWithTooMany(self):
        s = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        s3 = StudentQ.StudentQ(97)
        with self.assertRaises(RuntimeError):
            MentorQ.MentorQ("blah", s, s2, s3)

    # testbed/test/cruise/associations/ManyToNTest.java: constructorJustRight
    def test_constructorJustRight(self):
        s = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        m = MentorQ.MentorQ("blah", s, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))

    # testbed/test/cruise/associations/ManyToNTest.java: constructorWatchOutForDuplicateEntries
    def test_constructorWatchOutForDuplicateEntries(self):
        s = StudentQ.StudentQ(99)
        with self.assertRaises(RuntimeError):
            MentorQ.MentorQ("blah", s, s)

    # testbed/test/cruise/associations/ManyToNTest.java: constructorExistingMentorsOkay
    def test_constructorExistingMentorsOkay(self):
        s1 = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        s3 = StudentQ.StudentQ(97)
        m = MentorQ.MentorQ("blah", s1, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s1.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())
        m2 = MentorQ.MentorQ("blah2", s2, s3)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s1.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(m2, s2.getMentor(1))
        self.assertIs(m2, s3.getMentor(0))

    # testbed/test/cruise/associations/ManyToNTest.java: setStudents_outsideN
    def test_setStudents_outsideN(self):
        s = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        s3 = StudentQ.StudentQ(97)
        s4 = StudentQ.StudentQ(96)
        s5 = StudentQ.StudentQ(95)
        m = MentorQ.MentorQ("blah", s, s2)
        self.assertIs(False, m.setStudents(s2, s3, s4))
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

    # testbed/test/cruise/associations/ManyToNTest.java: setStudents_doNotAllowDuplicatesNM
    def test_setStudents_doNotAllowDuplicatesNM(self):
        s = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        s3 = StudentQ.StudentQ(97)
        m = MentorQ.MentorQ("blah", s, s2)
        self.assertIs(False, m.setStudents(s2, s2, s3))

    # testbed/test/cruise/associations/ManyToNTest.java: setStudents_withinN
    def test_setStudents_withinN(self):
        s = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        s3 = StudentQ.StudentQ(97)
        m = MentorQ.MentorQ("blah", s, s2)
        self.assertIs(True, m.setStudents(s3, s2))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))

    # testbed/test/cruise/associations/ManyToNTest.java: setStudents_empty
    def test_setStudents_empty(self):
        s = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        m = MentorQ.MentorQ("blah", s, s2)
        self.assertIs(False, m.setStudents())
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToNTest.java: deletStudentDeletesTheMentorIfNotEnoughLeft
    def test_deletStudentDeletesTheMentorIfNotEnoughLeft(self):
        s1 = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        m = MentorQ.MentorQ("blah", s1, s2)
        studentP = ProgramQ.ProgramQ()
        mentorP = ProgramQ.ProgramQ()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIsNone(m.getProgram())
        self.assertIsNone(mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertEqual(0, s1.numberOfMentors())

    # testbed/test/cruise/associations/ManyToNTest.java: addMentorTooMany
    def test_addMentorTooMany(self):
        s = StudentQ.StudentQ(99)
        s2 = StudentQ.StudentQ(98)
        s3 = StudentQ.StudentQ(97)
        m = MentorQ.MentorQ("blah", s, s2)
        self.assertIs(False, s3.addMentor(m))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(0, s3.numberOfMentors())
