import unittest

from ImportModules import importModules

importModules(["MentorAA", "ProgramAA", "StudentAA"], ["associations"])
from ImportModules import *


class ManyToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/ManyToOptionalNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentAA.StudentAA(99)
        self.assertEqual(0, s.numberOfMentors())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorAA.MentorAA("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: setTooMany
    def test_setTooMany(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        s3 = StudentAA.StudentAA(97)
        m = MentorAA.MentorAA("blah")
        self.assertIs(False, m.setStudents(s, s2, s3))
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
        self.assertEqual(0, s2.numberOfMentors())
        self.assertEqual(0, s3.numberOfMentors())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: setStudentsAtMax
    def test_setStudentsAtMax(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        m = MentorAA.MentorAA("blah")
        m.setStudents(s, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: setStudentsWatchOutForDuplicates
    def test_setStudentsWatchOutForDuplicates(self):
        s = StudentAA.StudentAA(99)
        m = MentorAA.MentorAA("blah")
        self.assertIs(False, m.setStudents(s, s))

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: setStudentsDoNotEraseExisting
    def test_setStudentsDoNotEraseExisting(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        s3 = StudentAA.StudentAA(97)
        m = MentorAA.MentorAA("blah")
        m.setStudents(s, s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())
        m2 = MentorAA.MentorAA("blah2")
        m2.setStudents(s, s3)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(m2, s.getMentor(1))
        self.assertIs(m2, s3.getMentor(0))

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: setStudents_aboveNKeepsExistingIntact
    def test_setStudents_aboveNKeepsExistingIntact(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        s3 = StudentAA.StudentAA(97)
        s4 = StudentAA.StudentAA(96)
        s5 = StudentAA.StudentAA(95)
        m = MentorAA.MentorAA("blah")
        self.assertIs(True, m.setStudents(s, s2))
        self.assertIs(False, m.setStudents(s2, s3, s4, s5, s))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertEqual(0, s3.numberOfMentors())
        self.assertEqual(0, s4.numberOfMentors())
        self.assertEqual(0, s5.numberOfMentors())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: setStudents_doNotAllowDuplicatesNM
    def test_setStudents_doNotAllowDuplicatesNM(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        m = MentorAA.MentorAA("blah")
        self.assertIs(False, m.setStudents(s, s2, s))

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: setStudents_atNOverwritesExisting
    def test_setStudents_atNOverwritesExisting(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        s3 = StudentAA.StudentAA(97)
        m = MentorAA.MentorAA("blah")
        self.assertIs(True, m.setStudents(s, s2))
        self.assertIs(True, m.setStudents(s2, s3))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: addMentorTooMany
    def test_addMentorTooMany(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        s3 = StudentAA.StudentAA(97)
        m = MentorAA.MentorAA("blah")
        m.setStudents(s, s2)
        self.assertIs(False, s3.addMentor(m))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(0, s3.numberOfMentors())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: addMentorTOkay
    def test_addMentorTOkay(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        m = MentorAA.MentorAA("blah")
        m.setStudents(s)
        self.assertIs(True, s2.addMentor(m))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(1, s2.numberOfMentors())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: addStudent
    def test_addStudent(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        s3 = StudentAA.StudentAA(97)
        m = MentorAA.MentorAA("blah")
        self.assertIs(True, m.setStudents(s))
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(True, m.addStudent(s2))
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(False, m.addStudent(s3))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: addStudentHasExistingMentor
    def test_addStudentHasExistingMentor(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        s3 = StudentAA.StudentAA(97)
        m = MentorAA.MentorAA("blah")
        m2 = MentorAA.MentorAA("blah2")
        m.setStudents(s, s2)
        m2.setStudents(s3)
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m2, s3.getMentor(0))
        self.assertIs(True, m2.addStudent(s2))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertEqual(2, s2.numberOfMentors())
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m2, s2.getMentor(1))
        self.assertIs(False, m.addStudent(s3))

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: removeStudent
    def test_removeStudent(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        s3 = StudentAA.StudentAA(97)
        m = MentorAA.MentorAA("blah")
        m.setStudents(s, s2)
        self.assertIs(False, m.removeStudent(s3))
        self.assertIs(True, m.removeStudent(s2))
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(m, s.getMentor(0))
        self.assertEqual(0, s2.numberOfMentors())
        self.assertEqual(0, s3.numberOfMentors())
        self.assertIs(True, m.removeStudent(s))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: setStudents_empty
    def test_setStudents_empty(self):
        s = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        m = MentorAA.MentorAA("blah")
        m.setStudents(s, s2)
        self.assertIs(True, m.setStudents())
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
        self.assertEqual(0, s2.numberOfMentors())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: deleteStudentLeavesMentorAlone
    def test_deleteStudentLeavesMentorAlone(self):
        s1 = StudentAA.StudentAA(99)
        s2 = StudentAA.StudentAA(98)
        m = MentorAA.MentorAA("blah")
        m.setStudents(s1, s2)
        studentP = ProgramAA.ProgramAA()
        mentorP = ProgramAA.ProgramAA()
        s2.setProgram(studentP)
        m.setProgram(mentorP)
        s1.delete()
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(mentorP, m.getProgram())
        self.assertIs(m, mentorP.getMentor())
        self.assertIs(studentP, s2.getProgram())
        self.assertEqual(0, s1.numberOfMentors())

    # testbed/test/cruise/associations/ManyToOptionalNTest.java: studentBounds
    def test_studentBounds(self):
        self.assertEqual(2, MentorAA.MentorAA.maximumNumberOfStudents())
