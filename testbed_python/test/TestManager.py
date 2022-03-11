import datetime
import time
TEST_PASS = "PASS"
TEST_FAIL = "FAIL"
TEST_ERROR = "ERROR"

class Test:
    def __init__(self, suite, name, outcome, function):
        self.suite = suite
        self.name = name
        self.time = 0
        self.status = "WAITING"
        
        # Type is expected outcome either pass, fail or error
        self.outcome = outcome
        self.function = function
        self.errorMsg = ""
    
    def run(self):
        self.function()

    def getName(self):
        return self.name

    def setStarted(self):
        self.time = time.time()
    
    def getTime(self):
        return self.time

    def setCompleted(self, status, errorMsg):
        self.status = status
        self.errorMsg = errorMsg
        self.time = time.time() - self.time
        print(self.time)

    def getOutput(self, className):
        out = ''
        if(self.status == "WAITING"):
            return out
        elif (self.status == TEST_PASS):
            out = '\t<testcase classname="' + className + '" name="' + self.name + '" time="' + str(self.time) + '" />\n'
        else:
            out = '\t<testcase classname="' + className + '" name="' + self.name + '" time="' + str(self.time) + '">\n'
            out += '\t\t<failure type="' + self.status + '">' + self.errorMsg + '</failure>\n'
            out += '\t</testcase>\n'
        return out

class Suite:
    def __init__(self, suiteName):
        self.tests = []
        self.name = suiteName
        self.timeStamp = 0
        self.totalTime = 0
        self.failed = 0
        self.error = 0

    def get_className(self):
        return self.name

    def set_className(self, className):
        self.name = className

    def testSize(self):
        return len(self.tests)

    def addTest(self, newTest):
        if isinstance(newTest, Test):
            self.tests.append(newTest)
            return True
        return False
    
    def runTests(self):
        self.timeStamp = datetime.datetime.now()
        for test in self.tests:
            test.setStarted()
            print("Running test: " + test.getName() + "\n")
            if (test.outcome == TEST_PASS):
                status, error = TestManager.testPass(test)
                test.setCompleted(status, error)
            elif (test.outcome == TEST_FAIL):
                status, error = TestManager.testFail(test)
                test.setCompleted(status, error)
            elif (test.outcome == TEST_ERROR):
                #status, error = TestManager.testError(test)
                test.setCompleted(status, error)
                pass
            print("Test: " + test.getName() + " completed!\n")
            self.totalTime += test.getTime()
            self.incTestStatus(status)
    
    def incTestStatus(self, status):
        if (status == TEST_FAIL):
            self.failed += 1
        elif (status == TEST_ERROR):
            self.error += 1



    def getOutput(self, path):
        fileName = path + "/TEST-" + self.name + ".xml"
        out = '<testsuite errors="' + str(self.error) + '" failures="' + str(self.failed) + \
                    '" name="' + self.name + '" tests="' + str(len(self.tests)) + '" time="0.004" timestamp="' + str(self.timeStamp) + '">\n'
        for t in self.tests:
            print(t.getName())
            out += t.getOutput(self.name)
        out += '</testsuite>\n'

        with open(fileName, 'w') as f:
            f.write('<?xml version="1.0" encoding="UTF-8" ?>\n')
            f.write(out)



class TestManager:
    suites = []

    def addSuite(newSuite):
        if isinstance(newSuite, Suite):
            TestManager.suites.append(newSuite)
            return True
        return False

    def testPass(test):
        try:
            test.run()
            print("Passed successfully")
            return (TEST_PASS, "")
        except AssertionError as e:
            print("Assertion Error")
            return (TEST_FAIL, str(e))
        except Exception as e:
            print("Exception raised: " + str(e))
            return (TEST_ERROR, str(e))

    def testFail(test):
        try:
            test.run()
            return (TEST_FAIL, "")
        except AssertionError as e:
            return (TEST_PASS, str(e))
        except Exception as e:
            return (TEST_ERROR, str(e))

    def testError(test, error):
        pass

    def getTestCount():
        totalTests = 0
        for s in TestManager.suites:
            totalTests += s.testSize()
        return totalTests

    def writeOutput(path):
        for s in TestManager.suites:
            print(s.get_className())
            s.getOutput(path)