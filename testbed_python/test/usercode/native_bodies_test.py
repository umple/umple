import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["UcNativeBodies", "UcShape", "UcSquare"], ["usercode", "test"])
from ImportModules import *


# Native method bodies.
class NativeBodiesTest(unittest.TestCase):
    def setUp(self):
        self.bodies = UcNativeBodies.UcNativeBodies()

    def test_nestedIndentation(self):
        self.assertEqual(4, self.bodies.nested(5))

    def test_tabIndentation(self):
        self.assertEqual("tabs", self.bodies.tabs())

    def test_tripleQuotedStringKeepsItsText(self):
        self.assertEqual("first\n      second\n  third", self.bodies.tripleQuoted())

    def test_backslashContinuedStringKeepsItsText(self):
        self.assertEqual("one    two", self.bodies.backslashString())

    def test_rawAndFormattedStringsKeepTheirText(self):
        self.assertEqual("a\\\n  b|x  y", self.bodies.rawAndFormatted())

    def test_commentAtColumnZero(self):
        self.assertEqual(2, self.bodies.columnZeroComment())

    def test_bracketAndBackslashContinuations(self):
        self.assertEqual(9, self.bodies.bracketsAndContinuation())

    def test_bodyWrittenAtColumnZero(self):
        self.assertEqual(4, self.bodies.zeroIndent())

    def test_bodyThatIsOneBlock(self):
        self.assertEqual(1, self.bodies.blockIsWholeBody(3))
        self.assertEqual(-1, self.bodies.blockIsWholeBody(-3))

    def test_emptyAndCommentOnlyBodies(self):
        self.assertIsNone(self.bodies.emptyBody())
        self.assertIsNone(self.bodies.commentOnly())

    def test_bodyOnOneLine(self):
        self.assertEqual(7, self.bodies.oneLine())

    def test_staticMethodWithoutAccessModifier(self):
        self.assertEqual(6, UcNativeBodies.UcNativeBodies.twice(3))

    def test_parameterNamedInIsInput(self):
        self.assertEqual(8, UcNativeBodies.UcNativeBodies.twice(input=4))

    def test_staticMethodCalledThroughInstance(self):
        self.assertEqual(2, self.bodies.increment(1))

    def test_untaggedBodyIsNativePython(self):
        self.assertEqual("untagged", self.bodies.untaggedPython())

    def test_methodWithOnlyJavaBodyIsLeftOut(self):
        self.assertFalse(hasattr(UcNativeBodies.UcNativeBodies, "javaOnly"))

    def test_extraCodeIsClassCode(self):
        self.assertEqual(5, UcNativeBodies.UcNativeBodies.LIMIT)
        self.assertEqual(10, self.bodies.helper())


# Abstract methods.
class AbstractMethodTest(unittest.TestCase):
    def test_abstractMethodMakesClassAbstract(self):
        with self.assertRaises(TypeError):
            UcShape.UcShape()

    def test_subclassProvidesAbstractMethod(self):
        square = UcSquare.UcSquare()
        self.assertEqual(4.0, square.area())
        self.assertEqual("area 4.0", square.describe())
