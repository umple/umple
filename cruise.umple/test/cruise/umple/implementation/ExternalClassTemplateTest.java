package cruise.umple.implementation;

import org.junit.*;

public class ExternalClassTemplateTest extends TemplateTest
{
  
  @Test
  public void SubclassingAnExternalFile()
  {
    assertUmpleTemplateFor("ExternalClassTest.ump",languagePath + "/ExternalClassTest_MyClass."+ languagePath +".txt","MyException");
  }
    
}