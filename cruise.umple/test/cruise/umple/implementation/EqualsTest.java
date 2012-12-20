/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class EqualsTest extends TemplateTest
{

  @Test
  public void Attributes()
  {
    assertUmpleTemplateFor("EqualsTest.ump",languagePath + "/EqualsTest_Attributes."+ languagePath +".txt","Student");
  }

  @Test
  public void Associations()
  {
    assertUmpleTemplateFor("EqualsTest.ump", languagePath + "/EqualsTest_Associations."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void AlreadyImmutable()
  {
    assertUmpleTemplateFor("EqualsTest_AlreadyImmutable.ump",languagePath + "/EqualsTest_AlreadyImmutable."+ languagePath +".txt","Student");
  }

}
