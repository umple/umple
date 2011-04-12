package cruise.statemachine.test;

import org.junit.*;

public class TimedEventTest
{

  @Test
  public void EnsureCallAfterXSeconds()
  {
    CourseD d = new CourseD();
    Assert.assertEquals(CourseD.Status.Open,d.getStatus());
    wait(2);
    Assert.assertEquals(CourseD.Status.Closed,d.getStatus());
  }

  public static void wait(int seconds)
  {
    try
    {
      Thread.sleep(seconds*1000);
    }
    catch (InterruptedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }    
  }

  
}
