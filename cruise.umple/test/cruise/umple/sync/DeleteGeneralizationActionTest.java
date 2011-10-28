/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import org.junit.*;

public class DeleteGeneralizationActionTest extends ActionTest
{
  
  @Test
  public void GoPositionAndModelSeparate()
  {
    assertDeleteGeneralizationAction("DeleteGeneralizationTest_Go");
  }  
}
