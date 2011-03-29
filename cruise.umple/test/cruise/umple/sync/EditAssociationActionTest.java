package cruise.umple.sync;

import org.junit.*;

public class EditAssociationActionTest extends ActionTest
{
  
  @Test
  public void Go()
  {
    assertEditAssociationAction("EditAssociationTest_Go");
  }
  
  @Test
  public void GoSeparateDescriptionFromPosition()
  {
    assertEditAssociationAction("EditAssociationTest_Go2");
  }  
  
  @Test
  public void GoNoPositionningAvailable()
  {
    assertEditAssociationAction("EditAssociationTest_Go3");
  }   
  
  @Test
  public void BugInSystemAddingExtraPositionInformation()
  {
    assertEditAssociationAction("EditAssociationTest_Go4");
  }    
  
  @Test
  public void GoNoClassOnePositionningAvailable()
  {
    assertEditAssociationAction("EditAssociationTest_Go5");
  }   
  
  @Test
  public void GoNoClassesHavePositioning()
  {
    assertEditAssociationAction("EditAssociationTest_Go6");
  }   
  
  @Test
  public void GoAssociationClass()
  {
    assertEditAssociationAction("EditAssociationTest_Go7");
  }
  
  @Test
  public void GoReflexiveNoPositioning()
  {
	assertEditAssociationAction("EditAssociationTest_Go8");
  }  
}
