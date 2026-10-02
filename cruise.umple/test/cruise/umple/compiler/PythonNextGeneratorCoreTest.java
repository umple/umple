/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.util.SampleFileWriter;

// Core decisions of the native Python generator: values, names, docstrings and diagnostics.
public class PythonNextGeneratorCoreTest
{
  private File dir;
  private PythonNextGenerator gen;

  @Before
  public void setUp() throws Exception
  {
    dir = Files.createTempDirectory("umple-python-core").toFile();
    gen = new PythonNextGenerator();
    gen.setModel(new UmpleModel(new UmpleFile(new File(dir, "empty.ump"))));
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(dir.getPath());
  }

  @Test
  public void literalsFollowTheDeclaredType()
  {
    Assert.assertEquals("None", gen.literal("String", "null"));
    Assert.assertEquals("True", gen.literal("Boolean", "true"));
    Assert.assertEquals("2.0", gen.literal("Double", "2"));
    Assert.assertEquals("2", gen.literal("Integer", "2L"));
    Assert.assertEquals("1.5", gen.literal("Float", "1.5f"));
    Assert.assertEquals("\"a\\\"b\"", gen.literal("String", "\"a\\\"b\""));
    Assert.assertEquals("\"x\"", gen.literal("char", "'x'"));
    Assert.assertEquals("datetime.date.fromisoformat(\"1978-12-25\")", gen.literal("Date", "\"1978-12-25\""));
    Assert.assertEquals("8", gen.literal("Integer", "010"));
    Assert.assertEquals("16", gen.literal("long", "0x10L"));
    Assert.assertEquals("-5", gen.literal("Integer", "-0b101"));
    Assert.assertEquals("1000000", gen.literal("Integer", "1_000_000"));
    Assert.assertEquals("1.0", gen.literal("Float", "1f"));
    Assert.assertEquals("\"\\\"\"", gen.literal("char", "'\\\"'"));
    Assert.assertEquals("\"a b\"", gen.literal("String", "\"a\\sb\""));
    Assert.assertEquals("\"A\\n\"", gen.literal("String", "\"\\u0041\\n\""));
    Assert.assertEquals("\"\\x00\"", gen.literal("char", "'\\0'"));
    Assert.assertNull("unknown escape", gen.literal("String", "\"\\q\""));
    Assert.assertNull("code is not a literal", gen.literal("Integer", "a + 1"));
    Assert.assertNull("two strings are not one literal", gen.literal("String", "\"a\" + \"b\""));
    // Underscores only between digits: anything else is a name or not Java
    Assert.assertNull(gen.literal("Integer", "_3D"));
    Assert.assertNull(gen.literal("Integer", "_1"));
    Assert.assertNull(gen.literal("Integer", "1_"));
    Assert.assertNull(gen.literal("Integer", "0x_1F"));
    Assert.assertEquals("65535", gen.literal("Integer", "0xFF_FF"));
    Assert.assertEquals("1000.5", gen.literal("Double", "1_000.5"));
    // Hexadecimal, octal and binary literals are the bits of a signed int, or long with L, as in Java
    Assert.assertEquals("-1", gen.literal("Integer", "0xFFFFFFFF"));
    Assert.assertEquals("-2147483648", gen.literal("Integer", "0x80000000"));
    Assert.assertEquals("4294967295", gen.literal("long", "0xFFFFFFFFL"));
    Assert.assertEquals("-1", gen.literal("long", "0xFFFFFFFFFFFFFFFFL"));
    Assert.assertEquals("1", gen.literal("Integer", "-0xFFFFFFFF"));
    Assert.assertEquals("-2147483648", gen.literal("Integer", "-0x80000000")); // negated, then wrapped as Java does
    Assert.assertNull("not an octal number", gen.literal("Integer", "08"));
  }

