import contextlib
import io
import os
import subprocess
import sys
import unittest

from ImportModules import importModules

importModules(["MainDefault", "MainEntry"], ["usercode", "behaviour"])
from ImportModules import *

# A generated Python main.


def runScript(module):
    """Run a generated module as a script, with only the generated root on the import path."""
    root = os.path.join(os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))), "src-gen-umple")
    environment = dict(os.environ, PYTHONPATH=root)
    return subprocess.run(
        [sys.executable, module.__file__, "payload"],
        env=environment, capture_output=True, text=True, timeout=30,
    )


class MainTest(unittest.TestCase):
    # the script's main receives the full sys.argv, script path included
    def test_mainReceivesFullArgv(self):
        result = runScript(MainEntry)
        self.assertEqual(0, result.returncode, result.stderr)
        self.assertEqual("2 ['payload']", result.stdout.strip())

    # an untagged main beside a Java one is the Python main
    def test_untaggedMainBesideJavaMain(self):
        result = runScript(MainDefault)
        self.assertEqual(0, result.returncode, result.stderr)
        self.assertEqual("DEFAULT 2", result.stdout.strip())

    # a main is also an ordinary static method
    def test_mainCallableDirectly(self):
        output = io.StringIO()
        with contextlib.redirect_stdout(output):
            MainEntry.MainEntry.main(["script", "a"])
        self.assertEqual("2 ['a']", output.getvalue().strip())
