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
  
}