package cruise.umple.compiler;

import org.junit.*;

public class CoordinateTest
{

  @Test
  public void equalsObjects()
  {
    Coordinate c = new Coordinate(1,2,3,4);
    Assert.assertEquals(false,c.equals(null));
    Assert.assertEquals(false,c.equals("not a coordinate"));
  }
  
  @Test
  public void equalsCheckAllData()
  {
    Coordinate c = new Coordinate(1,2,3,4);
    Coordinate c2 = new Coordinate(1,2,3,5);
    Coordinate c3 = new Coordinate(1,2,5,4);
    Coordinate c4 = new Coordinate(1,4,3,4);
    Coordinate c5 = new Coordinate(5,2,3,4);
    Coordinate c6 = new Coordinate(1,2,3,4);
    
    Assert.assertEquals(c, c6);
    Assert.assertEquals(c, c);
    Assert.assertEquals(false, c.equals(c2));
    Assert.assertEquals(false, c.equals(c3));
    Assert.assertEquals(false, c.equals(c4));
    Assert.assertEquals(false, c.equals(c5));
    
  }
  
  @Test
  public void getCorners()
  {
    Coordinate c = new Coordinate(10,20,30,40);
    Assert.assertEquals(new Point(10,20),c.getTopLeft());
    Assert.assertEquals(new Point(40,20),c.getTopRight());
    Assert.assertEquals(new Point(10,60),c.getBottomLeft());
    Assert.assertEquals(new Point(40,60),c.getBottomRight());

    Assert.assertEquals(new Point(25,20),c.getTopMiddle());
    Assert.assertEquals(new Point(25,60),c.getBottomMiddle());
    Assert.assertEquals(new Point(40,40),c.getRightMiddle());
    Assert.assertEquals(new Point(10,40),c.getLeftMiddle());
    
  }
  
  @Test
  public void whereIs_simple()
  {
    Coordinate c = new Coordinate(0,0,10,10);
    
    Assert.assertEquals("top",c.whereIs(new Coordinate(0,-20,10,10)));
    Assert.assertEquals("left",c.whereIs(new Coordinate(-20,0,10,10)));
    Assert.assertEquals("right",c.whereIs(new Coordinate(20,0,10,10)));
    Assert.assertEquals("bottom",c.whereIs(new Coordinate(0,20,10,10)));
  }
  
  @Test
  public void whereIs_complexTop()
  {
    Coordinate c = new Coordinate(0,0,5,10);
    
    Assert.assertEquals("top",c.whereIs(new Coordinate(-4,-15,5,10)));
    Assert.assertEquals("top",c.whereIs(new Coordinate(4,-15,5,10)));
    Assert.assertEquals("left",c.whereIs(new Coordinate(-6,-15,5,10)));
    Assert.assertEquals("right",c.whereIs(new Coordinate(6,-15,5,10)));
  }  

  @Test
  public void whereIs_complexBottom()
  {
    Coordinate c = new Coordinate(0,0,5,10);
    
    Assert.assertEquals("bottom",c.whereIs(new Coordinate(-4,15,5,10)));
    Assert.assertEquals("bottom",c.whereIs(new Coordinate(4,15,5,10)));
    Assert.assertEquals("left",c.whereIs(new Coordinate(-6,15,5,10)));
    Assert.assertEquals("right",c.whereIs(new Coordinate(6,15,5,10)));
  }   
  
  @Test
  public void status()
  {
	Coordinate c1 = new Coordinate(-1,-1,-1,-1);
	Assert.assertEquals(Coordinate.Status.Undefined, c1.getStatus());
	
	Coordinate c2 = new Coordinate(1,2,3,4);
	Assert.assertEquals(Coordinate.Status.Explicit, c2.getStatus());
	
	c1.setX(5);
	c1.setY(-1);
	Assert.assertEquals(Coordinate.Status.Explicit, c1.getStatus());
	
	c2.setX(-1);
	c2.setY(-1);
	c2.setWidth(-1);
	c2.setHeight(-1);
	Assert.assertEquals(Coordinate.Status.Undefined, c2.getStatus());
	
	c1.setStatus(Coordinate.Status.Defaulted);
	Assert.assertEquals(Coordinate.Status.Defaulted, c1.getStatus());
	
	c1.setX(5);
	Assert.assertEquals(Coordinate.Status.Explicit, c1.getStatus());
	
	c2.setX(-1);
	Assert.assertEquals(Coordinate.Status.Undefined, c2.getStatus());
  }
  
  @Test
  public void distanceTo()
  {
    Coordinate c1 = new Coordinate(1,2,0,0);
    Coordinate c2 = new Coordinate(5,6,0,0);
    Assert.assertEquals(6, c1.distanceTo(c2));
    Assert.assertEquals(6, c2.distanceTo(c1));
  }

}
