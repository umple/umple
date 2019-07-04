package cruise.umple.implementation.php;

import org.junit.*;

import cruise.umple.implementation.JavaPhpRubyNoNullMethodInjectionTest;

public class PhpJavaPhpRubyNoNullMethodInjectionTest extends JavaPhpRubyNoNullMethodInjectionTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
}
