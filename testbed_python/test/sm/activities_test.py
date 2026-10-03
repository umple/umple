import threading
import time
import unittest

from ImportModules import importModules

importModules(
    ["SmActivityDeletes", "SmActivityFails", "SmActivityToken", "SmCompleterFirst", "SmCompleterLast"],
    ["sm"],
)
from ImportModules import *

# The do-activity protocol. Activities wait on events the test controls, never on
# sleeps, and every activity is released or cancelled before its test ends.


def waitFor(condition, timeout=2.0):
    deadline = time.monotonic() + timeout
    while not condition():
        if time.monotonic() > deadline:
            return False
        time.sleep(0.005)
    return True


class ActivitiesTest(unittest.TestCase):
    # Exit cancels the visit's token, which the activity sees through its thread parameter
    def test_exitCancelsTheActivity(self):
        m = SmActivityToken.SmActivityToken()
        m.go()
        worker = m._doActivityStateBThread
        self.assertTrue(waitFor(lambda: m.getRuns() == 1))
        self.assertIs(True, m.back())
        worker.join(2)
        self.assertFalse(worker.is_alive())
        self.assertEqual(1, m.getStops())

    # Each visit gets its own worker and token; delete cancels without waiting
    def test_eachVisitHasItsOwnToken(self):
        m = SmActivityToken.SmActivityToken()
        m.go()
        first = m._doActivityStateBThread
        m.back()
        m.go()
        second = m._doActivityStateBThread
        self.assertIsNot(first, second)
        self.assertTrue(first.cancelled.is_set())
        self.assertFalse(second.cancelled.is_set())
        m.delete()
        self.assertTrue(second.cancelled.is_set())
        first.join(2)
        second.join(2)
        self.assertEqual(2, m.getStops())

    # The worker of the completion transition starts after the other workers of its
    # visit and fires the transition only after they finish, wherever it is declared
    def test_completionWaitsForTheOtherActivities(self):
        for cls in (SmCompleterFirst.SmCompleterFirst, SmCompleterLast.SmCompleterLast):
            gate, reached = threading.Event(), threading.Event()
            try:
                m = cls(gate, reached)
                self.assertTrue(reached.wait(2))
                self.assertIs(True, m.getSiblingsStarted())
                self.assertEqual("A", m.getStateFullName())
            finally:
                gate.set()
            self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))

    # An activity that deletes its object does not take the completion transition
    def test_deletingActivityDoesNotComplete(self):
        m = SmActivityDeletes.SmActivityDeletes()
        m._doActivityStateAThread.join(2)
        self.assertEqual("A", m.getStateFullName())

    # An activity's exception reaches threading.excepthook and the activity does not complete
    def test_failedActivityDoesNotComplete(self):
        reported = []
        previous = threading.excepthook
        threading.excepthook = lambda args: reported.append(args.exc_value)
        try:
            m = SmActivityFails.SmActivityFails()
            m._doActivityStateAThread.join(2)
        finally:
            threading.excepthook = previous
        self.assertEqual(["activity failed"], [str(e) for e in reported])
        self.assertEqual("A", m.getStateFullName())


if __name__ == "__main__":
    unittest.main()
