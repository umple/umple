import unittest

from ImportModules import importModules

importModules(["MentorN", "StudentN"], ["associations"])
from ImportModules import *


class ManyToManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/ManyToManyTest.java: CreateNew
    def test_CreateNew(self):
        s = StudentN.StudentN(99)
        self.assertEqual(0, s.numberOfMentors())
        m = MentorN.MentorN("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToManyTest.java: addStudent
    def test_addStudent(self):
        m = MentorN.MentorN("blah")
        s = StudentN.StudentN(99)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(False, m.addStudent(s))
        self.assertIs(m, s.getMentor(0))
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/ManyToManyTest.java: addStudentToMultipleMentors
    def test_addStudentToMultipleMentors(self):
        m = MentorN.MentorN("blah")
        m2 = MentorN.MentorN("blah2")
        s = StudentN.StudentN(99)
        s2 = StudentN.StudentN(992)
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

    # testbed/test/cruise/associations/ManyToManyTest.java: addToNewMentor
    def test_addToNewMentor(self):
        m = MentorN.MentorN("blah")
        m2 = MentorN.MentorN("blah2")
        s = StudentN.StudentN(99)
        m.addStudent(s)
        m2.addStudent(s)
        self.assertEqual(2, s.numberOfMentors())
        self.assertIs(m, s.getMentor(0))
        self.assertIs(m2, s.getMentor(1))
        self.assertEqual(1, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertIs(s, m.getStudent(0))
        self.assertIs(s, m2.getStudent(0))

    # testbed/test/cruise/associations/ManyToManyTest.java: doNotRemoveFromExistingMentor
    def test_doNotRemoveFromExistingMentor(self):
        m = MentorN.MentorN("blah")
        m2 = MentorN.MentorN("blah2")
        s1 = StudentN.StudentN(99)
        s2 = StudentN.StudentN(98)
        s3 = StudentN.StudentN(97)
        m.addStudent(s1)
        m.addStudent(s2)
        m.addStudent(s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        m2.addStudent(s1)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(s1, m.getStudent(0))
        self.assertIs(s2, m.getStudent(1))
        self.assertIs(s3, m.getStudent(2))
        self.assertEqual(1, m2.numberOfStudents())
        self.assertIs(s1, m2.getStudent(0))
        self.assertIs(m, s1.getMentor(0))
        self.assertIs(m2, s1.getMentor(1))
        self.assertIs(m, s2.getMentor(0))
        self.assertIs(m, s3.getMentor(0))

    # testbed/test/cruise/associations/ManyToManyTest.java: removeStudent
    def test_removeStudent(self):
        m = MentorN.MentorN("blah")
        s = StudentN.StudentN(99)
        m.addStudent(s)
        m.removeStudent(s)
        self.assertEqual(0, s.numberOfMentors())
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/ManyToManyTest.java: deleteAll
    def test_deleteAll(self):
        m = MentorN.MentorN("blah")
        m2 = MentorN.MentorN("blah2")
        s = StudentN.StudentN(99)
        s2 = StudentN.StudentN(98)
        s3 = StudentN.StudentN(97)
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
