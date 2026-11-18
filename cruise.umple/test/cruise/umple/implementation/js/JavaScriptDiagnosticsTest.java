/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.implementation.js;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import cruise.umple.compiler.JavaScriptGenerator;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.implementation.TemplateTest;
import cruise.umple.parser.ErrorMessage;
import cruise.umple.util.SampleFileWriter;

// What the JavaScript generator refuses, and what the code it does write does when Node runs it.
// Each model is generated into a directory of its own, so no test reads a file another one wrote.
public class JavaScriptDiagnosticsTest
{
  private File dir;

  @Before
  public void setUp() throws Exception
  {
    dir = Files.createTempDirectory("umple-javascript").toFile();
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(dir.getPath());
  }

  //------------------------
  // Names (E9221)
  //------------------------

  @Test
  public void aClassNamedWithAReservedWordIsRejected()
  {
    for (String name : new String[] {"function", "class", "delete", "static", "new", "var", "let", "this",
      "null", "true", "typeof", "arguments", "eval", "enum", "interface", "package", "public", "await"})
    {
      UmpleModel model = generate("class " + name + " { name; }\n");
      Assert.assertEquals("Class " + name + " has a name that JavaScript reserves or that generated code uses,"
        + " so give it another name", formatted(model, 9221));
      assertNotWritten(name);
      Assert.assertFalse(model.getLastResult().getWasSuccess());
    }
  }

  // A class named like one of Node's own module variables loads, but require would return an empty
  // object instead of the class, so it is rejected as well
  @Test
  public void aClassNamedLikeACommonJsBindingIsRejected()
  {
    for (String name : new String[] {"module", "exports", "require"})
    {
      UmpleModel model = generate("class " + name + " { name; }\n");
      Assert.assertEquals("Class " + name + " has a name that JavaScript reserves or that generated code uses,"
        + " so give it another name", formatted(model, 9221));
      assertNotWritten(name);
    }
  }

  @Test
  public void aSubclassOfAReservedNameIsRejectedToo()
  {
    UmpleModel model = generate("class function { name; }\nclass Worker { isA function; }\n");
    Assert.assertEquals("The superclass function cannot be generated in JavaScript yet, so class Worker was"
      + " not generated", formatted(model, 9220));
    assertNotWritten("Worker");
    assertNotWritten("function");
  }

  @Test
  public void aMethodParameterNamedWithAReservedWordIsRejected()
  {
    UmpleModel model = generate("class X {\n  void f(String class) JavaScript { return; }\n}\n");
    Assert.assertEquals("The parameter class of method f has a name that JavaScript reserves or that generated"
      + " code uses, so give it another name", formatted(model, 9221));
    assertNotWritten("X");
  }

  @Test
  public void twoParametersOfOneNameAreRejected()
  {
    UmpleModel model = generate("class X {\n  void f(String a, Integer a) JavaScript { return; }\n}\n");
    Assert.assertEquals("The second parameter named a of method f has a name that JavaScript reserves or that"
      + " generated code uses, so give it another name", formatted(model, 9221));
    assertNotWritten("X");
  }

  // A reserved name repeated in one parameter list has both problems, each named once
  @Test
  public void aReservedNameRepeatedInOneParameterListNamesBothProblems()
  {
    UmpleModel model = generate("class X {\n  void f(String class, Integer class) JavaScript { return; }\n}\n");
    Assert.assertEquals(Arrays.asList(
      "9221: The parameter class of method f has a name that JavaScript reserves or that generated code uses,"
        + " so give it another name",
      "9221: The second parameter named class of method f has a name that JavaScript reserves or that generated"
        + " code uses, so give it another name"),
      codes(model));
    assertNotWritten("X");
  }

