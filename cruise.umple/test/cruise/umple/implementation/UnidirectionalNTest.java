/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class UnidirectionalNTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("UnidirectionalNTest.ump",languagePath + "/UnidirectionalNTest_Aware."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("UnidirectionalNTest.ump",languagePath + "/UnidirectionalNTest_Unaware."+ languagePath +".txt","Student");
 }   


}
