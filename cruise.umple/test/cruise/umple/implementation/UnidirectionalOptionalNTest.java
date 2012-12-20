/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class UnidirectionalOptionalNTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("UnidirectionalOptionalNTest.ump", languagePath + "/UnidirectionalOptionalNTest_Aware."+ languagePath +".txt","Mentor");
 }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("UnidirectionalOptionalNTest.ump",languagePath + "/UnidirectionalOptionalNTest_Unaware."+ languagePath +".txt","Student");
 }   


}
