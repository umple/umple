package cruise.umple.implementation;

import org.junit.Test;

public class OneToMNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OneToMNTest.ump",languagePath + "/OneToMNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OneToMNTest.ump",languagePath + "/OneToMNTest_MN."+ languagePath +".txt","Pupil");
  }  
}
