package cruise.umple.implementation;

import org.junit.*;

public class ManyToNTest extends TemplateTest
{

  @Test
  public void Many()
  {
    assertUmpleTemplateFor("ManyToNTest.ump",languagePath + "/ManyToNTest_Many."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void N()
  {
    assertUmpleTemplateFor("ManyToNTest.ump",languagePath + "/ManyToNTest_N."+ languagePath +".txt","Student");
  }    
  
}
