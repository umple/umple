/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ExternalInterfaceTemplateTest extends TemplateTest
{
  
  @Test
  public void SubclassingAnExternalFile()
  {
    assertUmpleTemplateFor("ExternalInterfaceTest.ump",languagePath + "/ExternalInterfaceTest_MyInterface."+ languagePath +".txt","MyData");
  }
    
}