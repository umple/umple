/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.util.List;

import org.junit.*;

public class StateTest
{
  UmpleClass clazz;
  StateMachine sm, sm2;
  State state;
  
  Event e1,e2;
  
  @Before
  public void setUp()
  {
    clazz = new UmpleClass("Course");
    sm = new StateMachine("sm");
    sm.setUmpleClass(clazz);
    state = new State("state",sm);
    
    e1 = new Event("e1");
    e2 = new Event("e2");
    
    sm2 = new StateMachine("sm2");
  }
  
  @Test
  public void getIsConcurrent_NoNestedStates()
  {
    Assert.assertEquals(false,state.getIsConcurrent());
  }
  
  @Test
  public void getIsConcurrent_OneNestedState()
  {
    state.addNestedStateMachine(new StateMachine("x"));
    Assert.assertEquals(false,state.getIsConcurrent());
  }

  @Test
  public void getIsConcurrent_MultipleNestedStates()
  {
    state.addNestedStateMachine(new StateMachine("x"));
    state.addNestedStateMachine(new StateMachine("y"));
    Assert.assertEquals(true,state.getIsConcurrent());
  }
  

  @Test
  public void getTransitionsFor_none()
  {
    Assert.assertEquals(0,state.getTransitionsFor(e1).size());
    
    Transition t = state.addTransition(state);
    Assert.assertEquals(0,state.getTransitionsFor(e1).size());

    t.setEvent(e2);
    Assert.assertEquals(0,state.getTransitionsFor(e1).size());
  }
  
  @Test
  public void getTransitionsFor_one()
  {
    Transition t = state.addTransition(state);
    t.setEvent(e1);
    
    List<Transition> all = state.getTransitionsFor(e1);
    Assert.assertEquals(1,all.size());
    Assert.assertEquals(t,all.get(0));

    Transition t2 = state.addTransition(state);
    t2.setEvent(e2);
    all = state.getTransitionsFor(e1);
    Assert.assertEquals(1,all.size());
    Assert.assertEquals(t,all.get(0));

  }  
   
  @Test
  public void getTransitionsFor_many()
  {
    Transition t = state.addTransition(state);
    t.setEvent(e1);

    List<Transition> all = state.getTransitionsFor(e1);
    Assert.assertEquals(1,all.size());
    Assert.assertEquals(t,all.get(0));

    Transition t2 = state.addTransition(state);
    t2.setEvent(e1);
    all = state.getTransitionsFor(e1);
    Assert.assertEquals(2,all.size());
    Assert.assertEquals(t,all.get(0));
    Assert.assertEquals(t2,all.get(1));
  }  

  @Test
  public void IsStartState()
  {
    Assert.assertEquals(false, state.getIsStartState());
    state.setIsStartState(true);
    Assert.assertEquals(true, state.getIsStartState());
  }

  @Test
  public void getType_Nested()
  {
    State state = new State("s1",sm);
    state.addNestedStateMachine(new StateMachine("sm2"));
    Assert.assertEquals("Complex",state.getType());
  } 
  
  @Test
  public void getTypeBasedOnIfYouHaveTransitionsOrNot()
  {
    State state = new State("s1",sm);
    State state2 = new State("s2",sm);
    Assert.assertEquals("Simple",state.getType());
    state.addTransition(state2);
    Assert.assertEquals("Complex",state.getType());
    Assert.assertEquals("Simple",state2.getType());
  }  
  
  @Test
  public void newTimedEventName()
  {
    State state = new State("On",sm);
    State state2 = new State("Off",sm);
    
    String answer = state.newTimedEventName(state2);
    Assert.assertEquals("timeoutOnToOff", answer);
    
    Transition t1 = new Transition(state, state2);
    t1.setEvent(new Event("timeoutOnToOff"));

    answer = state.newTimedEventName(state2);
    Assert.assertEquals("timeoutOnToOff2", answer);
  }
  
  @Test
  public void newTimedEventName_invalidInput()
  {
    String answer;
    State state = new State("On",sm);
    State state2 = new State("Off",sm);
    
    answer = state.newTimedEventName(null);
    Assert.assertEquals("timeoutOnTo", answer);

    state2.setName("");
    answer = state.newTimedEventName(state2);
    Assert.assertEquals("timeoutOnTo", answer);

    state.setName("");
    answer = state.newTimedEventName(state2);
    Assert.assertEquals("timeoutTo", answer);

    state2.setName(null);
    answer = state.newTimedEventName(state2);
    Assert.assertEquals("timeoutTonull", answer);

    state.setName(null);
    answer = state.newTimedEventName(state2);
    Assert.assertEquals("timeoutnullTonull", answer);
  }

