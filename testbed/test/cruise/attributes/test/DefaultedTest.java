package cruise.attributes.test;

import org.junit.*;
import java.sql.*;

public class DefaultedTest
{
  
  @Test
  public void defaulted()
  {
    DoorD door = new DoorD();
    
    Assert.assertEquals("1",door.getId());
    Assert.assertEquals(true, door.setId("2"));
    Assert.assertEquals("2",door.getId());
    Assert.assertEquals(true, door.resetId());
    Assert.assertEquals("1",door.getId());
    
    Assert.assertEquals(2,door.getIntId());
    Assert.assertEquals(true, door.setIntId(3));
    Assert.assertEquals(3,door.getIntId());
    Assert.assertEquals(true, door.resetIntId());
    Assert.assertEquals(2,door.getIntId());

    Assert.assertEquals(3.4,door.getDoubleId(),0.01);
    Assert.assertEquals(true, door.setDoubleId(33.44));
    Assert.assertEquals(33.44,door.getDoubleId(),0.01);
    Assert.assertEquals(true, door.resetDoubleId());
    Assert.assertEquals(3.4,door.getDoubleId(),0.01);

    Assert.assertEquals(new Date(1234),door.getDateId());
    Assert.assertEquals(true, door.setDateId(new Date(4321)));
    Assert.assertEquals(new Date(4321),door.getDateId());
    Assert.assertEquals(true, door.resetDateId());
    Assert.assertEquals(new Date(1234),door.getDateId());

    Assert.assertEquals(new Time(1235),door.getTimeId());
    Assert.assertEquals(true, door.setTimeId(new Time(5321)));
    Assert.assertEquals(new Time(5321),door.getTimeId());
    Assert.assertEquals(true, door.resetTimeId());
    Assert.assertEquals(new Time(1235),door.getTimeId());

    Assert.assertEquals(false,door.getBooleanId());
    Assert.assertEquals(true, door.setBooleanId(true));
    Assert.assertEquals(true,door.getBooleanId());
    Assert.assertEquals(true, door.resetBooleanId());
    Assert.assertEquals(false,door.getBooleanId());

    Assert.assertEquals(new DoorB(5),door.getDoorId());
    Assert.assertEquals(true, door.setDoorId(new DoorB(6)));
    Assert.assertEquals(new DoorB(6),door.getDoorId());
    Assert.assertEquals(true, door.resetDoorId());
    Assert.assertEquals(new DoorB(5),door.getDoorId());
  }

}
