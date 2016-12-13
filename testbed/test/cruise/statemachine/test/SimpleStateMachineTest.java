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
  public void StateMachineWithNegativeNumberGaurd()
  {
    StateMachineWithNegativeNumberGaurd sm = new StateMachineWithNegativeNumberGaurd();
    Assert.assertEquals(StateMachineWithNegativeNumberGaurd.Status.On, sm.getStatus());
    sm.turnOff(-1);
    Assert.assertEquals(StateMachineWithNegativeNumberGaurd.Status.On, sm.getStatus());
    sm.turnOff(0);
    Assert.assertEquals(StateMachineWithNegativeNumberGaurd.Status.Off, sm.getStatus());
  }
}
