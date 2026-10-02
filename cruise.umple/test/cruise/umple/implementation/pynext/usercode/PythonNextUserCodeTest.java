/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.implementation.pynext.usercode;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.parser.ErrorMessage;
import cruise.umple.parser.Position;
import cruise.umple.util.SampleFileWriter;

// User code in the Python generator: re-indentation of native code, language
// selection, the constraint renderer, injections, overload dispatch and diagnostics.
public class PythonNextUserCodeTest
{
  private static final String INDENT = "        ";
  private File dir;

  @Before
  public void setUp() throws Exception
  {
    dir = Files.createTempDirectory("umple-python-usercode").toFile();
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(dir.getPath());
  }

  //------------------------
  // Re-indentation
  //------------------------

  // The parser keeps a body without the indentation of its first line.
  @Test
  public void firstLineIsLevelWithTheNextStatement()
  {
    assertBlock("x = 1\n    return x", "\n        x = 1\n        return x");
  }

  @Test
  public void firstLineThatOpensABlockIsLevelWithALaterStatement()
  {
    assertBlock("if x:\n        return 1\n    return 2", "\n        if x:\n            return 1\n        return 2");
  }

  @Test
  public void firstLineThatOpensABlockHoldingEverythingIsShallower()
  {
    assertBlock("for i in r:\n        yield i", "\n        for i in r:\n                yield i");
  }

  @Test
  public void firstLineIndentationIsRestoredWhenKnown()
  {
    Assert.assertEquals("\n        x = 1\n        return x", cruise.umple.util.PythonSource.reindent("x = 1\n    return x", "    ", INDENT));
    Assert.assertEquals("\n        x = 1\n            y = 2", cruise.umple.util.PythonSource.reindent("x = 1\n        y = 2", "    ", INDENT));
  }

  @Test
  public void linesInsideStringsAreKeptByteForByte()
  {
    assertBlock("s = \"\"\"a\n  b   \nc\"\"\"\n    return s", "\n        s = \"\"\"a\n  b   \nc\"\"\"\n        return s");
    assertBlock("s = 'a\\\n    b'\n    return s", "\n        s = 'a\\\n    b'\n        return s");
    assertBlock("s = r'a\\\n  b' + f'{s}\\\n  c'\n    return s", "\n        s = r'a\\\n  b' + f'{s}\\\n  c'\n        return s");
  }

  @Test
  public void quotesAndHashesInsideStringsAreText()
  {
    assertBlock("s = \"# '\" + '\"'\n    return s", "\n        s = \"# '\" + '\"'\n        return s");
    assertBlock("s = 'it\\'s:'\n    return s", "\n        s = 'it\\'s:'\n        return s");
  }

  @Test
  public void continuationLinesKeepTheirOffsets()
  {
    assertBlock("x = [1,\n2]\n    y = 1 + \\\n2\n    z = (3,\n           4)",
      "\n        x = [1,\n        2]\n        y = 1 + \\\n        2\n        z = (3,\n               4)");
  }

  @Test
  public void commentLinesDoNotSetTheIndentation()
  {
    assertBlock("x = 1\n# at column zero\n    return x", "\n        x = 1\n        # at column zero\n        return x");
    assertBlock("x = 1 # ends with:\n    return x", "\n        x = 1 # ends with:\n        return x");
  }

  @Test
  public void tabsFollowPythonTabStops()
  {
    assertBlock("a = 1\n\tif a:\n\t\ta = 2\n\treturn a", "\n        a = 1\n        if a:\n                a = 2\n        return a");
  }

  @Test
  public void bodyWrittenAtColumnZero()
  {
    assertBlock("x = 3\nif x:\n    x += 1\nreturn x", "\n        x = 3\n        if x:\n            x += 1\n        return x");
  }

  @Test
  public void lineEndingsAndBlankLines()
  {
    assertBlock("x = 1\r\n\r\n    return x\r\n", "\n        x = 1\n\n        return x");
  }

  @Test
  public void bodyWithoutStatementsGetsPass()
  {
    assertBlock("", "\n\n        pass");
    assertBlock("# only a comment", "\n        # only a comment\n        pass");
  }

  private static void assertBlock(String code, String expected)
  {
    Assert.assertEquals(expected, cruise.umple.util.PythonSource.reindent(code, null, INDENT));
  }

  @Test
  public void nativeCodeIsBracketedBySourceMarkersWhenItsStartIsKnown() throws Exception
  {
    UmpleModel model = generate("class X { }");
    PythonNextGenerator gen = generator(model);
    UmpleClass x = model.getUmpleClass("X");
    Assert.assertEquals("\n        # line 3 \"model.ump\"\n        return 1\n        # end line",
      gen.nativeCode("return 1", null, INDENT, new Position(new File(dir, "model.ump").getPath(), 3, 0, 0), x));
    Assert.assertEquals("\n        return 1", gen.nativeCode("return 1", null, INDENT, null, x));
    Assert.assertEquals("\n        pass", gen.nativeCode("  ", null, INDENT, new Position("model.ump", 3, 0, 0), x));
  }

  //------------------------
  // Language selection and main
  //------------------------

  @Test
  public void pythonBodyWinsThenAWrittenUntaggedBody() throws Exception
  {
    UmpleModel model = generate("class X {\n"
      + "  void untagged() { return 1 }\n"
      + "  void tagged() Python { pass } Java { }\n"
      + "  void javaOnly() Java { }\n"
      + "  void emptyUntagged() {} Java { return; }\n"
      + "  void both() { x } Python { y }\n"
      + "}\n");
    UmpleClass x = model.getUmpleClass("X");
    Assert.assertEquals("", PythonNextGenerator.pythonLanguage(method(x, "untagged")));
    Assert.assertEquals("Python", PythonNextGenerator.pythonLanguage(method(x, "tagged")));
    Assert.assertNull(PythonNextGenerator.pythonLanguage(method(x, "javaOnly")));
    Assert.assertEquals("", PythonNextGenerator.pythonLanguage(method(x, "emptyUntagged")));
    Assert.assertEquals("Python", PythonNextGenerator.pythonLanguage(method(x, "both")));
  }

  @Test
  public void codeSlotSelection()
  {
    CodeBlock code = new CodeBlock();
    Assert.assertNull(PythonNextGenerator.pythonLanguage(code));
    code.setCode("Java", "x;");
    Assert.assertNull(PythonNextGenerator.pythonLanguage(code));
    code.setCode("", "x");
    Assert.assertEquals("", PythonNextGenerator.pythonLanguage(code));
    code.setCode("Python", "y");
    Assert.assertEquals("Python", PythonNextGenerator.pythonLanguage(code));
  }

  @Test
  public void pythonMainIsPublicStaticVoidWithOneParameterAndAPythonBody() throws Exception
  {
    UmpleModel model = generate("class A { public static void main(String[] args) { pass } }\n"
      + "class B { public static void main(String[] args) Java { } }\n"
      + "class C { static void main(String[] args) { pass } }\n"
      + "class D { public static void main() { pass } }\n");
    Assert.assertTrue(PythonNextGenerator.isPythonMain(method(model.getUmpleClass("A"), "main")));
    Assert.assertFalse(PythonNextGenerator.isPythonMain(method(model.getUmpleClass("B"), "main")));
    Assert.assertFalse(PythonNextGenerator.isPythonMain(method(model.getUmpleClass("C"), "main")));
    Assert.assertFalse(PythonNextGenerator.isPythonMain(method(model.getUmpleClass("D"), "main")));
    // registered under its module name before its imports and class body run, so that a module
    // importing A shares the running class
    String a = model.getGeneratedCode().get("A");
    Assert.assertTrue(a, a.contains("\nimport sys\nif __name__ == \"__main__\":\n    sys.modules.setdefault(\"A\", sys.modules[__name__])\n"));
    Assert.assertTrue(a, a.endsWith("\n\n\nif __name__ == \"__main__\":\n    A.main(sys.argv)\n"));
    Assert.assertFalse(model.getGeneratedCode().get("C").contains("__main__"));
  }

  //------------------------
  // Diagnostics
  //------------------------

