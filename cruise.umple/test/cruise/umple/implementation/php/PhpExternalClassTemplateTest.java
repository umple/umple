package cruise.umple.implementation.php;

import java.io.File;

import org.junit.*;

import cruise.umple.implementation.ExternalClassTemplateTest;

public class PhpExternalClassTemplateTest extends ExternalClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
  
  @Test
  public void DoNotCreateExternalClasses()
  {
    assertUmpleTemplateFor("ExternalClassTest.ump",languagePath + "/ExternalClassTest_MyClass."+ languagePath +".txt","MyException");
    Assert.assertEquals(false, (new File(pathToInput + "/Exception.php")).exists());
  }
    
}