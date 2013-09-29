/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

/**
 * An element of a trace directive that indicates to trace one or more state machines
 * or transitions
 * @umplesource Trace.ump 122
 * @umplesource Trace_Code.ump 285
 */
// line 122 "../../../../src/Trace.ump"
// line 285 "../../../../src/Trace_Code.ump"
public class StateMachineTraceItem implements TraceItem
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateMachineTraceItem Attributes
  private Constraint constraint;
  private boolean isIn;
  private boolean isOut;
  private boolean entry;
  private boolean exit;
  private int level;
  private boolean traceStateMachineFlag;
  private Position position;
  private String periodClause;
  private boolean conditionallyWhere;
  private String conditionType;
  private String accessor;
  private String concatinator;

  //StateMachineTraceItem Associations
  private StateMachine stateMachine;
  private State state;
  private Transition transition;
  private TraceDirective traceDirective;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateMachineTraceItem(TraceDirective aTraceDirective)
  {
    constraint = null;
    isIn = false;
    isOut = false;
    entry = false;
    exit = false;
    level = -1;
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

  public boolean setIsIn(boolean aIsIn)
  {
    boolean wasSet = false;
    isIn = aIsIn;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsOut(boolean aIsOut)
  {
    boolean wasSet = false;
    isOut = aIsOut;
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

  public boolean setLevel(int aLevel)
  {
    boolean wasSet = false;
    level = aLevel;
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

  @umplesourcefile(line={127},file={"Trace.ump"},javaline={189},length={2})
  public String getTracerType()
  {
    return getTraceDirective().getTracerType();
  }

  public boolean getIsIn()
  {
    return isIn;
  }

  public boolean getIsOut()
  {
    return isOut;
  }

  public boolean getEntry()
  {
    return entry;
  }

  public boolean getExit()
  {
    return exit;
  }

  public int getLevel()
  {
    return level;
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

  public State getState()
  {
    return state;
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

  public boolean setState(State aState)
  {
    boolean wasSet = false;
    State existingState = state;
    state = aState;
    if (existingState != null && !existingState.equals(aState))
    {
      existingState.removeStateMachineTraceItem(this);
    }
    if (aState != null)
    {
      aState.addStateMachineTraceItem(this);
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
    if (state != null)
    {
      State placeholderState = state;
      this.state = null;
      placeholderState.removeStateMachineTraceItem(this);
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

  @umplesourcefile(line={293},file={"Trace_Code.ump"},javaline={372},length={3})
   public Boolean getIsPre(){
    return conditionallyWhere;
  }

  @umplesourcefile(line={296},file={"Trace_Code.ump"},javaline={377},length={3})
   public Boolean getIsPost(){
    return !conditionallyWhere;
  }


  /**
   * @params gen: A code transator
   * @params o: the current context(i.e.state being traced)
   * @params methodname: what to call this trace
   * @params uClass: the current umple class uClass
   * @params args: if the string is equal to "", the format will be {methodname} {attribute name} to {parameter name}, no argument only returns the argument name, or else the string is passed in the form {methodname} {passed string} to {attribute}
   * @return the message for the trace
   */
  @umplesourcefile(line={307},file={"Trace_Code.ump"},javaline={382},length={59})
   public String trace(CodeTranslator gen, Object o, String methodname, UmpleClass uClass, String... args){
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
      obj = aTransition.getFromState().getName();
      extra = "," + aTransition.getNextState().getName()+"\"";
    }
    else if(o instanceof State)
    {
      State state = (State)o;
      name = getStateMachine().getName()+"\"";
      obj = state.getName();
    }
    if(getTraceDirective().getTraceRecord()!=null)
    {
      for(Attribute record:getTraceDirective().getTraceRecord().getAttributes())
      {
        extra+=comma+gen.translate("attribute"+(record.getIsList()?"Many":"One"),record);
      }
      if(getTraceDirective().getTraceRecord().numberOfRecord()>0)
      {
        extra+= concatinator+"\"";
        for(String record:getTraceDirective().getTraceRecord().getRecord())
        {
          extra+=","+record.replace("\"","");
        }
        extra+= "\"";
      }
    }
    for(String str: args){
      extra+=comma+str;
    }
    
    String message = messageLayout+extra;
    message = StringFormatter.format(
      		message,gen.translate("traceTimestamp",this),
      		gen.translate("traceThread",this),
      		getPosition().getFilename().replace("\\","\\\\"),
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


  /**
   * Gets and returns the if statement enclosing this trace item. The name is not used, but is required from the signature of TraceItem
   * @return the if statement for the trace if one exists
   */
  @umplesourcefile(line={370},file={"Trace_Code.ump"},javaline={452},length={3})
   public String getExtremities(CodeTranslator gen, String name){
    return gen.translate("Closed",constraint);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "tracerType" + ":" + getTracerType()+ "," +
            "isIn" + ":" + getIsIn()+ "," +
            "isOut" + ":" + getIsOut()+ "," +
            "entry" + ":" + getEntry()+ "," +
            "exit" + ":" + getExit()+ "," +
            "level" + ":" + getLevel()+ "," +
            "traceStateMachineFlag" + ":" + getTraceStateMachineFlag()+ "," +
            "periodClause" + ":" + getPeriodClause()+ "," +
            "conditionallyWhere" + ":" + getConditionallyWhere()+ "," +
            "conditionType" + ":" + getConditionType()+ "," +
            "accessor" + ":" + getAccessor()+ "," +
            "concatinator" + ":" + getConcatinator()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "constraint" + "=" + (getConstraint() != null ? !getConstraint().equals(this)  ? getConstraint().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "stateMachine = "+(getStateMachine()!=null?Integer.toHexString(System.identityHashCode(getStateMachine())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "state = "+(getState()!=null?Integer.toHexString(System.identityHashCode(getState())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "transition = "+(getTransition()!=null?Integer.toHexString(System.identityHashCode(getTransition())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "traceDirective = "+(getTraceDirective()!=null?Integer.toHexString(System.identityHashCode(getTraceDirective())):"null")
     + outputString;
  }
}