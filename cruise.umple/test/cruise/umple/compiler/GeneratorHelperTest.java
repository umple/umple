/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

import cruise.umple.compiler.GeneratorHelper;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleModel;

import java.util.*;

public class GeneratorHelperTest
{
  @Test
  public void toCode_none()
  {
    Assert.assertEquals(null,GeneratorHelper.toCode(null));
    Assert.assertEquals(null,GeneratorHelper.toCode(new ArrayList<CodeInjection>()));
  }
  
  @Test
  public void toCode_one()
  {
    List<CodeInjection> all = new ArrayList<CodeInjection>();
    CodeInjection code = new CodeInjection("before","myOpp","//code",new UmpleClass("test"));
    all.add(code);
    Assert.assertEquals("//code",GeneratorHelper.toCode(all));
  }

  @Test
  public void toCode_many()
  {
    List<CodeInjection> all = new ArrayList<CodeInjection>();
    all.add(new CodeInjection("before","myOpp","//code",new UmpleClass("test")));
    all.add(new CodeInjection("before","myOpp","//code2",new UmpleClass("test")));

    Assert.assertEquals("//code\n//code2",GeneratorHelper.toCode(all));
  }

  GeneratorHelper helper;
  UmpleModel model;
  CodeGenerator generator;

  @Before
  public void setUp()
  {
    helper = new GeneratorHelper();
    
    model = new UmpleModel(null);
    generator = new JavaGenerator();
    generator.setModel(model);
  }
  
  @Test @Ignore
  public void prepare_postpare_traceDirective_attribute()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    Attribute attr = new Attribute("name","String",null,null,false,c);
    TraceDirective traceDirective = new TraceDirective(model.getTracer());
    
    traceDirective.setUmpleClass(c);
    AttributeTraceItem traceAttr = new AttributeTraceItem(traceDirective);
    traceAttr.addAttribute(attr);
    traceDirective.addAttributeTraceItem(traceAttr);

    Map<String,String> lookups = new HashMap<String,String>();
    lookups.put("setMethod","setX");
    lookups.put("Code","x");
    
   // GeneratorHelper.injectTraceDirective(traceDirective, lookups, "after", "setMethod");

    Assert.assertEquals(1,c.numberOfCodeInjections());
    CodeInjection inject = c.getCodeInjection(0);
    Assert.assertEquals("after",inject.getType());
    Assert.assertEquals("setX", inject.getOperation());
    Assert.assertEquals("x",inject.getCode());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,c.numberOfCodeInjections());
  }  

  @Test @Ignore
  public void prepare_StringTracer()
  {
    Map<String,String> lookups = new HashMap<String,String>();
    lookups.put("packageName","myblah");
    lookups.put("extraCode","extraCode");
    
    GeneratorHelper.prepareStringTracer(model,lookups);
    Assert.assertEquals(1,model.numberOfUmpleClasses());
    UmpleClass c = model.getUmpleClass("StringTracer");
    
    Assert.assertNotNull(c.getGeneratedClass());
    Assert.assertEquals(true,c.getIsSingleton());
    Assert.assertEquals(true,c.getIsInternal());
    Assert.assertEquals("traces",c.getAttribute(0).getName());
    Assert.assertEquals("extraCode",c.getExtraCode());
    Assert.assertEquals("myblah",c.getPackageName());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,model.numberOfUmpleClasses());
  }
  
  @Test
  public void prepare_StringTracerOnlyOnce()
  {
    Map<String,String> lookups = new HashMap<String,String>();
    String executeMethods = "public static void handle(String message) { getInstance().addTrace(message); }\n";
	executeMethods += "public void reset() { getInstance().traces.clear(); }";
	lookups.put("packageName","cruise.util");
	lookups.put("dependTracer","cruise.util.{0}Tracer");
	lookups.put("dependDate","java.util.Date");
	lookups.put("stringTracer",executeMethods);
	lookups.put("startTime","(int)System.currentTimeMillis()");
	
    UmpleClass uClass1 = new UmpleClass("firstClass",model);
    uClass1.addTraceDirective(new TraceDirective(new TracerDirective("string")));
    UmpleClass uClass2 = new UmpleClass("secondClass",model);
    uClass2.addTraceDirective(new TraceDirective(new TracerDirective("string")));
    model.setTracer(new TracerDirective("string"));
    model.addUmpleClass(uClass1);
    model.addUmpleClass(uClass2);
    Assert.assertEquals(true,GeneratorHelper.getWillGenerateString());
    GeneratorHelper.prepareAllTracers(null, model, uClass1, lookups);
    Assert.assertEquals(false,GeneratorHelper.getWillGenerateString());
    GeneratorHelper.prepareAllTracers(null, model, uClass2, lookups);
    Assert.assertEquals(3,model.numberOfUmpleClasses());
    //UmpleClass c = model.getUmpleClass("StringTracer");
    
    //Assert.assertEquals(1,c.numberOfAttributes());
    //Assert.assertEquals("code1",c.getExtraCode());
    //Assert.assertEquals("myblah",c.getPackageName());
  }


  @Test
  public void prepare_nestedStateMachine()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    StateMachine sm = new StateMachine("bulb");
    StateMachine nestedSm = new StateMachine("On");

    sm.setUmpleClass(c);
    
    State onState = new State("On",sm);
    onState.addNestedStateMachine(nestedSm);
    State normalState = new State("Normal",nestedSm);
    normalState.setIsStartState(true);

    Map<String,String> lookups = new HashMap<String,String>();
    lookups.put("setSmToNullExitActionCode", "setBulbOn(BulbOn.Null);");
    lookups.put("parentEntryActionCode","pEntry");
    lookups.put("parentExitActionCode","exitBulbOn();");
    
    GeneratorHelper.prepareNestedStateMachine(nestedSm, 0,lookups);
    Assert.assertEquals(2,onState.numberOfActions());

    Assert.assertEquals("Null",nestedSm.getState(0).getName());
    Assert.assertEquals("Normal",nestedSm.getStartState().getName());
    
    // Issue 935
    Assert.assertEquals("exit",onState.getAction(0).getActionType());
    Assert.assertEquals("exitBulbOn();",onState.getAction(0).getActionCode());
    
    Assert.assertEquals("entry",onState.getAction(1).getActionType());
    Assert.assertEquals("pEntry",onState.getAction(1).getActionCode());
    
    // Issue 935
    Assert.assertEquals("exit", normalState.getAction(0).getActionType());
    Assert.assertEquals("setBulbOn(BulbOn.Null);", normalState.getAction(0).getActionCode());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(1,onState.numberOfActions());
  }
  

}
