package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.InterfaceTemplateTest;

public class RubyInterfaceTemplateTest extends InterfaceTemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
}
