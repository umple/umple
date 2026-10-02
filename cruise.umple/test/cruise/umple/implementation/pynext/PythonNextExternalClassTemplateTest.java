package cruise.umple.implementation.pynext;

import java.io.File;

import org.junit.*;

import cruise.umple.implementation.ExternalClassTemplateTest;

public class PythonNextExternalClassTemplateTest extends ExternalClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
  
  @Test
  public void DoNotCreateExternalClasses()
  {
    assertUmpleTemplateFor("ExternalClassTest.ump",languagePath + "/ExternalClassTest_MyClass."+ languagePath +".txt","MyException");
    Assert.assertEquals(false, (new File(pathToInput + "/Exception.py")).exists());
  }
    
}