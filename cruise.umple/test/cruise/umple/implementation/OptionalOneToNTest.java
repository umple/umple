package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToNTest.ump",languagePath + "/OptionalOneToNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OptionalOneToNTest.ump",languagePath + "/OptionalOneToNTest_Many."+ languagePath +".txt","Student");
  }    
  
}
