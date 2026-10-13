import unittest

from ImportModules import importModules

importModules(["ManyAttribute"], ["attributes", "test"])
from ImportModules import *


class ManyAttributeTest(unittest.TestCase):
    def setUp(self):
        self.m1 = ManyAttribute.ManyAttribute()
        self.m2 = ManyAttribute.ManyAttribute()

    def tearDown(self):
        self.m1.delete()
        self.m2.delete()

    # testbed/test/cruise/attributes/test/ManyAttributeTest.java: testAddRemoveAttributes
    def test_testAddRemoveAttributes(self):
        self.assertIs(True, self.m1.addWork(1))
        self.assertIs(True, self.m1.removeWork(1))
        self.assertIs(False, self.m1.hasWorks())

    # testbed/test/cruise/attributes/test/ManyAttributeTest.java: testGetAttributes
    def test_testGetAttributes(self):
        self.m1.addWork(1)
        self.m1.addWork(2)
        self.m1.addWork(3)
        self.assertEqual(1, self.m1.getWork(0))
        works = [1, 2, 3]
        self.assertEqual(works, self.m1.getWorks())

    # testbed/test/cruise/attributes/test/ManyAttributeTest.java: testGetAttributesNum
    def test_testGetAttributesNum(self):
        self.m2.addWork(1)
        self.assertEqual(1, self.m2.numberOfWorks())
        self.m2.addWork(2)
        self.m2.addWork(3)
        self.assertEqual(3, self.m2.numberOfWorks())
        self.assertIs(True, self.m2.hasWorks())
