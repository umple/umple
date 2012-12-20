/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

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
