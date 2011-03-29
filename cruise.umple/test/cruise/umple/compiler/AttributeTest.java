package cruise.umple.compiler;

import org.junit.*;

public class AttributeTest
{

  @Test
  public void getName()
  {
    Attribute v;
    
    v = new Attribute(null, "MyType", "", "", true);
    Assert.assertEquals(null, v.getName());
  }
  
  @Test
  public void TypesIsANormalVariableNow()
  {
    Attribute v;
    
    v = new Attribute("a", "Blah", "", "", true);
    Assert.assertEquals("Blah", v.getType());
  }
  
  @Test
  public void isConstant()
  {
    Attribute v;
    
    v = new Attribute("a","Blah","const","1",false);
    Assert.assertEquals(true, v.isConstant());

    v = new Attribute("a","Blah","notconst","1",false);
    Assert.assertEquals(false, v.isConstant());
    
  }
  
  @Test
  public void isPrimitive()
  {
    Attribute av;
    
    av = new Attribute("a",null,null,null,false);
    Assert.assertEquals(true,av.isPrimitive());

    av.setType("String");
    Assert.assertEquals(true,av.isPrimitive());

    av.setType("Integer");
    Assert.assertEquals(true,av.isPrimitive());
    av.setType("Double");
    Assert.assertEquals(true,av.isPrimitive());
    av.setType("Boolean");
    Assert.assertEquals(true,av.isPrimitive());
    av.setType("Date");
    Assert.assertEquals(true,av.isPrimitive());
    av.setType("Time");
    Assert.assertEquals(true,av.isPrimitive());

    av.setType("Address");
    Assert.assertEquals(false,av.isPrimitive());
    
  }
}
