package cruise.umple.implementation.nusmv;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

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
	  }
	  
	  @Test @Ignore
	  public void File()
	  {
		assertUmpleTemplateFor("nusmv/ExampleFile.ump","nusmv/ExampleFile.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void myTemporaryTest()
	  {
		assertUmpleTemplateFor("nusmv/myTemporaryTest.ump","nusmv/myTemporaryTest.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/myTemporaryTest.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void ExampleFile1()
	  {
		assertUmpleTemplateFor("nusmv/ExampleFile1.ump","nusmv/ExampleFile1.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile1.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void ExampleFile2()
	  {
		assertUmpleTemplateFor("nusmv/ExampleFile2.ump","nusmv/ExampleFile2.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile2.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void ExampleFile()
	  {
		assertUmpleTemplateFor("nusmv/ExampleFile.ump","nusmv/ExampleFile.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void DigitalWatchFlat()
	  {
		assertUmpleTemplateFor("nusmv/DigitalWatchFlat.ump","nusmv/DigitalWatchFlat.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/DigitalWatchFlat.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void CarTransmission()
	  {
		assertUmpleTemplateFor("nusmv/CarTransmission.ump","nusmv/CarTransmission.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/CarTransmission.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void Elevator()
	  {
		assertUmpleTemplateFor("nusmv/Elevator.ump","nusmv/Elevator.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/Elevator.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void BigStateMachineWithNakedTransition()
	  {
		assertUmpleTemplateFor("nusmv/BigStateMachineWithNakedTransition.ump","nusmv/BigStateMachineWithNakedTransition.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/BigStateMachineWithNakedTransition.smv")).exists());
	  }
	  
	  @Test @Ignore
	  public void FurnaceControlSystem()
	  {
		assertUmpleTemplateFor("nusmv/FurnaceControlSystem.ump","nusmv/FurnaceControlSystem.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/FurnaceControlSystem.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void BigStateMachineTest()
	  {
		assertUmpleTemplateFor("nusmv/BigStateMachineTest.ump","nusmv/BigStateMachineTest.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/BigStateMachineTest.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void CourseSectionNested()
	  {
		assertUmpleTemplateFor("nusmv/CourseSectionNested.ump","nusmv/CourseSectionNested.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/CourseSectionNested.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void NestedWatch()
	  {
		assertUmpleTemplateFor("nusmv/NestedWatch.ump","nusmv/NestedWatch.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/NestedWatch.smv")).exists());
	  }
	  
	  @Test //@Ignore
	  public void Test()
	  {
		assertUmpleTemplateFor("nusmv/Test.ump","nusmv/Test.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/Test.smv")).exists());
	  }
	  @Test //@Ignore
	  public void CourseSection()
	  {
		assertUmpleTemplateFor("nusmv/CourseSection.ump","nusmv/CourseSection.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/CourseSection.smv")).exists());
	  }
	  
	  @Test 
	  public void GrantApplication()
	  {
		assertUmpleTemplateFor("nusmv/GrantApplication.ump","nusmv/GrantApplication.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/GrantApplication.smv")).exists());
	  }
	  
	  @Test 
	  public void AbstractMachine()
	  {
		assertUmpleTemplateFor("nusmv/AbstractMachine.ump","nusmv/AbstractMachine.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/AbstractMachine.smv")).exists());
	  }
	  
	  @Test 
	  public void NestedMachine()
	  {
		assertUmpleTemplateFor("nusmv/NestedMachine.ump","nusmv/NestedMachine.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/NestedMachine.smv")).exists());
	  }
}
