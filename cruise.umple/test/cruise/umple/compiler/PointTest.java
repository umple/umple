/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class PointTest
{

  @Test
  public void equals_null()
  {
    Point p = new Point(1,2);
    Assert.assertEquals(false,p.equals(null));
    Assert.assertEquals(false,p.equals("not a point"));
  }
  @Test
  public void equals_okay()
  {
    Point p = new Point(1,2);
    Point p2 = new Point(1,3);
    Point p3 = new Point(3,2);
    Point p4 = new Point(1,2);
    
    Assert.assertEquals(p, p4);
    Assert.assertEquals(false, p.equals(p2));
    Assert.assertEquals(false, p.equals(p3));
  }
  
  @Test
  public void create()
  {
    Assert.assertEquals(new Point(1,1),Point.create(0));
    
    Assert.assertEquals(new Point(1,2),Point.create(1));
    Assert.assertEquals(new Point(2,2),Point.create(2));
    Assert.assertEquals(new Point(2,1),Point.create(3));
    
    Assert.assertEquals(new Point(1,3),Point.create(4));
    Assert.assertEquals(new Point(2,3),Point.create(5));
    Assert.assertEquals(new Point(3,3),Point.create(6));
    Assert.assertEquals(new Point(3,1),Point.create(7));
    Assert.assertEquals(new Point(3,2),Point.create(8));

    Assert.assertEquals(new Point(1,4),Point.create(9));
    Assert.assertEquals(new Point(2,4),Point.create(10));
    Assert.assertEquals(new Point(3,4),Point.create(11));
    Assert.assertEquals(new Point(4,4),Point.create(12));
    Assert.assertEquals(new Point(4,1),Point.create(13));
    Assert.assertEquals(new Point(4,2),Point.create(14));
    Assert.assertEquals(new Point(4,3),Point.create(15));
  }
  
}
