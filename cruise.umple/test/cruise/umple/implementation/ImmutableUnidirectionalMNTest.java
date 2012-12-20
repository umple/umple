/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ImmutableUnidirectionalMNTest extends TemplateTest
{
   
  @Test
  public void Aware()
  {
    assertUmpleTemplateFor("ImmutableUnidirectionalMNTest.ump",languagePath + "/ImmutableUnidirectionalMNTest."+ languagePath +".txt","Student");
  }
  
  @Test
  public void Unaware()
  {
    assertUmpleTemplateFor("ImmutableUnidirectionalMNTest.ump",languagePath + "/ImmutableUnidirectionalTests_Unaware."+ languagePath +".txt","Mentor");
  }
}