/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToMStarTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToMStarTest.ump",languagePath + "/OptionalOneToMStarTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OptionalOneToMStarTest.ump",languagePath + "/OptionalOneToMStarTest_Many."+ languagePath +".txt","Student");
  }    
  
}
