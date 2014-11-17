/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * A committee or individual decision maker
 * OK to just call this Committee
 */
// line 20 "Decisions.ump"
// line 226 "Decisions.ump"
public class DecisionMakingBody
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DecisionMakingBody Attributes
  private String name;

  //DecisionMakingBody Associations
  private ApprovalLevel approvalLevel;
  private DecisionMakingBody superiorBody;
  private List<Membership> memberships;
  private Organization organization;
  private List<DecisionMakingBody> subordinateBodies;
  private List<DecisionByBody> decisionByBodies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DecisionMakingBody(String aName, ApprovalLevel aApprovalLevel, Organization aOrganization)
  {
    name = aName;
    boolean didAddApprovalLevel = setApprovalLevel(aApprovalLevel);
    if (!didAddApprovalLevel)
    {
      throw new RuntimeException("Unable to create decisionMakingBody due to approvalLevel");
    }
    memberships = new ArrayList<Membership>();
    boolean didAddOrganization = setOrganization(aOrganization);
    if (!didAddOrganization)
    {
      throw new RuntimeException("Unable to create decisionMakingBody due to organization");
    }
    subordinateBodies = new ArrayList<DecisionMakingBody>();
    decisionByBodies = new ArrayList<DecisionByBody>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public ApprovalLevel getApprovalLevel()
  {
    return approvalLevel;
  }

  public DecisionMakingBody getSuperiorBody()
  {
    return superiorBody;
  }

  public boolean hasSuperiorBody()
  {
    boolean has = superiorBody != null;
    return has;
  }

  public Membership getMembership(int index)
  {
    Membership aMembership = memberships.get(index);
    return aMembership;
  }

  /**
   * People who are members; can be temporarily empty
   */
  public List<Membership> getMemberships()
  {
    List<Membership> newMemberships = Collections.unmodifiableList(memberships);
    return newMemberships;
  }

  public int numberOfMemberships()
  {
    int number = memberships.size();
    return number;
  }

  public boolean hasMemberships()
  {
    boolean has = memberships.size() > 0;
    return has;
  }

  public int indexOfMembership(Membership aMembership)
  {
    int index = memberships.indexOf(aMembership);
    return index;
  }

  public Organization getOrganization()
  {
    return organization;
  }

  public DecisionMakingBody getSubordinateBody(int index)
  {
    DecisionMakingBody aSubordinateBody = subordinateBodies.get(index);
    return aSubordinateBody;
  }

  public List<DecisionMakingBody> getSubordinateBodies()
  {
    List<DecisionMakingBody> newSubordinateBodies = Collections.unmodifiableList(subordinateBodies);
    return newSubordinateBodies;
  }

  public int numberOfSubordinateBodies()
  {
    int number = subordinateBodies.size();
    return number;
  }

  public boolean hasSubordinateBodies()
  {
    boolean has = subordinateBodies.size() > 0;
    return has;
  }

  public int indexOfSubordinateBody(DecisionMakingBody aSubordinateBody)
  {
    int index = subordinateBodies.indexOf(aSubordinateBody);
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

  public boolean setApprovalLevel(ApprovalLevel aApprovalLevel)
  {
    boolean wasSet = false;
    if (aApprovalLevel == null)
    {
      return wasSet;
    }

    ApprovalLevel existingApprovalLevel = approvalLevel;
    approvalLevel = aApprovalLevel;
    if (existingApprovalLevel != null && !existingApprovalLevel.equals(aApprovalLevel))
    {
      existingApprovalLevel.removeDecisionMakingBody(this);
    }
    approvalLevel.addDecisionMakingBody(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setSuperiorBody(DecisionMakingBody aSuperiorBody)
  {
    boolean wasSet = false;
    DecisionMakingBody existingSuperiorBody = superiorBody;
    superiorBody = aSuperiorBody;
    if (existingSuperiorBody != null && !existingSuperiorBody.equals(aSuperiorBody))
    {
      existingSuperiorBody.removeSubordinateBody(this);
    }
    if (aSuperiorBody != null)
    {
      aSuperiorBody.addSubordinateBody(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfMemberships()
  {
    return 0;
  }

  public Membership addMembership(Date aStartDate, Date aEndDate, Person aPerson)
  {
    return new Membership(aStartDate, aEndDate, aPerson, this);
  }

  public boolean addMembership(Membership aMembership)
  {
    boolean wasAdded = false;
    if (memberships.contains(aMembership)) { return false; }
    DecisionMakingBody existingDecisionMakingBody = aMembership.getDecisionMakingBody();
    boolean isNewDecisionMakingBody = existingDecisionMakingBody != null && !this.equals(existingDecisionMakingBody);
    if (isNewDecisionMakingBody)
    {
      aMembership.setDecisionMakingBody(this);
    }
    else
    {
      memberships.add(aMembership);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMembership(Membership aMembership)
  {
    boolean wasRemoved = false;
    //Unable to remove aMembership, as it must always have a decisionMakingBody
    if (!this.equals(aMembership.getDecisionMakingBody()))
    {
      memberships.remove(aMembership);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMembershipAt(Membership aMembership, int index)
  {  
    boolean wasAdded = false;
    if(addMembership(aMembership))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMemberships()) { index = numberOfMemberships() - 1; }
      memberships.remove(aMembership);
      memberships.add(index, aMembership);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMembershipAt(Membership aMembership, int index)
  {
    boolean wasAdded = false;
    if(memberships.contains(aMembership))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMemberships()) { index = numberOfMemberships() - 1; }
      memberships.remove(aMembership);
      memberships.add(index, aMembership);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMembershipAt(aMembership, index);
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
      existingOrganization.removeDecisionMakingBody(this);
    }
    organization.addDecisionMakingBody(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfSubordinateBodies()
  {
    return 0;
  }

  public boolean addSubordinateBody(DecisionMakingBody aSubordinateBody)
  {
    boolean wasAdded = false;
    if (subordinateBodies.contains(aSubordinateBody)) { return false; }
    DecisionMakingBody existingSuperiorBody = aSubordinateBody.getSuperiorBody();
    if (existingSuperiorBody == null)
    {
      aSubordinateBody.setSuperiorBody(this);
    }
    else if (!this.equals(existingSuperiorBody))
    {
      existingSuperiorBody.removeSubordinateBody(aSubordinateBody);
      addSubordinateBody(aSubordinateBody);
    }
    else
    {
      subordinateBodies.add(aSubordinateBody);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubordinateBody(DecisionMakingBody aSubordinateBody)
  {
    boolean wasRemoved = false;
    if (subordinateBodies.contains(aSubordinateBody))
    {
      subordinateBodies.remove(aSubordinateBody);
      aSubordinateBody.setSuperiorBody(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubordinateBodyAt(DecisionMakingBody aSubordinateBody, int index)
  {  
    boolean wasAdded = false;
    if(addSubordinateBody(aSubordinateBody))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubordinateBodies()) { index = numberOfSubordinateBodies() - 1; }
      subordinateBodies.remove(aSubordinateBody);
      subordinateBodies.add(index, aSubordinateBody);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubordinateBodyAt(DecisionMakingBody aSubordinateBody, int index)
  {
    boolean wasAdded = false;
    if(subordinateBodies.contains(aSubordinateBody))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubordinateBodies()) { index = numberOfSubordinateBodies() - 1; }
      subordinateBodies.remove(aSubordinateBody);
      subordinateBodies.add(index, aSubordinateBody);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubordinateBodyAt(aSubordinateBody, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDecisionByBodies()
  {
    return 0;
  }

  public DecisionByBody addDecisionByBody(boolean aAccepted, DecisionSummaryVersion aDecisionSummaryVersion, Decision aDecision)
  {
    return new DecisionByBody(aAccepted, this, aDecisionSummaryVersion, aDecision);
  }

  public boolean addDecisionByBody(DecisionByBody aDecisionByBody)
  {
    boolean wasAdded = false;
    if (decisionByBodies.contains(aDecisionByBody)) { return false; }
    DecisionMakingBody existingDecider = aDecisionByBody.getDecider();
    boolean isNewDecider = existingDecider != null && !this.equals(existingDecider);
    if (isNewDecider)
    {
      aDecisionByBody.setDecider(this);
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
    //Unable to remove aDecisionByBody, as it must always have a decider
    if (!this.equals(aDecisionByBody.getDecider()))
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
    ApprovalLevel placeholderApprovalLevel = approvalLevel;
    this.approvalLevel = null;
    placeholderApprovalLevel.removeDecisionMakingBody(this);
    if (superiorBody != null)
    {
      DecisionMakingBody placeholderSuperiorBody = superiorBody;
      this.superiorBody = null;
      placeholderSuperiorBody.removeSubordinateBody(this);
    }
    for(int i=memberships.size(); i > 0; i--)
    {
      Membership aMembership = memberships.get(i - 1);
      aMembership.delete();
    }
    Organization placeholderOrganization = organization;
    this.organization = null;
    placeholderOrganization.removeDecisionMakingBody(this);
    while( !subordinateBodies.isEmpty() )
    {
      subordinateBodies.get(0).setSuperiorBody(null);
    }
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
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "approvalLevel = "+(getApprovalLevel()!=null?Integer.toHexString(System.identityHashCode(getApprovalLevel())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "organization = "+(getOrganization()!=null?Integer.toHexString(System.identityHashCode(getOrganization())):"null")
     + outputString;
  }
}