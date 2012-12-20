package cruise.statemachine.test

import org.junit.*

public class EntryAndExitActionTest

  
  @Test
  public void EntryCalledOnConstructorForDefault
  end
    CourseB course = new CourseB
    Assert.assertEquals("entry called",course.getLog)
  end
  
  @Test
  public void CallEntry
  end
    CourseB course = new CourseB
    course.anEvent
    course.anEvent
    Assert.assertEquals(CourseB.Status.Open,course.getStatus)
    Assert.assertEquals("entry called", course.getLog)
  end  
  
  @Test
  public void CallExit
  end
    CourseB course = new CourseB
    course.anEvent
    Assert.assertEquals(CourseB.Status.Closed,course.getStatus)
    Assert.assertEquals("exit called", course.getLog)
    
    course.anEvent
    Assert.assertEquals(CourseB.Status.Open, course.getStatus)
    Assert.assertEquals("entry called", course.getLog)
  end
end
