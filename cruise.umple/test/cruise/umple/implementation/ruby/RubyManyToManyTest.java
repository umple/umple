package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.ManyToManyTest;

public class RubyManyToManyTest extends ManyToManyTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
}
