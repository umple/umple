/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class DoubleGenTest extends TemplateTest
{

  @Test
  public void Parent()
  {
    assertUmpleTemplateFor("DoubleGenTest.ump",languagePath + "/DoubleGenTest_Parent."+ languagePath +".txt","Person");
 }
  
  @Test
  public void Child()
  {
    assertUmpleTemplateFor("DoubleGenTest.ump",languagePath + "/DoubleGenTest_Child."+ languagePath +".txt","Mentor");
  } 
  
  @Test
  public void Child2()
  {
    assertUmpleTemplateFor("DoubleGenTest.ump",languagePath + "/DoubleGenTest_Child2."+ languagePath +".txt","Student");
  }  
}
