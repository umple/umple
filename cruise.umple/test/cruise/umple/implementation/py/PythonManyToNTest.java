package cruise.umple.implementation.py;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonManyToNTest extends ManyToNTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }

  @Test @Ignore
  public void N(){
    super.N();
  }

  @Test @Ignore
  public void Many(){
    super.Many();
  }
  
}