  @Test
  public void methodWithOnlyOtherLanguagesIsLeftOutWithAWarning() throws Exception
  {
    UmpleModel model = generate("class X {\n  void f() Java { return; } Php { return; }\n}\n");
    Assert.assertFalse(model.getGeneratedCode().get("X").contains("def f"));
    ErrorMessage warning = message(model, 9212);
    Assert.assertEquals(3, warning.getPosition().getLineNumber()); // the generate line comes first
    Assert.assertTrue(warning.getFormattedMessage(), warning.getFormattedMessage().contains("Method f has code only for Java, Php, so it is left out of the generated Python"));
  }

  @Test
  public void unsupportedUserCodeIsReportedAtItsLocation() throws Exception
  {
    assertUnsupported("class X { X(int a) { pass } }", 9210, 2);
    assertUnsupported("class X { static queued void f() { pass } }", 9210, 2);
    assertUnsupported("class X { int f(int self) { return self } }", 9214, 2);
    assertUnsupported("class X { Integer n;\n around getN { around_proceed: pass } }", 9210, 3);
    assertUnsupported("class X { void f() { pass } }\nclass Y { emit render()(t); t <<!hi!>> }", 9210, 3);
    assertUnsupported("class X {\n static int f(int a) { return a }\n int f(String a) { return 1 } }", 9210, 4);
  }

  // Behaviour written only for other languages is left out with warning 9212. A derived attribute
  // would have no value, so it is an error (9211); a derived attribute is never a constructor parameter.
  @Test
  public void codeOnlyForOtherLanguagesIsReported() throws Exception
  {
    UmpleModel model = generate("class X { Integer n; after setN Java { n = 5; }\n"
      + "sm { A { go / Java { n = 1; } -> B; } B { entry / Java { n = 2; } } } }");
    List<String> warnings = new ArrayList<String>();
    for (ErrorMessage m : model.getLastResult().getErrorMessages())
    {
      if (m.getErrorType().getErrorCode() == 9212)
      {
        warnings.add(m.getFormattedMessage());
      }
    }
    Assert.assertEquals(warnings.toString(), 3, warnings.size());
    Assert.assertTrue(warnings.toString(), warnings.get(0).contains("After injection of setN has code only for Java, so it is left out"));
    Assert.assertTrue(warnings.toString(), warnings.toString().contains("The action of the transition on go from state A has code only for Java"));
    Assert.assertTrue(warnings.toString(), warnings.toString().contains("The entry action of state B has code only for Java"));
    Assert.assertNotNull(model.getGeneratedCode().get("X"));
    UmpleModel javaOnly = generate("class R { Double h; Double w; Double area = Java { h * w } }");
    Assert.assertTrue(message(javaOnly, 9211).getFormattedMessage().contains("the derived attribute area cannot be translated to Python: it has code only for Java"));
    UmpleModel python = generate("class R { Double h; Double w; Double area = Python { self.getH() * self.getW() } }");
    Assert.assertTrue(python.getGeneratedCode().get("R"), python.getGeneratedCode().get("R").contains("def __init__(self, aH, aW):"));
  }

  // A return without a value leaves the event without its result, which Java does not compile
  @Test
  public void aBareReturnInATransitionActionIsReported() throws Exception
  {
    UmpleModel returning = generate("class Q { Integer n; sm { A { go / { n = 1; return; } -> B; } B { } } }");
    Assert.assertTrue(message(returning, 9211).getFormattedMessage().contains("a return without a value"));
  }

  @Test
  public void onlyInjectionsWrittenWithAroundAreAroundInjections() throws Exception
  {
    UmpleModel model = generate("class A { name; before setName Python { print(\"around_proceed:\") } }\n"
      + "class B { name; before setName Python {\n    around_proceed: str = \"a local\"\n    print(around_proceed)\n  } }");
    Assert.assertTrue(generator(model).checkUserCode(model.getUmpleClass("A")));
    Assert.assertTrue(generator(model).checkUserCode(model.getUmpleClass("B")));
  }

  // Native code is read lexically: strings and comments are not code, the replacement fields of an
  // f-string are, and a binding errs towards being found
  @Test
  public void namesNativeCodeUsesAndBinds() throws Exception
  {
    java.util.Set<String> used = cruise.umple.util.PythonSource.codeNames(
      "x = Item()  # Other\ns = \"Thing\"\nt = f\"{Label.TEXT} {{Brace}}\"\ny = self.Member");
    Assert.assertTrue(used.toString(), used.containsAll(Arrays.asList("x", "Item", "s", "t", "Label", "y", "self")));
    for (String name : Arrays.asList("Other", "Thing", "Brace", "TEXT", "Member"))
    {
      Assert.assertFalse(name, used.contains(name));
    }
    java.util.Set<String> bound = cruise.umple.util.PythonSource.boundNames("import a.b\nfrom x import B, C as c\nd = 1\ne: int = 2\n"
      + "def F(): pass\nclass G: pass\nglobal h\nfor i in r: pass\nwith o as j: pass\nif (k := 3): pass\nm, n = 1, 2\n"
      + "print(\"q = 1\")\n# z = 2\nw == 1");
    Assert.assertTrue(bound.toString(), bound.containsAll(Arrays.asList("a", "B", "c", "d", "e", "F", "G", "h", "i", "j", "k", "m", "n")));
    for (String name : Arrays.asList("b", "C", "q", "z", "w", "o", "r"))
    {
      Assert.assertFalse(name, bound.contains(name));
    }
    // In an f-string's fields, strings and format specs are text; a format spec may hold a field
    java.util.Set<String> formatted = cruise.umple.util.PythonSource.codeNames("t = f\"{'Item'} {x:Spec} {y!r:>{Width}} {d['}']}\"");
    Assert.assertTrue(formatted.toString(), formatted.containsAll(Arrays.asList("t", "x", "y", "Width", "d")));
    for (String name : Arrays.asList("Item", "Spec", "r"))
    {
      Assert.assertFalse(name, formatted.contains(name));
    }
    // What comprehensions, lambdas and nested functions bind is theirs
    java.util.Set<String> scoped = cruise.umple.util.PythonSource.boundNames(
      "values = [A for A in r]\nf = lambda B: B\ndef helper(C):\n    D = C\n    return D\nfor E in r:\n    pass\nwith (\n    x for F in r):\n    pass");
    Assert.assertTrue(scoped.toString(), scoped.containsAll(Arrays.asList("values", "f", "helper", "E")));
    for (String name : Arrays.asList("A", "B", "C", "D", "F"))
    {
      Assert.assertFalse(name, scoped.contains(name));
    }
  }

  // A lambda's bindings are its own; an annotation or del alone makes a name local; attributes,
  // subscripts and keyword arguments bind nothing. A backslash never hides an f-string's field.
  @Test
  public void bindsWhatPythonScopesBind() throws Exception
  {
    java.util.Set<String> bound = cruise.umple.util.PythonSource.boundNames(
      "f = lambda: (A := 1)\ng = sorted(r, key=lambda x, y=1: x)\nC: int\ndel D, self.e, cache[F]\ncache[G] = 1\n"
      + "print(H(n=1))\nI = J = 2\nK += 1\nfor L in r: M = 1\nif N.ready(): O = 2\nP = f\"{Q=}\"\nimport R; S = 1\n"
      + "U = [(T := v) for v in r]");
    Assert.assertTrue(bound.toString(), bound.containsAll(Arrays.asList("f", "g", "C", "D", "I", "J", "K", "L", "M", "O", "P", "R", "S", "T", "U")));
    for (String name : Arrays.asList("A", "x", "y", "self", "e", "cache", "F", "G", "H", "n", "N", "Q", "v", "r"))
    {
      Assert.assertFalse(name, bound.contains(name));
    }
    java.util.Set<String> used = cruise.umple.util.PythonSource.codeNames(
      "a = rf\"\\{Item.__name__}\"\nb = f\"\\\\{Other}\"\nc = f\"\\N{BULLET} {Label}\"");
    Assert.assertTrue(used.toString(), used.containsAll(Arrays.asList("Item", "Other", "Label")));
    Assert.assertFalse(used.toString(), used.contains("BULLET"));
  }

