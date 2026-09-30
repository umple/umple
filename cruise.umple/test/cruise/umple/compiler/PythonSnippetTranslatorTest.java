/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import cruise.umple.parser.ErrorMessage;
import cruise.umple.parser.Position;
import cruise.umple.util.SampleFileWriter;

// The compatibility translator for untagged Java snippets: what it admits and how it
// writes it, what it rejects and with which diagnostic, and, by running the translated Python,
// that Java's evaluation order and integer semantics are kept.
public class PythonSnippetTranslatorTest
{
  private static final String FILE = "pythonSnippetTranslatorTest.ump";

  private static final String MODEL =
      "enum Color { Red, Green }\n"
    + "class Parent {\n"
    + "  Integer base = 1;\n"
    + "  const Integer LIMIT = 10;\n"
    + "  status { Open { close -> Closed; } Closed { } }\n"
    + "  Integer twice(Integer v) { return v * 2; }\n"
    + "  static Integer helper() { return 3; }\n"
    + "}\n"
    + "class Child {\n"
    + "  isA Parent;\n"
    + "  Integer n = 0;\n"
    + "  Integer calls = 0;\n"
    + "  String[] log;\n"
    + "  Integer twiceN = { n * 2 }\n"
    + "  String name;\n"
    + "  Double ratio = 1.5;\n"
    + "  Boolean flag = false;\n"
    + "  String[] tags;\n"
    + "  Color color = Color.Red;\n"
    + "  const Integer MAX = 5;\n"
    + "  0..1 -> 0..1 Child next;\n"
    + "  1 -- * Item items;\n"
    + "  mode { On { flip -> Off; } Off { flip -> On; Sub { e -> Sub2; } Sub2 { } } }\n"
    + "  other { Open { go -> Shut; } Shut { } }\n"
    + "  Child receiver() { return this; }\n"
    + "  Integer change() { return 3; }\n"
    + "  String pair(Integer a, Integer b) { return a + \",\" + b; }\n"
    + "  static Integer count() { return 0; }\n"
    + "  Object anything() { return null; }\n"
    + "}\n"
    + "class Item { Integer weight; }\n"
    + "class Outer { static class Inner { } }\n";

  private UmpleModel model;
  private PythonGenerator gen;
  private int checkedErrors;

  @Before
  public void setUp()
  {
    load(MODEL);
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(FILE);
  }

  private void load(String umple)
  {
    SampleFileWriter.createFile(FILE, umple);
    model = new UmpleModel(new UmpleFile(FILE));
    model.setShouldGenerate(false);
    model.run();
    gen = new PythonGenerator();
    gen.setModel(model);
    checkedErrors = 0;
  }

  // Parameters are written "name:Type".
  private static List<MethodParameter> parameters(String... declarations)
  {
    List<MethodParameter> parameters = new ArrayList<MethodParameter>();
    for (String declaration : declarations)
    {
      String[] parts = declaration.split(":");
      parameters.add(new MethodParameter(parts[0], parts[1], null, null, false));
    }
    return parameters;
  }

  private String statements(String className, String code, String... parameters)
  {
    return gen.translateSnippetAt(code, model.getUmpleClass(className), parameters(parameters), false, false, null, "the action of the transition e");
  }

  private String staticStatements(String className, String code)
  {
    return gen.translateSnippetAt(code, model.getUmpleClass(className), null, true, false, null, "the before injection for count");
  }

  private String expression(String className, String code)
  {
    return gen.translateSnippetAt(code, model.getUmpleClass(className), null, false, true, null, "the default value of attribute x");
  }

  private String classBody(String className, String code)
  {
    return gen.translateSnippetAt(code, model.getUmpleClass(className), null, true, true, null, "the constant X");
  }

  private static String lines(String... lines)
  {
    return String.join("\n", lines);
  }

  // The 9211 errors reported since the last call.
  private List<ErrorMessage> newSnippetErrors()
  {
    List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
    for (ErrorMessage error : model.getLastResult().getErrorMessages())
    {
      if (error.getErrorType().getErrorCode() == 9211)
      {
        errors.add(error);
      }
    }
    List<ErrorMessage> added = new ArrayList<ErrorMessage>(errors.subList(checkedErrors, errors.size()));
    checkedErrors = errors.size();
    return added;
  }

  private void assertRejected(String reason, String result)
  {
    Assert.assertNull("translated to " + result, result);
    List<ErrorMessage> errors = newSnippetErrors();
    Assert.assertEquals(1, errors.size());
    String message = errors.get(0).getFormattedMessage();
    Assert.assertTrue(message, message.contains(reason));
  }

  private void assertRejected(String reason, String className, String code, String... parameters)
  {
    assertRejected(reason, statements(className, code, parameters));
  }

  //------------------------
  // Names
  //------------------------

  @Test
  public void attributesAssociationsAndStateMachinesAreAssignedThroughTheirFields()
  {
    load("class Light1 {\n  light { OFF{} ON{} }\n  Integer brightness = 0;\n"
      + "  sm { s1 { on -> s2; } s2 { set(Integer b) [b >= 1] -> / { brightness = b; } s2; } }\n}\n");
    Assert.assertEquals(lines("self._light = Light1.Light.ON", "self._brightness = 0"),
      statements("Light1", "light = Light.ON; brightness = 0;"));
    Assert.assertEquals("self._brightness = b", statements("Light1", "brightness=b;", "b:Integer"));
  }

  @Test
  public void resolutionFollowsJavaOrder()
  {
    // A parameter hides the attribute, a local hides it within its block only.
    Assert.assertEquals("n = 5", statements("Child", "n = 5;", "n:Integer"));
    Assert.assertEquals(lines("n = 1", "n = 2", "self._n = 3"), statements("Child", "{ int n = 1; n = 2; } n = 3;"));
    Assert.assertEquals(lines("self._base = 2", "self._next = self", "self._items = None", "self._mode = Child.Mode.On"),
      statements("Child", "base = 2; next = this; items = null; mode = Mode.On;"));
  }

  @Test
  public void inheritedMembersAndConstants()
  {
    Assert.assertEquals(lines("self._base = Parent.LIMIT + Child.MAX", "self._status = Parent.Status.Closed", "self.twice(self._base)"),
      statements("Child", "base = LIMIT + MAX; status = Status.Closed; twice(base);"));
  }

  @Test
  public void callsResolveToMemberMethodsAndStaticMethodsUseTheirClass()
  {
    Assert.assertEquals(lines("self.setN(self.getN() + 1)", "self.flip()", "self.go()", "self.delete()", "Parent.helper()", "Child.count()",
      "self.addTag(\"a\")", "self.setFlag(self.isFlag())", "_tmp1 = self.getItem(0)", "_tmp2 = self.numberOfItems()", "_tmp1.setWeight(_tmp2)"),
      statements("Child", "setN(getN() + 1); flip(); go(); delete(); helper(); count(); addTag(\"a\"); setFlag(isFlag());"
        + " getItem(0).setWeight(numberOfItems());"));
  }

