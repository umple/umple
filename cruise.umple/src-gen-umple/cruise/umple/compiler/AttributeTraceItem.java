/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;
import java.util.*;

/**
 * An element of a trace directive that indicates to trace one or more attributes
 * @umplesource Trace.ump 97
 * @umplesource Trace_Code.ump 166
 */
// line 97 "../../../../src/Trace.ump"
// line 166 "../../../../src/Trace_Code.ump"
public class AttributeTraceItem implements TraceItem
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AttributeTraceItem Attributes
  private Constraint constraint;
  private boolean traceSet;
  private boolean traceGet;
  private boolean traceConstructor;
  private String forClause;
  private String periodClause;
  private String duringClause;
  private String executeClause;
  private Position position;
  private boolean conditionallyWhere;
  private String conditionType;

  //AttributeTraceItem Associations
  private List<UmpleVariable> umpleVariables;
  private TraceDirective traceDirective;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AttributeTraceItem(TraceDirective aTraceDirective)
  {
    constraint = null;
    traceSet = false;
    traceGet = false;
    traceConstructor = false;
    forClause = null;
    periodClause = null;
    duringClause = null;
    executeClause = null;
    position = null;
    conditionallyWhere = true;
    conditionType = "where";
    umpleVariables = new ArrayList<UmpleVariable>();
    boolean didAddTraceDirective = setTraceDirective(aTraceDirective);
    if (!didAddTraceDirective)
    {
      throw new RuntimeException("Unable to create attributeTraceItem due to traceDirective");
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

  public boolean setTraceSet(boolean aTraceSet)
  {
    boolean wasSet = false;
    traceSet = aTraceSet;
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceGet(boolean aTraceGet)
  {
    boolean wasSet = false;
    traceGet = aTraceGet;
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceConstructor(boolean aTraceConstructor)
  {
    boolean wasSet = false;
    traceConstructor = aTraceConstructor;
    wasSet = true;
    return wasSet;
  }

  public boolean setForClause(String aForClause)
  {
    boolean wasSet = false;
    forClause = aForClause;
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

  public boolean setDuringClause(String aDuringClause)
  {
    boolean wasSet = false;
    duringClause = aDuringClause;
    wasSet = true;
    return wasSet;
  }

  public boolean setExecuteClause(String aExecuteClause)
  {
    boolean wasSet = false;
    executeClause = aExecuteClause;
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

  public Constraint getConstraint()
  {
    return constraint;
  }

  @umplesourcefile(line={101},file={"Trace.ump"},javaline={168},length={2})
  public String getTracerType()
  {
    return getTraceDirective().getTracerType();
  }

  public boolean getTraceSet()
  {
    return traceSet;
  }

  public boolean getTraceGet()
  {
    return traceGet;
  }

  public boolean getTraceConstructor()
  {
    return traceConstructor;
  }

  public String getForClause()
  {
    return forClause;
  }

  public String getPeriodClause()
  {
    return periodClause;
  }

  public String getDuringClause()
  {
    return duringClause;
  }

  public String getExecuteClause()
  {
    return executeClause;
  }

  public Position getPosition()
  {
    return position;
  }

  public boolean getConditionallyWhere()
  {
    return conditionallyWhere;
  }

  public String getConditionType()
  {
    return conditionType;
  }

  public boolean isConditionallyWhere()
  {
    return conditionallyWhere;
  }

  public UmpleVariable getUmpleVariable(int index)
  {
    UmpleVariable aUmpleVariable = umpleVariables.get(index);
    return aUmpleVariable;
  }

  public List<UmpleVariable> getUmpleVariables()
  {
    List<UmpleVariable> newUmpleVariables = Collections.unmodifiableList(umpleVariables);
    return newUmpleVariables;
  }

  public int numberOfUmpleVariables()
  {
    int number = umpleVariables.size();
    return number;
  }

  public boolean hasUmpleVariables()
  {
    boolean has = umpleVariables.size() > 0;
    return has;
  }

  public int indexOfUmpleVariable(UmpleVariable aUmpleVariable)
  {
    int index = umpleVariables.indexOf(aUmpleVariable);
    return index;
  }

  public TraceDirective getTraceDirective()
  {
    return traceDirective;
  }

  public static int minimumNumberOfUmpleVariables()
  {
    return 0;
  }

  public boolean addUmpleVariable(UmpleVariable aUmpleVariable)
  {
    boolean wasAdded = false;
    if (umpleVariables.contains(aUmpleVariable)) { return false; }
    umpleVariables.add(aUmpleVariable);
    if (aUmpleVariable.indexOfAttributeTraceItem(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUmpleVariable.addAttributeTraceItem(this);
      if (!wasAdded)
      {
        umpleVariables.remove(aUmpleVariable);
      }
    }
    return wasAdded;
  }

  public boolean removeUmpleVariable(UmpleVariable aUmpleVariable)
  {
    boolean wasRemoved = false;
    if (!umpleVariables.contains(aUmpleVariable))
    {
      return wasRemoved;
    }

    int oldIndex = umpleVariables.indexOf(aUmpleVariable);
    umpleVariables.remove(oldIndex);
    if (aUmpleVariable.indexOfAttributeTraceItem(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUmpleVariable.removeAttributeTraceItem(this);
      if (!wasRemoved)
      {
        umpleVariables.add(oldIndex,aUmpleVariable);
      }
    }
    return wasRemoved;
  }

  public boolean addUmpleVariableAt(UmpleVariable aUmpleVariable, int index)
  {  
    boolean wasAdded = false;
    if(addUmpleVariable(aUmpleVariable))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleVariables()) { index = numberOfUmpleVariables() - 1; }
      umpleVariables.remove(aUmpleVariable);
      umpleVariables.add(index, aUmpleVariable);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUmpleVariableAt(UmpleVariable aUmpleVariable, int index)
  {
    boolean wasAdded = false;
    if(umpleVariables.contains(aUmpleVariable))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleVariables()) { index = numberOfUmpleVariables() - 1; }
      umpleVariables.remove(aUmpleVariable);
      umpleVariables.add(index, aUmpleVariable);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUmpleVariableAt(aUmpleVariable, index);
    }
    return wasAdded;
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
      existingTraceDirective.removeAttributeTraceItem(this);
    }
    traceDirective.addAttributeTraceItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<UmpleVariable> copyOfUmpleVariables = new ArrayList<UmpleVariable>(umpleVariables);
    umpleVariables.clear();
    for(UmpleVariable aUmpleVariable : copyOfUmpleVariables)
    {
      aUmpleVariable.removeAttributeTraceItem(this);
    }
    TraceDirective placeholderTraceDirective = traceDirective;
    this.traceDirective = null;
    placeholderTraceDirective.removeAttributeTraceItem(this);
  }

  @umplesourcefile(line={171},file={"Trace_Code.ump"},javaline={375},length={3})
  public Attribute getAttribute(int index){
    return (Attribute)getUmpleVariable(index);
  }

  @umplesourcefile(line={174},file={"Trace_Code.ump"},javaline={380},length={3})
  public Boolean addAttribute(Attribute attr){
    return addUmpleVariable(attr);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "tracerType" + ":" + getTracerType()+ "," +
            "traceSet" + ":" + getTraceSet()+ "," +
            "traceGet" + ":" + getTraceGet()+ "," +
            "traceConstructor" + ":" + getTraceConstructor()+ "," +
            "forClause" + ":" + getForClause()+ "," +
            "periodClause" + ":" + getPeriodClause()+ "," +
            "duringClause" + ":" + getDuringClause()+ "," +
            "executeClause" + ":" + getExecuteClause()+ "," +
            "conditionallyWhere" + ":" + getConditionallyWhere()+ "," +
            "conditionType" + ":" + getConditionType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "constraint" + "=" + (getConstraint() != null ? !getConstraint().equals(this)  ? getConstraint().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "traceDirective = "+(getTraceDirective()!=null?Integer.toHexString(System.identityHashCode(getTraceDirective())):"null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={176},file={"Trace_Code.ump"},javaline={408},length={100})
  @umplesourcefile(line={177},file={"Trace_Code.ump"},javaline={409},length={3})
  public Boolean getIsPre(){
  	return conditionallyWhere;
  }
  @umplesourcefile(line={180},file={"Trace_Code.ump"},javaline={413},length={3})
  public Boolean getIsPost(){
  	return !conditionallyWhere;
  }
  
  /*
   * @params gen: A code transator
   * @params o: the current context(i.e.attribute being traced)
   * @params methodname: what to call this trace
   * @params uClass: the current umple class uClass
   * @params args: if the string is equal to "", the format will be {methodname} {attribute name} to {parameter name}, no argument only returns the argument name, or else the string is passed in the form {methodname} {passed string} to {attribute}
   * @return the message for the trace 
   */
  @umplesourcefile(line={192},file={"Trace_Code.ump"},javaline={426},length={76})
  public String trace(CodeTranslator gen, Object o, String methodname, UmpleClass uClass,String... args)
  {//find the object being traced
    for(UmpleVariable attr: umpleVariables)
    {
      if(attr.equals(o))
      {
      	String type = ((UmpleVariable)o).getType();
      	String name = "";
      	String extra = "";
      	String obj = "";
      	String accessor = gen.translate("traceAccessor",this);
      	String concatinator = gen.translate("traceConcatinator",this);
      	String comma = concatinator+"\",\""+concatinator;
        String messageLayout = "{0}"+comma+"{1}"+concatinator+"\",{2},{3},{4},\""+concatinator+"{5}"+concatinator+"\",{6},{7},\""+concatinator+"{8}";
        
        if(o instanceof Attribute)
      	{
      		name = gen.translate("attributeOne",(Attribute)o);
      	}
      	else if(o instanceof AssociationVariable)
      	{
      		name = gen.translate("associationMany",(AssociationVariable)o);
      	}
      	
      	if(type==null||"".equals(type)||"String".equals(type)||"int".equals(type)||"Integer".equals(type)||"float".equals(type)||"Float".equals(type)||"double".equals(type)||"Double".equals(type)||"Time".equals(type)||"Date".equals(type))
      	{
      		obj = name;
      	}
      	else
      	{
      		obj = StringFormatter.format(gen.translate("traceIdentifier",this),name);
      	}
      	
      	for(String str: args){
      		extra+=comma+str;
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
      		accessor+name      		
      	);
      	message = StringFormatter.format(gen.translate("traceTemplate",this),getTracerType(),message);
      	if(getForClause()!=null)
      	{
      	  message += "\n  "+StringFormatter.format(gen.translate("traceIncrement",this),getForClause());
      	}
      	message = StringFormatter.format(getExtremities(gen, name),message);
      	message = GeneratorHelper.doIndent(message,gen.translate("traceIndent",this));
      	return message;
      }
    }
    return "";
  }
  /* Gets and returns the if statement enclosing this trace item.
   * needs the name of the attribute
   * @return the if statement for the trace if one exists
   */
  @umplesourcefile(line={272},file={"Trace_Code.ump"},javaline={507},length={4})
  public String getExtremities(CodeTranslator gen, String name)
  {
    return gen.translate(name+"Closed",constraint);
  }

}