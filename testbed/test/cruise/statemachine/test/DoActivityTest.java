package cruise.statemachine.test;

import org.junit.*;
import org.junit.Ignore;

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
  @Ignore
  // Ignored because was nondeterministic and breaking build when build was running under heavily loaded machine FIX FIX TO DO    
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
  
  public void autoTransitionSyncAfterMultipleDo() throws InterruptedException
  {
    TransitionActivitySync sync = new TransitionActivitySync();
    Thread.sleep(1000);
    Assert.assertEquals("[1, 2, 3]", sync.getList());
    Assert.assertEquals(TransitionActivitySync.Status.On, sync.getStatus());
  }
  
  @Test
  public void doActivityInNestedStateMachine() throws InterruptedException
  {
    CourseW course = new CourseW();
    Thread.sleep(5000);
    
    Assert.assertEquals("DoActivity in nested state", course.getLog(0));
  }

  @Test
  public void multipleDoActivitiesInState() throws InterruptedException
  {
    MultiLogCourse course = new MultiLogCourse();
    course.flip();
   
    Thread.sleep(5000);
    Assert.assertEquals("Expected 4, but only produced " + course.numberOfLogs(), true,course.numberOfLogs() == 4);
    Assert.assertEquals("Open Entry", course.getLog(0));
    Assert.assertEquals("Closed Entry", course.getLog(1));

    Assert.assertTrue(course.getLog(2).equals("Do Activity On Closed Thread1") || course.getLog(2).equals("Do Activity On Closed Thread2"));

    if (course.getLog(2).equals("Do Activity On Closed Thread1"))
    {
      Assert.assertEquals("Do Activity On Closed Thread2", course.getLog(3));
    }
    else if (course.getLog(2).equals("Do Activity On Closed Thread2"))
    {
      Assert.assertEquals("Do Activity On Closed Thread1", course.getLog(3));
    }
  }

  @Test
  public void multipleDoStopProcessingIfYouLeaveTheState() throws InterruptedException
  {
    MultiLogCourse course = new MultiLogCourse();
    course.flip();
    course.flip();
   
    Thread.sleep(5000);

    Assert.assertEquals("Expected 3, but produced " + course.numberOfLogs(), true,course.numberOfLogs() == 3);
    Assert.assertEquals("Open Entry", course.getLog(0));
    Assert.assertEquals("Closed Entry", course.getLog(1));
    Assert.assertEquals("Open Entry",course.getLog(2));
  }


  @Test
  public void transitionAfterMultipleDoActivities() throws InterruptedException
  {
    CourseVMultiDo course = new CourseVMultiDo();
    Thread.sleep(5000);
    Assert.assertEquals(2, course.getCount());
    Assert.assertEquals(CourseVMultiDo.Status.On, course.getStatus());
  }

  @Test
  public void multipleDoActivitiesInNestedStateMachine() throws InterruptedException
  {
    CourseWMultiDo course = new CourseWMultiDo();
    Thread.sleep(5000);
    
    Assert.assertTrue(course.getLog(0).equals("DoActivity in nested state Thread1") || course.getLog(0).equals("DoActivity in nested state Thread2"));
  
    if (course.getLog(0).equals("DoActivity in nested state Thread1"))
    {
      Assert.assertEquals("DoActivity in nested state Thread2", course.getLog(1));
    }
    else if (course.getLog(0).equals("DoActivity in nested state Thread2"))
    {
      Assert.assertEquals("DoActivity in nested state Thread1", course.getLog(1));
    }

  }

}