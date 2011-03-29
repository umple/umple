package cruise.umple.sync;

import org.junit.*;

public class UpdatePositioningActionTest extends ActionTest
{
  
  @Test
  public void GoOneClassNoPositioning()
  {
    assertUpdatePositioningAction("AddPositioningTest_Go");
  }  
  
  @Test
  public void GoMultipleClassesNoPositioning()
  {
	  assertUpdatePositioningAction("AddPositioningTest_Go2");
  }
  
  @Test
  public void GoOneClassWithPositioning()
  {
	  assertUpdatePositioningAction("AddPositioningTest_Go3");
  }  
  
  @Test
  public void GoMultipleClassesWithPositioning()
  {
	  assertUpdatePositioningAction("AddPositioningTest_Go4");
  }
  
  @Test
  public void GoDMMExample()
  {
	  assertUpdatePositioningAction("AddPositioningTest_Go5");
  }
  
  @Test
  public void GoNestedClassNoPositioning()
  {
	  assertUpdatePositioningAction("AddPositioningTest_Go6");
  }
  
  @Test
  public void GoNestedClassOuterHasPositioning()
  {
	  assertUpdatePositioningAction("AddPositioningTest_Go7");
  }
  
  @Test
  public void GoNestedClassInnerHasPositioning()
  {
	  assertUpdatePositioningAction("AddPositioningTest_Go8");
  }
  
  @Test
  public void GoDeleteClassesNotInModel()
  {
	  assertUpdatePositioningAction("AddPositioningTest_Go9");
  }
  
  @Test
  public void GoClassHasMixin()
  {
	  assertUpdatePositioningAction("UpdatePositioningTest_Go");
  }
  
  @Test
  public void GoAssociationClassToAdd()
  {
	  assertUpdatePositioningAction("UpdatePositioningTest_Go2");
  }

  @Test
  public void GoAssociationClassToDelete()
  {
	  assertUpdatePositioningAction("UpdatePositioningTest_Go3");
  }
}