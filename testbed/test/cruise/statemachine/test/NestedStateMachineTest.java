package cruise.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class NestedStateMachineTest
{

  @Test
  public void EntryState()
  {
    CourseE course = new CourseE();
    Assert.assertEquals(CourseE.Status.Off, course.getStatus());
    Assert.assertEquals(CourseE.StatusOn.Null, course.getStatusOn());    
    
    Assert.assertEquals(1,course.numberOfLogs());
    Assert.assertEquals("Enter Off", course.getLog(0));
  }
  
  @Test
  public void EnterNestedStateMachine()
  {
    
    CourseE course = new CourseE();
    course.turnOn();

    Assert.assertEquals(4,course.numberOfLogs());
    Assert.assertEquals("Enter Off", course.getLog(0));
    Assert.assertEquals("Exit Off", course.getLog(1));
    Assert.assertEquals("Enter On", course.getLog(2));
    Assert.assertEquals("Enter Play", course.getLog(3));
    
    Assert.assertEquals(CourseE.Status.On, course.getStatus());
    Assert.assertEquals(CourseE.StatusOn.Play, course.getStatusOn());    
  }
  
  @Test
  public void fullName()
  {
    CourseE course = new CourseE();

    Assert.assertEquals("Off",course.getStatusFullName());

    course.turnOn();
    Assert.assertEquals("On.Play",course.getStatusFullName());
  }

  @Test
  public void ExitFromNestedState()
  {
    
    CourseE course = new CourseE();
    course.turnOn();
    course.push();
    course.turnOff();

    Assert.assertEquals(9,course.numberOfLogs());
    Assert.assertEquals("Enter Off", course.getLog(0));
    Assert.assertEquals("Exit Off", course.getLog(1));
    Assert.assertEquals("Enter On", course.getLog(2));
    Assert.assertEquals("Enter Play", course.getLog(3));
    Assert.assertEquals("Exit Play", course.getLog(4));
    Assert.assertEquals("Enter Pause", course.getLog(5));
    Assert.assertEquals("Exit Pause", course.getLog(6));
    Assert.assertEquals("Exit On", course.getLog(7));
    Assert.assertEquals("Enter Off", course.getLog(8));
    
    Assert.assertEquals(CourseE.Status.Off, course.getStatus());
    Assert.assertEquals(CourseE.StatusOn.Null, course.getStatusOn());    
  }  
  
  @Test
  public void EnterNonStartStateOfNestedState()
  {
    
    CourseE course = new CourseE();
    Assert.assertEquals(CourseE.Status.Off,course.getStatus());
    course.turnSleep();
    course.wake();

    Assert.assertEquals(6,course.numberOfLogs());
    Assert.assertEquals("Enter Off", course.getLog(0));
    Assert.assertEquals("Exit Off", course.getLog(1));
    Assert.assertEquals("Enter Sleep", course.getLog(2));
    Assert.assertEquals("Exit Sleep", course.getLog(3));
    Assert.assertEquals("Enter On", course.getLog(4));
    Assert.assertEquals("Enter Pause", course.getLog(5));
    
    Assert.assertEquals(CourseE.Status.On, course.getStatus());
    Assert.assertEquals(CourseE.StatusOn.Pause, course.getStatusOn());    
  }    
  
  @Test
  public void ShouldOnlyApplyEventsToCurrentState()
  {
    CourseG course = new CourseG();
    Assert.assertEquals(CourseG.Status.On,course.getStatus());
    course.turnOff();
    course.flip();
    Assert.assertEquals(CourseG.Status.On,course.getStatus());
    Assert.assertEquals(CourseG.StatusOn.Idle,course.getStatusOn());
  }
  
  @Test
  public void ShouldStartInTheMostNestedStartState_SimpleStateMachine()
  {
    CourseH course = new CourseH();
    Assert.assertEquals("On.Running.Play",course.getStatusFullName());
    Assert.assertEquals(CourseH.Status.On,course.getStatus());
    Assert.assertEquals(CourseH.StatusOn.Running,course.getStatusOn());
    Assert.assertEquals(CourseH.StatusOnRunning.Play,course.getStatusOnRunning());
    
    course.setStatus(CourseH.Status.Off);
    Assert.assertEquals("Off.Idle",course.getStatusFullName());
    Assert.assertEquals(CourseH.Status.Off,course.getStatus());
    Assert.assertEquals(CourseH.StatusOff.Idle,course.getStatusOff());
    Assert.assertEquals(CourseH.StatusOn.Null,course.getStatusOn());
    Assert.assertEquals(CourseH.StatusOnRunning.Null,course.getStatusOnRunning());
    
  }
  
  
  @Test
  public void ShouldStartInTheMostNestedStartState_ComplexStateMachine()
  {
    CourseI course = new CourseI();
    Assert.assertEquals("On.Running.Play",course.getStatusFullName());
    Assert.assertEquals(CourseI.Status.On,course.getStatus());
    Assert.assertEquals(CourseI.StatusOn.Running,course.getStatusOn());
    Assert.assertEquals(CourseI.StatusOnRunning.Play,course.getStatusOnRunning());
    
    course.flip();
    Assert.assertEquals("Off.Full",course.getStatusFullName());
    Assert.assertEquals(CourseI.Status.Off,course.getStatus());
    Assert.assertEquals(CourseI.StatusOff.Full,course.getStatusOff());
    Assert.assertEquals(CourseI.StatusOn.Null,course.getStatusOn());
    Assert.assertEquals(CourseI.StatusOnRunning.Null,course.getStatusOnRunning());
    
  }  
  
}
