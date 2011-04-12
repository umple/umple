package cruise.attributes.test;

import java.sql.*;
import org.junit.*;

public class DateTimeStringTest
{
  
  @Test
  public void Date()
  {
    DoorE door = new DoorE();
    
    Assert.assertEquals(Date.valueOf("1978-12-01"),door.getD1());
    Assert.assertEquals(Date.valueOf("1978-12-02"),door.getD2());
    Assert.assertEquals(Date.valueOf("1978-12-03"),door.getD3());
    Assert.assertEquals(Date.valueOf("1978-12-04"),door.getD4());

    door.resetD3();
    Assert.assertEquals(Date.valueOf("1978-12-03"),door.getD3());
  }

  @Test
  public void Time()
  {
    DoorF door = new DoorF();
    
    Assert.assertEquals(Time.valueOf("12:51:51"),door.getD1());
    Assert.assertEquals(Time.valueOf("12:52:52"),door.getD2());
    Assert.assertEquals(Time.valueOf("12:53:53"),door.getD3());
    Assert.assertEquals(Time.valueOf("12:54:54"),door.getD4());

    door.resetD3();
    Assert.assertEquals(Time.valueOf("12:53:53"),door.getD3());
  }


}
