/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.util.SampleFileWriter;

// Generated Python for associations whose ends are both at most one, directed associations and
// immutable ends: every combination compiles, and the constructors and private setters have the
// shape the public API needs. Their behaviour is tested in testbed_python/test/associations.
public class PythonAssociationOneOneTest
{
  private File dir;

  @Before
  public void setUp() throws Exception
  {
    dir = Files.createTempDirectory("umple-python-oneone").toFile();
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(dir.getPath());
  }

  @Test
  public void everyCombinationCompiles() throws Exception
  {
    generate(
      "strictness ignore 36;\n" +
      "class K { name; key { name } }\n" +
      "class F { immutable; }\n" +
      "class C1 { 1 <@>- 0..1 P1 p; } class P1 { }\n" +
      "class C2 { 0..1 <@>- 0..1 P2 p; } class P2 { }\n" +
      "class C3 { 0..1 <@>- 1 P3 p; } class P3 { }\n" +
      "class C4 { 1 <@>- 1 P4 p; } class P4 { Integer n; }\n" +
      "class O1 { 0..1 o1 -- 0..1 K k; key { k } }\n" +
      "class O2 { 0..1 o2 -- 1 K k2; key { k2 } }\n" +
      "class D { 1 -> 1 K k; 0..1 -> 0..1 K2 opt; * -> * K3 many; * -> 1..2 K4 mn; * -> 2 K5 n; * -> 0..2 K6 optN;\n" +
      "  * -> 1..* K7 mStar; key { many } }\n" +
      "class K2 { } class K3 { } class K4 { } class K5 { } class K6 { } class K7 { }\n" +
      "class I { immutable; 1 -> 1 F f; 1 -> 0..1 F2 g; 1 -> 2..3 F3 h; 1 -> 2 F4 i; 1 -> 0..2 F5 j;\n" +
      "  1 -> 2..* F6 l; 1 -> * F7 m; }\n" +
      "class F2 { immutable; } class F3 { immutable; } class F4 { immutable; } class F5 { immutable; }\n" +
      "class F6 { immutable; } class F7 { immutable; }\n" +
      "class M1 { name; 1 -- 1 M2; 1 -> 1 K8 k; * -> 1..2 K9 ks; } class M2 { Integer n; } class K8 { } class K9 { }\n" +
      "class S { 1 -- 1 S2; * -> 1..2 K9 ks; } class S2 { * -> 1..* K8 ks; }\n" +
      "class R1 { 1 self buddy; }\n" +
      "class R2 { 0..1 self pal; }\n" +
      "class R3 { 0..1 parent -- 0..1 R3 child; }\n" +
      "class T { 0..1 t -- 1..* U us; } class U { }\n" +
      "class Ranked { Integer rank; } class Ladder { * -> 1..3 Ranked rungs sorted {rank}; * -> * Ranked steps sorted {rank}; }\n");
    String errors = cruise.umple.implementation.TemplateTest.pythonSyntaxErrors(generatedFiles());
    Assert.assertNull(errors, errors);
  }

  @Test
  public void oneToOneConstructorCreatesThePartnerAndAlternateConstructorAttachesOne() throws Exception
  {
    UmpleModel model = generate("class Base { Integer x; }\nclass Car { isA Base; name; 1 -- 1 Engine; }\nclass Engine { Integer power; }\n" +
      "class Van { isA Car; }\n");
    String car = model.getGeneratedCode().get("Car");
    Assert.assertTrue(car, car.contains("    def __init__(self, aX, aName, aPowerForEngine):\n        self._name = aName\n        self._engine = None\n" +
      "        super().__init__(aX)\n        from Engine import Engine\n        self._engine = Engine.alternateConstructor(aPowerForEngine, self)\n"));
    Assert.assertTrue(car, car.contains("    @classmethod\n    def alternateConstructor(cls, aX, aName, aEngine):\n        self = cls.__new__(cls)\n" +
      "        __class__._alternateInit(self, aX, aName, aEngine)\n        return self\n"));
    Assert.assertTrue(car, car.contains("    def _alternateInit(self, aX, aName, aEngine):\n        self._name = aName\n        self._engine = None\n" +
      "        super().__init__(aX)\n        if aEngine is None or aEngine.getCar() is not None:\n"));
    String engine = model.getGeneratedCode().get("Engine");
    Assert.assertTrue(engine, engine.contains("    def __init__(self, aPower, aXForCar, aNameForCar):\n"));
    Assert.assertTrue(engine, engine.contains("        self._car = Car.alternateConstructor(aXForCar, aNameForCar, self)\n"));
    // a subclass passes an existing partner, so its parent part is initialized as alternateConstructor does
    String van = model.getGeneratedCode().get("Van");
    Assert.assertTrue(van, van.contains("    def __init__(self, aX, aName, aEngine):\n        super()._alternateInit(aX, aName, aEngine)\n"));
  }

