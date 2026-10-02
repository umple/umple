import unittest

from ImportModules import importModules

importModules(["MentorB", "ProgramB", "StudentB"], ["associations"])
from ImportModules import *


class OptionalOneToOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/OptionalOneToOneTest.java: Constructor
    def test_Constructor(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)
        self.assertIs(student, mentor.getStudent())
        self.assertIs(mentor, student.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOneTest.java: CannotSetStudentBToNull
    def test_CannotSetStudentBToNull(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)
        self.assertIs(False, mentor.setStudent(None))

    # testbed/test/cruise/associations/OptionalOneToOneTest.java: SetStudent
    def test_SetStudent(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)
        student2 = StudentB.StudentB()
        self.assertIs(True, mentor.setStudent(student2))
        self.assertIs(mentor, student2.getMentor())
        self.assertIs(student2, mentor.getStudent())
        self.assertIsNone(student.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOneTest.java: SetMentorCannotReset
    def test_SetMentorCannotReset(self):
        s = StudentB.StudentB()
        m = MentorB.MentorB(s)
        s2 = StudentB.StudentB()
        m2 = MentorB.MentorB(s2)
        self.assertIs(False, m.setStudent(s2))
        self.assertIs(m, s.getMentor())
        self.assertIs(s, m.getStudent())
        self.assertIs(m2, s2.getMentor())
        self.assertIs(s2, m2.getStudent())

    # testbed/test/cruise/associations/OptionalOneToOneTest.java: SetMentor
    def test_SetMentor(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)
        student2 = StudentB.StudentB()
        student2.setMentor(mentor)
        self.assertIs(mentor, student2.getMentor())
        self.assertIs(student2, mentor.getStudent())
        self.assertIsNone(student.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOneTest.java: UnableToConstructNewSubordinateFromExistingDriverThatAlreadyHasDriver
    def test_UnableToConstructNewSubordinateFromExistingDriverThatAlreadyHasDriver(self):
        student = StudentB.StudentB()
        MentorB.MentorB(student)
        with self.assertRaises(RuntimeError):
            MentorB.MentorB(student)

    # testbed/test/cruise/associations/OptionalOneToOneTest.java: DeleteDriverStudentHasNoMentor
    def test_DeleteDriverStudentHasNoMentor(self):
        student = StudentB.StudentB()
        student.delete()
        self.assertIsNone(student.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOneTest.java: DeleteDriverRemovesSubordinate
    def test_DeleteDriverRemovesSubordinate(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)
        program = ProgramB.ProgramB()
        mentor.setProgram(program)
        student.delete()
        self.assertIsNone(student.getMentor())
        self.assertIsNone(mentor.getStudent())
        self.assertIsNone(mentor.getProgram())

    # testbed/test/cruise/associations/OptionalOneToOneTest.java: DeleteSubordinateKeepDriver
    def test_DeleteSubordinateKeepDriver(self):
        student = StudentB.StudentB()
        mentor = MentorB.MentorB(student)
        program = ProgramB.ProgramB()
        student.setProgram(program)
        mentor.delete()
        self.assertIsNone(student.getMentor())
        self.assertIsNone(mentor.getStudent())
        self.assertIs(program, student.getProgram())
