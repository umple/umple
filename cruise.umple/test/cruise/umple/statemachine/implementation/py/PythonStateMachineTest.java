package cruise.umple.statemachine.implementation.py;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import cruise.umple.statemachine.implementation.StateMachineTest;
import cruise.umple.util.SampleFileWriter;
import cruise.umple.compiler.Event;

public class PythonStateMachineTest extends StateMachineTest
{
 @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }

	@After
  public void tearDown()
  {
    super.tearDown();
	SampleFileWriter.destroy(pathToInput + "/Animal.py");
	SampleFileWriter.destroy(pathToInput + "/Bear.py");
	SampleFileWriter.destroy(pathToInput + "/Cat.py");
	SampleFileWriter.destroy(pathToInput + "/Course.py");
	SampleFileWriter.destroy(pathToInput + "/Cow.py");
	SampleFileWriter.destroy(pathToInput + "/Dog.py");
	SampleFileWriter.destroy(pathToInput + "/Game.py");
	SampleFileWriter.destroy(pathToInput + "/LightFixture.py");
	SampleFileWriter.destroy(pathToInput + "/Moose.py");
	SampleFileWriter.destroy(pathToInput + "/Player.py");
	SampleFileWriter.destroy(pathToInput + "/Session.py");
	SampleFileWriter.destroy(pathToInput + "/Sheep.py");
	SampleFileWriter.destroy(pathToInput + "/stateMachineWithNegativeNumberGuard.py");
	SampleFileWriter.destroy(pathToInput + "/stateMachineWithNegativeNumberGuard2.py");
	SampleFileWriter.destroy(pathToInput + "/stateMachineWithStringComparisonGuard.py");
	SampleFileWriter.destroy(pathToInput + "/ThingInWorld.py");
	SampleFileWriter.destroy(pathToInput + "/World.py");
	SampleFileWriter.destroy(pathToInput + "/py/A.py");
	SampleFileWriter.destroy(pathToInput + "/py/X.py");
  }
  @Test
  @Override
  public void testTwoParameterGuard_1()
  {
    assertUmpleTemplateFor(languagePath + "/testTwoParameterGuardPython.ump",languagePath + "/testTwoParameterGuard."+ languagePath +".txt","A_Guard");
  }

  @Override
  @Test
  public void guardNameBothAttributeAndMethod()
  {
	// Reset autotransition counter so isn't carried over to the next test (it's passed from the java test to the php test)
	Event.setNextAutoTransitionId(1);
	assertUmpleTemplateFor(languagePath + "/guardNameBothAttributeAndMethodPython.ump",languagePath + "/guardNameBothAttributeAndMethod."+ languagePath +".txt","A");
	Event.setNextAutoTransitionId(1);
  }

  @Override
  @Test
  public void guardNameBothAttributeAndMethod2()
  {
	Event.setNextAutoTransitionId(1);
	assertUmpleTemplateFor(languagePath + "/guardNameBothAttributeAndMethod2Python.ump",languagePath + "/guardNameBothAttributeAndMethod2."+ languagePath +".txt","A");
    Event.setNextAutoTransitionId(1);
  }


  @Override
  @Test
  public void guardNameBothAttributeAndMethod3()
  {
	Event.setNextAutoTransitionId(1);
	assertUmpleTemplateFor(languagePath + "/guardNameBothAttributeAndMethod3Python.ump",languagePath + "/guardNameBothAttributeAndMethod3."+ languagePath +".txt","A");
    Event.setNextAutoTransitionId(1);
  }

  @Override
  @Test
  public void checkExternalTransitions_withExitActions_1()
  {
    assertUmpleTemplateFor(languagePath + "/checkExternalTransitions_withExitActions_1Python.ump",languagePath + "/checkExternalTransitions_withExitActions_1."+ languagePath +".txt","X");
  }

  @Override @Ignore
  @Test
  public void eventlessStateMachine_before_QueuedStateMachine()
  {
    assertUmpleTemplateFor("eventlessStateMachine_QueuedStateMachine.ump",languagePath + "/eventlessStateMachine_QueuedStateMachine."+ languagePath +".txt","X");
  }

  @Override @Ignore
  @Test
  public void queuedSM_UnspecifiedReception() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
  Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
  f1.setAccessible(true);
  f1.setInt(null, 1);

    assertUmpleTemplateFor("queuedSM_UnspecifiedRecep.ump",languagePath + "/queuedSM_UnspecifiedRecep."+ languagePath +".txt","AutomatedTellerMachine");
  }

  @Override @Ignore
  @Test
  public void queuedSMwithConcurrentStatesTest()
  {
    assertUmpleTemplateFor("queuedSMwithConcurrentStatesTest.ump",languagePath + "/queuedSMwithConcurrentStatesTest."+ languagePath +".txt","QueuedSMwithConcurrentStates");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine()
  {
    assertUmpleTemplateFor("queuedStateMachine.ump",languagePath + "/queuedStateMachine."+ languagePath +".txt","Course");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_2()
  {
    assertUmpleTemplateFor("queuedStateMachine_2.ump",languagePath + "/queuedStateMachine_2."+ languagePath +".txt","GarageDoor");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_timedEvents_and_autoTansitions() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
  Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
  f1.setAccessible(true);
  f1.setInt(null, 1);

  assertUmpleTemplateFor("queuedStateMachine_timedEvents_and_autoTansitions.ump",languagePath + "/queuedStateMachine_timedEvents_and_autoTansitions."+ languagePath +".txt","X");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_timedTransition_1()
  {
    assertUmpleTemplateFor("queuedStateMachine_timedTransition_1.ump",languagePath + "/queuedStateMachine_timedTransition_1."+ languagePath +".txt","X");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_timedTransition_2()
  {
    assertUmpleTemplateFor("queuedStateMachine_timedTransition_2.ump",languagePath + "/queuedStateMachine_timedTransition_2."+ languagePath +".txt","X");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_withParameters()
  {
    assertUmpleTemplateFor("queuedStateMachine_withParameters.ump",languagePath + "/queuedStateMachine_withParameters."+ languagePath +".txt","LightFixture");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_withParameters_1()
  {
    assertUmpleTemplateFor("queuedStateMachine_withParameters_1.ump",languagePath + "/queuedStateMachine_withParameters_1."+ languagePath +".txt","LightFixture");
  }

  @Override @Ignore
  @Test
  public void queuedWithConcurrensStatesCourseAttempt() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
  Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
  f1.setAccessible(true);
  f1.setInt(null, 1);

  assertUmpleTemplateFor("queuedWithConcurrensStatesCourseAttempt.ump",languagePath + "/queuedWithConcurrensStatesCourseAttempt."+ languagePath +".txt","CourseAttempt");
  }

  @Override @Ignore
  @Test
  public void queuedWithConcurrentStateMachines()
  {
    assertUmpleTemplateFor("queuedWithConcurrentStateMachines.ump",languagePath + "/queuedWithConcurrentStateMachines."+ languagePath +".txt","QueuedWithConcurrentStateMachines");
  }

  @Override @Ignore
  @Test
  public void queuedWithNestingStatesATM()
  {
    assertUmpleTemplateFor("queuedWithNestingStatesATM.ump",languagePath + "/queuedWithNestingStatesATM."+ languagePath +".txt","AutomatedTellerMachine");
  }

  @Override @Ignore
  @Test
  public void guardNegSymbolSpacing() {
    assertUmpleTemplateFor("guardNegSymbolSpacing.ump",languagePath + "/guardNegSymbolSpacing."+ languagePath +".txt","Agent");
  }

  @Override @Ignore
  @Test
  public void checkExternalTransitions_noExitActions_1()
  {
    assertUmpleTemplateFor("checkExternalTransitions_noExitActions_1.ump",languagePath + "/checkExternalTransitions_noExitActions_1."+ languagePath +".txt","X");
  }

  @Override @Ignore
  @Test
  public void stateMachine_unSpecifiedReception_QSM() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);

	assertUmpleTemplateFor("stateMachine_unSpecifiedReception_QSM.ump",languagePath + "/stateMachine_unSpecifiedReception_QSM."+ languagePath +".txt","QSMwithUnspecifiedRecep");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_implements()
  {
	assertUmpleTemplateFor("queuedStateMachine_implementsInterface.ump",languagePath + "/queuedStateMachine_interfaceX."+ languagePath +".txt","IX");
    assertUmpleTemplateFor("queuedStateMachine_implementsInterface.ump",languagePath + "/queuedStateMachine_implementsInterface."+ languagePath +".txt","X");

  }

  @Override @Ignore
  @Test
  public void queuedWithNestingStateMachines()
  {
    assertUmpleTemplateFor("queuedWithNestedStateMachines.ump",languagePath + "/queuedWithNestedStateMachines."+ languagePath +".txt","QueuedWithNestedStateMachines");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_timedEvents()
  {
	assertUmpleTemplateFor("queuedStateMachine_timedEvents.ump",languagePath + "/queuedStateMachine_timedEvents."+ languagePath +".txt","Mentor");
  }

  @Override @Ignore
  @Test
  public void queuedStateMachine_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);

	assertUmpleTemplateFor("queuedStateMachine_autoTransition.ump",languagePath + "/queuedStateMachine_autoTransition."+ languagePath +".txt","Light");
  }

  @Override @Ignore
  @Test
  public void testMultipleQSMs()
  {
    assertUmpleTemplateFor("testMultipleQSMs.ump",languagePath + "/testMultipleQSMs."+ languagePath +".txt","X");
  }



@Override @Ignore
  @Test
  public void pooledStateMachine()
  {
	assertUmpleTemplateFor("pooledStateMachine.ump",languagePath + "/pooledStateMachine."+ languagePath +".txt","Course");
  }
  @Override @Ignore
  @Test
  public void pooledStateMachine_withParameters()
  {
	assertUmpleTemplateFor("pooledStateMachine_withParameters.ump",languagePath + "/pooledStateMachine_withParameters."+ languagePath +".txt","LightFixture");
  }
  @Override @Ignore
  @Test
  public void pooledStateMachine_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	 }

@Override @Ignore
  @Test
  public void pooledStateMachineWithConcurrentStates_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{}

  @Override @Ignore
  @Test
  public void pooledStateMachine_timedEvents_and_autoTansitions() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
	Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
	f1.setAccessible(true);
	f1.setInt(null, 1);

	assertUmpleTemplateFor("pooledStateMachine_timedEvents_and_autoTansitions.ump",languagePath + "/pooledStateMachine_timedEvents_and_autoTansitions."+ languagePath +".txt","X");
  }

@Override @Ignore
@Test
  public void pooledStateMachine_timedTransition_2()
  {
    assertUmpleTemplateFor("pooledStateMachine_timedTransition_2.ump",languagePath + "/pooledStateMachine_timedTransition_2."+ languagePath +".txt","X");
  }

@Override @Ignore
 @Test
  public void pooledStateMachine_timedTransition_1()
  {
    assertUmpleTemplateFor("pooledStateMachine_timedTransition_1.ump",languagePath + "/pooledStateMachine_timedTransition_1."+ languagePath +".txt","X");
  }
@Override @Ignore

  @Test
  public void pooledStateMachine_UnspecifiedReception() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {

     assertUmpleTemplateFor("pooledStateMachine_UnspecifiedReception.ump",languagePath + "/pooledStateMachine_UnspecifiedReception."+ languagePath +".txt","PooledSMwithUnspecifiedReception");
  }
  @Override @Ignore
  @Test
  public void testPooledwithNestedStates()
  {
	assertUmpleTemplateFor("testPooledwithNestedStates.ump",languagePath + "/testPooledwithNestedStates."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void testPooledwithNestedStates_2()
  {
	assertUmpleTemplateFor("testPooledwithNestedStates_2.ump",languagePath + "/testPooledwithNestedStates_2."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void testPooledwithNestedStates_3()
  {
	assertUmpleTemplateFor("testPooledwithNestedStates_3.ump",languagePath + "/testPooledwithNestedStates_3."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void testPooledwithNestedStates_4()
  {
	assertUmpleTemplateFor("testPooledwithNestedStates_4.ump",languagePath + "/testPooledwithNestedStates_4."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void multiplePooledStateMachine()
  {
    assertUmpleTemplateFor("multiplePooledStateMachine.ump",languagePath + "/multiplePooledStateMachine."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void multiplePooledStateMachine_EventlessStateMachine()
  {
    assertUmpleTemplateFor("multiplePooledStateMachine_EventlessStateMachine.ump",languagePath + "/multiplePooledStateMachine_EventlessStateMachine."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void multiplePooledStateMachine_nestedStates()
  {
    assertUmpleTemplateFor("multiplePooledStateMachine_nestedStates.ump",languagePath + "/multiplePooledStateMachine_nestedStates."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void multiplePooledStateMachines_sameEvents()
  {
    assertUmpleTemplateFor("multiplePooledStateMachines_sameEvents.ump",languagePath + "/multiplePooledStateMachines_sameEvents."+ languagePath +".txt","X");
  }
@Override @Ignore
  @Test
  public void exitAction()
  {
    assertUmpleTemplateFor("exitAction.ump",languagePath + "/exitAction."+ languagePath +".txt","LightFixture");
  }
  @Override @Ignore
  @Test
  public void exitActionSelfTransition()
  {
    assertUmpleTemplateFor("exitActionSelfTransition.ump",languagePath + "/exitActionSelfTransition."+ languagePath +".txt","A");
  }
@Override @Ignore
  @Test
  public void entryExitTransitionAction()
  {
    assertUmpleTemplateFor("entryExitTransitionAction.ump",languagePath + "/entryExitTransitionAction."+ languagePath +".txt","LightFixture");
  }
@Override @Ignore
  @Test
  public void entryExitTransitionActionWithGuard()
  {
    assertUmpleTemplateFor("entryExitTransitionActionWithGuard.ump",languagePath + "/entryExitTransitionActionWithGuard."+ languagePath +".txt","LightFixture");
  }
@Override @Ignore
  @Test
  public void entryExitActionNoTransitions()
  {
    assertUmpleTemplateFor("entryExitActionNoTransitions.ump",languagePath + "/entryExitActionNoTransitions." + languagePath + ".txt", "LightFixture");
  }
@Override @Ignore
  @Test
  public void entryExitActionDuplicates()
  {
  assertUmpleTemplateFor("entryExitActionDuplicates.ump",languagePath + "/entryExitActionDuplicates." + languagePath + ".txt", "Duplicate");
  }

//Generates unsupported feature
@Override @Ignore
@Test
public void queuedSMwithConcurrentStatesTest_2()
{
  assertUmpleTemplateFor("/queuedSMwithConcurrentStatesTest_2Python.ump",languagePath + "/queuedSMwithConcurrentStatesTest_2."+ languagePath +".txt","QueuedSMwithConcurrentStates_2");
}

@Override
  @Test
  public void doActivity()
  {
    assertUmpleTemplateFor(languagePath + "/doActivityPython.ump",languagePath + "/doActivity."+ languagePath +".txt","Switch");
  }

  @Override
  @Test
  public void doActivity_Multiple()
  {
    assertUmpleTemplateFor(languagePath + "/doActivityPython.ump",languagePath + "/doActivityMultiple."+ languagePath +".txt","Lamp");
  }

  @Override
  @Test
  public void doActivityMultipleInSameState()
  {
    assertUmpleTemplateFor(languagePath + "/doActivityMultiPython.ump",languagePath + "/doActivityMulti."+ languagePath +".txt","X", true, false);
  }

  @Override
  @Test
  public void doActivityMultiMixin()
  {
    assertUmpleTemplateFor(languagePath + "/doActivityMultiMixinPython.ump",languagePath + "/doActivityMultiMixin."+ languagePath +".txt","X");
  }

  @Override
  @Test
  public void doActivityNestedStateMachine()
  {
	  assertUmpleTemplateFor(languagePath + "/doActivityNestedStateMachinePython.ump",languagePath + "/doActivityNestedStateMachine."+ languagePath +".txt","Course");
  }

  @Override
  @Test
  public void doActivityNoTransitions()
  {
    assertUmpleTemplateFor(languagePath + "/doActivityNoTransitionsPython.ump",languagePath + "/doActivityNoTransitions."+ languagePath +".txt","LightFixture");
  }

  @Override
  @Test
  public void activeObject()
  {
    assertUmpleTemplateFor(languagePath + "/activeObjectPython.ump", languagePath + "/activeObject."+ languagePath + ".txt", "Lamp");
  }

  // Auto transition does not work
  @Override @Ignore
  @Test
  public void doActivitiesWithAutoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
    f1.setAccessible(true);
    f1.setInt(null, 1);
    assertUmpleTemplateFor("doActivitiesWithAutoTransition.ump",languagePath + "/doActivitiesWithAutoTransition."+languagePath +".txt","LightFixture");
  }

  @Override @Ignore
  @Test
  public void equivalentGuards()
  {
    assertUmpleTemplateFor("equivalentGuards.ump",languagePath + "/equivalentGuards."+ languagePath +".txt","A");
  }
@Override @Ignore
   @Test
  public void eventlessStateMachine_before_PooledStateMachine()
  {
    assertUmpleTemplateFor("eventlessStateMachine_PooledStateMachine.ump",languagePath + "/eventlessStateMachine_PooledStateMachine."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void pooledStateMachine_timedEvents()
  {
	assertUmpleTemplateFor("pooledStateMachine_timedEvents.ump",languagePath + "/pooledStateMachine_timedEvents."+ languagePath +".txt","Mentor");
  }
  @Override
  @Test
  public void testRegionFinalStates_6()
  {
    assertUmpleTemplateFor(languagePath + "/testRegionFinalStates_6Python.ump",languagePath + "/testRegionFinalStates_6."+ languagePath +".txt","X");
  }
@Override @Ignore
@Test
  public void multipleQSM()
  {
    assertUmpleTemplateFor("multipleQSM.ump",languagePath + "/multipleQSM."+ languagePath +".txt","X");
  }
@Override @Ignore
  @Test
  public void multipleQSM_EventlessStateMachine()
  {
    assertUmpleTemplateFor("multipleQSM_EventlessStateMachine.ump",languagePath + "/multipleQSM_EventlessStateMachine."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void multipleQSMe_nestedStates()
  {
    assertUmpleTemplateFor("multipleQSMe_nestedStates.ump",languagePath + "/multipleQSMe_nestedStates."+ languagePath +".txt","X");
  }
  @Override @Ignore
  @Test
  public void multipleQSM_sameEvents()
  {
    assertUmpleTemplateFor("multipleQSM_sameEvents.ump",languagePath + "/multipleQSM_sameEvents."+ languagePath +".txt","X");
  }
    @Override @Ignore
  @Test
  public void nestedStatesOfQSMwithSameEventNames()
  {
    assertUmpleTemplateFor("nestedStatesOfQSMwithSameEventNames.ump",languagePath + "/nestedStatesOfQSMwithSameEventNames."+ languagePath +".txt","NestedStatesWthSameEventNames");
  }
@Override @Ignore 
@Test
  public void nestedState_StateMachine_timedEvents()
  {
  	assertUmpleTemplateFor("nestedStates_StateMachine_timedEvent.ump",languagePath + "/nestedStates_StateMachine_timedEvent."+ languagePath +".txt","Window");
  }
  @Override @Ignore
  @Test
  public void sameEvent_twoStates_differentStatemachines()
  {
    assertUmpleTemplateFor("sameEvent_twoStates_differentStateMachines.ump",languagePath + "/sameEvent_twoStates_differentStatemachines."+ languagePath +".txt","LightFixture");
  }
  @Override @Ignore
  @Test
  public void nestedStates_exitInnerBeforeOutter()
  {
    assertUmpleTemplateFor("nestedStates_exitInnerBeforeOutter.ump",languagePath + "/nestedStates_exitInnerBeforeOutter."+ languagePath +".txt","LightFixture");
  }
  
  @Override @Ignore
  @Test
  public void refactorFinalState_hasAllInvalidElements()
  {
	  assertUmpleTemplateFor(languagePath + "/refactorFinalState_hasAllInvalidElementsPython.ump",languagePath + "/refactorFinalState_hasAllInvalidElements."+ languagePath +".txt","X");
  }

  @Override @Ignore
  @Test
  public void parallelSm_diffNamesDiffStatesEntryExitActions()
  {
    assertUmpleTemplateFor(languagePath + "/parallelSm_diffNamesDiffStatesEntryExitActionsPython.ump",languagePath + "/parallelSm_diffNamesDiffStatesEntryExitActions."+ languagePath +".txt","X");
  }

  @Override @Ignore
  @Test
  public void noDefaultEntryMethodGenerated()
  {
    assertUmpleTemplateFor(languagePath + "/noDefaultEntryMethodGeneratedPython.ump",languagePath + "/noDefaultEntryMethodGenerated."+ languagePath +".txt","X");    
  }
  
  @Test
  public void noDefaultEntryMethodGenerated_2()
  {
    assertUmpleTemplateFor(languagePath + "/noDefaultEntryMethodGenerated_2Python.ump",languagePath + "/noDefaultEntryMethodGenerated_2."+ languagePath +".txt","X");    
  }
  @Override @Ignore
  @Test
  public void parallelSm_sameNameDiffStatesEntryExitActions()
  {
    assertUmpleTemplateFor("parallelSm_sameNameDiffStatesEntryExitActions.ump",languagePath + "/parallelSm_sameNameDiffStatesEntryExitActions."+ languagePath +".txt","X");
  }
}
