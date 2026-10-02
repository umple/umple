import contextlib
import io
import subprocess
import sys
import threading
import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["LoudGreeter", "Checks", "AlwaysEqual", "Pair", "CountedChild", "ContractCalls", "ContractCallsChild",
               "KeyedPart", "PartBox", "PartBoxPair", "BoxedNull", "TextualSetter", "TextualStr", "LabelCrate",
               "CrateItem", "CountingTagged", "DependMaker", "ImplicitUser", "PickOverride", "PickWider", "ScopedUser", "ValueOwner", "LiteralOwner", "ValueFirst", "ValueSecond", "ValueNaming", "LazyOrder", "LazyReceiver", "LazyGuard", "LazyCycle", "LazyOnce", "LazyChain",
               "ValueDerived", "EventChild",
               "VarargsChild", "TypedChecks"], ["usercode", "test"])
from ImportModules import *


# Edge cases of user methods and their contracts: dispatch, names, Java's arithmetic and identity.
class EdgeCasesTest(unittest.TestCase):
    def test_subclassOverloadsCallTheirParentsThroughSuper(self):
        greeter = LoudGreeter.LoudGreeter()
        self.assertEqual("hello 3!", greeter.greet(3))
        self.assertEqual("hello you!", greeter.greet("you"))

    def test_enumerationParameterIsDispatchedByType(self):
        checks = Checks.Checks()
        self.assertEqual("color Red", checks.paint(Checks.Checks.Color.Red))
        self.assertEqual("number", checks.paint(2))
        with self.assertRaises(TypeError):
            checks.paint(object())

    def test_parameterNamedLikeItsClass(self):
        self.assertEqual(4, Checks.Checks().twice(2))
        with self.assertRaises(RuntimeError):
            Checks.Checks().twice(0)

    def test_listAndStringOperationsInContracts(self):
        self.assertEqual(4, Checks.Checks().sizes(["a", "b"], "xy"))
        for values, name in (([], "xy"), (["a"], "xy"), (["a", "b"], "x")):
            with self.assertRaises(RuntimeError):
                Checks.Checks().sizes(values, name)

    def test_integerDivisionIsExact(self):
        big = 2 ** 53 + 1
        self.assertEqual(big, Checks.Checks().exact(big))

    def test_remainderHasTheSignOfTheDividendAsInJava(self):
        self.assertEqual(-3, Checks.Checks().notOddPositive(-3))
        with self.assertRaises(RuntimeError):
            Checks.Checks().notOddPositive(3)

    def test_parametersNamedLikeTheReturnedValue(self):
        pair = Pair.Pair(AlwaysEqual.AlwaysEqual(), AlwaysEqual.AlwaysEqual())
        self.assertEqual(5, pair.sum(2, 3))
        self.assertEqual((2, 3), pair.seen)

    def test_modelObjectsReturnedByCallsAreComparedByIdentity(self):
        self.assertEqual(1, Pair.Pair(AlwaysEqual.AlwaysEqual(), AlwaysEqual.AlwaysEqual()).distinct())
        same = AlwaysEqual.AlwaysEqual()
        with self.assertRaises(RuntimeError):
            Pair.Pair(same, same).distinct()

    def test_inheritedAttributeInAContract(self):
        self.assertEqual(1, CountedChild.CountedChild().positive())

    def test_integralCallsDivideAndTakeTheRemainderAsInJava(self):
        calls = ContractCalls.ContractCalls()
        self.assertEqual(7, calls.half())
        self.assertEqual(7, calls.remainder())
        calls.setN(3)
        with self.assertRaises(RuntimeError):
            calls.half()
        with self.assertRaises(RuntimeError):
            calls.remainder()

    def test_remainderEvaluatesACallOnce(self):
        calls = ContractCalls.ContractCalls()
        self.assertEqual(7, calls.bumpedRemainder())
        self.assertEqual(1, calls.getBumps())

    def test_inheritedIntegralCalls(self):
        child = ContractCallsChild.ContractCallsChild()
        self.assertEqual(7, child.inherited())
        self.assertEqual(1, child.getBumps())

    def test_modelObjectsReachedThroughGettersAreComparedByIdentity(self):
        distinct = PartBoxPair.PartBoxPair(PartBox.PartBox(KeyedPart.KeyedPart(1)), PartBox.PartBox(KeyedPart.KeyedPart(1)))
        self.assertEqual(distinct.getOne().getPart(), distinct.getTwo().getPart())
        self.assertEqual(7, distinct.distinct())
        part = KeyedPart.KeyedPart(1)
        with self.assertRaises(RuntimeError):
            PartBoxPair.PartBoxPair(PartBox.PartBox(part), PartBox.PartBox(part)).distinct()

    def test_boxedParametersTakeNone(self):
        boxed = BoxedNull.BoxedNull()
        self.assertEqual("null", boxed.m(None))
        self.assertEqual("two", boxed.m(None, 1))
        with self.assertRaises(TypeError):
            boxed.m(1, None)

    def test_methodTextInAStringIsNotAMethod(self):
        textual = TextualSetter.TextualSetter(1)
        self.assertTrue(textual.setX(2))
        self.assertEqual(2, textual.getX())
        self.assertEqual("custom", textual.setX("label"))
        self.assertIn("[name:value]", str(TextualStr.TextualStr("value")))

    def test_subclassOverloadKeepsTheInheritedOnes(self):
        crate = LabelCrate.LabelCrate()
        item = CrateItem.CrateItem()
        self.assertTrue(item.setCrate(crate))
        self.assertEqual(1, crate.numberOfItems())
        self.assertTrue(crate.addItem("label"))
        self.assertFalse(crate.addItem("other"))
        tagged = CountingTagged.CountingTagged()
        self.assertTrue(tagged.addTag("a"))
        self.assertEqual(["a"], list(tagged.getTags()))
        self.assertEqual(3, tagged.getTags(3))

    def test_dependedClassIsImportedWhereTheBodyRuns(self):
        self.assertIsInstance(DependMaker.DependMaker().make(), CrateItem.CrateItem)

    def test_classesOfTheNamespaceNeedNoImport(self):
        user = ImplicitUser.ImplicitUser()
        self.assertIsInstance(user.make(), CrateItem.CrateItem)
        self.assertEqual("given", user.echo("given"))
        self.assertEqual("high 5", user.label())
        self.assertEqual(5, user.getHigh())

    def test_inheritedOverloadsCompeteWithTheSubclasses(self):
        override = PickOverride.PickOverride()
        self.assertEqual("override-int", override.pick(1))
        self.assertEqual("base-string", override.pick("x"))
        self.assertEqual("base-string", override.pick(s="y"))
        wider = PickWider.PickWider()
        self.assertEqual("base-int", wider.pick(1))
        self.assertEqual("wider-double", wider.pick(1.5))
        self.assertEqual("base-string", wider.pick("x"))

    def test_importsFollowPythonScopes(self):
        user = ScopedUser.ScopedUser()
        self.assertEqual("CrateItem", user.viaComprehension())
        self.assertEqual("CrateItem1", user.viaNested())
        user.setShared("x")
        self.assertEqual("local", user.getSeen())
        self.assertEqual(("CrateItem1", "before", "unbound"), (user.viaLambda(), user.viaBefore(), user.viaAnnotation()))
        self.assertEqual(("CrateItem", "Names the item class."), (user.documented(), ScopedUser.ScopedUser.documented.__doc__))
        self.assertEqual(("CrateItem", "Names it tersely."), (user.documentedTersely(), ScopedUser.ScopedUser.documentedTersely.__doc__))
        self.assertEqual(("CrateItem", None), (user.notDocumented(), ScopedUser.ScopedUser.notDocumented.__doc__))
        self.assertEqual("before", user.viaYielded())

    def test_aClassValueIsSetOnceItsClassExists(self):
        self.assertEqual("seed 1", ValueOwner.ValueOwner.LABEL)
        owner = ValueOwner.ValueOwner
        self.assertEqual((5, 5, 7), (owner.FROM_INNER, owner.ValueInner.K, owner.UNTAKEN))
        with self.assertRaisesRegex(RuntimeError, "ValueOwner.PENDING is needed to compute itself"):
            owner.PENDING
        self.assertEqual((6, 6), (LiteralOwner.LiteralOwner.N, LiteralOwner.LiteralOwner.LiteralInner.K))
        self.assertEqual((5, 5, 5), (ValueFirst.ValueFirst.FIRST, ValueFirst.ValueFirst.SECOND, ValueSecond.ValueSecond.VALUE))
        self.assertEqual((5, 3), (ValueNaming.ValueNaming.LIMIT, ValueNaming.ValueNaming._ClassValue))

    def test_computedConstantsKeepTheirPlaceInTheOrder(self):
        order = LazyOrder.LazyOrder()
        with self.assertRaises(ValueError):
            order.go()
        self.assertEqual(0, order.getCount())
        printed = io.StringIO()
        with contextlib.redirect_stdout(printed):
            receiver = LazyReceiver.LazyReceiver()
            receiver.go()
        self.assertEqual(("created\n", 5), (printed.getvalue(), receiver.getN()))
        guard = LazyGuard.LazyGuard.getInstance()
        guard.go()
        self.assertIs(LazyGuard.LazyGuard.Sm.S, guard.getSm())
        printed = io.StringIO()
        with contextlib.redirect_stdout(printed):
            chain = LazyChain.LazyChain()
        self.assertEqual(("made\n", 5), (printed.getvalue(), chain.getResult()))
        code = ("import sys; sys.path[:] = " + repr(sys.path) + "; "
                "from " + ValueDerived.__name__ + " import ValueDerived; print(ValueDerived.N)")
        result = subprocess.run([sys.executable, "-B", "-c", code], capture_output=True, text=True, timeout=10)
        self.assertEqual("7", result.stdout.strip(), result.stderr)

    def test_computedConstantsAreComputedOnceAndReportCyclesAcrossThreads(self):
        threads = [threading.Thread(target=lambda: LazyOnce.LazyOnce.ONE) for _ in range(8)]
        for thread in threads:
            thread.start()
        for thread in threads:
            thread.join(5)
        self.assertEqual((1, 1), (LazyOnce.LazyOnce.ONE, LazyOnce.LazyOnce.computations))
        errors = []

        def read(name):
            try:
                getattr(LazyCycle.LazyCycle, name)
            except RuntimeError as e:
                errors.append(str(e))
        readers = [threading.Thread(target=read, args=(name,), daemon=True) for name in ("X", "Y")]
        for reader in readers:
            reader.start()
        for reader in readers:
            reader.join(5)
        self.assertFalse(any(reader.is_alive() for reader in readers))
        self.assertEqual(2, len(errors))
        self.assertTrue(all("is needed to compute itself" in error for error in errors), errors)

    def test_inheritedEventsAndVarargsCompete(self):
        child = EventChild.EventChild()
        self.assertFalse(child.go(1.5))
        self.assertTrue(child.go(1))
        self.assertEqual("On", child.getSmFullName())
        self.assertEqual("base", VarargsChild.VarargsChild().pick())
        self.assertEqual("child", VarargsChild.VarargsChild().pick(1, 2))

    def test_otherClassesConstantsKeepTheirTypes(self):
        checks = TypedChecks.TypedChecks()
        self.assertEqual((1, 2, 3), (checks.half(), checks.length(), checks.has()))
        self.assertEqual((4, 4, 4), (checks.qualified(4), checks.nested(4), checks.inherited(4)))
        for call in (checks.qualified, checks.nested, checks.inherited):
            with self.assertRaises(RuntimeError):
                call(5)

