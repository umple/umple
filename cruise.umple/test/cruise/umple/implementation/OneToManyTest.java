/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class OneToManyTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OneToManyTest.ump",languagePath + "/OneToManyTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OneToManyTest.ump",languagePath + "/OneToManyTest_Many."+ languagePath +".txt","Student");
  }  
}
