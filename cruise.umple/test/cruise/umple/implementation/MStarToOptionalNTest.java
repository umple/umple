package cruise.umple.implementation;

import org.junit.Test;

public class MStarToOptionalNTest extends TemplateTest
{

  @Test
  public void MStar()
  {
    assertUmpleTemplateFor("MStarToOptionalNTest.ump",languagePath + "/MStarToOptionalNTest_MStar."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void OptionalN()
  {
    assertUmpleTemplateFor("MStarToOptionalNTest.ump",languagePath + "/MStarToOptionalNTest_OptionalN."+ languagePath +".txt","Student");
  }  
}