  @Test
  public void userMethodsDoNotHideTheOneToOneConstructors() throws Exception
  {
    // the helper gets a free name; a user alternateConstructor would replace the generated one
    UmpleModel model = generate("class A { 1 -- 1 B; void _alternateInit(B aB) Python { pass } }\nclass B { }\n");
    String a = model.getGeneratedCode().get("A");
    Assert.assertTrue(a, a.contains("        __class__._alternateInit2(self, aB)\n"));
    Assert.assertTrue(a, a.contains("    def _alternateInit2(self, aB):\n"));
    assertRejectedAs9215("class C { 1 -- 1 D; String alternateConstructor() Python { return \"c\" } }\nclass D { }\n", "C");
    assertRejectedAs9215("class Outer { static class E { 1 self buddy; String alternateConstructor() Python { return \"e\" } } }\n", "Outer");
  }

  private void assertRejectedAs9215(String code, String className) throws Exception
  {
    File file = new File(dir, "rejected.ump");
    Files.write(file.toPath(), ("generate Python;\n" + code).getBytes("UTF-8"));
    UmpleModel rejected = new UmpleModel(new UmpleFile(file));
    rejected.setShouldGenerate(true);
    try
    {
      rejected.run();
    }
    catch (UmpleCompilerException e)
    {
      // the error is checked below
    }
    List<Integer> codes = new ArrayList<Integer>();
    for (cruise.umple.parser.ErrorMessage message : rejected.getLastResult().getErrorMessages())
    {
      codes.add(message.getErrorType().getErrorCode());
    }
    Assert.assertTrue(codes.toString(), codes.contains(9215));
    Assert.assertNull(rejected.getGeneratedCode().get(className));
  }

  @Test
  public void immutableEndsHavePrivateSetters() throws Exception
  {
    UmpleModel model = generate("class Frozen { immutable; 1 -> 0..1 Part part; 1 -> 1..3 Piece pieces; }\n" +
      "class Part { immutable; }\nclass Piece { immutable; }\n");
    String frozen = model.getGeneratedCode().get("Frozen");
    Assert.assertTrue(frozen, frozen.contains("    def _setPart(self, aNewPart):\n        if not self._canSetPart:\n            return False\n        self._canSetPart = False\n"));
    Assert.assertTrue(frozen, frozen.contains("        if not self._setPieces(*allPieces):\n"));
    Assert.assertFalse(frozen, frozen.contains("def set"));
    Assert.assertFalse(frozen, frozen.contains("def add"));
    Assert.assertFalse(frozen, frozen.contains("def remove"));
  }

  private UmpleModel generate(String code) throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), ("generate Python;\n" + code).getBytes("UTF-8"));
    UmpleModel model = new UmpleModel(new UmpleFile(file));
    model.setShouldGenerate(true);
    try
    {
      model.run();
    }
    catch (UmpleCompilerException e)
    {
      // warnings also end the run with an exception; errors are checked below
    }
    for (cruise.umple.parser.ErrorMessage message : model.getLastResult().getErrorMessages())
    {
      Assert.assertTrue(message.toString(), message.getErrorType().getSeverity() > 2);
    }
    return model;
  }

  private List<File> generatedFiles() throws Exception
  {
    List<File> files = new ArrayList<File>();
    Files.walk(dir.toPath()).filter(p -> p.toString().endsWith(".py")).forEach(p -> files.add(p.toFile()));
    return files;
  }
}
