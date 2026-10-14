import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(
    ["CourseB", "CourseS", "ExitActionSelfTransition"], ["statemachine", "test"]
)
from ImportModules import *


class EntryAndExitActionTest(unittest.TestCase):
    def test_EntryCalledOnConstructorForDefault(self):
        course = CourseB.CourseB()
        self.assertEqual("entry called", course.getLog())

    def test_CallEntry(self):
        course = CourseB.CourseB()
        course.anEvent()
        course.anEvent()
        self.assertEqual(CourseB.CourseB.Status.Open, course.getStatus())
        self.assertEqual("entry called", course.getLog())

    def test_CallExit(self):
        course = CourseB.CourseB()
        course.anEvent()
        self.assertEqual(CourseB.CourseB.Status.Closed, course.getStatus())
        self.assertEqual("exit called", course.getLog())

        course.anEvent()
        self.assertEqual(CourseB.CourseB.Status.Open, course.getStatus())
        self.assertEqual("entry called", course.getLog())

    def test_CallMultipleEntryExit(self):
        course = CourseS.CourseS()

        self.assertEqual("Enter Off 1", course.getLog(0))
        self.assertEqual("Enter Off 2", course.getLog(1))

        course.flip()
        self.assertEqual("Exit Off 1", course.getLog(2))
        self.assertEqual("Exit Off 2", course.getLog(3))

    def test_ExitActionSelfTransition(self):
        sm = ExitActionSelfTransition.ExitActionSelfTransition()
        self.assertEqual(
            ExitActionSelfTransition.ExitActionSelfTransition.Sm.created, sm.getSm()
        )
        sm.init()
        self.assertEqual(
            ExitActionSelfTransition.ExitActionSelfTransition.Sm.created, sm.getSm()
        )
        self.assertTrue(sm.getExitCodeCalled())
