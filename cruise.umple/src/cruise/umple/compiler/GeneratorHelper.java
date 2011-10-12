/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

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
  
      if (concurrentIndex == 0)
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
  

  // Look through all traces and inject the necessary code in the after, it requires the following lookups
  //  + consoleTemplate
  //  + stringTemplate
  //  + dependPackage 
  //  + executeMethod
  public static void prepareAllStringTracers(CodeTranslator t, UmpleModel model, UmpleClass aClass, Map<String,String> templateLookups)
  {
    String consoleTemplate = templateLookups.get("consoleTemplate");
    String stringTemplate = templateLookups.get("stringTemplate");
    String dependPackage = templateLookups.get("dependPackage");
    String extraCode = templateLookups.get("extraCode");
    
    // Go over each trac edirective
    for (TraceDirective traceDirective : aClass.getTraceDirectives())
    {
      Map<String,String> lookups = new HashMap<String,String>();
      
      //-- if Console tracer is used, and its the default tracer if no tracer is specified
      if ("Console".equals(model.getTraceType()))
      {
    	// if the traceItem is an attribute
        if (traceDirective.hasAttributes())
        {
        	// Go over all attributes in trace directive
        	for( int i = 0 ; i < traceDirective.numberOfAttributes() ; ++i )
        	{
        		String attrCode = null, conditionType = null;
        		
        		// Process trace directive conditions if it has any 
        		if( traceDirective.hasCondition() )
        		{
        			TraceCondition tc = traceDirective.getCondition(0);
        			if( tc.getConditionType().equals("where") )
        			{
        				attrCode = "if( " + tc.getLhs() + " " + tc.getRhs().getComparisonOperator() + " " + tc.getRhs().getRhs() + " )";
        				conditionType = "where";
        			}
        			else if( tc.getConditionType().equals("until") )
        			{
        				attrCode = "if( " + tc.getLhs() + " " + getComparisonOperatorInverse(tc.getRhs().getComparisonOperator()) + " " + tc.getRhs().getRhs() + " )";
        				conditionType = "until";
        			}
        			else if( tc.getConditionType().equals("after") )
        			{
        				attrCode = "if( " + tc.getLhs() + " " + tc.getRhs().getComparisonOperator() + " " + tc.getRhs().getRhs() + " )";
        				conditionType = "after";
        			}
        			
        			lookups.put("attributeCode",attrCode);
          		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
          		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
        			
        			attrCode = "{";
            		lookups.put("attributeCode",attrCode);
          		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
          		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
          		  	
            		attrCode = "  " + StringFormatter.format(consoleTemplate,t.translate("attribute",traceDirective.getAttribute(i)),t.translate("parameter",traceDirective.getAttribute(i)));
          		  	lookups.put("attributeCode",attrCode);
        		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
        		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
          		  	
          		  	attrCode = "}";
          		  	lookups.put("attributeCode",attrCode);
        		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
        		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
      			
        		}
        		else
        		{
        			// simple trace directive without any extra fragments
            		attrCode = StringFormatter.format(consoleTemplate,t.translate("attribute",traceDirective.getAttribute(i)),t.translate("parameter",traceDirective.getAttribute(i)));
            		lookups.put("attributeCode",attrCode);
          		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
          		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
        		}
        		
        		if( traceDirective.getPeriodClause() != null )
        		{
        			attrCode = "Thread thr1 = new Thread(tracePeriod(" + preparePeriod(traceDirective.getPeriodClause()) + "));\n";
//        			attrCode += StringFormatter.format(consoleTemplate,t.translate("attribute",traceDirective.getAttribute(i)),t.translate("parameter",traceDirective.getAttribute(i)));
            		lookups.put("attributeCode",attrCode);
          		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
          		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
        			attrCode = "thr1.start();\n";
//        			attrCode += StringFormatter.format(consoleTemplate,t.translate("attribute",traceDirective.getAttribute(i)),t.translate("parameter",traceDirective.getAttribute(i)));
            		lookups.put("attributeCode",attrCode);
          		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
          		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
          		  	attrCode = StringFormatter.format(consoleTemplate,t.translate("attribute",traceDirective.getAttribute(i)),t.translate("parameter",traceDirective.getAttribute(i)));
          		  	lookups.put("attributeCode",attrCode);
        		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
        		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
        		}	
        	}	
        }
      }
      //-- if File tracer is used
      else if ("File".equals(model.getTraceType()))
      {
    	// if the traceItem is an attribute
          if (traceDirective.hasAttributes())
          {
          	// Go over all attributes in trace directive
          	for( int i = 0 ; i < traceDirective.numberOfAttributes() ; ++i )
          	{
          		String attrCode = null, conditionType = null;
          		
          		// Process trace directive conditions if it has any 
          		if( traceDirective.hasCondition() )
          		{
          			TraceCondition tc = traceDirective.getCondition(0);
          			if( tc.getConditionType().equals("where") )
          			{
          				attrCode = "if( " + tc.getLhs() + " " + tc.getRhs().getComparisonOperator() + " " + tc.getRhs().getRhs() + " )";
          				conditionType = "where";
          			}
          			else if( tc.getConditionType().equals("until") )
          			{
          				attrCode = "if( " + tc.getLhs() + " " + getComparisonOperatorInverse(tc.getRhs().getComparisonOperator()) + " " + tc.getRhs().getRhs() + " )";
          				conditionType = "until";
          			}
          			else if( tc.getConditionType().equals("after") )
          			{
          				attrCode = "if( " + tc.getLhs() + " " + tc.getRhs().getComparisonOperator() + " " + tc.getRhs().getRhs() + " )";
          				conditionType = "after";
          			}
          			
          			lookups.put("attributeCode",attrCode);
            		lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
            		GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
          			
          			attrCode = "{";
              		lookups.put("attributeCode",attrCode);
            		lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
            		GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
            		  	
            		attrCode = "  fileTracer(" + traceDirective.getAttribute(i).getName() + ");";
            		lookups.put("attributeCode",attrCode);
          		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
          		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
            		  	
            		attrCode = "}";
            		lookups.put("attributeCode",attrCode);
          		  	lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
          		  	GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
        			
          		}
          		else
          		{
          			// simple trace directive without any extra fragments
              		attrCode = "fileTracer(" + traceDirective.getAttribute(i).getName() + ");";
              		lookups.put("attributeCode",attrCode);
            		lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(i)));
            		GeneratorHelper.prepareTraceDirective(traceDirective,lookups,conditionType);
          		}
          	}	
          }
      }
      //-- if String tracer is used
