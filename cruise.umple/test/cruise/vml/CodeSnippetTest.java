/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license
 
 */

package cruise.vml;

import org.junit.*;

public class CodeSnippetTest
{
  
  @Test
  public void TestToString()
  {
    CodeSnippet c = new CodeSnippet("a");
    Assert.assertEquals("a",c.toString());
    
    c.setCode(null);
    Assert.assertEquals("",c.toString());
  }


}
