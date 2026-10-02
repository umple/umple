package cruise.umple.statemachine.implementation.pynext;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import cruise.umple.statemachine.implementation.StateMachineTest;
import cruise.umple.util.SampleFileWriter;
import cruise.umple.compiler.Event;

public class PythonNextStateMachineTest extends StateMachineTest
{
 @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
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
	SampleFileWriter.destroy(pathToInput + "/pynext/A.py");
	SampleFileWriter.destroy(pathToInput + "/pynext/X.py");
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
    // a guard names z, which the model does not define, so it would fail each time it runs
    assertPythonDiagnostic(languagePath + "/guardNameBothAttributeAndMethod2Python.ump", 9210);
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

  @Override
  @Test
  public void eventlessStateMachine_before_QueuedStateMachine()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("eventlessStateMachine_QueuedStateMachine.ump", 9210);
  }

  @Override
  @Test
  public void queuedSM_UnspecifiedReception() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedSM_UnspecifiedRecep.ump", 9210);
  }

  @Override
  @Test
  public void queuedSMwithConcurrentStatesTest()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedSMwithConcurrentStatesTest.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_2()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_2.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_timedEvents_and_autoTansitions() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_timedEvents_and_autoTansitions.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_timedTransition_1()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_timedTransition_1.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_timedTransition_2()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_timedTransition_2.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_withParameters()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_withParameters.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_withParameters_1()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_withParameters_1.ump", 9210);
  }

  @Override
  @Test
  public void queuedWithConcurrensStatesCourseAttempt() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedWithConcurrensStatesCourseAttempt.ump", 9210);
  }

  @Override
  @Test
  public void queuedWithConcurrentStateMachines()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedWithConcurrentStateMachines.ump", 9210);
  }

  @Override
  @Test
  public void queuedWithNestingStatesATM()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedWithNestingStatesATM.ump", 9210);
  }

  @Override
  @Test
  public void guardNegSymbolSpacing() {
    // the guards name not_achieved, which the model does not define
    assertPythonDiagnostic("guardNegSymbolSpacing.ump", 9210);
  }

  @Override
  @Test
  public void checkExternalTransitions_noExitActions_1()
  {
    assertUmpleTemplateFor("checkExternalTransitions_noExitActions_1.ump",languagePath + "/checkExternalTransitions_noExitActions_1."+ languagePath +".txt","X");
  }

  @Override
  @Test
  public void stateMachine_unSpecifiedReception_QSM() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("stateMachine_unSpecifiedReception_QSM.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_implements()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_implementsInterface.ump", 9210);
  }

  @Override
  @Test
  public void queuedWithNestingStateMachines()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedWithNestedStateMachines.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_timedEvents()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_timedEvents.ump", 9210);
  }

  @Override
  @Test
  public void queuedStateMachine_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("queuedStateMachine_autoTransition.ump", 9210);
  }

  @Override
  @Test
  public void testMultipleQSMs()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("testMultipleQSMs.ump", 9210);
  }



@Override
  @Test
  public void pooledStateMachine()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachine.ump", 9210);
  }
  @Override
  @Test
  public void pooledStateMachine_withParameters()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachine_withParameters.ump", 9210);
  }
  @Override
  @Test
  public void pooledStateMachine_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachine_autoTransition.ump", 9210);
  }

@Override
  @Test
  public void pooledStateMachineWithConcurrentStates_autoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachineWithConcurrentStates_autoTransition.ump", 9210);
  }

  @Override
  @Test
  public void pooledStateMachine_timedEvents_and_autoTansitions() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachine_timedEvents_and_autoTansitions.ump", 9210);
  }

@Override
@Test
  public void pooledStateMachine_timedTransition_2()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachine_timedTransition_2.ump", 9210);
  }

@Override
 @Test
  public void pooledStateMachine_timedTransition_1()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachine_timedTransition_1.ump", 9210);
  }
