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
  
  @Test @Ignore
  public void AssociationClass()
  {
    Assert.fail("Add an association class syntax text");
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
  
}
