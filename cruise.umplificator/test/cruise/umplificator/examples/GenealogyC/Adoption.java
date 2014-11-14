/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 29 "GenealogyC.ump"
// line 52 "GenealogyC.ump"
public class Adoption
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Adoption Attributes
  private String dateOfAdoption;

  //Adoption Associations
  private Union adoptiveParents;
  private Person adoptedChild;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Adoption(String aDateOfAdoption)
  {
    dateOfAdoption = aDateOfAdoption;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDateOfAdoption(String aDateOfAdoption)
  {
    boolean wasSet = false;
    dateOfAdoption = aDateOfAdoption;
    wasSet = true;
    return wasSet;
  }

  public String getDateOfAdoption()
  {
    return dateOfAdoption;
  }

  public Union getAdoptiveParents()
  {
    return adoptiveParents;
  }

  public boolean hasAdoptiveParents()
  {
    boolean has = adoptiveParents != null;
    return has;
  }

  public Person getAdoptedChild()
  {
    return adoptedChild;
  }

  public boolean hasAdoptedChild()
  {
    boolean has = adoptedChild != null;
    return has;
  }

  public boolean setAdoptiveParents(Union aAdoptiveParents)
  {
    boolean wasSet = false;
    Union existingAdoptiveParents = adoptiveParents;
    adoptiveParents = aAdoptiveParents;
    if (existingAdoptiveParents != null && !existingAdoptiveParents.equals(aAdoptiveParents))
    {
      existingAdoptiveParents.removeAdoption(this);
    }
    if (aAdoptiveParents != null)
    {
      aAdoptiveParents.addAdoption(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setAdoptedChild(Person aAdoptedChild)
  {
    boolean wasSet = false;
    Person existingAdoptedChild = adoptedChild;
    adoptedChild = aAdoptedChild;
    if (existingAdoptedChild != null && !existingAdoptedChild.equals(aAdoptedChild))
    {
      existingAdoptedChild.removeAdoption(this);
    }
    if (aAdoptedChild != null)
    {
      aAdoptedChild.addAdoption(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (adoptiveParents != null)
    {
      Union placeholderAdoptiveParents = adoptiveParents;
      this.adoptiveParents = null;
      placeholderAdoptiveParents.removeAdoption(this);
    }
    if (adoptedChild != null)
    {
      Person placeholderAdoptedChild = adoptedChild;
      this.adoptedChild = null;
      placeholderAdoptedChild.removeAdoption(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "dateOfAdoption" + ":" + getDateOfAdoption()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "adoptiveParents = "+(getAdoptiveParents()!=null?Integer.toHexString(System.identityHashCode(getAdoptiveParents())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "adoptedChild = "+(getAdoptedChild()!=null?Integer.toHexString(System.identityHashCode(getAdoptedChild())):"null")
     + outputString;
  }
}