@Override

  @Test
  public void pooledStateMachine_UnspecifiedReception() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachine_UnspecifiedReception.ump", 9210);
  }
  @Override
  @Test
  public void testPooledwithNestedStates()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("testPooledwithNestedStates.ump", 9210);
  }
  @Override
  @Test
  public void testPooledwithNestedStates_2()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("testPooledwithNestedStates_2.ump", 9210);
  }
  @Override
  @Test
  public void testPooledwithNestedStates_3()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("testPooledwithNestedStates_3.ump", 9210);
  }
  @Override
  @Test
  public void testPooledwithNestedStates_4()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("testPooledwithNestedStates_4.ump", 9210);
  }
  @Override
  @Test
  public void multiplePooledStateMachine()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("multiplePooledStateMachine.ump", 9210);
  }
  @Override
  @Test
  public void multiplePooledStateMachine_EventlessStateMachine()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("multiplePooledStateMachine_EventlessStateMachine.ump", 9210);
  }
  @Override
  @Test
  public void multiplePooledStateMachine_nestedStates()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("multiplePooledStateMachine_nestedStates.ump", 9210);
  }
  @Override
  @Test
  public void multiplePooledStateMachines_sameEvents()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("multiplePooledStateMachines_sameEvents.ump", 9210);
  }
@Override
  @Test
  public void exitAction()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("exitAction.ump", 9211);
  }
  @Override
  @Test
  public void exitActionSelfTransition()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("exitActionSelfTransition.ump", 9211);
  }
@Override
  @Test
  public void entryExitTransitionAction()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("entryExitTransitionAction.ump", 9211);
  }
@Override
  @Test
  public void entryExitTransitionActionWithGuard()
  {
    // a guard names isTurnedOn, which the model does not define
    assertPythonDiagnostic("entryExitTransitionActionWithGuard.ump", 9210);
  }
@Override
  @Test
  public void entryExitActionNoTransitions()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("entryExitActionNoTransitions.ump", 9211);
  }
@Override
  @Test
  public void entryExitActionDuplicates()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("entryExitActionDuplicates.ump", 9211);
  }

//Generates unsupported feature
@Override
@Test
public void queuedSMwithConcurrentStatesTest_2()
{
  // a feature Python does not generate yet is reported
  assertPythonDiagnostic("queuedSMwithConcurrentStatesTest_2.ump", 9210);
}

@Override
  @Test
  public void doActivity()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("pynext/doActivityPython.ump", 9211);
  }

  @Override
  @Test
  public void doActivity_Multiple()
  {
    // the shared model's untagged code is Java, so the Python case has a do activity in each of two states
    assertUmpleTemplateFor("pynext/doActivityMultiplePython.ump", languagePath + "/doActivityMultiple." + languagePath + ".txt", "Lamp");
  }

  @Override
  @Test
  public void doActivityMultipleInSameState()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("pynext/doActivityMultiPython.ump", 9211);
  }

  @Override
  @Test
  public void doActivityMultiMixin()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("pynext/doActivityMultiMixinPython.ump", 9211);
  }

  @Override
  @Test
  public void doActivityNestedStateMachine()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("pynext/doActivityNestedStateMachinePython.ump", 9211);
  }

  @Override
  @Test
  public void doActivityNoTransitions()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("pynext/doActivityNoTransitionsPython.ump", 9211);
  }

  @Override
  @Test
  public void activeObject()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("pynext/activeObjectPython.ump", 9211);
  }

  @Override
  @Test
  public void doActivitiesWithAutoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("doActivitiesWithAutoTransition.ump", 9211);
  }

  @Override
  @Test
  public void equivalentGuards()
  {
    // the guards name x, y and z, which the model does not define
    assertPythonDiagnostic("equivalentGuards.ump", 9210);
  }
@Override
   @Test
  public void eventlessStateMachine_before_PooledStateMachine()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("eventlessStateMachine_PooledStateMachine.ump", 9210);
  }
  @Override
  @Test
  public void pooledStateMachine_timedEvents()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("pooledStateMachine_timedEvents.ump", 9210);
  }
  @Override
  @Test
  public void testRegionFinalStates_6()
  {
    assertUmpleTemplateFor(languagePath + "/testRegionFinalStates_6Python.ump",languagePath + "/testRegionFinalStates_6."+ languagePath +".txt","X");
  }
@Override
@Test
  public void multipleQSM()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("multipleQSM.ump", 9210);
  }
