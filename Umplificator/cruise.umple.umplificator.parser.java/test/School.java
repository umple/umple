

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.617 modeling language!*/

import java.util.*;

public class School
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //School Attributes
  private String name;
  private String address;
  private String description;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public School(String aName, String aAddress, String aDescription)
  {
    name = aName;
    address = aAddress;
    description = aDescription;
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

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
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

  public String getDescription()
  {
    return description;
  }

  public void delete()
  {}

}

