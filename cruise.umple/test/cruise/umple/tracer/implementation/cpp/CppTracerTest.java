/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

State Machine extensions       

*/

package cruise.umple.tracer.implementation.cpp;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.tracer.implementation.*;
import cruise.umple.util.SampleFileWriter;
@Ignore
public class CppTracerTest extends TracerAttributesTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Cpp";
    languagePath = "cpp";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "statemachine/cpp/example");
  }
  
  @Test //@Ignore
  public void lttngSingleAttribute()
  {
	  
	assertUmpleTemplateFor(languagePath +"/LttngTracer_SingleAttribute.ump",languagePath + "/LttngTracer_SingleAttribute."+ languagePath +".txt","A");
		
  }
  
}
