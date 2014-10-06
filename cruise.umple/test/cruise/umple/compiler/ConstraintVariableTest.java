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
  
  ConstraintAttribute expr;
  Attribute attribute;
  UmpleClass uClass;
	
  @Before
  public void setUp()
  {
    uClass = new UmpleClass("blah",new UmpleModel(null));
    attribute = new Attribute("x","Integer","","",false,uClass);
    expr = new ConstraintAttribute(null);
  }
  
  @Test
  public void getAttributeType()
  {
	  
    assertEquals(null,expr.getAttribute());
    UmpleClass clazz = new UmpleClass("xx");
    expr.setAttribute(new Attribute("x","MyType","","",false,clazz));
    assertEquals("MyType",expr.getAttribute().getType());
  }

  @Test
  public void equals_null()
  {
    ConstraintAttribute compareTo = new ConstraintAttribute(null);
    assertEquals(false,expr.equals("donkey"));
    assertEquals(false,expr.equals(null));
  }

  @Test
  public void equals_empty()
  {
    ConstraintAttribute compareTo = new ConstraintAttribute(null);
    assertEquals(true,expr.equals(compareTo));
    assertEquals(true,compareTo.equals(expr));
  }

  @Test
  public void equals_concernAboutHash()
  {
    assertEquals(true,new ConstraintOperator("+").equals(new ConstraintOperator("+")));
  }

  @Test
  public void equals_valueAndSubConstraint()
  {
	Attribute aval = new Attribute("aval","Integer","","",false,uClass);
    ConstraintVariable compareTo = new ConstraintAttribute(aval);
    assertEquals(false,expr.equals(compareTo));
    assertEquals(false,compareTo.equals(expr));

    Attribute notval = new Attribute("notval","Integer","","",false,uClass);
    expr.setAttribute(notval);
    assertEquals(false,expr.equals(compareTo));
    assertEquals(false,compareTo.equals(expr));

    expr.setAttribute(uClass.getAttribute("aval"));
    assertEquals(true,expr.equals(compareTo));
    assertEquals(true,compareTo.equals(expr));

    ConstraintTree tree = new ConstraintTree();
    tree.addElement(expr);
    assertEquals(false,tree.equals(compareTo));
    assertEquals(false,compareTo.equals(tree));

    ConstraintTree tree2 = new ConstraintTree();
    tree2.addElement(compareTo);
    assertEquals(true,tree.equals(tree2));
    assertEquals(true,tree2.equals(tree));
  }
}