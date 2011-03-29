package cruise.umple.implementation;

import org.junit.*;

public class ManyToMStarTest extends TemplateTest
{

  @Test
  public void Many()
  {
    assertUmpleTemplateFor("ManyToMStarTest.ump",languagePath + "/ManyToMStarTest_Many."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void MStar()
  {
    assertUmpleTemplateFor("ManyToMStarTest.ump",languagePath + "/ManyToMStarTest_MStar."+ languagePath +".txt","Student");
  }    
  
}
