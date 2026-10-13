import unittest

from ImportModules import importModules

importModules(["MentorAK", "ProgramAK", "StudentAK"], ["associations"])
from ImportModules import *


class UnidirectionalNTest(unittest.TestCase):
    # testbed/test/cruise/associations/UnidirectionalNTest.java: constructorEmpty
    def test_constructorEmpty(self):
        m = MentorAK.MentorAK("blah")
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/UnidirectionalNTest.java: setTooMany
    def test_setTooMany(self):
        s = StudentAK.StudentAK(99)
        s2 = StudentAK.StudentAK(98)
        s3 = StudentAK.StudentAK(97)
        s4 = StudentAK.StudentAK(96)
        m = MentorAK.MentorAK("blah")
        self.assertIs(False, m.setStudents(s, s2, s3, s4))
        self.assertEqual(0, m.numberOfStudents())

    # testbed/test/cruise/associations/UnidirectionalNTest.java: setStudents
    def test_setStudents(self):
        s = StudentAK.StudentAK(99)
        s2 = StudentAK.StudentAK(98)
        s3 = StudentAK.StudentAK(97)
        s4 = StudentAK.StudentAK(97)
        m = MentorAK.MentorAK("blah")
        self.assertIs(False, m.setStudents(s, s2, s3, s4))
        self.assertIs(False, m.setStudents(s, s2, s2))
        self.assertIs(True, m.setStudents(s, s2))
        self.assertEqual(2, m.numberOfStudents())

    # testbed/test/cruise/associations/UnidirectionalNTest.java: deleteDoesNotChangeStudent
    def test_deleteDoesNotChangeStudent(self):
        s = StudentAK.StudentAK(99)
        s2 = StudentAK.StudentAK(98)
        s3 = StudentAK.StudentAK(97)
        p = ProgramAK.ProgramAK()
        s.setProgram(p)
        m = MentorAK.MentorAK("blah")
        m.setStudents(s, s2, s3)
        m.delete()
        self.assertEqual(0, m.numberOfStudents())
        self.assertIs(p, s.getProgram())