import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(
    ["CourseB", "CourseS", "ExitActionSelfTransition"], ["statemachine", "test"]
)
from ImportModules import *

import CourseB
import CourseS
import ExitActionSelfTransition


class EntryAndExitActionTest(unittest.TestCase):
    def EntryCalledOnConstructorForDefault(self):
        course = CourseB.CourseB()
        self.assertEquals("entry called", course.getLog())

    def CallEntry(self):
        course = CourseB.CourseB()
        course.anEvent()
        course.anEvent()
        self.assertEquals(CourseB.CourseB.Status.Open, course.getStatus())
        self.assertEquals("entry called", course.getLog())

    def CallExit(self):
        course = CourseB.CourseB()
        course.anEvent()
        self.assertEquals(CourseB.CourseB.Status.Closed, course.getStatus())
        self.assertEquals("exit called", course.getLog())

        course.anEvent()
        self.assertEquals(CourseB.CourseB.Status.Open, course.getStatus())
        self.assertEquals("entry called", course.getLog())

    def CallMultipleEntryExit(self):
        course = CourseS.CourseS()

        self.assertEquals("Enter Off 1", course.getLog(0))
        self.assertEquals("Enter Off 2", course.getLog(1))

        course.flip()
        self.assertEquals("Exit Off 1", course.getLog(2))
        self.assertEquals("Exit Off 2", course.getLog(3))

    def ExitActionSelfTransition(self):
        sm = ExitActionSelfTransition.ExitActionSelfTransition()
        self.assertEquals(
            ExitActionSelfTransition.ExitActionSelfTransition.Sm.created, sm.getSm()
        )
        sm.init()
        self.assertEquals(
            ExitActionSelfTransition.ExitActionSelfTransition.Sm.created, sm.getSm()
        )
        self.assertTrue(sm.getExitCodeCalled())
