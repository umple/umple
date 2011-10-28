/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

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
