package cruise.umple.testgenerator.phpUnit;

import java.io.File;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.testgenerator.UnitTemplateTest;
import cruise.umple.util.SampleFileWriter;



public class PhpUnitTemplateTest extends UnitTemplateTest{
	
	
	TemplateTest templateTest = new TemplateTest();

	  @Before
	  public void setUp()
	  {
	super.setUp();
		language = "PhpUnit";
    	languagePath = "PhpUnit";
    	
    	
	  }
	  
	  @After
	  public void tearDown()
	  {
	    super.tearDown();
	    SampleFileWriter.destroy(pathToInput + "/phpunit/DependTest.php");
	    SampleFileWriter.destroy(pathToInput + "/phpunit/GenerateTest.php");
	    SampleFileWriter.destroy(pathToInput + "/phpunit/TestcaseTest.php");
	    SampleFileWriter.destroy(pathToInput + "/phpunit/SubOptionTest.php");
	    SampleFileWriter.destroy(pathToInput + "/phpunit/AssertionTest.php");
	    //SampleFileWriter.destroy(pathToInput + "/test/Test.umpt");
	    //SampleFileWriter.destroy(pathToInput + "/test/test");
	    //SampleFileWriter.destroy(pathToInput + "/phpunit/DependTest.java");
	    //SampleFileWriter.destroy(pathToInput + "/phpunit/GenerateTest.java");
	    
	  }
	  
	  
	  @Test 
	  public void TestGenerate()
	  {
		language = "Java";
		//createUmpleSystem(languagePath, "/testGenerator_phpunit_testGenerate.ump");
		
		language = "PhpUnit";
	    System.out.println(pathToInput);    	    
	    createUmpleTestSystem(languagePath, "/testGenerator_phpunit_testGenerate.umpt");
	    System.out.println(pathToInput);
	    assertGeneratedCodeEquals(pathToInput, "/phpunit/GenerateTest.php");
	    Assert.assertEquals(true, (new File(pathToInput + "/phpunit/GenerateTest.php")).exists());
	    
	    
	  }
	  
	  @Test 
	  public void depends()
	  {
	    language = "phpunit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_phpunit_depend.umpt");
	    //assertUmpleTemplateFor("phpunit/testGenerate_model.umpt","phpunit/Testgenerate_model.java");
	    assertGeneratedCodeEquals(pathToInput, "/phpunit/DependTest.php");
	    Assert.assertEquals(true, (new File(pathToInput + "/phpunit/DependTest.php")).exists());
	  }
	  
	  @Test 
	  public void subOption()
	  {
	    language = "phpunit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_phpunit_subOption.umpt");
	    //assertUmpleTemplateFor("phpunit/testGenerate_model.umpt","phpunit/Testgenerate_model.java");
	    assertGeneratedCodeEquals(pathToInput, "/phpunit/SubOptionTest.php");
	    Assert.assertEquals(true, (new File(pathToInput + "/phpunit/SubOptionTest.php")).exists());
	  }
	  
	  @Test 
	  public void testCase()
	  {
	    language = "phpunit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_phpunit_testcase.umpt");
	    //assertUmpleTemplateFor("phpunit/testGenerate_model.umpt","phpunit/Testgenerate_model.java");
	    assertGeneratedCodeEquals(pathToInput, "/phpunit/TestcaseTest.php");
	    Assert.assertEquals(true, (new File(pathToInput + "/phpunit/TestcaseTest.php")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertion()
	  {
	    language = "phpunit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_phpunit_testcase_assertion.umpt");
	    //assertUmpleTemplateFor("phpunit/testGenerate_model.umpt","phpunit/Testgenerate_model.java");
	    assertGeneratedCodeEquals(pathToInput, "/phpunit/AssertionTest.php");
	    Assert.assertEquals(true, (new File(pathToInput + "/phpunit/AssertionTest.php")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertionTrue()
	  {
	    language = "phpunit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_phpunit_depend.umpt");
	    //assertUmpleTemplateFor("phpunit/testGenerate_model.umpt","phpunit/Testgenerate_model.java");
	    //assertGeneratedCodeEquals(pathToInput, "/phpunit/GenerateTest.php");
	    Assert.assertEquals(true, (new File(pathToInput + "/phpunit/DependTest.php")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertionFalse()
	  {
	    language = "phpunit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_phpunit_depend.umpt");
	    //assertUmpleTemplateFor("phpunit/testGenerate_model.umpt","phpunit/Testgenerate_model.java");
	    //assertGeneratedCodeEquals(pathToInput, "/phpunit/GenerateTest.php");
	    Assert.assertEquals(true, (new File(pathToInput + "/phpunit/DependTest.php")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertioneEqual()
	  {
	    language = "phpunit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_phpunit_depend.umpt");
	    //assertUmpleTemplateFor("phpunit/testGenerate_model.umpt","phpunit/Testgenerate_model.java");
	    //assertGeneratedCodeEquals(pathToInput, "/phpunit/GenerateTest.php");
	    Assert.assertEquals(true, (new File(pathToInput + "/phpunit/DependTest.php")).exists());
	  }
}
