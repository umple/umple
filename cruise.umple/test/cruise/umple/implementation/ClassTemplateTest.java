/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation;



import org.junit.*;



public class ClassTemplateTest extends TemplateTest

{

  

  @Test

  public void EmptyClass()

  {

    assertUmpleTemplateFor("ClassTemplateTest_EmptyClass.ump",languagePath + "/ClassTemplateTest_EmptyClass."+ languagePath +".txt","Mentor");

  }

  

  @Test

  public void Attributes()

  {

    assertUmpleTemplateFor("ClassTemplateTest_Attributes.ump",languagePath + "/ClassTemplateTest_Attributes."+ languagePath +".txt","Mentor");

  }  


  

  @Test

  public void AssociationAttributes()

  {

    assertUmpleTemplateFor("ClassTemplateTest_AssociationAttributes.ump",languagePath + "/ClassTemplateTest_AssociationAttributes."+ languagePath +".txt","Token");

  }  

  

  @Test

  public void ListAttribute()

  {

    assertUmpleTemplateFor("ClassTemplateTest_ListAttributes.ump",languagePath + "/ClassTemplateTest_ListAttributes."+ languagePath +".txt","Token");

  }   

  

  @Test

  public void IsA()

  {

    assertUmpleTemplateFor("ClassTemplateTest_IsA.ump",languagePath + "/ClassTemplateTest_IsA."+ languagePath +".txt","SubMentor");

  }



  @Test

  public void IsA2()

  {

    assertUmpleTemplateFor("ClassTemplateTest_IsA.ump",languagePath + "/ClassTemplateTest_IsA2."+ languagePath +".txt","SubMentor2");

  } 

  

  @Test

  public void Depend()

  {

    assertUmpleTemplateFor("ClassTemplateTest_Depend.ump",languagePath + "/ClassTemplateTest_Depend."+ languagePath +".txt","Mentor");

  } 

    

  @Test

  public void NoPackageForClass()

