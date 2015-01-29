/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

State machine tests

*/

package cruise.umple.statemachine.implementation.statetable;

import java.io.File;

import junit.framework.Assert;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class StateTableTemplateTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "StateTables";
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/statemachine/implementation");
    pathToRoot = SampleFileWriter.rationalize("../../cruise.umple");
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/statetable/simple.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/nestedStateTable.html");
  }

  @Test
  public void SimpleStateTable()
  {
    assertUmpleTemplateFor("statetable/simple.ump","statetable/simple.html.txt");
  }
  
  // The following is a test to check if nested state tables are displayed with nested states indented.
  @Test
  public void NestedStateTableIndent()
  {
    assertUmpleTemplateFor("statetable/nestedStateTable.ump", "statetable/nestedStateTable.html.txt");
  }


}
