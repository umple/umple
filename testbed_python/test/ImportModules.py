import unittest

# Import source generated test files
import os, sys, inspect
import importlib


def importModules(modules, local_path):
    # Get current folder
    current_dir = os.path.dirname(
        os.path.abspath(inspect.getfile(inspect.currentframe()))
    )

    # Generated classes are imported as users import them: through their package
    # (cruise.<path>.<Class>) with only the generated root on sys.path, so a generated module that
    # imports another one without its package fails here too. Each module is exposed under its
    # short name.
    package = ".".join(["cruise"] + local_path)
    generated_root = os.path.join(os.path.dirname(current_dir), "src-gen-umple")
    if generated_root not in sys.path:
        sys.path.insert(0, generated_root)

    for m in modules:
        try:
            globals()[m] = importlib.import_module(package + "." + m)
        except Exception as e:
            raise ImportError("Error occurred importing module: " + m) from e
