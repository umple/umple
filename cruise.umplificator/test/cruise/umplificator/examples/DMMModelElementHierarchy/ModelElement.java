/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 17 "DMMModelElementHierarchy.ump"
// line 170 "DMMModelElementHierarchy.ump"
public class ModelElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ModelElement Attributes
  private String visibility;

  //ModelElement Associations
  private Contains contains;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ModelElement(String aVisibility)
  {
    visibility = aVisibility;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVisibility(String aVisibility)
  {
    boolean wasSet = false;
    visibility = aVisibility;
    wasSet = true;
    return wasSet;
  }

  public String getVisibility()
  {
    return visibility;
  }

  public Contains getContains()
  {
    return contains;
  }

  public boolean hasContains()
  {
    boolean has = contains != null;
    return has;
  }

  public boolean setContains(Contains aNewContains)
  {
    boolean wasSet = false;
    if (contains != null && !contains.equals(aNewContains) && equals(contains.getModelElement()))
    {
      //Unable to setContains, as existing contains would become an orphan
      return wasSet;
    }

    contains = aNewContains;
    ModelElement anOldModelElement = aNewContains != null ? aNewContains.getModelElement() : null;

    if (!this.equals(anOldModelElement))
    {
      if (anOldModelElement != null)
      {
        anOldModelElement.contains = null;
      }
      if (contains != null)
      {
        contains.setModelElement(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Contains existingContains = contains;
    contains = null;
    if (existingContains != null)
    {
      existingContains.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "visibility" + ":" + getVisibility()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "contains = "+(getContains()!=null?Integer.toHexString(System.identityHashCode(getContains())):"null")
     + outputString;
  }
}