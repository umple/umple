/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 29 "Library.ump"
// line 86 "Library.ump"
public class Author
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Author Associations
  private List<EditionOrIssue> editionOrIssues;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Author()
  {
    editionOrIssues = new ArrayList<EditionOrIssue>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public boolean addEditionOrIssue(EditionOrIssue aEditionOrIssue)
  {
    boolean wasAdded = false;
    if (editionOrIssues.contains(aEditionOrIssue)) { return false; }
    editionOrIssues.add(aEditionOrIssue);
    if (aEditionOrIssue.indexOfAuthor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEditionOrIssue.addAuthor(this);
      if (!wasAdded)
      {
        editionOrIssues.remove(aEditionOrIssue);
      }
    }
    return wasAdded;
  }

  public boolean removeEditionOrIssue(EditionOrIssue aEditionOrIssue)
  {
    boolean wasRemoved = false;
    if (!editionOrIssues.contains(aEditionOrIssue))
    {
      return wasRemoved;
    }

    int oldIndex = editionOrIssues.indexOf(aEditionOrIssue);
    editionOrIssues.remove(oldIndex);
    if (aEditionOrIssue.indexOfAuthor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEditionOrIssue.removeAuthor(this);
      if (!wasRemoved)
      {
        editionOrIssues.add(oldIndex,aEditionOrIssue);
      }
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
    ArrayList<EditionOrIssue> copyOfEditionOrIssues = new ArrayList<EditionOrIssue>(editionOrIssues);
    editionOrIssues.clear();
    for(EditionOrIssue aEditionOrIssue : copyOfEditionOrIssues)
    {
      aEditionOrIssue.removeAuthor(this);
    }
  }

}