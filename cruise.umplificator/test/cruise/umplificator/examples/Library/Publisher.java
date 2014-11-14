/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 24 "Library.ump"
// line 92 "Library.ump"
public class Publisher
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Publisher Attributes
  private String name;

  //Publisher Associations
  private List<EditionOrIssue> editionOrIssues;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Publisher(String aName)
  {
    name = aName;
    editionOrIssues = new ArrayList<EditionOrIssue>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public EditionOrIssue getEditionOrIssue(int index)
  {
    EditionOrIssue aEditionOrIssue = editionOrIssues.get(index);
    return aEditionOrIssue;
  }

  public List<EditionOrIssue> getEditionOrIssues()
  {
    List<EditionOrIssue> newEditionOrIssues = Collections.unmodifiableList(editionOrIssues);
    return newEditionOrIssues;
  }

  public int numberOfEditionOrIssues()
  {
    int number = editionOrIssues.size();
    return number;
  }

  public boolean hasEditionOrIssues()
  {
    boolean has = editionOrIssues.size() > 0;
    return has;
  }

  public int indexOfEditionOrIssue(EditionOrIssue aEditionOrIssue)
  {
    int index = editionOrIssues.indexOf(aEditionOrIssue);
    return index;
  }

  public static int minimumNumberOfEditionOrIssues()
  {
    return 0;
  }

  public EditionOrIssue addEditionOrIssue(String aIssueNumber, String aPublishedDate, Publication aPublication)
  {
    return new EditionOrIssue(aIssueNumber, aPublishedDate, this, aPublication);
  }

  public boolean addEditionOrIssue(EditionOrIssue aEditionOrIssue)
  {
    boolean wasAdded = false;
    if (editionOrIssues.contains(aEditionOrIssue)) { return false; }
    Publisher existingPublisher = aEditionOrIssue.getPublisher();
    boolean isNewPublisher = existingPublisher != null && !this.equals(existingPublisher);
    if (isNewPublisher)
    {
      aEditionOrIssue.setPublisher(this);
    }
    else
    {
      editionOrIssues.add(aEditionOrIssue);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEditionOrIssue(EditionOrIssue aEditionOrIssue)
  {
    boolean wasRemoved = false;
    //Unable to remove aEditionOrIssue, as it must always have a publisher
    if (!this.equals(aEditionOrIssue.getPublisher()))
    {
      editionOrIssues.remove(aEditionOrIssue);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addEditionOrIssueAt(EditionOrIssue aEditionOrIssue, int index)
  {  
    boolean wasAdded = false;
    if(addEditionOrIssue(aEditionOrIssue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEditionOrIssues()) { index = numberOfEditionOrIssues() - 1; }
      editionOrIssues.remove(aEditionOrIssue);
      editionOrIssues.add(index, aEditionOrIssue);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEditionOrIssueAt(EditionOrIssue aEditionOrIssue, int index)
  {
    boolean wasAdded = false;
    if(editionOrIssues.contains(aEditionOrIssue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEditionOrIssues()) { index = numberOfEditionOrIssues() - 1; }
      editionOrIssues.remove(aEditionOrIssue);
      editionOrIssues.add(index, aEditionOrIssue);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEditionOrIssueAt(aEditionOrIssue, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=editionOrIssues.size(); i > 0; i--)
    {
      EditionOrIssue aEditionOrIssue = editionOrIssues.get(i - 1);
      aEditionOrIssue.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}