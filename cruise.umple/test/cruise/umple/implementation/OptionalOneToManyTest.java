package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToManyTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToManyTest.ump",languagePath + "/OptionalOneToManyTest_One."+ languagePath +".txt","Mentor");
 }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OptionalOneToManyTest.ump",languagePath + "/OptionalOneToManyTest_Many."+ languagePath +".txt","Student");
  }    
  
}
