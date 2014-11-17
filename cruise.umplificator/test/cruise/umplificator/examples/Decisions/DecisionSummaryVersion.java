/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 75 "Decisions.ump"
// line 197 "Decisions.ump"
public class DecisionSummaryVersion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DecisionSummaryVersion Attributes
  private int versionNumber;
  private String shortSummary;

  //DecisionSummaryVersion Associations
  private List<DecisionByBody> decisionByBodies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DecisionSummaryVersion(int aVersionNumber, String aShortSummary)
  {
    versionNumber = aVersionNumber;
    shortSummary = aShortSummary;
    decisionByBodies = new ArrayList<DecisionByBody>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVersionNumber(int aVersionNumber)
  {
    boolean wasSet = false;
    versionNumber = aVersionNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setShortSummary(String aShortSummary)
  {
    boolean wasSet = false;
    shortSummary = aShortSummary;
    wasSet = true;
    return wasSet;
  }

  public int getVersionNumber()
  {
    return versionNumber;
  }

  public String getShortSummary()
  {
    return shortSummary;
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

  public static int minimumNumberOfDecisionByBodies()
  {
    return 0;
  }

  public DecisionByBody addDecisionByBody(boolean aAccepted, DecisionMakingBody aDecider, Decision aDecision)
  {
    return new DecisionByBody(aAccepted, aDecider, this, aDecision);
  }

  public boolean addDecisionByBody(DecisionByBody aDecisionByBody)
  {
    boolean wasAdded = false;
    if (decisionByBodies.contains(aDecisionByBody)) { return false; }
    DecisionSummaryVersion existingDecisionSummaryVersion = aDecisionByBody.getDecisionSummaryVersion();
    boolean isNewDecisionSummaryVersion = existingDecisionSummaryVersion != null && !this.equals(existingDecisionSummaryVersion);
    if (isNewDecisionSummaryVersion)
    {
      aDecisionByBody.setDecisionSummaryVersion(this);
    }
    else
    {
      decisionByBodies.add(aDecisionByBody);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDecisionByBody(DecisionByBody aDecisionByBody)
  {
    boolean wasRemoved = false;
    //Unable to remove aDecisionByBody, as it must always have a decisionSummaryVersion
    if (!this.equals(aDecisionByBody.getDecisionSummaryVersion()))
    {
      decisionByBodies.remove(aDecisionByBody);
      wasRemoved = true;
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
    for(int i=decisionByBodies.size(); i > 0; i--)
    {
      DecisionByBody aDecisionByBody = decisionByBodies.get(i - 1);
      aDecisionByBody.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "versionNumber" + ":" + getVersionNumber()+ "," +
            "shortSummary" + ":" + getShortSummary()+ "]"
     + outputString;
  }
}