import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorI", "ProgramI", "StudentI"], ["associations"])
from ImportModules import *

class UnidirectionalOptionalNTest(unittest.TestCase):
    def test_constructorTooFew(self):
        with self.assertRaises(RuntimeError):
            s = StudentI.StudentI(99)
            MentorI.MentorI("blah",s)

    def test_constructorTooMany(self):
        s = StudentI.StudentI(99)
        s2 = StudentI.StudentI(98)
        s3 = StudentI.StudentI(97)
        s4 = StudentI.StudentI(96)
        s5 = StudentI.StudentI(96)

        with self.assertRaises(RuntimeError):
            MentorI.MentorI("blah",s,s2,s3,s4,s5)

    def test_constructorRequiresMinimumToMaximum(self):
        s = StudentI.StudentI(99)
        s2 = StudentI.StudentI(98)
        s3 = StudentI.StudentI(97)
        s4 = StudentI.StudentI(96)
        
        m = MentorI.MentorI("blah",s,s2)
        self.assertEqual(2,m.numberOfStudents())

        m2 = MentorI.MentorI("blah2",s,s2,s3,s4)
        self.assertEqual(4,m2.numberOfStudents())

    def test_addRemoveWithinLimits(self):
        s = StudentI.StudentI(99)
        s2 = StudentI.StudentI(98)
        s3 = StudentI.StudentI(97)
        s4 = StudentI.StudentI(96)
        s5 = StudentI.StudentI(95)
        
        m = MentorI.MentorI("blah",s,s2)
        self.assertEqual(2,m.numberOfStudents())
        self.assertEqual(True,m.addStudent(s3))
        self.assertEqual(True,m.addStudent(s4))
        self.assertEqual(False,m.addStudent(s4))
        
        self.assertEqual(4,m.numberOfStudents())
        
        self.assertEqual(False,m.removeStudent(s5))
        self.assertEqual(True,m.removeStudent(s3))
        self.assertEqual(True,m.removeStudent(s4))
        self.assertEqual(False,m.removeStudent(s))
        self.assertEqual(2,m.numberOfStudents())

    def test_deleteDoesNotChangeStudent(self):
        s = StudentI.StudentI(99)
        s2 = StudentI.StudentI(98)

        p = ProgramI.ProgramI()
        s.setProgram(p)
        
        m = MentorI.MentorI("blah",s,s2)
        del m
        self.assertEqual(p,s.getProgram())
