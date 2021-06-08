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
	  manykeys.addWork(Integer.valueOf(1));
	  manykeys.addWork(Integer.valueOf(2));
	  ManyKeys manykeys2 = new ManyKeys();
	  manykeys2.addWork(Integer.valueOf(1));
	  manykeys2.addWork(Integer.valueOf(2));
	  
	  Assert.assertEquals(true, manykeys.equals(manykeys2));
  }
  
  @Test
  public void MultipleKeysTest() {
	  ManKeysStringAndInt class1 = new ManKeysStringAndInt(1);
	  ManKeysStringAndInt class2 = new ManKeysStringAndInt(1);
	  
	  class1.addWorksString("1");
	  class1.addWorksString("2");
	  
	  class2.addWorksString("1");
	  class2.addWorksString("2");
	  
	  Assert.assertEquals(true, class1.equals(class2));
	  	  
	  class2.addWorksString("3");
	  
	  Assert.assertEquals(false, class1.equals(class2));
	  Assert.assertEquals(false, class2.equals(class1));
  }
}
