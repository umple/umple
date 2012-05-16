/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Election(int aIdElection, String aName, String aDescription)
  {
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

  public void delete()
  {}

}