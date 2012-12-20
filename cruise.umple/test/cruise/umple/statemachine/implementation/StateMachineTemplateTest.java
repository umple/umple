/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

State machine tests

*/

package cruise.umple.statemachine.implementation;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class StateMachineTemplateTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/statemachine/implementation");
    pathToRoot = SampleFileWriter.rationalize("../../cruise.umple");    
  }

}
