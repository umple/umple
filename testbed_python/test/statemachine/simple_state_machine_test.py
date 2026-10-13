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
    def test_OneStateNoEvents(self):
        course = CourseB.CourseB()
        self.assertEqual(CourseB.CourseB.Status.Open, course.getStatus())

    def test_StateMachineWithNegativeNumberGuard(self):
        sm = StateMachineWithNegativeNumberGuard.StateMachineWithNegativeNumberGuard()
        self.assertEqual(
            StateMachineWithNegativeNumberGuard.StateMachineWithNegativeNumberGuard.Status.On,
            sm.getStatus(),
        )
        sm.turnOff(-1)
        self.assertEqual(
            StateMachineWithNegativeNumberGuard.StateMachineWithNegativeNumberGuard.Status.On,
            sm.getStatus(),
        )
        sm.turnOff(0)
        self.assertEqual(
            StateMachineWithNegativeNumberGuard.StateMachineWithNegativeNumberGuard.Status.Off,
            sm.getStatus(),
        )