  @Test
  public void receiverChainsFollowTheModelReturnTypes()
  {
    Assert.assertEquals(lines("_tmp1 = self.getNext().getNext()", "_tmp2 = self.getNext().getItem(0).getWeight()", "_tmp1.setN(_tmp2)"),
      statements("Child", "getNext().getNext().setN(getNext().getItem(0).getWeight());"));
    Assert.assertEquals("self.getNext().getNext().setN(self._n)", statements("Child", "getNext().getNext().setN(n);"));
    Assert.assertEquals(lines("self._next._n = 5", "self._n = 4", "self._next._name = \"x\""),
      statements("Child", "next.n = 5; this.n = 4; next.name = \"x\";"));
    assertRejected("'weight2(...)' is not a method of Item", "Child", "getItem(0).weight2();");
    // Methods declared inside states are generated as one method that depends on the state.
    load("class Mario { sm { Small { void onHit() { } hit -> Big; } Big { void onHit() { } } } }");
    Assert.assertEquals("self.onHit()", statements("Mario", "onHit();"));
    // A role whose singular is its plural has getX(index) and getX() with one name.
    load("class Door { 0..1 -- * Person mayUse; }\nclass Person { Integer n; }\n");
    Assert.assertEquals(lines("self.getMayUse(0).setN(1)", "for p in self.getMayUse():", "    p.setN(2)"),
      statements("Door", "getMayUse(0).setN(1); for (Person p : getMayUse()) p.setN(2);"));
  }

  @Test
  public void overloadsAreChosenByTheirArguments()
  {
    load("class C {\n  Integer n = 0;\n  Integer f(Integer x) { return 5; }\n  Double f(Double x) { return 5.5; }\n"
      + "  Item choice(Integer x) { return null; }\n  C choice(Integer x, Integer y) { return this; }\n"
      + "  static Integer mixed(Integer x) { return 7; }\n  Integer mixed(Integer x, Integer y) { return 8; }\n}\n"
      + "class Item { Integer weight; }\n");
    Assert.assertEquals("d = self.f(1.0) / 2", statements("C", "double d = f(1.0) / 2;"));
    Assert.assertEquals("self.choice(1, 2).setN(1)", statements("C", "choice(1, 2).setN(1);"));
    assertRejected("static code cannot use mixed(...)", staticStatements("C", "mixed(1, 2);"));
    assertRejected("'f(...)' of C does not take these arguments", "C", "f(\"x\");");
  }

  @Test
  public void generatedMethodsFollowThePythonApi()
  {
    load("class Owner {\n  defaulted Integer n = 7;\n  1 -- * Item items;\n  0..1 -- 2 Part parts;\n  state { A { event -> B; } B { } }\n}\n"
      + "class Item { Integer weight; }\nclass Part { }\n");
    // addItem(...) also creates the item, because an item needs its owner.
    Assert.assertEquals("self.addItem(3).setWeight(4)", statements("Owner", "addItem(3).setWeight(4);"));
    // A default getter is an instance method, as the template writes it; the limits of an end are static
    Assert.assertEquals("k = self.getDefaultN() + Owner.maximumNumberOfParts() + Owner.requiredNumberOfParts()",
      statements("Owner", "int k = getDefaultN() + maximumNumberOfParts() + requiredNumberOfParts();"));
    assertRejected("'maximumNumberOfItems(...)' is not a method of class Owner", "Owner", "maximumNumberOfItems();");
    assertRejected("returns nothing", "Owner", "boolean b = setState(State.A);");
    assertRejected("'setN(...)' of Owner does not take these arguments", "Owner", "setN();");
    assertRejected("'event(...)' of Owner does not take these arguments", "Owner", "event(1);");
  }

  // A sorted end's comparator is Java's alone: Python has neither its field nor its accessors
  @Test
  public void aSortedEndHasNoComparatorInPython()
  {
    load("class Person {\n  name;\n  1 -- * Pet pets sorted {name};\n}\nclass Pet { name; }\n");
    assertRejected("petsPriority", "Person", "boolean b = petsPriority == null;");
    assertRejected("getPetsPriority", "Person", "getPetsPriority();");
  }

  // isX exists for Boolean attributes and full names for top-level machines only, as the templates
  // write them
  @Test
  public void generatedQueriesMatchTheTemplates()
  {
    load("class L {\n  boolean lit;\n  Boolean on;\n  sm { Top { Inner { go -> Other; } Other { } } }\n}\n");
    assertRejected("isLit", "L", "boolean b = isLit();");
    Assert.assertEquals("b = self.isOn()", statements("L", "boolean b = isOn();"));
    assertRejected("getSmTopFullName", "L", "String s = getSmTopFullName();");
    Assert.assertEquals("s = self.getSmFullName()", statements("L", "String s = getSmFullName();"));
  }

  // An immutable end has no public mutator in Python (Java's are private), so code calling one is
  // rejected rather than failing when it runs
  @Test
  public void anImmutableEndHasNoMutatorInPython()
  {
    load("class A {\n  immutable * -> 0..1 B item;\n  immutable * -> * B others;\n}\nclass B { immutable; }\n");
    assertRejected("setItem", "A", "setItem(null);");
    assertRejected("addOther", "A", "addOther(null);");
    Assert.assertEquals("b = self.getItem()", statements("A", "B b = getItem();"));
  }

  // A simple machine's setter returns True, and a unique attribute set once has a setter, as the
  // templates write them
  @Test
  public void generatedSettersMatchTheTemplates()
  {
    load("class K {\n  unique immutable Integer id;\n  level { Low { } High { } }\n}\n");
    Assert.assertEquals("b = self.setLevel(K.Level.High)", statements("K", "boolean b = setLevel(Level.High);"));
    Assert.assertEquals("self.setId(3)", statements("K", "setId(3);"));
  }

  @Test
  public void staticMembersThroughAnObjectUseTheirClass()
  {
    Assert.assertEquals(lines("c = None", "print(Child.count(), Child.MAX, Child.MAX)"), statements("Child", "Child c = null; print(c.count(), this.MAX, next.MAX);"));
    // An object with effects, or whose evaluation can fail, is still evaluated first; its value is
    // not used, so it may be null.
    Assert.assertEquals(lines("self.receiver()", "Child.count()"), statements("Child", "receiver().count();"));
    Assert.assertEquals(lines("self.receiver()", "self.receiver()", "self._n = Child.MAX + Child.count()"),
      statements("Child", "n = receiver().MAX + receiver().count();"));
    Assert.assertEquals(lines("c = None", "c._next", "print(Child.MAX)"), statements("Child", "Child c = null; print(c.next.MAX);"));
    Assert.assertEquals(lines("self.getColor()", "self._color = Child.Color.Green"), statements("Child", "color = getColor().Green;"));
    // Where no statement can come first, the object is the first item of a tuple.
    Assert.assertEquals("(self.receiver(), Child.count())[1]", expression("Child", "receiver().count()"));
    Assert.assertEquals("(self.receiver(), Child.MAX)[1]", expression("Child", "receiver().MAX"));
    Assert.assertEquals("Child.MAX", expression("Child", "next.MAX"));
  }

