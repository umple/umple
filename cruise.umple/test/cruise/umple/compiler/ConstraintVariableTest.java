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

  @Test
  public void equals_null()
  {
    ConstraintVariable compareTo = new ConstraintVariable(null,null);
    Assert.assertEquals(false,expr.equals("donkey"));
    Assert.assertEquals(false,expr.equals(null));
  }

  @Test
  public void equals_empty()
  {
    ConstraintVariable compareTo = new ConstraintVariable(null,null);
    Assert.assertEquals(true,expr.equals(compareTo));
    Assert.assertEquals(true,compareTo.equals(expr));
  }

  @Test
  public void equals_valueAndSubConstraint()
  {
    ConstraintVariable compareTo = new ConstraintVariable(null,"aval");
    Assert.assertEquals(false,expr.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(expr));

    expr.setValue("notval");
    Assert.assertEquals(false,expr.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(expr));

    expr.setValue("aval");
    Assert.assertEquals(true,expr.equals(compareTo));
    Assert.assertEquals(true,compareTo.equals(expr));

    Constraint con = new Constraint();
    expr.setSubConstraint(con);
    Assert.assertEquals(false,expr.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(expr));

    compareTo.setSubConstraint(con);
    Assert.assertEquals(true,expr.equals(compareTo));
    Assert.assertEquals(true,compareTo.equals(expr));
  }
  
}