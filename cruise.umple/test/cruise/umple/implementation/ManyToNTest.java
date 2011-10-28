/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ManyToNTest extends TemplateTest
{

  @Test
  public void Many()
  {
    assertUmpleTemplateFor("ManyToNTest.ump",languagePath + "/ManyToNTest_Many."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void N()
  {
    assertUmpleTemplateFor("ManyToNTest.ump",languagePath + "/ManyToNTest_N."+ languagePath +".txt","Student");
  }    
  
}