  // Default values of nested functions and lambdas, and statements continued over lines, belong to
  // the function; a grouped subscript binds nothing. Only the function's own yield makes a generator.
  @Test
  public void readsLogicalStatementsAndEnclosingDefaults() throws Exception
  {
    java.util.Set<String> bound = cruise.umple.util.PythonSource.boundNames(
      "f = lambda x=(A := 1): x\ndef g(y=(B := 2)): return (C := y)\ncache[(D)] = 1\n(E,\n F) = 1, 2\nG \\\n  = 3\n"
      + "for (H,\n I) in r: pass");
    Assert.assertTrue(bound.toString(), bound.containsAll(Arrays.asList("f", "A", "g", "B", "E", "F", "G", "H", "I")));
    for (String name : Arrays.asList("x", "y", "C", "cache", "D"))
    {
      Assert.assertFalse(name, bound.contains(name));
    }
    Assert.assertTrue(cruise.umple.util.PythonSource.isGenerator("x = 1\nyield x"));
    Assert.assertTrue(cruise.umple.util.PythonSource.isGenerator("return f\"{(yield 1)}\""));
    Assert.assertFalse(cruise.umple.util.PythonSource.isGenerator("yielded = 1\nreturn yielded"));
    Assert.assertFalse(cruise.umple.util.PythonSource.isGenerator("def values():\n    yield 1\nreturn list(values())"));
    Assert.assertFalse(cruise.umple.util.PythonSource.isGenerator("g = lambda: (yield)\nreturn g"));
    Assert.assertFalse(cruise.umple.util.PythonSource.codeNames("return f\"{1:\\N{SPACE}>3}\"").contains("SPACE"));
    Assert.assertTrue(cruise.umple.util.PythonSource.codeNames("return f\"{e:\\\\N{Item}}\"").contains("Item"));
    Assert.assertTrue(cruise.umple.util.PythonSource.isGenerator("def f(x=(yield 1)): pass"));
    java.util.Set<String> more = cruise.umple.util.PythonSource.boundNames("(R).x = 1\n[S][0] = 1\nwith o as (T, U): pass\n"
      + "def h() -> (V := int): pass\nw = lambda: \\\n  (W := 1)");
    Assert.assertTrue(more.toString(), more.containsAll(Arrays.asList("T", "U", "h", "V", "w")));
    for (String name : Arrays.asList("R", "S", "W"))
    {
      Assert.assertFalse(name, more.contains(name));
    }
    // a case pattern binds its captures, not its class patterns, values, keywords or guard
    java.util.Set<String> cases = cruise.umple.util.PythonSource.boundNames("match p:\n    case Point(x=0, y=Y1):\n        pass\n"
      + "    case Holder . Value1:\n        pass\n    case [A1, *Rest] if Limit.ok(A1):\n        pass\n    case Color.RED | {\"k\": V1}:\n        pass\n    case _ as Other:\n        pass\n"
      + "case = 1\ncase(Called)\ncase[Indexed] = 2\nwith o as ((N1, N2), N3): pass");
    Assert.assertTrue(cases.toString(), cases.containsAll(Arrays.asList("Y1", "A1", "Rest", "V1", "Other", "case", "N1", "N2", "N3")));
    for (String name : Arrays.asList("Point", "x", "Limit", "Color", "RED", "k", "p", "_", "Holder", "Value1", "Called", "Indexed"))
    {
      Assert.assertFalse(name, cases.contains(name));
    }
    // outside a match statement, case is a name: case[Item]: int annotates a subscript
    Assert.assertFalse(cruise.umple.util.PythonSource.boundNames("case = {}\ncase[Item]: int").contains("Item"));
    Assert.assertFalse(cruise.umple.util.PythonSource.boundNames("case = {}\ncase[Item]: \"int\"").contains("Item"));
    // a line break inside a string does not end the match statement's header
    Assert.assertTrue(cruise.umple.util.PythonSource.boundNames("match \"\"\"one\ntwo\"\"\":\n    case Item: pass").contains("Item"));
  }

  // A trait's code goes where superCall stands once that statement has a line of its own, also after
  // a header continued over lines; placeholders are replaced only where they are code
  @Test
  public void givesAStatementItsOwnLine() throws Exception
  {
    String code = "if (\n    True\n): superCall; x()\ny()";
    Assert.assertEquals("if (\n    True\n):\n    superCall;\n    x()\ny()",
      cruise.umple.util.PythonSource.ownLine(code, code.indexOf("superCall")));
    Assert.assertEquals("a()", cruise.umple.util.PythonSource.ownLine("a()", 0));
    String withString = "if \"\"\"one\ntwo\"\"\": superCall; x()";
    Assert.assertEquals("if \"\"\"one\ntwo\"\"\":\n    superCall;\n    x()", cruise.umple.util.PythonSource.ownLine(withString, withString.indexOf("superCall")));
    // an annotation's colon is no header's, outside a match statement's cases
    String annotated = "case = {}\ncase[0]: int; superCall; x()";
    Assert.assertEquals("case = {}\ncase[0]: int;\nsuperCall;\nx()", cruise.umple.util.PythonSource.ownLine(annotated, annotated.indexOf("superCall")));
    String withLambda = "if lambda: True: superCall; x()";
    Assert.assertEquals("if lambda: True:\n    superCall;\n    x()", cruise.umple.util.PythonSource.ownLine(withLambda, withLambda.indexOf("superCall")));
    Assert.assertEquals("x = \"__t__\"\ny(1)", cruise.umple.util.PythonSource.replaceCode("x = \"__t__\"\ny(__t__)", "__t__", "1"));
    // the shared composition also serves Java, whose body takes the trait's untagged code
    UmpleModel model = generate("generate Java;\ntrait T { sm { S { entry / { System.out.println(\"trait\"); } } } }\n"
      + "class A { isA T; sm { S { entry / Python { superCall; print(\"class\") } Java { superCall; System.out.println(\"class\"); } } } }\n");
    Assert.assertTrue(model.getGeneratedCode().toString(), model.getGeneratedCode().containsKey("A"));
  }

  // A docstring is a statement of string literals alone, however written; anything else gets its
  // imports first
  @Test
  public void recognizesDocstrings() throws Exception
  {
    Assert.assertEquals(5, cruise.umple.util.PythonSource.docstringEnd("\"doc\"\nreturn 1"));
    Assert.assertEquals(10, cruise.umple.util.PythonSource.docstringEnd("'''doc''' # why\nreturn 1"));
    Assert.assertEquals(11, cruise.umple.util.PythonSource.docstringEnd("(\"a\"\n r\"b\")\nreturn 1"));
    Assert.assertEquals(5, cruise.umple.util.PythonSource.docstringEnd("\"doc\"; return 1"));
    for (String code : Arrays.asList("\"a\" + Item.LABEL", "\"a\".join(x)", "f\"doc\"", "b\"doc\"", "(\"a\")(1)", "x = \"doc\""))
    {
      Assert.assertEquals(code, -1, cruise.umple.util.PythonSource.docstringEnd(code));
    }
    UmpleModel model = generate("class Item {}\nclass A {\n  String call() Python {\n    \"prefix\" + Item.__name__\n    return Item.__name__\n  }\n"
      + "  String doc() Python {\n    \"native-doc\"; return Item.__name__\n  }\n}\n");
    String a = model.getGeneratedCode().get("A");
    Assert.assertTrue(a, a.contains("    def call(self):\n        from Item import Item\n"));
    Assert.assertTrue(a, a.contains("\"native-doc\"\n        # end line\n        from Item import Item\n        # line 9 \"model.ump\"\n        return Item.__name__"));
  }

  // Before code runs in the method with its body, so the body sees what it binds. An authored
  // docstring stays first: its source region ends before the imports and resumes after them.
  @Test
  public void importsFollowBeforeCodeAndAuthoredDocstrings() throws Exception
  {
    UmpleModel model = generate("class Item {}\nclass A {\n  before name Python { Item = \"provided\" }\n"
      + "  String name() Python { return Item }\n  String call() Python {\n    '''Calls.'''\n    return Item.__name__\n  }\n}\n");
    String a = model.getGeneratedCode().get("A");
    Assert.assertFalse(a, a.contains("name_Original"));
    Assert.assertEquals(a, 1, a.split("from Item import Item", -1).length - 1);
    Assert.assertTrue(a, a.contains("'''Calls.'''\n        # end line\n        from Item import Item\n        # line 8 \""));
  }

