/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

/**
 * @umplesource Generator.ump 37
 * @umplesource GeneratorHelper_Code.ump 20
 * @umplesource GeneratorHelper_CodeClass.ump 16
 * @umplesource GeneratorHelper_CodeStateMachine.ump 16
 * @umplesource GeneratorHelper_CodeTrace.ump 16
 */
// line 37 "../../../../src/Generator.ump"
// line 20 "../../../../src/GeneratorHelper_Code.ump"
// line 16 "../../../../src/GeneratorHelper_CodeClass.ump"
// line 16 "../../../../src/GeneratorHelper_CodeStateMachine.ump"
// line 16 "../../../../src/GeneratorHelper_CodeTrace.ump"
public class GeneratorHelper
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
  //  @umplesourcefile(line={25},file={"GeneratorHelper_Code.ump"},javaline={47},length={433})
  @umplesourcefile(line={26},file={"GeneratorHelper_Code.ump"},javaline={48},length={11})
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
  @umplesourcefile(line={39},file={"GeneratorHelper_Code.ump"},javaline={62},length={6})
  private static void postpare(UmpleClass aClass)
  {
    postpareClass(aClass);
    postpareStateMachine(aClass);
    postpareTrace(aClass);
  }
//  @umplesourcefile(line={19},file={"GeneratorHelper_CodeClass.ump"},javaline={69},length={413})
  @umplesourcefile(line={20},file={"GeneratorHelper_CodeClass.ump"},javaline={70},length={12})
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
  @umplesourcefile(line={34},file={"GeneratorHelper_CodeClass.ump"},javaline={85},length={22})
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
  
  @umplesourcefile(line={57},file={"GeneratorHelper_CodeClass.ump"},javaline={109},length={28})
  public static String toCode(List<CodeInjection> allCodeInjections)
  {
    String asCode = null;
    String positionString = "";
    if (allCodeInjections != null)
    {
      for (CodeInjection inject : allCodeInjections)
      {
        if (asCode == null)
        {
          asCode = inject.getCode();
          Position p = inject.getPosition();
	      if (p != null) {
	          positionString =  "// line " + p.getLineNumber() + " \"" + p.getRelativePath(inject.getUmpleClass(), inject.getUmpleClass().getSourceModel().getDefaultGenerate()) + "\"\n";
	      }
        }
        else
        {
          asCode = StringFormatter.format("{0}\n{1}",asCode,inject.getCode());
        }
      }
    }
    if (asCode == null)
    {
      return null;
    }
    return positionString + asCode;
  }  

  @umplesourcefile(line={86},file={"GeneratorHelper_CodeClass.ump"},javaline={139},length={14})
  public static String doIndent(String code, String indents)
  {
    StringBuilder builder = new StringBuilder(code.length() + indents.length()); //Assume generally only one line, will expand otherwise
    builder.append(indents); //Indent first line
    for (int i = 0; i < code.length(); i++)
    {
      builder.append(code.charAt(i));
      if (code.charAt(i) == '\n')
      {
        builder.append(indents);
      }
    }
    return builder.toString();
  }
