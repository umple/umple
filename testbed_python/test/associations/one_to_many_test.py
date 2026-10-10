import unittest

from ImportModules import importModules

importModules(["Bus", "Commuter", "MentorJ", "Seating", "StudentJ"], ["associations"])
from ImportModules import *


class OneToManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToManyTest.java: cannotCreateNullStudent
    def test_cannotCreateNullStudent(self):
        with self.assertRaises(RuntimeError):
            StudentJ.StudentJ(99, None)

    # testbed/test/cruise/associations/OneToManyTest.java: CreateMentorWithoutStudent
    def test_CreateMentorWithoutStudent(self):
        m = MentorJ.MentorJ("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToManyTest.java: CreateStudentFromMentor
    def test_CreateStudentFromMentor(self):
        m = MentorJ.MentorJ("blah")
        s = StudentJ.StudentJ(99, m)
        self.assertEqual(99, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToManyTest.java: addStudentViaConstructorInformation
    def test_addStudentViaConstructorInformation(self):
        m = MentorJ.MentorJ("blah")
        s = m.addStudent(10)
        self.assertEqual(10, s.getNumber())
        self.assertIs(m, s.getMentor())
        self.assertEqual(1, m.numberOfStudents())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToManyTest.java: replaceMentor
    def test_replaceMentor(self):
        m = MentorJ.MentorJ("blah")
        m2 = MentorJ.MentorJ("blah2")
        s = m.addStudent(123)
        s2 = m2.addStudent(125)
        s.setMentor(m2)
        self.assertIs(m2, s.getMentor())
        self.assertEqual(2, m2.numberOfStudents())
        self.assertIs(s2, m2.getStudent(0))
        self.assertIs(s, m2.getStudent(1))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToManyTest.java: addToNewMentor
    def test_addToNewMentor(self):
        m = MentorJ.MentorJ("blah")
        m2 = MentorJ.MentorJ("blah2")
        s = m.addStudent(123)
        m2.addStudent(s)
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToManyTest.java: removeFromExistingMentor
    def test_removeFromExistingMentor(self):
        m = MentorJ.MentorJ("blah")
        m2 = MentorJ.MentorJ("blah2")
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

    # testbed/test/cruise/associations/OneToManyTest.java: cannotSetMentorNull
    def test_cannotSetMentorNull(self):
        m = MentorJ.MentorJ("blah")
        s = StudentJ.StudentJ(99, m)
        self.assertIs(False, s.setMentor(None))
        self.assertIs(m, s.getMentor())
        self.assertIs(s, m.getStudent(0))

    # testbed/test/cruise/associations/OneToManyTest.java: setMentorReplacesExistingMentor
    def test_setMentorReplacesExistingMentor(self):
        m = MentorJ.MentorJ("blah")
        s = StudentJ.StudentJ(99, m)
        m2 = MentorJ.MentorJ("blah2")
        s.setMentor(m2)
        self.assertIs(m2, s.getMentor())
        self.assertIs(s, m2.getStudent(0))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/OneToManyTest.java: deleteManyEnd
    def test_deleteManyEnd(self):
        m = MentorJ.MentorJ("blah")
        s1 = StudentJ.StudentJ(99, m)
        s2 = StudentJ.StudentJ(98, m)
        self.assertEqual(2, m.numberOfStudents())
        self.assertIs(m, s1.getMentor())
        self.assertIs(m, s2.getMentor())
        s1.delete()
        self.assertEqual(1, m.numberOfStudents())
        self.assertIsNone(s1.getMentor())
        self.assertIs(m, s2.getMentor())
        s2.delete()
        self.assertIsNone(s1.getMentor())
        self.assertIsNone(s2.getMentor())

    # testbed/test/cruise/associations/OneToManyTest.java: addDuplicate
    def test_addDuplicate(self):
        # Like the Java test, this passes when nothing raises
        b1 = Bus.Bus(24)
        c1 = Commuter.Commuter("Tom")
        c2 = Commuter.Commuter("Jan")
        s1 = Seating.Seating(b1, c2)
        s2 = Seating.Seating(b1, c2)