  // Names JavaScript allows as property names are not a conflict: every attribute and association is
  // reached through this._name and through methods, never through a binding
  @Test
  public void reservedWordsAreAllowedForAttributesAndRoles() throws Exception
  {
    UmpleModel model = generate("class Keywords {\n  class;\n  Integer var;\n  Boolean static;\n"
      + "  0..1 -- * Keywords functions;\n}\n");
    Assert.assertEquals(new ArrayList<String>(), codes(model));
    assertParses("Keywords");
    Assert.assertEquals("ok", run("const K = require('./Keywords.js');\n"
      + "const a = new K('c', 1, true), b = new K('c', 2, false);\n"
      + "assert.strictEqual(a.getClass(), 'c');\n"
      + "assert.strictEqual(a.isStatic(), true);\n"
      + "assert.strictEqual(a.addFunction(b), true);\n"
      + "assert.strictEqual(a.numberOfFunctions(), 1);\n"
      + "assert.strictEqual(b.getKeywords(), a);\n"
      + "assert.strictEqual(a.removeFunction(b), true);\n"
      + "assert.strictEqual(b.getKeywords(), null);\n"
      + "console.log('ok');\n"));
  }

  //------------------------
  // Overloading (E9220)
  //------------------------

  @Test
  public void twoMethodsOfOneNameAreRejected()
  {
    UmpleModel model = generate("class X {\n  void f() JavaScript { return; }\n"
      + "  void f(String a) JavaScript { return; }\n}\n");
    Assert.assertEquals("Overloads of method f cannot be generated in JavaScript yet, so class X was not generated",
      formatted(model, 9220));
    assertNotWritten("X");
  }

  // The singular of this role name is the role name, so Java's getSeries(index) and getSeries()
  // would be one name in JavaScript and the method taking an index would be lost
  @Test
  public void twoGeneratedMethodsOfOneNameAreRejected()
  {
    UmpleModel model = generate("class Machine {\n  0..1 -- * Machine series;\n}\n");
    Assert.assertEquals("A second method named getSeries cannot be generated in JavaScript yet, so class"
      + " Machine was not generated", formatted(model, 9220));
    assertNotWritten("Machine");
  }

  // An attribute and a many end whose singular is the attribute's name reach one name as well
  @Test
  public void anAttributeAndAManyEndThatReachOneNameAreRejected()
  {
    UmpleModel model = generate("class Shelf {\n  Integer item;\n  0..1 -- * Item items;\n}\nclass Item {}\n");
    Assert.assertEquals("A second method named getItem cannot be generated in JavaScript yet, so class Shelf"
      + " was not generated", formatted(model, 9220));
    assertNotWritten("Shelf");
  }

  // A method written in the model that repeats a generated name would replace it, so the generated
  // behaviour would be lost without saying so
  @Test
  public void aMethodThatRepeatsAGeneratedNameIsRejected()
  {
    UmpleModel model = generate("class Folder {\n  0..1 -- * Folder kids;\n  void delete() JavaScript { return; }\n}\n");
    Assert.assertEquals("A second method named delete cannot be generated in JavaScript yet, so class Folder"
      + " was not generated", formatted(model, 9220));
    assertNotWritten("Folder");
  }

  // Every reason a class is not generated must reach its subclasses: their modules require it
  @Test
  public void aSubclassOfAClassThatIsNotGeneratedIsRejected()
  {
    UmpleModel model = generate("class Base {\n  0..1 -- * Base series;\n}\nclass Derived {\n  isA Base;\n  name;\n}\n"
      + "class Apart { name; }\n");
    Assert.assertEquals(Arrays.asList(
      "9220: A second method named getSeries cannot be generated in JavaScript yet, so class Base was not generated",
      "9220: The superclass Base cannot be generated in JavaScript yet, so class Derived was not generated"),
      codes(model));
    assertNotWritten("Base");
    assertNotWritten("Derived");
    // the classes that do not depend on it are still generated, and the run still fails
    assertParses("Apart");
    Assert.assertFalse(model.getLastResult().getWasSuccess());
  }

