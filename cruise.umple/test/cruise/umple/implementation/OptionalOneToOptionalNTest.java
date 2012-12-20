/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToOptionalNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToOptionalNTest.ump",languagePath + "/OptionalOneToOptionalNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void N()
  {
    assertUmpleTemplateFor("OptionalOneToOptionalNTest.ump",languagePath + "/OptionalOneToOptionalNTest_N."+ languagePath +".txt","Student");
 }    
  
}