//      else if ("String".equals(model.getTraceType()))
//      {
//        String packageName = model.getDefaultPackage() == null ? "cruise.util" : model.getDefaultPackage();
//        lookups.put("packageName",packageName);
//        lookups.put("extraCode",extraCode);
//        GeneratorHelper.prepareStringTracer(model, lookups);
//        
//        if (dependPackage != null && !packageName.equals(aClass.getPackageName()))
//        {
//          Depend d = new Depend(packageName + ".*");
//          d.setIsInternal(true);
//          aClass.addDepend(d);
//        }
//        if (traceDirective.hasAttributes())
//        {
//        	for( int i = 0 ; i < traceDirective.numberOfAttributes() ; ++i )
//        	{
//                lookups.put("attributeCode",StringFormatter.format(stringTemplate,t.translate("attribute",traceDirective.getAttribute(i)),t.translate("parameter",traceDirective.getAttribute(i))));
//        	}
//        }
//      }
//      if (traceDirective.hasAttributes())
//      {
//    	  for( int i = 0 ; i < traceDirective.numberOfAttributes() ; ++i )
//    	  {
//    		  System.out.println("????");
//    		  lookups.put("setMethod",t.translate("setMethod",traceDirective.getAttribute(0)));
//    	  }
//      }
    }  
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
      Attribute traces = new Attribute("traces","String",null,null,false);
      traces.setIsList(true);
      aClass.addAttribute(traces);
      aClass.appendExtraCode(lookups.get("extraCode"));
    }
    aClass.createGeneratedClass(model);
  }

  // Inject the necessary "before" and "after" hooks to call the trace, this method expects the following action semantic lookups
  //  + setMethod: What is the name of the setMethod we are attaching the trace to
  //  + attributeCode: What is the trace code that should be executed
  public static void prepareTraceDirective(TraceDirective traceDirective, Map<String,String> lookups, String conditionType)
  {
    UmpleClass aClass = traceDirective.getUmpleClass();
    String setMethod = lookups.get("setMethod");
    String code = lookups.get("attributeCode");
    String injectionType = "after";
    
    if( "where".equals(conditionType) )
    	injectionType = "before";
    else if( "until".equals(conditionType) || "after".equals(conditionType) )
    	injectionType = "after";

    CodeInjection set = new CodeInjection(injectionType, setMethod, code);
    set.setIsInternal(true);
    aClass.addCodeInjection(set);  
  }
  
  private static String getComparisonOperatorInverse(String co) {
	  if( co.equals("==") ) return "!=";
	  else if( co.equals("!=") ) return "==";
	  else if( co.equals(">") ) return "<=";
	  else if( co.equals("<") ) return ">=";
	  else if( co.equals(">=") ) return "<";
	  else if( co.equals("<=") ) return ">";
	  
	  return null;
  }
  
  private static String preparePeriod(String periodClause) {
	  
	  // split periodClause into two strings (1) contains numeric time (2) contains time unit
	  String[] period = periodClause.split("s|m");
	  
	  // ToDo return time depending on kind of unit used (second or millisecond)
	  return period[0];
  }
}