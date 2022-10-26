package cruise.umple.implementation.py;

import org.junit.*;
import cruise.umple.implementation.*;

public class PythonReflexiveAssociationTest extends ReflexiveAssociationTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }

  @Test @Ignore
  public void OneToMany(){
    super.OneToMany();
  }

  @Test @Ignore
  public void OptionalOneAsymmetric(){
    super.OptionalOneAsymmetric();
  }

  @Test @Ignore
  public void OneSymmetric(){
    super.OneSymmetric();
  }

  @Test @Ignore
  public void OneSymmetricNoParam(){
    super.OneSymmetricNoParam();
  }

  @Test @Ignore
  public void OptionalOneSymmetric(){
    super.OptionalOneSymmetric();
  }
}