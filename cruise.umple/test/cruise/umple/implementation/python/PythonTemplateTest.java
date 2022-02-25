/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation.python;

import org.junit.*;

import cruise.umple.compiler.Event;
import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class PythonTemplateTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    Event.setNextAutoTransitionId(1);
    language = "Python";
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation");
    pathToRoot = SampleFileWriter.rationalize("../../cruise.umple");
  }

  @After
  public void tearDown()
  {
    super.tearDown();
    //TODO: Uncomment, using file to compare output for now
    //SampleFileWriter.destroy(pathToInput + "/python/EmptyClass.py");
  }

  @Test
  public void EmptyClassTemplate()
  {
    assertUmpleTemplateFor("python/class_empty.ump","python/class_empty.py.txt", "EmptyClass");
  }

}
