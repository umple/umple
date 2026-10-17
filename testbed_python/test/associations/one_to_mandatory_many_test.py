import unittest

from ImportModules import importModules

importModules(["MentorM", "StudentM"], ["associations"])
from ImportModules import *


class OneToMandatoryManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: cannotCreateNullStudent
    def test_cannotCreateNullStudent(self):
        with self.assertRaises(RuntimeError):
            StudentM.StudentM(99, None)

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorM.MentorM("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: CannotSetMentorNull
    def test_CannotSetMentorNull(self):
        m = MentorM.MentorM("blah")
        s = StudentM.StudentM(99, m)
        self.assertIs(False, s.setMentor(None))

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: CanAlwaysSetMentorNeverAtMax
    def test_CanAlwaysSetMentorNeverAtMax(self):
        m = MentorM.MentorM("blah")
        m2 = MentorM.MentorM("blah2")
        StudentM.StudentM(99, m)
        StudentM.StudentM(99, m)
        StudentM.StudentM(99, m)
        StudentM.StudentM(99, m2)
        StudentM.StudentM(99, m2)
        for i in range(1, 11):
            s = StudentM.StudentM(99, m2)
            self.assertIs(True, s.setMentor(m))
            self.assertEqual(2, m2.numberOfStudents())
            self.assertEqual(3 + i, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: CannotSetMentorExistingAtMin
    def test_CannotSetMentorExistingAtMin(self):
        m = MentorM.MentorM("blah")
        m2 = MentorM.MentorM("blah2")
        StudentM.StudentM(99, m)
        StudentM.StudentM(99, m)
        StudentM.StudentM(99, m2)
        s = StudentM.StudentM(99, m2)
        self.assertIs(False, s.setMentor(m))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(m2, s.getMentor())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: CreateStudentFromMentor
    def test_CreateStudentFromMentor(self):
        m = MentorM.MentorM("blah")
        s = StudentM.StudentM(99, m)
        self.assertEqual(99, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: addStudentViaConstructorInformation
    def test_addStudentViaConstructorInformation(self):
        m = MentorM.MentorM("blah")
        s = m.addStudent(10)
        self.assertEqual(10, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: addStudentViaConstructorInformation_neverTooMany
    def test_addStudentViaConstructorInformation_neverTooMany(self):
        m = MentorM.MentorM("blah")
        for i in range(1, 10):
            s = m.addStudent(i)
            self.assertIs(True, s is not None)
            self.assertEqual(i, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: createStudentMentoNeverHasEnough
    def test_createStudentMentoNeverHasEnough(self):
        m = MentorM.MentorM("blah")
        for i in range(1, 12):
            StudentM.StudentM(10, m)
            self.assertEqual(i, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: cannotReplaceMentorIfNotLeftWithoutEnoughStudents
    def test_cannotReplaceMentorIfNotLeftWithoutEnoughStudents(self):
        m = MentorM.MentorM("blah")
        m2 = MentorM.MentorM("blah2")
        s = m.addStudent(123)
        m2.addStudent(125)
        self.assertIs(False, s.setMentor(m2))

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorM.MentorM("blah")
        m2 = MentorM.MentorM("blah2")
        s = m.addStudent(123)
        m.addStudent(125)
        m.addStudent(124)
        s2 = m2.addStudent(122)
        self.assertIs(True, s.setMentor(m2))
        self.assertIs(m2, s.getMentor())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(s2, m2.getStudent(0))
        self.assertIs(s, m2.getStudent(1))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: addToNewMentor
    def test_addToNewMentor(self):
        m = MentorM.MentorM("blah")
        m2 = MentorM.MentorM("blah2")
        s = m.addStudent(123)
        m.addStudent(123)
        m.addStudent(123)
        self.assertIs(True, m2.addStudent(s))
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: removeFromExistingMentor
    def test_removeFromExistingMentor(self):
        m = MentorM.MentorM("blah")
        m2 = MentorM.MentorM("blah2")
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

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: setMentorReplacesExistingMentor
    def test_setMentorReplacesExistingMentor(self):
        m = MentorM.MentorM("blah")
        s = StudentM.StudentM(99, m)
        StudentM.StudentM(98, m)
        StudentM.StudentM(97, m)
        m2 = MentorM.MentorM("blah2")
        self.assertIs(True, s.setMentor(m2))
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: isNumberOfStudentsValid
    def test_isNumberOfStudentsValid(self):
        m = MentorM.MentorM("blah")
        self.assertIs(False, m.isNumberOfStudentsValid())
        StudentM.StudentM(99, m)
        self.assertIs(False, m.isNumberOfStudentsValid())
        StudentM.StudentM(99, m)
        self.assertIs(True, m.isNumberOfStudentsValid())
        StudentM.StudentM(99, m)
        self.assertIs(True, m.isNumberOfStudentsValid())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: getBoundsForStudent
    def test_getBoundsForStudent(self):
        self.assertEqual(2, MentorM.MentorM.minimumNumberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: addStudentMentorNeverHasTooMany
    def test_addStudentMentorNeverHasTooMany(self):
        m = MentorM.MentorM("blah")
        m2 = MentorM.MentorM("blah2")
        m.addStudent(12)
        m.addStudent(13)
        m.addStudent(14)
        m2.addStudent(21)
        m2.addStudent(22)
        s = m2.addStudent(23)
        self.assertIs(True, m.addStudent(s))
        self.assertEqual(4, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())

    # testbed/test/cruise/associations/OneToMandatoryManyTest.java: addStudentWhenMentorHasTooFew
    def test_addStudentWhenMentorHasTooFew(self):
        m = MentorM.MentorM("blah")
        m2 = MentorM.MentorM("blah2")
        m.addStudent(12)
        m.addStudent(13)
        m2.addStudent(21)
        s = m2.addStudent(23)
        self.assertIs(False, m.addStudent(s))
        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(2, m2.numberOfStudents())
