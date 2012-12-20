package cruise.umple.implementation.ruby;

import org.junit.*;
import cruise.umple.implementation.*;

public class RubyManyToMStarTest extends ManyToMStarTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
  
}
