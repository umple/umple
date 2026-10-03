import unittest

from ImportModules import importModules

importModules(
    ["AbstractShape", "FreshSingleton", "KeyedCollection", "NamedKey", "Square", "TagBag", "TaggedKey"],
    ["compat"],
)
importModules(["ClassWithOneSortedAssociations", "StudentC"], ["associations"])
from ImportModules import *

# Intentional changes from the previous generator's Python, asserted as their new behaviour. The
# other intentional changes are tested where their behaviour lives:
#   Python actions and injections, preconditions and before injections, after injections,
#   untagged default body, methods with only other-language bodies, user toString(), overloaded
#   user methods, True/False not matching int: usercode_behaviour/
#   do activities, timers, an action that deletes its object, timers and activities started
#   from a daemon thread: statemachine/
#   untagged snippets outside the translated subset, unsupported features, standard-module
#   class names: build/python_corpus_gate.py and its manifest
#   -c / -cx compile only: cruise.umple PythonCompileTest
#   Java declarations in untagged extra code: emitted as written, so there is nothing to run


class LedgerTest(unittest.TestCase):
    # list attribute add and remove return booleans; removing an absent value returns False
    # (previous generator: None, and ValueError for an absent value)
    def test_listMutatorsReturnBooleans(self):
        bag = TagBag.TagBag()
        self.assertIs(True, bag.addTag("a"))
        self.assertIs(True, bag.removeTag("a"))
        self.assertIs(False, bag.removeTag("absent"))

    # keyed classes compare and hash by key with == and hash(); equals() stays
    # (previous generator: == is identity)
    def test_keyedEqualityAndHash(self):
        a, b, c = NamedKey.NamedKey("x"), NamedKey.NamedKey("x"), NamedKey.NamedKey("y")
        self.assertEqual(a, b)
        self.assertNotEqual(a, c)
        self.assertNotEqual(a, "x")
        self.assertEqual(hash(a), hash(b))
        self.assertEqual(1, len({a, b}))
        self.assertIs(True, a.equals(b))
        self.assertIs(False, a.equals(c))

    # a non-key attribute takes no part in equality and stays settable after hashing; the key is
    # frozen once hashed, as Java freezes it
    def test_keyFrozenAfterHashing(self):
        a, b = NamedKey.NamedKey("x"), NamedKey.NamedKey("x")
        before = hash(a)
        self.assertIs(True, a.setSize(5))
        self.assertEqual(a, b)
        self.assertEqual(before, hash(a))
        self.assertIs(False, a.setName("y"))
        self.assertEqual("x", a.getName())

    # a list-valued key compares element-wise and hashes as a tuple
    def test_collectionKey(self):
        a, b = TaggedKey.TaggedKey(), TaggedKey.TaggedKey()
        for key in (a, b):
            key.addTag("p")
            key.addTag("q")
        self.assertEqual(a, b)
        self.assertEqual(hash(a), hash(b))
        reordered = TaggedKey.TaggedKey()
        reordered.addTag("q")
        reordered.addTag("p")
        self.assertNotEqual(a, reordered)
        self.assertIs(False, a.addTag("r"))

    # association membership stays identity, now independent of the keys' __eq__: an equal-key
    # twin is a different member (Java's add refuses it, as Java compares with equals)
    def test_associationMembershipIsIdentity(self):
        collection = KeyedCollection.KeyedCollection()
        first, twin = NamedKey.NamedKey("x"), NamedKey.NamedKey("x")
        self.assertEqual(first, twin)
        self.assertIs(True, collection.addMember(first))
        self.assertIs(True, collection.addMember(twin))
        self.assertIs(False, collection.addMember(twin))
        self.assertEqual(1, collection.indexOfMember(twin))
        self.assertIs(True, collection.removeMember(twin))
        self.assertEqual(1, collection.numberOfMembers())
        self.assertIs(first, collection.getMember(0))
        self.assertEqual(-1, collection.indexOfMember(twin))

    # a sorted association takes no comparator argument and keeps its objects sorted by the key
    # (previous generator: an extra constructor argument and no sorting)
    def test_sortedAssociation(self):
        sorted_ = ClassWithOneSortedAssociations.ClassWithOneSortedAssociations()
        for number in (3, 1, 2):
            sorted_.addStudentC(StudentC.StudentC(number))
        self.assertEqual([1, 2, 3], [s.getId() for s in sorted_.getStudentCs()])

    # an abstract class without abstract methods cannot be constructed; a subclass can
    # (previous generator: instantiable)
    def test_abstractClassWithoutAbstractMethods(self):
        with self.assertRaises(TypeError):
            AbstractShape.AbstractShape("shape")
        square = Square.Square("square")
        self.assertIsInstance(square, AbstractShape.AbstractShape)
        self.assertEqual("square", square.getName())

    # a singleton is reached only through getInstance(): direct construction raises
    # RuntimeError before and after the instance exists (previous generator: allowed). No other
    # test uses this singleton, so the first check runs before any instance exists.
    def test_singletonDirectConstruction(self):
        with self.assertRaises(RuntimeError):
            FreshSingleton.FreshSingleton()
        instance = FreshSingleton.FreshSingleton.getInstance()
        self.assertIsInstance(instance, FreshSingleton.FreshSingleton)
        with self.assertRaises(RuntimeError):
            FreshSingleton.FreshSingleton()
        self.assertIs(instance, FreshSingleton.FreshSingleton.getInstance())
