/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package paper.OneToOptionalOne;

// line 30 "../../OneToOptionalOneMutation_uModel_telephone.ump"
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
      throw new RuntimeException("Unable to create telephone due to phoneLine. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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
  /* Code from template association_GetOne */
  public PhoneLine getPhoneLine()
  {
    return phoneLine;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPhoneLine(PhoneLine aPhoneLine)
  {
    boolean wasSet = false;
    if (aPhoneLine == null)
    {
      return wasSet;
    }

    PhoneLine existingPhoneLine = phoneLine;
    phoneLine = aPhoneLine;
    if (existingPhoneLine != null && !existingPhoneLine.equals(aPhoneLine))
    {
      existingPhoneLine.removeTelephone(this);
    }
    phoneLine.addTelephone(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    PhoneLine placeholderPhoneLine = phoneLine;
    this.phoneLine = null;
    if(placeholderPhoneLine != null)
    {
      placeholderPhoneLine.removeTelephone(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "model" + ":" + getModel()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "phoneLine = "+(getPhoneLine()!=null?Integer.toHexString(System.identityHashCode(getPhoneLine())):"null");
  }
}