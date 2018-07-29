package cruise.umple.implementation.test;

import java.io.File;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	    
	    //SampleFileWriter.destroy(pathToInput + "/test/Test.umpt");
	    //SampleFileWriter.destroy(pathToInput + "/test/test");
	    
	  }
	  
	  
	  @Test 
	  public void Attribute()
	  {
	    language = null;
	    assertUmpleTemplateFor("test/attribute.ump","test/testAttribute.test.txt");
	    Assert.assertEquals(true, (new File(pathToInput + "/test/test/ATest.umpt")).exists());
	  }
	  
	  @Test 
	  public void LazyAttribute()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/LazyAttribute.ump","/test/testAttributeLazy.test.txt");
	    Assert.assertEquals(true, (new File(pathToInput + "/test/test/LazyATest.umpt")).exists());
	  }
	  
	  @Test 
	  public void ImmutableAttribute()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/immutableAttribute.ump","test/testAttributeImmutable.test.txt");
	    Assert.assertEquals(true, (new File(pathToInput + "/test/test/ImmutableATest.umpt")).exists());
	  }
	  
	  @Test 
	  public void OptionalOneToManyAssociation()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/OptionalOneToManyAssociation.ump","test/testAssociationOptionalOneToMany.test.txt");
	    Assert.assertEquals(true, (new File(pathToInput + "/test/test/OptionalOneToManyAssociation_ModelTest.umpt")).exists());
	  }
	  
	  @Test 
	  public void OneToManyAssociation()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/OneToManyAssociation.ump","test/testAssociationOneToMany.test.txt");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/OneToManyAssociation_ModelTest.umpt")).exists());
	  }
	  
	  /*@Test @Ignore
	  public void AirlineExample()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/AirlineExample.ump","test/AirlineExample.test.txt");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/AirlineExample_ModelTest.umpt")).exists());
	  }*/
	  
	  @Test 
	  public void NNToManyAssociation()
	  {
	    language = "Test";
	    //assertUmpleTemplateFor("test/NNToManyAssociation.ump","test/testAssociationNNToMany.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/NNToManyAssociation.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/ATest.umpt")).exists());
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/BTest.umpt")).exists());
	    
	  }
	  @Test
	  public void methodAssertion()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/methodAssertion.ump","test/testMethodAssertion.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/methodAssertion.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/MethodAssertionTest.umpt")).exists());
	   
	    
	  }
	  
	  
	  
	 
	  
}
