package cruise.umple.implementation.pynext;

import org.junit.*;

import cruise.umple.implementation.SingletonToOneTest;

public class PythonNextSingletonToOneTest extends SingletonToOneTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
}
