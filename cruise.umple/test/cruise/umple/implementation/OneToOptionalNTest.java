/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class OneToOptionalNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OneToOptionalNTest.ump",languagePath + "/OneToOptionalNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void OptionalN()
  {
    assertUmpleTemplateFor("OneToOptionalNTest.ump",languagePath + "/OneToOptionalNTest_OptionalN."+ languagePath +".txt","Student");
  }  
}
