/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation.java;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class JavaClassTemplateTest extends ClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Java";
    languagePath = "java";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/java/example");
  }
  
  @Test
  public void ClassMethods()
  {
    assertUmpleTemplateFor("ClassTemplateTest_Methods.ump",languagePath + "/ClassTemplateTest_Methods."+ languagePath +".txt","CodeTranslator");
  }
  
  @Test
  public void FixmlAttributes1()
  {
    assertUmpleTemplateFor("ClassTemplateTest_FixmlAttributes1.ump",languagePath + "/ClassTemplateTest_FixmlAttributes1."+ languagePath +".txt","Mentor");
  }
  @Test
  public void FixmlAttributes2()
  {
    assertUmpleTemplateFor("ClassTemplateTest_FixmlAttributes2.ump",languagePath + "/ClassTemplateTest_FixmlAttributes2."+ languagePath +".txt","Mentor");
  }
  @Test
  public void FixmlAttributes3()
  {
    assertUmpleTemplateFor("ClassTemplateTest_FixmlAttributes3.ump",languagePath + "/ClassTemplateTest_FixmlAttributes3."+ languagePath +".txt","Mentor");
  }
  @Test @Ignore
  public void FixmlAttributes4()
  {
    assertUmpleTemplateFor("ClassTemplateTest_FixmlAttributes4.ump",languagePath + "/ClassTemplateTest_FixmlAttributes4."+ languagePath +".txt","Mentor");
  }
  
  //Ignored this test because it doesn't seem to be able to take a umple version like @UMPLE_VERSION@ instead it needs it to be an exact version
  @Test @Ignore
  public void ClassMethods_TestingPartialFile()
  {
    assertUmplePartialTemplateFor("ClassTemplateTest_Methods.ump",languagePath + "/ClassTemplateTest_Methods.partial."+ languagePath +".txt","CodeTranslator");
  }
  
  @Test
  public void ClassImplementedMethods()
  {
    assertUmpleTemplateFor("ClassTemplateTest_ImplementedMethods.ump", languagePath + "/ClassTemplateTest_ImplementedMethods."+ languagePath +".txt","CodeTranslator");
    assertUmpleTemplateFor("ClassTemplateTest_VoidImplementedMethod.ump",languagePath + "/ClassTemplateTest_VoidImplementedMethod." +languagePath+".txt","ClientConsole"); 
  }

  @Test
  public void ClassCodeInjections_Basic()
  {
    assertUmpleTemplateFor("ClassTemplateTest_CodeInjectionsBasic.ump", languagePath + "/ClassTemplateTest_CodeInjectionsBasic." + languagePath + ".txt", "Student");
  }

  @Test
  public void ClassCodeInjections_NoBraces()
  {
    assertUmpleTemplateFor("ClassTemplateTest_CodeInjectionsNoBraces.ump", languagePath + "/ClassTemplateTest_CodeInjectionsNoBraces." + languagePath + ".txt", "Student");
  }

  @Test
  public void ClassCodeInjections_Comments()
  {
    assertUmpleTemplateFor("ClassTemplateTest_CodeInjectionsComments.ump", languagePath + "/ClassTemplateTest_CodeInjectionsComments." + languagePath + ".txt", "Student");
  }

  @Test
  public void ClassCodeInjections_SingleLine()
  {
    assertUmpleTemplateFor("ClassTemplateTest_CodeInjectionsSingleLine.ump", languagePath + "/ClassTemplateTest_CodeInjectionsSingleLine." + languagePath + ".txt", "Student");
  }

  public void ClassCodeInjections_ParametersBasic()
  {
    assertUmpleTemplateFor("ClassTemplateTest_CodeInjectionsParametersBasic.ump", languagePath + "/ClassTemplateTest_CodeInjectionsParametersBasic." + languagePath + ".txt", "Student");
  }

  @Test
  public void ClassCodeInjections_ParametersUnspecified()
  {
    assertUmpleTemplateFor("ClassTemplateTest_CodeInjectionsParametersUnspecified.ump", languagePath + "/ClassTemplateTest_CodeInjectionsParametersUnspecified." + languagePath + ".txt", "Student");
  }

  @Test
  public void ClassCodeInjections_ParametersMulti()
  {
    assertUmpleTemplateFor("ClassTemplateTest_CodeInjectionsParametersMulti.ump", languagePath + "/ClassTemplateTest_CodeInjectionsParametersMulti." + languagePath + ".txt", "Student");
  }

  @Test
  public void InternalAndConstantAndDerivedAttributeComments()
  {
        assertUmpleTemplateFor("ClassTemplateTest_AttributeComments.ump",languagePath+"/ClassTemplateTest_AttributeComments." + languagePath + ".txt","Student");
  }

  
  @Test
  public void Java()
  {
    language = null;
    assertUmpleTemplateFor("java/ClassTemplateTest_Java.ump","java/ClassTemplateTest_Java.java.txt","Mentor");
  }
  
  // Tests fix for issue 969 and 986
  @Test
  public void Generated()
  {
	/* Test that "void" is added to a non-constructor method with no specified return type, 
	 * and that the correct threading code is generated when "public static void main(String[] args)" is specified
	 */
    assertUmpleTemplateFor("java/ClassTemplateTest_Generated.ump","java/ClassTemplateTest_Generated.java.txt","Mentor");
    /*
     *  Check that a "main" function (in the Java sense) is only detected (and accompanying threading code generated)
     *  when a function matches the "public static void main(String[] args)" format exactly.
     */
    assertUmpleTemplateFor("java/ClassTemplateTest_Generated2.ump","java/ClassTemplateTest_Generated2.java.txt","Mentor");
    assertUmpleTemplateFor("java/ClassTemplateTest_Generated3.ump","java/ClassTemplateTest_Generated3.java.txt","Mentor");
    
    // Check that void is not added twice if the user explicitly includes it in the .ump file
    assertUmpleTemplateFor("java/ClassTemplateTest_Generated3.ump","java/ClassTemplateTest_Generated3.java.txt","Mentor");

    
  }
  
  @Test
  public void ImportAssociations()
  {
    language = null;
    assertUmpleTemplateFor("java/ClassTemplateTest_Import.ump","java/ClassTemplateTest_Import.java.txt","Mentor");
    assertUmpleTemplateFor("java/ClassTemplateTest_Import.ump","java/ClassTemplateTest_Import2.java.txt","Student");
    assertUmpleTemplateFor("java/ClassTemplateTest_Import.ump","java/ClassTemplateTest_Import3.java.txt","Course");
  }  
  
  @Test 
  public void immutableNotLazyAttributeConstructor(){
	  assertUmpleTemplateFor("java/ImmutableNotLazyAttributeConstructor.ump","java/StudentImmutableNotLazyTest.java.txt","Student");
  }
  
  @Test
  public void StateMachineImplementsInterface(){
      assertUmpleTemplateFor("java/ClassTemplateTest_StateMachineImplementsInterface.ump",
                             "java/ClassTemplateTest_StateMachineImplementsInterface.java.txt",
                             "FileLogger");
  }
  
  @Test
  public void StateMachineImplementsPartialInterface(){
	  assertUmpleTemplateFor("java/ClassTemplateTest_StateMachineImplementsPartialInterface.ump",
              				 "java/ClassTemplateTest_StateMachineImplementsPartialInterface.java.txt",
              				 "FileLogger");
  }
  
  @Test
  public void StateMachineDoesNotImplementInterface(){
	  assertUmpleTemplateFor("java/ClassTemplateTest_StateMachineDoesNotImplementInterface.ump",
				 			 "java/ClassTemplateTest_StateMachineDoesNotImplementInterface.java.txt",
				 			 "FileLogger");
  }
  
  @Test
  public void TestUmpleEnumerations(){
    assertUmpleTemplateFor("java/TestUmpleEnumerations.ump",
        "java/TestUmpleEnumerations.java.txt",
        "Student");
  }
  
  @Test
  public void TestUmpleEnumerations_2(){
    assertUmpleTemplateFor("java/TestUmpleEnumerations_2.ump",
        "java/TestUmpleEnumerations_2.java.txt",
        "X");
  }
  
  @Test
  public void TestUmpleEnumerations_3(){
    assertUmpleTemplateFor("java/TestUmpleEnumerations_3.ump",
        "java/TestUmpleEnumerations_3_c1.java.txt",
        "C1");
    assertUmpleTemplateFor("java/TestUmpleEnumerations_3.ump",
        "java/TestUmpleEnumerations_3_c2.java.txt",
        "C2");
  }
  
  @Test
  public void TestUmpleEnumerations_4(){
    assertUmpleTemplateFor("java/TestUmpleEnumerations_4.ump",
        "java/TestUmpleEnumerations_4_c1.java.txt",
        "C1");
    assertUmpleTemplateFor("java/TestUmpleEnumerations_4.ump",
        "java/TestUmpleEnumerations_4_c2.java.txt",
        "C2");
  }
  
  @Test
  public void TestUmpleEnumerations_5(){
    assertUmpleTemplateFor("java/TestUmpleEnumerations_5.ump",
        "java/TestUmpleEnumerations_5_X1.java.txt",
        "X1");
    assertUmpleTemplateFor("java/TestUmpleEnumerations_5.ump",
        "java/TestUmpleEnumerations_5_X2.java.txt",
        "X2");
  }
  
  @Test
  public void TestUmpleEnumerations_6(){
    assertUmpleTemplateFor("java/TestUmpleEnumerations_6.ump",
        "java/TestUmpleEnumerations_6_X.java.txt",
        "X");
    assertUmpleTemplateFor("java/TestUmpleEnumerations_6.ump",
        "java/TestUmpleEnumerations_6_X2.java.txt",
        "X2");
  }
  
  @Test
  public void TestUmpleEnumerations_7(){
    assertUmpleTemplateFor("java/TestUmpleEnumerations_7.ump",
        "java/TestUmpleEnumerations_7_X.java.txt",
        "X");
    assertUmpleTemplateFor("java/TestUmpleEnumerations_7.ump",
        "java/TestUmpleEnumerations_7_Y.java.txt",
        "Y");
    assertUmpleTemplateFor("java/TestUmpleEnumerations_7.ump",
        "java/TestUmpleEnumerations_7_Z.java.txt",
        "Z");
  }
}
