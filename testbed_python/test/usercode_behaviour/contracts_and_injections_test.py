import unittest

from ImportModules import importModules

importModules(
    ["Contracts", "GeneratedMethodInjections", "InjectionChild", "UserMethodInjections"],
    ["usercode", "behaviour"],
)
from ImportModules import *

# Contracts and injections around user and generated methods.


class ContractsAndInjectionsTest(unittest.TestCase):
    # a precondition on a Python method is enforced
    def test_preconditionOnPythonMethod(self):
        x = Contracts.Contracts()
        self.assertEqual(1, x.positive(1))
        with self.assertRaises(RuntimeError):
            x.positive(0)

    def test_preconditionOnUntaggedMethod(self):
        x = Contracts.Contracts()
        self.assertEqual(1, x.positiveUntagged(1))
        with self.assertRaises(RuntimeError):
            x.positiveUntagged(0)

    # only the selected body's postcondition applies
    def test_postconditionOfSelectedBodyOnly(self):
        x = Contracts.Contracts()
        self.assertEqual(2, x.postPerLanguage(2))
        with self.assertRaises(RuntimeError):
            x.postPerLanguage(0)

    # the before code runs first, so the body returns the value it set
    def test_beforeInjectionOnUserMethod(self):
        x = UserMethodInjections.UserMethodInjections()
        self.assertEqual(9, x.withBefore())
        self.assertEqual(9, x.getN())

    # after code runs once the body has computed its return value (5), so the doubling does not
    # change what is returned
    def test_afterInjectionRunsAfterTheBody(self):
        x = UserMethodInjections.UserMethodInjections()
        self.assertEqual(5, x.withAfter())
        self.assertEqual(10, x.getN())

    # a wrapped body declared void still returns what the native code returns
    def test_wrappedVoidBodyKeepsItsResult(self):
        x = UserMethodInjections.UserMethodInjections()
        self.assertEqual(5, x.voidWithResult())
        self.assertEqual("before;", x.getLog())

    # wrapped overrides reach the parent through super()
    def test_wrappedOverrideCallsSuper(self):
        self.assertEqual("child:base", InjectionChild.InjectionChild().f())

    # injections on a generated setter run in order and keep their statements apart
    def test_injectionsOnGeneratedSetter(self):
        x = GeneratedMethodInjections.GeneratedMethodInjections()
        self.assertIs(True, x.setN(3))
        self.assertEqual(3, x.getN())
        self.assertEqual("before;after;again;", x.getLog())
