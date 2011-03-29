package cruise.umple.implementation;

import org.junit.*;

public class ManyToManyTest extends TemplateTest
{

  @Test
  public void Association()
  {
    assertUmpleTemplateFor("ManyToManyTest.ump",languagePath + "/ManyToManyTest_Association."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("ManyToManyTest.ump",languagePath + "/ManyToManyTest_Association2."+ languagePath +".txt","Student");
  }   
}
