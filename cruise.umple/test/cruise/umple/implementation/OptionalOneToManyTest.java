/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToManyTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToManyTest.ump",languagePath + "/OptionalOneToManyTest_One."+ languagePath +".txt","Mentor");
 }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OptionalOneToManyTest.ump",languagePath + "/OptionalOneToManyTest_Many."+ languagePath +".txt","Student");
  }    
  
}