  @Test
  public void listItemsSplitOnlyAtSeparatingCommas()
  {
    Assert.assertEquals(Arrays.asList("\"a\"", "\"b,c\"", "f(1, 2)", "'x'"), gen.listItems("\"a\", \"b,c\", f(1, 2), 'x'"));
    Assert.assertEquals(Arrays.asList("\"a\\\",b\""), gen.listItems("\"a\\\",b\""));
    Assert.assertTrue(gen.listItems("  ").isEmpty());
  }

  @Test
  public void parameterNamesAvoidPythonKeywords()
  {
    Assert.assertEquals("input", PythonNextGenerator.parameterName("in"));
    Assert.assertEquals("lambda_", PythonNextGenerator.parameterName("lambda"));
    Assert.assertEquals("count", PythonNextGenerator.parameterName("count"));
  }

  @Test
  public void commentsBecomeDocstringsWithoutAnnotations()
  {
    Comment annotation = new Comment("@Override");
    annotation.setAnnotation(true);
    Assert.assertEquals("", gen.docstring(Arrays.asList(annotation), "    "));
    Assert.assertEquals("\n    \"\"\"Say \\\"hi\\\" \\\\ bye\"\"\"", gen.docstring(Arrays.asList(new Comment("Say \"hi\" \\ bye")), "    "));
    Assert.assertEquals("\n    \"\"\"\n    first\n\n    second\n    \"\"\"", gen.docstring(Arrays.asList(new Comment("first"), new Comment(""), new Comment("second")), "    "));
  }

  @Test
  public void coreModelCompiles() throws Exception
  {
    UmpleModel model = generate(
      "namespace shop;\n" +
      "interface Priced { const Integer CURRENCY = 1; Double price(); String label(String p); String label(Integer n); }\n" +
      "// An item\n" +
      "class Item { isA Priced; abstract; name; Double weight = 2; String[] tags = {\"a\", \"b,c\"};\n" +
      "  defaulted Integer stock = 5; autounique serial; enum Color { red, dark_green } Color color; }\n" +
      "class Book { isA Item; key { isbn, name } isbn; Boolean used = false; Integer[] pages; }\n" +
      "class Code { unique Integer number; }\n" +
      "class Registry { singleton; lazy Integer count; }\n" +
      "class Settings { immutable; host; Integer port; }\n");
    Assert.assertEquals(Arrays.asList("Book", "Code", "Item", "Priced", "Registry", "Settings"), sortedNames(model));
    String errors = cruise.umple.implementation.TemplateTest.pythonSyntaxErrors(generatedFiles());
    Assert.assertNull(errors, errors);
    String book = model.getGeneratedCode().get("Book");
    Assert.assertTrue(book, book.contains("        return super().setName(aName)"));
    Assert.assertTrue(book, book.contains("            self._canSetName = False"));
    Assert.assertTrue(model.getGeneratedCode().get("Code"), model.getGeneratedCode().get("Code").contains("self._number = None"));
  }

  @Test
  public void standardImportsGetAnAliasWhenTheModuleDefinesTheirName() throws Exception
  {
    UmpleModel model = generate("namespace clocks;\nclass datetime { Date date = \"2000-01-01\"; }\n" +
      "class EnumOrder { enum Enum { red } enum Other { blue } }\n");
    String clock = model.getGeneratedCode().get("datetime");
    Assert.assertTrue(clock, clock.contains("import datetime as datetime_\n"));
    Assert.assertTrue(clock, clock.contains("datetime_.date.fromisoformat(\"2000-01-01\")"));
    String order = model.getGeneratedCode().get("EnumOrder");
    Assert.assertTrue(order, order.contains("from enum import Enum as Enum_\n"));
    Assert.assertTrue(order, order.contains("class Other(Enum_):"));
  }

  @Test
  public void interfacesListOnlyParentsNotInheritedThroughAnother() throws Exception
  {
    UmpleModel model = generate("interface RootI { }\ninterface ChildI { isA RootI; }\ninterface BothI { isA RootI, ChildI; }\n");
    Assert.assertTrue(model.getGeneratedCode().get("BothI"), model.getGeneratedCode().get("BothI").contains("class BothI(ChildI):"));
  }

