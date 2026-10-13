import unittest

from ImportModules import importModules

importModules(["LengthSource", "InheritedLength", "LengthArguments", "ChoiceB",
               "CommonReturns", "CommonReturnsReverse", "ShiftChecks"], ["usercode", "expressions"])
from ImportModules import *


class ExpressionsTest(unittest.TestCase):
    def test_generatedBulkGetterLengthIncludingInheritance(self):
        value = InheritedLength.InheritedLength()
        for method, args in (("own", ()), ("inherited", ()), ("receiver", (value,))):
            with self.subTest(method=method), self.assertRaises(RuntimeError):
                getattr(value, method)(*args)
        for text in "abc":
            value.addValue(text)
        self.assertEqual(7, value.own())
        self.assertEqual(7, value.inherited())
        self.assertEqual(7, value.receiver(value))

    def test_lengthArgumentsSelectIntegralReturns(self):
        value = LengthArguments.LengthArguments()
        self.assertEqual(7, value.text("abc"))
        self.assertEqual(7, value.array(["a", "b", "c"]))
        self.assertEqual(7, value.getter())

    def test_commonIntegralReturnWithUncertainReferenceArguments(self):
        for cls in (CommonReturns.CommonReturns, CommonReturnsReverse.CommonReturnsReverse):
            with self.subTest(cls=cls.__name__):
                self.assertEqual(7, cls().run(ChoiceB.ChoiceB()))

    def test_intShiftCountsInStatementsAndExpressions(self):
        value = ShiftChecks.ShiftChecks()
        # These left shifts stay within Java's signed range so they isolate distance masking.
        for number, count in ((3, -32), (3, 32), (3, 33), (3, -31), (0, -1), (3, 64), (3, 0)):
            with self.subTest(number=number, count=count):
                value.setValue(number)
                value.setDistance(count)
                expected = number << (count & 31)
                self.assertEqual(expected, value.getLeft())
                value.shiftLeft()
                self.assertEqual(expected, value.getResult())
        for number in (8, -8):
            for count in (-1, -32, 0, 31, 32, 33, 64, 1000):
                with self.subTest(number=number, count=count):
                    value.setValue(number)
                    value.setDistance(count)
                    expected = number >> (count & 31)
                    self.assertEqual(expected, value.getRight())
                    value.shiftRight()
                    self.assertEqual(expected, value.getResult())

    def test_longShiftCountsInStatementsAndExpressions(self):
        value = ShiftChecks.ShiftChecks()
        for number, count in ((3, -64), (3, 64), (3, 65), (3, -63), (0, -1), (1, 32), (3, 0)):
            with self.subTest(number=number, count=count):
                value.setWide(number)
                value.setDistance(count)
                expected = number << (count & 63)
                self.assertEqual(expected, value.getWideLeft())
                value.shiftWideLeft()
                self.assertEqual(expected, value.getWideResult())
        for number in (1 << 40, -(1 << 40)):
            for count in (-1, -64, 0, 32, 63, 64, 65, 1000):
                with self.subTest(number=number, count=count):
                    value.setWide(number)
                    value.setDistance(count)
                    expected = number >> (count & 63)
                    self.assertEqual(expected, value.getWideRight())
                    value.shiftWideRight()
                    self.assertEqual(expected, value.getWideResult())

    def test_shiftArgumentsReachTheNullCallInBothSlots(self):
        value = ShiftChecks.ShiftChecks()
        for method in ("failLeft", "failRight", "getFailedLeft", "getFailedRight"):
            with self.subTest(method=method), self.assertRaisesRegex(AttributeError, "take"):
                getattr(value, method)()

    def test_shiftOperandsRunOnceAfterTheReceiverInBothSlots(self):
        for method in ("orderedCall", "getOrdered"):
            value = ShiftChecks.ShiftChecks()
            with self.subTest(method=method), self.assertRaisesRegex(AttributeError, "take"):
                getattr(value, method)()
            self.assertEqual(123, value.getTrace())
