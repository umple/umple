/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.implementation.pynext.usercode;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

// Whole generated modules for user methods, contracts, injections, overloads, abstract methods, main
// and extra code.
public class PythonNextUserCodeTemplateTest extends TemplateTest
{
  private static final String[] GENERATED = { "NativeMethods", "MethodWrappers", "Part", "OverloadedMethods", "Measured",
    "Shape", "Square", "MainAndExtraCode" };

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }

  @After
  public void tearDown()
  {
    super.tearDown();
    for (String name : GENERATED)
    {
      SampleFileWriter.destroy(pathToInput + "/pynext/usercode/" + name + ".py");
    }
  }

  // Source markers are compared too.
  @Test
  public void nativeMethodBodies()
  {
    assertUmpleTemplateFor("pynext/usercode/NativeMethods.ump", "pynext/usercode/NativeMethods.pynext.txt", "NativeMethods", true, false);
  }

  @Test
  public void contractsAndInjectionsWrapMethods()
  {
    assertUmpleTemplateFor("pynext/usercode/MethodWrappers.ump", "pynext/usercode/MethodWrappers.pynext.txt", "MethodWrappers");
  }

  @Test
  public void overloadedMethodsAreDispatched()
  {
    assertUmpleTemplateFor("pynext/usercode/OverloadedMethods.ump", "pynext/usercode/OverloadedMethods.pynext.txt", "OverloadedMethods");
  }

  @Test
  public void abstractMethodsAndInterfaceStubs()
  {
    assertUmpleTemplateFor("pynext/usercode/AbstractMethods.ump", "pynext/usercode/Shape.pynext.txt", "Shape");
    assertUmpleTemplateFor("pynext/usercode/AbstractMethods.ump", "pynext/usercode/Square.pynext.txt", "Square");
  }

  // Source markers are compared too.
  @Test
  public void mainAndExtraCode()
  {
    assertUmpleTemplateFor("pynext/usercode/MainAndExtraCode.ump", "pynext/usercode/MainAndExtraCode.pynext.txt", "MainAndExtraCode", true, false);
  }
}
