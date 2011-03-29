package cruise.umple.implementation;

import org.junit.Test;

public class NToMStarTest extends TemplateTest
{

  @Test
  public void MN()
  {
    assertUmpleTemplateFor("NToMStarTest.ump",languagePath + "/NToMStarTest_N."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void MStar()
  {
    assertUmpleTemplateFor("NToMStarTest.ump",languagePath + "/NToMStarTest_MStar."+ languagePath +".txt","Student");
  }  
}
