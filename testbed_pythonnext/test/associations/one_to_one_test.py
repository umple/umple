import unittest

from ImportModules import importModules

importModules(["MentorG", "ProgramG", "StudentG"], ["associations"])
from ImportModules import *


class OneToOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/OneToOneTest.java: ConstructorBuildsBoth
    def test_ConstructorBuildsBoth(self):
        m = MentorG.MentorG("a", 1)
        self.assertEqual("a", m.getName())
        self.assertEqual(1, m.getStudent().getNumber())

    # testbed/test/cruise/associations/OneToOneTest.java: ConstructorIfAlreadySet
    def test_ConstructorIfAlreadySet(self):
        m = MentorG.MentorG("a", 1)
        with self.assertRaises(RuntimeError):
            StudentG.StudentG.alternateConstructor(1, m)

    # testbed/test/cruise/associations/OneToOneTest.java: ConstructorCannotSetNull
    def test_ConstructorCannotSetNull(self):
        with self.assertRaises(RuntimeError):
            MentorG.MentorG.alternateConstructor("a", None)

    # testbed/test/cruise/associations/OneToOneTest.java: delete
    def test_delete(self):
        m = MentorG.MentorG("a", 1)
        s = m.getStudent()
        m.getStudent().setProgram(ProgramG.ProgramG())
        m.delete()
        self.assertIsNone(m.getStudent())
        self.assertIsNone(m.getProgram())
        self.assertIsNone(s.getMentor())
        self.assertIsNone(s.getProgram())
