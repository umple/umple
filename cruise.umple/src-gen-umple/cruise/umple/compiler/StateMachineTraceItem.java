/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

/**
 * An element of a trace directive that indicates to trace one or more state machines
 * or transitions
 * @umplesource Trace.ump 122
 * @umplesource Trace_Code.ump 225
 */
// line 122 "../../../../src/Trace.ump"
// line 225 "../../../../src/Trace_Code.ump"
public class StateMachineTraceItem implements TraceItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateMachineTraceItem Attributes
  private Constraint constraint;
  private boolean entry;
  private boolean exit;
  private boolean traceStateMachineFlag;
  private Position position;
  private String periodClause;
  private boolean conditionallyWhere;
  private String conditionType;
  private String accessor;
  private String concatinator;

  //StateMachineTraceItem Associations
  private StateMachine stateMachine;
  private Transition transition;
  private TraceDirective traceDirective;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateMachineTraceItem(TraceDirective aTraceDirective)
  {
    constraint = null;
    entry = false;
    exit = false;
    traceStateMachineFlag = false;
    position = null;
    periodClause = null;
    conditionallyWhere = true;
    conditionType = "where";
    accessor = "";
    concatinator = " + ";
    boolean didAddTraceDirective = setTraceDirective(aTraceDirective);
    if (!didAddTraceDirective)
    {
      throw new RuntimeException("Unable to create stateMachineTraceItem due to traceDirective");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setConstraint(Constraint aConstraint)
  {
    boolean wasSet = false;
    constraint = aConstraint;
    wasSet = true;
    return wasSet;
  }

  public boolean setEntry(boolean aEntry)
  {
    boolean wasSet = false;
    entry = aEntry;
    wasSet = true;
    return wasSet;
  }

  public boolean setExit(boolean aExit)
  {
    boolean wasSet = false;
    exit = aExit;
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceStateMachineFlag(boolean aTraceStateMachineFlag)
  {
    boolean wasSet = false;
    traceStateMachineFlag = aTraceStateMachineFlag;
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setPeriodClause(String aPeriodClause)
  {
    boolean wasSet = false;
    periodClause = aPeriodClause;
    wasSet = true;
    return wasSet;
  }

  public boolean setConditionallyWhere(boolean aConditionallyWhere)
  {
    boolean wasSet = false;
    conditionallyWhere = aConditionallyWhere;
    wasSet = true;
    return wasSet;
  }

  public boolean setConditionType(String aConditionType)
  {
    boolean wasSet = false;
    conditionType = aConditionType;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccessor(String aAccessor)
  {
    boolean wasSet = false;
    accessor = aAccessor;
    wasSet = true;
    return wasSet;
  }

  public boolean setConcatinator(String aConcatinator)
  {
    boolean wasSet = false;
    concatinator = aConcatinator;
    wasSet = true;
    return wasSet;
  }

  public Constraint getConstraint()
  {
    return constraint;
  }

  public String getTracerType()
  {
    return getTraceDirective().getTracerType();
  }

  public boolean getEntry()
  {
    return entry;
  }

  public boolean getExit()
  {
    return exit;
  }

  public boolean getTraceStateMachineFlag()
  {
    return traceStateMachineFlag;
  }

  public Position getPosition()
  {
    return position;
  }

  public String getPeriodClause()
  {
    return periodClause;
  }

  public boolean getConditionallyWhere()
  {
    return conditionallyWhere;
  }

  public String getConditionType()
  {
    return conditionType;
  }

  public String getAccessor()
  {
    return accessor;
  }

  public String getConcatinator()
  {
    return concatinator;
  }

  public boolean isConditionallyWhere()
  {
    return conditionallyWhere;
  }

  public StateMachine getStateMachine()
  {
    return stateMachine;
  }

  public Transition getTransition()
  {
    return transition;
  }

  public TraceDirective getTraceDirective()
  {
    return traceDirective;
  }

  public boolean setStateMachine(StateMachine aStateMachine)
  {
    boolean wasSet = false;
    StateMachine existingStateMachine = stateMachine;
    stateMachine = aStateMachine;
    if (existingStateMachine != null && !existingStateMachine.equals(aStateMachine))
    {
      existingStateMachine.removeStateMachineTraceItem(this);
    }
    if (aStateMachine != null)
    {
      aStateMachine.addStateMachineTraceItem(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setTransition(Transition aTransition)
  {
    boolean wasSet = false;
    Transition existingTransition = transition;
    transition = aTransition;
    if (existingTransition != null && !existingTransition.equals(aTransition))
    {
      existingTransition.removeStateMachineTraceItem(this);
    }
    if (aTransition != null)
    {
      aTransition.addStateMachineTraceItem(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceDirective(TraceDirective aTraceDirective)
  {
    boolean wasSet = false;
    if (aTraceDirective == null)
    {
      return wasSet;
    }

    TraceDirective existingTraceDirective = traceDirective;
    traceDirective = aTraceDirective;
    if (existingTraceDirective != null && !existingTraceDirective.equals(aTraceDirective))
    {
      existingTraceDirective.removeStateMachineTraceItem(this);
    }
    traceDirective.addStateMachineTraceItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (stateMachine != null)
    {
      StateMachine placeholderStateMachine = stateMachine;
      this.stateMachine = null;
      placeholderStateMachine.removeStateMachineTraceItem(this);
    }
    if (transition != null)
    {
      Transition placeholderTransition = transition;
      this.transition = null;
      placeholderTransition.removeStateMachineTraceItem(this);
    }
    TraceDirective placeholderTraceDirective = traceDirective;
    this.traceDirective = null;
    placeholderTraceDirective.removeStateMachineTraceItem(this);
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "tracerType" + ":" + getTracerType()+ "," +
            "entry" + ":" + getEntry()+ "," +
            "exit" + ":" + getExit()+ "," +
            "traceStateMachineFlag" + ":" + getTraceStateMachineFlag()+ "," +
            "periodClause" + ":" + getPeriodClause()+ "," +
            "conditionallyWhere" + ":" + getConditionallyWhere()+ "," +
            "conditionType" + ":" + getConditionType()+ "," +
            "accessor" + ":" + getAccessor()+ "," +
            "concatinator" + ":" + getConcatinator()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "traceDirective" + "=" + getConstraint() != null ? !getConstraint() .equals(this)  ? getConstraint().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "transition" + "=" + getPosition() != null ? !getPosition() .equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "stateMachine" + "=" + getStateMachine() != null ? !getStateMachine() .equals(this)  ? getStateMachine().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "constraint" + "=" + getTransition() != null ? !getTransition() .equals(this)  ? getTransition().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + getTraceDirective() != null ? !getTraceDirective() .equals(this)  ? getTraceDirective().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 233 ../../../../src/Trace_Code.ump
  public Boolean getIsPre(){
  	return conditionallyWhere;
  }
  public Boolean getIsPost(){
  	return !conditionallyWhere;
  }
  /*
   * @params gen: A code transator
   * @params o: the current context(i.e.state being traced)
   * @params methodname: what to call this trace
   * @params uClass: the current umple class uClass
   * @params args: if the string is equal to "", the format will be {methodname} {attribute name} to {parameter name}, no argument only returns the argument name, or else the string is passed in the form {methodname} {passed string} to {attribute}
   * @return the message for the trace 
   */
  public String trace(CodeTranslator gen, Object o, String methodname, UmpleClass uClass, String... args)
  {
  	String name = "";
    String extra = "";
    String obj = "";
    String accessor = gen.translate("traceAccessor",this);
    String concatinator = gen.translate("traceConcatinator",this);
    String comma = concatinator+"\",\""+concatinator;
    String messageLayout = "{0}"+comma+"{1}"+concatinator+"\",{2},{3},{4},\""+concatinator+"{5}"+concatinator+"\",{6},{7},{8}";
  
    if(o instanceof Transition)
    {
      Transition aTransition = (Transition)o;
      name = aTransition.getEvent().getName();
      obj = ","+aTransition.getFromState().getName();
      extra = "," + aTransition.getNextState().getName();
    }
    else if(o instanceof State)
    {
      State state = (State)o;
      name = getStateMachine().getName();
      obj = state.getName();
    }
      	
    for(String str: args){
      extra+=comma+str;
    }
    
    String message = messageLayout+extra;
    message = StringFormatter.format(
      		message,gen.translate("traceTimestamp",this),
      		gen.translate("traceThread",this),
      		getPosition().getFilename(),
      		getPosition().getLineNumber(),
      		uClass.getName(),
      		StringFormatter.format(gen.translate("traceIdentifier",this),gen.translate("traceSelf",this)),
      		methodname,
      		obj,
      		name      		
    );
    message = StringFormatter.format(gen.translate("traceTemplate",this),getTracerType(),message);
    message = StringFormatter.format(getExtremities(gen, name),message);
    message = GeneratorHelper.doIndent(message,gen.translate("traceIndent",this));
    return message;
  }
  /* Gets and returns the if statement enclosing this trace item. The name is not used, but is required from the signature of TraceItem
   * @return the if statement for the trace if one exists
   */
  public String getExtremities(CodeTranslator gen, String name)
  {
    return gen.translate("Closed",constraint);
  }
}