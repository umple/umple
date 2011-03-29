package cruise.umple.implementation;

import org.junit.*;

public class UnidirectionalOptionalOneTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("UnidirectionalOptionalOneTest.ump",languagePath + "/UnidirectionalOptionalOneTest_Aware."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("UnidirectionalOptionalOneTest.ump",languagePath + "/UnidirectionalOptionalOneTest_Unaware."+ languagePath +".txt","Student");
  }   


}
