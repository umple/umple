import unittest

from ImportModules import importModules

importModules(["MentorAI", "ProgramAI", "StudentAI"], ["associations"])
from ImportModules import *


class UnidirectionalOptionalOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/UnidirectionalOptionalOneTest.java: setStudent
    def test_setStudent(self):
        s = StudentAI.StudentAI(1)
        m = MentorAI.MentorAI("a")
        self.assertEqual("a", m.getName())
        self.assertIsNone(m.getStudent())
        m.setStudent(s)
        self.assertIs(s, m.getStudent())
        self.assertEqual(1, m.getStudent().getNumber())

    # testbed/test/cruise/associations/UnidirectionalOptionalOneTest.java: deleteLeavesStudentAlone
    def test_deleteLeavesStudentAlone(self):
        m = MentorAI.MentorAI("a")
        s = StudentAI.StudentAI(1)
        m.setStudent(s)
        p = ProgramAI.ProgramAI()
        s.setProgram(p)
        m.delete()
        self.assertIsNone(m.getStudent())
        self.assertIsNone(m.getProgram())
        self.assertIs(p, s.getProgram())
