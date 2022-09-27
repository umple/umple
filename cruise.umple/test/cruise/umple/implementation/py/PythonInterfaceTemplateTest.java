package cruise.umple.implementation.py;

import org.junit.*;

import cruise.umple.implementation.InterfaceTemplateTest;

public class PythonInterfaceTemplateTest extends InterfaceTemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
}
