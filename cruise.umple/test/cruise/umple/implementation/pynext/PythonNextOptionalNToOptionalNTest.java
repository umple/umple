package cruise.umple.implementation.pynext;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonNextOptionalNToOptionalNTest extends OptionalNToOptionalNTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
}