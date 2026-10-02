import subprocess
import sys
import time
import unittest

from ImportModules import importModules

importModules(["SmQueuedGarage", "SmPooledOrder", "SmQueuedWorker", "SmQueuedTimer"], ["sm"])
from ImportModules import *


def waitFor(condition, seconds=3):
    end = time.time() + seconds
    while not condition() and time.time() < end:
        time.sleep(0.01)
    return condition()


# Queued and pooled machines and queued methods.
class QueuedTest(unittest.TestCase):
    def test_eventsRunInOrderOnTheWorker(self):
        garage = SmQueuedGarage.SmQueuedGarage()
        self.assertIsNone(garage.close())
        garage.done()
        garage.open(3)
        self.assertTrue(waitFor(lambda: garage.getOpened() == 3))
        self.assertEqual("Open", garage.getStatusFullName())
        garage.delete()

    def test_pooledEventsWaitForAStateThatTakesThem(self):
        order = SmPooledOrder.SmPooledOrder()
        order.finish()
        time.sleep(0.2)
        self.assertEqual(("A", ""), (order.getStatusFullName(), order.getLog()))
        order.go()
        self.assertTrue(waitFor(lambda: order.getStatusFullName() == "C"))
        self.assertEqual("gf", order.getLog())
        order.delete()

    def test_queuedMethodsRunInOrder(self):
        worker = SmQueuedWorker.SmQueuedWorker()
        for n in range(5):
            worker.work(n)
        self.assertTrue(waitFor(lambda: worker.getLog() == "01234"))
        worker.delete()

    def test_aQueuedTimeoutIsProcessedByTheWorker(self):
        timed = SmQueuedTimer.SmQueuedTimer()
        self.assertTrue(waitFor(lambda: timed.getSmFullName() == "B"))
        timed.delete()

    def test_deleteDropsTheCallsStillWaiting(self):
        garage = SmQueuedGarage.SmQueuedGarage()
        garage.delete()
        garage.close()
        time.sleep(0.2)
        self.assertEqual("Open", garage.getStatusFullName())

    def test_theProgramEndsOnceItsQueuesAreIdle(self):
        # Java's worker runs until the object is deleted; Python's ends once nothing can reach it
        code = ("import sys; sys.path[:] = " + repr(sys.path) + "; "
                "from " + SmQueuedGarage.__name__ + " import SmQueuedGarage; "
                "import atexit; garage = SmQueuedGarage(); garage.close(); garage.done(); garage.open(4); "
                "atexit.register(lambda: print(garage.getStatusFullName(), garage.getOpened()))")
        result = subprocess.run([sys.executable, "-B", "-c", code], capture_output=True, text=True, timeout=10)
        self.assertEqual((0, "Open 4"), (result.returncode, result.stdout.strip()), result.stderr)
