package cruise.umple.compiler;

import java.util.List;

import org.junit.*;

public class StateMachineTest
{
  UmpleClass clazz;
  StateMachine sm;
  
  @Before
  public void setUp()
  {
    clazz = new UmpleClass("Course");
    sm = new StateMachine("sm");
    sm.setUmpleClass(clazz);
  }
  

  @Test
  public void getEventByName()
  {
    Assert.assertEquals(null, sm.getEvent(null));
    Assert.assertEquals(null, sm.getEvent(""));
    Assert.assertEquals(null, sm.getEvent("unknown"));
    
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    Event e = new Event("flip");
    Event e2 = new Event("flop");
    
    Transition t1 = new Transition(s1, s2);
    t1.setEvent(e);
    
    Transition t2 = new Transition(s2, s1);
    t2.setEvent(e2);
    
    Event same = sm.getEvent("flip");
    Assert.assertEquals(e, same);

    Event same2 = sm.getEvent("flop");
    Assert.assertEquals(e2, same2);
  }
  
  @Test
  public void getEvents_none()
  {
    Assert.assertEquals(0, sm.getEvents().size());
    
    State s1 = new State("s1",sm);
    Assert.assertEquals(0, sm.getEvents().size());
    
    new Transition(s1,s1);
    Assert.assertEquals(0, sm.getEvents().size());

  }
  
  @Test
  public void getEvents_one()
  {
    State s1 = new State("s1",sm);
    Transition t1 = new Transition(s1,s1);
    Event e1 = new Event("e1");
    t1.setEvent(e1);
    
    Assert.assertEquals(1, sm.getEvents().size());
    Assert.assertEquals(e1, sm.getEvents().get(0));
  }
  
  @Test
  public void getEvents_manyOnSameState()
  {
    State s1 = new State("s1",sm);
    Transition t1 = new Transition(s1,s1);
    Event e1 = new Event("e1");
    t1.setEvent(e1);

    Transition t2 = new Transition(s1,s1);
    Event e2 = new Event("e2");
    t2.setEvent(e2);
    
    Assert.assertEquals(2, sm.getEvents().size());
    Assert.assertEquals(e1, sm.getEvents().get(0));
    Assert.assertEquals(e2, sm.getEvents().get(1));
  }  
  
  
  @Test
  public void getEvents_manyFromDifferentStates()
  {
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    
    
    Transition t1 = new Transition(s1,s1);
    Event e1 = new Event("e1");
    t1.setEvent(e1);

    Transition t2 = new Transition(s2,s1);
    Event e2 = new Event("e2");
    t2.setEvent(e2);
    
    Assert.assertEquals(2, sm.getEvents().size());
    Assert.assertEquals(e1, sm.getEvents().get(0));
    Assert.assertEquals(e2, sm.getEvents().get(1));
  }   
  
  @Test
  public void getEvents_ignoreDuplicates()
  {
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    
    
    Transition t1 = new Transition(s1,s1);
    Event e1 = new Event("e1");
    t1.setEvent(e1);

    Transition t2 = new Transition(s2,s2);
    t2.setEvent(e1);
    
    Assert.assertEquals(1, sm.getEvents().size());
    Assert.assertEquals(e1, sm.getEvents().get(0));
  }  
  
  @Test
  public void findState_doesNotExist()
  {
    State s1 = sm.findState("s1");
    Assert.assertEquals(null, s1);
  }
  
  @Test
  public void findState_findeExisting()
  {
    State sOld = new State("s1",sm);
    State s1 = sm.findState("s1");
    Assert.assertEquals("s1", s1.getName());
    Assert.assertEquals(sm, s1.getStateMachine());
    Assert.assertEquals(1,sm.numberOfStates());
    Assert.assertSame(sOld, s1);
  }  

  @Test
  public void findState_ignoreNestingIfRequested()
  {
    State s1 = new State("s1",sm);
    
    StateMachine innerSm = new StateMachine("innerSm");
    s1.addNestedStateMachine(innerSm);
    
    new State("innerS2",innerSm);
    
    Assert.assertSame(null,sm.findState("innerS2",false));
    Assert.assertSame(null,innerSm.findState("s1",false));

    Assert.assertEquals(1,sm.numberOfStates());
    Assert.assertEquals(1,innerSm.numberOfStates());
  }
  
  
  @Test
  public void findState_nestedStateAlreadyDefined()
  {
    State s1 = new State("s1",sm);
    
    StateMachine innerSm = new StateMachine("innerSm");
    s1.addNestedStateMachine(innerSm);
    
    State innerS2 = new State("innerS2",innerSm);
    
    Assert.assertSame(innerS2,sm.findState("innerS2"));
    Assert.assertSame(s1,innerSm.findState("s1"));

    Assert.assertEquals(1,sm.numberOfStates());
    Assert.assertEquals(1,innerSm.numberOfStates());
  }

  @Test
  public void findOrCreateEvent_createNew()
  {
    Event e1 = sm.findOrCreateEvent("e1");
    Assert.assertEquals("e1", e1.getName());
  }
  
