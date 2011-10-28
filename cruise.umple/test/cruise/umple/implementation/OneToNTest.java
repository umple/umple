/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.Test;

public class OneToNTest extends TemplateTest
{

  @Test
  public void One()
  {
    assertUmpleTemplateFor("OneToNTest.ump",languagePath + "/OneToNTest_One."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Many()
  {
    assertUmpleTemplateFor("OneToNTest.ump",languagePath + "/OneToNTest_N."+ languagePath +".txt","Student");
  }  
}
