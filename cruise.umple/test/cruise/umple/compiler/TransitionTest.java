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
  
  @Test @Ignore //Deploy New Version
  public void isAutoTransition()
  {
//    Transition t = new Transition(from,too);
//    Assert.assertEquals(false,t.isAutoTransition());
//    t.setAutoTransition(true);
//    Assert.assertEquals(true,t.isAutoTransition());
  }
  
  @Test @Ignore //Deploy New Version
  public void createPlaceholder()
  {
//    Transition t = Transition.createPlaceholder(too);
//    Assert.assertEquals("null",t.getFromState().getName());
//    Assert.assertEquals(too, t.getNextState());
  }
  
  @Test @Ignore //Deploy New Version
  public void equalsIgnoreFromState()
  {
//    Transition t = Transition.createPlaceholder(too);
//    Transition t2 = Transition.createPlaceholder(too);
//    Assert.assertEquals(t, t2);
  }
  
  @Test
  public void equalsChecksGuard()
  {
    Transition t = Transition.createPlaceholder(too);
    Transition t2 = Transition.createPlaceholder(too);

    t.setGuard(new Guard("x"));
    t2.setGuard(new Guard("x"));
    Assert.assertEquals(t, t2);

    t2.setGuard(new Guard("y"));
    Assert.assertEquals(false, t.equals(t2));
  
  }
  
  @Test
  public void equalsChecksEvent()
  {
    Transition t = Transition.createPlaceholder(too);
    Transition t2 = Transition.createPlaceholder(too);

    t.setEvent(new Event("e"));
    t2.setEvent(new Event("e"));
    
    Assert.assertEquals(t, t2);

    t2.setEvent(new Event("y"));
    Assert.assertEquals(false, t.equals(t2));
  }
  
  @Test
  public void equalsChecksAction()
  {
    Transition t = Transition.createPlaceholder(too);
    Transition t2 = Transition.createPlaceholder(too);

    t.setAction(new Action("a"));
    t2.setAction(new Action("a"));
    
    Assert.assertEquals(t, t2);

    t2.setAction(new Action("y"));
    Assert.assertEquals(false, t.equals(t2));
  }  
  
}
