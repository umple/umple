import inspect
import threading
import unittest
import os
import sys


class UmpleTestTableResult(unittest.TextTestResult):
    """Reports unittest results as an HTML table while keeping unittest's own failure accounting."""

    def __init__(self, stream, descriptions, verbosity):
        super().__init__(stream, descriptions, verbosity)
        self.stream = stream
        self.verbosity = verbosity
        # Drop unittest's dashed separator line
        self.separator2 = ""

        self.testid = 0
        self.success = 0
        self.failure = 0

        self.resultTable = "<div style='display: flex; flex-direction: column;'>"
        self.resultTable += "<div style='height: 35px; order: 2'></div>"
        self.resultTable += "<style> table, th, td {\
                                border-collapse: collapse;\
                                padding: 12px 15px;\
                                #text {\
                                    gap: 0px;\
                                }\
                            }</style>"
        self.resultTable += "<table style='order: 3;'>"
        self.resultTable += "<tr><td>ID</td><td>Module</td><td>Test</td><td>Status</td><td>Message</td></tr>"

    def addSuccess(self, test):
        super().addSuccess(test)
        self.resultTable += "<td style='background-color:#66CD00'>PASS</td></tr>"
        self.success += 1

    def addError(self, test, err):
        super().addError(test, err)
        self.resultTable += (
            "<td style='background-color:#FF0000'>ERROR</td><td>{}</td></tr>".format(
                err[1]
            )
        )
        self.failure += 1

    def addFailure(self, test, err):
        super().addFailure(test, err)
        # Split unittest's equality message ("2 != 3") into the report's value columns
        err_msg = str(err[1]).split("\n")[0]
        err_args = err_msg
        assert_type = ""
        if " != " in err_msg:
            err_args = err_msg.split(" != ")
            assert_type = "AssertEqual"
        elif " == " in err_msg:
            err_args = err_msg.split(" == ")
            assert_type = "AssertNotEqual"

        if err_args != err_msg:
            self.resultTable += "<td style='background-color:#FF0000'>FAIL</td><td>{}: {} with Expected={}, Actual={}</td></tr>".format(
                assert_type, err_msg, err_args[0], err_args[1]
            )
        else:
            self.resultTable += (
                "<td style='background-color:#FF0000'>FAIL</td><td>{}</td></tr>".format(
                    str(err_msg)
                )
            )

        self.failure += 1

    def addSkip(self, test, reason):
        super().addSkip(test, reason)
        self.resultTable += (
            "<td style='background-color:#00ACFF'>SKIP</td><td>{0!r}</td></tr>".format(
                reason
            )
        )

    def addUnexpectedSuccess(self, test):
        super().addUnexpectedSuccess(test)
        self.resultTable += "<td style='background-color:#FF0000'>FAIL</td><td>unexpected success</td></tr>"
        self.failure += 1

    # Opens the test's row, which the add method for its outcome completes
    def startTest(self, test):
        unittest.TestResult.startTest(self, test)
        self.testid += 1
        test_info = self.getDescription(test).split("(")
        self.resultTable += "<tr><td>{0}</td><td>{1}</td><td>{2}</td>".format(
            self.testid, test_info[1][: test_info[1].rfind(".")], test_info[0]
        )

    def finishTable(self):
        self.resultTable += "</table>"
        self.resultTable += "</div>"
        self.resultTable += "Successful: {} / {} ({}%)".format(
            self.success,
            self.success + self.failure,
            "%.2f" % (self.success / max(1, self.success + self.failure) * 100),
        )
        return self.resultTable


"""
Generates an HTML table of the test modules that imported and those that failed to import.
A module that failed to import still runs as a failing test, so the failure is also counted.
"""


