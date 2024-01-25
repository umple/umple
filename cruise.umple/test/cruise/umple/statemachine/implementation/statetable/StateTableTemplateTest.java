/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

State machine tests

*/

package cruise.umple.statemachine.implementation.statetable;

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
    SampleFileWriter.destroy(pathToInput + "/statetable/guardedTransitionStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/guardedTransitionNestedStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/guardedTransitionDoublyNestedStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/transitionWithActionStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/transitionWithActionNestedStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/autoTransitionStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/timerTransitionStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentAlongsideNonConcurrentMultipleTransitionToSameStateWithGuardTransition.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentAutoTransitionStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentTimerTransitionStateTableDifferentTimer.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentTimerTransitionStateTableSameTimer.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentTransitionWithActionNestedStateTable.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentWithTransitionsBetweenLocallyNestedStates.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentCrossUp.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentCrossSide.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentCrossDown.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentCrossAnd.html");
    SampleFileWriter.destroy(pathToInput + "/statetable/concurrentSelfTransition.html");
  }

  @Test
  public void simpleStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/simple.ump",
      "statetable/simple.html.txt"
    );
  }
  
  @Test
  public void nestedStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/nestedStateTable.ump", 
      "statetable/nestedStateTable.html.txt"
    );
  }

  @Test
  public void guardedTransitionStateTable() 
  {
    assertUmpleTemplateFor
    (
      "statetable/guardedTransitionStateTable.ump", 
      "statetable/guardedTransitionStateTable.html.txt"
    );
  }

  @Test
  public void guardedTransitionNestedStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/guardedTransitionNestedStateTable.ump", 
      "statetable/guardedTransitionNestedStateTable.html.txt"
    );
  }

  @Test
  public void guardedTransitionDoublyNestedStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/guardedTransitionDoublyNestedStateTable.ump", 
      "statetable/guardedTransitionDoublyNestedStateTable.html.txt"
    );
  }
  
 

  @Test
  public void transitionWithActionStateTable() 
  {
    assertUmpleTemplateFor
    (
      "statetable/transitionWithActionStateTable.ump", 
      "statetable/transitionWithActionStateTable.html.txt"
    );  
  }

  @Test
  public void transitionWithActionNestedStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/transitionWithActionNestedStateTable.ump", 
      "statetable/transitionWithActionNestedStateTable.html.txt"
    );  
  }
  
  @Test
  public void concurrentTransitionWithActionNestedStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentTransitionWithActionNestedStateTable.ump",
      "statetable/concurrentTransitionWithActionNestedStateTable.html.txt"
    );
  }

  @Test
  public void autoTransitionStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/autoTransitionStateTable.ump", 
      "statetable/autoTransitionStateTable.html.txt"
    );
  }
  
  
  
  @Test @Ignore 
  public void concurrentAutoTransitionStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentAutoTransitionStateTable.ump",
      "statetable/concurrentAutoTransitionStateTable.html.txt"
    );
  }

  @Test
  public void timerTransitionStateTable()
  {
    assertUmpleTemplateFor
    (
      "statetable/timerTransitionStateTable.ump", 
      "statetable/timerTransitionStateTable.html.txt"
    );
  }
  
  @Test
  public void concurrentTimerTransitionStateTableDifferentTimer()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentTimerTransitionStateTableDifferentTimer.ump",
      "statetable/concurrentTimerTransitionStateTableDifferentTimer.html.txt"
    );
  }
  
  @Test
  public void concurrentTimerTransitionStateTableSameTimer()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentTimerTransitionStateTableSameTimer.ump",
      "statetable/concurrentTimerTransitionStateTableSameTimer.html.txt"
    );
  }
  
  @Test
  public void concurrentWithTransitionsBetweenLocallyNestedStates()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentWithTransitionsBetweenLocallyNestedStates.ump",
      "statetable/concurrentWithTransitionsBetweenLocallyNestedStates.html.txt"
    );
  }
  
  @Test
  public void concurrentAlongsideNonConcurrentMultipleTransitionToSameStateWithGuardTransition()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentAlongsideNonConcurrentMultipleTransitionToSameStateWithGuardTransition.ump",
      "statetable/concurrentAlongsideNonConcurrentMultipleTransitionToSameStateWithGuardTransition.html.txt"
    );
  }
  
  @Test
  public void concurrentCrossSide()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentCrossSide.ump",
      "statetable/concurrentCrossSide.html.txt"
    );
  }
  
  @Test
  public void concurrentCrossUp()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentCrossUp.ump",
      "statetable/concurrentCrossUp.html.txt"
    );
  }
  
  @Test
  public void concurrentCrossDown()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentCrossDown.ump",
      "statetable/concurrentCrossDown.html.txt"
    );
  }
  
  @Test
  public void concurrentCrossAnd()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentCrossAnd.ump",
      "statetable/concurrentCrossAnd.html.txt"
    );
  }
  
  @Test
  public void concurrentSelfTransition()
  {
    assertUmpleTemplateFor
    (
      "statetable/concurrentSelfTransition.ump",
      "statetable/concurrentSelfTransition.html.txt"
    );
  }
}
