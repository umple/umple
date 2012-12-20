/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class UniqueIdentifierTest
{

  @Test
  public void constructor()
  {
    UniqueIdentifier id = new UniqueIdentifier("myId","int",null,null);
    Assert.assertEquals("myId",id.getName());
  }
  
}
