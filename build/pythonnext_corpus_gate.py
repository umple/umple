"""Corpus gate for the Python generator.

Every model listed in pythonnext_corpus_manifest.json is generated into its own directory, together
with the files it includes with `use`, and checked against its expected outcome:

  supported           generation succeeds with no error, and so does the Java generation of the
                      same model, which lists the classes and public methods to expect; there is
                      a Python module for every Java class, and each class has a callable for
                      every public Java method (toString as __str__, hashCode as __hash__) except
                      a sorted association's comparator accessors and the methods a
                      warning 9212 at that class (or at a trait it uses) names as having code
                      only for other languages; every module compiles and imports through its package (only the
                      generated root on sys.path, a fresh interpreter per module); every class
                      with a main, and every class with a Python or untagged main in the model,
                      has the launcher, and every launcher exits 0 within the timeout with no
                      standard input (printing the manifest's expected output, where it has one)
  generation-only     the model's own code is not Python (for example Java method bodies, which
                      are taken as native Python), so its output cannot compile: generation
                      and the Java generation succeed, every Java class has its module, and each
                      module's class body defines every expected method; nothing is compiled
  unsupported CODES   generation fails with exactly the Umple errors CODES (comma-separated); for
                      9210 and 9213 the class the diagnostic points at has no module, and the
                      modules still written for the other classes compile, unless the entry reads
                      "unsupported CODES generation-only" (the model's own code is not Python)
  invalid CODES       the model is not valid Umple: generation fails with exactly the errors CODES
  fragment            not a model on its own; not generated

Supported cases with an entry in pythonnext_corpus_api.json must also keep that public API: module
paths, class names and bases, method signatures, enum members and constants.

A corpus file missing from the manifest, a manifest entry whose file is gone, or a case that does
not behave as expected fails the gate. Usage (from the repository root):

  python3 build/pythonnext_corpus_gate.py [--jar dist/umple.jar] [--output dist/python-corpus-gate]
                                      [--jobs N] [--timeout SECONDS] [--only TEXT ...]
"""
import argparse
import concurrent.futures
import hashlib
import inspect
import json
import os
import re
import shutil
import subprocess
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
OUTCOMES = ("supported", "unsupported", "invalid", "generation-only", "fragment")
LAUNCHER = re.compile(r"^if __name__ == ['\"]__main__['\"]\s*:", re.M)
CLASS_MAIN = re.compile(r"^    def main\(", re.M)
MODEL_MAIN = re.compile(r"\bstatic\s+void\s+main\s*\([^)]*\)\s*([^{]*)\{")
DIAGNOSTIC = re.compile(r"^(Error|Warning) (\d+) on line (\d+) of file '([^']*)':\n([^\n]*)", re.M)
# Public methods of a generated Java class (two-space indent: the top-level class, not nested ones)
JAVA_METHOD = re.compile(r"\n  public (?:static )?(?:final )?(?:synchronized )?[\w<>\[\], .?]+? (\w+)\(")
PYTHON_NAMES = {"toString": "__str__", "hashCode": "__hash__"}
# A sorted association's comparator field; its Java accessors are intentionally not carried over
COMPARATOR_FIELD = re.compile(r"\bComparator<[^>]*>\s+(\w+)\s*[;=]")
# Runs gate.<function>(<json file>, importlib.import_module) in a fresh interpreter with only the
# generated root and this script's directory on sys.path
CHECK = ("import importlib, json, sys; sys.path[:0] = sys.argv[1:3]; import pythonnext_corpus_gate as gate; "
         "problems = getattr(gate, sys.argv[3])(json.load(open(sys.argv[4])), importlib.import_module); "
         "print(chr(10).join(problems)); sys.exit(1 if problems else 0)")


def parse_expectation(text):
    """'unsupported 9210,9211 generation-only: queued machine'
    -> ('unsupported', ['9210', '9211'], True, 'queued machine'), True when the output is not compiled."""
    head, _, reason = text.partition(":")
    words = head.split()
    kind = words[0]
    uncompiled = kind == "unsupported" and words[-1] == "generation-only"
    if kind not in OUTCOMES or len(words) != (2 if kind in ("unsupported", "invalid") else 1) + uncompiled:
        raise ValueError("bad expectation: " + text)
    return kind, (words[1].split(",") if len(words) > 1 else None), uncompiled, reason.strip()


def blank_comments_and_strings(text):
    """The text with comments and string literals blanked out, line numbers unchanged."""
    return re.sub(r'//[^\n]*|/\*[\s\S]*?\*/|"(?:\\.|[^"\\\n])*"',
                  lambda m: "".join("\n" if c == "\n" else " " for c in m.group(0)), text)


