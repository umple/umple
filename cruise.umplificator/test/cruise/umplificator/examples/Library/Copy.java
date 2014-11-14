/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 15 "Library.ump"
// line 64 "Library.ump"
public class Copy
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Copy Attributes
  private String barCodeNumber;

  //Copy Associations
  private EditionOrIssue editionOrIssue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Copy(String aBarCodeNumber, EditionOrIssue aEditionOrIssue)
  {
    barCodeNumber = aBarCodeNumber;
    boolean didAddEditionOrIssue = setEditionOrIssue(aEditionOrIssue);
    if (!didAddEditionOrIssue)
    {
      throw new RuntimeException("Unable to create copy due to editionOrIssue");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBarCodeNumber(String aBarCodeNumber)
  {
    boolean wasSet = false;
    barCodeNumber = aBarCodeNumber;
    wasSet = true;
    return wasSet;
  }

  public String getBarCodeNumber()
  {
    return barCodeNumber;
  }

  public EditionOrIssue getEditionOrIssue()
  {
    return editionOrIssue;
  }

  public boolean setEditionOrIssue(EditionOrIssue aEditionOrIssue)
  {
    boolean wasSet = false;
    if (aEditionOrIssue == null)
    {
      return wasSet;
    }

    EditionOrIssue existingEditionOrIssue = editionOrIssue;
    editionOrIssue = aEditionOrIssue;
    if (existingEditionOrIssue != null && !existingEditionOrIssue.equals(aEditionOrIssue))
    {
      existingEditionOrIssue.removeCopy(this);
    }
    editionOrIssue.addCopy(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    EditionOrIssue placeholderEditionOrIssue = editionOrIssue;
    this.editionOrIssue = null;
    placeholderEditionOrIssue.removeCopy(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "barCodeNumber" + ":" + getBarCodeNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "editionOrIssue = "+(getEditionOrIssue()!=null?Integer.toHexString(System.identityHashCode(getEditionOrIssue())):"null")
     + outputString;
  }
}