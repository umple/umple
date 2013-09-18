/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_CodeSimpleMetrics.ump 631
 */
// line 631 "../../../../src/Generator_CodeSimpleMetrics.ump"
public class CountClass
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CountClass Attributes
  private int countStateMachines;
  private int countAssociations;
  private int countSubclasses;
  private int countAttributes;
  private int countMethods;
  private int countParameters;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CountClass()
  {
    countStateMachines = 0;
    countAssociations = 0;
    countSubclasses = 0;
    countAttributes = 0;
    countMethods = 0;
    countParameters = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCountStateMachines(int aCountStateMachines)
  {
    boolean wasSet = false;
    countStateMachines = aCountStateMachines;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountAssociations(int aCountAssociations)
  {
    boolean wasSet = false;
    countAssociations = aCountAssociations;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountSubclasses(int aCountSubclasses)
  {
    boolean wasSet = false;
    countSubclasses = aCountSubclasses;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountAttributes(int aCountAttributes)
  {
    boolean wasSet = false;
    countAttributes = aCountAttributes;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountMethods(int aCountMethods)
  {
    boolean wasSet = false;
    countMethods = aCountMethods;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountParameters(int aCountParameters)
  {
    boolean wasSet = false;
    countParameters = aCountParameters;
    wasSet = true;
    return wasSet;
  }

  public int getCountStateMachines()
  {
    return countStateMachines;
  }

  public int getCountAssociations()
  {
    return countAssociations;
  }

  public int getCountSubclasses()
  {
    return countSubclasses;
  }

  public int getCountAttributes()
  {
    return countAttributes;
  }

  public int getCountMethods()
  {
    return countMethods;
  }

  public int getCountParameters()
  {
    return countParameters;
  }

  public void delete()
  {}

  @umplesourcefile(line={639},file={"Generator_CodeSimpleMetrics.ump"},javaline={127},length={3})
  public void incStateMachines(){
    ++this.countStateMachines;
  }

  @umplesourcefile(line={642},file={"Generator_CodeSimpleMetrics.ump"},javaline={132},length={3})
  public void incCountAssociations(){
    ++this.countAssociations;
  }

  @umplesourcefile(line={645},file={"Generator_CodeSimpleMetrics.ump"},javaline={137},length={3})
  public void incCountSubclasses(){
    ++this.countSubclasses;
  }

  @umplesourcefile(line={648},file={"Generator_CodeSimpleMetrics.ump"},javaline={142},length={3})
  public void incCountAttributes(){
    ++this.countAttributes;
  }

  @umplesourcefile(line={651},file={"Generator_CodeSimpleMetrics.ump"},javaline={147},length={3})
  public void incCountMethods(){
    ++this.countMethods;
  }

  @umplesourcefile(line={654},file={"Generator_CodeSimpleMetrics.ump"},javaline={152},length={3})
  public void incCountParameters(){
    ++this.countParameters;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "countStateMachines" + ":" + getCountStateMachines()+ "," +
            "countAssociations" + ":" + getCountAssociations()+ "," +
            "countSubclasses" + ":" + getCountSubclasses()+ "," +
            "countAttributes" + ":" + getCountAttributes()+ "," +
            "countMethods" + ":" + getCountMethods()+ "," +
            "countParameters" + ":" + getCountParameters()+ "]"
     + outputString;
  }
}