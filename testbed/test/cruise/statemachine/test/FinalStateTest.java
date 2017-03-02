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
  public void CallDeleteAsSoonAsOneFinalStateIsReached()
  {
    CourseL c = new CourseL();
    Assert.assertEquals(CourseL.Status.On,c.getStatus());
    Assert.assertEquals(CourseL.StatusOnMotorIdle.MotorIdle,c.getStatusOnMotorIdle());
    Assert.assertEquals(CourseL.StatusOnFanIdle.FanIdle,c.getStatusOnFanIdle());

    c.flip();

    Assert.assertEquals(1,c.numberOfLogs());
    Assert.assertEquals("deleted",c.getLog(0));

    Assert.assertEquals(CourseL.Status.On,c.getStatus());
    Assert.assertEquals(CourseL.StatusOnMotorIdle.Final,c.getStatusOnMotorIdle());
    Assert.assertEquals(CourseL.StatusOnFanIdle.FanIdle,c.getStatusOnFanIdle());
    
  }
  
  
}
