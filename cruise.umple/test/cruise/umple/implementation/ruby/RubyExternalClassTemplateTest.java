package cruise.umple.implementation.ruby;

import java.io.File;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
import cruise.umple.implementation.ExternalClassTemplateTest;
import cruise.umple.util.SampleFileWriter;

public class RubyExternalClassTemplateTest extends ExternalClassTemplateTest
{
  
  @Test
  public void DoNotCreateExternalClasses()
  {
    assertUmpleTemplateFor("ExternalClassTest.ump",languagePath + "/ExternalClassTest_MyClass."+ languagePath +".txt","MyException");
    Assert.assertEquals(false, (new File(pathToInput + "/Exception.rb")).exists());
  }

}