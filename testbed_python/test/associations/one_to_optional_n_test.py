import unittest

from ImportModules import importModules

importModules(["MentorZ", "StudentZ"], ["associations"])
from ImportModules import *


class OneToOptionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToOptionalNTest.java: cannotCreateNullStudent
    def test_cannotCreateNullStudent(self):
        with self.assertRaises(RuntimeError):
            StudentZ.StudentZ(99, None)

    # testbed/test/cruise/associations/OneToOptionalNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorZ.MentorZ("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToOptionalNTest.java: CannotSetMentorNull
    def test_CannotSetMentorNull(self):
        m = MentorZ.MentorZ("blah")
        s = StudentZ.StudentZ(99, m)
        self.assertIs(False, s.setMentor(None))
        self.assertIs(m, s.getMentor())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToOptionalNTest.java: CreateStudentFromMentor
    def test_CreateStudentFromMentor(self):
        m = MentorZ.MentorZ("blah")
        s = StudentZ.StudentZ(99, m)
        self.assertEqual(99, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToOptionalNTest.java: CreateStudentFromMentorTooMany
    def test_CreateStudentFromMentorTooMany(self):
        m = MentorZ.MentorZ("blah")
        StudentZ.StudentZ(99, m)
        StudentZ.StudentZ(99, m)
        StudentZ.StudentZ(99, m)
        with self.assertRaises(RuntimeError):
            StudentZ.StudentZ(99, m)

    # testbed/test/cruise/associations/OneToOptionalNTest.java: CannotSetMentorAlreadyAtMax
    def test_CannotSetMentorAlreadyAtMax(self):
        m = MentorZ.MentorZ("blah")
        m2 = MentorZ.MentorZ("blah2")
        StudentZ.StudentZ(99, m)
        StudentZ.StudentZ(99, m)
        StudentZ.StudentZ(99, m)
        StudentZ.StudentZ(99, m2)
        StudentZ.StudentZ(99, m2)
        s = StudentZ.StudentZ(99, m2)
        self.assertIs(False, s.setMentor(m))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(3, m2.numberOfStudents())
        self.assertIs(m2, s.getMentor())

    # testbed/test/cruise/associations/OneToOptionalNTest.java: CreateStudentFromMentorJustEnough
    def test_CreateStudentFromMentorJustEnough(self):
        m = MentorZ.MentorZ("blah")
        s = StudentZ.StudentZ(99, m)
        s2 = StudentZ.StudentZ(99, m)
        s3 = StudentZ.StudentZ(99, m)
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(m, s.getMentor())
        self.assertIs(m, s2.getMentor())
        self.assertIs(m, s3.getMentor())

    # testbed/test/cruise/associations/OneToOptionalNTest.java: MaximumNumberOfStudents
    def test_MaximumNumberOfStudents(self):
        self.assertEqual(3, MentorZ.MentorZ.maximumNumberOfStudents())

    # testbed/test/cruise/associations/OneToOptionalNTest.java: addStudentViaConstructorInformation
    def test_addStudentViaConstructorInformation(self):
        m = MentorZ.MentorZ("blah")
        s = m.addStudent(10)
        self.assertEqual(10, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToOptionalNTest.java: addStudentViaConstructorInformationTooMany
    def test_addStudentViaConstructorInformationTooMany(self):
        m = MentorZ.MentorZ("blah")
        s = m.addStudent(10)
        s2 = m.addStudent(10)
        s3 = m.addStudent(10)
        s4 = m.addStudent(10)
        self.assertEqual(10, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(3, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))
        self.assertIs(s2, m.getStudent(1))
        self.assertIs(s3, m.getStudent(2))
        self.assertIsNone(s4)

    # testbed/test/cruise/associations/OneToOptionalNTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorZ.MentorZ("blah")
        m2 = MentorZ.MentorZ("blah2")
        s = m.addStudent(123)
        s2 = m2.addStudent(125)
        self.assertIs(True, s.setMentor(m2))
        self.assertIs(m2, s.getMentor())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(s2, m2.getStudent(0))
        self.assertIs(s, m2.getStudent(1))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToOptionalNTest.java: addToNewMentor
    def test_addToNewMentor(self):
        m = MentorZ.MentorZ("blah")
        m2 = MentorZ.MentorZ("blah2")
        s = m.addStudent(123)
        m2.addStudent(s)
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToOptionalNTest.java: removeFromExistingMentor
    def test_removeFromExistingMentor(self):
        m = MentorZ.MentorZ("blah")
        m2 = MentorZ.MentorZ("blah2")
        s1 = m.addStudent(123)
        s2 = m.addStudent(124)
        s3 = m.addStudent(125)
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

    # testbed/test/cruise/associations/OneToOptionalNTest.java: setMentorReplacesExistingMentor
    def test_setMentorReplacesExistingMentor(self):
        m = MentorZ.MentorZ("blah")
        s = StudentZ.StudentZ(99, m)
        m2 = MentorZ.MentorZ("blah2")
        s.setMentor(m2)
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToOptionalNTest.java: addStudentWhenMentorHasTooMany
    def test_addStudentWhenMentorHasTooMany(self):
        m = MentorZ.MentorZ("blah")
        m2 = MentorZ.MentorZ("blah2")
        m.addStudent(12)
        m.addStudent(13)
        m.addStudent(14)
        m2.addStudent(21)
        m2.addStudent(22)
        s = m2.addStudent(23)
        self.assertIs(False, m.addStudent(s))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(3, m2.numberOfStudents())
