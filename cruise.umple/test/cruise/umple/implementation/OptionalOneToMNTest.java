package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToMNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToMNTest.ump",languagePath + "/OptionalOneToMNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OptionalOneToMNTest.ump",languagePath + "/OptionalOneToMNTest_MN."+ languagePath +".txt","Student");
  }    
  
}
