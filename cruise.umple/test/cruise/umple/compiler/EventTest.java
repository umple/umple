/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.lang.reflect.Field;

import org.junit.*;

public class EventTest
{

  @Test
  public void name()
  {
    Event e = new Event("blah");
    Assert.assertEquals("blah",e.getName());
  }
  
  @Test
  public void equalsOnlyCaresAboutName()
  {
    Event e = new Event("x");
    Event e2 = new Event("x");
    Assert.assertEquals(e, e2);
    
    e2.setName("y");
    Assert.assertEquals(false, e.equals(e2));
  }
  
  @Test @Ignore //Deploy New Version
  public void IsAutoTransition()
  {
//    Event e = new Event("x");
//    Assert.assertEquals(false, e.isAutoTransition());
//    e.setAutoTransition(true);
//    Assert.assertEquals(true, e.isAutoTransition());
  }
  
  @Test @Ignore //Deploy New Version
  public void createAutoTransition() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
//    Field f1 = Event.class.getDeclaredField("nextAutoTransitionId");
//    f1.setAccessible(true);
//    f1.setInt(null, 1);
//    
//    Event e = Event.createAutoTransition();
//    Assert.assertEquals(true, e.isAutoTransition());
//    Assert.assertEquals("__autotransition1__",e.getName());
//
//    e = Event.createAutoTransition();
//    Assert.assertEquals(true, e.isAutoTransition());
//    Assert.assertEquals("__autotransition2__",e.getName());
  }

  
  
}
