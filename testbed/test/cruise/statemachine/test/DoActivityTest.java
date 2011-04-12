package cruise.statemachine.test;

import org.junit.*;

public class DoActivityTest
{
    
  @Test
  public void doActivity() throws InterruptedException
  {
    CourseC course = new CourseC();
    course.flip();
    course.flip();
    course.flip();
    
    Thread.sleep(5000);
    Assert.assertEquals("Expected 5 or more, but only produced " + course.numberOfLogs(), true,course.numberOfLogs() >= 5);
    Assert.assertEquals("Open Entry", course.getLog(0));
    Assert.assertEquals("Closed Entry",course.getLog(1));
    Assert.assertEquals("Open Entry",course.getLog(2));
    Assert.assertEquals("Closed Entry",course.getLog(3));
    Assert.assertEquals("Do Activity On Open",course.getLog(4));
  }
    
}