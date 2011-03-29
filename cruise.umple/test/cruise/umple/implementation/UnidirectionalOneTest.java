package cruise.umple.implementation;

import org.junit.*;

public class UnidirectionalOneTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("UnidirectionalOneTest.ump",languagePath + "/UnidirectionalOneTest_Aware."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("UnidirectionalOneTest.ump",languagePath + "/UnidirectionalOneTest_Unaware."+ languagePath +".txt","Student");
 }   


}
