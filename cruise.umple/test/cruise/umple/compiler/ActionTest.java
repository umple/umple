/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class ActionTest
{

  Action action;
  
  @Before
  public void setUp()
  {
    action = new Action("x");
  }
  
  @Test
  public void actionCode()
  {
    Assert.assertEquals("x",action.getActionCode());
  }
  
  @Test
  public void equalsCaresActionCode()
  {
    Action a2 = new Action("x");
    Assert.assertEquals(action, a2);
    
    a2.setActionCode("y");
    Assert.assertEquals(false, action.equals(a2));
  }
  
  @Test
  public void equalsCaresActionType()
  {
    Action a2 = new Action("x");
    a2.setActionType("entry");
    Assert.assertEquals(false, action.equals(a2));

    action.setActionType("entry");
    Assert.assertEquals(action, a2);
    
    action.setActionType("exit");
    Assert.assertEquals(false, action.equals(a2));
  }

  
  
}
