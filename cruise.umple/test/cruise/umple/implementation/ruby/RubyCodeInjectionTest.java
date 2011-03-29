package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.CodeInjectionTest;;

public class RubyCodeInjectionTest extends CodeInjectionTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
}
