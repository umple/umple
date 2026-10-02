import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorG", "ProgramG", "StudentG"], ["associations"])
from ImportModules import *


class OneToOneTest(unittest.TestCase):
    def test_constructorBuildsBoth(self):
        m = MentorG.MentorG("a", 1)
        self.assertEqual("a", m.getName())
        self.assertEqual(1, m.getStudent().getNumber())

    def test_constructorIfAlreadySet(self):
        with self.assertRaises(RuntimeError):
            m = MentorG.MentorG("a", 1)
            StudentG.StudentG.alternateConstructor(1, m)

    def test_constructorCannotSetNone(self):
        with self.assertRaises(RuntimeError):
            MentorG.MentorG.alternateConstructor("a", None)

    def test_delete(self):
        m = MentorG.MentorG("a", 1)
        s = m.getStudent()
        m.getStudent().setProgram(ProgramG.ProgramG())
        del m
        self.assertFalse(s.getMentor() in locals())
        self.assertFalse(s.getProgram() in locals())