  // An import native code needs goes to the start of its function, after its docstring and before its
  // source regions, and is left out where it would replace a name the function binds: its object
  // (self), a parameter, or a local another injection of it sets
  @Test
  public void importsOfNativeCodeKeepTheFunctionsOwnNames() throws Exception
  {
    UmpleModel model = generate("class self {}\nclass Item {}\n"
      + "class A { name;\n  String m(String Item) Python { return self.getName() + Item }\n"
      + "  before setName Python { Item = \"mine\" }\n  after setName Python { print(Item) }\n"
      + "  // Makes one.\n  String make() Python { return Item() }\n}\n");
    String a = model.getGeneratedCode().get("A");
    Assert.assertFalse(a, a.contains("from self import self"));
    Assert.assertFalse(a, a.contains("#<<"));
    Assert.assertEquals(a, 1, a.split("from Item import Item", -1).length - 1);
    Assert.assertTrue(a, a.contains("        \"\"\"Makes one.\"\"\"\n        from Item import Item\n"));
  }

  @Test
  public void codeForOtherLanguagesIsNotChecked() throws Exception
  {
    UmpleModel model = generate("class X { synchronized void f() Java { } X(int a) Java { } }");
    Assert.assertTrue(generator(model).checkUserCode(model.getUmpleClass("X")));
  }

  private void assertUnsupported(String code, int error, int line) throws Exception
  {
    UmpleModel model = generate(code);
    UmpleClass last = model.getUmpleClass(model.numberOfUmpleClasses() - 1);
    int before = model.getLastResult().numberOfErrorMessages();
    Assert.assertFalse(code, generator(model).checkUserCode(last));
    ErrorMessage reported = model.getLastResult().getErrorMessage(before);
    Assert.assertEquals(code, error, reported.getErrorType().getErrorCode());
    Assert.assertEquals(code, line, reported.getPosition().getLineNumber());
  }

  //------------------------
  // Constraints
  //------------------------

  private static final String CONSTRAINTS = "class Item { }\n"
    + "class Box {\n"
    + "  const Integer MAX = 10;\n"
    + "  Integer n; String s; Boolean b; Double d; String[] tags; Item single; internal Integer hidden;\n"
    + "  0..1 -> * Item items;\n"
    + "  0..1 -> 0..1 Item other;\n"
    + "  sm {\n"
    + "    A {\n"
    + "      e(Integer v) [v > n] -> B;\n"
    + "      g [!(n > 3 && b)] -> A;\n"
    + "      h [items has single] -> B;\n"
    + "      i [items cardinality >= 2] -> B;\n"
    + "      j [s == \"x\" + n] -> A;\n"
    + "      k [ok(n, 2)] -> A;\n"
    + "      l [n < MAX] -> A;\n"
    + "      m [tags[0] == \"a\"] -> A;\n"
    + "      o [other == single] -> A;\n"
    + "      p [not b] -> A;\n"
    + "      q [(n / 2) > 1] -> A;\n"
    + "      r [d > 1.5] -> A;\n"
    + "      t [s == null] -> A;\n"
    + "      u [single != null] -> A;\n"
    + "      w [hidden > 0 || b == true] -> A;\n"
    + "      x [sm == B] -> A;\n"
    + "      y [this.n > 1] -> A;\n"
    + "      z [ready()] -> A;\n"
    + "      c [tags == null] -> A;\n"
    + "    }\n"
    + "    B { }\n"
    + "  }\n"
    + "  boolean ok(int a, int c) { return True }\n"
    + "  boolean ready() { return True }\n"
    + "  int f(int x, String in) {\n"
    + "    [pre: x > 0 && in != \"z\"]\n"
    + "    [post: x < n]\n"
    + "    return x\n"
    + "  }\n"
    + "  static int st(Item x) {\n"
    + "    [pre: x != null]\n"
    + "    return 1\n"
    + "  }\n"
    + "  [n >= 0]\n"
    + "}\n";

  @Test
  public void guardsAreRenderedInPython() throws Exception
  {
    UmpleModel model = generate(CONSTRAINTS);
    PythonNextGenerator gen = generator(model);
    UmpleClass box = model.getUmpleClass("Box");
    List<String> expected = Arrays.asList(
      "e", "v > self.getN()",
      "g", "not (self.getN() > 3 and self.getB())",
      "h", "self.getSingle() in self.getItems()",
      "i", "self.numberOfItems() >= 2",
      "j", "self.getS() == \"x\" + str(self.getN())",
      "k", "self.ok(self.getN(), 2)",
      "l", "self.getN() < __class__.MAX",
      "m", "\"a\" == self.getTag(0)",
      "o", "self.getOther() is self.getSingle()",
      "p", "not self.getB()",
      "q", "(int(Fraction(self.getN(), 2))) > 1",
      "r", "self.getD() > 1.5",
      "t", "self.getS() is None",
      "u", "self.getSingle() is not None",
      "w", "self._hidden > 0 or self.getB() == True",
      "x", "self.getSm() is __class__.Sm.B",
      "y", "self.getN() > 1",
      "z", "self.ready()",
      "c", "self.getTags() is None");
    for (int i = 0; i < expected.size(); i += 2)
    {
      Transition transition = transition(box, expected.get(i));
      Assert.assertEquals(expected.get(i + 1), gen.condition(transition.getGuard(), box, transition.getEvent().getParams()));
    }
  }

  // Owner.CONSTANT reads through __class__, which finds the owner's constant unless a nearer class
  // declares a member of that name (then error 9210); the constant is typed from its owner
  @Test
  public void qualifiedConstantsReadTheirOwnersValue() throws Exception
  {
    UmpleModel inherited = generate("class Base { const Integer LIMIT = 3; }\nclass G { isA Base; Integer n = 0; sm { A { up [n <= Base.LIMIT] -> A; } } }");
    UmpleClass g = inherited.getUmpleClass("G");
    Assert.assertEquals("self.getN() <= __class__.LIMIT", generator(inherited).condition(transition(g, "up").getGuard(), g, null));
    Assert.assertNotNull(inherited.getGeneratedCode().get("G"));
    UmpleModel hidden = generate("interface Limits { const Integer MAX = 4; }\n"
      + "class B { isA Limits; const Integer MAX = 10; Integer n = 6; sm { S { go [n < Limits.MAX] -> T; } T {} } }");
    Assert.assertTrue(message(hidden, 9210).getFormattedMessage().contains("Limits.MAX, which the class hides"));
    UmpleModel typed = generate("interface Limits { const Integer MAX = 4; }\n"
      + "class A { isA Limits; Integer n = 6; sm { S { go [(n / Limits.MAX) == 1] -> T; } T {} } }");
    UmpleClass a = typed.getUmpleClass("A");
    Assert.assertEquals("(int(Fraction(self.getN(), __class__.MAX))) == 1", generator(typed).condition(transition(a, "go").getGuard(), a, null));
  }

  // Text built in a constraint spells booleans as Java does, literals and negations included; Java
  // calls equals between two parameters and compares other model objects by reference
  @Test
  public void constraintsFollowJavaForTextAndObjects() throws Exception
  {
    UmpleModel model = generate("class Seat { }\nclass Q { s = \"ab\"; Boolean flag = true; Seat home;\n"
      + "sm { S { a [s + true == \"abtrue\"] -> S; b [s + !flag == \"abfalse\"] -> S; change(Seat current, Seat wanted) [current == wanted] -> S;"
      + " swap(Seat seat) [seat == home] -> S; } } }");
    PythonNextGenerator gen = generator(model);
    UmpleClass q = model.getUmpleClass("Q");
    Assert.assertEquals("\"abtrue\" == str(self.getS()) + (\"true\" if True else \"false\")", gen.condition(transition(q, "a").getGuard(), q, null));
    Assert.assertEquals("\"abfalse\" == str(self.getS()) + (\"true\" if (not self.getFlag()) else \"false\")",
      gen.condition(transition(q, "b").getGuard(), q, null));
    Assert.assertEquals("current == wanted", gen.condition(transition(q, "change").getGuard(), q, transition(q, "change").getEvent().getParams()));
    Assert.assertEquals("seat is self.getHome()", gen.condition(transition(q, "swap").getGuard(), q, transition(q, "swap").getEvent().getParams()));
  }

