package cruise.umple.testgenerator.jUnit;

import java.io.File;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.testgenerator.UnitTemplateTest;
import cruise.umple.util.SampleFileWriter;



public class JUnitTemplateTest extends UnitTemplateTest{
	
	
	TemplateTest templateTest = new TemplateTest();

	  @Before
	  public void setUp()
	  {
	super.setUp();
		language = "JUnit";
    	languagePath = "JUnit";
    	
    	
	  }
	  
	  @After
	  public void tearDown()
	  {
	    super.tearDown();
	    
	    //SampleFileWriter.destroy(pathToInput + "/test/Test.umpt");
	    //SampleFileWriter.destroy(pathToInput + "/test/test");
	    SampleFileWriter.destroy(pathToInput + "/junit/DependTest.java");
	    SampleFileWriter.destroy(pathToInput + "/junit/GenerateTest.java");
	    SampleFileWriter.destroy(pathToInput + "/junit/TestcaseTest.java");
	    SampleFileWriter.destroy(pathToInput + "/junit/SubOptionTest.java");
	    SampleFileWriter.destroy(pathToInput + "/junit/AssertionTest.java");
	    
	  }
	  
	  
	  @Test 
	  public void TestGenerate()
	  {
		//language = "Java";
		//createUmpleSystem(languagePath, "/testGenerator_jUnit_testGenerate.ump");
		
		language = "JUnit";
	    //system.out.println(pathToInput);    	    
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_testGenerate.umpt");
	    //system.out.println(pathToInput);
	    assertGeneratedCodeEquals(pathToInput, "/junit/GenerateTest.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/GenerateTest.java")).exists());
	    
	    
	  }
	  
	  @Test 
	  public void depends()
	  {
	    language = "JUnit";
	    ////system.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_depend.umpt");
	    //assertUmpleTemplateFor("junit/testGenerate_model.umpt","junit/Testgenerate_model.java");
	    assertGeneratedCodeEquals(pathToInput, "/junit/DependTest.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/DependTest.java")).exists());
	  }
	  
	  @Test 
	  public void subOption()
	  {
	    language = "JUnit";
	    ////system.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_subOption.umpt");
	    //assertUmpleTemplateFor("junit/testGenerate_model.umpt","junit/Testgenerate_model.java");
	    assertGeneratedCodeEquals(pathToInput, "/junit/SubOptionTest.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/SubOptionTest.java")).exists());
	  }
	  
	  @Test 
	  public void testCase()
	  {
	    language = "JUnit";
	    ////system.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_testcase.umpt");
	    //assertUmpleTemplateFor("junit/testGenerate_model.umpt","junit/Testgenerate_model.java");
	    assertGeneratedCodeEquals(pathToInput, "/junit/TestcaseTest.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/TestcaseTest.java")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertion()
	  {
	    language = "JUnit";
	    ////system.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_testcase_assertion.umpt");
	    //assertUmpleTemplateFor("junit/testGenerate_model.umpt","junit/Testgenerate_model.java");
	    assertGeneratedCodeEquals(pathToInput, "/junit/AssertionTest.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/AssertionTest.java")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertionTrue()
	  {
	    language = "JUnit";
	    ////system.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_depend.umpt");
	    //assertUmpleTemplateFor("junit/testGenerate_model.umpt","junit/Testgenerate_model.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/DependTest.java")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertionFalse()
	  {
	    language = "JUnit";
	    ////system.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_depend.umpt");
	    //assertUmpleTemplateFor("junit/testGenerate_model.umpt","junit/Testgenerate_model.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/DependTest.java")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertioneEqual()
	  {
	    language = "JUnit";
	    ////system.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_depend.umpt");
	    //assertUmpleTemplateFor("junit/testGenerate_model.umpt","junit/Testgenerate_model.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/DependTest.java")).exists());
	  }
	  
	  @Test 
	  public void testCase_NoGiven()
	  {
	    language = "JUnit";
	    ////system.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_jUnit_testGenerate.umpt");
	    //assertUmpleTemplateFor("junit/testGenerate_model.umpt","junit/Testgenerate_model.java");
	    Assert.assertEquals(true, (new File(pathToInput + "/junit/GenerateTest.java")).exists());
	  }
}
