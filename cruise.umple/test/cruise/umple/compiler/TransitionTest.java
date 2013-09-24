/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

import cruise.umple.compiler.Transition;

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
  public void isAutoTransition()
  {
    Transition t = new Transition(from,too);
    Assert.assertEquals(false,t.isAutoTransition());
    t.setAutoTransition(true);
    Assert.assertEquals(true,t.isAutoTransition());
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
  
  @Test
  public void equalsChecksGuard()
  {
    Transition t = Transition.createPlaceholder(too);
    Transition t2 = Transition.createPlaceholder(too);
    Transition t3 = Transition.createPlaceholder(too);

    t.setGuard(new Guard());
    t.getGuard().addExpression(new ConstraintVariable("NAME","x"));
    t2.setGuard(new Guard());
    t2.getGuard().addExpression(new ConstraintVariable("NAME","x"));
    Assert.assertEquals(t, t2);

    t3.setGuard(new Guard());
    t3.getGuard().addExpression(new ConstraintVariable("NAME","y"));
    Assert.assertEquals(false, t.getGuard().getExpression(0).equals(t3.getGuard().getExpression(0)));
  
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
