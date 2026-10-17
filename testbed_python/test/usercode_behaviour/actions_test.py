import unittest

from ImportModules import importModules

importModules(["GuardHelper", "PythonActions"], ["usercode", "behaviour"])
from ImportModules import *

# Language-tagged code in state machines.


class ActionsTest(unittest.TestCase):
    # a Python transition action runs as written
    def test_pythonActionRuns(self):
        x = PythonActions.PythonActions()
        self.assertIs(True, x.go())
        self.assertEqual(7, x.getN())
        self.assertEqual("B", x.getSmFullName())

    # a multi-line Python action keeps its suite
    def test_pythonActionBlockRuns(self):
        x = PythonActions.PythonActions()
        self.assertIs(True, x.block())
        self.assertEqual(8, x.getN())

    # a Java-only action is left out and the transition still fires
    def test_javaOnlyActionLeftOut(self):
        x = PythonActions.PythonActions()
        self.assertIs(True, x.javaOnly())
        self.assertEqual("B", x.getSmFullName())
        self.assertEqual(0, x.getN())

    def test_pythonEntryAndExitActions(self):
        x = PythonActions.PythonActions()
        x.entryExit()
        self.assertEqual(10, x.getN())
        x.reset()
        self.assertEqual(110, x.getN())
        self.assertEqual("A", x.getSmFullName())

    # a guard may call a Python helper method
    def test_guardCallsHelperMethod(self):
        x = GuardHelper.GuardHelper()
        self.assertIs(False, x.go())
        x.setAllowed(True)
        self.assertIs(True, x.go())
        self.assertEqual("B", x.getSmFullName())