def uses(path):
    """Repository-relative files that a model includes with use statements, transitively."""
    found, todo = [], [path]
    while todo:
        current = todo.pop()
        text = blank_comments_and_strings((ROOT / current).read_text(errors="replace"))
        for m in re.finditer(r"^\s*use\s+([^;\n]+)", text, re.M):
            for item in [x.strip() for x in m.group(1).split(",")]:
                if item.endswith(".ump") and not item.startswith("lib:"):
                    dependency = os.path.normpath(os.path.join(os.path.dirname(current), item))
                    if (ROOT / dependency).is_file() and dependency not in found and dependency != path:
                        found.append(dependency)
                        todo.append(dependency)
    return found


def elements(model_file):
    """(kind, name, first line, last line, body) of each class, interface or trait in a model file."""
    text = blank_comments_and_strings(model_file.read_text(errors="replace"))
    found = []
    for m in re.finditer(r"\b(class|interface|trait|associationClass)\s+(\w+)[^{;]*\{", text):
        depth, i = 1, m.end()
        while depth and i < len(text):
            depth += {"{": 1, "}": -1}.get(text[i], 0)
            i += 1
        found.append((m.group(1), m.group(2), text.count("\n", 0, m.start()) + 1, text.count("\n", 0, i) + 1, text[m.end():i]))
    return found


def left_out_method(message):
    """The method a warning 9212 leaves out of the generated Python, or None when the warning is about
    an action or injection, which leaves its generated method in place."""
    m = re.match(r"Method (\w+) has code only for ", message)
    return m.group(1) if m else None


def prepare_output(out):
    """Empties out for a new run. A directory is replaced only when this gate made it (its marker
    file is there) or it is empty, so a mistyped --output deletes nothing else."""
    if out.exists() and any(out.iterdir()) and not (out / ".python-corpus-gate").exists():
        sys.exit("%s is not empty and was not made by this gate; choose another --output" % out)
    if out.exists():
        shutil.rmtree(out)
    out.mkdir(parents=True)
    (out / ".python-corpus-gate").touch()


def element_at(model_files, file_name, line):
    """(kind, name) of the innermost class, interface or trait around a line of a model file."""
    around = [e for f in model_files if f.name == file_name for e in elements(f) if e[2] <= line <= e[3]]
    return max(around, key=lambda e: e[2])[:2] if around else None


def users_of(model_files, trait):
    """Names of the classes that use a trait (isA)."""
    return {e[1] for f in model_files for e in elements(f)
            if e[0] != "trait" and re.search(r"\bisA\b[^;]*\b%s\b" % re.escape(trait), e[4])}


def class_body(source, name):
    """The indented lines of a top-level Python class definition, or None when it is absent."""
    m = re.search(r"^class %s\b[^\n]*:\n" % re.escape(name), source, re.M)
    if not m:
        return None
    end = re.search(r"^\S", source[m.end():], re.M)
    return source[m.end():m.end() + end.start()] if end else source[m.end():]


def signature(cls, name):
    """A method's parameters without self or cls: * for *args, name/ for a positional-only
    parameter, *name for a keyword-only one; marked static or class. **kwargs is left out because
    accepting more keywords breaks no existing call."""
    static = inspect.getattr_static(cls, name)
    kind = "@staticmethod " if isinstance(static, staticmethod) else "@classmethod " if isinstance(static, classmethod) else ""
    function = getattr(cls, name)
    if name == "__init__" and function is object.__init__:
        return "()"
    parameters = list(inspect.signature(function).parameters.values())
    if not kind:
        parameters = parameters[1:]

    def spell(p):
        if p.kind is p.VAR_POSITIONAL:
            return "*"
        return p.name + "/" if p.kind is p.POSITIONAL_ONLY else "*" + p.name if p.kind is p.KEYWORD_ONLY else p.name

    return kind + "(" + ", ".join(spell(p) for p in parameters if p.kind is not p.VAR_KEYWORD) + ")"


