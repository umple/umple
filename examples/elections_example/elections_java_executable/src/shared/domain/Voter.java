/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;

public class Voter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Voter Attributes
  private int idVoter;
  private String name;
  private String address;
  private String telephone;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdVoter;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Voter(int aIdVoter, String aName, String aAddress, String aTelephone)
  {
    cachedHashCode = -1;
    canSetIdVoter = true;
    idVoter = aIdVoter;
    name = aName;
    address = aAddress;
    telephone = aTelephone;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdVoter(int aIdVoter)
  {
    boolean wasSet = false;
    if (!canSetIdVoter) { return false; }
    idVoter = aIdVoter;
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

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setTelephone(String aTelephone)
  {
    boolean wasSet = false;
    telephone = aTelephone;
    wasSet = true;
    return wasSet;
  }

  public int getIdVoter()
  {
    return idVoter;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getTelephone()
  {
    return telephone;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Voter compareTo = (Voter)obj;
  
    if (idVoter != compareTo.idVoter)
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
    cachedHashCode = cachedHashCode * 23 + idVoter;

    canSetIdVoter = false;
    return cachedHashCode;
  }

  public void delete()
  {}

}