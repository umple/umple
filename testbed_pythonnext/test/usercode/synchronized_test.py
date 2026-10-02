import threading
import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["SyncCounter", "SyncSubCounter", "Thermostat"], ["usercode", "test"])
from ImportModules import *


def runTogether(target, *args):
    threads = [threading.Thread(target=target, args=args) for _ in range(8)]
    for thread in threads:
        thread.start()
    for thread in threads:
        thread.join()


# Synchronized methods, and constraints reading another class's constants.
class SynchronizedTest(unittest.TestCase):
    def test_synchronizedMethodsExcludeEachOther(self):
        counter = SyncCounter.SyncCounter()
        runTogether(counter.bump, 500)
        self.assertEqual(4000, counter.getCount())

    def test_theMonitorIsReentrant(self):
        counter = SyncCounter.SyncCounter()
        self.assertEqual(1, counter.bumpOnce())

    def test_staticSynchronizedMethodsHoldTheClassMonitor(self):
        SyncCounter.SyncCounter.tallied = 0
        runTogether(SyncCounter.SyncCounter.tally, 500)
        self.assertEqual(4000, SyncCounter.SyncCounter.tallied)

    def test_aSubclassSharesItsParentsMonitor(self):
        counter = SyncSubCounter.SyncSubCounter()
        runTogether(counter.bump, 500)
        self.assertEqual(4000, counter.getCount())
        counter.reset()
        self.assertEqual(0, counter.getCount())

    def test_constraintsReadAnotherClassesConstant(self):
        thermostat = Thermostat.Thermostat()
        self.assertFalse(thermostat.check())
        thermostat.setReading(9)
        self.assertTrue(thermostat.check())
        self.assertEqual("Alarm", thermostat.getModeFullName())
        self.assertEqual(5, thermostat.clamp(5))
        with self.assertRaises(RuntimeError):
            thermostat.clamp(6)
