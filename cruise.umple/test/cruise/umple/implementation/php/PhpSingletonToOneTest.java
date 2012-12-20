package cruise.umple.implementation.php;

import org.junit.*;

import cruise.umple.implementation.SingletonToOneTest;

public class PhpSingletonToOneTest extends SingletonToOneTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
}
