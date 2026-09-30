import importlib
import subprocess
import sys
import threading
import unittest
from unittest.mock import patch

from ImportModules import importModules


class GuardEffectsTest(unittest.TestCase):
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

    def _model(self, name):
        name = "SmGuard" + name
        importModules([name], ["sm"])
        obj = getattr(importlib.import_module("cruise.sm." + name), name)()
        self._objects.append(obj)
        return obj

    def _finish(self):
        try:
            for obj in self._objects:
                obj.delete()
        finally:
            # Keep failing callback regressions from leaving replacement timers alive.
            for timer in self._timers:
                timer.cancel()
            for timer in self._timers:
                if timer.ident is not None:
                    timer.join(1)
                self.assertFalse(timer.is_alive(), timer.name)

    def _cancelled_callback(self, name):
        obj = self._model(name)
        first = obj._timeoutAToBHandler
        first.run()
        self.assertTrue(first._timer.finished.is_set())
        self.assertEqual("", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())
        self.assertEqual(1, len(self._timers))

    def _armed_callback(self, name):
        obj = self._model(name)
        obj.setArmed(True)
        first = obj._timeoutAToBHandler
        first.run()
        self.assertTrue(first._timer.finished.is_set())
        self.assertEqual("", obj.getLog())
        self.assertEqual("A", obj.getSmFullName())
        self.assertEqual(1, len(self._timers))

    def test_before_getter_stops_callback(self):
        self._cancelled_callback("GetterExit")

    def test_computed_default_getter_stops_callback(self):
        self._armed_callback("DefaultExit")

    def test_reset_of_a_computed_default_stops_callback(self):
        self._armed_callback("ResetExit")

    def test_this_qualified_read_is_not_the_parameter(self):
        obj = self._model("ThisRead")
        self.assertFalse(obj.go(False))
        self.assertEqual("C", obj.getSmFullName())

    def test_this_qualified_read_of_an_inherited_attribute(self):
        obj = self._model("InheritedThisRead")
        self.assertFalse(obj.go(False))
        self.assertEqual("C", obj.getSmFullName())

    def test_after_getter_stops_callback(self):
        self._cancelled_callback("GetterAfterExit")

    def test_implicit_getter_stops_callback(self):
        self._cancelled_callback("ImplicitGetterExit")

    def test_implicit_derived_getter_stops_callback(self):
        self._cancelled_callback("DerivedExit")

    def test_explicit_derived_getter_stops_callback(self):
        self._cancelled_callback("DerivedExplicitExit")

    def test_boolean_derived_getter_stops_callback(self):
        self._cancelled_callback("DerivedBooleanExit")

    def test_direct_method_control_stops_callback(self):
        self._cancelled_callback("DirectControl")

    def test_accessor_callbacks_allow_process_exit(self):
        for name in ["GetterExit", "GetterAfterExit", "ImplicitGetterExit",
                     "DerivedExit", "DerivedExplicitExit", "DerivedBooleanExit"]:
            with self.subTest(name=name):
                obj = self._model(name)
                cls = type(obj)
                code = (
                    "import sys; sys.path[:] = " + repr(sys.path) + "; "
                    "from " + cls.__module__ + " import " + cls.__name__ + "; "
                    "obj = " + cls.__name__ + "(); obj._timeoutAToBHandler.run(); "
                    "print('finished', flush=True)"
                )
                # A timeout kills and reaps the child, including any non-daemon timers.
                result = subprocess.run([sys.executable, "-B", "-c", code],
                                        capture_output=True, text=True, timeout=3)
                self.assertEqual(0, result.returncode, result.stderr)
                self.assertEqual("finished", result.stdout.strip())

    def test_implicit_association_getter_stops_transition(self):
        obj = self._model("AssociationExit")
        self.assertIs(False, obj.go())
        self.assertEqual("A", obj.getSmFullName())

    def test_injected_association_count_stops_transition(self):
        obj = self._model("AssociationCountExit")
        self.assertIs(False, obj.go())
        self.assertEqual("A", obj.getSmFullName())

    def test_event_guard_stops_obsolete_transition(self):
        obj = self._model("EventCall")
        self.assertIs(False, obj.go())
        self.assertEqual("C", obj.getSmFullName())

    def test_false_event_guard_stops_fallback(self):
        obj = self._model("EventReject")
        self.assertIs(False, obj.go())
        self.assertEqual("C", obj.getSmFullName())

    def test_event_guard_detects_same_state_reentry(self):
        obj = self._model("EventReentry")
        self.assertIs(False, obj.go())
        self.assertEqual("A", obj.getSmFullName())

    def test_first_match_is_per_machine(self):
        obj = self._model("SharedEvent")
        self.assertIs(True, obj.go())
        self.assertEqual(("B", "B", 2),
                         (obj.getFirstFullName(), obj.getSecondFullName(), obj.getCalls()))

    def test_matched_local_avoids_parameters_and_authored_locals(self):
        for accepted, log in [(True, "32"), (False, "called;2")]:
            with self.subTest(accepted=accepted):
                obj = self._model("MatchedLocal")
                self.assertIs(True, obj.go(accepted))
                self.assertEqual("B", obj.getSmFullName())
                self.assertEqual(log, obj.getLog())

    def test_hundred_alternatives_are_lazy_ordered_and_importable(self):
        for choice in [0, 50, 99, 100]:
            with self.subTest(choice=choice):
                obj = self._model("ManyAlternatives")
                obj.setChoice(choice)
                self.assertIs(True, obj.go())
                self.assertEqual("B" if choice < 100 else "C", obj.getSmFullName())
                self.assertEqual("".join(str(i) + ";" for i in range(min(choice + 1, 100))),
                                 obj.getLog())

    def test_later_guard_reentry_stops_match_and_fallback(self):
        for choice in [50, 100]:
            with self.subTest(choice=choice):
                obj = self._model("ManyAlternatives")
                obj.setChoice(choice)
                obj.setStop(50)
                self.assertIs(False, obj.go())
                self.assertEqual("A", obj.getSmFullName())
                self.assertEqual("".join(str(i) + ";" for i in range(51)), obj.getLog())

    def test_later_guard_deletion_stops_match_and_fallback(self):
        for choice in [50, 100]:
            with self.subTest(choice=choice):
                obj = self._model("ManyAlternatives")
                obj.setChoice(choice)
                obj.setStop(50)
                obj.setDeleting(True)
                self.assertIs(True, obj.go())
                self.assertTrue(obj._deleted)
                self.assertEqual("A", obj.getSmFullName())
                self.assertEqual("".join(str(i) + ";" for i in range(51)), obj.getLog())
