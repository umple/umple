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
  public void FixmlAttributes()
  {
    assertUmpleTemplateFor("ClassTemplateTest_FixmlAttributes.ump",languagePath + "/ClassTemplateTest_FixmlAttributes."+ languagePath +".txt","Mentor");
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
  
  @Test
  public void Generated()
  {
    assertUmpleTemplateFor("java/ClassTemplateTest_Generated.ump","java/ClassTemplateTest_Generated.java.txt","Mentor");
  }
  
  @Test
  public void ImportAssociations()
  {
    language = null;
    assertUmpleTemplateFor("java/ClassTemplateTest_Import.ump","java/ClassTemplateTest_Import.java.txt","Mentor");
    assertUmpleTemplateFor("java/ClassTemplateTest_Import.ump","java/ClassTemplateTest_Import2.java.txt","Student");
    assertUmpleTemplateFor("java/ClassTemplateTest_Import.ump","java/ClassTemplateTest_Import3.java.txt","Course");
  }  
  
}
