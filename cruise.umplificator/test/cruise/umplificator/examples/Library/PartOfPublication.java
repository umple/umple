/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 10 "Library.ump"
// line 69 "Library.ump"
public class PartOfPublication
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PartOfPublication Attributes
  private String title;
  private String pageNumber;

  //PartOfPublication Associations
  private List<PartOfPublication> subparts;
  private PartOfPublication partOfPublication;
  private EditionOrIssue editionOrIssue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PartOfPublication(String aTitle, String aPageNumber, EditionOrIssue aEditionOrIssue)
  {
    title = aTitle;
    pageNumber = aPageNumber;
    subparts = new ArrayList<PartOfPublication>();
    boolean didAddEditionOrIssue = setEditionOrIssue(aEditionOrIssue);
    if (!didAddEditionOrIssue)
    {
      throw new RuntimeException("Unable to create tableOfContent due to editionOrIssue");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTitle(String aTitle)
  {
    boolean wasSet = false;
    title = aTitle;
    wasSet = true;
    return wasSet;
  }

  public boolean setPageNumber(String aPageNumber)
  {
    boolean wasSet = false;
    pageNumber = aPageNumber;
    wasSet = true;
    return wasSet;
  }

  public String getTitle()
  {
    return title;
  }

  public String getPageNumber()
  {
    return pageNumber;
  }

  public PartOfPublication getSubpart(int index)
  {
    PartOfPublication aSubpart = subparts.get(index);
    return aSubpart;
  }

  public List<PartOfPublication> getSubparts()
  {
    List<PartOfPublication> newSubparts = Collections.unmodifiableList(subparts);
    return newSubparts;
  }

  public int numberOfSubparts()
  {
    int number = subparts.size();
    return number;
  }

  public boolean hasSubparts()
  {
    boolean has = subparts.size() > 0;
    return has;
  }

  public int indexOfSubpart(PartOfPublication aSubpart)
  {
    int index = subparts.indexOf(aSubpart);
    return index;
  }

  public PartOfPublication getPartOfPublication()
  {
    return partOfPublication;
  }

  public boolean hasPartOfPublication()
  {
    boolean has = partOfPublication != null;
    return has;
  }

  public EditionOrIssue getEditionOrIssue()
  {
    return editionOrIssue;
  }

  public static int minimumNumberOfSubparts()
  {
    return 0;
  }

  public boolean addSubpart(PartOfPublication aSubpart)
  {
    boolean wasAdded = false;
    if (subparts.contains(aSubpart)) { return false; }
    PartOfPublication existingPartOfPublication = aSubpart.getPartOfPublication();
    if (existingPartOfPublication == null)
    {
      aSubpart.setPartOfPublication(this);
    }
    else if (!this.equals(existingPartOfPublication))
    {
      existingPartOfPublication.removeSubpart(aSubpart);
      addSubpart(aSubpart);
    }
    else
    {
      subparts.add(aSubpart);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubpart(PartOfPublication aSubpart)
  {
    boolean wasRemoved = false;
    if (subparts.contains(aSubpart))
    {
      subparts.remove(aSubpart);
      aSubpart.setPartOfPublication(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubpartAt(PartOfPublication aSubpart, int index)
  {  
    boolean wasAdded = false;
    if(addSubpart(aSubpart))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubparts()) { index = numberOfSubparts() - 1; }
      subparts.remove(aSubpart);
      subparts.add(index, aSubpart);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubpartAt(PartOfPublication aSubpart, int index)
  {
    boolean wasAdded = false;
    if(subparts.contains(aSubpart))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubparts()) { index = numberOfSubparts() - 1; }
      subparts.remove(aSubpart);
      subparts.add(index, aSubpart);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubpartAt(aSubpart, index);
    }
    return wasAdded;
  }

  public boolean setPartOfPublication(PartOfPublication aPartOfPublication)
  {
    boolean wasSet = false;
    PartOfPublication existingPartOfPublication = partOfPublication;
    partOfPublication = aPartOfPublication;
    if (existingPartOfPublication != null && !existingPartOfPublication.equals(aPartOfPublication))
    {
      existingPartOfPublication.removeSubpart(this);
    }
    if (aPartOfPublication != null)
    {
      aPartOfPublication.addSubpart(this);
    }
    wasSet = true;
    return wasSet;
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
      existingEditionOrIssue.removeTableOfContent(this);
    }
    editionOrIssue.addTableOfContent(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !subparts.isEmpty() )
    {
      subparts.get(0).setPartOfPublication(null);
    }
    if (partOfPublication != null)
    {
      PartOfPublication placeholderPartOfPublication = partOfPublication;
      this.partOfPublication = null;
      placeholderPartOfPublication.removeSubpart(this);
    }
    EditionOrIssue placeholderEditionOrIssue = editionOrIssue;
    this.editionOrIssue = null;
    placeholderEditionOrIssue.removeTableOfContent(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "title" + ":" + getTitle()+ "," +
            "pageNumber" + ":" + getPageNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "editionOrIssue = "+(getEditionOrIssue()!=null?Integer.toHexString(System.identityHashCode(getEditionOrIssue())):"null")
     + outputString;
  }
}