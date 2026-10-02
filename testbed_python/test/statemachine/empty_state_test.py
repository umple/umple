import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["CourseA", ], ["statemachine", "test"])
from ImportModules import *


class EmptyStateTest(unittest.TestCase):
    def test_getStateMachine(self):
        course = CourseA.CourseA()
        self.assertEquals(None, course.getStatus())
