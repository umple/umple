/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class UnidirectionalMNTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("UnidirectionalMNTest.ump",languagePath + "/UnidirectionalMNTest_Aware."+ languagePath +".txt","Mentor");
 }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("UnidirectionalMNTest.ump",languagePath + "/UnidirectionalMNTest_Unaware."+ languagePath +".txt","Student");
  }   


}
