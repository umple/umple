/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.OptionalOneToMany;
import java.util.*;

// line 33 "../../../OptionalOneToManyMutation_uModel.ump"
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
  private Telephone telephone;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PhoneLine(double aLocation, double aPoCode, int aDigOrAnalog)
  {
    location = aLocation;
    poCode = aPoCode;
    digOrAnalog = aDigOrAnalog;
    telephoneNumbers = new ArrayList<TelephoneNumber>();
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
  /* Code from template association_GetOne */
  public Telephone getTelephone()
  {
    return telephone;
  }

  public boolean hasTelephone()
  {
    boolean has = telephone != null;
    return has;
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
  /* Code from template association_SetOptionalOneToOne */
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
    return super.toString() + "["+
            "location" + ":" + getLocation()+ "," +
            "poCode" + ":" + getPoCode()+ "," +
            "digOrAnalog" + ":" + getDigOrAnalog()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "telephone = "+(getTelephone()!=null?Integer.toHexString(System.identityHashCode(getTelephone())):"null");
  }
}