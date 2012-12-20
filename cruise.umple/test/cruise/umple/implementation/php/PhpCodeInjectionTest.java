package cruise.umple.implementation.php;

import org.junit.*;

import cruise.umple.implementation.CodeInjectionTest;;

public class PhpCodeInjectionTest extends CodeInjectionTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
}
