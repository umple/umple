package cruise.statemachine.test;

import org.junit.*;

public class MixinTest
{

  @Test
  public void SharedEvents()
  {
    CourseM course = new CourseM();
    course.flip();
    
    Assert.assertEquals(CourseM.One.Off,course.getOne());
    Assert.assertEquals(CourseM.Two.Fast, course.getTwo());
  }

  @Test
  public void AddEvents()
  {
    CourseN course = new CourseN();
    course.flip();
    Assert.assertEquals(CourseN.One.Off,course.getOne());
  }
  
  @Test
  public void RemoveEvent()
  {
    CourseO course = new CourseO();
    try
    {
      Assert.assertEquals(null, course.getClass().getMethod("flip"));
      Assert.fail("flip should not exist");
    }
    catch (NoSuchMethodException e)
    {
    }
  }
  
}

