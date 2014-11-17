/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.util.*;

/**
 * Tracks the progress of a decision as it is approved and changed
 */
// line 55 "Decisions.ump"
// line 160 "Decisions.ump"
public class DecisionByBody
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DecisionByBody Attributes
  private Date dateOfDecision;
  private boolean accepted;

  //DecisionByBody Associations
  private DecisionMakingBody decider;
  private DecisionSummaryVersion decisionSummaryVersion;
  private List<DocumentVersion> documentsForDecision;
  private DecisionByBody next;
  private List<ChangeRequest> changeRequests;
  private List<Decision> onlyApprovedConditionalOnDecision;
  private Decision decision;
  private DecisionByBody previous;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DecisionByBody(boolean aAccepted, DecisionMakingBody aDecider, DecisionSummaryVersion aDecisionSummaryVersion, Decision aDecision)
  {
    dateOfDecision = null;
    accepted = aAccepted;
    boolean didAddDecider = setDecider(aDecider);
    if (!didAddDecider)
    {
      throw new RuntimeException("Unable to create decisionByBody due to decider");
    }
    boolean didAddDecisionSummaryVersion = setDecisionSummaryVersion(aDecisionSummaryVersion);
    if (!didAddDecisionSummaryVersion)
    {
      throw new RuntimeException("Unable to create decisionByBody due to decisionSummaryVersion");
    }
    documentsForDecision = new ArrayList<DocumentVersion>();
    changeRequests = new ArrayList<ChangeRequest>();
    onlyApprovedConditionalOnDecision = new ArrayList<Decision>();
    boolean didAddDecision = setDecision(aDecision);
    if (!didAddDecision)
    {
      throw new RuntimeException("Unable to create currentStatus due to decision");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDateOfDecision(Date aDateOfDecision)
  {
    boolean wasSet = false;
    dateOfDecision = aDateOfDecision;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccepted(boolean aAccepted)
  {
    boolean wasSet = false;
    accepted = aAccepted;
    wasSet = true;
    return wasSet;
  }

  /**
   * Null of not yet made
   */
  public Date getDateOfDecision()
  {
    return dateOfDecision;
  }

  /**
   * false if not approved and would have to go back down
   */
  public boolean getAccepted()
  {
    return accepted;
  }

  public boolean isAccepted()
  {
    return accepted;
  }

  public DecisionMakingBody getDecider()
  {
    return decider;
  }

  public DecisionSummaryVersion getDecisionSummaryVersion()
  {
    return decisionSummaryVersion;
  }

  public DocumentVersion getDocumentsForDecision(int index)
  {
    DocumentVersion aDocumentsForDecision = documentsForDecision.get(index);
    return aDocumentsForDecision;
  }

  /**
   * The versions of the documents as presented and discussed
   */
  public List<DocumentVersion> getDocumentsForDecision()
  {
    List<DocumentVersion> newDocumentsForDecision = Collections.unmodifiableList(documentsForDecision);
    return newDocumentsForDecision;
  }

  public int numberOfDocumentsForDecision()
  {
    int number = documentsForDecision.size();
    return number;
  }

  public boolean hasDocumentsForDecision()
  {
    boolean has = documentsForDecision.size() > 0;
    return has;
  }

  public int indexOfDocumentsForDecision(DocumentVersion aDocumentsForDecision)
  {
    int index = documentsForDecision.indexOf(aDocumentsForDecision);
    return index;
  }

  public DecisionByBody getNext()
  {
    return next;
  }

  public boolean hasNext()
  {
    boolean has = next != null;
    return has;
  }

  public ChangeRequest getChangeRequest(int index)
  {
    ChangeRequest aChangeRequest = changeRequests.get(index);
    return aChangeRequest;
  }

  /**
   * The requests the body has made
   */
  public List<ChangeRequest> getChangeRequests()
  {
    List<ChangeRequest> newChangeRequests = Collections.unmodifiableList(changeRequests);
    return newChangeRequests;
  }

  public int numberOfChangeRequests()
  {
    int number = changeRequests.size();
    return number;
  }

  public boolean hasChangeRequests()
  {
    boolean has = changeRequests.size() > 0;
    return has;
  }

  public int indexOfChangeRequest(ChangeRequest aChangeRequest)
  {
    int index = changeRequests.indexOf(aChangeRequest);
    return index;
  }

  public Decision getOnlyApprovedConditionalOnDecision(int index)
  {
    Decision aOnlyApprovedConditionalOnDecision = onlyApprovedConditionalOnDecision.get(index);
    return aOnlyApprovedConditionalOnDecision;
  }

  /**
   * Conditional approval
   */
  public List<Decision> getOnlyApprovedConditionalOnDecision()
  {
    List<Decision> newOnlyApprovedConditionalOnDecision = Collections.unmodifiableList(onlyApprovedConditionalOnDecision);
    return newOnlyApprovedConditionalOnDecision;
  }

  public int numberOfOnlyApprovedConditionalOnDecision()
  {
    int number = onlyApprovedConditionalOnDecision.size();
    return number;
  }

  public boolean hasOnlyApprovedConditionalOnDecision()
  {
    boolean has = onlyApprovedConditionalOnDecision.size() > 0;
    return has;
  }

  public int indexOfOnlyApprovedConditionalOnDecision(Decision aOnlyApprovedConditionalOnDecision)
  {
    int index = onlyApprovedConditionalOnDecision.indexOf(aOnlyApprovedConditionalOnDecision);
    return index;
  }

  public Decision getDecision()
  {
    return decision;
  }

  public DecisionByBody getPrevious()
  {
    return previous;
  }

  public boolean hasPrevious()
  {
    boolean has = previous != null;
    return has;
  }

  public boolean setDecider(DecisionMakingBody aDecider)
  {
    boolean wasSet = false;
    if (aDecider == null)
    {
      return wasSet;
    }

    DecisionMakingBody existingDecider = decider;
    decider = aDecider;
    if (existingDecider != null && !existingDecider.equals(aDecider))
    {
      existingDecider.removeDecisionByBody(this);
    }
    decider.addDecisionByBody(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setDecisionSummaryVersion(DecisionSummaryVersion aDecisionSummaryVersion)
  {
    boolean wasSet = false;
    if (aDecisionSummaryVersion == null)
    {
      return wasSet;
    }

    DecisionSummaryVersion existingDecisionSummaryVersion = decisionSummaryVersion;
    decisionSummaryVersion = aDecisionSummaryVersion;
    if (existingDecisionSummaryVersion != null && !existingDecisionSummaryVersion.equals(aDecisionSummaryVersion))
    {
      existingDecisionSummaryVersion.removeDecisionByBody(this);
    }
    decisionSummaryVersion.addDecisionByBody(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfDocumentsForDecision()
  {
    return 0;
  }

  public boolean addDocumentsForDecision(DocumentVersion aDocumentsForDecision)
  {
    boolean wasAdded = false;
    if (documentsForDecision.contains(aDocumentsForDecision)) { return false; }
    documentsForDecision.add(aDocumentsForDecision);
    if (aDocumentsForDecision.indexOfUsedInDecision(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDocumentsForDecision.addUsedInDecision(this);
      if (!wasAdded)
      {
        documentsForDecision.remove(aDocumentsForDecision);
      }
    }
    return wasAdded;
  }

  public boolean removeDocumentsForDecision(DocumentVersion aDocumentsForDecision)
  {
    boolean wasRemoved = false;
    if (!documentsForDecision.contains(aDocumentsForDecision))
    {
      return wasRemoved;
    }

    int oldIndex = documentsForDecision.indexOf(aDocumentsForDecision);
    documentsForDecision.remove(oldIndex);
    if (aDocumentsForDecision.indexOfUsedInDecision(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDocumentsForDecision.removeUsedInDecision(this);
      if (!wasRemoved)
      {
        documentsForDecision.add(oldIndex,aDocumentsForDecision);
      }
    }
    return wasRemoved;
  }

  public boolean addDocumentsForDecisionAt(DocumentVersion aDocumentsForDecision, int index)
  {  
    boolean wasAdded = false;
    if(addDocumentsForDecision(aDocumentsForDecision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDocumentsForDecision()) { index = numberOfDocumentsForDecision() - 1; }
      documentsForDecision.remove(aDocumentsForDecision);
      documentsForDecision.add(index, aDocumentsForDecision);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDocumentsForDecisionAt(DocumentVersion aDocumentsForDecision, int index)
  {
    boolean wasAdded = false;
    if(documentsForDecision.contains(aDocumentsForDecision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDocumentsForDecision()) { index = numberOfDocumentsForDecision() - 1; }
      documentsForDecision.remove(aDocumentsForDecision);
      documentsForDecision.add(index, aDocumentsForDecision);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDocumentsForDecisionAt(aDocumentsForDecision, index);
    }
    return wasAdded;
  }

  public boolean setNext(DecisionByBody aNewNext)
  {
    boolean wasSet = false;
    if (aNewNext == null)
    {
      DecisionByBody existingNext = next;
      next = null;
      
      if (existingNext != null && existingNext.getPrevious() != null)
      {
        existingNext.setPrevious(null);
      }
      wasSet = true;
      return wasSet;
    }

    DecisionByBody currentNext = getNext();
    if (currentNext != null && !currentNext.equals(aNewNext))
    {
      currentNext.setPrevious(null);
    }

    next = aNewNext;
    DecisionByBody existingPrevious = aNewNext.getPrevious();

    if (!equals(existingPrevious))
    {
      aNewNext.setPrevious(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfChangeRequests()
  {
    return 0;
  }

  public boolean addChangeRequest(ChangeRequest aChangeRequest)
  {
    boolean wasAdded = false;
    if (changeRequests.contains(aChangeRequest)) { return false; }
    changeRequests.add(aChangeRequest);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeChangeRequest(ChangeRequest aChangeRequest)
  {
    boolean wasRemoved = false;
    if (changeRequests.contains(aChangeRequest))
    {
      changeRequests.remove(aChangeRequest);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addChangeRequestAt(ChangeRequest aChangeRequest, int index)
  {  
    boolean wasAdded = false;
    if(addChangeRequest(aChangeRequest))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChangeRequests()) { index = numberOfChangeRequests() - 1; }
      changeRequests.remove(aChangeRequest);
      changeRequests.add(index, aChangeRequest);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveChangeRequestAt(ChangeRequest aChangeRequest, int index)
  {
    boolean wasAdded = false;
    if(changeRequests.contains(aChangeRequest))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChangeRequests()) { index = numberOfChangeRequests() - 1; }
      changeRequests.remove(aChangeRequest);
      changeRequests.add(index, aChangeRequest);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addChangeRequestAt(aChangeRequest, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfOnlyApprovedConditionalOnDecision()
  {
    return 0;
  }

  public boolean addOnlyApprovedConditionalOnDecision(Decision aOnlyApprovedConditionalOnDecision)
  {
    boolean wasAdded = false;
    if (onlyApprovedConditionalOnDecision.contains(aOnlyApprovedConditionalOnDecision)) { return false; }
    onlyApprovedConditionalOnDecision.add(aOnlyApprovedConditionalOnDecision);
    if (aOnlyApprovedConditionalOnDecision.indexOfDecisionByBody(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOnlyApprovedConditionalOnDecision.addDecisionByBody(this);
      if (!wasAdded)
      {
        onlyApprovedConditionalOnDecision.remove(aOnlyApprovedConditionalOnDecision);
      }
    }
    return wasAdded;
  }

  public boolean removeOnlyApprovedConditionalOnDecision(Decision aOnlyApprovedConditionalOnDecision)
  {
    boolean wasRemoved = false;
    if (!onlyApprovedConditionalOnDecision.contains(aOnlyApprovedConditionalOnDecision))
    {
      return wasRemoved;
    }

    int oldIndex = onlyApprovedConditionalOnDecision.indexOf(aOnlyApprovedConditionalOnDecision);
    onlyApprovedConditionalOnDecision.remove(oldIndex);
    if (aOnlyApprovedConditionalOnDecision.indexOfDecisionByBody(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOnlyApprovedConditionalOnDecision.removeDecisionByBody(this);
      if (!wasRemoved)
      {
        onlyApprovedConditionalOnDecision.add(oldIndex,aOnlyApprovedConditionalOnDecision);
      }
    }
    return wasRemoved;
  }

  public boolean addOnlyApprovedConditionalOnDecisionAt(Decision aOnlyApprovedConditionalOnDecision, int index)
  {  
    boolean wasAdded = false;
    if(addOnlyApprovedConditionalOnDecision(aOnlyApprovedConditionalOnDecision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOnlyApprovedConditionalOnDecision()) { index = numberOfOnlyApprovedConditionalOnDecision() - 1; }
      onlyApprovedConditionalOnDecision.remove(aOnlyApprovedConditionalOnDecision);
      onlyApprovedConditionalOnDecision.add(index, aOnlyApprovedConditionalOnDecision);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOnlyApprovedConditionalOnDecisionAt(Decision aOnlyApprovedConditionalOnDecision, int index)
  {
    boolean wasAdded = false;
    if(onlyApprovedConditionalOnDecision.contains(aOnlyApprovedConditionalOnDecision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOnlyApprovedConditionalOnDecision()) { index = numberOfOnlyApprovedConditionalOnDecision() - 1; }
      onlyApprovedConditionalOnDecision.remove(aOnlyApprovedConditionalOnDecision);
      onlyApprovedConditionalOnDecision.add(index, aOnlyApprovedConditionalOnDecision);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOnlyApprovedConditionalOnDecisionAt(aOnlyApprovedConditionalOnDecision, index);
    }
    return wasAdded;
  }

  public boolean setDecision(Decision aNewDecision)
  {
    boolean wasSet = false;
    if (aNewDecision == null)
    {
      //Unable to setDecision to null, as currentStatus must always be associated to a decision
      return wasSet;
    }
    
    DecisionByBody existingCurrentStatus = aNewDecision.getCurrentStatus();
    if (existingCurrentStatus != null && !equals(existingCurrentStatus))
    {
      //Unable to setDecision, the current decision already has a currentStatus, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Decision anOldDecision = decision;
    decision = aNewDecision;
    decision.setCurrentStatus(this);

    if (anOldDecision != null)
    {
      anOldDecision.setCurrentStatus(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setPrevious(DecisionByBody aNewPrevious)
  {
    boolean wasSet = false;
    if (aNewPrevious == null)
    {
      DecisionByBody existingPrevious = previous;
      previous = null;
      
      if (existingPrevious != null && existingPrevious.getNext() != null)
      {
        existingPrevious.setNext(null);
      }
      wasSet = true;
      return wasSet;
    }

    DecisionByBody currentPrevious = getPrevious();
    if (currentPrevious != null && !currentPrevious.equals(aNewPrevious))
    {
      currentPrevious.setNext(null);
    }

    previous = aNewPrevious;
    DecisionByBody existingNext = aNewPrevious.getNext();

    if (!equals(existingNext))
    {
      aNewPrevious.setNext(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    DecisionMakingBody placeholderDecider = decider;
    this.decider = null;
    placeholderDecider.removeDecisionByBody(this);
    DecisionSummaryVersion placeholderDecisionSummaryVersion = decisionSummaryVersion;
    this.decisionSummaryVersion = null;
    placeholderDecisionSummaryVersion.removeDecisionByBody(this);
    ArrayList<DocumentVersion> copyOfDocumentsForDecision = new ArrayList<DocumentVersion>(documentsForDecision);
    documentsForDecision.clear();
    for(DocumentVersion aDocumentsForDecision : copyOfDocumentsForDecision)
    {
      aDocumentsForDecision.removeUsedInDecision(this);
    }
    if (next != null)
    {
      next.setPrevious(null);
    }
    changeRequests.clear();
    ArrayList<Decision> copyOfOnlyApprovedConditionalOnDecision = new ArrayList<Decision>(onlyApprovedConditionalOnDecision);
    onlyApprovedConditionalOnDecision.clear();
    for(Decision aOnlyApprovedConditionalOnDecision : copyOfOnlyApprovedConditionalOnDecision)
    {
      aOnlyApprovedConditionalOnDecision.removeDecisionByBody(this);
    }
    Decision existingDecision = decision;
    decision = null;
    if (existingDecision != null)
    {
      existingDecision.setCurrentStatus(null);
    }
    if (previous != null)
    {
      previous.setNext(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "accepted" + ":" + getAccepted()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfDecision" + "=" + (getDateOfDecision() != null ? !getDateOfDecision().equals(this)  ? getDateOfDecision().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "decider = "+(getDecider()!=null?Integer.toHexString(System.identityHashCode(getDecider())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "decisionSummaryVersion = "+(getDecisionSummaryVersion()!=null?Integer.toHexString(System.identityHashCode(getDecisionSummaryVersion())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "decision = "+(getDecision()!=null?Integer.toHexString(System.identityHashCode(getDecision())):"null")
     + outputString;
  }
}