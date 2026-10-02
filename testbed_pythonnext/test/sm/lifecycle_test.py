import subprocess
import sys
import threading
import unittest
from unittest.mock import patch

from ImportModules import importModules

_NAMES = [
    "NestedDelete", "ParentDelete", "ExitDelete", "ExitActions", "EntryTimer",
    "NestedAutoTimer", "EntryActivity", "ReentrantActivity", "PartialFinal",
    "AutoRegions", "DeepHist", "DeepLeaves", "CrossDeletes", "AfterEventDeletes",
    "NestedRegionFinal", "ReentrantTimer", "ExitDuringEntry", "NamedPartialFinal",
    "EmptyRegionFinal", "ParentEntryInjection",
    "DelayLeaves", "DelayDeletes", "DelayReentry", "DelayExit", "DelayStable",
    "BeforeEventDeletes", "BeforeEventDeletesBare", "BeforeEventDeletesNative",
    "BeforeExitDeletesBare", "BeforeSetterDeletesBare", "VisitLocal", "VisitNative",
    "VisitActions", "VisitInjections", "VisitInjectionsNative",
    "RetryExit", "MultipleBefore",
    "MultipleBeforeNative", "MultipleAfter", "MultipleSetterBefore", "MultipleSetterAfter",
    "MultipleExitBefore", "MultipleExitAfter", "UnicodeVisit", "UnicodeVisitInjections",
    "ConstructorDeletes", "ConstructorTimerDeletes", "ConstructorLastDeletes", "ConstructorOrder",
    "ConstructorNestedDeletes",
    "CallbackGuardExit", "GuardDeletes", "GuardRejectDeletes", "BareGuardDeletes",
    "GuardReentry", "GuardOrder", "DeletedRecord", "DeletedGrandchild", "ChildContinues",
    "DeletedPair", "DeletedPartner", "DeletedBarePair", "DeletedBarePartner",
    "MultipleAfterLeaves", "MultipleAfterReentry",
    "MixedGuards", "GuardReceiver", "ReceiverGuard", "DependentGuard", "NoEventsAfterDelete",
    "PlainDelete", "Ring", "Telemetry", "TraitEntry", "TraitGuard", "TraitSuite", "TraitUntagged",
    "TraitNested", "TraitRepeated", "TraitOtherLanguage", "TraitBilingual", "TraitContinued",
]
importModules(["SmLifecycle" + name for name in _NAMES], ["sm"])
importModules(["visit", "SmLifecycleDelayClassName", "SmLifecycleDelayValueName",
               "SmLifecycleDelayNumberedNames"], ["sm", "timerlocals"])
from ImportModules import *


