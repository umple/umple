/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class ConstraintVariableTest
{

  ConstraintVariable expr;
  
  @Before
  public void setUp()
  {
    expr = new ConstraintVariable(null,null);
  }
  
  @Test
  public void getAttributeType()
  {
    Assert.assertEquals(null,expr.getAttributeType());
    UmpleClass clazz = new UmpleClass("xx");
    expr.setFoundAttribute(new Attribute("x","MyType","","",false,clazz));
    Assert.assertEquals("MyType",expr.getAttributeType());
  }
  
}