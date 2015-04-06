package cruise.umple.compiler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StateComparatorTest
{
  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
  
  @Test 
  public void SuccessTest() throws Exception {
    StateComparator c = new StateComparator("a");
    ImportStateMachineState stateA = new ImportStateMachineState("", "", 0, "a");
    ImportStateMachineState stateB = new ImportStateMachineState("", "", 0, "b");
    
    assertEquals(-1, c.compare(stateA, stateB));
    assertEquals(1, c.compare(stateB, stateA));
    assertEquals(-1, c.compare(stateA, stateA));
    assertEquals(0, c.compare(stateB, stateB));
  }
  
  @Test
  public void NullTest() throws Exception {
    StateComparator c = new StateComparator("a");
    ImportStateMachineState state = new ImportStateMachineState("", "", 0, "a");
    assertEquals(1, c.compare(null, state));
    assertEquals(-1, c.compare(state, null));
    assertEquals(0, c.compare(null, null));
  }
  
  @Test
  public void InvalidElementTest() throws Exception {
    StateComparator c = new StateComparator("a");
    ImportStateMachine state = new ImportStateMachine("", "", 0, "a");
    
    try {
      c.compare(null , state);
      assertTrue(false);
    } catch (Exception e) {
      assertTrue(e instanceof ClassCastException);
    }
  }
}
