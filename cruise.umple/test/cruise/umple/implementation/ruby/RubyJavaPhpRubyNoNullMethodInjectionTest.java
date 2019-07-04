package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.JavaPhpRubyNoNullMethodInjectionTest;

public class RubyJavaPhpRubyNoNullMethodInjectionTest extends JavaPhpRubyNoNullMethodInjectionTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
}
