/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

import cruise.umple.compiler.Guard;

public class GuardTest
{

  Guard guard;
  
  @Before
  public void setUp()
  {
    guard = new Guard();
    guard.addExpression(new ConstraintVariable("NAME","x"));
  }
  
  @Test
  public void condition()
  {
    Assert.assertEquals("x",guard.getExpression(0).getValue());
  }
  
  @Test
  public void equalsOnlyCaresAboutCondition()
  {
	Guard guard2 = new Guard();
	guard2.addExpression(new ConstraintVariable("NAME","x"));
    Assert.assertEquals(guard.getExpression(0).getValue(), guard2.getExpression(0).getValue());

	Guard guard3 = new Guard();
	guard3.addExpression(new ConstraintVariable("NAME","y"));
    Assert.assertEquals(false,guard.getExpression(0).getValue().equals(guard3.getExpression(0).getValue()));
  }
  
}
