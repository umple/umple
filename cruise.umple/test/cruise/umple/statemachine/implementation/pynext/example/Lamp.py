#PLEASE DO NOT EDIT THIS CODE
#This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!

from enum import Enum
import threading


class Lamp:
    """A do activity in each of two states of one machine"""

    class Status(Enum):
        On = "On"
        Off = "Off"

        def __str__(self):
            return self.value

    class DoActivityThread(threading.Thread):
        def __init__(self, controller, doActivityMethodName):
            super().__init__(daemon=False)
            self._controller = controller
            self._doActivityMethodName = doActivityMethodName
            self._siblings = ()
            self.cancelled = threading.Event()

        @staticmethod
        def startAll(*workers):
            for worker in workers:
                worker._siblings = tuple(other for other in workers if other is not worker)
            for worker in workers:
                if worker._controller._deleted or worker.cancelled.is_set():
                    return
                worker.start()

        def run(self):
            controller = self._controller
            if self._doActivityMethodName == "doActivityStatusOn":
                controller.doActivityStatusOn(self)
            elif self._doActivityMethodName == "doActivityStatusOff":
                controller.doActivityStatusOff(self)

    def __init__(self):
        self._status = None
        self._doActivityStatusOnThread = None
        self._doActivityStatusOffThread = None
        self._deleted = False
        self.setStatus(__class__.Status.On)
        if self._deleted:
            return

    def getStatusFullName(self):
        answer = str(self._status)
        return answer

    def getStatus(self):
        return self._status

    def press(self):
        if self._deleted:
            return False
        wasEventProcessed = False
        aStatus = self._status
        if aStatus is __class__.Status.On:
            self.exitStatus()
            if self._deleted:
                return True
            self.setStatus(__class__.Status.Off)
            wasEventProcessed = True
        elif aStatus is __class__.Status.Off:
            self.exitStatus()
            if self._deleted:
                return True
            self.setStatus(__class__.Status.On)
            wasEventProcessed = True
        return wasEventProcessed

    def exitStatus(self):
        if self._status is __class__.Status.On:
            if self._doActivityStatusOnThread is not None:
                self._doActivityStatusOnThread.cancelled.set()
        elif self._status is __class__.Status.Off:
            if self._doActivityStatusOffThread is not None:
                self._doActivityStatusOffThread.cancelled.set()

    def setStatus(self, aStatus):
        self._status = aStatus
        if self._status is __class__.Status.On:
            self._doActivityStatusOnThread = __class__.DoActivityThread(self, "doActivityStatusOn")
            __class__.DoActivityThread.startAll(self._doActivityStatusOnThread)
        elif self._status is __class__.Status.Off:
            self._doActivityStatusOffThread = __class__.DoActivityThread(self, "doActivityStatusOff")
            __class__.DoActivityThread.startAll(self._doActivityStatusOffThread)

    def doActivityStatusOn(self, thread):
        # line 12 "../doActivityMultiplePython.ump"
        self.alsoDo()
        # end line

    def doActivityStatusOff(self, thread):
        # line 18 "../doActivityMultiplePython.ump"
        self.keepDoing()
        # end line

    def delete(self):
        self._deleted = True
        if self._doActivityStatusOnThread is not None:
            self._doActivityStatusOnThread.cancelled.set()
        if self._doActivityStatusOffThread is not None:
            self._doActivityStatusOffThread.cancelled.set()

    def alsoDo(self):
        # line 21 "../doActivityMultiplePython.ump"
        pass
        # end line

    def keepDoing(self):
        # line 22 "../doActivityMultiplePython.ump"
        pass
        # end line
