/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license     

*/

package cruise.umple.tracer.implementation.java.log4j;

import java.io.File;

import junit.framework.Assert;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;


public class JavaLog4jConfigurationTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/tracer/implementation/java/log4j");
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "tracer/java/example");
    SampleFileWriter.destroy(pathToInput + "/cruise");
    SampleFileWriter.destroy(pathToInput + "/Tracer.java");
    SampleFileWriter.destroy(pathToInput + "/log4j2.xml");
  }
  

  
  @Test
  public void TestConfig()
  {
    assertUmpleTemplateFor("TestConfig.ump","TestConfig.xml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/log4j2.xml")).exists());
  }
  
  @Test
  public void TestConfigOptions()
  {
    assertUmpleTemplateFor("TestConfigOptions.ump","TestConfigOptions.xml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/log4j2.xml")).exists());
  }
  
  @Test
  public void TestConfigNoGenration()
  {
    Assert.assertEquals(false, (new File(pathToInput + "/log4j2.xml")).exists());
  }
  
  @Test
  public void TestConfigOptions2()
  {
    assertUmpleTemplateFor("TestConfigOptions2.ump","TestConfigOptions2.xml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/log4j2.xml")).exists());
  }
  
  public void assertLog(String input, String expected)
  {
    assertUmpleTemplateFor(input,expected,"Tracer",false);
  }
  
}
