/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

State Machine extensions       

*/

package cruise.umple.statemachine.implementation.java;

import org.junit.After;
import org.junit.Before;

import cruise.umple.statemachine.implementation.StateMachineTest;
import cruise.umple.util.SampleFileWriter;

public class JavaStateMachineTemplateTest extends StateMachineTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Java";
    languagePath = "java";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "statemachine/java/example");
  }
}