  @Test
  public void aConstructorWrittenInTheModelIsRejected()
  {
    UmpleModel model = generate("class X {\n  name;\n  X(String aName) JavaScript { this._name = aName; }\n}\n");
    Assert.assertEquals("The constructor X written in the model cannot be generated in JavaScript yet, so class X"
      + " was not generated", formatted(model, 9220));
    assertNotWritten("X");
  }

  @Test
  public void aQueuedMethodIsRejected()
  {
    UmpleModel model = generate("class X {\n  queued void f() JavaScript { return; }\n}\n");
    Assert.assertEquals("The queued method f cannot be generated in JavaScript yet, so class X was not generated",
      formatted(model, 9220));
    assertNotWritten("X");
  }

  //------------------------
  // External superclass (E9220)
  //------------------------

  @Test
  public void extendingAnExternalClassIsRejected()
  {
    UmpleModel model = generate("external Thread { void start() { } }\nclass Worker { isA Thread; name; }\n");
    Assert.assertEquals("The external superclass Thread cannot be generated in JavaScript yet, so class Worker"
      + " was not generated", formatted(model, 9220));
    assertNotWritten("Worker");
    // The superclass Worker.js would have required is not in the output either
    assertNotWritten("Thread");
  }

  @Test
  public void aSubclassOfAnExternalSubclassIsRejectedToo()
  {
    UmpleModel model = generate("external Thread { void start() { } }\nclass Worker { isA Thread; name; }\n"
      + "class Builder { isA Worker; }\n");
    Assert.assertEquals(Arrays.asList(
      "9220: The external superclass Thread cannot be generated in JavaScript yet, so class Worker was not generated",
      "9220: The superclass Worker cannot be generated in JavaScript yet, so class Builder was not generated"),
      codes(model));
    assertNotWritten("Worker");
    assertNotWritten("Builder");
  }

  //------------------------
  // Abstract classes
  //------------------------

  @Test
  public void anAbstractClassCannotBeInstantiatedButASubclassCan() throws Exception
  {
    UmpleModel model = generate("class Shape {\n  abstract;\n  name;\n}\nclass Circle {\n  isA Shape;\n  Double radius;\n}\n");
    Assert.assertEquals(new ArrayList<String>(), codes(model));
    assertParses("Shape", "Circle");
    Assert.assertEquals("ok", run("const Shape = require('./Shape.js'), Circle = require('./Circle.js');\n"
      + "assert.throws(() => new Shape('s'), TypeError);\n"
      + "const c = new Circle('c', 2.0);\n"
      + "assert.ok(c instanceof Shape);\n"
      + "assert.strictEqual(c.getName(), 'c');\n"
      + "console.log('ok');\n"));
  }

  @Test
  public void anAbstractMethodIsDeclaredWithABodyThatReportsTheCall() throws Exception
  {
    UmpleModel model = generate("class Shape {\n  abstract Double area();\n}\n"
      + "class Square {\n  isA Shape;\n  Double side;\n  Double area() JavaScript { return this.getSide() * this.getSide(); }\n}\n");
    Assert.assertEquals(new ArrayList<String>(), codes(model));
    assertParses("Shape", "Square");
    Assert.assertEquals("ok", run("const Shape = require('./Shape.js'), Square = require('./Square.js');\n"
      + "assert.throws(() => new Shape(), TypeError);\n"
      + "assert.strictEqual(new Square(4.0).area(), 16);\n"
      + "assert.throws(() => Shape.prototype.area.call(Object.create(Shape.prototype)), TypeError);\n"
      + "console.log('ok');\n"));
  }

  //------------------------
  // Methods written in the model
  //------------------------

  @Test
  public void aMethodWithNoJavaScriptBodyIsLeftOutWithAWarning() throws Exception
  {
    UmpleModel model = generate("class X {\n  name;\n  String f() Java { return \"java\"; }\n}\n");
    Assert.assertEquals("Method f has code only for Java, so it is left out of the generated JavaScript",
      formatted(model, 9222));
    // A warning does not stop the class, and the command line still succeeds
    Assert.assertTrue(model.getLastResult().getWasSuccess());
    Assert.assertEquals("ok", run("const X = require('./X.js');\n"
      + "assert.strictEqual(typeof new X('n').f, 'undefined');\n"
      + "console.log('ok');\n"));
  }

