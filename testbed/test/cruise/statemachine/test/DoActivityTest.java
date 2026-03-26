package cruise.statemachine.test;

import org.junit.*;

public class DoActivityTest
{
  // For longest possible waiting time (ms) do NUM_CHECKS * CHECK_INTERVAL_MS
  private static final int NUM_CHECKS = 800;
  private static final int CHECK_INTERVAL_MS = 25;

  @Test
  public void doActivity() throws InterruptedException
  {
    CourseC course = new CourseC();
    course.flip();

    int numChecks = NUM_CHECKS;
    final int expectedLogs = 3;
    
    while(numChecks > 0)
    {
      boolean testsCompleted = false;
      if (course.numberOfLogs() == expectedLogs) {
        break;
      } 
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }
    
    Assert.assertEquals("Expected " + expectedLogs + ", but only produced " + course.numberOfLogs(), true,course.numberOfLogs() == expectedLogs);
    Assert.assertEquals("Open Entry", course.getLog(0));
    Assert.assertEquals("Closed Entry", course.getLog(1));
    Assert.assertEquals("Do Activity On Closed",course.getLog(2));
  }
  
  @Test   
  public void stopProcessingIfYouLeaveTheState() throws InterruptedException
  {
    CourseC course = new CourseC();
    course.flip();
    course.flip();
   
    int numChecks = NUM_CHECKS;
    final int expectedLogs = 3;

    while(numChecks > 0)
    { 
      if (course.numberOfLogs() == expectedLogs) {
        break;
      } 
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }
    
    Assert.assertEquals("Expected " + expectedLogs + ", but only produced " + course.numberOfLogs(), true,course.numberOfLogs() == expectedLogs);
    Assert.assertEquals("Open Entry", course.getLog(0));
    Assert.assertEquals("Closed Entry", course.getLog(1));
    Assert.assertEquals("Open Entry",course.getLog(2));
  }

  @Test
  public void transitionAfterDoActivity() throws InterruptedException
  {
    CourseV course = new CourseV();
    int numChecks = NUM_CHECKS;
    final CourseV.Status expectedStatus = CourseV.Status.On;
    
    while(numChecks > 0)
    {

      if (course.getStatus() == expectedStatus) {
        break;
      }
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }

    Assert.assertEquals(1, course.getCount());
    Assert.assertEquals(CourseV.Status.On, course.getStatus());
  }

  @Test
  public void autoTransitionSyncAfterMultipleDo() throws InterruptedException
  {
    TransitionActivitySync sync = new TransitionActivitySync();
    int numChecks = NUM_CHECKS;
    final String expectedList = "[1, 2, 3]";

    while(numChecks > 0)
    {
      if (expectedList.equals(sync.getList())) {
        break;
      }
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }

    Assert.assertEquals("[1, 2, 3]", sync.getList());
    Assert.assertEquals(TransitionActivitySync.Status.On, sync.getStatus());
  }
  
  @Test
  public void doActivityInNestedStateMachine() throws InterruptedException
  {
    CourseW course = new CourseW();
    int numChecks = NUM_CHECKS;
    final int expectedLogs = 1;
    while(numChecks > 0)
    {
      if(course.numberOfLogs() == expectedLogs) {
        break;
      }
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }

    Assert.assertEquals("Expected " + expectedLogs + ", but only produced " + course.numberOfLogs(), true,course.numberOfLogs() == expectedLogs);
    Assert.assertEquals("DoActivity in nested state", course.getLog(0));
  }

  @Test
  public void multipleDoActivitiesInState() throws InterruptedException
  {
    MultiLogCourse course = new MultiLogCourse();
    course.flip();
   
    int numChecks = NUM_CHECKS;
    final int expectedLogs = 4;
    
    while(numChecks > 0)
    {
      if(course.numberOfLogs() == expectedLogs) {
        break;
      }
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }

    Assert.assertEquals("Expected " + expectedLogs + ", but only produced " + course.numberOfLogs(), true,course.numberOfLogs() == expectedLogs);
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
   
    int numChecks = NUM_CHECKS;
    final int expectedLogs = 3;
    
    while(numChecks > 0)
    {
      if(course.numberOfLogs() == expectedLogs) {
        break;
      }
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }

    Assert.assertEquals("Expected " + expectedLogs + ", but produced " + course.numberOfLogs(), true,course.numberOfLogs() == expectedLogs);
    Assert.assertEquals("Open Entry", course.getLog(0));
    Assert.assertEquals("Closed Entry", course.getLog(1));
    Assert.assertEquals("Open Entry",course.getLog(2));
  }


  @Test
  public void transitionAfterMultipleDoActivities() throws InterruptedException
  {
    CourseVMultiDo course = new CourseVMultiDo();
    int numChecks = NUM_CHECKS;
    final CourseVMultiDo.Status expectedStatus = CourseVMultiDo.Status.On;

    while(numChecks > 0)
    {
      if(course.getStatus() == expectedStatus) {
        break;
      }
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }
    
    Assert.assertEquals(2, course.getCount());
    Assert.assertEquals(CourseVMultiDo.Status.On, course.getStatus());
  }

  @Test
  public void multipleDoActivitiesInNestedStateMachine() throws InterruptedException
  {
    CourseWMultiDo course = new CourseWMultiDo();
    int numChecks = NUM_CHECKS;
    final int expectedLogs = 2;
    while(numChecks > 0)
    {
      if(course.numberOfLogs() == expectedLogs) {
        break;
      }
      Thread.sleep(CHECK_INTERVAL_MS);
      numChecks--;
    }


    Assert.assertEquals("Expected " + expectedLogs + ", but only produced " + course.numberOfLogs(), true,course.numberOfLogs() == expectedLogs);
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