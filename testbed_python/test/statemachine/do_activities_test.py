import threading
import time
import unittest

from ImportModules import importModules

importModules(
    [
        "DoActivityDaemon", "DoActivityError", "DoActivityExit", "DoActivityRuns", "DoCompletion",
        "DoDeleteCompletion", "DoMultiple", "DoNested", "DoSiblingCompletion", "DoStaleCompletion",
    ],
    ["statemachine", "behaviour"],
)
from ImportModules import *

# Do-activity behaviour of generated Python. Each scenario also ran against the generated Java;
# Java interrupts activities, so where Python intentionally differs the test says so.
# A slow activity takes its gate, records its thread and waits for the gate the test opens; a quick
# one sets `quickDone`. The tests fix the order of events with these: joining an activity's thread
# means its completion has been handled.


def waitFor(condition, timeout=5.0):
    deadline = time.monotonic() + timeout
    while not condition():
        if time.monotonic() > deadline:
            return False
        time.sleep(0.01)
    return True


class DoActivitiesTest(unittest.TestCase):
    def _gated(self, cls, count):
        """Give the next `count` activity runs of cls a gate each; after the test every gate is
        opened and every recorded thread joined. Returns the gates."""
        gates = [threading.Event() for _ in range(count)]
        cls.gates, cls.threads, cls.quickDone = list(gates), [], threading.Event()

        def joinAll():
            for thread in cls.threads:
                thread.join(10)

        self.addCleanup(joinAll)  # runs after the gates are opened (cleanups run last first)
        for gate in gates:
            self.addCleanup(gate.set)
        return gates

    def _join(self, thread):
        thread.join(10)
        self.assertFalse(thread.is_alive(), "the activity did not finish")

    # the activity runs when the state is entered
    def test_activityRunsOnEntry(self):
        m = DoActivityRuns.DoActivityRuns()
        self.assertTrue(waitFor(lambda: m.getCount() == 1))

    # an activity of a nested state runs
    def test_nestedActivityRuns(self):
        m = DoNested.DoNested()
        self.assertTrue(waitFor(lambda: m.getCount() == 1))
        self.assertIs(True, m.go())
        self.assertEqual("On.B", m.getStateFullName())

    # every activity of the state runs
    def test_multipleActivitiesRun(self):
        m = DoMultiple.DoMultiple()
        self.assertTrue(waitFor(lambda: m.getFirst() == 1 and m.getSecond() == 1))
        self.assertIs(True, m.go())
        self.assertEqual("B", m.getStateFullName())

    # leaving the state does not wait for the activity, which is cancelled cooperatively. Java
    # interrupts the activity instead, so its count stays 0; this body is not written to stop
    # early, so it finishes.
    def test_exitDoesNotWaitForActivity(self):
        cls = DoActivityExit.DoActivityExit
        [gate] = self._gated(cls, 1)
        m = cls()
        m.go()
        self.assertTrue(waitFor(lambda: cls.threads))
        started = time.monotonic()
        self.assertIs(True, m.back())
        self.assertLess(time.monotonic() - started, 5)  # waiting for the activity would take 10 s
        self.assertEqual("A", m.getStateFullName())
        gate.set()
        self._join(cls.threads[0])
        self.assertEqual(1, m.getCount())
        self.assertEqual("A", m.getStateFullName())

    # the completion transition fires when the activity ends
    def test_completionTransition(self):
        m = DoCompletion.DoCompletion()
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))

    # completion waits for every activity of the visit
    def test_completionWaitsForSiblingActivities(self):
        cls = DoSiblingCompletion.DoSiblingCompletion
        [gate] = self._gated(cls, 1)
        m = cls()
        self.assertTrue(cls.quickDone.wait(5))
        time.sleep(0.1)  # time for a wrong implementation to complete on the quick activity alone
        self.assertEqual("A", m.getStateFullName())
        self.assertIs(False, m.getSlow())
        gate.set()
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))
        self.assertIs(True, m.getSlow())

    # an activity from an earlier visit that finishes after the state was left and re-entered does
    # not complete the new visit
    def test_staleActivityDoesNotComplete(self):
        cls = DoStaleCompletion.DoStaleCompletion
        first, second = self._gated(cls, 2)
        m = cls()
        self.assertTrue(waitFor(lambda: len(cls.threads) == 1))
        m.leave()
        m.back()
        self.assertTrue(waitFor(lambda: len(cls.threads) == 2))
        first.set()
        self._join(cls.threads[0])
        self.assertEqual("Busy.A", m.getStateFullName())
        second.set()
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "Busy.Done"))

    # deleting the object cancels its activity, whose completion then never fires
    def test_deleteCancelsCompletion(self):
        cls = DoDeleteCompletion.DoDeleteCompletion
        [gate] = self._gated(cls, 1)
        m = cls()
        self.assertTrue(waitFor(lambda: cls.threads))
        m.delete()
        gate.set()
        self._join(cls.threads[0])
        self.assertEqual("A", m.getStateFullName())

    # an exception in an activity is reported through threading.excepthook instead of being
    # swallowed
    def test_activityExceptionIsReported(self):
        reported = []
        previous = threading.excepthook
        threading.excepthook = lambda args: reported.append(args.exc_value)
        try:
            DoActivityError.DoActivityError()
            self.assertTrue(waitFor(lambda: reported))
        finally:
            threading.excepthook = previous
        self.assertIsInstance(reported[0], RuntimeError)
        self.assertEqual("boom", str(reported[0]))

    # activities run on non-daemon threads, also when the state is entered from a daemon thread
    def test_activityThreadIsNotDaemon(self):
        for daemon in (False, True):
            created = []
            starter = threading.Thread(target=lambda: created.append(DoActivityDaemon.DoActivityDaemon()), daemon=daemon)
            starter.start()
            starter.join()
            m = created[0]
            self.assertTrue(waitFor(lambda: m.getRan()))
            self.assertIs(False, m.getDaemon())
