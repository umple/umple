/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class NToOptionalNTest extends TemplateTest
{

  @Test
  public void N()
  {
    assertUmpleTemplateFor("NToOptionalNTest.ump",languagePath + "/NToOptionalNTest_N."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void OptionalN()
  {
    assertUmpleTemplateFor("NToOptionalNTest.ump",languagePath + "/NToOptionalNTest_OptionalN."+ languagePath +".txt","Student");
  }  
}
