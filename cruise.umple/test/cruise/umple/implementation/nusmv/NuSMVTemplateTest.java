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
	    SampleFileWriter.destroy(pathToInput + "/alloy/ExampleFile.smv");
	   
	  }
	  
	  @Test @Ignore
	  public void ExampleFile()
	  {
		assertUmpleTemplateFor("alloy/ExampleFile.ump","nusmv/ExampleFile.nusmv.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/nusmv/ExampleFile.smv")).exists());
	  }
}
