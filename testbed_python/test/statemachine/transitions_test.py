import time
import unittest

from ImportModules import importModules

importModules(
    [
        "ActionOrder", "AutoTransitions", "ConcurrentRegions", "DeleteInAction", "EnumGuard",
        "EventParameters", "EventResult", "FinalDelete", "GuardPriority", "GuardsInOrder",
        "InheritedMachine", "NestedActions", "ReentrantAction", "RegionFinal", "ReusedNestedStateNames",
        "ReusedStateNames", "SetterEvent", "ShallowHistory", "SharedEvent", "StateDependentNested",
        "StateDependentWord", "TwoMachines",
    ],
    ["statemachine", "behaviour"],
)
from ImportModules import *

# Unless a test says otherwise, the same scenario passes against Java generated from the same
# models.


class TransitionsTest(unittest.TestCase):
    # the first enabled transition wins
    def test_firstEnabledGuardWins(self):
        m = GuardPriority.GuardPriority()
        self.assertIs(True, m.go(1))
        self.assertEqual("B", m.getStateFullName())
        m.reset()
        self.assertIs(True, m.go(0))
        self.assertEqual("C", m.getStateFullName())

    # guards are tried in model order, the unguarded one last
    def test_guardsTriedInModelOrder(self):
        m = GuardsInOrder.GuardsInOrder()
        self.assertIs(True, m.go(-2))
        self.assertEqual("B", m.getStateFullName())
        m.reset()
        self.assertIs(True, m.go(2))
        self.assertEqual("C", m.getStateFullName())
        m.reset()
        self.assertIs(True, m.go(0))
        self.assertEqual("D", m.getStateFullName())

    # a state name used by two machines belongs to each
    def test_reusedStateNamesBelongToTheirMachine(self):
        m = ReusedStateNames.ReusedStateNames()
        self.assertIs(True, m.go())
        self.assertIs(ReusedStateNames.ReusedStateNames.One.A, m.getOne())
        self.assertIs(ReusedStateNames.ReusedStateNames.Two.B, m.getTwo())
        self.assertEqual("B", m.getTwoFullName())

    # nested machines reusing state names initialize and move
    def test_reusedNestedStateNames(self):
        m = ReusedNestedStateNames.ReusedNestedStateNames()
        self.assertEqual("Top.A", m.getFirstFullName())
        self.assertEqual("Top.A", m.getSecondFullName())
        self.assertIs(True, m.go())
        self.assertEqual("Top.B", m.getFirstFullName())
        self.assertEqual("Top.B", m.getSecondFullName())

    # first-match is per machine, and the event reaches every machine
    def test_eventDispatchedToEveryMachine(self):
        m = SharedEvent.SharedEvent()
        self.assertIs(True, m.go(1))
        self.assertEqual("B", m.getOneFullName())
        self.assertEqual("Y", m.getTwoFullName())

    def test_twoMachinesMoveTogether(self):
        m = TwoMachines.TwoMachines()
        self.assertIs(True, m.go())
        self.assertEqual("B", m.getOneFullName())
        self.assertEqual("D", m.getTwoFullName())
        self.assertIs(True, m.back())
        self.assertEqual("A", m.getOneFullName())
        self.assertEqual("C", m.getTwoFullName())

    # an event returns True when a transition fires and False otherwise
    def test_eventResult(self):
        m = EventResult.EventResult()
        self.assertIs(True, m.go())
        self.assertIs(False, m.go())
        self.assertEqual("B", m.getStateFullName())

    # entry, exit and transition actions run in UML order
    def test_actionOrder(self):
        m = ActionOrder.ActionOrder()
        self.assertEqual("enterA;", m.getLog())
        self.assertIs(True, m.go())
        self.assertEqual("enterA;exitA;transition;enterB;", m.getLog())
        self.assertIs(False, m.go())
        self.assertEqual("enterA;exitA;transition;enterB;", m.getLog())

    def test_nestedEntryAndExit(self):
        m = NestedActions.NestedActions()
        self.assertEqual("Off", m.getStateFullName())
        m.on()
        self.assertEqual("On.A", m.getStateFullName())
        self.assertEqual("enterOn;enterA;", m.getLog())
        m.next()
        self.assertEqual("On.B", m.getStateFullName())
        m.off()
        self.assertEqual("Off", m.getStateFullName())
        self.assertEqual("enterOn;enterA;exitA;enterB;exitB;exitOn;", m.getLog())

    # an event reaches both regions of a concurrent state
    def test_concurrentRegions(self):
        m = ConcurrentRegions.ConcurrentRegions()
        m.on()
        self.assertEqual("On.A.C", m.getStateFullName())
        self.assertIs(True, m.step())
        self.assertEqual("On.B.D", m.getStateFullName())
        self.assertEqual("A;C;", m.getLog())
        self.assertIs(False, m.step())
        m.off()
        self.assertEqual("Off", m.getStateFullName())

    # the object is deleted only when every region is final
    def test_regionFinalDeletesWhenAllRegionsAreFinal(self):
        m = RegionFinal.RegionFinal()
        self.assertIs(True, m.first())
        self.assertEqual(0, m.getDeleted())
        self.assertIs(True, m.second())
        self.assertEqual(1, m.getDeleted())

    # reaching the final state deletes the object
    def test_finalStateDeletes(self):
        m = FinalDelete.FinalDelete()
        self.assertIs(True, m.finish())
        self.assertEqual(1, m.getDeleted())
        self.assertEqual("Final", m.getStateFullName())

    # H restores the last substate of On, whose own substates start over
    def test_shallowHistory(self):
        m = ShallowHistory.ShallowHistory()
        m.next()
        m.next()
        self.assertEqual("On.B.Y", m.getStateFullName())
        m.off()
        self.assertEqual("Off", m.getStateFullName())
        self.assertIs(True, m.resume())
        self.assertEqual("On.B.X", m.getStateFullName())

    # automatic transitions run on entry, including guarded ones
    def test_autoTransitions(self):
        m = AutoTransitions.AutoTransitions()
        self.assertEqual("C", m.getStateFullName())
        self.assertEqual(1, m.getCount())
        self.assertIs(True, m.again())
        self.assertEqual("C", m.getStateFullName())
        self.assertEqual(2, m.getCount())

    # the body is chosen by the current state, else the default
    def test_stateDependentMethod(self):
        m = StateDependentWord.StateDependentWord()
        self.assertEqual("A", m.word())
        m.go()
        self.assertEqual("B", m.word())
        m.go()
        self.assertEqual("default", m.word())

    # a nested state without its own body falls back to the enclosing state's
    def test_stateDependentMethodNestedFallback(self):
        m = StateDependentNested.StateDependentNested()
        self.assertEqual("X", m.word())
        m.next()
        self.assertEqual("On", m.word())

    def test_enumGuard(self):
        m = EnumGuard.EnumGuard()
        self.assertIs(False, m.go(EnumGuard.EnumGuard.Mode.No))
        self.assertEqual("A", m.getStateFullName())
        self.assertIs(True, m.go(EnumGuard.EnumGuard.Mode.Yes))
        self.assertEqual("B", m.getStateFullName())

    # event parameters reach the guard and the action
    def test_eventParameters(self):
        m = EventParameters.EventParameters()
        self.assertIs(False, m.send(-1, "no"))
        self.assertEqual(0, m.getTotal())
        self.assertIs(True, m.send(3, "ok"))
        self.assertEqual("B", m.getStateFullName())
        self.assertEqual(3, m.getTotal())
        self.assertEqual("ok", m.getText())

    # an event named like an attribute setter keeps both meanings
    def test_setterAndEventShareAName(self):
        m = SetterEvent.SetterEvent()
        self.assertIs(True, m.setValue(3))
        self.assertEqual("A", m.getStateFullName())
        self.assertEqual(3, m.getValue())
        self.assertIs(True, m.setValue())
        self.assertEqual("B", m.getStateFullName())
        self.assertEqual(3, m.getValue())

    # an inherited machine works on the subclass
    def test_inheritedMachine(self):
        m = InheritedMachine.InheritedMachine()
        self.assertIs(True, m.go())
        self.assertEqual("B", m.getStateFullName())
        self.assertIs(True, m.back())
        self.assertEqual("A", m.getStateFullName())

    # an event called from an action runs to completion first, then the outer transition finishes
    def test_eventFromActionRunsFirst(self):
        m = ReentrantAction.ReentrantAction()
        self.assertIs(True, m.go())
        self.assertEqual("B", m.getStateFullName())

    # an action that deletes its object ends the event, which returns True, enters no state and
    # starts no timer. Java differs: it enters B.
    def test_deleteInActionStopsTheEvent(self):
        m = DeleteInAction.DeleteInAction()
        self.assertIs(True, m.go())
        self.assertEqual("A", m.getStateFullName())
        self.assertEqual("", m.getLog())
        time.sleep(0.25)  # B's 0.1 s timer would have fired by now
        self.assertEqual("A", m.getStateFullName())