def outputErrors(errorList, suites_names):
    # Adds CSS
    print(
        "<style> table {\
            font-family: arial, sans-serif;\
            border-collapse: collapse;\
            width: 100%;\
        }\
        td, th {\
            border: 1px solid #dddddd;\
            text-align: left;\
            padding: 8px;\
        }\
        tr:nth-child(odd) {\
            background-color: #eaeaea;\
        }\
        tr:first-child {\
            background-color: #a6caf0;\
            font-weight: bold \
        }\
        </style>"
    )
    if len(errorList) == 0:
        return False

    print("<table style='order: 1;'>")
    print("<tr><td>Test Name</td><td>Status</td><td>Message</td></tr>")
    for err in errorList:
        spliterr = err.split("Traceback (most recent call last):")
        spliterr[0] = spliterr[0].replace("Failed to import test module:", "")
        spliterr[0] = spliterr[0].strip()

        print("<tr>")
        print("<td>" + spliterr[0] + "</td>")  # Module name
        print("<td style='background-color:#FF0000'>Import Failed</td>")
        print("<td>" + spliterr[1] + "</td>")  # Import error
        print("</tr>")

    failed = [err.split("Traceback (most recent call last):")[0].replace("Failed to import test module:", "").strip() for err in errorList]
    for passing in [name for name in suites_names if name not in failed]:
        print("<tr>")
        print("<td>" + passing + "</td>")
        print("<td style='background-color:#66CD00'>Imported</td><td></td>")
        print("</tr>")

    print("</table>")
    return True


TEST_HOOKS = {"setUp", "tearDown", "setUpClass", "tearDownClass"}

# The number of tests in the suite (see the check after the run)
INVENTORY = 1045


def uncollectedMethods(module_name):
    """
    Public methods of the module's test classes that unittest will not run. Such a method is
    almost always a test whose name does not start with "test"; helpers start with "_".
    """
    module = sys.modules.get(module_name)
    methods = []
    for test_class in vars(module).values() if module else []:
        if inspect.isclass(test_class) and issubclass(test_class, unittest.TestCase) and test_class.__module__ == module_name:
            for name, member in vars(test_class).items():
                if inspect.isfunction(member) and name not in TEST_HOOKS and not name.startswith(("test", "_")):
                    methods.append(module_name + "." + test_class.__name__ + "." + name)
    return methods


if __name__ == "__main__":
    test_root = os.path.dirname(os.path.abspath(__file__))
    loader = unittest.TestLoader()

    suites_list = []
    suites_names = []

    for directory, _, files in sorted(os.walk(test_root)):
        for file_name in sorted(files):
            if file_name.endswith("_test.py"):
                module_path = os.path.relpath(os.path.join(directory, file_name[:-3]), test_root)
                module_name = module_path.replace(os.sep, ".")
                suites_list.append(loader.loadTestsFromName(module_name))
                suites_names.append(module_name)

    outputErrors(loader.errors, suites_names)

    uncollected = [method for name in suites_names for method in uncollectedMethods(name)]

    runner = unittest.TextTestRunner(resultclass=UmpleTestTableResult, verbosity=2)
    big_suite = unittest.TestSuite(suites_list)
    result = runner.run(big_suite)

    print(result.finishTable())
    for method in uncollected:
        print("Not run because its name does not start with test: " + method, file=sys.stderr)

    # A generated timer or activity left running would keep the process alive forever, so it is a
    # failure, and the process ends without waiting for it.
    leaked = [t.name for t in threading.enumerate() if t is not threading.main_thread() and t.is_alive() and not t.daemon]
    for name in leaked:
        print("Thread still running after the tests: " + name, file=sys.stderr)

    # A test module deleted or no longer named *_test.py would drop its tests without a failure, so
    # the run must match the inventory: the number of tests the suite had when last counted (update it
    # when adding or removing tests).
    if result.testsRun != INVENTORY:
        print("%d tests ran, not the inventory of %d: a test module is missing or misnamed, or the"
              " inventory needs updating" % (result.testsRun, INVENTORY), file=sys.stderr)
    passed = result.wasSuccessful() and result.testsRun == INVENTORY and not uncollected and not leaked
    sys.stdout.flush()
    sys.stderr.flush()
    os._exit(0 if passed else 1)
