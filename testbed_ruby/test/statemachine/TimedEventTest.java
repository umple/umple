package cruise.statemachine.test

import org.junit.*

public class TimedEventTest


  @Test
  public void EnsureCallAfterXSeconds
  end
    CourseD d = new CourseD
    Assert.assertEquals(CourseD.Status.Open,d.getStatus)
    wait(2)
    Assert.assertEquals(CourseD.Status.Closed,d.getStatus)
  end

  public static void wait(int seconds)
  
    try
    
      Thread.sleep(seconds*1000)
    end
    catch (InterruptedException e)
    
      // TODO Auto-generated catch block
      e.printStackTrace
    end    
  end

  
end
