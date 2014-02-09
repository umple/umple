/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.util.*;

import org.junit.*;

import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.util.*;
import java.io.*;

public class UmpleParserTest
{

  public UmpleParser parser;
  public UmpleModel model;
  public String pathToInput;
  public String umpleParserName;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
  }
  
  @Test
  public void empty()
  {
    assertParse("001_empty.ump");
    Assert.assertEquals(0,model.numberOfUmpleClasses());
  }
  
  @Test
  public void emptyComment()
  {
	  assertParse("001_emptyComment.ump");
	  Assert.assertEquals(1, model.numberOfUmpleClasses());
  }
  
  @Test
  public void multipleEmptyComments()
  {
	  assertParse("001_multipleEmptyComments.ump");
	  Assert.assertEquals(3, model.numberOfUmpleClasses());
  }
  
  @Test
  public void emptyCommentWithSpaces()
  {
	  assertParse("001_emptyCommentWithSpaces.ump");
	  Assert.assertEquals(1, model.numberOfUmpleClasses());
  }
  
  @Test
  public void multipleEmptyCommentsWithSpaces()
  {
	  assertParse("001_multipleEmptyCommentsWithSpaces.ump");
	  Assert.assertEquals(5, model.numberOfUmpleClasses());
  }
  
  @Test
  public void emptyMultiLineComment()
  {
	  assertParse("001_emptyMultiLineComment.ump");
	  Assert.assertEquals(1, model.numberOfUmpleClasses());
  }
  
  @Test
  public void emptyMultiLineCommentWithSpaces()
  {
	  assertParse("001_emptyMultiLineCommentWithSpaces.ump");
	  Assert.assertEquals(1, model.numberOfUmpleClasses());
  }
  
  @Test
  public void multipleEmptyMultiLineCommentsWithSpaces()
  {
	  assertParse("001_multipleEmptyMultiLineCommentsWithSpaces.ump");
	  Assert.assertEquals(6, model.numberOfUmpleClasses());
  }
  
  @Test
  public void methodDetection()
  {
	  assertParse("001_methodInlineComment.ump");
	  Assert.assertEquals(true, model.getUmpleClass(0).numberOfMethods() == 1);
  }
  
  @Test
  public void methodInlineComment()
  {
	  assertParse("001_methodInlineComment.ump");
	  Assert.assertEquals(1, model.getUmpleClass(0).getMethod(0).numberOfComments());
  }
  
  @Test
  public void methodMultilineComment()
  {
	  assertParse("001_methodMultilineComment.ump");
	  Assert.assertEquals(1, model.getUmpleClass(0).getMethod(0).numberOfComments());
  }
  
  @Test
  public void multipleMethodComments()
  {
	  assertParse("001_multipleMethodComments.ump");
	  
	  // Check to see if the methods have the correct number of comments associated with them.
	  Assert.assertEquals(1, model.getUmpleClass(0).getMethod(0).numberOfComments());
	  Assert.assertEquals(2, model.getUmpleClass(0).getMethod(1).numberOfComments());
	  Assert.assertEquals(1, model.getUmpleClass(0).getMethod(2).numberOfComments());
	  Assert.assertEquals(2, model.getUmpleClass(0).getMethod(3).numberOfComments());
  }
  
  @Test
  public void attributeInlineComment()
  {
	  assertParse("001_attributeInlineComment.ump");
	  Assert.assertEquals(1, model.getUmpleClass(0).getAttribute(0).numberOfComments());
  }
  
  @Test
  public void attributeMultilineComment()
  {
	  assertParse("001_attributeMultilineComment.ump");
	  Assert.assertEquals(1, model.getUmpleClass(0).getAttribute(0).numberOfComments());
  }
  
  @Test
  public void multipleAttributeComments()
  {
	  assertParse("001_multipleAttributeComments.ump");
	  
	  // Check to see if the attributes have the correct number of comments associated with them.
	  Assert.assertEquals(1, model.getUmpleClass(0).getAttribute(0).numberOfComments());
	  Assert.assertEquals(2, model.getUmpleClass(0).getAttribute(1).numberOfComments());
	  Assert.assertEquals(1, model.getUmpleClass(0).getAttribute(2).numberOfComments());
	  Assert.assertEquals(2, model.getUmpleClass(0).getAttribute(3).numberOfComments());
  }
  
  @Test
  public void associationInlineComment()
  {
	  assertParse("001_associationInlineComment.ump");
	  Assert.assertEquals(1, model.getUmpleClass(0).getAssociationVariable(0).numberOfComments());
  }
  
  @Test
  public void associationMultilineComment()
  {
	  assertParse("001_associationMultilineComment.ump");
	  Assert.assertEquals(1, model.getUmpleClass(0).getAssociationVariable(0).numberOfComments());
  }
  
  @Test
  public void multipleAssociationComments()
  {
	  assertParse("001_multipleAssociationComments.ump");
	  
	  // Check to see if the attributes have the correct number of comments associated with them.
	  Assert.assertEquals(1, model.getUmpleClass(0).getAssociationVariable(0).numberOfComments());
	  Assert.assertEquals(2, model.getUmpleClass(0).getAssociationVariable(1).numberOfComments());
	  Assert.assertEquals(1, model.getUmpleClass(0).getAssociationVariable(2).numberOfComments());
	  Assert.assertEquals(2, model.getUmpleClass(0).getAssociationVariable(3).numberOfComments());
  }
  
  @Test
  public void oneCharacterMethod()
  {
	  assertParse("001_oneCharacterMethod.ump");
	  
	  /*
	  model.generate();
	  Collection<String> c = model.getGeneratedCode().values();
	  String generatedCode = (String)c.iterator().next();
	  System.out.println("GENERATED CODE: [" + generatedCode + "]");
	  */
	  
	  // Ensure that a class exists, along with a method when the method name is short.
	  Assert.assertEquals(1, model.numberOfUmpleClasses());
	  Assert.assertEquals(1, model.getUmpleClass(0).numberOfMethods());
	  Assert.assertEquals("m", model.getUmpleClass(0).getMethod(0).getName());
  }
  
  @Test
  public void twoCharacterMethod()
  {
	  assertParse("001_twoCharacterMethod.ump");
	  
	  /*
	  model.generate();
	  Collection<String> c = model.getGeneratedCode().values();
	  String generatedCode = (String)c.iterator().next();
	  System.out.println("GENERATED CODE: [" + generatedCode + "]");
	  */
	  
	  // Ensure that a class exists, along with a method when the method name is short.
	  Assert.assertEquals(1, model.numberOfUmpleClasses());
	  Assert.assertEquals(1, model.getUmpleClass(0).numberOfMethods());
	  Assert.assertEquals("m1", model.getUmpleClass(0).getMethod(0).getName());
  }
  
  @Test
  public void internalAttributeGetterMethod()
  {
    assertSimpleParse("008_internalAttributeNotAllowedGetterMethod.ump");
    Assert.assertEquals(1, model.numberOfUmpleClasses());
    Assert.assertEquals(1, model.getUmpleClass(0).numberOfAttributes());
    Assert.assertEquals("internal", model.getUmpleClass(0).getAttribute(0).getModifier());
    Assert.assertEquals(1, model.getUmpleClass(0).numberOfMethods());
    Assert.assertEquals("getTest",model.getUmpleClass(0).getMethod(0).getName());
    Assert.assertEquals("MyOtherObject", model.getUmpleClass(0).getMethod(0).getType());
  }

  @Test
  public void languageDefault()
  {
    assertParse("001_empty.ump");
    Assert.assertEquals("Java", model.getDefaultGenerate());
  }
  
  @Test
  public void abstractClass()
  {
	  assertParse("032_abstractClass.ump");
	  
	  /*
	  model.generate();
	  Collection<String> c = model.getGeneratedCode().values();
	  String generatedCode = (String)c.iterator().next();
	  System.out.println("GENERATED CODE: [" + generatedCode + "]");
	  */
	  
	  Assert.assertEquals(true, model.getUmpleClass("Foo").getIsAbstract());
	  Assert.assertEquals(false, model.getUmpleClass("Bar").getIsAbstract());
  }
  
  @Test
  public void abstractMethod()
  {
    assertSimpleParse("422_abstractMethod.ump");
      
    Assert.assertEquals(1, model.getUmpleClass("Foome").numberOfMethods());
    Assert.assertEquals("barme", model.getUmpleClass("Foome").getMethod(0).getName());
    Assert.assertEquals(true, model.getUmpleClass("Foome").getMethod(0).getIsAbstract());
  }

  @Test
  public void abstractInheritanceClass()
  {
    assertSimpleParse("422_abstractInheritanceClass.ump");

    Assert.assertEquals(true,model.getUmpleClass("A").getIsAbstract());
    Assert.assertEquals(true,model.getUmpleClass("B").getIsAbstract());
    Assert.assertEquals(true,model.getUmpleClass("C").getIsAbstract());
    Assert.assertEquals(false,model.getUmpleClass("D").getIsAbstract());
    Assert.assertEquals(false,model.getUmpleClass("E").getIsAbstract());
  }

  @Test
  public void immutableClass()
  {
    assertParse("022_immutableClass.ump");
    Assert.assertEquals(true,model.getUmpleClass("Student").isImmutable());
    Assert.assertEquals(false,model.getUmpleClass("Mentor").isImmutable());
  }
  
  @Test
  public void validAssociationsForImmutableClass()
  {
    assertParse("022_mutableToImmutableAssocRight.ump");
    UmpleClass studentClass = model.getUmpleClass("StudentA");
    UmpleClass mentorClass = model.getUmpleClass("MentorA");  
    Assert.assertFalse(studentClass.isImmutable());
    Assert.assertTrue(mentorClass.isImmutable());
    Assert.assertFalse(studentClass.getAssociationVariableFor(mentorClass).isImmutable());
    Assert.assertFalse(mentorClass.getAssociationVariableFor(studentClass).isImmutable()); 
    
    assertParse("022_mutableToImmutableAssocLeft.ump");
    studentClass = model.getUmpleClass("StudentB");
    mentorClass = model.getUmpleClass("MentorB");    
    Assert.assertTrue(studentClass.isImmutable());
    Assert.assertFalse(mentorClass.isImmutable());
    Assert.assertFalse(studentClass.getAssociationVariableFor(mentorClass).isImmutable());
    Assert.assertFalse(mentorClass.getAssociationVariableFor(studentClass).isImmutable()); 
    
    assertParse("022_immutableToImmutableAssocRight.ump");
    studentClass = model.getUmpleClass("StudentC");
    mentorClass = model.getUmpleClass("MentorC");    
    Assert.assertTrue(studentClass.isImmutable());
    Assert.assertTrue(mentorClass.isImmutable());
    Assert.assertTrue(studentClass.getAssociationVariableFor(mentorClass).isImmutable());
    Assert.assertTrue(mentorClass.getAssociationVariableFor(studentClass).isImmutable()); 
    
    assertParse("022_immutableToImmutableAssocLeft.ump");
    studentClass = model.getUmpleClass("StudentD");
    mentorClass = model.getUmpleClass("MentorD");    
    Assert.assertTrue(studentClass.isImmutable());
    Assert.assertTrue(mentorClass.isImmutable());
    Assert.assertTrue(studentClass.getAssociationVariableFor(mentorClass).isImmutable());
    Assert.assertTrue(mentorClass.getAssociationVariableFor(studentClass).isImmutable()); 
  }
  
  @Test
  public void validAssociationsForImmutableClass_independentlyDefined()
  {
    assertParse("022_mutableToImmutableAssocRightIndependent.ump");
    UmpleClass studentClass = model.getUmpleClass("StudentA");
    UmpleClass mentorClass = model.getUmpleClass("MentorA");  
    Assert.assertFalse(studentClass.isImmutable());
    Assert.assertTrue(mentorClass.isImmutable());
    Assert.assertFalse(studentClass.getAssociationVariableFor(mentorClass).isImmutable());
    Assert.assertFalse(mentorClass.getAssociationVariableFor(studentClass).isImmutable()); 
    
    assertParse("022_mutableToImmutableAssocLeftIndependent.ump");
    studentClass = model.getUmpleClass("StudentB");
    mentorClass = model.getUmpleClass("MentorB");    
    Assert.assertTrue(studentClass.isImmutable());
    Assert.assertFalse(mentorClass.isImmutable());
    Assert.assertFalse(studentClass.getAssociationVariableFor(mentorClass).isImmutable());
    Assert.assertFalse(mentorClass.getAssociationVariableFor(studentClass).isImmutable());
    
    assertParse("022_immutableToImmutableAssocRightIndependent.ump");
    studentClass = model.getUmpleClass("StudentC");
    mentorClass = model.getUmpleClass("MentorC");    
    Assert.assertTrue(studentClass.isImmutable());
    Assert.assertTrue(mentorClass.isImmutable());
    Assert.assertTrue(studentClass.getAssociationVariableFor(mentorClass).isImmutable());
    Assert.assertTrue(mentorClass.getAssociationVariableFor(studentClass).isImmutable()); 
    
    assertParse("022_immutableToImmutableAssocLeftIndependent.ump");
    studentClass = model.getUmpleClass("StudentD");
    mentorClass = model.getUmpleClass("MentorD");    
    Assert.assertTrue(studentClass.isImmutable());
    Assert.assertTrue(mentorClass.isImmutable());
    Assert.assertTrue(studentClass.getAssociationVariableFor(mentorClass).isImmutable());
    Assert.assertTrue(mentorClass.getAssociationVariableFor(studentClass).isImmutable()); 
  }
  
  @Test
  public void invalidAssociationsForImmutableClass()
  {
    assertFailedParse("022_immutableClassBidirectionalAssoc.ump", new Position("022_immutableClassBidirectionalAssoc.ump",4,1,30), 17);
    assertFailedParse("022_immutableToMutableAssocLeft.ump", new Position("022_immutableToMutableAssocLeft.ump",3,1,18), 13);
    assertFailedParse("022_immutableToMutableAssocRight.ump", new Position("022_immutableToMutableAssocRight.ump",4,1,30), 13);
    
    assertFailedParse("022_immutableClassToAssociationClass.ump", new Position("022_immutableClassToAssociationClass.ump",13,1,106), 13);
  }
  
  @Test
  public void invalidAssociationsForImmutableClass_independentlyDefined()
  {
    assertFailedParse("022_immutableClassBidirectionAssocIndependent.ump", new Position("022_immutableClassBidirectionAssocIndependent.ump",13,1,78), 17);
    assertFailedParse("022_immutableToMutableAssocLeftIndependent.ump", new Position("022_immutableToMutableAssocLeftIndependent.ump",12,1,66), 13);
    assertFailedParse("022_immutableToMutableAssocRightIndependent.ump", new Position("022_immutableToMutableAssocRightIndependent.ump",12,1,66), 13);
  }
  
  @Test
  public void associationsForMutableClassesParseSuccessfully()
  {
    assertParse("022_mutableClassesValidAssociations.ump");
  }
  
  @Test
  public void classCanNotBeChangedToImmutableWithInvalidAssociations()
  {
	  assertFailedParse("022_changeClassToImmutable.ump", new Position("022_changeClassToImmutable.ump",3,1,22), 13);
  }
  
  @Test
  public void superclassCanNotBeChangedToImmutableWithInvalidAssociationsInSubclass()
  {
    assertFailedParse("022_changeSuperclassToImmutable.ump", new Position("022_changeSuperclassToImmutable.ump",8,5,62), 16);
  }
  
  @Test
  public void immutableClassMayNotContainStateMachines()
  {
    assertHasWarningsParse("022_stateMachineInImmutableClass.ump", new Position("022_stateMachineInImmutableClass.ump",13,2,128), 15);
  }
  
  @Test
  public void javaLanguage()
  {
    assertParse("001_javaLanguage.ump");
    Assert.assertEquals("Java", model.getDefaultGenerate());
  }

  @Test
  public void phpLanguage()
  {
    assertParse("001_phpLanguage.ump");
    Assert.assertEquals("Php", model.getDefaultGenerate());
  }

  @Test
  public void rubyLanguage()
  {
    assertParse("001_rubyLanguage.ump");
    Assert.assertEquals("Ruby", model.getDefaultGenerate());
  }

  @Test
  public void cppLanguage()
  {
    assertParse("001_cppLanguage.ump");
    Assert.assertEquals("Cpp", model.getDefaultGenerate());
  }


  @Test
  public void otherLanguage()
  {
    assertFailedParse("001_otherLanguage.ump", new Position("001_otherLanguage.ump", 1,9,9));
  }

  @Test
  public void outputLanguagePath()
  {
	assertParse("001_outputLanguage.ump");
	
    Assert.assertEquals("Ruby", model.getDefaultGenerate());
    Assert.assertEquals("blah/blah/blah", model.getDefaultGeneratePath());
    
    Assert.assertEquals(false, model.getGenerate(0).getOverride());
    Assert.assertEquals(false, model.getGenerate(0).getOverrideAll());

    // This test is correct, since 'generate's may be re-ordered after
    // token analysis
    Assert.assertEquals(false, model.getGenerate(1).getOverride());
    Assert.assertEquals(false, model.getGenerate(1).getOverrideAll());

    Assert.assertEquals(true, model.getGenerate(2).getOverride());
    Assert.assertEquals(false, model.getGenerate(2).getOverrideAll());
  }
  
  @Test
  public void outputLanguagePathOverride()
  {
	assertParse("001_outputLanguageOverride.ump");
		
	 Assert.assertEquals("Java", model.getDefaultGenerate());
	 Assert.assertEquals("3", model.getDefaultGeneratePath());
  }

  @Test
  public void outputLanguagePathOverrideAll()
  {
	assertParse("001_outputLanguageOverrideAll.ump");
		
	Assert.assertEquals("Java", model.getDefaultGenerate());
	Assert.assertEquals("4", model.getDefaultGeneratePath());
  }
  @Test
  public void namespace()
  {
    assertParse("002_namespace.ump");
    Assert.assertEquals("cruise",model.getDefaultNamespace());
    
  }

  @Ignore
  @Test
  public void duplicateNamespace()
  {
	  assertHasWarningsParse("002_DuplicateNamespace.ump", new Position("002_duplicateNamespace.ump",5,10,28));
  }
  
  @Test
  public void invalidNamespace_noName()
  {
    assertFailedParse("002_invalidNamespace_noName.ump", new Position("002_invalidNamespace_noName.ump",1,10,10));
  }

  @Test
  public void emptyClass()
  {
    assertParse("003_emptyClass.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Student",aClass.getName());
    Assert.assertEquals(false,aClass.getKey().isProvided());
  }
  
  @Test
  public void multipleExtraCode()
  {
    assertParse("003_multipleExtraCode.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    AssertHelper.assertEqualsSafe("  blahblah"+ 
        System.getProperty("line.separator") + "  moreblah",aClass.getExtraCode());
  }
  
  @Test @Ignore
  public void constructorExtraCode()
  {
	//This test no longer makes sense, because the method is parsed as an umple method
    assertParse("003_constructorExtraCode.ump");  
    UmpleClass aClass = model.getUmpleClass("Student");
     Assert.assertEquals(" public Student(String x)  {"+ 
         System.getProperty("line.separator") + "blah();"+ 
         System.getProperty("line.separator") + "  }",aClass.getExtraCode());
  }
  
  @Test
  public void innerClass()
  {
    assertParse("003_innerClass.ump");
    UmpleClass person = model.getUmpleClass("Person");
    Assert.assertEquals("Person",person.getName());
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(person,student.getExtendsClass());
    Assert.assertEquals("Student",student.getName());
    
  }  
  
  @Test
  public void unknownClass()
  {
    assertFailedParse("003_unknownClass.ump", new Position("003_unknownClass.ump",5,9,27));
  }
  
  @Test
  public void commentsInClass()
  {
    assertParse("003_commentsInClass.ump");
  }
  
  @Test
  public void depend()
  {
    assertParse("004_depend.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    
    Assert.assertEquals(1,aClass.numberOfDepends());
    Assert.assertEquals("java.util.Map", aClass.getDepend(0).getName());
  }  

  @Test
  public void multipleClasses()
  {
    assertParse("004_multipleClasses.ump");
    Assert.assertEquals(2,model.numberOfUmpleClasses());
  }

  @Test
  public void classAndNamespaces()
  {
    assertParse("004_multipleClassesAndNamespaces.ump");

    UmpleClass studentClass = model.getUmpleClass("Student");
    Assert.assertEquals("cruise.util",studentClass.getPackageName());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals("cruise.core",mentorClass.getPackageName());

  }
  
  @Test
  public void validClassName()
  {
    //Test to ensure that the parser will compile Classes with valid Class names.

    assertSimpleParse("042_validClassNameLowerCase.ump");//all lower case name
    assertSimpleParse("042_validClassNameUpperCase.ump");//all upper case name
    assertSimpleParse("042_validClassNameMixedCase.ump");//mixed case name
    assertSimpleParse("042_validClassNameNumber.ump");//name with numbers
    assertSimpleParse("042_validClassNameUnderscore.ump");//name with underscore
    assertSimpleParse("042_validClassNameUnderNum.ump");//name with underscore and numbers
  }
  
  @Test
  public void invalidClassNameStart()
  {
    //Test to ensure that the parser will not compile Classes with an invalid Class name.
    //Specifically these tests target invalid starting characters.
  
    assertFailedParse("042_invalidClassNameStartNum.ump", 100);//name starts with a number
    assertFailedParse("042_invalidClassNameStartUnder.ump", 100);//name starts with an underscore
    assertFailedParse("042_invalidClassNameStartExclaim.ump", 100);//name starts with an exclamation mark
    assertFailedParse("042_invalidClassNameStartAmper.ump", 100);//name starts with an ampersand
    assertFailedParse("042_invalidClassNameStartDollar.ump", 100);//name starts with a dollar sign
    assertFailedParse("042_invalidClassNameStartHash.ump", 100);//name starts with a hash sign
  }
  
  @Test
  public void invalidClassNamePart()
  {
    //Test to ensure that the parser will not compile Classes with an invalid Class name.
    //Specifically these tests target invalid characters in part of the name.
  
    assertFailedParse("042_invalidClassNamePartQuest.ump", 100);//name contains a question mark
    assertFailedParse("042_invalidClassNamePartExclaim.ump", 100);//name contains an exclamation mark
    assertFailedParse("042_invalidClassNamePartAmper.ump", 100);//name contains an ampersand
    assertFailedParse("042_invalidClassNamePartDollar.ump", 100);//name contains a dollar sign
    assertFailedParse("042_invalidClassNamePartDot.ump", 100);//name contains a period
    assertFailedParse("042_invalidClassNamePartQuote.ump", 100);//name contains quotation marks
  }
  
  
  @Test
  public void validInterfaceName()
  {
    //Test to ensure that the parser will compile Interfaces with valid names.

    assertSimpleParse("043_validInterfaceNameLowerCase.ump");//all lower case name
    assertSimpleParse("043_validInterfaceNameUpperCase.ump");//all upper case name
    assertSimpleParse("043_validInterfaceNameMixedCase.ump");//mixed case name
    assertSimpleParse("043_validInterfaceNameNumber.ump");//name with numbers
    assertSimpleParse("043_validInterfaceNameUnderscore.ump");//name with underscore
    assertSimpleParse("043_validInterfaceNameUnderNum.ump");//name with underscore and numbers
  }
  
  @Test
  public void invalidInterfaceNameStart()
  {
    //Test to ensure that the parser will not compile Interfaces with an invalid name.
    //Specifically these tests target invalid starting characters.
  
    assertFailedParse("043_invalidInterfaceNameStartNum.ump", 110);//name starts with a number
    assertFailedParse("043_invalidInterfaceNameStartUnder.ump", 110);//name starts with an underscore
    assertFailedParse("043_invalidInterfaceNameStartExclaim.ump", 110);//name starts with an exclamation mark
    assertFailedParse("043_invalidInterfaceNameStartAmper.ump", 110);//name starts with an ampersand
    assertFailedParse("043_invalidInterfaceNameStartDollar.ump", 110);//name starts with a dollar sign
    assertFailedParse("043_invalidInterfaceNameStartHash.ump", 110);//name starts with a hash sign
  }
  
  @Test
  public void invalidInterfaceNamePart()
  {
    //Test to ensure that the parser will not compile Interfaces with an invalid name.
    //Specifically these tests target invalid characters in part of the name.
  
    assertFailedParse("043_invalidInterfaceNamePartQuest.ump", 110);//name contains a question mark
    assertFailedParse("043_invalidInterfaceNamePartExclaim.ump", 110);//name contains an exclamation mark
    assertFailedParse("043_invalidInterfaceNamePartAmper.ump", 110);//name contains an ampersand
    assertFailedParse("043_invalidInterfaceNamePartDollar.ump", 110);//name contains a dollar sign
    assertFailedParse("043_invalidInterfaceNamePartDot.ump", 110);//name contains a period
    assertFailedParse("043_invalidInterfaceNamePartQuote.ump", 110);//name contains quotation marks
  }
  
  @Test
  public void warningClassNameCapitalLetter()
  { // Test to make sure a warning is generated when a class name does not start with a capital letter
    assertHasWarningsParse("043_warningClassNameNotCapital.ump", 101); 
  }
  
  @Test
  public void warningInterfaceNameCapitalLetter()
  { // Test to make sure a warning is generated when an interface name does not start with a capital letter
    assertHasWarningsParse("043_warningInterfaceNameNotCapital.ump", 111);
  }

  @Test
  public void duplicateConstantNameInterface()
  { // Test to make sure that a duplicate constant name in an interface throws a warning
    assertFailedParse("044_duplicateConstantNameInInterface.ump", 112);
  }

  @Test
  public void warningConstantDeprecated()
  { // Ensures that a warning is thrown when deprecated keyword constant is used in an interface
    assertHasWarningsParse("044_constantDeprecatedInterface.ump", 901);
  }

  @Test
  public void warningUninitializedConstInterface()
  { // Ensures that a warning is thrown when a constant isn't initialized in an interface
    assertHasWarningsParse("044_uninitializedConstInterface.ump", 35);
  }

  @Test
  public void warningUninitializedConstClass()
  { // Ensures that a warning is thrown when deprecated keyword constant isn't initialized in a class
    assertHasWarningsParse("044_uninitializedConstClass.ump", 35);
  }

  @Test
  public void warningUninitializedConstObjectInterface()
  { // Ensures an error is thrown when a constant that isn't of a default Umple data type isn't initialized in an interface
    assertFailedParse("044_uninitializedConstObjectInterface.ump", 37);
  }

  @Test
  public void warningUninitializedConstObjectClass()
  { // Ensures an error is thrown when a constant that isn't of a default Umple data type isn't initialized in a class
    assertFailedParse("044_uninitializedConstObjectClass.ump", 37);
  }
  
  @Test
  public void referencedPackages()
  {
    assertParse("004_referencedPackages.ump");

    UmpleClass studentClass = model.getUmpleClass("Student");
    String[] referenced = studentClass.getNamespaces();
    Assert.assertEquals(1,referenced.length);
    Assert.assertEquals("anotherExample", referenced[0]);
    
    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    referenced = mentorClass.getNamespaces();
    Assert.assertEquals(1,referenced.length);
    Assert.assertEquals("example", referenced[0]);
  }

  @Test
  public void isA_OnlyOne()
  {
	//ie. isA Y;
    assertParse("007_isA_OnlyOne.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Person",aClass.getExtendsClass().getName());
    Assert.assertEquals(false,aClass.isRoot());
  }
  
  @Test
  public void isA_MultipleTimesInTheSameLine()
  {
	//ie. isA Y, isA Z;
    assertParse("007_isA_MultipleTimesInTheSameLine.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Person",aClass.getExtendsClass().getName());
    Assert.assertEquals("Worker",aClass.getParentInterface(0).getName());
    Assert.assertEquals(false,aClass.isRoot());
  }
  
  @Test
  public void isA_ListForm()
  {
    assertParse("007_isA_ListForm.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Person",aClass.getExtendsClass().getName());
    Assert.assertEquals("Worker",aClass.getParentInterface(0).getName());
    Assert.assertEquals(false,aClass.isRoot());
  }
  
  @Test
  public void implementsInterface()
  {
    assertParse("007_implements.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("IStudent",aClass.getParentInterface(0).getName());
  }
 
  @Test
  public void isA_MultipleInterfaces()
  {
    assertParse("007_isAMultipleInterfaces.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    
    Assert.assertEquals("IStudent",aClass.getParentInterface(0).getName());
    Assert.assertEquals("IPerson",aClass.getParentInterface(1).getName());
    Assert.assertEquals("IMan",aClass.getParentInterface(2).getName());
  }
  
  @Test
  public void isA_MultipleInterfacesAndClasses()
  {
    assertParse("007_isAMultipleInterfacesAndClasses.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    // EXTENDS
    Assert.assertEquals("Human",aClass.getExtendsClass().getName());
    // IMPLEMENTS
    Assert.assertEquals("IStudent",aClass.getParentInterface(0).getName());
    Assert.assertEquals("IPerson",aClass.getParentInterface(1).getName());
    Assert.assertEquals("IMan",aClass.getParentInterface(2).getName());
    // Root?
    Assert.assertEquals(false,aClass.isRoot());
  }
  
  @Test
  public void isA_MultipleInterfacesAndClassesV2()
  {
    assertParse("007_isAMultipleInterfacesAndClassesV2.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    // EXTENDS
    Assert.assertEquals("Human",aClass.getExtendsClass().getName());
    // IMPLEMENTS
    Assert.assertEquals("IStudent",aClass.getParentInterface(0).getName());
    Assert.assertEquals("IPerson",aClass.getParentInterface(1).getName());
    Assert.assertEquals("IMan",aClass.getParentInterface(2).getName());
    // Root?
    Assert.assertEquals(false,aClass.isRoot());
  }

	@Test
  public void multiple_Class_Inheritance()
  {
		assertFailedParse("007_isA_MultipleInher.ump", 34);
  }

	@Test
  public void singleIsA_MultipleClass_Inheritance()
  {
		assertFailedParse("007_single_isA.ump", 34);
  }
  
	@Test
  public void multipleIsA_MultipleClass_Inheritance()
  {
		assertFailedParse("007_isA_MultipleInheritance_MultipleIsA.ump", 34);
  }

  @Test
  public void isA_SimpleCycle()
  {
    assertFailedParse("007_isA_SimpleCycle.ump", new Position("007_isA_SimpleCycle.ump",3,6,22)); 
  }
  
  @Test
  public void isA_ComplexCycle()
  {
    assertFailedParse("007_isA_ComplexCycle.ump", new Position("007_isA_ComplexCycle.ump",3,6,22)); 
  }
  
  @Test
  public void is_A_SimpleCycle_Interface()
  {
	  assertFailedParse ("007_isA_SimpleCycle_Interface.ump", 11);
  }
  
  @Test
  public void is_A_ComplexCycle_Interface()
  {
	  assertFailedParse ("007_isA_ComplexCycle_Interface.ump", 12);
  }
   
  
  @Test
  public void isA_Grouped()
  {
    assertParse("007_isAGrouped.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Person",aClass.getExtendsClass().getName());
    Assert.assertEquals(false,aClass.isRoot());
  }

  @Test
  public void singleton()
  {
    assertParse("007_singleton.ump");
    UmpleClass aClass = model.getUmpleClass("Airline");
    Assert.assertEquals(true,aClass.getIsSingleton());
  }
  
  @Test 
  public void is_A_NonExistingExtendsClass(){
	assertHasWarningsParse("007_isANonExistingSuperClass.ump", 33);
  }

  @Test
  public void singletonAttributeNotLazy()
  {
	assertHasWarningsParse("007_singletonAttributeNotLazy.ump", new Position("007_singletonAttributeNotLazy.ump",3,1,29));
  }
  
  @Test
  public void singletonWithConst()
  {
	assertNoWarningsParse("007_singletonWithConst.ump");
  }
  
  @Test
  public void isAttributeLazyRedundant()
  {
	assertHasWarningsParse("007_isAttributeLazyRedundant.ump", 3);
  }
  
  @Test
  public void isABlahAttribute()
  {
    assertParse("008_isABlahAttribute.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable = aClass.getAttribute("isActNow");
    Assert.assertEquals("isActNow", variable.getName());
    Assert.assertEquals(false, variable.getIsList());
  }  
  
  @Test
  public void attribute_simple()
  {
    assertParse("008_simpleAttribute.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable = aClass.getAttribute("number");
    Assert.assertEquals("number", variable.getName());
    Assert.assertEquals(false, variable.getIsList());
  }

  @Test
  public void attribute_list()
  {
    assertParse("008_listAttribute.ump");
    UmpleClass aClass = model.getUmpleClass("Token");
    Attribute variable = aClass.getAttribute("name");
    Assert.assertEquals("name", variable.getName());
    Assert.assertEquals("String", variable.getType());
    Assert.assertEquals(true, variable.getIsList());

    Attribute blah = aClass.getAttribute("blah");
    Assert.assertEquals("blah", blah.getName());
    Assert.assertEquals("String", blah.getType());
    Assert.assertEquals(true, blah.getIsList());
  }

  @Test
  public void attribute_derived()
  {
    assertParse("008_derivedAttribute.ump");

    UmpleClass aClass = model.getUmpleClass("Position");
    Attribute variable = aClass.getAttribute("perimeter");
    Assert.assertEquals("perimeter", variable.getName());
    Assert.assertEquals("Integer", variable.getType());
    Assert.assertEquals(false, variable.getIsList());
    Assert.assertEquals("2*l + 2*w",variable.getValue());
    Assert.assertEquals(true, variable.getIsDerived());

    variable = aClass.getAttribute("l");
    Assert.assertEquals("l", variable.getName());
    Assert.assertEquals("Integer", variable.getType());
    Assert.assertEquals(false, variable.getIsList());
    Assert.assertEquals(false, variable.getIsDerived());

  }
  
  @Test
  public void attribute_defaultedWithoutAValue()
  {
    assertFailedParse("008_defaultWithoutValue.ump", new Position("008_defaultWithoutValue.ump",4,2,19));
  }
  
  @Test
  public void association_attribute()
  {
    assertParse("008_associationAttribute.ump");
    UmpleClass aClass = model.getUmpleClass("Token");
    Attribute variable = aClass.getAttribute("startPosition");
    Assert.assertEquals("startPosition", variable.getName());
    Assert.assertEquals("Position", variable.getType());
  }  
  
  @Test @Ignore
  public void complexClassWithAssociationsCannotBeAttribute()
  {
    assertFailedParse("008_complexAttribute.ump", new Position(5,2,10));
  }

  @Test
  public void attribute_Type()
  {
    assertParse("008_typeAttribute.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable;
    
    variable = aClass.getAttribute("name");
    Assert.assertEquals("name", variable.getName());
    Assert.assertEquals("Integer", variable.getType());
    
    variable = aClass.getAttribute("name2");
    Assert.assertEquals("name2", variable.getName());
    Assert.assertEquals("String", variable.getType());
    
    variable = aClass.getAttribute("name3");
    Assert.assertEquals("name3", variable.getName());
    Assert.assertEquals("Time", variable.getType());

    variable = aClass.getAttribute("name4");
    Assert.assertEquals("name4", variable.getName());
    Assert.assertEquals("Date", variable.getType());

    variable = aClass.getAttribute("name5");
    Assert.assertEquals("name5", variable.getName());
    Assert.assertEquals("Double", variable.getType());
  }
  
  @Test
  public void attribute_ContainerType()
  {
    assertHasWarningsParse("276_AttributeTypeAngleBrackets.ump", 46); 
  }

  @Test
  public void attribute_Unique()
  {
    assertParse("008_uniqueAttribute.ump");
    Attribute number = model.getUmpleClass("Student").getAttribute("number");
    Assert.assertTrue(number.getIsUnique());
  }

  @Test
  public void attribute_assignedValue()
  {
    assertParse("008_assignedValueAttribute.ump");
    UmpleClass aClass = model.getUmpleClass("Student");
    UmpleVariable variable;

    variable = aClass.getAttribute("s");
    Assert.assertEquals("\"s\"", variable.getValue());

    variable = aClass.getAttribute("s2");
    Assert.assertEquals("\"s2\"", variable.getValue());
  }

  @Test
  public void attribute_autounique()
  {
    assertParse("008_autouniqueAttribute.ump");

    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable = aClass.getAttribute("id");
    Assert.assertEquals(true,variable.getIsAutounique());
    Assert.assertEquals("Integer",variable.getType());
  }
  
  @Test
  public void attributeComplexAssigned()
  {
    assertParse("008_complexAssignedAttribute.ump");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable = aClass.getAttribute("t");
    Assert.assertEquals("new Time(\"now\")",variable.getValue());
  }
  
  @Test
  public void attributeInvalidName()
  {
	  assertFailedParse("008_invalidAttributeName.ump", 130);
	  assertFailedParse("008_attributeNumericalFirstCharacter.ump", 130);
	  assertSimpleParse("008_attributeUnderscoreFirstChar.ump");
  }
  @Test
  public void attributeProperNamingStyle()
  {
	  assertHasWarningsParse("008_attributeUpperFirstChar.ump", 131);
          assertSimpleParse("008_constAttributeUpperFirstChar.ump");
  }
  
  @Test
  public void TypeValueMismatchWarning()
  {
    assertHasWarningsParse("008_attributeTypeValueMismatch.ump",141);
  }

  @Test
  public void attributeLooksLikeAssociation()
  {
	  assertFailedParse("008_attributeContainsDoubleDash.ump", 132);
	  assertFailedParse("008_attributeContainsDoublePeriod.ump", 132);
	  //assertFailedParse("008_attributeContainsStar.ump", 132);
	  assertFailedParse("008_attributeContainsArrow.ump", 132);
  }
  
  @Test
  public void attributeInvalidTypeName()
  {
	  assertFailedParse("008_attributeInvalidType.ump", 140);
	  assertFailedParse("008_attributeAllNumericType.ump", 140);
  }
  
  @Test
  // test to make sure none of the attributes in a class share their name with attributes
  // in a superclass.
  public void attributeSharedName()
  {
	  assertHasWarningsParse("429_sharedAttributeName.ump", 44);
  	  assertHasWarningsParse("429_sharedAttributeName_ML.ump", 44);
  }
  
  @Test
  public void associationName()
  {
    assertParse("009_externalNamedAssociation.ump");
    
    Association as = model.getAssociation(0);
    Assert.assertEquals("Counsellor",as.getName());
  }
  
  @Test
  public void singletonToOneAssociation()
  {
	  assertHasWarningsParse("009_singletonToOneAssociation.ump", new Position("009_singletonToOneAssociation.ump",3,1,29));
  }

  @Test
  public void associationWithUnknownClass()
  {
    assertFailedParse("009_associationWithUnknownClass.ump", new Position("009_associationWithUnknownClass.ump",7,15,53));
  }
  
  @Test
  public void associationWithClassAndInterface(){
	  assertSimpleParse("009_associationWithInterfaceUnidirectional.ump");
	  assertFailedParse("009_associationWithInterfaceBidirectional.ump", 20);
	  assertFailedParse("009_associationNonExistentInterface.ump",5);
  }
  
  @Test
  public void externalAssociationWithUnknownClass()
  {
    assertFailedParse("009_externalAssociationWithUnknownClass.ump", new Position("009_externalAssociationWithUnknownClass.ump",6,7,42));
  }
   
  @Test
  public void externalAssociationWithUnknownClassSecondPosition()
  {
     assertFailedParse("009_externalAssociationWithUnknownClassSecond.ump", new Position("009_externalAssociationWithUnknownClassSecond.ump",6,23,58));
  }   
  
  @Test
  public void association()
  {
    assertParse("009_association.ump");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("aMentor");
    Assert.assertEquals(0,variable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,variable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Mentor",variable.getType());
    Assert.assertEquals("aMentor",variable.getName());
    Assert.assertEquals(true,variable.getIsNavigable());
    
    AssociationVariable relatedVariable = variable.getRelatedAssociation();
    Assert.assertEquals(2,relatedVariable.getMultiplicity().getLowerBound());
    Assert.assertEquals(3,relatedVariable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Student",relatedVariable.getType());
    Assert.assertEquals("students",relatedVariable.getName());
    Assert.assertEquals(true,relatedVariable.getIsNavigable());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals(relatedVariable, mentorClass.getAssociationVariable("students"));
    Assert.assertEquals(variable, mentorClass.getAssociationVariable("students").getRelatedAssociation());

    
    List<Association> iter = model.getAssociations();
    Assert.assertEquals(2,iter.size());
    Association one = iter.get(0);
    Association two = iter.get(1);
    
    Assert.assertEquals(2,one.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(3,one.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("students",one.getEnd(0).getRoleName());
    Assert.assertEquals("Student",one.getEnd(0).getClassName());
    Assert.assertEquals("Mentor",one.getEnd(0).getReferenceToClassName());

    Assert.assertEquals(0,one.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(1,one.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("aMentor",one.getEnd(1).getRoleName());
    Assert.assertEquals("Mentor",one.getEnd(1).getClassName());
    Assert.assertEquals("Student",one.getEnd(1).getReferenceToClassName());
    
    Assert.assertEquals(0,two.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,two.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("me",two.getEnd(0).getRoleName());
    Assert.assertEquals("Student",two.getEnd(0).getClassName());
    Assert.assertEquals("Student",two.getEnd(0).getReferenceToClassName());

    Assert.assertEquals(0,two.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,two.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("them",two.getEnd(1).getRoleName());
    Assert.assertEquals("Student",two.getEnd(1).getClassName());
    Assert.assertEquals("Student",two.getEnd(1).getReferenceToClassName());
  }
  
  @Test
  public void association_invalidMultiplicityOutOfOrder()
  {
    assertFailedParse("009_association_multiplicityOutOfOrder.ump", new Position("009_association_multiplicityOutOfOrder.ump",4,2,19));
  }  
  
  @Test
  public void invalidMultiplicity()
  {
    assertFailedParse("009_zeroMultiplicity.ump", 4);
  }  


  @Test
  public void association_external()
  {
    assertParse("009_externalAssociation.ump");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("myMentor");
    Assert.assertEquals(6,variable.getMultiplicity().getLowerBound());
    Assert.assertEquals(9,variable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Mentor",variable.getType());
    Assert.assertEquals("myMentor",variable.getName());
    Assert.assertEquals(true,variable.getIsNavigable());
    
    AssociationVariable relatedVariable = variable.getRelatedAssociation();
    Assert.assertEquals(4,relatedVariable.getMultiplicity().getLowerBound());
    Assert.assertEquals(5,relatedVariable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Student",relatedVariable.getType());
    Assert.assertEquals("students",relatedVariable.getName());
    Assert.assertEquals(true,relatedVariable.getIsNavigable());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals(relatedVariable, mentorClass.getAssociationVariable("students"));
    Assert.assertEquals(variable, mentorClass.getAssociationVariable("students").getRelatedAssociation());

    List<Association> iter = model.getAssociations();
    Assert.assertEquals(2,iter.size());
    Association one = iter.get(0);
    Association two = iter.get(1);
    
    Assert.assertEquals(4,one.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(5,one.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("students",one.getEnd(0).getRoleName());
    Assert.assertEquals("Student",one.getEnd(0).getClassName());
    Assert.assertEquals("Mentor",one.getEnd(0).getReferenceToClassName());

    Assert.assertEquals(6,one.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(9,one.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("myMentor",one.getEnd(1).getRoleName());
    Assert.assertEquals("Mentor",one.getEnd(1).getClassName());
    Assert.assertEquals("Student",one.getEnd(1).getReferenceToClassName());
    
    Assert.assertEquals(0,two.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,two.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("me",two.getEnd(0).getRoleName());
    Assert.assertEquals("Student",two.getEnd(0).getClassName());
    Assert.assertEquals("Student",two.getEnd(0).getReferenceToClassName());

    Assert.assertEquals(0,two.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,two.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("them",two.getEnd(1).getRoleName());
    Assert.assertEquals("Student",two.getEnd(1).getClassName());
    Assert.assertEquals("Student",two.getEnd(1).getReferenceToClassName());
  }

  @Test
  public void oneWayAssociation()
  {
    assertParse("009_oneWayAssociation.ump");

    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("mentor");
    Assert.assertEquals(0,variable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,variable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Mentor",variable.getType());
    Assert.assertEquals("mentor",variable.getName());
    Assert.assertEquals(true,variable.getIsNavigable());
    
    AssociationVariable relatedVariable = variable.getRelatedAssociation();
    Assert.assertEquals(0,relatedVariable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,relatedVariable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Student",relatedVariable.getType());
    Assert.assertEquals("student",relatedVariable.getName());
    Assert.assertEquals(false,relatedVariable.getIsNavigable());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals(relatedVariable, mentorClass.getAssociationVariable("student"));
    Assert.assertEquals(variable, mentorClass.getAssociationVariable("student").getRelatedAssociation());

  }
  
  @Test
  public void otherWayAssociation()
  {
    assertParse("009_otherWayAssociation.ump");

    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("mentor");
    Assert.assertEquals(0,variable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,variable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Mentor",variable.getType());
    Assert.assertEquals("mentor",variable.getName());
    Assert.assertEquals(false,variable.getIsNavigable());
    
    AssociationVariable relatedVariable = variable.getRelatedAssociation();
    Assert.assertEquals(0,relatedVariable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,relatedVariable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Student",relatedVariable.getType());
    Assert.assertEquals("student",relatedVariable.getName());
    Assert.assertEquals(true,relatedVariable.getIsNavigable());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals(relatedVariable, mentorClass.getAssociationVariable("student"));
    Assert.assertEquals(variable, mentorClass.getAssociationVariable("student").getRelatedAssociation());

  }  
  
  @Test
  public void association_nonZeroReflexiveAssociation()
  {
    assertFailedParse("009_nonZeroReflexiveAssociation.ump", new Position("009_nonZeroReflexiveAssociation.ump",5,10,28));
  }  

  

  @Test
  public void symmetricReflexiveAssociation()
  {
    assertParse("009_reflexiveSymmetricAssociation.ump");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("partner");
    
    Assert.assertEquals(true,variable.isSymmetricReflexive());
  }

  @Test
  public void associationByItself()
  {
    assertParse("009_associationByItself.ump");

    List<Association> iter = model.getAssociations();
    Assert.assertEquals(2,iter.size());
    Association one = iter.get(0);
    Association two = iter.get(1);
    
    Assert.assertEquals(0, one.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(1, one.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("aStudent", one.getEnd(0).getRoleName());
    Assert.assertEquals("Student", one.getEnd(0).getClassName());
    Assert.assertEquals(0, one.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(1, one.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("aMentor", one.getEnd(1).getRoleName());
    Assert.assertEquals("Mentor", one.getEnd(1).getClassName());
    Assert.assertEquals(true, one.getIsLeftNavigable());
    Assert.assertEquals(true, one.getIsRightNavigable());
    
    Assert.assertEquals(0, two.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1, two.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("events", two.getEnd(0).getRoleName());
    Assert.assertEquals("Event", two.getEnd(0).getClassName());
    Assert.assertEquals(0, two.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1, two.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("locations", two.getEnd(1).getRoleName());
    Assert.assertEquals("Location", two.getEnd(1).getClassName());
    Assert.assertEquals(true, two.getIsLeftNavigable());
    Assert.assertEquals(true, two.getIsRightNavigable());
  
  }

  @Test
  public void reflexiveCasesNoError21()
  {
    assertSimpleParse("009_ReflexiveDirectedManyRightRole.ump");
    assertSimpleParse("009_ReflexiveDirectedZeroOneRightRole.ump");
    assertSimpleParse("009_ReflexiveDirectedZeroOneSeparateAssocRightRole.ump");
    assertSimpleParse("009_ReflexiveNonDirectedManyRightRole.ump");
    assertSimpleParse("009_ReflexiveNonDirectedManySymmetricRightRole.ump");
    assertSimpleParse("009_ReflexiveNonDirectedZeroOneRightRole.ump");
    assertSimpleParse("009_ReflexiveNonDirectedZeroOneSeparateAssocRightRole.ump");
    assertSimpleParse("009_ReflexiveNonDirectedZeroOneSymmetricRightRole.ump");
  }

  @Test 
  public void reflexiveAndError21CasesDirected()
  {
    assertFailedParse("009_ReflexiveDirectedManyError21.ump",21);
    assertFailedParse("009_ReflexiveDirectedZeroOneError21.ump",21);
    assertFailedParse("009_ReflexiveDirectedZeroOneReverseError21.ump",21);
    assertFailedParse("009_ReflexiveDirectedZeroOneSeparateAssocError21.ump",21);
  }

  @Test
  public void reflexiveAndError21CasesNonDirected()
  {
    assertFailedParse("009_ReflexiveNonDirectedManyError21.ump",21);
    assertFailedParse("009_ReflexiveNonDirectedManySeparateAssocError21.ump",21);
    assertFailedParse("009_ReflexiveNonDirectedZeroOneError21.ump",21);
    assertFailedParse("009_ReflexiveNonDirectedZeroOneSeparateAssocError21.ump",21);
  }
  
  @Test 
  public void TestReservedRoleNameError32() {
	  assertFailedParse("009_ReflexiveReservedRoleNameError32.ump",32);  
  }
    
  @Test
  public void associationClass2()
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, "010_associationClass2.ump"));
    parser = UmpleParserFactory.create(umpleParserName,true);
    boolean answer = parser.parse("associationClassDefinition", input).getWasSuccess();
    Assert.assertEquals(true,answer);
  }
  
  @Test
  public void associationClassMultipleDefinitions()
  {
	assertParse("010_associationClassMultipleDefinitions.ump");
	UmpleClass associationClass = model.getUmpleClass("Relationship");
    Coordinate position = new Coordinate(1,2,3,4);
      
	Assert.assertEquals(position.getX(), associationClass.getCoordinates().getX());
    Assert.assertEquals(position.getY(), associationClass.getCoordinates().getY());
    Assert.assertEquals(position.getWidth(), associationClass.getCoordinates().getWidth());
    Assert.assertEquals(position.getHeight(), associationClass.getCoordinates().getHeight());
  }
  
  @Test
  public void associationClassAdditionalAssociations()
  {
    assertParse("010_associationClassOtherAssociations.ump");
    
    UmpleClass votes = model.getUmpleClass("VotesInPoll");
    Assert.assertEquals(3,votes.numberOfAssociationVariables());
      
  }
  
  @Test
  public void associationClassMissingLeft()
  {
    assertFailedParse("010_associationClassMissingLeft.ump", new Position("010_associationClassMissingLeft.ump",1,0,0));
  }  
  
  @Test
  public void associationClassMissingRight()
  {
    assertFailedParse("010_associationClassMissingRight.ump", new Position("010_associationClassMissingRight.ump",1,0,0));
  }
  
  @Test
  public void associationClass()
  {
    assertParse("010_associationClass.ump");

    UmpleClass aClass = model.getUmpleClass("Ticket");
    
    Assert.assertEquals("example",aClass.getPackageName());
    Assert.assertEquals("Thing", aClass.getExtendsClass().getName());
    Assert.assertTrue(aClass.getExtraCode().contains("public int one() {return 1;}"));
    //Replaced in favor of above line due to // line comments being added:
    //Assert.assertEquals("public int one() {return 1;}",aClass.getExtraCode()); 
    Assert.assertEquals("name",aClass.getAttribute("name").getName());
    Assert.assertEquals("type",aClass.getAttribute("type").getName());
    
    AssociationVariable av1 = aClass.getAssociationVariable("event");
    Assert.assertEquals(1,av1.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,av1.getMultiplicity().getUpperBound());
    Assert.assertEquals("event",av1.getName());
    Assert.assertEquals("Event", av1.getType());
    
    AssociationVariable relatedAv1 = av1.getRelatedAssociation();
    Assert.assertEquals(0,relatedAv1.getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,relatedAv1.getMultiplicity().getUpperBound());
    Assert.assertEquals("tickets",relatedAv1.getName());
    Assert.assertEquals("Ticket", relatedAv1.getType());
    
    AssociationVariable av2 = aClass.getAssociationVariable("location");
    Assert.assertEquals(1,av2.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,av2.getMultiplicity().getUpperBound());
    Assert.assertEquals("location",av2.getName());
    Assert.assertEquals("Location", av2.getType());
    
    AssociationVariable relatedAv2 = av2.getRelatedAssociation();
    Assert.assertEquals(0,relatedAv2.getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,relatedAv2.getMultiplicity().getUpperBound());
    Assert.assertEquals("tickets",relatedAv2.getName());
    Assert.assertEquals("Ticket", relatedAv2.getType());
    
    List<Association> iter = model.getAssociations();
    Assert.assertEquals(2,iter.size());
  }

  @Test
  public void associationClassNewSyntax()
  {
    assertParse("010_associationClassNewSyntaxAssociation.ump");
  }

  @Test
  public void associationClassSeveralAssociationsAttributes()
  {
    assertParse("010_associationClassSeveralAssociationsAttributes.ump");
    Assert.assertEquals(6,model.getAssociations().size());
    UmpleClass aClass = model.getUmpleClass("G");
    Assert.assertEquals(6,aClass.numberOfAssociationVariables());
    Assert.assertEquals(5,aClass.numberOfAttributes());
  }

  @Test
  public void inlineComments()
  {
    assertParse("013_inlineComments.ump");
  }

  @Test
  public void multilineComments()
  {
    assertParse("013_multilineComments.ump");
  }
   
  @Test
  public void attributesAndAssocations()
  {
    assertParse("012_attributesAndAssociations.ump");
  }

  /* Test to verify the isA relationship between classes and Interfaces*/
  @Test
  public void interfaceImplementation()
  {
	assertParse("014_interface_implementation.ump");
	   
    UmpleClass aClass = model.getUmpleClass("Something");
    Assert.assertEquals("ISomething",aClass.getParentInterface(0).getName());

  }
  
  /* Test to verify the the methods inside an Interface*/
  @Test
  public void interfaceWithMethodAndParameters()
  {
	assertParse("014_interface_methodAndParam.ump");
  }
  
  @Test
  public void interfaceWithPosition()
  {
	assertParse("014_interface_position.ump");
  }
  
  /* Test to verify the the methods WITH NO parameters inside an Interface*/
  @Test
  public void interfaceWithMethodAndNOTParameters()
  {
	assertParse("014_interface_methodNoParam.ump");
  }
  
  
  /* Test to verify the the constants inside an Interface*/
  @Test
  public void interfaceWithConstants()
  {
	assertParse("014_interface_constant.ump");
  }
  
  /* Test to verify all Members (Constants and Methods)  inside an Interface*/
  @Test
  public void interfaceWithMultipleMembers()
  {
    assertParse("014_interface_allMembers.ump");
  }
  
  @Test
  public void interfaceClassDepend()
  {
    assertParse("014_interfaceDepend.ump");
    
    UmpleInterface aInterface = model.getUmpleInterface("IMe");
    Assert.assertEquals(1,aInterface.numberOfDepends());
    Assert.assertEquals("java.util.*", aInterface.getDepend(0).getName());
  }  
  
  /* Test to verify extra code inside interfaces*/
  @Test
  public void interfaceWithExtraCode()
  {
    assertParse("014_interface_extracode.ump");
  }
  
  @Test
  public void interfaceWithSingleIsA()
  {
    assertParse("014_interfaceImplements.ump");
    UmpleInterface child = model.getUmpleInterface("ISomething");
	Assert.assertEquals("ISuper", child.getExtendsInterface(0).getName());
  }
  
  @Test
  public void interfaceWithMultipleIsA()
  {
    assertParse("014_interfaceMultipleImplements.ump");
    UmpleInterface child = model.getUmpleInterface("IOther");
	Assert.assertEquals("ISuper", child.getExtendsInterface(0).getName());
	Assert.assertEquals("IOtherSuper", child.getExtendsInterface(1).getName());
  }
  
  @Test
  public void classWithImplementedMethods()
  {
    assertParse("015_ClassWithImplementedMethods.ump");
  }
  
  //TODO: Not being parsed by meta model
  @Test @Ignore
  public void classWithMethods()
  {
    assertParse("015_classMethods.ump");
    
    UmpleClass s = model.getUmpleClass("Student");
    Assert.assertEquals(1,s.numberOfMethods());
    Method m = s.getMethod(0);
    Assert.assertEquals("getCode", m.getName());
    Assert.assertEquals("",s.getExtraCode());
  }
  
  @Test
  public void mixDifferentFiles()
  {
    assertParse("015_base.ump");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Student",aClass.getName());

    aClass = model.getUmpleClass("Mentor");
    Assert.assertEquals("Mentor",aClass.getName());
  }
  
  @Test
  public void classPosition()
  {
    assertParse("016_classPosition.ump");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Student",aClass.getName());
    Assert.assertEquals(new Coordinate(10,20,30,40),aClass.getCoordinates());
  }
  
  @Test
  public void classPosition_default()
  {
    assertParse("016_defaultClassPosition.ump");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Student",aClass.getName());
    Assert.assertEquals(new Coordinate(10,20,30,40),aClass.getCoordinates());
  }  
  
  @Test
  public void positionAssociation()
  {
    assertParse("016_associationPosition.ump");
    
    Association assoc = model.getAssociations().get(0);
    Assert.assertEquals("Mentor__Student",assoc.getName());
    Assert.assertEquals(2, assoc.numberOfPositions());
    Assert.assertEquals(new Coordinate(1,2,0,0), assoc.getPosition(0));
    Assert.assertEquals(new Coordinate(3,4,0,0), assoc.getPosition(1));
  }  

  @Test @Ignore
  public void positionAssociationClass_Mixin()
  {
    assertParse("016_associationClassMixinPosition.ump");
    
    Assert.assertEquals(3, model.numberOfUmpleClasses());
    
    UmpleClass aClass = model.getUmpleClass("Relationship");
    Assert.assertEquals("Relationship",aClass.getName());
    Assert.assertEquals(new Coordinate(10,20,30,40),aClass.getCoordinates());
    
    // make sure that "isWellDefined" is true
  } 

  @Test @Ignore
  public void positionAssociationClass_NoAssociation()
  {
    assertParse("016_associationClassRelationshipNotDefined.ump");
    
    // fill me in with checks
    // make sure that "isWellDefined" is false
  } 
  
  @Test
  public void positionUnknownAssociation()
  {
    assertParse("016_unknownAssociationPosition.ump");
    Assert.assertEquals(0, model.getAssociations().size());
  }  
  
  @Test
  public void associationClassPosition()
  {
    assertParse("016_associationClassPosition.ump");
    
    UmpleClass aClass = model.getUmpleClass("Relationship");
    Assert.assertEquals("Relationship",aClass.getName());
    Assert.assertEquals(new Coordinate(10,20,30,40),aClass.getCoordinates());
  }  
  
  @Test
  public void glossary()
  {
    assertParse("017_glossary.ump");
    Glossary g = model.getGlossary();
    Assert.assertEquals("entities",g.getPlural("entity"));
    Assert.assertEquals("entity",g.getSingular("entities"));
  }

  @Test
  public void cannotHaveDuplicateKeys()
  {
    assertHasWarningsParse("018_cannotHaveDuplicateKeys.ump",new Position("018_cannotHaveDuplicateKeys.ump",8,2,55));
  }

  @Test
  public void cannotHaveKeyAndDefaultKey()
  {
    assertHasWarningsParse("018_cannotHaveKeyAndDefaultKey.ump",new Position("018_cannotHaveKeyAndDefaultKey.ump",8,2,55));
  }
  
  @Test
  public void keyCannotHaveDuplicateAttributes()
  {
    assertFailedParse("018_keyCannotHaveDuplicateAttributes.ump", 26);
  }  
  
  @Test 
  public void attributeInKeyNotDefinedInClass()
  {
    assertHasWarningsParse("018_attributeInKeyNotDefinedInClass.ump", 27);
  }  
  
  @Test
  public void key()
  {
    assertParse("018_key.ump");
    
    UmpleClass student = model.getUmpleClass("Student");
    Key key = student.getKey();
    Assert.assertEquals(true, key.isProvided());
    Assert.assertEquals(2,key.numberOfMembers());
    Assert.assertEquals("id",key.getMember(0));
    Assert.assertEquals("name",key.getMember(1));
    
    UmpleClass mentor = model.getUmpleClass("Mentor");
    key = mentor.getKey();
    Assert.assertEquals(true, key.isProvided());
    Assert.assertEquals(1,key.numberOfMembers());
    Assert.assertEquals("employeeId",key.getMember(0));
    
    UmpleClass course = model.getUmpleClass("Course");
    key = course.getKey();
    Assert.assertEquals(true, key.isProvided());
    Assert.assertEquals(0,key.numberOfMembers());
    Assert.assertEquals(true,key.getIsDefault());
  }
  
  @Test
  public void keyWithInitializedAttribute()
  {
    assertHasWarningsParse("306_keyWithInitializedAttribute.ump", 45);
  }
	  
  @Test
  public void beforeKeyword()
  {
    assertParse("019_before.ump");

    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfCodeInjections());
    
    CodeInjection inject = student.getCodeInjection(0);
    Assert.assertEquals("before",inject.getType());
    Assert.assertEquals("setName",inject.getOperation());
    Assert.assertEquals("doSomething();",inject.getCode());
  }

  @Test
  public void afterKeyword()
  {
    assertParse("019_after.ump");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfCodeInjections());
    
    CodeInjection inject = student.getCodeInjection(0);
    Assert.assertEquals("after",inject.getType());
    Assert.assertEquals("getName",inject.getOperation());
    Assert.assertEquals("notReallyPossible();",inject.getCode());
  }

  @Test
  public void upperCaseAssociationKey()
  {
	assertSimpleParse("284_keyAssociationUpper.ump");
	
	UmpleClass A = model.getUmpleClass("A");
	Key key = A.getKey();
	Assert.assertEquals(1,key.numberOfMembers());
	Assert.assertEquals("bbbB", key.getMember(0));
  }
  
  
  @Test
  public void enumAttributeEmpty()
  {
    assertParse("020_enumEmpty.ump");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfStateMachines());
    StateMachine sm = student.getStateMachine(0);
    Assert.assertEquals("Simple",sm.getType());
  }

  @Test
  public void enumShortHandSyntax()
  {
    assertParse("020_enum.ump");
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(2,student.numberOfStateMachines());
    StateMachine sm = student.getStateMachine(0);
    Assert.assertEquals("Simple",sm.getType());
    
    Assert.assertEquals(3,sm.numberOfStates());
    Assert.assertEquals("FullTime", sm.getState(0).getName());
    Assert.assertEquals("PartTime", sm.getState(1).getName());
    Assert.assertEquals("MidTime", sm.getState(2).getName());
  }

  @Test
  public void enumLongHandSyntax()
  {
    assertParse("020_enumLongHand.ump");
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfStateMachines());
    StateMachine sm = student.getStateMachine(0);
    Assert.assertEquals("Simple",sm.getType());
    
    Assert.assertEquals(2,sm.numberOfStates());
    Assert.assertEquals("FullTime", sm.getState(0).getName());
    Assert.assertEquals("PartTime", sm.getState(1).getName());
  }
  
  @Test
  public void nestedUseStatements()
  {
    assertParse("021_nestedUse.ump");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(3,student.numberOfAttributes()); 
  }
  
  @Test
  public void immutableOneWayInternalAssociation()
  {
    assertParse("023_immutableInternalAssociation.ump");
    Association as = model.getAssociation(0);
    Assert.assertTrue(as.isImmutable());
    
    UmpleClass student = model.getUmpleClass("Student");
    AssociationVariable av = student.getAssociationVariable("aMentor");
    Assert.assertTrue(av.isImmutable());
    av = student.getAssociationVariable("them");
    Assert.assertTrue(av.isImmutable());
    av = student.getAssociationVariable("me");
    Assert.assertTrue(av.isImmutable());
    
    UmpleClass mentor = model.getUmpleClass("Mentor");
    av = mentor.getAssociationVariable("student");
    Assert.assertTrue(av.isImmutable());
  }
  
  @Test
  public void immutableOtherWayInternalAssociation()
  {
    assertParse("023_immutableInternalOtherWayAssociation.ump");
    Association as = model.getAssociation(0);
    Assert.assertTrue(as.isImmutable());
    
    UmpleClass student = model.getUmpleClass("Student");
    AssociationVariable av = student.getAssociationVariable("aMentor");
    Assert.assertTrue(av.isImmutable());
    av = student.getAssociationVariable("them");
    Assert.assertTrue(av.isImmutable());
    av = student.getAssociationVariable("me");
    Assert.assertTrue(av.isImmutable());
    
    UmpleClass mentor = model.getUmpleClass("Mentor");
    av = mentor.getAssociationVariable("student");
    Assert.assertTrue(av.isImmutable());
  }
  
  @Test
  public void immutableExternalAssociation()
  {
    assertParse("023_immutableExternalAssociation.ump");
    Association as = model.getAssociation(0);
    Assert.assertTrue(as.isImmutable());
    
    UmpleClass student = model.getUmpleClass("Student");
    AssociationVariable av = student.getAssociationVariable("myMentor");
    Assert.assertTrue(av.isImmutable());
    av = student.getAssociationVariable("them");
    Assert.assertTrue(av.isImmutable());
    av = student.getAssociationVariable("me");
    Assert.assertTrue(av.isImmutable());
    
    UmpleClass mentor = model.getUmpleClass("Mentor");
    av = mentor.getAssociationVariable("student");
    Assert.assertTrue(av.isImmutable());
  }
  
  @Test
  public void immutableExternalOtherWayAssociation()
  {
    assertParse("023_immutableExternalOtherWayAssociation.ump");
    Association as = model.getAssociation(0);
    Assert.assertTrue(as.isImmutable());
    
    UmpleClass student = model.getUmpleClass("Student");
    AssociationVariable av = student.getAssociationVariable("myMentor");
    Assert.assertTrue(av.isImmutable());
    av = student.getAssociationVariable("them");
    Assert.assertTrue(av.isImmutable());
    av = student.getAssociationVariable("me");
    Assert.assertTrue(av.isImmutable());
    
    UmpleClass mentor = model.getUmpleClass("Mentor");
    av = mentor.getAssociationVariable("student");
    Assert.assertTrue(av.isImmutable());
  }
  
  @Test
  public void immutableTwoWayAssociationsAreNotAllowed()
  {
    assertFailedParse("023_immutableInternalTwoWayAssociation.ump", new Position("023_immutableInternalTwoWayAssociation.ump",4,2,19), 17);
    assertFailedParse("023_immutableExternalTwoWayAssociation.ump", new Position("023_immutableExternalTwoWayAssociation.ump",10,2,52), 17);
  }
  
  @Test
  public void immutableAssociationMayNotHaveMutableClassAtDirectedEnd()
  {
    assertFailedParse("023_immutableExternalAssociationInvalid.ump", new Position("023_immutableExternalAssociationInvalid.ump",9,2,51), 13);
    assertFailedParse("023_immutableExternalOtherWayAssociationInvalid.ump", new Position("023_immutableExternalOtherWayAssociationInvalid.ump",9,2,51), 13);
    assertFailedParse("023_immutableExternalReflexiveAssociationInvalid.ump", new Position("023_immutableExternalReflexiveAssociationInvalid.ump",6,2,34), 13);
    assertFailedParse("023_immutableInternalAssociationInvalid.ump", new Position("023_immutableInternalAssociationInvalid.ump",3,2,18), 13);
    assertFailedParse("023_immutableInternalOtherWayAssociationInvalid.ump", new Position("023_immutableInternalOtherWayAssociationInvalid.ump",6,2,35), 13);
    assertFailedParse("023_immutableInternalReflexiveAssociationInvalid.ump", new Position("023_immutableInternalReflexiveAssociationInvalid.ump",3,2,18), 13);
    assertFailedParse("023_immutableInternalReflexiveOtherWayAssociationInvalid.ump", new Position("023_immutableInternalReflexiveOtherWayAssociationInvalid.ump",3,2,18), 13);
  }
  
  @Test
  public void reflexiveMandatoryAssociationMayNotBeImmutable()
  {
	assertFailedParse("023_immutableReflexiveMandatoryAssociation.ump", 36, 0);
    assertFailedParse("023_immutableReflexiveMandatoryAssociation.ump", new Position("023_immutableReflexiveMandatoryAssociation.ump",8,2,48), 18, 1);
    assertFailedParse("023_immutableReflexiveMandatoryAssociation2.ump", new Position("023_immutableReflexiveMandatoryAssociation2.ump",4,2,31), 18);
    assertFailedParse("023_immutableReflexiveMandatoryOtherWayAssociation.ump", new Position("023_immutableReflexiveMandatoryOtherWayAssociation.ump",8,2,48), 18, 1);
    assertFailedParse("023_immutableReflexiveMandatoryOtherWayAssociation.ump", 36, 0);
    assertFailedParse("023_immutableReflexiveMandatoryOtherWayAssociation2.ump", new Position("023_immutableReflexiveMandatoryOtherWayAssociation2.ump",4,2,31), 18, 1);
    assertFailedParse("023_immutableReflexiveMandatoryOtherWayAssociation2.ump", 36, 0);
  }
  
  @Test
  public void duplicateAssociationNames()
  {
    assertFailedParse("024_multipleUnnamedAssociationsToSameClass.ump", new Position("024_multipleUnnamedAssociationsToSameClass.ump",5,2,74), 19);
    assertFailedParse("024_multipleAssociationsWithSameName.ump", new Position("024_multipleAssociationsWithSameName.ump",7,2,79), 19);
    assertFailedParse("024_roleNameSameAsClassWithMultiAssocToSameClass.ump", 19); 
    assertFailedParse("024_multiAssocToSameClassNeedRoleName.ump", 19);  
    
    assertParse("024_multipleUnnamedOneWayAssociationsToSameClass.ump");
  }
  
  @Test
  public void duplicateAttributesNames(){
    assertFailedParse("025_multipleAttributesWithSameName.ump", new Position("025_multipleAttributesWithSameName.ump",3,2,16),22);
  
  } 
  
  @Test
  public void commentsBeforeClasses()
  {
    assertParse("400_commentsBeforeClasses.ump");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfComments());
    Assert.assertEquals("This is a simple comment",student.getComment(0).getText());
  }
  
  @Test
  public void test() {
	  assertParse("400_multiCommentsBeforeClassesTest.ump");
	  
	  UmpleClass student = model.getUmpleClass("Student");
	  Assert.assertEquals(2, student.numberOfComments());
	  Assert.assertEquals("This is a simple comment", student.getComment(0).getText());
	  Assert.assertEquals("Multiline comment test", student.getComment(1).getText());
  }
  
  @Test
  public void commentsBeforeMultipleClasses()
  {
    assertParse("400_commentsBeforeMultipleClasses.ump");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfComments());
    Assert.assertEquals("This is a simple comment",student.getComment(0).getText());

    UmpleClass mentor = model.getUmpleClass("Mentor");
    Assert.assertEquals(0,mentor.numberOfComments());

    UmpleClass course = model.getUmpleClass("Course");
    Assert.assertEquals(1,course.numberOfComments());
    Assert.assertEquals("This is a course file",course.getComment(0).getText());
  }

  @Test
  public void commentsWayBeforeClass()
  {
    assertParse("400_commentsWayBeforeClass.ump");
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(0,student.numberOfComments());
    
    
  }
  
  @Test
  public void sameLineComments()
  {
    assertSimpleParse("427_CommentPosition.ump");
	// check that attribute comments are attributing properly.
	UmpleClass Test = model.getUmpleClass("Test");
	Attribute a1 = Test.getAttribute("test");
	Assert.assertEquals(2, a1.numberOfComments());
	Attribute a2 = Test.getAttribute("test2");
	Assert.assertEquals(0, a2.numberOfComments());
	
	// check that association comments are attributing properly.
	UmpleClass X = model.getUmpleClass("X");
	AssociationVariable av1 = X.getAssociationVariable("test");
	Assert.assertEquals(2, av1.numberOfComments());
	AssociationVariable av2 = X.getAssociationVariable("test2");
	Assert.assertEquals(0, av2.numberOfComments());
	
  }
  
  
  @Test
  public void mixingRegularAndDerivedAttributes_bug201()
  {
    //http://code.google.com/p/umple/issues/detail?id=201
    assertParse("030_mixingRegularAndDerivedAttributes_bug201.ump");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(3,student.numberOfAttributes());
    
  }
  
  @Test
  public void debugKeyword()
  {
    assertParse("500_DebugMode.ump");       
    Assert.assertEquals(true,model.getDebugMode());        
  }

  @Test 
  public void filenamePropogation()
  {
	assertParse("020_enumLongHand.ump");
	if(parser.getClass() == UmpleInternalParser.class)
       Assert.assertEquals("020_enumLongHand.ump", ((UmpleInternalParser)parser).getFilename());        
  }
  
  @Test
  public void mixin_namespaces(){
	  assertParse("213_mixin_namespaces_1.ump");
	  Assert.assertEquals("A",parser.getModel().getUmpleClass("X").getPackageName());
	  Assert.assertEquals("B",parser.getModel().getUmpleClass("Y").getPackageName());
	  
	  assertParse("213_mixin_namespaces_2.ump");
	  Assert.assertEquals("B",parser.getModel().getUmpleClass("X").getPackageName());
	  Assert.assertEquals("B",parser.getModel().getUmpleClass("Y").getPackageName());
	  
	  assertHasWarningsParse("213_mixin_namespaces_3.ump",30);
	  Assert.assertEquals("C",parser.getModel().getUmpleClass("X").getPackageName());
	  Assert.assertEquals("B",parser.getModel().getUmpleClass("Y").getPackageName());
	  
  }
  
  // Test for issue #272
  // Author: Blake Quebec Desloges
  @Test
  public void attributeAndAssociationNameClashingBidirectional(){
  	  
	  assertFailedParse("024_bidirectional_many_to_one.ump",23);
	  assertFailedParse("024_bidirectional_many_to_some.ump",23);
	  assertFailedParse("024_bidirectional_many_to_many.ump",23);
	  assertFailedParse("024_bidirectional_some_to_one.ump",23);
	  assertFailedParse("024_bidirectional_some_to_some.ump",23);
	  assertFailedParse("024_bidirectional_some_to_many.ump",23);
	  assertFailedParse("024_bidirectional_one_to_one.ump",23);
	  assertFailedParse("024_bidirectional_one_to_some.ump",23);
	  assertFailedParse("024_bidirectional_one_to_many.ump",23);
	  
  }
  @Test
  public void attributeAndAssociationNameClashingUnidirectional(){
  	  
	  assertFailedParse("024_unidirectional_many_to_one.ump",23);
	  assertFailedParse("024_unidirectional_many_to_some.ump",23);
	  assertFailedParse("024_unidirectional_many_to_many.ump",23);
	  assertFailedParse("024_unidirectional_some_to_one.ump",36,0);
	  assertFailedParse("024_unidirectional_some_to_one.ump",23,1);
	  assertFailedParse("024_unidirectional_some_to_some.ump",36,0);
	  assertFailedParse("024_unidirectional_some_to_some.ump",23,1);
	  assertFailedParse("024_unidirectional_some_to_many.ump",36,0);
	  assertFailedParse("024_unidirectional_some_to_many.ump",23,1);
	  assertFailedParse("024_unidirectional_one_to_one.ump",36,0);
	  assertFailedParse("024_unidirectional_one_to_one.ump",23,1);
	  assertFailedParse("024_unidirectional_one_to_some.ump",36,0);
	  assertFailedParse("024_unidirectional_one_to_some.ump",23,1);
	  assertFailedParse("024_unidirectional_one_to_many.ump",36,0);
	  assertFailedParse("024_unidirectional_one_to_many.ump",23,1);
	  
  }
  @Test
  public void attributeAndAssociationNameClashingBackwardsUnidirectional(){
  	  
	  assertFailedParse("024_back_unidirectional_many_to_one.ump",23);
	  assertFailedParse("024_back_unidirectional_many_to_some.ump",23);
	  assertFailedParse("024_back_unidirectional_many_to_many.ump",23);
	  assertFailedParse("024_back_unidirectional_some_to_one.ump",36,0);
	  assertFailedParse("024_back_unidirectional_some_to_one.ump",23,1);
	  assertFailedParse("024_back_unidirectional_some_to_some.ump",36,0);
	  assertFailedParse("024_back_unidirectional_some_to_some.ump",23,1);
	  assertFailedParse("024_back_unidirectional_some_to_many.ump",36,0);
	  assertFailedParse("024_back_unidirectional_some_to_many.ump",23,1);
	  assertFailedParse("024_back_unidirectional_one_to_one.ump",36,0);
	  assertFailedParse("024_back_unidirectional_one_to_one.ump",23,1);
	  assertFailedParse("024_back_unidirectional_one_to_some.ump",36,0);
	  assertFailedParse("024_back_unidirectional_one_to_some.ump",23,1);
	  assertFailedParse("024_back_unidirectional_one_to_many.ump",36,0);
	  assertFailedParse("024_back_unidirectional_one_to_many.ump",23,1);
	  
  }
  @Test
  public void attributeAndAssociationNameClashingSeparate(){
  	  
  	  assertFailedParse("024_separate_back_unidirectional.ump",36,0);
  	assertFailedParse("024_separate_back_unidirectional.ump",23,1);
	  assertFailedParse("024_separate_bidirectional.ump",23);
	  assertFailedParse("024_separate_unidirectional.ump",36,0);
	  assertFailedParse("024_separate_unidirectional.ump",23,1);
	  
  }  
  
  
  // Test for issue #354
  // Author: Blake Quebec Desloges
  @Test
  public void stateMachineandAttributeNameClashing(){
  	  assertFailedParse("106_invalidNameStateMachineAndAttribute.ump",52); 
  }
  @Test
  public void stateMachineandAssociationNameClashing(){
  	  assertFailedParse("106_invalidNameStateMachineAndAssocRoleName1.ump",52);
  	  assertFailedParse("106_invalidNameStateMachineAndAssocRoleName2.ump",52);
  	  assertFailedParse("106_invalidNameStateMachineAndAssocRoleName3.ump",52);
  	  assertFailedParse("106_invalidNameStateMachineAndAssocRoleName4.ump",52);
  }
  
  @Test
  public void stateMachineConcurrencyBetweenStates()
  {
	  assertFailedParse("103_Concurrent_FirstStateLevel.ump", 53);
  }
  
  @Test
  public void externalDefinitionAndClassDefinitionCodeGeneration_externalFirst()
  {
    assertParse("026_externalDefinitionAndClassDefinition_first.ump");
    
    UmpleClass x = model.getUmpleClass("X");
    Assert.assertEquals(1,x.numberOfAttributes());
  }
   
   @Test
  public void externalDefinitionAndClassDefinitionCodeGeneration_externalMiddle()
  {
    assertParse("026_externalDefinitionAndClassDefinition_middle.ump");
    
    UmpleClass x = model.getUmpleClass("X");
    Assert.assertEquals(2,x.numberOfAttributes());
  }
  
   @Test
  public void externalDefinitionAndClassDefinitionCodeGeneration_externalLast()
  {
    assertParse("026_externalDefinitionAndClassDefinition_last.ump");
    
    UmpleClass x = model.getUmpleClass("X");
    Assert.assertEquals(1,x.numberOfAttributes());
  }
  
  
  // Test for issue 412 by F.K
  @Test 
  public void commentInAssociation()
  {
	assertParse("412_association_comment.ump");
  }
  
  public boolean parse(String filename)
  {
    //String input = SampleFileWriter.readContent(new File(pathToInput, filename));
	UmpleFile file = new UmpleFile(pathToInput,filename);
    ErrorTypeSingleton.getInstance().reset();
    model = new UmpleModel(new UmpleFile(pathToInput,filename));
    model.setShouldGenerate(false);
    RuleBasedParser rbp = new RuleBasedParser();
    parser = new UmpleInternalParser(umpleParserName,model,rbp);
    ParseResult result = rbp.parse(file);
    model.setLastResult(result);
    System.out.println(rbp.getRootToken());
    boolean answer = result.getWasSuccess();
    if (answer)
    {
      answer = parser.analyze(false).getWasSuccess();
    }
    return answer;
  }
  
  public boolean parseWarnings(String filename)
  {
    ErrorTypeSingleton.getInstance().reset();
    UmpleFile file = new UmpleFile(pathToInput,filename);
    model = new UmpleModel(file);
    model.setShouldGenerate(false);
    RuleBasedParser rbp = new RuleBasedParser();
    parser = new UmpleInternalParser(umpleParserName,model,rbp);
    ParseResult result = rbp.parse(file);
    model.setLastResult(result);
    boolean answer = result.getWasSuccess();
    if (answer)
    {
      answer = parser.analyze(false).getWasSuccess();
    }
    return answer;
  }
  
  // Assertion case where we expect the parse to succeed - may be overridden
  public void assertParse(String filename)
  {
    Assert.assertEquals(true,parse(filename));
  }
  
  // Assertion case where we expect the parse to succeed 
  public void assertSimpleParse(String filename)
  {
    Assert.assertEquals(true,parse(filename));
  }

  // Assertion for case where we expect parse to fail, and care about the position
  public void assertFailedParse(String filename, Position expectedPosition)
  {
    boolean answer = parse(filename);
    Assert.assertEquals(false, answer);
    Assert.assertEquals(expectedPosition, model.getLastResult().getErrorMessage(0).getPosition());
  }

  // Assertion for case where we expect parse to fail and care about the position and the error
  public void assertFailedParse(String filename, Position expectedPosition, int expectedError)
  {
    assertFailedParse(filename, expectedPosition);
    Assert.assertEquals(expectedError, parser.getParseResult().getErrorMessage(0).getErrorType().getErrorCode());
  }
  
  // Assertion for case where we expect parse to fail and care about the position, the error and the error Index per issue347
  public void assertFailedParse(String filename, Position expectedPosition, int expectedError, int expectedErrorIndex)
  {
    assertFailedParse(filename, expectedPosition);
    Assert.assertEquals(expectedError, parser.getParseResult().getErrorMessage(expectedErrorIndex).getErrorType().getErrorCode());
  }
  
  // Assertion for case where we expect parse to fail care about the error number but not the position
  public void assertFailedParse(String filename, int expectedError)
  {
    boolean answer = parse(filename);
    Assert.assertEquals(false, answer);
    Assert.assertEquals(expectedError, model.getLastResult().getErrorMessage(0).getErrorType().getErrorCode());
  }
  
  // Assertion case where we expect warnings at certain positions but don't care about the warning number
  public void assertHasWarningsParse(String filename, Position expectedPosition)
  {
    boolean answer = parseWarnings(filename);
    Assert.assertEquals(true, answer);
    Assert.assertEquals(expectedPosition, parser.getParseResult().getPosition());
  }
  
  // Assertion for case where we expect parse to fail and care about the error number and error index per issue347
  public void assertFailedParse(String filename, int expectedError, int expectedErrorIndex)
  {
    boolean answer = parse(filename);
    Assert.assertEquals(false, answer);
    Assert.assertEquals(expectedError, model.getLastResult().getErrorMessage(expectedErrorIndex).getErrorType().getErrorCode());
  }
  
  // Assertion case where we expect warnings and care about the position and the warning number
  public void assertHasWarningsParse(String filename, Position expectedPosition, int expectedError)
  {
    assertHasWarningsParse(filename, expectedPosition);
    Assert.assertEquals(expectedError, parser.getParseResult().getErrorMessage(0).getErrorType().getErrorCode());
  }

  // Assertion case where we expect warnings and care about the  warning number but not the position
  public void assertHasWarningsParse(String filename, int expectedError)
  {
    boolean answer = parseWarnings(filename);
    Assert.assertEquals(true, answer);
    Assert.assertEquals(expectedError, parser.getParseResult().getErrorMessage(0).getErrorType().getErrorCode());
  }
  
  //Assertion case where we expect warnings and care about the  warning number but not the position
  public void assertHasWarningsParse(String filename, int expectedError, int expectedErrorIndex)
  {
    boolean answer = parseWarnings(filename);
    Assert.assertEquals(true, answer);
    Assert.assertEquals(expectedError, parser.getParseResult().getErrorMessage(expectedErrorIndex).getErrorType().getErrorCode());
  }
  
  //Assertion case where we expect no warnings generated
  public void assertNoWarningsParse(String filename)
  {
	boolean answer = parseWarnings(filename);
	Assert.assertEquals(true, answer);
	Assert.assertEquals(true, parser.getParseResult().getErrorMessages().isEmpty());
  }
  
}
 
