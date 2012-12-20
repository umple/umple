/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class OptionalNToOptionalNTest extends TemplateTest
{

  @Test
  public void Association()
  {
    assertUmpleTemplateFor("OptionalNToOptionalNTest.ump",languagePath + "/OptionalNToOptionalNTest_Association."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("OptionalNToOptionalNTest.ump",languagePath + "/OptionalNToOptionalNTest_Association2."+ languagePath +".txt","Student");
  }  
}
