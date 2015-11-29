/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

 */

package cruise.umple.compiler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import cruise.umple.parser.analysis.RuleBasedParser;
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
  public void handleBangInAttribute()
  {
    assertParse("100_bangAttribute.ump", "[classDefinition][name:LightFixture][attribute][type:Integer][name:age][invariant][loneBoolean][negativeConstraint][constraintBody][numExpr][constraintName][name:age][moreOp:>][number:18]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfAttributes());
    Attribute attr = c.getAttribute(0);
    Assert.assertEquals(1, c.numberOfConstraintTrees());

    ConstraintTree ctree = c.getConstraintTree(0);
    JavaGenerator gen = new JavaGenerator();
    gen.setModel(model);

    Assert.assertEquals("(getAge()<=18)", ctree.getValue(gen));
    
    ctree.setDisplayNegation(true);
    Assert.assertEquals("!(getAge()<=18)", ctree.getValue(gen));

    ctree.setDisplayNegation(false);
    Assert.assertEquals("(getAge()<=18)", ctree.getValue(gen));
  }

  // Issue 656
  @Test
  public void handleBangInGuard()
  {
    assertParse("100_bangGuard.ump", "[classDefinition][name:LightFixture][attribute][type:boolean][name:flag][value:false][stateMachine][inlineStateMachine][name:status][state][stateName:on][transition][event:turnOff][guard][loneBoolean][negativeConstraint][constraintName][name:getFlag][constraintParameterList][stateName:off][state][stateName:off][transition][event:turnOn][stateName:on]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("status", sm.getName());
    State state1 = sm.getState(0);
    Assert.assertEquals(2, sm.numberOfStates());
    // Assert.assertEquals(0,state.numberOfTransitions());
    Transition t1 = state1.getTransition(0);
    Event event1 = t1.getEvent();
    Assert.assertEquals("turnOff", event1.getName());
    JavaGenerator gen = new JavaGenerator();
    gen.setModel(model);
    
    Assert.assertEquals("if (!getFlag())\n{\n  {0}\n}", gen.translate("on", t1.getGuard()));
  }

  // Issue 492
  @Test
  public void nonReachableState()
  {
    assertNoWarnings("100_nonReachableState6.ump");

    assertHasWarning("100_nonReachableState2.ump", 1, 67, new Position("100_nonReachableState2.ump", 13, 6, 140));

    for (ErrorMessage er : parser.getParseResult().getErrorMessages())
      System.out.println(er.getFormattedMessage());

    assertHasWarning("100_nonReachableState4.ump", 0, 67, new Position("100_nonReachableState4.ump", 5, 5, 52));
    for (ErrorMessage er : parser.getParseResult().getErrorMessages())
      System.out.println(er.getFormattedMessage());

    assertHasWarning("100_nonReachableState3.ump", 0, 67, new Position("100_nonReachableState3.ump", 5, 5, 52));
    for (ErrorMessage er : parser.getParseResult().getErrorMessages())
      System.out.println(er.getFormattedMessage());

    // Enum does not raise warning about unreachable state
    assertNoWarnings("100_nonReachableState.ump");
    for (ErrorMessage er : parser.getParseResult().getErrorMessages())
      System.out.println(er.getFormattedMessage());

    assertHasWarning("100_nonReachableState5.ump", 0, 67, new Position("100_nonReachableState5.ump", 11, 8, 106));
    for (ErrorMessage er : parser.getParseResult().getErrorMessages())
      System.out.println(er.getFormattedMessage());

    assertHasWarning("100_nonReachableState7.ump", 0, 67, new Position("100_nonReachableState7.ump", 7, 4, 56));
    for (ErrorMessage er : parser.getParseResult().getErrorMessages())
      System.out.println(er.getFormattedMessage());

    assertNoWarnings("100_nonReachableState8.ump");
    for (ErrorMessage er : parser.getParseResult().getErrorMessages())
      System.out.println(er.getFormattedMessage());
  }

  @Test
  public void stateMachineComments()
  {
    assertParse("100_stateMachineComments.ump", "[inlineComment:one][inlineComment:two][classDefinition][name:LightFixture][inlineComment:three][inlineComment:four][stateMachine][inlineStateMachine][name:status][inlineComment:five][inlineComment:six][state][stateName:On][inlineComment:seven][inlineComment:eight][transition][event:flip][stateName:Off][inlineComment:nine][inlineComment:ten][state][stateName:Off][inlineComment:eleven][inlineComment:twelve]");
    Assert.assertEquals(1, model.numberOfUmpleClasses());
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("status", sm.getName());
    Assert.assertEquals(2, sm.numberOfStates());
    Assert.assertEquals("On", sm.getState(0).getName());
    Assert.assertEquals("Off", sm.getState(1).getName());
  }

  @Test
  public void transitionToUnknownState()
  {
    assertParse("100_transitionToUnknownState.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:Off]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    Assert.assertEquals(2, sm.numberOfStates());
    Assert.assertEquals("On", sm.getState(0).getName());
    Assert.assertEquals("Off", sm.getState(1).getName());

    assertHasWarning("100_transitionToUnknownState2.ump.ump", 0, 68, new Position("100_transitionToUnknownState2.ump.ump", 9, 8, 57));
    assertHasWarning("100_transitionToUnknownState3.ump", 0, 68, new Position("100_transitionToUnknownState3.ump", 9, 8, 57));
  }

  @Test
  public void oneStateNoEventStateMachine()
  {
    assertParse("100_emptyStateMachine.ump", "[classDefinition][name:LightFixture][stateMachine][enum][name:bulb]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    Assert.assertEquals(0, sm.numberOfStates());
  }

  @Test
  public void oneState_StateMachine()
  {
    assertParse("100_oneState_StateMachine.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    Assert.assertEquals(1, sm.numberOfStates());
    State state = sm.getState(0);
    Assert.assertEquals("On", state.getName());
    Assert.assertEquals(0, state.numberOfTransitions());
    Assert.assertEquals(true, state.getIsStartState());

  }

  @Test
  public void oneStateOneEvent()
  {
    assertParse("100_oneStateOneEvent.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:On]");

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
    assertParse("100_oneStateTwoEvent.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:On][transition][event:pull][stateName:On]");
  }

  @Test
  public void transitionAction()
  {
    assertParse("100_transitionAction.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][action][code:blabla][stateName:On]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);

    Transition t1 = state.getTransition(0);

    Action a1 = t1.getAction();

    Assert.assertNotNull(a1);
    Assert.assertEquals("blabla", a1.getActionCode());
  }

  @Test
  public void doActivity()
  {
    assertParse("100_doActivity.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][activity][code:iAmaDoActivity]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);

    Activity a1 = state.getActivity(0);
    Assert.assertEquals("iAmaDoActivity", a1.getActivityCode());
  }

  @Test
  public void multipleDoActivity()
  {
    assertParse("100_multipleDoActivities.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:s1][activity][code:blah1();][activity][code:blah2();][inlineComment:e1 -> s2;][state][stateName:s2]");

    UmpleClass c = model.getUmpleClass("X");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);

    Assert.assertEquals(true, state.hasActivities());
    Assert.assertEquals(2, state.numberOfActivities());
    Activity a1 = state.getActivity(0);
    Activity a2 = state.getActivity(1);

    // Check positions for multiple do activities
    Assert.assertNotNull(a1.getPosition());
    Assert.assertNotNull(a2.getPosition());

    Assert.assertEquals(4, a1.getPosition().getLineNumber());
    Assert.assertEquals(5, a2.getPosition().getLineNumber());

    Assert.assertEquals(6, a1.getPosition().getCharacterOffset());
    Assert.assertEquals(6, a2.getPosition().getCharacterOffset());

    Assert.assertEquals("blah1();", a1.getActivityCode());
    Assert.assertEquals("blah2();", a2.getActivityCode());
  }

  @Test
  public void transitionAfterDo()
  {
    assertParse("100_transition_after_do.ump", "[classDefinition][name:Switch][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:press][stateName:Off][state][stateName:Off][autoTransition][activity][code:keepDoing;][stateName:On]");

    UmpleClass c = model.getUmpleClass("Switch");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(1);

    Transition t = state.getTransition(0);
    Activity act = state.getActivity(0);
    Assert.assertNotNull(act);
    Assert.assertEquals("keepDoing;", act.getActivityCode());
    Assert.assertEquals(t.getEvent(), act.getOnCompletionEvent());
    Assert.assertEquals(false, t.isAutoTransition());
    Assert.assertEquals(true, t.getEvent().isAutoTransition());
  }

  @Test
  public void unclearTransitionToState()
  {
    assertHasWarning("100_unclearTransitionToState.ump", 0, 66, new Position("100_unclearTransitionToState.ump", 4, 3, 25));
  }

  @Test
  public void unclearTransitionToStateNested()
  {
    assertHasWarning("100_unclearTransitionToStateNested.ump", 0, 66, new Position("100_unclearTransitionToStateNested.ump", 5, 7, 44));
  }

  // Multiple auto-transitions to different states
  @Test
  public void conflictingAutoTransitionsToStates()
  {
    assertHasWarning("100_conflictingAutoTransitionsToStates.ump", 0, 69, new Position("100_conflictingAutoTransitionsToStates.ump", 5, 6, 48));
  }

  @Test
  public void conflictingAutoTransitionsToStatesNested()
  {
    assertHasWarning("100_conflictingAutoTransitionsToStatesNested.ump", 0, 69, new Position("100_conflictingAutoTransitionsToStatesNested.ump", 6, 8, 62));
  }

  @Test
  public void conflictingAutoTransitionsToStatesAfterDo()
  {
    assertHasWarning("100_conflictingAutoTransitionsToStatesAfterDo.ump", 0, 69, new Position("100_conflictingAutoTransitionsToStatesAfterDo.ump", 5, 6, 89));
  }

  @Test
  public void historyStatePlacement()
  {
    assertNoWarnings("238_historyState.ump");

    UmpleClass c = model.getUmpleClass("X");
    StateMachine sm = c.getStateMachine(0);
    StateMachine s2 = sm.getState(1).getNestedStateMachine(0);
    StateMachine ss1 = s2.getState(0).getNestedStateMachine(0);
    Assert.assertEquals(true, ss1.getContainsHistoryState());
    Assert.assertEquals(false, s2.getContainsHistoryState());
    Assert.assertEquals(3, ss1.numberOfStates());
    Assert.assertEquals("H", ss1.getState(2).getName());
    Assert.assertEquals(true, ss1.getState(2).getIsHistoryState());
    // TODO: finish

    // TODO: failure if History state declared
    // TODO: failure if History state or deep transitioned to when no sub states
    // TODO: multiple transitions to same history/deep state
    // TODO: concurrent/pooled/queued

  }

  @Test
  public void invalidHistoryStateTransition()
  {
    assertFailedParse("239_deepHistory_nonExistantState.ump", new Position("239_deepHistory_nonExistantState.ump", 2, 2, 11), 64);
    // assertFailedParse("239_deepHistory_noSubstates.ump", new
    // Position("239_deepHistory_nonExistantState.ump", 2,2, 11), 65);
    assertFailedParse("239_deepHistory_declaredHistoryState.ump", new Position("239_deepHistory_declaredHistoryState.ump", 24, 4, 259), 63);
  }

  @Test
  public void dotNotationInvalid()
  {
    assertHasWarning("519_dotNotationInvalidState.ump", 0, 50, new Position("519_dotNotationInvalidState.ump", 12, 6, 120));
    assertFailedParse("519_dotNotationInvalidStateName.ump", new Position("519_dotNotationInvalidStateName.ump", 12, 6, 120), 152);

  }

  @Test
  public void dotNotationAtLevelAbove()
  {
    // assertNoWarnings("519_dotNotationAtLevelAbove.ump");
    assertHasWarning("519_dotNotationAtLevelAbove.ump", 0, 66, new Position("519_dotNotationAtLevelAbove.ump", 5, 8, 44));

    UmpleClass c = model.getUmpleClass("X");

    StateMachine sm = c.getStateMachine(0);
    State s1 = sm.getState(0);
    StateMachine s1Sm = s1.getNestedStateMachine(0);
    State s1ss1 = s1Sm.getState(0); // state second dot notation transition
                                    // should point
    Transition tTos2ss1 = s1Sm.getState(1).getTransition(0);

    State s2 = sm.getState(1);
    StateMachine s2Sm = s2.getNestedStateMachine(0);
    State s2ss1 = s2Sm.getState(0);
    State s2ss2 = s2Sm.getState(1); // state first dot notation should point to

    Transition tTos2ss2 = s2ss1.getTransition(0);
    Transition tTos1ss1 = s2ss2.getTransition(0);

    // assert Names are correct
    Assert.assertEquals(tTos2ss2.getNextState().getName(), "ss2");
    Assert.assertEquals(tTos2ss1.getNextState().getName(), "ss1");
    Assert.assertEquals(tTos1ss1.getNextState().getName(), "ss1");

    // assert they are equal
    Assert.assertEquals(s2ss2, tTos2ss2.getNextState());
    Assert.assertEquals(s1ss1, tTos1ss1.getNextState());
    Assert.assertEquals(s2ss1, tTos2ss1.getNextState());
  }

  @Test
  public void dotNotationAtSameLevel()
  {
    assertNoWarnings("519_dotNotationAtSameLevel.ump");

    UmpleClass c = model.getUmpleClass("X");

    // get state that transition should point to
    StateMachine sm = c.getStateMachine(0);
    State s1 = sm.getState(0);
    StateMachine innerSm = s1.getNestedStateMachine(0);
    State ss1 = innerSm.getState(0);

    // get state that transition does point to
    State s2 = sm.getState(1);
    Transition t = s2.getTransition(0);

    // assert they are equal
    Assert.assertEquals(ss1, t.getNextState());

  }

  @Test
  public void oneStateOneEntry()
  {
    assertParse("100_oneStateOneEntry.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][entryOrExitAction][type:entry][code:blahblah]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);

    Assert.assertEquals(1, state.numberOfActions());
    Action a1 = state.getAction(0);
    Assert.assertEquals("blahblah", a1.getActionCode());
    Assert.assertEquals("entry", a1.getActionType());

  }

  @Test
  public void oneStateManyEntry()
  {
    assertParse("100_oneStateManyEntry.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][entryOrExitAction][type:entry][code:blahblah][entryOrExitAction][type:entry][code:blahblah2][entryOrExitAction][type:exit][code:blahblahexit]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);

    Assert.assertEquals(3, state.numberOfActions());
    Action a1 = state.getAction(0);
    Assert.assertEquals("entry", a1.getActionType());
    Assert.assertEquals("blahblah", a1.getActionCode());

    Action a2 = state.getAction(1);
    Assert.assertEquals("entry", a2.getActionType());
    Assert.assertEquals("blahblah2", a2.getActionCode());

    Action a3 = state.getAction(2);
    Assert.assertEquals("exit", a3.getActionType());
    Assert.assertEquals("blahblahexit", a3.getActionCode());

  }

  @Test
  public void oneStateOneExit()
  {
    assertParse("100_oneStateOneExit.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][entryOrExitAction][type:exit][code:blahblah][transition][event:push][stateName:On]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State state = sm.getState(0);

    Assert.assertEquals(1, state.numberOfActions());
    Action a1 = state.getAction(0);
    Assert.assertEquals("blahblah", a1.getActionCode());
    Assert.assertEquals("exit", a1.getActionType());
  }

  @Test
  public void twoStateNoEventStateMachine()
  {
    assertParse("100_twoState_StateMachine.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:Off]");

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
    assertParse("100_reuseEvents.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On]");

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
    assertParse("100_reuseEvents.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On]");

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
    assertParse("100_oneGuardAfter.ump", "[classDefinition][name:LightFixture][attribute][type:Integer][name:brightness][value:0][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][guard][numExpr][constraintName][name:brightness][smallerOp:<][number:1][event:push][stateName:Off][state][stateName:Off]");

    UmpleClass c = model.getUmpleClass("LightFixture");

    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());

    State on = sm.getState(0);
    Assert.assertEquals("On", on.getName());

    Transition t = on.getTransition(0);
    Assert.assertEquals("push", t.getEvent().getName());
    JavaGenerator gen = new JavaGenerator();
    gen.setModel(model);
    Assert.assertEquals("if (getBrightness()<1)\n{", gen.translate("Open", t.getGuard()));
  }

  @Test
  public void oneStateOneGuardBefore()
  {

    assertParse("100_oneGuardBefore.ump", "[classDefinition][name:LightFixture][attribute][type:Integer][name:brightness][value:0][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][guard][numExpr][constraintName][name:brightness][smallerOp:<][number:1][stateName:Off][state][stateName:Off]");

    UmpleClass c = model.getUmpleClass("LightFixture");

    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());

    State on = sm.getState(0);
    Assert.assertEquals("On", on.getName());

    Transition t = on.getTransition(0);
    Assert.assertEquals("push", t.getEvent().getName());
    JavaGenerator gen = new JavaGenerator();
    gen.setModel(model);
    Assert.assertEquals("if (getBrightness()<1)\n{", gen.translate("Open", t.getGuard()));
  }

  @Test
  public void emptyAndNonEmptyStates()
  {
    assertParse("100_emptyAndNonEmptyStates.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off]");

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
    assertParse("100_sameEvent_twoStates.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On][stateMachine][inlineStateMachine][name:AnotherBulb][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On]");

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
    assertParse("101_Nested_oneState.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:Off]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    StateMachine innerSm = on.getNestedStateMachine(0);
    State off = innerSm.getState(0);

    Assert.assertEquals("On", innerSm.getName());
    Assert.assertEquals("On", on.getName());
    Assert.assertEquals("Off", off.getName());
  }

  @Test
  public void Nested_TwoStates()
  {
    assertParse("101_Nested_twoStates.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:Off][state][stateName:On][transition][event:push][stateName:Off]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    StateMachine innerSm = on.getNestedStateMachine(0);
    State off = innerSm.getState(0);
    State innerOn = innerSm.getState(1);

    Assert.assertEquals("On", innerSm.getName());
    Assert.assertEquals("On", on.getName());
    Assert.assertEquals("Off", off.getName());
    Assert.assertEquals("On", innerOn.getName());
  }

  @Test
  public void Nested_TwoStatesComplex()
  {
    assertParse("101_Nested_twoStatesComplex.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:OutsideOn][transition][event:push][stateName:On][state][stateName:Off][state][stateName:On][transition][event:push][stateName:Off][transition][event:pull][stateName:OutsideOff][state][stateName:OutsideOff]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    State off = sm.getState(1);

    Assert.assertEquals(2, sm.numberOfStates());
    Assert.assertEquals("OutsideOn", on.getName());
    Assert.assertEquals("OutsideOff", off.getName());

    StateMachine innerSm = on.getNestedStateMachine(0);
    State innerOff = innerSm.getState(0);
    State innerOn = innerSm.getState(1);

    Assert.assertEquals("OutsideOn", innerSm.getName());
    Assert.assertEquals("Off", innerOff.getName());
    Assert.assertEquals("On", innerOn.getName());

  }

  @Test
  public void Nested_realExample2()
  {
    assertParse("101_Nested_realExample2.ump", "[classDefinition][name:StrobeLight][stateMachine][inlineStateMachine][name:dvdPlayer][state][stateName:Off][transition][event:turnOn][stateName:On][state][stateName:Sleep][transition][event:wake][stateName:Pause][state][stateName:On][transition][event:turnOff][stateName:Off][state][stateName:Play][transition][event:push][stateName:Pause][state][stateName:Pause][transition][event:push][stateName:Play][transition][event:standby][stateName:Sleep]");

  }

  @Test
  public void Concurrent_NoSm()
  {
    assertParse("103_Concurrent_NoSm.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][||:||]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    Assert.assertEquals(0, on.numberOfNestedStateMachines());
  }

  @Test
  public void Concurrent_OneSm()
  {
    assertParse("103_Concurrent_OneSm.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:A][||:||]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    Assert.assertEquals(1, on.numberOfNestedStateMachines());
    StateMachine innerSm = on.getNestedStateMachine(0);
    Assert.assertEquals(false, on.getIsConcurrent());
    Assert.assertEquals("A", innerSm.getName());
    Assert.assertEquals(1, innerSm.numberOfStates());
    Assert.assertEquals("A", innerSm.getState(0).getName());
  }

  @Test
  public void Concurrent_TwoSm()
  {
    assertParse("103_Concurrent_TwoSm.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:A][state][stateName:B][||:||][state][stateName:C][state][stateName:D]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State on = sm.getState(0);
    Assert.assertEquals(2, on.numberOfNestedStateMachines());
    StateMachine innerSm = on.getNestedStateMachine(0);
    StateMachine innerSm2 = on.getNestedStateMachine(1);

    Assert.assertEquals(true, on.getIsConcurrent());

    Assert.assertEquals("A", innerSm.getName());
    Assert.assertEquals(2, innerSm.numberOfStates());
    Assert.assertEquals("A", innerSm.getState(0).getName());
    Assert.assertEquals("B", innerSm.getState(1).getName());

    Assert.assertEquals("C", innerSm2.getName());
    Assert.assertEquals(2, innerSm2.numberOfStates());
    Assert.assertEquals("C", innerSm2.getState(0).getName());
    Assert.assertEquals("D", innerSm2.getState(1).getName());

  }

  @Test
  public void stateMachineDefinition()
  {
    assertParse("200_stateMachineDefinition.ump", "[stateMachineDefinition][name:myname][state][stateName:On][transition][event:push][stateName:Off][state][stateName:Off]");

    StateMachine sm = model.getStateMachineDefinition(0);

    Assert.assertEquals("myname", sm.getName());
    Assert.assertEquals("On", sm.getState(0).getName());
    Assert.assertEquals("Off", sm.getState(1).getName());

    Assert.assertEquals("Off", sm.getState(0).getTransition(0).getNextState().getName());
    Assert.assertEquals(true, sm.getState(0).hasTransitions());
  }

  @Test
  public void stateMachineManyTransitionsToUndefinedStates()
  {
    assertParse("101_Nested_manyTransitions.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:OutsideOn][transition][event:push][stateName:On][transition][event:pull][stateName:On][state][stateName:Off][state][stateName:On][transition][event:push][stateName:Off][transition][event:pull][stateName:OutsideOff][state][stateName:OutsideOff]");
    StateMachine sm = model.getUmpleClass("LightFixture").getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());

    Assert.assertEquals(2, sm.numberOfStates());
    Assert.assertEquals("OutsideOn", sm.getState(0).getName());
    Assert.assertEquals("OutsideOff", sm.getState(1).getName());
    State s = sm.getState(0);
    StateMachine innerSm = s.getNestedStateMachine(0);
    Assert.assertEquals(2, innerSm.numberOfStates());
    Assert.assertEquals("Off", innerSm.getState(0).getName());
    Assert.assertEquals("On", innerSm.getState(1).getName());

  }

  @Test
  public void twoStateMachinesSameEvent()
  {
    assertParse("102_twoStateMachinesSameEvent.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:On][transition][event:flip][stateName:On][stateMachine][inlineStateMachine][name:anotherBulb][state][stateName:Off][transition][event:push][stateName:Off]");

    StateMachine sm1 = model.getUmpleClass("LightFixture").getStateMachine(0);
    StateMachine sm2 = model.getUmpleClass("LightFixture").getStateMachine(1);

    Event e1 = sm1.getEvent("push");
    Event alsoE1 = sm2.getEvent("push");

    Assert.assertSame(e1, alsoE1);
  }

  @Test
  public void OnOffTimer()
  {
    assertParse("200_OnOffTimer.ump", "[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:Off][state][stateName:Off][transition][timer:5][stateName:On]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());
    Assert.assertEquals("On", sm.getState(0).getName());
    Assert.assertEquals("Off", sm.getState(1).getName());

    Assert.assertEquals("Complex", sm.getType());

    List<Event> allEvents = sm.getEvents();
    Assert.assertEquals(2, allEvents.size());

    Event e = sm.getEvent("timeoutOffToOn");

    Assert.assertEquals("timeoutOffToOn", e.getName());
    Assert.assertEquals(true, e.getIsTimer());
    Assert.assertEquals("5", e.getTimerInSeconds());
  }

  @Test
  public void stateMachineDefinition_reference()
  {
    assertParse("200_stateMachineDefinition_reference.ump", "[stateMachineDefinition][name:OnOffSwitch][state][stateName:On][transition][event:push][stateName:Off][state][stateName:Off][transition][event:push][stateName:On][classDefinition][name:Lightbulb][stateMachine][referencedStateMachine][name:fixture][definitionName:OnOffSwitch]");

    StateMachine sm = model.getStateMachineDefinition(0);

    Assert.assertEquals("OnOffSwitch", sm.getName());
    Assert.assertEquals("On", sm.getState(0).getName());
    Assert.assertEquals("Off", sm.getState(1).getName());

    Assert.assertEquals("Off", sm.getState(0).getTransition(0).getNextState().getName());
    Assert.assertEquals("On", sm.getState(1).getTransition(0).getNextState().getName());

    UmpleClass lightbulb = model.getUmpleClass("Lightbulb");
    Assert.assertEquals(1, lightbulb.numberOfStateMachines());

    sm = lightbulb.getStateMachine(0);
    Assert.assertEquals("fixture", sm.getName());
    Assert.assertEquals("On", sm.getState(0).getName());
    Assert.assertEquals("Off", sm.getState(1).getName());

    Assert.assertEquals("Off", sm.getState(0).getTransition(0).getNextState().getName());
    Assert.assertEquals("On", sm.getState(1).getTransition(0).getNextState().getName());
  }

  @Test
  public void reusingEventsInNestedStateMachines()
  {
    assertParse("200_reusingEventsInNestedStateMachines.ump", "[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:status][state][stateName:S1][transition][event:e1][stateName:S1A][state][stateName:S1A][transition][event:e1][stateName:S1]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);

    List<Event> allEvents = sm.getEvents();
    Assert.assertEquals(1, allEvents.size());
    Assert.assertEquals("e1", allEvents.get(0).getName());
    Assert.assertEquals(1, uClass.getEvents().size());
  }

  @Test
  public void finalState()
  {
    assertParse("211_finalState.ump", "[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:Off][state][final:final][stateName:Off]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State s1 = sm.findState("On");
    Assert.assertEquals(false, s1.isFinalState());

    State s2 = sm.findState("Off");
    Assert.assertEquals(true, s2.isFinalState());
  }

  @Test
  public void finalStateReservedWord()
  {
    assertParse("211_finalStateReservedWord.ump", "[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][stateName:Final][state][stateName:Final]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State s1 = sm.findState("On");
    Assert.assertEquals(false, s1.isFinalState());

    State s2 = sm.findState("Final");
    Assert.assertEquals("Final", s2.getName());
    Assert.assertEquals(true, s2.isFinalState());
  }

  @Test
  public void concurrentFinals()
  {
    assertParse("211_concurrentFinals.ump", "[classDefinition][name:OnOffSwitch][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][state][stateName:MotorIdle][transition][event:flip][stateName:Final][||:||][state][stateName:FanIdle][transition][event:flop][stateName:Final]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State on = sm.findState("On");
    State motorFinal = on.getNestedStateMachine(0).findState("Final");
    State fanFinal = on.getNestedStateMachine(1).findState("Final");

    Assert.assertNotSame(motorFinal, fanFinal);
    Assert.assertEquals(true, motorFinal.isFinalState());
    Assert.assertEquals(true, fanFinal.isFinalState());
  }

  @Test
  public void finalStateInOneConcurrentRegion()
  {
    assertParse("211_finalState_inOneConcurrentRegion.ump", "[classDefinition][name:Dryer][stateMachine][inlineStateMachine][name:status][state][stateName:On][state][stateName:Rotating][transition][event:dryingCompleted][stateName:Final][||:||][state][stateName:Heating][transition][event:fire][stateName:Off][state][stateName:Off]");

    UmpleClass uClass = model.getUmpleClass("Dryer");

    State state = uClass.getStateMachine(0).findState("On").getNestedStateMachine(0).findState("Final");
    Assert.assertEquals(true, state.isFinalState());

    state = uClass.getStateMachine(0).findState("On").getNestedStateMachine(1).findState("Final");
    Assert.assertEquals(null, state);

  }

  @Test
  public void finalStateInTwoConcurrentRegions()
  {
    assertParse("211_finalState_inTwoConcurrentRegions.ump", "[classDefinition][name:Dryer][stateMachine][inlineStateMachine][name:status][state][stateName:On][state][stateName:Rotating][transition][event:dryingCompleted][stateName:Final][||:||][state][stateName:Heating][transition][event:dryingCompleted][stateName:Final][transition][event:fire][stateName:Off][state][stateName:Off]");

    UmpleClass uClass = model.getUmpleClass("Dryer");

    State final1 = uClass.getStateMachine(0).findState("On").getNestedStateMachine(0).findState("Final");
    Assert.assertEquals(true, final1.isFinalState());

    State final2 = uClass.getStateMachine(0).findState("On").getNestedStateMachine(1).findState("Final");
    Assert.assertEquals(true, final2.isFinalState());

    Assert.assertNotSame(final1, final2);
  }

  @Test
  public void finalStateNoAction()
  {
    assertParse("211_finalState_noAction.ump", "[classDefinition][name:DVDplayer][stateMachine][inlineStateMachine][name:DVDplayerStatus][state][stateName:NormalOperation][state][stateName:On][state][stateName:Playing][transition][event:stop][stateName:Stopped][state][stateName:Stopped][transition][event:play][stateName:Playing][transition][event:pause][stateName:Paused][state][stateName:history][state][stateName:Off][transition][event:turnOn][stateName:Final]");

    UmpleClass uClass = model.getUmpleClass("DVDplayer");
    State final1 = uClass.getStateMachine(0).findState("NormalOperation").getNestedStateMachine(0).findState("Final");
    Assert.assertEquals(true, final1.isFinalState());
  }

  @Test
  public void finalStateWithAction()
  {
    assertParse("211_finalState_withAction.ump", "[classDefinition][name:DVDplayer][stateMachine][inlineStateMachine][name:DVDplayerStatus][state][stateName:NormalOperation][state][stateName:On][state][stateName:Playing][transition][event:stop][stateName:Stopped][state][stateName:Stopped][transition][event:play][stateName:Playing][transition][event:pause][stateName:Paused][state][stateName:history][state][stateName:Off][transition][event:turnOn][action][code:actionCode][stateName:Final]");

    UmpleClass uClass = model.getUmpleClass("DVDplayer");
    State final1 = uClass.getStateMachine(0).findState("NormalOperation").getNestedStateMachine(0).findState("Final");
    Assert.assertEquals(true, final1.isFinalState());
  }

  // Issue 148
  @Test
  public void standAloneTransitions()
  {
    assertParse("212_standAloneTransition.ump", "[classDefinition][name:C][stateMachine][inlineStateMachine][name:stateMachineName][state][stateName:S1][state][stateName:S2][standAloneTransition][event:e1][fromState:S1][action][code:action][toState:S2][standAloneTransition][event:e2][fromState:S2][toState:S1]");

    UmpleClass uClass = model.getUmpleClass("C");
    StateMachine sm = uClass.getStateMachine(0);
    List<State> on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    ArrayList<Transition> transition = sm.getAllTransitions();

    for (int i = 0; i < transition.size(); i++)
      System.out.println(transition.get(i).toString());

    assertParse("212_standAloneTransition2.ump", "[classDefinition][name:C][stateMachine][inlineStateMachine][name:stateMachineName][standAloneTransition][event:e2][fromState:S2][toState:S1][state][stateName:S1][state][stateName:a][state][stateName:b][state][stateName:S2][standAloneTransition][event:e1][fromState:a][toState:b]");

    uClass = model.getUmpleClass("C");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    transition = sm.getAllTransitions();

    for (int i = 0; i < transition.size(); i++)
      System.out.println(transition.get(i).getEvent().getName());

    assertParse("212_standAloneTransition3.ump", "[classDefinition][name:C][stateMachine][inlineStateMachine][name:stateMachineName][state][stateName:S1][state][stateName:a][state][stateName:b][standAloneTransition][event:e1][fromState:a][toState:b][state][stateName:S2][standAloneTransition][event:e2][fromState:S2][toState:S1]");

    uClass = model.getUmpleClass("C");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    transition = sm.getAllTransitions();

    for (int i = 0; i < transition.size(); i++)
      System.out.println(transition.get(i).getEvent().getName());

    assertParse("212_standAloneTransition4.ump", "[classDefinition][name:C][stateMachine][inlineStateMachine][name:stateMachineName][standAloneTransition][guard][numExpr][constraintName][name:getClassSize][constraintParameterList][moreOp:>][constraintName][name:getMaximumClassSize][constraintParameterList][event:e2][fromState:S2][toState:S1][state][stateName:S1][state][stateName:a][state][stateName:b][state][stateName:S2][standAloneTransition][event:e1][guard][numExpr][constraintName][name:i][moreOp:>][number:0][fromState:S1][toState:S2]");

    uClass = model.getUmpleClass("C");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    transition = sm.getAllTransitions();

    for (int i = 0; i < transition.size(); i++)
      System.out.println(transition.get(i).getEvent().getName());

    assertParse("212_standAloneTransition5.ump", "[classDefinition][name:C][stateMachine][inlineStateMachine][name:stateMachineName][state][stateName:S1][state][stateName:S2][standAloneTransition][fromState:S1][toState:S2][standAloneTransition][fromState:S2][toState:S1]");

    uClass = model.getUmpleClass("C");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    transition = sm.getAllTransitions();

    for (int i = 0; i < transition.size(); i++)
      System.out.println(transition.get(i).getEvent().getName());

    assertHasWarning("212_standAloneTransition6.ump", 2, 50, new Position("212_standAloneTransition6.ump", 4, 2, 33));

  }

  // Issue 200
  @Test
  public void mixStateMachine()
  {
    assertParse("212_mixin_state.ump", "[stateMachineDefinition][name:OnOffStateMachine][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On][state][stateName:Amber][transition][event:flip][stateName:On][state][stateName:test1][state][stateName:test2][stateMachineDefinition][name:OnOffStateMachine][state][stateName:Amber][transition][event:flip][stateName:On][stateMachineDefinition][name:OnOffStateMachine][state][stateName:test1][state][stateName:test2][classDefinition][name:X][stateMachine][referencedStateMachine][name:bulb][definitionName:OnOffStateMachine]");

    UmpleClass uClass = model.getUmpleClass("X");
    StateMachine sm = uClass.getStateMachine(0);
    List<State> on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    assertParse("212_mixin_state2.ump", "[classDefinition][name:X][attribute][name:testattr][stateMachine][inlineStateMachine][name:sm1][state][stateName:s1][transition][event:e1][stateName:s2][classDefinition][name:X][attribute][name:anotherattr][stateMachine][inlineStateMachine][name:sm1][state][stateName:s2][transition][event:e1][stateName:s1]");

    uClass = model.getUmpleClass("X");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    assertParse("212_mixin_state3.ump", "[stateMachineDefinition][name:Machine][state][stateName:On][transition][event:flip][stateName:Off][transition][event:flop][stateName:Off][state][stateName:Off][state][stateName:Test][stateMachineDefinition][name:Machine][state][stateName:Test][classDefinition][name:OnOffSwitch][stateMachine][referencedStateMachine][name:bulb][definitionName:Machine][extendedStateMachine][state][stateName:On][changeType:-][transition][event:flip][stateName:Off]");

    uClass = model.getUmpleClass("OnOffSwitch");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    assertParse("212_mixin_state4.ump", "[stateMachineDefinition][name:OnOffStateMachine][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][stateName:On][classDefinition][name:X][stateMachine][referencedStateMachine][name:bulb][definitionName:OnOffStateMachine][extendedStateMachine][state][stateName:Amber]");

    uClass = model.getUmpleClass("X");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    assertParse("212_mixin_state5.ump", "[classDefinition][name:C][stateMachine][inlineStateMachine][name:stateMachineName][state][stateName:S1][state][stateName:S2][standAloneTransition][event:e1][fromState:S1][action][code:action][toState:S2][standAloneTransition][event:e2][fromState:S2][toState:S1][classDefinition][name:C][stateMachine][inlineStateMachine][name:stateMachineName][state][stateName:S3][transition][event:e4][stateName:S1][standAloneTransition][event:e4][fromState:S1][toState:S3]");

    uClass = model.getUmpleClass("C");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    // Issue 580
    assertParse("212_mixin_state6.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:s1][state][stateName:s1a][state][stateName:s1b][state][stateName:s1][state][stateName:s1c]");

    uClass = model.getUmpleClass("X");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

    assertParse("212_mixin_state7.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:s1][state][stateName:s1a][state][stateName:s1b][state][stateName:s1][state][stateName:s1c][classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:s1][state][stateName:s1d][state][stateName:s1e][state][stateName:s1][state][stateName:s1a][state][stateName:s1a2]");

    uClass = model.getUmpleClass("X");
    sm = uClass.getStateMachine(0);
    on = sm.getStates();

    for (int i = 0; i < on.size(); i++)
      System.out.println(on.get(i).getName());

  }

  // Issue 575
  @Test
  public void timedTransictionFollowedByTransiction()
  {
    assertNoWarnings("212_timed_normal_transaction.ump");
    assertNoWarnings("212_timed_normal_transaction2.ump");
  }

  @Test
  public void addEvent()
  {
    assertParse("212_mixin_addEvent.ump", "[stateMachineDefinition][name:Machine][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][classDefinition][name:OnOffSwitch][stateMachine][referencedStateMachine][name:bulb][definitionName:Machine][extendedStateMachine][state][stateName:On][changeType:+][transition][event:push][stateName:On]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State on = sm.findState("On");
    Assert.assertEquals(2, on.numberOfTransitions());
  }

  @Test
  public void removeEvent()
  {
    assertParse("212_mixin_removeEvent.ump", "[stateMachineDefinition][name:Machine][state][stateName:On][transition][event:flip][stateName:Off][transition][event:flop][stateName:Off][state][stateName:Off][classDefinition][name:OnOffSwitch][stateMachine][referencedStateMachine][name:bulb][definitionName:Machine][extendedStateMachine][state][stateName:On][changeType:-][transition][event:flip][stateName:Off]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State on = sm.findState("On");
    Assert.assertEquals(2, on.numberOfTransitions());
  }

  @Test
  public void removeState()
  {
    assertParse("212_mixin_removeState.ump", "[stateMachineDefinition][name:Machine][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][classDefinition][name:OnOffSwitch][stateMachine][referencedStateMachine][name:bulb][definitionName:Machine][extendedStateMachine][changeType:-][state][stateName:Off]");

    UmpleClass uClass = model.getUmpleClass("OnOffSwitch");
    StateMachine sm = uClass.getStateMachine(0);
    State on = sm.findState("On");
    State off = sm.findState("Off");
    Assert.assertEquals(0, on.numberOfTransitions());
    Assert.assertEquals(null, off);
  }

  @Test
  public void autoTransition_simple()
  {
    assertParse("104_autoTransition.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][autoTransition][stateName:Off][state][stateName:Off]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);

    State s = sm.getState(0);
    Assert.assertEquals("On", s.getName());
    Transition t = s.getTransition(0);
    Assert.assertEquals(true, t.isAutoTransition());

    Event autoEvent = t.getEvent();
    Assert.assertEquals(true, autoEvent.isAutoTransition());

    assertParse("104_autoTransition2.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][autoTransition][action][code:checksComplete=0;][stateName:Off][state][stateName:Off]");

    c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    sm = c.getStateMachine(0);

    s = sm.getState(0);
    Assert.assertEquals("On", s.getName());
    t = s.getTransition(0);
    Assert.assertEquals(true, t.isAutoTransition());

    autoEvent = t.getEvent();
    Assert.assertEquals(true, autoEvent.isAutoTransition());

    assertParse("104_autoTransition3.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][autoTransition][action][code:checksComplete=0;][stateName:Off][state][stateName:Off]");
    c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    sm = c.getStateMachine(0);

    s = sm.getState(0);
    Assert.assertEquals("On", s.getName());
    t = s.getTransition(0);
    Assert.assertEquals(true, t.isAutoTransition());

    autoEvent = t.getEvent();
    Assert.assertEquals(true, autoEvent.isAutoTransition());
  }

  @Test
  public void autoTransition_existingEntryAction()
  {
    assertParse("104_autoTransitionWithExistingEntryAction.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][entryOrExitAction][type:entry][code:doSomething();][autoTransition][stateName:Off][state][stateName:Off]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);

    State s = sm.getState(0);
    Assert.assertEquals(1, s.numberOfActions());
  }

  @Test
  public void autoTransition_guard()
  {
    assertParse("104_autoTransitionWithGuard.ump", "[classDefinition][name:LightFixture][attribute][type:Integer][name:count][stateMachine][inlineStateMachine][name:bulb][state][stateName:Off][autoTransition][guard][numExpr][constraintName][name:count][moreOp:>][number:10][stateName:On][state][stateName:On]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);

    State s = sm.getState(0);
    Assert.assertEquals("Off", s.getName());
    Transition t = s.getTransition(0);
    Assert.assertEquals(true, t.isAutoTransition());
    JavaGenerator gen = new JavaGenerator();
    gen.setModel(model);
    Assert.assertEquals("if (getCount()>10)\n{", gen.translate("Open", t.getGuard()));
  }

  @Test
  public void transitionWithGuardAndAction()
  {

    assertParse("100_transitionWithGuardAndAction.ump", "[classDefinition][name:LightFixture][attribute][type:Integer][name:brightness][value:0][stateMachine][inlineStateMachine][name:bulb][state][stateName:On][transition][event:push][guard][numExpr][constraintName][name:brightness][smallerOp:<][number:1][action][code:blabla][stateName:Off][state][stateName:Off]");

    UmpleClass c = model.getUmpleClass("LightFixture");

    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("bulb", sm.getName());

    State on = sm.getState(0);
    Assert.assertEquals("On", on.getName());

    Transition t = on.getTransition(0);
    Assert.assertEquals("push", t.getEvent().getName());
    JavaGenerator gen = new JavaGenerator();
    gen.setModel(model);
    Assert.assertEquals("if (getBrightness()<1)\n{", gen.translate("Open", t.getGuard()));

    Action a1 = t.getAction();

    Assert.assertNotNull(a1);
    Assert.assertEquals("blabla", a1.getActionCode());
  }
  
  @Test
  public void transitionWithInvalidGuard()
  {
    assertHasWarning("100_transitionWithInvalidGuard.ump", 0, 1006, new Position("100_transitionWithInvalidGuard.ump", 4, 6, 58));
  }


  @Test
  public void eventWithArgument()
  {
    assertParse("100_eventWithArgument.ump", "[classDefinition][name:LightFixture][attribute][type:Integer][name:brightness][value:0][stateMachine][inlineStateMachine][name:bulb][state][stateName:Off][transition][event:turnDimmer][parameterList][parameter][type:Integer][name:lightval][action][code:setBrightness(lightval)][stateName:Off][transition][event:flipSwitch][stateName:Dimmed][state][stateName:Dimmed][transition][event:entry][guard][numExpr][constraintName][name:dimmer][moreOp:>][number:99][stateName:On][transition][event:flipSwitch][stateName:Off][transition][event:turnDimmer][parameterList][parameter][type:Integer][name:lightval][action][code:setBrightness(lightval)][stateName:Dimmed][state][stateName:On][transition][event:flipSwitch][stateName:Off][transition][event:turnDimmer][parameterList][parameter][type:Integer][name:lightval][action][code:setBrightness(lightval)][stateName:Dimmed]");
    UmpleClass c = model.getUmpleClass("LightFixture");

    StateMachine sm = c.getStateMachine(0);
    State off = sm.getState(0);
    Event turnDimmer = off.getTransition(0).getEvent();
    Event flipSwitch = off.getTransition(1).getEvent();
    Assert.assertEquals("Integer lightval", turnDimmer.getArgs());
    Assert.assertEquals("", flipSwitch.getArgs());
  }

  @Test
  public void eventsWithInconsistentArguments()
  {
    assertFailedParse("100_eventWithInconsistentArguments.ump", new Position("100_eventWithInconsistentArguments.ump", 13, 8, 248), 51);
  }

  @Test
  public void duplicateEvents()
  {
    // right now only aasserts that a warning is raised if a guardless event
    // comes before the same event
    assertHasWarning("485_duplicateEventsNoGuards.ump", 0, 54, new Position("485_duplicateEventsNoGuards.ump", 8, 6, 95));
    assertHasWarning("485_duplicateEventsGuardlessBeforeGuarded.ump", 0, 54, new Position("485_duplicateEventsGuardlessBeforeGuarded.ump", 9, 6, 111));
    assertNoWarnings("485_duplicateEventsGuardedBeforeGuardless.ump");

    // make sure there is a warning when the substate events are guarded
    assertHasWarning("485_duplicateEventInSuperStateInAllStatesGuardedBelow.ump", 0, 55, new Position("485_duplicateEventInSuperStateInAllStatesGuardedBelow.ump", 6, 9, 79));

    // make sure a warning is raised when the duplicate event is in all states,
    // no guards
    assertHasWarning("485_duplicateEventInSuperStateInAllStatesAbove.ump", 0, 55, new Position("485_duplicateEventInSuperStateInAllStatesAbove.ump", 7, 8, 92));
    assertHasWarning("485_duplicateEventInSuperStateInAllStatesBelow.ump", 0, 55, new Position("485_duplicateEventInSuperStateInAllStatesBelow.ump", 6, 8, 73));

    // make sure no warnings are raised when the event in the super state is
    // guarded
    assertNoWarnings("485_duplicateEventInSuperStateGuarded.ump");

    // Fix: if timed transition comes before an event in the same state, the
    // warning should not be raised
    assertNoWarnings("485_timedTransitionANDevent_noWarning_issue575.ump");

    assertNoWarnings("485_duplicateEventsNoGuards2.ump");

    assertHasWarning("485_duplicateEventsNoGuards3.ump", 0, 69, new Position("485_duplicateEventsNoGuards3.ump", 6, 6, 62));

    assertNoWarnings("485_duplicateEventsNoGuardsTimed.ump");
  }

  @Test
  public void transitionsWithUndeclaredState()
  {
    // Make sure it it parses correctly when states in transitions have been
    // declared
    assertParse("105_transitionUsingDeclaredState.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:state1][transition][event:e1][stateName:state2][state][stateName:state2][transition][event:e2][stateName:state3][state][stateName:state3][transition][event:e3][stateName:state1]");
    assertParse("105_multipleTransitionsUsingDeclaredState.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:state1][transition][event:e1][stateName:state2][state][stateName:state2][transition][event:e2][stateName:state4][state][stateName:state3][transition][event:e3][stateName:state4][state][stateName:state4][transition][event:e4][stateName:state3]");
    // Make sure it throws an warning when a state in a transition has not been
    // declared.
    assertHasWarning("105_transitionUsingUndeclaredState.ump", 0, 50, new Position("105_transitionUsingUndeclaredState.ump", 7, 6, 75));
    assertHasWarning("105_multipleTransitionsUsingUndeclaredState.ump", 1, 50, new Position("105_multipleTransitionsUsingUndeclaredState.ump", 7, 6, 75));
    assertHasWarning("105_multipleTransitionsUsingUndeclaredState.ump", 2, 50, new Position("105_multipleTransitionsUsingUndeclaredState.ump", 10, 6, 113));
  }

  @Test
  public void stateMachineWithInvalidName()
  {
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
  public void stateWithInvalidName()
  {
    assertFailedParse("106_invalidStateNamePartAmper.ump", new Position("106_invalidStateNamePartAmper.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNamePartDollar.ump", new Position("106_invalidStateNamePartDollar.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNamePartDot.ump", new Position("106_invalidStateNamePartDot.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNamePartExclaim.ump", new Position("106_invalidStateNamePartExclaim.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNamePartQuest.ump", new Position("106_invalidStateNamePartQuest.ump", 3, 4, 21), 152);
    // assertFailedParse("106_invalidStateNamePartQuote.ump", new
    // Position("106_invalidStateNamePartQuote.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNameStartAmper.ump", new Position("106_invalidStateNameStartAmper.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNameStartDollar.ump", new Position("106_invalidStateNameStartDollar.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNameStartDot.ump", new Position("106_invalidStateNameStartDot.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNameStartExclaim.ump", new Position("106_invalidStateNameStartExclaim.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNameStartQuest.ump", new Position("106_invalidStateNameStartQuest.ump", 3, 4, 21), 152);
    assertFailedParse("106_invalidStateNameStartQuote.ump", new Position("106_invalidStateNameStartQuote.ump", 3, 4, 21), 152);

  }

  @Test
  public void queuedStateMachine_pooledStateMachine_noEvents()
  {
    assertHasWarning("106_queuedStateMachine_noEvents.ump", 0, 56, new Position("106_queuedStateMachine_noEvents.ump", 2, 2, 16));
    assertHasWarning("106_pooledStateMachine_noEvents.ump", 0, 57, new Position("106_pooledStateMachine_noEvents.ump", 2, 2, 16));
    assertHasWarning("106_queued_nestedSM_noEvents.ump", 0, 56, new Position("106_queued_nestedSM_noEvents.ump", 3, 2, 24));
    assertHasWarning("106_pooled_nestedSM_noEvents.ump", 0, 57, new Position("106_pooled_nestedSM_noEvents.ump", 3, 2, 24));
  }

  @Test
  public void testOfNotTwoOrMoreTypesOFStateMachineInSameClass()
  {
    assertFailedParse("106_invalidQSMandPooledSMandRegularSMinSameClass.ump", new Position("106_invalidQSMandPooledSMandRegularSMinSameClass.ump", 16, 2, 133), 58);
    assertFailedParse("106_invalidQSMandPooledSMinSameClass.ump", new Position("106_invalidQSMandPooledSMinSameClass.ump", 10, 2, 75), 59);
    assertFailedParse("106_invalidRegularSMandPooledSMinSameClass.ump", new Position("106_invalidRegularSMandPooledSMinSameClass.ump", 9, 2, 72), 60);
    assertFailedParse("106_invalidQSMandRegularSMinSameClass.ump", new Position("106_invalidQSMandRegularSMinSameClass.ump", 9, 2, 72), 61);
  }

  @Test
  public void pooledStateMachine_UnspecifiedReception()
  {
    assertHasWarning("106_invalid_PooledStateMachine_UnspecifiedReception.ump", 1, 62, new Position("106_invalid_PooledStateMachine_UnspecifiedReception.ump", 5, 6, 84));
  }

  @Test
  public void queuedStateMachine()
  {

    assertParse("108_queuedStateMachine.ump", "[classDefinition][name:QueuedSM][stateMachine][inlineStateMachine][queued:queued][name:sm][state][stateName:State1][transition][event:e1][stateName:State2][state][stateName:State2][transition][event:e2][stateName:State1]");

    UmpleClass c = model.getUmpleClass("QueuedSM");
    StateMachine sm = c.getStateMachine(0);

    Assert.assertEquals(true, sm.isQueued());
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
  public void pooledStateMachine()
  {
    assertParse("108_pooledStateMachine.ump", "[classDefinition][name:PooledSM][stateMachine][inlineStateMachine][pooled:pooled][name:sm][state][stateName:State1][transition][event:e1][stateName:State2][state][stateName:State2][transition][event:e2][stateName:State1]");

    UmpleClass c = model.getUmpleClass("PooledSM");
    StateMachine sm = c.getStateMachine(0);

    Assert.assertEquals(true, sm.isPooled());
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
  public void stateMachine_unspecifiedReception()
  {
    assertParse("100_stateMachine_UnspecifiedReception.ump", "[classDefinition][name:UnSpecifiedReceptionTestCaseOne][stateMachine][inlineStateMachine][name:sm][state][stateName:s1][transition][event:e1][stateName:s2][transition][event:unspecified][action][code:printError();][stateName:error1][state][stateName:s2][transition][event:e2][stateName:s1][transition][event:unspecified][stateName:error2][state][stateName:error1][autoTransition][stateName:s1][state][stateName:error2][autoTransition][stateName:s2]");

    UmpleClass c = model.getUmpleClass("UnSpecifiedReceptionTestCaseOne");

    StateMachine sm = c.getStateMachine(0);
    Assert.assertEquals("sm", sm.getName());

    Assert.assertEquals(4, sm.numberOfStates());
    State s1State = sm.getState(0);
    State s2State = sm.getState(1);
    State error1State = sm.getState(2);
    State error2State = sm.getState(3);

    Assert.assertEquals("s1", s1State.getName());
    Assert.assertEquals("s2", s2State.getName());
    Assert.assertEquals("error1", error1State.getName());
    Assert.assertEquals("error2", error2State.getName());

    Assert.assertEquals(2, s1State.numberOfTransitions());
    Assert.assertEquals(2, s2State.numberOfTransitions());
    Assert.assertEquals(1, error1State.numberOfTransitions());
    Assert.assertEquals(1, error2State.numberOfTransitions());

    Transition t1 = s1State.getTransition(0);
    Assert.assertEquals("e1", t1.getEvent().getName());

    Transition t2 = s1State.getTransition(1);
    Assert.assertEquals(true, t2.getEvent().isUnspecified());

    Transition t3 = s2State.getTransition(0);
    Assert.assertEquals("e2", t3.getEvent().getName());

    Transition t4 = s2State.getTransition(1);
    Assert.assertEquals(true, t4.getEvent().isUnspecified());

    Transition t5 = error1State.getTransition(0);
    Assert.assertEquals(true, t5.isAutoTransition());

    Transition t6 = error2State.getTransition(0);
    Assert.assertEquals(true, t6.isAutoTransition());

    Event autoEvent1 = t5.getEvent();
    Assert.assertEquals(true, autoEvent1.isAutoTransition());
    Event autoEvent2 = t6.getEvent();
    Assert.assertEquals(true, autoEvent2.isAutoTransition());

    Action a1 = t2.getAction();

    Assert.assertNotNull(a1);
    Assert.assertEquals("printError();", a1.getActionCode());

  }

  @Test
  public void pooledStateMachines_and_EmptyRegularStateMachine()
  {
    assertParse("106_valid_PooledSM_with_EmptyRegularSM.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][pooled:pooled][name:sm1][state][stateName:x][transition][event:e][stateName:y][state][stateName:y][transition][event:f][stateName:x][inlineComment:The following should work as an enum][stateMachine][inlineStateMachine][name:sm2][state][stateName:q][state][stateName:r][state][stateName:s]");

    UmpleClass c = model.getUmpleClass("X");
    StateMachine sm1 = c.getStateMachine(0);
    StateMachine sm2 = c.getStateMachine(0);

    Assert.assertEquals(true, sm1.isPooled());
  }

  @Test
  public void queuedStateMachines_and_EmptyRegularStateMachine()
  {
    assertParse("106_valid_QSM_with_EmptyRegularSM.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][queued:queued][name:sm1][state][stateName:x][transition][event:e][stateName:y][state][stateName:y][transition][event:f][stateName:x][inlineComment:The following should work as an enum][stateMachine][inlineStateMachine][name:sm2][state][stateName:q][state][stateName:r][state][stateName:s]");

    UmpleClass c = model.getUmpleClass("X");
    StateMachine sm1 = c.getStateMachine(0);
    StateMachine sm2 = c.getStateMachine(0);

    Assert.assertEquals(true, sm1.isQueued());
  }

  @Test
  public void malformedStateMachine()
  {
    assertHasWarning("107_badStateMachineSyntaxBrokenArrow.ump", 0, 1006, new Position("107_badStateMachineSyntaxBrokenArrow.ump", 8, 6, 106));
    // assertHasWarning("107_badStateMachineSyntaxEmptyCodeBlock.ump", 0, 1006,
    // new Position("107_badStateMachineSyntaxEmptyCodeBlock.ump", 4, 2, 45));
    // assertHasWarning("107_badStateMachineSyntaxEmptyGuard.ump", 0, 1006, new
    // Position("107_badStateMachineSyntaxEmptyGuard.ump", 4, 2, 45));
    assertHasWarning("107_badStateMachineSyntaxMisplacedAttribute.ump", 0, 1006, new Position("107_badStateMachineSyntaxMisplacedAttribute.ump", 3, 2, 16));
    assertHasWarning("107_badStateMachineSyntaxMisplacedGuard.ump", 0, 1006, new Position("107_badStateMachineSyntaxMisplacedGuard.ump", 13, 6, 191));
    assertHasWarning("107_badStateMachineSyntaxMissingForwardSlash.ump", 0, 1006, new Position("107_badStateMachineSyntaxMissingForwardSlash.ump", 7, 13, 79));
    assertHasWarning("107_badStateMachineSyntaxMissingSemiColon.ump", 0, 1006, new Position("107_badStateMachineSyntaxMissingSemiColon.ump", 8, 6, 106));
    assertHasWarning("107_badStateMachineSyntaxMissmatchedBrackets.ump", 0, 1006, new Position("107_badStateMachineSyntaxMissmatchedBrackets.ump", 13, 6, 191));
  }

  @Test
  public void semicolonStateMachine()
  {
    assertParse("379_semicolon_extracode.ump", "[classDefinition][name:CourseX][stateMachine][inlineStateMachine][name:status][state][stateName:Open][entryOrExitAction][type:entry][code:System.out.println(\"Enter open\");]");
    UmpleClass c = model.getUmpleClass("CourseX");
    StateMachine sm = c.getStateMachine(0);

    Assert.assertEquals("status", sm.getName());

    Assert.assertEquals(1, sm.numberOfStates());
    State state1 = sm.getState(0);
    Assert.assertEquals("Open", state1.getName());
    Assert.assertEquals(0, state1.numberOfTransitions());
    Assert.assertEquals(true, state1.getHasEntryAction());
  }

  @Test
  public void activeBlock()
  {
    assertParse("160_activeblock.ump", "[classDefinition][name:Lamp][stateMachine][name:stateMachine1][state][stateName:topLevel][state][stateName:thread1][activity][code:System.out.println(\"Hello\");]");
    UmpleClass c = model.getUmpleClass("Lamp");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);

    Assert.assertEquals(1, sm.numberOfStates());
    State topLevel = sm.getState(0);

    Assert.assertEquals(1, topLevel.numberOfNestedStateMachines());
    StateMachine threadLevel = topLevel.getNestedStateMachine(0);

    Assert.assertEquals(1, threadLevel.numberOfStates());
    State doLevel = threadLevel.getState(0);

    Assert.assertEquals(true, doLevel.hasActivities());
  }

  @Test
  public void activeBlock_NamingOverMultiClasses()
  {
    assertParse("160_activeBlock_stateMachineNamingWithMultiClasses.ump", "[classDefinition][name:Lamp][stateMachine][name:stateMachine1][state][stateName:topLevel][state][stateName:thread1][activity][code:System.out.println(\"Hello\");][stateMachine][name:stateMachine2][state][stateName:topLevel][state][stateName:thread1][activity][code:System.out.println(\"Hello2\");][classDefinition][name:Door][stateMachine][name:stateMachine1][state][stateName:topLevel][state][stateName:thread1][activity][code:System.out.println(\"Different Active Objects Number\");]");
  }

  @Test
  public void activeBlock_supportingLanguageSpecific()
  {
    assertParse("160_activeBlock_supportingLanguageSpecific.ump", "[classDefinition][name:Lamp][stateMachine][name:stateMachine1][state][stateName:topLevel][state][stateName:thread1][activity][codeLang:Java][code:System.out.println(\"Hello\");][codeLang:Cpp][code:cout << \"hello\";]");
    UmpleClass c = model.getUmpleClass("Lamp");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);

    Assert.assertEquals(1, sm.numberOfStates());
    State topLevel = sm.getState(0);

    Assert.assertEquals(1, topLevel.numberOfNestedStateMachines());
    StateMachine threadLevel = topLevel.getNestedStateMachine(0);

    Assert.assertEquals(1, threadLevel.numberOfStates());
    State doLevel = threadLevel.getState(0);

    Assert.assertEquals(true, doLevel.hasActivities());
    Assert.assertEquals("System.out.println(\"Hello\");", doLevel.getActivity(0).getCodeblock().getCode("Java"));
    Assert.assertEquals("cout << \"hello\";", doLevel.getActivity(0).getCodeblock().getCode("Cpp"));
  }

  @Test
  public void activeBlock_ActivityPositions()
  {
    // Single active block (no languages specified)
    assertParse("160_activeblock.ump", "[classDefinition][name:Lamp][stateMachine][name:stateMachine1][state][stateName:topLevel][state][stateName:thread1][activity][code:System.out.println(\"Hello\");]");
    UmpleClass c = model.getUmpleClass("Lamp");
    Assert.assertEquals(1, c.numberOfStateMachines());
    StateMachine sm = c.getStateMachine(0);

    Assert.assertEquals(1, sm.numberOfStates());
    State topLevel = sm.getState(0);

    Assert.assertEquals(1, topLevel.numberOfNestedStateMachines());
    StateMachine threadLevel = topLevel.getNestedStateMachine(0);

    Assert.assertEquals(1, threadLevel.numberOfStates());
    State doLevel = threadLevel.getState(0);

    Assert.assertEquals(true, doLevel.hasActivities());
    Activity a = doLevel.getActivity(0);

    // Check start position of active object
    Assert.assertEquals("160_activeblock.ump", a.getPosition().getFilename());
    Assert.assertEquals(3, a.getPosition().getLineNumber());
    Assert.assertEquals(2, a.getPosition().getCharacterOffset());
    Assert.assertEquals(16, a.getPosition().getOffset());

    // Check end position of active object
    Assert.assertEquals("160_activeblock.ump", a.getEndPosition().getFilename());
    Assert.assertEquals(1, a.getEndPosition().getLineNumber());
    Assert.assertEquals(65, a.getEndPosition().getCharacterOffset());
    Assert.assertEquals(65, a.getEndPosition().getOffset());

    // Multiple active blocks with multiple languages
    assertParse("160_activeBlock_supportingLanguageSpecific.ump", "[classDefinition][name:Lamp][stateMachine][name:stateMachine1][state][stateName:topLevel][state][stateName:thread1][activity][codeLang:Java][code:System.out.println(\"Hello\");][codeLang:Cpp][code:cout << \"hello\";]");
    c = model.getUmpleClass("Lamp");
    Assert.assertEquals(1, c.numberOfStateMachines());
    sm = c.getStateMachine(0);

    Assert.assertEquals(1, sm.numberOfStates());
    topLevel = sm.getState(0);

    Assert.assertEquals(1, topLevel.numberOfNestedStateMachines());
    threadLevel = topLevel.getNestedStateMachine(0);

    Assert.assertEquals(1, threadLevel.numberOfStates());
    doLevel = threadLevel.getState(0);

    Assert.assertEquals(1, doLevel.numberOfActivities());

    // Check start position of active object
    Position p = doLevel.getActivity(0).getPosition();
    Assert.assertEquals("160_activeBlock_supportingLanguageSpecific.ump", p.getFilename());
    Assert.assertEquals(4, p.getLineNumber());
    Assert.assertEquals(2, p.getCharacterOffset());
    Assert.assertEquals(19, p.getOffset());

    // Check end position of active object
    Position endP = doLevel.getActivity(0).getEndPosition();
    Assert.assertEquals("160_activeBlock_supportingLanguageSpecific.ump", p.getFilename());
    Assert.assertEquals(1, endP.getLineNumber());
    Assert.assertEquals(99, endP.getCharacterOffset());
    Assert.assertEquals(99, endP.getOffset());
  }

  @Test
  public void activeBlock_MultiLanguagePositions()
  {
    assertParse("160_activeBlock_supportingLanguageSpecific.ump", "[classDefinition][name:Lamp][stateMachine][name:stateMachine1][state][stateName:topLevel][state][stateName:thread1][activity][codeLang:Java][code:System.out.println(\"Hello\");][codeLang:Cpp][code:cout << \"hello\";]");
    UmpleClass c = model.getUmpleClass("Lamp");
    State topLevel = c.getStateMachine(0).getState(0);
    Activity a = topLevel.getNestedStateMachine(0).getState(0).getActivity(0);

    CodeBlock cb = a.getCodeblock();
    Assert.assertEquals(true, cb.hasCode("Java"));
    Assert.assertEquals(false, cb.hasCode("Php"));
    Assert.assertEquals(true, cb.hasCode("Cpp"));
    Assert.assertEquals(false, cb.hasCode(""));

    Position jPos = a.getImplementationPositions().get("Java");
    Assert.assertEquals(4, jPos.getLineNumber());
    Assert.assertEquals(9, jPos.getCharacterOffset());
    Assert.assertEquals("160_activeBlock_supportingLanguageSpecific.ump", jPos.getFilename());

    Position cPos = a.getImplementationPositions().get("Cpp");
    Assert.assertEquals(6, cPos.getLineNumber());
    Assert.assertEquals(4, cPos.getCharacterOffset());
    Assert.assertEquals("160_activeBlock_supportingLanguageSpecific.ump", cPos.getFilename());

    // Check positions for single language active block
    assertParse("160_activeblock.ump", "[classDefinition][name:Lamp][stateMachine][name:stateMachine1][state][stateName:topLevel][state][stateName:thread1][activity][code:System.out.println(\"Hello\");]");
    c = model.getUmpleClass("Lamp");
    topLevel = c.getStateMachine(0).getState(0);
    a = topLevel.getNestedStateMachine(0).getState(0).getActivity(0);
    cb = a.getCodeblock();

    Assert.assertEquals(true, cb.hasCode(""));
    Position nPos = a.getImplementationPositions().get("");
    Assert.assertEquals(5, nPos.getLineNumber());
    Assert.assertEquals(4, nPos.getCharacterOffset());
    Assert.assertEquals("160_activeblock.ump", nPos.getFilename());

  }

  @Test
  public void oneState_StateMachine_GraphDFS()
  {
    assertParse("100_oneState_StateMachine.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    Assert.assertEquals(isDFS, graph.isDepthFirst());
    Assert.assertEquals(true, graph.hasNext());
    Assert.assertEquals(true, startNode.getIsVisited());
    Assert.assertEquals(startNode, graph.nextNode());
    Assert.assertEquals(false, graph.hasNext());
  }

  @Test
  public void oneState_StateMachine_GraphBFS()
  {
    assertParse("100_oneState_StateMachine.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:bulb][state][stateName:On]");

    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    Assert.assertEquals(isDFS, graph.isDepthFirst());
    Assert.assertEquals(true, graph.hasNext());
    Assert.assertEquals(true, startNode.getIsVisited());
    Assert.assertEquals(startNode, graph.nextNode());
    Assert.assertEquals(false, graph.hasNext());
  }

  @Test
  public void twoState_StateMachine_GraphDFS()
  {
    assertParse("100_emptyAndNonEmptyStates.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;

    Assert.assertEquals(isDFS, graph.isDepthFirst());
    Assert.assertEquals(true, graph.hasNext());
    Assert.assertEquals(true, startNode.getIsVisited());

    state = (State) graph.nextNode();
    Assert.assertEquals(startNode, state);
    Assert.assertEquals("On", state.getName());
    Assert.assertEquals(true, startNode.getIsVisited());
    Assert.assertEquals(true, state.getIsVisited());

    Assert.assertEquals(true, graph.hasNext());  
    state = (State) graph.nextNode();
    Assert.assertEquals("Off", state.getName());
    Assert.assertEquals(true, state.getIsVisited());  

    Assert.assertEquals(false, graph.hasNext());
  }

  @Test
  public void twoState_StateMachine_GraphBFS()
  {
    assertParse("100_emptyAndNonEmptyStates.ump", "[classDefinition][name:LightFixture][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off]");
    UmpleClass c = model.getUmpleClass("LightFixture");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;

    Assert.assertEquals(isDFS, graph.isDepthFirst());
    Assert.assertEquals(true, graph.hasNext());
    Assert.assertEquals(true, startNode.getIsVisited());

    state = (State) graph.nextNode();
    Assert.assertEquals(startNode, state);
    Assert.assertEquals("On", state.getName());
    Assert.assertEquals(true, startNode.getIsVisited());
    Assert.assertEquals(true, state.getIsVisited());

    Assert.assertEquals(true, graph.hasNext());  
    state = (State) graph.nextNode();
    Assert.assertEquals("Off", state.getName());
    Assert.assertEquals(true, state.getIsVisited());  

    Assert.assertEquals(false, graph.hasNext());
  }

  @Test
  public void unreachableState_StateMachine_GraphDFS()
  {
    assertParse("100_nonReachableState.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:s1][state][stateName:s2]");
    UmpleClass c = model.getUmpleClass("X");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;

    Assert.assertEquals(true, graph.hasNext());
    state = (State) graph.nextNode();

    Assert.assertEquals("s1", state.getName());
    Assert.assertEquals(true, state.getIsVisited());  

    Assert.assertEquals(false, graph.hasNext()); 
  }

  @Test
  public void unreachableState_StateMachine_GraphBFS()
  {
    assertParse("100_nonReachableState.ump", "[classDefinition][name:X][stateMachine][inlineStateMachine][name:sm][state][stateName:s1][state][stateName:s2]");
    UmpleClass c = model.getUmpleClass("X");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;

    Assert.assertEquals(true, graph.hasNext());
    state = (State) graph.nextNode();

    Assert.assertEquals("s1", state.getName());
    Assert.assertEquals(true, state.getIsVisited());  

    Assert.assertEquals(false, graph.hasNext()); 
  }

  @Test
  public void twoStateLoop_StateMachine_GraphDFS()
  {
    assertParse("180_twoState_loop.ump", "[classDefinition][name:LightSwitch][stateMachine][inlineStateMachine][name:Light][state][stateName:On][transition][event:push][stateName:Off][state][stateName:Off][transition][event:push][stateName:On]");
    UmpleClass c = model.getUmpleClass("LightSwitch");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;

    Assert.assertEquals(true, graph.hasNext());
    state = (State) graph.nextNode();
    Assert.assertEquals("On", state.getName());
    Assert.assertEquals(true, state.getIsVisited());

    Assert.assertEquals(true, graph.hasNext());
    state = (State) graph.nextNode();
    Assert.assertEquals("Off", state.getName());
    Assert.assertEquals(true, state.getIsVisited());

    Assert.assertEquals(false, graph.hasNext());
  }

  @Test
  public void twoStateLoop_StateMachine_GraphBFS()
  {
    assertParse("180_twoState_loop.ump", "[classDefinition][name:LightSwitch][stateMachine][inlineStateMachine][name:Light][state][stateName:On][transition][event:push][stateName:Off][state][stateName:Off][transition][event:push][stateName:On]");
    UmpleClass c = model.getUmpleClass("LightSwitch");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;

    Assert.assertEquals(true, graph.hasNext());
    state = (State) graph.nextNode();
    Assert.assertEquals("On", state.getName());
    Assert.assertEquals(true, state.getIsVisited());

    Assert.assertEquals(true, graph.hasNext());
    state = (State) graph.nextNode();
    Assert.assertEquals("Off", state.getName());
    Assert.assertEquals(true, state.getIsVisited());

    Assert.assertEquals(false, graph.hasNext());
  }

  @Test
  public void ordering_StateMachine_GraphDFS()
  {
    assertParse("180_DFSBFS_Comparison_StateMachine.ump","[classDefinition][name:ExampleSM][stateMachine][inlineStateMachine][name:SM][state][stateName:s1][transition][event:p2][stateName:s2][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4][state][stateName:s2][transition][event:p1][stateName:s1][transition][event:p5][stateName:s5][state][stateName:s3][state][stateName:s4][transition][event:p7][stateName:s7][state][stateName:s5][transition][event:p6][stateName:s6][state][stateName:s6][state][stateName:s7]");
    UmpleClass c = model.getUmpleClass("ExampleSM");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("s1");
    expectedStates.add("s4");
    expectedStates.add("s7");
    expectedStates.add("s3");
    expectedStates.add("s2");
    expectedStates.add("s5");
    expectedStates.add("s6");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void ordering_StateMachine_GraphBFS()
  {
    assertParse("180_DFSBFS_Comparison_StateMachine.ump","[classDefinition][name:ExampleSM][stateMachine][inlineStateMachine][name:SM][state][stateName:s1][transition][event:p2][stateName:s2][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4][state][stateName:s2][transition][event:p1][stateName:s1][transition][event:p5][stateName:s5][state][stateName:s3][state][stateName:s4][transition][event:p7][stateName:s7][state][stateName:s5][transition][event:p6][stateName:s6][state][stateName:s6][state][stateName:s7]");
    UmpleClass c = model.getUmpleClass("ExampleSM");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("s1");
    expectedStates.add("s2");
    expectedStates.add("s3");
    expectedStates.add("s4");
    expectedStates.add("s5");
    expectedStates.add("s7");
    expectedStates.add("s6");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test 
  public void largeFlat_StateMachine_GraphDFS()
  {

  }

  @Test
  public void c6_StateMachine_GraphDFS()
  {
    assertParse("180_C6_StateMachine.ump","[classDefinition][name:ExampleSM][stateMachine][inlineStateMachine][name:SM][state][stateName:s1][transition][event:p2][stateName:s2][state][stateName:s2][transition][event:p3][stateName:s3][state][stateName:s3][transition][event:p4][stateName:s4][state][stateName:s4][transition][event:p5][stateName:s5][state][stateName:s5][transition][event:p6][stateName:s6][state][stateName:s6][transition][event:p1][stateName:s1]");
    UmpleClass c = model.getUmpleClass("ExampleSM");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("s1");
    expectedStates.add("s2");
    expectedStates.add("s3");
    expectedStates.add("s4");
    expectedStates.add("s5");
    expectedStates.add("s6");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void c6_StateMachine_GraphBFS()
  {
    assertParse("180_C6_StateMachine.ump","[classDefinition][name:ExampleSM][stateMachine][inlineStateMachine][name:SM][state][stateName:s1][transition][event:p2][stateName:s2][state][stateName:s2][transition][event:p3][stateName:s3][state][stateName:s3][transition][event:p4][stateName:s4][state][stateName:s4][transition][event:p5][stateName:s5][state][stateName:s5][transition][event:p6][stateName:s6][state][stateName:s6][transition][event:p1][stateName:s1]");
    UmpleClass c = model.getUmpleClass("ExampleSM");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("s1");
    expectedStates.add("s2");
    expectedStates.add("s3");
    expectedStates.add("s4");
    expectedStates.add("s5");
    expectedStates.add("s6");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void k5_StateMachine_GraphDFS()
  {
    assertParse("180_K5_StateMachine.ump","[classDefinition][name:ExampleSM][stateMachine][inlineStateMachine][name:SM][state][stateName:s1][transition][event:p2][stateName:s2][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4][transition][event:p5][stateName:s5][state][stateName:s2][transition][event:p1][stateName:s1][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4][transition][event:p5][stateName:s5][state][stateName:s3][transition][event:p1][stateName:s1][transition][event:p2][stateName:s2][transition][event:p4][stateName:s4][transition][event:p5][stateName:s5][state][stateName:s4][transition][event:p1][stateName:s1][transition][event:p2][stateName:s2][transition][event:p3][stateName:s3][transition][event:p5][stateName:s5][state][stateName:s5][transition][event:p1][stateName:s1][transition][event:p2][stateName:s2][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4]");
    UmpleClass c = model.getUmpleClass("ExampleSM");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("s1");
    expectedStates.add("s5");
    expectedStates.add("s4");
    expectedStates.add("s3");
    expectedStates.add("s2");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void k5_StateMachine_GraphBFS()
  {
    assertParse("180_K5_StateMachine.ump","[classDefinition][name:ExampleSM][stateMachine][inlineStateMachine][name:SM][state][stateName:s1][transition][event:p2][stateName:s2][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4][transition][event:p5][stateName:s5][state][stateName:s2][transition][event:p1][stateName:s1][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4][transition][event:p5][stateName:s5][state][stateName:s3][transition][event:p1][stateName:s1][transition][event:p2][stateName:s2][transition][event:p4][stateName:s4][transition][event:p5][stateName:s5][state][stateName:s4][transition][event:p1][stateName:s1][transition][event:p2][stateName:s2][transition][event:p3][stateName:s3][transition][event:p5][stateName:s5][state][stateName:s5][transition][event:p1][stateName:s1][transition][event:p2][stateName:s2][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4]");
    UmpleClass c = model.getUmpleClass("ExampleSM");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("s1");
    expectedStates.add("s2");
    expectedStates.add("s3");
    expectedStates.add("s4");
    expectedStates.add("s5");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void tree_StateMachine_GraphDFS()
  {
    assertParse("180_Tree7_StateMachine.ump","[classDefinition][name:ExampleSM][stateMachine][inlineStateMachine][name:SM][state][stateName:s1][transition][event:p2][stateName:s2][state][stateName:s2][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4][transition][event:p6][stateName:s6][state][stateName:s3][transition][event:p5][stateName:s5][state][stateName:s4][state][stateName:s5][state][stateName:s6][transition][event:p7][stateName:s7][transition][event:p8][stateName:s8][state][stateName:s7][state][stateName:s8]");
    UmpleClass c = model.getUmpleClass("ExampleSM");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("s1");
    expectedStates.add("s2");
    expectedStates.add("s6");
    expectedStates.add("s8");
    expectedStates.add("s7");
    expectedStates.add("s4");
    expectedStates.add("s3");
    expectedStates.add("s5");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void tree_StateMachine_GraphBFS()
  {
    assertParse("180_Tree7_StateMachine.ump","[classDefinition][name:ExampleSM][stateMachine][inlineStateMachine][name:SM][state][stateName:s1][transition][event:p2][stateName:s2][state][stateName:s2][transition][event:p3][stateName:s3][transition][event:p4][stateName:s4][transition][event:p6][stateName:s6][state][stateName:s3][transition][event:p5][stateName:s5][state][stateName:s4][state][stateName:s5][state][stateName:s6][transition][event:p7][stateName:s7][transition][event:p8][stateName:s8][state][stateName:s7][state][stateName:s8]");
    UmpleClass c = model.getUmpleClass("ExampleSM");
    StateMachine sm = c.getStateMachine(0);
    State startNode = sm.getStartState();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("s1");
    expectedStates.add("s2");
    expectedStates.add("s3");
    expectedStates.add("s4");
    expectedStates.add("s6");
    expectedStates.add("s5");
    expectedStates.add("s7");
    expectedStates.add("s8");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void nested2_StateMachine_GraphDFS()
  {
    assertParse("101_Nested_realExample2.ump","[classDefinition][name:StrobeLight][stateMachine][inlineStateMachine][name:dvdPlayer][state][stateName:Off][transition][event:turnOn][stateName:On][state][stateName:Sleep][transition][event:wake][stateName:Pause][state][stateName:On][transition][event:turnOff][stateName:Off][state][stateName:Play][transition][event:push][stateName:Pause][state][stateName:Pause][transition][event:push][stateName:Play][transition][event:standby][stateName:Sleep]");
    UmpleClass c = model.getUmpleClass("StrobeLight");
    StateMachine sm = c.getStateMachine(0).getState(2).getNestedStateMachine(0);

    State startNode = sm.getStartState();
    String smName = sm.getName();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, smName, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("Play");
    expectedStates.add("Pause");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }


  @Test
  public void nested2_StateMachine_GraphBFS()
  {
    assertParse("101_Nested_realExample2.ump","[classDefinition][name:StrobeLight][stateMachine][inlineStateMachine][name:dvdPlayer][state][stateName:Off][transition][event:turnOn][stateName:On][state][stateName:Sleep][transition][event:wake][stateName:Pause][state][stateName:On][transition][event:turnOff][stateName:Off][state][stateName:Play][transition][event:push][stateName:Pause][state][stateName:Pause][transition][event:push][stateName:Play][transition][event:standby][stateName:Sleep]");
    UmpleClass c = model.getUmpleClass("StrobeLight");
    StateMachine sm = c.getStateMachine(0).getState(2).getNestedStateMachine(0);

    State startNode = sm.getStartState();
    String smName = sm.getName();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, smName, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("Play");
    expectedStates.add("Pause");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void doubleNested_StateMachine_GraphDFS()
  {
    assertParse("180_nested_stopWatch.ump","[classDefinition][name:DigitalWatch][inlineComment:sx indicates that button X has been pressed][inlineComment:notSx indicates button x has been released][stateMachine][inlineStateMachine][name:sm][inlineComment:Main state displaying time][state][stateName:regular][state][stateName:time][transition][event:s1][stateName:date][transition][event:s2][stateName:alarmStatus][transition][event:s3][stateName:chronometer][transition][event:s3during2Secs][stateName:alarmTime][state][stateName:date][transition][event:notS1][stateName:time][state][stateName:update][transition][event:s3][stateName:time][inlineComment:States related to time update][state][stateName:second][transition][event:s1][stateName:minute][transition][event:s2][action][code:secondzero();][stateName:second][state][stateName:minute][transition][event:s1][stateName:hour][transition][event:s2][action][code:minute++;][stateName:minute][state][stateName:hour][transition][event:s1][stateName:month][transition][event:s2][action][code:hour++;][stateName:hour][state][stateName:month][transition][event:s1][stateName:day][transition][event:s2][action][code:month++;][stateName:month][state][stateName:day][transition][event:s1][stateName:year][transition][event:s2][action][code:day++;][stateName:day][state][stateName:year][transition][event:s1][stateName:second][transition][event:s2][action][code:year++;][stateName:year][inlineComment:States related to timer][state][stateName:chronometer][transition][event:s3][stateName:time][state][stateName:chronoNormal][state][stateName:paused][transition][event:s1][stateName:running][transition][event:s2][action][code:zero();][stateName:paused][state][stateName:running][transition][event:s1][stateName:paused][transition][event:s2][stateName:lapRunning][state][stateName:lapRunning][transition][event:s1][stateName:lapPaused][transition][event:s2][stateName:running][state][stateName:lapPaused][transition][event:s1][stateName:lapRunning][transition][event:s2][stateName:paused][inlineComment:States related to turning on and off charm or chime][state][stateName:alarmStatus][transition][event:notS2][stateName:time][state][stateName:bothOff][transition][event:s1][stateName:chimeOn][state][stateName:chimeOn][transition][event:s1][stateName:bothOn][state][stateName:bothOn][transition][event:s1][stateName:alarmOn][state][stateName:alarmOn][transition][event:s1][stateName:bothOff][inlineComment:States related to alarm update][state][stateName:alarmUpdate][transition][event:s3][stateName:second][state][stateName:alarmTime][transition][event:s1][stateName:alarmMinute][transition][event:s2][action][code:alarmHour++;][stateName:alarmHour][state][stateName:hourMinuteUpdate][state][stateName:alarmHour][transition][event:s1][stateName:alarmMinute][transition][event:s2][action][code:alarmHour++;][stateName:alarmHour][state][stateName:alarmMinute][transition][event:s1][stateName:alarmHour][transition][event:s2][action][code:alarmMinute++;][stateName:alarmMinute][attribute][type:Integer][name:day][value:0][attribute][type:Integer][name:month][value:0][attribute][type:Integer][name:year][value:2014][attribute][type:Integer][name:hour][value:0][attribute][type:Integer][name:minute][value:0][attribute][type:Integer][name:second][value:0][attribute][type:Integer][name:alarmHour][value:0][attribute][type:Integer][name:alarmMinute][value:0][attribute][type:Integer][name:alarmSecond][value:0][attribute][type:Integer][name:timer][value:0][concreteMethodDeclaration][type:void][methodDeclarator][methodName:secondzero][parameterList][code:setSecond(0);][concreteMethodDeclaration][type:void][methodDeclarator][methodName:zero][parameterList][code:setTimer(0);]");
    UmpleClass c = model.getUmpleClass("DigitalWatch");
    StateMachine sm = c.getStateMachine(0).getState(0).getNestedStateMachine(0);

    Assert.assertEquals("regular", sm.getName());

    State startNode = sm.getStartState();
    String smName = sm.getName();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, smName, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("time");
    expectedStates.add("date");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void doubleNested_StateMachine_GraphBFS()
  {
    assertParse("180_nested_stopWatch.ump","[classDefinition][name:DigitalWatch][inlineComment:sx indicates that button X has been pressed][inlineComment:notSx indicates button x has been released][stateMachine][inlineStateMachine][name:sm][inlineComment:Main state displaying time][state][stateName:regular][state][stateName:time][transition][event:s1][stateName:date][transition][event:s2][stateName:alarmStatus][transition][event:s3][stateName:chronometer][transition][event:s3during2Secs][stateName:alarmTime][state][stateName:date][transition][event:notS1][stateName:time][state][stateName:update][transition][event:s3][stateName:time][inlineComment:States related to time update][state][stateName:second][transition][event:s1][stateName:minute][transition][event:s2][action][code:secondzero();][stateName:second][state][stateName:minute][transition][event:s1][stateName:hour][transition][event:s2][action][code:minute++;][stateName:minute][state][stateName:hour][transition][event:s1][stateName:month][transition][event:s2][action][code:hour++;][stateName:hour][state][stateName:month][transition][event:s1][stateName:day][transition][event:s2][action][code:month++;][stateName:month][state][stateName:day][transition][event:s1][stateName:year][transition][event:s2][action][code:day++;][stateName:day][state][stateName:year][transition][event:s1][stateName:second][transition][event:s2][action][code:year++;][stateName:year][inlineComment:States related to timer][state][stateName:chronometer][transition][event:s3][stateName:time][state][stateName:chronoNormal][state][stateName:paused][transition][event:s1][stateName:running][transition][event:s2][action][code:zero();][stateName:paused][state][stateName:running][transition][event:s1][stateName:paused][transition][event:s2][stateName:lapRunning][state][stateName:lapRunning][transition][event:s1][stateName:lapPaused][transition][event:s2][stateName:running][state][stateName:lapPaused][transition][event:s1][stateName:lapRunning][transition][event:s2][stateName:paused][inlineComment:States related to turning on and off charm or chime][state][stateName:alarmStatus][transition][event:notS2][stateName:time][state][stateName:bothOff][transition][event:s1][stateName:chimeOn][state][stateName:chimeOn][transition][event:s1][stateName:bothOn][state][stateName:bothOn][transition][event:s1][stateName:alarmOn][state][stateName:alarmOn][transition][event:s1][stateName:bothOff][inlineComment:States related to alarm update][state][stateName:alarmUpdate][transition][event:s3][stateName:second][state][stateName:alarmTime][transition][event:s1][stateName:alarmMinute][transition][event:s2][action][code:alarmHour++;][stateName:alarmHour][state][stateName:hourMinuteUpdate][state][stateName:alarmHour][transition][event:s1][stateName:alarmMinute][transition][event:s2][action][code:alarmHour++;][stateName:alarmHour][state][stateName:alarmMinute][transition][event:s1][stateName:alarmHour][transition][event:s2][action][code:alarmMinute++;][stateName:alarmMinute][attribute][type:Integer][name:day][value:0][attribute][type:Integer][name:month][value:0][attribute][type:Integer][name:year][value:2014][attribute][type:Integer][name:hour][value:0][attribute][type:Integer][name:minute][value:0][attribute][type:Integer][name:second][value:0][attribute][type:Integer][name:alarmHour][value:0][attribute][type:Integer][name:alarmMinute][value:0][attribute][type:Integer][name:alarmSecond][value:0][attribute][type:Integer][name:timer][value:0][concreteMethodDeclaration][type:void][methodDeclarator][methodName:secondzero][parameterList][code:setSecond(0);][concreteMethodDeclaration][type:void][methodDeclarator][methodName:zero][parameterList][code:setTimer(0);]");
    UmpleClass c = model.getUmpleClass("DigitalWatch");
    StateMachine sm = c.getStateMachine(0).getState(0).getNestedStateMachine(0);

    Assert.assertEquals("regular", sm.getName());

    State startNode = sm.getStartState();
    String smName = sm.getName();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, smName, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("time");
    expectedStates.add("date");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);
  }

  @Test
  public void doubleNested_twoLevels_StateMachine_GraphDFS()
  {
    assertParse("180_nested_stopWatch.ump","[classDefinition][name:DigitalWatch][inlineComment:sx indicates that button X has been pressed][inlineComment:notSx indicates button x has been released][stateMachine][inlineStateMachine][name:sm][inlineComment:Main state displaying time][state][stateName:regular][state][stateName:time][transition][event:s1][stateName:date][transition][event:s2][stateName:alarmStatus][transition][event:s3][stateName:chronometer][transition][event:s3during2Secs][stateName:alarmTime][state][stateName:date][transition][event:notS1][stateName:time][state][stateName:update][transition][event:s3][stateName:time][inlineComment:States related to time update][state][stateName:second][transition][event:s1][stateName:minute][transition][event:s2][action][code:secondzero();][stateName:second][state][stateName:minute][transition][event:s1][stateName:hour][transition][event:s2][action][code:minute++;][stateName:minute][state][stateName:hour][transition][event:s1][stateName:month][transition][event:s2][action][code:hour++;][stateName:hour][state][stateName:month][transition][event:s1][stateName:day][transition][event:s2][action][code:month++;][stateName:month][state][stateName:day][transition][event:s1][stateName:year][transition][event:s2][action][code:day++;][stateName:day][state][stateName:year][transition][event:s1][stateName:second][transition][event:s2][action][code:year++;][stateName:year][inlineComment:States related to timer][state][stateName:chronometer][transition][event:s3][stateName:time][state][stateName:chronoNormal][state][stateName:paused][transition][event:s1][stateName:running][transition][event:s2][action][code:zero();][stateName:paused][state][stateName:running][transition][event:s1][stateName:paused][transition][event:s2][stateName:lapRunning][state][stateName:lapRunning][transition][event:s1][stateName:lapPaused][transition][event:s2][stateName:running][state][stateName:lapPaused][transition][event:s1][stateName:lapRunning][transition][event:s2][stateName:paused][inlineComment:States related to turning on and off charm or chime][state][stateName:alarmStatus][transition][event:notS2][stateName:time][state][stateName:bothOff][transition][event:s1][stateName:chimeOn][state][stateName:chimeOn][transition][event:s1][stateName:bothOn][state][stateName:bothOn][transition][event:s1][stateName:alarmOn][state][stateName:alarmOn][transition][event:s1][stateName:bothOff][inlineComment:States related to alarm update][state][stateName:alarmUpdate][transition][event:s3][stateName:second][state][stateName:alarmTime][transition][event:s1][stateName:alarmMinute][transition][event:s2][action][code:alarmHour++;][stateName:alarmHour][state][stateName:hourMinuteUpdate][state][stateName:alarmHour][transition][event:s1][stateName:alarmMinute][transition][event:s2][action][code:alarmHour++;][stateName:alarmHour][state][stateName:alarmMinute][transition][event:s1][stateName:alarmHour][transition][event:s2][action][code:alarmMinute++;][stateName:alarmMinute][attribute][type:Integer][name:day][value:0][attribute][type:Integer][name:month][value:0][attribute][type:Integer][name:year][value:2014][attribute][type:Integer][name:hour][value:0][attribute][type:Integer][name:minute][value:0][attribute][type:Integer][name:second][value:0][attribute][type:Integer][name:alarmHour][value:0][attribute][type:Integer][name:alarmMinute][value:0][attribute][type:Integer][name:alarmSecond][value:0][attribute][type:Integer][name:timer][value:0][concreteMethodDeclaration][type:void][methodDeclarator][methodName:secondzero][parameterList][code:setSecond(0);][concreteMethodDeclaration][type:void][methodDeclarator][methodName:zero][parameterList][code:setTimer(0);]");
    UmpleClass c = model.getUmpleClass("DigitalWatch");
    StateMachine sm = c.getStateMachine(0).getState(0).getNestedStateMachine(0);


    State startNode = sm.getStartState();
    String smName = sm.getName();
    boolean isDFS = true;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, smName, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("time");
    expectedStates.add("date");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);

    expectedStates.clear();
    returnedStates.clear();

    sm = c.getStateMachine(0).getState(0).getNestedStateMachine(0);
    sm = sm.getState(2).getNestedStateMachine(0);

    Assert.assertEquals("update", sm.getName()); 

    startNode = sm.getStartState();
    smName = sm.getName();
    graph = new StateMachineLevelGraph(startNode, smName, isDFS);
    
    expectedStates.add("second");
    expectedStates.add("minute");
    expectedStates.add("hour");
    expectedStates.add("month");
    expectedStates.add("day");
    expectedStates.add("year");

    while(graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);

  }

  @Test
  public void doubleNested_twoLevels_StateMachine_GraphBFS()
  {
    assertParse("180_nested_stopWatch.ump","[classDefinition][name:DigitalWatch][inlineComment:sx indicates that button X has been pressed][inlineComment:notSx indicates button x has been released][stateMachine][inlineStateMachine][name:sm][inlineComment:Main state displaying time][state][stateName:regular][state][stateName:time][transition][event:s1][stateName:date][transition][event:s2][stateName:alarmStatus][transition][event:s3][stateName:chronometer][transition][event:s3during2Secs][stateName:alarmTime][state][stateName:date][transition][event:notS1][stateName:time][state][stateName:update][transition][event:s3][stateName:time][inlineComment:States related to time update][state][stateName:second][transition][event:s1][stateName:minute][transition][event:s2][action][code:secondzero();][stateName:second][state][stateName:minute][transition][event:s1][stateName:hour][transition][event:s2][action][code:minute++;][stateName:minute][state][stateName:hour][transition][event:s1][stateName:month][transition][event:s2][action][code:hour++;][stateName:hour][state][stateName:month][transition][event:s1][stateName:day][transition][event:s2][action][code:month++;][stateName:month][state][stateName:day][transition][event:s1][stateName:year][transition][event:s2][action][code:day++;][stateName:day][state][stateName:year][transition][event:s1][stateName:second][transition][event:s2][action][code:year++;][stateName:year][inlineComment:States related to timer][state][stateName:chronometer][transition][event:s3][stateName:time][state][stateName:chronoNormal][state][stateName:paused][transition][event:s1][stateName:running][transition][event:s2][action][code:zero();][stateName:paused][state][stateName:running][transition][event:s1][stateName:paused][transition][event:s2][stateName:lapRunning][state][stateName:lapRunning][transition][event:s1][stateName:lapPaused][transition][event:s2][stateName:running][state][stateName:lapPaused][transition][event:s1][stateName:lapRunning][transition][event:s2][stateName:paused][inlineComment:States related to turning on and off charm or chime][state][stateName:alarmStatus][transition][event:notS2][stateName:time][state][stateName:bothOff][transition][event:s1][stateName:chimeOn][state][stateName:chimeOn][transition][event:s1][stateName:bothOn][state][stateName:bothOn][transition][event:s1][stateName:alarmOn][state][stateName:alarmOn][transition][event:s1][stateName:bothOff][inlineComment:States related to alarm update][state][stateName:alarmUpdate][transition][event:s3][stateName:second][state][stateName:alarmTime][transition][event:s1][stateName:alarmMinute][transition][event:s2][action][code:alarmHour++;][stateName:alarmHour][state][stateName:hourMinuteUpdate][state][stateName:alarmHour][transition][event:s1][stateName:alarmMinute][transition][event:s2][action][code:alarmHour++;][stateName:alarmHour][state][stateName:alarmMinute][transition][event:s1][stateName:alarmHour][transition][event:s2][action][code:alarmMinute++;][stateName:alarmMinute][attribute][type:Integer][name:day][value:0][attribute][type:Integer][name:month][value:0][attribute][type:Integer][name:year][value:2014][attribute][type:Integer][name:hour][value:0][attribute][type:Integer][name:minute][value:0][attribute][type:Integer][name:second][value:0][attribute][type:Integer][name:alarmHour][value:0][attribute][type:Integer][name:alarmMinute][value:0][attribute][type:Integer][name:alarmSecond][value:0][attribute][type:Integer][name:timer][value:0][concreteMethodDeclaration][type:void][methodDeclarator][methodName:secondzero][parameterList][code:setSecond(0);][concreteMethodDeclaration][type:void][methodDeclarator][methodName:zero][parameterList][code:setTimer(0);]");
    UmpleClass c = model.getUmpleClass("DigitalWatch");
    StateMachine sm = c.getStateMachine(0).getState(0).getNestedStateMachine(0);


    State startNode = sm.getStartState();
    String smName = sm.getName();
    boolean isDFS = false;
    StateMachineLevelGraph graph = new StateMachineLevelGraph(startNode, smName, isDFS);
    State state;
    ArrayList<String> expectedStates, returnedStates;
    expectedStates = new ArrayList<String>();
    expectedStates.add("time");
    expectedStates.add("date");

    returnedStates = new ArrayList<String>();

    while (graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);

    expectedStates.clear();
    returnedStates.clear();

    sm = c.getStateMachine(0).getState(0).getNestedStateMachine(0);
    sm = sm.getState(2).getNestedStateMachine(0);

    Assert.assertEquals("update", sm.getName()); 

    startNode = sm.getStartState();
    smName = sm.getName();
    graph = new StateMachineLevelGraph(startNode, smName, isDFS);
    
    expectedStates.add("second");
    expectedStates.add("minute");
    expectedStates.add("hour");
    expectedStates.add("month");
    expectedStates.add("day");
    expectedStates.add("year");

    while(graph.hasNext())
    {
      state = (State) graph.nextNode();
      returnedStates.add(state.getName());
    }

    Assert.assertEquals(expectedStates, returnedStates);

  }


  private void assertParse(String filename, String expectedOutput)
  {
    assertParse(filename, expectedOutput, true);
  }

  public void assertFailedParse(String filename, Position expectedPosition, int expectedError)
  {
    UmpleFile file = new UmpleFile(pathToInput, filename);
    model = new UmpleModel(new UmpleFile(pathToInput, filename));
    model.setShouldGenerate(false);
    RuleBasedParser rbp = new RuleBasedParser(model);
    parser = new UmpleInternalParser(umpleParserName, model, rbp);
    ParseResult answer = rbp.parse(file);
    if (answer.getWasSuccess())
    {
      answer = parser.analyze(false);
    }

    Assert.assertEquals(false, answer.getWasSuccess());
    // Assert.assertEquals(true, parser.getParseResult().getHasWarnings());
    Assert.assertNotNull(answer.getErrorMessage(0));
    Assert.assertEquals(expectedError, answer.getErrorMessage(0).getErrorType().getErrorCode());
    System.err.println(expectedPosition.getOffset() + " " + answer.getErrorMessage(0).getPosition().getOffset());
    Assert.assertEquals(expectedPosition, answer.getErrorMessage(0).getPosition());
  }

  private void assertNoWarnings(String filename)
  {
    assertHasWarning(filename, -1, -1, null);
  }

  private void assertHasWarning(String filename, int expectedWarningIndex, int expectedError, Position expectedPosition)
  {
    UmpleFile file = new UmpleFile(pathToInput, filename);
    model = new UmpleModel(new UmpleFile(pathToInput, filename));
    model.setShouldGenerate(false);
    boolean answer = true;
    RuleBasedParser rbp = new RuleBasedParser(model);
    parser = new UmpleInternalParser(umpleParserName, model, rbp);
    ParseResult result = rbp.parse(file);
    answer = result.getWasSuccess();
    if (answer)
    {
      answer = parser.analyze(false).getWasSuccess();
    }

    if (answer == false && true)
    {
      System.out.println("failed at:" + model.getLastResult().getPosition());
    }

    Assert.assertEquals(answer, true);
    if (expectedWarningIndex == -1)
    {
      Assert.assertEquals(false, parser.getParseResult().getHasWarnings());
    }
    else
    {
      Assert.assertEquals(true, parser.getParseResult().getHasWarnings());
      Assert.assertNotNull(parser.getParseResult().getErrorMessage(expectedWarningIndex));
      Assert.assertEquals(expectedError, parser.getParseResult().getErrorMessage(expectedWarningIndex).getErrorType().getErrorCode());
      System.out.println(">>" + parser.getParseResult().getErrorMessage(expectedWarningIndex).getPosition().getOffset());
      Assert.assertEquals(expectedPosition, parser.getParseResult().getErrorMessage(expectedWarningIndex).getPosition());
    }
  }

  private void assertParse(String filename, String expectedOutput, boolean expected)
  {
    // String input = SampleFileWriter.readContent(new File(pathToInput,
    // filename));
    UmpleFile file = new UmpleFile(pathToInput, filename);
    model = new UmpleModel(new UmpleFile(pathToInput, filename));
    model.setShouldGenerate(false);
    boolean answer = true;
    RuleBasedParser rbp = new RuleBasedParser(model);
    parser = new UmpleInternalParser(umpleParserName, model, rbp);
    ParseResult result = rbp.parse(file);
    answer = result.getWasSuccess();
    if (answer)
    {
      answer = parser.analyze(false).getWasSuccess();
    }

    if (answer == false && expected)
    {
      System.out.println("failed at:" + model.getLastResult().getPosition());
    }

    Assert.assertEquals(expected, answer);
    if (expected)
    {
      Assert.assertEquals(expectedOutput, parser.toString());
    }
  }

}
