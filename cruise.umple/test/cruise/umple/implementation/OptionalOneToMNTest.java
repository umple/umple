/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class OptionalOneToMNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OptionalOneToMNTest.ump",languagePath + "/OptionalOneToMNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OptionalOneToMNTest.ump",languagePath + "/OptionalOneToMNTest_MN."+ languagePath +".txt","Student");
  }    
  
}
