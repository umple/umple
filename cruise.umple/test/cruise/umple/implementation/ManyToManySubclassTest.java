/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ManyToManySubclassTest extends TemplateTest
{

  @Test
  public void Association()
  {
    assertUmpleTemplateFor("ManyToManySubclassTest.ump",languagePath + "/ManyToManySubclassTest_Association."+ languagePath +".txt","Analyzer");
  }
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("ManyToManySubclassTest2.ump",languagePath + "/ManyToManySubclassTest_Association2."+ languagePath +".txt","Analyzer");
  }
  
}
