package cruise.umple.implementation.py;

import org.junit.*;

import cruise.umple.implementation.SingletonToOneTest;

public class PythonSingletonToOneTest extends SingletonToOneTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
}
