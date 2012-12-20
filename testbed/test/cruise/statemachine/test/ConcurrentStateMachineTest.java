package cruise.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class ConcurrentStateMachineTest
{

  @Test
  public void EnterDualState()
  {
    CourseF course = new CourseF();
    Assert.assertEquals(CourseF.Status.Off, course.getStatus());
    Assert.assertEquals(CourseF.StatusMotorIdle.Null, course.getStatusMotorIdle());    
    Assert.assertEquals(CourseF.StatusFanIdle.Null, course.getStatusFanIdle());
    
    course.turnOn();
    Assert.assertEquals(CourseF.Status.On, course.getStatus());
    Assert.assertEquals(CourseF.StatusMotorIdle.MotorIdle, course.getStatusMotorIdle());    
    Assert.assertEquals(CourseF.StatusFanIdle.FanIdle, course.getStatusFanIdle());
  }

  @Test
  public void ExitDualState()
  {
    CourseF course = new CourseF();
    Assert.assertEquals(CourseF.Status.Off, course.getStatus());
    Assert.assertEquals(CourseF.StatusMotorIdle.Null, course.getStatusMotorIdle());    
    Assert.assertEquals(CourseF.StatusFanIdle.Null, course.getStatusFanIdle());
    
    course.turnOn();
    Assert.assertEquals(CourseF.Status.On, course.getStatus());
    Assert.assertEquals(CourseF.StatusMotorIdle.MotorIdle, course.getStatusMotorIdle());    
    Assert.assertEquals(CourseF.StatusFanIdle.FanIdle, course.getStatusFanIdle());
    
    course.turnOff();
    Assert.assertEquals(CourseF.Status.Off, course.getStatus());
    Assert.assertEquals(CourseF.StatusMotorIdle.Null, course.getStatusMotorIdle());    
    Assert.assertEquals(CourseF.StatusFanIdle.Null, course.getStatusFanIdle());
    
  }

  @Test
  public void StayWithinState()
  {
    CourseF course = new CourseF();
    course.turnOn();
    course.flip();

    Assert.assertEquals(CourseF.Status.On, course.getStatus());
    Assert.assertEquals(CourseF.StatusMotorIdle.MotorRunning, course.getStatusMotorIdle());    
    Assert.assertEquals(CourseF.StatusFanIdle.FanIdle, course.getStatusFanIdle());

    course.flop();

    Assert.assertEquals(CourseF.Status.On, course.getStatus());
    Assert.assertEquals(CourseF.StatusMotorIdle.MotorRunning, course.getStatusMotorIdle());    
    Assert.assertEquals(CourseF.StatusFanIdle.FanRunning, course.getStatusFanIdle());
  }
  

}
