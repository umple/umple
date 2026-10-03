import unittest

from ImportModules import importModules

importModules(["MentorP", "StudentP"], ["associations"])
from ImportModules import *


class UnidirectionalManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/UnidirectionalManyTest.java: addStudent
    def test_addStudent(self):
        m = MentorP.MentorP("blah")
        s = StudentP.StudentP(1)
        m.addStudent(s)
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/UnidirectionalManyTest.java: addSameStudent
    def test_addSameStudent(self):
        m = MentorP.MentorP("blah")
        s = StudentP.StudentP(1)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(False, m.addStudent(s))
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/UnidirectionalManyTest.java: removeStudent
    def test_removeStudent(self):
        m = MentorP.MentorP("blah")
        s = StudentP.StudentP(1)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(True, m.removeStudent(s))
        self.assertIs(False, m.removeStudent(s))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/UnidirectionalManyTest.java: addMultipleMentors
    def test_addMultipleMentors(self):
        m = MentorP.MentorP("blah")
        m2 = MentorP.MentorP("blah2")
        s = StudentP.StudentP(99)
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        m.addStudent(s)
        self.assertEqual(1, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        m2.addStudent(s)
        self.assertEqual(1, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertIs(s, m.getStudent(0))
        self.assertIs(s, m2.getStudent(0))

    # testbed/test/cruise/associations/UnidirectionalManyTest.java: deleteDoesNotRemoveStudentsFromMentors
    def test_deleteDoesNotRemoveStudentsFromMentors(self):
        m = MentorP.MentorP("blah")
        m2 = MentorP.MentorP("blah2")
        m3 = MentorP.MentorP("blah3")
        s = StudentP.StudentP(99)
        s2 = StudentP.StudentP(98)
        s3 = StudentP.StudentP(97)
        m.addStudent(s)
        m.addStudent(s2)
        m2.addStudent(s)
        m3.addStudent(s3)
        s.delete()
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(1, m3.numberOfStudents())
