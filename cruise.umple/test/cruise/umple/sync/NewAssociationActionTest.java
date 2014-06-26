/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import org.junit.*;

public class NewAssociationActionTest extends ActionTest
{
  
  @Test
  public void GoPositionAndModelTogether()
  {
    assertNewAssociationAction("NewAssociationTest_Go");
  }
  
  @Test
  public void GoPositionAndModelSeparate()
  {
    assertNewAssociationAction("NewAssociationTest_Go2");
  }  
  
  @Test
  public void GoNoPositioningAvailable()
  {
    assertNewAssociationAction("NewAssociationTest_Go3");
  }  
  
  @Test
  public void GoClassOneHasParent()
  {
    assertNewAssociationAction("NewAssociationTest_Go4");
  }  
  
  @Test
  public void GoClassOneAlphabeticallyBefore()
  {
	 assertNewAssociationAction("NewAssociationTest_Go5");
  }

  @Test
  public void GoReflexiveAssociationAdded()
  {
    assertNewAssociationAction("NewAssociationTest_Go6");
  }
}
