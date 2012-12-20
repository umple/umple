package cruise.statemachine.test;

import org.junit.*;

public class AutoTransitionEvents
{

  @Test
  public void simpleAutoTranslate()
  {
    CourseQ q = new CourseQ();
    Assert.assertEquals(CourseQ.One.On,q.getOne());
  }

  @Test
  public void combinedWithOtherEntryActions()
  {
    CourseR course = new CourseR();
    Assert.assertEquals(CourseR.One.On,course.getOne());
    
    Assert.assertEquals(3, course.numberOfLogs());
    Assert.assertEquals("Enter Off",course.getLog(0));
    Assert.assertEquals("Exit Off",course.getLog(1));
    Assert.assertEquals("Enter On",course.getLog(2));
  }
  
  @Test
  public void autoTransitionWithGuards()
  {
    CourseT course = new CourseT(9);
    Assert.assertEquals(CourseT.One.Wait, course.getOne());
  
    course = new CourseT(11);
    Assert.assertEquals(CourseT.One.On, course.getOne());
  }
  
}
