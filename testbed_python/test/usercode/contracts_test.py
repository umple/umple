import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["UcContracts", "Base", "Derived", "Limited"], ["usercode", "test"])
from ImportModules import *


# UcContracts and injections on Python methods.
class ContractsTest(unittest.TestCase):
    def setUp(self):
        UcContracts.UcContracts.calls.clear()
        self.contracts = UcContracts.UcContracts()

    def test_preconditionAndPostconditionHold(self):
        self.assertEqual(5, self.contracts.half(10))

    def test_failedPrecondition(self):
        with self.assertRaises(RuntimeError) as raised:
            self.contracts.half(0)
        self.assertEqual("Please provide a valid x", str(raised.exception))

    def test_failedPostcondition(self):
        self.assertEqual(6, self.contracts.grow(3))
        with self.assertRaises(RuntimeError):
            self.contracts.grow(0)

    def test_staticMethodPrecondition(self):
        self.assertEqual(5, UcContracts.UcContracts.bounded(5))
        with self.assertRaises(RuntimeError):
            UcContracts.UcContracts.bounded(100)

    def test_preconditionComparingWithNull(self):
        self.assertIsNone(self.contracts.check("a"))
        with self.assertRaises(RuntimeError):
            self.contracts.check(None)

    def test_injectionsRunAroundTheBody(self):
        self.assertEqual(9, self.contracts.square(3))
        self.assertEqual(["before 3", "after"], UcContracts.UcContracts.calls)

    def test_afterInjectionRunsAfterAnEarlyReturn(self):
        self.assertEqual(0, self.contracts.square(-1))
        self.assertEqual(["before -1", "after"], UcContracts.UcContracts.calls)

    def test_preconditionReadsInheritedConstant(self):
        self.assertEqual(9, Limited.Limited().below(9))
        with self.assertRaises(RuntimeError):
            Limited.Limited().below(10)

    def test_generatorBodyIsCheckedWhenCalled(self):
        self.assertEqual([0, 2, 4], list(self.contracts.evens(5)))
        with self.assertRaises(RuntimeError):
            self.contracts.evens(-1)


# A subclass and its parent both wrap m; the child's body calls super().
class InheritedContractsTest(unittest.TestCase):
    def setUp(self):
        Base.Base.calls.clear()

    def test_eachWrapperRunsItsOwnBody(self):
        self.assertEqual(8, Derived.Derived().m(3))
        self.assertEqual(["derived", "base"], Base.Base.calls)

    def test_parentBody(self):
        self.assertEqual(3, Base.Base().m(2))
        self.assertEqual(["base"], Base.Base.calls)

    def test_eachClassChecksItsOwnPrecondition(self):
        with self.assertRaises(RuntimeError):
            Derived.Derived().m(20)
        with self.assertRaises(RuntimeError):
            Derived.Derived().m(-1)
        self.assertEqual(["derived"], Base.Base.calls)
