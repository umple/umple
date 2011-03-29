package cruise.umple.implementation;

import org.junit.*;

public class InterfaceTemplateTest extends TemplateTest
{
  
  @Test
  public void Interface()
  {
    assertUmpleInterfaceTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest."+ languagePath +".txt","ISomething");
  }
  
  @Test
  public void Implements()
  {
	  assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_Implements."+ languagePath +".txt","Something");
  }


}
