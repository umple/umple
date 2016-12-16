package cruise.statemachine.test;

import org.junit.*;

public class EntryAndExitActionTest
{
  
  @Test
  public void EntryCalledOnConstructorForDefault()
  {
    CourseB course = new CourseB();
    Assert.assertEquals("entry called",course.getLog());
  }
  
  @Test
  public void CallEntry()
  {
    CourseB course = new CourseB();
    course.anEvent();
    course.anEvent();
    Assert.assertEquals(CourseB.Status.Open,course.getStatus());
    Assert.assertEquals("entry called", course.getLog());
  }  
  
  @Test
  public void CallExit()
  {
    CourseB course = new CourseB();
    course.anEvent();
    Assert.assertEquals(CourseB.Status.Closed,course.getStatus());
    Assert.assertEquals("exit called", course.getLog());
    
    course.anEvent();
    Assert.assertEquals(CourseB.Status.Open, course.getStatus());
    Assert.assertEquals("entry called", course.getLog());
  }
  
  @Test
  public void CallMultipleEntryExit()
  {
    CourseS course = new CourseS();
    
    Assert.assertEquals("Enter Off 1", course.getLog(0));
    Assert.assertEquals("Enter Off 2", course.getLog(1));

    course.flip();
    Assert.assertEquals("Exit Off 1", course.getLog(2));
    Assert.assertEquals("Exit Off 2", course.getLog(3));
  }

  @Test
  public void ExitActionSelfTransition()
  {
    ExitActionSelfTransition sm = new ExitActionSelfTransition();
	Assert.assertEquals(ExitActionSelfTransition.Sm.created, sm.getSm());
	sm.init();
	Assert.assertEquals(ExitActionSelfTransition.Sm.created, sm.getSm());
	Assert.assertTrue(sm.getExitCodeCalled());
  }
}
