import unittest

from ImportModules import importModules

importModules(
    ["AssociatedClassWithKey", "AssociationClass", "AssociationClassManyKeys"],
    ["associations"],
)
from ImportModules import *


class InheritedTest(unittest.TestCase):
    # testbed/test/cruise/associations/InheritedTest.java: InheritedAssociationKey
    def test_InheritedAssociationKey(self):
        someclass = AssociationClass.AssociationClass(1)
        someclass2 = AssociationClass.AssociationClass(1)
        self.assertIs(True, someclass.equals(someclass2))

    # testbed/test/cruise/associations/InheritedTest.java: InheritedAssociationManyKeys
    def test_InheritedAssociationManyKeys(self):
        someAssociatedClass = AssociatedClassWithKey.AssociatedClassWithKey(1)
        someAssociatedClass2 = AssociatedClassWithKey.AssociatedClassWithKey(2)
        someAssociatedClass3 = AssociatedClassWithKey.AssociatedClassWithKey(3)
        someAssociatedClass4 = AssociatedClassWithKey.AssociatedClassWithKey(4)
        someclass = AssociationClassManyKeys.AssociationClassManyKeys()
        someclass2 = AssociationClassManyKeys.AssociationClassManyKeys()
        someclass.addAssociatedClass(someAssociatedClass)
        someclass.addAssociatedClass(someAssociatedClass2)
        someclass.addAssociatedClass(someAssociatedClass3)
        someclass2.addAssociatedClass(someAssociatedClass)
        someclass2.addAssociatedClass(someAssociatedClass2)
        someclass2.addAssociatedClass(someAssociatedClass3)
        self.assertIs(True, someclass.equals(someclass2))
        someclass.addAssociatedClass(someAssociatedClass4)
        self.assertIs(False, someclass.equals(someclass2))
        self.assertIs(False, someclass2.equals(someclass))
