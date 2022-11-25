import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorAI", "ProgramAI", "StudentAI"], ["associations"])
from ImportModules import *

class UnidirectionalOptionalOneTest(unittest.TestCase):
    def test_setStudent(self):
        s = StudentAI.StudentAI(1)
        m = MentorAI.MentorAI("a")
        self.assertEqual("a",m.getName())
        #self.assertEqual(None, m.getStudent())

        m.setStudent(s)
        self.assertEqual(s,m.getStudent())
        self.assertEqual(1, m.getStudent().getNumber())

    def test_deleteLeavesStudentAlone(self):
        m = MentorAI.MentorAI("a")
        s = StudentAI.StudentAI(1)
        m.setStudent(s)
        p = ProgramAI.ProgramAI()
        s.setProgram(p)

        del m
        self.assertEqual(p, s.getProgram())
