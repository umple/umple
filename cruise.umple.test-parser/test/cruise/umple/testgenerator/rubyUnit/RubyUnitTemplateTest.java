package cruise.umple.testgenerator.rubyUnit;

import java.io.File;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.testgenerator.UnitTemplateTest;
import cruise.umple.util.SampleFileWriter;



public class RubyUnitTemplateTest extends UnitTemplateTest{
	
	
	TemplateTest templateTest = new TemplateTest();

	  @Before
	  public void setUp()
	  {
	super.setUp();
		language = "RubyUnit";
    	languagePath = "RubyUnit";
    	
    	
	  }
	  
	  @After
	  public void tearDown()
	  {
	    super.tearDown();
	    SampleFileWriter.destroy(pathToInput + "/rubyunit/DependTest.rb");
	    SampleFileWriter.destroy(pathToInput + "/rubyunit/GenerateTest.rb");
	    SampleFileWriter.destroy(pathToInput + "/rubyunit/TestcaseTest.rb");
	    SampleFileWriter.destroy(pathToInput + "/rubyunit/SubOptionTest.rb");
	    SampleFileWriter.destroy(pathToInput + "/rubyunit/AssertionTest.rb");
	    //SampleFileWriter.destroy(pathToInput + "/test/Test.umpt");
	    //SampleFileWriter.destroy(pathToInput + "/test/test");
	    //SampleFileWriter.destroy(pathToInput + "/junit/DependTest.java");
	    //SampleFileWriter.destroy(pathToInput + "/junit/GenerateTest.java");
	    
	  }
	  
	  
	  @Test 
	  public void TestGenerate()
	  {
		//language = "Java";
		//createUmpleSystem(languagePath, "/testGenerator_rubyunit_testGenerate.ump");
		
		language = "RubyUnit";
	    System.out.println(pathToInput);    	    
	    createUmpleTestSystem(languagePath, "/testGenerator_rubyunit_testGenerate.umpt");
	    System.out.println(pathToInput);
	    assertGeneratedCodeEquals(pathToInput, "/rubyunit/GenerateTest.rb");
	    Assert.assertEquals(true, (new File(pathToInput + "/rubyunit/GenerateTest.rb")).exists());
	    
	    
	  }
	  
	  @Test 
	  public void depends()
	  {
	    language = "RubyUnit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_RubyUnit_depend.umpt");
	    //assertUmpleTemplateFor("RubyUnit/testGenerate_model.umpt","RubyUnit/Testgenerate_model.rb");
	    assertGeneratedCodeEquals(pathToInput, "/rubyunit/DependTest.rb");
	    Assert.assertEquals(true, (new File(pathToInput + "/RubyUnit/DependTest.rb")).exists());
	  }
	  
	  @Test 
	  public void subOption()
	  {
	    language = "RubyUnit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_RubyUnit_subOption.umpt");
	    //assertUmpleTemplateFor("RubyUnit/testGenerate_model.umpt","RubyUnit/Testgenerate_model.rb");
	    assertGeneratedCodeEquals(pathToInput, "/rubyunit/SubOptionTest.rb");
	    Assert.assertEquals(true, (new File(pathToInput + "/RubyUnit/SubOptionTest.rb")).exists());
	  }
	  
	  @Test 
	  public void testCase()
	  {
	    language = "RubyUnit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_RubyUnit_testcase.umpt");
	    //assertUmpleTemplateFor("RubyUnit/testGenerate_model.umpt","RubyUnit/Testgenerate_model.rb");
	    assertGeneratedCodeEquals(pathToInput, "/rubyunit/TestcaseTest.rb");
	    Assert.assertEquals(true, (new File(pathToInput + "/RubyUnit/TestcaseTest.rb")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertion()
	  {
	    language = "RubyUnit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_rubyunit_testcase_assertion.umpt");
	    //assertUmpleTemplateFor("RubyUnit/testGenerate_model.umpt","RubyUnit/Testgenerate_model.rb");
	    assertGeneratedCodeEquals(pathToInput, "/rubyunit/AssertionTest.rb");
	    Assert.assertEquals(true, (new File(pathToInput + "/RubyUnit/AssertionTest.rb")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertionTrue()
	  {
	    language = "RubyUnit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_RubyUnit_depend.umpt");
	    //assertUmpleTemplateFor("RubyUnit/testGenerate_model.umpt","RubyUnit/Testgenerate_model.rb");
	    Assert.assertEquals(true, (new File(pathToInput + "/RubyUnit/DependTest.rb")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertionFalse()
	  {
	    language = "RubyUnit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_RubyUnit_depend.umpt");
	    //assertUmpleTemplateFor("RubyUnit/testGenerate_model.umpt","RubyUnit/Testgenerate_model.rb");
	    Assert.assertEquals(true, (new File(pathToInput + "/RubyUnit/DependTest.rb")).exists());
	  }
	  
	  @Test 
	  public void testCase_assertioneEqual()
	  {
	    language = "RubyUnit";
	    //System.out.println(languagePath);
	    createUmpleTestSystem(languagePath, "/testGenerator_RubyUnit_depend.umpt");
	    //assertUmpleTemplateFor("RubyUnit/testGenerate_model.umpt","RubyUnit/Testgenerate_model.rb");
	    Assert.assertEquals(true, (new File(pathToInput + "/RubyUnit/DependTest.rb")).exists());
	  }
}
