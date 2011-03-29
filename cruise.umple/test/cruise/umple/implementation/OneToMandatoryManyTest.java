package cruise.umple.implementation;

import org.junit.Test;

public class OneToMandatoryManyTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OneToMandatoryManyTest.ump",languagePath + "/OneToMandatoryManyTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OneToMandatoryManyTest.ump",languagePath + "/OneToMandatoryManyTest_Many."+ languagePath +".txt","Student");
  }  
}
