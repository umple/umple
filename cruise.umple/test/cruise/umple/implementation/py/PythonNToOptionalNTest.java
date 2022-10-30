package cruise.umple.implementation.py;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonNToOptionalNTest extends NToOptionalNTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }

  @Test @Ignore
  public void OptionalN(){
    super.OptionalN();
  }

  @Test @Ignore
  public void N(){
    super.N();
  }
}