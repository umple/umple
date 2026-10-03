/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.implementation.py.usercode;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

// Whole generated modules for user methods, contracts, injections, overloads, abstract methods, main
// and extra code.
public class PythonUserCodeTemplateTest extends TemplateTest
{
  private static final String[] GENERATED = { "NativeMethods", "MethodWrappers", "Part", "OverloadedMethods", "Measured",
    "Shape", "Square", "MainAndExtraCode" };

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }

  @After
  public void tearDown()
  {
    super.tearDown();
    for (String name : GENERATED)
    {
      SampleFileWriter.destroy(pathToInput + "/py/usercode/" + name + ".py");
    }
  }

  // Source markers are compared too.
  @Test
  public void nativeMethodBodies()
  {
    assertUmpleTemplateFor("py/usercode/NativeMethods.ump", "py/usercode/NativeMethods.py.txt", "NativeMethods", true, false);
  }

  @Test
  public void contractsAndInjectionsWrapMethods()
  {
    assertUmpleTemplateFor("py/usercode/MethodWrappers.ump", "py/usercode/MethodWrappers.py.txt", "MethodWrappers");
  }

  @Test
  public void overloadedMethodsAreDispatched()
  {
    assertUmpleTemplateFor("py/usercode/OverloadedMethods.ump", "py/usercode/OverloadedMethods.py.txt", "OverloadedMethods");
  }

  @Test
  public void abstractMethodsAndInterfaceStubs()
  {
    assertUmpleTemplateFor("py/usercode/AbstractMethods.ump", "py/usercode/Shape.py.txt", "Shape");
    assertUmpleTemplateFor("py/usercode/AbstractMethods.ump", "py/usercode/Square.py.txt", "Square");
  }

  // Source markers are compared too.
  @Test
  public void mainAndExtraCode()
  {
    assertUmpleTemplateFor("py/usercode/MainAndExtraCode.ump", "py/usercode/MainAndExtraCode.py.txt", "MainAndExtraCode", true, false);
  }
}
