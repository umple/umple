package cruise.umple.implementation.py;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonManyToMNTest extends ManyToMNTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
  
  @Test @Ignore
  public void MN(){
    super.MN();
  }

  @Test @Ignore
  public void Many(){
    super.Many();
  }
}
