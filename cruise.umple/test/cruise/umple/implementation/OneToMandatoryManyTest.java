/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class OneToMandatoryManyTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OneToMandatoryManyTest.ump",languagePath + "/OneToMandatoryManyTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OneToMandatoryManyTest.ump",languagePath + "/OneToMandatoryManyTest_Many."+ languagePath +".txt","Student");
  }  
}
