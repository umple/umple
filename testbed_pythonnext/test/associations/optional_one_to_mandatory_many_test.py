import unittest

from ImportModules import importModules

importModules(["MentorAR", "StudentAR"], ["associations"])
from ImportModules import *


class OptionalOneToMandatoryManyTest(unittest.TestCase):
    # testbed/test/cruise/associations/OptionalOneToMandatoryManyTest.java: TestA_InitMentorARIsNull
    def test_TestA_InitMentorARIsNull(self):
        S1 = StudentAR.StudentAR()
        S2 = StudentAR.StudentAR()
        S3 = StudentAR.StudentAR()
        self.assertIsNone(S1.getMentorAR())
        self.assertIsNone(S2.getMentorAR())
        self.assertIsNone(S3.getMentorAR())

    # testbed/test/cruise/associations/OptionalOneToMandatoryManyTest.java: TestB_MentorARCtorAcceptsStudentARAsArgumentProperly
    def test_TestB_MentorARCtorAcceptsStudentARAsArgumentProperly(self):
        S1 = StudentAR.StudentAR()
        M1 = MentorAR.MentorAR(S1)
        self.assertIs(M1, S1.getMentorAR())
        self.assertIs(S1, M1.getStudentAR(0))
        self.assertEqual(1, M1.numberOfStudentARs())
        idx = M1.indexOfStudentAR(S1)
        self.assertIs(True, idx >= 0 and idx < M1.numberOfStudentARs())

    # testbed/test/cruise/associations/OptionalOneToMandatoryManyTest.java: TestC_FromNullToValue
    def test_TestC_FromNullToValue(self):
        S1 = StudentAR.StudentAR()
        S2 = StudentAR.StudentAR()
        M1 = MentorAR.MentorAR(S1)
        self.assertIs(S1.getMentorAR(), M1)
        self.assertIsNone(S2.getMentorAR())
        S2.setMentorAR(M1)
        self.assertEqual(2, M1.numberOfStudentARs())
        self.assertIs(M1, S2.getMentorAR())

    # testbed/test/cruise/associations/OptionalOneToMandatoryManyTest.java: TestD_FailsWhenStudentARIsMandatory
    def test_TestD_FailsWhenStudentARIsMandatory(self):
        S1 = StudentAR.StudentAR()
        M1 = MentorAR.MentorAR(S1)
        self.assertIs(M1, S1.getMentorAR())
        self.assertIs(False, S1.setMentorAR(None))

    # testbed/test/cruise/associations/OptionalOneToMandatoryManyTest.java: TestE_SucceedsWhenStudentARIsNotMandatory
    def test_TestE_SucceedsWhenStudentARIsNotMandatory(self):
        S1 = StudentAR.StudentAR()
        S2 = StudentAR.StudentAR()
        M1 = MentorAR.MentorAR(S1)
        S2.setMentorAR(M1)
        self.assertEqual(2, M1.numberOfStudentARs())
        self.assertIs(True, S1.setMentorAR(None))

    # testbed/test/cruise/associations/OptionalOneToMandatoryManyTest.java: TestF_ChangingMentorARMovesStudentARFromListAndAddsToNewList
    def test_TestF_ChangingMentorARMovesStudentARFromListAndAddsToNewList(self):
        S1 = StudentAR.StudentAR()
        S2 = StudentAR.StudentAR()
        S3 = StudentAR.StudentAR()
        M1 = MentorAR.MentorAR(S1)
        M2 = MentorAR.MentorAR(S2)
        self.assertIs(True, S3.setMentorAR(M1))
        self.assertIs(M1, S1.getMentorAR())
        self.assertIs(M2, S2.getMentorAR())
        self.assertIs(M1, S3.getMentorAR())
        self.assertEqual(2, M1.numberOfStudentARs())
        self.assertEqual(1, M2.numberOfStudentARs())
        self.assertIs(True, S3.setMentorAR(M2))
        self.assertIs(M1, S1.getMentorAR())
        self.assertIs(M2, S2.getMentorAR())
        self.assertIs(M2, S3.getMentorAR())
        self.assertEqual(1, M1.numberOfStudentARs())
        self.assertEqual(2, M2.numberOfStudentARs())

    # testbed/test/cruise/associations/OptionalOneToMandatoryManyTest.java: TestG_WhenStudentARIsMandatoryChangeFails
    def test_TestG_WhenStudentARIsMandatoryChangeFails(self):
        S1 = StudentAR.StudentAR()
        S2 = StudentAR.StudentAR()
        M1 = MentorAR.MentorAR(S1)
        M2 = MentorAR.MentorAR(S2)
        self.assertIs(M1, S1.getMentorAR())
        self.assertIs(M2, S2.getMentorAR())
        self.assertEqual(1, M1.numberOfStudentARs())
        self.assertEqual(1, M2.numberOfStudentARs())
        self.assertIs(False, S1.setMentorAR(M2))
        self.assertIs(M1, S1.getMentorAR())
        self.assertIs(M2, S2.getMentorAR())
        self.assertEqual(1, M1.numberOfStudentARs())
        self.assertEqual(1, M2.numberOfStudentARs())

    # testbed/test/cruise/associations/OptionalOneToMandatoryManyTest.java: TestConsideration_OptionalOne_To_Mandatory_M_With_Maximum_N
    def test_TestConsideration_OptionalOne_To_Mandatory_M_With_Maximum_N(self):
        # The Java test only asserts true; its comment says this method must not be generated
        self.assertFalse(hasattr(MentorAR.MentorAR, "maximumNumberOfStudentARs"))
