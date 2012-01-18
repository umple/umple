/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class JavaGeneratorTraceTest
{

  UmpleModel model;
  JavaGenerator generator;
  String umpleParserName;

  @Before
  public void setUp()
  {
    model = new UmpleModel(null);
    generator = new JavaGenerator();
    generator.setModel(model);
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
  }
  
  @Test @Ignore
  public void prepare_postpare_traceDirective_attribute()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    Attribute attr = new Attribute("name","String",null,null,false);
    TraceDirective traceDirective = new TraceDirective();
    
    traceDirective.setUmpleClass(c);
    Attribute_TraceItem traceAttr = new Attribute_TraceItem(traceDirective);
    traceAttr.addAttribute(attr);
    traceDirective.addAttributeTraceItem(traceAttr);
    generator.prepare();

    Assert.assertEquals(1,c.numberOfCodeInjections());
    CodeInjection inject = c.getCodeInjection(0);
    Assert.assertEquals("after",inject.getType());
    Assert.assertEquals("setName", inject.getOperation());
    Assert.assertEquals("System.out.println(\"name=\" + aName);",inject.getCode());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,c.numberOfCodeInjections());
  }    
  
  @Test @Ignore
  public void prepare_traceDirective_attribute_string_default_package()
  {
    model.setTraceType("String");
    
    UmpleClass c = model.addUmpleClass("LightFixture");
    c.setPackageName("notblah");
    Attribute attr = new Attribute("name","String",null,null,false);
    TraceDirective traceDirective = new TraceDirective();
    
    traceDirective.setUmpleClass(c);
    Attribute_TraceItem traceAttr = new Attribute_TraceItem(traceDirective);
    traceAttr.addAttribute(attr);
    traceDirective.addAttributeTraceItem(traceAttr);
    generator.prepare();

    Assert.assertEquals(1,model.numberOfUmpleClasses());
    UmpleClass c2 = model.getUmpleClass("StringTracer");
    Assert.assertEquals("cruise.util",c2.getPackageName());
    
    Assert.assertEquals(1,c.numberOfCodeInjections());
    Assert.assertEquals("cruise.util.*",c.getDepend(0).getName());
  }    
  
  @Test @Ignore
  public void prepare_postpare_traceDirective_attribute_string()
  {
    model.setTraceType("Console");
    model.setDefaultPackage("blah");
    
    UmpleClass c = model.addUmpleClass("LightFixture");
    c.setPackageName("notblah");
    Attribute attr = new Attribute("name","String",null,null,false);
    TraceDirective traceDirective = new TraceDirective();
    
    traceDirective.setUmpleClass(c);
    Attribute_TraceItem traceAttr = new Attribute_TraceItem(traceDirective);
    traceAttr.addAttribute(attr);
    traceDirective.addAttributeTraceItem(traceAttr);
    generator.prepare();

    Assert.assertEquals(1,model.numberOfUmpleClasses());
    UmpleClass c2 = model.getUmpleClass("LightFixture");
    Assert.assertEquals(false,c2.getIsInternal());
    Assert.assertEquals("traces",c2.getAttribute(0).getName());
    
    Assert.assertEquals(1,c.numberOfCodeInjections());
    CodeInjection inject = c.getCodeInjection(0);
    Assert.assertEquals("after",inject.getType());
    Assert.assertEquals("setName", inject.getOperation());
    Assert.assertEquals("StringTracer.execute(\"name=\" + aName);",inject.getCode());
    Assert.assertEquals("blah.*",c.getDepend(0).getName());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,c.numberOfCodeInjections());
    Assert.assertEquals(1,model.numberOfUmpleClasses());
    Assert.assertEquals(0, c.numberOfDepends());
  }   
  
  @Test
  public void prepare_postpare_traceDirective_attribute_string_samePackage()
  {
    model.setTraceType("Console");
    model.setDefaultPackage("blah");
    
    UmpleClass c = model.addUmpleClass("LightFixture");
    c.setPackageName("blah");
    Attribute attr = new Attribute("name","String",null,null,false);
    TraceDirective traceDirective = new TraceDirective();
    
    traceDirective.setUmpleClass(c);
    Attribute_TraceItem traceAttr = new Attribute_TraceItem(traceDirective);
    traceAttr.addAttribute(attr);
    traceDirective.addAttributeTraceItem(traceAttr);
    generator.prepare();

    Assert.assertEquals(0,c.numberOfDepends());
  } 

}
