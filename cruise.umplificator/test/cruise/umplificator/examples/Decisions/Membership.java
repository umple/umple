/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;

// line 31 "Decisions.ump"
// line 191 "Decisions.ump"
public class Membership
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Membership Attributes
  private Date startDate;
  private Date endDate;

  //Membership Associations
  private Person person;
  private DecisionMakingBody decisionMakingBody;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Membership(Date aStartDate, Date aEndDate, Person aPerson, DecisionMakingBody aDecisionMakingBody)
  {
    startDate = aStartDate;
    endDate = aEndDate;
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create membership due to person");
    }
    boolean didAddDecisionMakingBody = setDecisionMakingBody(aDecisionMakingBody);
    if (!didAddDecisionMakingBody)
    {
      throw new RuntimeException("Unable to create membership due to decisionMakingBody");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartDate(Date aStartDate)
  {
    boolean wasSet = false;
    startDate = aStartDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndDate(Date aEndDate)
  {
    boolean wasSet = false;
    endDate = aEndDate;
    wasSet = true;
    return wasSet;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public Person getPerson()
  {
    return person;
  }

  public DecisionMakingBody getDecisionMakingBody()
  {
    return decisionMakingBody;
  }

  public boolean setPerson(Person aPerson)
  {
    boolean wasSet = false;
    if (aPerson == null)
    {
      return wasSet;
    }

    Person existingPerson = person;
    person = aPerson;
    if (existingPerson != null && !existingPerson.equals(aPerson))
    {
      existingPerson.removeMembership(this);
    }
    person.addMembership(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setDecisionMakingBody(DecisionMakingBody aDecisionMakingBody)
  {
    boolean wasSet = false;
    if (aDecisionMakingBody == null)
    {
      return wasSet;
    }

    DecisionMakingBody existingDecisionMakingBody = decisionMakingBody;
    decisionMakingBody = aDecisionMakingBody;
    if (existingDecisionMakingBody != null && !existingDecisionMakingBody.equals(aDecisionMakingBody))
    {
      existingDecisionMakingBody.removeMembership(this);
    }
    decisionMakingBody.addMembership(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Person placeholderPerson = person;
    this.person = null;
    placeholderPerson.removeMembership(this);
    DecisionMakingBody placeholderDecisionMakingBody = decisionMakingBody;
    this.decisionMakingBody = null;
    placeholderDecisionMakingBody.removeMembership(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startDate" + "=" + (getStartDate() != null ? !getStartDate().equals(this)  ? getStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endDate" + "=" + (getEndDate() != null ? !getEndDate().equals(this)  ? getEndDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "decisionMakingBody = "+(getDecisionMakingBody()!=null?Integer.toHexString(System.identityHashCode(getDecisionMakingBody())):"null")
     + outputString;
  }
}