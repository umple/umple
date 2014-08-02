/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class InterfaceTemplateTest extends TemplateTest
{
  
  @Test @Ignore
  public void Interface()
  {
    assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest."+ languagePath +".txt","ISomething");
  }
  
  @Test
  public void Implements()
  {
	  assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_Implements."+ languagePath +".txt","Something");
  }

}
