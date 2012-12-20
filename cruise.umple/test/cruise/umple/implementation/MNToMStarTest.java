/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class MNToMStarTest extends TemplateTest
{

  @Test
  public void MN()
  {
    assertUmpleTemplateFor("MNToMStarTest.ump",languagePath + "/MNToMStarTest_MN."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void MStar()
  {
    assertUmpleTemplateFor("MNToMStarTest.ump",languagePath + "/MNToMStarTest_MStar."+ languagePath +".txt","Student");
  }  
}
