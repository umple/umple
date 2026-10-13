import unittest

from ImportModules import importModules

importModules(
    ["ClassThatWillHaveSortedAssociationOne", "ClassThatWillHaveSortedAssociationTwo", "MultipleSortedAcademy"],
    ["associations"],
)
from ImportModules import *


class SortedAssociationsTest(unittest.TestCase):
    # testbed/test/cruise/associations/SortedAssociationsTest.java: setStudent
    def test_setStudent(self):
        t = ClassThatWillHaveSortedAssociationOne.ClassThatWillHaveSortedAssociationOne("Tom Jim")
        j = ClassThatWillHaveSortedAssociationOne.ClassThatWillHaveSortedAssociationOne("Jim Tom")
        check = ClassThatWillHaveSortedAssociationTwo.ClassThatWillHaveSortedAssociationTwo()
        check.addMass(t)
        check.addMass(j)
        self.assertIs(j, check.getMass(0))

    # testbed/test/cruise/associations/SortedAssociationsTest.java: multipleSorted
    def test_multipleSorted(self):
        ac = MultipleSortedAcademy.MultipleSortedAcademy()
        j = ac.addRegistrant(12, "Jim")
        a = ac.addRegistrant(4, "Ali")
        m = ac.addRegistrant(8, "Mary")
        f = ac.addRegistrant(3, "Francois")
        c = ac.addMultipleSortedCourse("CS191")
        c2 = ac.addMultipleSortedCourse("AN234")
        j.addMultipleSortedRegistration(c)
        a.addMultipleSortedRegistration(c)
        m.addMultipleSortedRegistration(c)
        f.addMultipleSortedRegistration(c)
        m.addMultipleSortedRegistration(c2)
        f.addMultipleSortedRegistration(c2)
        self.assertIs(a, c.getMultipleSortedRegistration(0).getMultipleSortedStudent())
        self.assertIs(f, c.getMultipleSortedRegistration(1).getMultipleSortedStudent())
        self.assertIs(j, c.getMultipleSortedRegistration(2).getMultipleSortedStudent())
        self.assertIs(m, c.getMultipleSortedRegistration(3).getMultipleSortedStudent())
        self.assertIs(f, c2.getMultipleSortedRegistration(0).getMultipleSortedStudent())
        self.assertIs(m, c2.getMultipleSortedRegistration(1).getMultipleSortedStudent())