  @Test
  public void anEmptyIntermediateClassKeepsListParameters() throws Exception
  {
    UmpleModel model = generate("class TargetA { }\nclass TargetB { }\nclass TargetC { }\n" +
      "class ManyBase { String root; 1 -> 1..* TargetA as; 1 -> 1..* TargetB bs; }\n" +
      "class EmptyMiddle { isA ManyBase; }\nclass ManyLeaf { isA EmptyMiddle; String leaf; 1 -> 1..* TargetC cs; }\n");
    String leaf = model.getGeneratedCode().get("ManyLeaf");
    Assert.assertTrue(leaf, leaf.contains("def __init__(self, aRoot, allAs, allBs, aLeaf, allCs):"));
  }

  @Test
  public void tracingIsReportedAsUnsupported() throws Exception
  {
    UmpleModel model = generate("class Lamp { Integer level; trace level; }\nclass Other { }\n");
    Assert.assertEquals(Arrays.asList(9210), errorCodes(model));
    Assert.assertEquals(Arrays.asList("Other"), sortedNames(model));
  }

  @Test
  public void aModuleOrNamespaceNamedLikeAStandardModuleIsReported() throws Exception
  {
    UmpleModel model = generate("class threading { }\n");
    Assert.assertEquals(Arrays.asList(9213), errorCodes(model));
    // Python has loaded os before the program runs, so importing a module os would get that one
    Assert.assertEquals(Arrays.asList(9213), errorCodes(generate("class os { }\n")));
    UmpleModel anInterface = generate("interface math { }\n");
    Assert.assertTrue(messageOf(anInterface, 9213), messageOf(anInterface, 9213).startsWith("Interface math conflicts"));
    // A namespace's first part is resolved first: sys.Main could not be imported
    UmpleModel inNamespace = generate("namespace sys;\nclass Main { }\n");
    Assert.assertTrue(messageOf(inNamespace, 9213), messageOf(inNamespace, 9213).startsWith("The namespace sys of class Main conflicts"));
    Assert.assertEquals(new ArrayList<Integer>(), errorCodes(generate("namespace app.sys;\nclass Main { }\n")));
  }

