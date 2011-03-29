package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToOptionalNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToOptionalNTest.ump",languagePath + "/OptionalOneToOptionalNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void N()
  {
    assertUmpleTemplateFor("OptionalOneToOptionalNTest.ump",languagePath + "/OptionalOneToOptionalNTest_N."+ languagePath +".txt","Student");
 }    
  
}
