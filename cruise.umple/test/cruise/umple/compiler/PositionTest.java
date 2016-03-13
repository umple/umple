/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.parser;

import org.junit.*;

public class PositionTest
{

  @Test
  public void notEquals_null()
  {
    Position p = new Position(0,0,0);
    Assert.assertEquals(false,p.equals(null));
    Assert.assertEquals(false,p.equals("blah"));
  }

  @Test
  public void notEquals_position()
  {
    Position p = new Position(0,0,0);
    Position compareTo = new Position(0,1,0);
    Assert.assertEquals(false,p.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(p));
  }
  
  
  @Test
  public void notEquals_lineNumber()
  {
    Position p = new Position(0,0,0);
    Position compareTo = new Position(1,0,0);
    Assert.assertEquals(false,p.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(p));
  }
  
  @Test
  public void notEquals_offset()
  {
    Position p = new Position(0,0,0);
    Position compareTo = new Position(0,0,1);
    Assert.assertEquals(false,p.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(p));
  }  
  
  @Test
  public void equals_all_same()
  {
    Position p = new Position(1,2,2);
    Position compareTo = new Position(1,2,2);
    Assert.assertEquals(true,p.equals(compareTo));
    Assert.assertEquals(true,compareTo.equals(p));
    Assert.assertEquals(true,p.equals(p));
  }
  
  @Test
  public void toStringFromAttributes()
  {
    Position p = new Position(1,2,2);
    Assert.assertEquals("[1,2]", p.toString());
  }
  
  @Test
  public void copy()
  {
    Position p = new Position(1,2,2);
    Position aCopy = p.copy();
    
    Assert.assertEquals(p,aCopy);
    p.setLineNumber(10);
    
    Assert.assertEquals(false,p.equals(aCopy));
    Assert.assertEquals(new Position(1,2,2),aCopy);
  }
  
  @Test
  public void addDoNotDuplicateTheLineNumber()
  {
    Position p = new Position(2,3,10);
    Position more = new Position(4,6,11);
    
    Assert.assertEquals(new Position(5,9,21),p.add(more));
    Assert.assertEquals(new Position(2,3,10),p);
    Assert.assertEquals(new Position(4,6,11),more);
    
  }
  
}
