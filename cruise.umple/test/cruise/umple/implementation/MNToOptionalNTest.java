/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class MNToOptionalNTest extends TemplateTest
{

  @Test
  public void MN()
  {
    assertUmpleTemplateFor("MNToOptionalNTest.ump",languagePath + "/MNToOptionalNTest_MN."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void OptionalN()
  {
    assertUmpleTemplateFor("MNToOptionalNTest.ump",languagePath + "/MNToOptionalNTest_OptionalN."+ languagePath +".txt","Student");
  }  
}
