/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ManyToMNTest extends TemplateTest
{

  @Test
  public void Many()
  {
    assertUmpleTemplateFor("ManyToMNTest.ump",languagePath + "/ManyToMNTest_Many."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void MN()
  {
    assertUmpleTemplateFor("ManyToMNTest.ump",languagePath + "/ManyToMNTest_MN."+ languagePath +".txt","Student");
  }    
  
}
