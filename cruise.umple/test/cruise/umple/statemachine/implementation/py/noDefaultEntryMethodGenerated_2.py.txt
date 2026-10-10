#PLEASE DO NOT EDIT THIS CODE
#This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!

from enum import Enum


class X:
    class Sm(Enum):
        on = "on"
        idle = "idle"
        off = "off"

        def __str__(self):
            return self.value

    def __init__(self):
        self._sm = None
        self._deleted = False
        self.setSm(__class__.Sm.on)

    def getSmFullName(self):
        answer = str(self._sm)
        return answer

    def getSm(self):
        return self._sm

    def turnOff(self):
        if self._deleted:
            return False
        wasEventProcessed = False
        aSm = self._sm
        if aSm is __class__.Sm.on:
            self.setSm(__class__.Sm.off)
            wasEventProcessed = True
        return wasEventProcessed

    def goIdle(self):
        if self._deleted:
            return False
        wasEventProcessed = False
        aSm = self._sm
        if aSm is __class__.Sm.on:
            self.setSm(__class__.Sm.idle)
            wasEventProcessed = True
        return wasEventProcessed

    def buttonPressed(self):
        if self._deleted:
            return False
        wasEventProcessed = False
        aSm = self._sm
        if aSm is __class__.Sm.idle:
            self.setSm(__class__.Sm.on)
            wasEventProcessed = True
        return wasEventProcessed

    def turnOn(self):
        if self._deleted:
            return False
        wasEventProcessed = False
        aSm = self._sm
        if aSm is __class__.Sm.off:
            self.setSm(__class__.Sm.on)
            wasEventProcessed = True
        return wasEventProcessed

    def setSm(self, aSm):
        self._sm = aSm

    def delete(self):
        self._deleted = True
