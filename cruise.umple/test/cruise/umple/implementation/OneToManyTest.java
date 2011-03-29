package cruise.umple.implementation;

import org.junit.Test;

public class OneToManyTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OneToManyTest.ump",languagePath + "/OneToManyTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OneToManyTest.ump",languagePath + "/OneToManyTest_Many."+ languagePath +".txt","Student");
  }  
}
