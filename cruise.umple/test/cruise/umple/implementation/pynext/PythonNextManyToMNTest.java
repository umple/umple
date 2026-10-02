package cruise.umple.implementation.pynext;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonNextManyToMNTest extends ManyToMNTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
}
