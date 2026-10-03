import time
import unittest

from ImportModules import importModules

importModules(
    [
        "SmHelperNames", "SmTimerDerived", "SmTimerFraction", "SmTimerQuick", "SmTimerRetry", "SmTimerStale",
        "SmTimerTwo", "SmTimerZero",
    ],
    ["sm"],
)
from ImportModules import *

# The timer protocol. Most timers here are set to 30 seconds so that they never fire
# during a test: a test calls a handler's callback itself at the moment it wants to check, which
# makes the check deterministic. tearDown deletes every object, which cancels its pending timers.


def waitFor(condition, timeout=2.0):
    deadline = time.monotonic() + timeout
    while not condition():
        if time.monotonic() > deadline:
            return False
        time.sleep(0.005)
    return True


class LeavesDuringTimeout(SmTimerRetry.SmTimerRetry):
    """The timeout event leaves the state and is rejected."""

    def timeoutAToB(self):
        self.leave()
        return False


class DeletesDuringTimeout(SmTimerRetry.SmTimerRetry):
    """The timeout event deletes the object and is rejected."""

    def timeoutAToB(self):
        self.delete()
        return False


class ReentersDuringTimeout(SmTimerRetry.SmTimerRetry):
    """The timeout event leaves and re-enters the state, which arms a new timer, and is rejected."""

    def timeoutAToB(self):
        self.leave()
        self.back()
        self.replacement = self._timeoutAToBHandler
        return False


class TimersTest(unittest.TestCase):
    def setUp(self):
        self.objects = []

    def tearDown(self):
        for m in self.objects:
            m.delete()

    def _new(self, cls):
        m = cls()
        self.objects.append(m)
        return m

    # A current callback fires the timeout event
    def test_currentCallbackFires(self):
        m = self._new(SmTimerStale.SmTimerStale)
        m._timeoutAToBHandler.run()
        self.assertEqual("B", m.getStateFullName())
        self.assertEqual(1, m.getCount())

    # A callback that runs after its state was left does nothing
    def test_callbackAfterExitIsSuppressed(self):
        m = self._new(SmTimerStale.SmTimerStale)
        handler = m._timeoutAToBHandler
        m.leave()
        handler.run()
        self.assertEqual("C", m.getStateFullName())
        self.assertEqual(0, m.getCount())
        self.assertIs(handler, m._timeoutAToBHandler)

    # After leaving and re-entering, only the new visit's timer fires
    def test_callbackOfEarlierVisitIsSuppressed(self):
        m = self._new(SmTimerStale.SmTimerStale)
        old = m._timeoutAToBHandler
        m.leave()
        m.back()
        new = m._timeoutAToBHandler
        self.assertIsNot(old, new)
        old.run()
        self.assertEqual("A", m.getStateFullName())
        self.assertEqual(0, m.getCount())
        new.run()
        self.assertEqual("B", m.getStateFullName())
        self.assertEqual(1, m.getCount())

    # Delete cancels the timer, and a callback that was already under way does nothing
    def test_deleteCancelsTheTimer(self):
        m = self._new(SmTimerStale.SmTimerStale)
        handler = m._timeoutAToBHandler
        m.delete()
        handler._timer.join(2)
        self.assertFalse(handler._timer.is_alive())
        handler.run()
        self.assertEqual("A", m.getStateFullName())
        self.assertEqual(0, m.getCount())

    # A timeout whose guard is false arms the timer again, and fires once the guard holds
    def test_rejectedTimeoutArmsTheTimerAgain(self):
        m = self._new(SmTimerRetry.SmTimerRetry)
        first = m._timeoutAToBHandler
        first.run()
        second = m._timeoutAToBHandler
        self.assertIsNot(first, second)
        self.assertEqual("A", m.getStateFullName())
        m.setReady(True)
        second.run()
        self.assertEqual("B", m.getStateFullName())
        self.assertEqual(1, m.getCount())

    # A rejected timeout is not retried when the event itself left the state, deleted the
    # object, or re-entered the state and so armed a new timer, which stays in place
    def test_retryIsCheckedAfterTheEvent(self):
        m = self._new(LeavesDuringTimeout)
        handler = m._timeoutAToBHandler
        handler.run()
        self.assertEqual("C", m.getStateFullName())
        self.assertIs(handler, m._timeoutAToBHandler)

        m = self._new(DeletesDuringTimeout)
        handler = m._timeoutAToBHandler
        handler.run()
        self.assertIs(handler, m._timeoutAToBHandler)

        m = self._new(ReentersDuringTimeout)
        handler = m._timeoutAToBHandler
        handler.run()
        self.assertEqual("A", m.getStateFullName())
        self.assertIs(m.replacement, m._timeoutAToBHandler)
        self.assertIsNot(handler, m.replacement)

    # Delays are float seconds, not truncated
    def test_fractionalDelay(self):
        m = self._new(SmTimerFraction.SmTimerFraction)
        self.assertEqual(0.25, m._timeoutAToBHandler._timer.interval)
        m = self._new(SmTimerQuick.SmTimerQuick)
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))

    # The handler is published before its timer starts, so a zero delay always fires once
    def test_zeroDelay(self):
        machines = [self._new(SmTimerZero.SmTimerZero) for _ in range(30)]
        for m in machines:
            self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))
            self.assertEqual(1, m.getCount())

    # Two machines with the same timed transition get their own handlers; as in Java, the timeout
    # event reaches every machine that handles it
    def test_timersOfTwoMachines(self):
        m = self._new(SmTimerTwo.SmTimerTwo)
        one = m._one_timeoutAToBHandler
        two = m._two_timeoutAToBHandler
        self.assertIsNot(one, two)
        one.run()
        self.assertEqual("B", m.getOneFullName())
        self.assertEqual("B", m.getTwoFullName())
        two.run()
        self.assertEqual("B", m.getTwoFullName())

    # Delete stops the timers of the class and its parent, and the fields that
    # implement this never take the name of a subclass's attribute
    def test_inheritedTimersAndHelperNames(self):
        m = self._new(SmTimerDerived.SmTimerDerived)
        self.assertEqual(0, m.getDeleted())
        handlers = [m._timeoutAToBHandler, m._timeoutXToYHandler]
        m.delete()
        self.assertEqual(0, m.getDeleted())
        for handler in handlers:
            handler._timer.join(2)
            self.assertFalse(handler._timer.is_alive())
            handler.run()
        self.assertEqual("A", m.getBaseFullName())
        self.assertEqual("X", m.getOwnFullName())
        self.assertEqual(0, m.getCount())

    # The helper classes and fields never take a model method's name
    def test_helperNamesLeaveModelMethodsAlone(self):
        m = self._new(SmHelperNames.SmHelperNames)
        self.assertEqual("timer", m.TimedEventHandler())
        self.assertEqual("worker", m.DoActivityThread())
        self.assertEqual("handler", m._timeoutAToBHandler())
        workers = [t for t in vars(m).values() if hasattr(t, "cancelled")]
        m.delete()
        for worker in workers:
            worker.join(2)
            self.assertFalse(worker.is_alive())


if __name__ == "__main__":
    unittest.main()