@Override
  @Test
  public void multipleQSM_EventlessStateMachine()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("multipleQSM_EventlessStateMachine.ump", 9210);
  }
  @Override
  @Test
  public void multipleQSMe_nestedStates()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("multipleQSMe_nestedStates.ump", 9210);
  }
  @Override
  @Test
  public void multipleQSM_sameEvents()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("multipleQSM_sameEvents.ump", 9210);
  }
    @Override
  @Test
  public void nestedStatesOfQSMwithSameEventNames()
  {
    // a feature Python does not generate yet is reported
    assertPythonDiagnostic("nestedStatesOfQSMwithSameEventNames.ump", 9210);
  }
@Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")
@Override
@Test
  public void nestedState_StateMachine_timedEvents()
  {
  	assertUmpleTemplateFor("nestedStates_StateMachine_timedEvent.ump",languagePath + "/nestedStates_StateMachine_timedEvent."+ languagePath +".txt","Window");
  }
  @Override
  @Test
  public void sameEvent_twoStates_differentStatemachines()
  {
    assertUmpleTemplateFor("sameEvent_twoStates_differentStateMachines.ump",languagePath + "/sameEvent_twoStates_differentStatemachines."+ languagePath +".txt","LightFixture");
  }
  @Override
  @Test
  public void nestedStates_exitInnerBeforeOutter()
  {
    assertUmpleTemplateFor("nestedStates_exitInnerBeforeOutter.ump",languagePath + "/nestedStates_exitInnerBeforeOutter."+ languagePath +".txt","LightFixture");
  }
  
  @Override
  @Test
  public void refactorFinalState_hasAllInvalidElements()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("pynext/refactorFinalState_hasAllInvalidElementsPython.ump", 9211);
  }

  @Override
  @Test
  public void parallelSm_diffNamesDiffStatesEntryExitActions()
  {
    assertUmpleTemplateFor(languagePath + "/parallelSm_diffNamesDiffStatesEntryExitActionsPython.ump",languagePath + "/parallelSm_diffNamesDiffStatesEntryExitActions."+ languagePath +".txt","X");
  }

  @Override
  @Test
  public void noDefaultEntryMethodGenerated()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("pynext/noDefaultEntryMethodGeneratedPython.ump", 9211);
  }
  
  @Test
  public void noDefaultEntryMethodGenerated_2()
  {
    assertUmpleTemplateFor(languagePath + "/noDefaultEntryMethodGenerated_2Python.ump",languagePath + "/noDefaultEntryMethodGenerated_2."+ languagePath +".txt","X");    
  }
  @Override
  @Test
  public void parallelSm_sameNameDiffStatesEntryExitActions()
  {
    assertUmpleTemplateFor("parallelSm_sameNameDiffStatesEntryExitActions.ump",languagePath + "/parallelSm_sameNameDiffStatesEntryExitActions."+ languagePath +".txt","X");
  }

  @Override
  @Test
  public void eventWithArguments()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("eventWithArguments.ump", 9211);
  }

  @Override
  @Test
  public void refactorFinalState_invalidElementsInNestedFinalState()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("refactorFinalState_invalidElementsInNestedFinalState.ump", 9211);
  }

  @Override
  @Test
  public void refactorFinalState_onlyEntryAction()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("refactorFinalState_onlyEntryAction.ump", 9211);
  }

  @Override
  @Test
  public void checkExternalTransitions_withExitActions_2()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("checkExternalTransitions_withExitActions_2.ump", 9211);
  }

  @Override
  @Test
  public void checkExternalTransitions_concurrentStateMachines_2()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("checkExternalTransitions_concurrentStateMachines_2.ump", 9211);
  }

  @Override
  @Test
  public void eventWithArguments_1()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("eventWithArguments_1.ump", 9211);
  }

  @Override
  @Test
  public void stateMachineSpacing()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("stateMachineSpacing1.ump", 9211);
  }

  @Override
  @Test
  public void guardsOnEntryAndExit()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("1600_guardsOnEntryAndExit.ump", 9211);
  }

  @Override
  @Test
  public void checkExternalTransitions_concurrentStateMachines()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("checkExternalTransitions_concurrentStateMachines.ump", 9211);
  }
}
