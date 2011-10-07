package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.SingletonToOneTest;

public class RubySingletonToOneTest extends SingletonToOneTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
}
