/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class CodeInjectionTest
{

  
  @Test
  public void Constructor()
  {
    CodeInjection inject = new CodeInjection("before","addName","x");
    Assert.assertEquals("before",inject.getType());
    Assert.assertEquals("addName",inject.getOperation());
    Assert.assertEquals("x",inject.getCode());
  }
}
