/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class TransitionTest
{

  StateMachine sm;
  State from;
  State too;
  
  @Before
  public void setUp()
  {
    sm = new StateMachine("sm");
    from = new State("from",sm);
    too = new State("too",sm);
  }
  
  @Test
  public void getIsInternal()
  {
    Transition t = new Transition(from,too);
    Assert.assertEquals(false,t.getIsInternal());
    t.setIsInternal(true);
    Assert.assertEquals(true,t.getIsInternal());
  }
  
  @Test
  public void createPlaceholder()
  {
    Transition t = Transition.createPlaceholder(too);
    Assert.assertEquals("null",t.getFromState().getName());
    Assert.assertEquals(too, t.getNextState());
  }
  
  @Test
  public void equalsIgnoreFromState()
  {
    Transition t = Transition.createPlaceholder(too);
    Transition t2 = Transition.createPlaceholder(too);
    Assert.assertEquals(t, t2);
  }
  
}
