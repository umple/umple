/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ImmutableUnidirectionalNTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("ImmutableUnidirectionalNTest.ump",languagePath + "/ImmutableUnidirectionalNTest."+ languagePath +".txt","Student");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("ImmutableUnidirectionalNTest.ump",languagePath + "/ImmutableUnidirectionalTests_Unaware."+ languagePath +".txt","Mentor");
  }
}