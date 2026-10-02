import unittest
import os

"""
Formats the output of the tests to be more user-friendly
Currently outputted as a table in order to increase readability.
"""


class UmpleTestTableResult(unittest.TextTestResult):
    """
    Opens tag for results table and adds a little css
    Adds the top row of table
    """

    def __init__(self, stream, descriptions, verbosity):
        super().__init__(stream, descriptions, verbosity)
        self.stream = stream
        self.verbosity = verbosity
        # Removes a useless line of '-'
        self.separator2 = ""

        # Used to calculate % of passing tests
        self.testid = 0
        self.success = 0
        self.failure = 0

        # Container for the table
        self.resultTable = "<div style='display: flex; flex-direction: column;'>"
        # Separator div to add spacing between tables
        self.resultTable += "<div style='height: 35px; order: 2'></div>"
        # Creates HTML table
        self.resultTable += "<style> table, th, td {\
                                border-collapse: collapse;\
                                padding: 12px 15px;\
                                #text {\
                                    gap: 0px;\
                                }\
                            }</style>"
        self.resultTable += "<table style='order: 3;'>"
        self.resultTable += "<tr><td>ID</td><td>Module</td><td>Test</td><td>Status</td><td>Message</td></tr>"

    """
    Called after a test passes
    Adds output to results table
    """

    def addSuccess(self, test):
        self.resultTable += "<td style='background-color:#66CD00'>PASS</td></tr>"
        self.success += 1

    """
    Called after a test throws an error
    Adds output to results table
    """

    def addError(self, test, err):
        self.resultTable += (
            "<td style='background-color:#FF0000'>ERROR</td><td>{}</td></tr>".format(
                err[1]
            )
        )
        self.failure += 1

    """
    Called after a test does not satisfy the expected results
    Adds output to results table
    """

    def addFailure(self, test, err):
        # Format failure message to be more tester friendly
        # Original format looks like "2 == 2" or "2 != 2"
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

    """
    Called after a test is skipped
    Adds output to results table
    """

    def addSkip(self, test, reason):
        self.resultTable += (
            "<td style='background-color:#00ACFF'>SKIP</td><td>{0!r}</td></tr>".format(
                reason
            )
        )

    """
    Called after a test passes unexpectedly
    Adds output to results table
    """

    def addUnexpectedSuccess(self, test):
        self.resultTable += "<td style='background-color:#FF0000'>FAIL</td><td>unexpected success</td></tr>"
        self.failure += 1

    """
    Called after a test passes
    Adds output to results table
    """

    def startTest(self, test):
        unittest.TestResult.startTest(self, test)
        self.testid += 1
        test_info = self.getDescription(test).split("(")
        self.resultTable += "<tr><td>{0}</td><td>{1}</td><td>{2}</td>".format(
            self.testid, test_info[1][: test_info[1].rfind(".")], test_info[0]
        )

    """
    Called once all tests are ran to finish of the HTML table
    Prints results as a percentage
    """

    def __del__(self):
        global testResults
        self.resultTable += "</table>"
        self.resultTable += "</div>"
        self.resultTable += "Successful: {} / {} ({}%)".format(
            self.success,
            self.success + self.failure,
            "%.2f" % (self.success / (self.success + max(1, self.failure)) * 100),
        )
        testResults = self.resultTable


"""
Removes any tests that were unsucessfully imported.
Generates an HTML table of imports that failed and passed and returns it.

Use-case:
When Python imports files, it might throw an error if any issues arise in the files being imported
Assuming all tests can be imported successfully, this function serves no purpose.
However, if someone breaks a test, this allows us to still have an easily readable output.
"""


def outputErrors(errorList, suites_names, suites_list):
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

        # Get the index of the error message and remove it for rerun
        err_index = suites_names.index(spliterr[0])
        if spliterr[0] in suites_names:
            del suites_names[err_index]
            del suites_list[err_index]

        print("<tr>")
        print("<td>" + spliterr[0] + "</td>")  # Module name
        print("<td style='background-color:#FF0000'>Import Failed</td>")
        print("<td>" + spliterr[1] + "</td>")  # Import error
        print("</tr>")

    for passing in suites_names:
        print("<tr>")
        print("<td>" + passing + "</td>")
        print("<td style='background-color:#66CD00'>Imported</td><td></td>")
        print("</tr>")

    print("</table>")
    return True


testResults = None
if __name__ == "__main__":
    path_list = ["associations", "attributes", "patterns", "statemachine"]
    loader = unittest.TestLoader()

    suites_list = []
    suites_names = []

    for path in path_list:
        dir_list = os.listdir(os.path.dirname(os.path.abspath(__file__)) + "/" + path)

        for file_name in dir_list:
            # optional_one_to_one_test.py is currently broken and will be enabled soon
            if ("test.py" in file_name and not "optional_one_to_one_test.py" in file_name):
                file_no_ext = file_name.rsplit(".", 1)[0]
                suite = loader.loadTestsFromName(path + "." + file_no_ext)
                suites_list.append(suite)
                suites_names.append(file_no_ext)

    outputErrors(loader.errors, suites_names, suites_list)

    runner = unittest.TextTestRunner(resultclass=UmpleTestTableResult, verbosity=2)
    big_suite = unittest.TestSuite(suites_list)
    runner.run(big_suite)

    print(testResults)
