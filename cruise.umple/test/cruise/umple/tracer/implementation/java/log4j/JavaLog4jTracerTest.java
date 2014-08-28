/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license     

*/

package cruise.umple.tracer.implementation.java.log4j;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.compiler.UmpleModel;
import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;


public class JavaLog4jTracerTest extends TemplateTest
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
  public void Test1()
  {
    assertLog("Log4jTest1.ump","Log4jTest1.java.txt");
  }
  
  @Test
  public void Test2()
  {
    assertLog("Log4jTest2.ump","Log4jTest2.java.txt");
  }
  
  @Test
  public void Test3()
  {
    assertLog("Log4jTest3.ump","Log4jTest3.java.txt");
  }
  
  @Test
  public void Test4()
  {
    assertLog("Log4jTest4.ump","Log4jTest4.java.txt");
  }
  
  @Test
  public void Test5()
  {
    assertLog("Log4jTest5.ump","Log4jTest5.java.txt");
  }
  
  @Test @Ignore
  public void TestConfig()
  {
    aTracer = "log4j";
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
//    assertUmpleTemplateFor("TestConfig.ump","log4j2.xml.txt");
//    assertGeneratedCodeEquals(pathToInput,"log4j2.xml");
//    UmpleModel model = createUmpleSystem(pathToInput, "TestConfig.ump");
//    System.out.println("Code =\n"+model.getCode());
    assertLog4jConfigurationFile("TestConfig.ump","TestConfig.xml.txt");
//    Assert.assertEquals(true, (new File(pathToInput + "/log4j2.xml")).exists());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @Test @Ignore
  public void TestConfigOptions()
  {
    assertUmpleTemplateFor("TestConfigOptions.ump","log4j2.xml.txt");
  } 
  
  @Test @Ignore
  public void TestConfigTmp()
  {
    assertUmpleTemplateFor("TestConfigTmp.ump","log4j2.xml.txt");
  } 
  
  public void assertLog(String input, String expected)
  {
    assertUmpleTemplateFor(input,expected,"Tracer",false);
  }
  
  public void assertLog4jConfigurationFile(String inputUmpleFile, String logConfigFile)
  {
    UmpleModel model = createUmpleSystem(pathToInput, inputUmpleFile);
    System.out.println("model = \n"+model);
    model.generate();
    String actual = model.getCode();
    File expected = new File(pathToInput, logConfigFile);
//    System.out.println("a = \n"+actual);
    SampleFileWriter.assertFileContent(expected,actual);
  }
}
