package cruise.umple.implementation.gv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class GvSdGeneratorTest extends TemplateTest {

  @Before
  public void setUp() {
    super.setUp();
    language = "GvStateDiagram";
    languagePath = "gv";
  }

  @After
  public void tearDown() {
    super.tearDown();
    // State tests
    SampleFileWriter.destroy(pathToInput + "/gv/NormalState.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/NestedState.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/EntryLess5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Entry5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/EntryMore5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ExitLess5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Exit5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ExitMore5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ActivityLess5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Activity5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ActivityMore5State.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/HideActionState.gv");
		
    // Transition tests
    SampleFileWriter.destroy(pathToInput + "/gv/Transition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/TransitionSelf.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/NestedTransition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/GuardTransition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ActLess5Transition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Act5Transition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ActMore5Transition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/HideActionTransition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/HideGuardTransition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/AutoTransition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/GuardedAutoTransition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/TimedTransition.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ParameterTransition.gv");
  }

  /********* STATE TESTS **********/
  @Test
  public void tooltip_normal_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/NormalState.ump","gv/NormalState.gv.txt");
  }

  @Test
  public void tooltip_nested_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/NestedState.ump","gv/NestedState.gv.txt");
  }
	
  @Test
  public void tooltip_entry_less5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/EntryLess5State.ump","gv/EntryLess5State.gv.txt");
  }
	
  @Test
  public void tooltip_entry_5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Entry5State.ump","gv/Entry5State.gv.txt");
  }
	
  @Test
  public void tooltip_entry_more5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/EntryMore5State.ump","gv/EntryMore5State.gv.txt");
  }
	
  @Test
  public void tooltip_exit_less5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ExitLess5State.ump","gv/ExitLess5State.gv.txt");
  }
	
  @Test
  public void tooltip_exit_5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Exit5State.ump","gv/Exit5State.gv.txt");
  }
	
  @Test
  public void tooltip_exit_more5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ExitMore5State.ump","gv/ExitMore5State.gv.txt");
  }
	
  @Test
  public void tooltip_activity_less5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ActivityLess5State.ump","gv/ActivityLess5State.gv.txt");
  }
	
  @Test
  public void tooltip_activity_5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Activity5State.ump","gv/Activity5State.gv.txt");
  }
	
  @Test
  public void tooltip_activity_more5_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ActivityMore5State.ump","gv/ActivityMore5State.gv.txt");
  }
	
  @Test
  public void tooltip_hide_action_state()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/HideActionState.ump","gv/HideActionState.gv.txt");
  }
	
  /********* TRANSITION TESTS **********/
  @Test
  public void tooltip_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Transition.ump","gv/Transition.gv.txt");
  }
    
  @Test
  public void tooltip_transition_self()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/TransitionSelf.ump","gv/TransitionSelf.gv.txt");
  }
	
  @Test
  public void tooltip_nested_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/NestedTransition.ump","gv/NestedTransition.gv.txt");
  }
	
  @Test
  public void tooltip_guard_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/GuardTransition.ump","gv/GuardTransition.gv.txt");
  }
	
  @Test
  public void tooltip_activity_less5_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ActLess5Transition.ump","gv/ActLess5Transition.gv.txt");
  }
	
  @Test
  public void tooltip_activity_5_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Act5Transition.ump","gv/Act5Transition.gv.txt");
  }
	
  @Test
  public void tooltip_activity_more5_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ActMore5Transition.ump","gv/ActMore5Transition.gv.txt");
  }
	
  @Test
  public void tooltip_hide_action_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/HideActionTransition.ump","gv/HideActionTransition.gv.txt");
  }

  @Test
  public void tooltip_hide_guard_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/HideGuardTransition.ump","gv/HideGuardTransition.gv.txt");
  }
	
  @Test
  public void tooltip_auto_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/AutoTransition.ump","gv/AutoTransition.gv.txt");
  }

  @Test
  public void tooltip_guarded_auto_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/GuardedAutoTransition.ump","gv/GuardedAutoTransition.gv.txt");
  }
	
  @Test
  public void tooltip_timed_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/TimedTransition.ump","gv/TimedTransition.gv.txt");
  }

  @Test
  public void tooltip_parameter_transition()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ParameterTransition.ump","gv/ParameterTransition.gv.txt");
  }
}
