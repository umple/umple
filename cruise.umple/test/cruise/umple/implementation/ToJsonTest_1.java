/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ToJsonTest_1 extends TemplateTest
{
  
  @Test
  public void GenJsonTest_1Person()
  {
    assertUmpleTemplateFor("ToJsonTest_1.ump",languagePath + "/ToJsonTest_1_Person."+ languagePath +".txt","Person");
 }
  
  @Test
  public void GenJsonTest_1Address()
  {
    assertUmpleTemplateFor("ToJsonTest_1.ump",languagePath + "/ToJsonTest_1_Address."+ languagePath +".txt","Address");
  } 
}
