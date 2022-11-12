package cruise.umple.implementation.py;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonManyToMStarTest extends ManyToMStarTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
}