  // JavaScript has no access modifiers, and a synchronous body cannot be interleaved, so there is
  // nothing for synchronized to hold: all three generate a plain method, as the manual states
  @Test
  public void modifiersJavaScriptCannotExpressStillGenerateTheMethod() throws Exception
  {
    UmpleModel model = generate("class Counter {\n  Integer n = 0;\n"
      + "  synchronized void bump() JavaScript { this.setN(this.getN() + 1); }\n"
      + "  private String secret() JavaScript { return \"s\"; }\n"
      + "  protected String half() JavaScript { return \"h\"; }\n}\n");
    Assert.assertEquals(new ArrayList<String>(), codes(model));
    Assert.assertEquals("ok", run("const Counter = require('./Counter.js');\n"
      + "const c = new Counter();\n"
      + "c.bump();\n"
      + "assert.strictEqual(c.getN(), 1);\n"
      + "assert.strictEqual(c.secret(), 's');\n"
      + "assert.strictEqual(c.half(), 'h');\n"
      + "console.log('ok');\n"));
  }

  // An untagged body is the one every generator falls back to, so it is emitted as it was written
  @Test
  public void anUntaggedBodyIsEmitted() throws Exception
  {
    UmpleModel model = generate("class X {\n  name;\n  String f() { return this.getName(); }\n}\n");
    Assert.assertEquals(new ArrayList<String>(), codes(model));
    Assert.assertEquals("ok", run("const X = require('./X.js');\n"
      + "assert.strictEqual(new X('n').f(), 'n');\n"
      + "console.log('ok');\n"));
  }

  // A method that names another generated class gets a require of it, placed after module.exports so
  // that two classes using each other both load
  @Test
  public void aMethodThatUsesAnotherClassGetsItsModule() throws Exception
  {
    UmpleModel model = generate("class Order {\n  0..1 -- * Line;\n"
      + "  Boolean add(String aLabel) JavaScript { return this.addLine(new Line(aLabel)); }\n}\n"
      + "class Line {\n  label;\n"
      + "  String summary() JavaScript { return this.getOrder() === null ? 'loose' : Order.name; }\n}\n");
    Assert.assertEquals(new ArrayList<String>(), codes(model));
    Assert.assertEquals("ok", run("const Order = require('./Order.js'), Line = require('./Line.js');\n"
      + "const o = new Order();\n"
      + "assert.strictEqual(o.add('first'), true);\n"
      + "assert.strictEqual(o.numberOfLines(), 1);\n"
      + "assert.strictEqual(o.getLine(0).summary(), 'Order');\n"
      + "assert.strictEqual(new Line('l').summary(), 'loose');\n"
      + "console.log('ok');\n"));
  }

  //------------------------
  // Optional associations start empty
  //------------------------

  @Test
  public void anUnsetOptionalAssociationReadsAsNull() throws Exception
  {
    UmpleModel model = generate("class A {\n  0..1 -- 0..1 B;\n  0..1 -> 0..1 C;\n}\nclass B {\n  0..1 -- * D;\n}\n"
      + "class C {}\nclass D {}\n");
    Assert.assertEquals(new ArrayList<String>(), codes(model));
    Assert.assertEquals("ok", run("const A = require('./A.js'), B = require('./B.js'), C = require('./C.js'), D = require('./D.js');\n"
      + "const a = new A(), b = new B(), c = new C(), d = new D();\n"
      + "assert.strictEqual(a.getB(), null, 'one to one end starts null');\n"
      + "assert.strictEqual(a.getC(), null, 'directed end starts null');\n"
      + "assert.strictEqual(d.getB(), null, 'the one end of a one to many starts null');\n"
      + "assert.strictEqual(a.hasB(), false);\n"
      + "assert.deepStrictEqual(b.getDs(), []);\n"
      + "assert.strictEqual(a.setB(b), true);\n"
      + "assert.strictEqual(b.getA(), a);\n"
      + "assert.strictEqual(a.setB(null), true);\n"
      + "assert.strictEqual(a.getB(), null, 'null after being unset, as before being set');\n"
      + "assert.strictEqual(b.getA(), null);\n"
      + "console.log('ok');\n"));
  }

