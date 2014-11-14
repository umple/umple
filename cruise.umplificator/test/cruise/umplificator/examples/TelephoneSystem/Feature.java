/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 27 "TelephoneSystem.ump"
// line 60 "TelephoneSystem.ump"
public class Feature
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Feature Attributes
  private String description;

  //Feature Associations
  private List<TelephoneNumber> telephoneNumbers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Feature(String aDescription)
  {
    description = aDescription;
    telephoneNumbers = new ArrayList<TelephoneNumber>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public TelephoneNumber getTelephoneNumber(int index)
  {
    TelephoneNumber aTelephoneNumber = telephoneNumbers.get(index);
    return aTelephoneNumber;
  }

  public List<TelephoneNumber> getTelephoneNumbers()
  {
    List<TelephoneNumber> newTelephoneNumbers = Collections.unmodifiableList(telephoneNumbers);
    return newTelephoneNumbers;
  }

  public int numberOfTelephoneNumbers()
  {
    int number = telephoneNumbers.size();
    return number;
  }

  public boolean hasTelephoneNumbers()
  {
    boolean has = telephoneNumbers.size() > 0;
    return has;
  }

  public int indexOfTelephoneNumber(TelephoneNumber aTelephoneNumber)
  {
    int index = telephoneNumbers.indexOf(aTelephoneNumber);
    return index;
  }

  public static int minimumNumberOfTelephoneNumbers()
  {
    return 0;
  }

  public boolean addTelephoneNumber(TelephoneNumber aTelephoneNumber)
  {
    boolean wasAdded = false;
    if (telephoneNumbers.contains(aTelephoneNumber)) { return false; }
    telephoneNumbers.add(aTelephoneNumber);
    if (aTelephoneNumber.indexOfFeature(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTelephoneNumber.addFeature(this);
      if (!wasAdded)
      {
        telephoneNumbers.remove(aTelephoneNumber);
      }
    }
    return wasAdded;
  }

  public boolean removeTelephoneNumber(TelephoneNumber aTelephoneNumber)
  {
    boolean wasRemoved = false;
    if (!telephoneNumbers.contains(aTelephoneNumber))
    {
      return wasRemoved;
    }

    int oldIndex = telephoneNumbers.indexOf(aTelephoneNumber);
    telephoneNumbers.remove(oldIndex);
    if (aTelephoneNumber.indexOfFeature(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTelephoneNumber.removeFeature(this);
      if (!wasRemoved)
      {
        telephoneNumbers.add(oldIndex,aTelephoneNumber);
      }
    }
    return wasRemoved;
  }

  public boolean addTelephoneNumberAt(TelephoneNumber aTelephoneNumber, int index)
  {  
    boolean wasAdded = false;
    if(addTelephoneNumber(aTelephoneNumber))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTelephoneNumbers()) { index = numberOfTelephoneNumbers() - 1; }
      telephoneNumbers.remove(aTelephoneNumber);
      telephoneNumbers.add(index, aTelephoneNumber);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTelephoneNumberAt(TelephoneNumber aTelephoneNumber, int index)
  {
    boolean wasAdded = false;
    if(telephoneNumbers.contains(aTelephoneNumber))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTelephoneNumbers()) { index = numberOfTelephoneNumbers() - 1; }
      telephoneNumbers.remove(aTelephoneNumber);
      telephoneNumbers.add(index, aTelephoneNumber);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTelephoneNumberAt(aTelephoneNumber, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<TelephoneNumber> copyOfTelephoneNumbers = new ArrayList<TelephoneNumber>(telephoneNumbers);
    telephoneNumbers.clear();
    for(TelephoneNumber aTelephoneNumber : copyOfTelephoneNumbers)
    {
      aTelephoneNumber.removeFeature(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}