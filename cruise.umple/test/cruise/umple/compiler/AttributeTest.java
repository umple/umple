/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class AttributeTest
{
  
  UmpleClass clazz;
  Attribute attr;
  
  @Before
  public void setUp()
  {
    clazz = new UmpleClass("Student");
    attr = new Attribute("a",null,null,null,false,clazz);
  }
  
  @Test
  public void getName()
  {
    Assert.assertEquals("a", attr.getName());
  }
  
  @Test
  public void TypesIsANormalVariableNow()
  {
    attr = new Attribute("a", "Blah", "", "", true,clazz);
    Assert.assertEquals("Blah", attr.getType());
  }
  
  @Test
  public void isConstant()
  {
    attr = new Attribute("a","Blah","const","1",false,clazz);
    Assert.assertEquals(true, attr.isConstant());

    attr = new Attribute("a","Blah","notconst","1",false,clazz);
    Assert.assertEquals(false, attr.isConstant());
    
  }
  
  @Test
  public void isPrimitive()
  {
    Assert.assertEquals(true,attr.isPrimitive());

    attr.setType("String");
    Assert.assertEquals(true,attr.isPrimitive());

    attr.setType("Integer");
    Assert.assertEquals(true,attr.isPrimitive());
    attr.setType("Double");
    Assert.assertEquals(true,attr.isPrimitive());
    attr.setType("Boolean");
    Assert.assertEquals(true,attr.isPrimitive());
    attr.setType("Date");
    Assert.assertEquals(true,attr.isPrimitive());
    attr.setType("Time");
    Assert.assertEquals(true,attr.isPrimitive());

    attr.setType("Address");
    Assert.assertEquals(false,attr.isPrimitive());
    
  }
  
  @Test
  public void isImmutable()
  {
    Assert.assertEquals(false, attr.isImmutable());
    
    attr.setModifier("immutable");
    Assert.assertEquals(true, attr.isImmutable());
  }
  
  @Test
  public void isImmutableBasedOnClass()
  {
    UmpleClass c = new UmpleClass("Student");
    c.addAttribute(attr);
    
    Assert.assertEquals(false, attr.isImmutable());
    
    attr.setModifier("immutable");
    Assert.assertEquals(true, attr.isImmutable());
        
    c.setImmutable();
    Assert.assertEquals(true, attr.isImmutable());
    
    attr.setModifier(null);    
    Assert.assertEquals(true, attr.isImmutable());
  }
}
