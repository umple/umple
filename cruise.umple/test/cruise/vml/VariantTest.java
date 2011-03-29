package cruise.vml;

import org.junit.*;

public class VariantTest
{

  @Test
  public void TestToString()
  {
    Variant v = new Variant("x");
    Assert.assertEquals("x",v.toString());
    v.setName(null);
    Assert.assertEquals("",v.toString());
  }
  
}
