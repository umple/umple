import unittest

# Import source generated test files
import os, sys, inspect
import importlib


def importModules(modules, local_path):
    # Get current folder
    current_dir = os.path.dirname(
        os.path.abspath(inspect.getfile(inspect.currentframe()))
    )
    # Go up one folder
    parent_dir = os.path.dirname(current_dir)

    path_separator = ""
    if os.name == "nt":
        parent_dir += "\\src-gen-umple\\cruise\\"
        path_separator = "\\"
    else:
        parent_dir += "/src-gen-umple/cruise/"
        path_separator = "/"

    # OS specific folder locations
    while len(local_path) > 0:
        parent_dir += local_path.pop(0)
        if len(local_path) > 0:
            parent_dir += path_separator

    sys.path.insert(0, parent_dir)

    for m in modules:
        try:
            globals()[m] = importlib.import_module(m)
        except Exception as e:
            raise ImportError("Error occurred importing module: " + m)
