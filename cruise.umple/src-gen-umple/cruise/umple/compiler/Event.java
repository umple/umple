/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource StateMachine.ump 164
 * @umplesource StateMachine_Code.ump 445
 */
// line 164 "../../../../src/StateMachine.ump"
// line 445 "../../../../src/StateMachine_Code.ump"
public class Event
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  private String name;
  private boolean isTimer;
  private boolean autoTransition;
  private String timerInSeconds;
  private boolean isInternal;

  //Event Associations
  private List<MethodParameter> params;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Event(String aName)
  {
    cachedHashCode = -1;
    canSetName = true;
    name = aName;
    isTimer = false;
    autoTransition = false;
    timerInSeconds = "0";
    isInternal = false;
    params = new ArrayList<MethodParameter>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    if (!canSetName) { return false; }
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsTimer(boolean aIsTimer)
  {
    boolean wasSet = false;
    isTimer = aIsTimer;
    wasSet = true;
    return wasSet;
  }

  public boolean setAutoTransition(boolean aAutoTransition)
  {
    boolean wasSet = false;
    autoTransition = aAutoTransition;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimerInSeconds(String aTimerInSeconds)
  {
    boolean wasSet = false;
    timerInSeconds = aTimerInSeconds;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsInternal(boolean aIsInternal)
  {
    boolean wasSet = false;
    isInternal = aIsInternal;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  /**
   * String args = null;
   */
  public boolean getIsTimer()
  {
    return isTimer;
  }

  public boolean getAutoTransition()
  {
    return autoTransition;
  }

  public String getTimerInSeconds()
  {
    return timerInSeconds;
  }

  /**
   * TODO: how do you specify milliseconds etc.
   */
  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean isIsTimer()
  {
    return isTimer;
  }

  public boolean isAutoTransition()
  {
    return autoTransition;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public MethodParameter getParam(int index)
  {
    MethodParameter aParam = params.get(index);
    return aParam;
  }

  /**
   * for code generation only e.g. ouside scope of nested state
   * The event parameters.
   */
  public List<MethodParameter> getParams()
  {
    List<MethodParameter> newParams = Collections.unmodifiableList(params);
    return newParams;
  }

  public int numberOfParams()
  {
    int number = params.size();
    return number;
  }

  public boolean hasParams()
  {
    boolean has = params.size() > 0;
    return has;
  }

  public int indexOfParam(MethodParameter aParam)
  {
    int index = params.indexOf(aParam);
    return index;
  }

  public static int minimumNumberOfParams()
  {
    return 0;
  }

  public boolean addParam(MethodParameter aParam)
  {
    boolean wasAdded = false;
    if (params.contains(aParam)) { return false; }
    params.add(aParam);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeParam(MethodParameter aParam)
  {
    boolean wasRemoved = false;
    if (params.contains(aParam))
    {
      params.remove(aParam);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addParamAt(MethodParameter aParam, int index)
  {  
    boolean wasAdded = false;
    if(addParam(aParam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParams()) { index = numberOfParams() - 1; }
      params.remove(aParam);
      params.add(index, aParam);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveParamAt(MethodParameter aParam, int index)
  {
    boolean wasAdded = false;
    if(params.contains(aParam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParams()) { index = numberOfParams() - 1; }
      params.remove(aParam);
      params.add(index, aParam);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addParamAt(aParam, index);
    }
    return wasAdded;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Event compareTo = (Event)obj;
  
    if (name == null && compareTo.name != null)
    {
      return false;
    }
    else if (name != null && !name.equals(compareTo.name))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (name != null)
    {
      cachedHashCode = cachedHashCode * 23 + name.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetName = false;
    return cachedHashCode;
  }

  public void delete()
  {
    params.clear();
  }

  @umplesourcefile(line={449},file={"StateMachine_Code.ump"},javaline={279},length={6})
   public static  Event createAutoTransition(){
    Event e = new Event("__autotransition" + Event.nextAutoTransitionId + "__");
    e.setAutoTransition(true);
    Event.nextAutoTransitionId += 1;
    return e;
  }

  @umplesourcefile(line={457},file={"StateMachine_Code.ump"},javaline={287},length={24})
   public String getArgs(){
    String args="";
    String paramName="";
    String paramType="";
    String aSingleParameter="";
    String isList="";
    String parameters = "";
    String finalParams= "";

     if(this.hasParams() == true)
     {
       for (MethodParameter aEventParam : this.getParams())
       {
         paramName = aEventParam.getName();
         paramType = aEventParam.getType();
         isList = aEventParam.getIsList() ? " [] " : " ";
         aSingleParameter = paramType + isList + paramName;
         parameters += aSingleParameter + ",";
       }
       finalParams = parameters.substring(0, parameters.length()-1);
       args=finalParams;
     }
     return args;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "isTimer" + ":" + getIsTimer()+ "," +
            "autoTransition" + ":" + getAutoTransition()+ "," +
            "timerInSeconds" + ":" + getTimerInSeconds()+ "," +
            "isInternal" + ":" + getIsInternal()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={446},file={"StateMachine_Code.ump"},javaline={328},length={2})
  private static int nextAutoTransitionId = 1 ;

}