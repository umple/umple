import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["MentorB", "ProgramB", "StudentB"], ["associations"])
from ImportModules import *


class OptionalOneToOneTest(unittest.TestCase):
    def test_constructor(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)

        self.assertEqual(student, mentor.getStudent())
        self.assertEqual(mentor, student.getMentor())

    def test_cannotSetStudentBToNull(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)

        self.assertEqual(False, mentor.setStudent(None))

    @unittest.skip(".equals()")
    def test_setStudent(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)

        student2 = StudentB.StudentB()
        self.assertEqual(True, mentor.setStudent(student2))

        self.assertEqual(mentor, student2.getMentor())
        self.assertEqual(student2, mentor.getStudent())
        self.assertEqual(None, student.getMentor())

    def test_setMentorCannotReset(self):
        s = StudentB.StudentB()
        m = MentorB.MentorB(s)

        s2 = StudentB.StudentB()
        m2 = MentorB.MentorB(s2)

        self.assertEqual(False, m.setStudent(s2))
        self.assertEqual(m, s.getMentor())
        self.assertEqual(s, m.getStudent())
        self.assertEqual(m2, s2.getMentor())
        self.assertEqual(s2, m2.getStudent())

    @unittest.skip(".equals()")
    def test_setMentor(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)

        student2 = StudentB.StudentB()
        student2.setMentor(mentor)

        self.assertEqual(mentor, student2.getMentor())
        self.assertEqual(student2, mentor.getStudent())
        self.assertEqual(None, student.getMentor())

    def test_unableToConstructNewSubordinateFromExistingDriverThatAlreadyHasDriver(
        self,
    ):
        with self.assertRaises(RuntimeError):
            student = StudentB.StudentB()
            MentorB.MentorB(student)
            MentorB.MentorB(student)

    def test_deleteDriverRemovesSubordinate(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)
        program = ProgramB.ProgramB()
        mentor.setProgram(program)

        del student
        self.assertFalse(mentor.getStudent() in locals())
        self.assertFalse(mentor.getProgram() in locals())

    def test_deleteSubordinateKeepDriver(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)
        program = ProgramB.ProgramB()
        student.setProgram(program)

        del mentor
        self.assertFalse(student.getMentor() in locals())
        self.assertEqual(program, student.getProgram())
