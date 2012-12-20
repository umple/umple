package cruise.umple.implementation.php;

import org.junit.*;

import cruise.umple.implementation.ManyToManyTest;

public class PhpManyToManyTest extends ManyToManyTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
}
