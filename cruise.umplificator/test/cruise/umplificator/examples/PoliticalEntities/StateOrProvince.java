/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 26 "PoliticalEntities.ump"
// line 41 "PoliticalEntities.ump"
public class StateOrProvince extends Territory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateOrProvince Associations
  private Country country;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateOrProvince(String aName, Country aCountry)
  {
    super(aName);
    boolean didAddCountry = setCountry(aCountry);
    if (!didAddCountry)
    {
      throw new RuntimeException("Unable to create stateOrProvince due to country");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Country getCountry()
  {
    return country;
  }

  public boolean setCountry(Country aCountry)
  {
    boolean wasSet = false;
    if (aCountry == null)
    {
      return wasSet;
    }

    Country existingCountry = country;
    country = aCountry;
    if (existingCountry != null && !existingCountry.equals(aCountry))
    {
      existingCountry.removeStateOrProvince(this);
    }
    country.addStateOrProvince(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Country placeholderCountry = country;
    this.country = null;
    placeholderCountry.removeStateOrProvince(this);
    super.delete();
  }

}