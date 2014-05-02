/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license     

*/

package cruise.umple.tracer.implementation.java;

import org.junit.After;
import org.junit.Before;

import cruise.umple.tracer.implementation.TracerTest;
import cruise.umple.util.SampleFileWriter;


public class JavaFileTracerTest extends TracerTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Java";
    languagePath = "java";
    this.aTracer = "File";
    this.tracerPath = "/File/";
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/tracer/implementation");
    pathToRoot = SampleFileWriter.rationalize("../../cruise.umple");
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
