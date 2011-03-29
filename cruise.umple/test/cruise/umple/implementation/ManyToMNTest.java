package cruise.umple.implementation;

import org.junit.*;

public class ManyToMNTest extends TemplateTest
{

  @Test
  public void Many()
  {
    assertUmpleTemplateFor("ManyToMNTest.ump",languagePath + "/ManyToMNTest_Many."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void MN()
  {
    assertUmpleTemplateFor("ManyToMNTest.ump",languagePath + "/ManyToMNTest_MN."+ languagePath +".txt","Student");
  }    
  
}
