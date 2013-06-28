/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

*/

package cruise.umple.statemachine.implementation;

import java.lang.reflect.Field;

import org.junit.*;

import cruise.umple.compiler.Event;

public class StateMachineTest extends StateMachineTemplateTest
{

  @Test
  public void NoStates()
  {
    assertUmpleTemplateFor("SimpleStateMachine.ump",languagePath + "/SimpleStateMachine."+ languagePath +".txt","Mentor");
  }

  @Test
  public void OneState()
  {
    assertUmpleTemplateFor("SimpleStateMachine.ump",languagePath + "/SimpleStateMachine_OneState."+ languagePath +".txt","Student");
  }

  @Test
  public void TwoState()
  {
    assertUmpleTemplateFor("SimpleStateMachine.ump",languagePath + "/SimpleStateMachine_TwoStates."+ languagePath +".txt","Course");
  }

  @Test
  public void EventTransitionSameState()
  {
    assertUmpleTemplateFor("EventTransition.ump",languagePath + "/EventTransition."+ languagePath +".txt","Course");
  }
  
  @Test
  public void EventTransitionNewState()
  {
    assertUmpleTemplateFor("EventTransition.ump",languagePath + "/EventTransition_NewState."+ languagePath +".txt","Light");
  }  
  
  @Test
  public void EmptyAndNonEmptyStates()
  {
    assertUmpleTemplateFor("EmptyAndNonEmptyStates.ump",languagePath + "/EmptyAndNonEmptyStates."+ languagePath +".txt","Light");
  }   
  
