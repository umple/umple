import unittest

from ImportModules import importModules

importModules(
    [
        "SmDeepHistory", "SmDeleteInAction", "SmDependent", "SmDependentMethods", "SmEntryDeletes", "SmEnums",
        "SmExitDeletes", "SmFinal", "SmFirstMatch", "SmGuardedActions", "SmInjections", "SmNames", "SmNestedOrder",
        "SmRegionAlternative", "SmRegionFinal", "SmSetterEvent", "SmSimple", "SmUnspecified", "SmUnspecifiedOr",
        "SmValueEvent",
    ],
    ["sm"],
)
from ImportModules import *

# Transitions, enums, history, deletion and state-dependent methods that the ported Java testbed
# does not cover. Models are in testbed_pythonnext/src/TestHarnessPythonStateMachines.ump.


class Deletes:
    """Counts delete() calls, which final states make, without needing an injection."""

    def delete(self):
        self.deletes = getattr(self, "deletes", 0) + 1
        super().delete()


class RegionFinal(Deletes, SmRegionFinal.SmRegionFinal):
    pass


class Final(Deletes, SmFinal.SmFinal):
    pass


class RegionAlternative(Deletes, SmRegionAlternative.SmRegionAlternative):
    pass


class TransitionsTest(unittest.TestCase):
    # The first enabled transition in model order wins, and only one fires
    def test_firstEnabledTransitionWins(self):
        m = SmFirstMatch.SmFirstMatch()
        self.assertIs(True, m.go(9))
        self.assertEqual("B", m.getStateFullName())
        self.assertEqual("big;", m.getLog())
        m.back()
        self.assertIs(True, m.go(1))
        self.assertEqual("C", m.getStateFullName())
        m.back()
        self.assertIs(True, m.go(-1))
        self.assertEqual("D", m.getStateFullName())
        self.assertEqual("big;positive;other;", m.getLog())

    def test_eventInOtherStateIsNotProcessed(self):
        m = SmFirstMatch.SmFirstMatch()
        self.assertIs(False, m.back())
        self.assertEqual("A", m.getStateFullName())

    # entry and exit actions of a concurrent state and its regions run in Java's order
    def test_concurrentEntryAndExitOrder(self):
        m = SmNestedOrder.SmNestedOrder()
        self.assertIs(True, m.on())
        self.assertEqual("On.Left.Right", m.getStateFullName())
        self.assertIs(True, m.off())
        self.assertEqual("enterOn;enterLeft;enterRight;exitLeft;exitRight;exitOn;", m.getLog())

    # As in Java: unspecified handles what a state does not, and an event that some state handles
    # alongside unspecified goes to unspecified in the states that do not handle it
    def test_unspecifiedEvent(self):
        m = SmUnspecified.SmUnspecified()
        self.assertIs(True, m.e1())
        self.assertEqual("B", m.getStateFullName())
        self.assertIs(False, m.unspecified("B", "other"))
        m.e1()
        self.assertIs(True, m.unspecified("A", "other"))
        self.assertEqual("Error", m.getStateFullName())
        self.assertIs(False, m.e1())
        self.assertIs(True, m.fix())
        self.assertEqual("A", m.getStateFullName())


    # The setter and the event keep the previous generator's dispatch; with the same argument types
    # the name selects the setter, and each stays callable as its numbered implementation
    def test_eventNamedLikeASetter(self):
        m = SmSetterEvent.SmSetterEvent()
        self.assertIs(True, m.setValue(3))
        self.assertEqual(3, m.getValue())
        self.assertEqual("A", m.getStateFullName())
        self.assertIs(True, m.setValue2(4))
        self.assertEqual("B", m.getStateFullName())
        self.assertEqual(3, m.getValue())
        self.assertIs(True, m.setValue1(5))
        self.assertEqual(5, m.getValue())


    # The event returns True when a machine took it, although another machine sent it to
    # unspecified, which did nothing (Java returns False here)
    def test_unspecifiedDoesNotHideAnotherMachinesTransition(self):
        m = SmUnspecifiedOr.SmUnspecifiedOr()
        self.assertIs(True, m.go())
        self.assertEqual("B", m.getOneFullName())
        self.assertEqual("X", m.getTwoFullName())

    # An entry or exit action with a guard runs only when the guard holds, whether its body is
    # Python or untagged
    def test_guardedEntryAndExitActions(self):
        m = SmGuardedActions.SmGuardedActions()
        m.go()
        self.assertEqual("", m.getLog())
        m.back()
        self.assertEqual("left;", m.getLog())
        m.setReady(True)
        m.go()
        m.back()
        self.assertEqual("left;entered;", m.getLog())

    # An event named like an inherited setter; both stay callable
    def test_eventNamedLikeAnInheritedSetter(self):
        m = SmValueEvent.SmValueEvent()
        self.assertIs(True, m.setValue(4))
        self.assertEqual(4, m.getValue())
        self.assertIs(True, m.setValue())
        self.assertEqual("B", m.getSmFullName())
        self.assertIs(True, m.setValue1(5))
        self.assertEqual(5, m.getValue())

    # Parameters named like the class or a generated local, and an attribute named like
    # the history field, change nothing
    def test_modelNamesDoNotClashWithGeneratedNames(self):
        m = SmNames.SmNames()
        self.assertIs(True, m.go(1, 2))
        self.assertEqual("B", m.getSmFullName())
        self.assertEqual("Y", m.getSm2FullName())
        m.next()
        m.leave()
        self.assertIs(True, m.back())
        self.assertEqual("On.A", m.getHistoryFullName())
        self.assertEqual(42, m.getHistoryOnH())


