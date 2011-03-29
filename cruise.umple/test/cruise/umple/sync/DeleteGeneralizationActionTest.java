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
