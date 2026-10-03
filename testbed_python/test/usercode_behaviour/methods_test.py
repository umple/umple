import unittest

from ImportModules import importModules

importModules(
    [
        "DerivedPython", "ExtraCode", "LanguageSelection", "OverloadByArity", "OverloadByType",
        "StaticMethods", "UserToString",
    ],
    ["usercode", "behaviour"],
)
from ImportModules import *

# User methods in generated Python.


class MethodsTest(unittest.TestCase):
    # overloads are dispatched by argument type
    def test_overloadByType(self):
        x = OverloadByType.OverloadByType()
        self.assertEqual(1, x.f(0))
        self.assertEqual(2, x.f("a"))

    # keyword calls bind by parameter name, None matches a reference type, and the
    # numbered implementations stay callable
    def test_overloadCallForms(self):
        x = OverloadByType.OverloadByType()
        self.assertEqual(1, x.f(x=0))
        self.assertEqual(2, x.f(None))
        self.assertEqual(1, x.f1(0))
        self.assertEqual(2, x.f2("a"))

    # no match raises TypeError, as the previous generator's dispatcher did; a bool is not an int
    def test_overloadWithoutMatch(self):
        x = OverloadByType.OverloadByType()
        for argument in (1.5, True):
            with self.assertRaises(TypeError) as raised:
                x.f(argument)
            self.assertEqual("No method matches provided parameters", str(raised.exception))

    def test_overloadByArity(self):
        x = OverloadByArity.OverloadByArity()
        self.assertEqual(1, x.f())
        self.assertEqual(2, x.f(5))

    # a static method needs no access modifier
    def test_staticWithoutAccessModifier(self):
        self.assertEqual(3, StaticMethods.StaticMethods.next(2))
        self.assertEqual(3, StaticMethods.StaticMethods().next(2))

    # a static method with a precondition is wrapped without a receiver
    def test_staticPrecondition(self):
        self.assertEqual(2, StaticMethods.StaticMethods.half(5))
        with self.assertRaises(RuntimeError):
            StaticMethods.StaticMethods.half(-1)

    # the Python body is selected
    def test_pythonBodySelected(self):
        self.assertEqual(7, LanguageSelection.LanguageSelection().both())

    # an untagged body beside a Java body is the Python body
    def test_untaggedBodyBesideJavaBody(self):
        self.assertEqual(1, LanguageSelection.LanguageSelection().fallback())

    # a method with only a Java body is left out (with a generation warning)
    def test_javaOnlyMethodLeftOut(self):
        self.assertFalse(hasattr(LanguageSelection.LanguageSelection(), "javaOnly"))

    def test_derivedPythonAttribute(self):
        x = DerivedPython.DerivedPython()
        self.assertEqual(6, x.getTwice())
        x.setN(5)
        self.assertEqual(10, x.getTwice())

    # class-level extra code is native Python
    def test_extraCodeIsNative(self):
        self.assertEqual(7, ExtraCode.ExtraCode.TOKEN)
        self.assertEqual(21, ExtraCode.ExtraCode().triple(7))

    # a user toString() is what str() returns
    def test_userToString(self):
        x = UserToString.UserToString()
        self.assertEqual("CUSTOM", str(x))
        self.assertEqual("CUSTOM", x.toString())