  // Numbers in constraints take Java's value; 08 is no Java number
  @Test
  public void constraintNumbersTakeJavasValue() throws Exception
  {
    UmpleModel model = generate("class N { Integer n; Integer f(Integer a) { [pre: a == 07] [pre: n != -07] return a } }");
    Assert.assertEquals(Arrays.asList("a == 7", "self.getN() != -7"), preconditions(model, "N", "f"));
    UmpleModel invalid = generate("class N { Integer n; Integer f(Integer a) { [pre: a == 08] return a } }");
    Assert.assertTrue(message(invalid, 9210).getFormattedMessage().contains("the number 08"));
  }

  @Test
  public void contractsAndInvariantsAreRenderedInPython() throws Exception
  {
    UmpleModel model = generate(CONSTRAINTS);
    PythonNextGenerator gen = generator(model);
    UmpleClass box = model.getUmpleClass("Box");
    Method f = method(box, "f");
    Assert.assertEquals("x > 0 and \"z\" != input", gen.condition(gen.contracts(box, f, true).get(0), box, f.getMethodParameters(), false, null));
    Assert.assertEquals("x < self.getN()", gen.condition(gen.contracts(box, f, false).get(0), box, f.getMethodParameters(), false, null));
    Method st = method(box, "st");
    Assert.assertEquals("x is not None", gen.condition(gen.contracts(box, st, true).get(0), box, st.getMethodParameters(), true, null));
    Assert.assertEquals("\"Please provide a valid in and x\"", gen.contractMessage(gen.contracts(box, f, true).get(0)));
    Attribute n = box.getAttribute("n");
    Assert.assertEquals("aN >= 0", gen.condition(box.getConstraintTree(0), box, null, false, Arrays.asList(n)));
    Assert.assertEquals("self.getN() >= 0", gen.condition(box.getConstraintTree(0), box, null));
  }

  // An ancestor's constant is reached through the class, whose module does not import the ancestor.
  @Test
  public void inheritedConstantsAreReachedThroughTheClass() throws Exception
  {
    UmpleModel model = generate("class A { const Integer LIMIT = 10; }\nclass B { isA A; }\n"
      + "class C { isA B; int f(int x) { [pre: x < LIMIT] return x } }\n");
    Assert.assertEquals(Arrays.asList("x < __class__.LIMIT"), preconditions(model, "C", "f"));
  }

  @Test
  public void listsStringsAndIntegerArithmeticFollowJava() throws Exception
  {
    UmpleModel model = generate("class Item { }\nclass X {\n  String text; String[] tags; Integer n;\n  0..1 -> * Item items;\n"
      + "  int f(String[] values, String name, int a, int b) {\n"
      + "    [pre: values has all \"a\", \"b\"]\n"
      + "    [pre: values cardinality > 0]\n"
      + "    [pre: tags cardinality > 0]\n"
      + "    [pre: text.length() > 0]\n"
      + "    [pre: name.length() > 1]\n"
      + "    [pre: items has all a, b]\n"
      + "    [pre: (a / b) == a]\n"
      + "    [pre: (a % b) == 1]\n"
      + "    [pre: n > 0]\n"
      + "    return 1\n  }\n}\n");
    Assert.assertEquals(Arrays.asList(
      "\"a\" in values and \"b\" in values",
      "len(values) > 0",
      "len(self.getTags()) > 0",
      "(len(str.encode(self.getText(), \"utf-16-le\", \"surrogatepass\")) // 2) > 0",
      "(len(str.encode(name, \"utf-16-le\", \"surrogatepass\")) // 2) > 1",
      "a in self.getItems() and b in self.getItems()",
      "(int(Fraction(a, b))) == a",
      "((a - b * int(Fraction(a, b)))) == 1",
      "self.getN() > 0"), preconditions(model, "X", "f"));
  }

  // A call has the type its method declares, generated getters and inherited methods included, and a
  // call through a receiver is looked up in the receiver's declared class. So integer division and
  // remainder follow Java, evaluating a call once, and model objects compare by identity.
  @Test
  public void callsHaveTheirDeclaredTypes() throws Exception
  {
    UmpleModel model = generate("class Item { Integer id; key { id } }\n"
      + "class Box { Item item; Integer n; int size() { return 1 } }\n"
      + "class Base { Integer count = 3; int twice() { return 6 } }\n"
      + "class X {\n  isA Base;\n  Box one; Box two; Integer n; String text;\n"
      + "  int f(int a, Box b) {\n"
      + "    [pre: (getN() / 2) == -1]\n"
      + "    [pre: (getN() % 2) == -1]\n"
      + "    [pre: (twice() / getCount()) == 2]\n"
      + "    [pre: (count / 2) == 1]\n"
      + "    [pre: (getOne().size() % a) == 1]\n"
      + "    [pre: (one.getN() % 2) == -1]\n"
      + "    [pre: (text.length() / 2) == 1]\n"
      + "    [pre: getOne().getItem() != getTwo().getItem()]\n"
      + "    [pre: this.getOne().getItem() == b.getItem()]\n"
      + "    [pre: getOne().getN() == getTwo().getN()]\n"
      + "    return 1\n  }\n}\n");
    Assert.assertEquals(Arrays.asList(
      "(int(Fraction(self.getN(), 2))) == -1",
      "((lambda x, y: x - y * int(Fraction(x, y)))(self.getN(), 2)) == -1",
      "(int(Fraction(self.twice(), self.getCount()))) == 2",
      "(int(Fraction(self.getCount(), 2))) == 1",
      "((lambda x, y: x - y * int(Fraction(x, y)))(self.getOne().size(), a)) == 1",
      "((lambda x, y: x - y * int(Fraction(x, y)))(self.getOne().getN(), 2)) == -1",
      "(int(Fraction((len(str.encode(self.getText(), \"utf-16-le\", \"surrogatepass\")) // 2), 2))) == 1",
      "self.getOne().getItem() is not self.getTwo().getItem()",
      "self.getOne().getItem() is b.getItem()",
      "self.getOne().getN() == self.getTwo().getN()"), preconditions(model, "X", "f"));
  }

  @Test
  public void overloadCallsUseTheSelectedReturnType() throws Exception
  {
    String integer = "int pick(int n) { return -3 }\n";
    String floating = "double pick(String s) { return -3.0 }\n";
    for (String declarations : Arrays.asList(integer + floating, floating + integer))
    {
      UmpleModel model = generate("class X { int count = 1; String text;\n" + declarations
        + "double arity() { return -3.0 } int arity(int a, int b) { return -3 }\n"
        + "int f(int n, String s) {\n"
        + "[pre: (pick(1) / 2) == -1]\n"
        + "[pre: (pick(-1) / 2) == -1]\n"
        + "[pre: (pick(\"a\") / 2) == -1.5]\n"
        + "[pre: (this.pick(n) % 2) == -1]\n"
        + "[pre: (pick(s) / 2) == -1.5]\n"
        + "[pre: (pick(count) / 2) == -1]\n"
        + "[pre: (pick(getText()) / 2) == -1.5]\n"
        + "[pre: (arity() / 2) == -1.5]\n"
        + "[pre: (arity(1, 2) / 2) == -1]\n"
        + "[pre: (pick(external()) / 2) == -1.5]\n"
        + "return 7 } }");
      Assert.assertEquals(Arrays.asList(
        "(int(Fraction(self.pick(1), 2))) == -1",
        "(int(Fraction(self.pick(-1), 2))) == -1",
        "(self.pick(\"a\") / 2) == -1.5",
        "((lambda x, y: x - y * int(Fraction(x, y)))(self.pick(n), 2)) == -1",
        "(self.pick(s) / 2) == -1.5",
        "(int(Fraction(self.pick(self.getCount()), 2))) == -1",
        "(self.pick(self.getText()) / 2) == -1.5",
        "(self.arity() / 2) == -1.5",
        "(int(Fraction(self.arity(1, 2), 2))) == -1",
        "(self.pick(self.external()) / 2) == -1.5"), preconditions(model, "X", "f"));
    }
  }

