import unittest

from ImportModules import importModules

importModules(["X1_1", "Y1_1"], ["associations", "compositions"])
from ImportModules import *


class OneToOneTest(unittest.TestCase):
    # testbed/test/cruise/associations/compositions/OneToOneTest.java: constructorNotSettingNull
    def test_constructorNotSettingNull(self):
        with self.assertRaises(RuntimeError):
            X1_1.X1_1.alternateConstructor(12, None)

    # testbed/test/cruise/associations/compositions/OneToOneTest.java: constructionNotSettingXWithNonNullY
    def test_constructionNotSettingXWithNonNullY(self):
        x1 = X1_1.X1_1(1)
        with self.assertRaises(RuntimeError):
            Y1_1.Y1_1.alternateConstructor(x1)

    # testbed/test/cruise/associations/compositions/OneToOneTest.java: settingAndDeleting
    def test_settingAndDeleting(self):
        x1 = X1_1.X1_1(1)
        y1 = x1.getY1_1()
        self.assertIs(x1, y1.getXVar())
        self.assertIs(y1, x1.getY1_1())
        # The links exist before the deletion (added to the Java test)
        self.assertIsNotNone(y1.getXVar())
        self.assertIsNotNone(x1.getY1_1())
        y1.delete()
        self.assertIsNone(y1.getXVar())
        self.assertIsNone(x1.getY1_1())
