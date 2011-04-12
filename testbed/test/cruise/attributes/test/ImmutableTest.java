package cruise.attributes.test;

import org.junit.*;
import java.sql.*;

public class ImmutableTest
{

  // TODO: Look at writing a helper test to use reflection to make sure the "setX" method is not available
  @Test 
  public void Immutable()
  {
    DoorC door = new DoorC("1",2,3.4,new Date(1234),new Time(1235),false,new DoorB(5));

    Assert.assertEquals("1",door.getId());
    // Assert.assertEquals(false,door.setId("2"));
    // Assert.assertEquals("1",door.getId());
  
    Assert.assertEquals(2,door.getIntId());
    // Assert.assertEquals(false,door.setIntId(22));
    // Assert.assertEquals(2,door.getIntId());
  
    Assert.assertEquals(3.4,door.getDoubleId(),0.01);
    // Assert.assertEquals(false,door.setDoubleId(33.44));
    // Assert.assertEquals(3.4,door.getDoubleId(),0.01);
    
    Assert.assertEquals(new Date(1234),door.getDateId());
    // Assert.assertEquals(false,door.setDateId(new Date(4321)));
    // Assert.assertEquals(new Date(1234),door.getDateId());

    Assert.assertEquals(new Time(1235),door.getTimeId());
    // Assert.assertEquals(false,door.setTimeId(new Time(5321)));
    // Assert.assertEquals(new Time(1235),door.getTimeId());

    Assert.assertEquals(false,door.getBooleanId());
    // Assert.assertEquals(false,door.setBooleanId(true));
    // Assert.assertEquals(false,door.getBooleanId());
    
    Assert.assertEquals(new DoorB(5),door.getDoorId());
    // Assert.assertEquals(false,door.setDoorId(new DoorB(6)));
    // Assert.assertEquals(new DoorB(5),door.getDoorId());
  }
  
  //TODO: Look at writing a helper test to use reflection to make sure the "setX" method is not available
  @Test
  public void ImmutableInitialized()
  {
    DoorA door = new DoorA();
    Assert.assertEquals("1",door.getId());
    // Assert.assertEquals(false,door.setId("2"));
    // Assert.assertEquals("1",door.getId());
  
    Assert.assertEquals(2,door.getIntId());
    // Assert.assertEquals(false,door.setIntId(22));
    // Assert.assertEquals(2,door.getIntId());
  
    Assert.assertEquals(3.4,door.getDoubleId(),0.01);
    // Assert.assertEquals(false,door.setDoubleId(33.44));
    // Assert.assertEquals(3.4,door.getDoubleId(),0.01);
    
    Assert.assertEquals(new Date(1234),door.getDateId());
    // Assert.assertEquals(false,door.setDateId(new Date(4321)));
    // Assert.assertEquals(new Date(1234),door.getDateId());

    Assert.assertEquals(new Time(1235),door.getTimeId());
    // Assert.assertEquals(false,door.setTimeId(new Time(5321)));
    // Assert.assertEquals(new Time(1235),door.getTimeId());

    Assert.assertEquals(false,door.getBooleanId());
    // Assert.assertEquals(false,door.setBooleanId(true));
    // Assert.assertEquals(false,door.getBooleanId());
    
    Assert.assertEquals(new DoorB(5),door.getDoorId());
    // Assert.assertEquals(false,door.setDoorId(new DoorB(6)));
    // Assert.assertEquals(new DoorB(5),door.getDoorId());

  }

  
  
}
