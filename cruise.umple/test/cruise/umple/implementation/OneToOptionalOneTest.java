/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class OneToOptionalOneTest extends TemplateTest
{

  @Test
  public void Driver()
  {
    assertUmpleTemplateFor("OneToOptionalOneTest.ump",languagePath + "/OneToOptionalOneTest_Driver."+ languagePath +".txt","MyDriver");
  }
  
  @Test
  public void Subordinate()
  {
    assertUmpleTemplateFor("OneToOptionalOneTest.ump",languagePath + "/OneToOptionalOneTest_Subordinate."+ languagePath +".txt","MySubordinate");
  }   
  
}
