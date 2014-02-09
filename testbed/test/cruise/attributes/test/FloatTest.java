package cruise.attributes.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloatTest {

	@Test
	public void floatWithoutF() {
	  DoorG door = new DoorG();
	  
	  assertEquals(1.1, door.getFloatNoF(), 0.01);
	  assertEquals(1.2f, door.getFloatWithF(), 0.01);
	  assertEquals(1.3, door.getDoubleNoF(), 0.01);
	  assertEquals(1.4f, door.getDoubleWithF(), 0.01);
	}
	
	@Test
	public void floatWithF() {
	  
	}
	
	@Test
	public void doubleWithoutF() {
	  
	}
	
	@Test
	public void doubleWithF() {
	  
	}

}
