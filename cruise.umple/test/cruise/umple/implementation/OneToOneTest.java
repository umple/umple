package cruise.umple.implementation;

import org.junit.*;

public class OneToOneTest extends TemplateTest
{

  @Test
  public void Association()
  {
    assertUmpleTemplateFor("OneToOneTest.ump",languagePath + "/OneToOneTest_Association."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("OneToOneTest.ump",languagePath + "/OneToOneTest_Association2."+ languagePath +".txt","Student");
  }  
}
