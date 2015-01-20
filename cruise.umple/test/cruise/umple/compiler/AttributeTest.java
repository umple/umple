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
  public void getAllAttributes_none()
  {
    Assert.assertEquals(0, new UmpleClass("Mentor").getAllAttributes().size());
  }

  @Test
  public void getAllAttributes_allMyAttributesIncluded()
  {
    Assert.assertEquals(1, clazz.getAllAttributes().size());
    Assert.assertEquals(attr, clazz.getAllAttributes().get(0));
  }

  @Test
  public void getAllAttributes_allMySuperclassAttributesIncluded()
  {
    UmpleClass superClazz = new UmpleClass("Person");
    Attribute superAttribute = new Attribute("super_a",null,null,null,false,superClazz);
    
    superClazz.addAttribute(superAttribute);
    clazz.setExtendsClass(superClazz);
    
    Assert.assertEquals(2, clazz.getAllAttributes().size());
    Assert.assertEquals(attr, clazz.getAllAttributes().get(1));
    Assert.assertEquals(superAttribute, clazz.getAllAttributes().get(0));
  }

  @Test
  public void getAllAttributes_allMyInfiniteSuperclassAttributesIncluded()
  {
    UmpleClass superClazz = new UmpleClass("Person");
    Attribute superAttribute = new Attribute("super_a",null,null,null,false,superClazz);

    UmpleClass superSuperClazz = new UmpleClass("Person");
    Attribute superSuperAttribute = new Attribute("super_super_a",null,null,null,false,superSuperClazz);
    
    superClazz.addAttribute(superAttribute);
    superSuperClazz.addAttribute(superSuperAttribute);
    
    superClazz.setExtendsClass(superSuperClazz);
    clazz.setExtendsClass(superClazz);
    
    Assert.assertEquals(3, clazz.getAllAttributes().size());
    Assert.assertEquals(attr, clazz.getAllAttributes().get(2));
    Assert.assertEquals(superAttribute, clazz.getAllAttributes().get(1));
    Assert.assertEquals(superSuperAttribute, clazz.getAllAttributes().get(0));
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
