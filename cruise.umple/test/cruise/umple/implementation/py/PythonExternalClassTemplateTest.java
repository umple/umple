package cruise.umple.implementation.py;

import java.io.File;

import org.junit.*;

import cruise.umple.implementation.ExternalClassTemplateTest;

public class PythonExternalClassTemplateTest extends ExternalClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
  
  @Test
  public void DoNotCreateExternalClasses()
  {
    assertUmpleTemplateFor("ExternalClassTest.ump",languagePath + "/ExternalClassTest_MyClass."+ languagePath +".txt","MyException");
    Assert.assertEquals(false, (new File(pathToInput + "/Exception.py")).exists());
  }
    
}