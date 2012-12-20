/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license
 
 */

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
