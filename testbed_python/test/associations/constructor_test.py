import unittest

from ImportModules import importModules

importModules(["ConstructorManyClass", "Otherclass"], ["associations"])
from ImportModules import *


class ConstructorTest(unittest.TestCase):
    # testbed/test/cruise/associations/ConstructorTest.java: constructorMayHaveMultipleToManyRelationships
    def test_constructorMayHaveMultipleToManyRelationships(self):
        other1 = Otherclass.Otherclass("one")
        other2 = Otherclass.Otherclass("two")
        other3 = Otherclass.Otherclass("three")
        other = Otherclass.Otherclass("other")
        clazz = ConstructorManyClass.ConstructorManyClass([other1, other2, other3], [other])
        self.assertEqual(clazz.numberOfOthersOne(), 3)
        self.assertEqual(clazz.numberOfOthersTwo(), 1)
