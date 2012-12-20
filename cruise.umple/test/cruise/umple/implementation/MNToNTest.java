/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class MNToNTest extends TemplateTest
{

  @Test
  public void MN()
  {
    assertUmpleTemplateFor("MNToNTest.ump",languagePath + "/MNToNTest_MN."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void N()
  {
    assertUmpleTemplateFor("MNToNTest.ump",languagePath + "/MNToNTest_N."+ languagePath +".txt","Student");
  }  
}