  {

    assertUmpleTemplateFor("ClassTemplateTest_NoNamespace.ump",languagePath + "/ClassTemplateTest_NoNamespaceClass."+ languagePath +".txt","Token");

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
  public void Singleton()
  {
    assertUmpleTemplateFor("ClassTemplateTest_Singleton.ump",languagePath + "/ClassTemplateTest_Singleton."+ languagePath +".txt","Application");
  }   

  

  /*

  @Test

  public void LazyAttributesOnSingleton()

  {

	  assertUmpleTemplateFor("ClassTemplateTest_LazyAttributesOnSingleton.ump",languagePath + "/ClassTemplateTest_LazyAttributesOnSingleton."+ languagePath +".txt","Application");

  }

  */

  

  @Test
  public void AssociationClass()
  {
	  //Test two variants of the AssociationClassTest syntax that should generate the same code.
    if (!languagePath.equals("test")) {
	    assertUmpleTemplateFor("ClassTemplateTest_AssociationClassTest_1.ump",languagePath + "/ClassTemplateTest_AssociationClassTest."+ languagePath +".txt","Registration");
	    //Test for issue 131
	    assertUmpleTemplateFor("ClassTemplateTest_AssociationClassTest_2.ump",languagePath + "/ClassTemplateTest_AssociationClassTest."+ languagePath +".txt","Registration");
    }
  }

  

  @Test @Ignore

  public void AssociationClass_NotWellDefined()

  {

    Assert.fail("Add an association class that does not have the *properties* of an association");    

  }

  

  @Test

  public void CommentsBeforeClass()

  {

    assertUmpleTemplateFor("ClassTemplateTest_Comment.ump",languagePath + "/ClassTemplateTest_Comment."+ languagePath +".txt","Student");

  }

  

  @Test

  public void MultiCommentsBeforeClassTest()

  {

	  assertUmpleTemplateFor("ClassTemplateTest_MultiComment.ump",languagePath + "/ClassTemplateTest_MultiComment."+ languagePath +".txt", "Student");

  }

  

  @Test

  public void GarbageCommentsClass()

  {

	  assertUmpleTemplateFor("ClassTemplateTest_GarbageComment.ump",languagePath + "/ClassTemplateTest_GarbageComment."+languagePath+".txt", "Student");

  }

  

  @Test

  public void MultiLineCommentsBeforeClassTest()

  {

	  assertUmpleTemplateFor("ClassTemplateTest_MultiLineComment.ump",languagePath + "/ClassTemplateTest_MultiLineComment."+languagePath+".txt","Student");

  }

    

  /* Test for spacing bug in issue 236 */

  @Test  

  public void EmptyStringAttributeWhitespaceTest()

  {

	  assertUmpleTemplateFor("ClassTemplateTest_EmptyStringAttr.ump",languagePath + "/ClassTemplateTest_EmptyStringAttr."+languagePath+".txt","Student");

  }
  
  
  //
  // Tests for missing comments in generated code.
  //
  
  

  @Test
  public void AttributeInlineComment()
  {
	  assertUmpleTemplateFor("AttributeInlineComment.ump",languagePath + "/ClassTemplateTest_AttributeInlineComment."+languagePath+".txt","Foo");
  }
  
  @Test
  public void AttributeMultilineComment()
  {
	  assertUmpleTemplateFor("AttributeMultilineComment.ump",languagePath + "/ClassTemplateTest_AttributeMultilineComment."+languagePath+".txt","Foo");
  }
  
  @Test
  public void MultipleAttributeComments()
  {
	  assertUmpleTemplateFor("MultipleAttributeComments.ump",languagePath + "/ClassTemplateTest_MultipleAttributeComments."+languagePath+".txt","Foo");
  }

  @Test
  public void InternalAndConstantAndDerivedAttributeComments()
  {
    assertUmpleTemplateFor("ClassTemplateTest_AttributeComments.ump",languagePath+"/ClassTemplateTest_AttributeComments." + languagePath + ".txt","Student");
  }
  
  @Test
  public void AssociationInlineComment()
  {
	  assertUmpleTemplateFor("AssociationInlineComment.ump",languagePath + "/ClassTemplateTest_AssociationInlineComment."+languagePath+".txt","Foo");
  }

  
  @Test
  public void AssociationMultilineComment()
  {
	  assertUmpleTemplateFor("AssociationMultilineComment.ump",languagePath + "/ClassTemplateTest_AssociationMultilineComment."+languagePath+".txt","Foo");
  }
  
  @Test
  public void MultipleAssociationComments()
  {
	  assertUmpleTemplateFor("MultipleAssociationComments.ump",languagePath + "/ClassTemplateTest_MultipleAssociationComments."+languagePath+".txt","Foo");
  }
  
  @Test
  public void MethodInlineComment()
  {
	  assertUmpleTemplateFor("MethodInlineComment.ump",languagePath + "/ClassTemplateTest_MethodInlineComment."+languagePath+".txt","Foo");
  }
  
  @Test
  public void MethodMultilineComment()
  {
	  assertUmpleTemplateFor("MethodMultilineComment.ump",languagePath + "/ClassTemplateTest_MethodMultilineComment."+languagePath+".txt","Foo");
  }
  
  @Test
  public void MultipleMethodComments()
  {
	  assertUmpleTemplateFor("MultipleMethodComments.ump",languagePath + "/ClassTemplateTest_MultipleMethodComments."+languagePath+".txt","Foo");
  }
  
  
  //
  // Special case comment tests for classes and methods where comments may contain empty lines in them.
  //
  
  
  @Test
  public void ClassCommentWithEmptyLines()
  {
	  assertUmpleTemplateFor("ClassCommentWithEmptyLines.ump",languagePath + "/ClassTemplateTest_ClassCommentWithEmptyLines."+languagePath+".txt","Foo");
  }
  
  @Test
  public void MethodCommentWithEmptyLines()
  {
	  assertUmpleTemplateFor("MethodCommentWithEmptyLines.ump",languagePath + "/ClassTemplateTest_MethodCommentWithEmptyLines."+languagePath+".txt","Foo");
  }
  
  
  //
  // Abstract class tests.
  //
  
  
  @Test
  public void AbstractClass()
  {
		assertUmpleTemplateFor("ClassTemplateTest_AbstractClass.ump",languagePath + "/ClassTemplateTest_AbstractClass."+languagePath+".txt","Foo");
  }
  
  @Test
  public void AbstractClassInheritance()
  {
		assertUmpleTemplateFor("ClassTemplateTest_AbstractClassInheritance.ump",languagePath + "/ClassTemplateTest_AbstractClassInheritance."+languagePath+".txt","Teacher");
  }

  @Test
  public void AbstractClassAvoidingInstantiation()
  {
		assertUmpleTemplateFor("ClassTemplateTest_AbstractClassAvoidingInstantiation.ump",languagePath + "/ClassTemplateTest_AbstractClassAvoidingInstantiation."+languagePath+".txt","Teacher");
  }

  @Test
  public void AbstractClassAvoidingInstantiationMN()
  {
		assertUmpleTemplateFor("ClassTemplateTest_AbstractClassAvoidingInstantiation2.ump",languagePath + "/ClassTemplateTest_AbstractClassAvoidingInstantiation2."+languagePath+".txt","Teacher");
  }
  
@Test
  public void MultivaluedAttributeAssignment() 
  {
    if (languagePath.equals("java") || languagePath.equals("php"))
    {
      assertUmpleTemplateFor("ClassTemplateTest_MultivaluedAttributesAssignment.ump", languagePath + "/ClassTemplateTest_MultivaluedAttributesAssignment."+languagePath+".txt", "Foo");
    }
  }
  
@Test
  public void QueuedMethod()
  {
    if (languagePath.equals("java"))
    {
      assertUmpleTemplateFor("ClassTemplateTest_QueuedMethod.ump", languagePath + "/ClassTemplateTest_QueuedMethod."+languagePath+".txt", "Foo");
    }
  }
  
@Ignore @Test
  public void LazyAttributeOnImmutableClass()
  {
	  assertUmpleTemplateFor("ClassTemplateTest_LazyAttributeOnImmutableClass.ump",languagePath + "/ClassTemplateTest_LazyAttributeOnImmutableClass."+languagePath+".txt","Student");
  }

@Test
  public void ImmutableNotLazyAttributeConstructor()
  {
	  assertUmpleTemplateFor("ClassTemplateTest_ImmutableNotLazyAttributeConstructor.ump",languagePath + "/ClassTemplateTest_ImmutableNotLazyTest."+languagePath+".txt","Student");
  }

  @Test
  public void ImportAssociations()
  {
    assertUmpleTemplateFor("ClassTemplateTest_Import.ump", languagePath + "/ClassTemplateTest_Import."+languagePath+".txt","Mentor");
    assertUmpleTemplateFor("ClassTemplateTest_Import.ump", languagePath + "/ClassTemplateTest_Import2."+languagePath+".txt","Student");
    assertUmpleTemplateFor("ClassTemplateTest_Import.ump", languagePath + "/ClassTemplateTest_Import3."+languagePath+".txt","Course");
  }  

}

