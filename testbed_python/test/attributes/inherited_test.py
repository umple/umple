import unittest

from ImportModules import importModules

importModules(["DoorI", "ManKeysStringAndInt", "ManyKeys"], ["attributes", "test"])
from ImportModules import *


class InheritedTest(unittest.TestCase):
    # testbed/test/cruise/attributes/test/InheritedTest.java: InheritedKey
    def test_InheritedKey(self):
        door = DoorI.DoorI("1")
        door2 = DoorI.DoorI("1")
        self.assertIs(True, door.equals(door2))
        self.assertEqual("1", door.getId())

    # testbed/test/cruise/attributes/test/InheritedTest.java: InheritedManyKeys
    def test_InheritedManyKeys(self):
        manykeys = ManyKeys.ManyKeys()
        manykeys.addWork(1)
        manykeys.addWork(2)
        manykeys2 = ManyKeys.ManyKeys()
        manykeys2.addWork(1)
        manykeys2.addWork(2)
        self.assertIs(True, manykeys.equals(manykeys2))

    # testbed/test/cruise/attributes/test/InheritedTest.java: MultipleKeysTest
    def test_MultipleKeysTest(self):
        class1 = ManKeysStringAndInt.ManKeysStringAndInt(1)
        class2 = ManKeysStringAndInt.ManKeysStringAndInt(1)
        class1.addWorksString("1")
        class1.addWorksString("2")
        class2.addWorksString("1")
        class2.addWorksString("2")
        self.assertIs(True, class1.equals(class2))
        class2.addWorksString("3")
        self.assertIs(False, class1.equals(class2))
        self.assertIs(False, class2.equals(class1))
