package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToMStarTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToMStarTest.ump",languagePath + "/OptionalOneToMStarTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OptionalOneToMStarTest.ump",languagePath + "/OptionalOneToMStarTest_Many."+ languagePath +".txt","Student");
  }    
  
}
