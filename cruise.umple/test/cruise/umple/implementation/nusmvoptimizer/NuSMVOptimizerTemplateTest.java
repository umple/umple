package cruise.umple.implementation.nusmvoptimizer;

import java.io.File;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class NuSMVOptimizerTemplateTest extends TemplateTest{
	  @Before
	  public void setUp()
	  {
	    super.setUp();
	    language = "NuSMVOptimizer";
	    languagePath = "nusmvoptimizer";
	  }
	  
	  @After
	  public void tearDown()
	  {
	    super.tearDown();
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/ExampleFile.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/ExampleFile1.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/ExampleFile2.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/FlatElevator.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/FlatSpecificFlight.smv");	    
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/Test.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/CarTransmission.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/CourseSection.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/GrantApplication.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/AbstractMachine.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/NestedMachine.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/BigStateMachineTest.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/CourseSectionNested.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/NestedWatch.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/DigitalWatchFlat.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/Elevator.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/BigStateMachineWithNakedTransition.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/myTemporaryTest.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/FurnaceControlSystem.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/AbstractConcurrentSystem.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/MultiLevelStateMachineExample.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/MultiLevelStateMachineExampleCase2.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/nestedConcurrentMachine.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/concurrentMachineExample.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/JavaDataTypes.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/ArbitraryExample.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/AndCrossExample.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/AndCrossFromDeeplyNestedState.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/AndCrossFromDeeplyNestedStateCase2.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/EnhancedBitCounter.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/OutgoingTransitionOfConcurrentState.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/OutgoingTransitionOfConcurrentStateWithAndCross1.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/AdaptiveCruiseControlSystem.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/AdaptiveCruiseControlWithTerminalState.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/SingleEventMachine.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/SimpleCaseOfNondeterminism.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/SingleLaneBridge.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/RoomHeatingSystem.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/ConstantTest.smv");
		SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/InputVarTest.smv");
		SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/RangeTypeTest.smv");
		SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/EmptyStateTest.smv");
		SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/SpecificFlight.smv");
		SampleFileWriter.destroy(pathToInput + "/nusmvoptimizer/paper_example.smv");
	  }

	  @Test
	  public void EmptyStateMachineTest() {
		Assert.assertNotNull(createUmpleSystem(pathToInput,"/nusmvoptimizer/EmptyStateTest.ump")); //umple file with empty state machines should not make system fail. 

	  }
	  
	  @Test   // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void SpecificFlight() {
	  		assertUmpleTemplateFor("nusmvoptimizer/SpecificFlight.ump","nusmvoptimizer/SpecificFlight.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/SpecificFlight.smv")).exists());
	  }
	  
	  @Test   // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void FlatSpecificFlight() {
	  		assertUmpleTemplateFor("nusmvoptimizer/FlatSpecificFlight.ump","nusmvoptimizer/FlatSpecificFlight.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/FlatSpecificFlight.smv")).exists());
	  }
	  
	  @Ignore //@Test    // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void RangeTypeTest() {
	  		assertUmpleTemplateFor("nusmvoptimizer/RangeTypeTest.ump","nusmvoptimizer/RangeTypeTest.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/RangeTypeTest.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void InputVariableTest()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/InputVarTest.ump","nusmvoptimizer/InputVarTest.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/InputVarTest.smv")).exists());
	  }

	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void ConstantTest()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/ConstantTest.ump","nusmvoptimizer/ConstantTest.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/ConstantTest.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void RoomHeatingSystem()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/RoomHeatingSystem.ump","nusmvoptimizer/RoomHeatingSystem.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/RoomHeatingSystem.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void SingleLaneBridge()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/SingleLaneBridge.ump","nusmvoptimizer/SingleLaneBridge.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/SingleLaneBridge.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void SimpleCaseOfNondeterminism()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/SimpleCaseOfNondeterminism.ump","nusmvoptimizer/SimpleCaseOfNondeterminism.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/SimpleCaseOfNondeterminism.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void SingleEventMachine()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/SingleEventMachine.ump","nusmvoptimizer/SingleEventMachine.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/SingleEventMachine.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void OutgoingTransitionOfConcurrentStateWithAndCross1()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/OutgoingTransitionOfConcurrentStateWithAndCross1.ump","nusmvoptimizer/OutgoingTransitionOfConcurrentStateWithAndCross1.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/OutgoingTransitionOfConcurrentStateWithAndCross1.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void OutgoingTransitionOfConcurrentState()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/OutgoingTransitionOfConcurrentState.ump","nusmvoptimizer/OutgoingTransitionOfConcurrentState.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/OutgoingTransitionOfConcurrentState.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void EnhancedBitCounter()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/EnhancedBitCounter.ump","nusmvoptimizer/EnhancedBitCounter.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/EnhancedBitCounter.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void AndCrossFromDeeplyNestedStateCase2()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/AndCrossFromDeeplyNestedStateCase2.ump","nusmvoptimizer/AndCrossFromDeeplyNestedStateCase2.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/AndCrossFromDeeplyNestedStateCase2.smv")).exists());
	  }	  
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void AndCrossFromDeeplyNestedState()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/AndCrossFromDeeplyNestedState.ump","nusmvoptimizer/AndCrossFromDeeplyNestedState.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/AndCrossFromDeeplyNestedState.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void concurrentMachineExample()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/concurrentMachineExample.ump","nusmvoptimizer/concurrentMachineExample.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/concurrentMachineExample.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void nestedConcurrentMachine()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/nestedConcurrentMachine.ump","nusmvoptimizer/nestedConcurrentMachine.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/nestedConcurrentMachine.smv")).exists());
	  }
	
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void MultiLevelStateMachineExample()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/MultiLevelStateMachineExample.ump","nusmvoptimizer/MultiLevelStateMachineExample.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/MultiLevelStateMachineExample.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void MultiLevelStateMachineExampleCase2()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/MultiLevelStateMachineExampleCase2.ump","nusmvoptimizer/MultiLevelStateMachineExampleCase2.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/MultiLevelStateMachineExampleCase2.smv")).exists());
	  }
	  
	  @Test @Ignore
	  public void File()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/ExampleFile.ump","nusmvoptimizer/ExampleFile.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/ExampleFile.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void myTemporaryTest()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/myTemporaryTest.ump","nusmvoptimizer/myTemporaryTest.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/myTemporaryTest.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void ExampleFile1()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/ExampleFile1.ump","nusmvoptimizer/ExampleFile1.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/ExampleFile1.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AdaptiveCruiseControlWithTerminalState()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/AdaptiveCruiseControlWithTerminalState.ump","nusmvoptimizer/AdaptiveCruiseControlWithTerminalState.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/AdaptiveCruiseControlWithTerminalState.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void ExampleFile2()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/ExampleFile2.ump","nusmvoptimizer/ExampleFile2.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/ExampleFile2.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void ExampleFile()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/ExampleFile.ump","nusmvoptimizer/ExampleFile.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/ExampleFile.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void DigitalWatchFlat()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/DigitalWatchFlat.ump","nusmvoptimizer/DigitalWatchFlat.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/DigitalWatchFlat.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void CarTransmission()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/CarTransmission.ump","nusmvoptimizer/CarTransmission.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/CarTransmission.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void ArbitraryExample()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/ArbitraryExample.ump","nusmvoptimizer/ArbitraryExample.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/ArbitraryExample.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AndCrossExample()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/AndCrossExample.ump","nusmvoptimizer/AndCrossExample.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/AndCrossExample.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void JavaDataTypes()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/JavaDataTypes.ump","nusmvoptimizer/JavaDataTypes.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/JavaDataTypes.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void Elevator()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/Elevator.ump","nusmvoptimizer/Elevator.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/Elevator.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void FlatElevator()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/FlatElevator.ump","nusmvoptimizer/FlatElevator.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/FlatElevator.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void FurnaceControlSystem()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/FurnaceControlSystem.ump","nusmvoptimizer/FurnaceControlSystem.nusmvoptimizer.txt");
				Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/FurnaceControlSystem.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void BigStateMachineWithNakedTransition()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/BigStateMachineWithNakedTransition.ump","nusmvoptimizer/BigStateMachineWithNakedTransition.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/BigStateMachineWithNakedTransition.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AdaptiveCruiseControlSystem()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/AdaptiveCruiseControlSystem.ump","nusmvoptimizer/AdaptiveCruiseControlSystem.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/AdaptiveCruiseControlSystem.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AbstractConcurrentSystem()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/AbstractConcurrentSystem.ump","nusmvoptimizer/AbstractConcurrentSystem.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/AbstractConcurrentSystem.smv")).exists());
	  }
	  
	  @Test  //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void BigStateMachineTest()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/BigStateMachineTest.ump","nusmvoptimizer/BigStateMachineTest.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/BigStateMachineTest.smv")).exists());
	  }
	  
	  @Ignore  //@Test TEMPORARY IGNORE BY TIM
	  public void PaperExample()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/PaperExample.ump","nusmvoptimizer/PaperExample.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/PaperExample.smv")).exists());
	  }
	  
	  @Test  //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void CourseSectionNested()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/CourseSectionNested.ump","nusmvoptimizer/CourseSectionNested.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/CourseSectionNested.smv")).exists());
	  }
	  
	  @Test  //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void NestedWatch()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/NestedWatch.ump","nusmvoptimizer/NestedWatch.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/NestedWatch.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void Test()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/Test.ump","nusmvoptimizer/Test.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/Test.smv")).exists());
	  }
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void CourseSection()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/CourseSection.ump","nusmvoptimizer/CourseSection.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/CourseSection.smv")).exists());
	  }
	  
	  @Test //@Ignore // TEMPORARY IGNORE BY TIM
	  public void GrantApplication()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/GrantApplication.ump","nusmvoptimizer/GrantApplication.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/GrantApplication.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AbstractMachine()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/AbstractMachine.ump","nusmvoptimizer/AbstractMachine.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/AbstractMachine.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void NestedMachine()
	  {
	  		assertUmpleTemplateFor("nusmvoptimizer/NestedMachine.ump","nusmvoptimizer/NestedMachine.nusmvoptimizer.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmvoptimizer/NestedMachine.smv")).exists());
	  }
}