  @Test
  public void aClassNamedLikeABuiltinIsReported() throws Exception
  {
    UmpleModel model = generate("namespace n;\nclass len { }\nclass Other { }\n");
    Assert.assertEquals(Arrays.asList(9215), errorCodes(model));
    Assert.assertEquals(Arrays.asList("Other"), sortedNames(model));
    // The binding of a same-module class a local hides calls globals()
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("namespace n;\nclass globals { }\n")));
    // The overload dispatcher calls all() for variable arguments
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("namespace n;\nclass all { }\n")));
    // Built-ins of the generated helpers: class values, Math functions, queue workers
    for (String helperName : Arrays.asList("setattr", "getattr", "ValueError", "OverflowError", "abs", "max"))
    {
      Assert.assertEquals(helperName, Arrays.asList(9215), errorCodes(generate("namespace n;\nclass " + helperName + " { }\n")));
    }
  }

  @Test
  public void sortPrioritiesAreNotAttributesInPython() throws Exception
  {
    UmpleModel model = generate("class Academy { 1 -- * Student sorted {id}; }\nclass Student { Integer id; }\n");
    String academy = model.getGeneratedCode().get("Academy");
    Assert.assertTrue(academy, academy.contains("def __init__(self):"));
    Assert.assertFalse(academy, academy.contains("Priority"));
  }

  @Test
  public void interfaceSignaturesPythonCannotRepresentAreReported() throws Exception
  {
    Assert.assertEquals(Arrays.asList(9214), errorCodes(generate("interface SelfI { String go(String self); }\n")));
    Assert.assertEquals(Arrays.asList(9216), errorCodes(generate("interface Clash { String go(String in, String input); }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("interface Keyword { String lambda(); }\n")));
    // Each class using a trait with such a method reports it and gets no file
    UmpleModel shared = generate("trait T { void f(Integer self) Python { pass } }\nclass A { isA T; }\nclass B { isA T; }\n");
    Assert.assertEquals(Arrays.asList(9214, 9214), errorCodes(shared));
    Assert.assertTrue(shared.getGeneratedCode().isEmpty());
    Assert.assertTrue(messageOf(shared, 9214), messageOf(shared, 9214).startsWith("Method f has a parameter named self"));
    UmpleModel event = generate("class E { sm { S { go(Integer in, Integer input) -> S; } } }\n");
    Assert.assertTrue(messageOf(event, 9216), messageOf(event, 9216).startsWith("Event go has two parameters named input"));
    // A parameter named like a built-in a constraint calls would hide it
    Assert.assertEquals(Arrays.asList(9210), errorCodes(generate("class L { Integer f(String len) { [pre: len.length() > 0] return 1 } }\n")));
    UmpleModel fine = generate("interface Fine { String go(String in, String lambda); }\n");
    Assert.assertTrue(fine.getGeneratedCode().get("Fine"), fine.getGeneratedCode().get("Fine").contains("def go(self, input, lambda_):"));
  }

  @Test
  public void pythonKeywordsAsGeneratedNamesAreReported() throws Exception
  {
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("class async { name; }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("class Choice { enum Color { red, none } Color color; }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("class Flags { const String None = \"x\"; }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("interface Limits { const Integer pass = 1; }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("class Outer { inner class lambda { } }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("class Doubler { Integer twice(Integer __class__) Python { return __class__ * 2 } }\n")));
    UmpleModel fine = generate("class Choice { enum Color { red, nothing } Color color; }\n");
    Assert.assertEquals(new ArrayList<Integer>(), errorCodes(fine));
  }

  // Only a sibling defined earlier can be named as a base inside the outer class's body
  @Test
  public void aNestedClassExtendingANonSiblingOfItsModuleIsReported() throws Exception
  {
    UmpleModel model = generate("class Outer { inner class Base { name; } inner class Box { inner class Child { isA Base; } } }\nclass Other { }\n");
    Assert.assertEquals(Arrays.asList(9210), errorCodes(model));
    Assert.assertEquals(Arrays.asList("Other"), sortedNames(model));
    Assert.assertEquals(Arrays.asList(9210), errorCodes(generate("class Outer { inner class Child { isA Outer; } }\n")));
    String siblings = generate("class Outer { inner class Child { isA Base; } inner class Base { } }\n").getGeneratedCode().get("Outer");
    Assert.assertTrue(siblings, siblings.indexOf("class Base:") < siblings.indexOf("class Child(Base):"));
  }

  // A class of the same module is named through its outer class, which only a local of the same name
  // can hide; a binding is added for that case alone, and one per imported module
  @Test
  public void classesOfTheSameModuleAreBoundOnlyWhenALocalHidesThem() throws Exception
  {
    UmpleModel model = generate("class Outer { inner class Part { } inner class Piece { }\n" +
      "  inner class Hub { String f(Part p) Python { return \"part\" } String f(Piece p) Python { return \"piece\" } } }\n" +
      "class args { inner class Target { } inner class User { String f(Target t) Python { return \"t\" } String f(Integer i) Python { return \"i\" } } }\n");
    String outer = model.getGeneratedCode().get("Outer");
    Assert.assertFalse(outer, outer.contains("globals()"));
    Assert.assertTrue(outer, outer.contains("isinstance(bound[0], Outer.Part)"));
    String args = model.getGeneratedCode().get("args");
    Assert.assertTrue(args, args.contains("args_ = globals()[\"args\"]"));

    // The dispatcher binds this module once, even after an import took the first alias
    String bound = generate("class bound_ { }\nclass bound { inner class Item { } inner class Part { }\n" +
      "  inner class User { String f(bound_ b) Python { return \"b\" } String f(Item i) Python { return \"i\" }\n" +
      "    String f(Part p) Python { return \"p\" } } }\n").getGeneratedCode().get("bound");
    Assert.assertEquals(bound, 1, bound.split("globals\\(\\)\\[\"bound\"\\]", -1).length - 1);
  }

  // Same-name methods the dispatcher can tell apart share it, as Java overloads do. One it cannot tell
  // from another has the same parameter types: a method written in the model redefines the generated
  // one, and the later definition wins as in any Python class.
  @Test
  public void sameNameMethodsAreMergedWhenTheirSignaturesDiffer() throws Exception
  {
    String named = generate("class Named { name; String getName(String prefix) Python { return prefix } }\n")
      .getGeneratedCode().get("Named");
    Assert.assertTrue(named, named.contains("    def getName1(self):") && named.contains("    def getName2(self, prefix):"));
    Assert.assertTrue(named, named.contains("    def getName(self, *args, **kwargs):"));
    String twice = generate("class Twice { sm { Off { go -> On; } On {} } Boolean go() Python { return None } }\n")
      .getGeneratedCode().get("Twice");
    Assert.assertEquals(twice, 2, twice.split("\n    def go\\(self\\):", -1).length - 1);
    Assert.assertFalse(twice, twice.contains("def go1("));
    // the user's method is the later definition, which Python keeps
    int later = twice.lastIndexOf("\n    def go(self):");
    Assert.assertTrue(twice, twice.substring(later).contains("return None") && !twice.substring(0, later).contains("return None"));

    // A generated getter joins the dispatcher of two user overloads; a definition in a string is text
    String product = generate("class Product { name; String getName(String p) Python { return p }\n"
      + "String getName(String p, String s) Python { return p + s }\n"
      + "String sample() Python {\n    return \"\"\"x\n    def getName(self, locale):\n        return locale\n\"\"\"\n} }\n")
      .getGeneratedCode().get("Product");
    Assert.assertEquals(product, 1, product.split("\n    def getName\\(self, \\*args, \\*\\*kwargs\\):", -1).length - 1);
    Assert.assertTrue(product, product.contains("    def getName3(self):") && product.contains("\n    def getName(self, locale):\n"));
  }

  // An interface method the class does not implement gets a stub typed from its declaration, an event
  // named like an association's method is typed from the event, and user overloads of a generated
  // overload group (a factory add) get numbers of their own: each joins the generated method's dispatcher
  @Test
  public void stubsEventsAndUserGroupsJoinGeneratedMethodsOfTheirName() throws Exception
  {
    String light = generate("interface Levelled { String setLevel(String s); }\nclass Light { isA Levelled; Integer level = 0; }\n")
      .getGeneratedCode().get("Light");
    Assert.assertTrue(light, light.contains("    def setLevel(self, *args, **kwargs):"));
    String vehicle = generate("class Vehicle { 0..1 -- * Passenger passengers; trip { Parked { removePassenger(String seat) -> Parked; } } }\n"
      + "class Passenger { }\n").getGeneratedCode().get("Vehicle");
    Assert.assertTrue(vehicle, vehicle.contains("    def removePassenger(self, *args, **kwargs):"));
    UmpleModel order = generate("class Order { 1 <@>- * Line lines;\n"
      + "  Boolean addLine(String sku, String note) Python { return True }\n  Boolean addLine(String sku) Python { return True } }\n"
      + "class Line { sku; Integer qty; }\n");
    Assert.assertTrue(errorCodes(order).isEmpty());
    String text = order.getGeneratedCode().get("Order");
    Assert.assertEquals(text, 1, text.split("\n    def addLine\\(self, \\*args, \\*\\*kwargs\\):", -1).length - 1);
    Assert.assertTrue(text, text.contains("    def addLine4(self, sku):"));
  }

  // A sorted end's comparator is Java's alone, so a guard naming it cannot be generated
  @Test
  public void aGuardNamingTheComparatorIsReported() throws Exception
  {
    Assert.assertEquals(Arrays.asList(9210), errorCodes(generate(
      "class Person { name; 1 -- * Pet pets sorted {name}; sm { S { go [petsPriority == null] -> S; } } }\nclass Pet { name; }\n")));
  }

  // A static method whose first parameter is named cls is a static method, not a class method
  @Test
  public void aStaticMethodWithAParameterNamedClsIsDispatched() throws Exception
  {
    String account = generate("class Account { unique email; static String getWithEmail(String cls, Boolean ignoreCase) Python { return \"user\" } }\n")
      .getGeneratedCode().get("Account");
    Assert.assertTrue(account, account.contains("    def getWithEmail(*args, **kwargs):"));
  }

  // One Python name cannot be a static and an instance method, even when Python generates one of them
  @Test
  public void staticAndInstanceMethodsOfOneNameAreReported() throws Exception
  {
    Assert.assertEquals(Arrays.asList(9210), errorCodes(generate("class P { name; static String getName(Integer x) Python { return \"\" } }\n")));
  }

  // Java's unique-attribute and sorting code is its own: Python generated after Java in one run is
  // the same as Python alone
  @Test
  public void pythonAfterJavaIsPythonAlone() throws Exception
  {
    String model = "class Account { unique email; }\nclass Mentor { 0..1 -- * Student students sorted {rank}; }\n"
      + "class Student { Integer rank; }\n";
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), ("generate Java \"java\";\ngenerate PythonNext;\n" + model).getBytes("UTF-8"));
    UmpleModel both = new UmpleModel(new UmpleFile(file));
    both.setShouldGenerate(true);
    both.run();
    Assert.assertTrue(both.getLastResult().toString(), both.getLastResult().getErrorMessages().isEmpty());
    Assert.assertEquals(generate(model).getGeneratedCode().get("Account"), both.getGeneratedCode().get("Account"));
    Assert.assertEquals(generate(model).getGeneratedCode().get("Mentor"), both.getGeneratedCode().get("Mentor"));
  }

  // Generated Python ends its lines with "\n" whatever the model's line endings (the platform's
  // separator is covered by running the suites with -Dline.separator set to CRLF)
  @Test
  public void generatedPythonHasUnixLineEndings() throws Exception
  {
    String model = "class Door {\n  Integer width = 3;\n  Integer twice() Python {\n    w = self.getWidth()\n    return w * 2\n  }\n"
      + "  def extra(self):\n      return 1\n  sm { Open { close -> / { width = 4; } Closed; } Closed {} }\n}\n";
    UmpleModel generated = generate(model.replace("\n", "\r\n"));
    Assert.assertEquals(new ArrayList<Integer>(), errorCodes(generated));
    for (File file : generatedFiles())
    {
      Assert.assertFalse(file.getName(), new String(Files.readAllBytes(file.toPath()), "UTF-8").contains("\r"));
    }
    Assert.assertFalse(generatedFiles().isEmpty());
  }

  // Python reads source as UTF-8; the JVM's default charset (Cp1252 on many Windows machines) would
  // replace the characters it lacks or write bytes Python rejects
  @Test
  public void generatedPythonIsUtf8WhateverTheDefaultCharset() throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), "generate PythonNext;\nclass A { String text = \"\\u20ac\\u0100\"; }\n".getBytes("UTF-8"));
    String jvm = new File(new File(System.getProperty("java.home"), "bin"), "java").getPath();
    Process process = new ProcessBuilder(jvm, "-Dfile.encoding=ISO-8859-1", "-cp", System.getProperty("java.class.path"),
      "cruise.umple.UmpleConsoleMain", file.getPath()).redirectErrorStream(true).redirectOutput(new File(dir, "umple.out")).start();
    Assert.assertTrue(process.waitFor(60, java.util.concurrent.TimeUnit.SECONDS));
    Assert.assertEquals(0, process.exitValue());
    String code = new String(Files.readAllBytes(new File(dir, "A.py").toPath()), "UTF-8");
    Assert.assertTrue(code, code.contains("\"\u20ac\u0100\""));
  }

  // Each ancestry question visits an interface once, however many paths lead to it
  @Test(timeout = 20000)
  public void interfacesWithManySharedAncestorsGenerateQuickly() throws Exception
  {
    StringBuilder model = new StringBuilder("interface A0 { }\ninterface B0 { }\n");
    for (int i = 1; i < 40; i++)
    {
      for (String name : Arrays.asList("A", "B"))
      {
        model.append("interface " + name + i + " { isA A" + (i - 1) + ", B" + (i - 1) + "; }\n");
      }
    }
    Assert.assertEquals(new ArrayList<Integer>(), errorCodes(generate(model.toString())));
  }

  // A runtime error in Python-tagged code is reported at its line of the model
  @Test
  public void tracebacksOfTaggedCodeNameTheModelLine() throws Exception
  {
    cruise.umple.implementation.TemplateTest.assumePython();
    generate("class Runner {\n"
      + "  void work() Python {\n"
      + "    total = 1\n"
      + "    raise ValueError(total)\n"
      + "  }\n"
      + "  sm { Idle { go / Python { x = 1 / 0 } -> Idle;\n"
      + "    Integer size() Python {\n"
      + "      return len(None)\n"
      + "    } } }\n"
      + "  Integer broken = Python {\n"
      + "    1 / 0\n"
      + "  };\n"
      + "}\n");
    Assert.assertTrue(tracebackOf("Runner().work()"), tracebackOf("Runner().work()").contains("[model.ump:5]"));
    Assert.assertTrue(tracebackOf("Runner().go()"), tracebackOf("Runner().go()").contains("[model.ump:7]"));
    Assert.assertTrue(tracebackOf("Runner().size()"), tracebackOf("Runner().size()").contains("[model.ump:9]"));
    Assert.assertTrue(tracebackOf("Runner().getBroken()"), tracebackOf("Runner().getBroken()").contains("[model.ump:12]"));
  }

  // The traceback of a statement run on the generated classes, mapped to the model
  private String tracebackOf(String statement) throws Exception
  {
    String root = dir.getCanonicalPath() + File.separator;
    File script = new File(root + "run.py");
    Files.write(script.toPath(), ("from Runner import Runner\n" + statement + "\n").getBytes("UTF-8"));
    Process process = new ProcessBuilder(CodeCompiler.getPythonInterpreter(), script.getPath()).redirectErrorStream(true).start();
    String output = new String(process.getInputStream().readAllBytes(), "UTF-8");
    Assert.assertTrue(process.waitFor(30, java.util.concurrent.TimeUnit.SECONDS));
    return CodeCompiler.mapPythonTraceback(output, new String[] { root, root });
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

  private static String messageOf(UmpleModel model, int code)
  {
    for (cruise.umple.parser.ErrorMessage message : model.getLastResult().getErrorMessages())
    {
      if (message.getErrorType().getErrorCode() == code)
      {
        return message.getFormattedMessage();
      }
    }
    return "no message " + code;
  }

  // Codes of the errors (not warnings) the model reported.
  private static List<Integer> errorCodes(UmpleModel model)
  {
    List<Integer> codes = new ArrayList<Integer>();
    for (cruise.umple.parser.ErrorMessage message : model.getLastResult().getErrorMessages())
    {
      if (message.getErrorType().getSeverity() <= 2)
      {
        codes.add(message.getErrorType().getErrorCode());
      }
    }
    return codes;
  }

  private static List<String> sortedNames(UmpleModel model)
  {
    List<String> names = new ArrayList<String>(model.getGeneratedCode().keySet());
    java.util.Collections.sort(names);
    return names;
  }

  private List<File> generatedFiles() throws Exception
  {
    List<File> files = new ArrayList<File>();
    Files.walk(dir.toPath()).filter(p -> p.toString().endsWith(".py")).forEach(p -> files.add(p.toFile()));
    return files;
  }
}
