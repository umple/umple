/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 6 "BankingSystemA.ump"
// line 158 "BankingSystemA.ump"
public class PersonRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PersonRole Associations
  private Person person;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PersonRole(Person aPerson)
  {
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create personRole due to person");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Person getPerson()
  {
    return person;
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
      existingPerson.removePersonRole(this);
    }
    person.addPersonRole(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Person placeholderPerson = person;
    this.person = null;
    placeholderPerson.removePersonRole(this);
  }

}