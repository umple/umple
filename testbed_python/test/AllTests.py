'''
    For a test to be executed, it needs to start with test_
'''
import sys
import TestManager

print(sys.argv)

if __name__ == "__main__":
    import cruise.associations.associations
    cruise.associations.associations.test_init()
    cruise.associations.associations.test_start()

    TestManager.TestManager.writeOutput(sys.argv[2])
    


''' TODO LIST:
    - Make parameter more robust
    - Implement TestPass
    - Implement TestFail
    - Implement TestError
    - Fix enums in tests
    - Add comments
    - Add error to runTest
    - Fix time for suite output
    - Error format:
        type: junit.framework.AssertionFailedError
        message: expected X was Y
        body: which files or errors
    - Pick either Datetime or time if possible
'''