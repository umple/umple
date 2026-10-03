import unittest

from ImportModules import importModules

importModules(["ChoiceA", "ChoiceB", "OverloadShiftChecks", "ConstraintShiftChecks"],
              ["usercode", "expressions"])
from ImportModules import *


class ShiftWidthsTest(unittest.TestCase):
    def test_certainOverloadWidthsInBothSnippetSlotsAndConstraints(self):
        value = OverloadShiftChecks.OverloadShiftChecks(ChoiceA.ChoiceA(), ChoiceB.ChoiceB())
        for count in (-64, -32, -1, 0, 31, 32, 63, 64, 65, 1000):
            with self.subTest(count=count):
                value.setDistance(count)
                wide = (1 << 40) >> (count & 63)
                narrow = 8 >> (count & 31)
                self.assertEqual(wide, value.getKnown())
                value.shiftKnown()
                self.assertEqual(wide, value.getResult())
                self.assertEqual(7, value.knownContract(count, wide))
                self.assertEqual(narrow, value.getNarrow())
                value.shiftNarrow()
                self.assertEqual(narrow, value.getResult())
                self.assertEqual(7, value.narrowContract(count, narrow))

    def test_uncertainOverloadWidthsUseASharedLiteralDistanceAndIntegralDivision(self):
        value = OverloadShiftChecks.OverloadShiftChecks(ChoiceA.ChoiceA(), ChoiceB.ChoiceB())
        # These distances need no long mask and agree with the Java control.
        for count in (0, 1, 31, 32, 40, 63):
            with self.subTest(count=count):
                value.setDistance(count)
                expected = (1 << 40) >> count
                self.assertEqual(1 << 9, value.getUnknown())
                value.shiftUnknown()
                self.assertEqual(1 << 9, value.getResult())
                self.assertEqual(7, value.unknownContract(count, expected))
        self.assertEqual(-1, value.getQuotient())
        value.divide()
        self.assertEqual(-1, value.getResult())

    def test_constraintIntShifts(self):
        value = ConstraintShiftChecks.ConstraintShiftChecks()
        for number in (8, -8):
            for count in (-1, -32, 0, 31, 32, 33, 64, 1000):
                with self.subTest(number=number, count=count):
                    self.assertEqual(7, value.intRight(number, count, number >> (count & 31)))
        # Left shifts avoid signed overflow to isolate count masking.
        for number, count in ((3, -32), (3, 32), (3, 33), (3, -31), (0, -1), (3, 64), (3, 0)):
            with self.subTest(number=number, count=count):
                self.assertEqual(7, value.intLeft(number, count, number << (count & 31)))
        with self.assertRaises(RuntimeError):
            value.intRight(8, 32, 0)

    def test_constraintLongShifts(self):
        value = ConstraintShiftChecks.ConstraintShiftChecks()
        for number in (1 << 40, -(1 << 40)):
            for count in (-1, -64, 0, 32, 63, 64, 65, 1000):
                with self.subTest(number=number, count=count):
                    self.assertEqual(7, value.longRight(number, count, number >> (count & 63)))
        for number, count in ((3, -64), (3, 64), (3, 65), (3, -63), (0, -1), (1, 32), (3, 0)):
            with self.subTest(number=number, count=count):
                self.assertEqual(7, value.longLeft(number, count, number << (count & 63)))

    def test_constraintArithmeticPromotion(self):
        value = ConstraintShiftChecks.ConstraintShiftChecks()
        for count in (-64, -32, 32, 64, 1000):
            with self.subTest(count=count):
                self.assertEqual(7, value.promoted(2, count, (1 << 41) >> (count & 63)))
                expected = (1 << 39) >> (count & 63)
                self.assertEqual(7, value.divided(count, expected))

    def test_constraintOperandsRunOnceInOrder(self):
        value = ConstraintShiftChecks.ConstraintShiftChecks()
        for count in (-64, -32, 32, 64):
            with self.subTest(count=count):
                value.setDistance(count)
                value.setTrace(0)
                self.assertEqual(7, value.ordered((1 << 40) >> (count & 63)))
                self.assertEqual(12, value.getTrace())
