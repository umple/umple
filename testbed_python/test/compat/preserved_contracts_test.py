import os
import re
import unittest

from ImportModules import importModules

importModules(
    [
        "Child", "Group", "Left", "OnlyOne", "Owner", "Palette", "Params", "Person", "Right", "TagBag",
    ],
    ["compat"],
)
importModules(["MentorJ", "StudentJ"], ["associations"])
importModules(["NestedActions"], ["statemachine", "behaviour"])
from ImportModules import *

# Contracts of the previous generator's Python that this generator keeps and that a signature check
# cannot see; each test also passes on the Python the previous generator produced.
# public_api_test.py checks names and signatures; the timer, activity and main contracts are in
# statemachine/ and usercode_behaviour/.


class PreservedContractsTest(unittest.TestCase):
    # module paths and ClassName.py layout, reached through the namespace package
    def test_moduleLayout(self):
        self.assertEqual("cruise.compat.Palette", Palette.Palette.__module__)
        self.assertTrue(Palette.__file__.endswith(os.path.join("cruise", "compat", "Palette.py")))

    # glossary plurals name the association API
    def test_glossaryNames(self):
        group = Group.Group()
        person = Person.Person("glossary")
        self.assertIs(True, group.addPerson(person))
        self.assertIs(person, group.getPerson(0))
        self.assertEqual((person,), group.getPeople())
        self.assertEqual(1, group.numberOfPeople())
        self.assertEqual(0, group.indexOfPerson(person))
        self.assertIs(group, person.getGroup())
        person.delete()

    # unique attributes keep their static lookups and registry
    def test_uniqueLookups(self):
        person = Person.Person("unique")
        self.assertIs(person, Person.Person.getWithId("unique"))
        self.assertIs(True, Person.Person.hasWithId("unique"))
        self.assertIsNone(Person.Person.getWithId("absent"))
        person.delete()
        self.assertIs(False, Person.Person.hasWithId("unique"))

    # constructor parameter order and keyword names
    def test_constructorKeywordNames(self):
        mentor = MentorJ.MentorJ(aName="m")
        student = StudentJ.StudentJ(aNumber=5, aMentor=mentor)
        self.assertEqual("m", mentor.getName())
        self.assertIs(mentor, student.getMentor())

    # the plain constructor creates the peer; alternateConstructor attaches an
    # existing peer and refuses one that is taken
    def test_alternateConstructor(self):
        left = Left.Left()
        right = left.getRights()
        self.assertIsInstance(right, Right.Right)
        self.assertIs(left, right.getLefts())
        with self.assertRaises(RuntimeError):
            Left.Left.alternateConstructor(right)

    # numbered implementations, int accepted for a Double
    # parameter, and the dispatcher's TypeError message
    def test_numberedOverloadsAndIntForFloat(self):
        owner = Owner.Owner()
        child = owner.addChild(7)
        self.assertIsInstance(child, Child.Child)
        self.assertEqual(7, child.getWeight())
        self.assertIs(owner, child.getOwner())
        self.assertIsInstance(owner.addChild1(2.5), Child.Child)
        other = Child.Child(1.5, Owner.Owner())
        self.assertIs(True, owner.addChild2(other))
        self.assertEqual(3, owner.numberOfChildren())
        with self.assertRaises(TypeError) as raised:
            owner.addChild("heavy")
        self.assertEqual("No method matches provided parameters", str(raised.exception))

    # association getters return tuple snapshots
    def test_associationGetterIsTupleSnapshot(self):
        owner = Owner.Owner()
        first = owner.addChild(1)
        children = owner.getChildren()
        self.assertIsInstance(children, tuple)
        owner.addChild(2)
        self.assertEqual((first,), children)

    # list-attribute getters return a list copy
    def test_listAttributeGetterIsListCopy(self):
        bag = TagBag.TagBag()
        bag.addTag("a")
        tags = bag.getTags()
        self.assertIsInstance(tags, list)
        tags.append("external")
        self.assertEqual(["a"], bag.getTags())

    # negative indexes count from the end; indexes past the end raise IndexError
    def test_indexing(self):
        bag = TagBag.TagBag()
        bag.addTag("a")
        bag.addTag("b")
        self.assertEqual("b", bag.getTag(-1))
        owner = Owner.Owner()
        owner.addChild(1)
        last = owner.addChild(2)
        self.assertIs(last, owner.getChild(-1))
        with self.assertRaises(IndexError):
            bag.getTag(5)

    # indexOfX returns -1 for an absent value or object
    def test_indexOfAbsentIsMinusOne(self):
        bag = TagBag.TagBag()
        self.assertEqual(-1, bag.indexOfTag("absent"))
        self.assertEqual(-1, Owner.Owner().indexOfChild(Owner.Owner().addChild(1)))

    # multiplicity violations raise RuntimeError
    def test_multiplicityViolationRaisesRuntimeError(self):
        with self.assertRaises(RuntimeError):
            StudentJ.StudentJ(99, None)

    # enum members have name, value and str() equal to their spelling and
    # are not equal to that string
    def test_enumStrings(self):
        red = Palette.Palette.Color.Red
        self.assertEqual("Red", red.name)
        self.assertEqual("Red", red.value)
        self.assertEqual("Red", str(red))
        self.assertNotEqual("Red", red)
        self.assertIs(red, Palette.Palette(red).getColor())

    # state full names are dot-separated state names
    def test_stateFullNames(self):
        machine = NestedActions.NestedActions()
        machine.on()
        self.assertEqual("On.A", machine.getStateFullName())
        self.assertEqual("On", str(machine.getState()))

    # getInstance() returns the one instance
    def test_getInstance(self):
        instance = OnlyOne.OnlyOne.getInstance()
        self.assertIsInstance(instance, OnlyOne.OnlyOne)
        self.assertIs(instance, OnlyOne.OnlyOne.getInstance())

    # the __str__ format is the object repr, [attribute:value,...], then one line
    # per association holding the linked object's hex identity or null
    def test_strFormat(self):
        person = Person.Person("one")
        prefix = r"<cruise\.compat\.Person\.Person object at 0x[0-9a-fA-F]+>\[id:one\]"
        self.assertRegex(str(person), "^" + prefix + re.escape("\n") + "  group = null$")
        group = Group.Group()
        group.addPerson(person)
        self.assertRegex(str(person), "^" + prefix + re.escape("\n") + "  group = " + format(id(group), "x") + "$")
        person.delete()

    # objects of classes without keys are equal only to themselves
    def test_identityEqualityWithoutKeys(self):
        a, b = TagBag.TagBag(), TagBag.TagBag()
        self.assertNotEqual(a, b)
        self.assertEqual(a, a)
        self.assertEqual(2, len({a, b}))

    # a parameter named in is exposed as input
    def test_inParameterIsInput(self):
        params = Params.Params()
        params.accept(input="keyword works")
        self.assertEqual("keyword works", params.getLast())
