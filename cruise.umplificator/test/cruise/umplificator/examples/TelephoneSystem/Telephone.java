/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 31 "TelephoneSystem.ump"
// line 55 "TelephoneSystem.ump"
public class Telephone
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Telephone Attributes
  private String model;

  //Telephone Associations
  private PhoneLine phoneLine;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Telephone(String aModel, PhoneLine aPhoneLine)
  {
    model = aModel;
    boolean didAddPhoneLine = setPhoneLine(aPhoneLine);
    if (!didAddPhoneLine)
    {
      throw new RuntimeException("Unable to create telephone due to phoneLine");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setModel(String aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public String getModel()
  {
    return model;
  }

  public PhoneLine getPhoneLine()
  {
    return phoneLine;
  }

  public boolean setPhoneLine(PhoneLine aNewPhoneLine)
  {
    boolean wasSet = false;
    if (aNewPhoneLine == null)
    {
      //Unable to setPhoneLine to null, as telephone must always be associated to a phoneLine
      return wasSet;
    }
    
    Telephone existingTelephone = aNewPhoneLine.getTelephone();
    if (existingTelephone != null && !equals(existingTelephone))
    {
      //Unable to setPhoneLine, the current phoneLine already has a telephone, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    PhoneLine anOldPhoneLine = phoneLine;
    phoneLine = aNewPhoneLine;
    phoneLine.setTelephone(this);

    if (anOldPhoneLine != null)
    {
      anOldPhoneLine.setTelephone(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    PhoneLine existingPhoneLine = phoneLine;
    phoneLine = null;
    if (existingPhoneLine != null)
    {
      existingPhoneLine.setTelephone(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "model" + ":" + getModel()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "phoneLine = "+(getPhoneLine()!=null?Integer.toHexString(System.identityHashCode(getPhoneLine())):"null")
     + outputString;
  }
}