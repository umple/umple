package cruise.umple.implementation.pynext;

import org.junit.*;

import cruise.umple.implementation.ManyToManyTest;

public class PythonNextManyToManyTest extends ManyToManyTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
}
