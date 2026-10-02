import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(
    ["CourseB", "StateMachineWithNegativeNumberGuard"],
    ["statemachine", "test"],
)
from ImportModules import *


class SimpleStateMachineTest(unittest.TestCase):
    def OneStateNoEvents(self):
        course = CourseB.CourseB()
        self.assertEquals(CourseB.CourseB.Status.Open, course.getStatus())

    def StateMachineWithNegativeNumberGuard(self):
        sm = StateMachineWithNegativeNumberGuard.StateMachineWithNegativeNumberGuard()
        self.assertEquals(
            StateMachineWithNegativeNumberGuard.StateMachineWithNegativeNumberGuard.Status.On,
            sm.getStatus(),
        )
        sm.turnOff(-1)
        self.assertEquals(
            StateMachineWithNegativeNumberGuard.StateMachineWithNegativeNumberGuard.Status.On,
            sm.getStatus(),
        )
        sm.turnOff(0)
        self.assertEquals(
            StateMachineWithNegativeNumberGuard.StateMachineWithNegativeNumberGuard.Status.Off,
            sm.getStatus(),
        )
