'''
	Python Test for associations
'''
from TestManager import *
def test_simplePass():
    assert(4 == 4)


def test_simpleFail():
    assert(4 == 5)


def test_simpleFailNotCaught():
    assert(4 == 5)

assoSuite = Suite("cruise.statemachine.test.Associations")
def test_init():
    global assoSuite
    assoSuite.addTest(Test(assoSuite, "simplePass", TEST_PASS, test_simplePass))
    assoSuite.addTest(Test(assoSuite, "simpleFail", TEST_FAIL, test_simpleFail))
    assoSuite.addTest(Test(assoSuite, "simpleFailNotCaught", TEST_FAIL, test_simpleFailNotCaught))
    TestManager.addSuite(assoSuite)

def test_start():
    assoSuite.runTests()

