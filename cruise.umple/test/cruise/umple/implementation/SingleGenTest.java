/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class SingleGenTest extends TemplateTest
{

  @Test
  public void Parent()
  {
    assertUmpleTemplateFor("SingleGenTest.ump",languagePath + "/SingleGenTest_Parent."+ languagePath +".txt","Person");
 }
  
  @Test
  public void Child()
  {
    assertUmpleTemplateFor("SingleGenTest.ump",languagePath + "/SingleGenTest_Child."+ languagePath +".txt","Mentor");
  } 
}