  @Test
  public void addNestedTransitions()
  {
    State s = new State("s",sm);
    State s1 = new State("s1",sm);
    State s0 = new State("s0",sm);
    
    Transition t1 = s.addTransition(s1);
    Transition t0 = s.addTransition(s0,0);
    
    Assert.assertEquals(2,s.numberOfTransitions());
    Assert.assertEquals(t0,s.getTransition(0));
    Assert.assertEquals(t1,s.getTransition(1));
  }
  

  @Test
  public void addAction_index()
  {
    State s = new State("s",sm);
    
    Action a = new Action("a");
    Action b = new Action("b");
    
    s.addAction(b);
    s.addAction(a,0);
    
    Assert.assertEquals(a, s.getAction(0));
    Assert.assertEquals(b, s.getAction(1));
  }

  @Test
  public void isFinalBasedOnName()
  {
    State s = new State("Final",sm);
    Assert.assertEquals(true, s.isFinalState());
    
    s = new State("NotFinal",sm);
    Assert.assertEquals(false, s.isFinalState());
    s.setName("Final");
    Assert.assertEquals(true, s.isFinalState());
  }

  @Test
  public void isSameState_null()
  {
    State s = new State("s1",sm);
    Assert.assertEquals(false,s.isSameState(null,null));
    Assert.assertEquals(false,s.isSameState(null,sm));
    Assert.assertEquals(true,s.isSameState(s,null));
  }  

  @Test
  public void isSameState_siblings()
  {
    State s = new State("s1",sm);
    Assert.assertEquals(true,s.isSameState(s,sm));
    
    State s2 = new State("nots1",sm);
    Assert.assertEquals(false,s.isSameState(s2,sm));
    Assert.assertEquals(false,s2.isSameState(s,sm));
  }

  @Test
  public void isSameState_differentStateMachines()
  {
    State s = new State("s1",sm);
    Assert.assertEquals(true,s.isSameState(s,sm));
    
    State s2 = new State("nots1",sm2);
    Assert.assertEquals(false,s.isSameState(s2,sm));
    Assert.assertEquals(false,s2.isSameState(s,sm));
  }

  @Test
  public void isSameState_self()
  {
    Assert.assertEquals(true,state.isSameState(state,sm));
  }

  
  @Test
  public void isSameState_nestedSm()
  {
    State s = new State("s1",sm);
    new State("s2",sm);
    
    StateMachine nested1 = new StateMachine("nested1");
    State sA = new State("sA",nested1);
    State sB = new State("sB",nested1);
    
    StateMachine nested2 = new StateMachine("nested2");
    State sX = new State("sX",nested2);
    State sY = new State("sY",nested2);

    nested1.setParentState(s);
    nested2.setParentState(sA);
    
    Assert.assertEquals(true,s.isSameState(sA,sm));
    Assert.assertEquals(true,s.isSameState(sB,sm));
    Assert.assertEquals(true,s.isSameState(sX,sm));
    Assert.assertEquals(true,sA.isSameState(s,sm));
    Assert.assertEquals(true,sB.isSameState(s,sm));
    Assert.assertEquals(true,sX.isSameState(s,sm));

    Assert.assertEquals(true,sA.isSameState(sB,sm));
    Assert.assertEquals(true,sB.isSameState(sA,sm));

    Assert.assertEquals(true,sX.isSameState(sY,sm));
    Assert.assertEquals(true,sX.isSameState(sY,nested1));
    Assert.assertEquals(false,sX.isSameState(sY,nested2));

    Assert.assertEquals(true,sX.isSameState(sB,sm));
    Assert.assertEquals(false,sX.isSameState(sB,nested1));
    Assert.assertEquals(false,sX.isSameState(sB,nested2));
  }  

  
  @Test
  public void removeTransition_simple()
  {
    State state = new State("On",sm);
    State state2 = new State("Off",sm);
    new Transition(state, state2);
    
    Transition deleteT = Transition.createPlaceholder(state2);
    state.removeTransition(deleteT);
    Assert.assertEquals(0, state.numberOfTransitions());
  }
  
}
