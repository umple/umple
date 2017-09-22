package cruise.attributes.test;

import org.junit.*;
import java.sql.*;

public class InheritedTest
{

  @Test 
  public void InheritedKey()
  {
    DoorI door = new DoorI("1");
    DoorI door2 = new DoorI("1");
    
    Assert.assertEquals(true, door.equals(door2)); 
    Assert.assertEquals("1",door.getId());
  }
  
  @Test
  public void InheritedManyKeys()
  {
	  ManyKeys manykeys = new ManyKeys();
	  manykeys.addWork(new Integer(1));
	  manykeys.addWork(new Integer(2));
	  ManyKeys manykeys2 = new ManyKeys();
	  manykeys2.addWork(new Integer(1));
	  manykeys2.addWork(new Integer(2));
	  
	  Assert.assertEquals(true, manykeys.equals(manykeys2));
  }
}
