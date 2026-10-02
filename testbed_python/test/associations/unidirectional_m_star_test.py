import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorAL", "ProgramAL", "StudentAL"], ["associations"])
from ImportModules import *

class UnidirectionalMStarTest(unittest.TestCase):
    def test_constructorTooFew(self):
        s = StudentAL.StudentAL(99)
        s2 = StudentAL.StudentAL(98)
        with self.assertRaises(RuntimeError):
            MentorAL.MentorAL("blah",s,s2)
    
    def test_constructorRequiresMinimum(self):
        s = StudentAL.StudentAL(99)
        s2 = StudentAL.StudentAL(98)
        s3 = StudentAL.StudentAL(97)
        
        m = MentorAL.MentorAL("blah",s,s2,s3)
        self.assertEqual(3,m.numberOfStudents())
    
    def test_addRemoveWithinLimits(self):
        s = StudentAL.StudentAL(99)
        s2 = StudentAL.StudentAL(98)
        s3 = StudentAL.StudentAL(97)
        s4 = StudentAL.StudentAL(96)
        s5 = StudentAL.StudentAL(95)
        s6 = StudentAL.StudentAL(94)
        
        m = MentorAL.MentorAL("blah",s,s2,s3)
        self.assertEqual(3,m.numberOfStudents())
        self.assertEqual(True,m.addStudent(s4))
        self.assertEqual(True,m.addStudent(s5))
        
        self.assertEqual(5,m.numberOfStudents())
        
        self.assertEqual(False,m.removeStudent(s6))
        self.assertEqual(True,m.removeStudent(s3))
        self.assertEqual(True,m.removeStudent(s4))
        self.assertEqual(False,m.removeStudent(s))
        self.assertEqual(3,m.numberOfStudents())

    def test_deleteDoesNotChangeStudent(self):
        s = StudentAL.StudentAL(99)
        s2 = StudentAL.StudentAL(98)
        s3 = StudentAL.StudentAL(98)

        p = ProgramAL.ProgramAL()
        s.setProgram(p)
        
        m = MentorAL.MentorAL("blah",s,s2,s3)
        del m
        self.assertEqual(p,s.getProgram())
