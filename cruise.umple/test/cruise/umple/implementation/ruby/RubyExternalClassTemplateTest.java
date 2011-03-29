package cruise.umple.implementation.ruby;

import java.io.File;

import org.junit.*;

import cruise.umple.implementation.ExternalClassTemplateTest;

public class RubyExternalClassTemplateTest extends ExternalClassTemplateTest
{
  
  @Test
  public void DoNotCreateExternalClasses()
  {
    assertUmpleTemplateFor("ExternalClassTest.ump",languagePath + "/ExternalClassTest_MyClass."+ languagePath +".txt","MyException");
    Assert.assertEquals(false, (new File(pathToInput + "/Exception.rb")).exists());
  }
    
}