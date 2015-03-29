/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

State machine tests

*/

package cruise.umple.statemachine.implementation.eventsequence;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class EventSequenceTemplateTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "EventSequence";
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/statemachine/implementation");
    pathToRoot = SampleFileWriter.rationalize("../../cruise.umple");
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/eventsequence/simple.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/simple_multiple_class.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/simple_multiple_class_multiple_sm.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/simple_nested.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/end_state_reached.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/nested_end_state_reached.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/all_states_visited.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/nested_all_states_visited.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/counter_hit.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/nested_counter_hit.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/guarded_transition_end_reached.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/guarded_transition_all_visited.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/guarded_transition_counter_hit.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/auto_transition.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/guarded_auto_transition.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/timed_transition.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/guarded_timed_transition.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/no_transitions.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/multiple_sm_one_transitionless.html");
    SampleFileWriter.destroy(pathToInput + "/eventsequence/no_state_machine.html");
  }

  @Test
  public void simpleEventSequence()
  {
    assertUmpleTemplateFor
    (
      "eventsequence/simple.ump",
      "eventsequence/simple.html.txt"
    );
  }

  @Test
  public void simpleNestedEventSequence()
  {
    assertUmpleTemplateFor
    (
      "eventsequence/simple_nested.ump",
      "eventsequence/simple_nested.html.txt"
    );
  }

  @Test
  public void simpleMultipleClassEventSequence()
  {
    assertUmpleTemplateFor
    (
      "eventsequence/simple_multiple_class.ump",
      "eventsequence/simple_multiple_class.html.txt"
    );
  }

  @Test
  public void simpleMultipleClassMultipleStateMachineEventSequence()
  {
    assertUmpleTemplateFor
    (
      "eventsequence/simple_multiple_class_multiple_sm.ump",
      "eventsequence/simple_multiple_class_multiple_sm.html.txt"
    );
  }

  @Test
  public void eventSequenceEndStateReached() 
  {
    suboptions = new String[]{"seed", "54"};
    assertUmpleTemplateFor
    (
      "eventsequence/end_state_reached.ump",
      "eventsequence/end_state_reached.html.txt"
    );
  }

  @Test
  public void nestedEventSequenceEndStateReached() 
  {
    suboptions = new String[]{"seed", "51"};
    assertUmpleTemplateFor
    (
      "eventsequence/nested_end_state_reached.ump",
      "eventsequence/nested_end_state_reached.html.txt"
    );
  }

  @Test
  public void eventSequenceAllStatesVisited() 
  {
    suboptions = new String[]{"seed", "2341"};
    assertUmpleTemplateFor
    (
      "eventsequence/all_states_visited.ump",
      "eventsequence/all_states_visited.html.txt"
    );
  }

  @Test
  public void nestedEventSequenceAllStatesVisited() 
  {
    suboptions = new String[]{"seed", "123"};
    assertUmpleTemplateFor
    (
      "eventsequence/nested_all_states_visited.ump",
      "eventsequence/nested_all_states_visited.html.txt"
    );
  }

  @Test
  public void eventSequenceCounterHit() 
  {
    suboptions = new String[]{"seed", "1234"};
    assertUmpleTemplateFor
    (
      "eventsequence/counter_hit.ump",
      "eventsequence/counter_hit.html.txt"
    );
  }

  @Test
  public void nestedEventSequenceCounterHit() 
  {
    suboptions = new String[]{"seed", "1"};
    assertUmpleTemplateFor
    (
      "eventsequence/nested_counter_hit.ump",
      "eventsequence/nested_counter_hit.html.txt"
    );
  }

  @Test
  public void guardedTransitionEventSequenceEndStateReached()
  {
    suboptions = new String[]{"seed", "249250"};
    assertUmpleTemplateFor
    (
      "eventsequence/guarded_transition_end_reached.ump",
      "eventsequence/guarded_transition_end_reached.html.txt"
    );
  }

  @Test
  public void guardedTransitionEventSequenceAllStatesVisited()
  {
    suboptions = new String[]{"seed", "249250"};
    assertUmpleTemplateFor
    (
      "eventsequence/guarded_transition_all_visited.ump",
      "eventsequence/guarded_transition_all_visited.html.txt"
    );
  }

  @Test
  public void guardedTransitionEventSequenceCounterHit()
  {
    suboptions = new String[]{"seed", "1234"};
    assertUmpleTemplateFor
    (
      "eventsequence/guarded_transition_counter_hit.ump",
      "eventsequence/guarded_transition_counter_hit.html.txt"
    );
  }

  @Test
  public void eventSequenceAutoTransition()
  {
    suboptions = new String[]{"seed", "14540"};
    assertUmpleTemplateFor
    (
      "eventsequence/auto_transition.ump",
      "eventsequence/auto_transition.html.txt"
    );
  }

  @Test
  public void eventSequenceGuardedAutoTransition()
  {
    suboptions = new String[]{"seed", "1"};
    assertUmpleTemplateFor
    (
      "eventsequence/guarded_auto_transition.ump",
      "eventsequence/guarded_auto_transition.html.txt"
    );
  }

  @Test
  public void eventSequenceTimedTransition()
  {
    suboptions = new String[]{"seed", "14540"};
    assertUmpleTemplateFor
    (
      "eventsequence/timed_transition.ump",
      "eventsequence/timed_transition.html.txt"
    );
  }

  @Test
  public void eventSequenceGuardedTimedTransition()
  {
    suboptions = new String[]{"seed", "1"};
    assertUmpleTemplateFor
    (
      "eventsequence/guarded_timed_transition.ump",
      "eventsequence/guarded_timed_transition.html.txt"
    );
  }

  @Test
  public void transitionlessEventSequence()
  {
    assertUmpleTemplateFor
    (
      "eventsequence/no_transitions.ump",
      "eventsequence/no_transitions.html.txt"
    );
  }

  @Test
  public void multipleStateMachinesOneTransitionlessEventSequence()
  {
    assertUmpleTemplateFor
    (
      "eventsequence/multiple_sm_one_transitionless.ump",
      "eventsequence/multiple_sm_one_transitionless.html.txt"
    );
  }

  @Test
  public void eventSequenceNoStateMachine()
  {
    assertUmpleTemplateFor
    (
      "eventsequence/no_state_machine.ump",
      "eventsequence/no_state_machine.html.txt"
    );
  }
}