  // Python looks a method up on its object before evaluating the arguments, so a null object would
  // skip their effects; Java evaluates them before it fails. Where that can happen, the object and the
  // arguments are kept first.
  @Test
  public void argumentsComeBeforeTheCallOfAnObjectThatMayBeNull()
  {
    Assert.assertEquals(lines("_tmp1 = self._next", "_tmp2 = self._n", "_tmp3 = self.change()", "_tmp1.pair(_tmp2, _tmp3)"),
      statements("Child", "next.pair(n, change());"));
    Assert.assertEquals(lines("_tmp1 = self.receiver()", "_tmp2 = self.change()", "_tmp1.setN(_tmp2)"), statements("Child", "receiver().setN(change());"));
    Assert.assertEquals("(lambda x, *y: x.pair(*y))(self._next, 1, self.change())", expression("Child", "next.pair(1, change())"));
    // Arguments without effects, this and a new object keep the plain call.
    Assert.assertEquals(lines("self._next.setN(self._n)", "self.setN(self.change())", "Child().setN(self.change())", "self.receiver().getN()"),
      statements("Child", "next.setN(n); this.setN(change()); new Child().setN(change()); receiver().getN();"));
  }

  @Test
  public void failingArgumentsComeBeforeTheNullReceiverCheck()
  {
    String division = "1 // self._n if (1 < 0) == (self._n < 0) else -(-1 // self._n)";
    Assert.assertEquals(lines("_tmp1 = self._next", "_tmp2 = " + division, "_tmp1.setN(_tmp2)"),
      statements("Child", "next.setN(1 / n);"));
    Assert.assertEquals("(lambda x, *y: x.setN(*y))(self._next, " + division + ")",
      expression("Child", "next.setN(1 / n)"));
    Assert.assertEquals(lines("_tmp1 = self._next", "_tmp2 = self._next._n", "_tmp1.setN(_tmp2)"),
      statements("Child", "next.setN(next.n);"));
    Assert.assertEquals("(lambda x, *y: x.setN(*y))(self._next, self._next._n)",
      expression("Child", "next.setN(next.n)"));
    Assert.assertEquals("(lambda x, *y: x.setN(*y))(self._next, (self._next._next, Child.MAX)[1])",
      expression("Child", "next.setN(next.next.MAX)"));
    Assert.assertEquals(lines("_tmp1 = self._next", "_tmp2 = 1 + (" + division + ")", "_tmp1.setN(_tmp2)"),
      statements("Child", "next.setN(1 + 1 / n);"));
    // Plain reads cannot fail before the null check, so they keep their direct form.
    Assert.assertEquals(lines("local = 2", "self._next.setN(1)", "self._next.setN(local)",
      "self._next.setN(p)", "self._next.setN(self._n)", "self._next.setN(self._n)", "self._next.setN(self._n + 1)",
      "self._next.setN(4 // 2)", "self._next.setN(self._n)"),
      statements("Child", "int local = 2; next.setN(1); next.setN(local); next.setN(p); next.setN(n); next.setN(this.n); next.setN(n + 1); next.setN(4 / 2); next.setN((int) n);", "p:Integer"));
  }

  @Test
  public void enumerationsBelongToTheirOwner()
  {
    // Two machines with a state named Open, a nested machine with its Null state, a model
    // enumeration generated inside the class that uses it.
    Assert.assertEquals(lines("self._other = Child.Other.Open", "self._status = Parent.Status.Open",
      "if self.getModeOff() is Child.ModeOff.Null:", "    self._color = Child.Color.Green"),
      statements("Child", "other = Other.Open; status = Status.Open; if (getModeOff() == ModeOff.Null) { color = Color.Green; }"));
    assertRejected("'Shut' is not a value of Status", "Child", "status = Status.Shut;");
    // A machine named like its enumeration: Java resolves Light to the field and reads the
    // enumeration's constant through it.
    load("class Signal { Light { Red { } Green { } } }");
    Assert.assertEquals("self.setLight(Signal.Light.Green)", statements("Signal", "setLight(Light.Green);"));
    // Java spells enumerations and their values in PascalCase, also for another class's copy.
    load("enum color { red, green }\nclass A { color c; size s; enum size { small } }\nclass B { color c; }\n");
    Assert.assertEquals(lines("self._c = A.Color.Red", "self._s = A.Size.Small"), statements("A", "c = Color.Red; s = Size.Small;"));
    Assert.assertEquals("A.Color.Green", expression("B", "A.Color.Green"));
  }

  @Test
  public void constantsAreQualifiedInMethodsAndBareInTheClassBody()
  {
    Assert.assertEquals("k = Child.MAX * 2", statements("Child", "int k = MAX * 2;"));
    Assert.assertEquals("MAX * 2", classBody("Child", "MAX * 2"));
    Assert.assertEquals("Parent.LIMIT + MAX", classBody("Child", "LIMIT + MAX"));
    Assert.assertEquals("Color.Red", classBody("Child", "Color.Red"));
    assertRejected("while the class is being defined cannot call count(...)", classBody("Child", "count()"));
    assertRejected("while the class is being defined cannot use n", classBody("Child", "n + 1"));
    // An enclosing or nested class is still being defined too.
    load("class Outer { const Integer X = 7; static class Inner { const Integer Y = 1; } }");
    assertRejected("cannot use Outer, which is also still being defined", classBody("Inner", "Outer.X"));
    assertRejected("cannot use Outer.Inner, which is also still being defined", classBody("Outer", "Inner.Y"));
  }

  @Test
  public void staticCodeUsesClassesAndRejectsTheObject()
  {
    Assert.assertEquals(lines("Child.count()", "k = Child.MAX"), staticStatements("Child", "count(); int k = MAX;"));
    assertRejected("static code cannot use n, which needs an object", staticStatements("Child", "n = 1;"));
    assertRejected("static code cannot use flip(...)", staticStatements("Child", "flip();"));
    assertRejected("static code cannot use this", staticStatements("Child", "count(this);"));
  }

  @Test
  public void parametersAndLocalsGetPythonNames()
  {
    // Generated Python calls a parameter named in "input" and adds _ to other keywords.
    Assert.assertEquals("self._name = input + from_", statements("Child", "name = in + from;", "in:String", "from:String"));
    // Locals may not hide the names the translation uses or Python keywords.
    Assert.assertEquals(lines("str_ = 1", "is_ = True", "print(\"\" + str(str_) + (\"true\" if is_ else \"false\"))"),
      statements("Child", "int str = 1; boolean is = true; System.out.println(\"\" + str + is);"));
    assertRejected("the parameter str hides the name str", "Child", "name = \"\" + n;", "str:String");
    // A parameter may not hide a class the code refers to either.
    assertRejected("the parameter Item hides the name Item", "Child", "addItem(new Item(1, this));", "Item:String");
    // Temporaries avoid the snippet's own names.
    Assert.assertEquals(lines("_tmp1 = 0", "_tmp2 = _tmp1", "_tmp1 += 1", "self._n = _tmp2"),
      statements("Child", "int _tmp1 = 0; n = _tmp1++;"));
  }

