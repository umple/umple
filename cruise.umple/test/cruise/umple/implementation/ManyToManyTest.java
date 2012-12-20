/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ManyToManyTest extends TemplateTest
{

  @Test
  public void Association()
  {
    assertUmpleTemplateFor("ManyToManyTest.ump",languagePath + "/ManyToManyTest_Association."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("ManyToManyTest.ump",languagePath + "/ManyToManyTest_Association2."+ languagePath +".txt","Student");
  }   
}
