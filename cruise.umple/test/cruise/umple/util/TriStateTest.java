/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license
 
 */

package cruise.umple.util;

import org.junit.*;

public class TriStateTest
{

  @Test
  public void isTrue()
  {
    TriState bool = new TriState(true);
    Assert.assertEquals(false,bool.isTrue());
    Assert.assertEquals(false,bool.isFalse());

    bool.setIsSet(true);
    Assert.assertEquals(true,bool.isTrue());
    Assert.assertEquals(false,bool.isFalse());

    bool.setStatus(false);
    Assert.assertEquals(false,bool.isTrue());
    Assert.assertEquals(true,bool.isFalse());

    bool.setIsSet(false);
    Assert.assertEquals(false,bool.isTrue());
    Assert.assertEquals(false,bool.isFalse());

    bool.setIsSet(true);
    Assert.assertEquals(false,bool.isTrue());
    Assert.assertEquals(true,bool.isFalse());
  }
  
}
