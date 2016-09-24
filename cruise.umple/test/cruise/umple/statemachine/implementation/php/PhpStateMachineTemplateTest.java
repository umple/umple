/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

State machine extensions

*/

package cruise.umple.statemachine.implementation.php;

import org.junit.After;
import org.junit.Before;

import cruise.umple.statemachine.implementation.StateMachineTest;
import cruise.umple.util.SampleFileWriter;

public class PhpStateMachineTemplateTest extends StateMachineTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "statemachine/php/Student.php");
    SampleFileWriter.destroy(pathToInput + "statemachine/php/Mentor.php");
    SampleFileWriter.destroy(pathToInput + "statemachine/php/Course.php");
    SampleFileWriter.destroy(pathToInput + "statemachine/php/Light.php");
    SampleFileWriter.destroy(pathToInput + "/Duplicate.php");
    SampleFileWriter.destroy(pathToInput + "/LightFixture.php");
  }
}