class StateDependentIntegrationTest(unittest.TestCase):
    # A state-dependent method implements an interface method; no stub replaces it
    def test_implementsInterfaceMethod(self):
        self.assertEqual("a", SmDependentMethods.SmDependentMethods().label())

    # State-dependent overloads get numbered implementations and a dispatcher
    def test_overloads(self):
        m = SmDependentMethods.SmDependentMethods()
        self.assertEqual("none", m.kind())
        self.assertEqual("int", m.kind(1))

    # The precondition is checked, the body may rebind its parameter, and the after
    # injection runs once the result is computed
    def test_contractsAndInjections(self):
        m = SmDependentMethods.SmDependentMethods()
        self.assertEqual(6, m.twice(3))
        self.assertEqual(1, m.getCalls())
        self.assertRaises(RuntimeError, m.twice, -1)
        m.go()
        self.assertEqual(3, m.twice(3))
        self.assertEqual(2, m.getCalls())


class InjectionsTest(unittest.TestCase):
    # Java's positions: before and after an event, and after the state is set, before entry actions
    def test_injectionsOnEventAndSetter(self):
        m = SmInjections.SmInjections()
        self.assertEqual("set A;", m.getLog())
        self.assertIs(True, m.go())
        self.assertEqual("set A;before go;set B;after go;", m.getLog())


class EnumsTest(unittest.TestCase):
    # Each machine has its own enum; states compare by identity
    def test_statesBelongToTheirMachine(self):
        m = SmEnums.SmEnums()
        self.assertIs(SmEnums.SmEnums.One.A, m.getOne())
        self.assertIs(SmEnums.SmEnums.Two.A, m.getTwo())
        self.assertIsNot(m.getOne(), m.getTwo())
        self.assertNotEqual(SmEnums.SmEnums.One.A, SmEnums.SmEnums.Two.A)
        self.assertIs(True, m.go())
        self.assertIs(SmEnums.SmEnums.One.B, m.getOne())
        self.assertIs(SmEnums.SmEnums.Two.B, m.getTwo())
        self.assertIs(SmEnums.SmEnums.NestOuter.Inner2, m.getNestOuter())

    # Values are the state names, and str() gives the name, as in the previous generator's Python
    def test_enumNamesValuesAndStrings(self):
        state = SmEnums.SmEnums.One.B
        self.assertEqual("B", state.name)
        self.assertEqual("B", state.value)
        self.assertEqual("B", str(state))
        self.assertEqual(["Null", "Inner1", "Inner2"], [s.value for s in SmEnums.SmEnums.NestOuter])
        self.assertEqual("Outer.Inner1", SmEnums.SmEnums().getNestFullName())

    # A machine without events or actions has a public setter that returns True
    def test_simpleMachineSetter(self):
        m = SmSimple.SmSimple()
        self.assertIs(SmSimple.SmSimple.Status.Open, m.getStatus())
        self.assertIs(True, m.setStatus(SmSimple.SmSimple.Status.Closed))
        self.assertIs(SmSimple.SmSimple.Status.Closed, m.getStatus())


