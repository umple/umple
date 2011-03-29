package cruise.vml;

import org.junit.*;

public class ConcernTest
{
  
  @Test
  public void ToString()
  {
    Concern c = new Concern("a");
    Assert.assertEquals("a:0 variation points",c.toString());
    
    c.addVariationPoint(new VariationPoint("vp1"));
    Assert.assertEquals("a:1 variation points",c.toString());
    
  }
  
  @Test
  public void getVariationPoint_ByName()
  {
    Concern c = new Concern("a");
    VariationPoint vp1 = new VariationPoint("x");
    
    Assert.assertEquals(null,c.getVariationPoint("blah"));
    c.addVariationPoint(vp1);
    Assert.assertEquals(vp1,c.getVariationPoint("x"));
  }

}
