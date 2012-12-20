package cruise.umple.implementation.ruby;

import org.junit.*;
import cruise.umple.implementation.*;

public class RubyOneToMandatoryManyTest extends OneToMandatoryManyTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
}