  @Test
  public void overloadReturnTypesStayUnknownWhenArgumentsDoNotDecide() throws Exception
  {
    UmpleModel model = generate("class Item {}\nclass X { Item item; String[] texts; 0..1 -> * Item items;\n"
      + "int pick(int n) { return -3 } double pick(Item item) { return -3.0 }\n"
      + "int many(int n) { return -3 } double many(String[] texts) { return -3.0 }\n"
      + "int objects(int n) { return -3 } double objects(Item[] items) { return -3.0 }\n"
      + "Item lookup(int n) { return None } int lookup(String text) { return 1 }\n"
      + "int f(External unknown) {\n"
      + "[pre: (pick(item) / 2) == -1.5]\n"
      + "[pre: (many(texts) / 2) == -1.5]\n"
      + "[pre: (objects(items) / 2) == -1.5]\n"
      + "[pre: (pick(unknown) / 2) == -1.5]\n"
      + "[pre: (pick(null) / 2) == -1.5]\n"
      + "[pre: lookup(1) != lookup(2)]\n"
      + "[pre: lookup(\"a\") == lookup(\"b\")]\n"
      + "return 7 } }");
    Assert.assertEquals(Arrays.asList(
      "(self.pick(self.getItem()) / 2) == -1.5",
      "(self.many(self.getTexts()) / 2) == -1.5",
      "(self.objects(self.getItems()) / 2) == -1.5",
      "(self.pick(unknown) / 2) == -1.5",
      "(self.pick(None) / 2) == -1.5",
      "self.lookup(1) is not self.lookup(2)",
      "self.lookup(\"a\") == self.lookup(\"b\")"), preconditions(model, "X", "f"));
  }

  @Test
  public void interfaceCallsUseDeclaredAndInheritedReturnTypes() throws Exception
  {
    UmpleModel model = generate("class Item { Integer id; key { id } }\n"
      + "interface Countable { int value(); }\n"
      + "interface HasItem { Item getItem(); }\n"
      + "interface View { isA Countable, HasItem; }\n"
      + "class X { View one; View two;\n"
      + "int f(Countable count, HasItem box) {\n"
      + "[pre: (count.value() / 2) == -1]\n"
      + "[pre: (one.value() % 2) == -1]\n"
      + "[pre: one.getItem() != two.getItem()]\n"
      + "[pre: box.getItem() == one.getItem()]\n"
      + "return 7 } }");
    Assert.assertEquals(Arrays.asList(
      "(int(Fraction(count.value(), 2))) == -1",
      "((lambda x, y: x - y * int(Fraction(x, y)))(self.getOne().value(), 2)) == -1",
      "self.getOne().getItem() is not self.getTwo().getItem()",
      "box.getItem() is self.getOne().getItem()"), preconditions(model, "X", "f"));
  }

  @Test
  public void lengthIsSpecialOnlyForStringsAndArrays() throws Exception
  {
    UmpleModel model = generate("interface Measured { double length(); }\n"
      + "class Item { double length() { return -3.0 } int length(int n) { return -3 } }\n"
      + "class X { Item item; String text; String[] tags;\n"
      + "int f(Measured measured, String[] values, External other) {\n"
      + "[pre: (item.length() / 2) == -1.5]\n"
      + "[pre: (item.length(1) / 2) == -1]\n"
      + "[pre: (measured.length() / 2) == -1.5]\n"
      + "[pre: (other.length() / 2) == -1.5]\n"
      + "[pre: (text.length() / 2) == 1]\n"
      + "[pre: tags.length == 2]\n"
      + "[pre: (values.length / 2) == 1]\n"
      + "return 7 } }");
    Assert.assertEquals(Arrays.asList(
      "(self.getItem().length() / 2) == -1.5",
      "(int(Fraction(self.getItem().length(1), 2))) == -1",
      "(measured.length() / 2) == -1.5",
      "(other.length() / 2) == -1.5",
      "(int(Fraction((len(str.encode(self.getText(), \"utf-16-le\", \"surrogatepass\")) // 2), 2))) == 1",
      "len(self.getTags()) == 2",
      "(int(Fraction(len(values), 2))) == 1"), preconditions(model, "X", "f"));
  }

  @Test
  public void generatedBulkGettersHaveArrayReturnTypes() throws Exception
  {
    UmpleModel model = generate("class Parent { String[] values; }\n"
      + "class X { isA Parent; String[] tags;\n"
      + "int f(Parent other) {\n"
      + "[pre: getTags().length == 3]\n"
      + "[pre: getValues().length == 3]\n"
      + "[pre: this.getValues().length == 3]\n"
      + "[pre: other.getValues().length == 3]\n"
      + "return 7 } }");
    Assert.assertEquals(Arrays.asList("len(self.getTags()) == 3", "len(self.getValues()) == 3",
      "len(self.getValues()) == 3", "len(other.getValues()) == 3"), preconditions(model, "X", "f"));
  }

  @Test
  public void lengthArgumentsSelectIntegralOverloads() throws Exception
  {
    UmpleModel model = generate("class X { String[] tags;\n"
      + "int pick(int n) { return -3 } double pick(String text) { return -3.0 }\n"
      + "int f(String text, String[] values) {\n"
      + "[pre: (pick(text.length()) / 2) == -1]\n"
      + "[pre: (pick(values.length) / 2) == -1]\n"
      + "[pre: (pick(getTags().length) / 2) == -1]\n"
      + "return 7 } }");
    Assert.assertEquals(Arrays.asList("(int(Fraction(self.pick((len(str.encode(text, \"utf-16-le\", \"surrogatepass\")) // 2)), 2))) == -1",
      "(int(Fraction(self.pick(len(values)), 2))) == -1",
      "(int(Fraction(self.pick(len(self.getTags())), 2))) == -1"), preconditions(model, "X", "f"));
  }

  @Test
  public void uncertainOverloadsKeepACommonReturnType() throws Exception
  {
    for (String declarations : Arrays.asList(
      "int pick(A a) { return -3 } int pick(B b) { return -3 }",
      "int pick(B b) { return -3 } int pick(A a) { return -3 }"))
    {
      UmpleModel model = generate("class A {} class B {} class X {\n" + declarations
        + " double pick(int n) { return -3.0 }\n"
        + "int f(B b, External unknown) {\n"
        + "[pre: (pick(b) / 2) == -1]\n"
        + "[pre: (pick(unknown) / 2) == -1.5]\n"
        + "return 7 } }");
      Assert.assertEquals(Arrays.asList("(int(Fraction(self.pick(b), 2))) == -1",
        "(self.pick(unknown) / 2) == -1.5"), preconditions(model, "X", "f"));
    }
    UmpleModel model = generate("class A {} class B {} class X {\n"
      + "int pick(A a) { return -3 } int pick(B b) { return -3 }\n"
      + "int f(External unknown) { [pre: (pick(unknown) / 2) == -1] return 7 } }");
    Assert.assertEquals(Arrays.asList("(int(Fraction(self.pick(unknown), 2))) == -1"), preconditions(model, "X", "f"));
  }

  @Test
  public void constraintShiftsUsePromotedLeftWidths() throws Exception
  {
    for (String op : Arrays.asList("<<", ">>"))
    {
      UmpleModel model = generate("class X { long wide; int count; String text; String[] tags; "
        + "long number() { return 8 } int distance() { return 32 } "
        + "int f(int value, long large, short small, byte tiny, int step, long longStep) {\n"
        + "[pre: (value " + op + " step) == 8]\n"
        + "[pre: (large " + op + " step) == 8]\n"
        + "[pre: (small " + op + " longStep) == 8]\n"
        + "[pre: (tiny " + op + " step) == 8]\n"
        + "[pre: (wide * value " + op + " step) == 8]\n"
        + "[pre: (value * count " + op + " step) == 8]\n"
        + "[pre: (large / 2 " + op + " step) == 8]\n"
        + "[pre: (large % 3 " + op + " step) == 8]\n"
        + "[pre: (number() " + op + " distance()) == 8]\n"
        + "[pre: (text.length() " + op + " step) == 8]\n"
        + "[pre: (tags.length " + op + " step) == 8]\n"
        + "[pre: (value " + op + " 31) == 8]\n"
        + "[pre: (large " + op + " 63) == 8]\n"
        + "[pre: (value " + op + " 32) == 8]\n"
        + "[pre: (large " + op + " -64) == 8]\nreturn 7 } }");
      Assert.assertEquals(Arrays.asList(
        "(value " + op + " (step & 31)) == 8",
        "(large " + op + " (step & 63)) == 8",
        "(small " + op + " (longStep & 31)) == 8",
        "(tiny " + op + " (step & 31)) == 8",
        "(self.getWide() * value " + op + " (step & 63)) == 8",
        "(value * self.getCount() " + op + " (step & 31)) == 8",
        "(int(Fraction(large, 2)) " + op + " (step & 63)) == 8",
        "((large - 3 * int(Fraction(large, 3))) " + op + " (step & 63)) == 8",
        "(self.number() " + op + " (self.distance() & 63)) == 8",
        "((len(str.encode(self.getText(), \"utf-16-le\", \"surrogatepass\")) // 2) " + op + " (step & 31)) == 8",
        "(len(self.getTags()) " + op + " (step & 31)) == 8",
        "(value " + op + " 31) == 8",
        "(large " + op + " 63) == 8",
        "(value " + op + " (32 & 31)) == 8",
        "(large " + op + " (-64 & 63)) == 8"), preconditions(model, "X", "f"));
    }
  }

