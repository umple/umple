import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorC", "StudentC"], ["associations"])
from ImportModules import *


class OptionalOneToManyTest(unittest.TestCase):
    def test_createStudentWithoutMentor(self):
        s = StudentC.StudentC(99)
        self.assertEqual(None, s.getMentor())

    def test_addStudent(self):
        m = MentorC.MentorC("m1")
        s = StudentC.StudentC(99)
        m.addStudent(s)

        self.assertEqual(1, m.numberOfStudents())
        self.assertEqual(m, s.getMentor())
        self.assertEqual(s, m.getStudent(0))

    def test_replaceMentor(self):
        m = MentorC.MentorC("m1")
        m2 = MentorC.MentorC("m2")

        s = StudentC.StudentC(99)
        m.addStudent(s)
        self.assertEqual(1, m.numberOfStudents())
        s.setMentor(m2)

        self.assertEqual(m2, s.getMentor())
        self.assertEqual(s, m2.getStudent(0))
        self.assertEqual(0, m.numberOfStudents())

    def test_addToNewMentor(self):
        m = MentorC.MentorC("m1")
        m2 = MentorC.MentorC("m2")
        s = StudentC.StudentC(99)

        m.addStudent(s)
        m2.addStudent(s)

        self.assertEqual(m2, s.getMentor())
        self.assertEqual(s, m2.getStudent(0))
        self.assertEqual(0, m.numberOfStudents())

    def test_removeFromExistingMentor(self):
        m = MentorC.MentorC("m1")
        m2 = MentorC.MentorC("m2")

        s1 = StudentC.StudentC(99)
        s2 = StudentC.StudentC(98)
        s3 = StudentC.StudentC(97)

        m.addStudent(s1)
        m.addStudent(s2)
        m.addStudent(s3)

        self.assertEqual(3, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())

        m2.addStudent(s1)

        self.assertEqual(2, m.numberOfStudents())
        self.assertEqual(s2, m.getStudent(0))
        self.assertEqual(s3, m.getStudent(1))

        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(s1, m2.getStudent(0))

        self.assertEqual(m2, s1.getMentor())
        self.assertEqual(m, s2.getMentor())
        self.assertEqual(m, s3.getMentor())

    def test_removeStudent(self):
        m = MentorC.MentorC("m1")
        s = StudentC.StudentC(99)

        m.addStudent(s)
        m.removeStudent(s)

        self.assertEqual(None, s.getMentor())
        self.assertEqual(0, m.numberOfStudents())

    def test_deleteMentor(self):
        m = MentorC.MentorC("m1")
        s1 = StudentC.StudentC(1)
        s2 = StudentC.StudentC(2)
        s3 = StudentC.StudentC(3)
        s1.setMentor(m)
        s2.setMentor(m)
        s3.setMentor(m)

        del m

        self.assertFalse(s1.getMentor() in locals())
        self.assertFalse(s2.getMentor() in locals())
        self.assertFalse(s3.getMentor() in locals())
