/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 123 "Decisions.ump"
// line 180 "Decisions.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;

  //Person Associations
  private Organization organization;
  private List<Membership> memberships;
  private List<DocumentVersion> documentVersions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, Organization aOrganization)
  {
    name = aName;
    boolean didAddOrganization = setOrganization(aOrganization);
    if (!didAddOrganization)
    {
      throw new RuntimeException("Unable to create user due to organization");
    }
    memberships = new ArrayList<Membership>();
    documentVersions = new ArrayList<DocumentVersion>();
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

  public Organization getOrganization()
  {
    return organization;
  }

  public Membership getMembership(int index)
  {
    Membership aMembership = memberships.get(index);
    return aMembership;
  }

  public List<Membership> getMemberships()
  {
    List<Membership> newMemberships = Collections.unmodifiableList(memberships);
    return newMemberships;
  }

  public int numberOfMemberships()
  {
    int number = memberships.size();
    return number;
  }

  public boolean hasMemberships()
  {
    boolean has = memberships.size() > 0;
    return has;
  }

  public int indexOfMembership(Membership aMembership)
  {
    int index = memberships.indexOf(aMembership);
    return index;
  }

  public DocumentVersion getDocumentVersion(int index)
  {
    DocumentVersion aDocumentVersion = documentVersions.get(index);
    return aDocumentVersion;
  }

  public List<DocumentVersion> getDocumentVersions()
  {
    List<DocumentVersion> newDocumentVersions = Collections.unmodifiableList(documentVersions);
    return newDocumentVersions;
  }

  public int numberOfDocumentVersions()
  {
    int number = documentVersions.size();
    return number;
  }

  public boolean hasDocumentVersions()
  {
    boolean has = documentVersions.size() > 0;
    return has;
  }

  public int indexOfDocumentVersion(DocumentVersion aDocumentVersion)
  {
    int index = documentVersions.indexOf(aDocumentVersion);
    return index;
  }

  public boolean setOrganization(Organization aOrganization)
  {
    boolean wasSet = false;
    if (aOrganization == null)
    {
      return wasSet;
    }

    Organization existingOrganization = organization;
    organization = aOrganization;
    if (existingOrganization != null && !existingOrganization.equals(aOrganization))
    {
      existingOrganization.removeUser(this);
    }
    organization.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfMemberships()
  {
    return 0;
  }

  public Membership addMembership(Date aStartDate, Date aEndDate, DecisionMakingBody aDecisionMakingBody)
  {
    return new Membership(aStartDate, aEndDate, this, aDecisionMakingBody);
  }

  public boolean addMembership(Membership aMembership)
  {
    boolean wasAdded = false;
    if (memberships.contains(aMembership)) { return false; }
    Person existingPerson = aMembership.getPerson();
    boolean isNewPerson = existingPerson != null && !this.equals(existingPerson);
    if (isNewPerson)
    {
      aMembership.setPerson(this);
    }
    else
    {
      memberships.add(aMembership);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMembership(Membership aMembership)
  {
    boolean wasRemoved = false;
    //Unable to remove aMembership, as it must always have a person
    if (!this.equals(aMembership.getPerson()))
    {
      memberships.remove(aMembership);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMembershipAt(Membership aMembership, int index)
  {  
    boolean wasAdded = false;
    if(addMembership(aMembership))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMemberships()) { index = numberOfMemberships() - 1; }
      memberships.remove(aMembership);
      memberships.add(index, aMembership);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMembershipAt(Membership aMembership, int index)
  {
    boolean wasAdded = false;
    if(memberships.contains(aMembership))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMemberships()) { index = numberOfMemberships() - 1; }
      memberships.remove(aMembership);
      memberships.add(index, aMembership);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMembershipAt(aMembership, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDocumentVersions()
  {
    return 0;
  }

  public boolean addDocumentVersion(DocumentVersion aDocumentVersion)
  {
    boolean wasAdded = false;
    if (documentVersions.contains(aDocumentVersion)) { return false; }
    documentVersions.add(aDocumentVersion);
    if (aDocumentVersion.indexOfAuthor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDocumentVersion.addAuthor(this);
      if (!wasAdded)
      {
        documentVersions.remove(aDocumentVersion);
      }
    }
    return wasAdded;
  }

  public boolean removeDocumentVersion(DocumentVersion aDocumentVersion)
  {
    boolean wasRemoved = false;
    if (!documentVersions.contains(aDocumentVersion))
    {
      return wasRemoved;
    }

    int oldIndex = documentVersions.indexOf(aDocumentVersion);
    documentVersions.remove(oldIndex);
    if (aDocumentVersion.indexOfAuthor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDocumentVersion.removeAuthor(this);
      if (!wasRemoved)
      {
        documentVersions.add(oldIndex,aDocumentVersion);
      }
    }
    return wasRemoved;
  }

  public boolean addDocumentVersionAt(DocumentVersion aDocumentVersion, int index)
  {  
    boolean wasAdded = false;
    if(addDocumentVersion(aDocumentVersion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDocumentVersions()) { index = numberOfDocumentVersions() - 1; }
      documentVersions.remove(aDocumentVersion);
      documentVersions.add(index, aDocumentVersion);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDocumentVersionAt(DocumentVersion aDocumentVersion, int index)
  {
    boolean wasAdded = false;
    if(documentVersions.contains(aDocumentVersion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDocumentVersions()) { index = numberOfDocumentVersions() - 1; }
      documentVersions.remove(aDocumentVersion);
      documentVersions.add(index, aDocumentVersion);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDocumentVersionAt(aDocumentVersion, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Organization placeholderOrganization = organization;
    this.organization = null;
    placeholderOrganization.removeUser(this);
    for(int i=memberships.size(); i > 0; i--)
    {
      Membership aMembership = memberships.get(i - 1);
      aMembership.delete();
    }
    ArrayList<DocumentVersion> copyOfDocumentVersions = new ArrayList<DocumentVersion>(documentVersions);
    documentVersions.clear();
    for(DocumentVersion aDocumentVersion : copyOfDocumentVersions)
    {
      aDocumentVersion.removeAuthor(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "organization = "+(getOrganization()!=null?Integer.toHexString(System.identityHashCode(getOrganization())):"null")
     + outputString;
  }
}