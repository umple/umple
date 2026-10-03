import unittest

from ImportModules import importModules

importModules(["ItemWithUniqueImmutableId"], ["attributes", "test"])
from ImportModules import *


class UniqueImmutableTest(unittest.TestCase):
    def setUp(self):
        self.one = ItemWithUniqueImmutableId.ItemWithUniqueImmutableId("1")
        self.two = ItemWithUniqueImmutableId.ItemWithUniqueImmutableId("2")

    def tearDown(self):
        self.one.delete()
        self.two.delete()

    # testbed/test/cruise/attributes/test/UniqueImmutableTest.java: testCreateWithDuplicates
    def test_testCreateWithDuplicates(self):
        with self.assertRaises(RuntimeError):
            ItemWithUniqueImmutableId.ItemWithUniqueImmutableId("1")

    # testbed/test/cruise/attributes/test/UniqueImmutableTest.java: testHasWithGetWith
    def test_testHasWithGetWith(self):
        self.assertIs(True, ItemWithUniqueImmutableId.ItemWithUniqueImmutableId.hasWithId("1"))
        self.assertIs(False, ItemWithUniqueImmutableId.ItemWithUniqueImmutableId.hasWithId("3"))
        self.assertIs(ItemWithUniqueImmutableId.ItemWithUniqueImmutableId.getWithId("1"), self.one)
        self.assertIs(ItemWithUniqueImmutableId.ItemWithUniqueImmutableId.getWithId("2"), self.two)
        self.assertIsNone(ItemWithUniqueImmutableId.ItemWithUniqueImmutableId.getWithId("3"))

    # testbed/test/cruise/attributes/test/UniqueImmutableTest.java: testSetId
    def test_testSetId(self):
        self.assertIs(False, self.two.setId("1"))
        self.assertEqual(self.two.getId(), "2")
        self.assertIs(False, self.two.setId("3"))
        self.assertEqual(self.two.getId(), "2")
        self.assertIs(False, ItemWithUniqueImmutableId.ItemWithUniqueImmutableId.hasWithId("3"))
        three = ItemWithUniqueImmutableId.ItemWithUniqueImmutableId("3")
        three.delete()