  @Test
  public void constraintOverloadShiftsLeaveUncertainWidthsUnmasked() throws Exception
  {
    for (String declarations : Arrays.asList(
      "long pick(A a) { return 8 } int pick(B b) { return 8 }",
      "int pick(B b) { return 8 } long pick(A a) { return 8 }"))
    {
      UmpleModel model = generate("class A {} class B {} class X { " + declarations
        + " int f(A a, B b, External unknown, int distance) {\n"
        + "[pre: (pick(a) >> distance) == 8]\n"
        + "[pre: (pick(b) << distance) == 8]\n"
        + "[pre: (pick(unknown) >> distance) == 8]\n"
        + "[pre: (external() << distance) == 8]\nreturn 7 } }");
      boolean longFirst = declarations.startsWith("long");
      Assert.assertEquals(Arrays.asList(
        "(self.pick(a) >> " + (longFirst ? "(distance & 63)" : "distance") + ") == 8",
        "(self.pick(b) << " + (longFirst ? "distance" : "(distance & 31)") + ") == 8",
        "(self.pick(unknown) >> distance) == 8",
        "(self.external() << distance) == 8"), preconditions(model, "X", "f"));
    }
  }

  @Test
  public void constraintNonNullTextExcludesModelOverloads() throws Exception
  {
    UmpleModel model = generate("class A {} class X { "
      + "double pick(A value) { return 2.0 } int pick(String value) { return -3 } "
      + "int f(String text) {\n"
      + "[pre: (pick(\"x\") / 2) == -1]\n"
      + "[pre: (pick(text) / 2) == -1.5]\nreturn 7 } }");
    Assert.assertEquals(Arrays.asList("(int(Fraction(self.pick(\"x\"), 2))) == -1",
      "(self.pick(text) / 2) == -1.5"), preconditions(model, "X", "f"));
  }

  @Test
  public void constraintKnownLongPromotesUncertainWidths() throws Exception
  {
    for (String declarations : Arrays.asList(
      "int pick(A a) { return 8 } long pick(B b) { return 8 }",
      "long pick(A a) { return 8 } int pick(B b) { return 8 }"))
    {
      for (String shift : Arrays.asList("<<", ">>"))
      {
        for (String op : Arrays.asList("*", "/", "%", "^"))
        {
          UmpleModel model = generate("class A {} class B {} class X { long unit = 1; " + declarations
            + " int f(B b, int count) {\n"
            + "[pre: (pick(b) " + op + " unit " + shift + " count) == 8]\n"
            + "[pre: (unit " + op + " pick(b) " + shift + " count) == 8]\nreturn 7 } }");
          String left = "self.pick(b)";
          String right = "self.getUnit()";
          List<String> expected = new ArrayList<String>();
          for (int order = 0; order < 2; order++)
          {
            String a = order == 0 ? left : right;
            String b = order == 0 ? right : left;
            String arithmetic = op.equals("/") ? "int(Fraction(" + a + ", " + b + "))"
              : op.equals("%") ? "(lambda x, y: x - y * int(Fraction(x, y)))(" + a + ", " + b + ")"
              : a + " " + op + " " + b;
            expected.add("(" + arithmetic + " " + shift + " (count & 63)) == 8");
          }
          Assert.assertEquals(expected, preconditions(model, "X", "f"));
        }
      }
    }
  }

  // A constraint's name reads the attribute even where a parameter has the same name, as in Java's
  // generated check
  @Test
  public void constraintsReadAttributesOverParameters() throws Exception
  {
    UmpleModel model = generate("class X { Integer n; int f(int n) { [pre: n > 5] return n } }");
    Assert.assertEquals(Arrays.asList("self.getN() > 5"), preconditions(model, "X", "f"));
  }

  @Test
  public void constraintShapeWithoutAPythonFormStopsTheClass() throws Exception
  {
    UmpleModel model = generate("class S { sm { A { go -> B; } B { f [sm is in state B] -> A; } } }");
    UmpleClass s = model.getUmpleClass("S");
    try
    {
      generator(model).condition(transition(s, "f").getGuard(), s, null);
      Assert.fail("a state check without its state has no Python form");
    }
    catch (RuntimeException e)
    {
      Assert.assertEquals("A constraint using the state test is in state", e.getMessage());
    }
  }

  // Constraints name a state machine's states through its enum, and Java's equals and contains have
  // Python forms; another method of a Java value, or a name the model does not define, would fail
  // each time the constraint runs, so the class is not generated (9210)
  @Test
  public void constraintsNameStatesAndJavaValueMethods() throws Exception
  {
    UmpleModel model = generate("class F { blade { Still { spin [getPower() == Power.On] -> Still; } }\n"
      + "power { Off { t -> On; } On { } }\n"
      + "String note; code;\n"
      + "int f(String c, External e) {\n"
      + "[pre: c.equals(code)]\n"
      + "[pre: note.contains(\"rush\")]\n"
      + "[pre: e.startsWith(\"x\")]\n"
      + "return 7 } }");
    UmpleClass f = model.getUmpleClass("F");
    Assert.assertEquals("self.getPower() == __class__.Power.On", generator(model).condition(transition(f, "spin").getGuard(), f, null));
    Assert.assertEquals(Arrays.asList("(c == self.getCode())", "str.__contains__(self.getNote(), \"rush\")", "e.startsWith(\"x\")"),
      preconditions(model, "F", "f"));
    for (String guard : new String[] { "[note.isEmpty()]", "[missing > 1]", "[result > 1]" })
    {
      UmpleModel rejected = generate("class G { String note; sm { A { go " + guard + " -> B; } B { } } }");
      Assert.assertTrue(guard, message(rejected, 9210).getFormattedMessage().contains("class G was not generated"));
    }
  }

  // A constraint reads another model class's constants through that class, which the function
  // imports; anything else of that class is reported
  @Test
  public void constraintsReadConstantsOfOtherClasses() throws Exception
  {
    UmpleModel model = generate("namespace shop;\nclass Limit { const Integer MAX = 5; Integer other; }\n"
      + "namespace app;\nclass A { Integer x; sm { Off { go [x < Limit.MAX] -> On; } On { } }\n"
      + "  int f(int n) Python {\n  [pre: n < Limit.MAX]\n  return n } }\n"
      + "class D { int f(int n) Python {\n  [pre: n < Limit.other]\n  return n } }\n");
    String a = model.getGeneratedCode().get("A");
    Assert.assertTrue(a, a.contains("        from shop.Limit import Limit\n"));
    Assert.assertTrue(a, a.contains("if self.getX() < Limit.MAX:"));
    Assert.assertTrue(a, a.contains("        from shop.Limit import Limit\n        if not (n < Limit.MAX):"));
    Assert.assertTrue(message(model, 9210).getFormattedMessage(),
      message(model, 9210).getFormattedMessage().contains("Limit.other, which is not a constant of Limit"));
  }

  //------------------------
  // Extra code
  //------------------------

