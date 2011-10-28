/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class OneToMNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OneToMNTest.ump",languagePath + "/OneToMNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OneToMNTest.ump",languagePath + "/OneToMNTest_MN."+ languagePath +".txt","Pupil");
  }  
}
