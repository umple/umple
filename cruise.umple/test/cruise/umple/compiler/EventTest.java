package cruise.umple.compiler;

import org.junit.*;

public class EventTest
{

  @Test
  public void name()
  {
    Event e = new Event("blah");
    Assert.assertEquals("blah",e.getName());
  }
  
  
}
