/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 46 "AirlineExample.ump"
// line 67 "AirlineExample.ump"
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
    //Must provide person to personRole
    if (aPerson == null)
    {
      return wasSet;
    }

    //person already at maximum (2)
    if (aPerson.numberOfPersonRoles() >= Person.maximumNumberOfPersonRoles())
    {
      return wasSet;
    }
    
    Person existingPerson = person;
    person = aPerson;
    if (existingPerson != null && !existingPerson.equals(aPerson))
    {
      boolean didRemove = existingPerson.removePersonRole(this);
      if (!didRemove)
      {
        person = existingPerson;
        return wasSet;
      }
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