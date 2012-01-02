package cruise.statemachine.test;

import org.junit.*;

public class FinalStateTest
{

  @Test
  public void CallDeleteOnceInFinalState()
  {
    CourseK c = new CourseK();
    c.flip();
    Assert.assertEquals(1,c.numberOfLogs());
    Assert.assertEquals("deleted",c.getLog(0));
  }
  
  @Test
  public void CallDeleteOnlyOnceAllFinalStatesAreReached()
  {
    CourseL c = new CourseL();
    Assert.assertEquals(CourseL.Status.On,c.getStatus());
    Assert.assertEquals(CourseL.StatusMotorIdle.MotorIdle,c.getStatusMotorIdle());
    Assert.assertEquals(CourseL.StatusFanIdle.FanIdle,c.getStatusFanIdle());

    c.flip();

    Assert.assertEquals(CourseL.Status.On,c.getStatus());
    Assert.assertEquals(CourseL.StatusMotorIdle.Final,c.getStatusMotorIdle());
    Assert.assertEquals(CourseL.StatusFanIdle.FanIdle,c.getStatusFanIdle());
    
    
    Assert.assertEquals(0,c.numberOfLogs());
    c.flop();

    Assert.assertEquals(CourseL.Status.On,c.getStatus());
    Assert.assertEquals(CourseL.StatusMotorIdle.Final,c.getStatusMotorIdle());
    Assert.assertEquals(CourseL.StatusFanIdle.Final,c.getStatusFanIdle());
    
    Assert.assertEquals(1,c.numberOfLogs());
    Assert.assertEquals("deleted",c.getLog(0));
  }
  
  
}
