package cruise.umple.implementation;

import org.junit.*;

public class UnidirectionalManyTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("UnidirectionalManyTest.ump",languagePath + "/UnidirectionalManyTest_Aware."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("UnidirectionalManyTest.ump",languagePath + "/UnidirectionalManyTest_Unaware."+ languagePath +".txt","Student");
  }

}
