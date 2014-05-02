/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license     

*/

package cruise.umple.tracer.implementation.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import cruise.umple.tracer.implementation.TracerAttributesTest;
import cruise.umple.util.SampleFileWriter;

@Ignore
public class JavaTracerTest extends TracerAttributesTest
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
    SampleFileWriter.destroy(pathToInput + "tracer/java/example");
    SampleFileWriter.destroy(pathToInput + "/cruise");
    SampleFileWriter.destroy(pathToInput + "/Tracer.java");
  }
  
}
