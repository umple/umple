import unittest

from ImportModules import importModules

importModules(["ItemWithUniqueId"], ["attributes", "test"])
from ImportModules import *


class UniqueTest(unittest.TestCase):
    def setUp(self):
        self.one = ItemWithUniqueId.ItemWithUniqueId("1")
        self.two = ItemWithUniqueId.ItemWithUniqueId("2")

    def tearDown(self):
        self.one.delete()
        self.two.delete()

    # testbed/test/cruise/attributes/test/UniqueTest.java: testCreateWithDuplicates
    def test_testCreateWithDuplicates(self):
        with self.assertRaises(RuntimeError):
            ItemWithUniqueId.ItemWithUniqueId("1")

    # testbed/test/cruise/attributes/test/UniqueTest.java: testHasWithGetWith
    def test_testHasWithGetWith(self):
        self.assertIs(True, ItemWithUniqueId.ItemWithUniqueId.hasWithId("1"))
        self.assertIs(False, ItemWithUniqueId.ItemWithUniqueId.hasWithId("3"))
        self.assertIs(ItemWithUniqueId.ItemWithUniqueId.getWithId("1"), self.one)
        self.assertIs(ItemWithUniqueId.ItemWithUniqueId.getWithId("2"), self.two)
        self.assertIsNone(ItemWithUniqueId.ItemWithUniqueId.getWithId("3"))

    # testbed/test/cruise/attributes/test/UniqueTest.java: testSetId
    def test_testSetId(self):
        self.assertIs(False, self.two.setId("1"))
        self.assertEqual(self.two.getId(), "2")
        self.assertIs(True, self.two.setId("3"))
        self.assertEqual(self.two.getId(), "3")
        self.assertIs(False, ItemWithUniqueId.ItemWithUniqueId.hasWithId("2"))
        newTwo = ItemWithUniqueId.ItemWithUniqueId("2")
        newTwo.delete()
