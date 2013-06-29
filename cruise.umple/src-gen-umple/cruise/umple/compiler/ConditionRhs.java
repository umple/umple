/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Trace.ump 43
 */
// line 43 "../../../../src/Trace.ump"
public class ConditionRhs
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConditionRhs Attributes
  private String rhs;
  private String comparisonOperator;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConditionRhs()
  {
    rhs = null;
    comparisonOperator = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRhs(String aRhs)
  {
    boolean wasSet = false;
    rhs = aRhs;
    wasSet = true;
    return wasSet;
  }

  public boolean setComparisonOperator(String aComparisonOperator)
  {
    boolean wasSet = false;
    comparisonOperator = aComparisonOperator;
    wasSet = true;
    return wasSet;
  }

  public String getRhs()
  {
    return rhs;
  }

  public String getComparisonOperator()
  {
    return comparisonOperator;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "rhs" + ":" + getRhs()+ "," +
            "comparisonOperator" + ":" + getComparisonOperator()+ "]"
     + outputString;
  }
}