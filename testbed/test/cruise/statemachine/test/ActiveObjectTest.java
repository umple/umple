package cruise.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class ActiveObjectTest {
  @Test
  public void doActivityInActiveObject() throws InterruptedException
  {
    CourseY course = new CourseY();
    
    Thread.sleep(5000);
    Assert.assertEquals("Active entry", course.getLog(0));
  }
  
  @Test
  public void TwoActiveObject() throws InterruptedException
  {
    CourseZ course = new CourseZ();
    
    Thread.sleep(5000);
    Assert.assertEquals("First active", course.getLogFirstActive());
    Assert.assertEquals("Second active", course.getLogSecondActive());
  }
}
