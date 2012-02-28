/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

public class GeneratorHelper
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GeneratorHelper()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static void postpare(UmpleModel model)
  {
    postpareClass(model);
    postpareStateMachine(model);
    postpareTrace(model);
    
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      postpare(aClass);
    }  
  }

  // Undo all class level internal changes
  private static void postpare(UmpleClass aClass)
  {
    postpareClass(aClass);
    postpareStateMachine(aClass);
    postpareTrace(aClass);
  }
public static void postpareClass(UmpleModel model)
  {
    int maxIndex = model.numberOfUmpleClasses() - 1;
    for (int i=maxIndex; i>=0; i--)
    {
      UmpleClass c = model.getUmpleClass(i);
      if (c.getIsInternal())
      {
        model.removeUmpleClass(c);
      }
    }
  }
  
  // Remove all internally added attributes / associations of a class
  private static void postpareClass(UmpleClass aClass)
  {
    int maxIndex = aClass.numberOfCodeInjections() - 1;
    for (int i=maxIndex; i>=0; i--)
    {
      CodeInjection ci = aClass.getCodeInjection(i);
      if (ci.getIsInternal())
      {
        aClass.removeCodeInjection(ci);
      }
    }
    
    maxIndex = aClass.numberOfDepends() - 1;
    for (int i=maxIndex; i>=0; i--)
    {
      Depend d = aClass.getDepend(i);
      if (d.getIsInternal())
      {
        aClass.removeDepend(d);
      }      
    }  
  }  
  
  public static String toCode(List<CodeInjection> allCodeInjections)
  {
    String asCode = null;
    if (allCodeInjections != null)
    {
      for (CodeInjection inject : allCodeInjections)
      {
        if (asCode == null)
        {
          asCode = inject.getCode();
        }
        else
        {
          asCode = StringFormatter.format("{0}\n    {1}",asCode,inject.getCode());
        }
      }
    }
    return asCode;
  }
private static void postpareStateMachine(UmpleModel aModel)
  {
    
  }

  // Remove all internal state machine entities
  private static void postpareStateMachine(UmpleClass aClass)
  {
    List<State> shouldDelete = new ArrayList<State>();
    for (StateMachine sm : aClass.getAllStateMachines())
    {
      postpareInternalStates(sm,shouldDelete);
    }

    // Remove all internally created actions
    for (StateMachine sm : aClass.getAllStateMachines())
    {
      for (State s : sm.getStates())
      {
        for (int i=s.numberOfTransitions()-1; i>=0; i--)
        {
          Transition t = s.getTransition(i);
          if (t.getIsInternal())
          {
            t.delete();
          }
        }

        for (int i=s.numberOfActions()-1; i>=0; i--)
        {
          Action a = s.getAction(i);
          if (a.getIsInternal())
          {
            s.removeAction(a);
          }
        }
      }
    }
    
    for (int i=shouldDelete.size()-1; i>=0; i--)
    {
      State s = shouldDelete.get(i);
      s.delete();
    }
  }  

  // Add the necessary entry action to delete the object once the final state is reached
  public static void prepareFinalState(StateMachine sm, Map<String,String> lookups)
  {
    for (State s : sm.getStates())
    {
      if (s.isFinalState())
      {
        Action entryAction = new Action(lookups.get("deleteActionCode"));
        entryAction.setIsInternal(true);
        entryAction.setActionType("entry");
        s.addAction(entryAction);
      }
    }
  }  

  // Add the necessary before / after hooks to support nested state machines
  public static void prepareNestedStateMachine(StateMachine sm, int concurrentIndex, Map<String,String> lookups)
  {
    String entryEventName = lookups.get("entryEventName");
    String exitEventName = lookups.get("exitEventName");
    String parentEntryActionCode = lookups.get("parentEntryActionCode");
    String parentExitActionCode = lookups.get("parentExitActionCode");
  
    State parentState = sm.getParentState();
    StateMachine firstSm = parentState.getNestedStateMachine(0);
    State nullState = sm.addState("Null",0);
    nullState.setIsInternal(true);

    if (sm.getStartState() != null)
    {
  
      if (concurrentIndex == 0 && parentExitActionCode != null)
      {
        Action parentExitAction = new Action(parentExitActionCode);
        parentExitAction.setIsInternal(true);
        parentExitAction.setActionType("exit");
        parentState.addAction(parentExitAction,0);
      }

      Event enterEvent = firstSm.findOrCreateEvent(entryEventName);
      enterEvent.setIsInternal(true);
      Transition enterTransition = new Transition(nullState,sm.getStartState());
      enterTransition.setIsInternal(true);
      enterTransition.setEvent(enterEvent);

      Event exitEvent = firstSm.findOrCreateEvent(exitEventName);
      exitEvent.setIsInternal(true);
  
      for (State state : sm.getStates())
      {
        if (state == nullState) { continue; }
        Transition exitTransition = state.addTransition(nullState,0);
        exitTransition.setIsInternal(true);
        exitTransition.setEvent(exitEvent);
      }

      Action parentEntryAction = new Action(parentEntryActionCode);
      parentEntryAction.setActionType("entry");
      parentEntryAction.setIsInternal(true);
      parentState.addAction(parentEntryAction); 
    }  
  }

  // Mark all internal states are ready for deletion
  private static void postpareInternalStates(StateMachine sm, List<State> shouldDelete)
  {
    for (int i=sm.numberOfStates() - 1; i >= 0; i--)
    {
      State s = sm.getState(i);
      if (s.getIsInternal())
      {
        shouldDelete.add(s);
      }       
    }
  }
