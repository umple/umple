import unittest

from ImportModules import importModules

importModules(["ContractOverloads", "ContractOverloadsReverse", "NumberedPart", "PartHolder",
               "InterfaceContracts", "MeasuredLength", "LengthContracts", "FailingArguments", "GuardNames",
               "GuardTicket", "GuardVersion", "GuardDeployment", "GuardLimits", "GuardArithmetic",
               "GuardContact", "GuardDirectory"],
              ["usercode", "constraints"])
from ImportModules import *


class ConstraintCallsTest(unittest.TestCase):
    def test_overloadReturnTypesInBothDeclarationOrders(self):
        for cls in (ContractOverloads.ContractOverloads, ContractOverloadsReverse.ContractOverloadsReverse):
            value = cls()
            for name in ("integral", "fractional", "remainder", "getter", "noArguments", "twoArguments"):
                with self.subTest(cls=cls.__name__, method=name):
                    self.assertEqual(7, getattr(value, name)())
            self.assertEqual(7, value.parameter("a"))

    def test_guardsQualifyStatesFollowTheClassAndCallAModelsEquals(self):
        self.assertTrue(GuardTicket.GuardTicket().close())
        ticket = GuardTicket.GuardTicket()
        self.assertFalse(ticket.transfer())
        ticket.setPartner(GuardTicket.GuardTicket())
        self.assertTrue(ticket.transfer())
        deployment = GuardDeployment.GuardDeployment()
        self.assertTrue(deployment.approve(GuardVersion.GuardVersion(2), GuardVersion.GuardVersion(2)))
        self.assertEqual("Approved", deployment.getStatusFullName())

    def test_missingObjectInGuardTextIsNull(self):
        directory = GuardDirectory.GuardDirectory()
        self.assertTrue(directory.resolve())
        self.assertEqual("Ready", directory.getStateFullName())

    def test_guardsComputeAsJava(self):
        value = GuardArithmetic.GuardArithmetic()
        self.assertEqual((True, True, True, True, True), (value.half(), value.rem(), value.frem(), value.text(), value.limit()))

    def test_guardsNameStatesAndUseEqualsAndContains(self):
        value = GuardNames.GuardNames("1234")
        self.assertFalse(value.spin())
        self.assertEqual(1, value.refund())
        value.toggle()
        self.assertTrue(value.spin())
        self.assertRaises(RuntimeError, value.refund)
        value.stop()
        self.assertFalse(value.check())
        value.setNote("a rush job")
        self.assertTrue(value.check())
        value.stop()
        self.assertFalse(value.enter("9"))
        self.assertTrue(value.enter("1234"))
        self.assertEqual("Open", value.getBladeFullName())

    def test_interfaceIntegralReturnTypesIncludingParents(self):
        box = PartHolder.PartHolder(NumberedPart.NumberedPart(1))
        value = InterfaceContracts.InterfaceContracts(box, box)
        self.assertEqual(7, value.integral())
        self.assertEqual(7, value.remainder())
        self.assertEqual(7, value.direct(box))

    def test_interfaceObjectReturnTypesCompareIdentity(self):
        one = PartHolder.PartHolder(NumberedPart.NumberedPart(1))
        two = PartHolder.PartHolder(NumberedPart.NumberedPart(1))
        self.assertEqual(one.getPart(), two.getPart())
        value = InterfaceContracts.InterfaceContracts(one, two)
        self.assertEqual(7, value.distinct())
        self.assertEqual(7, value.same(one))
        with self.assertRaises(RuntimeError):
            value.same(two)
        with self.assertRaises(RuntimeError):
            InterfaceContracts.InterfaceContracts(one, one).distinct()

    def test_modelLengthMethodsRemainCalls(self):
        item = MeasuredLength.MeasuredLength()
        value = LengthContracts.LengthContracts(item)
        self.assertEqual(7, value.fractional())
        self.assertEqual(7, value.integral())
        self.assertEqual(7, value.throughInterface(item))

    def test_stringAndArrayLengthRemainBuiltins(self):
        value = LengthContracts.LengthContracts(MeasuredLength.MeasuredLength())
        self.assertEqual(7, value.stringLength("abc"))
        self.assertEqual(7, value.arrayLength(["a", "b", "c"]))
        with self.assertRaises(RuntimeError):
            value.stringLength("")
        with self.assertRaises(RuntimeError):
            value.arrayLength([])

    def test_divisionFailurePrecedesNullReceiver(self):
        value = FailingArguments.FailingArguments()
        for name in ("division", "remainder", "getDivided"):
            with self.subTest(method=name), self.assertRaises(ZeroDivisionError):
                getattr(value, name)()

    def test_fieldFailurePrecedesNullReceiver(self):
        value = FailingArguments.FailingArguments()
        for name in ("field", "getFieldValue"):
            with self.subTest(method=name), self.assertRaisesRegex(AttributeError, "_zero"):
                getattr(value, name)()

    def test_receiverAndFailingCallAreEvaluatedOnceInOrder(self):
        for name in ("call", "getCalled"):
            value = FailingArguments.FailingArguments()
            with self.subTest(method=name), self.assertRaises(ZeroDivisionError):
                getattr(value, name)()
            self.assertEqual(12, value.getTrace())
