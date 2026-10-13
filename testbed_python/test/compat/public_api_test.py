import json
import os
import sys
import unittest

import ImportModules

# The public API of the Python the previous generator produced for the testbed models, which this
# generator keeps: module paths, class names and bases, method names, parameter names and order,
# static and class methods, nested enum members and class constants. testbed_api.json records it;
# its "excluded" list names each member left out and why (internal helpers, and the intentional
# changes that ledger_test.py asserts instead). The comparison is the one the corpus gate uses for
# the UmpleOnline examples' baselines.

HERE = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, os.path.join(HERE, os.pardir, os.pardir, os.pardir, "build"))
from python_corpus_gate import api_differences

BASELINE = json.load(open(os.path.join(HERE, "testbed_api.json")))


def load(module):
    """The generated module, imported through its package as every testbed test imports it."""
    parts = module.split(".")
    ImportModules.importModules([parts[-1]], parts[1:-1])
    return getattr(ImportModules, parts[-1])


class PublicApiTest(unittest.TestCase):
    def test_testbedPublicApi(self):
        problems = api_differences(BASELINE["modules"], load)
        self.assertFalse(problems, "%d differences:\n" % len(problems) + "\n".join(problems))
