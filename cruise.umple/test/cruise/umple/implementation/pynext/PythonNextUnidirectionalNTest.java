package cruise.umple.implementation.pynext;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonNextUnidirectionalNTest extends UnidirectionalNTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
}