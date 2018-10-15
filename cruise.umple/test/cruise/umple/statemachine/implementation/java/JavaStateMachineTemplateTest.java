/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

State Machine extensions       

*/

package cruise.umple.statemachine.implementation.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

  //Issue #1351
  @Test
  public void stateDependentMethodDeclaration()
  {
    assertUmpleTemplateFor("stateDependentMethodDeclaration.ump",languagePath + "/stateDependentMethodDeclaration."+ languagePath +".txt","Portal");
  }

  @Test
  public void stateDependentMethodDeclaration_2()
  {
    assertUmpleTemplateFor("stateDependentMethodDeclaration_2.ump",languagePath + "/stateDependentMethodDeclaration_2."+ languagePath +".txt","X");
  }

  @Test
  public void stateDependentMethodDeclaration_3()
  {
    assertUmpleTemplateFor("stateDependentMethodDeclaration_3.ump",languagePath + "/stateDependentMethodDeclaration_3."+ languagePath +".txt","MultipleTopLevel");
  }
}
