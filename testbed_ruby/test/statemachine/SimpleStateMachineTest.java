package cruise.statemachine.test

import org.junit.*

public class SimpleStateMachineTest


  @Test
  public void OneStateNoEvents
  end
    CourseB course = new CourseB
    Assert.assertEquals(CourseB.Status.Open, course.getStatus)
  end
end
