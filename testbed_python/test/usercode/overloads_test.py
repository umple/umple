import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["Overloads"], ["usercode", "test"])
from ImportModules import *


# Overloaded user methods dispatched by their arguments.
class OverloadsTest(unittest.TestCase):
    def setUp(self):
        self.overloads = Overloads.Overloads()

    def test_dispatchByPositionalArgumentType(self):
        self.assertEqual("int 3", self.overloads.describe(3))
        self.assertEqual("text abc", self.overloads.describe("abc"))
        self.assertEqual("object", self.overloads.describe(Overloads.Overloads()))
        self.assertEqual("nothing", self.overloads.describe())

    def test_dispatchByKeywordArguments(self):
        self.assertEqual("int 3", self.overloads.describe(value=3))
        self.assertEqual("text x", self.overloads.describe(value="x"))
        self.assertEqual("pair 2.5 True", self.overloads.describe(flag=True, value=2.5))
        self.assertEqual("pair 2.5 False", self.overloads.describe(2.5, flag=False))
        self.assertEqual("object", self.overloads.describe(other=self.overloads))

    def test_intAcceptedForFloatParameter(self):
        self.assertEqual("pair 2 True", self.overloads.describe(2, True))

    def test_boolNeverAcceptedForInt(self):
        with self.assertRaises(TypeError):
            self.overloads.describe(True)

    def test_noneAcceptedForReferenceTypesOnly(self):
        # Java rejects describe(null) as ambiguous; the first reference overload declared takes it
        self.assertEqual("int None", self.overloads.describe(None))
        self.assertEqual("object", self.overloads.describe(other=None))
        with self.assertRaises(TypeError):
            Overloads.Overloads.combine(None)

    def test_argumentsThatBindToNoCandidate(self):
        for args, kwargs in (((1, 2, 3), {}), ((), {"nope": 1}), ((1,), {"value": 2}), ((1.5,), {})):
            with self.assertRaises(TypeError) as raised:
                self.overloads.describe(*args, **kwargs)
            self.assertEqual("No method matches provided parameters", str(raised.exception))

    def test_numberedImplementationsRemainCallable(self):
        self.assertEqual("int 5", self.overloads.describe1(5))
        self.assertEqual("text y", self.overloads.describe2("y"))

    def test_staticOverloads(self):
        self.assertEqual(4, Overloads.Overloads.combine(4))
        self.assertEqual(3, Overloads.Overloads.combine(1, 2))
        self.assertEqual(7, Overloads.Overloads.combine(b=2, a=5))
        self.assertEqual(2, self.overloads.combine(1, 1))

    def test_varargsOverload(self):
        self.assertEqual(0, self.overloads.count())
        self.assertEqual(3, self.overloads.count(1, 2, 3))
        self.assertEqual(-1, self.overloads.count("x"))
        with self.assertRaises(TypeError):
            self.overloads.count(1, "x")

    def test_varargsWithoutOverloads(self):
        self.assertEqual(6, self.overloads.total(1, 2, 3))