def api_differences(modules, load):
    """How imported generated modules differ from a public API baseline: module
    paths, class names and bases, method signatures, nested enum members, class constants.
    `modules` maps module -> class (dotted for nested) -> api; `load(module)` imports a module."""
    problems = []
    owner = {name: module for module, classes in modules.items() for name in classes if "." not in name}

    def member(module, dotted):
        value = load(module)
        for part in dotted.split("."):
            value = getattr(value, part)
        return value

    for module, classes in modules.items():
        try:
            loaded = load(module)
        except Exception as e:
            problems.append("%s: cannot import (%s)" % (module, e))
            continue
        if not loaded.__file__.endswith(os.path.join(*module.split(".")) + ".py"):
            problems.append("%s: module file is %s" % (module, loaded.__file__))
        for name, api in classes.items():
            where = module + "." + name
            try:
                cls = member(module, name)
            except AttributeError:
                problems.append(where + ": missing")
                continue
            if "enum" in api:
                for view in ("name", "value", "str"):
                    got = [str(m) if view == "str" else getattr(m, view) for m in cls]
                    if got != api["enum"]:
                        problems.append("%s: enum %ss %s, expected %s" % (where, view, got, api["enum"]))
                continue
            for base in api.get("bases", []):
                if base in owner and not issubclass(cls, member(owner[base], base)):
                    problems.append("%s: not a subclass of %s" % (where, base))
            for method, expected in api.get("methods", {}).items():
                if not callable(getattr(cls, method, None)):
                    problems.append("%s.%s: missing" % (where, method))
                elif signature(cls, method) != expected:
                    problems.append("%s.%s: %s, expected %s" % (where, method, signature(cls, method), expected))
            for constant in api.get("constants", []):
                if not hasattr(cls, constant):
                    problems.append("%s.%s: missing" % (where, constant))
    return problems


def missing_members(expected, load):
    """Methods each generated class lacks: `expected` maps module -> [class name, method names]."""
    missing = []
    for module, (name, members) in expected.items():
        cls = getattr(load(module), name)
        missing += ["%s.%s.%s" % (module, name, m) for m in members if not callable(getattr(cls, m, None))]
    return missing


def run(command, cwd, timeout, env=None):
    try:
        p = subprocess.run(command, cwd=cwd, env=env, stdin=subprocess.DEVNULL, capture_output=True,
                           text=True, errors="replace", timeout=timeout)
        return p.returncode, p.stdout + p.stderr
    except subprocess.TimeoutExpired:
        return None, "timed out after %s s" % timeout


def compile_all(python, root, case):
    """Compiles every module under root. One argument per module would pass Windows' command-line limit
    for the largest cases."""
    return run([python, "-I", "-m", "compileall", "-q", str(root)], case, timeout=300)


def tail(text, lines=3):
    return " | ".join(text.strip().splitlines()[-lines:])


