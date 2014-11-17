/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Identifies a level of approval -- e.g. departmental, board level
 * It would be acceptable just to have string attributes instead of associations to this
 * Could also be called ImportanceLevel
 */
// line 119 "Decisions.ump"
// line 233 "Decisions.ump"
public class ApprovalLevel
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ApprovalLevel Attributes
  private String description;

  //ApprovalLevel Associations
  private List<DecisionMakingBody> decisionMakingBodies;
  private List<DecisionType> decisionTypes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ApprovalLevel(String aDescription)
  {
    description = aDescription;
    decisionMakingBodies = new ArrayList<DecisionMakingBody>();
    decisionTypes = new ArrayList<DecisionType>();
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

  public DecisionMakingBody getDecisionMakingBody(int index)
  {
    DecisionMakingBody aDecisionMakingBody = decisionMakingBodies.get(index);
    return aDecisionMakingBody;
  }

  public List<DecisionMakingBody> getDecisionMakingBodies()
  {
    List<DecisionMakingBody> newDecisionMakingBodies = Collections.unmodifiableList(decisionMakingBodies);
    return newDecisionMakingBodies;
  }

  public int numberOfDecisionMakingBodies()
  {
    int number = decisionMakingBodies.size();
    return number;
  }

  public boolean hasDecisionMakingBodies()
  {
    boolean has = decisionMakingBodies.size() > 0;
    return has;
  }

  public int indexOfDecisionMakingBody(DecisionMakingBody aDecisionMakingBody)
  {
    int index = decisionMakingBodies.indexOf(aDecisionMakingBody);
    return index;
  }

  public DecisionType getDecisionType(int index)
  {
    DecisionType aDecisionType = decisionTypes.get(index);
    return aDecisionType;
  }

  public List<DecisionType> getDecisionTypes()
  {
    List<DecisionType> newDecisionTypes = Collections.unmodifiableList(decisionTypes);
    return newDecisionTypes;
  }

  public int numberOfDecisionTypes()
  {
    int number = decisionTypes.size();
    return number;
  }

  public boolean hasDecisionTypes()
  {
    boolean has = decisionTypes.size() > 0;
    return has;
  }

  public int indexOfDecisionType(DecisionType aDecisionType)
  {
    int index = decisionTypes.indexOf(aDecisionType);
    return index;
  }

  public static int minimumNumberOfDecisionMakingBodies()
  {
    return 0;
  }

  public DecisionMakingBody addDecisionMakingBody(String aName, Organization aOrganization)
  {
    return new DecisionMakingBody(aName, this, aOrganization);
  }

  public boolean addDecisionMakingBody(DecisionMakingBody aDecisionMakingBody)
  {
    boolean wasAdded = false;
    if (decisionMakingBodies.contains(aDecisionMakingBody)) { return false; }
    ApprovalLevel existingApprovalLevel = aDecisionMakingBody.getApprovalLevel();
    boolean isNewApprovalLevel = existingApprovalLevel != null && !this.equals(existingApprovalLevel);
    if (isNewApprovalLevel)
    {
      aDecisionMakingBody.setApprovalLevel(this);
    }
    else
    {
      decisionMakingBodies.add(aDecisionMakingBody);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDecisionMakingBody(DecisionMakingBody aDecisionMakingBody)
  {
    boolean wasRemoved = false;
    //Unable to remove aDecisionMakingBody, as it must always have a approvalLevel
    if (!this.equals(aDecisionMakingBody.getApprovalLevel()))
    {
      decisionMakingBodies.remove(aDecisionMakingBody);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDecisionMakingBodyAt(DecisionMakingBody aDecisionMakingBody, int index)
  {  
    boolean wasAdded = false;
    if(addDecisionMakingBody(aDecisionMakingBody))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDecisionMakingBodies()) { index = numberOfDecisionMakingBodies() - 1; }
      decisionMakingBodies.remove(aDecisionMakingBody);
      decisionMakingBodies.add(index, aDecisionMakingBody);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDecisionMakingBodyAt(DecisionMakingBody aDecisionMakingBody, int index)
  {
    boolean wasAdded = false;
    if(decisionMakingBodies.contains(aDecisionMakingBody))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDecisionMakingBodies()) { index = numberOfDecisionMakingBodies() - 1; }
      decisionMakingBodies.remove(aDecisionMakingBody);
      decisionMakingBodies.add(index, aDecisionMakingBody);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDecisionMakingBodyAt(aDecisionMakingBody, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDecisionTypes()
  {
    return 0;
  }

  public DecisionType addDecisionType(String aDescription)
  {
    return new DecisionType(aDescription, this);
  }

  public boolean addDecisionType(DecisionType aDecisionType)
  {
    boolean wasAdded = false;
    if (decisionTypes.contains(aDecisionType)) { return false; }
    ApprovalLevel existingHighestApprovalLevelRequired = aDecisionType.getHighestApprovalLevelRequired();
    boolean isNewHighestApprovalLevelRequired = existingHighestApprovalLevelRequired != null && !this.equals(existingHighestApprovalLevelRequired);
    if (isNewHighestApprovalLevelRequired)
    {
      aDecisionType.setHighestApprovalLevelRequired(this);
    }
    else
    {
      decisionTypes.add(aDecisionType);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDecisionType(DecisionType aDecisionType)
  {
    boolean wasRemoved = false;
    //Unable to remove aDecisionType, as it must always have a highestApprovalLevelRequired
    if (!this.equals(aDecisionType.getHighestApprovalLevelRequired()))
    {
      decisionTypes.remove(aDecisionType);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDecisionTypeAt(DecisionType aDecisionType, int index)
  {  
    boolean wasAdded = false;
    if(addDecisionType(aDecisionType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDecisionTypes()) { index = numberOfDecisionTypes() - 1; }
      decisionTypes.remove(aDecisionType);
      decisionTypes.add(index, aDecisionType);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDecisionTypeAt(DecisionType aDecisionType, int index)
  {
    boolean wasAdded = false;
    if(decisionTypes.contains(aDecisionType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDecisionTypes()) { index = numberOfDecisionTypes() - 1; }
      decisionTypes.remove(aDecisionType);
      decisionTypes.add(index, aDecisionType);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDecisionTypeAt(aDecisionType, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=decisionMakingBodies.size(); i > 0; i--)
    {
      DecisionMakingBody aDecisionMakingBody = decisionMakingBodies.get(i - 1);
      aDecisionMakingBody.delete();
    }
    for(int i=decisionTypes.size(); i > 0; i--)
    {
      DecisionType aDecisionType = decisionTypes.get(i - 1);
      aDecisionType.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}