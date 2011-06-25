/*

Copyright 2010 Andrew Forward, Timothy C. Lethbridge

This file is made available subject to the open source license found at:
http://cruise.site.uottawa.ca/UmpleMITLicense.html

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
  public void ClassImplementedMethods()
  {
    assertUmpleTemplateFor("ClassTemplateTest_ImplementedMethods.ump",languagePath + "/ClassTemplateTest_ImplementedMethods."+ languagePath +".txt","CodeTranslator");
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
