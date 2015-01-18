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
  Attribute attribute;
  
  @Before
  public void setUp()
  {
    guard = new Guard();
    UmpleModel model = new UmpleModel(null);
    UmpleClass uClass = new UmpleClass("blah",model);
    attribute = new Attribute("x","String","","",false,uClass);
    guard.addElement(new ConstraintAttribute(attribute));
  }
  
  @Test
  public void condition()
  {
    Assert.assertEquals("x",((ConstraintAttribute)guard.getRoot()).getAttribute().getName());
  }
  
  @Test
  public void equalsOnlyCaresAboutCondition()
  {
    Guard guard2 = new Guard();
    guard2.addElement(new ConstraintAttribute(attribute));
    UmpleModel model = new UmpleModel(null);
    JavaGenerator gen = new JavaGenerator();
    gen.setModel(model);
    Assert.assertEquals(guard.getValue(gen), guard2.getValue(gen));

    Guard guard3 = new Guard();
    Attribute y = new Attribute("y","String","","",false,attribute.getUmpleClass());
    guard3.addElement(new ConstraintAttribute(y));
    Assert.assertEquals(false,guard.equals(guard3));
  }
  
}
