/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class MStarToMStarTest extends TemplateTest
{

  @Test
  public void Association()
  {
    assertUmpleTemplateFor("MStarToMStarTest.ump",languagePath + "/MStarToMStarTest_Association."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("MStarToMStarTest.ump",languagePath + "/MStarToMStarTest_Association2."+ languagePath +".txt","Student");
  }  
}
