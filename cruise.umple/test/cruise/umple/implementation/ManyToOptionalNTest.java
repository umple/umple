/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ManyToOptionalNTest extends TemplateTest
{

  @Test
  public void Many()
  {
    assertUmpleTemplateFor("ManyToOptionalNTest.ump",languagePath + "/ManyToOptionalNTest_Many."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void MN()
  {
    assertUmpleTemplateFor("ManyToOptionalNTest.ump",languagePath + "/ManyToOptionalNTest_OptionalN."+ languagePath +".txt","Student");
  }    
  
}
