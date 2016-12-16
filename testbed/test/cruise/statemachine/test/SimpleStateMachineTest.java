package cruise.statemachine.test;

import org.junit.*;

public class SimpleStateMachineTest
{

  @Test
  public void OneStateNoEvents()
  {
    CourseB course = new CourseB();
    Assert.assertEquals(CourseB.Status.Open, course.getStatus());
  }
  
  @Test
  public void StateMachineWithNegativeNumberGuard()
  {
    StateMachineWithNegativeNumberGuard sm = new StateMachineWithNegativeNumberGuard();
    Assert.assertEquals(StateMachineWithNegativeNumberGuard.Status.On, sm.getStatus());
    sm.turnOff(-1);
    Assert.assertEquals(StateMachineWithNegativeNumberGuard.Status.On, sm.getStatus());
    sm.turnOff(0);
    Assert.assertEquals(StateMachineWithNegativeNumberGuard.Status.Off, sm.getStatus());
  }
  
  @Test
  public void StateMachineWithStringComparisonGuard()
  {
    StateMachineWithStringComparisonGuard sm = new StateMachineWithStringComparisonGuard();
    Assert.assertEquals(StateMachineWithStringComparisonGuard.CommandControl.IDLE, sm.getCommandControl());
    sm.execute();
    Assert.assertEquals(StateMachineWithStringComparisonGuard.CommandControl.CHECK_AVAILABILITY, sm.getCommandControl());
	sm.execute();
    Assert.assertEquals(StateMachineWithStringComparisonGuard.CommandControl.CHECK_AVAILABILITY, sm.getCommandControl());
	sm.setCmdString("invalid");
	sm.execute();
	Assert.assertEquals(StateMachineWithStringComparisonGuard.CommandControl.COMMAND_VALIDITY, sm.getCommandControl());
	sm.execute();
	Assert.assertEquals(StateMachineWithStringComparisonGuard.CommandControl.COMMAND_VALIDITY, sm.getCommandControl());
	sm.setCmdString("valid");
	sm.execute();
	Assert.assertEquals(StateMachineWithStringComparisonGuard.CommandControl.EXECUTION, sm.getCommandControl());
  }
}
