/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class OneToOneTest extends TemplateTest
{

  @Test
  public void Association()
  {
    assertUmpleTemplateFor("OneToOneTest.ump",languagePath + "/OneToOneTest_Association."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("OneToOneTest.ump",languagePath + "/OneToOneTest_Association2."+ languagePath +".txt","Student");
  }  
}
