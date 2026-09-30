import unittest

from ImportModules import importModules

importModules(["MentorAE", "StudentAE"], ["associations"])
from ImportModules import *


class OptionalNToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: CreateNew
    def test_CreateNew(self):
        s = StudentAE.StudentAE(99)
        self.assertEqual(0, s.numberOfMentors())
        m = MentorAE.MentorAE("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: addStudent
    def test_addStudent(self):
        m = MentorAE.MentorAE("blah")
        s = StudentAE.StudentAE(99)
        m.addStudent(s)
        self.assertIs(m, s.getMentor(0))
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: addStudentToMultipleMentors
    def test_addStudentToMultipleMentors(self):
        m = MentorAE.MentorAE("blah")
        m2 = MentorAE.MentorAE("blah2")
        s = StudentAE.StudentAE(99)
        s2 = StudentAE.StudentAE(992)
        m.addStudent(s)
        m2.addStudent(s2)
        m2.addStudent(s)
        s2.addMentor(m)
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m2, s.getMentor(1))
        self.assertIs(m2, s2.getMentor(0))
        self.assertIs(m, s2.getMentor(1))
        self.assertIs(s, m.getStudent(0))
        self.assertIs(s2, m.getStudent(1))
        self.assertIs(s2, m2.getStudent(0))
        self.assertIs(s, m2.getStudent(1))

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: addToNewMentor
    def test_addToNewMentor(self):
        m = MentorAE.MentorAE("blah")
        m2 = MentorAE.MentorAE("blah2")
        s = StudentAE.StudentAE(99)
        m.addStudent(s)
        m2.addStudent(s)
        self.assertEqual(2, s.numberOfMentors())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m2, s.getMentor(1))
        self.assertEqual(1, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertIs(s, m.getStudent(0))
        self.assertIs(s, m2.getStudent(0))

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: doNotRemoveFromExistingMentor
    def test_doNotRemoveFromExistingMentor(self):
        m = MentorAE.MentorAE("blah")
        m2 = MentorAE.MentorAE("blah2")
        s1 = StudentAE.StudentAE(99)
        s2 = StudentAE.StudentAE(98)
        m.addStudent(s1)
        m.addStudent(s2)
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        m2.addStudent(s1)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(s1, m.getStudent(0))
        self.assertIs(s2, m.getStudent(1))
        self.assertEqual(1, m2.numberOfStudents())
        self.assertIs(s1, m2.getStudent(0))
        self.assertIs(m, s1.getMentor(0))
        self.assertIs(m2, s1.getMentor(1))
        self.assertIs(m, s2.getMentor(0))

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: removeStudent
    def test_removeStudent(self):
        m = MentorAE.MentorAE("blah")
        s = StudentAE.StudentAE(99)
        m.addStudent(s)
        m.removeStudent(s)
        self.assertEqual(0, s.numberOfMentors())
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: deleteAll
    def test_deleteAll(self):
        m = MentorAE.MentorAE("blah")
        m2 = MentorAE.MentorAE("blah2")
        s = StudentAE.StudentAE(99)
        s2 = StudentAE.StudentAE(98)
        s3 = StudentAE.StudentAE(97)
        m.addStudent(s)
        m.addStudent(s2)
        m.addStudent(s3)
        m2.addStudent(s2)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(0, s.numberOfMentors())
        self.assertEqual(1, s2.numberOfMentors())
        self.assertEqual(0, s3.numberOfMentors())

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: isMaxNumber
    def test_isMaxNumber(self):
        self.assertEqual(3, StudentAE.StudentAE.maximumNumberOfMentors())
        self.assertEqual(2, MentorAE.MentorAE.maximumNumberOfStudents())

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: addStudentsMax
    def test_addStudentsMax(self):
        m = MentorAE.MentorAE("blah")
        self.assertIs(True, m.addStudent(StudentAE.StudentAE(99)))
        self.assertIs(True, m.addStudent(StudentAE.StudentAE(98)))
        self.assertIs(False, m.addStudent(StudentAE.StudentAE(97)))

    # testbed/test/cruise/associations/OptionalNToOptionalNTest.java: addMentorsMax
    def test_addMentorsMax(self):
        s = StudentAE.StudentAE(98)
        self.assertIs(True, s.addMentor(MentorAE.MentorAE("blah")))
        self.assertIs(True, s.addMentor(MentorAE.MentorAE("blah2")))
        self.assertIs(True, s.addMentor(MentorAE.MentorAE("blah3")))
        self.assertIs(False, s.addMentor(MentorAE.MentorAE("blah4")))
