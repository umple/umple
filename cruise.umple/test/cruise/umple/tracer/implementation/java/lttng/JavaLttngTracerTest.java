/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license     

*/

package cruise.umple.tracer.implementation.java.lttng;


import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;


public class JavaLttngTracerTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/tracer/implementation/java/lttng");
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "tracer/java/example");
    SampleFileWriter.destroy(pathToInput + "/cruise");
    SampleFileWriter.destroy(pathToInput + "/Tracer.java");
  }
  
  @Test
  public void Test1()
  {
    assertLttng("LttngTest1.ump","LttngTest1.java.txt");
  }
  
  @Test
  public void Test2()
  {
    assertLttng("LttngTest2.ump","LttngTest2.java.txt");
  }
  
  public void assertLttng(String input, String expected)
  {
    assertUmpleTemplateFor(input,expected,"Tracer",false);
  }
  
}
