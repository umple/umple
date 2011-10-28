/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class EventTest
{

  @Test
  public void name()
  {
    Event e = new Event("blah");
    Assert.assertEquals("blah",e.getName());
  }
  
  
}