  //------------------------
  // Statements
  //------------------------

  @Test
  public void localDeclarations()
  {
    Assert.assertEquals(lines("a = 1", "s = \"x\"", "c = self.getNext()", "d = 5.0", "f = float(a)", "e = None"),
      statements("Child", "int a = 1, b; final String s = \"x\"; Child c = getNext(); double d = 5; float f = a; Item e = null;"));
  }

  @Test
  public void literals()
  {
    Assert.assertEquals(lines("l = 10", "h = 0x1F", "o = 0o17", "d = 1.5", "e = 2.0", "g = 1e3", "c = \"\\n\"", "s = \"tab\\tquote\\\" A\"",
        "t = True", "x = None", "u = 1000", "v = 0xAB", "w = 0o7"),
      statements("Child", "long l = 10L; int h = 0x1F; int o = 017; double d = 1.5f; double e = 2d; double g = 1e3; char c = '\\n';"
        + " String s = \"tab\\tquote\\\" \\u0041\"; boolean t = true; Child x = null; int u = 1__000; int v = 0xA_B; int w = 0_7;"));
  }

  @Test
  public void ifElseChainsBecomeElif()
  {
    Assert.assertEquals(lines("if self._n > 5:", "    self._n = 1", "elif self._n > 2:", "    self._n = 2", "else:", "    self._n = 3"),
      statements("Child", "if (n > 5) { n = 1; } else if (n > 2) n = 2; else { n = 3; }"));
  }

  @Test
  public void loops()
  {
    Assert.assertEquals(lines("while self._n < 3:", "    self._n += 1", "    if self._flag:", "        break"),
      statements("Child", "while (n < 3) { n++; if (flag) break; }"));
    // The update of a for loop also runs before continue.
    Assert.assertEquals(lines("i = 0", "while i < 3:", "    if i == 1:", "        i += 1", "        continue", "    self._n += i", "    i += 1"),
      statements("Child", "for(int i=0; i<3; i++) { if(i==1) continue; n+=i; }"));
    Assert.assertEquals(lines("while True:", "    pass"), statements("Child", "for (;;) { }"));
  }

  @Test
  public void enhancedForGoesThroughModelCollections()
  {
    Assert.assertEquals(lines("for it in self.getItems():", "    it.setWeight(1)", "for it in self._items:", "    continue",
        "for t in self._tags:", "    self._name = t"),
      statements("Child", "for (Item it : getItems()) { it.setWeight(1); } for (Item it : items) continue; for (String t : tags) name = t;"));
    assertRejected("can only go through a collection of the model", "Child", "for (Item it : getItem(0)) { }");
  }

  @Test
  public void returnAndEmptySnippets()
  {
    Assert.assertEquals(lines("if self._n == 0:", "    return", "return self._n > 1"), statements("Child", "if (n == 0) return; return n > 1;"));
    Assert.assertEquals(lines("# nothing here", "# at all", "pass"), statements("Child", "  // nothing here\n /* at all */ ;"));
    Assert.assertEquals("pass", statements("Child", ""));
  }

  @Test
  public void commentsStayBeforeTheirStatements()
  {
    // A lone carriage return also ends a line comment.
    Assert.assertEquals(lines("# heading", "self._n += 1"), statements("Child", "// heading\rn++;"));
    Assert.assertEquals(lines("# count it", "self._n += 1", "if self._flag:", "    # nothing yet", "    pass", "#", "# done", "# twice"),
      statements("Child", "// count it\nn++;\nif (flag) {\n  // nothing yet\n}\n/*\n * done\n * twice */"));
  }

  @Test
  public void printing()
  {
    // println ends the line, print does not; a bare print is Python's print.
    Assert.assertEquals(lines("print(\"a\")", "print(\"b\", end=\"\")", "print()", "print(\"Show Me Last (Exit)\")"),
      statements("Child", "System.out.println(\"a\"); System.out.print(\"b\"); System.out.println(); print(\"Show Me Last (Exit)\");"));
  }

  @Test
  public void runtimeExceptionsAreRaised()
  {
    Assert.assertEquals(lines("if aQuery is None:", "    raise RuntimeError(\"Please provide a valid query: \" + str(self._n))"),
      statements("Child", "if (aQuery == null) { throw new RuntimeException(\"Please provide a valid query: \" + n); }", "aQuery:String"));
  }

  @Test
  public void modelObjectsAreCreatedAndImportedInsideTheFunction()
  {
    Assert.assertEquals(lines("from Item import Item", "from Outer import Outer", "self.addItem(Item(3, self))", "o = Outer.Inner()"),
      statements("Child", "addItem(new Item(3, this)); Outer.Inner o = new Outer.Inner();"));
    load("namespace shop;\nclass A { }\nnamespace other;\nclass B { }\n");
    Assert.assertEquals(lines("from shop.A import A", "a = A()"), statements("B", "A a = new A();"));
    // An expression cannot hold the import, so its caller gets it.
    Assert.assertEquals("A()", expression("B", "new A()"));
    Assert.assertEquals(Arrays.asList("from shop.A import A"), gen.getSnippetImports());
    // A class-body initializer runs at import time, so the import is at module level.
    Assert.assertEquals("A()", classBody("B", "new A()"));
    Assert.assertTrue(gen.moduleImports(), gen.moduleImports().contains("from shop.A import A"));
    // Rejected code leaves no imports behind.
    load("class A { Double r; }\nclass B { }\n");
    Assert.assertNull(statements("A", "r = r % 2 + new B().foo();"));
    Assert.assertEquals("", gen.moduleImports());
  }

  @Test
  public void listDefaultsAreModelData()
  {
    Assert.assertEquals("[\"a\", \"b,c\"]", gen.translateListDefault("\"a\", \"b,c\"", model.getUmpleClass("Child"), false, null, "the default value of attribute tags"));
    Assert.assertEquals("[Item(1, self), Item(2, self)]", gen.translateListDefault("new Item(1, this),new Item(2, this)", model.getUmpleClass("Child"), false, null, "the default value of attribute x"));
    Assert.assertEquals(Arrays.asList("from Item import Item"), gen.getSnippetImports());
    Assert.assertEquals("[]", gen.translateListDefault("", model.getUmpleClass("Child"), false, null, "the default value of attribute tags"));
    Assert.assertNull(gen.translateListDefault("\"a\", len(\"b\")", model.getUmpleClass("Child"), false, null, "the default value of attribute tags"));
  }

  //------------------------
  // Expressions and semantics
  //------------------------

  @Test
  public void stringConcatenationConvertsTheOtherOperand()
  {
    Assert.assertEquals(lines("s = \"n=\" + str(self._n) + (\"true\" if self._flag else \"false\") + \"c\" + self._name", "t = str(1 + 2) + \"a\"",
        "self._name += str(self._n)", "self._name += \"x\""),
      statements("Child", "String s = \"n=\" + n + flag + 'c' + name; String t = 1 + 2 + \"a\"; name += n; name += \"x\";"));
  }

