package cruise.umple.compiler;

import org.junit.*;

public class TraceItemTest
{
  
  TraceItem traceItem;
  
  @Before
  public void setUp()
  {
    traceItem = new TraceItem();
  }

  @Test
  public void attribute()
  {
    Assert.assertEquals(null,traceItem.getAttribute());
    Attribute a = new Attribute("n","String",null,null,false);
    traceItem.setAttribute(a);
    Assert.assertEquals(a,traceItem.getAttribute());
  }

  @Test
  public void umpleClass()
  {
    Assert.assertEquals(null,traceItem.getUmpleClass());
    UmpleClass clazz = new UmpleClass("X");
    traceItem.setUmpleClass(clazz);
    Assert.assertEquals(clazz,traceItem.getUmpleClass());
  }

}
