/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.util.List;

import org.junit.*;

import cruise.umple.util.*;

public class UmpleParserStateMachineTest
{
  UmpleParser parser;
  UmpleModel model;
  String pathToInput;
  String umpleParserName;

  @Before
  public void setUp()
  {
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
  }
  
  @Test
  public void stateMachineComments()
  {
    assertParse("100_stateMachineComments.ump","[inlineComment:one][inlineComment:two][classDefinition][name:LightFixture][inlineComment:three][inlineComment:four][stateMachine][inlineStateMachine][name:status][inlineComment:five][inlineComment:six][state][stateName:On][inlineComment:seven][inlineComment:eight][transition][event:flip][stateName:Off][inlineComment:nine][inlineComment:ten][state][stateName:Off][inlineComment:eleven][inlineComment:twelve]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("status", sm.getName());
    Assert.assertEquals(2, sm.numberOfStates());
    Assert.assertEquals("On",sm.getState(0).getName());
    Assert.assertEquals("Off",sm.getState(1).getName());
  }
  
  @Test
  public void transitionToUnknownState()
  {
    assertParse("100_transitionToUnknownState.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:Off]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    Assert.assertEquals(2, sm.numberOfStates());
    Assert.assertEquals("On",sm.getState(0).getName());
    Assert.assertEquals("Off",sm.getState(1).getName());
  }
  
  @Test
  public void oneStateNoEventStateMachine()
  {
    assertParse("100_emptyStateMachine.ump","[classDefinition][name:LightFixture][stateMachine][enum][name:bulb]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    Assert.assertEquals(0, sm.numberOfStates());
  }

  @Test
  public void oneState_StateMachine()
  {
    assertParse("100_oneState_StateMachine.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    Assert.assertEquals(1, sm.numberOfStates());
    State state = sm.getState(0);
    Assert.assertEquals("On", state.getName());
    Assert.assertEquals(0,state.numberOfTransitions());
    Assert.assertEquals(true,state.getIsStartState());
   
  }
  
  
  @Test
  public void oneStateOneEvent()
  {
    assertParse("100_oneStateOneEvent.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:On]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());

    Assert.assertEquals(1, sm.numberOfStates());
    State state = sm.getState(0);
    Assert.assertEquals("On", state.getName());

    Assert.assertEquals(1, state.numberOfTransitions());
    Transition t1 = state.getTransition(0);
    Assert.assertEquals("push", t1.getEvent().getName());
    Assert.assertEquals(state, t1.getNextState());
  }

  @Test
  public void oneStateTwoEvent()
  {
    assertParse("100_oneStateTwoEvent.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:On][transition][event:pull][stateName:On]");
  }
  
  @Test
  public void transitionAction()
  {
    assertParse("100_transitionAction.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][action][code:blabla][stateName:On]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);
    
    Transition t1 = state.getTransition(0);
    
    Action a1= t1.getAction();
    
    Assert.assertNotNull(a1);
    Assert.assertEquals("blabla", a1.getActionCode());
  }

  @Test
  public void doActivity() 
  {
    assertParse("100_doActivity.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][activity][code:iAmaDoActivity]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);
    
    Activity a1 = state.getActivity();
    Assert.assertEquals("iAmaDoActivity", a1.getActivityCode());
  }

  @Test
  public void transitionAfterDo()
  {
    assertParse("100_transition_after_do.ump","[classDefinition][name:Switch][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:press][stateName:Off][state][stateName:Off][autoTransition][activity][code:keepDoing;][stateName:On]");
	  
    UmpleClass c = model.getUmpleClass("Switch");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(1);

    Transition t = state.getTransition(0);
    Activity act = state.getActivity();
    Assert.assertNotNull(act);
    Assert.assertEquals("keepDoing;", act.getActivityCode());
    Assert.assertEquals(t.getEvent(), act.getOnCompletionEvent());
    Assert.assertEquals(false,t.isAutoTransition());
    Assert.assertEquals(true, t.getEvent().isAutoTransition());
  }
  
  @Test
  public void oneStateOneEntry()
  {
    assertParse("100_oneStateOneEntry.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][entryOrExitAction][type:entry][code:blahblah]");
  
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);
    
    Assert.assertEquals(1, state.numberOfActions());
    Action a1 = state.getAction(0);
    Assert.assertEquals("blahblah",a1.getActionCode());
    Assert.assertEquals("entry", a1.getActionType());
  
  }
  
  @Test
  public void oneStateManyEntry()
  {
    assertParse("100_oneStateManyEntry.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][entryOrExitAction][type:entry][code:blahblah][entryOrExitAction][type:entry][code:blahblah2][entryOrExitAction][type:exit][code:blahblahexit]");
  
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);
    
    Assert.assertEquals(3, state.numberOfActions());
    Action a1 = state.getAction(0);
    Assert.assertEquals("entry",a1.getActionType());
    Assert.assertEquals("blahblah",a1.getActionCode());

    Action a2 = state.getAction(1);
    Assert.assertEquals("entry",a2.getActionType());
    Assert.assertEquals("blahblah2",a2.getActionCode());

    Action a3 = state.getAction(2);
    Assert.assertEquals("exit",a3.getActionType());
    Assert.assertEquals("blahblahexit",a3.getActionCode());
    
  }  
  
  @Test
  public void oneStateOneExit()
  {
    assertParse("100_oneStateOneExit.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][entryOrExitAction][type:exit][code:blahblah][transition][event:push][stateName:On]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);
    
    Assert.assertEquals(1, state.numberOfActions());
    Action a1 = state.getAction(0);
    Assert.assertEquals("blahblah",a1.getActionCode());
    Assert.assertEquals("exit", a1.getActionType());
  }
  
  @Test
  public void twoStateNoEventStateMachine()
  {
    assertParse("100_twoState_StateMachine.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:Off]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());

    Assert.assertEquals(2, sm.numberOfStates());
    State state = sm.getState(0);
    Assert.assertEquals("On", state.getName());
    Assert.assertEquals(true, state.getIsStartState());

    state = sm.getState(1);
    Assert.assertEquals("Off", state.getName());
    Assert.assertEquals(false, state.getIsStartState());
  
  }
  
  @Test
  public void reuseEvents()
  {
    assertParse("100_reuseEvents.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());

    Assert.assertEquals(2, sm.numberOfStates());
    State state = sm.getState(0);
    Assert.assertEquals("On", state.getName());
    
    Assert.assertEquals(1, state.numberOfTransitions());
    Transition t1 = state.getTransition(0);
    Event flip1 = t1.getEvent();
    Assert.assertEquals("flip", flip1.getName());
  
    State state2 = sm.getState(1);
    Assert.assertEquals("Off", state2.getName());
    Assert.assertEquals(1, state2.numberOfTransitions());
    Transition t2 = state2.getTransition(0);
    Event flip2 = t2.getEvent();
    Assert.assertEquals("flip", flip2.getName());

    Assert.assertSame(flip1, flip2);
    Assert.assertEquals(1, sm.getEvents().size());
  }  
  
  @Test
  public void transitionNextState()
  {
    assertParse("100_reuseEvents.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());

    Assert.assertEquals(2, sm.numberOfStates());
    State onState = sm.getState(0);
    State offState = sm.getState(1);
    
    Assert.assertEquals("On", onState.getName());
    Assert.assertEquals("Off", offState.getName());
    
    Assert.assertEquals(1, onState.numberOfTransitions());
    Transition t1 = onState.getTransition(0);
    Assert.assertEquals(onState, t1.getFromState());
    Assert.assertEquals(offState, t1.getNextState());
    
    Assert.assertEquals(1, offState.numberOfTransitions());
    Transition t2 = offState.getTransition(0);
    Assert.assertEquals(offState, t2.getFromState());
    Assert.assertEquals(onState, t2.getNextState());
    
  }
  
  @Test
  public void oneStateOneGuardAfter()
  {
    assertParse("100_oneGuardAfter.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:brightness][value:0][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][guard][numExpr][constraintName][name:brightness][smallerOp:<][number:1][event:push][stateName:Off][state][stateName:Off]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
 
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    
    State on = sm.getState(0);
    Assert.assertEquals("On",on.getName());
    
    Transition t = on.getTransition(0);
    Assert.assertEquals("push", t.getEvent().getName());
    Assert.assertEquals("if (brightness<1)\n{", t.getGuard().getCondition(new JavaGenerator()));
  }
  
  @Test
  public void oneStateOneGuardBefore()
  {
                            
    assertParse("100_oneGuardBefore.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:brightness][value:0][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][guard][numExpr][constraintName][name:brightness][smallerOp:<][number:1][stateName:Off][state][stateName:Off]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    
    State on = sm.getState(0);
    Assert.assertEquals("On",on.getName());
    
    Transition t = on.getTransition(0);
    Assert.assertEquals("push", t.getEvent().getName());
    Assert.assertEquals("if (brightness<1)\n{", t.getGuard().getCondition(new JavaGenerator()));
  }
  
  @Test
  public void emptyAndNonEmptyStates()
  {
    assertParse("100_emptyAndNonEmptyStates.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("status", sm.getName());

    Assert.assertEquals(2, sm.numberOfStates());
    State onState = sm.getState(0);
    State offState = sm.getState(1);
    
    Assert.assertEquals("On", onState.getName());
    Assert.assertEquals("Off", offState.getName());
    
    Assert.assertEquals(1, onState.numberOfTransitions());
    Transition t1 = onState.getTransition(0);
    Assert.assertEquals(onState, t1.getFromState());
    Assert.assertEquals(offState, t1.getNextState());
    Assert.assertEquals("flip", t1.getEvent().getName());
    
    Assert.assertEquals(0, offState.numberOfTransitions());
    
  }  

  @Test
  public void sameEvent_TwoStates()
  {
	  assertParse("100_sameEvent_twoStates.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On][stateMachine][inlineStateMachine][name:AnotherBulb][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On]");
	  
	  UmpleClass c = model.getUmpleClass("LightFixture");
	    StateMachine sm = c.getStateMachine(0);
	    Assert.assertEquals("bulb", sm.getName());

	    Assert.assertEquals(2, sm.numberOfStates());
	    State onState = sm.getState(0);
	    State offState = sm.getState(1);
	    
	    Assert.assertEquals("On", onState.getName());
	    Assert.assertEquals("Off", offState.getName());
	    
	    Assert.assertEquals("flip", onState.getTransition(0).getEvent().getName());
	    Assert.assertEquals("flip", offState.getTransition(0).getEvent().getName());
  }
  
  
  @Test
  public void Nested_oneState()
  {
    assertParse("101_Nested_oneState.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:Off]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    StateMachine innerSm = on.getNestedStateMachine(0);
    State off = innerSm.getState(0);
    
    Assert.assertEquals("On",innerSm.getName());
    Assert.assertEquals("On",on.getName());
    Assert.assertEquals("Off",off.getName());
  }
  
  @Test
  public void Nested_TwoStates()
  {
    assertParse("101_Nested_twoStates.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:Off][state][stateName:On][transition][event:push][stateName:Off]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    StateMachine innerSm = on.getNestedStateMachine(0);
    State off = innerSm.getState(0);
    State innerOn = innerSm.getState(1);
    
    Assert.assertEquals("On",innerSm.getName());
    Assert.assertEquals("On",on.getName());
    Assert.assertEquals("Off",off.getName());
    Assert.assertEquals("On",innerOn.getName());
  }
  
  @Test
  public void Nested_TwoStatesComplex()
  {
    assertParse("101_Nested_twoStatesComplex.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:OutsideOn][transition][event:push][stateName:On][state][stateName:Off][state][stateName:On][transition][event:push][stateName:Off][transition][event:pull][stateName:OutsideOff][state][stateName:OutsideOff]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    State off = sm.getState(1);

    Assert.assertEquals(2,sm.numberOfStates());
    Assert.assertEquals("OutsideOn",on.getName());
    Assert.assertEquals("OutsideOff",off.getName());

    StateMachine innerSm = on.getNestedStateMachine(0);
    State innerOff = innerSm.getState(0);
    State innerOn = innerSm.getState(1);

    
    Assert.assertEquals("OutsideOn",innerSm.getName());
    Assert.assertEquals("Off",innerOff.getName());
    Assert.assertEquals("On",innerOn.getName());    
    
  }
  
  @Test
  public void Nested_realExample2()
  {
    assertParse("101_Nested_realExample2.ump","[classDefinition][name:StrobeLight][stateMachine][inlineStateMachine][name:dvdPlayer][state][stateName:Off][transition][event:turnOn][stateName:On][state][stateName:Sleep][transition][event:wake][stateName:Pause][state][stateName:On][transition][event:turnOff][stateName:Off][state][stateName:Play][transition][event:push][stateName:Pause][state][stateName:Pause][transition][event:push][stateName:Play][transition][event:standby][stateName:Sleep]");

    
  }

  @Test
  public void Concurrent_NoSm()
  {
    assertParse("103_Concurrent_NoSm.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][||:||]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    Assert.assertEquals(0,on.numberOfNestedStateMachines());
  }

  @Test
  public void Concurrent_OneSm()
  {
    assertParse("103_Concurrent_OneSm.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:A][||:||]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    Assert.assertEquals(1,on.numberOfNestedStateMachines());
    StateMachine innerSm = on.getNestedStateMachine(0);
    Assert.assertEquals(false,on.getIsConcurrent());
    Assert.assertEquals("A",innerSm.getName());
    Assert.assertEquals(1,innerSm.numberOfStates());
    Assert.assertEquals("A",innerSm.getState(0).getName());
  }
  

  @Test
  public void Concurrent_TwoSm()
  {
    assertParse("103_Concurrent_TwoSm.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:A][state][stateName:B][||:||][state][stateName:C][state][stateName:D]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    Assert.assertEquals(2,on.numberOfNestedStateMachines());
    StateMachine innerSm = on.getNestedStateMachine(0);
    StateMachine innerSm2 = on.getNestedStateMachine(1);

    Assert.assertEquals(true,on.getIsConcurrent());

    Assert.assertEquals("A",innerSm.getName());
    Assert.assertEquals(2,innerSm.numberOfStates());
    Assert.assertEquals("A",innerSm.getState(0).getName());
    Assert.assertEquals("B",innerSm.getState(1).getName());

    Assert.assertEquals("C",innerSm2.getName());
    Assert.assertEquals(2,innerSm2.numberOfStates());
    Assert.assertEquals("C",innerSm2.getState(0).getName());
    Assert.assertEquals("D",innerSm2.getState(1).getName());
    
  
  }
  
  
  @Test
  public void stateMachineDefinition()
  {
    assertParse("200_stateMachineDefinition.ump","[stateMachineDefinition][name:myname][state][stateName:On][transition][event:push][stateName:Off][state][stateName:Off]");

    StateMachine sm = model.getStateMachineDefinition(0);
    
    Assert.assertEquals("myname", sm.getName());
    Assert.assertEquals("On",sm.getState(0).getName());
    Assert.assertEquals("Off",sm.getState(1).getName());
    
    Assert.assertEquals("Off", sm.getState(0).getTransition(0).getNextState().getName());
    Assert.assertEquals(true, sm.getState(0).hasTransitions());
  }
  
  @Test
  public void stateMachineManyTransitionsToUndefinedStates()
  {
    assertParse("101_Nested_manyTransitions.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:OutsideOn][transition][event:push][stateName:On][transition][event:pull][stateName:On][state][stateName:Off][state][stateName:On][transition][event:push][stateName:Off][transition][event:pull][stateName:OutsideOff][state][stateName:OutsideOff]");
    StateMachine sm = model.getUmpleClass("LightFixture").getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    
    Assert.assertEquals(2,sm.numberOfStates());
    Assert.assertEquals("OutsideOn",sm.getState(0).getName());
    Assert.assertEquals("OutsideOff",sm.getState(1).getName());
    State s = sm.getState(0);
    StateMachine innerSm = s.getNestedStateMachine(0);
    Assert.assertEquals(2,innerSm.numberOfStates());
    Assert.assertEquals("Off",innerSm.getState(0).getName());
    Assert.assertEquals("On",innerSm.getState(1).getName());

  }
  
  @Test
  public void twoStateMachinesSameEvent()
  {
    assertParse("102_twoStateMachinesSameEvent.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:On][transition][event:flip][stateName:On][stateMachine][inlineStateMachine][name:anotherBulb][state][stateName:Off][transition][event:push][stateName:Off]");

    StateMachine sm1 = model.getUmpleClass("LightFixture").getStateMachine(0);
    StateMachine sm2 = model.getUmpleClass("LightFixture").getStateMachine(1);
    
    Event e1 = sm1.getEvent("push");
    Event alsoE1 = sm2.getEvent("push");
    
    Assert.assertSame(e1, alsoE1);
  }  
  
  
  @Test
  public void OnOffTimer()
  {
    assertParse("200_OnOffTimer.ump","[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:Off][state][stateName:Off][transition][timer:5][stateName:On]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    Assert.assertEquals("On",sm.getState(0).getName());
    Assert.assertEquals("Off",sm.getState(1).getName());
    
    Assert.assertEquals("Complex",sm.getType());
    
    List<Event> allEvents = sm.getEvents();
    Assert.assertEquals(2,allEvents.size());
    
    Event e = sm.getEvent("timeoutOffToOn");
    
    Assert.assertEquals("timeoutOffToOn",e.getName());
    Assert.assertEquals(true,e.getIsTimer());
    Assert.assertEquals("5",e.getTimerInSeconds());
  }
  
  @Test
  public void stateMachineDefinition_reference()
  {
    assertParse("200_stateMachineDefinition_reference.ump","[stateMachineDefinition][name:OnOffSwitch][state][stateName:On][transition][event:push][stateName:Off][state][stateName:Off][transition][event:push][stateName:On][classDefinition][name:Lightbulb][stateMachine][referencedStateMachine][name:fixture][definitionName:OnOffSwitch]");

    StateMachine sm = model.getStateMachineDefinition(0);
    
    Assert.assertEquals("OnOffSwitch", sm.getName());
    Assert.assertEquals("On",sm.getState(0).getName());
    Assert.assertEquals("Off",sm.getState(1).getName());
    
    Assert.assertEquals("Off", sm.getState(0).getTransition(0).getNextState().getName());
    Assert.assertEquals("On", sm.getState(1).getTransition(0).getNextState().getName());
    
    UmpleClass lightbulb = model.getUmpleClass("Lightbulb");
    Assert.assertEquals(1,lightbulb.numberOfStateMachines());
    
    sm = lightbulb.getStateMachine(0);
    Assert.assertEquals("fixture", sm.getName());
    Assert.assertEquals("On",sm.getState(0).getName());
    Assert.assertEquals("Off",sm.getState(1).getName());
    
    Assert.assertEquals("Off", sm.getState(0).getTransition(0).getNextState().getName());
    Assert.assertEquals("On", sm.getState(1).getTransition(0).getNextState().getName());
  }  

  @Test
  public void reusingEventsInNestedStateMachines()
  {
    assertParse("200_reusingEventsInNestedStateMachines.ump","[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:status][state][stateName:S1][transition][event:e1][stateName:S1A][state][stateName:S1A][transition][event:e1][stateName:S1]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    
    List<Event> allEvents = sm.getEvents();
    Assert.assertEquals(1,allEvents.size());
    Assert.assertEquals("e1",allEvents.get(0).getName());
    Assert.assertEquals(1,uClass.getEvents().size());
  }
  
  @Test
  public void finalState()
  {
    assertParse("211_finalState.ump","[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:Off][state][final:final][stateName:Off]");
    
    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State s1 = sm.findState("On");
    Assert.assertEquals(false,s1.isFinalState());
    
    State s2 = sm.findState("Off");
    Assert.assertEquals(true,s2.isFinalState());
  }
  
  @Test
  public void finalStateReservedWord()
  {
    assertParse("211_finalStateReservedWord.ump","[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:Final][state][stateName:Final]");
    
    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State s1 = sm.findState("On");
    Assert.assertEquals(false,s1.isFinalState());
    
    State s2 = sm.findState("Final");
    Assert.assertEquals("Final",s2.getName());
    Assert.assertEquals(true,s2.isFinalState());
  }
  
  @Test
  public void concurrentFinals()
  {
    assertParse("211_concurrentFinals.ump","[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:MotorIdle][transition][event:flip][stateName:Final][||:||][state][stateName:FanIdle][transition][event:flop][stateName:Final]");
    
    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State on = sm.findState("On");
    State motorFinal = on.getNestedStateMachine(0).findState("Final");
    State fanFinal = on.getNestedStateMachine(1).findState("Final");
    
    Assert.assertNotSame(motorFinal, fanFinal);
    Assert.assertEquals(true,motorFinal.isFinalState());
    Assert.assertEquals(true,fanFinal.isFinalState());
  }
  
  @Test
  public void finalStateInOneConcurrentRegion()
  {
    assertParse("211_finalState_inOneConcurrentRegion.ump","[classDefinition][name:Dryer][stateMachine][inlineStateMachine][name:status][state][stateName:On][state][stateName:Rotating][transition][event:dryingCompleted][stateName:Final][||:||][state][stateName:Heating][transition][event:fire][stateName:Off][state][stateName:Off]");
    
    UmpleClass uClass = model.getUmpleClass("Dryer");

    State state = uClass.getStateMachine(0).findState("On").getNestedStateMachine(0).findState("Final");
    Assert.assertEquals(true,state.isFinalState());
  
    state = uClass.getStateMachine(0).findState("On").getNestedStateMachine(1).findState("Final");
    Assert.assertEquals(null,state);

  }
  
  @Test
  public void finalStateInTwoConcurrentRegions()
  {
    assertParse("211_finalState_inTwoConcurrentRegions.ump","[classDefinition][name:Dryer][stateMachine][inlineStateMachine][name:status][state][stateName:On][state][stateName:Rotating][transition][event:dryingCompleted][stateName:Final][||:||][state][stateName:Heating][transition][event:dryingCompleted][stateName:Final][transition][event:fire][stateName:Off][state][stateName:Off]");

    UmpleClass uClass = model.getUmpleClass("Dryer");

    State final1 = uClass.getStateMachine(0).findState("On").getNestedStateMachine(0).findState("Final");
    Assert.assertEquals(true,final1.isFinalState());
  
    State final2 = uClass.getStateMachine(0).findState("On").getNestedStateMachine(1).findState("Final");
    Assert.assertEquals(true,final2.isFinalState());

    Assert.assertNotSame(final1, final2);
  }
  
  @Test
  public void finalStateNoAction()
  {
    assertParse("211_finalState_noAction.ump","[classDefinition][name:DVDplayer][stateMachine][inlineStateMachine][name:DVDplayerStatus][state][stateName:NormalOperation][state][stateName:On][state][stateName:Playing][transition][event:stop][stateName:Stopped][state][stateName:Stopped][transition][event:play][stateName:Playing][transition][event:pause][stateName:Paused][state][stateName:history][state][stateName:Off][transition][event:turnOn][stateName:Final]");

    UmpleClass uClass = model.getUmpleClass("DVDplayer");
    State final1 = uClass.getStateMachine(0).findState("NormalOperation").getNestedStateMachine(0).findState("Final");
    Assert.assertEquals(true,final1.isFinalState());
  }

  @Test
  public void finalStateWithAction()
  {
    assertParse("211_finalState_withAction.ump","[classDefinition][name:DVDplayer][stateMachine][inlineStateMachine][name:DVDplayerStatus][state][stateName:NormalOperation][state][stateName:On][state][stateName:Playing][transition][event:stop][stateName:Stopped][state][stateName:Stopped][transition][event:play][stateName:Playing][transition][event:pause][stateName:Paused][state][stateName:history][state][stateName:Off][transition][event:turnOn][action][code:actionCode][stateName:Final]");

    UmpleClass uClass = model.getUmpleClass("DVDplayer");
    State final1 = uClass.getStateMachine(0).findState("NormalOperation").getNestedStateMachine(0).findState("Final");
    Assert.assertEquals(true,final1.isFinalState());
  }

  @Test
  public void addEvent()
  {
    assertParse("212_mixin_addEvent.ump","[stateMachineDefinition][name:Machine][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][classDefinition][name:OnOffSwitch][stateMachine][referencedStateMachine][name:bulb][definitionName:Machine][extendedStateMachine][state][stateName:On][changeType:+][transition][event:push][stateName:On]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State on = sm.findState("On");
    Assert.assertEquals(2,on.numberOfTransitions());
  }
  

  @Test
  public void removeEvent()
  {
    assertParse("212_mixin_removeEvent.ump","[stateMachineDefinition][name:Machine][state][stateName:On][transition][event:flip][stateName:Off][transition][event:flop][stateName:Off][state][stateName:Off][classDefinition][name:OnOffSwitch][stateMachine][referencedStateMachine][name:bulb][definitionName:Machine][extendedStateMachine][state][stateName:On][changeType:-][transition][event:flip][stateName:Off]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State on = sm.findState("On");
    Assert.assertEquals(1,on.numberOfTransitions());
    Assert.assertEquals("flop", on.getTransition(0).getEvent().getName());
  }

  @Test
  public void removeState()
  {
    assertParse("212_mixin_removeState.ump","[stateMachineDefinition][name:Machine][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][classDefinition][name:OnOffSwitch][stateMachine][referencedStateMachine][name:bulb][definitionName:Machine][extendedStateMachine][changeType:-][state][stateName:Off]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State on = sm.findState("On");
    State off = sm.findState("Off");
    Assert.assertEquals(0,on.numberOfTransitions());
    Assert.assertEquals(null,off);
  }

  
  @Test
  public void autoTransition_simple()
  {
    assertParse("104_autoTransition.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][autoTransition][stateName:Off][state][stateName:Off]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    
    State s = sm.getState(0);
    Assert.assertEquals("On", s.getName());
    Transition t = s.getTransition(0);
    Assert.assertEquals(true,t.isAutoTransition());
    
    Event autoEvent = t.getEvent();
    Assert.assertEquals(true, autoEvent.isAutoTransition());
  }
  
  @Test
  public void autoTransition_existingEntryAction()
  {
    assertParse("104_autoTransitionWithExistingEntryAction.ump","[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][entryOrExitAction][type:entry][code:doSomething();][autoTransition][stateName:Off][state][stateName:Off]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    
    State s = sm.getState(0);
    Assert.assertEquals(1,s.numberOfActions());
  }
  
  @Test
  public void autoTransition_guard()
  {
    assertParse("104_autoTransitionWithGuard.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:count][stateMachine][inlineStateMachine][name:bulb][state][stateName:Off][autoTransition][guard][numExpr][constraintName][name:count][moreOp:>][number:10][stateName:On][state][stateName:On]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    
    State s = sm.getState(0);
    Assert.assertEquals("Off", s.getName());
    Transition t = s.getTransition(0);
    Assert.assertEquals(true,t.isAutoTransition());
    Assert.assertEquals("if (count>10)\n{", t.getGuard().getCondition(new JavaGenerator()));
  }  

  @Test
  public void transitionWithGuardAndAction()
  {
                            
    assertParse("100_transitionWithGuardAndAction.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:brightness][value:0][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][guard][numExpr][constraintName][name:brightness][smallerOp:<][number:1][action][code:blabla][stateName:Off][state][stateName:Off]");
    
    UmpleClass c = model.getUmpleClass("LightFixture");
    
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    
    State on = sm.getState(0);
    Assert.assertEquals("On",on.getName());
    
    Transition t = on.getTransition(0);
    Assert.assertEquals("push", t.getEvent().getName());
    Assert.assertEquals("if (brightness<1)\n{", t.getGuard().getCondition(new JavaGenerator()));

    Action a1= t.getAction();
    
    Assert.assertNotNull(a1);
    Assert.assertEquals("blabla", a1.getActionCode());
  }

  
  @Test
  public void eventWithArgument()
  {
	  assertParse("100_eventWithArgument.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:brightness][value:0][stateMachine][inlineStateMachine][name:bulb][state][stateName:Off][transition][event:turnDimmer][parameterList][parameter][type:Integer][name:lightval][action][code:setBrightness(lightval)][stateName:Off][transition][event:flipSwitch][stateName:Dimmed][state][stateName:Dimmed][transition][event:entry][guard][numExpr][constraintName][name:dimmer][moreOp:>][number:99][stateName:On][transition][event:flipSwitch][stateName:Off][transition][event:turnDimmer][parameterList][parameter][type:Integer][name:lightval][action][code:setBrightness(lightval)][stateName:Dimmed][state][stateName:On][transition][event:flipSwitch][stateName:Off][transition][event:turnDimmer][parameterList][parameter][type:Integer][name:lightval][action][code:setBrightness(lightval)][stateName:Dimmed]");
	  UmpleClass c = model.getUmpleClass("LightFixture");
	    
	  StateMachine sm = c.getStateMachine(0);
	  State off = sm.getState(0);
	  Event turnDimmer = off.getTransition(0).getEvent();
	  Event flipSwitch = off.getTransition(1).getEvent();
	  Assert.assertEquals("Integer lightval", turnDimmer.getArgs());
	  Assert.assertEquals("", flipSwitch.getArgs());
  }
  
  @Test
  public void eventsWithInconsistentArguments(){
	  assertFailedParse("100_eventWithInconsistentArguments.ump", new Position("100_eventWithInconsistentArguments.ump", 13,8,248), 51);
  }
  
  @Test
  public void transitionsWithUndeclaredState(){
	  //Make sure it it parses correctly when states in transitions have been declared
	  assertParse("105_transitionUsingDeclaredState.ump","[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:state1][transition][event:e1][stateName:state2][state][stateName:state2][transition][event:e2][stateName:state3][state][stateName:state3][transition][event:e3][stateName:state1]");
	  assertParse("105_multipleTransitionsUsingDeclaredState.ump","[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:state1][transition][event:e1][stateName:state2][state][stateName:state2][transition][event:e2][stateName:state4][state][stateName:state3][transition][event:e3][stateName:state4][state][stateName:state4][transition][event:e4][stateName:state3]");
	  //Make sure it throws an warning when a state in a transition has not been declared.
	  assertHasWarning("105_transitionUsingUndeclaredState.ump", 0, 50, new Position("105_transitionUsingUndeclaredState.ump", 7, 6, 75));
	  assertHasWarning("105_multipleTransitionsUsingUndeclaredState.ump", 0, 50, new Position("105_multipleTransitionsUsingUndeclaredState.ump", 7, 6, 75));
	  assertHasWarning("105_multipleTransitionsUsingUndeclaredState.ump", 1, 50, new Position("105_multipleTransitionsUsingUndeclaredState.ump", 10, 6, 113));
  }
  
  @Test
  public void stateMachineWithInvalidName(){
	  assertFailedParse("106_invalidStateMachineNamePartAmper.ump", new Position("106_invalidStateMachineNamePartAmper.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNamePartDollar.ump", new Position("106_invalidStateMachineNamePartDollar.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNamePartDot.ump", new Position("106_invalidStateMachineNamePartDot.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNamePartExclaim.ump", new Position("106_invalidStateMachineNamePartExclaim.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNamePartQuest.ump", new Position("106_invalidStateMachineNamePartQuest.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNamePartQuote.ump", new Position("106_invalidStateMachineNamePartQuote.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNameStartAmper.ump", new Position("106_invalidStateMachineNameStartAmper.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNameStartDollar.ump", new Position("106_invalidStateMachineNameStartDollar.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNameStartDot.ump", new Position("106_invalidStateMachineNameStartDot.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNameStartExclaim.ump", new Position("106_invalidStateMachineNameStartExclaim.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNameStartQuest.ump", new Position("106_invalidStateMachineNameStartQuest.ump", 2, 2, 12), 150);
	  assertFailedParse("106_invalidStateMachineNameStartQuote.ump", new Position("106_invalidStateMachineNameStartQuote.ump", 2, 2, 12), 150);
  }
  
  @Test
  public void stateWithInvalidName(){
	  assertFailedParse("106_invalidStateNamePartAmper.ump", new Position("106_invalidStateNamePartAmper.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNamePartDollar.ump", new Position("106_invalidStateNamePartDollar.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNamePartDot.ump", new Position("106_invalidStateNamePartDot.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNamePartExclaim.ump", new Position("106_invalidStateNamePartExclaim.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNamePartQuest.ump", new Position("106_invalidStateNamePartQuest.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNamePartQuote.ump", new Position("106_invalidStateNamePartQuote.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNameStartAmper.ump", new Position("106_invalidStateNameStartAmper.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNameStartDollar.ump", new Position("106_invalidStateNameStartDollar.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNameStartDot.ump", new Position("106_invalidStateNameStartDot.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNameStartExclaim.ump", new Position("106_invalidStateNameStartExclaim.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNameStartQuest.ump", new Position("106_invalidStateNameStartQuest.ump", 3, 4, 21), 152);
	  assertFailedParse("106_invalidStateNameStartQuote.ump", new Position("106_invalidStateNameStartQuote.ump", 3, 4, 21), 152);
	
  }
  
  @Test
  public void queuedStateMachine()
  {
                            
    assertParse("108_queuedStateMachine.ump","[classDefinition][name:QueuedSM][stateMachine][inlineStateMachine][queued:queued][name:sm][state][stateName:State1][transition][event:e1][stateName:State2][state][stateName:State2][transition][event:e2][stateName:State1]");
    
    UmpleClass c = model.getUmpleClass("QueuedSM");
    StateMachine sm = c.getStateMachine(0);
    
    Assert.assertEquals(true,sm.isQueued());
    Assert.assertEquals("sm", sm.getName());
   
    Assert.assertEquals(2, sm.numberOfStates());
    State state1 = sm.getState(0);
    Assert.assertEquals("State1", state1.getName());
    Assert.assertEquals(1, state1.numberOfTransitions());
    Transition t1 = state1.getTransition(0);
    Event event1 = t1.getEvent();
    Assert.assertEquals("e1", event1.getName());

    State state2 = sm.getState(1);
    Assert.assertEquals("State2", state2.getName());
    Assert.assertEquals(1, state2.numberOfTransitions());
    Transition t2 = state2.getTransition(0);
    Event event2 = t2.getEvent();
    Assert.assertEquals("e2", event2.getName());
  }
 
  @Test
  public void malformedStateMachine(){
	  assertHasWarning("107_badStateMachineSyntaxBrokenArrow.ump", 0, 1006, new Position("107_badStateMachineSyntaxBrokenArrow.ump", 4, 2, 45));
	  assertHasWarning("107_badStateMachineSyntaxEmptyCodeBlock.ump", 0, 1006, new Position("107_badStateMachineSyntaxEmptyCodeBlock.ump", 4, 2, 45));
	//  assertHasWarning("107_badStateMachineSyntaxEmptyGuard.ump", 0, 1006, new Position("107_badStateMachineSyntaxEmptyGuard.ump", 4, 2, 45));
	  assertHasWarning("107_badStateMachineSyntaxMisplacedAttribute.ump", 0, 1006, new Position("107_badStateMachineSyntaxMisplacedAttribute.ump", 3, 2, 16));
	  assertHasWarning("107_badStateMachineSyntaxMisplacedGuard.ump", 0, 1006, new Position("107_badStateMachineSyntaxMisplacedGuard.ump", 4, 2, 45));
	  assertHasWarning("107_badStateMachineSyntaxMissingForwardSlash.ump", 0, 1006, new Position("107_badStateMachineSyntaxMissingForwardSlash.ump", 4, 2, 45));
	  assertHasWarning("107_badStateMachineSyntaxMissingSemiColon.ump", 0, 1006, new Position("107_badStateMachineSyntaxMissingSemiColon.ump", 4, 2, 45));
	  assertHasWarning("107_badStateMachineSyntaxMissmatchedBrackets.ump", 0, 1006, new Position("107_badStateMachineSyntaxMissmatchedBrackets.ump", 4, 2, 45));
  }
  @Test
	public void semicolonStateMachine() {
		assertParse(
				"379_semicolon_extracode.ump",
				"[classDefinition][name:CourseX][stateMachine][inlineStateMachine][name:status][state][stateName:Open][entryOrExitAction][type:entry][code:System.out.println(\"Enter open\");]");
		UmpleClass c = model.getUmpleClass("CourseX");
		StateMachine sm = c.getStateMachine(0);

		Assert.assertEquals("status", sm.getName());

		Assert.assertEquals(1, sm.numberOfStates());
		State state1 = sm.getState(0);
		Assert.assertEquals("Open", state1.getName());
		Assert.assertEquals(0, state1.numberOfTransitions());
		Assert.assertEquals(true, state1.getHasEntryAction());
	}
  private void assertParse(String filename, String expectedOutput)
  {
    assertParse(filename, expectedOutput, true);
  }

  public void assertFailedParse(String filename, Position expectedPosition, int expectedError)
  {
	    String input = SampleFileWriter.readContent(new File(pathToInput, filename));
	    model = new UmpleModel(new UmpleFile(pathToInput,filename));
	    model.setShouldGenerate(false);
	    parser = UmpleParserFactory.create(umpleParserName,model,true);
	    boolean answer = parser.parse("program", input).getWasSuccess();
	    
	    if (answer)
	    {
	      answer = parser.analyze(false).getWasSuccess();
	    }
	    
	  Assert.assertEquals(answer, false);
	  //Assert.assertEquals(true, parser.getParseResult().getHasWarnings());
	  Assert.assertNotNull(parser.getParseResult().getErrorMessage(0));
	  Assert.assertEquals(expectedError, parser.getParseResult().getErrorMessage(0).getErrorType().getErrorCode());
	  System.err.println(expectedPosition.getOffset()+" "+parser.getParseResult().getErrorMessage(0).getPosition().getOffset());
	  Assert.assertEquals(expectedPosition, parser.getParseResult().getErrorMessage(0).getPosition());
  }
  
  private void assertHasWarning(String filename, int expectedWarningIndex, int expectedError, Position expectedPosition){
	    String input = SampleFileWriter.readContent(new File(pathToInput, filename));
	    model = new UmpleModel(new UmpleFile(pathToInput,filename));
	    model.setShouldGenerate(false);
	    parser = UmpleParserFactory.create(umpleParserName,model,true);
	    boolean answer = parser.parse("program", input).getWasSuccess();
	    
	    if (answer)
	    {
	      answer = parser.analyze(false).getWasSuccess();
	    }

	    if (answer == false)
	    {
	      System.out.println("failed at:" + parser.getParseResult().getPosition());
	    }
	    
	  Assert.assertEquals(answer, true);
	  Assert.assertEquals(true, parser.getParseResult().getHasWarnings());
	  Assert.assertNotNull(parser.getParseResult().getErrorMessage(expectedWarningIndex));
	  Assert.assertEquals(expectedError, parser.getParseResult().getErrorMessage(expectedWarningIndex).getErrorType().getErrorCode());
	  Assert.assertEquals(expectedPosition, parser.getParseResult().getErrorMessage(expectedWarningIndex).getPosition());
  }
  
  private void assertParse(String filename, String expectedOutput, boolean expected)
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, filename));
    model = new UmpleModel(new UmpleFile(pathToInput,filename));
    model.setShouldGenerate(false);
    parser = UmpleParserFactory.create(umpleParserName,model,true);
    boolean answer = parser.parse("program", input).getWasSuccess();
    
    if (answer)
    {
      answer = parser.analyze(false).getWasSuccess();
    }

    if (answer == false && expected)
    {
      System.out.println("failed at:" + parser.getParseResult().getPosition());
    }
    
    Assert.assertEquals(expected, answer);
    if (expected)
    {
      Assert.assertEquals(expectedOutput, parser.toString());  
    }
  }
  
  
}
