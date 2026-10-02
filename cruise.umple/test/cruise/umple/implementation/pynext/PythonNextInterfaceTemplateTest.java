package cruise.umple.implementation.pynext;

import org.junit.*;

import cruise.umple.implementation.InterfaceTemplateTest;

public class PythonNextInterfaceTemplateTest extends InterfaceTemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
}
