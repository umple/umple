/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package BankingSystem.core.tangableResources;
import java.util.*;

// line 8 "../../../../BankingSystemA.ump"
// line 103 "../../../../BankingSystemA.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private String address;
  private String phoneNumber;

  //Person Associations
  private List<PersonRole> personRoles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, String aAddress, String aPhoneNumber)
  {
    name = aName;
    address = aAddress;
    phoneNumber = aPhoneNumber;
    personRoles = new ArrayList<PersonRole>();
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

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
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

  public static int minimumNumberOfPersonRoles()
  {
    return 0;
  }

  public PersonRole addPersonRole()
  {
    return new PersonRole(this);
  }

  public boolean addPersonRole(PersonRole aPersonRole)
  {
    boolean wasAdded = false;
    if (personRoles.contains(aPersonRole)) { return false; }
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

  public void delete()
  {
    for(int i=personRoles.size(); i > 0; i--)
    {
      PersonRole aPersonRole = personRoles.get(i - 1);
      aPersonRole.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "]"
     + outputString;
  }
}