private static void postpareTrace(UmpleModel aModel)
  {}

  // Currently no internal trace entities to remove at the class level
  private static void postpareTrace(UmpleClass aClass)
  {}
  
  //*********************************************** 
  //*******  Methods dealing with different tracers
  //*********************************************** 
  // Process traces based on tracer selected
  // Current Tracers supported ( Console / File / String ) to be added later ( LTTNG / Dtrace )
  public static void prepareAllTraces(CodeTranslator t, UmpleModel model, UmpleClass aClass, Map<String,String> templateLookups)
  {    
      if ("Console".equals(model.getTraceType()))
      {
    	  prepareConsoleTraces(model,aClass,t,templateLookups);
      }
      else if ("File".equals(model.getTraceType()))
      {
    	  prepareFileTraces(model,aClass,t,templateLookups);
      }
      else if ("String".equals(model.getTraceType()))
      {
    	  prepareStringTraces(model,aClass,t,templateLookups);
      }
  }
  
  // "Console Tracer" Look through all trace directives and inject the necessary code
  private static void prepareConsoleTraces( UmpleModel model, UmpleClass aClass, CodeTranslator t, Map<String,String> templateLookups) 
  {
	  String consoleTemplate = templateLookups.get("consoleTemplate");
	  prepareTraceDirectives(model,aClass,t,consoleTemplate,"console");
  }
  
  // "File Tracer" Look through all trace directives and inject the necessary code
  private static void prepareFileTraces( UmpleModel model, UmpleClass aClass, CodeTranslator t, Map<String,String> templateLookups) 
  {
	  String fileTemplate = templateLookups.get("fileTemplate");  	
	  prepareTraceDirectives(model,aClass,t,fileTemplate,"file");
  }

  // "String Tracer" Look through all traces and inject the necessary code
  private static void prepareStringTraces(UmpleModel model, UmpleClass aClass, CodeTranslator t, Map<String,String> templateLookups) 
  {
	  String stringTemplate = templateLookups.get("stringTemplate");
	  String dependPackage = templateLookups.get("dependPackage");
	  String extraCode = templateLookups.get("extraCode");
	  
	  // Go over each trace directive
	  for (TraceDirective traceDirective : aClass.getTraceDirectives())
	  {
		  Map<String,String> lookups = new HashMap<String,String>();
		  String packageName = model.getDefaultPackage() == null ? "cruise.util" : model.getDefaultPackage();
          lookups.put("packageName",packageName);
          lookups.put("extraCode",extraCode);
          GeneratorHelper.prepareStringTracer(model, lookups);

          if (dependPackage != null && !packageName.equals(aClass.getPackageName()))
          {
            Depend d = new Depend(packageName + ".*");
            d.setIsInternal(true);
            aClass.addDepend(d);
          }
          // if the traceItem is an attribute
          if (traceDirective.hasAttributeTraceItems())
          {
        	  processTraceDirectiveAttributes(model,traceDirective,t,stringTemplate);	 
          }
	  }
  }
  
  //*********************************************** 
  //*******  Methods dealing with Trace Directives
  //*********************************************** 
  // Process all trace directives in an umple class
  private static void prepareTraceDirectives( UmpleModel model, UmpleClass aClass, CodeTranslator t, String template, String tracer) 
  {
	  // Go over each trace directive
	  for (TraceDirective traceDirective : aClass.getTraceDirectives())
	  {  
		  // process trace record if found
		  if( traceDirective.getTraceRecord() != null )
		  {
			  processTraceRecord(model,traceDirective,t,template,tracer);        
		  }
		  // if the traceItem is an attribute
		  else if (traceDirective.hasAttributeTraceItems())
		  {
			  processTraceDirectiveAttributes(model,traceDirective,t,template);		  
		  }
		  // if the traceItem is a state machine
		  else if( traceDirective.hasStateMachineTraceItems() )
		  {
			  processTraceDirectiveStateMachines(traceDirective,t,template,tracer);	
		  }		  	  
	  }
  }

  //**************************************************** 
  //*******  Methods dealing with Attribute Trace Items
  //****************************************************
  // Process every AttributeTraceItem in a trace directive
  private static void processTraceDirectiveAttributes( UmpleModel model, TraceDirective traceDirective, CodeTranslator t, String template ) 
  {	  
	  for( Attribute_TraceItem traceAttr : traceDirective.getAttributeTraceItems() )
	  {
		  // Go over all attributes in attribute trace item
		  for( Attribute attr : traceAttr.getAttributes() )
		  {	  		
			  processAttributeInAttributeTraceItem(model,traceDirective,t,template,traceAttr,attr);
	  	  }
	  }
  }
  
  // Process every Attribute in a AttributeTraceItem based on output language
  private static void processAttributeInAttributeTraceItem( UmpleModel model, TraceDirective traceDirective, CodeTranslator t, String template, Attribute_TraceItem traceAttr, Attribute attr) 
  {	  
	  if( model.getDefaultGenerate().equals("Java"))
	  {
		  JavaGenerator.processAttribute(model,traceDirective,t,template,traceAttr,attr);
	  }
	  if( model.getDefaultGenerate().equals("Php"))
	  {
		  PhpGenerator.processAttribute(model,traceDirective,t,template,traceAttr,attr);
	  }
  }
  
  //********************************************************
  //*******  Methods dealing with State Machines Trace Items
  //********************************************************
  // Process every state machine in a trace directive
  private static void processTraceDirectiveStateMachines( TraceDirective traceDirective, CodeTranslator t, String consoleTemplate, String tracer) 
  {
	  TraceRecord traceRecord = traceDirective.getTraceRecord();

	  for( StateMachine_TraceItem tracedState : traceDirective.getStateMachineTraceItems() )
	  {
		  StateMachine stm = tracedState.getStateMachine();
		  String stmCode = null;
		  
		  if(tracer.equals("console") && tracedState.getTraceStateMachineFlag() )
		  {
			  stmCode = StringFormatter.format(consoleTemplate,prepareConsistentOutput("state",t.translate("stateMachineOne",stm)));
	  		  prepareTraceDirectiveInjectStateMachine(traceDirective,t,stm,stmCode,"before");
	  		  
	  		  stmCode = StringFormatter.format(consoleTemplate,prepareConsistentOutput("state",t.translate("stateMachineOne",stm)));
			  prepareTraceDirectiveInjectStateMachine(traceDirective,t,stm,stmCode,"after");
		  }
		  else if(tracer.equals("file") && tracedState.getTraceStateMachineFlag() )
		  {
			  stmCode = StringFormatter.format(consoleTemplate,"\"status\"+"+t.translate("stateMachineOne",stm));
	  		  prepareTraceDirectiveInjectStateMachine(traceDirective,t,stm,stmCode,"before");
	  		  
	  		  stmCode = StringFormatter.format(consoleTemplate,"\"status\"+"+t.translate("stateMachineOne",stm));
			  prepareTraceDirectiveInjectStateMachine(traceDirective,t,stm,stmCode,"after");
		  }
		  
		  if(tracer.equals("console") && traceRecord != null )
		  {
			  stmCode = "if( " + t.translate("parameterOne",stm) + ".equals(" + t.translate("type",stm) + "." + stm.getState(0).getName() + ") )\n      ";
			  stmCode += StringFormatter.format(consoleTemplate,prepareConsistentOutput("state",t.translate("stateMachineOne",stm)));
	  		  prepareTraceDirectiveInjectStateMachine(traceDirective,t,stm,stmCode,"before");

			  stmCode = "if( " + t.translate("parameterOne",stm) + ".equals(" + t.translate("type",stm) + "." + stm.getState(0).getName() + ") )\n      ";
	  		  stmCode += StringFormatter.format(consoleTemplate,prepareConsistentOutput("state",t.translate("stateMachineOne",stm)));
			  prepareTraceDirectiveInjectStateMachine(traceDirective,t,stm,stmCode,"after");
			  
			  stmCode = "if( " + t.translate("stateMachineOne",stm) + ".equals(" + t.translate("type",stm) + "." + stm.getState(0).getName() + ") )\n      ";
	  		  stmCode += "System.out.println(\"action=" + stm.getState(0).getName() + "-exit" +", " + traceRecord.getRecord() +  "=\" + "+traceRecord.getRecord()+");";
			  tmp(traceDirective,t,stm,stmCode,"after");
		  }
	  }
  }
  
  //*********************************************** 
  //*******  Methods dealing with Trace Record
  //*********************************************** 

  private static void processTraceRecord(UmpleModel model, TraceDirective traceDirective, CodeTranslator t, String template, String tracer) 
  {
	  if( model.getDefaultGenerate().equals("Java"))
	  {
		  if( traceDirective.getTraceRecord().getRecordOnly() )
			  JavaGenerator.processTraceRecord(traceDirective,t,template,tracer);
		  else
		  {
			  processTraceDirectiveAttributes(model,traceDirective,t,template);
			  JavaGenerator.processTraceRecord(traceDirective,t,template,tracer);	
		  }
	  }
	  if( model.getDefaultGenerate().equals("Php"))
	  {
		  if( traceDirective.getTraceRecord().getRecordOnly() )
			  PhpGenerator.processTraceRecord(traceDirective,t,template,tracer);
		  else
		  {
			  processTraceDirectiveAttributes(model,traceDirective,t,template);
			  PhpGenerator.processTraceRecord(traceDirective,t,template,tracer);	
		  }
	  }

  }

  //********************************************************
  //*******  Methods dealing with Code Injections
  //********************************************************
  
  public static void prepareTraceDirectiveAttributeInject( TraceDirective traceDirective, CodeTranslator t, Attribute_TraceItem traceAttr, Attribute attr, String attrCode, String conditionType) 
  {
	  if( traceAttr.getTraceSet() == true && traceAttr.getTraceGet() == false )
		  prepareTraceDirectiveInject(traceDirective,t,attr,attrCode,conditionType,"setMethod");
	  else if( traceAttr.getTraceSet() == false && traceAttr.getTraceGet() == true )
		  prepareTraceDirectiveInject(traceDirective,t,attr,attrCode,conditionType,"getMethod");
	  else if( traceAttr.getTraceSet() == true && traceAttr.getTraceGet() == true )
	  {
		  prepareTraceDirectiveInject(traceDirective,t,attr,attrCode,conditionType,"setMethod");
		  prepareTraceDirectiveInject(traceDirective,t,attr,attrCode,conditionType,"getMethod");
	  }
  }
  
  public static void prepareTraceRecordAttributeInject( TraceDirective traceDirective, CodeTranslator t, Attribute attr, String attrCode, String conditionType) 
  {
	  prepareTraceDirectiveInject(traceDirective,t,attr,attrCode,conditionType,"setMethod");
  }
  
  // Assigns and prepares trace code injection before calling "injectTraceDirective"
  //  + setMethod: What is the name of the setMethod we are attaching the trace to
  //  + attrCode: What is the trace code that should be executed
  public static void prepareTraceDirectiveInject( TraceDirective traceDirective, CodeTranslator t, Attribute attr, String attrCode, String conditionType, String method) 
  {
	  Map<String,String> lookups = new HashMap<String,String>();
	  lookups.put("Code",attrCode);
	  if( method.equals("setMethod") )
		  lookups.put("setMethod",t.translate("setMethod",attr));
	  if( method.equals("getMethod") )
		  lookups.put("getMethod",t.translate("getMethod",attr));
	  String injectionType = "after";
	    
	  if( "where".equals(conditionType) )
		  injectionType = "before";  
	  else if( "until".equals(conditionType) || "after".equals(conditionType) || "giving".equals(conditionType) )
		  injectionType = "after";
	  if( method.equals("setMethod") )
		  injectTraceDirective(traceDirective,lookups,injectionType,"setMethod");
	  if( method.equals("getMethod") )
		  injectTraceDirective(traceDirective,lookups,injectionType,"getMethod");
  }
  
  public static void prepareTraceDirectiveInjectStateMachine( TraceDirective traceDirective, CodeTranslator t, StateMachine stm, String stmCode, String injectionType) 
  {
	  Map<String,String> lookups = new HashMap<String,String>();
	  lookups.put("Code",stmCode);
	  lookups.put("setMethod",t.translate("setMethod",stm));
	  injectTraceDirective(traceDirective,lookups,injectionType,"setMethod");
  }
  
  public static void tmp( TraceDirective traceDirective, CodeTranslator t, StateMachine stm, String stmCode, String injectionType) 
  {
	  Map<String,String> lookups = new HashMap<String,String>();
	  lookups.put("Code",stmCode);
	  lookups.put("exitMethod",t.translate("exitMethod",stm));
	  tmp2(traceDirective,lookups,injectionType);
  }
  public static void tmp2(TraceDirective traceDirective, Map<String,String> lookups, String injectionType)
  {
    UmpleClass aClass = traceDirective.getUmpleClass();
    String setMethod = lookups.get("exitMethod");
    String code = lookups.get("Code");

    CodeInjection set = new CodeInjection(injectionType, setMethod, code);
    set.setIsInternal(true);
    aClass.addCodeInjection(set);  
  }
  // Inject the necessary "before" and "after" hooks to call the trace, this method expects the following action semantic lookups
  //  + setMethod: What is the name of the setMethod we are attaching the trace to
  //  + attributeCode: What is the trace code that should be executed
  public static void injectTraceDirective(TraceDirective traceDirective, Map<String,String> lookups, String injectionType, String method)
  {
    UmpleClass aClass = traceDirective.getUmpleClass();
    String Method = lookups.get(method);
    String code = lookups.get("Code");

    CodeInjection set = new CodeInjection(injectionType, Method, code);
    set.setIsInternal(true);
    aClass.addCodeInjection(set);  
  }

  // Add a StringTracer class to support "String" tracing - typically used for testing, this methods 
  // expects the following action semantic lookups
  //  + packageName: What package should this class belong to?
  //  + extraCode: What is the code required to execute the trace 
  public static void prepareStringTracer(UmpleModel model, Map<String,String> lookups)
  {
    UmpleClass aClass = model.addUmpleClass("StringTracer");
    
    if (aClass.numberOfAttributes() == 0)
    {
      aClass.setIsInternal(true);
      aClass.setIsSingleton(true); 
      aClass.setPackageName(lookups.get("packageName"));
      Attribute traces = new Attribute("traces","String",null,null,false,aClass);
      traces.setIsList(true);
      aClass.appendExtraCode(lookups.get("extraCode"));
    }
    aClass.createGeneratedClass(model);
  }
  
  static String prepareConsistentOutput(String param1, String param2) 
  {
	  String output = StringFormatter.format("\"{0}=\" + {1}",param1,param2);
	  return output;
  }
}