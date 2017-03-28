/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

State machine extensions

*/

package cruise.umple.statemachine.implementation.php;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import cruise.umple.compiler.Event;
import cruise.umple.statemachine.implementation.StateMachineTest;
import cruise.umple.util.SampleFileWriter;

public class PhpStateMachineTemplateTest extends StateMachineTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "statemachine/php/Student.php");
    SampleFileWriter.destroy(pathToInput + "statemachine/php/Mentor.php");
    SampleFileWriter.destroy(pathToInput + "statemachine/php/Course.php");
    SampleFileWriter.destroy(pathToInput + "statemachine/php/Light.php");
    SampleFileWriter.destroy(pathToInput + "/Duplicate.php");
    SampleFileWriter.destroy(pathToInput + "/LightFixture.php");
  }
  
  
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void parallelSm_diffNamesDiffStates_2()
  {
    assertUmpleTemplateFor("parallelSm_diffNamesDiffStates_2.ump",languagePath + "/parallelSm_diffNamesDiffStates_2."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void eventlessStateMachine_before_PooledStateMachine()
  {
    assertUmpleTemplateFor("eventlessStateMachine_PooledStateMachine.ump",languagePath + "/eventlessStateMachine_PooledStateMachine."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void queuedSMwithConcurrentStatesTest_2()
  {
    assertUmpleTemplateFor("queuedSMwithConcurrentStatesTest_2.ump",languagePath + "/queuedSMwithConcurrentStatesTest_2."+ languagePath +".txt","QueuedSMwithConcurrentStates_2");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void nestedStatesOfQSMwithSameEventNames()
  {
    assertUmpleTemplateFor("nestedStatesOfQSMwithSameEventNames.ump",languagePath + "/nestedStatesOfQSMwithSameEventNames."+ languagePath +".txt","NestedStatesWthSameEventNames");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void testPooledwithNestedStates_2()
  {
  assertUmpleTemplateFor("testPooledwithNestedStates_2.ump",languagePath + "/testPooledwithNestedStates_2."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void testPooledwithNestedStates_3()
  {
  assertUmpleTemplateFor("testPooledwithNestedStates_3.ump",languagePath + "/testPooledwithNestedStates_3."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void testPooledwithNestedStates_4()
  {
  assertUmpleTemplateFor("testPooledwithNestedStates_4.ump",languagePath + "/testPooledwithNestedStates_4."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void activeObject()
  {
    assertUmpleTemplateFor("activeObject.ump", languagePath + "/activeObject."+ languagePath + ".txt", "Lamp");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void parallelSm_diffNamesDiffStates()
  {
    assertUmpleTemplateFor("parallelSm_diffNamesDiffStates.ump",languagePath + "/parallelSm_diffNamesDiffStates."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void pooledStateMachineWithConcurrentStates_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
  Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
  f1.setAccessible(true);
  f1.setInt(null, 1);
  
  assertUmpleTemplateFor("pooledStateMachineWithConcurrentStates_autoTransition.ump",languagePath + "/pooledStateMachineWithConcurrentStates_autoTransition."+ languagePath +".txt","CourseAttempt");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void parallelSm_sameNameDiffStatesEntryExitActions()
  {
    assertUmpleTemplateFor("parallelSm_sameNameDiffStatesEntryExitActions.ump",languagePath + "/parallelSm_sameNameDiffStatesEntryExitActions."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void nestedStates()
  {
    assertUmpleTemplateFor("nestedStates.ump",languagePath + "/nestedStates."+ languagePath +".txt","LightFixture");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void nestedStates_UnspecifiedReception()
  {
  assertUmpleTemplateFor("nestedStates_UnspecifiedReception.ump",languagePath + "/nestedStates_UnspecifiedReception."+ languagePath +".txt","NestedStatesWthSameEventNames");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void nestedStates_timedTransition()
  {
    assertUmpleTemplateFor("nestedStates_timedTransition.ump",languagePath + "/nestedStates_timedTransition."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void eventlessStateMachine_before_QueuedStateMachine()
  {
    assertUmpleTemplateFor("eventlessStateMachine_QueuedStateMachine.ump",languagePath + "/eventlessStateMachine_QueuedStateMachine."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void nestedStates_exitInnerBeforeOutter()
  {
    assertUmpleTemplateFor("nestedStates_exitInnerBeforeOutter.ump",languagePath + "/nestedStates_exitInnerBeforeOutter."+ languagePath +".txt","LightFixture");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void multipleQSM()
  {
    assertUmpleTemplateFor("multipleQSM.ump",languagePath + "/multipleQSM."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void multipleQSMe_nestedStates()
  {
    assertUmpleTemplateFor("multipleQSMe_nestedStates.ump",languagePath + "/multipleQSMe_nestedStates."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void parallelSm_sameNameDiffStates()
  {
    assertUmpleTemplateFor("parallelSm_sameNameDiffStates.ump",languagePath + "/parallelSm_sameNameDiffStates."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void nestedStates_Two_TimedTransition()
  {
    assertUmpleTemplateFor("nestedStates_Two_TimedTransition.ump",languagePath + "/nestedStates_Two_TimedTransition."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void queuedWithNestingStateMachines()
  {
    assertUmpleTemplateFor("queuedWithNestedStateMachines.ump",languagePath + "/queuedWithNestedStateMachines."+ languagePath +".txt","QueuedWithNestedStateMachines");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void multiplePooledStateMachine_nestedStates()
  {
    assertUmpleTemplateFor("multiplePooledStateMachine_nestedStates.ump",languagePath + "/multiplePooledStateMachine_nestedStates."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void doActivityNestedStateMachine()
  {
    assertUmpleTemplateFor("doActivityNestedStateMachine.ump",languagePath + "/doActivityNestedStateMachine."+ languagePath +".txt","Course");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void queuedSM_UnspecifiedReception() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
  Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
  f1.setAccessible(true);
  f1.setInt(null, 1);
  
    assertUmpleTemplateFor("queuedSM_UnspecifiedRecep.ump",languagePath + "/queuedSM_UnspecifiedRecep."+ languagePath +".txt","AutomatedTellerMachine");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void concurrentStates()
  {
    assertUmpleTemplateFor("concurrentStates_normal.ump",languagePath + "/concurrentStates_normal."+ languagePath +".txt","LightFixture");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void testPooledwithNestedStates()
  {
  assertUmpleTemplateFor("testPooledwithNestedStates.ump",languagePath + "/testPooledwithNestedStates."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void queuedWithConcurrentStateMachines()
  {
    assertUmpleTemplateFor("queuedWithConcurrentStateMachines.ump",languagePath + "/queuedWithConcurrentStateMachines."+ languagePath +".txt","QueuedWithConcurrentStateMachines");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void multipleQSM_EventlessStateMachine()
  {
    assertUmpleTemplateFor("multipleQSM_EventlessStateMachine.ump",languagePath + "/multipleQSM_EventlessStateMachine."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void parallelSm_diffNamesDiffStatesEntryExitActions()
  {
    assertUmpleTemplateFor("parallelSm_diffNamesDiffStatesEntryExitActions.ump",languagePath + "/parallelSm_diffNamesDiffStatesEntryExitActions."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void queuedSMwithConcurrentStatesTest()
  {
    assertUmpleTemplateFor("queuedSMwithConcurrentStatesTest.ump",languagePath + "/queuedSMwithConcurrentStatesTest."+ languagePath +".txt","QueuedSMwithConcurrentStates");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void multiplePooledStateMachine_EventlessStateMachine()
  {
    assertUmpleTemplateFor("multiplePooledStateMachine_EventlessStateMachine.ump",languagePath + "/multiplePooledStateMachine_EventlessStateMachine."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void nestedStateMachineExtendedByMultipleClasses()
  {
    assertUmpleTemplateFor("nestedStateMachineExtendedByMultipleClasses.ump",languagePath + "/nestedStateMachineExtendedByMultipleClasses."+ languagePath +".txt","Animal");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void nestedStateMachineExtendedByClass()
  {
    assertUmpleTemplateFor("nestedStateMachineExtendedByClass.ump",languagePath + "/nestedStateMachineExtendedByClass."+ languagePath +".txt","Animal");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void refactorFinalState_invalidElementsInNestedFinalState()
  {
    assertUmpleTemplateFor("refactorFinalState_invalidElementsInNestedFinalState.ump",languagePath + "/refactorFinalState_invalidElementsInNestedFinalState."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void queuedWithNestingStatesATM()
  {
    assertUmpleTemplateFor("queuedWithNestingStatesATM.ump",languagePath + "/queuedWithNestingStatesATM."+ languagePath +".txt","AutomatedTellerMachine");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void queuedWithConcurrensStatesCourseAttempt() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
  Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
  f1.setAccessible(true);
  f1.setInt(null, 1);
    
  assertUmpleTemplateFor("queuedWithConcurrensStatesCourseAttempt.ump",languagePath + "/queuedWithConcurrensStatesCourseAttempt."+ languagePath +".txt","CourseAttempt");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void parallelSm_sameNameDiffStates_2()
  {
    assertUmpleTemplateFor("parallelSm_sameNameDiffStates_2.ump",languagePath + "/parallelSm_sameNameDiffStates_2."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void checkExternalTransitions_withExitActions_1()
  {
    assertUmpleTemplateFor("checkExternalTransitions_withExitActions_1.ump",languagePath + "/checkExternalTransitions_withExitActions_1."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void checkExternalTransitions_withExitActions_2()
  {
    assertUmpleTemplateFor("checkExternalTransitions_withExitActions_2.ump",languagePath + "/checkExternalTransitions_withExitActions_2."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void checkExternalTransitions_noExitActions_1()
  {
    assertUmpleTemplateFor("checkExternalTransitions_noExitActions_1.ump",languagePath + "/checkExternalTransitions_noExitActions_1."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void checkExternalTransitions_noNestedStateMachines()
  {
    assertUmpleTemplateFor("checkExternalTransitions_noNestedStateMachines.ump",languagePath + "/checkExternalTransitions_noNestedStateMachines."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void checkExternalTransitions_concurrentStateMachines()
  {
    assertUmpleTemplateFor("checkExternalTransitions_concurrentStateMachines.ump",languagePath + "/checkExternalTransitions_concurrentStateMachines."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 935 fix, will update PHP generation in the future")
  public void checkExternalTransitions_concurrentStateMachines_2()
  {
    assertUmpleTemplateFor("checkExternalTransitions_concurrentStateMachines_2.ump",languagePath + "/checkExternalTransitions_concurrentStateMachines_2."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 1019 fix, will update PHP generation in the future")
  public void entryExitActionNoTransitions()
  {
    assertUmpleTemplateFor("entryExitActionNoTransitions.ump",languagePath + "/entryExitActionNoTransitions." + languagePath + ".txt", "LightFixture");
  }
  
  @Test
  @Ignore("Ignoring due to issue 1019 fix, will update PHP generation in the future")
  public void noDefaultEntryMethodGenerated()
  {
    assertUmpleTemplateFor("noDefaultEntryMethodGenerated.ump",languagePath + "/noDefaultEntryMethodGenerated."+ languagePath +".txt","X");    
  }
  
  @Test
  @Ignore("Ignoring due to issue 1019 fix, will update PHP generation in the future")
  public void noDefaultEntryMethodGenerated_2()
  {
    assertUmpleTemplateFor("noDefaultEntryMethodGenerated_2.ump",languagePath + "/noDefaultEntryMethodGenerated_2."+ languagePath +".txt","X");    
  }
  
  @Test
  @Ignore("Ignoring due to issue 140 fix, will update PHP generation in the future")
  public void finalState()
  {
    assertUmpleTemplateFor("FinalState.ump",languagePath + "/FinalState."+ languagePath +".txt","Mentor");
  }
  
  @Test
  @Ignore("Ignoring due to issue 140 fix, will update PHP generation in the future")
  public void testFinalKeyword()
  {
    assertUmpleTemplateFor("testFinalKeyword.ump",languagePath + "/testFinalKeyword."+ languagePath +".txt","X");
  }
  
  @Test
  @Ignore("Ignoring due to issue 140 fix, will update PHP generation in the future")
  public void testFinalKeyword_2()
  {
    assertUmpleTemplateFor("testFinalKeyword_2.ump",languagePath + "/testFinalKeyword_2."+ languagePath +".txt","X");
  }
}