  //------------------------
  // Unexpected failures
  //------------------------

  // isUsableName is the rule the generator applies to every name it binds
  @Test
  public void usableNamesAreIdentifiersThatAreNotReserved()
  {
    Assert.assertTrue(JavaScriptGenerator.isUsableName("Person"));
    Assert.assertTrue(JavaScriptGenerator.isUsableName("_x$1"));
    Assert.assertFalse(JavaScriptGenerator.isUsableName("class"));
    Assert.assertFalse(JavaScriptGenerator.isUsableName("module"));
    Assert.assertFalse(JavaScriptGenerator.isUsableName("1x"));
    Assert.assertFalse(JavaScriptGenerator.isUsableName("a-b"));
    Assert.assertFalse(JavaScriptGenerator.isUsableName(""));
    Assert.assertFalse(JavaScriptGenerator.isUsableName(null));
  }

  //------------------------
  // Helpers
  //------------------------

  private UmpleModel generate(String code)
  {
    try
    {
      File file = new File(dir, "model.ump");
      Files.write(file.toPath(), ("generate JavaScript;\n" + code).getBytes("UTF-8"));
      UmpleModel model = new UmpleModel(new UmpleFile(file));
      model.setShouldGenerate(true);
      try
      {
        model.run();
      }
      catch (UmpleCompilerException e)
      {
        // the diagnostics are in the model's last result, which the tests read
      }
      return model;
    }
    catch (java.io.IOException e)
    {
      throw new AssertionError("Unable to generate the model", e);
    }
  }

  // The formatted text of the one message with this code, so a test fails on its wording too
  private String formatted(UmpleModel model, int code)
  {
    List<String> found = new ArrayList<String>();
    for (ErrorMessage m : model.getLastResult().getErrorMessages())
    {
      if (m.getErrorType().getErrorCode() == code)
      {
        found.add(m.getFormattedMessage());
      }
    }
    Assert.assertEquals("one message " + code + ", of " + codes(model), 1, found.size());
    return found.get(0);
  }

  private List<String> codes(UmpleModel model)
  {
    List<String> found = new ArrayList<String>();
    for (ErrorMessage m : model.getLastResult().getErrorMessages())
    {
      found.add(m.getErrorType().getErrorCode() + ": " + m.getFormattedMessage());
    }
    return found;
  }

  private void assertNotWritten(String className)
  {
    Assert.assertFalse("No file may be written for " + className, new File(dir, className + ".js").exists());
  }

  private void assertParses(String... classNames)
  {
    List<File> files = new ArrayList<File>();
    for (String className : classNames)
    {
      File file = new File(dir, className + ".js");
      Assert.assertTrue(file.getPath() + " was not written", file.exists());
      files.add(file);
    }
    Assert.assertNull(TemplateTest.javaScriptSyntaxErrors(files));
  }

  // Runs a script beside the generated modules and returns what it printed, so a test states what
  // the generated code does rather than what it looks like
  private String run(String script) throws Exception
  {
    TemplateTest.assumeNode();
    File file = new File(dir, "check.js");
    Files.write(file.toPath(), ("const assert = require('node:assert');\n" + script).getBytes("UTF-8"));
    StringBuilder output = new StringBuilder();
    int status = TemplateTest.runNode(Arrays.asList(TemplateTest.nodeRuntime(), file.getName()), dir, output);
    Assert.assertEquals("node " + file.getName() + " failed:\n" + output, 0, status);
    return output.toString().trim();
  }
}
