/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 17 "Library.ump"
// line 52 "Library.ump"
public class EditionOrIssue
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EditionOrIssue Attributes
  private String issueNumber;
  private String publishedDate;

  //EditionOrIssue Associations
  private List<PartOfPublication> tableOfContents;
  private List<Copy> copies;
  private Publisher publisher;
  private List<Author> authors;
  private Publication publication;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EditionOrIssue(String aIssueNumber, String aPublishedDate, Publisher aPublisher, Publication aPublication)
  {
    issueNumber = aIssueNumber;
    publishedDate = aPublishedDate;
    tableOfContents = new ArrayList<PartOfPublication>();
    copies = new ArrayList<Copy>();
    boolean didAddPublisher = setPublisher(aPublisher);
    if (!didAddPublisher)
    {
      throw new RuntimeException("Unable to create editionOrIssue due to publisher");
    }
    authors = new ArrayList<Author>();
    boolean didAddPublication = setPublication(aPublication);
    if (!didAddPublication)
    {
      throw new RuntimeException("Unable to create editionOrIssue due to publication");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIssueNumber(String aIssueNumber)
  {
    boolean wasSet = false;
    issueNumber = aIssueNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setPublishedDate(String aPublishedDate)
  {
    boolean wasSet = false;
    publishedDate = aPublishedDate;
    wasSet = true;
    return wasSet;
  }

  public String getIssueNumber()
  {
    return issueNumber;
  }

  public String getPublishedDate()
  {
    return publishedDate;
  }

  public PartOfPublication getTableOfContent(int index)
  {
    PartOfPublication aTableOfContent = tableOfContents.get(index);
    return aTableOfContent;
  }

  public List<PartOfPublication> getTableOfContents()
  {
    List<PartOfPublication> newTableOfContents = Collections.unmodifiableList(tableOfContents);
    return newTableOfContents;
  }

  public int numberOfTableOfContents()
  {
    int number = tableOfContents.size();
    return number;
  }

  public boolean hasTableOfContents()
  {
    boolean has = tableOfContents.size() > 0;
    return has;
  }

  public int indexOfTableOfContent(PartOfPublication aTableOfContent)
  {
    int index = tableOfContents.indexOf(aTableOfContent);
    return index;
  }

  public Copy getCopy(int index)
  {
    Copy aCopy = copies.get(index);
    return aCopy;
  }

  public List<Copy> getCopies()
  {
    List<Copy> newCopies = Collections.unmodifiableList(copies);
    return newCopies;
  }

  public int numberOfCopies()
  {
    int number = copies.size();
    return number;
  }

  public boolean hasCopies()
  {
    boolean has = copies.size() > 0;
    return has;
  }

  public int indexOfCopy(Copy aCopy)
  {
    int index = copies.indexOf(aCopy);
    return index;
  }

  public Publisher getPublisher()
  {
    return publisher;
  }

  public Author getAuthor(int index)
  {
    Author aAuthor = authors.get(index);
    return aAuthor;
  }

  public List<Author> getAuthors()
  {
    List<Author> newAuthors = Collections.unmodifiableList(authors);
    return newAuthors;
  }

  public int numberOfAuthors()
  {
    int number = authors.size();
    return number;
  }

  public boolean hasAuthors()
  {
    boolean has = authors.size() > 0;
    return has;
  }

  public int indexOfAuthor(Author aAuthor)
  {
    int index = authors.indexOf(aAuthor);
    return index;
  }

  public Publication getPublication()
  {
    return publication;
  }

  public static int minimumNumberOfTableOfContents()
  {
    return 0;
  }

  public PartOfPublication addTableOfContent(String aTitle, String aPageNumber)
  {
    return new PartOfPublication(aTitle, aPageNumber, this);
  }

  public boolean addTableOfContent(PartOfPublication aTableOfContent)
  {
    boolean wasAdded = false;
    if (tableOfContents.contains(aTableOfContent)) { return false; }
    if (tableOfContents.contains(aTableOfContent)) { return false; }
    if (tableOfContents.contains(aTableOfContent)) { return false; }
    EditionOrIssue existingEditionOrIssue = aTableOfContent.getEditionOrIssue();
    boolean isNewEditionOrIssue = existingEditionOrIssue != null && !this.equals(existingEditionOrIssue);
    if (isNewEditionOrIssue)
    {
      aTableOfContent.setEditionOrIssue(this);
    }
    else
    {
      tableOfContents.add(aTableOfContent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTableOfContent(PartOfPublication aTableOfContent)
  {
    boolean wasRemoved = false;
    //Unable to remove aTableOfContent, as it must always have a editionOrIssue
    if (!this.equals(aTableOfContent.getEditionOrIssue()))
    {
      tableOfContents.remove(aTableOfContent);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTableOfContentAt(PartOfPublication aTableOfContent, int index)
  {  
    boolean wasAdded = false;
    if(addTableOfContent(aTableOfContent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTableOfContents()) { index = numberOfTableOfContents() - 1; }
      tableOfContents.remove(aTableOfContent);
      tableOfContents.add(index, aTableOfContent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTableOfContentAt(PartOfPublication aTableOfContent, int index)
  {
    boolean wasAdded = false;
    if(tableOfContents.contains(aTableOfContent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTableOfContents()) { index = numberOfTableOfContents() - 1; }
      tableOfContents.remove(aTableOfContent);
      tableOfContents.add(index, aTableOfContent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTableOfContentAt(aTableOfContent, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfCopies()
  {
    return 0;
  }

  public Copy addCopy(String aBarCodeNumber)
  {
    return new Copy(aBarCodeNumber, this);
  }

  public boolean addCopy(Copy aCopy)
  {
    boolean wasAdded = false;
    if (copies.contains(aCopy)) { return false; }
    if (copies.contains(aCopy)) { return false; }
    if (copies.contains(aCopy)) { return false; }
    EditionOrIssue existingEditionOrIssue = aCopy.getEditionOrIssue();
    boolean isNewEditionOrIssue = existingEditionOrIssue != null && !this.equals(existingEditionOrIssue);
    if (isNewEditionOrIssue)
    {
      aCopy.setEditionOrIssue(this);
    }
    else
    {
      copies.add(aCopy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCopy(Copy aCopy)
  {
    boolean wasRemoved = false;
    //Unable to remove aCopy, as it must always have a editionOrIssue
    if (!this.equals(aCopy.getEditionOrIssue()))
    {
      copies.remove(aCopy);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCopyAt(Copy aCopy, int index)
  {  
    boolean wasAdded = false;
    if(addCopy(aCopy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCopies()) { index = numberOfCopies() - 1; }
      copies.remove(aCopy);
      copies.add(index, aCopy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCopyAt(Copy aCopy, int index)
  {
    boolean wasAdded = false;
    if(copies.contains(aCopy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCopies()) { index = numberOfCopies() - 1; }
      copies.remove(aCopy);
      copies.add(index, aCopy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCopyAt(aCopy, index);
    }
    return wasAdded;
  }

  public boolean setPublisher(Publisher aPublisher)
  {
    boolean wasSet = false;
    if (aPublisher == null)
    {
      return wasSet;
    }

    Publisher existingPublisher = publisher;
    publisher = aPublisher;
    if (existingPublisher != null && !existingPublisher.equals(aPublisher))
    {
      existingPublisher.removeEditionOrIssue(this);
    }
    publisher.addEditionOrIssue(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfAuthors()
  {
    return 0;
  }

  public boolean addAuthor(Author aAuthor)
  {
    boolean wasAdded = false;
    if (authors.contains(aAuthor)) { return false; }
    if (authors.contains(aAuthor)) { return false; }
    if (authors.contains(aAuthor)) { return false; }
    authors.add(aAuthor);
    if (aAuthor.indexOfEditionOrIssue(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAuthor.addEditionOrIssue(this);
      if (!wasAdded)
      {
        authors.remove(aAuthor);
      }
    }
    return wasAdded;
  }

  public boolean removeAuthor(Author aAuthor)
  {
    boolean wasRemoved = false;
    if (!authors.contains(aAuthor))
    {
      return wasRemoved;
    }

    int oldIndex = authors.indexOf(aAuthor);
    authors.remove(oldIndex);
    if (aAuthor.indexOfEditionOrIssue(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAuthor.removeEditionOrIssue(this);
      if (!wasRemoved)
      {
        authors.add(oldIndex,aAuthor);
      }
    }
    return wasRemoved;
  }

  public boolean addAuthorAt(Author aAuthor, int index)
  {  
    boolean wasAdded = false;
    if(addAuthor(aAuthor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAuthors()) { index = numberOfAuthors() - 1; }
      authors.remove(aAuthor);
      authors.add(index, aAuthor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAuthorAt(Author aAuthor, int index)
  {
    boolean wasAdded = false;
    if(authors.contains(aAuthor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAuthors()) { index = numberOfAuthors() - 1; }
      authors.remove(aAuthor);
      authors.add(index, aAuthor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAuthorAt(aAuthor, index);
    }
    return wasAdded;
  }

  public boolean setPublication(Publication aPublication)
  {
    boolean wasSet = false;
    if (aPublication == null)
    {
      return wasSet;
    }

    Publication existingPublication = publication;
    publication = aPublication;
    if (existingPublication != null && !existingPublication.equals(aPublication))
    {
      existingPublication.removeEditionOrIssue(this);
    }
    publication.addEditionOrIssue(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=tableOfContents.size(); i > 0; i--)
    {
      PartOfPublication aTableOfContent = tableOfContents.get(i - 1);
      aTableOfContent.delete();
    }
    for(int i=copies.size(); i > 0; i--)
    {
      Copy aCopy = copies.get(i - 1);
      aCopy.delete();
    }
    Publisher placeholderPublisher = publisher;
    this.publisher = null;
    placeholderPublisher.removeEditionOrIssue(this);
    ArrayList<Author> copyOfAuthors = new ArrayList<Author>(authors);
    authors.clear();
    for(Author aAuthor : copyOfAuthors)
    {
      aAuthor.removeEditionOrIssue(this);
    }
    Publication placeholderPublication = publication;
    this.publication = null;
    placeholderPublication.removeEditionOrIssue(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "issueNumber" + ":" + getIssueNumber()+ "," +
            "publishedDate" + ":" + getPublishedDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "publisher = "+(getPublisher()!=null?Integer.toHexString(System.identityHashCode(getPublisher())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "publication = "+(getPublication()!=null?Integer.toHexString(System.identityHashCode(getPublication())):"null")
     + outputString;
  }
}