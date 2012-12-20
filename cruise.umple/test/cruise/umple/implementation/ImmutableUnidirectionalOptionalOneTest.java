/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ImmutableUnidirectionalOptionalOneTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("ImmutableUnidirectionalOptionalOneTest.ump",languagePath + "/ImmutableUnidirectionalOptionalOneTest."+ languagePath +".txt","Student");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("ImmutableUnidirectionalOptionalOneTest.ump",languagePath + "/ImmutableUnidirectionalTests_Unaware."+ languagePath +".txt","Mentor");
  }
}