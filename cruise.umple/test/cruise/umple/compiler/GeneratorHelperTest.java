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
    CodeInjection code = new CodeInjection("before","myOpp","//code");
    all.add(code);
    Assert.assertEquals("//code",GeneratorHelper.toCode(all));
  }

  @Test
  public void toCode_many()
  {
    List<CodeInjection> all = new ArrayList<CodeInjection>();
    all.add(new CodeInjection("before","myOpp","//code"));
    all.add(new CodeInjection("before","myOpp","//code2"));

    Assert.assertEquals("//code\n    //code2",GeneratorHelper.toCode(all));
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
  public void prepare_postpare_traceItem_attribute()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    Attribute attr = new Attribute("name","String",null,null,false);
    TraceItem traceItem = new TraceItem();
    
    traceItem.setUmpleClass(c);
    traceItem.setAttribute(attr);

    Map<String,String> lookups = new HashMap<String,String>();
    lookups.put("setMethod","setX");
    lookups.put("attributeCode","x");
    
    GeneratorHelper.prepareTraceItem(traceItem,lookups);

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
    GeneratorHelper.prepareStringTracer(model,"myblah","extraCode");
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
    GeneratorHelper.prepareStringTracer(model,"myblah","code1");
    GeneratorHelper.prepareStringTracer(model,"myblah2","code2");
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
