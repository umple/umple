import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorAK", "ProgramAK", "StudentAK"], ["associations"])
from ImportModules import *


class UnidirectionalNTest(unittest.TestCase):
    def constructorEmpty(self):
        m = MentorAK("blah")
        self.assertEqual(0,m.numberOfStudents())
  
    def setTooMany(self):
        s = StudentAK(99)
        s2 = StudentAK(98)
        s3 = StudentAK(97)
        s4 = StudentAK(96)
        
        m = MentorAK("blah")
        self.assertEqual(False,m.setStudents(s,s2,s3,s4))
        self.assertEqual(0, m.numberOfStudents())
  
    def setStudents(self):
        s = StudentAK(99)
        s2 = StudentAK(98)
        s3 = StudentAK(97)
        s4 = StudentAK(97)
        
        m = MentorAK("blah")
        
        self.assertEqual(False,m.setStudents(s,s2,s3,s4))
        self.assertEqual(False,m.setStudents(s,s2,s2))
        self.assertEqual(True,m.setStudents(s,s2))
        
        self.assertEqual(2,m.numberOfStudents())
  
    def deleteDoesNotChangeStudent(self):
        s = StudentAK(99)
        s2 = StudentAK(98)
        s3 = StudentAK(97)

        p = ProgramAK()
        s.setProgram(p)
        
        m = MentorAK("blah")
        m.setStudents(s,s2,s3)
        del m
        self.assertEqual(0,m.numberOfStudents())
        self.assertEqual(p,s.getProgram())
  