  @Test
  public void modelObjectsAndEnumerationsCompareByIdentity()
  {
    Assert.assertEquals(lines("a = self._next is None", "b = self._next is not self", "c = self._mode is Child.Mode.On", "d = self._n == 3",
        "e = self._name != \"x\"", "f = self._next is None"),
      statements("Child", "boolean a = next == null; boolean b = next != this; boolean c = mode == Mode.On; boolean d = n == 3;"
        + " boolean e = name != \"x\"; boolean f = null == next;"));
  }

  @Test
  public void operatorsKeepJavaPrecedence()
  {
    Assert.assertEquals(lines("a = not self._flag and (self._n > 0 or self._flag)", "b = (self._n + 1) * 2", "c = self._n - (1 - 2)",
        "d = (self._n == 1) == self._flag", "e = -(-self._n)", "f = not self._n > 0", "g = ~self._n & 3", "h = self._n << 2 | 1"),
      statements("Child", "boolean a = !flag && (n > 0 || flag); int b = (n + 1) * 2; int c = n - (1 - 2); boolean d = (n == 1) == flag;"
        + " int e = -(-n); boolean f = !(n > 0); int g = ~n & 3; int h = n << 2 | 1;"));
  }

  @Test
  public void castsToNumbers()
  {
    Assert.assertEquals(lines("a = int(self._ratio)", "b = float(self._n)", "c = self._n", "d = int(self._ratio * 2)"),
      statements("Child", "int a = (int) ratio; double b = (double) n; long c = (long) n; int d = (int) (ratio * 2);"));
  }

  @Test
  public void integerDivisionAndRemainderTruncateTowardZero()
  {
    Assert.assertEquals(lines("a = self._n // 2 if self._n >= 0 else -(-self._n // 2)",
        "b = self._n % self._base if (self._n < 0) == (self._base < 0) else -(-self._n % self._base)",
        "c = self._ratio / 2", "d = math.fmod(self._ratio, 2)"),
      statements("Child", "int a = n / 2; int b = n % base; double c = ratio / 2; double d = ratio % 2;"));
    Assert.assertTrue(gen.moduleImports().contains("import math"));
    // Python's // and % agree with Java when neither operand can be negative.
    Assert.assertEquals("a = 7 // 2 + 7 % 2", statements("Child", "int a = 7 / 2 + 7 % 2;"));
    // Operands with effects are computed once, in order.
    Assert.assertEquals(lines("_tmp1 = self._n", "_tmp2 = self.change()",
        "k = _tmp1 // _tmp2 if (_tmp1 < 0) == (_tmp2 < 0) else -(-_tmp1 // _tmp2)"),
      statements("Child", "int k = n / change();"));
    Assert.assertEquals("(lambda x, y: x // y if (x < 0) == (y < 0) else -(-x // y))(self.getN(), self.change())",
      expression("Child", "getN() / change()"));
    // A division's result is used once however deep the divisions nest, so the code grows linearly
    Assert.assertTrue(expression("Child", "getN() / 2 / 2 / 2 / 2 / 2 / 2").length() < 1000);
  }

  // Hexadecimal, octal and binary literals are the bits of a signed int, or long with L, as in Java
  @Test
  public void nonDecimalIntegerLiteralsTakeJavasSignedValue()
  {
    Assert.assertEquals(lines("h = (-1)", "g = 0xFF", "l = (-1)"),
      statements("Child", "int h = 0xFFFFFFFF; int g = 0xFF; long l = 0xFFFFFFFFFFFFFFFFL;"));
  }

  @Test
  public void derivedAndDefaultExpressions()
  {
    Assert.assertEquals("self._n * 2 if self._flag else 0", expression("Child", "flag ? n * 2 : 0"));
    Assert.assertEquals("self.getNext().getName()", expression("Child", "getNext().getName()"));
    assertRejected("++ changes a variable, which an initial value or derived attribute cannot do", expression("Child", "n++"));
    assertRejected("returns nothing", expression("Child", "delete()"));
    assertRejected("'len(...)' is not a method of class Child", expression("Child", "len(\"abc\")"));
  }

  //------------------------
  // Java evaluation order
  //------------------------

  @Test
  public void incrementsInsideExpressionsKeepTheirValue()
  {
    Assert.assertEquals(lines("i = 1", "_tmp1 = i", "i += 1", "r = self.pair(_tmp1, i)"),
      statements("Child", "int i = 1; String r = pair(i++, i);"));
    Assert.assertEquals(lines("x = 1", "_tmp1 = x", "x += 1", "x = _tmp1"), statements("Child", "int x = 1; x = x++;"));
    Assert.assertEquals(lines("x = 1", "x += 1", "_tmp1 = x", "y = _tmp1 * 2"), statements("Child", "int x = 1; int y = ++x * 2;"));
  }

  @Test
  public void compoundAssignmentEvaluatesItsTargetOnce()
  {
    Assert.assertEquals(lines("_tmp1 = self.receiver()", "_tmp1._n += self.change()"), statements("Child", "receiver().n += change();"));
    // When the right-hand side needs statements first, the old value is read before them.
    Assert.assertEquals(lines("i = 0", "_tmp2 = self._n", "_tmp1 = i", "i += 1", "self._n = _tmp2 + _tmp1"),
      statements("Child", "int i = 0; n += i++;"));
    Assert.assertEquals("self._n = int(self._n * self._ratio)", statements("Child", "n *= ratio;"));
    Assert.assertEquals("self._n = self._n // 2 if self._n >= 0 else -(-self._n // 2)", statements("Child", "n /= 2;"));
  }

  @Test
  public void shortCircuitAndTernaryBranchesKeepTheirEffects()
  {
    Assert.assertEquals(lines("_tmp2 = self._flag", "if _tmp2:", "    _tmp1 = self._n", "    self._n += 1", "    _tmp2 = _tmp1 > 0",
        "if _tmp2:", "    self._n = 5"),
      statements("Child", "if (flag && n++ > 0) { n = 5; }"));
    Assert.assertEquals(lines("if self._flag:", "    _tmp1 = self._n", "    self._n += 1", "    _tmp2 = _tmp1", "else:", "    _tmp2 = 0",
        "v = _tmp2"),
      statements("Child", "int v = flag ? n++ : 0;"));
    Assert.assertEquals("v = (2 if self._n > 5 else 1) if self._n > 0 else 0", statements("Child", "int v = n > 0 ? (n > 5 ? 2 : 1) : 0;"));
  }

  // The translated statements run as the body of run(self) on a stand-in for the generated class;
  // the output must be what the Java code prints.
  private String runTranslated(String code)
  {
    String python = statements("Child", code);
    Assert.assertNotNull(newSnippetErrors().toString(), python);
    String program = lines(
      gen.moduleImports(),
      "class Child:",
      "    def __init__(self):",
      "        self._n = 2",
      "        self._flag = False",
      "        self._calls = 0",
      "        self._log = []",
      "    def receiver(self):",
      "        self._calls += 1",
      "        self._log.append(\"receiver\")",
      "        return self",
      "    def change(self):",
      "        self._log.append(\"change\")",
      "        self._n = 100",
      "        return 3",
      "    def pair(self, a, b):",
      "        return str(a) + \",\" + str(b)",
      "    def getN(self):",
      "        return self._n",
      "def run(self):",
      "    " + python.replace("\n", "\n    "),
      "c = Child()",
      "run(c)",
      "");
    return runPython(program);
  }

