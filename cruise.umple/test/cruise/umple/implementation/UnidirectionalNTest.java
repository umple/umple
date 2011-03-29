package cruise.umple.implementation;

import org.junit.*;

public class UnidirectionalNTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("UnidirectionalNTest.ump",languagePath + "/UnidirectionalNTest_Aware."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("UnidirectionalNTest.ump",languagePath + "/UnidirectionalNTest_Unaware."+ languagePath +".txt","Student");
 }   


}
