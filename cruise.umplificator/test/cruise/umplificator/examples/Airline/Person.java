/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * LAYOUT INFORMATION
 */
// line 39 "Airline.ump"
// line 54 "Airline.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private int idNumber;

  //Person Associations
  private List<PersonRole> personRoles;
  private Airline airline;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, int aIdNumber, Airline aAirline)
  {
    name = aName;
    idNumber = aIdNumber;
    personRoles = new ArrayList<PersonRole>();
    boolean didAddAirline = setAirline(aAirline);
    if (!didAddAirline)
    {
      throw new RuntimeException("Unable to create person due to airline");
    }
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

  public boolean setIdNumber(int aIdNumber)
  {
    boolean wasSet = false;
    idNumber = aIdNumber;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getIdNumber()
  {
    return idNumber;
  }

  public PersonRole getPersonRole(int index)
  {
    PersonRole aPersonRole = personRoles.get(index);
    return aPersonRole;
  }

  public List<PersonRole> getPersonRoles()
  {
    List<PersonRole> newPersonRoles = Collections.unmodifiableList(personRoles);
    return newPersonRoles;
  }

  public int numberOfPersonRoles()
  {
    int number = personRoles.size();
    return number;
  }

  public boolean hasPersonRoles()
  {
    boolean has = personRoles.size() > 0;
    return has;
  }

  public int indexOfPersonRole(PersonRole aPersonRole)
  {
    int index = personRoles.indexOf(aPersonRole);
    return index;
  }

  public Airline getAirline()
  {
    return airline;
  }

  public static int minimumNumberOfPersonRoles()
  {
    return 0;
  }

  public static int maximumNumberOfPersonRoles()
  {
    return 2;
  }

  public PersonRole addPersonRole()
  {
    if (numberOfPersonRoles() >= maximumNumberOfPersonRoles())
    {
      return null;
    }
    else
    {
      return new PersonRole(this);
    }
  }

  public boolean addPersonRole(PersonRole aPersonRole)
  {
    boolean wasAdded = false;
    if (personRoles.contains(aPersonRole)) { return false; }
    if (numberOfPersonRoles() >= maximumNumberOfPersonRoles())
    {
      return wasAdded;
    }

    Person existingPerson = aPersonRole.getPerson();
    boolean isNewPerson = existingPerson != null && !this.equals(existingPerson);
    if (isNewPerson)
    {
      aPersonRole.setPerson(this);
    }
    else
    {
      personRoles.add(aPersonRole);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePersonRole(PersonRole aPersonRole)
  {
    boolean wasRemoved = false;
    //Unable to remove aPersonRole, as it must always have a person
    if (!this.equals(aPersonRole.getPerson()))
    {
      personRoles.remove(aPersonRole);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPersonRoleAt(PersonRole aPersonRole, int index)
  {  
    boolean wasAdded = false;
    if(addPersonRole(aPersonRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersonRoles()) { index = numberOfPersonRoles() - 1; }
      personRoles.remove(aPersonRole);
      personRoles.add(index, aPersonRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePersonRoleAt(PersonRole aPersonRole, int index)
  {
    boolean wasAdded = false;
    if(personRoles.contains(aPersonRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersonRoles()) { index = numberOfPersonRoles() - 1; }
      personRoles.remove(aPersonRole);
      personRoles.add(index, aPersonRole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPersonRoleAt(aPersonRole, index);
    }
    return wasAdded;
  }

  public boolean setAirline(Airline aAirline)
  {
    boolean wasSet = false;
    if (aAirline == null)
    {
      return wasSet;
    }

    Airline existingAirline = airline;
    airline = aAirline;
    if (existingAirline != null && !existingAirline.equals(aAirline))
    {
      existingAirline.removePerson(this);
    }
    airline.addPerson(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=personRoles.size(); i > 0; i--)
    {
      PersonRole aPersonRole = personRoles.get(i - 1);
      aPersonRole.delete();
    }
    Airline placeholderAirline = airline;
    this.airline = null;
    placeholderAirline.removePerson(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "idNumber" + ":" + getIdNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "airline = "+(getAirline()!=null?Integer.toHexString(System.identityHashCode(getAirline())):"null")
     + outputString;
  }
}