  private static String runPython(String program)
  {
    cruise.umple.implementation.TemplateTest.assumePython();
    String python = CodeCompiler.getPythonInterpreter();
    File script = null;
    File output = null;
    try
    {
      script = File.createTempFile("snippet", ".py");
      output = File.createTempFile("snippet", ".out");
      Files.write(script.toPath(), program.getBytes("UTF-8"));
      Process process = new ProcessBuilder(python, "-I", script.getPath()).redirectErrorStream(true).redirectOutput(output).start();
      if (!process.waitFor(30, TimeUnit.SECONDS))
      {
        process.destroyForcibly();
        Assert.fail("the translated code did not finish:\n" + program);
      }
      String printed = new String(Files.readAllBytes(output.toPath()), "UTF-8");
      Assert.assertEquals(program + "\n" + printed, 0, process.exitValue());
      return printed;
    }
    catch (Exception e)
    {
      throw new AssertionError(e);
    }
    finally
    {
      if (script != null)
      {
        script.delete();
      }
      if (output != null)
      {
        output.delete();
      }
    }
  }

  @Test
  public void shiftDistancesUseThePromotedLeftOperand()
  {
    for (String op : Arrays.asList("<<", ">>"))
    {
      Assert.assertEquals("self._n " + op + " (self._base & 31)", expression("Child", "n " + op + " base"));
      Assert.assertEquals("1 " + op + " (-1 & 31)", expression("Child", "1 " + op + " -1"));
      Assert.assertEquals("1 " + op + " (32 & 31)", expression("Child", "1 " + op + " 32"));
      Assert.assertEquals("1 " + op + " (64 & 63)", expression("Child", "1L " + op + " 64"));
      Assert.assertEquals("1 " + op + " 32", expression("Child", "1L " + op + " 32"));
      Assert.assertEquals("1 " + op + " (32 & 31)", expression("Child", "1 " + op + " 32L"));
      for (String count : Arrays.asList("0", "31", "0x1f", "0b11111"))
      {
        Assert.assertEquals("1 " + op + " " + count, expression("Child", "1 " + op + " " + count));
      }
      Assert.assertEquals("1 " + op + " 0o37", expression("Child", "1 " + op + " 037"));
      Assert.assertEquals("self._n " + op + "= self._base & 31", statements("Child", "n " + op + "= base;"));
      Assert.assertEquals("self._n " + op + "= 2", statements("Child", "n " + op + "= 2;"));
      Assert.assertEquals("x = 1\nx " + op + "= distance & 63",
        statements("Child", "long x = 1; x " + op + "= distance;", "distance:int"));
      Assert.assertEquals("print(x " + op + " (distance & 63))",
        statements("Child", "print(x " + op + " distance);", "x:long", "distance:int"));
      Assert.assertEquals("(lambda x, *y: x.setN(*y))(self._next, 1 " + op + " (-1 & 31))",
        expression("Child", "next.setN(1 " + op + " -1)"));
      Assert.assertEquals(lines("_tmp1 = self._next", "_tmp2 = 1 " + op + " (-1 & 31)", "_tmp1.setN(_tmp2)"),
        statements("Child", "next.setN(1 " + op + " -1);"));
    }
    assertRejected("the operator >>> is not supported", "Child", "n = n >>> -1;");
    assertRejected("the operator >>>= is not supported", "Child", "n >>>= -1;");
    Assert.assertNull(expression("Child", "n >>> -1"));
    Assert.assertTrue(newSnippetErrors().get(0).getFormattedMessage().contains("the operator >>> is not supported"));
  }

  @Test
  public void shiftWidthSurvivesIntegralExpressions()
  {
    load("class X { long wide = 8L; int distance = 32; long number() { return 8; } }");
    for (String left : Arrays.asList("wide", "getWide()", "number()", "(long) 8", "wide + 1", "wide / 2", "~wide",
      "true ? wide : 1", "wide << 1", "1 + 1L", "8L / 2", "8 / 2L", "wide % 3", "wide & 7", "-wide"))
    {
      String code = expression("X", "(" + left + ") >> distance");
      Assert.assertNotNull(left, code);
      Assert.assertTrue(code, code.endsWith(" >> (self._distance & 63)"));
    }
    Assert.assertEquals("self._wide >> (self._distance & 31)", expression("X", "((int) wide) >> distance"));
    Assert.assertEquals("1 << 1 >> (self._distance & 31)", expression("X", "(1 << 1L) >> distance"));
    load("class A {} class B {} class X { B other; int pick(A a) { return 8; } long pick(B b) { return 8L; } }");
    Assert.assertEquals("(lambda x, y: x // y if (x < 0) == (y < 0) else -(-x // y))(self.pick(self._other), 2)",
      expression("X", "pick(other) / 2"));
  }

  @Test
  public void overloadShiftWidthsFollowDispatchOrder()
  {
    for (String declarations : Arrays.asList(
      "long pick(A a) { return 8L; } int pick(B b) { return 8; }",
      "int pick(B b) { return 8; } long pick(A a) { return 8L; }"))
    {
      load("class A {} class B {} class X { A a; B b; int distance = 64; " + declarations + " }");
      boolean longFirst = declarations.startsWith("long");
      for (String op : Arrays.asList("<<", ">>"))
      {
        String known = longFirst ? "a" : "b";
        String uncertain = longFirst ? "b" : "a";
        Assert.assertEquals("self.pick(self._" + known + ") " + op + " (self._distance & " + (longFirst ? 63 : 31) + ")",
          expression("X", "pick(" + known + ") " + op + " distance"));
        assertRejected("a shift needs to know", expression("X", "pick(" + uncertain + ") " + op + " distance"));
        Assert.assertEquals("self.pick(None) " + op + " (self._distance & " + (longFirst ? 63 : 31) + ")",
          expression("X", "pick(null) " + op + " distance"));
      }
    }
    load("class X { long pick(double n) { return 8L; } int pick(int n) { return 8; } }");
    Assert.assertEquals("self.pick(1) >> (64 & 63)", expression("X", "pick(1) >> 64"));
  }

