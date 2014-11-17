/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Categorization of decisions
 */
// line 111 "Decisions.ump"
// line 208 "Decisions.ump"
public class DecisionType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DecisionType Attributes
  private String description;

  //DecisionType Associations
  private ApprovalLevel highestApprovalLevelRequired;
  private List<Decision> decisions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DecisionType(String aDescription, ApprovalLevel aHighestApprovalLevelRequired)
  {
    description = aDescription;
    boolean didAddHighestApprovalLevelRequired = setHighestApprovalLevelRequired(aHighestApprovalLevelRequired);
    if (!didAddHighestApprovalLevelRequired)
    {
      throw new RuntimeException("Unable to create decisionType due to highestApprovalLevelRequired");
    }
    decisions = new ArrayList<Decision>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public ApprovalLevel getHighestApprovalLevelRequired()
  {
    return highestApprovalLevelRequired;
  }

  public Decision getDecision(int index)
  {
    Decision aDecision = decisions.get(index);
    return aDecision;
  }

  public List<Decision> getDecisions()
  {
    List<Decision> newDecisions = Collections.unmodifiableList(decisions);
    return newDecisions;
  }

  public int numberOfDecisions()
  {
    int number = decisions.size();
    return number;
  }

  public boolean hasDecisions()
  {
    boolean has = decisions.size() > 0;
    return has;
  }

  public int indexOfDecision(Decision aDecision)
  {
    int index = decisions.indexOf(aDecision);
    return index;
  }

  public boolean setHighestApprovalLevelRequired(ApprovalLevel aHighestApprovalLevelRequired)
  {
    boolean wasSet = false;
    if (aHighestApprovalLevelRequired == null)
    {
      return wasSet;
    }

    ApprovalLevel existingHighestApprovalLevelRequired = highestApprovalLevelRequired;
    highestApprovalLevelRequired = aHighestApprovalLevelRequired;
    if (existingHighestApprovalLevelRequired != null && !existingHighestApprovalLevelRequired.equals(aHighestApprovalLevelRequired))
    {
      existingHighestApprovalLevelRequired.removeDecisionType(this);
    }
    highestApprovalLevelRequired.addDecisionType(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfDecisions()
  {
    return 0;
  }

  public Decision addDecision(String aId, boolean aIsBeingConsidered, Organization aOrganization)
  {
    return new Decision(aId, aIsBeingConsidered, this, aOrganization);
  }

  public boolean addDecision(Decision aDecision)
  {
    boolean wasAdded = false;
    if (decisions.contains(aDecision)) { return false; }
    DecisionType existingDecisionType = aDecision.getDecisionType();
    boolean isNewDecisionType = existingDecisionType != null && !this.equals(existingDecisionType);
    if (isNewDecisionType)
    {
      aDecision.setDecisionType(this);
    }
    else
    {
      decisions.add(aDecision);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDecision(Decision aDecision)
  {
    boolean wasRemoved = false;
    //Unable to remove aDecision, as it must always have a decisionType
    if (!this.equals(aDecision.getDecisionType()))
    {
      decisions.remove(aDecision);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDecisionAt(Decision aDecision, int index)
  {  
    boolean wasAdded = false;
    if(addDecision(aDecision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDecisions()) { index = numberOfDecisions() - 1; }
      decisions.remove(aDecision);
      decisions.add(index, aDecision);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDecisionAt(Decision aDecision, int index)
  {
    boolean wasAdded = false;
    if(decisions.contains(aDecision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDecisions()) { index = numberOfDecisions() - 1; }
      decisions.remove(aDecision);
      decisions.add(index, aDecision);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDecisionAt(aDecision, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ApprovalLevel placeholderHighestApprovalLevelRequired = highestApprovalLevelRequired;
    this.highestApprovalLevelRequired = null;
    placeholderHighestApprovalLevelRequired.removeDecisionType(this);
    for(int i=decisions.size(); i > 0; i--)
    {
      Decision aDecision = decisions.get(i - 1);
      aDecision.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "highestApprovalLevelRequired = "+(getHighestApprovalLevelRequired()!=null?Integer.toHexString(System.identityHashCode(getHighestApprovalLevelRequired())):"null")
     + outputString;
  }
}