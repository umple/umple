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

  // SIMPLE STATES
	
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

  // TRANSITIONS
  
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
  
  // GUARDS
  
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
  
  // SPACING
  
  // Spacing of state transaction actions
  
  @Test // Test the spacing problems in issue 155
  public void guardSpacing() {
    
	  assertUmpleTemplateFor("guardSpacing.ump",languagePath + "/guardSpacing."+ languagePath +".txt","Garage");
  }
  
  @Test //Test the spacing problems in issues 154
  public void stateMachineSpacing() {
	  assertUmpleTemplateFor("stateMachineSpacing1.ump",languagePath + "/stateMachineSpacing1."+ languagePath +".txt","Garage");
	  assertUmpleTemplateFor("stateMachineSpacing2.ump",languagePath + "/stateMachineSpacing2."+ languagePath +".txt","Garage");
  }
  
  // Spacing of state names (issue 399)
  
  /**
   * Tests spacing issues by changing the spacing in the test file for <{@link #NoStates()}.
   * Changing the spacing should have no effect on the output and so this method compares to the same
   * output files as {@link #NoStates()}.
   * <p>This test case addresses <b>issue 399</b>.
   * @author Kenan Kigunda
   * @since September 20, 2013
   */
  @Test
  public void stateNameSpacingForNoStates() {
	  assertUmpleTemplateFor("SimpleStateMachineSpacing.ump",languagePath + "/SimpleStateMachine."+ languagePath +".txt","Mentor");
  }
  
  /**
   * Test spacing issues by changing the spacing in the test file for {@link #OneState()}.
   * @see #stateNameSpacingForNoStates()
   */
  @Test
  public void stateNameSpacingForOneState() {
	  assertUmpleTemplateFor("SimpleStateMachineSpacing.ump",languagePath + "/SimpleStateMachine_OneState."+ languagePath +".txt","Student");	  
  }
  
  /**
   * Test spacing issues by changing the spacing in the test file for {@link #TwoState()}.
   * @see #stateNameSpacingForNoStates()
   */
  @Test
  public void stateNameSpacingForTwoStates() {
	  assertUmpleTemplateFor("SimpleStateMachineSpacing.ump",languagePath + "/SimpleStateMachine_TwoStates."+ languagePath +".txt","Course");  
  }
  
  /**
   * Test spacing issues by changing the spacing in the test file for {@link #EventTransitionSameState()}.
   * @see #stateNameSpacingForNoStates()
   */
  @Test
  public void stateNameSpacingForEventTransitionSameState() {
	  assertUmpleTemplateFor("EventTransitionSpacing.ump",languagePath + "/EventTransition_NewState."+ languagePath +".txt","Light");
  }
  
  /**
   * Test spacing issues by changing the spacing in the test file for {@link #EventTransitionNewState()}.
   * @see #stateNameSpacingForNoStates()
   */
  @Test
  public void stateNameSpacingForEventTransitionNewState() {
	  assertUmpleTemplateFor("EventTransitionSpacing.ump",languagePath + "/EventTransition."+ languagePath +".txt","Course");	  
  }
  
  // ACTIONS
  
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
  
  @Test
  public void queuedWithNestingStateMachines()
  {
    assertUmpleTemplateFor("queuedWithNestedStateMachines.ump",languagePath + "/queuedWithNestedStateMachines."+ languagePath +".txt","QueuedWithNestedStateMachines");
  }
  
  @Test
  public void queuedWithConcurrentStateMachines()
  {
    assertUmpleTemplateFor("queuedWithConcurrentStateMachines.ump",languagePath + "/queuedWithConcurrentStateMachines."+ languagePath +".txt","QueuedWithConcurrentStateMachines");
  }
  
  @Test
  public void queuedSMwithConcurrentStatesTest()
  {
    assertUmpleTemplateFor("queuedSMwithConcurrentStatesTest.ump",languagePath + "/queuedSMwithConcurrentStatesTest."+ languagePath +".txt","QueuedSMwithConcurrentStates");
  }
  
  @Test
  public void queuedSMwithConcurrentStatesTest_2()
  {
    assertUmpleTemplateFor("queuedSMwithConcurrentStatesTest_2.ump",languagePath + "/queuedSMwithConcurrentStatesTest_2."+ languagePath +".txt","QueuedSMwithConcurrentStates_2");
  }
  
  @Test
  public void queuedWithConcurrensStatesCourseAttempt() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
		
	assertUmpleTemplateFor("queuedWithConcurrensStatesCourseAttempt.ump",languagePath + "/queuedWithConcurrensStatesCourseAttempt."+ languagePath +".txt","CourseAttempt");
  }
  
  @Test
  public void queuedWithNestingStatesATM()
  {
    assertUmpleTemplateFor("queuedWithNestingStatesATM.ump",languagePath + "/queuedWithNestingStatesATM."+ languagePath +".txt","AutomatedTellerMachine");
  }
  
  @Test
  public void nestedStatesOfQSMwithSameEventNames()
  {
    assertUmpleTemplateFor("nestedStatesOfQSMwithSameEventNames.ump",languagePath + "/nestedStatesOfQSMwithSameEventNames."+ languagePath +".txt","NestedStatesWthSameEventNames");
  }
  
  @Test
  public void queuedStateMachine_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
	
	assertUmpleTemplateFor("queuedStateMachine_autoTransition.ump",languagePath + "/queuedStateMachine_autoTransition."+ languagePath +".txt","Light");
  }
  
  @Test
  public void queuedStateMachine_timedEvents()
  {
	assertUmpleTemplateFor("queuedStateMachine_timedEvents.ump",languagePath + "/queuedStateMachine_timedEvents."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void pooledStateMachine_timedEvents()
  {
	assertUmpleTemplateFor("pooledStateMachine_timedEvents.ump",languagePath + "/pooledStateMachine_timedEvents."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void pooledStateMachine()
  {
	assertUmpleTemplateFor("pooledStateMachine.ump",languagePath + "/pooledStateMachine."+ languagePath +".txt","Course");
  }
  
  @Test
  public void pooledStateMachine_withParameters()
  {
	assertUmpleTemplateFor("pooledStateMachine_withParameters.ump",languagePath + "/pooledStateMachine_withParameters."+ languagePath +".txt","LightFixture");
  }
  
  @Test
  public void pooledStateMachine_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
	
	assertUmpleTemplateFor("pooledStateMachine_autoTransition.ump",languagePath + "/pooledStateMachine_autoTransition."+ languagePath +".txt","Light");
  }
  
  @Test
  public void pooledStateMachineWithConcurrentStates_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
	
	assertUmpleTemplateFor("pooledStateMachineWithConcurrentStates_autoTransition.ump",languagePath + "/pooledStateMachineWithConcurrentStates_autoTransition."+ languagePath +".txt","CourseAttempt");
  }
  
  @Test
  public void queuedStateMachine_timedEvents_and_autoTansitions() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
	
	assertUmpleTemplateFor("queuedStateMachine_timedEvents_and_autoTansitions.ump",languagePath + "/queuedStateMachine_timedEvents_and_autoTansitions."+ languagePath +".txt","X");
  }
  
  @Test
  public void pooledStateMachine_timedEvents_and_autoTansitions() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
	
	assertUmpleTemplateFor("pooledStateMachine_timedEvents_and_autoTansitions.ump",languagePath + "/pooledStateMachine_timedEvents_and_autoTansitions."+ languagePath +".txt","X");
  }
  
  @Test 
  public void stateMachine_UnspecifiedReception() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
	
	assertUmpleTemplateFor("stateMachine_UnspecifiedReception.ump",languagePath + "/stateMachine_UnspecifiedReception."+ languagePath +".txt","Course");
  }
  
  @Test
  public void stateMachine_unSpecifiedReception_QSM() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
    
	assertUmpleTemplateFor("stateMachine_unSpecifiedReception_QSM.ump",languagePath + "/stateMachine_unSpecifiedReception_QSM."+ languagePath +".txt","QSMwithUnspecifiedRecep");
  }
  
  @Test
  public void queuedSM_UnspecifiedReception() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);
	
    assertUmpleTemplateFor("queuedSM_UnspecifiedRecep.ump",languagePath + "/queuedSM_UnspecifiedRecep."+ languagePath +".txt","AutomatedTellerMachine");
  }
  
  @Test
  public void nestedStates_UnspecifiedReception()
  {
	assertUmpleTemplateFor("nestedStates_UnspecifiedReception.ump",languagePath + "/nestedStates_UnspecifiedReception."+ languagePath +".txt","NestedStatesWthSameEventNames");
  }
  
  @Test
  public void pooledStateMachine_UnspecifiedReception() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	 Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
     f1.setAccessible(true);
	 f1.setInt(null, 1);
		
     assertUmpleTemplateFor("pooledStateMachine_UnspecifiedReception.ump",languagePath + "/pooledStateMachine_UnspecifiedReception."+ languagePath +".txt","PooledSMwithUnspecifiedReception");
  }
  
  @Test
  public void testPooledwithNestedStates()
  {
	assertUmpleTemplateFor("testPooledwithNestedStates.ump",languagePath + "/testPooledwithNestedStates."+ languagePath +".txt","X");
  }
  
  @Test
  public void testPooledwithNestedStates_2()
  {
	assertUmpleTemplateFor("testPooledwithNestedStates_2.ump",languagePath + "/testPooledwithNestedStates_2."+ languagePath +".txt","X");
  }
  
  @Test
  public void testPooledwithNestedStates_3()
  {
	assertUmpleTemplateFor("testPooledwithNestedStates_3.ump",languagePath + "/testPooledwithNestedStates_3."+ languagePath +".txt","X");
  }
  
  @Test
  public void testPooledwithNestedStates_4()
  {
	assertUmpleTemplateFor("testPooledwithNestedStates_4.ump",languagePath + "/testPooledwithNestedStates_4."+ languagePath +".txt","X");
  }
  
  @Test
  public void multiplePooledStateMachine()
  {
  assertUmpleTemplateFor("multiplePooledStateMachine.ump",languagePath + "/multiplePooledStateMachine."+ languagePath +".txt","X");
  }
  
  @Test
  public void multiplePooledStateMachine_EventlessStateMachine()
  {
  assertUmpleTemplateFor("multiplePooledStateMachine_EventlessStateMachine.ump",languagePath + "/multiplePooledStateMachine_EventlessStateMachine."+ languagePath +".txt","X");
  }
  
  @Test
  public void multiplePooledStateMachine_nestedStates()
  {
  assertUmpleTemplateFor("multiplePooledStateMachine_nestedStates.ump",languagePath + "/multiplePooledStateMachine_nestedStates."+ languagePath +".txt","X");
  }
  
  @Test
  public void multiplePooledStateMachines_sameEvents()
  {
  assertUmpleTemplateFor("multiplePooledStateMachines_sameEvents.ump",languagePath + "/multiplePooledStateMachines_sameEvents."+ languagePath +".txt","X");
  }

}
