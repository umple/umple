package cruise.statemachine.test;

import org.junit.*;

public class DoActivityTest
{
    
  @Test
  public void doActivity() throws InterruptedException
  {
    CourseC course = new CourseC();
    course.flip();
   
    Thread.sleep(5000);
    Assert.assertEquals("Expected 3, but only produced " + course.numberOfLogs(), true,course.numberOfLogs() == 3);
    Assert.assertEquals("Open Entry", course.getLog(0));
    Assert.assertEquals("Closed Entry", course.getLog(1));
    Assert.assertEquals("Do Activity On Closed",course.getLog(2));
  }
  
  @Test
  public void stopProcessingIfYouLeaveTheState() throws InterruptedException
  {
    CourseC course = new CourseC();
    course.flip();
    course.flip();
   
    Thread.sleep(5000);
    Assert.assertEquals("Expected 3, but only produced " + course.numberOfLogs(), true,course.numberOfLogs() == 3);
    Assert.assertEquals("Open Entry", course.getLog(0));
    Assert.assertEquals("Closed Entry", course.getLog(1));
    Assert.assertEquals("Open Entry",course.getLog(2));
  }

  @Test
  public void transitionAfterDoActivity() throws InterruptedException
  {
    CourseV course = new CourseV();
    Thread.sleep(5000);
    Assert.assertEquals(1, course.getCount());
    Assert.assertEquals(CourseV.Status.On, course.getStatus());
  }
  
  @Test
  public void doActivityInNestedStateMachine() throws InterruptedException
  {
    CourseW course = new CourseW();
    Thread.sleep(5000);
    
    Assert.assertEquals("DoActivity in nested state", course.getLog(0));
  }
}