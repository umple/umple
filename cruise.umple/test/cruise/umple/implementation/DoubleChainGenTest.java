/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class DoubleChainGenTest extends TemplateTest
{

  @Test
  public void Parent()
  {
    assertUmpleTemplateFor("DoubleChainGenTest.ump",languagePath + "/DoubleChainGenTest_Parent."+ languagePath +".txt","Person");
 }
  
  @Test
  public void Middle()
  {
    assertUmpleTemplateFor("DoubleChainGenTest.ump",languagePath + "/DoubleChainGenTest_Middle."+ languagePath +".txt","Employee");
  } 
  
  @Test
  public void Child()
  {
    assertUmpleTemplateFor("DoubleChainGenTest.ump",languagePath + "/DoubleChainGenTest_Child."+ languagePath +".txt","Admin");
  }  
}
