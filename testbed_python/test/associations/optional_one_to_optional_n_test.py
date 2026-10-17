import unittest

from ImportModules import importModules

importModules(["MentorY", "StudentY"], ["associations"])
from ImportModules import *


class OptionalOneToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: CreateStudentWithoutMentor
    def test_CreateStudentWithoutMentor(self):
        s = StudentY.StudentY(99)
        self.assertIsNone(s.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: addStudent
    def test_addStudent(self):
        m = MentorY.MentorY("blah")
        s = StudentY.StudentY(99)
        m.addStudent(s)
        self.assertIs(m, s.getMentor())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: addStudentCannotAddForever
    def test_addStudentCannotAddForever(self):
        m = MentorY.MentorY("blah")
        self.assertIs(True, m.addStudent(StudentY.StudentY(99)))
        self.assertIs(True, m.addStudent(StudentY.StudentY(98)))
        self.assertIs(True, m.addStudent(StudentY.StudentY(97)))
        self.assertIs(True, m.addStudent(StudentY.StudentY(96)))
        self.assertIs(False, m.addStudent(StudentY.StudentY(95)))

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorY.MentorY("blah")
        m2 = MentorY.MentorY("blah2")
        s = StudentY.StudentY(99)
        m.addStudent(s)
        s.setMentor(m2)
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: cannotReplaceIfFull
    def test_cannotReplaceIfFull(self):
        m = MentorY.MentorY("blah")
        m2 = MentorY.MentorY("blah2")
        m2.addStudent(StudentY.StudentY(99))
        m2.addStudent(StudentY.StudentY(98))
        m2.addStudent(StudentY.StudentY(97))
        m2.addStudent(StudentY.StudentY(96))
        s = StudentY.StudentY(95)
        self.assertIs(True, m.addStudent(s))
        self.assertIs(False, s.setMentor(m2))
        self.assertIs(m, s.getMentor())
        self.assertEqual(4, m2.numberOfStudents())
        self.assertEqual(1, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: addToNewMentor
    def test_addToNewMentor(self):
        m = MentorY.MentorY("blah")
        m2 = MentorY.MentorY("blah2")
        s = StudentY.StudentY(99)
        m.addStudent(s)
        m2.addStudent(s)
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: cannotAddToFullMentor
    def test_cannotAddToFullMentor(self):
        m = MentorY.MentorY("blah")
        m2 = MentorY.MentorY("blah2")
        s = StudentY.StudentY(99)
        m.addStudent(StudentY.StudentY(99))
        m.addStudent(StudentY.StudentY(98))
        m.addStudent(StudentY.StudentY(97))
        m.addStudent(StudentY.StudentY(96))
        m2.addStudent(s)
        self.assertIs(False, m.addStudent(s))
        self.assertIs(m2, s.getMentor())
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: removeFromExistingMentor
    def test_removeFromExistingMentor(self):
        m = MentorY.MentorY("blah")
        m2 = MentorY.MentorY("blah2")
        s1 = StudentY.StudentY(99)
        s2 = StudentY.StudentY(98)
        s3 = StudentY.StudentY(97)
        m.addStudent(s1)
        m.addStudent(s2)
        m.addStudent(s3)
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        m2.addStudent(s1)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(s2, m.getStudent(0))
        self.assertIs(s3, m.getStudent(1))
        self.assertEqual(1, m2.numberOfStudents())
        self.assertIs(s1, m2.getStudent(0))
        self.assertIs(m2, s1.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: removeStudent
    def test_removeStudent(self):
        m = MentorY.MentorY("blah")
        s = StudentY.StudentY(99)
        m.addStudent(s)
        m.removeStudent(s)
        self.assertIsNone(s.getMentor())
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OptionalOneToOptionalNTest.java: maximumNumberOfStudents
    def test_maximumNumberOfStudents(self):
        self.assertEqual(4, MentorY.MentorY.maximumNumberOfStudents())
