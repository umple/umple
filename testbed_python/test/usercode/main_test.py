import os
import subprocess
import sys
import unittest

# Test classes are imported dynamically
# Must be generated into ImportModules' namespace then imported
from ImportModules import importModules

importModules(["Launcher"], ["usercode", "test"])
from ImportModules import *

GENERATED_ROOT = os.path.join(os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))), "src-gen-umple")


# A Python main.
class MainTest(unittest.TestCase):
    def test_importingDoesNotRunMain(self):
        env = dict(os.environ, PYTHONPATH=GENERATED_ROOT)
        run = subprocess.run([sys.executable, "-c", "import cruise.usercode.test.Launcher"], env=env,
                             capture_output=True, text=True, timeout=60)
        self.assertEqual((0, ""), (run.returncode, run.stdout), run.stderr)

    def test_runningTheModuleCallsMainWithFullArgv(self):
        script = os.path.join(GENERATED_ROOT, "cruise", "usercode", "test", "Launcher.py")
        env = dict(os.environ, PYTHONPATH=GENERATED_ROOT)
        run = subprocess.run([sys.executable, script, "a", "b"], env=env, capture_output=True, text=True, timeout=60)
        self.assertEqual(0, run.returncode, run.stderr)
        self.assertEqual("arguments 3 ['a', 'b']\n", run.stdout)

    def test_theRunningMainClassIsTheOneOtherModulesImport(self):
        script = os.path.join(GENERATED_ROOT, "cruise", "usercode", "test", "IdentityMain.py")
        env = dict(os.environ, PYTHONPATH=GENERATED_ROOT)
        for command in ([script], ["-m", "cruise.usercode.test.IdentityMain"]):
            run = subprocess.run([sys.executable] + command, env=env, capture_output=True, text=True, timeout=60)
            self.assertEqual((0, "main\n"), (run.returncode, run.stdout), run.stderr)

    def test_theMainIsRegisteredBeforeItsClassBodyRuns(self):
        script = os.path.join(GENERATED_ROOT, "cruise", "usercode", "test", "InitMain.py")
        env = dict(os.environ, PYTHONPATH=GENERATED_ROOT)
        for command in ([script], ["-m", "cruise.usercode.test.InitMain"]):
            run = subprocess.run([sys.executable] + command, env=env, capture_output=True, text=True, timeout=60)
            self.assertEqual((0, "main\n"), (run.returncode, run.stdout), run.stderr)