  @Test
  public void unknownIntegralWidthsRejectUnsafeShiftsWithoutLosingDivision()
  {
    load("class A {} class B {} class X { B b; int distance = 32; "
      + "int pick(A a) { return -3; } long pick(B b) { return -3L; } "
      + "External unknown() { return null; } }");
    for (String left : Arrays.asList("pick(b)", "pick(b) + 1", "pick(b) / 2", "pick(b) % 2", "~pick(b)",
      "-pick(b)", "true ? pick(b) : 1", "pick(b) << 1", "pick(b) & 7"))
    {
      assertRejected("a shift needs to know", expression("X", "(" + left + ") >> distance"));
      Assert.assertNotNull(left, expression("X", "(" + left + ") >> 31"));
    }
    Assert.assertEquals("(lambda x, y: x // y if (x < 0) == (y < 0) else -(-x // y))(self.pick(self._b), 2)",
      expression("X", "pick(b) / 2"));
    Assert.assertEquals("self.pick(self._b) >> (self._distance & 31)", expression("X", "((int) pick(b)) >> distance"));
    Assert.assertEquals("self.pick(self._b) + 1 >> (self._distance & 63)", expression("X", "(pick(b) + 1L) >> distance"));
    assertRejected("a shift needs to know", expression("X", "unknown() >> distance"));
  }

  @Test
  public void uncertainShiftWidthsAcceptOnlySharedLiteralDistances()
  {
    for (String returns : Arrays.asList("int,long", "long,int"))
    {
      String[] types = returns.split(",");
      load("class A {} class B {} class X { B b; int distance = 64; long result = 0L; "
        + types[0] + " pick(A a) { return 8; } " + types[1] + " pick(B b) { return 8; } }");
      for (String op : Arrays.asList("<<", ">>"))
      {
        for (String count : Arrays.asList("0", "1", "31", "0x1f", "0b11111", "037", "31L"))
        {
          Assert.assertNotNull(expression("X", "pick(b) " + op + " " + count));
          Assert.assertNotNull(statements("X", "result = pick(b) " + op + " " + count + ";"));
        }
        for (String count : Arrays.asList("-1", "-32", "32", "63", "64", "-64", "distance", "1 + 1"))
        {
          Assert.assertNull(expression("X", "pick(b) " + op + " " + count));
          List<ErrorMessage> errors = newSnippetErrors();
          Assert.assertEquals(1, errors.size());
          String message = errors.get(0).getFormattedMessage();
          Assert.assertTrue(message, message.contains("a shift needs to know"));
          Assert.assertTrue(message, message.contains("Give a Python version instead"));
          assertRejected("a shift needs to know", "X", "result = pick(b) " + op + " " + count + ";");
        }
      }
      Assert.assertNotNull(expression("X", "pick(b) / 2"));
    }
  }

  @Test
  public void nonNullArgumentsExcludeIncompatibleReferenceOverloads()
  {
    load("class A {} class X { String text; boolean flag = true; "
      + "double pick(A a) { return 2.0; } int pick(String s) { return -3; } "
      + "double number(A a) { return 2.0; } int number(int n) { return -3; } "
      + "double truth(A a) { return 2.0; } int truth(boolean b) { return -3; } }");
    for (String call : Arrays.asList("pick(\"x\")", "pick('x')", "pick(\"x\" + \"y\")", "pick(text + \"x\")",
      "pick(flag ? \"x\" : \"y\")", "number(1)", "number(1 + 2)", "truth(true)", "truth(1 == 2)"))
    {
      String code = expression("X", call + " / 2");
      Assert.assertNotNull(call, code);
      Assert.assertTrue(code, code.contains("//"));
      Assert.assertNotNull(statements("X", "print(" + call + " / 2);"));
    }
    for (String argument : Arrays.asList("text", "getText()", "flag ? \"x\" : null", "flag ? text : \"y\""))
    {
      assertRejected("division needs to know", expression("X", "pick(" + argument + ") / 2"));
    }
    Assert.assertEquals("self.pick(None) / 2", expression("X", "pick(null) / 2"));
  }

  @Test
  public void runsIncrementsInJavaOrder()
  {
    Assert.assertEquals("1,2\n3\n2\n1\n3\n", runTranslated("int i = 1; System.out.println(pair(i++, i));"
      + " int x = 1; System.out.println(x++ + 2); System.out.println(x); x = 1; x = x++; System.out.println(x);"
      + " x = 2; System.out.println(++x);"));
  }

  @Test
  public void runsCompoundAssignmentOnOneReceiver()
  {
    // Java reads n (2) before change() sets it to 100, then adds 3; the receiver is called once.
    Assert.assertEquals("5 1\n", runTranslated("receiver().n += change(); print(n, calls);"));
  }

  @Test
  public void runsAssignmentToAnObjectFirstEvaluatingTheObject()
  {
    Assert.assertEquals(lines("_tmp1 = self.receiver()", "_tmp1._n = self.change()"), statements("Child", "receiver().n = change();"));
    Assert.assertEquals("['receiver', 'change'] 3\n", runTranslated("receiver().n = change(); print(log, n);"));
    // Nothing can change in between, so nothing is kept.
    Assert.assertEquals("self._next._n = 5", statements("Child", "next.n = 5;"));
  }

  @Test
  public void runsContinueWithTheUpdateOfTheLoopHeader()
  {
    // The body's local n hides the attribute n, which the update still means.
    Assert.assertEquals("2\n", runTranslated("n = 0; for (; n < 2; n++) { int n = 50; continue; } System.out.println(n);"));
  }

  @Test
  public void runsShortCircuitsAndTernaries()
  {
    Assert.assertEquals("2\n2\n3\n2\n1\n", runTranslated("if (flag && n++ > 0) { n = 50; } System.out.println(n);"
      + " if (!flag || n++ > 0) { } System.out.println(n);"
      + " if (!flag && n++ > 0) { } System.out.println(n);"
      + " int a = 7; System.out.println(a > 0 ? (a > 5 ? 2 : 1) : 0); System.out.println(flag ? n++ : 1);"));
  }

  @Test
  public void runsSignedDivisionAndRemainder()
  {
    Assert.assertEquals("-3 -1 -3 1 3 -1 3 1\n-4 -2\n2.5 -0.5\n",
      runTranslated("int a = -7; int b = 2; int c = 7; int d = -2;"
        + " print(a / b, a % b, c / d, c % d, a / d, a % d, c / b, c % b);"
        + " print((a - 1) / b, (a + 1) % (b + b));"
        + " double r = 5; print(r / 2, -r % 1.5);"));
    Assert.assertEquals("-33\n", runTranslated("n = -100; System.out.println(getN() / change());"));
  }

  @Test
  public void runsLoopsWithContinueAndIncrementConditions()
  {
    Assert.assertEquals("2\n6 4\n", runTranslated("n = 0; for (int i = 0; i < 3; i++) { if (i == 1) continue; n += i; } System.out.println(n);"
      + " int i = 0; int t = 0; while (i++ < 3) { t += i; } print(t, i);"));
  }

  @Test
  public void runsElseIfWhoseConditionNeedsStatements()
  {
    Assert.assertEquals("b 3\n", runTranslated("int x = 2; if (x > 5) { print(\"a\"); } else if (x++ > 1) { print(\"b\", x); } else { print(\"c\"); }"));
  }