class Gate:
    def __init__(self, options, outputs):
        self.jar = str(Path(options.jar).resolve())
        self.python = options.python
        self.out = Path(options.output).resolve()
        self.timeout = options.timeout
        self.api = json.loads(Path(options.api).read_text())["cases"]
        self.outputs = outputs

    def generate(self, case, model, language):
        target = case / language.lower()
        status, output = run(["java", "-jar", self.jar, "-g", language, "--override", "--path", str(target), str(model)],
                             case, timeout=600)
        (case / (language.lower() + ".log")).write_text(output)
        suffix = ".py" if language == "PythonNext" else ".java"
        files = sorted(str(p.relative_to(target))[:-len(suffix)].replace(os.sep, "/") for p in target.rglob("*" + suffix)) \
            if target.exists() else []
        errors = [m.group(2) for m in DIAGNOSTIC.finditer(output) if m.group(1) == "Error"]
        return status, output, errors, files

    def check(self, path, expectation):
        """None when the case behaves as expected, else a one-line reason."""
        kind, codes, uncompiled, _ = parse_expectation(expectation)
        if kind == "fragment":
            return None
        # A short directory name keeps the copied model's path within Windows' length limit
        case = self.out / ("%s-%s" % (Path(path).stem[:40], hashlib.sha1(path.encode()).hexdigest()[:8]))
        for f in [path] + uses(path):
            (case / "model" / f).parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(ROOT / f, case / "model" / f)
        model = case / "model" / path
        model_files = list((case / "model").rglob("*.ump"))
        status, output, errors, modules = self.generate(case, model, "PythonNext")
        root = case / "pythonnext"
        if kind in ("unsupported", "invalid"):
            if status == 0:
                return "generation succeeded, expected error %s" % ",".join(codes)
            if set(errors) != set(codes):
                return "expected error %s, got %s" % (",".join(codes), ",".join(sorted(set(errors))) or tail(output))
            # the class the diagnostic points at gets no output file, never a stub
            for m in DIAGNOSTIC.finditer(output):
                element = element_at(model_files, m.group(4), int(m.group(3))) if m.group(2) in ("9210", "9213") else None
                if element and any(module.rsplit("/", 1)[-1] == element[1] for module in modules):
                    return "error %s for %s, yet it was generated" % (m.group(2), element[1])
            if modules and not uncompiled:
                status, output = compile_all(self.python, root, case)
                if status != 0:
                    return "the modules generated for the other classes do not compile: " + tail(output, 2)
            return None
        if status != 0 or errors:
            return "generation failed (%s): %s" % (status, tail(output))
        java_status, java_output, java_errors, java_modules = self.generate(case, model, "Java")
        if java_status != 0 or java_errors:
            return "the Java generation of the same model failed (%s): %s" % (java_status, tail(java_output))
        problems = []
        missing, extra = sorted(set(java_modules) - set(modules)), sorted(set(modules) - set(java_modules))
        if missing:
            problems.append("no module for " + ", ".join(missing))
        if extra:
            problems.append("unexpected module " + ", ".join(extra))
        present = [m for m in java_modules if m in modules]
        expected = self.expected_methods(case, present, output, model_files)
        if kind == "generation-only":
            for module in present:
                name, methods = expected[module.replace("/", ".")]
                body = class_body((root / (module + ".py")).read_text(errors="replace"), name)
                if body is None:
                    problems.append("%s does not define class %s" % (module, name))
                    continue
                absent = [m for m in methods if not re.search(r"^[ \t]+def %s\(" % m, body, re.M)]
                if absent:
                    problems.append("%s lacks %s" % (module, ", ".join(absent[:5])))
            return "; ".join(problems) or None
        problems += self.run_python(case, model, root, modules, expected)
        if path in self.api and not problems:
            problems += self.check_in_python(case, root, "api_differences", self.api[path]["modules"], "public API differs")
        return "; ".join(problems) or None

    def expected_methods(self, case, modules, output, model_files):
        """Module -> [class name, public methods of the Java class that Python must have]."""
        left_out = {}  # class name -> methods its 9212 warnings leave out
        for m in DIAGNOSTIC.finditer(output):
            method = left_out_method(m.group(5)) if m.group(2) == "9212" else None
            if m.group(1) == "Warning" and method:
                element = element_at(model_files, m.group(4), int(m.group(3)))
                names = {method}
                owners = users_of(model_files, element[1]) if element and element[0] == "trait" else {element[1]} if element else set()
                for owner in owners:
                    left_out.setdefault(owner, set()).update(names)
        expected = {}
        for module in modules:
            name = module.rsplit("/", 1)[-1]
            java_text = (case / "java" / (module + ".java")).read_text(errors="replace")
            comparators = {prefix + field[0].upper() + field[1:] for field in COMPARATOR_FIELD.findall(java_text)
                           for prefix in ("get", "set")}
            java = set(JAVA_METHOD.findall(java_text)) - left_out.get(name, set()) - comparators
            # Java's contract wrapper keeps the body in <method>_Original; Python names that helper per
            # overload, so it is not part of the API to compare
            java = {n for n in java if not n.endswith("_Original")}
            expected[module.replace("/", ".")] = [name, sorted(PYTHON_NAMES.get(n, n) for n in java)]
        return expected

    def run_python(self, case, model, root, modules, expected):
        problems = []
        broken = set()
        if modules:
            status, output = compile_all(self.python, root, case)
            if status != 0:
                broken = {m for m in modules if str(root / (m + ".py")) in output}
                problems.append("does not compile: " + tail(output, 2))
        for module in modules:
            if module in broken:
                continue
            status, output = run([self.python, "-I", "-c",
                                  "import importlib, sys; sys.path.insert(0, sys.argv[1]); importlib.import_module(sys.argv[2])",
                                  str(root), module.replace("/", ".")], case, timeout=60)
            if status != 0:
                problems.append("import %s: %s" % (module.replace("/", "."), tail(output, 1)))
        if problems:
            return problems
        problems += self.check_in_python(case, root, "missing_members", expected, "missing Java's public method")
        return problems + self.run_mains(case, model, root, modules)

    def run_mains(self, case, model, root, modules):
        problems, launchers = [], []
        for module in modules:
            text = (root / (module + ".py")).read_text(errors="replace")
            if LAUNCHER.search(text):
                launchers.append(module)
            elif CLASS_MAIN.search(text):
                problems.append("%s has a main but no launcher" % module)
        # a main whose body is untagged or Python-tagged is a Python main of its class
        launched = {module.rsplit("/", 1)[-1] for module in launchers}
        for f in (case / "model").rglob("*.ump"):
            text = blank_comments_and_strings(f.read_text(errors="replace"))
            for m in MODEL_MAIN.finditer(text):
                element = element_at([f], f.name, text.count("\n", 0, m.start()) + 1)
                if element and (not m.group(1).strip() or "Python" in m.group(1)) and element[1] not in launched:
                    problems.append("%s has a Python main in the model but no launcher" % element[1])
        printed = ""
        for module in launchers:
            directory = case / "run" / module.replace("/", ".")
            directory.mkdir(parents=True, exist_ok=True)
            # As UmpleOnline's runner does: the module by its dotted name, from the generated root
            environment = dict(os.environ, PYTHONNOUSERSITE="1", PYTHONDONTWRITEBYTECODE="1")
            environment.pop("PYTHONPATH", None)
            status, output = run([self.python, "-m", module.replace("/", ".")], root, timeout=self.timeout, env=environment)
            (directory / "main.log").write_text(output)
            printed += output
            if status != 0:
                problems.append("main %s %s: %s" % (module.replace("/", "."),
                                                    "timed out" if status is None else "exited %s" % status, tail(output, 1)))
        expected_output = self.outputs.get(model.relative_to(case / "model").as_posix())
        if expected_output and expected_output not in printed:
            problems.append("the mains did not print %r" % expected_output)
        return problems

    def check_in_python(self, case, root, function, data, label):
        (case / (function + ".json")).write_text(json.dumps(data))
        # -B: importing this script from build/ writes no __pycache__ there
        status, output = run([self.python, "-I", "-B", "-c", CHECK, str(root), str(Path(__file__).resolve().parent), function,
                              str(case / (function + ".json"))], case, timeout=300)
        lines = output.strip().splitlines()
        return [] if status == 0 else ["%s (%d): %s" % (label, len(lines), " | ".join(lines[:3]))]