//  @umplesourcefile(line={19},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={154},length={332})
  @umplesourcefile(line={20},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={155},length={4})
  private static void postpareStateMachine(UmpleModel aModel)
  {
    
  }

  // Remove all internal state machine entities
  @umplesourcefile(line={26},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={162},length={39})
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

  @umplesourcefile(line={66},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={203},length={17})
  public static void prepareAutoTransitions(StateMachine sm, CodeTranslator codeTranslate, Map<String,String> lookups)
  {
    for (State s : sm.getStates())
    {
      for (Transition t : s.getTransitions())
      {
        if (t.isAutoTransition())
        {
          String eventName = codeTranslate.translate("eventMethod",t.getEvent());
          Action entryAction = new Action(StringFormatter.format(lookups.get("callEvent"),eventName));
          entryAction.setIsInternal(true);
          entryAction.setActionType("entry");
          s.addAction(entryAction);
        }
      }
    }
  } 
  
  // Add the necessary entry action to delete the object once the final state is reached
  @umplesourcefile(line={85},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={223},length={13})
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
  @umplesourcefile(line={100},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={239},length={46})
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

  @umplesourcefile(line={147},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={287},length={16})
  public static String getFullActivityName(State currentState)
  {
    String name = getNameWithCapital(currentState.getName());
    State parent = null;
     
    name = getNameWithCapital(currentState.getStateMachine().getName()) + name;
    
    parent = currentState.getStateMachine().getParentState();
    while (parent != null)
    {
      name = getNameWithCapital(parent.getStateMachine().getName()) + name;
      parent = parent.getStateMachine().getParentState();
    }
    
    return name;
  }
  
  @umplesourcefile(line={164},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={305},length={4})
  private static String getNameWithCapital(String name)
  {
    return name.substring(0, 1).toUpperCase() + name.substring(1);
  }
  
  // Mark all internal states are ready for deletion
  @umplesourcefile(line={170},file={"GeneratorHelper_CodeStateMachine.ump"},javaline={312},length={11})
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
//  @umplesourcefile(line={18},file={"GeneratorHelper_CodeTrace.ump"},javaline={324},length={170})
  @umplesourcefile(line={19},file={"GeneratorHelper_CodeTrace.ump"},javaline={325},length={2})
  private static void postpareTrace(UmpleModel aModel)
  {}

  // Currently no internal trace entities to remove at the class level
  @umplesourcefile(line={23},file={"GeneratorHelper_CodeTrace.ump"},javaline={330},length={2})
  private static void postpareTrace(UmpleClass aClass)
  {}
  
  //*********************************************** 
  //*******  Methods dealing with different tracers
  //*********************************************** 
  // Process traces based on tracer selected
  // Current Tracers supported ( Console / File / String ) to be added later ( LTTNG / Dtrace )
  static private boolean generateConsole = true;
  static private boolean generateFile = true;
  static private boolean generateString = true;
  @umplesourcefile(line={34},file={"GeneratorHelper_CodeTrace.ump"},javaline={342},length={3})
  public static boolean getWillGenerateString(){
  	return generateString;
  }
  @umplesourcefile(line={37},file={"GeneratorHelper_CodeTrace.ump"},javaline={346},length={48})
  public static void prepareAllTracers(CodeTranslator t, UmpleModel model, UmpleClass aClass, Map<String,String> templateLookups)
  {    
    for(TraceDirective td: aClass.getTraceDirectives())
    {
      if(templateLookups.containsKey("dependTracer"))
      {
        aClass.addDepend(new Depend(StringFormatter.format(templateLookups.get("dependTracer"),td.getTracerType())));
      }
      if(templateLookups.containsKey("dependDate"))
      {
      	Depend dep = new Depend(templateLookups.get("dependDate"));
      	dep.setIsInternal(true);
        aClass.addDepend(dep);
      }
      if ("Console".equals(td.getTracerType()))
      {
        if(generateConsole)
        {
          generateConsole=false;
          prepareConsoleTracer(model,templateLookups);
        }
      }
      else if ("File".equals(td.getTracerType()))
      {
        if(generateFile)
        {
          generateFile=false;          
          if(model.getTracer().numberOfArgument()>0)
          {
      	    templateLookups.put("filename","\""+td.getTracer().getArgument(0)+"\"");
          }
          else
          {
          	templateLookups.put("filename","\"trace.txt\"");
          }
          prepareFileTracer(model,templateLookups);
        }
      }
      else if ("String".equals(td.getTracerType()))
      {
        if(generateString)
        {
          generateString=false;
          prepareStringTracer(model,templateLookups);
        }
      }
    }
  }

  // Add a StringTracer class to support "String" tracing - typically used for testing, this methods 
  // expects the following action semantic lookups
  //  + packageName: What package should this class belong to?
  //  + extraCode: What is the code required to execute the trace 
  @umplesourcefile(line={90},file={"GeneratorHelper_CodeTrace.ump"},javaline={400},length={20})
  public static void prepareStringTracer(UmpleModel model, Map<String,String> lookups)
  {
    UmpleClass aClass = model.addUmpleClass("StringTracer");
    
    if (aClass.numberOfAttributes() == 0)
    {
      aClass.setIsInternal(true);
      aClass.setIsSingleton(true); 
      aClass.setPackageName(lookups.get("packageName"));
      Attribute traces = new Attribute("traces","String",null,"null",false,aClass);
      Attribute startTime = new Attribute("startTime","int",null,lookups.get("startTime"),false,aClass);
      traces.setIsList(true);
      CodeInjection init = new CodeInjection("after","constructor", lookups.get("initial"), aClass);
      init.setIsInternal(true);
      aClass.addCodeInjection(init);
      aClass.appendExtraCode(lookups.get("stringTracer"));
      aClass.appendExtraCode(lookups.get("static"));
    }
    aClass.createGeneratedClass(model);
  }
  @umplesourcefile(line={110},file={"GeneratorHelper_CodeTrace.ump"},javaline={421},length={17})
  public static void prepareConsoleTracer(UmpleModel model, Map<String,String> lookups)
  {
    UmpleClass aClass = model.addUmpleClass("ConsoleTracer");
    
    if (aClass.getExtraCode().equals(""))
    {
      aClass.setIsInternal(true);
      aClass.setIsSingleton(true); 
      aClass.setPackageName(lookups.get("packageName"));
      aClass.appendExtraCode(lookups.get("consoleTracer"));
      aClass.appendExtraCode(lookups.get("static"));
      CodeInjection init = new CodeInjection("after","constructor", lookups.get("initial"), aClass);
      init.setIsInternal(true);
      aClass.addCodeInjection(init);
    }
    aClass.createGeneratedClass(model);
  }
  @umplesourcefile(line={127},file={"GeneratorHelper_CodeTrace.ump"},javaline={439},length={20})
  public static void prepareFileTracer(UmpleModel model, Map<String,String> lookups)
  {
    UmpleClass aClass = model.addUmpleClass("FileTracer");
    
    if (aClass.getExtraCode()=="")
    {
      aClass.setIsInternal(true);
      aClass.setIsSingleton(true); 
      aClass.addDepend(new Depend("java.io.*"));
      aClass.setPackageName(lookups.get("packageName"));
      
      Attribute filename = new Attribute("filename","String","const",lookups.get("filename"),false,aClass);
      aClass.appendExtraCode(lookups.get("fileTracer"));
      aClass.appendExtraCode(lookups.get("static"));
      CodeInjection init = new CodeInjection("after","constructor", lookups.get("initial"), aClass);
      init.setIsInternal(true);
      aClass.addCodeInjection(init);
    }
    aClass.createGeneratedClass(model);
  }
  
  // Process output to force consistency 
  // this method deals with what is inside the System.err.println();
  static String prepareConsistentOutput(String[] record, Object... params) 
  {
    String output = StringFormatter.format("\"{0}=\" + {1}",params[0],params[1]);
    int i;
    
    for( i = 2 ; i < params.length ; i += 2 )
    {
      if( ! outputRedundant( i, params[i] , params ) )
        output += StringFormatter.format(" + \",{0}=\" + {1}",params[i],params[i+1]);
    }

    if( record != null )
      for( i = 0 ; i < record.length ; ++i )
      {
        if( record[i] == null )
        {
      
        }
        else
          output += StringFormatter.format(" + \",{0}=\" + {1}",record[i],record[i]);
      }
        
    return output;
  }
  
  // purpose of this method is make sure that output is not redundant
  static boolean outputRedundant( int index, Object target, Object... params)
  {
    boolean flag = false;
    
    for( int i =  0 ; i < index ; i += 2 )
    {
      if( target.equals(params[i]) )
        flag = true;
    }
    
    return flag;
  }

}