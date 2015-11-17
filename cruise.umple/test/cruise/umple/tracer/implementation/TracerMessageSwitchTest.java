/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

 */

package cruise.umple.tracer.implementation;

import org.junit.*;

@Ignore
public class TracerMessageSwitchTest extends TracerTemplateTest
{

  @Test
  public void TracerSwitchOn()
  {
  	AssertTraceMessageSwitch("TracerSwitchOn.ump","TracerSwitchOn.");
  }

  //----------------------------------------
  
  public void AssertTraceMessageSwitch( String inputUmplefile, String expectedOutputFile)
  {   
    assertUmpleTemplateFor( "attributes/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        "Tracer",
        false);
  }
}