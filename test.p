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
        from Thread import Thread
        try :
            None Thread.sleep(1);
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
        from Thread import Thread
        Thread.currentThread().setUncaughtExceptionHandler(A.UmpleExceptionHandler())
        Thread.setDefaultUncaughtExceptionHandler(A.UmpleExceptionHandler())
        print("Preparing to launch active objects") A.A("Obj1")
        A.A("Obj2") print("Launched active objects in their own threads")

    def __str__(self):
        return str(super().__str__()) + "[" + "name" + ":" + str(self.getName()) + "]"

    class UmpleExceptionHandler(Thread.UncaughtExceptionHandler):
        def uncaughtException(self, t, e):
            self.translate(e)
            if not (e.getCause() is None) :
                self.translate(e.getCause())
            e.printStackTrace()

        def translate(self, e):
            result = new java.util.ArrayList< StackTraceElement >()
            elements = e.getStackTrace()
            try :
                for element in elements:
                    className = element.getClassName()
                    methodName = element.getMethodName()
                    methodFound = False
                    index = className.lastIndexOf('.') + 1
                    try :
                        query = this.getClass().getMethod(className.substring(index) + "_" + methodName, new Class[]{})
                        sourceInformation = query.invoke(self, new Object[]{})
                        i = 0
                        while i < sourceInformation.size() :
                            functionStart = sourceInformation.getJavaLine(i) + ((3) if ("main" == methodName) else 1)
                            functionEnd = functionStart + sourceInformation.getLength(i)
                            afterInjectionLines = 0
                            j = 0
                            while j < i :
                                if sourceInformation.getJavaLine(j) - 1 >= functionStart and sourceInformation.getJavaLine(j) - 1 <= functionEnd and sourceInformation.getJavaLine(j) - 1 <= element.getLineNumber() :
                                    if sourceInformation.getJavaLine(j) - 1 == functionStart :
                                        functionStart += sourceInformation.getLength(j) + 2
                                        functionEnd += sourceInformation.getLength(j) + 2
                                    else :
                                        afterInjectionLines += sourceInformation.getLength(j) + 2
                                        functionEnd += sourceInformation.getLength(j) + 2
                                j += 1

                            distanceFromStart = element.getLineNumber() - functionStart - afterInjectionLines
                            if distanceFromStart >= 0 and distanceFromStart <= sourceInformation.getLength(i) :
                                result.add(StackTraceElement(element.getClassName(), element.getMethodName(), sourceInformation.getFileName(i), sourceInformation.getUmpleLine(i) + distanceFromStart))
                                methodFound = True
                                break
                            i += 1

                    except :
                        pass
                    if not methodFound :
                        result.add(element)

            except :
                e1.printStackTrace()
            e.setStackTrace(result.toArray(new StackTraceElement[0]))

        def A_doActivityStateMachine1TopLevelThread1(self):
            return new UmpleSourceData().setFileNames("PtActive.ump").setUmpleLines(4).setJavaLines(123).setLengths(1)

        def A_main(self):
            return new UmpleSourceData().setFileNames("PtActive.ump").setUmpleLines(14).setJavaLines(158).setLengths(4)

    class UmpleSourceData():
        def __init__(self):
            self._umpleLengths = None
            self._umpleJavaLines = None
            self._umpleLines = None
            self._umpleFileNames = None

        def getFileName(self, i):
            return self._umpleFileNames[i]

        def getUmpleLine(self, i):
            return self._umpleLines[i]

        def getJavaLine(self, i):
            return self._umpleJavaLines[i]

        def getLength(self, i):
            return self._umpleLengths[i]

        def setFileNames(self, *filenames):
            filenames = list(filenames)
            self._umpleFileNames = filenames
            return self

        def setUmpleLines(self, *umplelines):
            umplelines = list(umplelines)
            self._umpleLines = umplelines
            return self

        def setJavaLines(self, *javalines):
            javalines = list(javalines)
            self._umpleJavaLines = javalines
            return self

        def setLengths(self, *lengths):
            lengths = list(lengths)
            self._umpleLengths = lengths
            return self

        def size(self):
            return self._umpleFileNames.length

if __name__ == "__main__" :
    A.main(sys.argv)
