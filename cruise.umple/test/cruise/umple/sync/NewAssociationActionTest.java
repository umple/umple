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
}
