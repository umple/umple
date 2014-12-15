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
	  }
	  
	  @Test @Ignore
	  public void File()
	  {
		assertUmpleTemplateFor("nusmv/ExampleFile.ump","nusmv/ExampleFile.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile.smv")).exists());
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
	  public void CarTransmission()
	  {
		assertUmpleTemplateFor("nusmv/CarTransmission.ump","nusmv/CarTransmission.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/CarTransmission.smv")).exists());
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
}
