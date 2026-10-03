import unittest

from ImportModules import importModules

importModules(["ChoiceB", "NonNullOverloads", "UncertainIntShifts", "UncertainLongShifts", "UncertainPromotion"],
              ["usercode", "expressions"])
from ImportModules import *


class OverloadBoundariesTest(unittest.TestCase):
    def test_sharedLiteralCountsForEitherSelectedWidth(self):
        for cls, number in ((UncertainIntShifts.UncertainIntShifts, 8),
                            (UncertainLongShifts.UncertainLongShifts, 1 << 40)):
            with self.subTest(cls=cls.__name__):
                value = cls(ChoiceB.ChoiceB())
                self.assertEqual(number, value.getZero())
                self.assertEqual(number >> 1, value.getOne())
                self.assertEqual(number >> 31, value.getBoundary())
                self.assertEqual(number << 1, value.getLeft())
                value.run()
                self.assertEqual(number >> 31, value.getResult())

    def test_integralDivisionForRealAndNullArguments(self):
        for cls, number in ((UncertainIntShifts.UncertainIntShifts, 8),
                            (UncertainLongShifts.UncertainLongShifts, 1 << 40)):
            for argument, expected in ((ChoiceB.ChoiceB(), number // 2), (None, -1)):
                with self.subTest(cls=cls.__name__, argument=argument):
                    value = cls(argument)
                    self.assertEqual(expected, value.getQuotient())
                    value.divide()
                    self.assertEqual(expected, value.getResult())

    def test_nonNullArgumentsKeepTruncatingDivision(self):
        value = NonNullOverloads.NonNullOverloads()
        for method in ("getLiteral", "getConcatenated", "getConditional", "getNumeric", "getBooleanValue"):
            with self.subTest(method=method):
                self.assertEqual(-1, getattr(value, method)())
        value.run()
        self.assertEqual(-1, value.getResult())
        value.setFlag(False)
        self.assertEqual(-1, value.getConditional())

    def test_nonNullConstraintArgumentsKeepTruncatingDivision(self):
        self.assertEqual(7, NonNullOverloads.NonNullOverloads().contract())

    def test_knownLongPromotesUncertainConstraintWidths(self):
        value = UncertainPromotion.UncertainPromotion(ChoiceB.ChoiceB())
        for count in (-64, -32, 0, 31, 32, 63, 64, 65):
            for method, number in (("product", 8), ("reversed", 8),
                                   ("divided", -3), ("remainder", 0), ("parameter", 8)):
                with self.subTest(count=count, method=method):
                    args = (1,) if method == "parameter" else ()
                    self.assertEqual(7, getattr(value, method + "Right")(count, number >> (count & 63), *args))
                    # Left shifts stay within Java's signed range.
                    if count & 63 < 32:
                        self.assertEqual(7, getattr(value, method + "Left")(count, number << (count & 63), *args))
        value.setUnit(2)
        self.assertEqual(7, value.dividedRight(64, -1))
        self.assertEqual(7, value.remainderRight(-64, -1))
        with self.assertRaises(RuntimeError):
            value.productRight(64, 0)

    def test_promotedConstraintOperandsRunOnceInOrder(self):
        value = UncertainPromotion.UncertainPromotion(ChoiceB.ChoiceB())
        for count in (-64, -32, 32, 64):
            with self.subTest(count=count):
                value.setDistance(count)
                value.setTrace(0)
                self.assertEqual(7, value.ordered(8 >> (count & 63)))
                self.assertEqual(123, value.getTrace())
