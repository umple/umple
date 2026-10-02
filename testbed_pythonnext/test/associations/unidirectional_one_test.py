import unittest

from ImportModules import importModules

importModules(["MentorAH", "ProgramAH", "StudentAH"], ["associations"])
from ImportModules import *


class UnidirectionalOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/UnidirectionalOneTest.java: ConstructorManySide
    def test_ConstructorManySide(self):
        s = StudentAH.StudentAH(1)
        m = MentorAH.MentorAH("a", s)
        self.assertEqual("a", m.getName())
        self.assertEqual(1, m.getStudent().getNumber())

    # testbed/test/cruise/associations/UnidirectionalOneTest.java: ConstructorSetNull
    def test_ConstructorSetNull(self):
        with self.assertRaises(RuntimeError):
            MentorAH.MentorAH("a", None)

    # testbed/test/cruise/associations/UnidirectionalOneTest.java: deleteLeavesStudentAlone
    def test_deleteLeavesStudentAlone(self):
        m = MentorAH.MentorAH("a", StudentAH.StudentAH(1))
        s = m.getStudent()
        p = ProgramAH.ProgramAH()
        s.setProgram(p)
        m.delete()
        self.assertIsNone(m.getStudent())
        self.assertIsNone(m.getProgram())
        self.assertIs(p, s.getProgram())
