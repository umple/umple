/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;

public class TraceCondition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceCondition Attributes
  private String conditionType;
  private String lhs;

  //TraceCondition Associations
  private ConditionRhs rhs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceCondition(ConditionRhs aRhs)
  {
    conditionType = null;
    lhs = null;
    if (!setRhs(aRhs))
    {
      throw new RuntimeException("Unable to create TraceCondition due to aRhs");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setConditionType(String aConditionType)
  {
    boolean wasSet = false;
    conditionType = aConditionType;
    wasSet = true;
    return wasSet;
  }

  public boolean setLhs(String aLhs)
  {
    boolean wasSet = false;
    lhs = aLhs;
    wasSet = true;
    return wasSet;
  }

  public String getConditionType()
  {
    return conditionType;
  }

  public String getLhs()
  {
    return lhs;
  }

  public ConditionRhs getRhs()
  {
    return rhs;
  }

  public boolean setRhs(ConditionRhs newRhs)
  {
    boolean wasSet = false;
    if (newRhs != null)
    {
      rhs = newRhs;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    rhs = null;
  }

}