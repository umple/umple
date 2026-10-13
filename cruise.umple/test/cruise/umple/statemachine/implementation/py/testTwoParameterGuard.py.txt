#PLEASE DO NOT EDIT THIS CODE
#This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!

from enum import Enum


class A_Guard:
    class Status(Enum):
        S1 = "S1"
        S2 = "S2"
        S3 = "S3"

        def __str__(self):
            return self.value

    def __init__(self):
        self._status = None
        self._statusVisit = 0
        self._deleted = False
        self.setStatus(__class__.Status.S1)
        if self._deleted:
            return

    def getStatusFullName(self):
        answer = str(self._status)
        return answer

    def getStatus(self):
        return self._status

    def e1(self, myB):
        if self._deleted:
            return False
        wasEventProcessed = False
        aStatus = self._status
        visit = self._statusVisit
        if aStatus is __class__.Status.S1:
            guard = self.checkGuard1(myB)
            if self._deleted:
                return True
            if self._statusVisit != visit:
                return wasEventProcessed
            if guard:
                self.setStatus(__class__.Status.S2)
                wasEventProcessed = True
        return wasEventProcessed

    def e2(self, myB, mySecondB):
        if self._deleted:
            return False
        wasEventProcessed = False
        aStatus = self._status
        visit = self._statusVisit
        if aStatus is __class__.Status.S2:
            guard = self.checkGuard1(myB)
            if self._deleted:
                return True
            if self._statusVisit != visit:
                return wasEventProcessed
            if guard:
                self.setStatus(__class__.Status.S3)
                wasEventProcessed = True
        elif aStatus is __class__.Status.S3:
            guard = self.checkGuard2(myB, mySecondB)
            if self._deleted:
                return True
            if self._statusVisit != visit:
                return wasEventProcessed
            if guard:
                self.setStatus(__class__.Status.S1)
                wasEventProcessed = True
        return wasEventProcessed

    def setStatus(self, aStatus):
        self._status = aStatus
        self._statusVisit += 1

    def delete(self):
        self._deleted = True

    def checkGuard1(self, myB):
        # line 19 "../testTwoParameterGuardPython.ump"
        return True
        # end line

    def checkGuard2(self, myB, mySecondB):
        # line 22 "../testTwoParameterGuardPython.ump"
        return True
        # end line
