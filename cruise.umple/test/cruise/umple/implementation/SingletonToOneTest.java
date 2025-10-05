/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class SingletonToOneTest extends TemplateTest
{

  @Test
  public void Singleton()
  {
    assertUmpleTemplateFor("SingletonToOneTest.ump",languagePath + "/SingletonToOneTest_Singleton."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void One()
  {
    assertUmpleTemplateFor("SingletonToOneTest.ump",languagePath + "/SingletonToOneTest_One."+ languagePath +".txt","Student");
  }    
  
}