  @Test
  public void findOrCreateEvent_mustBeRegistered()
  {
    Event eOld = sm.findOrCreateEvent("e1");
    Event e1 = sm.findOrCreateEvent("e1");
    Assert.assertEquals("e1", e1.getName());
    Assert.assertEquals("e1", eOld.getName());
    Assert.assertNotSame(eOld, e1);
  }   
  
  @Test
  public void findOrCreateEvent_findeExisting()
  {
    Event eOld = sm.findOrCreateEvent("e1");
    State s = new State("s1",sm);
    Transition t = new Transition(s,s);
    t.setEvent(eOld);
    
    Event e1 = sm.findOrCreateEvent("e1");
    Assert.assertEquals("e1", e1.getName());
    Assert.assertSame(eOld, e1);
  }   
  
  @Test
  public void getStartState_none()
  {
    Assert.assertEquals(null,sm.getStartState());
    new State("s1",sm);
    Assert.assertEquals(null,sm.getStartState());
  }
  
  @Test
  public void getStartState_okay()
  {
    new State("s1",sm);
    State state2 = new State("s2",sm);
    state2.setIsStartState(true);
    Assert.assertEquals(state2,sm.getStartState());
  }  
  
  @Test
  public void getTypeBasedStateTypes()
  {
    Assert.assertEquals("Simple",sm.getType());

    State state = new State("s1",sm);
    State state2 = new State("s2",sm);
    sm.findState("s3");

    Assert.assertEquals("Simple",sm.getType());
    state.addTransition(state2);
    Assert.assertEquals("Complex",sm.getType());
  }

  @Test
  public void equalsNoParentState()
  {
    StateMachine sm2 = new StateMachine("sm");
    Assert.assertEquals(sm,sm2);
    
    sm2.setName("notsm");
    Assert.assertEquals(false,sm.equals(sm2));
  }

  @Test
  public void equalsCheckParentState()
  {
    StateMachine sm2 = new StateMachine("sm");
    State s = sm.findState("s");
    State s2 = new State("s2",sm);
    
    sm.setParentState(s);
    sm2.setParentState(s);
    Assert.assertEquals(sm,sm2);
    
    sm.setParentState(s2);
    Assert.assertEquals(false,sm.equals(sm2));
  }
  
  @Test
  public void findOrCreateFromInnerToOuter()
  {

    State outsideOn = new State("OutsideOn",sm);
    State on = new State("On",sm);
    
    StateMachine innerSm = new StateMachine("innerSm");
    outsideOn.addNestedStateMachine(innerSm);
    innerSm.findState("Off");
    State alsoOn = innerSm.findState("On");
    
    Assert.assertSame(on,alsoOn);
  }
  
  @Test
  public void getNestedStateMachines_none()
  {
    Assert.assertEquals(0,sm.getNestedStateMachines().size());
    new State("On",sm);
    Assert.assertEquals(0,sm.getNestedStateMachines().size());
  }

  @Test
  public void getNestedStateMachines_some()
  {
    State state1 = new State("state1",sm);
    State state2 = new State("state2",sm);
    new State("state3",sm);
    
    StateMachine innerSm1 = new StateMachine("innerSm1");
    state1.addNestedStateMachine(innerSm1);
    
    StateMachine innerSm2 = new StateMachine("innerSm2");
    state2.addNestedStateMachine(innerSm2);
    
    List<StateMachine> all = sm.getNestedStateMachines();
    Assert.assertEquals(2,all.size());
    Assert.assertEquals(innerSm1,all.get(0));
    Assert.assertEquals(innerSm2,all.get(1));
  }

  @Test
  public void getNestedStateMachines_nestedOfNested()
  {
    State state1 = new State("state1",sm);
    new State("state3",sm);
    
    StateMachine innerSm1 = new StateMachine("innerSm1");
    state1.addNestedStateMachine(innerSm1);

    State state2 = new State("state2",innerSm1);
    new State("state4",innerSm1);
    
    StateMachine innerSm2 = new StateMachine("innerSm2");
    state2.addNestedStateMachine(innerSm2);
    
    List<StateMachine> all = sm.getNestedStateMachines();
    Assert.assertEquals(2,all.size());
    Assert.assertEquals(innerSm1,all.get(0));
    Assert.assertEquals(innerSm2,all.get(1));
  }
  
  @Test
  public void getFullName()
  {
    StateMachine innerSm1 = new StateMachine("innerSm1");
    StateMachine innerSm2 = new StateMachine("innerSm2");

    State state1 = new State("state1",sm);
    state1.addNestedStateMachine(innerSm1);

    State state2 = new State("state2",innerSm1);
    state2.addNestedStateMachine(innerSm2);

    Assert.assertEquals("sm",sm.getFullName());
    Assert.assertEquals("smInnerSm1",innerSm1.getFullName());
    Assert.assertEquals("smInnerSm1InnerSm2",innerSm2.getFullName());
  }

  @Test
  public void addNullState()
  {
    State s = new State("s1",sm);
    State n = sm.addState("Null",0);
    
    Assert.assertEquals(2,sm.numberOfStates());
    Assert.assertEquals(n,sm.getState(0));
    Assert.assertEquals(s,sm.getState(1));
  }
  
}
