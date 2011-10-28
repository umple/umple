/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import org.junit.*;

public class NewGeneralizationActionTest extends ActionTest
{
  
  @Test
  public void GoPositionAndModelSeparate()
  {
    assertNewGeneralizationAction("NewGeneralizationTest_Go");
  }  
  
  @Test
  public void GoPositionAndModelTogether()
  {
    assertNewGeneralizationAction("NewGeneralizationTest_Go2");
  }  
  
  @Test
  public void GoChildAlreadyExtendsParent()
  {
    assertNewGeneralizationAction("NewGeneralizationTest_Go3");
  }  
}
