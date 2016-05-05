package cruise.umple.implementation.nusmv;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

@SuppressWarnings("deprecation")
public class NuSMVTemplateTest extends TemplateTest{
	  @Before
	  public void setUp()
	  {
	    super.setUp();
	    language = "NuSMV";
	    languagePath = "nusmv";
	  }
	  
	  @After
	  public void tearDown()
	  {
	    super.tearDown();
	    SampleFileWriter.destroy(pathToInput + "/nusmv/ExampleFile.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/ExampleFile1.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/ExampleFile2.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/Test.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/CarTransmission.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/CourseSection.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/GrantApplication.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/AbstractMachine.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/NestedMachine.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/BigStateMachineTest.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/CourseSectionNested.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/NestedWatch.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/DigitalWatchFlat.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/Elevator.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/BigStateMachineWithNakedTransition.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/myTemporaryTest.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/FurnaceControlSystem.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/AbstractConcurrentSystem.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/MultiLevelStateMachineExample.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/MultiLevelStateMachineExampleCase2.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/nestedConcurrentMachine.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/concurrentMachineExample.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/JavaDataTypes.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/ArbitraryExample.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/AndCrossExample.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/AndCrossFromDeeplyNestedState.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/AndCrossFromDeeplyNestedStateCase2.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/EnhancedBitCounter.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/OutgoingTransitionOfConcurrentState.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/OutgoingTransitionOfConcurrentStateWithAndCross1.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/AdaptiveCruiseControlSystem.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/AdaptiveCruiseControlWithTerminalState.smv");
	    SampleFileWriter.destroy(pathToInput + "/nusmv/SingleEventMachine.smv");
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void SingleEventMachine()
	  {
	  		assertUmpleTemplateFor("nusmv/SingleEventMachine.ump","nusmv/SingleEventMachine.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/SingleEventMachine.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void OutgoingTransitionOfConcurrentStateWithAndCross1()
	  {
	  		assertUmpleTemplateFor("nusmv/OutgoingTransitionOfConcurrentStateWithAndCross1.ump","nusmv/OutgoingTransitionOfConcurrentStateWithAndCross1.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/OutgoingTransitionOfConcurrentStateWithAndCross1.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void OutgoingTransitionOfConcurrentState()
	  {
	  		assertUmpleTemplateFor("nusmv/OutgoingTransitionOfConcurrentState.ump","nusmv/OutgoingTransitionOfConcurrentState.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/OutgoingTransitionOfConcurrentState.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void EnhancedBitCounter()
	  {
	  		assertUmpleTemplateFor("nusmv/EnhancedBitCounter.ump","nusmv/EnhancedBitCounter.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/EnhancedBitCounter.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void AndCrossFromDeeplyNestedStateCase2()
	  {
	  		assertUmpleTemplateFor("nusmv/AndCrossFromDeeplyNestedStateCase2.ump","nusmv/AndCrossFromDeeplyNestedStateCase2.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/AndCrossFromDeeplyNestedStateCase2.smv")).exists());
	  }	  
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void AndCrossFromDeeplyNestedState()
	  {
	  		assertUmpleTemplateFor("nusmv/AndCrossFromDeeplyNestedState.ump","nusmv/AndCrossFromDeeplyNestedState.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/AndCrossFromDeeplyNestedState.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM ISSUE 740
	  public void concurrentMachineExample()
	  {
	  		assertUmpleTemplateFor("nusmv/concurrentMachineExample.ump","nusmv/concurrentMachineExample.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/concurrentMachineExample.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void nestedConcurrentMachine()
	  {
	  		assertUmpleTemplateFor("nusmv/nestedConcurrentMachine.ump","nusmv/nestedConcurrentMachine.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/nestedConcurrentMachine.smv")).exists());
	  }
	
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void MultiLevelStateMachineExample()
	  {
	  		assertUmpleTemplateFor("nusmv/MultiLevelStateMachineExample.ump","nusmv/MultiLevelStateMachineExample.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/MultiLevelStateMachineExample.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void MultiLevelStateMachineExampleCase2()
	  {
	  		assertUmpleTemplateFor("nusmv/MultiLevelStateMachineExampleCase2.ump","nusmv/MultiLevelStateMachineExampleCase2.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/MultiLevelStateMachineExampleCase2.smv")).exists());
	  }
	  
	  @Test @Ignore
	  public void File()
	  {
	  		assertUmpleTemplateFor("nusmv/ExampleFile.ump","nusmv/ExampleFile.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void myTemporaryTest()
	  {
	  		assertUmpleTemplateFor("nusmv/myTemporaryTest.ump","nusmv/myTemporaryTest.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/myTemporaryTest.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void ExampleFile1()
	  {
	  		assertUmpleTemplateFor("nusmv/ExampleFile1.ump","nusmv/ExampleFile1.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile1.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AdaptiveCruiseControlWithTerminalState()
	  {
	  		assertUmpleTemplateFor("nusmv/AdaptiveCruiseControlWithTerminalState.ump","nusmv/AdaptiveCruiseControlWithTerminalState.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/AdaptiveCruiseControlWithTerminalState.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void ExampleFile2()
	  {
	  		assertUmpleTemplateFor("nusmv/ExampleFile2.ump","nusmv/ExampleFile2.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile2.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void ExampleFile()
	  {
	  		assertUmpleTemplateFor("nusmv/ExampleFile.ump","nusmv/ExampleFile.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void DigitalWatchFlat()
	  {
	  		assertUmpleTemplateFor("nusmv/DigitalWatchFlat.ump","nusmv/DigitalWatchFlat.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/DigitalWatchFlat.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void CarTransmission()
	  {
	  		assertUmpleTemplateFor("nusmv/CarTransmission.ump","nusmv/CarTransmission.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/CarTransmission.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void ArbitraryExample()
	  {
	  		assertUmpleTemplateFor("nusmv/ArbitraryExample.ump","nusmv/ArbitraryExample.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ArbitraryExample.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AndCrossExample()
	  {
	  		assertUmpleTemplateFor("nusmv/AndCrossExample.ump","nusmv/AndCrossExample.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/AndCrossExample.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void JavaDataTypes()
	  {
	  		assertUmpleTemplateFor("nusmv/JavaDataTypes.ump","nusmv/JavaDataTypes.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/JavaDataTypes.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void Elevator()
	  {
	  		assertUmpleTemplateFor("nusmv/Elevator.ump","nusmv/Elevator.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/Elevator.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void FurnaceControlSystem()
	  {
	  		assertUmpleTemplateFor("nusmv/FurnaceControlSystem.ump","nusmv/FurnaceControlSystem.nusmv.txt");
				Assert.assertEquals(true, (new File(pathToInput + "/nusmv/FurnaceControlSystem.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void BigStateMachineWithNakedTransition()
	  {
	  		assertUmpleTemplateFor("nusmv/BigStateMachineWithNakedTransition.ump","nusmv/BigStateMachineWithNakedTransition.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/BigStateMachineWithNakedTransition.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AdaptiveCruiseControlSystem()
	  {
	  		assertUmpleTemplateFor("nusmv/AdaptiveCruiseControlSystem.ump","nusmv/AdaptiveCruiseControlSystem.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/AdaptiveCruiseControlSystem.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AbstractConcurrentSystem()
	  {
	  		assertUmpleTemplateFor("nusmv/AbstractConcurrentSystem.ump","nusmv/AbstractConcurrentSystem.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/AbstractConcurrentSystem.smv")).exists());
	  }
	  
	  @Test  //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void BigStateMachineTest()
	  {
	  		assertUmpleTemplateFor("nusmv/BigStateMachineTest.ump","nusmv/BigStateMachineTest.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/BigStateMachineTest.smv")).exists());
	  }
	  
	  @Test  //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void CourseSectionNested()
	  {
	  		assertUmpleTemplateFor("nusmv/CourseSectionNested.ump","nusmv/CourseSectionNested.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/CourseSectionNested.smv")).exists());
	  }
	  
	  @Test  //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void NestedWatch()
	  {
	  		assertUmpleTemplateFor("nusmv/NestedWatch.ump","nusmv/NestedWatch.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/NestedWatch.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void Test()
	  {
	  		assertUmpleTemplateFor("nusmv/Test.ump","nusmv/Test.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/Test.smv")).exists());
	  }
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void CourseSection()
	  {
	  		assertUmpleTemplateFor("nusmv/CourseSection.ump","nusmv/CourseSection.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/CourseSection.smv")).exists());
	  }
	  
	  @Test //@Ignore // TEMPORARY IGNORE BY TIM
	  public void GrantApplication()
	  {
	  		assertUmpleTemplateFor("nusmv/GrantApplication.ump","nusmv/GrantApplication.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/GrantApplication.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void AbstractMachine()
	  {
	  		assertUmpleTemplateFor("nusmv/AbstractMachine.ump","nusmv/AbstractMachine.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/AbstractMachine.smv")).exists());
	  }
	  
	  @Test //@Ignore  // TEMPORARY IGNORE BY TIM
	  public void NestedMachine()
	  {
	  		assertUmpleTemplateFor("nusmv/NestedMachine.ump","nusmv/NestedMachine.nusmv.txt");
	  		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/NestedMachine.smv")).exists());
	  }
}
