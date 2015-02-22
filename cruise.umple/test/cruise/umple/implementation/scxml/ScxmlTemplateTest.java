/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

State machine tests

*/

package cruise.umple.implementation.scxml;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class ScxmlTemplateTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Scxml";
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation");
    pathToRoot = SampleFileWriter.rationalize("../../cruise.umple");
  }

  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/scxml/empty.scxml");
    SampleFileWriter.destroy(pathToInput + "/scxml/oneState.scxml");
    SampleFileWriter.destroy(pathToInput + "/scxml/simpleTransition.scxml");
    SampleFileWriter.destroy(pathToInput + "/scxml/nestedStateMachine.scxml");
    SampleFileWriter.destroy(pathToInput + "/scxml/transitionWithGuard.scxml");
    SampleFileWriter.destroy(pathToInput + "/scxml/onEntry.scxml");
    SampleFileWriter.destroy(pathToInput + "/scxml/transitionAction.scxml");
  }

  @Test
  public void SimpleStateTable()
  {
    assertUmpleTemplateFor("scxml/empty.ump","scxml/empty.scxml.txt");
  }
  
  @Test
  public void oneState()
  {
    assertUmpleTemplateFor("scxml/oneState.ump","scxml/oneState.scxml.txt");
  }
  
  @Test
  public void simpleTransition()
  {
    assertUmpleTemplateFor("scxml/simpleTransition.ump","scxml/simpleTransition.scxml.txt");
  }
  
  @Test
  public void nestedStateMachine()
  {
    assertUmpleTemplateFor("scxml/nestedStateMachine.ump","scxml/nestedStateMachine.scxml.txt");
  }
  
  @Test
  public void transitionWithGuard()
  {
    assertUmpleTemplateFor("scxml/transitionWithGuard.ump","scxml/transitionWithGuard.scxml.txt");
  }
  
  @Test
  public void stateWithEntry()
  {
    assertUmpleTemplateFor("scxml/onEntry.ump","scxml/onEntry.scxml.txt");
  }
  
  @Test
  public void transitionAction()
  {
    assertUmpleTemplateFor("scxml/transitionAction.ump","scxml/transitionAction.scxml.txt");
  }
}
