package cruise.vml;

import org.junit.*;

public class VariationPointTest
{
  
  @Test
  public void TestEqualsBasedOnConcern()
  {
    Concern c1 = new Concern("c1");
    Concern c1b= new Concern("c1");
    Concern c2 = new Concern("c2");
    
    VariationPoint vp1 = new VariationPoint("vp1");
    VariationPoint vp2 = new VariationPoint("vp1");
    VariationPoint vp1b = new VariationPoint("vp1");
    
    c1.addVariationPoint(vp1);
    c1b.addVariationPoint(vp1b);

    c2.addVariationPoint(vp2);
    
    Assert.assertEquals(true,c1.equals(c1b));
    Assert.assertEquals(false,c1.equals(c2));

    Assert.assertEquals(false,vp1.equals(vp2));
    Assert.assertEquals(true,vp1.equals(vp1b));
  }

  @Test
  public void TestToString()
  {
    VariationPoint vp = new VariationPoint("vp1");
    Assert.assertEquals("vp1:Optional:",vp.toString());
    
    vp.setCodeSnippet(new CodeSnippet("abc"));
    Assert.assertEquals("vp1:Optional:abc",vp.toString());
  }
  
  @Test
  public void getVariant_byName()
  {
    VariationPoint vp = new VariationPoint("vp1");
    Variant var1 = new Variant("x");
    
    Assert.assertEquals(null, vp.getVariant(null));
    
    Assert.assertEquals(null,vp.getVariant("x"));
    vp.addVariant(var1);
    
    Assert.assertEquals(var1,vp.getVariant("x"));
    
    
  }
}
