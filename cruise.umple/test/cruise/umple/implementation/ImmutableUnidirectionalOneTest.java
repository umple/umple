/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ImmutableUnidirectionalOneTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("ImmutableUnidirectionalOneTest.ump",languagePath + "/ImmutableUnidirectionalOneTest."+ languagePath +".txt","Student");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("ImmutableUnidirectionalOneTest.ump",languagePath + "/ImmutableUnidirectionalTests_Unaware."+ languagePath +".txt","Mentor");
  }
}