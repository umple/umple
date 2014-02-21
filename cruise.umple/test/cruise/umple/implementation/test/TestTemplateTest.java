package cruise.umple.implementation.test;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;



public class TestTemplateTest extends TemplateTest{

	  @Before
	  public void setUp()
	  {
	super.setUp();
		language = "Test";
    	languagePath = "test";
    	
	  }
	  
	  @After
	  public void tearDown()
	  {
	    super.tearDown();
	    //SampleFileWriter.destroy(pathToInput + "/test/Mentor.txt");
	    //SampleFileWriter.destroy(pathToInput + "/Lamp.txt");
	    SampleFileWriter.destroy(pathToInput + "/test/attribute.txt");
	  }
	  
	  
	  @Test
	  public void Attribute()
	  {
	    language = null;
	    assertUmpleTemplateFor("test/attribute.ump","test/testAttribute.test.txt");
	    Assert.assertEquals(true, (new File(pathToInput + "/test/attribute.txt")).exists());
	  }  
	  
	 
	  
}