  // The parser puts a marker before each piece of extra code: a Java comment, with a Python
  // alternative when it has one. A user's own comment is not a marker.
  @Test
  public void extraCodePiecesKeepTheirSourceMarkers() throws Exception
  {
    UmpleModel model = generate("class X { }");
    UmpleClass x = model.getUmpleClass("X");
    CodeBlock marker = new CodeBlock("// line 7 model.ump");
    marker.setCode("Python", "# line 7 \"model.ump\"");
    x.appendExtraCode(true, marker);
    x.appendExtraCode("  VALUE = 1\n# line 3 of the table\ndef f(self):\n    return 2");
    x.appendExtraCode(true, new CodeBlock("\n// line 12 \"model.ump\""));
    x.appendExtraCode("  OTHER = 3");
    CodeBlock.languageUsed = "Python";
    Assert.assertEquals("\n\n    # line 7 \"model.ump\"\n    VALUE = 1\n    # line 3 of the table\n    def f(self):\n        return 2\n    # end line"
      + "\n\n    # line 12 \"model.ump\"\n    OTHER = 3\n    # end line", generator(model).classExtraCode(x));
  }

  // A line inside a string is text even when it looks like a marker.
  @Test
  public void markerLikeLinesInsideStringsAreText() throws Exception
  {
    UmpleModel model = generate("class X { }");
    UmpleClass x = model.getUmpleClass("X");
    x.appendExtraCode(true, new CodeBlock("// line 2 model.ump"));
    x.appendExtraCode("  TEXT = \"\"\"first\n# line 99 \"elsewhere.ump\"\nlast\"\"\"");
    CodeBlock.languageUsed = "Python";
    Assert.assertEquals("\n\n    # line 2 \"model.ump\"\n    TEXT = \"\"\"first\n# line 99 \"elsewhere.ump\"\nlast\"\"\"\n    # end line",
      generator(model).classExtraCode(x));
  }

  //------------------------
  // Injections and overloads used by the generated-method templates
  //------------------------

  @Test
  public void injectionsOfAGeneratedMethod() throws Exception
  {
    UmpleModel model = generate("class G {\n  Integer n;\n"
      + "  before setN Python { if aN < 0:\n      aN = 0 }\n"
      + "  after setN { print(\"set\"); }\n"
      + "  before setN Java { System.out.println(); }\n"
      + "}\n");
    PythonNextGenerator gen = generator(model);
    UmpleClass g = model.getUmpleClass("G");
    List<MethodParameter> parameters = Arrays.asList(new MethodParameter("aN", "Integer", null, null, false));
    // The first line opens a block that holds everything else, so it is less indented than the rest.
    Assert.assertEquals("\n        # line 4 \"model.ump\"\n        if aN < 0:\n              aN = 0\n        # end line",
      gen.injections(g, "before", "setN", parameters, false, INDENT));
    Assert.assertTrue(gen.injections(g, "after", "setN", parameters, false, INDENT).startsWith("\n        print(\"set\")"));
    Assert.assertEquals("", gen.injections(g, "before", "getN", parameters, false, INDENT));
  }

  @Test
  public void codeSlotsUseTheirPythonBodyElseTheirTranslatedUntaggedBody() throws Exception
  {
    UmpleModel model = generate("class X { }");
    PythonNextGenerator gen = generator(model);
    UmpleClass x = model.getUmpleClass("X");
    CodeBlock action = new CodeBlock("count++;");
    action.setCode("Python", "if ready:\n    go()");
    Assert.assertEquals("\n        if ready:\n            go()", gen.slotCode(action, x, null, false, INDENT, "the action", null));
    Assert.assertTrue(gen.slotCode(new CodeBlock("print(1);"), x, null, false, INDENT, "the action", null).startsWith("\n        print(1)"));
    Assert.assertEquals("", gen.slotCode(new CodeBlock("Java", "go();"), x, null, false, INDENT, "the action", null));
    Assert.assertEquals("", gen.slotCode(new CodeBlock("Python", "  "), x, null, false, INDENT, "the action", null));
  }

  @Test
  public void dispatcherForGeneratedOverloads() throws Exception
  {
    UmpleModel model = generate("class Item { }\nclass Order { }\n");
    PythonNextGenerator gen = generator(model);
    UmpleClass order = model.getUmpleClass("Order");
    List<List<MethodParameter>> parameters = new ArrayList<List<MethodParameter>>();
    parameters.add(Arrays.asList(new MethodParameter("aItem", "Item", null, null, false)));
    parameters.add(Arrays.asList(new MethodParameter("aNumber", "int", null, null, false)));
    Assert.assertEquals("\n\n    def addItem(self, *args, **kwargs):"
      + "\n        from Item import Item"
      + "\n        bound = __class__._bindArguments((\"aItem\",), False, args, kwargs)"
      + "\n        if bound is not None and (bound[0] is None or isinstance(bound[0], Item)):"
      + "\n            return __class__.addItem1(self, *bound)"
      + "\n        bound = __class__._bindArguments((\"aNumber\",), False, args, kwargs)"
      + "\n        if bound is not None and (isinstance(bound[0], int) and not isinstance(bound[0], bool)):"
      + "\n            return __class__.addItem2(self, *bound)"
      + "\n        raise TypeError(\"No method matches provided parameters\")",
      gen.overloadDispatcher(order, "addItem", false, Arrays.asList("addItem1", "addItem2"), parameters));
    Assert.assertTrue(gen.bindingHelper(order).startsWith("\n\n    @staticmethod\n    def _bindArguments(names, varargs, args, kwargs):"));
    Assert.assertEquals("the helper is emitted once", "", gen.bindingHelper(order));
  }

  //------------------------
  // Generator-owned names
  //------------------------

  // A helper name avoids the numbered implementations of an overloaded method too.
  @Test
  public void freshNamesAvoidModelledMembersAndNumberedOverloads() throws Exception
  {
    UmpleModel model = generate("class X {\n  int m() { return 1 }\n  int m_Original() { return 2 }\n  int m_Original(int n) { return n }\n}\n");
    PythonNextGenerator gen = generator(model);
    UmpleClass x = model.getUmpleClass("X");
    Assert.assertEquals(Arrays.asList("m_Original1", "m_Original2"), gen.overloadNames(x, "m_Original", 2, "methods"));
    Assert.assertEquals("m_Original3", gen.freshMemberName(x, "m_Original"));
    // Another group of the same name (a generated one) gets numbers of its own; asking again gives the same
    Assert.assertEquals(Arrays.asList("m_Original3", "m_Original4"), gen.overloadNames(x, "m_Original", 2, "factory"));
    Assert.assertEquals(Arrays.asList("m_Original1", "m_Original2"), gen.overloadNames(x, "m_Original", 2, "methods"));
    Assert.assertEquals("_bindArguments", gen.freshMemberName(x, "_bindArguments"));
  }

  //------------------------
  // Helpers
  //------------------------

  private List<String> preconditions(UmpleModel model, String className, String methodName)
  {
    PythonNextGenerator gen = generator(model);
    UmpleClass uClass = model.getUmpleClass(className);
    Method method = method(uClass, methodName);
    List<String> rendered = new ArrayList<String>();
    for (ConstraintTree pre : gen.contracts(uClass, method, true))
    {
      rendered.add(gen.condition(pre, uClass, method.getMethodParameters(), PythonNextGenerator.isStatic(method), null));
    }
    return rendered;
  }

  private UmpleModel generate(String code) throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), ("generate PythonNext;\n" + code).getBytes("UTF-8"));
    UmpleModel model = new UmpleModel(new UmpleFile(file));
    model.setShouldGenerate(true);
    try
    {
      model.run();
    }
    catch (UmpleCompilerException e)
    {
      // errors and warnings are in the model's last result, which the tests check
    }
    return model;
  }

  private static PythonNextGenerator generator(UmpleModel model)
  {
    PythonNextGenerator gen = new PythonNextGenerator();
    gen.setModel(model);
    return gen;
  }

  private static Method method(UmpleClass uClass, String name)
  {
    for (Method m : uClass.getMethods())
    {
      if (m.getName().equals(name))
      {
        return m;
      }
    }
    throw new AssertionError("No method " + name);
  }

  private static Transition transition(UmpleClass uClass, String eventName)
  {
    for (State s : uClass.getStateMachine(0).getStates())
    {
      for (Transition t : s.getTransitions())
      {
        if (t.getEvent().getName().equals(eventName))
        {
          return t;
        }
      }
    }
    throw new AssertionError("No transition on " + eventName);
  }

  private static ErrorMessage message(UmpleModel model, int code)
  {
    for (ErrorMessage m : model.getLastResult().getErrorMessages())
    {
      if (m.getErrorType().getErrorCode() == code)
      {
        return m;
      }
    }
    throw new AssertionError("No message " + code);
  }
}
