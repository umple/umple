/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * A formal decision that is proposed or made
 */
// line 38 "Decisions.ump"
// line 214 "Decisions.ump"
public class Decision
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Decision Attributes
  private String id;
  private boolean isBeingConsidered;

  //Decision Associations
  private DecisionType decisionType;
  private DecisionByBody currentStatus;
  private List<Decision> successors;
  private Organization organization;
  private List<Decision> predecessors;
  private List<DecisionByBody> decisionByBodies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Decision(String aId, boolean aIsBeingConsidered, DecisionType aDecisionType, Organization aOrganization)
  {
    id = aId;
    isBeingConsidered = aIsBeingConsidered;
    boolean didAddDecisionType = setDecisionType(aDecisionType);
    if (!didAddDecisionType)
    {
      throw new RuntimeException("Unable to create decision due to decisionType");
    }
    successors = new ArrayList<Decision>();
    boolean didAddOrganization = setOrganization(aOrganization);
    if (!didAddOrganization)
    {
      throw new RuntimeException("Unable to create decision due to organization");
    }
    predecessors = new ArrayList<Decision>();
    decisionByBodies = new ArrayList<DecisionByBody>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsBeingConsidered(boolean aIsBeingConsidered)
  {
    boolean wasSet = false;
    isBeingConsidered = aIsBeingConsidered;
    wasSet = true;
    return wasSet;
  }

  /**
   * Formal identification code
   */
  public String getId()
  {
    return id;
  }

  /**
   * True if still in progress; false if dropped or merged/split
   */
  public boolean getIsBeingConsidered()
  {
    return isBeingConsidered;
  }

  public boolean isIsBeingConsidered()
  {
    return isBeingConsidered;
  }

  public DecisionType getDecisionType()
  {
    return decisionType;
  }

  public DecisionByBody getCurrentStatus()
  {
    return currentStatus;
  }

  public boolean hasCurrentStatus()
  {
    boolean has = currentStatus != null;
    return has;
  }

  public Decision getSuccessor(int index)
  {
    Decision aSuccessor = successors.get(index);
    return aSuccessor;
  }

  /**
   * Used for tracking splitting or merging of decisions
   */
  public List<Decision> getSuccessors()
  {
    List<Decision> newSuccessors = Collections.unmodifiableList(successors);
    return newSuccessors;
  }

  public int numberOfSuccessors()
  {
    int number = successors.size();
    return number;
  }

  public boolean hasSuccessors()
  {
    boolean has = successors.size() > 0;
    return has;
  }

  public int indexOfSuccessor(Decision aSuccessor)
  {
    int index = successors.indexOf(aSuccessor);
    return index;
  }

  public Organization getOrganization()
  {
    return organization;
  }

  public Decision getPredecessor(int index)
  {
    Decision aPredecessor = predecessors.get(index);
    return aPredecessor;
  }

  public List<Decision> getPredecessors()
  {
    List<Decision> newPredecessors = Collections.unmodifiableList(predecessors);
    return newPredecessors;
  }

  public int numberOfPredecessors()
  {
    int number = predecessors.size();
    return number;
  }

  public boolean hasPredecessors()
  {
    boolean has = predecessors.size() > 0;
    return has;
  }

  public int indexOfPredecessor(Decision aPredecessor)
  {
    int index = predecessors.indexOf(aPredecessor);
    return index;
  }

  public DecisionByBody getDecisionByBody(int index)
  {
    DecisionByBody aDecisionByBody = decisionByBodies.get(index);
    return aDecisionByBody;
  }

  public List<DecisionByBody> getDecisionByBodies()
  {
    List<DecisionByBody> newDecisionByBodies = Collections.unmodifiableList(decisionByBodies);
    return newDecisionByBodies;
  }

  public int numberOfDecisionByBodies()
  {
    int number = decisionByBodies.size();
    return number;
  }

  public boolean hasDecisionByBodies()
  {
    boolean has = decisionByBodies.size() > 0;
    return has;
  }

  public int indexOfDecisionByBody(DecisionByBody aDecisionByBody)
  {
    int index = decisionByBodies.indexOf(aDecisionByBody);
    return index;
  }

  public boolean setDecisionType(DecisionType aDecisionType)
  {
    boolean wasSet = false;
    if (aDecisionType == null)
    {
      return wasSet;
    }

    DecisionType existingDecisionType = decisionType;
    decisionType = aDecisionType;
    if (existingDecisionType != null && !existingDecisionType.equals(aDecisionType))
    {
      existingDecisionType.removeDecision(this);
    }
    decisionType.addDecision(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentStatus(DecisionByBody aNewCurrentStatus)
  {
    boolean wasSet = false;
    if (currentStatus != null && !currentStatus.equals(aNewCurrentStatus) && equals(currentStatus.getDecision()))
    {
      //Unable to setCurrentStatus, as existing currentStatus would become an orphan
      return wasSet;
    }

    currentStatus = aNewCurrentStatus;
    Decision anOldDecision = aNewCurrentStatus != null ? aNewCurrentStatus.getDecision() : null;

    if (!this.equals(anOldDecision))
    {
      if (anOldDecision != null)
      {
        anOldDecision.currentStatus = null;
      }
      if (currentStatus != null)
      {
        currentStatus.setDecision(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfSuccessors()
  {
    return 0;
  }

  public boolean addSuccessor(Decision aSuccessor)
  {
    boolean wasAdded = false;
    if (successors.contains(aSuccessor)) { return false; }
    successors.add(aSuccessor);
    if (aSuccessor.indexOfPredecessor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSuccessor.addPredecessor(this);
      if (!wasAdded)
      {
        successors.remove(aSuccessor);
      }
    }
    return wasAdded;
  }

  public boolean removeSuccessor(Decision aSuccessor)
  {
    boolean wasRemoved = false;
    if (!successors.contains(aSuccessor))
    {
      return wasRemoved;
    }

    int oldIndex = successors.indexOf(aSuccessor);
    successors.remove(oldIndex);
    if (aSuccessor.indexOfPredecessor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSuccessor.removePredecessor(this);
      if (!wasRemoved)
      {
        successors.add(oldIndex,aSuccessor);
      }
    }
    return wasRemoved;
  }

  public boolean addSuccessorAt(Decision aSuccessor, int index)
  {  
    boolean wasAdded = false;
    if(addSuccessor(aSuccessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuccessors()) { index = numberOfSuccessors() - 1; }
      successors.remove(aSuccessor);
      successors.add(index, aSuccessor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSuccessorAt(Decision aSuccessor, int index)
  {
    boolean wasAdded = false;
    if(successors.contains(aSuccessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuccessors()) { index = numberOfSuccessors() - 1; }
      successors.remove(aSuccessor);
      successors.add(index, aSuccessor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSuccessorAt(aSuccessor, index);
    }
    return wasAdded;
  }

  public boolean setOrganization(Organization aOrganization)
  {
    boolean wasSet = false;
    if (aOrganization == null)
    {
      return wasSet;
    }

    Organization existingOrganization = organization;
    organization = aOrganization;
    if (existingOrganization != null && !existingOrganization.equals(aOrganization))
    {
      existingOrganization.removeDecision(this);
    }
    organization.addDecision(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfPredecessors()
  {
    return 0;
  }

  public boolean addPredecessor(Decision aPredecessor)
  {
    boolean wasAdded = false;
    if (predecessors.contains(aPredecessor)) { return false; }
    predecessors.add(aPredecessor);
    if (aPredecessor.indexOfSuccessor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPredecessor.addSuccessor(this);
      if (!wasAdded)
      {
        predecessors.remove(aPredecessor);
      }
    }
    return wasAdded;
  }

  public boolean removePredecessor(Decision aPredecessor)
  {
    boolean wasRemoved = false;
    if (!predecessors.contains(aPredecessor))
    {
      return wasRemoved;
    }

    int oldIndex = predecessors.indexOf(aPredecessor);
    predecessors.remove(oldIndex);
    if (aPredecessor.indexOfSuccessor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPredecessor.removeSuccessor(this);
      if (!wasRemoved)
      {
        predecessors.add(oldIndex,aPredecessor);
      }
    }
    return wasRemoved;
  }

  public boolean addPredecessorAt(Decision aPredecessor, int index)
  {  
    boolean wasAdded = false;
    if(addPredecessor(aPredecessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPredecessors()) { index = numberOfPredecessors() - 1; }
      predecessors.remove(aPredecessor);
      predecessors.add(index, aPredecessor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePredecessorAt(Decision aPredecessor, int index)
  {
    boolean wasAdded = false;
    if(predecessors.contains(aPredecessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPredecessors()) { index = numberOfPredecessors() - 1; }
      predecessors.remove(aPredecessor);
      predecessors.add(index, aPredecessor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPredecessorAt(aPredecessor, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDecisionByBodies()
  {
    return 0;
  }

  public boolean addDecisionByBody(DecisionByBody aDecisionByBody)
  {
    boolean wasAdded = false;
    if (decisionByBodies.contains(aDecisionByBody)) { return false; }
    decisionByBodies.add(aDecisionByBody);
    if (aDecisionByBody.indexOfOnlyApprovedConditionalOnDecision(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDecisionByBody.addOnlyApprovedConditionalOnDecision(this);
      if (!wasAdded)
      {
        decisionByBodies.remove(aDecisionByBody);
      }
    }
    return wasAdded;
  }

  public boolean removeDecisionByBody(DecisionByBody aDecisionByBody)
  {
    boolean wasRemoved = false;
    if (!decisionByBodies.contains(aDecisionByBody))
    {
      return wasRemoved;
    }

    int oldIndex = decisionByBodies.indexOf(aDecisionByBody);
    decisionByBodies.remove(oldIndex);
    if (aDecisionByBody.indexOfOnlyApprovedConditionalOnDecision(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDecisionByBody.removeOnlyApprovedConditionalOnDecision(this);
      if (!wasRemoved)
      {
        decisionByBodies.add(oldIndex,aDecisionByBody);
      }
    }
    return wasRemoved;
  }

  public boolean addDecisionByBodyAt(DecisionByBody aDecisionByBody, int index)
  {  
    boolean wasAdded = false;
    if(addDecisionByBody(aDecisionByBody))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDecisionByBodies()) { index = numberOfDecisionByBodies() - 1; }
      decisionByBodies.remove(aDecisionByBody);
      decisionByBodies.add(index, aDecisionByBody);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDecisionByBodyAt(DecisionByBody aDecisionByBody, int index)
  {
    boolean wasAdded = false;
    if(decisionByBodies.contains(aDecisionByBody))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDecisionByBodies()) { index = numberOfDecisionByBodies() - 1; }
      decisionByBodies.remove(aDecisionByBody);
      decisionByBodies.add(index, aDecisionByBody);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDecisionByBodyAt(aDecisionByBody, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    DecisionType placeholderDecisionType = decisionType;
    this.decisionType = null;
    placeholderDecisionType.removeDecision(this);
    DecisionByBody existingCurrentStatus = currentStatus;
    currentStatus = null;
    if (existingCurrentStatus != null)
    {
      existingCurrentStatus.delete();
    }
    ArrayList<Decision> copyOfSuccessors = new ArrayList<Decision>(successors);
    successors.clear();
    for(Decision aSuccessor : copyOfSuccessors)
    {
      aSuccessor.removePredecessor(this);
    }
    Organization placeholderOrganization = organization;
    this.organization = null;
    placeholderOrganization.removeDecision(this);
    ArrayList<Decision> copyOfPredecessors = new ArrayList<Decision>(predecessors);
    predecessors.clear();
    for(Decision aPredecessor : copyOfPredecessors)
    {
      aPredecessor.removeSuccessor(this);
    }
    ArrayList<DecisionByBody> copyOfDecisionByBodies = new ArrayList<DecisionByBody>(decisionByBodies);
    decisionByBodies.clear();
    for(DecisionByBody aDecisionByBody : copyOfDecisionByBodies)
    {
      aDecisionByBody.removeOnlyApprovedConditionalOnDecision(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "isBeingConsidered" + ":" + getIsBeingConsidered()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "decisionType = "+(getDecisionType()!=null?Integer.toHexString(System.identityHashCode(getDecisionType())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentStatus = "+(getCurrentStatus()!=null?Integer.toHexString(System.identityHashCode(getCurrentStatus())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "organization = "+(getOrganization()!=null?Integer.toHexString(System.identityHashCode(getOrganization())):"null")
     + outputString;
  }
}