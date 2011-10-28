/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class UmpleVariableTest
{

  @Test
  public void getUpperCaseName_empty()
  {
    UmpleVariable v = new UmpleVariable("","","","");
    Assert.assertEquals("",v.getUpperCaseName());

    v = new UmpleVariable(null,"","","");
    Assert.assertEquals(null,v.getUpperCaseName());

  }
  
  @Test
  public void getUpperCaseName_oneCharacter()
  {
    UmpleVariable v = new UmpleVariable("x","","","");
    Assert.assertEquals("X",v.getUpperCaseName());
  }  
  
  @Test
  public void getUpperCaseName_manyCharacter()
  {
    UmpleVariable v = new UmpleVariable("xy","","","");
    Assert.assertEquals("Xy",v.getUpperCaseName());

    v = new UmpleVariable("xyZ","","","");
    Assert.assertEquals("XyZ",v.getUpperCaseName());
  }    
  
  @Test
  public void defaultName()
  {
    UmpleVariable v = new UmpleVariable(null,"Student",null,null);
    Assert.assertEquals(null,v.getName());

    v = new UmpleVariable(null,null,null,null);
    Assert.assertEquals(null,v.getName());
  }
}
