/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
    assertEquals(null,expr.getAttributeType());
    UmpleClass clazz = new UmpleClass("xx");
    expr.setFoundAttribute(new Attribute("x","MyType","","",false,clazz));
    assertEquals("MyType",expr.getAttributeType());
  }

  @Test
  public void equals_null()
  {
    ConstraintVariable compareTo = new ConstraintVariable(null,null);
    assertEquals(false,expr.equals("donkey"));
    assertEquals(false,expr.equals(null));
  }

  @Test
  public void equals_empty()
  {
    ConstraintVariable compareTo = new ConstraintVariable(null,null);
    assertEquals(true,expr.equals(compareTo));
    assertEquals(true,compareTo.equals(expr));
  }

  @Test
  public void equals_valueAndSubConstraint()
  {
    ConstraintVariable compareTo = new ConstraintVariable(null,"aval");
    assertEquals(false,expr.equals(compareTo));
    assertEquals(false,compareTo.equals(expr));

    expr.setValue("notval");
    assertEquals(false,expr.equals(compareTo));
    assertEquals(false,compareTo.equals(expr));

    expr.setValue("aval");
    assertEquals(true,expr.equals(compareTo));
    assertEquals(true,compareTo.equals(expr));

    Constraint con = new Constraint();
    expr.setSubConstraint(con);
    assertEquals(false,expr.equals(compareTo));
    assertEquals(false,compareTo.equals(expr));

    compareTo.setSubConstraint(con);
    assertEquals(true,expr.equals(compareTo));
    assertEquals(true,compareTo.equals(expr));
  }
  
  @Test
  public void isPrimitive_defaultToTrue() {
    assertEquals(true,expr.getIsPrimitive());
  }
  
  @Test
  public void setIsPrimitive_true() {
    expr.setIsPrimitive(true);
    assertEquals(true,expr.getIsPrimitive());
    assertEquals(false,expr.getIsNotPrimitive());
  }
  
  @Test
  public void setIsPrimitive_false() {
    expr.setIsPrimitive(false);
    assertEquals(false,expr.getIsPrimitive());
    assertEquals(true,expr.getIsNotPrimitive());
  }
}