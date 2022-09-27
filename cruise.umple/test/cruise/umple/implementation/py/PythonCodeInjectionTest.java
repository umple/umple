package cruise.umple.implementation.py;

import org.junit.*;

import cruise.umple.implementation.CodeInjectionTest;;

public class PythonCodeInjectionTest extends CodeInjectionTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
}
