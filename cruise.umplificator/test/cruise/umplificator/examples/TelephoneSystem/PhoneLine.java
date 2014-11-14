/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 34 "TelephoneSystem.ump"
// line 48 "TelephoneSystem.ump"
public class PhoneLine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PhoneLine Attributes
  private String location;
  private String digOrAnalog;

  //PhoneLine Associations
  private List<TelephoneNumber> telephoneNumbers;
  private Telephone telephone;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhoneLine(String aLocation, String aDigOrAnalog)
  {
    location = aLocation;
    digOrAnalog = aDigOrAnalog;
    telephoneNumbers = new ArrayList<TelephoneNumber>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setDigOrAnalog(String aDigOrAnalog)
  {
    boolean wasSet = false;
    digOrAnalog = aDigOrAnalog;
    wasSet = true;
    return wasSet;
  }

  public String getLocation()
  {
    return location;
  }

  public String getDigOrAnalog()
  {
    return digOrAnalog;
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

  public Telephone getTelephone()
  {
    return telephone;
  }

  public boolean hasTelephone()
  {
    boolean has = telephone != null;
    return has;
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
    if (aTelephoneNumber.indexOfPhoneLine(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTelephoneNumber.addPhoneLine(this);
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
    if (aTelephoneNumber.indexOfPhoneLine(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTelephoneNumber.removePhoneLine(this);
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

  public boolean setTelephone(Telephone aNewTelephone)
  {
    boolean wasSet = false;
    if (telephone != null && !telephone.equals(aNewTelephone) && equals(telephone.getPhoneLine()))
    {
      //Unable to setTelephone, as existing telephone would become an orphan
      return wasSet;
    }

    telephone = aNewTelephone;
    PhoneLine anOldPhoneLine = aNewTelephone != null ? aNewTelephone.getPhoneLine() : null;

    if (!this.equals(anOldPhoneLine))
    {
      if (anOldPhoneLine != null)
      {
        anOldPhoneLine.telephone = null;
      }
      if (telephone != null)
      {
        telephone.setPhoneLine(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<TelephoneNumber> copyOfTelephoneNumbers = new ArrayList<TelephoneNumber>(telephoneNumbers);
    telephoneNumbers.clear();
    for(TelephoneNumber aTelephoneNumber : copyOfTelephoneNumbers)
    {
      aTelephoneNumber.removePhoneLine(this);
    }
    Telephone existingTelephone = telephone;
    telephone = null;
    if (existingTelephone != null)
    {
      existingTelephone.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "location" + ":" + getLocation()+ "," +
            "digOrAnalog" + ":" + getDigOrAnalog()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "telephone = "+(getTelephone()!=null?Integer.toHexString(System.identityHashCode(getTelephone())):"null")
     + outputString;
  }
}