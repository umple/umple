import unittest

from ImportModules import importModules

importModules(["MentorL", "StudentL"], ["associations"])
from ImportModules import *


class OneToNTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToNTest.java: cannotCreateNullStudent
    def test_cannotCreateNullStudent(self):
        with self.assertRaises(RuntimeError):
            StudentL.StudentL(99, None)

    # testbed/test/cruise/associations/OneToNTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorL.MentorL("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToNTest.java: CannotSetMentorNull
    def test_CannotSetMentorNull(self):
        m = MentorL.MentorL("blah")
        s = StudentL.StudentL(99, m)
        self.assertIs(False, s.setMentor(None))

    # testbed/test/cruise/associations/OneToNTest.java: CannotSetMentorAlreadyAtMax
    def test_CannotSetMentorAlreadyAtMax(self):
        m = MentorL.MentorL("blah")
        m2 = MentorL.MentorL("blah2")
        StudentL.StudentL(99, m)
        StudentL.StudentL(99, m)
        StudentL.StudentL(99, m2)
        s = StudentL.StudentL(99, m2)
        self.assertIs(False, s.setMentor(m))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(m2, s.getMentor())

    # testbed/test/cruise/associations/OneToNTest.java: CannotSetMentorExistingAtMin
    def test_CannotSetMentorExistingAtMin(self):
        m = MentorL.MentorL("blah")
        m2 = MentorL.MentorL("blah2")
        StudentL.StudentL(99, m)
        StudentL.StudentL(99, m)
        StudentL.StudentL(99, m2)
        s = StudentL.StudentL(99, m2)
        self.assertIs(False, s.setMentor(m))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(m2, s.getMentor())

    # testbed/test/cruise/associations/OneToNTest.java: CreateStudentFromMentor
    def test_CreateStudentFromMentor(self):
        m = MentorL.MentorL("blah")
        s = StudentL.StudentL(99, m)
        self.assertEqual(99, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToNTest.java: addStudentViaConstructorInformation
    def test_addStudentViaConstructorInformation(self):
        m = MentorL.MentorL("blah")
        s = m.addStudent(10)
        self.assertEqual(10, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToNTest.java: addStudentViaConstructorInformation_tooMany
    def test_addStudentViaConstructorInformation_tooMany(self):
        m = MentorL.MentorL("blah")
        m.addStudent(10)
        m.addStudent(11)
        m.addStudent(12)
        self.assertIsNone(m.addStudent(13))

    # testbed/test/cruise/associations/OneToNTest.java: createStudentWhenMentorAlreadyHasEnogh
    def test_createStudentWhenMentorAlreadyHasEnogh(self):
        m = MentorL.MentorL("blah")
        StudentL.StudentL(10, m)
        StudentL.StudentL(10, m)
        # The mentor takes exactly two students, so the third throws (Java never reaches the fourth)
        with self.assertRaises(RuntimeError):
            StudentL.StudentL(10, m)

    # testbed/test/cruise/associations/OneToNTest.java: cannotReplaceMentor
    def test_cannotReplaceMentor(self):
        m = MentorL.MentorL("blah")
        m2 = MentorL.MentorL("blah2")
        s = m.addStudent(123)
        m2.addStudent(125)
        self.assertIs(False, s.setMentor(m2))
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(1, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToNTest.java: cannotReassign
    def test_cannotReassign(self):
        m = MentorL.MentorL("blah")
        m2 = MentorL.MentorL("blah2")
        s = m.addStudent(123)
        self.assertIs(False, m2.addStudent(s))

    # testbed/test/cruise/associations/OneToNTest.java: cannotRemoveFromExistingMentor
    def test_cannotRemoveFromExistingMentor(self):
        m = MentorL.MentorL("blah")
        m2 = MentorL.MentorL("blah2")
        s1 = m.addStudent(123)
        m.addStudent(124)
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())
        self.assertIs(False, m2.addStudent(s1))

    # testbed/test/cruise/associations/OneToNTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorL.MentorL("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        StudentL.StudentL(99, m)
        self.assertIs(False, m.isNumberOfStudentsValid())
        StudentL.StudentL(99, m)
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/OneToNTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(2, MentorL.MentorL.minimumNumberOfStudents())
        self.assertEqual(2, MentorL.MentorL.maximumNumberOfStudents())

    # testbed/test/cruise/associations/OneToNTest.java: addStudentWhenMentorHasTooMany
    def test_addStudentWhenMentorHasTooMany(self):
        m = MentorL.MentorL("blah")
        m2 = MentorL.MentorL("blah2")
        m.addStudent(12)
        m.addStudent(13)
        m2.addStudent(21)
        m2.addStudent(22)
        s = m2.addStudent(23)
        self.assertIs(False, m.addStudent(s))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())

    # testbed/test/cruise/associations/OneToNTest.java: addStudentWhenMentorHasTooFew
    def test_addStudentWhenMentorHasTooFew(self):
        m = MentorL.MentorL("blah")
        m2 = MentorL.MentorL("blah2")
        m.addStudent(12)
        m.addStudent(13)
        m2.addStudent(21)
        s = m2.addStudent(23)
        self.assertIs(False, m.addStudent(s))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