class DeletionTest(unittest.TestCase):
    # An action that deletes its object ends the event, which returns True;
    # the target is not entered, so its entry action, timer and activity never start
    def test_deleteInActionStopsTheEvent(self):
        m = SmDeleteInAction.SmDeleteInAction()
        self.assertIs(True, m.go())
        self.assertEqual("A", m.getStateFullName())
        self.assertEqual("", m.getLog())
        self.assertIsNone(m._timeoutBToCHandler)
        self.assertIsNone(m._doActivityStateBThread)

    # A final state deletes the object
    def test_finalStateDeletes(self):
        m = Final()
        self.assertIs(True, m.finish())
        self.assertEqual(1, m.deletes)
        self.assertEqual("Final", m.getStateFullName())

    # In concurrent regions, the object is deleted once every region is final, whichever
    # region finishes last
    def test_regionFinalWaitsForEveryRegion(self):
        m = RegionFinal()
        self.assertIs(True, m.first())
        self.assertIs(True, m.second())
        self.assertEqual(0, getattr(m, "deletes", 0))
        self.assertIs(True, m.firstAgain())
        self.assertEqual(1, m.deletes)

        m = RegionFinal()
        m.first()
        m.firstAgain()
        self.assertEqual(0, getattr(m, "deletes", 0))
        m.second()
        self.assertEqual(1, m.deletes)


    # An exit action that deletes the object ends the event before the target is entered
    def test_deleteInExitActionStopsTheEvent(self):
        m = SmExitDeletes.SmExitDeletes()
        self.assertIs(True, m.go())
        self.assertEqual("A", m.getStateFullName())
        self.assertEqual(0, m.getCount())

    # An entry action that deletes the object ends the event before other machines take it
    def test_deleteInEntryActionStopsTheEvent(self):
        m = SmEntryDeletes.SmEntryDeletes()
        self.assertIs(True, m.go())
        self.assertEqual("B", m.getOneFullName())
        self.assertEqual("X", m.getTwoFullName())
        self.assertEqual(0, m.getCount())

    # A region with several final states is final in any of them
    def test_regionWithAlternativeFinalStates(self):
        m = RegionAlternative()
        m.alternative()
        self.assertEqual(0, getattr(m, "deletes", 0))
        m.second()
        self.assertEqual(1, m.deletes)

        m = RegionAlternative()
        m.second()
        m.alternative()
        self.assertEqual(1, m.deletes)


class HistoryTest(unittest.TestCase):
    # As the Java output: the history of a machine is recorded when its next event starts, and deep
    # history restores the nested machine's recorded state
    def test_deepHistoryAsInJava(self):
        m = SmDeepHistory.SmDeepHistory()
        m.next()
        m.next()
        self.assertEqual("On.B.Y", m.getStateFullName())
        m.off()
        self.assertEqual("Off", m.getStateFullName())
        self.assertIs(True, m.resume())
        self.assertEqual("On.B.X", m.getStateFullName())
        m.off()
        self.assertIs(True, m.back())
        self.assertEqual("On.B.X", m.getStateFullName())

        m = SmDeepHistory.SmDeepHistory()
        m.next()
        m.off()
        m.resume()
        self.assertEqual("On.A", m.getStateFullName())


class StateDependentTest(unittest.TestCase):
    # The current state's body, else the enclosing state's, else Java's default for the return type
    # (null for a wrapper type such as Integer); parameters reach every body
    def test_nestedFallbackAndDefault(self):
        m = SmDependent.SmDependent()
        self.assertEqual(4, m.size(3))
        m.grow()
        self.assertEqual(3, m.size(3))
        m.off()
        self.assertIsNone(m.size(3))

    # An after injection runs once the selected body has computed the result
    def test_afterInjectionOfStateDependentMethod(self):
        m = SmInjections.SmInjections()
        m.go()
        m.setLog("")
        self.assertEqual("b", m.word())
        self.assertEqual("word;", m.getLog())

    # With several machines, a machine without a body for the current state defers to the next
    def test_bodiesOfSeveralMachines(self):
        m = SmDependent.SmDependent()
        self.assertEqual("quiet", m.word())
        m.loud()
        self.assertEqual("plain", m.word())


if __name__ == "__main__":
    unittest.main()
