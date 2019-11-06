/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package paper.OneToOptionalOne;
import java.util.*;

// line 33 "../../OneToOptionalOneMutation_uModel_telephone.ump"
public class PhoneLine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PhoneLine Attributes
  private double location;
  private double poCode;
  private int digOrAnalog;

  //PhoneLine Associations
  private List<TelephoneNumber> telephoneNumbers;
  private List<Telephone> telephones;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhoneLine(double aLocation, double aPoCode, int aDigOrAnalog)
  {
    location = aLocation;
    poCode = aPoCode;
    digOrAnalog = aDigOrAnalog;
    telephoneNumbers = new ArrayList<TelephoneNumber>();
    telephones = new ArrayList<Telephone>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLocation(double aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setPoCode(double aPoCode)
  {
    boolean wasSet = false;
    poCode = aPoCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setDigOrAnalog(int aDigOrAnalog)
  {
    boolean wasSet = false;
    digOrAnalog = aDigOrAnalog;
    wasSet = true;
    return wasSet;
  }

  public double getLocation()
  {
    return location;
  }

  public double getPoCode()
  {
    return poCode;
  }

  public int getDigOrAnalog()
  {
    return digOrAnalog;
  }
  /* Code from template association_GetMany */
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
  /* Code from template association_GetMany */
  public Telephone getTelephone(int index)
  {
    Telephone aTelephone = telephones.get(index);
    return aTelephone;
  }

  public List<Telephone> getTelephones()
  {
    List<Telephone> newTelephones = Collections.unmodifiableList(telephones);
    return newTelephones;
  }

  public int numberOfTelephones()
  {
    int number = telephones.size();
    return number;
  }

  public boolean hasTelephones()
  {
    boolean has = telephones.size() > 0;
    return has;
  }

  public int indexOfTelephone(Telephone aTelephone)
  {
    int index = telephones.indexOf(aTelephone);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTelephoneNumbers()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTelephoneNumber(TelephoneNumber aTelephoneNumber)
  {
    boolean wasAdded = false;
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
  /* Code from template association_RemoveMany */
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
  /* Code from template association_AddIndexControlFunctions */
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTelephones()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Telephone addTelephone(String aModel)
  {
    return new Telephone(aModel, this);
  }

  public boolean addTelephone(Telephone aTelephone)
  {
    boolean wasAdded = false;
    PhoneLine existingPhoneLine = aTelephone.getPhoneLine();
    boolean isNewPhoneLine = existingPhoneLine != null && !this.equals(existingPhoneLine);
    if (isNewPhoneLine)
    {
      aTelephone.setPhoneLine(this);
    }
    else
    {
      telephones.add(aTelephone);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTelephone(Telephone aTelephone)
  {
    boolean wasRemoved = false;
    //Unable to remove aTelephone, as it must always have a phoneLine
    if (!this.equals(aTelephone.getPhoneLine()))
    {
      telephones.remove(aTelephone);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTelephoneAt(Telephone aTelephone, int index)
  {  
    boolean wasAdded = false;
    if(addTelephone(aTelephone))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTelephones()) { index = numberOfTelephones() - 1; }
      telephones.remove(aTelephone);
      telephones.add(index, aTelephone);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTelephoneAt(Telephone aTelephone, int index)
  {
    boolean wasAdded = false;
    if(telephones.contains(aTelephone))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTelephones()) { index = numberOfTelephones() - 1; }
      telephones.remove(aTelephone);
      telephones.add(index, aTelephone);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTelephoneAt(aTelephone, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<TelephoneNumber> copyOfTelephoneNumbers = new ArrayList<TelephoneNumber>(telephoneNumbers);
    telephoneNumbers.clear();
    for(TelephoneNumber aTelephoneNumber : copyOfTelephoneNumbers)
    {
      aTelephoneNumber.removePhoneLine(this);
    }
    for(int i=telephones.size(); i > 0; i--)
    {
      Telephone aTelephone = telephones.get(i - 1);
      aTelephone.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "location" + ":" + getLocation()+ "," +
            "poCode" + ":" + getPoCode()+ "," +
            "digOrAnalog" + ":" + getDigOrAnalog()+ "]";
  }
}