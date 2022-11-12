package cruise.umple.implementation.py;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonOneToManyTest extends OneToManyTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
}