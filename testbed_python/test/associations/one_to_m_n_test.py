import unittest

from ImportModules import importModules

importModules(["MentorK", "StudentK"], ["associations"])
from ImportModules import *


class OneToMNTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToMNTest.java: cannotCreateNullStudent
    def test_cannotCreateNullStudent(self):
        with self.assertRaises(RuntimeError):
            StudentK.StudentK(99, None)

    # testbed/test/cruise/associations/OneToMNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorK.MentorK("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMNTest.java: CannotSetMentorNull
    def test_CannotSetMentorNull(self):
        m = MentorK.MentorK("blah")
        s = StudentK.StudentK(99, m)
        self.assertIs(False, s.setMentor(None))
        self.assertIs(m, s.getMentor())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToMNTest.java: CannotSetMentorAlreadyAtMax
    def test_CannotSetMentorAlreadyAtMax(self):
        m = MentorK.MentorK("blah")
        m2 = MentorK.MentorK("blah2")
        StudentK.StudentK(99, m)
        StudentK.StudentK(99, m)
        StudentK.StudentK(99, m)
        StudentK.StudentK(99, m2)
        StudentK.StudentK(99, m2)
        s = StudentK.StudentK(99, m2)
        self.assertIs(False, s.setMentor(m))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(3, m2.numberOfStudents())
        self.assertIs(m2, s.getMentor())

    # testbed/test/cruise/associations/OneToMNTest.java: CannotSetMentorExistingAtMin
    def test_CannotSetMentorExistingAtMin(self):
        m = MentorK.MentorK("blah")
        m2 = MentorK.MentorK("blah2")
        StudentK.StudentK(99, m)
        StudentK.StudentK(99, m)
        StudentK.StudentK(99, m2)
        s = StudentK.StudentK(99, m2)
        self.assertIs(False, s.setMentor(m))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(m2, s.getMentor())

    # testbed/test/cruise/associations/OneToMNTest.java: CreateStudentFromMentor
    def test_CreateStudentFromMentor(self):
        m = MentorK.MentorK("blah")
        s = StudentK.StudentK(99, m)
        self.assertEqual(99, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToMNTest.java: addStudentViaConstructorInformation
    def test_addStudentViaConstructorInformation(self):
        m = MentorK.MentorK("blah")
        s = m.addStudent(10)
        self.assertEqual(10, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToMNTest.java: addStudentViaConstructorInformationTooMany
    def test_addStudentViaConstructorInformationTooMany(self):
        m = MentorK.MentorK("blah")
        m.addStudent(10)
        m.addStudent(11)
        m.addStudent(12)
        self.assertIsNone(m.addStudent(13))

    # testbed/test/cruise/associations/OneToMNTest.java: createStudentWhenMentorAlreadyHasEnogh
    def test_createStudentWhenMentorAlreadyHasEnogh(self):
        m = MentorK.MentorK("blah")
        StudentK.StudentK(10, m)
        StudentK.StudentK(10, m)
        StudentK.StudentK(10, m)
        with self.assertRaises(RuntimeError):
            StudentK.StudentK(10, m)

    # testbed/test/cruise/associations/OneToMNTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorK.MentorK("blah")
        m2 = MentorK.MentorK("blah2")
        s = m.addStudent(123)
        m.addStudent(125)
        m.addStudent(126)
        s2 = m2.addStudent(124)
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertIs(True, s.setMentor(m2))
        self.assertIs(m2, s.getMentor())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(s2, m2.getStudent(0))
        self.assertIs(s, m2.getStudent(1))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMNTest.java: addToNewMentor
    def test_addToNewMentor(self):
        m = MentorK.MentorK("blah")
        m2 = MentorK.MentorK("blah2")
        s = m.addStudent(123)
        m.addStudent(124)
        m.addStudent(125)
        self.assertIs(True, m2.addStudent(s))
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMNTest.java: removeFromExistingMentor
    def test_removeFromExistingMentor(self):
        m = MentorK.MentorK("blah")
        m2 = MentorK.MentorK("blah2")
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

    # testbed/test/cruise/associations/OneToMNTest.java: setMentorReplacesExistingMentor
    def test_setMentorReplacesExistingMentor(self):
        m = MentorK.MentorK("blah")
        s = StudentK.StudentK(99, m)
        StudentK.StudentK(98, m)
        StudentK.StudentK(97, m)
        m2 = MentorK.MentorK("blah2")
        self.assertIs(True, s.setMentor(m2))
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMNTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorK.MentorK("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        StudentK.StudentK(99, m)
        self.assertIs(False, m.isNumberOfStudentsValid())
        StudentK.StudentK(99, m)
        self.assertIs(True, m.isNumberOfStudentsValid())
        StudentK.StudentK(99, m)
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/OneToMNTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(2, MentorK.MentorK.minimumNumberOfStudents())
        self.assertEqual(3, MentorK.MentorK.maximumNumberOfStudents())

    # testbed/test/cruise/associations/OneToMNTest.java: addStudentWhenMentorHasTooMany
    def test_addStudentWhenMentorHasTooMany(self):
        m = MentorK.MentorK("blah")
        m2 = MentorK.MentorK("blah2")
        m.addStudent(12)
        m.addStudent(13)
        m.addStudent(14)
        m2.addStudent(21)
        m2.addStudent(22)
        s = m2.addStudent(23)
        self.assertIs(False, m.addStudent(s))
        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(3, m2.numberOfStudents())

    # testbed/test/cruise/associations/OneToMNTest.java: addStudentWhenMentorHasTooFew
    def test_addStudentWhenMentorHasTooFew(self):
        m = MentorK.MentorK("blah")
        m2 = MentorK.MentorK("blah2")
        m.addStudent(12)
        m.addStudent(13)
        m2.addStudent(21)
        s = m2.addStudent(23)
        self.assertIs(False, m.addStudent(s))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
