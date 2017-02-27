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
    Assert.assertEquals(CourseF.StatusOnMotorIdle.Null, course.getStatusOnMotorIdle());    
    Assert.assertEquals(CourseF.StatusOnFanIdle.Null, course.getStatusOnFanIdle());
    
    course.turnOn();
    Assert.assertEquals(CourseF.Status.On, course.getStatus());
    Assert.assertEquals(CourseF.StatusOnMotorIdle.MotorIdle, course.getStatusOnMotorIdle());    
    Assert.assertEquals(CourseF.StatusOnFanIdle.FanIdle, course.getStatusOnFanIdle());
  }

  @Test
  public void ExitDualState()
  {
    CourseF course = new CourseF();
    Assert.assertEquals(CourseF.Status.Off, course.getStatus());
    Assert.assertEquals(CourseF.StatusOnMotorIdle.Null, course.getStatusOnMotorIdle());    
    Assert.assertEquals(CourseF.StatusOnFanIdle.Null, course.getStatusOnFanIdle());
    
    course.turnOn();
    Assert.assertEquals(CourseF.Status.On, course.getStatus());
    Assert.assertEquals(CourseF.StatusOnMotorIdle.MotorIdle, course.getStatusOnMotorIdle());    
    Assert.assertEquals(CourseF.StatusOnFanIdle.FanIdle, course.getStatusOnFanIdle());
    
    course.turnOff();
    Assert.assertEquals(CourseF.Status.Off, course.getStatus());
    Assert.assertEquals(CourseF.StatusOnMotorIdle.Null, course.getStatusOnMotorIdle());    
    Assert.assertEquals(CourseF.StatusOnFanIdle.Null, course.getStatusOnFanIdle());
    
  }

  @Test
  public void StayWithinState()
  {
    CourseF course = new CourseF();
    course.turnOn();
    course.flip();

    Assert.assertEquals(CourseF.Status.On, course.getStatus());
    Assert.assertEquals(CourseF.StatusOnMotorIdle.MotorRunning, course.getStatusOnMotorIdle());    
    Assert.assertEquals(CourseF.StatusOnFanIdle.FanIdle, course.getStatusOnFanIdle());

    course.flop();

    Assert.assertEquals(CourseF.Status.On, course.getStatus());
    Assert.assertEquals(CourseF.StatusOnMotorIdle.MotorRunning, course.getStatusOnMotorIdle());    
    Assert.assertEquals(CourseF.StatusOnFanIdle.FanRunning, course.getStatusOnFanIdle());
  }
  

}
