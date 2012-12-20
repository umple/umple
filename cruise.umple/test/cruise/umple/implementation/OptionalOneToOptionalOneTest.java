/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToOptionalOneTest extends TemplateTest
{
   
  @Test
  public void Association()
  {
    assertUmpleTemplateFor("OptionalOneToOptionalOneTest.ump",languagePath + "/OptionalOneToOptionalOneTest_Association."+ languagePath +".txt","Mentor");
  } 
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("OptionalOneToOptionalOneTest.ump",languagePath + "/OptionalOneToOptionalOneTest_Association2."+ languagePath +".txt","Student");
  }


}
