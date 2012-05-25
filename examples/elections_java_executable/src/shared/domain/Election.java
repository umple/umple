/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;

public class Election
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Election Attributes
  private int idElection;
  private String name;
  private String description;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdElection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Election(int aIdElection, String aName, String aDescription)
  {
    cachedHashCode = -1;
    canSetIdElection = true;
    idElection = aIdElection;
    name = aName;
    description = aDescription;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdElection(int aIdElection)
  {
    boolean wasSet = false;
    if (!canSetIdElection) { return false; }
    idElection = aIdElection;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public int getIdElection()
  {
    return idElection;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Election compareTo = (Election)obj;
  
    if (idElection != compareTo.idElection)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + idElection;

    canSetIdElection = false;
    return cachedHashCode;
  }

  public void delete()
  {}

}