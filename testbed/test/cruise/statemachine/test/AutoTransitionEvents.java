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
    CourseR r = new CourseR();
    Assert.assertEquals(CourseR.One.On,r.getOne());
    
    Assert.assertEquals(3, r.numberOfLogs());
    Assert.assertEquals("Enter Off",r.getLog(0));
    Assert.assertEquals("Exit Off",r.getLog(1));
    Assert.assertEquals("Enter On",r.getLog(2));
  }
  
}