def main():
    parser = argparse.ArgumentParser(description=__doc__.split("\n")[0])
    parser.add_argument("--jar", default=str(ROOT / "dist/umple.jar"))
    parser.add_argument("--python", default=sys.executable, help="interpreter for compiling and running (default: this one)")
    parser.add_argument("--manifest", default=str(Path(__file__).resolve().parent / "pythonnext_corpus_manifest.json"))
    parser.add_argument("--api", default=str(Path(__file__).resolve().parent / "pythonnext_corpus_api.json"))
    parser.add_argument("--output", default=str(ROOT / "dist/python-corpus-gate"))
    parser.add_argument("--jobs", type=int, default=os.cpu_count() or 2)
    parser.add_argument("--timeout", type=float, default=10.0, help="seconds each Python main may run")
    parser.add_argument("--only", nargs="*", default=[], help="check only cases whose path contains one of these")
    options = parser.parse_args()

    manifest = json.loads(Path(options.manifest).read_text())
    cases = manifest["cases"]
    failures = {}
    for pattern in manifest["corpus"]:
        for f in sorted(ROOT.glob(pattern)):
            if f.relative_to(ROOT).as_posix() not in cases:
                failures[f.relative_to(ROOT).as_posix()] = ("not classified in the manifest: add it to %s with its expected "
                                                      "outcome (see UmpleToPythonNext/ReadMe.txt)" % Path(options.manifest).name)
    for path, expectation in cases.items():
        parse_expectation(expectation)
        if not (ROOT / path).is_file():
            failures[path] = "listed in the manifest but missing"
    selected = {p: e for p, e in cases.items() if p not in failures and (not options.only or any(o in p for o in options.only))}
    if options.only and not selected:
        sys.exit("No case matches --only %s" % " ".join(options.only))

    gate = Gate(options, manifest.get("main_output", {}))
    prepare_output(gate.out)
    with concurrent.futures.ThreadPoolExecutor(max_workers=options.jobs) as pool:
        futures = {pool.submit(gate.check, p, e): p for p, e in selected.items()}
        for future in concurrent.futures.as_completed(futures):
            path = futures[future]
            try:
                problem = future.result()
            except Exception as e:  # a crash in one case is that case's failure
                problem = "gate error: %r" % e
            if problem:
                failures[path] = problem

    summary = {}
    for path, expectation in selected.items():
        kind = parse_expectation(expectation)[0]
        counts = summary.setdefault(kind, [0, 0])
        counts[0 if path not in failures else 1] += 1
    (gate.out / "results.json").write_text(json.dumps(
        {"cases": len(selected), "summary": summary, "failures": dict(sorted(failures.items()))}, indent=1))
    print("PythonNext corpus gate: %d cases" % len(selected))
    for kind in OUTCOMES:
        if kind in summary:
            print("  %-16s %4d as expected, %4d not" % (kind, summary[kind][0], summary[kind][1]))
    for path, problem in sorted(failures.items()):
        print("NOT AS EXPECTED %s [%s]: %s" % (path, cases.get(path, "unclassified"), problem[:300]))
    print("Details: %s" % (gate.out / "results.json"))
    sys.exit(1 if failures else 0)


if __name__ == "__main__":
    main()
