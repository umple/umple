/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 10 "Decisions.ump"
// line 185 "Decisions.ump"
public class Organization
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Organization theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Organization Attributes
  private String name;

  //Organization Associations
  private List<Decision> decisions;
  private List<DecisionMakingBody> decisionMakingBodies;
  private List<Person> users;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Organization()
  {
    name = null;
    decisions = new ArrayList<Decision>();
    decisionMakingBodies = new ArrayList<DecisionMakingBody>();
    users = new ArrayList<Person>();
  }

  public static Organization getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Organization();
    }
    return theInstance;
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

  public Person getUser(int index)
  {
    Person aUser = users.get(index);
    return aUser;
  }

  public List<Person> getUsers()
  {
    List<Person> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(Person aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }

  public static int minimumNumberOfDecisions()
  {
    return 0;
  }

  public Decision addDecision(String aId, boolean aIsBeingConsidered, DecisionType aDecisionType)
  {
    return new Decision(aId, aIsBeingConsidered, aDecisionType, this);
  }

  public boolean addDecision(Decision aDecision)
  {
    boolean wasAdded = false;
    if (decisions.contains(aDecision)) { return false; }
    Organization existingOrganization = aDecision.getOrganization();
    boolean isNewOrganization = existingOrganization != null && !this.equals(existingOrganization);
    if (isNewOrganization)
    {
      aDecision.setOrganization(this);
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
    //Unable to remove aDecision, as it must always have a organization
    if (!this.equals(aDecision.getOrganization()))
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

  public static int minimumNumberOfDecisionMakingBodies()
  {
    return 0;
  }

  public DecisionMakingBody addDecisionMakingBody(String aName, ApprovalLevel aApprovalLevel)
  {
    return new DecisionMakingBody(aName, aApprovalLevel, this);
  }

  public boolean addDecisionMakingBody(DecisionMakingBody aDecisionMakingBody)
  {
    boolean wasAdded = false;
    if (decisionMakingBodies.contains(aDecisionMakingBody)) { return false; }
    Organization existingOrganization = aDecisionMakingBody.getOrganization();
    boolean isNewOrganization = existingOrganization != null && !this.equals(existingOrganization);
    if (isNewOrganization)
    {
      aDecisionMakingBody.setOrganization(this);
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
    //Unable to remove aDecisionMakingBody, as it must always have a organization
    if (!this.equals(aDecisionMakingBody.getOrganization()))
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

  public static int minimumNumberOfUsers()
  {
    return 0;
  }

  public Person addUser(String aName)
  {
    return new Person(aName, this);
  }

  public boolean addUser(Person aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    Organization existingOrganization = aUser.getOrganization();
    boolean isNewOrganization = existingOrganization != null && !this.equals(existingOrganization);
    if (isNewOrganization)
    {
      aUser.setOrganization(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(Person aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a organization
    if (!this.equals(aUser.getOrganization()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addUserAt(Person aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(Person aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=decisions.size(); i > 0; i--)
    {
      Decision aDecision = decisions.get(i - 1);
      aDecision.delete();
    }
    for(int i=decisionMakingBodies.size(); i > 0; i--)
    {
      DecisionMakingBody aDecisionMakingBody = decisionMakingBodies.get(i - 1);
      aDecisionMakingBody.delete();
    }
    for(int i=users.size(); i > 0; i--)
    {
      Person aUser = users.get(i - 1);
      aUser.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}