class LifecycleTest(unittest.TestCase):
    def setUp(self):
        self._objects = []
        self._timers = []
        self._timer_class = threading.Timer
        timer_patch = patch("threading.Timer", side_effect=self._new_timer)
        timer_patch.start()
        self.addCleanup(timer_patch.stop)
        self.addCleanup(self._finish)

    def _new_timer(self, *args, **kwargs):
        timer = self._timer_class(*args, **kwargs)
        self._timers.append(timer)
        return timer

    def _model(self, name, *args):
        name = "SmLifecycle" + name
        obj = getattr(globals()[name], name)(*args)
        self._objects.append(obj)
        return obj

    def _workers(self, obj):
        return [t for t in threading.enumerate() if getattr(t, "_controller", None) is obj]

    def _finish(self):
        # Recover orphan workers too, so a failing regression cannot keep the test process alive.
        workers = [t for obj in self._objects for t in self._workers(obj)]
        try:
            for obj in self._objects:
                obj.delete()
        finally:
            for worker in workers:
                worker.cancelled.set()
            for timer in self._timers:
                timer.cancel()
            for thread in workers + self._timers:
                if thread.ident is not None:
                    thread.join(1)
                self.assertFalse(thread.is_alive(), thread.name)

    def test_nested_entry_stops_after_delete(self):
        obj = self._model("NestedDelete")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())

    def test_parent_entry_deletion_stops_child_entry(self):
        obj = self._model("ParentDelete")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())

    def test_nested_exit_deletion_stops_parent_exit(self):
        obj = self._model("ExitDelete")
        self.assertIs(True, obj.off())
        self.assertEqual("delete;", obj.getLog())
        self.assertEqual("On.Inner", obj.getSmFullName())

    def test_deletion_stops_later_exit_actions(self):
        obj = self._model("ExitActions")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())

    def test_cross_region_deletion_does_not_restart_source(self):
        obj = self._model("CrossDeletes")
        self.assertIs(True, obj.cross())
        self.assertEqual("A;", obj.getLog())

    def test_deleting_entry_skips_event_after_injection(self):
        obj = self._model("AfterEventDeletes")
        self.assertIs(True, obj.go())
        self.assertEqual("", obj.getLog())

    def test_deleted_object_takes_no_events(self):
        obj = self._model("NoEventsAfterDelete")
        obj.delete()
        self.assertIs(False, obj.go())
        self.assertEqual(("Shut", "Quiet", ""), (obj.getLockFullName(), obj.getAlarmFullName(), obj.getLog()))

    def test_state_dependent_boxed_types_without_body_are_none(self):
        obj = self._model("Telemetry")
        self.assertEqual((7, True, 18.5, 3), (obj.packets(), obj.ready(), obj.temperature(), obj.raw()))
        obj.disconnect()
        self.assertEqual((None, None, None, 0), (obj.packets(), obj.ready(), obj.temperature(), obj.raw()))

    def test_trait_entry_code_runs_at_super_call(self):
        self.assertEqual("trait;class;", self._model("TraitEntry").getLog())

    def test_trait_entry_code_keeps_its_guard_and_every_super_call(self):
        self.assertEqual("class;", self._model("TraitGuard").getLog())
        self.assertEqual("trait;class;trait;", self._model("TraitSuite").getLog())
        self.assertEqual("trait;class;", self._model("TraitUntagged").getLog())
        self.assertEqual("middle;class;", self._model("TraitNested").getLog())
        self.assertEqual("trait;trait;class;", self._model("TraitRepeated").getLog())
        self.assertEqual("class;", self._model("TraitOtherLanguage").getLog())
        self.assertEqual("trait;class;", self._model("TraitBilingual").getLog())
        self.assertEqual("trait;class;", self._model("TraitContinued").getLog())

    def test_plain_machine_takes_no_events_after_delete(self):
        obj = self._model("PlainDelete")
        obj.delete()
        self.assertIs(False, obj.turnOn())
        self.assertEqual("Off", obj.getSmFullName())

    def test_state_dependent_string_without_body_is_empty(self):
        obj = self._model("Ring")
        self.assertEqual("idle-ring", obj.ring())
        obj.call()
        obj.broke()
        self.assertEqual("", obj.ring())

    def test_entry_event_does_not_start_exited_timer(self):
        obj = self._model("EntryTimer")
        self.assertEqual("B", obj.getSmFullName())
        self.assertIsNone(obj._timeoutAToCHandler)
        self.assertEqual([], self._timers)

    def test_nested_auto_does_not_start_exited_timer(self):
        obj = self._model("NestedAutoTimer")
        self.assertEqual("Off", obj.getSmFullName())
        self.assertIsNone(obj._timeoutOnToOtherHandler)
        self.assertEqual([], self._timers)

    def test_entry_event_does_not_start_exited_activity(self):
        obj = self._model("EntryActivity")
        self.assertEqual("B", obj.getSmFullName())
        self.assertIsNone(obj._doActivitySmAThread)
        self.assertEqual([], self._workers(obj))
        self.assertEqual(0, obj.getCount())

    def test_reentry_starts_only_current_activity_and_delete_cancels_it(self):
        obj = self._model("ReentrantActivity")
        workers = self._workers(obj)
        self.assertEqual(2, obj.getVisits())
        self.assertEqual(1, len(workers))
        self.assertIs(workers[0], obj._doActivitySmAThread)
        obj.delete()
        self.assertTrue(all(worker.cancelled.is_set() for worker in workers))
        for worker in workers:
            worker.join(1)
            self.assertFalse(worker.is_alive())

    def test_reentry_starts_only_current_timer_and_later_action(self):
        obj = self._model("ReentrantTimer")
        self.assertEqual(2, obj.getVisits())
        self.assertEqual("A", obj.getSmFullName())
        self.assertEqual("current;", obj.getLog())
        self.assertEqual(1, len(self._timers))
        self.assertIs(self._timers[0], obj._timeoutAToCHandler._timer)
        self.assertTrue(self._timers[0].is_alive())

    def test_exit_helper_ends_entry_even_without_a_new_state(self):
        obj = self._model("ExitDuringEntry")
        self.assertEqual("A", obj.getSmFullName())
        self.assertEqual([], self._timers)

    def test_nested_auto_stops_later_region_entry(self):
        obj = self._model("AutoRegions")
        self.assertEqual("Off", obj.getSmFullName())

    def test_deep_history_still_restores_the_current_visit(self):
        obj = self._model("DeepHist")
        self.assertIs(True, obj.next())
        self.assertIs(True, obj.next())
        self.assertEqual("On.B.Y", obj.getStateFullName())
        self.assertIs(True, obj.off())
        self.assertIs(True, obj.resume())
        self.assertEqual("On.B.X", obj.getStateFullName())

    def test_deep_history_does_not_restore_an_ended_visit(self):
        obj = self._model("DeepLeaves")
        obj.next()
        obj.next()
        obj.off()
        obj.setLeaving(True)
        self.assertIs(True, obj.resume())
        self.assertEqual("Gone", obj.getStateFullName())

    def test_region_without_final_prevents_delete(self):
        obj = self._model("PartialFinal")
        self.assertIs(True, obj.finish())
        self.assertEqual("On.Done.R", obj.getSmFullName())
        self.assertEqual(0, obj.getDeletedCount())
        self.assertIs(True, obj.tick())
        self.assertEqual(0, obj.getDeletedCount())

    def test_named_region_without_final_prevents_delete(self):
        obj = self._model("NamedPartialFinal")
        self.assertIs(True, obj.finish())
        self.assertEqual(0, obj.getDeletedCount())
        self.assertIs(True, obj.tick())

    def test_empty_region_prevents_delete(self):
        obj = self._model("EmptyRegionFinal")
        self.assertIs(True, obj.finish())
        self.assertEqual(0, obj.getDeletedCount())

    def test_nested_region_final_requires_both_regions(self):
        obj = self._model("NestedRegionFinal")
        self.assertIs(True, obj.toP())
        self.assertIs(True, obj.toF())
        self.assertEqual(0, obj.getDeletes())
        self.assertIs(True, obj.second())
        self.assertEqual(1, obj.getDeletes())

    def test_direct_region_final_requires_both_regions(self):
        obj = self._model("NestedRegionFinal")
        self.assertIs(True, obj.second())
        self.assertEqual(0, obj.getDeletes())
        self.assertIs(True, obj.toG())
        self.assertEqual(1, obj.getDeletes())

    def test_parent_deletion_stops_child_setter_after_injection(self):
        obj = self._model("ParentEntryInjection")
        obj.setDeleteOnEntry(True)
        self.assertIs(True, obj.go())
        self.assertEqual("", obj.getLog())

    def test_parent_reentry_stops_obsolete_child_setter_after_injection(self):
        obj = self._model("ParentEntryInjection")
        self.assertIs(True, obj.go())
        self.assertEqual(2, obj.getVisits())
        self.assertEqual("current;", obj.getLog())

    def test_delay_deletion_does_not_create_a_timer(self):
        obj = self._model("DelayDeletes")
        self.assertTrue(obj._deleted)
        self.assertIsNone(obj._timeoutAToBHandler)
        self.assertEqual([], self._timers)

    def test_delay_leaving_does_not_create_a_timer(self):
        obj = self._model("DelayLeaves")
        self.assertEqual("B", obj.getSmFullName())
        self.assertEqual(1, obj.getCalls())
        self.assertIsNone(obj._timeoutAToCHandler)
        self.assertEqual([], self._timers)

    def test_delay_reentry_retains_only_the_new_visits_timer(self):
        obj = self._model("DelayReentry")
        self.assertEqual("A", obj.getSmFullName())
        self.assertEqual(2, obj.getCalls())
        self.assertEqual(1, len(self._timers))
        self.assertIs(self._timers[0], obj._timeoutAToCHandler._timer)
        self.assertTrue(self._timers[0].is_alive())
        obj.delete()
        self.assertTrue(all(timer.finished.is_set() for timer in self._timers))

    def test_delay_exit_invalidates_visit_without_changing_state(self):
        obj = self._model("DelayExit")
        self.assertEqual("A", obj.getSmFullName())
        self.assertIsNone(obj._timeoutAToBHandler)
        self.assertEqual([], self._timers)

    def test_current_delay_is_evaluated_once_and_starts_timer(self):
        obj = self._model("DelayStable")
        self.assertEqual(1, obj.getCalls())
        self.assertEqual(1, len(self._timers))
        self.assertIs(self._timers[0], obj._timeoutAToBHandler._timer)
        self.assertTrue(self._timers[0].is_alive())

    def test_event_before_deletion_stops_transition_action(self):
        obj = self._model("BeforeEventDeletes")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())

    def test_event_before_deletion_stops_bare_transition(self):
        obj = self._model("BeforeEventDeletesBare")
        self.assertIs(True, obj.go())
        self.assertEqual(1, obj.getDeletes())
        self.assertEqual("A", obj.getSmFullName())

    def test_native_event_before_deletion_stops_bare_transition(self):
        obj = self._model("BeforeEventDeletesNative")
        self.assertIs(True, obj.go())
        self.assertEqual(1, obj.getDeletes())
        self.assertEqual("A", obj.getSmFullName())

    def test_exit_before_deletion_stops_bare_transition(self):
        obj = self._model("BeforeExitDeletesBare")
        self.assertIs(True, obj.go())
        self.assertEqual(1, obj.getDeletes())
        self.assertEqual("On.A", obj.getSmFullName())

    def test_setter_before_deletion_stops_bare_transition(self):
        obj = self._model("BeforeSetterDeletesBare")
        self.assertIs(True, obj.go())
        self.assertEqual(1, obj.getDeletes())
        self.assertEqual("A", obj.getSmFullName())

    def test_entry_local_does_not_suppress_timer(self):
        obj = self._model("VisitLocal")
        self.assertEqual(99, obj.getCount())
        self.assertEqual(1, len(self._timers))
        self.assertIs(self._timers[0], obj._timeoutAToBHandler._timer)
        self.assertTrue(self._timers[0].is_alive())

    def test_native_entry_local_does_not_suppress_later_entry(self):
        obj = self._model("VisitNative")
        self.assertEqual(100, obj.getCount())

    def test_translated_entry_local_does_not_suppress_later_entry(self):
        obj = self._model("VisitActions")
        self.assertEqual(100, obj.getCount())

    def test_translated_setter_injections_keep_their_locals(self):
        obj = self._model("VisitInjections")
        self.assertEqual(100, obj.getCount())

    def test_native_setter_injections_keep_their_locals(self):
        obj = self._model("VisitInjectionsNative")
        self.assertEqual(100, obj.getCount())

    def test_timer_expression_import_is_not_overwritten(self):
        with patch.object(visit.visit, "duration", wraps=visit.visit.duration) as duration:
            obj = self._model("DelayClassName")
        duration.assert_called_once_with()
        self.assertEqual(1, len(self._timers))
        self.assertEqual(30.0, self._timers[0].interval)
        self.assertIs(self._timers[0], obj._timeoutAToBHandler._timer)
        self.assertTrue(self._timers[0].is_alive())

    def test_timer_temporaries_avoid_numbered_import_names(self):
        obj = self._model("DelayNumberedNames")
        self.assertEqual(1, len(self._timers))
        self.assertEqual(30.0, self._timers[0].interval)
        self.assertIs(self._timers[0], obj._timeoutAToBHandler._timer)
        self.assertTrue(self._timers[0].is_alive())

    def test_timer_delay_temporary_does_not_hide_import(self):
        obj = self._model("DelayValueName")
        self.assertEqual(1, len(self._timers))
        self.assertEqual(30.0, self._timers[0].interval)
        self.assertIs(self._timers[0], obj._timeoutAToBHandler._timer)
        self.assertTrue(self._timers[0].is_alive())

    def test_exit_in_rejected_timeout_prevents_retry(self):
        obj = self._model("RetryExit")
        first = obj._timeoutAToBHandler
        first.run()
        self.assertEqual(1, obj.getCalls())
        self.assertEqual("A", obj.getSmFullName())
        self.assertTrue(first._timer.finished.is_set())
        self.assertIs(first, obj._timeoutAToBHandler)
        self.assertEqual(1, len(self._timers))

    def test_cancelled_timeout_does_not_dispatch(self):
        obj = self._model("RetryExit")
        first = obj._timeoutAToBHandler
        obj.exitSm()
        first.run()
        self.assertEqual(0, obj.getCalls())
        self.assertIs(first, obj._timeoutAToBHandler)
        self.assertEqual(1, len(self._timers))

    def test_explicit_exit_retry_does_not_keep_process_alive(self):
        # subprocess.run kills and reaps a timed-out child, including its non-daemon timers.
        module = SmLifecycleRetryExit
        code = (
            "import sys; sys.path[:] = " + repr(sys.path) + "; "
            "from " + module.__name__ + " import SmLifecycleRetryExit; "
            "obj = SmLifecycleRetryExit(); obj._timeoutAToBHandler.run(); "
            "assert obj.getCalls() == 1; print('finished')"
        )
        result = subprocess.run([sys.executable, "-B", "-c", code], capture_output=True,
                                text=True, timeout=3)
        self.assertEqual(0, result.returncode, result.stderr)
        self.assertEqual("finished", result.stdout.strip())

    def test_first_before_injection_deletion_stops_next_injection(self):
        obj = self._model("MultipleBefore")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())

    def test_native_injection_finishes_its_block_but_stops_next_block(self):
        obj = self._model("MultipleBeforeNative")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;block;", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())
        self.assertEqual([], self._timers)

    def test_first_after_injection_deletion_stops_next_injection(self):
        obj = self._model("MultipleAfter")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())
        self.assertEqual("B", obj.getSmFullName())

    def test_setter_before_deletion_stops_next_injection(self):
        obj = self._model("MultipleSetterBefore")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())

    def test_setter_after_deletion_stops_next_injection_and_entry(self):
        obj = self._model("MultipleSetterAfter")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())
        self.assertEqual("B", obj.getSmFullName())

    def test_exit_before_deletion_stops_next_injection(self):
        obj = self._model("MultipleExitBefore")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())
        self.assertEqual("On.A", obj.getSmFullName())

    def test_exit_after_deletion_stops_next_injection(self):
        obj = self._model("MultipleExitAfter")
        self.assertIs(True, obj.go())
        self.assertEqual("delete;", obj.getLog())

    def test_native_normalized_identifier_does_not_overwrite_visit(self):
        obj = self._model("UnicodeVisit")
        self.assertEqual(100, obj.getCount())

    def test_normalized_numbered_injection_locals_are_reserved(self):
        obj = self._model("UnicodeVisitInjections")
        self.assertEqual(100, obj.getCount())

    def test_constructor_entry_deletion_stops_next_machine_and_injection(self):
        obj = self._model("ConstructorDeletes")
        self.assertTrue(obj._deleted)
        self.assertEqual("delete;", obj.getLog())
        self.assertIsNone(obj.getSecond())

    def test_constructor_entry_deletion_stops_timer_machine(self):
        obj = self._model("ConstructorTimerDeletes")
        self.assertEqual("delete;", obj.getLog())
        self.assertIsNone(obj.getSecond())
        self.assertEqual([], self._timers)

    def test_last_initial_entry_deletion_stops_constructor_injection(self):
        obj = self._model("ConstructorLastDeletes")
        self.assertTrue(obj._deleted)
        self.assertEqual("delete;", obj.getLog())

    def test_constructor_preserves_nondeleting_entry_order(self):
        obj = self._model("ConstructorOrder")
        self.assertEqual("first;second;constructor;", obj.getLog())

    def test_nested_initial_setter_deletion_stops_parent_initialization(self):
        obj = self._model("ConstructorNestedDeletes")
        self.assertTrue(obj._deleted)
        self.assertEqual("delete;", obj.getLog())
        self.assertIsNone(obj.getSm())
        self.assertIsNone(obj.getSmOn())

    def test_cancelled_timeout_cannot_continue_after_true_guard(self):
        obj = self._model("CallbackGuardExit")
        first = obj._timeoutAToBHandler
        first.run()
        self.assertTrue(first._timer.finished.is_set())
        self.assertEqual("", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())
        self.assertEqual(1, len(self._timers))

    def test_true_guard_exit_does_not_keep_process_alive(self):
        module = SmLifecycleCallbackGuardExit
        code = (
            "import sys; sys.path[:] = " + repr(sys.path) + "; "
            "from " + module.__name__ + " import SmLifecycleCallbackGuardExit; "
            "obj = SmLifecycleCallbackGuardExit(); obj._timeoutAToBHandler.run(); "
            "print('finished')"
        )
        result = subprocess.run([sys.executable, "-B", "-c", code], capture_output=True,
                                text=True, timeout=3)
        self.assertEqual(0, result.returncode, result.stderr)
        self.assertEqual("finished", result.stdout.strip())

    def test_true_guard_deletion_stops_transition_action(self):
        obj = self._model("GuardDeletes")
        self.assertIs(True, obj.go())
        self.assertTrue(obj._deleted)
        self.assertEqual("", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())

    def test_false_guard_deletion_stops_next_guard_and_fallback(self):
        obj = self._model("GuardRejectDeletes")
        self.assertIs(True, obj.go())
        self.assertTrue(obj._deleted)
        self.assertEqual("", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())

    def test_guard_deletion_stops_action_free_transition(self):
        obj = self._model("BareGuardDeletes")
        self.assertIs(True, obj.go())
        self.assertEqual("A", obj.getSmFullName())

    def test_true_guard_reentry_stops_obsolete_transition(self):
        obj = self._model("GuardReentry")
        self.assertIs(False, obj.go(True))
        self.assertEqual(1, obj.getCalls())
        self.assertEqual("", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())

    def test_false_guard_reentry_stops_fallback(self):
        obj = self._model("GuardReentry")
        self.assertIs(False, obj.go(False))
        self.assertEqual(1, obj.getCalls())
        self.assertEqual("", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())

    def test_guard_chain_keeps_first_match_and_normal_exit(self):
        obj = self._model("GuardOrder")
        self.assertIs(True, obj.go(True, True))
        self.assertEqual("guard;exit;first;9999", obj.getLog())

    def test_guard_chain_evaluates_second_guard_once(self):
        obj = self._model("GuardOrder")
        self.assertIs(True, obj.go(False, True))
        self.assertEqual("guard;guard;exit;second;9999", obj.getLog())

    def test_guard_chain_reaches_fallback_only_after_rejections(self):
        obj = self._model("GuardOrder")
        self.assertIs(True, obj.go(False, False))
        self.assertEqual("guard;guard;exit;fallback;9999", obj.getLog())

    def test_unchanged_timeout_guard_still_exits_and_enters_target(self):
        obj = self._model("CallbackGuardExit")
        first = obj._timeoutAToBHandler
        with patch.object(obj, "ready", return_value=True) as ready:
            first.run()
        ready.assert_called_once_with()
        self.assertTrue(first._timer.finished.is_set())
        self.assertEqual("action;entry;", obj.getLog())
        self.assertEqual("B", obj.getSmFullName())
        self.assertEqual(2, len(self._timers))

    def test_timeout_guard_deletion_stops_target_timer(self):
        obj = self._model("CallbackGuardExit")
        with patch.object(obj, "ready", side_effect=lambda: (obj.delete(), True)[1]):
            obj._timeoutAToBHandler.run()
        self.assertTrue(obj._deleted)
        self.assertEqual("", obj.getLog())
        self.assertEqual(1, len(self._timers))

    def test_mixed_guards_keep_priority_and_evaluate_calls_once(self):
        for choice, accepted, second, expected, calls in [
                (1, True, True, "First", 0), (0, True, True, "Called", 1),
                (2, False, True, "Second", 1), (0, False, True, "Called", 2),
                (0, False, False, "Default", 2)]:
            with self.subTest(choice=choice, accepted=accepted, second=second):
                obj = self._model("MixedGuards")
                self.assertIs(True, obj.go(choice, accepted, second, False))
                self.assertEqual(expected, obj.getSmFullName())
                self.assertEqual(calls, obj.getCalls())

    def test_mixed_guards_stop_after_same_state_reentry(self):
        for accepted in [True, False]:
            with self.subTest(accepted=accepted):
                obj = self._model("MixedGuards")
                self.assertIs(False, obj.go(2, accepted, True, True))
                self.assertEqual("A", obj.getSmFullName())
                self.assertEqual(1, obj.getCalls())

    def test_receiver_guard_deletion_stops_transition_and_fallback(self):
        peer = self._model("GuardReceiver")
        for accepted in [True, False]:
            with self.subTest(accepted=accepted):
                obj = self._model("ReceiverGuard")
                self.assertIs(True, obj.go(peer, accepted))
                self.assertTrue(obj._deleted)
                self.assertEqual("A", obj.getSmFullName())

    def test_state_dependent_guard_deletion_stops_transition_and_fallback(self):
        for accepted in [True, False]:
            with self.subTest(accepted=accepted):
                obj = self._model("DependentGuard")
                self.assertIs(True, obj.go(accepted))
                self.assertTrue(obj._deleted)
                self.assertEqual("A", obj.getSmFullName())

    def test_parent_entry_deletion_prevents_unique_registration_and_injections(self):
        obj = self._model("DeletedRecord", "same-key")
        self.assertTrue(obj._deleted)
        self.assertIsNone(type(obj).getWithCode("same-key"))
        self.assertEqual("delete;", obj.getLog())
        another = self._model("DeletedRecord", "same-key")
        self.assertIsNot(obj, another)
        self.assertIsNone(type(obj).getWithCode("same-key"))

    def test_ancestor_entry_deletion_stops_machine_free_grandchild(self):
        obj = self._model("DeletedGrandchild", "grandchild-key")
        self.assertTrue(obj._deleted)
        self.assertEqual("delete;", obj.getLog())
        self.assertIsNone(type(obj).getWithCode("grandchild-key"))

    def test_parent_entry_deletion_prevents_child_machine_entry(self):
        obj = self._model("ChildContinues")
        self.assertEqual("delete;", obj.getLog())
        self.assertIsNone(obj.getSecond())

    def test_parent_deletion_stops_ordinary_one_to_one_constructor(self):
        obj = self._model("DeletedPair", "ordinary-pair")
        self.assertEqual("delete;", obj.getLog())
        self.assertIsNone(obj.getSecond())
        self.assertIsNone(obj.getPartner())
        self.assertIsNone(type(obj).getWithCode("ordinary-pair"))

    def test_parent_deletion_stops_alternate_one_to_one_initializer(self):
        partner = self._model("DeletedPartner", "alternate-pair")
        obj = partner.getRecord()
        self.assertTrue(obj._deleted)
        self.assertEqual("delete;", obj.getLog())
        self.assertIsNone(obj.getSecond())
        self.assertIsNone(obj.getPartner())
        self.assertIsNone(type(obj).getWithCode("alternate-pair"))

    def test_alternate_initializer_uses_ancestor_flag_without_own_machine(self):
        partner = self._model("DeletedBarePartner", "alternate-bare-pair")
        obj = partner.getRecord()
        self.assertTrue(obj._deleted)
        self.assertEqual("delete;", obj.getLog())
        self.assertIsNone(obj.getPartner())
        self.assertIsNone(type(obj).getWithCode("alternate-bare-pair"))

    def test_setter_after_leave_prevents_next_injection(self):
        obj = self._model("MultipleAfterLeaves")
        self.assertEqual("B", obj.getSmFullName())
        self.assertEqual("B;", obj.getLog())

    def test_setter_after_reentry_prevents_obsolete_next_injection(self):
        obj = self._model("MultipleAfterReentry")
        self.assertEqual(2, obj.getVisits())
        self.assertEqual("A;", obj.getLog())