  @Test
  public void runsConcatenationAndPrinting()
  {
    Assert.assertEquals("a12 3a\nabc\n", runTranslated("System.out.print(\"a\" + 1 + 2); System.out.println(\" \" + (1 + 2) + \"a\");"
      + " System.out.print(\"a\"); System.out.print(\"b\"); System.out.println(\"c\");"));
    // Java spells booleans and null in lower case
    Assert.assertEquals("truenull false\nfalse\n", runTranslated("boolean b = false; System.out.println(\"\" + (1 == 1) + null + \" \" + b);"
      + " System.out.println(b);"));
  }

  //------------------------
  // Rejections
  //------------------------

  @Test
  public void rejectedConstructsNameTheReason()
  {
    String[][] cases = {
      { "foo();", "'foo(...)' is not a method of class Child" },
      { "n = missing;", "'missing' is not a local variable, parameter, attribute, association, state machine or constant of class Child" },
      { "blahblah;", "'blahblah' is not a statement" },
      { "n = twiceN;", "'twiceN' is a derived attribute, which has no field; call getTwiceN() instead" },
      { "Math.sqrt(4);", "Math is a Java library class" },
      { "n = Thread.currentThread();", "Thread is a Java library class" },
      { "Date d = new Date();", "new Date(...) creates a Java library object" },
      { "Object o = null;", "variables of type Object are not supported" },
      { "int k = name.length();", "String methods such as length() are not supported" },
      { "if (name.equals(\"x\")) { }", "String methods such as equals() are not supported" },
      { "int k = getItems().size();", "collection methods such as size() are not supported" },
      { "mode.name();", "methods of enumerations, such as name(), are not supported" },
      { "byte b = (byte) n;", "casts to byte are not supported (they need Java's narrowing)" },
      { "char c = (char) n;", "casts to char are not supported" },
      { "Item i = (Item) anything();", "casts to Item are not supported" },
      { "char c = 'a'; int k = c + 1;", "arithmetic on char values is not supported" },
      { "char c = 'a'; c++;", "arithmetic on char values is not supported" },
      { "int k = 'a';", "converting a char to a number is not supported" },
      { "try { n = 1; } catch (Exception e) { }", "'try' statements are not supported" },
      { "throw new IllegalStateException(\"x\");", "exceptions are not supported, except throw new RuntimeException(message)" },
      { "Runnable r = () -> { };", "lambdas are not supported" },
      { "items.forEach(i -> i.delete());", "'->' is not supported" },
      { "cmp1->pIn1(1);", "'->' is not supported" },
      { "new Item(1, this) { };", "anonymous classes are not supported" },
      { "switch (n) { case 1: break; }", "'switch' statements are not supported" },
      { "do { n++; } while (n < 3);", "'do' statements are not supported" },
      { "int[] a = new int[3];", "arrays are not supported" },
      { "int a[] = null;", "arrays are not supported" },
      { "String t = tags[0];", "arrays are not supported" },
      { "List<String> l = null;", "generic types such as List<...> are not supported" },
      { "int k = n / anything();", "division needs to know whether its operands are integers" },
      { "around_proceed: n = 1;", "around_proceed is not supported" },
      { "outer: while (true) { }", "labelled statements are not supported" },
      { "n = (n = 1) + 2;", "assignments inside expressions are not supported" },
      { "n = base = 0;", "chained assignments such as a = b = c are not supported" },
      { "super.twice(1);", "super is not supported" },
      { "boolean b = next instanceof Child;", "instanceof is not supported" },
      { "int k = n >>> 1;", "the operator >>> is not supported" },
      { "System.err.println(\"x\");", "only System.out.println and System.out.print are" },
      { "System.out.printf(\"%d\", n);", "only System.out.println and System.out.print are" },
      { "System.out.print();", "System.out.print takes one argument" },
      { "$this->addLog(\"x\");", "names starting with $" },
      { "# a Ruby comment", "'#' is not Java syntax" },
      { "print \"text\";", "'print' is not a statement" },
      { "int k = Status;", "'Status' is a type, not a value" },
      { "int k = delete();", "returns nothing" },
      { "break;", "break is outside a loop" },
      { "LIMIT = 3;", "the constant LIMIT cannot be changed" },
      { "flag = flag + 1;", "the operator + cannot be used on a boolean and an integer" },
      { "String s = \"unclosed;", "a string is not closed" },
      { "int k = 1_;", "the number starting at '1_;' is not supported" },
      { "double d = 1_.5;", "the number starting at '1_.5;' is not supported" },
      { "int a$b = 1;", "the name a$b is not supported" },
      { "setN(delete());", "returns nothing" },
      { "setN(Child);", "'Child' is a type, not a value" },
      { "new Item(delete(), this);", "returns nothing" },
      { "if (1) { }", "a condition must be a boolean, but '1' is an integer" },
      { "boolean b = 1 && 2;", "a condition must be a boolean" },
      { "boolean b = !n;", "a condition must be a boolean" },
      { "while (name) { }", "a condition must be a boolean" },
      { "double d = 1.0 << 2;", "the operator << needs integers" },
      { "int a = 1.5;", "'1.5' is a floating-point number, which cannot be stored where an integer is expected" },
      { "boolean b = 1;", "which cannot be stored where a boolean is expected" },
      { "String s = \"\"\"\n text\"\"\";", "text blocks are not supported" },
      { "n = 1", "expected ';' but found the end of the code" },
    };
    for (String[] c : cases)
    {
      String result = statements("Child", c[0]);
      Assert.assertNull(c[0] + " translated to " + result, result);
      List<ErrorMessage> errors = newSnippetErrors();
      Assert.assertEquals(c[0], 1, errors.size());
      String message = errors.get(0).getFormattedMessage();
      Assert.assertTrue(c[0] + ": " + message, message.contains(c[1]));
    }
  }

  @Test
  public void diagnosticsHaveTheLocationAndASlotSpecificSuggestion()
  {
    UmpleClass child = model.getUmpleClass("Child");
    Position position = new Position(FILE, 12, 4, 100);
    Assert.assertNull(gen.translateSnippetAt("foo();", child, null, false, false, position, "the entry action of state On"));
    ErrorMessage error = newSnippetErrors().get(0);
    Assert.assertEquals(12, error.getPosition().getLineNumber());
    Assert.assertEquals("This code in the entry action of state On cannot be translated to Python: 'foo(...)' is not a method of class Child."
      + " Give a Python version instead, for example entry / Python { self.setN(1) }", error.getFormattedMessage().trim());
    String[][] slots = {
      { "the exit action of state On", "exit / Python {" },
      { "the do activity of state On", "do Python {" },
      { "the action of the transition flip", "e -> / Python {" },
      { "the before injection for setN", "before setN Python {" },
      { "the after injection for setN", "after setN Python {" },
      { "the derived attribute total", "Integer total = { a + b } Python {" },
      { "the default value of attribute n", "with Integer initialN() Python {" },
      { "the constant X", "a literal value" },
    };
    for (String[] slot : slots)
    {
      Assert.assertNull(gen.translateSnippetAt("foo();", child, null, false, false, child.getPosition(0), slot[0]));
      String message = newSnippetErrors().get(0).getFormattedMessage();
      Assert.assertTrue(message, message.contains(slot[1]));
    }
  }
}
