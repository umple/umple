/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 21 "PoliticalEntities.ump"
// line 46 "PoliticalEntities.ump"
public class Country extends Territory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Country Associations
  private List<StateOrProvince> stateOrProvinces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Country(String aName)
  {
    super(aName);
    stateOrProvinces = new ArrayList<StateOrProvince>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public StateOrProvince getStateOrProvince(int index)
  {
    StateOrProvince aStateOrProvince = stateOrProvinces.get(index);
    return aStateOrProvince;
  }

  public List<StateOrProvince> getStateOrProvinces()
  {
    List<StateOrProvince> newStateOrProvinces = Collections.unmodifiableList(stateOrProvinces);
    return newStateOrProvinces;
  }

  public int numberOfStateOrProvinces()
  {
    int number = stateOrProvinces.size();
    return number;
  }

  public boolean hasStateOrProvinces()
  {
    boolean has = stateOrProvinces.size() > 0;
    return has;
  }

  public int indexOfStateOrProvince(StateOrProvince aStateOrProvince)
  {
    int index = stateOrProvinces.indexOf(aStateOrProvince);
    return index;
  }

  public static int minimumNumberOfStateOrProvinces()
  {
    return 0;
  }

  public StateOrProvince addStateOrProvince(String aName)
  {
    return new StateOrProvince(aName, this);
  }

  public boolean addStateOrProvince(StateOrProvince aStateOrProvince)
  {
    boolean wasAdded = false;
    if (stateOrProvinces.contains(aStateOrProvince)) { return false; }
    Country existingCountry = aStateOrProvince.getCountry();
    boolean isNewCountry = existingCountry != null && !this.equals(existingCountry);
    if (isNewCountry)
    {
      aStateOrProvince.setCountry(this);
    }
    else
    {
      stateOrProvinces.add(aStateOrProvince);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStateOrProvince(StateOrProvince aStateOrProvince)
  {
    boolean wasRemoved = false;
    //Unable to remove aStateOrProvince, as it must always have a country
    if (!this.equals(aStateOrProvince.getCountry()))
    {
      stateOrProvinces.remove(aStateOrProvince);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStateOrProvinceAt(StateOrProvince aStateOrProvince, int index)
  {  
    boolean wasAdded = false;
    if(addStateOrProvince(aStateOrProvince))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateOrProvinces()) { index = numberOfStateOrProvinces() - 1; }
      stateOrProvinces.remove(aStateOrProvince);
      stateOrProvinces.add(index, aStateOrProvince);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStateOrProvinceAt(StateOrProvince aStateOrProvince, int index)
  {
    boolean wasAdded = false;
    if(stateOrProvinces.contains(aStateOrProvince))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateOrProvinces()) { index = numberOfStateOrProvinces() - 1; }
      stateOrProvinces.remove(aStateOrProvince);
      stateOrProvinces.add(index, aStateOrProvince);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStateOrProvinceAt(aStateOrProvince, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=stateOrProvinces.size(); i > 0; i--)
    {
      StateOrProvince aStateOrProvince = stateOrProvinces.get(i - 1);
      aStateOrProvince.delete();
    }
    super.delete();
  }

}