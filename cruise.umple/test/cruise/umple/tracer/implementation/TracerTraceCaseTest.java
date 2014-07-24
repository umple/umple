/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

 */

package cruise.umple.tracer.implementation;

import org.junit.*;

@Ignore
public class TracerTraceCaseTest extends TracerTemplateTest
{

  @Test
  public void TraceCaseSingleTD()
  {
  	AssertTraceCase("TraceCaseSingleTD.ump","TraceCaseSingleTD.","Tracer");
  }

  //----------------------------------------
  
  public void AssertTraceCase( String inputUmplefile, String expectedOutputFile, String testClassName)
  {   
    assertUmpleTemplateFor( "tracecase/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        testClassName,
        false);
  }
}