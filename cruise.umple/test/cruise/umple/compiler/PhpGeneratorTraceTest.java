package cruise.umple.compiler;

import org.junit.*;

public class PhpGeneratorTraceTest
{

  UmpleModel model;
  PhpGenerator generator;

  @Before
  public void setUp()
  {
    model = new UmpleModel(null);
    generator = new PhpGenerator();
    generator.setModel(model);
  }
  
  
  @Test
  public void prepare_postpare_traceItem_attribute()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    Attribute attr = new Attribute("name","String",null,null,false);
    TraceItem traceItem = new TraceItem();
    
    traceItem.setUmpleClass(c);
    traceItem.setAttribute(attr);
    generator.prepare();

    Assert.assertEquals(1,c.numberOfCodeInjections());
    CodeInjection inject = c.getCodeInjection(0);
    Assert.assertEquals("after",inject.getType());
    Assert.assertEquals("setName", inject.getOperation());
    Assert.assertEquals("print(\"name={$aName}\");",inject.getCode());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,c.numberOfCodeInjections());
  }   
  
  @Test
  public void prepare_postpare_traceItem_attribute_string()
  {
    model.setTraceType("String");
    model.setDefaultPackage("blah");
    
    UmpleClass c = model.addUmpleClass("LightFixture");
    c.setPackageName("notblah");
    Attribute attr = new Attribute("name","String",null,null,false);
    TraceItem traceItem = new TraceItem();
    
    traceItem.setUmpleClass(c);
    traceItem.setAttribute(attr);
    generator.prepare();

    Assert.assertEquals(2,model.numberOfUmpleClasses());
    UmpleClass c2 = model.getUmpleClass("StringTracer");
    Assert.assertEquals(true,c2.getIsInternal());
    Assert.assertEquals("traces",c2.getAttribute(0).getName());
    
    Assert.assertEquals(1,c.numberOfCodeInjections());
    CodeInjection inject = c.getCodeInjection(0);
    Assert.assertEquals("after",inject.getType());
    Assert.assertEquals("setName", inject.getOperation());
    Assert.assertEquals("StringTracer::execute(\"name={$aName}\");",inject.getCode());
    Assert.assertEquals(0,c.numberOfDepends());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,c.numberOfCodeInjections());
    Assert.assertEquals(1,model.numberOfUmpleClasses());
    Assert.assertEquals(0, c.numberOfDepends());
  }  
 
}