  @Test
  public void oneGuard()
  {
    assertUmpleTemplateFor("oneGuard.ump",languagePath + "/oneGuard."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void multipleGuardsSameEvent()
  {
    assertUmpleTemplateFor("multipleGuardsSameEvent.ump",languagePath + "/multipleGuardsSameEvent."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void multipleGuardsSameEventWithDefaultNoGuard()
  {
    assertUmpleTemplateFor("multipleGuardsSameEventWithDefaultNoGuard.ump",languagePath + "/multipleGuardsSameEventWithDefaultNoGuard."+ languagePath +".txt","LightFixture");
  }
  
  @Test //Test the spacing problems in issue 155
  public void guardSpacing() {
	  assertUmpleTemplateFor("guardSpacing.ump",languagePath + "/guardSpacing."+ languagePath +".txt","Garage");
  }
  
  @Test //Test the spacing problems in issues 154
  public void stateMachineSpacing() {
	  assertUmpleTemplateFor("stateMachineSpacing1.ump",languagePath + "/stateMachineSpacing1."+ languagePath +".txt","Garage");
	  assertUmpleTemplateFor("stateMachineSpacing2.ump",languagePath + "/stateMachineSpacing2."+ languagePath +".txt","Garage");
  }
  
  @Test
  public void transitionAction()
  {
    assertUmpleTemplateFor("transitionAction.ump",languagePath + "/transitionAction."+ languagePath +".txt","Course");
  }
 
  
  @Test 
  public void entryAction()
  {
    assertUmpleTemplateFor("entryAction.ump",languagePath + "/entryAction."+ languagePath +".txt","Light");
  }
  
  @Test
  public void doActivity()
  {
    assertUmpleTemplateFor("doActivity.ump",languagePath + "/doActivity."+ languagePath +".txt","Switch");
  }
  
  @Test
  public void doActivity_Multiple()
  {
    assertUmpleTemplateFor("doActivity.ump",languagePath + "/doActivityMultiple."+ languagePath +".txt","Lamp");
  }
  
  @Test
  public void doActivityNestedStateMachine()
  {
	  assertUmpleTemplateFor("doActivityNestedStateMachine.ump",languagePath + "/doActivityNestedStateMachine."+ languagePath +".txt","Course");
  }
  
  @Test 
  public void exitAction()
  {
    assertUmpleTemplateFor("exitAction.ump",languagePath + "/exitAction."+ languagePath +".txt","LightFixture");
  }

  @Test 
  public void entryExitTransitionAction()
  {
    assertUmpleTemplateFor("entryExitTransitionAction.ump",languagePath + "/entryExitTransitionAction."+ languagePath +".txt","LightFixture");
  }

  @Test 
  public void entryExitTransitionActionWithGuard()
  {
    assertUmpleTemplateFor("entryExitTransitionActionWithGuard.ump",languagePath + "/entryExitTransitionActionWithGuard."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void externalStateMachine()
  {
    assertUmpleTemplateFor("externalStateMachine.ump",languagePath + "/externalStateMachine."+ languagePath +".txt","Course");
  }
  
  @Test
  public void timedEvent()
  {
    assertUmpleTemplateFor("timedEvent.ump",languagePath + "/timedEvent."+ languagePath +".txt","Mentor");
  }

  @Test
  public void sameEvent_twoStates_differentStatemachines()
  {
    assertUmpleTemplateFor("sameEvent_twoStates_differentStateMachines.ump",languagePath + "/sameEvent_twoStates_differentStatemachines."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void nestedStates()
  {
    assertUmpleTemplateFor("nestedStates.ump",languagePath + "/nestedStates."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void nestedStates_exitInnerBeforeOutter()
  {
    assertUmpleTemplateFor("nestedStates_exitInnerBeforeOutter.ump",languagePath + "/nestedStates_exitInnerBeforeOutter."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void concurrentStates()
  {
    assertUmpleTemplateFor("concurrentStates_normal.ump",languagePath + "/concurrentStates_normal."+ languagePath +".txt","LightFixture");
  }
  
  @Test
  public void before_after_setMethod()
  {
    assertUmpleTemplateFor("BeforeAndAfter_StateMachineSet.ump",languagePath + "/BeforeAndAfter_StateMachineSet."+ languagePath +".txt","LightFixture");
  }
  
  @Test
  public void activeObject()
  {
    assertUmpleTemplateFor("activeObject.ump", languagePath + "/activeObject."+ languagePath + ".txt", "Lamp");
  }

  @Test
  public void finalState()
  {
    assertUmpleTemplateFor("FinalState.ump",languagePath + "/FinalState."+ languagePath +".txt","Mentor");
  }

  @Test
  public void eventWithArguments(){
	  assertUmpleTemplateFor("eventWithArguments.ump",languagePath + "/eventWithArguments."+ languagePath +".txt","LightFixture");
  }
  
  
  @Test
  public void eventWithArguments_1(){
	  assertUmpleTemplateFor("eventWithArguments_1.ump",languagePath + "/eventWithArguments_1."+ languagePath +".txt","LightFixture");
  }
  
  @Test
  public void eventWithArguments_2(){
	  assertUmpleTemplateFor("eventWithArguments_2.ump",languagePath + "/eventWithArguments_2."+ languagePath +".txt","Course");
  }
  
  @Test
  public void twoEventsWithArguments(){
	  assertUmpleTemplateFor("twoEventsWithArguments.ump",languagePath + "/twoEventsWithArguments."+ languagePath +".txt","Course");
  }
  
  @Test
  public void autoEventTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
    f1.setAccessible(true);
    f1.setInt(null, 1);
    
    assertUmpleTemplateFor("AutoEventTransition.ump",languagePath + "/AutoEventTransition."+ languagePath +".txt","Light");
  }

  @Test
  public void queuedStateMachine()
  {
    assertUmpleTemplateFor("queuedStateMachine.ump",languagePath + "/queuedStateMachine."+ languagePath +".txt","Course");
  }

  @Test
  public void queuedStateMachine_2()
  {
    assertUmpleTemplateFor("queuedStateMachine_2.ump",languagePath + "/queuedStateMachine_2."+ languagePath +".txt","GarageDoor");
  }

  @Test
  public void queuedStateMachine_withParameters()
  {
    assertUmpleTemplateFor("queuedStateMachine_withParameters.ump",languagePath + "/queuedStateMachine_withParameters."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void queuedStateMachine_withParameters_1()
  {
    assertUmpleTemplateFor("queuedStateMachine_withParameters_1.ump",languagePath + "/queuedStateMachine_withParameters_1."+ languagePath +".txt","LightFixture");
  }  
}
