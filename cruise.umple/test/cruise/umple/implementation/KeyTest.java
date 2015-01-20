/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class KeyTest extends TemplateTest
{

  @Test
  public void Attributes()
  {
    assertUmplePartialTemplateFor("InheritedKeys.ump",languagePath + "/InheritedKeys."+ languagePath +".txt","Bar");
  }

}
