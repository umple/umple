from enum import Enum, auto
import sys

class A():
    class StateMachine1(Enum):
        def _generate_next_value_(name, start, count, last_values):
            return name
        def __str__(self):
            return str(self.value)
        topLevel = auto()

    class StateMachine1TopLevel(Enum):
        def _generate_next_value_(name, start, count, last_values):
            return name
        def __str__(self):
            return str(self.value)
        Null = auto()
        thread1 = auto()

    def __init__(self, aName):
        self._doActivityStateMachine1TopLevelThread1Thread = None
        self._stateMachine1TopLevel = None
        self._stateMachine1 = None
        self._name = None
        self._name = aName
        self.setStateMachine1TopLevel(A.StateMachine1TopLevel.Null)
        self.setStateMachine1(A.StateMachine1.topLevel)

    def setName(self, aName):
        wasSet = False
        self._name = aName
        wasSet = True
        return wasSet

    def getName(self):
        return self._name

    def getStateMachine1FullName(self):
        answer = self._stateMachine1.__str__()
        if self._stateMachine1TopLevel != A.StateMachine1TopLevel.Null :
            answer += "." + self._stateMachine1TopLevel.__str__()
        return answer

    def getStateMachine1(self):
        return self._stateMachine1

    def getStateMachine1TopLevel(self):
        return self._stateMachine1TopLevel

    def exitStateMachine1(self):
        if self._stateMachine1 == A.StateMachine1.topLevel :
            self.exitStateMachine1TopLevel()

    def setStateMachine1(self, aStateMachine1):
        self._stateMachine1 = aStateMachine1
        if self._stateMachine1 == A.StateMachine1.topLevel :
            if self._stateMachine1TopLevel == A.StateMachine1TopLevel.Null :
                self.setStateMachine1TopLevel(A.StateMachine1TopLevel.thread1)

    def exitStateMachine1TopLevel(self):
        if self._stateMachine1TopLevel == A.StateMachine1TopLevel.thread1 :
            if not (self._doActivityStateMachine1TopLevelThread1Thread is None) :
                self._doActivityStateMachine1TopLevelThread1Thread.interrupt()
            self.setStateMachine1TopLevel(A.StateMachine1TopLevel.Null)

    def setStateMachine1TopLevel(self, aStateMachine1TopLevel):
        self._stateMachine1TopLevel = aStateMachine1TopLevel
        if self._stateMachine1 != A.StateMachine1.topLevel and aStateMachine1TopLevel != A.StateMachine1TopLevel.Null :
            self.setStateMachine1(A.StateMachine1.topLevel)
        if self._stateMachine1TopLevel == A.StateMachine1TopLevel.thread1 :
            self._doActivityStateMachine1TopLevelThread1Thread = A.DoActivityThread(self, "doActivityStateMachine1TopLevelThread1")

    def doActivityStateMachine1TopLevelThread1(self):
        try :
            print("Object " + self.getName() + "is now active")
            for i in range(1, 9):
                print(" " + self._name + " was here") print(" " + self._name + " was also here")
                time.sleep(1) print(" " + self._name + " was here too")
                time.sleep(0.001)

        except :
            pass

    class DoActivityThread(Thread):
        def __init__(self, aController, aDoActivityMethodName):
            self._doActivityMethodName = None
            self._controller = None
            self._controller = aController
            self._doActivityMethodName = aDoActivityMethodName
            start()

        def run(self):
            if "doActivityStateMachine1TopLevelThread1" == self._doActivityMethodName :
                self._controller.doActivityStateMachine1TopLevelThread1()

    def delete(self):
        pass

    @staticmethod
    def main(argv):
        print("Preparing to launch active objects")
        A.A("Obj1")
        A.A("Obj2")
        print("Launched active objects in their own threads")

    def __str__(self):
        return str(super().__str__()) + "[" + "name" + ":" + str(self.getName()) + "]"

if __name__ == "__main__" :
    A.main(sys.argv)
