/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

State machine tests

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class TracerTemplateTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/tracer/implementation");
    pathToRoot = SampleFileWriter.rationalize("../../cruise.umple");    
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(pathToInput + "/attributes/example");
    SampleFileWriter.destroy(pathToInput + "/statemachines/example");
    SampleFileWriter.destroy(pathToInput + "/associations/example");
    
    SampleFileWriter.destroy(pathToInput + "/attributes/cruise/util");
  }
}
