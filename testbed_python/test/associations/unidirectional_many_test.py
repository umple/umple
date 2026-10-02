import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorP", "StudentP"], ["associations"])
from ImportModules import *


class UnidirectionalManyTest(unittest.TestCase):
    def test_addStudent(self):
        m = MentorP.MentorP("blah")
        s = StudentP.StudentP(1)
        m.addStudent(s)
        self.assertEqual(s, m.getStudent(0))

    def test_addSameStudent(self):
        m = MentorP.MentorP("blah")
        s = StudentP.StudentP(1)
        
        self.assertEqual(True,m.addStudent(s))
        self.assertEqual(False,m.addStudent(s))

        self.assertEqual(1, m.numberOfStudents())
        self.assertEqual(s, m.getStudent(0))

    def removeStudent(self):
        m = MentorP.MentorP("blah")
        s = StudentP.StudentP(1)
        
        self.assertEqual(True,m.addStudent(s))
        self.assertEqual(True,m.removeStudent(s))
        self.assertEqual(False,m.removeStudent(s))
        self.assertEqual(0, m.numberOfStudents())
   
    def test_addMultipleMentors(self):
        m = MentorP.MentorP("blah")
        m2 = MentorP.MentorP("blah2")

        s = StudentP.StudentP(99)
        self.assertEqual(0, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())

        m.addStudent(s)
        
        self.assertEqual(1, m.numberOfStudents())
        self.assertEqual(0, m2.numberOfStudents())

        m2.addStudent(s)

        self.assertEqual(1, m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())

        self.assertEqual(s, m.getStudent(0))
        self.assertEqual(s, m2.getStudent(0))

    def test_deleteDoesNotRemoveStudentsFromMentors(self):
        m = MentorP.MentorP("blah")
        m2 = MentorP.MentorP("blah2")
        m3 = MentorP.MentorP("blah3")
        
        s = StudentP.StudentP(99)
        s2 = StudentP.StudentP(98)
        s3 = StudentP.StudentP(97)
        
        m.addStudent(s)
        m.addStudent(s2)
        
        m2.addStudent(s)
        m3.addStudent(s3)
        
        del s
        
        self.assertEqual(2,m.numberOfStudents())
        self.assertEqual(1, m2.numberOfStudents())
        self.assertEqual(1, m3.numberOfStudents())
