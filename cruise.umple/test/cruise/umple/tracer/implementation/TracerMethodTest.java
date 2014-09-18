/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

 */

package cruise.umple.tracer.implementation;

import org.junit.*;

@Ignore
public class TracerMethodTest extends TracerTraceCaseTest
{

  @Test
  public void TraceMethodEntry()
  {
    AssertMethod("TraceMethodEntry.ump","TraceMethodEntry.","Tracer");
  }
  
  @Test
  public void TraceMethodExit()
  {
    AssertMethod("TraceMethodExit.ump","TraceMethodExit.","Tracer");
  }

  //----------------------------------------
  
  public void AssertMethod( String inputUmplefile, String expectedOutputFile, String testClassName)
  {
    assertUmpleTemplateFor( "methods/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        testClassName,
        false);
  }
}