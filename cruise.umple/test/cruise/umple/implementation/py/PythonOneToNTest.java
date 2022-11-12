package cruise.umple.implementation.py;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonOneToNTest extends OneToNTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
}