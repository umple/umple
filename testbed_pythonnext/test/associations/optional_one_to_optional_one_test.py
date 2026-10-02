import unittest

from ImportModules import importModules

importModules(["MentorA", "StudentA"], ["associations"])
from ImportModules import *


class OptionalOneToOptionalOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/OptionalOneToOptionalOneTest.java: Constructor
    def test_Constructor(self):
        mentor = MentorA.MentorA()
        student = StudentA.StudentA()
        self.assertIsNone(mentor.getStudent())
        self.assertIsNone(student.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOptionalOneTest.java: NewRelationshipReplaceExisting
    def test_NewRelationshipReplaceExisting(self):
        m1 = MentorA.MentorA()
        sA = StudentA.StudentA()
        m2 = MentorA.MentorA()
        sB = StudentA.StudentA()
        m1.setStudent(sA)
        m2.setStudent(sB)
        self.assertIs(sA, m1.getStudent())
        self.assertIs(m1, sA.getMentor())
        self.assertIs(sB, m2.getStudent())
        self.assertIs(m2, sB.getMentor())
        m2.setStudent(sA)
        self.assertIs(sA, m2.getStudent())
        self.assertIs(m2, sA.getMentor())
        self.assertIsNone(m1.getStudent())
        self.assertIsNone(sB.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOptionalOneTest.java: NewRelationshipWhenNm1Existed
    def test_NewRelationshipWhenNm1Existed(self):
        m1 = MentorA.MentorA()
        sA = StudentA.StudentA()
        m2 = MentorA.MentorA()
        m1.setStudent(sA)
        m2.setStudent(sA)
        self.assertIs(sA, m2.getStudent())
        self.assertIs(m2, sA.getMentor())
        self.assertIsNone(m1.getStudent())

    # testbed/test/cruise/associations/OptionalOneToOptionalOneTest.java: RemoveRelationship
    def test_RemoveRelationship(self):
        m1 = MentorA.MentorA()
        sA = StudentA.StudentA()
        m1.setStudent(sA)
        m1.setStudent(None)
        self.assertIsNone(m1.getStudent())
        self.assertIsNone(sA.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOptionalOneTest.java: RemoveRelationshipThatNeverWas
    def test_RemoveRelationshipThatNeverWas(self):
        m1 = MentorA.MentorA()
        m1.setStudent(None)
        self.assertIsNone(m1.getStudent())

    # testbed/test/cruise/associations/OptionalOneToOptionalOneTest.java: DeleteRelationship
    def test_DeleteRelationship(self):
        m1 = MentorA.MentorA()
        sA = StudentA.StudentA()
        m1.setStudent(sA)
        m1.delete()
        self.assertIsNone(m1.getStudent())
        self.assertIsNone(sA.getMentor())

    # testbed/test/cruise/associations/OptionalOneToOptionalOneTest.java: DeleteRelationshipThatNeverExisted
    def test_DeleteRelationshipThatNeverExisted(self):
        m1 = MentorA.MentorA()
        sA = StudentA.StudentA()
        m1.delete()
        self.assertIsNone(m1.getStudent())
        self.assertIsNone(sA.getMentor())
