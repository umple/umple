package cruise.umple.implementation;

import org.junit.*;

public class UnidirectionalMNTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("UnidirectionalMNTest.ump",languagePath + "/UnidirectionalMNTest_Aware."+ languagePath +".txt","Mentor");
 }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("UnidirectionalMNTest.ump",languagePath + "/UnidirectionalMNTest_Unaware."+ languagePath +".txt","Student");
  }   


}
