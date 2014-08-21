/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license     

*/

package cruise.umple.tracer.implementation.java.log4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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
  }
  
  @Test //@Ignore
  public void Test1()
  {
    assertLog("Log4jTest1.ump","Log4jTest1.java.txt");
  }
  
  @Test //@Ignore
  public void Test2()
  {
    assertLog("Log4jTest2.ump","Log4jTest2.java.txt");
  }
  
  @Test //@Ignore
  public void Test3()
  {
    assertLog("Log4jTest3.ump","Log4jTest3.java.txt");
  }
  
  @Test //@Ignore
  public void Test4()
  {
    assertLog("Log4jTest4.ump","Log4jTest4.java.txt");
  }
  
  @Test //@Ignore
  public void Test5()
  {
    assertLog("Log4jTest5.ump","Log4jTest5.java.txt");
  }
  
  public void assertLog(String input, String expected)
  {
    assertUmpleTemplateFor(input,expected,"Tracer",false);
  }
  
}
