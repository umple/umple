package cruise.patterns.test;

import java.sql.Date;

import org.junit.*;

public class KeysAndHashTest
{
  
  @Test
  public void equals_NotNull()
  {
    Assert.assertEquals(false,(new WidgetC("x")).equals(null));
  }

  @Test
  public void equals_WrongType()
  {
    Assert.assertEquals(false,(new WidgetC("x")).equals(new WidgetB()));
  }
  
  @Test
  public void equals_SameData()
  {
    WidgetB original = new WidgetB();
    WidgetA widget = new WidgetA("blah",1,2.3,true,Date.valueOf("1978-12-01"),original,"ignore");
    WidgetA compareTo = new WidgetA("blah",1,2.3,true,Date.valueOf("1978-12-01"),original,"alsoIgnore");
    Assert.assertEquals(true, widget.equals(compareTo));
    Assert.assertEquals(true, compareTo.equals(widget));
    Assert.assertEquals(widget.hashCode(), compareTo.hashCode());
  }

  @Test
  public void equals_CompareToNull()
  {
    WidgetB original = new WidgetB();
    WidgetA widget = new WidgetA("blah",1,2.3,true,Date.valueOf("1978-12-01"),original,"ignore");
    WidgetA compareToA = new WidgetA(null,1,2.3,true,Date.valueOf("1978-12-01"),original,"alsoIgnore");
    WidgetA compareToB = new WidgetA("blah",1,2.3,true,null,original,"alsoIgnore");
    WidgetA compareToC = new WidgetA("blah",1,2.3,true,Date.valueOf("1978-12-01"),null,"alsoIgnore");
    
    Assert.assertEquals(false, widget.equals(compareToA));
    Assert.assertEquals(false, widget.equals(compareToB));
    Assert.assertEquals(false, widget.equals(compareToC));

    Assert.assertEquals(false, compareToA.equals(widget));
    Assert.assertEquals(false, compareToB.equals(widget));
    Assert.assertEquals(false, compareToC.equals(widget));
  }
  
  @Test
  public void equals_SameNulls()
  {
    WidgetA widget = new WidgetA(null,1,2.3,true,null,null,"ignore");
    WidgetA compareTo = new WidgetA(null,1,2.3,true,null,null,"alsoIgnore");
    
    Assert.assertEquals(true, widget.equals(compareTo));
    Assert.assertEquals(true, compareTo.equals(widget));
  }
  
  @Test
  public void equals_WrongData()
  {
    WidgetB original = new WidgetB();
    WidgetB copy = new WidgetB();
    WidgetA widget = new WidgetA("blah",1,2.3,true,Date.valueOf("1978-12-01"),original,"ignore");
    WidgetA compareToA = new WidgetA("blah2",1,2.3,true,Date.valueOf("1978-12-01"),original,"alsoIgnore");
    WidgetA compareToB = new WidgetA("blah",12,2.3,true,Date.valueOf("1978-12-01"),original,"alsoIgnore");
    WidgetA compareToC = new WidgetA("blah",1,3.3,true,Date.valueOf("1978-12-01"),original,"alsoIgnore");
    WidgetA compareToD = new WidgetA("blah",1,2.3,false,Date.valueOf("1978-12-01"),original,"alsoIgnore");
    WidgetA compareToE = new WidgetA("blah",1,2.3,true,Date.valueOf("1979-12-01"),original,"alsoIgnore");
    WidgetA compareToF = new WidgetA("blah",1,2.3,true,Date.valueOf("1978-12-01"),copy,"alsoIgnore");

    Assert.assertEquals(false, widget.equals(compareToA));
    Assert.assertEquals(false, widget.equals(compareToB));
    Assert.assertEquals(false, widget.equals(compareToC));
    Assert.assertEquals(false, widget.equals(compareToD));
    Assert.assertEquals(false, widget.equals(compareToE));
    Assert.assertEquals(false, widget.equals(compareToF));

    Assert.assertEquals(false, compareToA.equals(widget));
    Assert.assertEquals(false, compareToB.equals(widget));
    Assert.assertEquals(false, compareToC.equals(widget));
    Assert.assertEquals(false, compareToD.equals(widget));
    Assert.assertEquals(false, compareToE.equals(widget));
    Assert.assertEquals(false, compareToF.equals(widget));
  }  
  
  @Test
  public void cannotChangeHashCodeAfterCalling()
  {
    
    WidgetB original = new WidgetB();
    WidgetB copy = new WidgetB();
    
    WidgetA widget = new WidgetA("blah",1,2.3,true,Date.valueOf("1978-12-01"),original,"stuff");
    
    Assert.assertEquals("blah", widget.getId());
    Assert.assertEquals(true,widget.setId("blah2"));
    Assert.assertEquals("blah2",widget.getId());
    
    int hashCode = widget.hashCode();
    Assert.assertEquals(false,widget.setId("blah3"));
    Assert.assertEquals(false,widget.setIntId(2));
    Assert.assertEquals(false,widget.setDoubleId(3.4));
    Assert.assertEquals(false,widget.setBoolId(false));
    Assert.assertEquals(false,widget.setDateId(Date.valueOf("1978-09-21")));
    Assert.assertEquals(false,widget.setWidgetId(copy));

    Assert.assertEquals(true,widget.setIgnore("more stuff"));
    
    Assert.assertEquals("blah2",widget.getId());
    Assert.assertEquals(1,widget.getIntId());
    Assert.assertEquals(2.3,widget.getDoubleId(),0.01);
    Assert.assertEquals(true,widget.getBoolId());
    Assert.assertEquals(original,widget.getWidgetId());
    Assert.assertEquals("more stuff",widget.getIgnore());
    
    Assert.assertEquals(hashCode,widget.hashCode());
  }
  
}
