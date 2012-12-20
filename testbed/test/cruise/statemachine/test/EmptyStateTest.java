package cruise.statemachine.test;

import org.junit.*;

public class EmptyStateTest
{

  @Test
  public void getStateMachine()
  {
    CourseA course = new CourseA();
    Assert.assertEquals(null, course.getStatus());
  }
  
}
