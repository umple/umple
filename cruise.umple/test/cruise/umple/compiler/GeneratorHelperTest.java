/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

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
  
  @Test
  public void prepare_postpare_traceDirective_attribute()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    Attribute attr = new Attribute("name","String",null,null,false,c);
    TraceDirective traceDirective = new TraceDirective();
    
    traceDirective.setUmpleClass(c);
    Attribute_TraceItem traceAttr = new Attribute_TraceItem(traceDirective);
    traceAttr.addAttribute(attr);
    traceDirective.addAttributeTraceItem(traceAttr);

    Map<String,String> lookups = new HashMap<String,String>();
    lookups.put("setMethod","setX");
    lookups.put("Code","x");
    
    GeneratorHelper.injectTraceDirective(traceDirective, lookups, "after", "setMethod");

    Assert.assertEquals(1,c.numberOfCodeInjections());
    CodeInjection inject = c.getCodeInjection(0);
    Assert.assertEquals("after",inject.getType());
    Assert.assertEquals("setX", inject.getOperation());
    Assert.assertEquals("x",inject.getCode());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,c.numberOfCodeInjections());
  }  

  @Test
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
    lookups.put("packageName","myblah");
    lookups.put("extraCode","code1");

    Map<String,String> lookups2 = new HashMap<String,String>();
    lookups2.put("packageName","myblah2");
    lookups2.put("extraCode","code2");
    
    GeneratorHelper.prepareStringTracer(model,lookups);
    GeneratorHelper.prepareStringTracer(model,lookups2);
    Assert.assertEquals(1,model.numberOfUmpleClasses());
    UmpleClass c = model.getUmpleClass("StringTracer");
    
    Assert.assertEquals(1,c.numberOfAttributes());
    Assert.assertEquals("code1",c.getExtraCode());
    Assert.assertEquals("myblah",c.getPackageName());
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
    lookups.put("entryEventName","eEntry");
    lookups.put("exitEventName","eExit");
    lookups.put("parentEntryActionCode","pEntry");
    lookups.put("parentExitActionCode","pExit");
    
    GeneratorHelper.prepareNestedStateMachine(nestedSm, 0,lookups);
    Assert.assertEquals(2,onState.numberOfActions());

    Assert.assertEquals("Null",nestedSm.getState(0).getName());
    Assert.assertEquals("Normal",nestedSm.getStartState().getName());
    
    Assert.assertEquals("exit",onState.getAction(0).getActionType());
    Assert.assertEquals("pExit",onState.getAction(0).getActionCode());
    
    Assert.assertEquals("entry",onState.getAction(1).getActionType());
    Assert.assertEquals("pEntry",onState.getAction(1).getActionCode());
    
    Assert.assertNotNull(nestedSm.getEvent("eEntry"));
    Assert.assertNotNull(nestedSm.getEvent("eExit"));
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,onState.numberOfActions());
  }
  

}
