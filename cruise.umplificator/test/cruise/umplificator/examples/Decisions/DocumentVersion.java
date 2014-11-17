/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 86 "Decisions.ump"
// line 202 "Decisions.ump"
public class DocumentVersion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DocumentVersion Attributes
  private int versionNumber;
  private Date dateCreated;
  private String filename;

  //DocumentVersion Associations
  private List<Person> authors;
  private List<DecisionByBody> usedInDecision;
  private Document document;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DocumentVersion(int aVersionNumber, Date aDateCreated, String aFilename, Document aDocument)
  {
    versionNumber = aVersionNumber;
    dateCreated = aDateCreated;
    filename = aFilename;
    authors = new ArrayList<Person>();
    usedInDecision = new ArrayList<DecisionByBody>();
    boolean didAddDocument = setDocument(aDocument);
    if (!didAddDocument)
    {
      throw new RuntimeException("Unable to create version due to document");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVersionNumber(int aVersionNumber)
  {
    boolean wasSet = false;
    versionNumber = aVersionNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateCreated(Date aDateCreated)
  {
    boolean wasSet = false;
    dateCreated = aDateCreated;
    wasSet = true;
    return wasSet;
  }

  public boolean setFilename(String aFilename)
  {
    boolean wasSet = false;
    filename = aFilename;
    wasSet = true;
    return wasSet;
  }

  public int getVersionNumber()
  {
    return versionNumber;
  }

  /**
   * not strictly required
   */
  public Date getDateCreated()
  {
    return dateCreated;
  }

  /**
   * put filename here, but could be in Document
   */
  public String getFilename()
  {
    return filename;
  }

  public Person getAuthor(int index)
  {
    Person aAuthor = authors.get(index);
    return aAuthor;
  }

  public List<Person> getAuthors()
  {
    List<Person> newAuthors = Collections.unmodifiableList(authors);
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

  public int indexOfAuthor(Person aAuthor)
  {
    int index = authors.indexOf(aAuthor);
    return index;
  }

  public DecisionByBody getUsedInDecision(int index)
  {
    DecisionByBody aUsedInDecision = usedInDecision.get(index);
    return aUsedInDecision;
  }

  public List<DecisionByBody> getUsedInDecision()
  {
    List<DecisionByBody> newUsedInDecision = Collections.unmodifiableList(usedInDecision);
    return newUsedInDecision;
  }

  public int numberOfUsedInDecision()
  {
    int number = usedInDecision.size();
    return number;
  }

  public boolean hasUsedInDecision()
  {
    boolean has = usedInDecision.size() > 0;
    return has;
  }

  public int indexOfUsedInDecision(DecisionByBody aUsedInDecision)
  {
    int index = usedInDecision.indexOf(aUsedInDecision);
    return index;
  }

  public Document getDocument()
  {
    return document;
  }

  public static int minimumNumberOfAuthors()
  {
    return 0;
  }

  public boolean addAuthor(Person aAuthor)
  {
    boolean wasAdded = false;
    if (authors.contains(aAuthor)) { return false; }
    authors.add(aAuthor);
    if (aAuthor.indexOfDocumentVersion(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAuthor.addDocumentVersion(this);
      if (!wasAdded)
      {
        authors.remove(aAuthor);
      }
    }
    return wasAdded;
  }

  public boolean removeAuthor(Person aAuthor)
  {
    boolean wasRemoved = false;
    if (!authors.contains(aAuthor))
    {
      return wasRemoved;
    }

    int oldIndex = authors.indexOf(aAuthor);
    authors.remove(oldIndex);
    if (aAuthor.indexOfDocumentVersion(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAuthor.removeDocumentVersion(this);
      if (!wasRemoved)
      {
        authors.add(oldIndex,aAuthor);
      }
    }
    return wasRemoved;
  }

  public boolean addAuthorAt(Person aAuthor, int index)
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

  public boolean addOrMoveAuthorAt(Person aAuthor, int index)
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

  public static int minimumNumberOfUsedInDecision()
  {
    return 0;
  }

  public boolean addUsedInDecision(DecisionByBody aUsedInDecision)
  {
    boolean wasAdded = false;
    if (usedInDecision.contains(aUsedInDecision)) { return false; }
    usedInDecision.add(aUsedInDecision);
    if (aUsedInDecision.indexOfDocumentsForDecision(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUsedInDecision.addDocumentsForDecision(this);
      if (!wasAdded)
      {
        usedInDecision.remove(aUsedInDecision);
      }
    }
    return wasAdded;
  }

  public boolean removeUsedInDecision(DecisionByBody aUsedInDecision)
  {
    boolean wasRemoved = false;
    if (!usedInDecision.contains(aUsedInDecision))
    {
      return wasRemoved;
    }

    int oldIndex = usedInDecision.indexOf(aUsedInDecision);
    usedInDecision.remove(oldIndex);
    if (aUsedInDecision.indexOfDocumentsForDecision(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUsedInDecision.removeDocumentsForDecision(this);
      if (!wasRemoved)
      {
        usedInDecision.add(oldIndex,aUsedInDecision);
      }
    }
    return wasRemoved;
  }

  public boolean addUsedInDecisionAt(DecisionByBody aUsedInDecision, int index)
  {  
    boolean wasAdded = false;
    if(addUsedInDecision(aUsedInDecision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsedInDecision()) { index = numberOfUsedInDecision() - 1; }
      usedInDecision.remove(aUsedInDecision);
      usedInDecision.add(index, aUsedInDecision);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUsedInDecisionAt(DecisionByBody aUsedInDecision, int index)
  {
    boolean wasAdded = false;
    if(usedInDecision.contains(aUsedInDecision))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsedInDecision()) { index = numberOfUsedInDecision() - 1; }
      usedInDecision.remove(aUsedInDecision);
      usedInDecision.add(index, aUsedInDecision);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUsedInDecisionAt(aUsedInDecision, index);
    }
    return wasAdded;
  }

  public boolean setDocument(Document aDocument)
  {
    boolean wasSet = false;
    if (aDocument == null)
    {
      return wasSet;
    }

    Document existingDocument = document;
    document = aDocument;
    if (existingDocument != null && !existingDocument.equals(aDocument))
    {
      existingDocument.removeVersion(this);
    }
    document.addVersion(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Person> copyOfAuthors = new ArrayList<Person>(authors);
    authors.clear();
    for(Person aAuthor : copyOfAuthors)
    {
      aAuthor.removeDocumentVersion(this);
    }
    ArrayList<DecisionByBody> copyOfUsedInDecision = new ArrayList<DecisionByBody>(usedInDecision);
    usedInDecision.clear();
    for(DecisionByBody aUsedInDecision : copyOfUsedInDecision)
    {
      aUsedInDecision.removeDocumentsForDecision(this);
    }
    Document placeholderDocument = document;
    this.document = null;
    placeholderDocument.removeVersion(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "versionNumber" + ":" + getVersionNumber()+ "," +
            "filename" + ":" + getFilename()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateCreated" + "=" + (getDateCreated() != null ? !getDateCreated().equals(this)  ? getDateCreated().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "document = "+(getDocument()!=null?Integer.toHexString(System.identityHashCode(getDocument())):"null")
     + outputString;
  }
}