package cruise.umple.implementation.test;

import java.io.File;
import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.internal.TextListener;
import org.junit.runner.Result;
//import com.ibm.icu.util.BytesTrie.Result;
import org.junit.runner.notification.Failure;

import cruise.umple.implementation.ClassTemplateTest;
import cruise.umple.util.SampleFileWriter;



public class TestTemplateTest extends ClassTemplateTest{

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
		SampleFileWriter.destroy(pathToInput + "/AssociationInlineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/AssociationMultilineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/AttributeInlineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/AttributeMultilineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/Bar1Test.umpt");
		SampleFileWriter.destroy(pathToInput + "/Bar2Test.umpt");
		SampleFileWriter.destroy(pathToInput + "/Bar3Test.umpt");
		SampleFileWriter.destroy(pathToInput + "/Bar4Test.umpt");
		SampleFileWriter.destroy(pathToInput + "/BarTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/ClassCommentWithEmptyLines_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/ClassTemplateTest_CodeInjectionsBasic_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/ClassTemplateTest_CodeInjectionsComments_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/ClassTemplateTest_CodeInjectionsNoBraces_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/ClassTemplateTest_CodeInjectionsParametersMulti_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/ClassTemplateTest_CodeInjectionsParametersUnspecified_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/ClassTemplateTest_CodeInjectionsSingleLine_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/ClassTemplateTest_NoNamespace_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/FooTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/MethodCommentWithEmptyLines_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/MethodInlineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/MethodMultilineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/MultipleAssociationComments_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/MultipleAttributeComments_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/MultipleMethodComments_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/StudentTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/TokenTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/AssociationInlineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/AssociationMultilineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/AttributeInlineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/AttributeMultilineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/Bar1Test.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/Bar2Test.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/Bar3Test.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/Bar4Test.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/BarTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/ClassCommentWithEmptyLines_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsBasic_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsComments_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsNoBraces_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsParametersMulti_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsParametersUnspecified_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsSingleLine_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_NoNamespace_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/FooTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/MethodCommentWithEmptyLines_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/MethodInlineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/MethodMultilineComment_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/MultipleAssociationComments_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/MultipleAttributeComments_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/MultipleMethodComments_ModelTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/StudentTest.umpt");
		SampleFileWriter.destroy(pathToInput + "/test/TokenTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/FooTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/Bar1Test.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/Bar2Test.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/Bar3Test.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/Bar4Test.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/BarTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/AttributeInlineComment_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/ClassCommentWithEmptyLines_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/AttributeMultilineComment_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/AssociationMultilineComment_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/AssociationInlineComment_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsBasic_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsComments_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsNoBraces_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsParametersMulti_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsParametersUnspecified_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_CodeInjectionsSingleLine_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/ClassTemplateTest_NoNamespace_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/MethodCommentWithEmptyLines_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/MethodInlineComment_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/MethodMultilineComment_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/MultipleAssociationComments_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/MultipleAttributeComments_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/MultipleMethodComments_ModelTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/StudentTest.umpt");
	    SampleFileWriter.destroy(pathToInput + "/test/TokenTest.umpt");
	    
	    
	    
	  }
	  
	  public static void main (String[] args)
	  {
	     JUnitCore  junit = new JUnitCore();
	     junit.addListener(new TextListener(System.out));
	     org.junit.runner.Result result = junit.run(TestTemplateTest.class);
	     
	     TestTemplateTest testClass = new TestTemplateTest();
	     
	     
	     
	     resultReport(result);
	     
	     
	     if(result.wasSuccessful())
	     {
	    	 System.out.println("test has successfully passed");
	     }
	     
	     
	     
	     else {
	    	 double y = result.getFailureCount();
		     double z = result.getRunCount();	 
	     int x = (int) ((y/z)  * 100)  ;
	     for (Failure f : result.getFailures())
	     {	    	 
	     System.out.println(f.getDescription() + "failed");
	     }
	     
	     System.out.println("Mutation Score: "+ x);
	     }
	     
	     
	     
	     for(Field field : TestTemplateTest.class.getDeclaredFields() )
	     {
	    	 System.out.println(field.getName());
	     }
	     
	     
	  }
	  
	  public static void resultReport(Result result) {
		    System.out.println("Finished. Result: Failures: " +
		      result.getFailureCount() + ". Ignored: " +
		      result.getIgnoreCount() + ". Tests run: " +
		      result.getRunCount() + ". Time: " +
		      result.getRunTime() + "ms.");
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
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/ATest.umpt")).exists());
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/BTest.umpt")).exists());
	    
	  }
	  
	  /*
	  @Test
	  public void methodAssertion()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/MethodAssertion.ump","test/testMethodAssertion.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/MethodAssertion.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/MethodAssertionTest.umpt")).exists());
	   
	    
	  }*/
	  
	  
	  @Test
	  public void classAssertion()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/ClassAssertion.ump","test/testClassAssertion.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/ClassAssertion.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/ClassAssertionTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void traitAssertion()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TraitAssertion.ump","test/testTraitAssertion.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TraitAssertion.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TraitAssertion_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void traitAssertion_multiplTraits()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TraitAssertion_multipleTraits.ump","test/testTraitAssertion_multipleTraits.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TraitAssertion_multipleTraits.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TraitAssertion_multipleTraits_ModelTest.umpt")).exists());
	   
	    
	  }
	  /*
	  @Test @Ignore 
	  public void traitAssertion_extendedTraits()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TraitAssertion_extendedTrait.ump","test/testTraitAssertion_multipleTraits.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TraitAssertion_extendedTrait.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TraitAssertion_extendedTrait_ModelTest.umpt")).exists());
	   
	    
	  }*/
	  
	  @Test 
	  public void traitAssertion_SameTestMultiplTraits()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TraitAssertion_SameTestMultipleTraits.ump","test/testTraitAssertion_SameTestMultipleTraits.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TraitAssertion_SameTestMultipleTraits.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TraitAssertion_SameTestMultipleTraits_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void mixsetTest()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/MixsetTest.ump","test/testMixsetTest.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/MixsetTest.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/MixsetTest_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void mixsetTest_action()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/MixsetTest_action.ump","test/testMixsetTest_action.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/MixsetTest_action.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/MixsetTest_action_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  
	  @Test
	  public void mixsetTest_multiple()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/MixsetTest_multiple.ump","test/testMixsetTest_multiple.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/MixsetTest_multiple.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/MixsetTest_multiple_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void mixsetTest_SameTestMultipleMixsets()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/MixsetTest_SameTestMultipleMixsets.ump","test/testMixsetTest_SameTestMultipleMixsets.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/MixsetTest_SameTestMultipleMixsets.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/MixsetTest_SameTestMultipleMixsets_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  
	  @Test
	  public void testcaseAction()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TestCaseAction.ump","test/testTestcaseAction.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TestCaseAction.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TestCaseAction_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void testcaseAction_trait()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TestCaseAction_trait.ump","test/testTestcaseAction_trait.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TestCaseAction_trait.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TestCaseAction_trait_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void interfaceTest()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/interfaceTest.ump","test/testInterfaceTest.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/interfaceTest.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/interfaceTest_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void ifStatement_Test()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/ifStatementTest.ump","test/testIfStatementTest.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/ifStatementTest.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/ifStatementTest_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void ifElseStatement_Test()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/ifElseStatementTest.ump","test/testIfElseStatementTest.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/ifElseStatementTest.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/ifElseStatementTest_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void elseStatement_Test()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/elseStatementTest.ump","test/testElseStatementTest.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/elseStatementTest.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/elseStatementTest_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  
	  @Test
	  public void abstractTest()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TestCase_AbstractTest.ump","test/testAbstractTest.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TestCase_AbstractTest.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TestCase_AbstractTest_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void fatherTest()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TestCase_AnscestralTest.ump","test/testAnscestralAbstractTest.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TestCase_AnscestralTest.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TestCase_AnscestralTest_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void testSequence_noTestCasesTest()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/TestSequence_noTestCases.ump","test/testTestSequence_noTestCases.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/TestSequence_noTestCases.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/TestSequence_noTestCases_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase.ump","test/testGenericTestcase.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_String()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_String.ump","test/testGenericTestcase_String.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_String.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_String_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_Integer()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_Integer.ump","test/testGenericTestcase_Integer.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_Integer.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_Integer_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_method()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_method.ump","test/testGenericTestcase_method.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_method.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_method_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_association()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association.ump","test/testGenericTestcase_association.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_association_toSingular()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_toSingular.ump","test/testGenericTestcase_association_toSingular.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyassociation_toSingular_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_toSingular.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_toSingular_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  
	  @Test
	  public void genericTestCaseTest_association_oneToMany()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_oneToMany.ump","test/testGenericTestcase_association_oneToMany.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyassociation_oneToMany_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_oneToMany.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_oneToMany_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_association_OptionalOneToMany()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_optionalOneToMany.ump","test/testGenericTestcase_association_optionalOneToMany.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyassociation_OptionalOneToMany_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_optionalOneToMany.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_optionalOneToMany_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_association_OptionalOneToOne()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_optionalOneToOne.ump","test/testGenericTestcase_association_optionalOneToOne.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToOneassociation_OptionalOneToOne_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_optionalOneToOne.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_optionalOneToOne_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_association_OptionalOneToOne_RNav()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_optionalOneToOne_RNav.ump","test/testGenericTestcase_association_optionalOneToOne_RNav.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToOne_RNavassociation_OptionalOneToOne_RNav_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_optionalOneToOne_RNav.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_optionalOneToOne_RNav_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  
	  @Test
	  public void genericTestCaseTest_association_ManyToMany()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_manyToMany.ump","test/testGenericTestcase_association_manyToMany.test.txt");	    
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_manyToMany.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_manyToMany_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_association_ManyToMany_RNav()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_manyToMany_RNav.ump","test/testGenericTestcase_association_manyToMany_RNav.test.txt");	    
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_manyToMany_RNav.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_manyToMany_RNav_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  
	  @Test
	  public void genericTestCaseTest_association_oneToMany_RNav()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_oneToMany_RNav.ump","test/testGenericTestcase_association_oneToMany_RNav.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToMany_RNavassociation_oneToMany_RNav_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_oneToMany_RNav.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_oneToMany_RNav_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_association_optionalOneToMany_RNav()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_association_optionalOneToMany_RNav.ump","test/testGenericTestcase_association_optionalOneToMany_RNav.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToMany_RNavassociation_optionalOneToMany_RNav_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_association_optionalOneToMany_RNav.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_association_optionalOneToMany_RNav_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_attribute_prefix()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_attribute_prefix.ump","test/testGenericTestcase_attribute_prefix.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_attribute_prefix.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_attribute_prefix_ModelTest.umpt")).exists());
	   
	    
	  }
	  
	  @Test
	  public void genericTestCaseTest_attribute_suffix()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_attribute_suffix.ump","test/testGenericTestcase_attribute_suffix.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_attribute_suffix.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_attribute_suffix_ModelTest.umpt")).exists());
	   
	    
	  }
	 
	  @Test
	  public void genericTestCaseTest_attribute_regex()
	  {
	    language = "Test";
	    assertUmpleTemplateFor("test/GenericTestCase_attribute_regex.ump","test/testGenericTestcase_attribute_regex.test.txt");
	    //Assert.assertEquals(true, (new File(pathToInput  + "/test/test/NNToManyAssociation_ModelTest.umpt")).exists());
	    createUmpleSystem(pathToInput, "test/GenericTestCase_attribute_regex.ump");
	    Assert.assertEquals(true, (new File(pathToInput  + "/test/test/GenericTestCase_attribute_regex_ModelTest.umpt")).exists());
	   
	    
	  }
}
