import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorAH", "ProgramAH", "StudentAH"], ["associations"])
from ImportModules import *

class UnidirectionalOneTest(unittest.TestCase):
    def test_constructorManySide(self):
        s = StudentAH.StudentAH(1)
        m = MentorAH.MentorAH("a", s)
        self.assertEqual("a", m.getName())
        self.assertEqual(1, m.getStudent().getNumber())
    
    def test_constructorSetNull(self):
        with self.assertRaises(RuntimeError):
            MentorAH.MentorAH("a", None)
    
    def test_deleteLeavesStudentAlone(self):
      m = MentorAH.MentorAH("a", StudentAH.StudentAH(1))
      s = m.getStudent()
      p = ProgramAH.ProgramAH()
      s.setProgram(p)
      del m
      self.assertEqual(p, s.getProgram())
