import threading
import time
import unittest

from ImportModules import importModules

importModules(
    [
        "TimerCancel", "TimerDelete", "TimerFraction", "TimerGuardEvery", "TimerGuardOnce", "TimerNested",
        "TimerOnce", "TimerReenter", "TimerRepeated", "TimerThread", "TimerTwoMachines", "TimerZero",
    ],
    ["statemachine", "behaviour"],
)
from ImportModules import *

# Timer behaviour of generated Python. Each scenario also ran with whole seconds against the
# generated Java. Java truncates fractional delays, so these fractional-second scenarios have no
# Java control; where Python intentionally differs from Java the test says so.
# Waits for what must happen use waitFor. An operation or observation that must come before a
# timer is due is bracketed by the clock: when it ended too late to tell (a slow machine), the
# test is skipped rather than failed.


def waitFor(condition, timeout=5.0):
    deadline = time.monotonic() + timeout
    while not condition():
        if time.monotonic() > deadline:
            return False
        time.sleep(0.01)
    return True


class TimersTest(unittest.TestCase):
    def _make(self, cls):
        """A new machine and the time it was made; its timers are cancelled after the test."""
        start = time.monotonic()
        m = cls()
        self.addCleanup(m.delete)
        return m, start

    def _early(self, start, seconds, result):
        """result, if what produced it ended less than `seconds` after start; else skip the test."""
        if time.monotonic() - start >= seconds:
            self.skipTest("this machine was too slow to act before the timer was due")
        return result

    def _sleepUntil(self, start, seconds):
        time.sleep(max(0.0, start + seconds - time.monotonic()))

    # a 0.1 s timer
    def test_afterFiresOnce(self):
        m, start = self._make(TimerOnce.TimerOnce)
        self.assertEqual("A", self._early(start, 0.09, m.getStateFullName()))
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))
        time.sleep(0.2)
        self.assertEqual(1, m.getCount())

    # delays are float seconds and are not truncated (0.8 s here);
    # the transition action records when the timer fired
    def test_fractionalDelay(self):
        m, start = self._make(TimerFraction.TimerFraction)
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))
        self.assertGreaterEqual(m.getFiredAt() - start, 0.75)

    # a zero delay cannot fire before the timer is published
    def test_zeroDelay(self):
        for _ in range(20):
            m, _ = self._make(TimerZero.TimerZero)
            self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))

    # leaving the state cancels its timer (due after 0.5 s)
    def test_exitCancelsTimer(self):
        m, start = self._make(TimerCancel.TimerCancel)
        self.assertIs(True, self._early(start, 0.45, m.cancel()))
        self._sleepUntil(start, 0.8)
        self.assertEqual("C", m.getStateFullName())
        self.assertEqual(0, m.getCount())

    # delete cancels the timer (due after 0.5 s). Java still fires it after delete.
    def test_deleteCancelsTimer(self):
        start = time.monotonic()
        m = TimerDelete.TimerDelete()
        self._early(start, 0.45, m.delete())
        self._sleepUntil(start, 0.8)
        self.assertEqual("A", m.getStateFullName())
        self.assertEqual(0, m.getCount())

    # after leaving and re-entering, only the new visit's timer fires (both are 0.5 s timers)
    def test_reentryRestartsTimer(self):
        m, start = self._make(TimerReenter.TimerReenter)
        time.sleep(0.3)
        self.assertIs(True, self._early(start, 0.45, m.cancel()))
        self.assertIs(True, m.restart())
        restarted = time.monotonic() - start
        self._sleepUntil(start, max(0.6, restarted + 0.1))  # the first visit's timer was due at 0.5 s
        # the second visit's timer is due at restarted + 0.5 s
        observed = self._early(start, restarted + 0.45, (m.getStateFullName(), m.getCount()))
        self.assertEqual(("A", 0), observed)
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))
        time.sleep(0.2)
        self.assertEqual(1, m.getCount())

    # a timed transition whose guard is false is retried
    def test_afterRetriesWhileGuardIsFalse(self):
        m, _ = self._make(TimerGuardOnce.TimerGuardOnce)
        time.sleep(0.25)
        self.assertEqual("A", m.getStateFullName())
        m.setReady(True)
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))
        time.sleep(0.25)
        self.assertEqual(1, m.getCount())

    # leaving the state stops the retries (Java leaks a timer here)
    def test_afterEveryRetryStopsOnExit(self):
        m, _ = self._make(TimerGuardEvery.TimerGuardEvery)
        time.sleep(0.25)
        self.assertIs(True, m.cancel())
        m.setReady(True)
        time.sleep(0.25)
        self.assertEqual("C", m.getStateFullName())
        self.assertEqual(0, m.getCount())

    def test_afterEveryFiresWhenGuardBecomesTrue(self):
        m, _ = self._make(TimerGuardEvery.TimerGuardEvery)
        time.sleep(0.15)
        m.setReady(True)
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))
        self.assertEqual(1, m.getCount())

    # afterEvery with a self transition fires repeatedly until the state is left; here the third
    # firing leaves it through an automatic transition, on the timer's own thread, so no other
    # thread races with the callbacks
    def test_afterEveryRepeatsUntilExit(self):
        m, _ = self._make(TimerRepeated.TimerRepeated)
        self.assertTrue(waitFor(lambda: m.getStateFullName() == "B"))
        time.sleep(0.3)
        self.assertEqual(3, m.getCount())
        self.assertEqual("B", m.getStateFullName())

    # leaving the enclosing state cancels a nested state's timer (0.5 s)
    def test_nestedTimerCancelledByParentExit(self):
        m, start = self._make(TimerNested.TimerNested)
        self.assertIs(True, self._early(start, 0.45, m.off()))
        self._sleepUntil(start, 0.8)
        self.assertEqual("Off", m.getStateFullName())
        self.assertEqual(0, m.getCount())

    # timers of two machines reusing state names both run
    def test_timersOfTwoMachines(self):
        m, _ = self._make(TimerTwoMachines.TimerTwoMachines)
        self.assertTrue(waitFor(lambda: m.getOneFullName() == "B" and m.getTwoFullName() == "B"))
        self.assertEqual(1, m.getCountOne())
        self.assertEqual(1, m.getCountTwo())

    # a pending timer runs on a non-daemon thread, so it keeps the process alive, even when the
    # state was entered from a daemon thread
    def test_timerThreadIsNotDaemon(self):
        for daemon in (False, True):
            before = set(threading.enumerate())
            created = []
            starter = threading.Thread(target=lambda: created.append(TimerThread.TimerThread()), daemon=daemon)
            starter.start()
            starter.join()
            self.assertTrue(created, "construction failed")
            self.addCleanup(created[0].delete)
            started = [t for t in threading.enumerate() if t not in before and t is not starter and t.is_alive()]
            self.assertTrue(started, "no timer thread is pending")
            self.assertEqual([False] * len(started), [t.daemon for t in started])
