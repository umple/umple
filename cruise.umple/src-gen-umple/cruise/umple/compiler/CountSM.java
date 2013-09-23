/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * END OF CLASS StateMachineMetrics
 * @umplesource Generator_CodeSimpleMetrics.ump 577
 */
// line 577 "../../../../src/Generator_CodeSimpleMetrics.ump"
public class CountSM
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CountSM Attributes
  private int totalStateMachines;
  private int totalStateMachinesPerClass;
  private int totalStatesPerClass;
  private int totalStates;
  private int totalEvents;
  private int totalTransitions;
  private int avgTransitionsPerEvent;
  private int avgTransitionsPerClass;
  private int totalActions;
  private int totalNestedStateMachine;
  private int maxNestingDepth;
  private int avgNestingDepth;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CountSM()
  {
    totalStateMachines = 0;
    totalStateMachinesPerClass = 0;
    totalStatesPerClass = 0;
    totalStates = 0;
    totalEvents = 0;
    totalTransitions = 0;
    avgTransitionsPerEvent = 0;
    avgTransitionsPerClass = 0;
    totalActions = 0;
    totalNestedStateMachine = 0;
    maxNestingDepth = 0;
    avgNestingDepth = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTotalStateMachines(int aTotalStateMachines)
  {
    boolean wasSet = false;
    totalStateMachines = aTotalStateMachines;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalStateMachinesPerClass(int aTotalStateMachinesPerClass)
  {
    boolean wasSet = false;
    totalStateMachinesPerClass = aTotalStateMachinesPerClass;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalStatesPerClass(int aTotalStatesPerClass)
  {
    boolean wasSet = false;
    totalStatesPerClass = aTotalStatesPerClass;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalStates(int aTotalStates)
  {
    boolean wasSet = false;
    totalStates = aTotalStates;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalEvents(int aTotalEvents)
  {
    boolean wasSet = false;
    totalEvents = aTotalEvents;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalTransitions(int aTotalTransitions)
  {
    boolean wasSet = false;
    totalTransitions = aTotalTransitions;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvgTransitionsPerEvent(int aAvgTransitionsPerEvent)
  {
    boolean wasSet = false;
    avgTransitionsPerEvent = aAvgTransitionsPerEvent;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvgTransitionsPerClass(int aAvgTransitionsPerClass)
  {
    boolean wasSet = false;
    avgTransitionsPerClass = aAvgTransitionsPerClass;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalActions(int aTotalActions)
  {
    boolean wasSet = false;
    totalActions = aTotalActions;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalNestedStateMachine(int aTotalNestedStateMachine)
  {
    boolean wasSet = false;
    totalNestedStateMachine = aTotalNestedStateMachine;
    wasSet = true;
    return wasSet;
  }

  public boolean setMaxNestingDepth(int aMaxNestingDepth)
  {
    boolean wasSet = false;
    maxNestingDepth = aMaxNestingDepth;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvgNestingDepth(int aAvgNestingDepth)
  {
    boolean wasSet = false;
    avgNestingDepth = aAvgNestingDepth;
    wasSet = true;
    return wasSet;
  }

  public int getTotalStateMachines()
  {
    return totalStateMachines;
  }

  public int getTotalStateMachinesPerClass()
  {
    return totalStateMachinesPerClass;
  }

  public int getTotalStatesPerClass()
  {
    return totalStatesPerClass;
  }

  public int getTotalStates()
  {
    return totalStates;
  }

  public int getTotalEvents()
  {
    return totalEvents;
  }

  public int getTotalTransitions()
  {
    return totalTransitions;
  }

  public int getAvgTransitionsPerEvent()
  {
    return avgTransitionsPerEvent;
  }

  public int getAvgTransitionsPerClass()
  {
    return avgTransitionsPerClass;
  }

  public int getTotalActions()
  {
    return totalActions;
  }

  public int getTotalNestedStateMachine()
  {
    return totalNestedStateMachine;
  }

  public int getMaxNestingDepth()
  {
    return maxNestingDepth;
  }

  public int getAvgNestingDepth()
  {
    return avgNestingDepth;
  }

  public void delete()
  {}

  @umplesourcefile(line={591},file={"Generator_CodeSimpleMetrics.ump"},javaline={218},length={3})
  public void incTotalStateMachines(int a){
    this.totalStateMachines+=a;
  }

  @umplesourcefile(line={594},file={"Generator_CodeSimpleMetrics.ump"},javaline={223},length={3})
  public void incTotalStateMachinesPerClass(int a){
    this.totalStateMachinesPerClass+=a;
  }

  @umplesourcefile(line={597},file={"Generator_CodeSimpleMetrics.ump"},javaline={228},length={3})
  public void incTotalStatesPerClass(int a){
    this.totalStatesPerClass+=a;
  }

  @umplesourcefile(line={600},file={"Generator_CodeSimpleMetrics.ump"},javaline={233},length={3})
  public void incTotalStates(int a){
    this.totalStates+=a;
  }

  @umplesourcefile(line={603},file={"Generator_CodeSimpleMetrics.ump"},javaline={238},length={3})
  public void incTotalEvents(int a){
    this.totalEvents+=a;
  }

  @umplesourcefile(line={606},file={"Generator_CodeSimpleMetrics.ump"},javaline={243},length={3})
  public void incTotalTransitions(int a){
    this.totalTransitions+=a;
  }

  @umplesourcefile(line={609},file={"Generator_CodeSimpleMetrics.ump"},javaline={248},length={3})
  public void incAvgTransitionsPerEvent(int a){
    this.avgTransitionsPerEvent+=a;
  }

  @umplesourcefile(line={613},file={"Generator_CodeSimpleMetrics.ump"},javaline={253},length={3})
  public void incAvgTransitionsPerClass(int a){
    this.avgTransitionsPerClass+=a;
  }

  @umplesourcefile(line={616},file={"Generator_CodeSimpleMetrics.ump"},javaline={258},length={3})
  public void incTotalActions(int a){
    this.totalActions+=a;
  }

  @umplesourcefile(line={619},file={"Generator_CodeSimpleMetrics.ump"},javaline={263},length={3})
  public void incTotalNestedStateMachine(int a){
    this.totalNestedStateMachine+=a;
  }

  @umplesourcefile(line={622},file={"Generator_CodeSimpleMetrics.ump"},javaline={268},length={3})
  public void incMaxNestingDepth(int a){
    this.maxNestingDepth+=a;
  }

  @umplesourcefile(line={625},file={"Generator_CodeSimpleMetrics.ump"},javaline={273},length={3})
  public void incAvgNestingDepth(int a){
    this.avgNestingDepth+=a;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "totalStateMachines" + ":" + getTotalStateMachines()+ "," +
            "totalStateMachinesPerClass" + ":" + getTotalStateMachinesPerClass()+ "," +
            "totalStatesPerClass" + ":" + getTotalStatesPerClass()+ "," +
            "totalStates" + ":" + getTotalStates()+ "," +
            "totalEvents" + ":" + getTotalEvents()+ "," +
            "totalTransitions" + ":" + getTotalTransitions()+ "," +
            "avgTransitionsPerEvent" + ":" + getAvgTransitionsPerEvent()+ "," +
            "avgTransitionsPerClass" + ":" + getAvgTransitionsPerClass()+ "," +
            "totalActions" + ":" + getTotalActions()+ "," +
            "totalNestedStateMachine" + ":" + getTotalNestedStateMachine()+ "," +
            "maxNestingDepth" + ":" + getMaxNestingDepth()+ "," +
            "avgNestingDepth" + ":" + getAvgNestingDepth()+ "]"
     + outputString;
  }
}