/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 80 "Decisions.ump"
// line 220 "Decisions.ump"
public class Document
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Document Attributes
  private String id;
  private String docType;

  //Document Associations
  private List<DocumentVersion> versions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Document(String aId, String aDocType)
  {
    id = aId;
    docType = aDocType;
    versions = new ArrayList<DocumentVersion>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDocType(String aDocType)
  {
    boolean wasSet = false;
    docType = aDocType;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getDocType()
  {
    return docType;
  }

  public DocumentVersion getVersion(int index)
  {
    DocumentVersion aVersion = versions.get(index);
    return aVersion;
  }

  public List<DocumentVersion> getVersions()
  {
    List<DocumentVersion> newVersions = Collections.unmodifiableList(versions);
    return newVersions;
  }

  public int numberOfVersions()
  {
    int number = versions.size();
    return number;
  }

  public boolean hasVersions()
  {
    boolean has = versions.size() > 0;
    return has;
  }

  public int indexOfVersion(DocumentVersion aVersion)
  {
    int index = versions.indexOf(aVersion);
    return index;
  }

  public static int minimumNumberOfVersions()
  {
    return 0;
  }

  public DocumentVersion addVersion(int aVersionNumber, Date aDateCreated, String aFilename)
  {
    return new DocumentVersion(aVersionNumber, aDateCreated, aFilename, this);
  }

  public boolean addVersion(DocumentVersion aVersion)
  {
    boolean wasAdded = false;
    if (versions.contains(aVersion)) { return false; }
    Document existingDocument = aVersion.getDocument();
    boolean isNewDocument = existingDocument != null && !this.equals(existingDocument);
    if (isNewDocument)
    {
      aVersion.setDocument(this);
    }
    else
    {
      versions.add(aVersion);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVersion(DocumentVersion aVersion)
  {
    boolean wasRemoved = false;
    //Unable to remove aVersion, as it must always have a document
    if (!this.equals(aVersion.getDocument()))
    {
      versions.remove(aVersion);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVersionAt(DocumentVersion aVersion, int index)
  {  
    boolean wasAdded = false;
    if(addVersion(aVersion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVersions()) { index = numberOfVersions() - 1; }
      versions.remove(aVersion);
      versions.add(index, aVersion);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVersionAt(DocumentVersion aVersion, int index)
  {
    boolean wasAdded = false;
    if(versions.contains(aVersion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVersions()) { index = numberOfVersions() - 1; }
      versions.remove(aVersion);
      versions.add(index, aVersion);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVersionAt(aVersion, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=versions.size(); i > 0; i--)
    {
      DocumentVersion aVersion = versions.get(i - 1);
      aVersion.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "docType" + ":" + getDocType()+ "]"
     + outputString;
  }
}