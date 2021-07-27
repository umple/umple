/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class CompositePKGenTest extends TemplateTest
{

  @Test
  public void Parent()
  {
    assertUmpleTemplateFor("CompositePKGenTest.ump",languagePath + "/CompositePKGenTest_Parent."+ languagePath +".txt","Person");
 }
  
  @Test
  public void Child()
  {
    assertUmpleTemplateFor("CompositePKGenTest.ump",languagePath + "/CompositePKGenTest_Child."+ languagePath +".txt","Mentor");
  }  
}
